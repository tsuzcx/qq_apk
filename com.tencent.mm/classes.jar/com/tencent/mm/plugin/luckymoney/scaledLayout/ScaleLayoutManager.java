package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  public float aNl;
  private int fUm;
  private float uow;
  private float uox;
  private float uoy;
  
  private ScaleLayoutManager(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(65337);
    G(null);
    if (this.uoR != paramInt4)
    {
      this.uoR = paramInt4;
      removeAllViews();
    }
    G(null);
    if (this.uoP != paramInt3)
    {
      this.uoP = paramInt3;
      removeAllViews();
    }
    this.fUm = paramInt1;
    this.aNl = paramFloat1;
    this.uow = paramFloat4;
    this.uox = paramFloat2;
    this.uoy = paramFloat3;
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
  
  protected final float cZh()
  {
    return this.fUm + this.uoE;
  }
  
  protected final float cZi()
  {
    if (this.uow == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.uow;
  }
  
  protected final void q(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.uoG + paramFloat - this.uoG);
    float f1 = f2;
    if (f2 - this.uoE > 0.0F) {
      f1 = this.uoE;
    }
    f1 = 1.0F - f1 / this.uoE * (1.0F - this.aNl);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.uoy - this.uox) / this.uoL * f1 + this.uox;
    if (f1 >= this.uoL) {
      paramFloat = this.uoy;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float uoA = 1.0F;
    private static float uoz = 1.0F;
    private float aNl;
    private boolean arF;
    private Context context;
    private int fUm = 0;
    private int orientation;
    private int uoB;
    private int uoC;
    private float uow;
    private float uox;
    private float uoy;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.aNl = 0.8F;
      this.uow = 1.0F;
      this.uox = uoA;
      this.uoy = uoz;
      this.arF = false;
      this.uoC = 2147483647;
      this.uoB = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */