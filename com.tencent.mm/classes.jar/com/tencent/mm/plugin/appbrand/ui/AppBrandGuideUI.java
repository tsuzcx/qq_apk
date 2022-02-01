package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.plugin.appbrand.report.model.r;
import com.tencent.mm.plugin.appbrand.report.model.r.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.e.a;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI
  extends MMActivity
  implements f
{
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(48618);
    finish();
    AppMethodBeat.o(48618);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48616);
    setTheme(ba.j.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    aw.g(getWindow());
    paramBundle = n.cfb();
    if (paramBundle == null)
    {
      super.finish();
      AppMethodBeat.o(48616);
      return;
    }
    AppBrandStickyBannerLogic.b.d(this);
    Object localObject = new e.a(this);
    ((e.a)localObject).aEK(ba.i.app_brand_entrance);
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(ba.e.app_brand_guide_image);
    TextView localTextView = new TextView(this);
    localTextView.setText(ba.i.app_brand_guide_message);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.argb(Math.round(137.70001F), 0, 0, 0));
    localTextView.setLineSpacing(0.0F, 1.2F);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-1, -2));
    ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
    ((e.a)localObject).md(localLinearLayout);
    ((e.a)localObject).c(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48610);
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48610);
      }
    });
    ((e.a)localObject).aES(ba.i.close_btn);
    ((e.a)localObject).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48611);
        r.a(r.a.tQS, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48611);
      }
    });
    ((e.a)localObject).aER(ba.i.app_brand_guide_confirm_view_list);
    ((e.a)localObject).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48612);
        paramAnonymousDialogInterface = AppBrandGuideUI.this;
        Object localObject = new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        r.a(r.a.tQT, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48612);
      }
    });
    ((e.a)localObject).NC(false);
    ((e.a)localObject).ND(true);
    localObject = ((e.a)localObject).jHH();
    ((Dialog)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(48613);
        if (4 == paramAnonymousInt)
        {
          if (1 == paramAnonymousKeyEvent.getAction())
          {
            r.a(r.a.tQU, "");
            AppBrandGuideUI.this.finish();
          }
          AppMethodBeat.o(48613);
          return true;
        }
        AppMethodBeat.o(48613);
        return false;
      }
    });
    ((Dialog)localObject).show();
    r.a(r.a.tQR, paramBundle.uaL);
    paramBundle.uaK = false;
    paramBundle.uaL = null;
    AppMethodBeat.o(48616);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48617);
    super.onDestroy();
    AppBrandStickyBannerLogic.b.c(this);
    AppMethodBeat.o(48617);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    implements Application.ActivityLifecycleCallbacks, f
  {
    public boolean uaK = false;
    String uaL;
    
    public static Application cKQ()
    {
      AppMethodBeat.i(48614);
      Application localApplication = (Application)MMApplicationContext.getContext().getApplicationContext();
      AppMethodBeat.o(48614);
      return localApplication;
    }
    
    public final void agf(String paramString)
    {
      this.uaK = true;
      this.uaL = paramString;
    }
    
    public final void cB(String paramString, int paramInt)
    {
      this.uaK = false;
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof AppBrandGuideUI)) {
        this.uaK = false;
      }
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(48615);
      if (((paramActivity instanceof AppBrandGuideUI)) || ((paramActivity instanceof AppBrandLauncherUI))) {
        this.uaK = false;
      }
      Object localObject;
      int i;
      if ((h.baz()) && (this.uaK))
      {
        localObject = Util.getCurrentTaskInfo(paramActivity, paramActivity.getTaskId());
        if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity != null)) {
          break label145;
        }
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          this.uaK = false;
          localObject = new Intent(paramActivity, AppBrandGuideUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(48615);
        return;
        label145:
        if ((!((ActivityManager.RunningTaskInfo)localObject).baseActivity.getClassName().endsWith(".LauncherUI")) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity.getClassName().contains(".AppBrandUI"))) {
          i = 0;
        } else {
          i = 1;
        }
      }
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI
 * JD-Core Version:    0.7.0.1
 */