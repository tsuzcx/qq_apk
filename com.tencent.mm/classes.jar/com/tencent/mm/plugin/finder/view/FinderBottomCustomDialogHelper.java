package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper;", "", "()V", "Companion", "UserInfoHelper", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBottomCustomDialogHelper
{
  public static final FinderBottomCustomDialogHelper.Companion Companion;
  private static final String TAG = "FinderBottomCustomDialogHelper";
  
  static
  {
    AppMethodBeat.i(343983);
    Companion = new FinderBottomCustomDialogHelper.Companion(null);
    AppMethodBeat.o(343983);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "username", "", "userInfoContainer", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "getContext", "()Landroid/content/Context;", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getUsername", "()Ljava/lang/String;", "doSceneForUserInfo", "getChangeLeftRegionWidth", "", "text", "getLocationTextWidth", "locationText", "getTotalAvailableWidth", "", "getUserTagText", "userExtInfo", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "handleAuth", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleNickname", "load", "loadInternal", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class UserInfoHelper
    implements com.tencent.mm.am.h
  {
    public static final Companion Companion;
    public static final String TAG = "ProfileHeaderHelper";
    private static final com.tencent.mm.b.h<String, h.c> userExtInfoCache;
    private kotlin.g.a.b<? super Boolean, ah> callback;
    private final Context context;
    private com.tencent.threadpool.i.d<?> dialogRunnable;
    private w loadingDialog;
    private final ViewGroup userInfoContainer;
    private final String username;
    
    static
    {
      AppMethodBeat.i(344129);
      Companion = new Companion(null);
      userExtInfoCache = new com.tencent.mm.b.h(100);
      AppMethodBeat.o(344129);
    }
    
    public UserInfoHelper(Context paramContext, String paramString, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(344007);
      this.context = paramContext;
      this.username = paramString;
      this.userInfoContainer = paramViewGroup;
      this.callback = ((kotlin.g.a.b)FinderBottomCustomDialogHelper.UserInfoHelper.callback.1.INSTANCE);
      AppMethodBeat.o(344007);
    }
    
    private final void doSceneForUserInfo(String paramString)
    {
      AppMethodBeat.i(344013);
      Log.i("ProfileHeaderHelper", kotlin.g.b.s.X("doSceneForUserInfo, username:", paramString));
      Object localObject = this.dialogRunnable;
      if (localObject != null) {
        ((com.tencent.threadpool.i.d)localObject).cancel(false);
      }
      this.dialogRunnable = com.tencent.threadpool.h.ahAA.o(new FinderBottomCustomDialogHelper.UserInfoHelper..ExternalSyntheticLambda0(this), 1500L);
      com.tencent.mm.kernel.h.aZW().a(3736, (com.tencent.mm.am.h)this);
      localObject = com.tencent.mm.kernel.h.aZW();
      paramString = new dt(paramString, 0L, null, 0, null, 0, 0L, false, null, 0L, null, null, null, 8174);
      paramString.ADC = true;
      ah localah = ah.aiuX;
      ((com.tencent.mm.am.s)localObject).a((com.tencent.mm.am.p)paramString, 0);
      AppMethodBeat.o(344013);
    }
    
    private static final void doSceneForUserInfo$lambda-0(UserInfoHelper paramUserInfoHelper)
    {
      AppMethodBeat.i(344114);
      kotlin.g.b.s.u(paramUserInfoHelper, "this$0");
      paramUserInfoHelper.loadingDialog = w.a(paramUserInfoHelper.getContext(), (CharSequence)paramUserInfoHelper.getContext().getString(e.h.loading_tips_1), true, 3, null);
      AppMethodBeat.o(344114);
    }
    
    private final float getChangeLeftRegionWidth(String paramString)
    {
      AppMethodBeat.i(344076);
      if (((ImageView)this.userInfoContainer.findViewById(e.e.finder_profile_auth_icon)).getVisibility() == 0) {}
      for (float f = a.bs(this.userInfoContainer.getContext(), e.c.Edge_2_5_A) + 0.0F;; f = 0.0F)
      {
        AppMethodBeat.o(344076);
        return f;
      }
    }
    
    private final float getLocationTextWidth(String paramString)
    {
      AppMethodBeat.i(344050);
      float f = 0.0F;
      if (!Util.isNullOrNil(paramString)) {
        f = ((TextView)this.userInfoContainer.findViewById(e.e.user_tag_layout)).getPaint().measureText(paramString);
      }
      AppMethodBeat.o(344050);
      return f;
    }
    
    private final int getTotalAvailableWidth()
    {
      AppMethodBeat.i(344087);
      Object localObject = new DisplayMetrics();
      Context localContext = this.userInfoContainer.getContext();
      if (localContext == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(344087);
        throw ((Throwable)localObject);
      }
      ((Activity)localContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      Log.i("ProfileHeaderHelper", kotlin.g.b.s.X("screen width :", Integer.valueOf(((DisplayMetrics)localObject).widthPixels)));
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = a.bs(this.userInfoContainer.getContext(), e.c.finder_12_A);
      AppMethodBeat.o(344087);
      return i - j;
    }
    
    private final String getUserTagText(h.c paramc)
    {
      AppMethodBeat.i(344101);
      Object localObject = paramc.userTags;
      if (!((LinkedList)localObject).isEmpty())
      {
        paramc = new StringBuilder();
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramc.append((String)((Iterator)localObject).next()).append(" ");
        }
        paramc = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)paramc.toString());
        if (paramc != null)
        {
          paramc = paramc.toString();
          kotlin.g.b.s.s(paramc, "this.toString()");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(344101);
        return paramc;
        paramc = "";
      }
    }
    
    private final void handleAuth(m paramm)
    {
      AppMethodBeat.i(344043);
      FinderAuthInfo localFinderAuthInfo;
      if (paramm == null)
      {
        localFinderAuthInfo = null;
        if (localFinderAuthInfo != null) {
          break label58;
        }
        if (paramm == null) {
          break label53;
        }
      }
      label53:
      for (boolean bool = true;; bool = false)
      {
        Log.w("Finder.FinderProfileHeaderUIC", kotlin.g.b.s.X("[handleAuthGenerator] profileContact=", Boolean.valueOf(bool)));
        AppMethodBeat.o(344043);
        return;
        localFinderAuthInfo = paramm.field_authInfo;
        break;
      }
      label58:
      if (localFinderAuthInfo.authIconType <= 0)
      {
        Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
        AppMethodBeat.o(344043);
        return;
      }
      Object localObject = av.GiL;
      localObject = (ImageView)this.userInfoContainer.findViewById(e.e.finder_profile_auth_icon);
      kotlin.g.b.s.s(localObject, "userInfoContainer.finder_profile_auth_icon");
      av.a((ImageView)localObject, localFinderAuthInfo, 0, c.a(paramm, false), 4);
      AppMethodBeat.o(344043);
    }
    
    private final void handleNickname(m paramm, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(344035);
      if (paramm == null)
      {
        AppMethodBeat.o(344035);
        return;
      }
      Object localObject1 = ((LinearLayout)paramViewGroup.findViewById(e.e.finder_profile_name_container)).getLayoutParams();
      if (localObject1 == null)
      {
        paramm = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(344035);
        throw paramm;
      }
      Object localObject2 = (ConstraintLayout.LayoutParams)localObject1;
      TextView localTextView1 = (TextView)paramViewGroup.findViewById(e.e.user_tag_layout);
      TextView localTextView2 = (TextView)paramViewGroup.findViewById(e.e.finder_profile_name_tv);
      localObject1 = (ImageView)paramViewGroup.findViewById(e.e.finder_profile_avatar_btn);
      if (localTextView1.getVisibility() == 4)
      {
        ((ConstraintLayout.LayoutParams)localObject2).blm = -1;
        ((ConstraintLayout.LayoutParams)localObject2).blk = e.e.finder_profile_avatar_container;
      }
      for (((ConstraintLayout.LayoutParams)localObject2).bln = e.e.finder_profile_avatar_container;; ((ConstraintLayout.LayoutParams)localObject2).bln = -1)
      {
        ((LinearLayout)paramViewGroup.findViewById(e.e.finder_profile_name_container)).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        aw.a((Paint)localTextView2.getPaint(), 0.8F);
        paramViewGroup = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.p.eCp();
        paramm = new com.tencent.mm.plugin.finder.loader.b(paramm.field_avatarUrl);
        kotlin.g.b.s.s(localObject1, "userAvatarIv");
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramViewGroup.a(paramm, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        AppMethodBeat.o(344035);
        return;
        ((ConstraintLayout.LayoutParams)localObject2).blm = e.e.finder_profile_avatar_guideline;
        ((ConstraintLayout.LayoutParams)localObject2).blk = -1;
      }
    }
    
    private final void loadInternal()
    {
      AppMethodBeat.i(344024);
      Object localObject = userExtInfoCache.get(this.username);
      kotlin.g.b.s.s(localObject, "userExtInfoCache[username]");
      String str = getUserTagText((h.c)localObject);
      localObject = com.tencent.mm.plugin.finder.api.d.AwY;
      m localm = d.a.auT(this.username);
      Context localContext = this.context;
      int i;
      float f1;
      if (localm == null)
      {
        localObject = null;
        localObject = com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject).toString();
        kotlin.g.b.s.s(localObject, "spanForSmiley(context, f…act?.nickname).toString()");
        i = getTotalAvailableWidth();
        f1 = getChangeLeftRegionWidth((String)localObject);
        float f2 = ((TextView)this.userInfoContainer.findViewById(e.e.finder_profile_name_tv)).getPaint().measureText((String)localObject);
        float f3 = getLocationTextWidth(str);
        if ((f2 + f1 <= i) && (f3 <= i)) {
          break label220;
        }
        setProfileTextWidth((String)localObject, str, i - a.bs(this.userInfoContainer.getContext(), e.c.Edge_2A), (int)f1);
      }
      for (;;)
      {
        handleNickname(localm, this.userInfoContainer);
        handleAuth(localm);
        this.callback.invoke(Boolean.TRUE);
        AppMethodBeat.o(344024);
        return;
        localObject = localm.getNickname();
        break;
        label220:
        setProfileTextWidth((String)localObject, str, i, (int)f1);
      }
    }
    
    private static final void onSceneEnd$lambda-2(UserInfoHelper paramUserInfoHelper)
    {
      AppMethodBeat.i(344121);
      kotlin.g.b.s.u(paramUserInfoHelper, "this$0");
      paramUserInfoHelper.loadInternal();
      AppMethodBeat.o(344121);
    }
    
    private final void setProfileTextWidth(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344058);
      ((TextView)this.userInfoContainer.findViewById(e.e.finder_profile_name_tv)).setMaxWidth(paramInt1 - paramInt2);
      ((TextView)this.userInfoContainer.findViewById(e.e.finder_profile_name_tv)).setText((CharSequence)paramString1);
      ((TextView)this.userInfoContainer.findViewById(e.e.user_tag_layout)).setMaxWidth(paramInt1);
      ((TextView)this.userInfoContainer.findViewById(e.e.user_tag_layout)).setText((CharSequence)paramString2);
      AppMethodBeat.o(344058);
    }
    
    public final Context getContext()
    {
      return this.context;
    }
    
    public final String getUsername()
    {
      return this.username;
    }
    
    public final void load(kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      AppMethodBeat.i(344173);
      kotlin.g.b.s.u(paramb, "callback");
      this.callback = paramb;
      if (!userExtInfoCache.check(this.username))
      {
        doSceneForUserInfo(this.username);
        AppMethodBeat.o(344173);
        return;
      }
      loadInternal();
      AppMethodBeat.o(344173);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(344169);
      paramString = this.loadingDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      paramString = this.dialogRunnable;
      if (paramString != null) {
        paramString.cancel(false);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if ((paramp instanceof dt))
        {
          StringBuilder localStringBuilder = new StringBuilder("username=").append(this.username).append(", scene username=");
          paramString = ((dt)paramp).caK();
          if (paramString != null) {
            break label255;
          }
          paramString = null;
          Log.i("ProfileHeaderHelper", paramString);
          paramString = (h.c)userExtInfoCache.get(this.username);
          if (paramString != null) {
            break label263;
          }
          paramString = new h.c();
          label132:
          paramString.fansCount = ((dt)paramp).fansCount;
          paramString.friendFollowCount = ((dt)paramp).friendFollowCount;
          paramString.aS(new LinkedList((Collection)((dt)paramp).userTags));
          paramString.FeF = ((dt)paramp).dWB();
          paramString.FeL = ((dt)paramp).dWD();
          userExtInfoCache.put(this.username, paramString);
          new MMHandler(Looper.getMainLooper()).postUI(new FinderBottomCustomDialogHelper.UserInfoHelper..ExternalSyntheticLambda1(this));
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aZW().b(3736, (com.tencent.mm.am.h)this);
        AppMethodBeat.o(344169);
        return;
        label255:
        paramString = paramString.username;
        break;
        label263:
        break label132;
        this.callback.invoke(Boolean.FALSE);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper$Companion;", "", "()V", "TAG", "", "userExtInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "getUserExtInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class Companion
    {
      public final com.tencent.mm.b.h<String, h.c> getUserExtInfoCache()
      {
        AppMethodBeat.i(345129);
        com.tencent.mm.b.h localh = FinderBottomCustomDialogHelper.UserInfoHelper.access$getUserExtInfoCache$cp();
        AppMethodBeat.o(345129);
        return localh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper
 * JD-Core Version:    0.7.0.1
 */