package com.tencent.matrix.resource.processor;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.e.c;
import com.tencent.matrix.report.f;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class ManualDumpProcessor
  extends b
{
  private final NotificationManager bpy;
  private final String fbf;
  private final List<DestroyedActivityInfo> fcB = new ArrayList();
  public boolean fcC;
  
  public ManualDumpProcessor(com.tencent.matrix.resource.f.b paramb, String paramString)
  {
    super(paramb);
    this.fbf = paramString;
    this.bpy = ((NotificationManager)paramb.mContext.getSystemService("notification"));
  }
  
  private ManualDumpData X(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    azu();
    com.tencent.matrix.resource.f.b.azx();
    Object localObject = azr().azo();
    if (localObject != null) {
      com.tencent.matrix.memorydump.a.gQ(((File)localObject).getPath());
    }
    if ((localObject == null) || (((File)localObject).length() <= 0L))
    {
      a(2, a.b.fbl, paramString1, paramString2, "FileNull", "0");
      c.e("Matrix.LeakProcessor.ManualDump", "file is null!", new Object[0]);
      return null;
    }
    c.i("Matrix.LeakProcessor.ManualDump", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), paramString2, ((File)localObject).getAbsolutePath() }), new Object[0]);
    long l2 = System.currentTimeMillis();
    try
    {
      com.tencent.matrix.resource.analyzer.model.a locala = g((File)localObject, paramString2);
      c.i("Matrix.LeakProcessor.ManualDump", String.format("analyze cost=%sms refString=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), paramString2 }), new Object[0]);
      String str = locala.toString();
      if (locala.eZt)
      {
        c.i("Matrix.LeakProcessor.ManualDump", "leakFound,refcChain = %s", new Object[] { str });
        a(0, a.b.fbl, paramString1, paramString2, str, String.valueOf(System.currentTimeMillis() - l1));
        localObject = new ManualDumpData(((File)localObject).getAbsolutePath(), str);
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a(3, a.b.fbl, paramString1, paramString2, "OutOfMemoryError", "0");
      c.printErrStackTrace("Matrix.LeakProcessor.ManualDump", localOutOfMemoryError.getCause(), "", new Object[0]);
      return null;
    }
    c.i("Matrix.LeakProcessor.ManualDump", "leak not found", new Object[0]);
    ManualDumpData localManualDumpData = new ManualDumpData(localOutOfMemoryError.getAbsolutePath(), null);
    return localManualDumpData;
  }
  
  public final boolean a(final DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    azu();
    com.tencent.matrix.resource.f.b.azx();
    if (paramDestroyedActivityInfo.mActivityRef.get() == null)
    {
      c.v("Matrix.LeakProcessor.ManualDump", "activity with key [%s] was already recycled.", new Object[] { paramDestroyedActivityInfo.mKey });
      return true;
    }
    this.fcB.add(paramDestroyedActivityInfo);
    c.i("Matrix.LeakProcessor.ManualDump", "show notification for activity leak. %s", new Object[] { paramDestroyedActivityInfo.mActivityName });
    if (this.fcC)
    {
      c.i("Matrix.LeakProcessor.ManualDump", "is muted, won't show notification util process reboot", new Object[0]);
      return true;
    }
    final String str1 = paramDestroyedActivityInfo.mActivityName;
    final String str2 = paramDestroyedActivityInfo.mKey;
    paramDestroyedActivityInfo = new a()
    {
      public final void a(ManualDumpProcessor.ManualDumpData paramAnonymousManualDumpData)
      {
        if (paramAnonymousManualDumpData != null)
        {
          if (!ManualDumpProcessor.a(ManualDumpProcessor.this))
          {
            c.i("Matrix.LeakProcessor.ManualDump", "shown notification!!!3", new Object[0]);
            ManualDumpProcessor.a(ManualDumpProcessor.this, paramDestroyedActivityInfo, paramAnonymousManualDumpData);
          }
        }
        else {
          return;
        }
        c.i("Matrix.LeakProcessor.ManualDump", "mute mode, notification will not be shown.", new Object[0]);
      }
    };
    com.tencent.matrix.e.b.aAp().postAtFrontOfQueue(new Runnable()
    {
      public final void run()
      {
        paramDestroyedActivityInfo.a(ManualDumpProcessor.a(ManualDumpProcessor.this, str1, str2));
      }
    });
    return true;
  }
  
  public static class ManualDumpData
    implements Parcelable
  {
    public static final Parcelable.Creator<ManualDumpData> CREATOR = new Parcelable.Creator() {};
    public final String fcI;
    public final String fcJ;
    
    protected ManualDumpData(Parcel paramParcel)
    {
      this.fcI = paramParcel.readString();
      this.fcJ = paramParcel.readString();
    }
    
    public ManualDumpData(String paramString1, String paramString2)
    {
      this.fcI = paramString1;
      this.fcJ = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.fcI);
      paramParcel.writeString(this.fcJ);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(ManualDumpProcessor.ManualDumpData paramManualDumpData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.ManualDumpProcessor
 * JD-Core Version:    0.7.0.1
 */