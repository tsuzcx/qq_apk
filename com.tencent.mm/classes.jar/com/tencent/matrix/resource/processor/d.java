package com.tencent.matrix.resource.processor;

import android.os.Build.VERSION;
import com.tencent.matrix.e.c;
import com.tencent.matrix.memorydump.a;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.c.a.a;
import java.io.File;

public final class d
  extends b
{
  public d(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    if (Build.VERSION.SDK_INT > 31)
    {
      c.e("Matrix.LeakProcessor.ForkDump", "unsupported API version " + Build.VERSION.SDK_INT, new Object[0]);
      return false;
    }
    long l = System.currentTimeMillis();
    File localFile = azr().azo();
    if (localFile == null)
    {
      c.e("Matrix.LeakProcessor.ForkDump", "cannot create hprof file, just ignore", new Object[0]);
      return true;
    }
    if (!a.gQ(localFile.getPath()))
    {
      c.e("Matrix.LeakProcessor.ForkDump", String.format("heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { paramDestroyedActivityInfo.mKey }), new Object[0]);
      return true;
    }
    c.i("Matrix.LeakProcessor.ForkDump", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramDestroyedActivityInfo.mKey, localFile.getPath() }), new Object[0]);
    azu().m(paramDestroyedActivityInfo.mActivityName, true);
    azu();
    com.tencent.matrix.resource.f.b.azx();
    azt().a(new com.tencent.matrix.resource.analyzer.model.f(localFile, paramDestroyedActivityInfo.mKey, paramDestroyedActivityInfo.mActivityName));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.d
 * JD-Core Version:    0.7.0.1
 */