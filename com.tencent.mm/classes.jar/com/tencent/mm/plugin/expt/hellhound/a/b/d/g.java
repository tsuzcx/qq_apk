package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_field", "Ljava/lang/reflect/Field;", "feedLoaderRef", "Ljava/lang/ref/WeakReference;", "", "feedObject_field", "feedObject_item_field", "id_field", "mActivityRef", "nickname_field", "sessionBuffer_field", "username_field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "initParams", "", "isAd", "setRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-expt_release"})
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a wnm;
  private WeakReference<Activity> mActivityRef;
  private Field wne;
  private WeakReference<Object> wnf;
  private Field wng;
  private Field wnh;
  private Field wni;
  private Field wnj;
  private Field wnk;
  private Field wnl;
  
  static
  {
    AppMethodBeat.i(251032);
    wnm = new a((byte)0);
    AppMethodBeat.o(251032);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(251030);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(251030);
  }
  
  private final Object KR(int paramInt)
  {
    AppMethodBeat.i(251029);
    if (den()) {
      try
      {
        Field localField = this.wne;
        if (localField == null) {
          p.bGy("dataList_field");
        }
        Object localObject = this.wnf;
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
          AppMethodBeat.o(251029);
          return localObject;
          localObject = null;
          break;
        }
        AppMethodBeat.o(251029);
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "getfeedItem, reflect exception: " + localException.getMessage());
      }
    }
    label140:
    return null;
  }
  
  private final boolean den()
  {
    AppMethodBeat.i(251019);
    if (this.wnf != null)
    {
      localObject1 = this.wnf;
      if (localObject1 != null) {}
      for (localObject1 = ((WeakReference)localObject1).get(); localObject1 != null; localObject1 = null)
      {
        AppMethodBeat.o(251019);
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
      AppMethodBeat.o(251019);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("com.tencent.mm.ui.component.UIComponentActivity");
        p.j(localObject1, "Class.forName(ACTIVITY_BASE_NAME)");
        localObject3 = ((Class)localObject1).getDeclaredField("mainUIC");
        p.j(localObject3, "UIComponentActivity_Clas…Field(mainUIC_field_name)");
        ((Field)localObject3).setAccessible(true);
        localObject1 = this.mActivityRef;
        if (localObject1 != null)
        {
          localObject1 = (Activity)((WeakReference)localObject1).get();
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC");
          p.j(localObject3, "Class.forName(FinderTabUIC_NAME)");
          localObject3 = ((Class)localObject3).getDeclaredField("tabProvider");
          p.j(localObject3, "FinderTabUIC_Class.getDe…d(tabProvider_field_name)");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider");
          p.j(localObject3, "Class.forName(FinderTabProvider_NAME)");
          localObject3 = ((Class)localObject3).getDeclaredField("fragments");
          p.j(localObject3, "FinderTabProvider_Class.…eld(fragments_field_name)");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          if (localObject1 != null) {
            break;
          }
          localObject1 = new t("null cannot be cast to non-null type java.util.LinkedList<*>");
          AppMethodBeat.o(251019);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "init, reflect exception: " + localException.getMessage());
        AppMethodBeat.o(251019);
        return false;
      }
      localObject2 = null;
    }
    Object localObject2 = (LinkedList)localObject2;
    Object localObject3 = Class.forName("com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment");
    p.j(localObject3, "Class.forName(FinderProfileFeedFragment_NAME)");
    Iterator localIterator = ((LinkedList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      if (((Class)localObject3).isInstance(localObject2))
      {
        localObject3 = Class.forName("com.tencent.mm.ui.component.UIComponentFragment");
        p.j(localObject3, "Class.forName(COMPONENT_BASE_NAME)");
        localObject3 = ((Class)localObject3).getDeclaredField("mainUIC");
        p.j(localObject3, "COMPONENT_Class.getDecla…(mainUIC_frag_field_name)");
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Field)localObject3).get(localObject2);
        localObject3 = Class.forName("com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC");
        p.j(localObject3, "Class.forName(FinderProfileFeedUIC_NAME)");
        localObject3 = ((Class)localObject3).getDeclaredMethod("getFeedLoader", new Class[0]);
        p.j(localObject3, "FinderProfileFeedUIC_Cla…d(feedLoader_method_name)");
        ((Method)localObject3).setAccessible(true);
        this.wnf = new WeakReference(((Method)localObject3).invoke(localObject2, new Object[0]));
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore");
        p.j(localObject2, "Class.forName(DataStore_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("dataList");
        p.j(localObject2, "DataStore_Class.getDecla…ield(dataList_field_name)");
        this.wne = ((Field)localObject2);
        localObject2 = this.wne;
        if (localObject2 == null) {
          p.bGy("dataList_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        p.j(localObject2, "Class.forName(BaseFinderFeed_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("feedObject");
        p.j(localObject2, "BaseFinderFeed_Class.get…ld(feedObject_field_name)");
        this.wng = ((Field)localObject2);
        localObject2 = this.wng;
        if (localObject2 == null) {
          p.bGy("feedObject_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
        p.j(localObject2, "Class.forName(FinderItem_NAME)");
        localObject2 = ((Class)localObject2).getDeclaredField("feedObject");
        p.j(localObject2, "finderItem_Class.getDecl…bject_field_name_of_item)");
        this.wnh = ((Field)localObject2);
        localObject2 = this.wnh;
        if (localObject2 == null) {
          p.bGy("feedObject_item_field");
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
        p.j(localObject2, "Class.forName(FeedObject_NAME)");
        localObject3 = ((Class)localObject2).getDeclaredField("id");
        p.j(localObject3, "FinderObject_NAME.getDeclaredField(id_field_name)");
        this.wni = ((Field)localObject3);
        localObject3 = this.wni;
        if (localObject3 == null) {
          p.bGy("id_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((Class)localObject2).getDeclaredField("username");
        p.j(localObject3, "FinderObject_NAME.getDec…ield(username_field_name)");
        this.wnk = ((Field)localObject3);
        localObject3 = this.wnk;
        if (localObject3 == null) {
          p.bGy("username_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject3 = ((Class)localObject2).getDeclaredField("nickname");
        p.j(localObject3, "FinderObject_NAME.getDec…ield(nickname_field_name)");
        this.wnj = ((Field)localObject3);
        localObject3 = this.wnj;
        if (localObject3 == null) {
          p.bGy("nickname_field");
        }
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Class)localObject2).getDeclaredField("sessionBuffer");
        p.j(localObject2, "FinderObject_NAME.getDec…sessionBuffer_field_name)");
        this.wnl = ((Field)localObject2);
        localObject2 = this.wnl;
        if (localObject2 == null) {
          p.bGy("sessionBuffer_field");
        }
        ((Field)localObject2).setAccessible(true);
      }
    }
    AppMethodBeat.o(251019);
    return true;
  }
  
  public final String KI(int paramInt)
  {
    AppMethodBeat.i(251026);
    Object localObject1 = KR(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.wng;
        if (localObject2 == null) {
          p.bGy("feedObject_field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.wnh;
        if (localObject2 == null) {
          p.bGy("feedObject_item_field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.wnl;
        if (localObject2 == null) {
          p.bGy("sessionBuffer_field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(251026);
        return localObject1;
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getSessionBuffer crash: " + localException.getMessage());
        AppMethodBeat.o(251026);
        return null;
      }
    }
    AppMethodBeat.o(251026);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(251021);
    paramView = KR(paramInt);
    if (paramView != null)
    {
      try
      {
        Field localField = this.wng;
        if (localField == null) {
          p.bGy("feedObject_field");
        }
        paramView = localField.get(paramView);
        localField = this.wnh;
        if (localField == null) {
          p.bGy("feedObject_item_field");
        }
        paramView = localField.get(paramView);
        localField = this.wni;
        if (localField == null) {
          p.bGy("id_field");
        }
        paramView = localField.get(paramView);
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(251021);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedItem crash: " + paramView.getMessage());
        AppMethodBeat.o(251021);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
      AppMethodBeat.o(251021);
      return paramView;
    }
    AppMethodBeat.o(251021);
    return null;
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(251024);
    paramView = KR(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.wng;
        if (localObject == null) {
          p.bGy("feedObject_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wnh;
        if (localObject == null) {
          p.bGy("feedObject_item_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wnk;
        if (localObject == null) {
          p.bGy("username_field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(251024);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedUserName crash: " + paramView.getMessage());
        AppMethodBeat.o(251024);
        return null;
      }
    }
    AppMethodBeat.o(251024);
    return null;
  }
  
  public final String ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(251025);
    paramView = KR(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.wng;
        if (localObject == null) {
          p.bGy("feedObject_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wnh;
        if (localObject == null) {
          p.bGy("feedObject_item_field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wnj;
        if (localObject == null) {
          p.bGy("nickname_field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(251025);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", "ProfileParamsCatcher, getFeedNickName crash: " + paramView.getMessage());
        AppMethodBeat.o(251025);
        return null;
      }
    }
    AppMethodBeat.o(251025);
    return null;
  }
  
  public final boolean en(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher$Companion;", "", "()V", "ACTIVITY_BASE_NAME", "", "BaseFinderFeed_NAME", "COMPONENT_BASE_NAME", "DataStore_NAME", "FeedObject_NAME", "FinderItem_NAME", "FinderProfileFeedFragment_NAME", "FinderProfileFeedUIC_NAME", "FinderTabProvider_NAME", "FinderTabUIC_NAME", "TAG", "dataList_field_name", "feedLoader_method_name", "feedObject_field_name", "feedObject_field_name_of_item", "fragments_field_name", "id_field_name", "mainUIC_field_name", "mainUIC_frag_field_name", "nickname_field_name", "sessionBuffer_field_name", "tabProvider_field_name", "username_field_name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.g
 * JD-Core Version:    0.7.0.1
 */