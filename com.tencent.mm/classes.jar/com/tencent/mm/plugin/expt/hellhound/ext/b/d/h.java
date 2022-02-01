package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/TopicParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements com.tencent.mm.plugin.expt.hellhound.ext.a.a.b
{
  private static Field zEa;
  private static Field zEb;
  private static Field zEc;
  private static Method zEd;
  private static Method zEe;
  private static Method zEf;
  private static Method zHG;
  private static Field zHH;
  public static final h.a zJq;
  private WeakReference<RecyclerView> zHB;
  
  static
  {
    AppMethodBeat.i(300334);
    zJq = new h.a((byte)0);
    AppMethodBeat.o(300334);
  }
  
  public h()
  {
    AppMethodBeat.i(300330);
    Log.w("HABBYGE-MALI.TopicParamsCatcher", "TopicParamsCatcher");
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
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      s.s(localObject1, "forName(BaseFinderFeed_Name)");
      localObject1 = ((Class)localObject1).getDeclaredField("feedObject");
      zEc = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      s.s(localObject1, "forName(FinderItem_Name)");
      Method localMethod = ((Class)localObject1).getDeclaredMethod("getId", new Class[0]);
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
        AppMethodBeat.o(300330);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(300330);
    }
  }
  
  public final String LH(int paramInt)
  {
    AppMethodBeat.i(300397);
    Object localObject1;
    RecyclerView.a locala;
    if (this.zHB != null)
    {
      localObject1 = this.zHB;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label420;
        }
        locala = ((RecyclerView)localObject1).getAdapter();
        if (locala == null) {
          break label420;
        }
        if (!(locala instanceof WxRecyclerAdapter)) {
          break label413;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = zEa;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            continue;
          }
          AppMethodBeat.o(300397);
          return null;
          localObject1 = (RecyclerView)((WeakReference)localObject1).get();
          break;
        }
        localObject1 = ((Field)localObject1).get(locala);
        continue;
        if (!(localObject1 instanceof ArrayList)) {
          continue;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label427;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
          continue;
        }
        localObject1 = ((ArrayList)localObject1).get(paramInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(300397);
          return null;
        }
        localObject3 = zEc;
        if (localObject3 != null) {
          continue;
        }
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = zEb;
          if (localObject2 == null)
          {
            localObject2 = null;
            if (localObject2 == null)
            {
              AppMethodBeat.o(300397);
              return null;
              localObject2 = ((Field)localObject3).get(localObject2);
              continue;
              AppMethodBeat.o(300397);
              return null;
              AppMethodBeat.o(300397);
              return null;
            }
          }
          else
          {
            localObject2 = ((Field)localObject2).get(locala);
            continue;
          }
          Object localObject4 = zHG;
          Object localObject3 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("getFinderObject_Method");
            localObject3 = null;
          }
          localObject4 = ((Method)localObject3).invoke(localObject2, new Object[0]);
          localObject3 = zHH;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("sessionBuffer_Field");
            localObject2 = null;
          }
          localObject2 = ((Field)localObject2).get(localObject4);
          if ((localObject2 instanceof String))
          {
            localObject2 = (String)localObject2;
            AppMethodBeat.o(300397);
            return localObject2;
          }
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)localException2, s.X("getSessionBuffer crash: ", localException2.getMessage()), new Object[0]);
          AppMethodBeat.o(300397);
          return null;
        }
        AppMethodBeat.o(300397);
        return null;
      }
      localObject4 = zHG;
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("getFinderObject_Method");
        localObject3 = null;
      }
      localObject4 = ((Method)localObject3).invoke(localObject1, new Object[0]);
      localObject3 = zHH;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("sessionBuffer_Field");
        localObject1 = null;
      }
      localObject1 = ((Field)localObject1).get(localObject4);
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        AppMethodBeat.o(300397);
        return localObject1;
      }
      label413:
      AppMethodBeat.o(300397);
      return null;
      label420:
      AppMethodBeat.o(300397);
      return null;
      label427:
      int i = 0;
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt) {}
  
  public final String aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(300346);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null) {
        paramView = null;
      }
      for (;;)
      {
        if (paramView == null) {
          break label403;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label403;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label265;
        }
        try
        {
          localObject = zEa;
          if (localObject == null) {}
          for (paramView = null;; paramView = ((Field)localObject).get(paramView))
          {
            if (paramView != null) {
              break label84;
            }
            AppMethodBeat.o(300346);
            return null;
            paramView = (RecyclerView)paramView.get();
            break;
          }
          label84:
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>");
            AppMethodBeat.o(300346);
            throw paramView;
          }
        }
        catch (Exception paramView)
        {
          Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("_getFeedId, e2, crash: ", paramView.getMessage()), new Object[0]);
          AppMethodBeat.o(300346);
          return null;
        }
      }
      paramView = (ArrayList)paramView;
      if ((paramView.isEmpty()) || (paramInt < 0) || (paramInt >= paramView.size()))
      {
        AppMethodBeat.o(300346);
        return null;
      }
      paramView = paramView.get(paramInt);
      if (paramView == null)
      {
        AppMethodBeat.o(300346);
        return null;
      }
      Object localObject = zEc;
      if (localObject == null)
      {
        paramView = null;
        localObject = zEd;
        if (localObject != null) {
          break label234;
        }
      }
      label234:
      for (paramView = null;; paramView = ((Method)localObject).invoke(paramView, new Object[0]))
      {
        if (paramView != null) {
          break label247;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(300346);
        throw paramView;
        paramView = ((Field)localObject).get(paramView);
        break;
      }
      label247:
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
      AppMethodBeat.o(300346);
      return paramView;
      label265:
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
                AppMethodBeat.o(300346);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zEd;
            if (localObject == null)
            {
              paramView = null;
              if (paramView != null) {
                break;
              }
              paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
              AppMethodBeat.o(300346);
              throw paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("_getFeedId, e1, crash: ", paramView.getMessage()), new Object[0]);
            AppMethodBeat.o(300346);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
        AppMethodBeat.o(300346);
        return paramView;
      }
      AppMethodBeat.o(300346);
      return null;
    }
    label403:
    AppMethodBeat.o(300346);
    return null;
  }
  
  public final String ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(300362);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null)
      {
        paramView = null;
        if (paramView == null) {
          break label401;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label401;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label266;
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
          AppMethodBeat.o(300362);
          return null;
          paramView = (RecyclerView)paramView.get();
          break;
        }
        paramView = ((Field)localObject).get(paramView);
        continue;
        if (!(paramView instanceof ArrayList)) {
          break label258;
        }
        if (((Collection)paramView).isEmpty()) {
          break label409;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
          break label258;
        }
        paramView = ((ArrayList)paramView).get(paramInt);
        if (paramView == null)
        {
          AppMethodBeat.o(300362);
          return null;
        }
        localObject = zEc;
        if (localObject == null)
        {
          paramView = null;
          localObject = zEe;
          if (localObject != null) {
            break label236;
          }
          paramView = null;
          if (!(paramView instanceof String)) {
            break label250;
          }
          paramView = (String)paramView;
          AppMethodBeat.o(300362);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("getFeedUserName e1: ", paramView.getMessage()), new Object[0]);
        AppMethodBeat.o(300362);
        return null;
      }
      paramView = ((Field)localObject).get(paramView);
      continue;
      label236:
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      continue;
      label250:
      AppMethodBeat.o(300362);
      return null;
      label258:
      AppMethodBeat.o(300362);
      return null;
      label266:
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
                AppMethodBeat.o(300362);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zEe;
            if (localObject == null)
            {
              paramView = null;
              if (!(paramView instanceof String)) {
                break;
              }
              paramView = (String)paramView;
              AppMethodBeat.o(300362);
              return paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("getFeedUserName e2: ", paramView.getMessage()), new Object[0]);
            AppMethodBeat.o(300362);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        AppMethodBeat.o(300362);
        return null;
      }
      AppMethodBeat.o(300362);
      return null;
      label401:
      AppMethodBeat.o(300362);
      return null;
      label409:
      int i = 0;
    }
  }
  
  public final String al(View paramView, int paramInt)
  {
    AppMethodBeat.i(300371);
    if (this.zHB != null)
    {
      paramView = this.zHB;
      if (paramView == null)
      {
        paramView = null;
        if (paramView == null) {
          break label401;
        }
        paramView = paramView.getAdapter();
        if (paramView == null) {
          break label401;
        }
        if (!(paramView instanceof WxRecyclerAdapter)) {
          break label266;
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
          AppMethodBeat.o(300371);
          return null;
          paramView = (RecyclerView)paramView.get();
          break;
        }
        paramView = ((Field)localObject).get(paramView);
        continue;
        if (!(paramView instanceof ArrayList)) {
          break label258;
        }
        if (((Collection)paramView).isEmpty()) {
          break label409;
        }
        i = 1;
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)paramView).size())) {
          break label258;
        }
        paramView = ((ArrayList)paramView).get(paramInt);
        if (paramView == null)
        {
          AppMethodBeat.o(300371);
          return null;
        }
        localObject = zEc;
        if (localObject == null)
        {
          paramView = null;
          localObject = zEf;
          if (localObject != null) {
            break label236;
          }
          paramView = null;
          if (!(paramView instanceof String)) {
            break label250;
          }
          paramView = (String)paramView;
          AppMethodBeat.o(300371);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("getFeedNickName e1: ", paramView.getMessage()), new Object[0]);
        AppMethodBeat.o(300371);
        return null;
      }
      paramView = ((Field)localObject).get(paramView);
      continue;
      label236:
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      continue;
      label250:
      AppMethodBeat.o(300371);
      return null;
      label258:
      AppMethodBeat.o(300371);
      return null;
      label266:
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
                AppMethodBeat.o(300371);
                return null;
              }
            }
            else
            {
              paramView = ((Field)localObject).get(paramView);
              continue;
            }
            localObject = zEf;
            if (localObject == null)
            {
              paramView = null;
              if (!(paramView instanceof String)) {
                break;
              }
              paramView = (String)paramView;
              AppMethodBeat.o(300371);
              return paramView;
            }
          }
          catch (Exception paramView)
          {
            Log.printErrStackTrace("HABBYGE-MALI.TopicParamsCatcher", (Throwable)paramView, s.X("getFeedNickName e2: ", paramView.getMessage()), new Object[0]);
            AppMethodBeat.o(300371);
            return null;
          }
          paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        }
        AppMethodBeat.o(300371);
        return null;
      }
      AppMethodBeat.o(300371);
      return null;
      label401:
      AppMethodBeat.o(300371);
      return null;
      label409:
      int i = 0;
    }
  }
  
  public final boolean fh(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(300382);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(300382);
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
      AppMethodBeat.o(300382);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.h
 * JD-Core Version:    0.7.0.1
 */