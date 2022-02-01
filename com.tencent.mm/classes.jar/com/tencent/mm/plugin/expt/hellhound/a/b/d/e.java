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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroid/support/v7/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class e
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a sHh;
  private Field sCe;
  private WeakReference<RecyclerView> sFA;
  private Method sFF;
  private Field sFG;
  private Field sGU;
  private WeakReference<Object> sHd;
  private Field sHe;
  private Field sHf;
  private Field sHg;
  
  static
  {
    AppMethodBeat.i(221065);
    sHh = new a((byte)0);
    AppMethodBeat.o(221065);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(221064);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI");
      p.g(localObject, "Class.forName(ACTIVITY_NAME)");
      localObject = ((Class)localObject).getDeclaredField("presenter");
      p.g(localObject, "FinderMixSearchUI_Class.…eld(presenter_Field_Name)");
      ((Field)localObject).setAccessible(true);
      this.sHd = new WeakReference(((Field)localObject).get(paramActivity));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter");
      p.g(paramActivity, "Class.forName(FinderMixSearchPresenter_Name)");
      paramActivity = paramActivity.getDeclaredField("feedList");
      p.g(paramActivity, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
      this.sHe = paramActivity;
      paramActivity = this.sHe;
      if (paramActivity == null) {
        p.btv("feedList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.g(paramActivity, "Class.forName(BaseFinderFeed_Name)");
      paramActivity = paramActivity.getDeclaredField("feedObject");
      p.g(paramActivity, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
      this.sCe = paramActivity;
      paramActivity = this.sCe;
      if (paramActivity == null) {
        p.btv("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.g(paramActivity, "Class.forName(FinderItem_Name)");
      paramActivity = paramActivity.getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.sFF = paramActivity;
      paramActivity = this.sFF;
      if (paramActivity == null) {
        p.btv("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.g(paramActivity, "Class.forName(FinderObject_Name)");
      localObject = paramActivity.getDeclaredField("id");
      p.g(localObject, "FinderObject_Class.getDeclaredField(id_Name)");
      this.sGU = ((Field)localObject);
      localObject = this.sGU;
      if (localObject == null) {
        p.btv("id_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("nickname");
      p.g(localObject, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.sHf = ((Field)localObject);
      localObject = this.sHf;
      if (localObject == null) {
        p.btv("nickname_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("username");
      p.g(localObject, "FinderObject_Class.getDeclaredField(username_Name)");
      this.sHg = ((Field)localObject);
      localObject = this.sHg;
      if (localObject == null) {
        p.btv("username_Field");
      }
      ((Field)localObject).setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      p.g(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.sFG = paramActivity;
      paramActivity = this.sFG;
      if (paramActivity == null) {
        p.btv("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(221064);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(221064);
    }
  }
  
  private final Object Hh(int paramInt)
  {
    AppMethodBeat.i(221063);
    try
    {
      Object localObject = this.sHe;
      if (localObject == null) {
        p.btv("feedList_Field");
      }
      WeakReference localWeakReference = this.sHd;
      if (localWeakReference == null) {
        p.btv("presenterRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(221063);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(221063);
    }
  }
  
  public final String GY(int paramInt)
  {
    AppMethodBeat.i(221062);
    Object localObject1 = Hh(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.sCe;
        if (localObject2 == null) {
          p.btv("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.sFF;
        if (localObject2 == null) {
          p.btv("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.sFG;
        if (localObject2 == null) {
          p.btv("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(221062);
        return localObject1;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "MixSearchParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(221062);
        return null;
      }
    }
    AppMethodBeat.o(221062);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(221058);
    paramView = Hh(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.sCe;
        if (localObject == null) {
          p.btv("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sFF;
        if (localObject == null) {
          p.btv("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.sGU;
        if (localObject == null) {
          p.btv("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(221058);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedId crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221058);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)paramView).longValue());
      AppMethodBeat.o(221058);
      return paramView;
    }
    AppMethodBeat.o(221058);
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(221059);
    paramView = Hh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.sCe;
        if (localObject == null) {
          p.btv("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sFF;
        if (localObject == null) {
          p.btv("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.sHg;
        if (localObject == null) {
          p.btv("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(221059);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221059);
        return null;
      }
    }
    AppMethodBeat.o(221059);
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(221060);
    paramView = Hh(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.sCe;
        if (localObject == null) {
          p.btv("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.sFF;
        if (localObject == null) {
          p.btv("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.sHf;
        if (localObject == null) {
          p.btv("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(221060);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(221060);
        return null;
      }
    }
    AppMethodBeat.o(221060);
    return null;
  }
  
  public final boolean dP(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(221061);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(221061);
      return;
    }
    if (this.sFA != null)
    {
      localObject = this.sFA;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.sFA = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(221061);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher$Companion;", "", "()V", "ACTIVITY_NAME", "", "BaseFinderFeed_Name", "FinderItem_Name", "FinderMixSearchPresenter_Name", "FinderObject_Name", "HEADER_COUNT", "", "TAG", "feedList_Field_Name", "feedObject_Field_Name", "getFinderObject_Name", "id_Name", "nickname_Name", "presenter_Field_Name", "sessionBuffer_Name", "username_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.e
 * JD-Core Version:    0.7.0.1
 */