package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleLayoutManager
  extends ViewPagerLayoutManager
{
  private float Kvu;
  private float Kvv;
  private float Kvw;
  private int itemSpace;
  public float minScale;
  
  public ScaleLayoutManager(Context paramContext)
  {
    this(new a(paramContext, 0));
    AppMethodBeat.i(65335);
    AppMethodBeat.o(65335);
  }
  
  private ScaleLayoutManager(Context paramContext, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, float paramFloat4, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super(paramInt2, paramBoolean);
    AppMethodBeat.i(283866);
    ZT(paramInt4);
    ZR(paramInt3);
    this.itemSpace = paramInt1;
    this.minScale = paramFloat1;
    this.Kvu = paramFloat4;
    this.Kvv = paramFloat2;
    this.Kvw = paramFloat3;
    AppMethodBeat.o(283866);
  }
  
  private ScaleLayoutManager(a parama)
  {
    this(a.a(parama), a.b(parama), a.c(parama), a.d(parama), a.e(parama), a.f(parama), a.g(parama), a.h(parama), a.i(parama), a.j(parama));
    AppMethodBeat.i(65336);
    AppMethodBeat.o(65336);
  }
  
  protected final float fXp()
  {
    return this.itemSpace + this.KvC;
  }
  
  protected final float fXq()
  {
    if (this.Kvu == 0.0F) {
      return 3.4028235E+38F;
    }
    return 1.0F / this.Kvu;
  }
  
  protected final void w(View paramView, float paramFloat)
  {
    AppMethodBeat.i(65338);
    float f2 = Math.abs(this.KvE + paramFloat - this.KvE);
    float f1 = f2;
    if (f2 - this.KvC > 0.0F) {
      f1 = this.KvC;
    }
    f1 = 1.0F - f1 / this.KvC * (1.0F - this.minScale);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    f1 = Math.abs(paramFloat);
    paramFloat = (this.Kvw - this.Kvv) / this.KvI * f1 + this.Kvv;
    if (f1 >= this.KvI) {
      paramFloat = this.Kvw;
    }
    paramView.setAlpha(paramFloat);
    AppMethodBeat.o(65338);
  }
  
  public static final class a
  {
    private static float Kvx = 1.0F;
    private static float Kvy = 1.0F;
    private int KvA;
    private float Kvu;
    private float Kvv;
    private float Kvw;
    private int Kvz;
    private boolean agn;
    private Context context;
    private int itemSpace = 0;
    private float minScale;
    private int orientation;
    
    public a(Context paramContext, int paramInt)
    {
      this.context = paramContext;
      this.orientation = 0;
      this.minScale = 0.8F;
      this.Kvu = 1.0F;
      this.Kvv = Kvy;
      this.Kvw = Kvx;
      this.agn = false;
      this.KvA = 2147483647;
      this.Kvz = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager
 * JD-Core Version:    0.7.0.1
 */