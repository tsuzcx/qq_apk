package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.List;

public final class d<T extends RecyclerView.v>
  implements b<T>
{
  private List hfb;
  View hqL;
  FrameLayout hrW;
  public a hsb;
  private Object hsi;
  private e hsj;
  
  public d(FrameLayout paramFrameLayout, List paramList, e parame)
  {
    this.hrW = paramFrameLayout;
    this.hfb = paramList;
    this.hsj = parame;
  }
  
  private static float e(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    float f2 = paramv.aie.getTop();
    Object localObject = paramv.aie;
    ViewParent localViewParent = ((View)localObject).getParent();
    float f1 = f2;
    paramv = (RecyclerView.v)localObject;
    if (localViewParent != null)
    {
      f1 = f2;
      paramv = (RecyclerView.v)localObject;
      if ((localViewParent instanceof View)) {
        paramv = (View)localViewParent;
      }
    }
    for (f1 = f2 + paramv.getTop(); paramv != paramRecyclerView; f1 += paramv.getTop())
    {
      label59:
      localObject = paramv.getParent();
      if ((localObject == null) || (!(localObject instanceof View))) {
        break label59;
      }
      paramv = (View)localObject;
    }
    return f1;
  }
  
  private static float f(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    float f2 = paramv.aie.getLeft();
    Object localObject = paramv.aie;
    ViewParent localViewParent = ((View)localObject).getParent();
    float f1 = f2;
    paramv = (RecyclerView.v)localObject;
    if (localViewParent != null)
    {
      f1 = f2;
      paramv = (RecyclerView.v)localObject;
      if ((localViewParent instanceof View)) {
        paramv = (View)localViewParent;
      }
    }
    for (f1 = f2 + paramv.getLeft(); paramv != paramRecyclerView; f1 += paramv.getLeft())
    {
      label59:
      localObject = paramv.getParent();
      if ((localObject == null) || (!(localObject instanceof View))) {
        break label59;
      }
      paramv = (View)localObject;
    }
    return f1;
  }
  
  public final boolean J(T paramT)
  {
    if (this.hsb != null) {
      return this.hsb.J(paramT);
    }
    return paramT != null;
  }
  
  public final boolean L(T paramT)
  {
    if (this.hsb != null) {
      return this.hsb.L(paramT);
    }
    return false;
  }
  
  public final boolean M(T paramT)
  {
    if (this.hsb != null) {
      return this.hsb.K(paramT);
    }
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, Runnable paramRunnable)
  {
    RecyclerView.v localv;
    float f2;
    float f1;
    if ((paramT != null) && (this.hqL != null))
    {
      y.i("ItemMoveHelper", "[finishMove] position" + paramT.id() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.bK(paramInt);
      f2 = this.hqL.getTranslationX();
      f1 = this.hqL.getTranslationY();
      if ((paramInt == paramT.id()) || (localv != null)) {
        break label249;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).gY() <= paramInt) {
        break label236;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    label295:
    for (;;)
    {
      this.hqL.animate().scaleX(1.0F).scaleY(1.0F).translationX(f2).translationY(f1).setDuration(200L).setListener(new d.1(this, localv, paramRunnable)).start();
      y.i("MicroMsg.ItemMoveHelper", "alvinluo ItemMoveHelper");
      paramInt = 4;
      for (;;)
      {
        if (paramInt < this.hfb.size())
        {
          paramRecyclerView = this.hfb.get(paramInt);
          if (((paramRecyclerView instanceof AppBrandDesktopView.a)) && (((AppBrandDesktopView.a)paramRecyclerView).hqw != null)) {
            y.i("MicroMsg.ItemMoveHelper", "alvinluo title: %s", new Object[] { ((AppBrandDesktopView.a)paramRecyclerView).hqw.nickname });
          }
          paramInt += 1;
          continue;
          label236:
          f1 = paramRecyclerView.getHeight() + f1;
          break;
          label249:
          if (localv == null) {
            break label295;
          }
          f2 = f(paramRecyclerView, localv);
          f1 = e(paramRecyclerView, localv);
          break;
        }
      }
      if (this.hsb != null) {
        this.hsb.c(this.hsi, true);
      }
      return;
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.id() + " target:" + paramT2.id());
    y.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.hfb.hashCode()) });
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.hfb, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.hfb, i, i - 1);
      i -= 1;
    }
    y.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.hfb.hashCode()) });
    paramRecyclerView.getAdapter().ai(paramInt1, paramInt2);
    return true;
  }
  
  public final View c(RecyclerView paramRecyclerView, T paramT)
  {
    FrameLayout localFrameLayout = this.hrW;
    paramT.aie.setVisibility(4);
    paramRecyclerView = this.hsb.b(paramRecyclerView, paramT);
    paramRecyclerView.setAlpha(1.0F);
    paramRecyclerView.setScaleX(1.0F);
    paramRecyclerView.setScaleY(1.0F);
    paramRecyclerView.setVisibility(0);
    this.hqL = paramRecyclerView;
    localFrameLayout.addView(paramRecyclerView);
    y.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.id());
    if ((this.hsj != null) && (this.hfb.size() > paramT.id())) {
      this.hsi = this.hsj.aZ(this.hfb.get(paramT.id()));
    }
    return this.hqL;
  }
  
  public final void d(RecyclerView paramRecyclerView, T paramT)
  {
    y.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.id()) });
    if ((paramT instanceof com.tencent.mm.plugin.appbrand.widget.desktop.e)) {
      y.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((com.tencent.mm.plugin.appbrand.widget.desktop.e)paramT).eXr.getText() });
    }
    this.hfb.remove(paramT.id());
    y.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.hfb.hashCode()) });
    paramRecyclerView.getAdapter().bN(paramT.id());
    if (this.hsb != null) {
      this.hsb.ba(this.hsi);
    }
  }
  
  public final void i(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d
 * JD-Core Version:    0.7.0.1
 */