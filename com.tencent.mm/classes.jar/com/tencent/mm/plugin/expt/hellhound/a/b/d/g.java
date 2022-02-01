package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_field", "Ljava/lang/reflect/Field;", "feedLoaderRef", "Ljava/lang/ref/WeakReference;", "", "feedObject_field", "feedObject_item_field", "id_field", "mActivityRef", "nickname_field", "sessionBuffer_field", "username_field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "initParams", "", "isAd", "setRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-expt_release"})
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a sHr;
  private WeakReference<Activity> mActivityRef;
  private Field sHj;
  private WeakReference<Object> sHk;
  private Field sHl;
  private Field sHm;
  private Field sHn;
  private Field sHo;
  private Field sHp;
  private Field sHq;
  
  static
  {
    AppMethodBeat.i(221090);
    sHr = new a((byte)0);
    AppMethodBeat.o(221090);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(221089);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(221089);
  }
  
  private final Object Hh(int paramInt)
  {
    AppMethodBeat.i(221088);
    if (cPt()) {
      try
      {
        Field localField = this.sHj;
        if (localField == null) {
          p.btv("dataList_field");
        }
        Object localObject = this.sHk;
        if (localObject != null)
        {
          localObject = ((WeakReference)localObject).get();
          localObject = localField.get(localObject);
          if (!(localObject instanceof ArrayList)) {
            break label140;
          }
          if (((Collection)localObject).isEmpty()) {
            break label110;
          }
        }
        label110:
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject).size())) {
            break label140;
          }
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(221088);
          return localObject;
          localObject = null;
          break;
        }
        AppMethodBeat.o(221088);
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "getfeedItem, reflect exception: " + localException.getMessage());
      }
    }
    label140:
    return null;
  }
  
  private final boolean cPt()
  {
    AppMethodBeat.i(221083);
    if (this.sHk != null)
    {
      localObject1 = this.sHk;
      if (localObject1 != null) {}
      for (localObject1 = ((WeakReference)localObject1).get(); localObject1 != null; localObject1 = null)
      {
        AppMethodBeat.o(221083);
        return true;
      }
    }
    if (this.mActivityRef != null)
    {
      localObject1 = this.mActivityRef;
      if (localObject1 == null) {
        break label77;
      }
    }
    label77:
    for (Object localObject1 = (Activity)((WeakReference)localObject1).get(); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(221083);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("com.tencent.mm.ui.component.UIComponentActivity");
        p.g(localObject1, "Class.forName(ACTIVITY_BASE_NAME)");
        localObject3 = ((Class)localObject1).getDeclaredField("mainUIC");
        p.g(localObject3, "UIComponentActivity_Clas…Field(mainUIC_field_name)");
        ((Field)localObject3).setAccessible(true);
        localObject1 = this.mActivityRef;
        if (localObject1 != null)
        {
          localObject1 = (Activity)((WeakReference)localObject1).get();
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC");
          p.g(localObject3, "Class.forName(FinderTabUIC_NAME)");
          localObject3 = ((Class)localObject3).getDeclaredField("tabProvider");
          p.g(localObject3, "FinderTabUIC_Class.getDe…d(tabProvider_field_name)");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider");
          p.g(localObject3, "Class.forName(FinderTabProvider_NAME)");
          localObject3 = ((Class)localObject3).getDeclaredField("fragments");
          p.g(localObject3, "FinderTabProvider_Class.…eld(fragments_field_name)");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          if (localObject1 != null) {
            break;
          }
          localObject1 = new t("null cannot be cast to non-null type java.util.LinkedList<*>");
          AppMethodBeat.o(221083);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "init, reflect exception: " + localException.getMessage());
        AppMethodBeat.o(221083);
        return false;
      }
      localObject2 = null;
    }
    Object localObject2 = (LinkedList)localObject2;
    Object localObject3 = Class.forName("com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment");
    p.g(localObject3, "Class.forName(FinderProfileFeedFragment_NAME)");
    Iterator localIterator = ((LinkedList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      if (((Class)localObject3).isInstance(localObject2))
      {
        localObject3 = Class.forName("com.tencent.mm.ui.component.UIComponentFragment");
        p.g(localObject3, "Class.forName(COMPONENT_BASE_NAME)");
        localObject3 = ((Class)localObject3).getDeclaredField("mainUIC");
        p.g(localObject3, "COMPONENT_Class.getDecla…(mainUIC_frag_field_name)");
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Field)localObject3).get(localObject2);
        localObject3 = Class.forName("com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC");
        p.g(localObject3, "Class.forName(FinderProfileFeedUIC_NAME)");
        localObject3 = ((Class)localObject3).getDeclaredMethod("getFeedLoader", new Class[0]);
        p.g(localObject3, "FinderProfileFeedUIC_Cla…d(feedLoader_method_name)");
        ((Method)localObject3).setAccessible(true);
        this.sHk = new WeakReference(((Method)localObject3).invoke(localObject2, new Object[0]));
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore");
        p.g(localObject2, "Class.forName(DataStore_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("dataList");
        p.g(localObject2, "DataStore_Class.getDecla…ield(dataList_field_name)");
        this.sHj = ((Field)localObject2);
        localObject2 = this.sHj;
        if (localObject2 == null) {
          p.btv("dataList_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        p.g(localObject2, "Class.forName(BaseFinderFeed_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("feedObject");
        p.g(localObject2, "BaseFinderFeed_Class.get…ld(feedObject_field_name)");
        this.sHl = ((Field)localObject2);
        localObject2 = this.sHl;
        if (localObject2 == null) {
          p.btv("feedObject_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
        p.g(localObject2, "Class.forName(FinderItem_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("feedObject");
        p.g(localObject2, "finderItem_Class.getDecl…bject_field_name_of_item)");
        this.sHm = ((Field)localObject2);
        localObject2 = this.sHm;
        if (localObject2 == null) {
          p.btv("feedObject_item_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
        p.g(localObject2, "Class.forName(FeedObject_NAME)");
        localObject3 = ((Class)localObject2).getDeclaredField("id");
        p.g(localObject3, "FinderObject_NAME.getDeclaredField(id_field_name)");
        this.sHn = ((Field)localObject3);
        localObject3 = this.sHn;
        if (localObject3 == null) {
          p.btv("id_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((Class)localObject2).getDeclaredField("username");
        p.g(localObject3, "FinderObject_NAME.getDec…ield(username_field_name)");
        this.sHp = ((Field)localObject3);
        localObject3 = this.sHp;
        if (localObject3 == null) {
          p.btv("username_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((Class)localObject2).getDeclaredField("nickname");
        p.g(localObject3, "FinderObject_NAME.getDec…ield(nickname_field_name)");
        this.sHo = ((Field)localObject3);
        localObject3 = this.sHo;
        if (localObject3 == null) {
          p.btv("nickname_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Class)localObject2).getDeclaredField("sessionBuffer");
        p.g(localObject2, "FinderObject_NAME.getDec…sessionBuffer_field_name)");
        this.sHq = ((Field)localObject2);
        localObject2 = this.sHq;
        if (localObject2 == null) {
          p.btv("sessionBuffer_field");
        }
        ((Field)localObject2).setAccessible(true);
      }
    }
    AppMethodBeat.o(221083);
    return true;
  }
  
  public final String GY(int paramInt)
  {
    AppMethodBeat.i(221087);
    Object localObject1 = Hh(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.sHl;
        if (localObject2 == null) {
          p.btv("feedObject_field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.sHm;
        if (localObject2 == null) {
          p.btv("feedObject_item_field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.sHq;
        if (localObject2 == null) {
          p.btv("sessionBuffer_field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(221087);
        return localObject1;
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getSessionBuffer crash: " + localException.getMessage());
        AppMethodBeat.o(221087);
        return null;
      }
    }
    AppMethodBeat.o(221087);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(221084);
    paramView = Hh(paramInt);
    if (paramView != null)
    {
      try
      {
        Field localField = this.sHl;
        if (localField == null) {
          p.btv("feedObject_field");
        }
        paramView = localField.get(paramView);
        localField = this.sHm;
        if (localField == null) {
          p.btv("feedObject_item_field");
        }
        paramView = localField.get(paramView);
        localField = this.sHn;
        if (localField == null) {
          p.btv("id_field");
        }
        paramView = localField.get(paramView);
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(221084);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedItem crash: " + paramView.getMessage());
        AppMethodBeat.o(221084);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)paramView).longValue());
      AppMethodBeat.o(221084);
      return paramView;
    }
    AppMethodBeat.o(221084);
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(221085);
    paramView = Hh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.sHl;
        if (localObject == null) {
          p.btv("feedObject_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sHm;
        if (localObject == null) {
          p.btv("feedObject_item_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sHp;
        if (localObject == null) {
          p.btv("username_field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(221085);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedUserName crash: " + paramView.getMessage());
        AppMethodBeat.o(221085);
        return null;
      }
    }
    AppMethodBeat.o(221085);
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(221086);
    paramView = Hh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.sHl;
        if (localObject == null) {
          p.btv("feedObject_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sHm;
        if (localObject == null) {
          p.btv("feedObject_item_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sHo;
        if (localObject == null) {
          p.btv("nickname_field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(221086);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedNickName crash: " + paramView.getMessage());
        AppMethodBeat.o(221086);
        return null;
      }
    }
    AppMethodBeat.o(221086);
    return null;
  }
  
  public final boolean dP(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher$Companion;", "", "()V", "ACTIVITY_BASE_NAME", "", "BaseFinderFeed_NAME", "COMPONENT_BASE_NAME", "DataStore_NAME", "FeedObject_NAME", "FinderItem_NAME", "FinderProfileFeedFragment_NAME", "FinderProfileFeedUIC_NAME", "FinderTabProvider_NAME", "FinderTabUIC_NAME", "TAG", "dataList_field_name", "feedLoader_method_name", "feedObject_field_name", "feedObject_field_name_of_item", "fragments_field_name", "id_field_name", "mainUIC_field_name", "mainUIC_frag_field_name", "nickname_field_name", "sessionBuffer_field_name", "tabProvider_field_name", "username_field_name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.g
 * JD-Core Version:    0.7.0.1
 */