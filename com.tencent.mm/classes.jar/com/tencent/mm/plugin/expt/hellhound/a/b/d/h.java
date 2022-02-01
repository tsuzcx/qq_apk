package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class h
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  private static Field rbD;
  private static Field rbE;
  private static Field rbF;
  private static Method rbG;
  private static Method rbH;
  private static Method rbI;
  private static Method reo;
  private static Field rep;
  public static final h.a rfW;
  private WeakReference<RecyclerView> ren;
  
  static
  {
    AppMethodBeat.i(196605);
    rfW = new h.a((byte)0);
    AppMethodBeat.o(196605);
  }
  
  public h()
  {
    AppMethodBeat.i(196604);
    ae.w("HABBYGE-MALI.TopicParamsCatcher", "TopicParamsCatcher");
    try
    {
      Object localObject = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      p.g(localObject, "Class.forName(WxRecyclerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("data");
      rbD = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      p.g(localObject, "Class.forName(FinderMediaBannerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("feed");
      rbE = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.g(localObject, "Class.forName(BaseFinderFeed_Name)");
      localObject = ((Class)localObject).getDeclaredField("feedObject");
      rbF = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.g(localObject, "Class.forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      rbG = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      rbH = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      rbI = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(localObject, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      reo = (Method)localObject;
      if (localObject == null) {
        p.bdF("getFinderObject_Method");
      }
      ((Method)localObject).setAccessible(true);
      localObject = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("sessionBuffer");
      p.g(localObject, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      rep = (Field)localObject;
      if (localObject == null) {
        p.bdF("sessionBuffer_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(196604);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(196604);
    }
  }
  
  public final String Dn(int paramInt)
  {
    AppMethodBeat.i(196603);
    Object localObject1;
    RecyclerView.a locala;
    if (this.ren != null)
    {
      localObject1 = this.ren;
      if (localObject1 == null) {
        break label401;
      }
      localObject1 = (RecyclerView)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        locala = ((RecyclerView)localObject1).getAdapter();
        if (locala != null) {
          if (!(locala instanceof WxRecyclerAdapter)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = rbD;
        if (localObject1 == null) {
          break label406;
        }
        localObject1 = ((Field)localObject1).get(locala);
        if (localObject1 == null)
        {
          AppMethodBeat.o(196603);
          return null;
        }
        if (!(localObject1 instanceof ArrayList)) {
          continue;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label411;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).get(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(196603);
          return null;
        }
        localObject4 = rbF;
        if (localObject4 == null) {
          continue;
        }
        localObject1 = ((Field)localObject4).get(localObject1);
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = rbE;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((Field)localObject2).get(locala);
          if (localObject2 != null) {
            continue;
          }
          AppMethodBeat.o(196603);
          return null;
          localObject2 = null;
          continue;
          AppMethodBeat.o(196603);
          return null;
          localObject2 = null;
          continue;
          Object localObject4 = reo;
          if (localObject4 != null) {
            continue;
          }
          p.bdF("getFinderObject_Method");
          localObject2 = ((Method)localObject4).invoke(localObject2, new Object[0]);
          localObject4 = rep;
          if (localObject4 != null) {
            continue;
          }
          p.bdF("sessionBuffer_Field");
          localObject4 = ((Field)localObject4).get(localObject2);
          localObject2 = localObject4;
          if ((localObject4 instanceof String)) {
            continue;
          }
          localObject2 = null;
          localObject2 = (String)localObject2;
          AppMethodBeat.o(196603);
          return localObject2;
        }
        catch (Exception localException2)
        {
          ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException2, "getSessionBuffer crash: " + localException2.getMessage(), new Object[0]);
          AppMethodBeat.o(196603);
          return null;
        }
      }
      localObject4 = reo;
      if (localObject4 == null) {
        p.bdF("getFinderObject_Method");
      }
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
      localObject4 = rep;
      if (localObject4 == null) {
        p.bdF("sessionBuffer_Field");
      }
      localObject4 = ((Field)localObject4).get(localObject1);
      localObject1 = localObject4;
      if (!(localObject4 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(196603);
      return localObject1;
      AppMethodBeat.o(196603);
      return null;
      AppMethodBeat.o(196603);
      return null;
      label401:
      Object localObject3 = null;
      break;
      label406:
      localObject3 = null;
      continue;
      label411:
      int i = 0;
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(196599);
    Object localObject;
    if (this.ren != null)
    {
      paramView = this.ren;
      if (paramView == null) {
        break label393;
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
                localObject = rbD;
                if (localObject == null) {
                  break label398;
                }
                paramView = ((Field)localObject).get(paramView);
                label63:
                if (paramView == null)
                {
                  AppMethodBeat.o(196599);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(196599);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(196599);
                  return null;
                }
                localObject = rbF;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = rbG;
                  if (localObject == null) {
                    break label221;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new v("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(196599);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e2, crash: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(196599);
                return null;
              }
              paramView = null;
              continue;
              label221:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)paramView).longValue());
            AppMethodBeat.o(196599);
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
        localObject = rbE;
        if (localObject == null) {
          break label403;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(196599);
          return null;
        }
        localObject = rbG;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label361;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(196599);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e1, crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196599);
        return null;
      }
      paramView = null;
      continue;
      label361:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)paramView).longValue());
      AppMethodBeat.o(196599);
      return paramView;
      AppMethodBeat.o(196599);
      return null;
      AppMethodBeat.o(196599);
      return null;
      label393:
      paramView = null;
      break;
      label398:
      paramView = null;
      break label63;
      label403:
      paramView = null;
    }
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(196600);
    Object localObject;
    label67:
    int i;
    if (this.ren != null)
    {
      paramView = this.ren;
      if (paramView == null) {
        break label412;
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
                localObject = rbD;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(196600);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label422;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(196600);
                  return null;
                }
                localObject = rbF;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = rbH;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(196600);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(196600);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(196600);
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
        localObject = rbE;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(196600);
          return null;
        }
        localObject = rbH;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(196600);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196600);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(196600);
      return null;
      AppMethodBeat.o(196600);
      return null;
      label412:
      paramView = null;
      break;
      label417:
      paramView = null;
      break label67;
      label422:
      i = 0;
      break label100;
      label427:
      paramView = null;
    }
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(196601);
    Object localObject;
    label67:
    int i;
    if (this.ren != null)
    {
      paramView = this.ren;
      if (paramView == null) {
        break label412;
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
                localObject = rbD;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(196601);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label422;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(196601);
                  return null;
                }
                localObject = rbF;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = rbI;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(196601);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(196601);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(196601);
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
        localObject = rbE;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(196601);
          return null;
        }
        localObject = rbI;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(196601);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196601);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(196601);
      return null;
      AppMethodBeat.o(196601);
      return null;
      label412:
      paramView = null;
      break;
      label417:
      paramView = null;
      break label67;
      label422:
      i = 0;
      break label100;
      label427:
      paramView = null;
    }
  }
  
  public final boolean dX(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(196602);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(196602);
      return;
    }
    if (this.ren != null)
    {
      localObject = this.ren;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.ren = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(196602);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.h
 * JD-Core Version:    0.7.0.1
 */