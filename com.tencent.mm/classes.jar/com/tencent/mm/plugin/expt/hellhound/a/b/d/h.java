package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class h
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  private static Field sCc;
  private static Field sCd;
  private static Field sCe;
  private static Method sCf;
  private static Method sCg;
  private static Method sCh;
  private static Method sFF;
  private static Field sFG;
  public static final a sHs;
  private WeakReference<RecyclerView> sFA;
  
  static
  {
    AppMethodBeat.i(221097);
    sHs = new a((byte)0);
    AppMethodBeat.o(221097);
  }
  
  public h()
  {
    AppMethodBeat.i(221096);
    Log.w("HABBYGE-MALI.TopicParamsCatcher", "TopicParamsCatcher");
    try
    {
      Object localObject = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      p.g(localObject, "Class.forName(WxRecyclerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("data");
      sCc = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      p.g(localObject, "Class.forName(FinderMediaBannerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("feed");
      sCd = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.g(localObject, "Class.forName(BaseFinderFeed_Name)");
      localObject = ((Class)localObject).getDeclaredField("feedObject");
      sCe = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.g(localObject, "Class.forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      sCf = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      sCg = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      sCh = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(localObject, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      sFF = (Method)localObject;
      if (localObject == null) {
        p.btv("getFinderObject_Method");
      }
      ((Method)localObject).setAccessible(true);
      localObject = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.g(localObject, "Class.forName(FinderObject_Name)");
      localObject = ((Class)localObject).getDeclaredField("sessionBuffer");
      p.g(localObject, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      sFG = (Field)localObject;
      if (localObject == null) {
        p.btv("sessionBuffer_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(221096);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(221096);
    }
  }
  
  public final String GY(int paramInt)
  {
    AppMethodBeat.i(221095);
    Object localObject1;
    RecyclerView.a locala;
    if (this.sFA != null)
    {
      localObject1 = this.sFA;
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
        localObject1 = sCc;
        if (localObject1 == null) {
          break label406;
        }
        localObject1 = ((Field)localObject1).get(locala);
        if (localObject1 == null)
        {
          AppMethodBeat.o(221095);
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
          AppMethodBeat.o(221095);
          return null;
        }
        localObject4 = sCe;
        if (localObject4 == null) {
          continue;
        }
        localObject1 = ((Field)localObject4).get(localObject1);
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = sCd;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((Field)localObject2).get(locala);
          if (localObject2 != null) {
            continue;
          }
          AppMethodBeat.o(221095);
          return null;
          localObject2 = null;
          continue;
          AppMethodBeat.o(221095);
          return null;
          localObject2 = null;
          continue;
          Object localObject4 = sFF;
          if (localObject4 != null) {
            continue;
          }
          p.btv("getFinderObject_Method");
          localObject2 = ((Method)localObject4).invoke(localObject2, new Object[0]);
          localObject4 = sFG;
          if (localObject4 != null) {
            continue;
          }
          p.btv("sessionBuffer_Field");
          localObject4 = ((Field)localObject4).get(localObject2);
          localObject2 = localObject4;
          if ((localObject4 instanceof String)) {
            continue;
          }
          localObject2 = null;
          localObject2 = (String)localObject2;
          AppMethodBeat.o(221095);
          return localObject2;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException2, "getSessionBuffer crash: " + localException2.getMessage(), new Object[0]);
          AppMethodBeat.o(221095);
          return null;
        }
      }
      localObject4 = sFF;
      if (localObject4 == null) {
        p.btv("getFinderObject_Method");
      }
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
      localObject4 = sFG;
      if (localObject4 == null) {
        p.btv("sessionBuffer_Field");
      }
      localObject4 = ((Field)localObject4).get(localObject1);
      localObject1 = localObject4;
      if (!(localObject4 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(221095);
      return localObject1;
      AppMethodBeat.o(221095);
      return null;
      AppMethodBeat.o(221095);
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
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(221091);
    Object localObject;
    if (this.sFA != null)
    {
      paramView = this.sFA;
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
                localObject = sCc;
                if (localObject == null) {
                  break label400;
                }
                paramView = ((Field)localObject).get(paramView);
                label63:
                if (paramView == null)
                {
                  AppMethodBeat.o(221091);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(221091);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(221091);
                  return null;
                }
                localObject = sCe;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = sCf;
                  if (localObject == null) {
                    break label222;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(221091);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e2, crash: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(221091);
                return null;
              }
              paramView = null;
              continue;
              label222:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)paramView).longValue());
            AppMethodBeat.o(221091);
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
        localObject = sCd;
        if (localObject == null) {
          break label405;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(221091);
          return null;
        }
        localObject = sCf;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label363;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(221091);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "_getFeedId, e1, crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221091);
        return null;
      }
      paramView = null;
      continue;
      label363:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)paramView).longValue());
      AppMethodBeat.o(221091);
      return paramView;
      AppMethodBeat.o(221091);
      return null;
      AppMethodBeat.o(221091);
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
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(221092);
    Object localObject;
    label67:
    int i;
    if (this.sFA != null)
    {
      paramView = this.sFA;
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
                localObject = sCc;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(221092);
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
                  AppMethodBeat.o(221092);
                  return null;
                }
                localObject = sCe;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = sCg;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(221092);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(221092);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(221092);
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
        localObject = sCd;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(221092);
          return null;
        }
        localObject = sCg;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(221092);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedUserName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221092);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(221092);
      return null;
      AppMethodBeat.o(221092);
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
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(221093);
    Object localObject;
    label67:
    int i;
    if (this.sFA != null)
    {
      paramView = this.sFA;
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
                localObject = sCc;
                if (localObject == null) {
                  break label417;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(221093);
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
                  AppMethodBeat.o(221093);
                  return null;
                }
                localObject = sCe;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = sCh;
                  if (localObject == null) {
                    break label252;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  localObject = paramView;
                  if (!(paramView instanceof String)) {
                    localObject = null;
                  }
                  paramView = (String)localObject;
                  AppMethodBeat.o(221093);
                  return paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(221093);
                return null;
              }
              paramView = null;
              continue;
              label252:
              paramView = null;
            }
            AppMethodBeat.o(221093);
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
        localObject = sCd;
        if (localObject == null) {
          break label427;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(221093);
          return null;
        }
        localObject = sCh;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = paramView;
          if (!(paramView instanceof String)) {
            localObject = null;
          }
          paramView = (String)localObject;
          AppMethodBeat.o(221093);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, "getFeedNickName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221093);
        return null;
      }
      paramView = null;
      continue;
      AppMethodBeat.o(221093);
      return null;
      AppMethodBeat.o(221093);
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
  
  public final boolean dP(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(221094);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(221094);
      return;
    }
    if (this.sFA != null)
    {
      localObject = this.sFA;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.sFA = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(221094);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher$Companion;", "", "()V", "BaseFinderFeed_Name", "", "FinderItem_Name", "FinderMediaBannerAdapter_Name", "FinderObject_Name", "TAG", "WxRecyclerAdapter_Name", "data_Field_Name", "data_field", "Ljava/lang/reflect/Field;", "feedObject_Field", "feedObject_Field_Name", "feed_Field_Name", "feed_field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "getFinderObject_Method_Name", "getId_Method", "getId_Method_Name", "getNickName_Method", "getUserName_Method", "nickName_Method_Name", "sessionBuffer_Field", "sessionBuffer_Field_Name", "userName_Method_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.h
 * JD-Core Version:    0.7.0.1
 */