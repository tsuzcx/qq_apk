package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/LbsParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.plugin.expt.hellhound.ext.a.a.b
{
  private static Field zEa;
  private static Field zEb;
  private static Field zEc;
  private static Method zEd;
  private static Method zEe;
  private static Method zEf;
  public static final f.a zHA;
  private static Method zHC;
  private static Method zHD;
  private static Method zHE;
  private static Method zHF;
  private static Method zHG;
  private static Field zHH;
  private WeakReference<RecyclerView> zHB;
  
  static
  {
    AppMethodBeat.i(300576);
    zHA = new f.a((byte)0);
    AppMethodBeat.o(300576);
  }
  
  public f()
  {
    AppMethodBeat.i(300568);
    try
    {
      Object localObject1 = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
      s.s(localObject1, "forName(WxRecyclerAdapter_Name)");
      localObject1 = ((Class)localObject1).getDeclaredField("data");
      zEa = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
      s.s(localObject1, "forName(FinderMediaBannerAdapter_Name)");
      localObject1 = ((Class)localObject1).getDeclaredField("feed");
      zEb = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.storage.FeedData");
      s.s(localObject1, "forName(FeedData_Name)");
      Method localMethod = ((Class)localObject1).getDeclaredMethod("getId", new Class[0]);
      zHC = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject1).getDeclaredMethod("getUserName", new Class[0]);
      zHD = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject1).getDeclaredMethod("getNickName", new Class[0]);
      zHE = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("getSessionBuffer", new Class[0]);
      zHF = (Method)localObject1;
      if (localObject1 != null) {
        ((Method)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      s.s(localObject1, "forName(BaseFinderFeed_Name)");
      localObject1 = ((Class)localObject1).getDeclaredField("feedObject");
      zEc = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      s.s(localObject1, "forName(FinderItem_Name)");
      localMethod = ((Class)localObject1).getDeclaredMethod("getId", new Class[0]);
      zEd = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject1).getDeclaredMethod("getUserName", new Class[0]);
      zEe = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject1).getDeclaredMethod("getNickName", new Class[0]);
      zEf = localMethod;
      if (localMethod != null) {
        localMethod.setAccessible(true);
      }
      localMethod = ((Class)localObject1).getDeclaredMethod("getFinderObject", new Class[0]);
      s.s(localMethod, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
      zHG = localMethod;
      localObject1 = localMethod;
      if (localMethod == null)
      {
        s.bIx("getFinderObject_Method");
        localObject1 = null;
      }
      ((Method)localObject1).setAccessible(true);
      localObject1 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("sessionBuffer");
      s.s(localObject1, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
      zHH = (Field)localObject1;
      if (localObject1 == null)
      {
        s.bIx("sessionBuffer_Field");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((Field)localObject1).setAccessible(true);
        AppMethodBeat.o(300568);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("HABBYGE-MALI.LbsParamsCatcher", "reflect crash");
      AppMethodBeat.o(300568);
    }
  }
  
  public final String LH(int paramInt)
  {
    AppMethodBeat.i(300629);
    Object localObject1;
    if (this.zHB != null)
    {
      localObject1 = this.zHB;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label406;
        }
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 == null) {
          break label406;
        }
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          break label285;
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        localObject4 = zEa;
        if (localObject4 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            continue;
          }
          AppMethodBeat.o(300629);
          return null;
          localObject1 = (RecyclerView)((WeakReference)localObject1).get();
          break;
        }
        localObject1 = ((Field)localObject4).get(localObject1);
        continue;
        if (!(localObject1 instanceof ArrayList)) {
          break label278;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label413;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
          break label278;
        }
        localObject1 = ((ArrayList)localObject1).get(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(300629);
          return null;
        }
        localObject4 = zEc;
        if (localObject4 == null)
        {
          localObject1 = null;
          Object localObject5 = zHG;
          localObject4 = localObject5;
          if (localObject5 == null)
          {
            s.bIx("getFinderObject_Method");
            localObject4 = null;
          }
          localObject5 = ((Method)localObject4).invoke(localObject1, new Object[0]);
          localObject4 = zHH;
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("sessionBuffer_Field");
            localObject1 = null;
          }
          localObject1 = ((Field)localObject1).get(localObject5);
          if (localObject1 != null) {
            break label266;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(300629);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFinderObject_Method, e1, crash");
        AppMethodBeat.o(300629);
        return null;
      }
      Object localObject2 = ((Field)localObject4).get(localException1);
      continue;
      label266:
      localObject2 = (String)localObject2;
      AppMethodBeat.o(300629);
      return localObject2;
      label278:
      AppMethodBeat.o(300629);
      return null;
      label285:
      if ((localObject2 instanceof a))
      {
        for (;;)
        {
          try
          {
            localObject4 = zEb;
            if (localObject4 == null)
            {
              localObject2 = null;
              if (localObject2 == null)
              {
                AppMethodBeat.o(300629);
                return null;
              }
            }
            else
            {
              localObject2 = ((Field)localObject4).get(localObject2);
              continue;
            }
            localObject4 = zHF;
            if (localObject4 == null)
            {
              localObject2 = null;
              if (localObject2 != null) {
                break;
              }
              localObject2 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(300629);
              throw ((Throwable)localObject2);
            }
          }
          catch (Exception localException2)
          {
            Log.e("HABBYGE-MALI.LbsParamsCatcher", "getSessionBuffer_Method2, e2, crash");
            AppMethodBeat.o(300629);
            return null;
          }
          localObject3 = ((Method)localObject4).invoke(localException2, new Object[0]);
        }
        Object localObject3 = (String)localObject3;
        AppMethodBeat.o(300629);
        return localObject3;
      }
      AppMethodBeat.o(300629);
      return null;
      label406:
      AppMethodBeat.o(300629);
      return null;
      label413:
      int i = 0;
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(300587);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null) {
        paramView = null;
      }
      for (;;)
      {
        if (paramView == null) {
          break label388;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label388;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label260;
        }
        try
        {
          localObject = zEa;
          if (localObject == null) {}
          for (paramView = null;; paramView = ((Field)localObject).get(paramView))
          {
            if (paramView != null) {
              break label86;
            }
            AppMethodBeat.o(300587);
            return null;
            paramView = (RecyclerView)paramView.get();
            break;
          }
          label86:
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>");
            AppMethodBeat.o(300587);
            throw paramView;
          }
        }
        catch (Exception paramView)
        {
          Log.e("HABBYGE-MALI.LbsParamsCatcher", "_getFeedId, e2, crash");
          AppMethodBeat.o(300587);
          return null;
        }
      }
      paramView = (ArrayList)paramView;
      if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
      {
        AppMethodBeat.o(300587);
        return null;
      }
      paramView = paramView.get(paramInt);
      if (paramView == null)
      {
        AppMethodBeat.o(300587);
        return null;
      }
      Object localObject = zEc;
      if (localObject == null)
      {
        paramView = null;
        localObject = zEd;
        if (localObject != null) {
          break label228;
        }
      }
      label228:
      for (paramView = null;; paramView = ((Method)localObject).invoke(paramView, new Object[0]))
      {
        if (paramView != null) {
          break label241;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(300587);
        throw paramView;
        paramView = ((Field)localObject).get(paramView);
        break;
      }
      label241:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
      AppMethodBeat.o(300587);
      return paramView;
      label260:
      if ((paramView instanceof a))
      {
        for (;;)
        {
          try
          {
            localObject = zEb;
            if (localObject == null)
            {
              paramView = null;
              if (paramView == null)
              {
                AppMethodBeat.o(300587);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zHC;
            if (localObject == null)
            {
              paramView = null;
              if (paramView != null) {
                break;
              }
              paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
              AppMethodBeat.o(300587);
              throw paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.e("HABBYGE-MALI.LbsParamsCatcher", "_getFeedId, e1, crash");
            AppMethodBeat.o(300587);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
        AppMethodBeat.o(300587);
        return paramView;
      }
      AppMethodBeat.o(300587);
      return null;
    }
    label388:
    AppMethodBeat.o(300587);
    return null;
  }
  
  public final String ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(300605);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null)
      {
        paramView = null;
        if (paramView == null) {
          break label385;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label385;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label258;
        }
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = zEa;
        if (localObject == null)
        {
          paramView = null;
          if (paramView != null) {
            continue;
          }
          AppMethodBeat.o(300605);
          return null;
          paramView = (RecyclerView)paramView.get();
          break;
        }
        paramView = ((Field)localObject).get(paramView);
        continue;
        if (!(paramView instanceof ArrayList)) {
          break label250;
        }
        if (((Collection)paramView).isEmpty()) {
          break label393;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
          break label250;
        }
        paramView = ((ArrayList)paramView).get(paramInt);
        if (paramView == null)
        {
          AppMethodBeat.o(300605);
          return null;
        }
        localObject = zEc;
        if (localObject == null)
        {
          paramView = null;
          localObject = zEe;
          if (localObject != null) {
            break label223;
          }
          paramView = null;
          if (paramView != null) {
            break label237;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(300605);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedUserName, e1, crash");
        AppMethodBeat.o(300605);
        return null;
      }
      paramView = ((Field)localObject).get(paramView);
      continue;
      label223:
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      continue;
      label237:
      paramView = (String)paramView;
      AppMethodBeat.o(300605);
      return paramView;
      label250:
      AppMethodBeat.o(300605);
      return null;
      label258:
      if ((paramView instanceof a))
      {
        for (;;)
        {
          try
          {
            localObject = zEb;
            if (localObject == null)
            {
              paramView = null;
              if (paramView == null)
              {
                AppMethodBeat.o(300605);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zHD;
            if (localObject == null)
            {
              paramView = null;
              if (paramView != null) {
                break;
              }
              paramView = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(300605);
              throw paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedUserName, e2, crash");
            AppMethodBeat.o(300605);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        paramView = (String)paramView;
        AppMethodBeat.o(300605);
        return paramView;
      }
      AppMethodBeat.o(300605);
      return null;
      label385:
      AppMethodBeat.o(300605);
      return null;
      label393:
      int i = 0;
    }
  }
  
  public final String al(View paramView, int paramInt)
  {
    AppMethodBeat.i(300615);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null)
      {
        paramView = null;
        if (paramView == null) {
          break label385;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label385;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label258;
        }
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = zEa;
        if (localObject == null)
        {
          paramView = null;
          if (paramView != null) {
            continue;
          }
          AppMethodBeat.o(300615);
          return null;
          paramView = (RecyclerView)paramView.get();
          break;
        }
        paramView = ((Field)localObject).get(paramView);
        continue;
        if (!(paramView instanceof ArrayList)) {
          break label250;
        }
        if (((Collection)paramView).isEmpty()) {
          break label393;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
          break label250;
        }
        paramView = ((ArrayList)paramView).get(paramInt);
        if (paramView == null)
        {
          AppMethodBeat.o(300615);
          return null;
        }
        localObject = zEc;
        if (localObject == null)
        {
          paramView = null;
          localObject = zEf;
          if (localObject != null) {
            break label223;
          }
          paramView = null;
          if (paramView != null) {
            break label237;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(300615);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedNickName, e1, crash");
        AppMethodBeat.o(300615);
        return null;
      }
      paramView = ((Field)localObject).get(paramView);
      continue;
      label223:
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      continue;
      label237:
      paramView = (String)paramView;
      AppMethodBeat.o(300615);
      return paramView;
      label250:
      AppMethodBeat.o(300615);
      return null;
      label258:
      if ((paramView instanceof a))
      {
        for (;;)
        {
          try
          {
            localObject = zEb;
            if (localObject == null)
            {
              paramView = null;
              if (paramView == null)
              {
                AppMethodBeat.o(300615);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zHE;
            if (localObject == null)
            {
              paramView = null;
              if (paramView != null) {
                break;
              }
              paramView = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(300615);
              throw paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.e("HABBYGE-MALI.LbsParamsCatcher", "getFeedNickName, e2, crash");
            AppMethodBeat.o(300615);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        paramView = (String)paramView;
        AppMethodBeat.o(300615);
        return paramView;
      }
      AppMethodBeat.o(300615);
      return null;
      label385:
      AppMethodBeat.o(300615);
      return null;
      label393:
      int i = 0;
    }
  }
  
  public final boolean fh(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(300623);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(300623);
      return;
    }
    if (this.zHB != null)
    {
      localObject = this.zHB;
      if (localObject != null) {
        break label58;
      }
    }
    label58:
    for (Object localObject = null;; localObject = (RecyclerView)((WeakReference)localObject).get())
    {
      if (localObject == null) {
        this.zHB = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(300623);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.f
 * JD-Core Version:    0.7.0.1
 */