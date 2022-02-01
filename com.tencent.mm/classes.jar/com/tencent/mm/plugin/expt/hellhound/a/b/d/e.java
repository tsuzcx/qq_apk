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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class e
  implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b
{
  public static final a wnc;
  private Field whZ;
  private Method wlA;
  private Field wlB;
  private WeakReference<RecyclerView> wlv;
  private Field wmP;
  private WeakReference<Object> wmY;
  private Field wmZ;
  private Field wna;
  private Field wnb;
  
  static
  {
    AppMethodBeat.i(252079);
    wnc = new a((byte)0);
    AppMethodBeat.o(252079);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(252078);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI");
      p.j(localObject, "Class.forName(ACTIVITY_NAME)");
      localObject = ((Class)localObject).getDeclaredField("presenter");
      p.j(localObject, "FinderMixSearchUI_Class.…eld(presenter_Field_Name)");
      ((Field)localObject).setAccessible(true);
      this.wmY = new WeakReference(((Field)localObject).get(paramActivity));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter");
      p.j(paramActivity, "Class.forName(FinderMixSearchPresenter_Name)");
      paramActivity = paramActivity.getDeclaredField("feedList");
      p.j(paramActivity, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
      this.wmZ = paramActivity;
      paramActivity = this.wmZ;
      if (paramActivity == null) {
        p.bGy("feedList_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.j(paramActivity, "Class.forName(BaseFinderFeed_Name)");
      paramActivity = paramActivity.getDeclaredField("feedObject");
      p.j(paramActivity, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
      this.whZ = paramActivity;
      paramActivity = this.whZ;
      if (paramActivity == null) {
        p.bGy("feedObject_Field");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.j(paramActivity, "Class.forName(FinderItem_Name)");
      paramActivity = paramActivity.getDeclaredMethod("getFinderObject", new Class[0]);
      p.j(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.wlA = paramActivity;
      paramActivity = this.wlA;
      if (paramActivity == null) {
        p.bGy("getFinderObject_Method");
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.j(paramActivity, "Class.forName(FinderObject_Name)");
      localObject = paramActivity.getDeclaredField("id");
      p.j(localObject, "FinderObject_Class.getDeclaredField(id_Name)");
      this.wmP = ((Field)localObject);
      localObject = this.wmP;
      if (localObject == null) {
        p.bGy("id_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("nickname");
      p.j(localObject, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.wna = ((Field)localObject);
      localObject = this.wna;
      if (localObject == null) {
        p.bGy("nickname_Field");
      }
      ((Field)localObject).setAccessible(true);
      localObject = paramActivity.getDeclaredField("username");
      p.j(localObject, "FinderObject_Class.getDeclaredField(username_Name)");
      this.wnb = ((Field)localObject);
      localObject = this.wnb;
      if (localObject == null) {
        p.bGy("username_Field");
      }
      ((Field)localObject).setAccessible(true);
      paramActivity = paramActivity.getDeclaredField("sessionBuffer");
      p.j(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.wlB = paramActivity;
      paramActivity = this.wlB;
      if (paramActivity == null) {
        p.bGy("sessionBuffer_Field");
      }
      paramActivity.setAccessible(true);
      AppMethodBeat.o(252078);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramActivity, "init, reflect exception: " + paramActivity.getMessage(), new Object[0]);
      AppMethodBeat.o(252078);
    }
  }
  
  private final Object KR(int paramInt)
  {
    AppMethodBeat.i(252076);
    try
    {
      Object localObject = this.wmZ;
      if (localObject == null) {
        p.bGy("feedList_Field");
      }
      WeakReference localWeakReference = this.wmY;
      if (localWeakReference == null) {
        p.bGy("presenterRef");
      }
      localObject = ((Field)localObject).get(localWeakReference.get());
      if ((localObject instanceof ArrayList))
      {
        if (!((Collection)localObject).isEmpty()) {}
        for (int i = 1; (i != 0) && (paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()); i = 0)
        {
          localObject = ((ArrayList)localObject).get(paramInt);
          AppMethodBeat.o(252076);
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "getfeedItem, reflect exception: " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(252076);
    }
  }
  
  public final String KI(int paramInt)
  {
    AppMethodBeat.i(252074);
    Object localObject1 = KR(paramInt);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = this.whZ;
        if (localObject2 == null) {
          p.bGy("feedObject_Field");
        }
        localObject1 = ((Field)localObject2).get(localObject1);
        localObject2 = this.wlA;
        if (localObject2 == null) {
          p.bGy("getFinderObject_Method");
        }
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[0]);
        localObject2 = this.wlB;
        if (localObject2 == null) {
          p.bGy("sessionBuffer_Field");
        }
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = localObject2;
        if (!(localObject2 instanceof String)) {
          localObject1 = null;
        }
        localObject1 = (String)localObject1;
        AppMethodBeat.o(252074);
        return localObject1;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, "MixSearchParamsCatcher, getSessionBuffer crash: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(252074);
        return null;
      }
    }
    AppMethodBeat.o(252074);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(252068);
    paramView = KR(paramInt);
    if (paramView != null)
    {
      try
      {
        Object localObject = this.whZ;
        if (localObject == null) {
          p.bGy("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wlA;
        if (localObject == null) {
          p.bGy("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.wmP;
        if (localObject == null) {
          p.bGy("id_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(252068);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedId crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(252068);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramView).longValue());
      AppMethodBeat.o(252068);
      return paramView;
    }
    AppMethodBeat.o(252068);
    return null;
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(252069);
    paramView = KR(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.whZ;
        if (localObject == null) {
          p.bGy("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wlA;
        if (localObject == null) {
          p.bGy("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.wnb;
        if (localObject == null) {
          p.bGy("username_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(252069);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedUserName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(252069);
        return null;
      }
    }
    AppMethodBeat.o(252069);
    return null;
  }
  
  public final String ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(252070);
    paramView = KR(paramInt);
    if (paramView != null) {
      try
      {
        Object localObject = this.whZ;
        if (localObject == null) {
          p.bGy("feedObject_Field");
        }
        paramView = ((Field)localObject).get(paramView);
        localObject = this.wlA;
        if (localObject == null) {
          p.bGy("getFinderObject_Method");
        }
        paramView = ((Method)localObject).invoke(paramView, new Object[0]);
        localObject = this.wna;
        if (localObject == null) {
          p.bGy("nickname_Field");
        }
        localObject = ((Field)localObject).get(paramView);
        paramView = (View)localObject;
        if (!(localObject instanceof String)) {
          paramView = null;
        }
        paramView = (String)paramView;
        AppMethodBeat.o(252070);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, "MixSearchParamsCatcher, getFeedNickName crash: " + paramView.getMessage(), new Object[0]);
        AppMethodBeat.o(252070);
        return null;
      }
    }
    AppMethodBeat.o(252070);
    return null;
  }
  
  public final boolean en(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(252072);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(252072);
      return;
    }
    if (this.wlv != null)
    {
      localObject = this.wlv;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = (RecyclerView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.wlv = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(252072);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher$Companion;", "", "()V", "ACTIVITY_NAME", "", "BaseFinderFeed_Name", "FinderItem_Name", "FinderMixSearchPresenter_Name", "FinderObject_Name", "HEADER_COUNT", "", "TAG", "feedList_Field_Name", "feedObject_Field_Name", "getFinderObject_Name", "id_Name", "nickname_Name", "presenter_Field_Name", "sessionBuffer_Name", "username_Name", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.e
 * JD-Core Version:    0.7.0.1
 */