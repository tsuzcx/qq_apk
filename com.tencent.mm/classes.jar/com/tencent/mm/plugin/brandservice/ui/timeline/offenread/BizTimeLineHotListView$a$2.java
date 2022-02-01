package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineHotListView$a$2
  extends ShapeDrawable.ShaderFactory
{
  BizTimeLineHotListView$a$2(BizTimeLineHotListView.a parama, int paramInt) {}
  
  public final Shader resize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302239);
    float f1 = paramInt1 / 2;
    float f2 = paramInt1 / 2;
    float f3 = paramInt2;
    paramInt1 = this.vPd;
    paramInt2 = this.vPd;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(f1, 0.0F, f2, f3, new int[] { 0, paramInt1, paramInt2 }, new float[] { 0.0F, 0.58F, 1.0F }, (Shader.TileMode)localObject);
    AppMethodBeat.o(302239);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.a.2
 * JD-Core Version:    0.7.0.1
 */