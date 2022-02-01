package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ProfileParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "dataList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "modelRef", "Ljava/lang/ref/WeakReference;", "", "nickname_Field", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class g
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final g.a rfV;
  private Field rbF;
  private WeakReference<RecyclerView> ren;
  private Method reo;
  private Field rep;
  private Field rfE;
  private Field rfP;
  private Field rfQ;
  private Field rfT;
  private WeakReference<Object> rfU;
  
  static
  {
    AppMethodBeat.i(196598);
    rfV = new g.a((byte)0);
    AppMethodBeat.o(196598);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(196597);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI").getDeclaredField("viewCallback");
      p.g(localObject, "viewCallback_Field");
      ((Field)localObject).setAccessible(true);
      paramActivity = ((Field)localObject).get(paramActivity);
      localObject = Class.forName("com.tencent.mm.plugin.finder.feed.FinderProfileUIContract$ProfileViewCallback").getDeclaredMethod("getModel", new Class[0]);
      p.g(localObject, "getModel_Method");
      ((Method)localObject).setAccessible(true);
      this.rfU = new WeakReference(((Method)localObject).invoke(paramActivity, new Object[0]));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.feed.model.internal.DataStore").getDeclaredField("dataList");
      p.g(paramActivity, "DataStore_Class.getDecla…ield(dataList_Field_Name)");
      this.rfT = paramActivity;
      paramActivity = this.rfT;
      if (paramActivity == null) {
        p.bdF("dataList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      p.g(paramActivity, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.rbF = paramActivity;
      paramActivity = this.rbF;
      if (paramActivity == null) {
        p.bdF("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.reo = paramActivity;
      paramActivity = this.reo;
      if (paramActivity == null) {
        p.bdF("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      localObject = paramActivity.getDeclaredField("id");
      p.g(localObject, "FinderObject_Class.getDeclaredField(id_Name)");
      this.rfE = ((Field)localObject);
      localObject = this.rfE;
      if (localObject == null) {
        p.bdF("id_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("nickname");
      p.g(localObject, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.rfP = ((Field)localObject);
      localObject = this.rfP;
      if (localObject == null) {
        p.bdF("nickname_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("username");
      p.g(localObject, "FinderObject_Class.getDeclaredField(username_Name)");
      this.rfQ = ((Field)localObject);
      localObject = this.rfQ;
      if (localObject == null) {
        p.bdF("username_Field");
      }
      ((Field)localObject).setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      p.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.rep = paramActivity;
      paramActivity = this.rep;
      if (paramActivity == null) {
        p.bdF("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(196597);
      return;
    }
    catch (Exception paramActivity)
    {
      ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(196597);
    }
  }
  
  private final Object Du(int paramInt)
  {
    AppMethodBeat.i(196596);
    try
    {
      Object localObject = this.rfT;
      if (localObject == null) {
        p.bdF("dataList_Field");
      }
      WeakReference localWeakReference = this.rfU;
      if (localWeakReference == null) {
        p.bdF("modelRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(196596);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(196596);
    }
  }
  
  public final String Dn(int paramInt)
  {
    AppMethodBeat.i(196595);
    Object localObject1 = Du(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.rbF;
        if (localObject2 == null) {
          p.bdF("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.reo;
        if (localObject2 == null) {
          p.bdF("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.rep;
        if (localObject2 == null) {
          p.bdF("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(196595);
        return localObject1;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)localException, "ProfileParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(196595);
        return null;
      }
    }
    AppMethodBeat.o(196595);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(196591);
    paramView = Du(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.rbF;
        if (localObject == null) {
          p.bdF("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.reo;
        if (localObject == null) {
          p.bdF("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.rfE;
        if (localObject == null) {
          p.bdF("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(196591);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedItem crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196591);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)paramView).longValue());
      AppMethodBeat.o(196591);
      return paramView;
    }
    AppMethodBeat.o(196591);
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(196592);
    paramView = Du(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.rbF;
        if (localObject == null) {
          p.bdF("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.reo;
        if (localObject == null) {
          p.bdF("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.rfQ;
        if (localObject == null) {
          p.bdF("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(196592);
        return paramView;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196592);
        return null;
      }
    }
    AppMethodBeat.o(196592);
    return null;
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(196593);
    paramView = Du(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.rbF;
        if (localObject == null) {
          p.bdF("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.reo;
        if (localObject == null) {
          p.bdF("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.rfP;
        if (localObject == null) {
          p.bdF("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(196593);
        return paramView;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ProfileParamsCatcher", (Throwable)paramView, "ProfileParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(196593);
        return null;
      }
    }
    AppMethodBeat.o(196593);
    return null;
  }
  
  public final boolean dX(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(196594);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(196594);
      return;
    }
    if (this.ren != null)
    {
      localObject = this.ren;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.ren = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(196594);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.g
 * JD-Core Version:    0.7.0.1
 */