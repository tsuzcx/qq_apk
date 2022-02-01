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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.report.model.o.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.a.d.a;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI
  extends MMActivity
  implements f
{
  public final void bv(String paramString, int paramInt)
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
    setTheme(2131821149);
    super.onCreate(paramBundle);
    ai.b(getWindow());
    paramBundle = j.aOB();
    if (paramBundle == null)
    {
      super.finish();
      AppMethodBeat.o(48616);
      return;
    }
    AppBrandStickyBannerLogic.b.d(this);
    Object localObject = new d.a(this);
    ((d.a)localObject).aau(2131755401);
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(2131230984);
    TextView localTextView = new TextView(this);
    localTextView.setText(2131755457);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.argb(Math.round(137.70001F), 0, 0, 0));
    localTextView.setLineSpacing(0.0F, 1.2F);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-1, -2));
    ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 16);
    ((d.a)localObject).gs(localLinearLayout);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48610);
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48610);
      }
    });
    ((d.a)localObject).aaC(2131757429);
    ((d.a)localObject).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48611);
        o.a(o.a.lsm, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48611);
      }
    });
    ((d.a)localObject).aaB(2131755456);
    ((d.a)localObject).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48612);
        paramAnonymousDialogInterface = AppBrandGuideUI.this;
        Object localObject = new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        o.a(o.a.lsn, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48612);
      }
    });
    ((d.a)localObject).wX(false);
    ((d.a)localObject).wY(true);
    localObject = ((d.a)localObject).fft();
    ((Dialog)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(48613);
        if (4 == paramAnonymousInt)
        {
          if (1 == paramAnonymousKeyEvent.getAction())
          {
            o.a(o.a.lso, "");
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
    o.a(o.a.lsl, paramBundle.lzy);
    paramBundle.lzx = false;
    paramBundle.lzy = null;
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
    public boolean lzx = false;
    String lzy;
    
    public static Application bod()
    {
      AppMethodBeat.i(48614);
      Application localApplication = (Application)aj.getContext().getApplicationContext();
      AppMethodBeat.o(48614);
      return localApplication;
    }
    
    public final void MW(String paramString)
    {
      this.lzx = true;
      this.lzy = paramString;
    }
    
    public final void bv(String paramString, int paramInt)
    {
      this.lzx = false;
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof AppBrandGuideUI)) {
        this.lzx = false;
      }
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(48615);
      if (((paramActivity instanceof AppBrandGuideUI)) || ((paramActivity instanceof AppBrandLauncherUI))) {
        this.lzx = false;
      }
      Object localObject;
      int i;
      if ((g.afw()) && (this.lzx))
      {
        localObject = bt.aA(paramActivity, paramActivity.getTaskId());
        if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).baseActivity != null)) {
          break label145;
        }
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          this.lzx = false;
          localObject = new Intent(paramActivity, AppBrandGuideUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI
 * JD-Core Version:    0.7.0.1
 */