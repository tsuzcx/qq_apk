package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.bd;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "", "title", "content", "Landroid/view/View;", "ok", "cancel", "btnStyle", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "alwaysDarkMode", "", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;Z)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showConfirmMsgDialog", "msg", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showConfirmTextDialog", "showFinderIcon", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/Boolean;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnDismissListener;)Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "showCreateFinderUserDialog", "", "scene", "intent", "Landroid/content/Intent;", "showCreateFinderUserDialogOnLiveWithCallback", "Landroid/app/Activity;", "requestCode", "showOverSeaAgreeConfirmDiaglog", "showRealNameCertificationDialog", "showRealNameCertificationDialogWithCallback", "showUserInfoConfirmDialog", "finderUserName", "dismiss", "showUserInfoConfirmDialogOnLiveRedPacket", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBottomCustomDialogHelper$Companion
{
  private static final void showConfirmDialog$lambda-11(com.tencent.mm.ui.widget.a.f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344186);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344186);
  }
  
  private static final void showConfirmDialog$lambda-12(com.tencent.mm.ui.widget.a.f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344193);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344193);
  }
  
  private static final void showConfirmDialog$lambda-13(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344199);
    if (paramOnDismissListener != null) {
      paramOnDismissListener.onDismiss(null);
    }
    AppMethodBeat.o(344199);
  }
  
  private static final void showConfirmDialog$lambda-14(com.tencent.mm.ui.widget.a.f paramf, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(344203);
    kotlin.g.b.s.u(paramf, "$dialog");
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$rootViewContainer");
    params.clear();
    paramf.setFooterView(null);
    paramf.setFooterView((View)paramRoundedCornerFrameLayout);
    AppMethodBeat.o(344203);
  }
  
  private static final void showConfirmTextDialog$lambda-15(com.tencent.mm.ui.widget.a.f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344215);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344215);
  }
  
  private static final void showConfirmTextDialog$lambda-16(com.tencent.mm.ui.widget.a.f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344219);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344219);
  }
  
  private static final void showConfirmTextDialog$lambda-17(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344226);
    if (paramOnDismissListener != null) {
      paramOnDismissListener.onDismiss(null);
    }
    AppMethodBeat.o(344226);
  }
  
  private static final void showConfirmTextDialog$lambda-18(com.tencent.mm.ui.widget.a.f paramf, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(344233);
    kotlin.g.b.s.u(paramf, "$dialog");
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$rootViewContainer");
    params.clear();
    paramf.setFooterView(null);
    paramf.setFooterView((View)paramRoundedCornerFrameLayout);
    AppMethodBeat.o(344233);
  }
  
  private static final void showCreateFinderUserDialog$lambda-4(Intent paramIntent, int paramInt1, Context paramContext, DialogInterface paramDialogInterface, int paramInt2)
  {
    AppMethodBeat.i(344145);
    kotlin.g.b.s.u(paramContext, "$context");
    paramDialogInterface = paramIntent;
    if (paramIntent == null) {
      paramDialogInterface = new Intent();
    }
    paramDialogInterface.putExtra("key_create_scene", paramInt1);
    com.tencent.mm.plugin.finder.utils.a.GfO.x(paramContext, paramDialogInterface);
    ((ce)h.ax(ce.class)).a(q.bd.DAE);
    AppMethodBeat.o(344145);
  }
  
  private static final void showCreateFinderUserDialog$lambda-5(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(344153);
    ((ce)h.ax(ce.class)).a(q.bd.DAD);
    AppMethodBeat.o(344153);
  }
  
  private static final void showCreateFinderUserDialogOnLiveWithCallback$lambda-2(Intent paramIntent, int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface paramDialogInterface, int paramInt3)
  {
    AppMethodBeat.i(344128);
    kotlin.g.b.s.u(paramActivity, "$context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("key_create_scene", paramInt1);
    paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.e(paramActivity, localIntent, paramInt2);
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(paramDialogInterface, paramInt3);
    }
    AppMethodBeat.o(344128);
  }
  
  private static final void showOverSeaAgreeConfirmDiaglog$lambda-10(com.tencent.mm.ui.widget.a.f paramf, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(344182);
    kotlin.g.b.s.u(paramf, "$dialog");
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$rootViewContainer");
    params.clear();
    paramf.setFooterView(null);
    paramf.setFooterView((View)paramRoundedCornerFrameLayout);
    AppMethodBeat.o(344182);
  }
  
  private static final void showOverSeaAgreeConfirmDiaglog$lambda-8(com.tencent.mm.ui.widget.a.f paramf, DialogInterface.OnClickListener paramOnClickListener, View paramView)
  {
    AppMethodBeat.i(344172);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramOnClickListener);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, -1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344172);
  }
  
  private static final void showOverSeaAgreeConfirmDiaglog$lambda-9(com.tencent.mm.ui.widget.a.f paramf, View paramView)
  {
    AppMethodBeat.i(344177);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "$dialog");
    paramf.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344177);
  }
  
  private static final void showRealNameCertificationDialog$lambda-6(Activity paramActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(344159);
    kotlin.g.b.s.u(paramActivity, "$context");
    paramDialogInterface = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.aK(paramActivity);
    ((ce)h.ax(ce.class)).a(q.bd.DAE);
    AppMethodBeat.o(344159);
  }
  
  private static final void showRealNameCertificationDialog$lambda-7(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(344165);
    ((ce)h.ax(ce.class)).a(q.bd.DAD);
    AppMethodBeat.o(344165);
  }
  
  private static final void showRealNameCertificationDialogWithCallback$lambda-3(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(344136);
    kotlin.g.b.s.u(paramActivity, "$context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.aK(paramActivity);
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(paramDialogInterface, paramInt);
    }
    AppMethodBeat.o(344136);
  }
  
  public final com.tencent.mm.ui.widget.a.f showConfirmDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, View paramView, String paramString2, String paramString3, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    AppMethodBeat.i(370620);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramView, "content");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    Object localObject;
    if (paramBoolean)
    {
      localObject = View.inflate(paramContext, e.f.finder_bottom_custom_confirm_dark, null);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(370620);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      ((FrameLayout)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_content)).addView(paramView);
      paramView = (WeImageView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_icon);
      if (paramDrawable == null) {
        break label369;
      }
      paramView.setImageDrawable(paramDrawable);
      label118:
      if (paramInt == -1) {
        break label384;
      }
      paramView.setIconColor(paramInt);
      label129:
      paramDrawable = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_title);
      if (!Util.isNullOrNil(paramString1)) {
        paramDrawable.setText((CharSequence)paramString1);
      }
      paramDrawable = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.ok_btn);
      if (!Util.isNullOrNil(paramString2)) {
        paramDrawable.setText((CharSequence)paramString2);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.cancel_btn);
      if (!Util.isNullOrNil(paramString3)) {
        paramString1.setText((CharSequence)paramString3);
      }
      ((RoundedCornerFrameLayout)localObject).A(bd.fromDPToPix(paramContext, 12), bd.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramDrawable.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda7(localf, paramOnClickListener1));
      paramString1.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda11(localf, paramOnClickListener2));
      localf.aeLi = new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda16(paramOnDismissListener);
      localf.Vtg = new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda12(localf, (RoundedCornerFrameLayout)localObject);
      if (paramInteger != null) {
        break label399;
      }
    }
    for (;;)
    {
      localf.uR(true);
      localf.dDn();
      AppMethodBeat.o(370620);
      return localf;
      localObject = View.inflate(paramContext, e.f.finder_bottom_custom_confirm, null);
      if (localObject == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(370620);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      break;
      label369:
      paramView.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, e.g.icons_outlined_finder_icon));
      break label118;
      label384:
      paramView.setIconColor(com.tencent.mm.cd.a.w(paramContext, e.b.Orange));
      break label129;
      label399:
      if (paramInteger.intValue() == 1)
      {
        paramDrawable.setTextColor(paramContext.getResources().getColor(e.b.white_text_color_selector));
        paramDrawable.setBackground(paramContext.getResources().getDrawable(e.d.finder_live_post_btn_red));
      }
    }
  }
  
  public final com.tencent.mm.ui.widget.a.f showConfirmMsgDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344429);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString2, "msg");
    View localView = View.inflate(paramContext, e.f.finder_bottom_content_msg, null);
    ((TextView)localView.findViewById(e.e.finder_msg)).setText((CharSequence)Util.nullAsNil(paramString2));
    kotlin.g.b.s.s(localView, "msgContainer");
    paramContext = showConfirmDialog$default(this, paramContext, paramDrawable, paramInt, paramString1, localView, paramString3, paramString4, paramInteger, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener, false, 2048, null);
    AppMethodBeat.o(344429);
    return paramContext;
  }
  
  public final com.tencent.mm.ui.widget.a.f showConfirmTextDialog(Context paramContext, Drawable paramDrawable, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, DialogInterface.OnClickListener paramOnClickListener1, Boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344458);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString2, "content");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    Object localObject = View.inflate(paramContext, e.f.finder_bottom_custom_text_confirm, null);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(344458);
      throw paramContext;
    }
    localObject = (RoundedCornerFrameLayout)localObject;
    ((TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_content)).setText((CharSequence)paramString2);
    paramString2 = (WeImageView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_icon);
    if (paramDrawable != null)
    {
      paramString2.setImageDrawable(paramDrawable);
      if (paramInt == -1) {
        break label355;
      }
      paramString2.setIconColor(paramInt);
      label127:
      if (!kotlin.g.b.s.p(paramBoolean, Boolean.TRUE)) {
        break label370;
      }
      paramString2.setVisibility(0);
      label144:
      paramDrawable = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_title);
      if (!Util.isNullOrNil(paramString1)) {
        paramDrawable.setText((CharSequence)paramString1);
      }
      paramDrawable = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.ok_btn);
      if (!Util.isNullOrNil(paramString3)) {
        paramDrawable.setText((CharSequence)paramString3);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.cancel_btn);
      if (!Util.isNullOrNil(paramString4)) {
        paramString1.setText((CharSequence)paramString4);
      }
      ((RoundedCornerFrameLayout)localObject).A(bd.fromDPToPix(paramContext, 12), bd.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramDrawable.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda10(localf, paramOnClickListener1));
      paramString1.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda8(localf, paramOnClickListener2));
      localf.aeLi = new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda15(paramOnDismissListener);
      localf.Vtg = new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda14(localf, (RoundedCornerFrameLayout)localObject);
      if (paramInteger != null) {
        break label380;
      }
    }
    for (;;)
    {
      localf.uR(true);
      localf.dDn();
      AppMethodBeat.o(344458);
      return localf;
      paramString2.setImageDrawable(com.tencent.mm.cd.a.m(paramContext, e.g.icons_outlined_finder_icon));
      break;
      label355:
      paramString2.setIconColor(com.tencent.mm.cd.a.w(paramContext, e.b.Orange));
      break label127;
      label370:
      paramString2.setVisibility(8);
      break label144;
      label380:
      if (paramInteger.intValue() == 1)
      {
        paramDrawable.setTextColor(paramContext.getResources().getColor(e.b.white_text_color_selector));
        paramDrawable.setBackground(paramContext.getResources().getDrawable(e.d.finder_live_post_btn_red));
        paramString1.setTextColor(paramContext.getResources().getColor(e.b.room_live_logo_color));
      }
    }
  }
  
  public final void showCreateFinderUserDialog(Context paramContext, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(344396);
    kotlin.g.b.s.u(paramContext, "context");
    String str1 = paramContext.getString(e.h.finder_create_finder_title);
    kotlin.g.b.s.s(str1, "context.getString(R.stri…nder_create_finder_title)");
    String str2 = paramContext.getString(e.h.finder_create_finder_msg);
    kotlin.g.b.s.s(str2, "context.getString(R.stri…finder_create_finder_msg)");
    String str3 = paramContext.getString(e.h.finder_create_finder_ok_button);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…_create_finder_ok_button)");
    String str4 = paramContext.getString(e.h.finder_create_finder_cancel_button);
    kotlin.g.b.s.s(str4, "context.getString(R.stri…ate_finder_cancel_button)");
    showConfirmMsgDialog$default(this, paramContext, null, 0, str1, str2, str3, str4, null, new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda3(paramIntent, paramInt, paramContext), null, FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda4.INSTANCE, 646, null);
    AppMethodBeat.o(344396);
  }
  
  public final void showCreateFinderUserDialogOnLiveWithCallback(Activity paramActivity, int paramInt1, Intent paramIntent, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344381);
    kotlin.g.b.s.u(paramActivity, "context");
    String str1 = paramActivity.getString(e.h.finder_create_title);
    kotlin.g.b.s.s(str1, "context.getString(R.string.finder_create_title)");
    String str2 = paramActivity.getString(e.h.finder_create_contact_tips);
    kotlin.g.b.s.s(str2, "context.getString(R.stri…nder_create_contact_tips)");
    String str3 = paramActivity.getString(e.h.finder_go_to_create_finder_account);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…to_create_finder_account)");
    String str4 = paramActivity.getString(e.h.finder_create_finder_cancel_button);
    kotlin.g.b.s.s(str4, "context.getString(R.stri…ate_finder_cancel_button)");
    showConfirmMsgDialog$default(this, (Context)paramActivity, null, 0, str1, str2, str3, str4, Integer.valueOf(1), new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda2(paramIntent, paramInt1, paramActivity, paramInt2, paramOnClickListener1), paramOnClickListener2, paramOnDismissListener, 6, null);
    AppMethodBeat.o(344381);
  }
  
  public final void showOverSeaAgreeConfirmDiaglog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(344418);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "title");
    kotlin.g.b.s.u(paramString2, "content");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    Object localObject = View.inflate(paramContext, e.f.finder_bottom_oversea_confirm, null);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
      AppMethodBeat.o(344418);
      throw paramContext;
    }
    localObject = (RoundedCornerFrameLayout)localObject;
    ((RoundedCornerFrameLayout)localObject).A(bd.fromDPToPix(paramContext, 12), bd.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
    ((TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_title)).setText((CharSequence)paramString1);
    ((TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.finder_content)).setText((CharSequence)paramString2);
    TextView localTextView1 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.wx_service);
    TextView localTextView2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(e.e.wx_private);
    paramString2 = h.baE().ban().d(274436, "").toString();
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
    paramString1 = paramContext.getResources().getString(b.i.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), paramString2, "setting", Integer.valueOf(0), Integer.valueOf(0) });
    kotlin.g.b.s.s(paramString1, "context.resources.getStr…tryCode, \"setting\", 0, 0)");
    paramString2 = paramContext.getResources().getString(b.i.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), paramString2 });
    kotlin.g.b.s.s(paramString2, "context.resources.getStr…nLanguage(), countryCode)");
    am localam = am.aixg;
    paramString2 = String.format("<a href='%s'>%s</a>", Arrays.copyOf(new Object[] { paramString2, paramContext.getResources().getString(b.i.license_detail) }, 2));
    kotlin.g.b.s.s(paramString2, "java.lang.String.format(format, *args)");
    localTextView1.setText((CharSequence)paramString2);
    paramString2 = am.aixg;
    paramContext = String.format("<a href='%s'>%s</a>", Arrays.copyOf(new Object[] { paramString1, paramContext.getResources().getString(b.i.privacy_detail) }, 2));
    kotlin.g.b.s.s(paramContext, "java.lang.String.format(format, *args)");
    localTextView2.setText((CharSequence)paramContext);
    p.t(localTextView1, 1);
    p.t(localTextView2, 1);
    paramContext = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.ok_btn);
    paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(e.e.cancel_btn);
    paramContext.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda9(localf, paramOnClickListener));
    paramString1.setOnClickListener(new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda6(localf));
    localf.Vtg = new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda13(localf, (RoundedCornerFrameLayout)localObject);
    localf.uR(true);
    localf.dDn();
    AppMethodBeat.o(344418);
  }
  
  public final void showRealNameCertificationDialog(Activity paramActivity)
  {
    AppMethodBeat.i(344403);
    kotlin.g.b.s.u(paramActivity, "context");
    Drawable localDrawable = com.tencent.mm.cd.a.m((Context)paramActivity, e.g.icons_outlined_wechat);
    int i = com.tencent.mm.cd.a.w((Context)paramActivity, e.b.transparent);
    String str1 = paramActivity.getString(e.h.finder_real_name_title);
    kotlin.g.b.s.s(str1, "context.getString(R.string.finder_real_name_title)");
    String str2 = paramActivity.getString(e.h.finder_real_name_msg);
    kotlin.g.b.s.s(str2, "context.getString(R.string.finder_real_name_msg)");
    String str3 = paramActivity.getString(e.h.finder_real_name_ok_button);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…nder_real_name_ok_button)");
    String str4 = paramActivity.getString(e.h.finder_real_name_cancel_button);
    kotlin.g.b.s.s(str4, "context.getString(R.stri…_real_name_cancel_button)");
    showConfirmMsgDialog$default(this, (Context)paramActivity, localDrawable, i, str1, str2, str3, str4, null, new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda0(paramActivity), null, FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda5.INSTANCE, 640, null);
    AppMethodBeat.o(344403);
  }
  
  public final void showRealNameCertificationDialogWithCallback(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(344387);
    kotlin.g.b.s.u(paramActivity, "context");
    Drawable localDrawable = com.tencent.mm.cd.a.m((Context)paramActivity, e.g.icons_outlined_finder_icon);
    int i = com.tencent.mm.cd.a.w((Context)paramActivity, e.b.Orange);
    String str1 = paramActivity.getString(e.h.finder_create_title);
    kotlin.g.b.s.s(str1, "context.getString(R.string.finder_create_title)");
    String str2 = paramActivity.getString(e.h.finder_create_accout_need_real_name_title);
    kotlin.g.b.s.s(str2, "context.getString(R.stri…out_need_real_name_title)");
    String str3 = paramActivity.getString(e.h.finder_real_name_ok_button);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…nder_real_name_ok_button)");
    String str4 = paramActivity.getString(e.h.finder_real_name_cancel_button);
    kotlin.g.b.s.s(str4, "context.getString(R.stri…_real_name_cancel_button)");
    showConfirmMsgDialog((Context)paramActivity, localDrawable, i, str1, str2, str3, str4, Integer.valueOf(1), new FinderBottomCustomDialogHelper.Companion..ExternalSyntheticLambda1(paramActivity, paramOnClickListener1), paramOnClickListener2, paramOnDismissListener);
    AppMethodBeat.o(344387);
  }
  
  public final void showUserInfoConfirmDialog(Context paramContext, String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnDismissListener paramOnDismissListener, final boolean paramBoolean)
  {
    AppMethodBeat.i(370618);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "finderUserName");
    final String str1 = paramContext.getString(e.h.finder_user_info_confirm_title);
    kotlin.g.b.s.s(str1, "context.getString(R.stri…_user_info_confirm_title)");
    final String str2 = paramContext.getString(e.h.finder_user_info_ok_button);
    kotlin.g.b.s.s(str2, "context.getString(R.stri…nder_user_info_ok_button)");
    final String str3 = paramContext.getString(e.h.finder_user_info_cancel_button);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…_user_info_cancel_button)");
    if (paramBoolean) {}
    for (final View localView = View.inflate(paramContext, e.f.finder_bottom_content_user_info_dark, null); localView == null; localView = View.inflate(paramContext, e.f.finder_bottom_content_user_info, null))
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(370618);
      throw paramContext;
    }
    new FinderBottomCustomDialogHelper.UserInfoHelper(paramContext, paramString, (ViewGroup)localView).load((kotlin.g.a.b)new u(paramContext)
    {
      private static final void invoke$lambda-0(DialogInterface.OnDismissListener paramAnonymousOnDismissListener, DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(344086);
        if (paramAnonymousOnDismissListener != null) {
          paramAnonymousOnDismissListener.onDismiss(paramAnonymousDialogInterface);
        }
        ((ce)h.ax(ce.class)).a(q.bd.DAD);
        AppMethodBeat.o(344086);
      }
      
      public final void invoke(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(344105);
        if (paramAnonymousBoolean)
        {
          FinderBottomCustomDialogHelper.Companion localCompanion = FinderBottomCustomDialogHelper.Companion;
          Context localContext = this.$context;
          String str = str1;
          View localView = localView;
          kotlin.g.b.s.s(localView, "userInfoContainer");
          FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(localCompanion, localContext, null, 0, str, localView, str2, str3, Integer.valueOf(1), paramOnClickListener1, paramOnClickListener2, new FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog.1.1..ExternalSyntheticLambda0(paramOnDismissListener), paramBoolean, 6, null);
          AppMethodBeat.o(344105);
          return;
        }
        aa.y(this.$context, this.$context.getString(e.h.sns_request_timeout), e.g.icons_filled_error);
        AppMethodBeat.o(344105);
      }
    });
    AppMethodBeat.o(370618);
  }
  
  public final void showUserInfoConfirmDialogOnLiveRedPacket(Context paramContext, String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(344376);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "finderUserName");
    final String str1 = paramContext.getString(e.h.finder_user_info_confirm_title);
    kotlin.g.b.s.s(str1, "context.getString(R.stri…_user_info_confirm_title)");
    final String str2 = paramContext.getString(e.h.finder_user_info_ok_button);
    kotlin.g.b.s.s(str2, "context.getString(R.stri…nder_user_info_ok_button)");
    final String str3 = paramContext.getString(e.h.finder_user_info_cancel_button);
    kotlin.g.b.s.s(str3, "context.getString(R.stri…_user_info_cancel_button)");
    final View localView = View.inflate(paramContext, e.f.finder_bottom_content_user_info, null);
    if (localView == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(344376);
      throw paramContext;
    }
    new FinderBottomCustomDialogHelper.UserInfoHelper(paramContext, paramString, (ViewGroup)localView).load((kotlin.g.a.b)new u(paramContext)
    {
      private static final void invoke$lambda-0(DialogInterface paramAnonymousDialogInterface) {}
      
      public final void invoke(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(345269);
        if (paramAnonymousBoolean)
        {
          FinderBottomCustomDialogHelper.Companion localCompanion = FinderBottomCustomDialogHelper.Companion;
          FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialogOnLiveRedPacket.1.1..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialogOnLiveRedPacket.1.1..ExternalSyntheticLambda0.INSTANCE;
          Context localContext = this.$context;
          String str = str1;
          View localView = localView;
          kotlin.g.b.s.s(localView, "userInfoContainer");
          FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(localCompanion, localContext, null, 0, str, localView, str2, str3, Integer.valueOf(1), paramOnClickListener1, paramOnClickListener2, localExternalSyntheticLambda0, false, 2054, null);
          AppMethodBeat.o(345269);
          return;
        }
        aa.y(this.$context, this.$context.getString(e.h.sns_request_timeout), e.g.icons_filled_error);
        AppMethodBeat.o(345269);
      }
    });
    AppMethodBeat.o(344376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion
 * JD-Core Version:    0.7.0.1
 */