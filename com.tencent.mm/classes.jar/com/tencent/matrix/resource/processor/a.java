package com.tencent.matrix.resource.processor;

import com.tencent.matrix.e.c;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.c.a.a;
import java.io.File;

public final class a
  extends b
{
  public a(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    File localFile = azs().dK(true);
    if (localFile != null)
    {
      azu().m(paramDestroyedActivityInfo.mActivityName, true);
      azu();
      com.tencent.matrix.resource.f.b.azx();
      paramDestroyedActivityInfo = new com.tencent.matrix.resource.analyzer.model.f(localFile, paramDestroyedActivityInfo.mKey, paramDestroyedActivityInfo.mActivityName);
      azt().a(paramDestroyedActivityInfo);
      return true;
    }
    c.i("Matrix.LeakProcessor.AutoDump", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { paramDestroyedActivityInfo.mKey });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.a
 * JD-Core Version:    0.7.0.1
 */