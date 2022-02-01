package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  public float aXF;
  private int gnO;
  private float vra;
  private float vrb;
  private float vrc;
  
  private ScaleLayoutManager(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(65337);
    F(null);
    if (this.vrv != paramInt4)
    {
      this.vrv = paramInt4;
      removeAllViews();
    }
    F(null);
    if (this.vrt != paramInt3)
    {
      this.vrt = paramInt3;
      removeAllViews();
    }
    this.gnO = paramInt1;
    this.aXF = paramFloat1;
    this.vra = paramFloat4;
    this.vrb = paramFloat2;
    this.vrc = paramFloat3;
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
  
  protected final float dit()
  {
    return this.gnO + this.vri;
  }
  
  protected final float diu()
  {
    if (this.vra == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.vra;
  }
  
  protected final void q(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.vrk + paramFloat - this.vrk);
    float f1 = f2;
    if (f2 - this.vri > 0.0F) {
      f1 = this.vri;
    }
    f1 = 1.0F - f1 / this.vri * (1.0F - this.aXF);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.vrc - this.vrb) / this.vrp * f1 + this.vrb;
    if (f1 >= this.vrp) {
      paramFloat = this.vrc;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float vrd = 1.0F;
    private static float vre = 1.0F;
    private float aXF;
    private boolean atw;
    private Context context;
    private int gnO = 0;
    private int orientation;
    private float vra;
    private float vrb;
    private float vrc;
    private int vrf;
    private int vrg;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.aXF = 0.8F;
      this.vra = 1.0F;
      this.vrb = vre;
      this.vrc = vrd;
      this.atw = false;
      this.vrg = 2147483647;
      this.vrf = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */