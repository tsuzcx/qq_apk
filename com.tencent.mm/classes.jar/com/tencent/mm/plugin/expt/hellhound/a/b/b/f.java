package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LbsParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class f
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  private static Field qTF;
  private static Field qTG;
  private static Field qTH;
  private static Method qTI;
  private static Method qTJ;
  private static Method qTK;
  private static Method qWo;
  private static Field qWp;
  public static final f.a qWq;
  private WeakReference<RecyclerView> qWn;
  
  static
  {
    AppMethodBeat.i(210800);
    qWq = new f.a((byte)0);
    AppMethodBeat.o(210800);
  }
  
  public f()
  {
    AppMethodBeat.i(210799);
    ad.w("HABBYGE-MALI.LbsParamsCatcher", "LbsParamsCatcher");
    try
    {
      Object localObject = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      p.g(localObject, "Class.forName(WxRecyclerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("data");
      qTF = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      p.g(localObject, "Class.forName(FinderMediaBannerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("feed");
      qTG = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.g(localObject, "Class.forName(BaseFinderFeed_Name)");
      localObject = ((Class)localObject).getDeclaredField("feedObject");
      qTH = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.g(localObject, "Class.forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      qTI = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      qTJ = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      qTK = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(localObject, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      qWo = (Method)localObject;
      if (localObject == null) {
        p.bcb("getFinderObject_Method");
      }
      ((Method)localObject).setAccessible(true);
      localObject = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("sessionBuffer");
      p.g(localObject, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      qWp = (Field)localObject;
      if (localObject == null) {
        p.bcb("sessionBuffer_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(210799);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(210799);
    }
  }
  
  public final String Da(int paramInt)
  {
    AppMethodBeat.i(210798);
    Object localObject1;
    Object localObject3;
    if (this.qWn != null)
    {
      localObject1 = this.qWn;
      if (localObject1 == null) {
        break label415;
      }
      localObject1 = (RecyclerView)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject3 = ((RecyclerView)localObject1).getAdapter();
        if (localObject3 != null) {
          if (!(localObject3 instanceof WxRecyclerAdapter)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = qTF;
        if (localObject1 == null) {
          break label420;
        }
        localObject1 = ((Field)localObject1).get(localObject3);
        if (localObject1 == null)
        {
          AppMethodBeat.o(210798);
          return null;
        }
        if (!(localObject1 instanceof ArrayList)) {
          continue;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label425;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).get(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(210798);
          return null;
        }
        localObject4 = qTH;
        if (localObject4 == null) {
          continue;
        }
        localObject1 = ((Field)localObject4).get(localObject1);
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject4;
          Object localObject2 = qTG;
          if (localObject2 != null)
          {
            localObject2 = ((Field)localObject2).get(localObject3);
            if (localObject2 == null)
            {
              AppMethodBeat.o(210798);
              return null;
              localObject2 = null;
              continue;
              localObject2 = (String)localObject2;
              AppMethodBeat.o(210798);
              return localObject2;
              AppMethodBeat.o(210798);
              return null;
            }
          }
          else
          {
            localObject2 = null;
            continue;
          }
          localObject3 = qWo;
          if (localObject3 == null) {
            p.bcb("getFinderObject_Method");
          }
          localObject2 = ((Method)localObject3).invoke(localObject2, new Object[0]);
          localObject3 = qWp;
          if (localObject3 == null) {
            p.bcb("sessionBuffer_Field");
          }
          localObject2 = ((Field)localObject3).get(localObject2);
          if (localObject2 == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210798);
            throw ((Throwable)localObject2);
          }
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)localException2, "getSessionBuffer crash: " + localException2.getMessage(), new Object[0]);
          AppMethodBeat.o(210798);
          return null;
        }
        str = (String)localException2;
        AppMethodBeat.o(210798);
        return str;
      }
      localObject4 = qWo;
      if (localObject4 == null) {
        p.bcb("getFinderObject_Method");
      }
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
      localObject4 = qWp;
      if (localObject4 == null) {
        p.bcb("sessionBuffer_Field");
      }
      localObject1 = ((Field)localObject4).get(localObject1);
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(210798);
        throw ((Throwable)localObject1);
      }
      AppMethodBeat.o(210798);
      return null;
      AppMethodBeat.o(210798);
      return null;
      label415:
      String str = null;
      break;
      label420:
      str = null;
      continue;
      label425:
      int i = 0;
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(210794);
    Object localObject;
    if (this.qWn != null)
    {
      paramView = this.qWn;
      if (paramView == null) {
        break label395;
      }
      paramView = (RecyclerView)paramView.get();
      if (paramView != null)
      {
        paramView = paramView.getAdapter();
        if (paramView != null)
        {
          if ((paramView instanceof WxRecyclerAdapter))
          {
            for (;;)
            {
              try
              {
                localObject = qTF;
                if (localObject == null) {
                  break label400;
                }
                paramView = ((Field)localObject).get(paramView);
                label63:
                if (paramView == null)
                {
                  AppMethodBeat.o(210794);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(210794);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(210794);
                  return null;
                }
                localObject = qTH;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = qTI;
                  if (localObject == null) {
                    break label222;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new v("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(210794);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "_getFeedId, e2, crash: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(210794);
                return null;
              }
              paramView = null;
              continue;
              label222:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rc(((Long)paramView).longValue());
            AppMethodBeat.o(210794);
            return paramView;
          }
          if (!(paramView instanceof a)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = qTG;
        if (localObject == null) {
          break label405;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(210794);
          return null;
        }
        localObject = qTI;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label363;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(210794);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "_getFeedId, e1, crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210794);
        return null;
      }
      paramView = null;
      continue;
      label363:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rc(((Long)paramView).longValue());
      AppMethodBeat.o(210794);
      return paramView;
      AppMethodBeat.o(210794);
      return null;
      AppMethodBeat.o(210794);
      return null;
      label395:
      paramView = null;
      break;
      label400:
      paramView = null;
      break label63;
      label405:
      paramView = null;
    }
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(210795);
    Object localObject;
    label67:
    int i;
    if (this.qWn != null)
    {
      paramView = this.qWn;
      if (paramView == null) {
        break label428;
      }
      paramView = (RecyclerView)paramView.get();
      if (paramView != null)
      {
        paramView = paramView.getAdapter();
        if (paramView != null)
        {
          if ((paramView instanceof WxRecyclerAdapter))
          {
            for (;;)
            {
              try
              {
                localObject = qTF;
                if (localObject == null) {
                  break label433;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(210795);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break label265;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label438;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break label265;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(210795);
                  return null;
                }
                localObject = qTH;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = qTJ;
                  if (localObject == null) {
                    break label247;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new v("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(210795);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "getFeedUserName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(210795);
                return null;
              }
              paramView = null;
              continue;
              label247:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(210795);
            return paramView;
            label265:
            AppMethodBeat.o(210795);
            return null;
          }
          if (!(paramView instanceof a)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = qTG;
        if (localObject == null) {
          break label443;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(210795);
          return null;
        }
        localObject = qTJ;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label399;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210795);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "getFeedUserName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210795);
        return null;
      }
      paramView = null;
      continue;
      label399:
      paramView = (String)paramView;
      AppMethodBeat.o(210795);
      return paramView;
      AppMethodBeat.o(210795);
      return null;
      AppMethodBeat.o(210795);
      return null;
      label428:
      paramView = null;
      break;
      label433:
      paramView = null;
      break label67;
      label438:
      i = 0;
      break label100;
      label443:
      paramView = null;
    }
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(210796);
    Object localObject;
    label67:
    int i;
    if (this.qWn != null)
    {
      paramView = this.qWn;
      if (paramView == null) {
        break label428;
      }
      paramView = (RecyclerView)paramView.get();
      if (paramView != null)
      {
        paramView = paramView.getAdapter();
        if (paramView != null)
        {
          if ((paramView instanceof WxRecyclerAdapter))
          {
            for (;;)
            {
              try
              {
                localObject = qTF;
                if (localObject == null) {
                  break label433;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(210796);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break label265;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label438;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break label265;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(210796);
                  return null;
                }
                localObject = qTH;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = qTK;
                  if (localObject == null) {
                    break label247;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new v("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(210796);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "getFeedNickName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(210796);
                return null;
              }
              paramView = null;
              continue;
              label247:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(210796);
            return paramView;
            label265:
            AppMethodBeat.o(210796);
            return null;
          }
          if (!(paramView instanceof a)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = qTG;
        if (localObject == null) {
          break label443;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(210796);
          return null;
        }
        localObject = qTK;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label399;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210796);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.LbsParamsCatcher", (Throwable)paramView, "getFeedNickName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210796);
        return null;
      }
      paramView = null;
      continue;
      label399:
      paramView = (String)paramView;
      AppMethodBeat.o(210796);
      return paramView;
      AppMethodBeat.o(210796);
      return null;
      AppMethodBeat.o(210796);
      return null;
      label428:
      paramView = null;
      break;
      label433:
      paramView = null;
      break label67;
      label438:
      i = 0;
      break label100;
      label443:
      paramView = null;
    }
  }
  
  public final boolean dX(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(210797);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(210797);
      return;
    }
    if (this.qWn != null)
    {
      localObject = this.qWn;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.qWn = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(210797);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.f
 * JD-Core Version:    0.7.0.1
 */