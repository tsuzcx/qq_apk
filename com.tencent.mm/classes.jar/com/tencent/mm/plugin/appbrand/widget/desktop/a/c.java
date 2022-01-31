package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.List;

public final class c<T extends RecyclerView.v>
  implements b<T>
{
  View hqL;
  FrameLayout hrW;
  private List hrX;
  List hrY;
  Object hrZ;
  boolean hsa;
  public a hsb;
  c.a hsc;
  
  public c(FrameLayout paramFrameLayout, List paramList1, List paramList2, c.a parama)
  {
    this.hrW = paramFrameLayout;
    this.hrX = paramList1;
    this.hsc = parama;
    this.hrY = paramList2;
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
  
  private void j(RecyclerView paramRecyclerView)
  {
    if (this.hsa)
    {
      int i = this.hrY.indexOf(this.hrZ);
      if (i >= 0)
      {
        this.hrY.remove(i);
        paramRecyclerView.getAdapter().bN(i);
      }
      this.hsa = false;
      if (this.hsc != null) {
        this.hsc.arm();
      }
    }
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
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.v paramv, int paramInt, Runnable paramRunnable)
  {
    paramRunnable = new c.1(this, paramRecyclerView, paramInt, paramRunnable);
    RecyclerView.v localv;
    float f2;
    float f1;
    if ((paramv != null) && (this.hqL != null))
    {
      y.i("ItemMoveHelper", "[finishMove] position:" + paramv.id() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.bK(paramInt);
      f2 = this.hqL.getTranslationX();
      f1 = this.hqL.getTranslationY();
      if (this.hsa) {
        break label155;
      }
      f2 = f(paramRecyclerView, paramv);
      f1 = e(paramRecyclerView, paramv);
    }
    for (;;)
    {
      this.hqL.animate().scaleX(1.0F).scaleY(1.0F).translationX(f2).translationY(f1).setDuration(200L).setListener(new c.2(this, paramv, paramRunnable, localv)).start();
      return;
      label155:
      if ((localv == null) || (paramInt != localv.id()))
      {
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).gY() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      else if (this.hsa)
      {
        f2 = f(paramRecyclerView, localv);
        f1 = e(paramRecyclerView, localv);
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
      paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    } while (this.hsb == null);
    this.hsb.a(paramv, paramView);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    y.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.hsa + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (!this.hsa)
    {
      this.hrY.add(paramInt2, this.hrZ);
      paramRecyclerView.getAdapter().bM(paramInt2);
      this.hsa = true;
      if (this.hsc != null) {
        this.hsc.arl();
      }
    }
    do
    {
      return true;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        while (i < paramInt2)
        {
          Collections.swap(this.hrY, i, i + 1);
          i += 1;
        }
        paramRecyclerView.getAdapter().ai(paramInt1, paramInt2);
        return true;
      }
    } while (paramInt1 <= paramInt2);
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.hrY, i, i - 1);
      i -= 1;
    }
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
    this.hsa = false;
    this.hrZ = this.hsc.aZ(this.hrX.get(paramT.id()));
    return this.hqL;
  }
  
  public final void d(RecyclerView paramRecyclerView, T paramT)
  {
    y.i("ItemInsertHelper", "[onDelete] position:" + paramT.id());
    this.hrX.remove(paramT.id());
    paramRecyclerView.getAdapter().bL(2);
    j(paramRecyclerView);
    if (this.hsb != null) {
      this.hsb.ba(this.hrZ);
    }
  }
  
  public final void i(RecyclerView paramRecyclerView)
  {
    y.i("ItemInsertHelper", "alvinluo onCancel");
    j(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */