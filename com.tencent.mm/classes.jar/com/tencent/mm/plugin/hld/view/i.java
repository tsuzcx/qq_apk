package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/VerticalItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerType", "Lcom/tencent/mm/plugin/hld/view/ImeDividerType;", "dividerColors", "", "backgroundPaint", "Landroid/graphics/Paint;", "dividerHeight", "", "dividerLeftRightMargin", "(Lcom/tencent/mm/plugin/hld/view/ImeDividerType;[ILandroid/graphics/Paint;II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "Builder", "plugin-hld_release"})
public final class i
  extends RecyclerView.h
{
  private final d DJp;
  private final int[] DJq;
  private final int DJr;
  private final int jau;
  private final Paint jbC;
  
  public i(d paramd, int[] paramArrayOfInt, Paint paramPaint, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209790);
    this.DJp = paramd;
    this.DJq = paramArrayOfInt;
    this.jbC = paramPaint;
    this.jau = paramInt1;
    this.DJr = paramInt2;
    AppMethodBeat.o(209790);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(209787);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramCanvas, paramRecyclerView, params);
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = k + this.DJr;
    int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight() - this.DJr;
    int i = 0;
    if (i < j)
    {
      params = paramRecyclerView.getChildAt(i);
      p.j(params, "view");
      float f1 = params.getBottom();
      float f2 = params.getBottom() + this.jau;
      if (i == j - 1) {
        paramCanvas.drawRect(k, f1, n, f2, this.jbC);
      }
      for (;;)
      {
        i += 1;
        break;
        params = this.DJp;
        switch (j.$EnumSwitchMapping$0[params.ordinal()])
        {
        default: 
          break;
        case 1: 
          params = new Paint();
          params.setColor(this.DJq[0]);
          paramCanvas.drawRect(m, f1, n, f2, params);
          break;
        case 2: 
          params = new Paint();
          float f3 = m;
          float f4 = n;
          int[] arrayOfInt = this.DJq;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          params.setShader((Shader)new LinearGradient(f3, 0.0F, f4, 0.0F, arrayOfInt, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode));
          params.setAlpha(255);
          paramCanvas.drawRect(new RectF(m, f1, n, f2), params);
        }
      }
    }
    AppMethodBeat.o(209787);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(209789);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramRect.bottom = this.jau;
    AppMethodBeat.o(209789);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/VerticalItemDecoration$Builder;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundColor", "", "mDividerColors", "", "mDividerHeight", "mDividerType", "Lcom/tencent/mm/plugin/hld/view/ImeDividerType;", "mLeftRightMarginSpan", "mResources", "Landroid/content/res/Resources;", "build", "Lcom/tencent/mm/plugin/hld/view/VerticalItemDecoration;", "setBackgroundColor", "resource", "setDividerColor", "setDividerHeight", "vertical", "setDividerLinearGradient", "dividerColor", "setDividerType", "dividerType", "setLeftRightMargin", "plugin-hld_release"})
  public static final class a
  {
    public d DJs;
    private int DJt;
    private int[] DJu;
    private final Context mContext;
    private final Resources mResources;
    private int rou;
    private int sS;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(213913);
      this.mContext = paramContext;
      paramContext = this.mContext.getResources();
      p.j(paramContext, "mContext.resources");
      this.mResources = paramContext;
      this.DJs = d.DHY;
      this.DJu = new int[1];
      this.DJt = 0;
      this.sS = 0;
      this.DJu[0] = -1;
      this.rou = -1;
      AppMethodBeat.o(213913);
    }
    
    public final a UR(int paramInt)
    {
      AppMethodBeat.i(213905);
      this.sS = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(213905);
      return this;
    }
    
    public final a US(@androidx.annotation.a int paramInt)
    {
      AppMethodBeat.i(213907);
      this.DJu[0] = androidx.core.content.a.w(this.mContext, paramInt);
      AppMethodBeat.o(213907);
      return this;
    }
    
    public final a UT(@androidx.annotation.a int paramInt)
    {
      AppMethodBeat.i(213908);
      this.rou = androidx.core.content.a.w(this.mContext, paramInt);
      AppMethodBeat.o(213908);
      return this;
    }
    
    public final i eHI()
    {
      AppMethodBeat.i(213910);
      Object localObject = new Paint();
      ((Paint)localObject).setColor(this.rou);
      localObject = new i(this.DJs, this.DJu, (Paint)localObject, this.sS, this.DJt);
      AppMethodBeat.o(213910);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.i
 * JD-Core Version:    0.7.0.1
 */