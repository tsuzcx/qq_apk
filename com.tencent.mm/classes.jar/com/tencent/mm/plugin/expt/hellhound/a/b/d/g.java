package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "modelRef", "Ljava/lang/ref/WeakReference;", "", "nickname_Field", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a KIy;
  private WeakReference<RecyclerView> KHb;
  private Method KHc;
  private Field KHd;
  private Field KIj;
  private Field KIs;
  private Field KIt;
  private Field KIw;
  private WeakReference<Object> KIx;
  private Field pFR;
  
  static
  {
    AppMethodBeat.i(205310);
    KIy = new a((byte)0);
    AppMethodBeat.o(205310);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(205309);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI").getDeclaredField("viewCallback");
      k.g(localObject, "viewCallback_Field");
      ((Field)localObject).setAccessible(true);
      paramActivity = ((Field)localObject).get(paramActivity);
      localObject = Class.forName("com.tencent.mm.plugin.finder.feed.FinderProfileUIContract$ProfileViewCallback").getDeclaredMethod("getModel", new Class[0]);
      k.g(localObject, "getModel_Method");
      ((Method)localObject).setAccessible(true);
      this.KIx = new WeakReference(((Method)localObject).invoke(paramActivity, new Object[0]));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore").getDeclaredField("dataList");
      k.g(paramActivity, "DataStore_Class.getDecla…ield(dataList_Field_Name)");
      this.KIw = paramActivity;
      paramActivity = this.KIw;
      if (paramActivity == null) {
        k.aPZ("dataList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      k.g(paramActivity, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.pFR = paramActivity;
      paramActivity = this.pFR;
      if (paramActivity == null) {
        k.aPZ("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      k.g(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.KHc = paramActivity;
      paramActivity = this.KHc;
      if (paramActivity == null) {
        k.aPZ("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      localObject = paramActivity.getDeclaredField("id");
      k.g(localObject, "FinderObject_Class.getDeclaredField(id_Name)");
      this.KIj = ((Field)localObject);
      localObject = this.KIj;
      if (localObject == null) {
        k.aPZ("id_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("nickname");
      k.g(localObject, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.KIs = ((Field)localObject);
      localObject = this.KIs;
      if (localObject == null) {
        k.aPZ("nickname_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("username");
      k.g(localObject, "FinderObject_Class.getDeclaredField(username_Name)");
      this.KIt = ((Field)localObject);
      localObject = this.KIt;
      if (localObject == null) {
        k.aPZ("username_Field");
      }
      ((Field)localObject).setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      k.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.KHd = paramActivity;
      paramActivity = this.KHd;
      if (paramActivity == null) {
        k.aPZ("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(205309);
      return;
    }
    catch (Exception paramActivity)
    {
      ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(205309);
    }
  }
  
  private final Object agZ(int paramInt)
  {
    AppMethodBeat.i(205308);
    try
    {
      Object localObject = this.KIw;
      if (localObject == null) {
        k.aPZ("dataList_Field");
      }
      WeakReference localWeakReference = this.KIx;
      if (localWeakReference == null) {
        k.aPZ("modelRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(205308);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(205308);
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(205303);
    paramView = agZ(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.pFR;
        if (localObject == null) {
          k.aPZ("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.KHc;
        if (localObject == null) {
          k.aPZ("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.KIj;
        if (localObject == null) {
          k.aPZ("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(205303);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedItem crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205303);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)paramView).longValue());
      AppMethodBeat.o(205303);
      return paramView;
    }
    AppMethodBeat.o(205303);
    return null;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(205304);
    paramView = agZ(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.pFR;
        if (localObject == null) {
          k.aPZ("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.KHc;
        if (localObject == null) {
          k.aPZ("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.KIt;
        if (localObject == null) {
          k.aPZ("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(205304);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205304);
        return null;
      }
    }
    AppMethodBeat.o(205304);
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(205305);
    paramView = agZ(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.pFR;
        if (localObject == null) {
          k.aPZ("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.KHc;
        if (localObject == null) {
          k.aPZ("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.KIs;
        if (localObject == null) {
          k.aPZ("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(205305);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205305);
        return null;
      }
    }
    AppMethodBeat.o(205305);
    return null;
  }
  
  public final String agS(int paramInt)
  {
    AppMethodBeat.i(205307);
    Object localObject1 = agZ(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.pFR;
        if (localObject2 == null) {
          k.aPZ("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.KHc;
        if (localObject2 == null) {
          k.aPZ("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.KHd;
        if (localObject2 == null) {
          k.aPZ("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(205307);
        return localObject1;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "ProfileParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(205307);
        return null;
      }
    }
    AppMethodBeat.o(205307);
    return null;
  }
  
  public final boolean dO(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205306);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(205306);
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
      AppMethodBeat.o(205306);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher$Companion;", "", "()V", "ACTIVITY_NAME", "", "BaseFinderFeed_Name", "DataStore_Name", "FinderItem_Name", "FinderObject_Name", "ProfileViewCallback_Name", "TAG", "dataList_Field_Name", "feedObject_Name", "getFinderObject_Name", "getModel_Method_Name", "id_Name", "nickname_Name", "sessionBuffer_Name", "username_Name", "viewCallback_Field_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.g
 * JD-Core Version:    0.7.0.1
 */