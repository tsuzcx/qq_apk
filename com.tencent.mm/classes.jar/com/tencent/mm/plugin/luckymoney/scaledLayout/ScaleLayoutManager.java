package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  public float aXu;
  private int hbd;
  private float yYh;
  private float yYi;
  private float yYj;
  
  public ScaleLayoutManager(Context paramContext)
  {
    this(new a(paramContext, 0));
    AppMethodBeat.i(65335);
    AppMethodBeat.o(65335);
  }
  
  private ScaleLayoutManager(Context paramContext, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(213334);
    assertNotInLayoutOrScroll(null);
    if (this.yYC != paramInt4)
    {
      this.yYC = paramInt4;
      removeAllViews();
    }
    assertNotInLayoutOrScroll(null);
    if (this.yYA != paramInt3)
    {
      this.yYA = paramInt3;
      removeAllViews();
    }
    this.hbd = paramInt1;
    this.aXu = paramFloat1;
    this.yYh = paramFloat4;
    this.yYi = paramFloat2;
    this.yYj = paramFloat3;
    AppMethodBeat.o(213334);
  }
  
  private ScaleLayoutManager(a parama)
  {
    this(a.a(parama), a.b(parama), a.c(parama), a.d(parama), a.e(parama), a.f(parama), a.g(parama), a.h(parama), a.i(parama), a.j(parama));
    AppMethodBeat.i(65336);
    AppMethodBeat.o(65336);
  }
  
  protected final float efn()
  {
    return this.hbd + this.yYp;
  }
  
  protected final float efo()
  {
    if (this.yYh == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.yYh;
  }
  
  protected final void v(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.yYr + paramFloat - this.yYr);
    float f1 = f2;
    if (f2 - this.yYp > 0.0F) {
      f1 = this.yYp;
    }
    f1 = 1.0F - f1 / this.yYp * (1.0F - this.aXu);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.yYj - this.yYi) / this.yYw * f1 + this.yYi;
    if (f1 >= this.yYw) {
      paramFloat = this.yYj;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float yYk = 1.0F;
    private static float yYl = 1.0F;
    private float aXu;
    private boolean atu;
    private Context context;
    private int hbd = 0;
    private int orientation;
    private float yYh;
    private float yYi;
    private float yYj;
    private int yYm;
    private int yYn;
    
    public a(Context paramContext, int paramInt)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.aXu = 0.8F;
      this.yYh = 1.0F;
      this.yYi = yYl;
      this.yYj = yYk;
      this.atu = false;
      this.yYn = 2147483647;
      this.yYm = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */