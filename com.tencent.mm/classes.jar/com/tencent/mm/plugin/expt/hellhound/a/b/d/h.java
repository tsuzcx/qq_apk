package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class h
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  private static Field KEP;
  private static Method KHc;
  private static Field KHd;
  public static final a KIz;
  private static Field pFQ;
  private static Field pFR;
  private static Method pFS;
  private static Method pFT;
  private static Method pFU;
  private WeakReference<RecyclerView> KHb;
  
  static
  {
    AppMethodBeat.i(205317);
    KIz = new a((byte)0);
    AppMethodBeat.o(205317);
  }
  
  public h()
  {
    AppMethodBeat.i(205316);
    ad.w("HABBYGE-MALI.TopicParamsCatcher", "TopicParamsCatcher");
    try
    {
      Object localObject = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      k.g(localObject, "Class.forName(WxRecyclerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("data");
      pFQ = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      k.g(localObject, "Class.forName(FinderMediaBannerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("feed");
      KEP = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      k.g(localObject, "Class.forName(BaseFinderFeed_Name)");
      localObject = ((Class)localObject).getDeclaredField("feedObject");
      pFR = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      k.g(localObject, "Class.forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      pFS = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      pFT = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      pFU = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getFinderObject", new Class[0]);
      k.g(localObject, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      KHc = (Method)localObject;
      if (localObject == null) {
        k.aPZ("getFinderObject_Method");
      }
      ((Method)localObject).setAccessible(true);
      localObject = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("sessionBuffer");
      k.g(localObject, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      KHd = (Field)localObject;
      if (localObject == null) {
        k.aPZ("sessionBuffer_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(205316);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(205316);
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(205311);
    Object localObject;
    if (this.KHb != null)
    {
      paramView = this.KHb;
      if (paramView == null) {
        break label392;
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
                localObject = pFQ;
                if (localObject == null) {
                  break label397;
                }
                paramView = ((Field)localObject).get(paramView);
                label63:
                if (paramView == null)
                {
                  AppMethodBeat.o(205311);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(205311);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(205311);
                  return null;
                }
                localObject = pFR;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = pFS;
                  if (localObject == null) {
                    break label220;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new v("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(205311);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e2, crash: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(205311);
                return null;
              }
              paramView = null;
              continue;
              label220:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)paramView).longValue());
            AppMethodBeat.o(205311);
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
        localObject = KEP;
        if (localObject == null) {
          break label402;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(205311);
          return null;
        }
        localObject = pFS;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label360;
          }
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(205311);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e1, crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205311);
        return null;
      }
      paramView = null;
      continue;
      label360:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)paramView).longValue());
      AppMethodBeat.o(205311);
      return paramView;
      AppMethodBeat.o(205311);
      return null;
      AppMethodBeat.o(205311);
      return null;
      label392:
      paramView = null;
      break;
      label397:
      paramView = null;
      break label63;
      label402:
      paramView = null;
    }
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(205312);
    Object localObject;
    label67:
    int i;
    if (this.KHb != null)
    {
      paramView = this.KHb;
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
                localObject = pFQ;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(205312);
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
                  AppMethodBeat.o(205312);
                  return null;
                }
                localObject = pFR;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = pFT;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(205312);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(205312);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(205312);
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
        localObject = KEP;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(205312);
          return null;
        }
        localObject = pFT;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(205312);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205312);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(205312);
      return null;
      AppMethodBeat.o(205312);
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
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(205313);
    Object localObject;
    label67:
    int i;
    if (this.KHb != null)
    {
      paramView = this.KHb;
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
                localObject = pFQ;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(205313);
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
                  AppMethodBeat.o(205313);
                  return null;
                }
                localObject = pFR;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = pFU;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(205313);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(205313);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(205313);
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
        localObject = KEP;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(205313);
          return null;
        }
        localObject = pFU;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(205313);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205313);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(205313);
      return null;
      AppMethodBeat.o(205313);
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
  
  public final String agS(int paramInt)
  {
    AppMethodBeat.i(205315);
    Object localObject1;
    RecyclerView.a locala;
    if (this.KHb != null)
    {
      localObject1 = this.KHb;
      if (localObject1 == null) {
        break label412;
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
        localObject1 = pFQ;
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((Field)localObject1).get(locala);
        if (localObject1 == null)
        {
          AppMethodBeat.o(205315);
          return null;
        }
        if (!(localObject1 instanceof ArrayList)) {
          continue;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label422;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).get(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(205315);
          return null;
        }
        localObject4 = pFR;
        if (localObject4 == null) {
          continue;
        }
        localObject1 = ((Field)localObject4).get(localObject1);
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = KEP;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((Field)localObject2).get(locala);
          if (localObject2 != null) {
            continue;
          }
          AppMethodBeat.o(205315);
          return null;
          localObject2 = null;
          continue;
          AppMethodBeat.o(205315);
          return null;
          localObject2 = null;
          continue;
          Object localObject4 = KHc;
          if (localObject4 != null) {
            continue;
          }
          k.aPZ("getFinderObject_Method");
          localObject2 = ((Method)localObject4).invoke(localObject2, new Object[0]);
          localObject4 = KHd;
          if (localObject4 != null) {
            continue;
          }
          k.aPZ("sessionBuffer_Field");
          localObject4 = ((Field)localObject4).get(localObject2);
          localObject2 = localObject4;
          if ((localObject4 instanceof String)) {
            continue;
          }
          localObject2 = null;
          localObject2 = (String)localObject2;
          AppMethodBeat.o(205315);
          return localObject2;
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException2, "getSessionBuffer crash: " + localException2.getMessage(), new Object[0]);
          AppMethodBeat.o(205315);
          return null;
        }
      }
      localObject4 = KHc;
      if (localObject4 == null) {
        k.aPZ("getFinderObject_Method");
      }
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
      localObject4 = KHd;
      if (localObject4 == null) {
        k.aPZ("sessionBuffer_Field");
      }
      localObject4 = ((Field)localObject4).get(localObject1);
      localObject1 = localObject4;
      if (!(localObject4 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(205315);
      return localObject1;
      AppMethodBeat.o(205315);
      return null;
      AppMethodBeat.o(205315);
      return null;
      label412:
      Object localObject3 = null;
      break;
      label417:
      localObject3 = null;
      continue;
      label422:
      int i = 0;
    }
  }
  
  public final boolean dO(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205314);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(205314);
      return;
    }
    if (this.KHb != null)
    {
      localObject = this.KHb;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.KHb = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(205314);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher$Companion;", "", "()V", "BaseFinderFeed_Name", "", "FinderItem_Name", "FinderMediaBannerAdapter_Name", "FinderObject_Name", "TAG", "WxRecyclerAdapter_Name", "data_Field_Name", "data_field", "Ljava/lang/reflect/Field;", "feedObject_Field", "feedObject_Field_Name", "feed_Field_Name", "feed_field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "getFinderObject_Method_Name", "getId_Method", "getId_Method_Name", "getNickName_Method", "getUserName_Method", "nickName_Method_Name", "sessionBuffer_Field", "sessionBuffer_Field_Name", "userName_Method_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.h
 * JD-Core Version:    0.7.0.1
 */