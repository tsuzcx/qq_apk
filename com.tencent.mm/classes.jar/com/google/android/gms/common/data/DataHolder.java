package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@KeepName
public final class DataHolder
  extends zza
  implements Closeable
{
  public static final Parcelable.Creator<DataHolder> CREATOR = new zze();
  private static final DataHolder.zza zzaDW = new DataHolder.1(new String[0], null);
  boolean mClosed = false;
  private final String[] zzaDP;
  Bundle zzaDQ;
  private final CursorWindow[] zzaDR;
  private final Bundle zzaDS;
  int[] zzaDT;
  int zzaDU;
  private boolean zzaDV = true;
  final int zzaiI;
  private final int zzavD;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.zzaiI = paramInt1;
    this.zzaDP = paramArrayOfString;
    this.zzaDR = paramArrayOfCursorWindow;
    this.zzavD = paramInt2;
    this.zzaDS = paramBundle;
  }
  
  private DataHolder(DataHolder.zza paramzza, int paramInt, Bundle paramBundle)
  {
    this(DataHolder.zza.zza(paramzza), zza(paramzza, -1), paramInt, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.zzaiI = 1;
    this.zzaDP = ((String[])zzac.zzw(paramArrayOfString));
    this.zzaDR = ((CursorWindow[])zzac.zzw(paramArrayOfCursorWindow));
    this.zzavD = paramInt;
    this.zzaDS = paramBundle;
    zzxk();
  }
  
  public static DataHolder zza(int paramInt, Bundle paramBundle)
  {
    return new DataHolder(zzaDW, paramInt, paramBundle);
  }
  
  private static CursorWindow[] zza(DataHolder.zza paramzza, int paramInt)
  {
    int k = 0;
    if (DataHolder.zza.zza(paramzza).length == 0) {
      return new CursorWindow[0];
    }
    Object localObject3;
    Object localObject2;
    ArrayList localArrayList;
    int i;
    label88:
    Object localObject1;
    if ((paramInt < 0) || (paramInt >= DataHolder.zza.zzb(paramzza).size()))
    {
      localObject3 = DataHolder.zza.zzb(paramzza);
      int m = ((List)localObject3).size();
      localObject2 = new CursorWindow(false);
      localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((CursorWindow)localObject2).setNumColumns(DataHolder.zza.zza(paramzza).length);
      paramInt = 0;
      i = 0;
      if (paramInt >= m) {
        break label697;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      int j;
      try
      {
        if (!((CursorWindow)localObject2).allocRow())
        {
          new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(paramInt).append(")");
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(paramInt);
          ((CursorWindow)localObject2).setNumColumns(DataHolder.zza.zza(paramzza).length);
          localArrayList.add(localObject2);
          localObject1 = localObject2;
          if (!((CursorWindow)localObject2).allocRow())
          {
            localArrayList.remove(localObject2);
            paramzza = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
            return paramzza;
            localObject3 = DataHolder.zza.zzb(paramzza).subList(0, paramInt);
            break;
          }
        }
        Map localMap = (Map)((List)localObject3).get(paramInt);
        j = 0;
        bool = true;
        if ((j < DataHolder.zza.zza(paramzza).length) && (bool))
        {
          localObject2 = DataHolder.zza.zza(paramzza)[j];
          Object localObject4 = localMap.get(localObject2);
          if (localObject4 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject4, paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof Long))
          {
            bool = ((CursorWindow)localObject1).putLong(((Long)localObject4).longValue(), paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof Integer))
          {
            bool = ((CursorWindow)localObject1).putLong(((Integer)localObject4).intValue(), paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof Boolean))
          {
            if (!((Boolean)localObject4).booleanValue()) {
              break label721;
            }
            l = 1L;
            bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject1).putBlob((byte[])localObject4, paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof Double))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Double)localObject4).doubleValue(), paramInt, j);
            break label714;
          }
          if ((localObject4 instanceof Float))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Float)localObject4).floatValue(), paramInt, j);
            break label714;
          }
          paramzza = String.valueOf(localObject4);
          throw new IllegalArgumentException(String.valueOf(localObject2).length() + 32 + String.valueOf(paramzza).length() + "Unsupported object for column " + (String)localObject2 + ": " + paramzza);
        }
      }
      catch (RuntimeException paramzza)
      {
        boolean bool;
        i = localArrayList.size();
        paramInt = k;
        if (paramInt < i)
        {
          ((CursorWindow)localArrayList.get(paramInt)).close();
          paramInt += 1;
          continue;
          if (!bool)
          {
            if (i != 0) {
              throw new DataHolder.zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            }
            new StringBuilder(74).append("Couldn't populate window data for row ").append(paramInt).append(" - allocating new window.");
            ((CursorWindow)localObject1).freeLastRow();
            localObject1 = new CursorWindow(false);
            ((CursorWindow)localObject1).setStartPosition(paramInt);
            ((CursorWindow)localObject1).setNumColumns(DataHolder.zza.zza(paramzza).length);
            localArrayList.add(localObject1);
            i = paramInt - 1;
            paramInt = 1;
            j = i + 1;
            i = paramInt;
            paramInt = j;
            localObject2 = localObject1;
            break label88;
          }
          j = 0;
          i = paramInt;
          paramInt = j;
          continue;
        }
        throw paramzza;
      }
      label697:
      return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      label714:
      j += 1;
      continue;
      label721:
      long l = 0L;
    }
  }
  
  public static DataHolder.zza zzc(String[] paramArrayOfString)
  {
    return new DataHolder.zza(paramArrayOfString, null, null);
  }
  
  public static DataHolder zzcJ(int paramInt)
  {
    return zza(paramInt, null);
  }
  
  private void zzi(String paramString, int paramInt)
  {
    if ((this.zzaDQ == null) || (!this.zzaDQ.containsKey(paramString)))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "No such column: ".concat(paramString);; paramString = new String("No such column: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    if (isClosed()) {
      throw new IllegalArgumentException("Buffer is closed.");
    }
    if ((paramInt < 0) || (paramInt >= this.zzaDU)) {
      throw new CursorIndexOutOfBoundsException(paramInt, this.zzaDU);
    }
  }
  
  public final void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        int i = 0;
        while (i < this.zzaDR.length)
        {
          this.zzaDR[i].close();
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  protected final void finalize()
  {
    try
    {
      if ((this.zzaDV) && (this.zzaDR.length > 0) && (!isClosed()))
      {
        close();
        String str = String.valueOf(toString());
        new StringBuilder(String.valueOf(str).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(str).append(")");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getCount()
  {
    return this.zzaDU;
  }
  
  public final int getStatusCode()
  {
    return this.zzavD;
  }
  
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally {}
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public final void zza(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    zzi(paramString, paramInt1);
    this.zzaDR[paramInt2].copyStringToBuffer(paramInt1, this.zzaDQ.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final long zzb(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].getLong(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final int zzc(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].getInt(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final int zzcI(int paramInt)
  {
    int j = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.zzaDU))
    {
      bool = true;
      zzac.zzaw(bool);
    }
    for (;;)
    {
      int i = j;
      if (j < this.zzaDT.length)
      {
        if (paramInt < this.zzaDT[j]) {
          i = j - 1;
        }
      }
      else
      {
        paramInt = i;
        if (i == this.zzaDT.length) {
          paramInt = i - 1;
        }
        return paramInt;
        bool = false;
        break;
      }
      j += 1;
    }
  }
  
  public final String zzd(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].getString(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final boolean zzdf(String paramString)
  {
    return this.zzaDQ.containsKey(paramString);
  }
  
  public final boolean zze(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return Long.valueOf(this.zzaDR[paramInt2].getLong(paramInt1, this.zzaDQ.getInt(paramString))).longValue() == 1L;
  }
  
  public final float zzf(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].getFloat(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final byte[] zzg(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].getBlob(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final Uri zzh(String paramString, int paramInt1, int paramInt2)
  {
    paramString = zzd(paramString, paramInt1, paramInt2);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  public final boolean zzi(String paramString, int paramInt1, int paramInt2)
  {
    zzi(paramString, paramInt1);
    return this.zzaDR[paramInt2].isNull(paramInt1, this.zzaDQ.getInt(paramString));
  }
  
  public final Bundle zzxf()
  {
    return this.zzaDS;
  }
  
  public final void zzxk()
  {
    this.zzaDQ = new Bundle();
    int i = 0;
    while (i < this.zzaDP.length)
    {
      this.zzaDQ.putInt(this.zzaDP[i], i);
      i += 1;
    }
    this.zzaDT = new int[this.zzaDR.length];
    i = 0;
    int j = 0;
    while (i < this.zzaDR.length)
    {
      this.zzaDT[i] = j;
      int k = this.zzaDR[i].getStartPosition();
      j += this.zzaDR[i].getNumRows() - (j - k);
      i += 1;
    }
    this.zzaDU = j;
  }
  
  final String[] zzxl()
  {
    return this.zzaDP;
  }
  
  final CursorWindow[] zzxm()
  {
    return this.zzaDR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.7.0.1
 */