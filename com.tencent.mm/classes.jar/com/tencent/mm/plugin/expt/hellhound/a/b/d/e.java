package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class e
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final e.a qXL;
  private Field qTH;
  private WeakReference<RecyclerView> qWn;
  private Method qWo;
  private Field qWp;
  private WeakReference<Object> qXH;
  private Field qXI;
  private Field qXJ;
  private Field qXK;
  private Field qXy;
  
  static
  {
    AppMethodBeat.i(210902);
    qXL = new e.a((byte)0);
    AppMethodBeat.o(210902);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(210901);
    try
    {
      Field localField = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI").getDeclaredField("presenter");
      p.g(localField, "presenter_Field");
      localField.setAccessible(true);
      this.qXH = new WeakReference(localField.get(paramActivity));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter").getDeclaredField("feedList");
      p.g(paramActivity, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
      this.qXI = paramActivity;
      paramActivity = this.qXI;
      if (paramActivity == null) {
        p.bcb("feedList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      p.g(paramActivity, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
      this.qTH = paramActivity;
      paramActivity = this.qTH;
      if (paramActivity == null) {
        p.bcb("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.qWo = paramActivity;
      paramActivity = this.qWo;
      if (paramActivity == null) {
        p.bcb("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      localField = paramActivity.getDeclaredField("id");
      p.g(localField, "FinderObject_Class.getDeclaredField(id_Name)");
      this.qXy = localField;
      localField = this.qXy;
      if (localField == null) {
        p.bcb("id_Field");
      }
      localField.setAccessible(true);
      localField = paramActivity.getDeclaredField("nickname");
      p.g(localField, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.qXJ = localField;
      localField = this.qXJ;
      if (localField == null) {
        p.bcb("nickname_Field");
      }
      localField.setAccessible(true);
      localField = paramActivity.getDeclaredField("username");
      p.g(localField, "FinderObject_Class.getDeclaredField(username_Name)");
      this.qXK = localField;
      localField = this.qXK;
      if (localField == null) {
        p.bcb("username_Field");
      }
      localField.setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      p.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.qWp = paramActivity;
      paramActivity = this.qWp;
      if (paramActivity == null) {
        p.bcb("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(210901);
      return;
    }
    catch (Exception paramActivity)
    {
      ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(210901);
    }
  }
  
  private final Object Dh(int paramInt)
  {
    AppMethodBeat.i(210900);
    try
    {
      Object localObject = this.qXI;
      if (localObject == null) {
        p.bcb("feedList_Field");
      }
      WeakReference localWeakReference = this.qXH;
      if (localWeakReference == null) {
        p.bcb("presenterRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(210900);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(210900);
    }
  }
  
  public final String Da(int paramInt)
  {
    AppMethodBeat.i(210899);
    Object localObject1 = Dh(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.qTH;
        if (localObject2 == null) {
          p.bcb("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.qWo;
        if (localObject2 == null) {
          p.bcb("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.qWp;
        if (localObject2 == null) {
          p.bcb("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(210899);
        return localObject1;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "MixSearchParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(210899);
        return null;
      }
    }
    AppMethodBeat.o(210899);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(210895);
    paramView = Dh(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.qTH;
        if (localObject == null) {
          p.bcb("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qWo;
        if (localObject == null) {
          p.bcb("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qXy;
        if (localObject == null) {
          p.bcb("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(210895);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedId crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210895);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rc(((Long)paramView).longValue());
      AppMethodBeat.o(210895);
      return paramView;
    }
    AppMethodBeat.o(210895);
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(210896);
    paramView = Dh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.qTH;
        if (localObject == null) {
          p.bcb("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qWo;
        if (localObject == null) {
          p.bcb("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qXK;
        if (localObject == null) {
          p.bcb("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(210896);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210896);
        return null;
      }
    }
    AppMethodBeat.o(210896);
    return null;
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(210897);
    paramView = Dh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.qTH;
        if (localObject == null) {
          p.bcb("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.qWo;
        if (localObject == null) {
          p.bcb("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.qXJ;
        if (localObject == null) {
          p.bcb("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(210897);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(210897);
        return null;
      }
    }
    AppMethodBeat.o(210897);
    return null;
  }
  
  public final boolean dX(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(210898);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(210898);
      return;
    }
    if (this.qWn != null)
    {
      localObject = this.qWn;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.qWn = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(210898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.e
 * JD-Core Version:    0.7.0.1
 */