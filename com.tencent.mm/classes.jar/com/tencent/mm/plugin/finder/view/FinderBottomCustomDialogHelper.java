package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Looper;
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
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.aq;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.profile.uic.j.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper;", "", "()V", "Companion", "UserInfoHelper", "plugin-finder_release"})
public final class FinderBottomCustomDialogHelper
{
  public static final Companion Companion;
  private static final String TAG = "FinderBottomCustomDialogHelper";
  
  static
  {
    AppMethodBeat.i(223198);
    Companion = new Companion(null);
    AppMethodBeat.o(223198);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "", "title", "content", "Landroid/view/View;", "ok", "cancel", "btnStyle", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showConfirmMsgDialog", "msg", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showConfirmTextDialog", "showFinderIcon", "", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/Boolean;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showCreateFinderUserDialog", "", "scene", "intent", "Landroid/content/Intent;", "showCreateFinderUserDialogOnLiveWithCallback", "Landroid/app/Activity;", "requestCode", "showOverSeaAgreeConfirmDiaglog", "showRealNameCertificationDialog", "showRealNameCertificationDialogWithCallback", "showUserInfoConfirmDialog", "finderUserName", "dismiss", "showUserInfoConfirmDialogOnLiveRedPacket", "plugin-finder_release"})
  public static final class Companion
  {
    public final com.tencent.mm.ui.widget.a.e showConfirmDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, View paramView, String paramString2, String paramString3, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233852);
      p.k(paramContext, "context");
      p.k(paramView, "content");
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, b.g.finder_bottom_custom_confirm, null);
      if (localObject == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(233852);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      ((FrameLayout)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_content)).addView(paramView);
      paramView = (WeImageView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_icon);
      if (paramDrawable != null)
      {
        paramView.setImageDrawable(paramDrawable);
        if (paramInt == -1) {
          break label360;
        }
        paramView.setIconColor(paramInt);
        label119:
        paramDrawable = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_title);
        if (!Util.isNullOrNil(paramString1))
        {
          p.j(paramDrawable, "titleTv");
          paramDrawable.setText((CharSequence)paramString1);
        }
        paramDrawable = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.ok_btn);
        if (!Util.isNullOrNil(paramString2))
        {
          p.j(paramDrawable, "okBtn");
          paramDrawable.setText((CharSequence)paramString2);
        }
        paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.cancel_btn);
        if (!Util.isNullOrNil(paramString3))
        {
          p.j(paramString1, "cancelBtn");
          paramString1.setText((CharSequence)paramString3);
        }
        ((RoundedCornerFrameLayout)localObject).v(aw.fromDPToPix(paramContext, 12), aw.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
        paramDrawable.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showConfirmDialog.1(locale, paramOnClickListener1));
        paramString1.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showConfirmDialog.2(locale, paramOnClickListener2));
        locale.b((e.b)new FinderBottomCustomDialogHelper.Companion.showConfirmDialog.3(paramOnDismissListener));
        locale.a((q.f)new FinderBottomCustomDialogHelper.Companion.showConfirmDialog.4(locale, (RoundedCornerFrameLayout)localObject));
        if (paramInteger != null) {
          break label375;
        }
      }
      for (;;)
      {
        locale.rn(true);
        locale.eik();
        AppMethodBeat.o(233852);
        return locale;
        paramView.setImageDrawable(com.tencent.mm.ci.a.m(paramContext, com.tencent.mm.plugin.finder.b.i.icons_outlined_finder_icon));
        break;
        label360:
        paramView.setIconColor(com.tencent.mm.ci.a.w(paramContext, b.c.Orange));
        break label119;
        label375:
        if (paramInteger.intValue() == 1)
        {
          paramDrawable.setTextColor(paramContext.getResources().getColor(b.c.white_text_color_selector));
          p.j(paramDrawable, "okBtn");
          paramDrawable.setBackground(paramContext.getResources().getDrawable(b.e.finder_live_post_btn_red));
          paramString1.setTextColor(paramContext.getResources().getColor(b.c.room_live_logo_color));
        }
      }
    }
    
    public final com.tencent.mm.ui.widget.a.e showConfirmMsgDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233846);
      p.k(paramContext, "context");
      p.k(paramString2, "msg");
      View localView = View.inflate(paramContext, b.g.finder_bottom_content_msg, null);
      TextView localTextView = (TextView)localView.findViewById(b.f.finder_msg);
      p.j(localTextView, "msgView");
      localTextView.setText((CharSequence)Util.nullAsNil(paramString2));
      paramString2 = (Companion)this;
      p.j(localView, "msgContainer");
      paramContext = paramString2.showConfirmDialog(paramContext, paramDrawable, paramInt, paramString1, localView, paramString3, paramString4, paramInteger, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener);
      AppMethodBeat.o(233846);
      return paramContext;
    }
    
    public final com.tencent.mm.ui.widget.a.e showConfirmTextDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233858);
      p.k(paramContext, "context");
      p.k(paramString2, "content");
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, b.g.finder_bottom_custom_text_confirm, null);
      if (localObject == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(233858);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_content);
      p.j(localTextView, "contentViewContainer");
      localTextView.setText((CharSequence)paramString2);
      paramString2 = (WeImageView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_icon);
      if (paramDrawable != null)
      {
        paramString2.setImageDrawable(paramDrawable);
        if (paramInt == -1) {
          break label403;
        }
        paramString2.setIconColor(paramInt);
        label136:
        if (!p.h(paramBoolean, Boolean.TRUE)) {
          break label418;
        }
        p.j(paramString2, "titleIconIv");
        paramString2.setVisibility(0);
        label161:
        paramDrawable = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_title);
        if (!Util.isNullOrNil(paramString1))
        {
          p.j(paramDrawable, "titleTv");
          paramDrawable.setText((CharSequence)paramString1);
        }
        paramDrawable = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.ok_btn);
        if (!Util.isNullOrNil(paramString3))
        {
          p.j(paramDrawable, "okBtn");
          paramDrawable.setText((CharSequence)paramString3);
        }
        paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.cancel_btn);
        if (!Util.isNullOrNil(paramString4))
        {
          p.j(paramString1, "cancelBtn");
          paramString1.setText((CharSequence)paramString4);
        }
        ((RoundedCornerFrameLayout)localObject).v(aw.fromDPToPix(paramContext, 12), aw.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
        paramDrawable.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog.1(locale, paramOnClickListener1));
        paramString1.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog.2(locale, paramOnClickListener2));
        locale.b((e.b)new FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog.3(paramOnDismissListener));
        locale.a((q.f)new FinderBottomCustomDialogHelper.Companion.showConfirmTextDialog.4(locale, (RoundedCornerFrameLayout)localObject));
        if (paramInteger != null) {
          break label436;
        }
      }
      for (;;)
      {
        locale.rn(true);
        locale.eik();
        AppMethodBeat.o(233858);
        return locale;
        paramString2.setImageDrawable(com.tencent.mm.ci.a.m(paramContext, com.tencent.mm.plugin.finder.b.i.icons_outlined_finder_icon));
        break;
        label403:
        paramString2.setIconColor(com.tencent.mm.ci.a.w(paramContext, b.c.Orange));
        break label136;
        label418:
        p.j(paramString2, "titleIconIv");
        paramString2.setVisibility(8);
        break label161;
        label436:
        if (paramInteger.intValue() == 1)
        {
          paramDrawable.setTextColor(paramContext.getResources().getColor(b.c.white_text_color_selector));
          p.j(paramDrawable, "okBtn");
          paramDrawable.setBackground(paramContext.getResources().getDrawable(b.e.finder_live_post_btn_red));
          paramString1.setTextColor(paramContext.getResources().getColor(b.c.room_live_logo_color));
        }
      }
    }
    
    public final void showCreateFinderUserDialog(final Context paramContext, final int paramInt, Intent paramIntent)
    {
      AppMethodBeat.i(233831);
      p.k(paramContext, "context");
      String str1 = paramContext.getString(b.j.finder_create_finder_title);
      p.j(str1, "context.getString(R.stri…nder_create_finder_title)");
      String str2 = paramContext.getString(b.j.finder_create_finder_msg);
      p.j(str2, "context.getString(R.stri…finder_create_finder_msg)");
      String str3 = paramContext.getString(b.j.finder_create_finder_ok_button);
      p.j(str3, "context.getString(R.stri…_create_finder_ok_button)");
      String str4 = paramContext.getString(b.j.finder_create_finder_cancel_button);
      p.j(str4, "context.getString(R.stri…ate_finder_cancel_button)");
      showConfirmMsgDialog$default((Companion)this, paramContext, null, 0, str1, str2, str3, str4, null, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(291908);
          Object localObject = this.$intent;
          paramAnonymousDialogInterface = (DialogInterface)localObject;
          if (localObject == null) {
            paramAnonymousDialogInterface = new Intent();
          }
          paramAnonymousDialogInterface.putExtra("key_create_scene", paramInt);
          localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.w(paramContext, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = k.yBj;
          k.a(s.aq.yJE);
          AppMethodBeat.o(291908);
        }
      }, null, (DialogInterface.OnDismissListener)showCreateFinderUserDialog.2.INSTANCE, 646, null);
      AppMethodBeat.o(233831);
    }
    
    public final void showCreateFinderUserDialogOnLiveWithCallback(final Activity paramActivity, final int paramInt1, Intent paramIntent, final int paramInt2, final DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233817);
      p.k(paramActivity, "context");
      String str1 = paramActivity.getString(b.j.finder_create_title);
      p.j(str1, "context.getString(R.string.finder_create_title)");
      String str2 = paramActivity.getString(b.j.finder_create_contact_tips);
      p.j(str2, "context.getString(R.stri…nder_create_contact_tips)");
      String str3 = paramActivity.getString(b.j.finder_go_to_create_finder_account);
      p.j(str3, "context.getString(R.stri…to_create_finder_account)");
      String str4 = paramActivity.getString(b.j.finder_create_finder_cancel_button);
      p.j(str4, "context.getString(R.stri…ate_finder_cancel_button)");
      showConfirmMsgDialog$default((Companion)this, (Context)paramActivity, null, 0, str1, str2, str3, str4, Integer.valueOf(1), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(258065);
          Object localObject2 = this.$intent;
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Intent();
          }
          ((Intent)localObject1).putExtra("key_create_scene", paramInt1);
          localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.b(paramActivity, (Intent)localObject1, paramInt2);
          localObject1 = paramOnClickListener1;
          if (localObject1 != null)
          {
            ((DialogInterface.OnClickListener)localObject1).onClick(paramAnonymousDialogInterface, paramAnonymousInt);
            AppMethodBeat.o(258065);
            return;
          }
          AppMethodBeat.o(258065);
        }
      }, paramOnClickListener2, paramOnDismissListener, 6, null);
      AppMethodBeat.o(233817);
    }
    
    public final void showOverSeaAgreeConfirmDiaglog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(233842);
      p.k(paramContext, "context");
      p.k(paramString1, "title");
      p.k(paramString2, "content");
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, b.g.finder_bottom_oversea_confirm, null);
      if (localObject == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(233842);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      ((RoundedCornerFrameLayout)localObject).v(aw.fromDPToPix(paramContext, 12), aw.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      TextView localTextView1 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_title);
      p.j(localTextView1, "titleText");
      localTextView1.setText((CharSequence)paramString1);
      paramString1 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_content);
      p.j(paramString1, "contentText");
      paramString1.setText((CharSequence)paramString2);
      localTextView1 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.wx_service);
      TextView localTextView2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.wx_private);
      paramString1 = com.tencent.mm.kernel.h.aHG();
      p.j(paramString1, "MMKernel.storage()");
      paramString2 = paramString1.aHp().b(274436, "").toString();
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = LocaleUtil.getCurrentCountryCode();
      }
      paramString2 = paramString1;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString2 = paramString1;
        if (!Util.isAllAlpha(paramString1)) {
          paramString2 = "";
        }
      }
      paramString1 = paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), paramString2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
      p.j(paramString1, "context.resources.getStr…tryCode, \"setting\", 0, 0)");
      paramString2 = paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), paramString2 });
      p.j(paramString2, "context.resources.getStr…nLanguage(), countryCode)");
      af localaf = af.aaBG;
      paramString2 = String.format("<a href='%s'>%s</a>", Arrays.copyOf(new Object[] { paramString2, paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.license_detail) }, 2));
      p.j(paramString2, "java.lang.String.format(format, *args)");
      localTextView1.setText((CharSequence)paramString2);
      paramString2 = af.aaBG;
      paramContext = String.format("<a href='%s'>%s</a>", Arrays.copyOf(new Object[] { paramString1, paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.privacy_detail) }, 2));
      p.j(paramContext, "java.lang.String.format(format, *args)");
      localTextView2.setText((CharSequence)paramContext);
      com.tencent.mm.pluginsdk.ui.span.l.q(localTextView1, 1);
      com.tencent.mm.pluginsdk.ui.span.l.q(localTextView2, 1);
      paramContext = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.ok_btn);
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.cancel_btn);
      paramContext.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog.1(locale, paramOnClickListener));
      paramString1.setOnClickListener((View.OnClickListener)new FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog.2(locale));
      locale.a((q.f)new FinderBottomCustomDialogHelper.Companion.showOverSeaAgreeConfirmDiaglog.3(locale, (RoundedCornerFrameLayout)localObject));
      locale.rn(true);
      locale.eik();
      AppMethodBeat.o(233842);
    }
    
    public final void showRealNameCertificationDialog(Activity paramActivity)
    {
      AppMethodBeat.i(233838);
      p.k(paramActivity, "context");
      Drawable localDrawable = com.tencent.mm.ci.a.m((Context)paramActivity, com.tencent.mm.plugin.finder.b.i.icons_outlined_wechat);
      int i = com.tencent.mm.ci.a.w((Context)paramActivity, b.c.transparent);
      String str1 = paramActivity.getString(b.j.finder_real_name_title);
      p.j(str1, "context.getString(R.string.finder_real_name_title)");
      String str2 = paramActivity.getString(b.j.finder_real_name_msg);
      p.j(str2, "context.getString(R.string.finder_real_name_msg)");
      String str3 = paramActivity.getString(b.j.finder_real_name_ok_button);
      p.j(str3, "context.getString(R.stri…nder_real_name_ok_button)");
      String str4 = paramActivity.getString(b.j.finder_real_name_cancel_button);
      p.j(str4, "context.getString(R.stri…_real_name_cancel_button)");
      showConfirmMsgDialog$default((Companion)this, (Context)paramActivity, localDrawable, i, str1, str2, str3, str4, null, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(270807);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.as(this.$context);
          paramAnonymousDialogInterface = k.yBj;
          k.a(s.aq.yJE);
          AppMethodBeat.o(270807);
        }
      }, null, (DialogInterface.OnDismissListener)showRealNameCertificationDialog.2.INSTANCE, 640, null);
      AppMethodBeat.o(233838);
    }
    
    public final void showRealNameCertificationDialogWithCallback(Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233825);
      p.k(paramActivity, "context");
      Drawable localDrawable = com.tencent.mm.ci.a.m((Context)paramActivity, com.tencent.mm.plugin.finder.b.i.icons_outlined_finder_icon);
      int i = com.tencent.mm.ci.a.w((Context)paramActivity, b.c.Orange);
      String str1 = paramActivity.getString(b.j.finder_create_title);
      p.j(str1, "context.getString(R.string.finder_create_title)");
      String str2 = paramActivity.getString(b.j.finder_create_accout_need_real_name_title);
      p.j(str2, "context.getString(R.stri…out_need_real_name_title)");
      String str3 = paramActivity.getString(b.j.finder_real_name_ok_button);
      p.j(str3, "context.getString(R.stri…nder_real_name_ok_button)");
      String str4 = paramActivity.getString(b.j.finder_real_name_cancel_button);
      p.j(str4, "context.getString(R.stri…_real_name_cancel_button)");
      ((Companion)this).showConfirmMsgDialog((Context)paramActivity, localDrawable, i, str1, str2, str3, str4, Integer.valueOf(1), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(250282);
          Object localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.as(this.$context);
          localObject = paramOnClickListener1;
          if (localObject != null)
          {
            ((DialogInterface.OnClickListener)localObject).onClick(paramAnonymousDialogInterface, paramAnonymousInt);
            AppMethodBeat.o(250282);
            return;
          }
          AppMethodBeat.o(250282);
        }
      }, paramOnClickListener2, paramOnDismissListener);
      AppMethodBeat.o(233825);
    }
    
    public final void showUserInfoConfirmDialog(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(233809);
      p.k(paramContext, "context");
      p.k(paramString, "finderUserName");
      final String str1 = paramContext.getString(b.j.finder_user_info_confirm_title);
      p.j(str1, "context.getString(R.stri…_user_info_confirm_title)");
      final String str2 = paramContext.getString(b.j.finder_user_info_ok_button);
      p.j(str2, "context.getString(R.stri…nder_user_info_ok_button)");
      final String str3 = paramContext.getString(b.j.finder_user_info_cancel_button);
      p.j(str3, "context.getString(R.stri…_user_info_cancel_button)");
      final View localView = View.inflate(paramContext, b.g.finder_bottom_content_user_info, null);
      if (localView == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(233809);
        throw paramContext;
      }
      new FinderBottomCustomDialogHelper.UserInfoHelper(paramContext, paramString, (ViewGroup)localView).load((b)new kotlin.g.b.q(paramContext)
      {
        public final void invoke(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(285230);
          if (paramAnonymousBoolean)
          {
            FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(FinderBottomCustomDialogHelper.Companion, this.$context$inlined, null, 0, str1, localView, str2, str3, Integer.valueOf(1), paramOnClickListener1, paramOnClickListener2, (DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(280290);
                DialogInterface.OnDismissListener localOnDismissListener = this.this$0.$dismiss$inlined;
                if (localOnDismissListener != null) {
                  localOnDismissListener.onDismiss(paramAnonymous2DialogInterface);
                }
                paramAnonymous2DialogInterface = k.yBj;
                k.a(s.aq.yJD);
                AppMethodBeat.o(280290);
              }
            }, 6, null);
            AppMethodBeat.o(285230);
            return;
          }
          w.w(this.$context$inlined, this.$context$inlined.getString(b.j.sns_request_timeout), com.tencent.mm.plugin.finder.b.i.icons_filled_error);
          AppMethodBeat.o(285230);
        }
      });
      AppMethodBeat.o(233809);
    }
    
    public final void showUserInfoConfirmDialogOnLiveRedPacket(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2)
    {
      AppMethodBeat.i(233814);
      p.k(paramContext, "context");
      p.k(paramString, "finderUserName");
      final String str1 = paramContext.getString(b.j.finder_user_info_confirm_title);
      p.j(str1, "context.getString(R.stri…_user_info_confirm_title)");
      final String str2 = paramContext.getString(b.j.finder_user_info_ok_button);
      p.j(str2, "context.getString(R.stri…nder_user_info_ok_button)");
      final String str3 = paramContext.getString(b.j.finder_user_info_cancel_button);
      p.j(str3, "context.getString(R.stri…_user_info_cancel_button)");
      final View localView = View.inflate(paramContext, b.g.finder_bottom_content_user_info, null);
      if (localView == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(233814);
        throw paramContext;
      }
      new FinderBottomCustomDialogHelper.UserInfoHelper(paramContext, paramString, (ViewGroup)localView).load((b)new kotlin.g.b.q(paramContext)
      {
        public final void invoke(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(269483);
          if (paramAnonymousBoolean)
          {
            FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(FinderBottomCustomDialogHelper.Companion, this.$context$inlined, null, 0, str1, localView, str2, str3, Integer.valueOf(1), paramOnClickListener1, paramOnClickListener2, (DialogInterface.OnDismissListener)FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialogOnLiveRedPacket.1.1.1.INSTANCE, 6, null);
            AppMethodBeat.o(269483);
            return;
          }
          w.w(this.$context$inlined, this.$context$inlined.getString(b.j.sns_request_timeout), com.tencent.mm.plugin.finder.b.i.icons_filled_error);
          AppMethodBeat.o(269483);
        }
      });
      AppMethodBeat.o(233814);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "username", "", "userInfoContainer", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "getContext", "()Landroid/content/Context;", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getUsername", "()Ljava/lang/String;", "doSceneForUserInfo", "getChangeLeftRegionWidth", "", "text", "getLocationTextWidth", "locationText", "getTotalAvailableWidth", "", "getUserTagText", "userExtInfo", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "handleAuth", "finderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleNickname", "load", "loadInternal", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"})
  public static final class UserInfoHelper
    implements com.tencent.mm.an.i
  {
    public static final Companion Companion;
    public static final String TAG = "ProfileHeaderHelper";
    private static final com.tencent.mm.b.h<String, j.b> userExtInfoCache;
    private b<? super Boolean, x> callback;
    private final Context context;
    private com.tencent.e.i.d<?> dialogRunnable;
    private s loadingDialog;
    private final ViewGroup userInfoContainer;
    private final String username;
    
    static
    {
      AppMethodBeat.i(276235);
      Companion = new Companion(null);
      userExtInfoCache = new com.tencent.mm.b.h(100);
      AppMethodBeat.o(276235);
    }
    
    public UserInfoHelper(Context paramContext, String paramString, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(276234);
      this.context = paramContext;
      this.username = paramString;
      this.userInfoContainer = paramViewGroup;
      this.callback = ((b)FinderBottomCustomDialogHelper.UserInfoHelper.callback.1.INSTANCE);
      AppMethodBeat.o(276234);
    }
    
    private final void doSceneForUserInfo(String paramString)
    {
      AppMethodBeat.i(276210);
      Log.i("ProfileHeaderHelper", "doSceneForUserInfo, username:".concat(String.valueOf(paramString)));
      Object localObject = this.dialogRunnable;
      if (localObject != null) {
        ((com.tencent.e.i.d)localObject).cancel(false);
      }
      this.dialogRunnable = com.tencent.e.h.ZvG.n((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272270);
          FinderBottomCustomDialogHelper.UserInfoHelper.access$setLoadingDialog$p(this.this$0, s.a(this.this$0.getContext(), (CharSequence)this.this$0.getContext().getString(b.j.loading_tips_1), true, 3, null));
          AppMethodBeat.o(272270);
        }
      }, 1500L);
      com.tencent.mm.kernel.h.aGY().a(3736, (com.tencent.mm.an.i)this);
      localObject = com.tencent.mm.kernel.h.aGY();
      paramString = new cr(paramString, 0L, null, 0, null, 0, 0L, 110);
      paramString.xer = true;
      ((com.tencent.mm.an.t)localObject).b((com.tencent.mm.an.q)paramString);
      AppMethodBeat.o(276210);
    }
    
    private final float getChangeLeftRegionWidth(String paramString)
    {
      AppMethodBeat.i(276230);
      paramString = (ImageView)((View)this.userInfoContainer).findViewById(b.f.finder_profile_auth_icon);
      p.j(paramString, "userInfoContainer.finder_profile_auth_icon");
      if (paramString.getVisibility() == 0) {}
      for (float f = com.tencent.mm.ci.a.aZ(this.userInfoContainer.getContext(), b.d.Edge_2_5_A) + 0.0F;; f = 0.0F)
      {
        AppMethodBeat.o(276230);
        return f;
      }
    }
    
    private final float getLocationTextWidth(String paramString)
    {
      AppMethodBeat.i(276226);
      float f = 0.0F;
      if (!Util.isNullOrNil(paramString))
      {
        TextView localTextView = (TextView)((View)this.userInfoContainer).findViewById(b.f.user_tag_layout);
        p.j(localTextView, "userInfoContainer.user_tag_layout");
        f = localTextView.getPaint().measureText(paramString);
      }
      AppMethodBeat.o(276226);
      return f;
    }
    
    private final int getTotalAvailableWidth()
    {
      AppMethodBeat.i(276232);
      Object localObject1 = new DisplayMetrics();
      Object localObject2 = this.userInfoContainer.getContext();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(276232);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((Activity)localObject2).getWindowManager();
      p.j(localObject2, "(userInfoContainer.conte…s Activity).windowManager");
      ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      Log.i("ProfileHeaderHelper", "screen width :" + ((DisplayMetrics)localObject1).widthPixels);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      int j = com.tencent.mm.ci.a.aZ(this.userInfoContainer.getContext(), b.d.finder_12_A);
      AppMethodBeat.o(276232);
      return i - j;
    }
    
    private final String getUserTagText(j.b paramb)
    {
      AppMethodBeat.i(276233);
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
          p.j(paramb, "this.toString()");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(276233);
        return paramb;
        paramb = "";
      }
    }
    
    private final void handleAuth(com.tencent.mm.plugin.finder.api.i parami)
    {
      AppMethodBeat.i(276224);
      Object localObject;
      if (parami != null)
      {
        localObject = parami.field_authInfo;
        if (localObject != null) {}
      }
      else
      {
        localObject = new StringBuilder("[handleAuthGenerator] profileContact=");
        if (parami != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.w("Finder.FinderProfileHeaderUIC", bool);
          AppMethodBeat.o(276224);
          return;
        }
      }
      if (((FinderAuthInfo)localObject).authIconType <= 0)
      {
        Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
        AppMethodBeat.o(276224);
        return;
      }
      parami = aj.AGc;
      parami = (ImageView)((View)this.userInfoContainer).findViewById(b.f.finder_profile_auth_icon);
      p.j(parami, "userInfoContainer.finder_profile_auth_icon");
      aj.a(parami, (FinderAuthInfo)localObject);
      AppMethodBeat.o(276224);
    }
    
    private final void handleNickname(com.tencent.mm.plugin.finder.api.i parami, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(276222);
      if (parami == null)
      {
        AppMethodBeat.o(276222);
        return;
      }
      Object localObject1 = (LinearLayout)((View)paramViewGroup).findViewById(b.f.finder_profile_name_container);
      p.j(localObject1, "userInfoContainer.finder_profile_name_container");
      localObject1 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        parami = new kotlin.t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(276222);
        throw parami;
      }
      Object localObject2 = (ConstraintLayout.LayoutParams)localObject1;
      TextView localTextView2 = (TextView)paramViewGroup.findViewById(b.f.user_tag_layout);
      TextView localTextView1 = (TextView)paramViewGroup.findViewById(b.f.finder_profile_name_tv);
      localObject1 = (ImageView)paramViewGroup.findViewById(b.f.finder_profile_avatar_btn);
      p.j(localTextView2, "userTagLayout");
      if (localTextView2.getVisibility() == 4)
      {
        ((ConstraintLayout.LayoutParams)localObject2).Ff = -1;
        ((ConstraintLayout.LayoutParams)localObject2).Fd = b.f.finder_profile_avatar_container;
      }
      for (((ConstraintLayout.LayoutParams)localObject2).Fg = b.f.finder_profile_avatar_container;; ((ConstraintLayout.LayoutParams)localObject2).Fg = -1)
      {
        paramViewGroup = (LinearLayout)((View)paramViewGroup).findViewById(b.f.finder_profile_name_container);
        p.j(paramViewGroup, "userInfoContainer.finder_profile_name_container");
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        p.j(localTextView1, "userNameTv");
        ar.a((Paint)localTextView1.getPaint(), 0.8F);
        paramViewGroup = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.t.dJh();
        parami = new com.tencent.mm.plugin.finder.loader.e(parami.field_avatarUrl);
        p.j(localObject1, "userAvatarIv");
        localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramViewGroup.a(parami, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        AppMethodBeat.o(276222);
        return;
        ((ConstraintLayout.LayoutParams)localObject2).Ff = b.f.finder_profile_avatar_guideline;
        ((ConstraintLayout.LayoutParams)localObject2).Fd = -1;
      }
    }
    
    private final void loadInternal()
    {
      AppMethodBeat.i(276219);
      Object localObject1 = userExtInfoCache.get(this.username);
      p.j(localObject1, "userExtInfoCache[username]");
      String str = getUserTagText((j.b)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.i locali = d.a.aAK(this.username);
      Object localObject2 = this.context;
      int i;
      float f1;
      if (locali != null)
      {
        localObject1 = locali.getNickname();
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1).toString();
        p.j(localObject1, "MMSpanManager.spanForSmi…act?.nickname).toString()");
        i = getTotalAvailableWidth();
        f1 = getChangeLeftRegionWidth((String)localObject1);
        localObject2 = (TextView)((View)this.userInfoContainer).findViewById(b.f.finder_profile_name_tv);
        p.j(localObject2, "userInfoContainer.finder_profile_name_tv");
        float f2 = ((TextView)localObject2).getPaint().measureText((String)localObject1);
        float f3 = getLocationTextWidth(str);
        if ((f2 + f1 <= i) && (f3 <= i)) {
          break label235;
        }
        setProfileTextWidth((String)localObject1, str, i - com.tencent.mm.ci.a.aZ(this.userInfoContainer.getContext(), b.d.Edge_2A), (int)f1);
      }
      for (;;)
      {
        handleNickname(locali, this.userInfoContainer);
        handleAuth(locali);
        this.callback.invoke(Boolean.TRUE);
        AppMethodBeat.o(276219);
        return;
        localObject1 = null;
        break;
        label235:
        setProfileTextWidth((String)localObject1, str, i, (int)f1);
      }
    }
    
    private final void setProfileTextWidth(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276228);
      TextView localTextView = (TextView)((View)this.userInfoContainer).findViewById(b.f.finder_profile_name_tv);
      p.j(localTextView, "userInfoContainer.finder_profile_name_tv");
      localTextView.setMaxWidth(paramInt1 - paramInt2);
      localTextView = (TextView)((View)this.userInfoContainer).findViewById(b.f.finder_profile_name_tv);
      p.j(localTextView, "userInfoContainer.finder_profile_name_tv");
      localTextView.setText((CharSequence)paramString1);
      paramString1 = (TextView)((View)this.userInfoContainer).findViewById(b.f.user_tag_layout);
      p.j(paramString1, "userInfoContainer.user_tag_layout");
      paramString1.setMaxWidth(paramInt1);
      paramString1 = (TextView)((View)this.userInfoContainer).findViewById(b.f.user_tag_layout);
      p.j(paramString1, "userInfoContainer.user_tag_layout");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(276228);
    }
    
    public final Context getContext()
    {
      return this.context;
    }
    
    public final String getUsername()
    {
      return this.username;
    }
    
    public final void load(b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(276215);
      p.k(paramb, "callback");
      this.callback = paramb;
      if (!userExtInfoCache.check(this.username))
      {
        doSceneForUserInfo(this.username);
        AppMethodBeat.o(276215);
        return;
      }
      loadInternal();
      AppMethodBeat.o(276215);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(276213);
      paramString = this.loadingDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      paramString = this.dialogRunnable;
      if (paramString != null) {
        paramString.cancel(false);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if ((paramq instanceof cr))
        {
          StringBuilder localStringBuilder = new StringBuilder("username=").append(this.username).append(", scene username=");
          paramString = ((cr)paramq).dpc();
          if (paramString == null) {
            break label249;
          }
          paramString = paramString.username;
          Log.i("ProfileHeaderHelper", paramString);
          paramString = (j.b)userExtInfoCache.get(this.username);
          if (paramString != null) {
            break label270;
          }
          paramString = new j.b();
        }
      }
      label270:
      for (;;)
      {
        paramString.fansCount = ((cr)paramq).fansCount;
        paramString.friendFollowCount = ((cr)paramq).friendFollowCount;
        paramString.aL(new LinkedList((Collection)((cr)paramq).userTags));
        paramString.zSA = ((cr)paramq).dpd();
        userExtInfoCache.put(this.username, paramString);
        new MMHandler(Looper.getMainLooper()).postUI((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(277999);
            FinderBottomCustomDialogHelper.UserInfoHelper.access$loadInternal(this.this$0);
            AppMethodBeat.o(277999);
          }
        });
        for (;;)
        {
          com.tencent.mm.kernel.h.aGY().b(3736, (com.tencent.mm.an.i)this);
          AppMethodBeat.o(276213);
          return;
          label249:
          paramString = null;
          break;
          this.callback.invoke(Boolean.FALSE);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$UserInfoHelper$Companion;", "", "()V", "TAG", "", "userExtInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$UserExtInfo;", "getUserExtInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "plugin-finder_release"})
    public static final class Companion
    {
      public final com.tencent.mm.b.h<String, j.b> getUserExtInfoCache()
      {
        AppMethodBeat.i(258257);
        com.tencent.mm.b.h localh = FinderBottomCustomDialogHelper.UserInfoHelper.access$getUserExtInfoCache$cp();
        AppMethodBeat.o(258257);
        return localh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper
 * JD-Core Version:    0.7.0.1
 */