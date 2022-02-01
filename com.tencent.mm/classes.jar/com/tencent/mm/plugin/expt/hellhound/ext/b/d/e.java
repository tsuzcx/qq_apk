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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/MixSearchParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "feedList_Field", "Ljava/lang/reflect/Field;", "feedObject_Field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "nickname_Field", "presenterRef", "Ljava/lang/ref/WeakReference;", "", "recyclerViewRef", "Landroidx/recyclerview/widget/RecyclerView;", "sessionBuffer_Field", "username_Field", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedItem", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.plugin.expt.hellhound.ext.a.a.b
{
  public static final e.a zJb;
  private Field zEc;
  private WeakReference<RecyclerView> zHB;
  private Method zHG;
  private Field zHH;
  private Field zIU;
  private WeakReference<Object> zJc;
  private Field zJd;
  private Field zJe;
  private Field zJf;
  
  static
  {
    AppMethodBeat.i(300322);
    zJb = new e.a((byte)0);
    AppMethodBeat.o(300322);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(300309);
    try
    {
      Object localObject2 = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchUI").getDeclaredField("presenter");
      ((Field)localObject2).setAccessible(true);
      this.zJc = new WeakReference(((Field)localObject2).get(paramActivity));
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.search.FinderMixSearchPresenter").getDeclaredField("feedList");
      s.s(paramActivity, "FinderMixSearchPresenter…ield(feedList_Field_Name)");
      this.zJd = paramActivity;
      localObject2 = this.zJd;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedList_Field");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      s.s(paramActivity, "BaseFinderFeed_Class.get…ld(feedObject_Field_Name)");
      this.zEc = paramActivity;
      localObject2 = this.zEc;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedObject_Field");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      paramActivity = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      s.s(paramActivity, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.zHG = paramActivity;
      localObject2 = this.zHG;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("getFinderObject_Method");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      paramActivity = localClass.getDeclaredField("id");
      s.s(paramActivity, "FinderObject_Class.getDeclaredField(id_Name)");
      this.zIU = paramActivity;
      localObject2 = this.zIU;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("id_Field");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      paramActivity = localClass.getDeclaredField("nickname");
      s.s(paramActivity, "FinderObject_Class.getDeclaredField(nickname_Name)");
      this.zJe = paramActivity;
      localObject2 = this.zJe;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("nickname_Field");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      paramActivity = localClass.getDeclaredField("username");
      s.s(paramActivity, "FinderObject_Class.getDeclaredField(username_Name)");
      this.zJf = paramActivity;
      localObject2 = this.zJf;
      paramActivity = (Activity)localObject2;
      if (localObject2 == null)
      {
        s.bIx("username_Field");
        paramActivity = null;
      }
      paramActivity.setAccessible(true);
      paramActivity = localClass.getDeclaredField("sessionBuffer");
      s.s(paramActivity, "FinderObject_Class.getDe…Field(sessionBuffer_Name)");
      this.zHH = paramActivity;
      paramActivity = this.zHH;
      if (paramActivity == null)
      {
        s.bIx("sessionBuffer_Field");
        paramActivity = localObject1;
      }
      for (;;)
      {
        paramActivity.setAccessible(true);
        AppMethodBeat.o(300309);
        return;
      }
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramActivity, s.X("init, reflect exception: ", paramActivity.getMessage()), new Object[0]);
      AppMethodBeat.o(300309);
    }
  }
  
  private final Object LQ(int paramInt)
  {
    AppMethodBeat.i(300314);
    try
    {
      Object localObject = this.zJd;
      if (localObject == null)
      {
        s.bIx("feedList_Field");
        localObject = null;
        WeakReference localWeakReference2 = this.zJc;
        WeakReference localWeakReference1 = localWeakReference2;
        if (localWeakReference2 == null)
        {
          s.bIx("presenterRef");
          localWeakReference1 = null;
        }
        localObject = ((Field)localObject).get(localWeakReference1.get());
        if (!(localObject instanceof ArrayList)) {
          break label141;
        }
        if (((Collection)localObject).isEmpty()) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (paramInt < 0) || (paramInt >= ((ArrayList)localObject).size())) {
          break label141;
        }
        localObject = ((ArrayList)localObject).get(paramInt);
        AppMethodBeat.o(300314);
        return localObject;
        break;
      }
      label141:
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, s.X("getfeedItem, reflect exception: ", localException.getMessage()), new Object[0]);
      AppMethodBeat.o(300314);
    }
  }
  
  public final String LH(int paramInt)
  {
    AppMethodBeat.i(300367);
    Object localObject3 = LQ(paramInt);
    if (localObject3 != null) {
      try
      {
        Object localObject2 = this.zEc;
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObject_Field");
          localObject1 = null;
        }
        localObject3 = ((Field)localObject1).get(localObject3);
        localObject2 = this.zHG;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("getFinderObject_Method");
          localObject1 = null;
        }
        localObject3 = ((Method)localObject1).invoke(localObject3, new Object[0]);
        localObject2 = this.zHH;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("sessionBuffer_Field");
          localObject1 = null;
        }
        localObject1 = ((Field)localObject1).get(localObject3);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          AppMethodBeat.o(300367);
          return localObject1;
        }
        AppMethodBeat.o(300367);
        return null;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)localException, s.X("MixSearchParamsCatcher, getSessionBuffer crash: ", localException.getMessage()), new Object[0]);
        AppMethodBeat.o(300367);
        return null;
      }
    }
    AppMethodBeat.o(300367);
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    paramPInt1.value = 0;
    paramPInt2.value = 0;
  }
  
  public final String aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(300329);
    Object localObject2 = LQ(paramInt);
    if (localObject2 != null)
    {
      try
      {
        Object localObject1 = this.zEc;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("feedObject_Field");
          paramView = null;
        }
        localObject2 = paramView.get(localObject2);
        localObject1 = this.zHG;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("getFinderObject_Method");
          paramView = null;
        }
        localObject2 = paramView.invoke(localObject2, new Object[0]);
        localObject1 = this.zIU;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("id_Field");
          paramView = null;
        }
        paramView = paramView.get(localObject2);
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(300329);
          throw paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, s.X("MixSearchParamsCatcher, getFeedId crash: ", paramView.getMessage()), new Object[0]);
        AppMethodBeat.o(300329);
        return null;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramView).longValue());
      AppMethodBeat.o(300329);
      return paramView;
    }
    AppMethodBeat.o(300329);
    return null;
  }
  
  public final String ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(300343);
    Object localObject2 = LQ(paramInt);
    if (localObject2 != null) {
      try
      {
        Object localObject1 = this.zEc;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("feedObject_Field");
          paramView = null;
        }
        localObject2 = paramView.get(localObject2);
        localObject1 = this.zHG;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("getFinderObject_Method");
          paramView = null;
        }
        localObject2 = paramView.invoke(localObject2, new Object[0]);
        localObject1 = this.zJf;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("username_Field");
          paramView = null;
        }
        paramView = paramView.get(localObject2);
        if ((paramView instanceof String))
        {
          paramView = (String)paramView;
          AppMethodBeat.o(300343);
          return paramView;
        }
        AppMethodBeat.o(300343);
        return null;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, s.X("MixSearchParamsCatcher, getFeedUserName crash: ", paramView.getMessage()), new Object[0]);
        AppMethodBeat.o(300343);
        return null;
      }
    }
    AppMethodBeat.o(300343);
    return null;
  }
  
  public final String al(View paramView, int paramInt)
  {
    AppMethodBeat.i(300350);
    Object localObject2 = LQ(paramInt);
    if (localObject2 != null) {
      try
      {
        Object localObject1 = this.zEc;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("feedObject_Field");
          paramView = null;
        }
        localObject2 = paramView.get(localObject2);
        localObject1 = this.zHG;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("getFinderObject_Method");
          paramView = null;
        }
        localObject2 = paramView.invoke(localObject2, new Object[0]);
        localObject1 = this.zJe;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          s.bIx("nickname_Field");
          paramView = null;
        }
        paramView = paramView.get(localObject2);
        if ((paramView instanceof String))
        {
          paramView = (String)paramView;
          AppMethodBeat.o(300350);
          return paramView;
        }
        AppMethodBeat.o(300350);
        return null;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.MixSearchParamsCatcher", (Throwable)paramView, s.X("MixSearchParamsCatcher, getFeedNickName crash: ", paramView.getMessage()), new Object[0]);
        AppMethodBeat.o(300350);
        return null;
      }
    }
    AppMethodBeat.o(300350);
    return null;
  }
  
  public final boolean fh(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(300361);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(300361);
      return;
    }
    if (this.zHB != null)
    {
      localObject = this.zHB;
      if (localObject != null) {
        break label58;
      }
    }
    label58:
    for (Object localObject = null;; localObject = (RecyclerView)((WeakReference)localObject).get())
    {
      if (localObject == null) {
        this.zHB = new WeakReference(paramRecyclerView);
      }
      AppMethodBeat.o(300361);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.e
 * JD-Core Version:    0.7.0.1
 */