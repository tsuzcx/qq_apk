package com.tencent.matrix.resource.processor;

import android.os.Build.VERSION;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;
import java.io.File;

public final class c
  extends b
{
  public c(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
  }
  
  private boolean V(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    localFile = azr().azo();
    if ((localFile != null) && (!com.tencent.matrix.memorydump.a.gQ(localFile.getPath())))
    {
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.ForkAnalyse", String.format("heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { paramString2 }), new Object[0]);
      return false;
    }
    if ((localFile == null) || (localFile.length() == 0L))
    {
      a(2, a.b.fbo, paramString1, paramString2, "FileNull", "0");
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.ForkAnalyse", "cannot create hprof file", new Object[0]);
      return false;
    }
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ForkAnalyse", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), paramString2, localFile.getPath() }), new Object[0]);
    for (;;)
    {
      try
      {
        long l2 = System.currentTimeMillis();
        Object localObject = g(localFile, paramString2);
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ForkAnalyse", String.format("analyze cost=%sms refString=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), paramString2 }), new Object[0]);
        if (!((com.tencent.matrix.resource.analyzer.model.a)localObject).eZt) {
          continue;
        }
        localObject = ((com.tencent.matrix.resource.analyzer.model.a)localObject).toString();
        a(0, a.b.fbo, paramString1, paramString2, (String)localObject, String.valueOf(System.currentTimeMillis() - l1));
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ForkAnalyse", (String)localObject, new Object[0]);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        a(3, a.b.fbo, paramString1, paramString2, "OutOfMemoryError", "0");
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.LeakProcessor.ForkAnalyse", localOutOfMemoryError.getCause(), "", new Object[0]);
        localFile.delete();
        continue;
      }
      finally
      {
        localFile.delete();
      }
      return true;
      com.tencent.matrix.e.c.i("Matrix.LeakProcessor.ForkAnalyse", "leak not found", new Object[0]);
    }
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    if (Build.VERSION.SDK_INT > 31)
    {
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.ForkAnalyse", "cannot fork-dump with unsupported API version " + Build.VERSION.SDK_INT, new Object[0]);
      a(4, a.b.fbo, paramDestroyedActivityInfo.mActivityName, paramDestroyedActivityInfo.mKey, "Unsupported API", "0");
      return false;
    }
    azu();
    com.tencent.matrix.resource.f.b.azx();
    if (V(paramDestroyedActivityInfo.mActivityName, paramDestroyedActivityInfo.mKey))
    {
      azu().m(paramDestroyedActivityInfo.mActivityName, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.c
 * JD-Core Version:    0.7.0.1
 */