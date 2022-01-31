package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.container.WrapperNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.n;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class af
{
  public ViewGroup iux;
  d ixq;
  View iyA;
  bc iyB;
  int iyC;
  private ar iyD;
  private AppBrandPageFullScreenView iyE;
  List<af.b> iyx;
  int iyy;
  float[] iyz;
  private ak mHandler;
  
  public af(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(91097);
    this.iyy = -1;
    this.iyC = -1;
    this.iux = paramViewGroup;
    this.mHandler = new ak(Looper.getMainLooper());
    this.iyx = new LinkedList();
    this.iyA = new View(paramViewGroup.getContext());
    AppMethodBeat.o(91097);
  }
  
  private void a(af.b paramb)
  {
    AppMethodBeat.i(91108);
    this.iyx.removeAll(b(paramb));
    AppMethodBeat.o(91108);
  }
  
  private void aJI()
  {
    AppMethodBeat.i(141802);
    if (this.iyE == null)
    {
      this.iyE = new AppBrandPageFullScreenView(this.iux.getContext());
      if (this.iyD != null) {
        this.iyD.a(this.iyE);
      }
    }
    AppMethodBeat.o(141802);
  }
  
  private List<af.b> b(af.b paramb)
  {
    AppMethodBeat.i(91109);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.iyx.iterator();
    while (localIterator.hasNext())
    {
      af.b localb = (af.b)localIterator.next();
      if (localb.parent == paramb.id) {
        localLinkedList.addAll(b(localb));
      }
    }
    localLinkedList.add(paramb);
    AppMethodBeat.o(91109);
    return localLinkedList;
  }
  
  private int dm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91110);
    Iterator localIterator = this.iyx.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      af.b localb = (af.b)localIterator.next();
      if ((paramInt1 != localb.parent) || (paramInt2 < localb.z)) {
        break label72;
      }
      i += 1;
    }
    label72:
    for (;;)
    {
      break;
      AppMethodBeat.o(91110);
      return i;
    }
  }
  
  final ViewGroup I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91102);
    if (paramBoolean)
    {
      localObject = aJJ();
      AppMethodBeat.o(91102);
      return localObject;
    }
    if (paramInt == 0)
    {
      localObject = this.iux;
      AppMethodBeat.o(91102);
      return localObject;
    }
    Object localObject = ph(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(91102);
      return null;
    }
    localObject = (View)((af.b)localObject).iyQ.get();
    if (((localObject instanceof WrapperNativeContainerView)) && ((localObject instanceof o)) && ((localObject instanceof ViewGroup)))
    {
      localObject = (ViewGroup)((WrapperNativeContainerView)localObject).aa(AppBrandNativeContainerView.class);
      AppMethodBeat.o(91102);
      return localObject;
    }
    if (((localObject instanceof o)) && ((localObject instanceof ViewGroup)))
    {
      localObject = (ViewGroup)localObject;
      AppMethodBeat.o(91102);
      return localObject;
    }
    AppMethodBeat.o(91102);
    return null;
  }
  
  public final v.b J(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91115);
    v.b localb = v.aae().z(hashCode() + "#" + paramInt, paramBoolean);
    AppMethodBeat.o(91115);
    return localb;
  }
  
  public final void a(ar paramar)
  {
    AppMethodBeat.i(138260);
    ab.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", new Object[] { Boolean.TRUE });
    this.iyD = paramar;
    if (this.iyE != null) {
      this.iyD.a(this.iyE);
    }
    AppMethodBeat.o(138260);
  }
  
  public final boolean a(int paramInt1, bc parambc, int paramInt2)
  {
    AppMethodBeat.i(91116);
    parambc = new af.6(this, Boolean.FALSE, paramInt1, parambc, paramInt2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      bool = ((Boolean)parambc.b(null)).booleanValue();
      AppMethodBeat.o(91116);
      return bool;
    }
    boolean bool = ((Boolean)parambc.b(this.mHandler)).booleanValue();
    AppMethodBeat.o(91116);
    return bool;
  }
  
  public final boolean a(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(91106);
    paramArrayOfFloat = new af.5(this, Boolean.FALSE, paramInt1, paramArrayOfFloat, paramInt2, paramBoolean1, paramBoolean2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      bool = ((Boolean)paramArrayOfFloat.b(null)).booleanValue();
      AppMethodBeat.o(91106);
      return bool;
    }
    boolean bool = ((Boolean)paramArrayOfFloat.b(this.mHandler)).booleanValue();
    AppMethodBeat.o(91106);
    return bool;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(91100);
    paramView = new af.2(this, Boolean.FALSE, paramView, paramInt1, paramInt2, paramArrayOfFloat, paramInt3, paramBoolean1, paramBoolean2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramBoolean1 = ((Boolean)paramView.b(null)).booleanValue();
      AppMethodBeat.o(91100);
      return paramBoolean1;
    }
    paramBoolean1 = ((Boolean)paramView.b(this.mHandler)).booleanValue();
    AppMethodBeat.o(91100);
    return paramBoolean1;
  }
  
  public final ViewGroup aJJ()
  {
    AppMethodBeat.i(138261);
    aJI();
    AppBrandPageFullScreenView localAppBrandPageFullScreenView = this.iyE;
    AppMethodBeat.o(138261);
    return localAppBrandPageFullScreenView;
  }
  
  final boolean b(int paramInt1, float[] paramArrayOfFloat, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(91107);
    if (pk(paramInt1))
    {
      AppMethodBeat.o(91107);
      return true;
    }
    af.b localb = ph(paramInt1);
    if (localb == null)
    {
      AppMethodBeat.o(91107);
      return false;
    }
    View localView = (View)localb.iyQ.get();
    if (paramBoolean2 != null) {}
    for (boolean bool1 = paramBoolean2.booleanValue();; bool1 = localb.hhs)
    {
      paramBoolean2 = I(localb.parent, bool1);
      if (paramBoolean2 != null) {
        break;
      }
      AppMethodBeat.o(91107);
      return false;
    }
    if (paramInt2 >= 0) {
      if (paramInt2 != 0) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 5)) {
        break;
      }
      AppMethodBeat.o(91107);
      return true;
    }
    float f2 = paramArrayOfFloat[0];
    float f1 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    i = (int)paramArrayOfFloat[4];
    boolean bool2;
    if (paramBoolean1 != null) {
      bool2 = paramBoolean1.booleanValue();
    }
    while ((localb.z != i) || (localb.hhs != bool1))
    {
      this.iyx.remove(localb);
      paramBoolean2.removeView(localView);
      if (localView.getParent() != null)
      {
        if ((localb.iyS != null) && ((localView.getParent() instanceof bd))) {
          ((bd)localView.getParent()).b(localb.iyS);
        }
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      if (b(localView, paramInt1, localb.parent, paramArrayOfFloat, paramInt2, bool2, bool1))
      {
        AppMethodBeat.o(91107);
        return true;
        bool2 = localb.iyR;
      }
      else
      {
        a(localb);
        AppMethodBeat.o(91107);
        return false;
      }
    }
    paramBoolean1 = localb.iyS;
    if ((localb.parent == 0) && ((paramBoolean2 instanceof bd)) && (bool2 != localb.iyR)) {
      if (bool2)
      {
        paramArrayOfFloat = paramBoolean1;
        if (paramBoolean1 == null)
        {
          paramArrayOfFloat = new af.a((byte)0);
          paramArrayOfFloat.view = localView;
          localb.iyS = paramArrayOfFloat;
        }
        ((bd)paramBoolean2).a(paramArrayOfFloat);
        if (paramArrayOfFloat == null) {
          break label580;
        }
        paramArrayOfFloat.x = f2;
        paramArrayOfFloat.y = f1;
        paramArrayOfFloat.iyO = this.iux.getScrollX();
        paramArrayOfFloat.iyP = this.iux.getScrollY();
        f2 = paramArrayOfFloat.iyO + f2;
        f1 = paramArrayOfFloat.iyP + f1;
      }
    }
    label580:
    for (;;)
    {
      paramArrayOfFloat = localView.getLayoutParams();
      paramArrayOfFloat.width = ((int)f3);
      paramArrayOfFloat.height = ((int)f4);
      localView.setX(f2);
      localView.setY(f1);
      localView.requestLayout();
      paramInt1 = paramBoolean2.indexOfChild(this.iyA);
      if ((paramBoolean2.indexOfChild(localView) == -1) && (paramInt1 != -1))
      {
        paramBoolean2.addView(localView, paramInt1);
        paramBoolean2.removeView(this.iyA);
      }
      AppMethodBeat.o(91107);
      return true;
      ((bd)paramBoolean2).b(localb.iyS);
      paramArrayOfFloat = paramBoolean1;
      break;
    }
  }
  
  final boolean b(View paramView, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(91101);
    if ((paramView == null) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 5))
    {
      AppMethodBeat.o(91101);
      return false;
    }
    ViewGroup localViewGroup = I(paramInt2, paramBoolean2);
    if (localViewGroup == null)
    {
      AppMethodBeat.o(91101);
      return false;
    }
    if (getViewById(paramInt1) != null)
    {
      AppMethodBeat.o(91101);
      return false;
    }
    float f2 = paramArrayOfFloat[0];
    float f1 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    int m = (int)paramArrayOfFloat[4];
    paramArrayOfFloat = new ViewGroup.LayoutParams((int)f3, (int)f4);
    int i = dm(paramInt2, m);
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int j;
      if ((localViewGroup instanceof n))
      {
        j = ((n)localViewGroup).getTargetViewChildCount();
        int k = i;
        if (i > j) {
          k = j;
        }
        if (paramInt3 >= 0)
        {
          if (paramInt3 != 0) {
            break label371;
          }
          paramInt3 = 0;
          label179:
          paramView.setVisibility(paramInt3);
        }
        localViewGroup.addView(paramView, k, paramArrayOfFloat);
        paramArrayOfFloat = new af.b(paramView, paramInt1, paramInt2, m, paramBoolean1, paramBoolean2);
        this.iyx.add(paramArrayOfFloat);
        if ((paramInt2 != 0) || (!(localViewGroup instanceof bd)) || (!paramBoolean1)) {
          break label377;
        }
        af.a locala = new af.a((byte)0);
        locala.view = paramView;
        locala.x = f2;
        locala.y = f1;
        locala.iyO = this.iux.getScrollX();
        locala.iyP = this.iux.getScrollY();
        f2 += locala.iyO;
        f3 = locala.iyP;
        ((bd)localViewGroup).a(locala);
        paramArrayOfFloat.iyS = locala;
        f1 = f3 + f1;
      }
      label371:
      label377:
      for (;;)
      {
        paramView.setX(f2);
        paramView.setY(f1);
        AppMethodBeat.o(91101);
        return true;
        j = localViewGroup.getChildCount();
        break;
        paramInt3 = 4;
        break label179;
      }
    }
  }
  
  public final View getViewById(int paramInt)
  {
    AppMethodBeat.i(91113);
    Object localObject = ph(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(91113);
      return null;
    }
    localObject = (View)((af.b)localObject).iyQ.get();
    AppMethodBeat.o(91113);
    return localObject;
  }
  
  public final boolean pf(int paramInt)
  {
    AppMethodBeat.i(91103);
    af.3 local3 = new af.3(this, Boolean.FALSE, paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      bool = ((Boolean)local3.b(null)).booleanValue();
      AppMethodBeat.o(91103);
      return bool;
    }
    boolean bool = ((Boolean)local3.b(this.mHandler)).booleanValue();
    AppMethodBeat.o(91103);
    return bool;
  }
  
  final boolean pg(int paramInt)
  {
    AppMethodBeat.i(91104);
    af.b localb = ph(paramInt);
    if (localb == null)
    {
      AppMethodBeat.o(91104);
      return false;
    }
    pm(paramInt);
    a(localb);
    ViewGroup localViewGroup = I(localb.parent, localb.hhs);
    if (localViewGroup != null)
    {
      this.iyx.remove(localb);
      localViewGroup.removeView((View)localb.iyQ.get());
      if ((localb.parent == 0) && ((localViewGroup instanceof bd)) && (localb.iyR)) {
        ((bd)localViewGroup).b(localb.iyS);
      }
      AppMethodBeat.o(91104);
      return true;
    }
    AppMethodBeat.o(91104);
    return false;
  }
  
  public final af.b ph(int paramInt)
  {
    AppMethodBeat.i(91111);
    Iterator localIterator = this.iyx.iterator();
    while (localIterator.hasNext())
    {
      af.b localb = (af.b)localIterator.next();
      if (localb.id == paramInt)
      {
        AppMethodBeat.o(91111);
        return localb;
      }
    }
    AppMethodBeat.o(91111);
    return null;
  }
  
  public final boolean pi(int paramInt)
  {
    AppMethodBeat.i(91112);
    if (ph(paramInt) != null)
    {
      AppMethodBeat.o(91112);
      return true;
    }
    AppMethodBeat.o(91112);
    return false;
  }
  
  public final v.b pj(int paramInt)
  {
    AppMethodBeat.i(91114);
    v.b localb = v.aae().oP(hashCode() + "#" + paramInt);
    AppMethodBeat.o(91114);
    return localb;
  }
  
  public final boolean pk(int paramInt)
  {
    return (this.iyC == paramInt) || (this.iyy == paramInt);
  }
  
  public final boolean pl(int paramInt)
  {
    AppMethodBeat.i(91117);
    af.7 local7 = new af.7(this, Boolean.FALSE, paramInt);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      bool = ((Boolean)local7.b(null)).booleanValue();
      AppMethodBeat.o(91117);
      return bool;
    }
    boolean bool = ((Boolean)local7.b(this.mHandler)).booleanValue();
    AppMethodBeat.o(91117);
    return bool;
  }
  
  final boolean pm(int paramInt)
  {
    AppMethodBeat.i(91118);
    if (paramInt != this.iyy)
    {
      AppMethodBeat.o(91118);
      return false;
    }
    if (ph(paramInt) == null)
    {
      AppMethodBeat.o(91118);
      return false;
    }
    this.ixq.aIJ();
    AppMethodBeat.o(91118);
    return true;
  }
  
  public final void removeAll()
  {
    AppMethodBeat.i(91105);
    af.4 local4 = new af.4(this, Boolean.FALSE);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      local4.b(null);
    }
    local4.b(this.mHandler);
    AppMethodBeat.o(91105);
  }
  
  public final void setFullscreenImpl(d paramd)
  {
    AppMethodBeat.i(91098);
    this.ixq = paramd;
    this.ixq.a(new ao()
    {
      public final void aDk()
      {
        AppMethodBeat.i(91087);
        af localaf = af.this;
        af.b localb = localaf.ph(localaf.iyC);
        float[] arrayOfFloat = localaf.iyz;
        if ((localb == null) || (localb.iyQ == null) || (arrayOfFloat == null)) {}
        for (;;)
        {
          if (af.this.iyB != null)
          {
            af.this.iyB.aDk();
            af.this.iyB = null;
          }
          AppMethodBeat.o(91087);
          return;
          View localView = (View)localb.iyQ.get();
          if (localView != null)
          {
            if (localaf.iyC != localaf.iyy)
            {
              Object localObject = localaf.ph(localaf.iyy);
              if ((localObject != null) && (((af.b)localObject).iyQ != null))
              {
                localObject = (View)((af.b)localObject).iyQ.get();
                if (localObject != null) {
                  localaf.b(localaf.iyy, arrayOfFloat, ((View)localObject).getVisibility(), Boolean.valueOf(localb.iyR), Boolean.FALSE);
                }
              }
            }
            int i = localaf.iyC;
            localaf.iyy = -1;
            localaf.iyC = -1;
            localaf.b(i, arrayOfFloat, localView.getVisibility(), Boolean.valueOf(localb.iyR), Boolean.FALSE);
          }
        }
      }
    });
    AppMethodBeat.o(91098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */