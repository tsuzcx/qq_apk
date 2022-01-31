package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends ViewPagerLayoutManager
{
  public float arK;
  private int oqb;
  private float oqc;
  private float oqd;
  private float oqe;
  
  private c(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(42481);
    S(null);
    if (this.oqy != paramInt4)
    {
      this.oqy = paramInt4;
      removeAllViews();
    }
    S(null);
    if (this.oqw != paramInt3)
    {
      this.oqw = paramInt3;
      removeAllViews();
    }
    this.oqb = paramInt1;
    this.arK = paramFloat1;
    this.oqc = paramFloat4;
    this.oqd = paramFloat2;
    this.oqe = paramFloat3;
    AppMethodBeat.o(42481);
  }
  
  public c(Context paramContext)
  {
    this(new c.a(paramContext));
    AppMethodBeat.i(42479);
    AppMethodBeat.o(42479);
  }
  
  private c(c.a parama)
  {
    this(c.a.b(parama), c.a.c(parama), c.a.d(parama), c.a.e(parama), c.a.f(parama), c.a.g(parama), c.a.h(parama), c.a.i(parama), c.a.j(parama));
    AppMethodBeat.i(42480);
    AppMethodBeat.o(42480);
  }
  
  protected final float bNt()
  {
    return this.oqb + this.oql;
  }
  
  protected final float bNu()
  {
    if (this.oqc == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.oqc;
  }
  
  protected final void n(View paramView, float paramFloat)
  {
    AppMethodBeat.i(42483);
    float f2 = Math.abs(this.oqn + paramFloat - this.oqn);
    float f1 = f2;
    if (f2 - this.oql > 0.0F) {
      f1 = this.oql;
    }
    f1 = 1.0F - f1 / this.oql * (1.0F - this.arK);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.oqe - this.oqd) / this.oqs * f1 + this.oqd;
    if (f1 >= this.oqs) {
      paramFloat = this.oqe;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(42483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.c
 * JD-Core Version:    0.7.0.1
 */