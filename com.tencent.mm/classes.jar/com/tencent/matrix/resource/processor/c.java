package com.tencent.matrix.resource.processor;

import com.tencent.matrix.report.e;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;

public final class c
  extends b
{
  public c(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.NoDump", "lightweight mode, just report leaked activity name.", new Object[0]);
    this.daQ.m(paramDestroyedActivityInfo.mActivityName, true);
    com.tencent.matrix.resource.f.b.XT();
    a(0, a.b.dcI, paramDestroyedActivityInfo.mActivityName, paramDestroyedActivityInfo.mKey, "no dump", "0");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.c
 * JD-Core Version:    0.7.0.1
 */