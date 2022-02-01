package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  private float ECq;
  private float ECr;
  private float ECs;
  public float aGO;
  private int itemSpace;
  
  public ScaleLayoutManager(Context paramContext)
  {
    this(new a(paramContext, 0));
    AppMethodBeat.i(65335);
    AppMethodBeat.o(65335);
  }
  
  private ScaleLayoutManager(Context paramContext, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(271451);
    VX(paramInt4);
    VV(paramInt3);
    this.itemSpace = paramInt1;
    this.aGO = paramFloat1;
    this.ECq = paramFloat4;
    this.ECr = paramFloat2;
    this.ECs = paramFloat3;
    AppMethodBeat.o(271451);
  }
  
  private ScaleLayoutManager(a parama)
  {
    this(a.a(parama), a.b(parama), a.c(parama), a.d(parama), a.e(parama), a.f(parama), a.g(parama), a.h(parama), a.i(parama), a.j(parama));
    AppMethodBeat.i(65336);
    AppMethodBeat.o(65336);
  }
  
  protected final float eOL()
  {
    return this.itemSpace + this.ECy;
  }
  
  protected final float eOM()
  {
    if (this.ECq == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.ECq;
  }
  
  protected final void v(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.ECA + paramFloat - this.ECA);
    float f1 = f2;
    if (f2 - this.ECy > 0.0F) {
      f1 = this.ECy;
    }
    f1 = 1.0F - f1 / this.ECy * (1.0F - this.aGO);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.ECs - this.ECr) / this.ECE * f1 + this.ECr;
    if (f1 >= this.ECE) {
      paramFloat = this.ECs;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float ECt = 1.0F;
    private static float ECu = 1.0F;
    private float ECq;
    private float ECr;
    private float ECs;
    private int ECv;
    private int ECw;
    private int FO;
    private float aGO;
    private boolean aln;
    private Context context;
    private int itemSpace = 0;
    
    public a(Context paramContext, int paramInt)
    {
      this.context = paramContext;
      this.FO = 0;
      this.aGO = 0.8F;
      this.ECq = 1.0F;
      this.ECr = ECu;
      this.ECs = ECt;
      this.aln = false;
      this.ECw = 2147483647;
      this.ECv = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */