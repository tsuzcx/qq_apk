package com.tencent.mm.plugin.expt.hellhound.a.b.b;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LbsParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class f
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
  public static final a wlC;
  private static Method wlw;
  private static Method wlx;
  private static Method wly;
  private static Method wlz;
  private WeakReference<RecyclerView> wlv;
  
  static
  {
    AppMethodBeat.i(253563);
    wlC = new a((byte)0);
    AppMethodBeat.o(253563);
  }
  
  public f()
  {
    AppMethodBeat.i(253560);
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
      localObject = Class.forName("com.tencent.mm.plugin.finder.storage.FeedData");
      p.j(localObject, "Class.forName(FeedData_Name)");
      Method localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
      wlw = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getUserName", new Class[0]);
      wlx = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject).getDeclaredMethod("getNickName", new Class[0]);
      wly = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject = ((Class)localObject).getDeclaredMethod("getSessionBuffer", new Class[0]);
      wlz = (Method)localObject;
      if (localObject != null) {
        ((Method)localObject).setAccessible(true);
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
      localMethod = ((Class)localObject).getDeclaredMethod("getId", new Class[0]);
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
      AppMethodBeat.o(253560);
      return;
    }
    catch (Exception localException)
    {
      Log.e("HABBYGE-MALI.LbsParamsCatcher", "reflect crash");
      AppMethodBeat.o(253560);
    }
  }
  
  public final String KI(int paramInt)
  {
    AppMethodBeat.i(253556);
    Object localObject3;
    label66:
    int i;
    label98:
    Object localObject2;
    if (this.wlv != null)
    {
      Object localObject1 = this.wlv;
      if (localObject1 == null) {
        break label385;
      }
      localObject1 = (RecyclerView)((WeakReference)localObject1).get();
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 != null)
        {
          if ((localObject1 instanceof WxRecyclerAdapter))
          {
            for (;;)
            {
              try
              {
                localObject3 = whX;
                if (localObject3 == null) {
                  break label390;
                }
                localObject1 = ((Field)localObject3).get(localObject1);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(253556);
                  return null;
                }
                if (!(localObject1 instanceof ArrayList)) {
                  break label255;
                }
                if (((Collection)localObject1).isEmpty()) {
                  break label395;
                }
                i = 1;
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
                  break label255;
                }
                localObject1 = ((ArrayList)localObject1).get(paramInt);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(253556);
                  return null;
                }
                localObject3 = whZ;
                if (localObject3 != null)
                {
                  localObject1 = ((Field)localObject3).get(localObject1);
                  localObject3 = wlA;
                  if (localObject3 == null) {
                    p.bGy("getFinderObject_Method");
                  }
                  localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
                  localObject3 = wlB;
                  if (localObject3 == null) {
                    p.bGy("sessionBuffer_Field");
                  }
                  localObject1 = ((Field)localObject3).get(localObject1);
                  if (localObject1 != null) {
                    break;
                  }
                  localObject1 = new t("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(253556);
                  throw ((Throwable)localObject1);
                }
              }
              catch (Exception localException1)
              {
                Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFinderObject_Method, e1, crash");
                AppMethodBeat.o(253556);
                return null;
              }
              localObject2 = null;
            }
            localObject2 = (String)localObject2;
            AppMethodBeat.o(253556);
            return localObject2;
            label255:
            AppMethodBeat.o(253556);
            return null;
          }
          if (!(localObject2 instanceof a)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = whY;
        if (localObject3 == null) {
          break label400;
        }
        localObject2 = ((Field)localObject3).get(localObject2);
        if (localObject2 == null)
        {
          AppMethodBeat.o(253556);
          return null;
        }
        localObject3 = wlz;
        if (localObject3 != null)
        {
          localObject2 = ((Method)localObject3).invoke(localObject2, new Object[0]);
          if (localObject2 != null) {
            break label359;
          }
          localObject2 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(253556);
          throw ((Throwable)localObject2);
        }
      }
      catch (Exception localException2)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getSessionBuffer_Method2, e2, crash");
        AppMethodBeat.o(253556);
        return null;
      }
      String str = null;
      continue;
      label359:
      str = (String)str;
      AppMethodBeat.o(253556);
      return str;
      AppMethodBeat.o(253556);
      return null;
      AppMethodBeat.o(253556);
      return null;
      label385:
      str = null;
      break;
      label390:
      str = null;
      break label66;
      label395:
      i = 0;
      break label98;
      label400:
      str = null;
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(253547);
    Object localObject;
    if (this.wlv != null)
    {
      paramView = this.wlv;
      if (paramView == null) {
        break label345;
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
                  break label350;
                }
                paramView = ((Field)localObject).get(paramView);
                label63:
                if (paramView == null)
                {
                  AppMethodBeat.o(253547);
                  return null;
                }
                paramView = (ArrayList)paramView;
                if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
                {
                  AppMethodBeat.o(253547);
                  return null;
                }
                paramView = paramView.get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(253547);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wia;
                  if (localObject == null) {
                    break label197;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.Long");
                  AppMethodBeat.o(253547);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.e("HABBYGE-MALI.LbsParamsCatcher", "_getFeedId, e2, crash");
                AppMethodBeat.o(253547);
                return null;
              }
              paramView = null;
              continue;
              label197:
              paramView = null;
            }
            paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
            AppMethodBeat.o(253547);
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
          break label355;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(253547);
          return null;
        }
        localObject = wlw;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label313;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(253547);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "_getFeedId, e1, crash");
        AppMethodBeat.o(253547);
        return null;
      }
      paramView = null;
      continue;
      label313:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
      AppMethodBeat.o(253547);
      return paramView;
      AppMethodBeat.o(253547);
      return null;
      AppMethodBeat.o(253547);
      return null;
      label345:
      paramView = null;
      break;
      label350:
      paramView = null;
      break label63;
      label355:
      paramView = null;
    }
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(253550);
    Object localObject;
    label67:
    int i;
    if (this.wlv != null)
    {
      paramView = this.wlv;
      if (paramView == null) {
        break label378;
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
                  break label383;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(253550);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break label240;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label388;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break label240;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(253550);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wib;
                  if (localObject == null) {
                    break label222;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(253550);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedUserName, e1, crash");
                AppMethodBeat.o(253550);
                return null;
              }
              paramView = null;
              continue;
              label222:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(253550);
            return paramView;
            label240:
            AppMethodBeat.o(253550);
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
          break label393;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(253550);
          return null;
        }
        localObject = wlx;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label349;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(253550);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedUserName, e2, crash");
        AppMethodBeat.o(253550);
        return null;
      }
      paramView = null;
      continue;
      label349:
      paramView = (String)paramView;
      AppMethodBeat.o(253550);
      return paramView;
      AppMethodBeat.o(253550);
      return null;
      AppMethodBeat.o(253550);
      return null;
      label378:
      paramView = null;
      break;
      label383:
      paramView = null;
      break label67;
      label388:
      i = 0;
      break label100;
      label393:
      paramView = null;
    }
  }
  
  public final String ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(253552);
    Object localObject;
    label67:
    int i;
    if (this.wlv != null)
    {
      paramView = this.wlv;
      if (paramView == null) {
        break label378;
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
                  break label383;
                }
                paramView = ((Field)localObject).get(paramView);
                if (paramView == null)
                {
                  AppMethodBeat.o(253552);
                  return null;
                }
                if (!(paramView instanceof ArrayList)) {
                  break label240;
                }
                if (((Collection)paramView).isEmpty()) {
                  break label388;
                }
                i = 1;
                label100:
                if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
                  break label240;
                }
                paramView = ((ArrayList)paramView).get(paramInt);
                if (paramView == null)
                {
                  AppMethodBeat.o(253552);
                  return null;
                }
                localObject = whZ;
                if (localObject != null)
                {
                  paramView = ((Field)localObject).get(paramView);
                  localObject = wic;
                  if (localObject == null) {
                    break label222;
                  }
                  paramView = ((Method)localObject).invoke(paramView, new Object[0]);
                  if (paramView != null) {
                    break;
                  }
                  paramView = new t("null cannot be cast to non-null type kotlin.String");
                  AppMethodBeat.o(253552);
                  throw paramView;
                }
              }
              catch (Exception paramView)
              {
                Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedNickName, e1, crash");
                AppMethodBeat.o(253552);
                return null;
              }
              paramView = null;
              continue;
              label222:
              paramView = null;
            }
            paramView = (String)paramView;
            AppMethodBeat.o(253552);
            return paramView;
            label240:
            AppMethodBeat.o(253552);
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
          break label393;
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(253552);
          return null;
        }
        localObject = wly;
        if (localObject != null)
        {
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
          if (paramView != null) {
            break label349;
          }
          paramView = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(253552);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedNickName, e2, crash");
        AppMethodBeat.o(253552);
        return null;
      }
      paramView = null;
      continue;
      label349:
      paramView = (String)paramView;
      AppMethodBeat.o(253552);
      return paramView;
      AppMethodBeat.o(253552);
      return null;
      AppMethodBeat.o(253552);
      return null;
      label378:
      paramView = null;
      break;
      label383:
      paramView = null;
      break label67;
      label388:
      i = 0;
      break label100;
      label393:
      paramView = null;
    }
  }
  
  public final boolean en(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(253553);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(253553);
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
      AppMethodBeat.o(253553);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LbsParamsCatcher$Companion;", "", "()V", "BaseFinderFeed_Name", "", "FeedData_Name", "FinderItem_Name", "FinderMediaBannerAdapter_Name", "FinderObject_Name", "TAG", "WxRecyclerAdapter_Name", "data_Field_Name", "data_field", "Ljava/lang/reflect/Field;", "feedObject_Field", "feedObject_Field_Name", "feed_Field_Name", "feed_field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "getFinderObject_Method_Name", "getId_Method", "getId_Method2", "getId_Method_Name", "getNickName_Method", "getNickName_Method2", "getSessionBuffer_Method2", "getUserName_Method", "getUserName_Method2", "nickName_Method_Name", "sessionBuffer_Field", "sessionBuffer_Field_Name", "userName_Method_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.f
 * JD-Core Version:    0.7.0.1
 */