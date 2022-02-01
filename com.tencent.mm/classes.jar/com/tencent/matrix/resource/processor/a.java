package com.tencent.matrix.resource.processor;

import com.tencent.matrix.e.c;
import com.tencent.matrix.report.e;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.analyzer.model.f;
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
    File localFile = XL().db(true);
    if (localFile != null)
    {
      this.daQ.m(paramDestroyedActivityInfo.mActivityName, true);
      com.tencent.matrix.resource.f.b.XT();
      paramDestroyedActivityInfo = new f(localFile, paramDestroyedActivityInfo.mKey, paramDestroyedActivityInfo.mActivityName);
      XM().a(paramDestroyedActivityInfo);
      return true;
    }
    c.i("Matrix.LeakProcessor.AutoDump", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { paramDestroyedActivityInfo.mKey });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.a
 * JD-Core Version:    0.7.0.1
 */