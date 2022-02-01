package com.tencent.matrix.resource.processor;

import com.tencent.matrix.e.c;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;

public final class f
  extends b
{
  public f(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    c.i("Matrix.LeakProcessor.NoDump", "lightweight mode, just report leaked activity name.", new Object[0]);
    azu().m(paramDestroyedActivityInfo.mActivityName, true);
    azu();
    com.tencent.matrix.resource.f.b.azx();
    a(0, a.b.fbj, paramDestroyedActivityInfo.mActivityName, paramDestroyedActivityInfo.mKey, "no dump", "0");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.f
 * JD-Core Version:    0.7.0.1
 */