package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_field", "Ljava/lang/reflect/Field;", "feedLoaderRef", "Ljava/lang/ref/WeakReference;", "", "feedObject_field", "feedObject_item_field", "id_field", "mActivityRef", "nickname_field", "sessionBuffer_field", "username_field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "initParams", "", "isAd", "setRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.ext.a.a.b
{
  public static final g.a zJh;
  private WeakReference<Activity> mActivityRef;
  private Field zJi;
  private WeakReference<Object> zJj;
  private Field zJk;
  private Field zJl;
  private Field zJm;
  private Field zJn;
  private Field zJo;
  private Field zJp;
  
  static
  {
    AppMethodBeat.i(300360);
    zJh = new g.a((byte)0);
    AppMethodBeat.o(300360);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(300320);
    this.mActivityRef = new WeakReference(paramActivity);
    AppMethodBeat.o(300320);
  }
  
  private final Object LQ(int paramInt)
  {
    AppMethodBeat.i(300356);
    if (dLc()) {}
    label135:
    label142:
    for (;;)
    {
      try
      {
        Object localObject1 = this.zJi;
        if (localObject1 != null) {
          break label142;
        }
        s.bIx("dataList_field");
        localObject1 = null;
        Object localObject2 = this.zJj;
        if (localObject2 == null)
        {
          localObject2 = null;
          localObject1 = ((Field)localObject1).get(localObject2);
          if (!(localObject1 instanceof ArrayList)) {
            break label135;
          }
          if (!((Collection)localObject1).isEmpty())
          {
            i = 1;
            if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject1).size())) {
              break label135;
            }
            localObject1 = ((ArrayList)localObject1).get(paramInt);
            AppMethodBeat.o(300356);
            return localObject1;
          }
        }
        else
        {
          localObject2 = ((WeakReference)localObject2).get();
          continue;
        }
        int i = 0;
        continue;
        AppMethodBeat.o(300356);
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("getfeedItem, reflect exception: ", localException.getMessage()));
      }
      return null;
    }
  }
  
  private final boolean dLc()
  {
    AppMethodBeat.i(300345);
    if (this.zJj != null)
    {
      localObject1 = this.zJj;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 != null; localObject1 = ((WeakReference)localObject1).get())
      {
        AppMethodBeat.o(300345);
        return true;
      }
    }
    if (this.mActivityRef != null)
    {
      localObject1 = this.mActivityRef;
      if (localObject1 != null) {
        break label71;
      }
    }
    label71:
    for (Object localObject1 = null; localObject1 == null; localObject1 = (Activity)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(300345);
      return false;
    }
    for (;;)
    {
      try
      {
        localObject3 = Class.forName("com.tencent.mm.ui.component.UIComponentActivity").getDeclaredField("mainUIC");
        ((Field)localObject3).setAccessible(true);
        localObject1 = this.mActivityRef;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC").getDeclaredField("tabProvider");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          localObject3 = Class.forName("com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider").getDeclaredField("fragments");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          if (localObject1 != null) {
            break;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<*>");
          AppMethodBeat.o(300345);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("init, reflect exception: ", localException.getMessage()));
        AppMethodBeat.o(300345);
        return false;
      }
      localObject2 = (Activity)localException.get();
    }
    Object localObject3 = (LinkedList)localObject2;
    Object localObject2 = Class.forName("com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment");
    Object localObject4 = ((LinkedList)localObject3).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject3 = ((Iterator)localObject4).next();
      if (((Class)localObject2).isInstance(localObject3))
      {
        localObject2 = Class.forName("com.tencent.mm.ui.component.UIComponentFragment").getDeclaredField("mainUIC");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject3);
        localObject3 = Class.forName("com.tencent.mm.plugin.finder.profile.uic.FinderProfileFeedUIC").getDeclaredMethod("getFeedLoader", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        this.zJj = new WeakReference(((Method)localObject3).invoke(localObject2, new Object[0]));
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore").getDeclaredField("dataList");
        s.s(localObject2, "DataStore_Class.getDecla…ield(dataList_field_name)");
        this.zJi = ((Field)localObject2);
        localObject3 = this.zJi;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("dataList_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
        s.s(localObject2, "BaseFinderFeed_Class.get…ld(feedObject_field_name)");
        this.zJk = ((Field)localObject2);
        localObject3 = this.zJk;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("feedObject_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredField("feedObject");
        s.s(localObject2, "finderItem_Class.getDecl…bject_field_name_of_item)");
        this.zJl = ((Field)localObject2);
        localObject3 = this.zJl;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("feedObject_item_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject4 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
        localObject2 = ((Class)localObject4).getDeclaredField("id");
        s.s(localObject2, "FinderObject_NAME.getDeclaredField(id_field_name)");
        this.zJm = ((Field)localObject2);
        localObject3 = this.zJm;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("id_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Class)localObject4).getDeclaredField("username");
        s.s(localObject2, "FinderObject_NAME.getDec…ield(username_field_name)");
        this.zJo = ((Field)localObject2);
        localObject3 = this.zJo;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("username_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Class)localObject4).getDeclaredField("nickname");
        s.s(localObject2, "FinderObject_NAME.getDec…ield(nickname_field_name)");
        this.zJn = ((Field)localObject2);
        localObject3 = this.zJn;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("nickname_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Class)localObject4).getDeclaredField("sessionBuffer");
        s.s(localObject2, "FinderObject_NAME.getDec…sessionBuffer_field_name)");
        this.zJp = ((Field)localObject2);
        localObject3 = this.zJp;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("sessionBuffer_field");
          localObject2 = null;
        }
        ((Field)localObject2).setAccessible(true);
      }
    }
    AppMethodBeat.o(300345);
    return true;
  }
  
  public final String LH(int paramInt)
  {
    AppMethodBeat.i(300412);
    Object localObject2 = LQ(paramInt);
    if (localObject2 != null) {
      try
      {
        Field localField = this.zJk;
        Object localObject1 = localField;
        if (localField == null)
        {
          s.bIx("feedObject_field");
          localObject1 = null;
        }
        localObject2 = ((Field)localObject1).get(localObject2);
        localField = this.zJl;
        localObject1 = localField;
        if (localField == null)
        {
          s.bIx("feedObject_item_field");
          localObject1 = null;
        }
        localObject2 = ((Field)localObject1).get(localObject2);
        localField = this.zJp;
        localObject1 = localField;
        if (localField == null)
        {
          s.bIx("sessionBuffer_field");
          localObject1 = null;
        }
        localObject1 = ((Field)localObject1).get(localObject2);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          AppMethodBeat.o(300412);
          return localObject1;
        }
        AppMethodBeat.o(300412);
        return null;
      }
      catch (Exception localException)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("ProfileParamsCatcher, getSessionBuffer crash: ", localException.getMessage()));
        AppMethodBeat.o(300412);
        return null;
      }
    }
    AppMethodBeat.o(300412);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(300368);
    Object localObject = LQ(paramInt);
    if (localObject != null)
    {
      try
      {
        Field localField = this.zJk;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJl;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_item_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJm;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("id_field");
          paramView = null;
        }
        paramView = paramView.get(localObject);
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(300368);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("ProfileParamsCatcher, getFeedItem crash: ", paramView.getMessage()));
        AppMethodBeat.o(300368);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
      AppMethodBeat.o(300368);
      return paramView;
    }
    AppMethodBeat.o(300368);
    return null;
  }
  
  public final String ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(300383);
    Object localObject = LQ(paramInt);
    if (localObject != null) {
      try
      {
        Field localField = this.zJk;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJl;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_item_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJo;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("username_field");
          paramView = null;
        }
        paramView = paramView.get(localObject);
        if ((paramView instanceof String))
        {
          paramView = (String)paramView;
          AppMethodBeat.o(300383);
          return paramView;
        }
        AppMethodBeat.o(300383);
        return null;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("ProfileParamsCatcher, getFeedUserName crash: ", paramView.getMessage()));
        AppMethodBeat.o(300383);
        return null;
      }
    }
    AppMethodBeat.o(300383);
    return null;
  }
  
  public final String al(View paramView, int paramInt)
  {
    AppMethodBeat.i(300393);
    Object localObject = LQ(paramInt);
    if (localObject != null) {
      try
      {
        Field localField = this.zJk;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJl;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("feedObject_item_field");
          paramView = null;
        }
        localObject = paramView.get(localObject);
        localField = this.zJn;
        paramView = localField;
        if (localField == null)
        {
          s.bIx("nickname_field");
          paramView = null;
        }
        paramView = paramView.get(localObject);
        if ((paramView instanceof String))
        {
          paramView = (String)paramView;
          AppMethodBeat.o(300393);
          return paramView;
        }
        AppMethodBeat.o(300393);
        return null;
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.ProfileParamsCatcher", s.X("ProfileParamsCatcher, getFeedNickName crash: ", paramView.getMessage()));
        AppMethodBeat.o(300393);
        return null;
      }
    }
    AppMethodBeat.o(300393);
    return null;
  }
  
  public final boolean fh(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.g
 * JD-Core Version:    0.7.0.1
 */