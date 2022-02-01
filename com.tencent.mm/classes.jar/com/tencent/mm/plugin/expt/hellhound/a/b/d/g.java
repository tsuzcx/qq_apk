package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "modelRef", "Ljava/lang/ref/WeakReference;", "", "nickname_Field", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final g.a qoQ;
  private Field qkL;
  private WeakReference<RecyclerView> qnp;
  private Method qnq;
  private Field qnr;
  private Field qoB;
  private Field qoK;
  private Field qoL;
  private Field qoO;
  private WeakReference<Object> qoP;
  
  static
  {
    AppMethodBeat.i(195569);
    qoQ = new g.a((byte)0);
    AppMethodBeat.o(195569);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(195568);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI").getDeclaredField("viewCallback");
      k.g(localObject, "viewCallback_Field");
      ((Field)localObject).setAccessible(true);
      paramActivity = ((Field)localObject).get(paramActivity);
      localObject = Class.forName("com.tencent.mm.plugin.finder.feed.FinderProfileUIContract$ProfileViewCallback").getDeclaredMethod("getModel", new Class[0]);
      k.g(localObject, "getModel_Method");
      ((Method)localObject).setAccessible(true);
      this.qoP = new WeakReference(((Method)localObject).invoke(paramActivity, new Object[0]));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore").getDeclaredField("dataList");
      k.g(paramActivity, "DataStore_Class.getDecla…ield(dataList_Field_Name)");
      this.qoO = paramActivity;
      paramActivity = this.qoO;
      if (paramActivity == null) {
        k.aVY("dataList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      k.g(paramActivity, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.qkL = paramActivity;
      paramActivity = this.qkL;
      if (paramActivity == null) {
        k.aVY("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      k.g(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.qnq = paramActivity;
      paramActivity = this.qnq;
      if (paramActivity == null) {
        k.aVY("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      localObject = paramActivity.getDeclaredField("id");
      k.g(localObject, "FinderObject_Class.getDeclaredField(id_Name)");
      this.qoB = ((Field)localObject);
      localObject = this.qoB;
      if (localObject == null) {
        k.aVY("id_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("nickname");
      k.g(localObject, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.qoK = ((Field)localObject);
      localObject = this.qoK;
      if (localObject == null) {
        k.aVY("nickname_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("username");
      k.g(localObject, "FinderObject_Class.getDeclaredField(username_Name)");
      this.qoL = ((Field)localObject);
      localObject = this.qoL;
      if (localObject == null) {
        k.aVY("username_Field");
      }
      ((Field)localObject).setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      k.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.qnr = paramActivity;
      paramActivity = this.qnr;
      if (paramActivity == null) {
        k.aVY("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(195568);
      return;
    }
    catch (Exception paramActivity)
    {
      ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(195568);
    }
  }
  
  private final Object Cu(int paramInt)
  {
    AppMethodBeat.i(195567);
    try
    {
      Object localObject = this.qoO;
      if (localObject == null) {
        k.aVY("dataList_Field");
      }
      WeakReference localWeakReference = this.qoP;
      if (localWeakReference == null) {
        k.aVY("modelRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(195567);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(195567);
    }
  }
  
  public final String Cn(int paramInt)
  {
    AppMethodBeat.i(195566);
    Object localObject1 = Cu(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.qkL;
        if (localObject2 == null) {
          k.aVY("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.qnq;
        if (localObject2 == null) {
          k.aVY("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.qnr;
        if (localObject2 == null) {
          k.aVY("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(195566);
        return localObject1;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "ProfileParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(195566);
        return null;
      }
    }
    AppMethodBeat.o(195566);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(195562);
    paramView = Cu(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.qkL;
        if (localObject == null) {
          k.aVY("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qnq;
        if (localObject == null) {
          k.aVY("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qoB;
        if (localObject == null) {
          k.aVY("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(195562);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedItem crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(195562);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.pb(((Long)paramView).longValue());
      AppMethodBeat.o(195562);
      return paramView;
    }
    AppMethodBeat.o(195562);
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(195563);
    paramView = Cu(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.qkL;
        if (localObject == null) {
          k.aVY("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qnq;
        if (localObject == null) {
          k.aVY("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qoL;
        if (localObject == null) {
          k.aVY("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(195563);
        return paramView;
      }
      catch (Exception paramView)
      {
        ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(195563);
        return null;
      }
    }
    AppMethodBeat.o(195563);
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(195564);
    paramView = Cu(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.qkL;
        if (localObject == null) {
          k.aVY("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qnq;
        if (localObject == null) {
          k.aVY("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qoK;
        if (localObject == null) {
          k.aVY("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(195564);
        return paramView;
      }
      catch (Exception paramView)
      {
        ac.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(195564);
        return null;
      }
    }
    AppMethodBeat.o(195564);
    return null;
  }
  
  public final boolean dS(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(195565);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(195565);
      return;
    }
    if (this.qnp != null)
    {
      localObject = this.qnp;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.qnp = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(195565);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.g
 * JD-Core Version:    0.7.0.1
 */