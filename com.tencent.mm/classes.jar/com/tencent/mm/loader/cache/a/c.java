package com.tencent.mm.loader.cache.a;

import android.system.ErrnoException;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "save", "data", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG = "MicroMsg.Loader.DiskFunction";
  public static final c npb = new c();
  
  public static OutputStream GF(String paramString)
  {
    s.u(paramString, "filePath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    try
    {
      u localu = new u(paramString).jKP();
      if (localu != null) {
        localu.jKY();
      }
      paramString = y.ev(paramString, false);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(TAG, "obtainOutputStream:%s", new Object[] { paramString });
        paramString = null;
      }
    }
    return paramString;
  }
  
  public static boolean a(String paramString, OutputStream paramOutputStream)
  {
    s.u(paramString, "filePath");
    s.u(paramOutputStream, "stream");
    Object localObject1;
    if (y.ZC(paramString)) {
      try
      {
        localObject1 = y.Lh(paramString);
        if (localObject1 != null)
        {
          localObject1 = (Closeable)localObject1;
          try
          {
            InputStream localInputStream = (InputStream)localObject1;
            byte[] arrayOfByte = new byte[4096];
            for (;;)
            {
              int i = localInputStream.read(arrayOfByte);
              if (i == -1) {
                break;
              }
              paramOutputStream.write(arrayOfByte, 0, i);
            }
            paramOutputStream = finally;
          }
          finally
          {
            try
            {
              throw paramOutputStream;
            }
            finally
            {
              b.a((Closeable)localObject1, paramOutputStream);
            }
          }
        }
        return false;
      }
      finally
      {
        f.Ozc.idkeyStat(1299L, 12L, 1L, false);
        Log.printErrStackTrace(TAG, paramOutputStream, s.X("save failed. path:", paramString), new Object[0]);
      }
    }
    b.a((Closeable)localObject1, null);
    return true;
  }
  
  public static boolean b(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    s.u(paramArrayOfByte, "data");
    s.u(paramOutputStream, "stream");
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return true;
    }
    catch (ErrnoException paramArrayOfByte)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramArrayOfByte, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.a.c
 * JD-Core Version:    0.7.0.1
 */