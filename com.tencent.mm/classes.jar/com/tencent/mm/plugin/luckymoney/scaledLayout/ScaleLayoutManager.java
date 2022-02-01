package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  public float aXF;
  private int gqk;
  private float vDf;
  private float vDg;
  private float vDh;
  
  private ScaleLayoutManager(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(65337);
    F(null);
    if (this.vDA != paramInt4)
    {
      this.vDA = paramInt4;
      removeAllViews();
    }
    F(null);
    if (this.vDy != paramInt3)
    {
      this.vDy = paramInt3;
      removeAllViews();
    }
    this.gqk = paramInt1;
    this.aXF = paramFloat1;
    this.vDf = paramFloat4;
    this.vDg = paramFloat2;
    this.vDh = paramFloat3;
    AppMethodBeat.o(65337);
  }
  
  public ScaleLayoutManager(Context paramContext)
  {
    this(new a(paramContext));
    AppMethodBeat.i(65335);
    AppMethodBeat.o(65335);
  }
  
  private ScaleLayoutManager(a parama)
  {
    this(a.b(parama), a.c(parama), a.d(parama), a.e(parama), a.f(parama), a.g(parama), a.h(parama), a.i(parama), a.j(parama));
    AppMethodBeat.i(65336);
    AppMethodBeat.o(65336);
  }
  
  protected final float dls()
  {
    return this.gqk + this.vDn;
  }
  
  protected final float dlt()
  {
    if (this.vDf == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.vDf;
  }
  
  protected final void q(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.vDp + paramFloat - this.vDp);
    float f1 = f2;
    if (f2 - this.vDn > 0.0F) {
      f1 = this.vDn;
    }
    f1 = 1.0F - f1 / this.vDn * (1.0F - this.aXF);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.vDh - this.vDg) / this.vDu * f1 + this.vDg;
    if (f1 >= this.vDu) {
      paramFloat = this.vDh;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float vDi = 1.0F;
    private static float vDj = 1.0F;
    private float aXF;
    private boolean atw;
    private Context context;
    private int gqk = 0;
    private int orientation;
    private float vDf;
    private float vDg;
    private float vDh;
    private int vDk;
    private int vDl;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.aXF = 0.8F;
      this.vDf = 1.0F;
      this.vDg = vDj;
      this.vDh = vDi;
      this.atw = false;
      this.vDl = 2147483647;
      this.vDk = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */