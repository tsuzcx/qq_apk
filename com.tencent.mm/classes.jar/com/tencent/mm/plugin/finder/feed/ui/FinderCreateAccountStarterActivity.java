package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.a.ip;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "bottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "cancelText", "", "confirmText", "contentText", "enterScene", "", "isSendEvent", "", "titleText", "convertActivityFromTranslucent", "finish", "", "getExtraJson", "Lcom/tencent/mm/json/JSONObject;", "getLayoutId", "initActivityCloseAnimation", "initDialog", "context", "Landroid/content/Context;", "initParam", "extraJson", "isSupportNavigationSwipeBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onNewIntent", "intent", "Landroid/content/Intent;", "sendEvent", "eventType", "showCreateContactDialog", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCreateAccountStarterActivity
  extends MMFinderUI
{
  public static final a Bmg;
  private String Bmh = "";
  private String Bmi = "";
  private String Bmj = "";
  private String Bmk = "";
  private d Bml;
  private int enterScene = 15;
  private boolean uGv;
  
  static
  {
    AppMethodBeat.i(365329);
    Bmg = new a((byte)0);
    AppMethodBeat.o(365329);
  }
  
  private final void Of(int paramInt)
  {
    AppMethodBeat.i(365296);
    Log.i("OccupyFinderUI24", s.X("sendEvent :", Integer.valueOf(paramInt)));
    this.uGv = true;
    ip localip = new ip();
    localip.hKc.result = paramInt;
    localip.publish();
    AppMethodBeat.o(365296);
  }
  
  private final void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(365263);
    Log.i("OccupyFinderUI24", "showCreateContactDialog");
    b(paramContext, parami);
    d locald = this.Bml;
    if (locald == null) {
      parami = null;
    }
    for (;;)
    {
      if (parami == null)
      {
        this.Bml = new d(paramContext);
        parami = this.Bml;
        s.checkNotNull(parami);
        a(paramContext, parami);
        paramContext = this.Bml;
        if (paramContext != null) {
          paramContext.dDn();
        }
      }
      AppMethodBeat.o(365263);
      return;
      parami = locald;
      if (!locald.isShowing())
      {
        locald.dDn();
        parami = locald;
      }
    }
  }
  
  private final void a(Context paramContext, d paramd)
  {
    AppMethodBeat.i(365288);
    paramd.UD(e.f.finder_jsapi_create_account_dialog);
    TextView localTextView = (TextView)paramd.rootView.findViewById(e.e.finder_activity_detail_dialog_title);
    int i;
    if (localTextView != null)
    {
      if (((CharSequence)this.Bmh).length() <= 0) {
        break label271;
      }
      i = 1;
      if (i == 0) {
        break label276;
      }
      localTextView.setText((CharSequence)this.Bmh);
      aw.a((Paint)localTextView.getPaint(), 0.8F);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      localTextView = (TextView)paramd.rootView.findViewById(e.e.finder_activity_detail_dialog_content);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)this.Bmi);
        aw.a((Paint)localTextView.getPaint(), 0.8F);
      }
      localTextView = (TextView)paramd.rootView.findViewById(e.e.finder_jsapi_create_account_dialog_cancel);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)this.Bmj);
        aw.a((Paint)localTextView.getPaint(), 0.8F);
        localTextView.setOnClickListener(new FinderCreateAccountStarterActivity..ExternalSyntheticLambda1(paramd));
      }
      localTextView = (TextView)paramd.rootView.findViewById(e.e.finder_jsapi_create_account_dialog_create);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)this.Bmk);
        aw.a((Paint)localTextView.getPaint(), 0.8F);
      }
      if (localTextView != null) {
        localTextView.setOnClickListener(new FinderCreateAccountStarterActivity..ExternalSyntheticLambda0(this, paramContext, paramd));
      }
      paramd.GwT = new FinderCreateAccountStarterActivity..ExternalSyntheticLambda2(this);
      AppMethodBeat.o(365288);
      return;
      label271:
      i = 0;
      break;
      label276:
      localTextView.setVisibility(8);
    }
  }
  
  private static final void a(FinderCreateAccountStarterActivity paramFinderCreateAccountStarterActivity)
  {
    AppMethodBeat.i(365323);
    s.u(paramFinderCreateAccountStarterActivity, "this$0");
    if (!paramFinderCreateAccountStarterActivity.uGv) {
      paramFinderCreateAccountStarterActivity.Of(2);
    }
    paramFinderCreateAccountStarterActivity.Bml = null;
    if (!paramFinderCreateAccountStarterActivity.isFinishing()) {
      paramFinderCreateAccountStarterActivity.finish();
    }
    AppMethodBeat.o(365323);
  }
  
  private static final void a(FinderCreateAccountStarterActivity paramFinderCreateAccountStarterActivity, Context paramContext, d paramd, View paramView)
  {
    AppMethodBeat.i(365316);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderCreateAccountStarterActivity);
    localb.cH(paramContext);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCreateAccountStarterActivity, "this$0");
    s.u(paramContext, "$context");
    s.u(paramd, "$bottomSheet");
    if (!Util.isNullOrNil(z.bAW())) {
      paramFinderCreateAccountStarterActivity.Of(4);
    }
    for (;;)
    {
      paramFinderCreateAccountStarterActivity.uGv = true;
      paramd.cyW();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365316);
      return;
      if ((paramContext instanceof Activity))
      {
        paramView = new Intent();
        paramView.putExtra("key_create_scene", paramFinderCreateAccountStarterActivity.enterScene);
        paramView.putExtra("key_router_to_profile", false);
        com.tencent.mm.plugin.finder.utils.a.GfO.x(paramContext, paramView);
      }
    }
  }
  
  private final void b(Context paramContext, i parami)
  {
    AppMethodBeat.i(365274);
    if (parami != null)
    {
      Object localObject2 = parami.Ft("tipsWording");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        String str = parami.optString("tipsWording");
        localObject1 = localObject2;
        if (!Util.isNullOrNil(str)) {
          localObject1 = new i(str);
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).optString("title");
        s.s(localObject2, "optString(\"title\")");
        this.Bmh = ((String)localObject2);
        localObject2 = ((i)localObject1).optString("tip");
        s.s(localObject2, "optString(\"tip\")");
        this.Bmi = ((String)localObject2);
        localObject2 = ((i)localObject1).optString("cancelWording");
        s.s(localObject2, "optString(\"cancelWording\")");
        this.Bmj = ((String)localObject2);
        localObject1 = ((i)localObject1).optString("confirmWording");
        s.s(localObject1, "optString(\"confirmWording\")");
        this.Bmk = ((String)localObject1);
      }
      this.enterScene = parami.optInt("scene");
    }
    if (((CharSequence)this.Bmi).length() == 0)
    {
      i = 1;
      if (i != 0)
      {
        parami = paramContext.getResources().getString(e.h.finder_create_account_dialog_default_tips);
        s.s(parami, "context.resources.getStr…ount_dialog_default_tips)");
        this.Bmi = parami;
      }
      if (((CharSequence)this.Bmj).length() != 0) {
        break label316;
      }
      i = 1;
      label233:
      if (i != 0)
      {
        parami = paramContext.getResources().getString(e.h.finder_create_account_dialog_cancel);
        s.s(parami, "context.resources.getStr…te_account_dialog_cancel)");
        this.Bmj = parami;
      }
      if (((CharSequence)this.Bmk).length() != 0) {
        break label321;
      }
    }
    label316:
    label321:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramContext = paramContext.getResources().getString(e.h.finder_create_account_dialog_confirm);
        s.s(paramContext, "context.resources.getStr…e_account_dialog_confirm)");
        this.Bmk = paramContext;
      }
      AppMethodBeat.o(365274);
      return;
      i = 0;
      break;
      i = 0;
      break label233;
    }
  }
  
  private static final void c(d paramd, View paramView)
  {
    AppMethodBeat.i(365304);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$bottomSheet");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365304);
  }
  
  private final i eeI()
  {
    AppMethodBeat.i(365256);
    Object localObject = getIntent().getStringExtra("param_extra_info");
    if ((localObject != null) && (!Util.isNullOrNil((String)localObject)))
    {
      localObject = new i((String)localObject);
      AppMethodBeat.o(365256);
      return localObject;
    }
    AppMethodBeat.o(365256);
    return null;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365386);
    super.finish();
    int i = e.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(365386);
  }
  
  public final int getLayoutId()
  {
    return e.f.qq_music_dialog_wrapper_layout;
  }
  
  public final void initActivityCloseAnimation() {}
  
  public final boolean isSupportNavigationSwipeBack()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365393);
    super.onCreate(paramBundle);
    hideTitleView();
    a((Context)this, eeI());
    AppMethodBeat.o(365393);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(365356);
    super.onCreateBeforeSetContentView();
    if (aw.isDarkMode())
    {
      setTheme(e.i.MMTheme_Holo_FinderDarkTransparent);
      AppMethodBeat.o(365356);
      return;
    }
    setTheme(e.i.MMTheme_Holo_FinderLightTransparent);
    AppMethodBeat.o(365356);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(365404);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a((Context)this, eeI());
    AppMethodBeat.o(365404);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCreateAccountStarterActivity$Companion;", "", "()V", "PARAM_EXTRA_INFO", "", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderCreateAccountStarterActivity
 * JD-Core Version:    0.7.0.1
 */