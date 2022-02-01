package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper;", "", "()V", "Companion", "UserInfoHelper", "plugin-finder_release"})
public final class FinderBottomCustomDialogHelper
{
  public static final Companion Companion;
  private static final String TAG = "FinderBottomCustomDialogHelper";
  
  static
  {
    AppMethodBeat.i(254662);
    Companion = new Companion(null);
    AppMethodBeat.o(254662);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "", "title", "content", "Landroid/view/View;", "ok", "cancel", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "showConfirmMsgDialog", "msg", "showCreateFinderUserDialog", "", "scene", "showRealNameCertificationDialog", "Landroid/app/Activity;", "showUserInfoConfirmDialog", "finderUserName", "plugin-finder_release"})
  public static final class Companion
  {
    public final e showConfirmDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, View paramView, String paramString2, String paramString3, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(254641);
      p.h(paramContext, "context");
      p.h(paramView, "content");
      e locale = new e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, 2131494213, null);
      if (localObject == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(254641);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      ((FrameLayout)((RoundedCornerFrameLayout)localObject).findViewById(2131300797)).addView(paramView);
      paramView = (WeImageView)((RoundedCornerFrameLayout)localObject).findViewById(2131300851);
      if (paramDrawable != null)
      {
        paramView.setImageDrawable(paramDrawable);
        if (paramInt == -1) {
          break label348;
        }
        paramView.setIconColor(paramInt);
      }
      for (;;)
      {
        paramDrawable = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131301498);
        if (!Util.isNullOrNil(paramString1))
        {
          p.g(paramDrawable, "titleTv");
          paramDrawable.setText((CharSequence)paramString1);
        }
        paramDrawable = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131305592);
        if (!Util.isNullOrNil(paramString2))
        {
          p.g(paramDrawable, "okBtn");
          paramDrawable.setText((CharSequence)paramString2);
        }
        paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131297963);
        if (!Util.isNullOrNil(paramString3))
        {
          p.g(paramString1, "cancelBtn");
          paramString1.setText((CharSequence)paramString3);
        }
        ((RoundedCornerFrameLayout)localObject).s(at.fromDPToPix(paramContext, 12), at.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
        paramDrawable.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          private byte _hellAccFlag_;
          
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(254622);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.$dialog.bMo();
            paramAnonymousView = paramOnClickListener1;
            if (paramAnonymousView != null) {
              paramAnonymousView.onClick(null, -1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254622);
          }
        });
        paramString1.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          private byte _hellAccFlag_;
          
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(254623);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.$dialog.bMo();
            paramAnonymousView = paramOnClickListener2;
            if (paramAnonymousView != null) {
              paramAnonymousView.onClick(null, -2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254623);
          }
        });
        locale.b((e.b)new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(254624);
            DialogInterface.OnDismissListener localOnDismissListener = this.$ldismiss;
            if (localOnDismissListener != null)
            {
              localOnDismissListener.onDismiss(null);
              AppMethodBeat.o(254624);
              return;
            }
            AppMethodBeat.o(254624);
          }
        });
        locale.a((o.f)new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
          {
            AppMethodBeat.i(254625);
            paramAnonymousm.clear();
            this.$dialog.setFooterView(null);
            this.$dialog.setFooterView((View)this.$rootViewContainer);
            AppMethodBeat.o(254625);
          }
        });
        locale.Dm(true);
        locale.dGm();
        AppMethodBeat.o(254641);
        return locale;
        paramView.setImageDrawable(com.tencent.mm.cb.a.l(paramContext, 2131690801));
        break;
        label348:
        paramView.setIconColor(com.tencent.mm.cb.a.n(paramContext, 2131099792));
      }
    }
    
    public final e showConfirmMsgDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(254639);
      p.h(paramContext, "context");
      p.h(paramString2, "msg");
      View localView = View.inflate(paramContext, 2131494211, null);
      TextView localTextView = (TextView)localView.findViewById(2131301364);
      p.g(localTextView, "msgView");
      localTextView.setText((CharSequence)Util.nullAsNil(paramString2));
      paramString2 = (Companion)this;
      p.g(localView, "msgContainer");
      paramContext = paramString2.showConfirmDialog(paramContext, paramDrawable, paramInt, paramString1, localView, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener);
      AppMethodBeat.o(254639);
      return paramContext;
    }
    
    public final void showCreateFinderUserDialog(final Context paramContext, int paramInt)
    {
      AppMethodBeat.i(254637);
      p.h(paramContext, "context");
      String str1 = paramContext.getString(2131759640);
      p.g(str1, "context.getString(R.stri…nder_create_finder_title)");
      String str2 = paramContext.getString(2131759637);
      p.g(str2, "context.getString(R.stri…finder_create_finder_msg)");
      String str3 = paramContext.getString(2131759639);
      p.g(str3, "context.getString(R.stri…_create_finder_ok_button)");
      String str4 = paramContext.getString(2131759636);
      p.g(str4, "context.getString(R.stri…ate_finder_cancel_button)");
      showConfirmMsgDialog$default((Companion)this, paramContext, null, 0, str1, str2, str3, str4, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(254626);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("scene", this.$scene);
          paramAnonymousDialogInterface.putExtra("key_create_scene", this.$scene);
          com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.w(paramContext, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = k.vkd;
          k.a(s.af.vqp);
          AppMethodBeat.o(254626);
        }
      }, null, (DialogInterface.OnDismissListener)showCreateFinderUserDialog.2.INSTANCE, 262, null);
      AppMethodBeat.o(254637);
    }
    
    public final void showRealNameCertificationDialog(Activity paramActivity)
    {
      AppMethodBeat.i(254638);
      p.h(paramActivity, "context");
      Drawable localDrawable = com.tencent.mm.cb.a.l((Context)paramActivity, 2131690936);
      int i = com.tencent.mm.cb.a.n((Context)paramActivity, 2131101287);
      String str1 = paramActivity.getString(2131760500);
      p.g(str1, "context.getString(R.string.finder_real_name_title)");
      String str2 = paramActivity.getString(2131760491);
      p.g(str2, "context.getString(R.string.finder_real_name_msg)");
      String str3 = paramActivity.getString(2131760492);
      p.g(str3, "context.getString(R.stri…nder_real_name_ok_button)");
      String str4 = paramActivity.getString(2131760490);
      p.g(str4, "context.getString(R.stri…_real_name_cancel_button)");
      showConfirmMsgDialog$default((Companion)this, (Context)paramActivity, localDrawable, i, str1, str2, str3, str4, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(254629);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.am(this.$context);
          paramAnonymousDialogInterface = k.vkd;
          k.a(s.af.vqp);
          AppMethodBeat.o(254629);
        }
      }, null, (DialogInterface.OnDismissListener)showRealNameCertificationDialog.2.INSTANCE, 256, null);
      AppMethodBeat.o(254638);
    }
    
    public final void showUserInfoConfirmDialog(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2)
    {
      AppMethodBeat.i(254636);
      p.h(paramContext, "context");
      p.h(paramString, "finderUserName");
      final String str1 = paramContext.getString(2131760668);
      p.g(str1, "context.getString(R.stri…_user_info_confirm_title)");
      final String str2 = paramContext.getString(2131760669);
      p.g(str2, "context.getString(R.stri…nder_user_info_ok_button)");
      final String str3 = paramContext.getString(2131760667);
      p.g(str3, "context.getString(R.stri…_user_info_cancel_button)");
      final View localView = View.inflate(paramContext, 2131494212, null);
      if (localView == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(254636);
        throw paramContext;
      }
      new FinderBottomCustomDialogHelper.UserInfoHelper(paramContext, paramString, (ViewGroup)localView).load((kotlin.g.a.b)new kotlin.g.b.q(paramContext)
      {
        public final void invoke(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(254633);
          if (paramAnonymousBoolean)
          {
            FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(FinderBottomCustomDialogHelper.Companion, this.$context$inlined, null, 0, str1, localView, str2, str3, paramOnClickListener1, paramOnClickListener2, (DialogInterface.OnDismissListener)FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog.1.1.1.INSTANCE, 6, null);
            AppMethodBeat.o(254633);
            return;
          }
          u.u(this.$context$inlined, this.$context$inlined.getString(2131766184), 2131690547);
          AppMethodBeat.o(254633);
        }
      });
      AppMethodBeat.o(254636);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "username", "", "userInfoContainer", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "getContext", "()Landroid/content/Context;", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getUsername", "()Ljava/lang/String;", "doSceneForUserInfo", "getChangeLeftRegionWidth", "", "text", "getLocationTextWidth", "locationText", "getTotalAvailableWidth", "", "getUserTagText", "userExtInfo", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "handleAuth", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleNickname", "load", "loadInternal", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"})
  public static final class UserInfoHelper
    implements com.tencent.mm.ak.i
  {
    public static final Companion Companion;
    public static final String TAG = "ProfileHeaderHelper";
    private static final com.tencent.mm.b.h<String, FinderProfileHeaderUIC.b> userExtInfoCache;
    private kotlin.g.a.b<? super Boolean, x> callback;
    private final Context context;
    private com.tencent.f.i.d<?> dialogRunnable;
    private com.tencent.mm.ui.base.q loadingDialog;
    private final ViewGroup userInfoContainer;
    private final String username;
    
    static
    {
      AppMethodBeat.i(254660);
      Companion = new Companion(null);
      userExtInfoCache = new com.tencent.mm.b.h(100);
      AppMethodBeat.o(254660);
    }
    
    public UserInfoHelper(Context paramContext, String paramString, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(254659);
      this.context = paramContext;
      this.username = paramString;
      this.userInfoContainer = paramViewGroup;
      this.callback = ((kotlin.g.a.b)FinderBottomCustomDialogHelper.UserInfoHelper.callback.1.INSTANCE);
      AppMethodBeat.o(254659);
    }
    
    private final void doSceneForUserInfo(String paramString)
    {
      AppMethodBeat.i(254648);
      Log.i("ProfileHeaderHelper", "doSceneForUserInfo, username:".concat(String.valueOf(paramString)));
      Object localObject = this.dialogRunnable;
      if (localObject != null) {
        ((com.tencent.f.i.d)localObject).cancel(false);
      }
      this.dialogRunnable = com.tencent.f.h.RTc.n((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254646);
          FinderBottomCustomDialogHelper.UserInfoHelper.access$setLoadingDialog$p(this.this$0, com.tencent.mm.ui.base.q.a(this.this$0.getContext(), (CharSequence)this.this$0.getContext().getString(2131762447), true, 3, null));
          AppMethodBeat.o(254646);
        }
      }, 1500L);
      com.tencent.mm.kernel.g.azz().a(3736, (com.tencent.mm.ak.i)this);
      localObject = com.tencent.mm.kernel.g.azz();
      paramString = new cn(paramString, 0L, null, 0, null, 0, 0L, 110);
      paramString.twC = true;
      ((com.tencent.mm.ak.t)localObject).b((com.tencent.mm.ak.q)paramString);
      AppMethodBeat.o(254648);
    }
    
    private final float getChangeLeftRegionWidth(String paramString)
    {
      AppMethodBeat.i(254656);
      paramString = (ImageView)((View)this.userInfoContainer).findViewById(2131301415);
      p.g(paramString, "userInfoContainer.finder_profile_auth_icon");
      if (paramString.getVisibility() == 0) {}
      for (float f = com.tencent.mm.cb.a.aH(this.userInfoContainer.getContext(), 2131165297) + 0.0F;; f = 0.0F)
      {
        AppMethodBeat.o(254656);
        return f;
      }
    }
    
    private final float getLocationTextWidth(String paramString)
    {
      AppMethodBeat.i(254654);
      float f = 0.0F;
      if (!Util.isNullOrNil(paramString))
      {
        TextView localTextView = (TextView)((View)this.userInfoContainer).findViewById(2131309648);
        p.g(localTextView, "userInfoContainer.user_tag_layout");
        f = localTextView.getPaint().measureText(paramString);
      }
      AppMethodBeat.o(254654);
      return f;
    }
    
    private final int getTotalAvailableWidth()
    {
      AppMethodBeat.i(254657);
      Object localObject1 = new DisplayMetrics();
      Object localObject2 = this.userInfoContainer.getContext();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(254657);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((Activity)localObject2).getWindowManager();
      p.g(localObject2, "(userInfoContainer.conte…s Activity).windowManager");
      ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      Log.i("ProfileHeaderHelper", "screen width :" + ((DisplayMetrics)localObject1).widthPixels);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      int j = com.tencent.mm.cb.a.aH(this.userInfoContainer.getContext(), 2131166350);
      AppMethodBeat.o(254657);
      return i - j;
    }
    
    private final String getUserTagText(FinderProfileHeaderUIC.b paramb)
    {
      AppMethodBeat.i(254658);
      Object localObject = paramb.userTags;
      if (!((LinkedList)localObject).isEmpty())
      {
        paramb = new StringBuilder();
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramb.append((String)((Iterator)localObject).next()).append(" ");
        }
        paramb = com.tencent.mm.pluginsdk.ui.span.l.c(this.context, (CharSequence)paramb.toString());
        if (paramb != null)
        {
          paramb = paramb.toString();
          p.g(paramb, "this.toString()");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(254658);
        return paramb;
        paramb = "";
      }
    }
    
    private final void handleAuth(com.tencent.mm.plugin.finder.api.g paramg)
    {
      AppMethodBeat.i(254653);
      Object localObject;
      if (paramg != null)
      {
        localObject = paramg.field_authInfo;
        if (localObject != null) {}
      }
      else
      {
        localObject = new StringBuilder("[handleAuthGenerator] profileContact=");
        if (paramg != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.w("Finder.FinderProfileHeaderUIC", bool);
          AppMethodBeat.o(254653);
          return;
        }
      }
      if (((FinderAuthInfo)localObject).authIconType <= 0)
      {
        Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
        AppMethodBeat.o(254653);
        return;
      }
      paramg = y.vXH;
      paramg = (ImageView)((View)this.userInfoContainer).findViewById(2131301415);
      p.g(paramg, "userInfoContainer.finder_profile_auth_icon");
      y.a(paramg, (FinderAuthInfo)localObject);
      AppMethodBeat.o(254653);
    }
    
    private final void handleNickname(com.tencent.mm.plugin.finder.api.g paramg, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(254652);
      if (paramg == null)
      {
        AppMethodBeat.o(254652);
        return;
      }
      Object localObject1 = (LinearLayout)((View)paramViewGroup).findViewById(2131301453);
      p.g(localObject1, "userInfoContainer.finder_profile_name_container");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        paramg = new kotlin.t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(254652);
        throw paramg;
      }
      Object localObject2 = (ConstraintLayout.LayoutParams)localObject1;
      TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131309648);
      TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131301454);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131301417);
      p.g(localTextView2, "userTagLayout");
      if (localTextView2.getVisibility() == 4)
      {
        ((ConstraintLayout.LayoutParams)localObject2).bottomToTop = -1;
        ((ConstraintLayout.LayoutParams)localObject2).topToTop = 2131301418;
      }
      for (((ConstraintLayout.LayoutParams)localObject2).bottomToBottom = 2131301418;; ((ConstraintLayout.LayoutParams)localObject2).bottomToBottom = -1)
      {
        paramViewGroup = (LinearLayout)((View)paramViewGroup).findViewById(2131301453);
        p.g(paramViewGroup, "userInfoContainer.finder_profile_name_container");
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        p.g(localTextView1, "userNameTv");
        ao.a((Paint)localTextView1.getPaint(), 0.8F);
        paramViewGroup = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.m.dka();
        paramg = new com.tencent.mm.plugin.finder.loader.a(paramg.field_avatarUrl);
        p.g(localObject1, "userAvatarIv");
        localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        paramViewGroup.a(paramg, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
        AppMethodBeat.o(254652);
        return;
        ((ConstraintLayout.LayoutParams)localObject2).bottomToTop = 2131301419;
        ((ConstraintLayout.LayoutParams)localObject2).topToTop = -1;
      }
    }
    
    private final void loadInternal()
    {
      AppMethodBeat.i(254651);
      Object localObject1 = userExtInfoCache.get(this.username);
      p.g(localObject1, "userExtInfoCache[username]");
      String str = getUserTagText((FinderProfileHeaderUIC.b)localObject1);
      localObject1 = c.tsp;
      com.tencent.mm.plugin.finder.api.g localg = c.a.asG(this.username);
      Object localObject2 = this.context;
      int i;
      float f1;
      if (localg != null)
      {
        localObject1 = localg.getNickname();
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1).toString();
        p.g(localObject1, "MMSpanManager.spanForSmi…act?.nickname).toString()");
        i = getTotalAvailableWidth();
        f1 = getChangeLeftRegionWidth((String)localObject1);
        localObject2 = (TextView)((View)this.userInfoContainer).findViewById(2131301454);
        p.g(localObject2, "userInfoContainer.finder_profile_name_tv");
        float f2 = ((TextView)localObject2).getPaint().measureText((String)localObject1);
        float f3 = getLocationTextWidth(str);
        if ((f2 + f1 <= i) && (f3 <= i)) {
          break label235;
        }
        setProfileTextWidth((String)localObject1, str, i - com.tencent.mm.cb.a.aH(this.userInfoContainer.getContext(), 2131165296), (int)f1);
      }
      for (;;)
      {
        handleNickname(localg, this.userInfoContainer);
        handleAuth(localg);
        this.callback.invoke(Boolean.TRUE);
        AppMethodBeat.o(254651);
        return;
        localObject1 = null;
        break;
        label235:
        setProfileTextWidth((String)localObject1, str, i, (int)f1);
      }
    }
    
    private final void setProfileTextWidth(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254655);
      TextView localTextView = (TextView)((View)this.userInfoContainer).findViewById(2131301454);
      p.g(localTextView, "userInfoContainer.finder_profile_name_tv");
      localTextView.setMaxWidth(paramInt1 - paramInt2);
      localTextView = (TextView)((View)this.userInfoContainer).findViewById(2131301454);
      p.g(localTextView, "userInfoContainer.finder_profile_name_tv");
      localTextView.setText((CharSequence)paramString1);
      paramString1 = (TextView)((View)this.userInfoContainer).findViewById(2131309648);
      p.g(paramString1, "userInfoContainer.user_tag_layout");
      paramString1.setMaxWidth(paramInt1);
      paramString1 = (TextView)((View)this.userInfoContainer).findViewById(2131309648);
      p.g(paramString1, "userInfoContainer.user_tag_layout");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(254655);
    }
    
    public final Context getContext()
    {
      return this.context;
    }
    
    public final String getUsername()
    {
      return this.username;
    }
    
    public final void load(kotlin.g.a.b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(254650);
      p.h(paramb, "callback");
      this.callback = paramb;
      if (!userExtInfoCache.check(this.username))
      {
        doSceneForUserInfo(this.username);
        AppMethodBeat.o(254650);
        return;
      }
      loadInternal();
      AppMethodBeat.o(254650);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(254649);
      paramString = this.loadingDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      paramString = this.dialogRunnable;
      if (paramString != null) {
        paramString.cancel(false);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if ((paramq instanceof cn))
        {
          StringBuilder localStringBuilder = new StringBuilder("username=").append(this.username).append(", scene username=");
          paramString = ((cn)paramq).cZk();
          if (paramString == null) {
            break label249;
          }
          paramString = paramString.username;
          Log.i("ProfileHeaderHelper", paramString);
          paramString = (FinderProfileHeaderUIC.b)userExtInfoCache.get(this.username);
          if (paramString != null) {
            break label270;
          }
          paramString = new FinderProfileHeaderUIC.b();
        }
      }
      label270:
      for (;;)
      {
        paramString.fansCount = ((cn)paramq).fansCount;
        paramString.friendFollowCount = ((cn)paramq).friendFollowCount;
        paramString.at(new LinkedList((Collection)((cn)paramq).userTags));
        paramString.vcb = ((cn)paramq).cZl();
        userExtInfoCache.put(this.username, paramString);
        new MMHandler(Looper.getMainLooper()).postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254647);
            FinderBottomCustomDialogHelper.UserInfoHelper.access$loadInternal(this.this$0);
            AppMethodBeat.o(254647);
          }
        });
        for (;;)
        {
          com.tencent.mm.kernel.g.azz().b(3736, (com.tencent.mm.ak.i)this);
          AppMethodBeat.o(254649);
          return;
          label249:
          paramString = null;
          break;
          this.callback.invoke(Boolean.FALSE);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper$Companion;", "", "()V", "TAG", "", "userExtInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "getUserExtInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"})
    public static final class Companion
    {
      public final com.tencent.mm.b.h<String, FinderProfileHeaderUIC.b> getUserExtInfoCache()
      {
        AppMethodBeat.i(254643);
        com.tencent.mm.b.h localh = FinderBottomCustomDialogHelper.UserInfoHelper.access$getUserExtInfoCache$cp();
        AppMethodBeat.o(254643);
        return localh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper
 * JD-Core Version:    0.7.0.1
 */