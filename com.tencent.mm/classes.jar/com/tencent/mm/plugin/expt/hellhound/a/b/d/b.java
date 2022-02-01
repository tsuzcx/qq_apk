package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FavParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class b
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  private static Field whX;
  private static Field whY;
  private static Field whZ;
  private static Method wia;
  private static Method wib;
  private static Method wic;
  private static Method wlA;
  private static Field wlB;
  public static final a wmO;
  private WeakReference<RecyclerView> wlv;
  
  static
  {
    AppMethodBeat.i(254893);
    wmO = new a((byte)0);
    AppMethodBeat.o(254893);
  }
  
  public b()
  {
    AppMethodBeat.i(254892);
    Log.w("HABBYGE-MALI.FavParamsCatcher", "FavParamsCatcher");
    try
    {
      Object localObject = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      p.j(localObject, "Class.forName(WxRecyclerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("data");
      whX = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      p.j(localObject, "Class.forName(FinderMediaBannerAdapter_Name)");
      localObject = ((Class)localObject).getDeclaredField("feed");
      whY = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.j(localObject, "Class.forName(BaseFinderFeed_Name)");
      localObject = ((Class)localObject).getDeclaredField("feedObject");
      whZ = (Field)localObject;
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.j(localObject, "Class.forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      wia = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      wib = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      wic = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getFinderObject", new Class[0]);
      p.j(localObject, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      wlA = (Method)localObject;
      if (localObject == null) {
        p.bGy("getFinderObject_Method");
      }
      ((Method)localObject).setAccessible(true);
      localObject = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.j(localObject, "Class.forName(FinderObject_Name)");
      localObject = ((Class)localObject).getDeclaredField("sessionBuffer");
      p.j(localObject, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      wlB = (Field)localObject;
      if (localObject == null) {
        p.bGy("sessionBuffer_Field");
      }
      ((Field)localObject).setAccessible(true);
      AppMethodBeat.o(254892);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(254892);
    }
  }
  
  public final String KI(int paramInt)
  {
    AppMethodBeat.i(254889);
    Object localObject1;
    Object localObject3;
    if (this.wlv != null)
    {
      localObject1 = this.wlv;
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
        localObject1 = whX;
        if (localObject1 == null) {
          break label420;
        }
        localObject1 = ((Field)localObject1).get(localObject3);
        if (localObject1 == null)
        {
          AppMethodBeat.o(254889);
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
          AppMethodBeat.o(254889);
          return null;
        }
        localObject4 = whZ;
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
          Object localObject2 = whY;
          if (localObject2 != null)
          {
            localObject2 = ((Field)localObject2).get(localObject3);
            if (localObject2 == null)
            {
              AppMethodBeat.o(254889);
              return null;
              localObject2 = null;
              continue;
              localObject2 = (String)localObject2;
              AppMethodBeat.o(254889);
              return localObject2;
              AppMethodBeat.o(254889);
              return null;
            }
          }
          else
          {
            localObject2 = null;
            continue;
          }
          localObject3 = wlA;
          if (localObject3 == null) {
            p.bGy("getFinderObject_Method");
          }
          localObject2 = ((Method)localObject3).invoke(localObject2, new Object[0]);
          localObject3 = wlB;
          if (localObject3 == null) {
            p.bGy("sessionBuffer_Field");
          }
          localObject2 = ((Field)localObject3).get(localObject2);
          if (localObject2 == null)
          {
            localObject2 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(254889);
            throw ((Throwable)localObject2);
          }
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)localException2, "getSessionBuffer crash: " + localException2.getMessage(), new Object[0]);
          AppMethodBeat.o(254889);
          return null;
        }
        str = (String)localException2;
        AppMethodBeat.o(254889);
        return str;
      }
      localObject4 = wlA;
      if (localObject4 == null) {
        p.bGy("getFinderObject_Method");
      }
      localObject1 = ((Method)localObject4).invoke(localObject1, new Object[0]);
      localObject4 = wlB;
      if (localObject4 == null) {
        p.bGy("sessionBuffer_Field");
      }
      localObject1 = ((Field)localObject4).get(localObject1);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(254889);
        throw ((Throwable)localObject1);
      }
      AppMethodBeat.o(254889);
      return null;
      AppMethodBeat.o(254889);
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
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(254882);
    Object localObject;
    if (this.wlv != null)
    {
      paramView = this.wlv;
      if (paramView == null) {
        break label408;
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
                localObject = whX;
                if (localObject == null) {
                  break label413;
                }
                paramView = ((Field)localObject).get(paramView);
                label64:
                if (paramView == null)
                {
                  AppMethodBeat.o(254882);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(254882);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(254882);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wia;
                  if (localObject == null) {
                    break label228;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(254882);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "_getFeedId, e2, crash: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(254882);
                return null;
              }
              paramView = null;
              continue;
              label228:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
            AppMethodBeat.o(254882);
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
        localObject = whY;
        if (localObject == null) {
          break label418;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(254882);
          return null;
        }
        localObject = wia;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label373;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(254882);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "_getFeedId, e1, crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(254882);
        return null;
      }
      paramView = null;
      continue;
      label373:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
      AppMethodBeat.o(254882);
      return paramView;
      AppMethodBeat.o(254882);
      return null;
      AppMethodBeat.o(254882);
      return null;
      label408:
      paramView = null;
      break;
      label413:
      paramView = null;
      break label64;
      label418:
      paramView = null;
    }
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(254884);
    Object localObject;
    label67:
    int i;
    if (this.wlv != null)
    {
      paramView = this.wlv;
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
                localObject = whX;
                if (localObject == null) {
                  break label433;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(254884);
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
                  AppMethodBeat.o(254884);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wib;
                  if (localObject == null) {
                    break label247;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(254884);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "getFeedUserName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(254884);
                return null;
              }
              paramView = null;
              continue;
              label247:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(254884);
            return paramView;
            label265:
            AppMethodBeat.o(254884);
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
        localObject = whY;
        if (localObject == null) {
          break label443;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(254884);
          return null;
        }
        localObject = wib;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label399;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(254884);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "getFeedUserName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(254884);
        return null;
      }
      paramView = null;
      continue;
      label399:
      paramView = (String)paramView;
      AppMethodBeat.o(254884);
      return paramView;
      AppMethodBeat.o(254884);
      return null;
      AppMethodBeat.o(254884);
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
  
  public final String ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(254886);
    Object localObject;
    label67:
    int i;
    if (this.wlv != null)
    {
      paramView = this.wlv;
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
                localObject = whX;
                if (localObject == null) {
                  break label433;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(254886);
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
                  AppMethodBeat.o(254886);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wic;
                  if (localObject == null) {
                    break label247;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(254886);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "getFeedNickName e1: " + paramView.getMessage(), new Object[0]);
                AppMethodBeat.o(254886);
                return null;
              }
              paramView = null;
              continue;
              label247:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(254886);
            return paramView;
            label265:
            AppMethodBeat.o(254886);
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
        localObject = whY;
        if (localObject == null) {
          break label443;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(254886);
          return null;
        }
        localObject = wic;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label399;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(254886);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", (Throwable)paramView, "getFeedNickName e2: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(254886);
        return null;
      }
      paramView = null;
      continue;
      label399:
      paramView = (String)paramView;
      AppMethodBeat.o(254886);
      return paramView;
      AppMethodBeat.o(254886);
      return null;
      AppMethodBeat.o(254886);
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
  
  public final boolean en(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(254887);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(254887);
      return;
    }
    if (this.wlv != null)
    {
      localObject = this.wlv;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.wlv = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(254887);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FavParamsCatcher$Companion;", "", "()V", "BaseFinderFeed_Name", "", "FinderItem_Name", "FinderMediaBannerAdapter_Name", "FinderObject_Name", "TAG", "WxRecyclerAdapter_Name", "data_Field_Name", "data_field", "Ljava/lang/reflect/Field;", "feedObject_Field", "feedObject_Field_Name", "feed_Field_Name", "feed_field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "getFinderObject_Method_Name", "getId_Method", "getId_Method_Name", "getNickName_Method", "getUserName_Method", "nickName_Method_Name", "sessionBuffer_Field", "sessionBuffer_Field_Name", "userName_Method_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.b
 * JD-Core Version:    0.7.0.1
 */