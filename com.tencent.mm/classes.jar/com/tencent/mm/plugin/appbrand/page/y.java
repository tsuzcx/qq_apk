package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.container.WrapperNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class y
{
  b gTQ;
  public ViewGroup gVj;
  List<y.b> gVk;
  int gVl = -1;
  float[] gVm;
  View gVn;
  aj gVo;
  int gVp = -1;
  ah mHandler;
  
  public y(ViewGroup paramViewGroup)
  {
    this.gVj = paramViewGroup;
    this.mHandler = new ah(Looper.getMainLooper());
    this.gVk = new LinkedList();
    this.gVn = new View(paramViewGroup.getContext());
  }
  
  private void a(y.b paramb)
  {
    this.gVk.removeAll(b(paramb));
  }
  
  private List<y.b> b(y.b paramb)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.gVk.iterator();
    while (localIterator.hasNext())
    {
      y.b localb = (y.b)localIterator.next();
      if (localb.gVA == paramb.id) {
        localLinkedList.addAll(b(localb));
      }
    }
    localLinkedList.add(paramb);
    return localLinkedList;
  }
  
  private int cd(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.gVk.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      y.b localb = (y.b)localIterator.next();
      if ((paramInt1 != localb.gVA) || (paramInt2 < localb.z)) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public final u.b F(int paramInt, boolean paramBoolean)
  {
    return u.Hc().v(hashCode() + "#" + paramInt, paramBoolean);
  }
  
  public final boolean a(int paramInt1, aj paramaj, int paramInt2)
  {
    paramaj = new y.6(this, Boolean.valueOf(false), paramInt1, paramaj, paramInt2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)paramaj.b(null)).booleanValue();
    }
    return ((Boolean)paramaj.b(this.mHandler)).booleanValue();
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean)
  {
    paramArrayOfFloat = new y.5(this, Boolean.valueOf(false), paramInt1, paramArrayOfFloat, paramInt2, paramBoolean);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)paramArrayOfFloat.b(null)).booleanValue();
    }
    return ((Boolean)paramArrayOfFloat.b(this.mHandler)).booleanValue();
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    paramView = new y.2(this, Boolean.valueOf(false), paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)paramView.b(null)).booleanValue();
    }
    return ((Boolean)paramView.b(this.mHandler)).booleanValue();
  }
  
  final boolean b(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean)
  {
    if (mi(paramInt1)) {
      return true;
    }
    y.b localb = me(paramInt1);
    if (localb == null) {
      return false;
    }
    View localView = (View)localb.gVz.get();
    ViewGroup localViewGroup = mb(localb.gVA);
    if (localViewGroup == null) {
      return false;
    }
    if (paramInt2 >= 0) {
      if (paramInt2 != 0) {
        break label85;
      }
    }
    label85:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 5)) {
        break;
      }
      return true;
    }
    float f2 = paramArrayOfFloat[0];
    float f1 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    i = (int)paramArrayOfFloat[4];
    boolean bool;
    if (paramBoolean != null) {
      bool = paramBoolean.booleanValue();
    }
    while (localb.z != i)
    {
      this.gVk.remove(localb);
      localViewGroup.removeView(localView);
      if (b(localView, paramInt1, localb.gVA, paramArrayOfFloat, paramInt2, bool))
      {
        return true;
        bool = localb.gVB;
      }
      else
      {
        a(localb);
        return false;
      }
    }
    paramBoolean = localb.gVC;
    if ((localb.gVA == 0) && ((localViewGroup instanceof ak)) && (bool != localb.gVB)) {
      if (bool)
      {
        paramArrayOfFloat = paramBoolean;
        if (paramBoolean == null)
        {
          paramArrayOfFloat = new y.a((byte)0);
          paramArrayOfFloat.view = localView;
          localb.gVC = paramArrayOfFloat;
        }
        ((ak)localViewGroup).a(paramArrayOfFloat);
        if (paramArrayOfFloat == null) {
          break label438;
        }
        paramArrayOfFloat.x = f2;
        paramArrayOfFloat.y = f1;
        paramArrayOfFloat.gVx = this.gVj.getScrollX();
        paramArrayOfFloat.gVy = this.gVj.getScrollY();
        f2 = paramArrayOfFloat.gVx + f2;
        f1 = paramArrayOfFloat.gVy + f1;
      }
    }
    label438:
    for (;;)
    {
      paramArrayOfFloat = localView.getLayoutParams();
      paramArrayOfFloat.width = ((int)f3);
      paramArrayOfFloat.height = ((int)f4);
      localView.setX(f2);
      localView.setY(f1);
      localView.requestLayout();
      paramInt1 = localViewGroup.indexOfChild(this.gVn);
      if ((localViewGroup.indexOfChild(localView) == -1) && (paramInt1 != -1))
      {
        localViewGroup.addView(localView, paramInt1);
        localViewGroup.removeView(this.gVn);
      }
      return true;
      ((ak)localViewGroup).b(localb.gVC);
      paramArrayOfFloat = paramBoolean;
      break;
    }
  }
  
  final boolean b(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean)
  {
    if ((paramView == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 5)) {
      return false;
    }
    ViewGroup localViewGroup = mb(paramInt2);
    if (localViewGroup == null) {
      return false;
    }
    if (mg(paramInt1) != null) {
      return false;
    }
    float f2 = paramArrayOfFloat[0];
    float f1 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    int m = (int)paramArrayOfFloat[4];
    paramArrayOfFloat = new ViewGroup.LayoutParams((int)f3, (int)f4);
    int i = cd(paramInt2, m);
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int j;
      if ((localViewGroup instanceof o))
      {
        j = ((o)localViewGroup).getTargetViewChildCount();
        int k = i;
        if (i > j) {
          k = j;
        }
        if (paramInt3 >= 0)
        {
          if (paramInt3 != 0) {
            break label337;
          }
          paramInt3 = 0;
          label153:
          paramView.setVisibility(paramInt3);
        }
        localViewGroup.addView(paramView, k, paramArrayOfFloat);
        paramArrayOfFloat = new y.b(paramView, paramInt1, paramInt2, m, paramBoolean);
        this.gVk.add(paramArrayOfFloat);
        if ((paramInt2 != 0) || (!(localViewGroup instanceof ak)) || (!paramBoolean)) {
          break label343;
        }
        y.a locala = new y.a((byte)0);
        locala.view = paramView;
        locala.x = f2;
        locala.y = f1;
        locala.gVx = this.gVj.getScrollX();
        locala.gVy = this.gVj.getScrollY();
        f2 += locala.gVx;
        f3 = locala.gVy;
        ((ak)localViewGroup).a(locala);
        paramArrayOfFloat.gVC = locala;
        f1 = f3 + f1;
      }
      label337:
      label343:
      for (;;)
      {
        paramView.setX(f2);
        paramView.setY(f1);
        return true;
        j = localViewGroup.getChildCount();
        break;
        paramInt3 = 4;
        break label153;
      }
    }
  }
  
  final ViewGroup mb(int paramInt)
  {
    if (paramInt == 0) {
      return this.gVj;
    }
    Object localObject = me(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = (View)((y.b)localObject).gVz.get();
    if (((localObject instanceof WrapperNativeContainerView)) && ((localObject instanceof p)) && ((localObject instanceof ViewGroup))) {
      return (ViewGroup)((WrapperNativeContainerView)localObject).K(AppBrandNativeContainerView.class);
    }
    if (((localObject instanceof p)) && ((localObject instanceof ViewGroup))) {
      return (ViewGroup)localObject;
    }
    return null;
  }
  
  public final boolean mc(int paramInt)
  {
    y.3 local3 = new y.3(this, Boolean.valueOf(false), paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)local3.b(null)).booleanValue();
    }
    return ((Boolean)local3.b(this.mHandler)).booleanValue();
  }
  
  final boolean md(int paramInt)
  {
    y.b localb = me(paramInt);
    if (localb == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      mk(paramInt);
      a(localb);
      localViewGroup = mb(localb.gVA);
    } while (localViewGroup == null);
    this.gVk.remove(localb);
    localViewGroup.removeView((View)localb.gVz.get());
    if ((localb.gVA == 0) && ((localViewGroup instanceof ak)) && (localb.gVB)) {
      ((ak)localViewGroup).b(localb.gVC);
    }
    return true;
  }
  
  public final y.b me(int paramInt)
  {
    Iterator localIterator = this.gVk.iterator();
    while (localIterator.hasNext())
    {
      y.b localb = (y.b)localIterator.next();
      if (localb.id == paramInt) {
        return localb;
      }
    }
    return null;
  }
  
  public final boolean mf(int paramInt)
  {
    return me(paramInt) != null;
  }
  
  public final View mg(int paramInt)
  {
    y.b localb = me(paramInt);
    if (localb == null) {
      return null;
    }
    return (View)localb.gVz.get();
  }
  
  public final u.b mh(int paramInt)
  {
    return u.Hc().ii(hashCode() + "#" + paramInt);
  }
  
  public final boolean mi(int paramInt)
  {
    return (this.gVp == paramInt) || (this.gVl == paramInt);
  }
  
  public final boolean mj(int paramInt)
  {
    y.7 local7 = new y.7(this, Boolean.valueOf(false), paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return ((Boolean)local7.b(null)).booleanValue();
    }
    return ((Boolean)local7.b(this.mHandler)).booleanValue();
  }
  
  final boolean mk(int paramInt)
  {
    if (paramInt != this.gVl) {}
    while (me(paramInt) == null) {
      return false;
    }
    this.gTQ.amQ();
    return true;
  }
  
  public final void setFullscreenImpl(b paramb)
  {
    this.gTQ = paramb;
    this.gTQ.a(new y.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y
 * JD-Core Version:    0.7.0.1
 */