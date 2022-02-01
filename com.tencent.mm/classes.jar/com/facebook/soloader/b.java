package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.zip.ZipEntry;

public final class b
  extends i
{
  final int cN = 1;
  
  public b(Context paramContext, File paramFile, String paramString)
  {
    super(paramContext, paramString, paramFile, "^lib/([^/]+)/([^/]+\\.so)$");
  }
  
  protected final q.f PO()
  {
    AppMethodBeat.i(208062);
    a locala = new a(this);
    AppMethodBeat.o(208062);
    return locala;
  }
  
  protected final byte[] PP()
  {
    AppMethodBeat.i(208067);
    Object localObject1 = this.cCG.getCanonicalFile();
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeByte((byte)2);
      localParcel.writeString(((File)localObject1).getPath());
      localParcel.writeLong(((File)localObject1).lastModified());
      localParcel.writeInt(SysUtil.getAppVersionCode(this.mContext));
      if ((this.cN & 0x1) == 0)
      {
        localParcel.writeByte((byte)0);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localObject1 = this.mContext.getApplicationInfo().nativeLibraryDir;
      if (localObject1 == null)
      {
        localParcel.writeByte((byte)1);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localObject1 = new File((String)localObject1).getCanonicalFile();
      if (!((File)localObject1).exists())
      {
        localParcel.writeByte((byte)1);
        localObject1 = localParcel.marshall();
        return localObject1;
      }
      localParcel.writeByte((byte)2);
      localParcel.writeString(((File)localObject1).getPath());
      localParcel.writeLong(((File)localObject1).lastModified());
      localObject1 = localParcel.marshall();
      return localObject1;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(208067);
    }
  }
  
  protected final class a
    extends i.b
  {
    private File cCr;
    private final int cN;
    
    a(i parami)
    {
      super(parami);
      AppMethodBeat.i(208110);
      this.cCr = new File(b.this.mContext.getApplicationInfo().nativeLibraryDir);
      this.cN = b.this.cN;
      AppMethodBeat.o(208110);
    }
    
    protected final boolean a(ZipEntry paramZipEntry, String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(208121);
      String str = paramZipEntry.getName();
      if (paramString.equals(b.this.cDq))
      {
        b.this.cDq = null;
        String.format("allowing consideration of corrupted lib %s", new Object[] { paramString });
      }
      for (;;)
      {
        AppMethodBeat.o(208121);
        return bool;
        if ((this.cN & 0x1) == 0)
        {
          new StringBuilder("allowing consideration of ").append(str).append(": self-extraction preferred");
        }
        else
        {
          File localFile = new File(this.cCr, paramString);
          if (!localFile.isFile())
          {
            String.format("allowing considering of %s: %s not in system lib dir", new Object[] { str, paramString });
          }
          else
          {
            long l1 = localFile.length();
            long l2 = paramZipEntry.getSize();
            if (l1 != l2)
            {
              String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", new Object[] { localFile, Long.valueOf(l1), Long.valueOf(l2) });
            }
            else
            {
              new StringBuilder("not allowing consideration of ").append(str).append(": deferring to libdir");
              bool = false;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.b
 * JD-Core Version:    0.7.0.1
 */