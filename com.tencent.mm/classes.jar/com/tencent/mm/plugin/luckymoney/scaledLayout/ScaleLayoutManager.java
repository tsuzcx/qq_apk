package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  public float aMv;
  private int fQr;
  private float tgh;
  private float tgi;
  private float tgj;
  
  private ScaleLayoutManager(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(65337);
    E(null);
    if (this.tgC != paramInt4)
    {
      this.tgC = paramInt4;
      removeAllViews();
    }
    E(null);
    if (this.tgA != paramInt3)
    {
      this.tgA = paramInt3;
      removeAllViews();
    }
    this.fQr = paramInt1;
    this.aMv = paramFloat1;
    this.tgh = paramFloat4;
    this.tgi = paramFloat2;
    this.tgj = paramFloat3;
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
  
  protected final float cLB()
  {
    return this.fQr + this.tgp;
  }
  
  protected final float cLC()
  {
    if (this.tgh == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.tgh;
  }
  
  protected final void p(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.tgr + paramFloat - this.tgr);
    float f1 = f2;
    if (f2 - this.tgp > 0.0F) {
      f1 = this.tgp;
    }
    f1 = 1.0F - f1 / this.tgp * (1.0F - this.aMv);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.tgj - this.tgi) / this.tgw * f1 + this.tgi;
    if (f1 >= this.tgw) {
      paramFloat = this.tgj;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float tgk = 1.0F;
    private static float tgl = 1.0F;
    private float aMv;
    private boolean aqJ;
    private Context context;
    private int fQr = 0;
    private int orientation;
    private float tgh;
    private float tgi;
    private float tgj;
    private int tgm;
    private int tgn;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.aMv = 0.8F;
      this.tgh = 1.0F;
      this.tgi = tgl;
      this.tgj = tgk;
      this.aqJ = false;
      this.tgn = 2147483647;
      this.tgm = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */