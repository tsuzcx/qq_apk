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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class e
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a KIu;
  private WeakReference<RecyclerView> KHb;
  private Method KHc;
  private Field KHd;
  private Field KIj;
  private WeakReference<Object> KIq;
  private Field KIr;
  private Field KIs;
  private Field KIt;
  private Field pFR;
  
  static
  {
    AppMethodBeat.i(205295);
    KIu = new a((byte)0);
    AppMethodBeat.o(205295);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(205294);
    try
    {
      Field localField = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI").getDeclaredField("presenter");
      k.g(localField, "presenter_Field");
      localField.setAccessible(true);
      this.KIq = new WeakReference(localField.get(paramActivity));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter").getDeclaredField("feedList");
      k.g(paramActivity, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
      this.KIr = paramActivity;
      paramActivity = this.KIr;
      if (paramActivity == null) {
        k.aPZ("feedList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      k.g(paramActivity, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
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
      localField = paramActivity.getDeclaredField("id");
      k.g(localField, "FinderObject_Class.getDeclaredField(id_Name)");
      this.KIj = localField;
      localField = this.KIj;
      if (localField == null) {
        k.aPZ("id_Field");
      }
      localField.setAccessible(true);
      localField = paramActivity.getDeclaredField("nickname");
      k.g(localField, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.KIs = localField;
      localField = this.KIs;
      if (localField == null) {
        k.aPZ("nickname_Field");
      }
      localField.setAccessible(true);
      localField = paramActivity.getDeclaredField("username");
      k.g(localField, "FinderObject_Class.getDeclaredField(username_Name)");
      this.KIt = localField;
      localField = this.KIt;
      if (localField == null) {
        k.aPZ("username_Field");
      }
      localField.setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      k.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.KHd = paramActivity;
      paramActivity = this.KHd;
      if (paramActivity == null) {
        k.aPZ("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(205294);
      return;
    }
    catch (Exception paramActivity)
    {
      ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(205294);
    }
  }
  
  private final Object agZ(int paramInt)
  {
    AppMethodBeat.i(205293);
    try
    {
      Object localObject = this.KIr;
      if (localObject == null) {
        k.aPZ("feedList_Field");
      }
      WeakReference localWeakReference = this.KIq;
      if (localWeakReference == null) {
        k.aPZ("presenterRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(205293);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(205293);
    }
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(205288);
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
          AppMethodBeat.o(205288);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedId crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205288);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)paramView).longValue());
      AppMethodBeat.o(205288);
      return paramView;
    }
    AppMethodBeat.o(205288);
    return null;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(205289);
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
        AppMethodBeat.o(205289);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205289);
        return null;
      }
    }
    AppMethodBeat.o(205289);
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(205290);
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
        AppMethodBeat.o(205290);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(205290);
        return null;
      }
    }
    AppMethodBeat.o(205290);
    return null;
  }
  
  public final String agS(int paramInt)
  {
    AppMethodBeat.i(205292);
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
        AppMethodBeat.o(205292);
        return localObject1;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "MixSearchParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(205292);
        return null;
      }
    }
    AppMethodBeat.o(205292);
    return null;
  }
  
  public final boolean dO(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205291);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(205291);
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
      AppMethodBeat.o(205291);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher$Companion;", "", "()V", "ACTIVITY_NAME", "", "BaseFinderFeed_Name", "FinderItem_Name", "FinderMixSearchPresenter_Name", "FinderObject_Name", "HEADER_COUNT", "", "TAG", "feedList_Field_Name", "feedObject_Field_Name", "getFinderObject_Name", "id_Name", "nickname_Name", "presenter_Field_Name", "sessionBuffer_Name", "username_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.e
 * JD-Core Version:    0.7.0.1
 */