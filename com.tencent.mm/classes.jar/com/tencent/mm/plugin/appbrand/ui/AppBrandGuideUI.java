package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Dialog;
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
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.report.model.o.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.d.a;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI
  extends MMActivity
  implements f
{
  public final void bJ(String paramString, int paramInt)
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
    setTheme(2131821178);
    super.onCreate(paramBundle);
    ao.e(getWindow());
    paramBundle = n.buB();
    if (paramBundle == null)
    {
      super.finish();
      AppMethodBeat.o(48616);
      return;
    }
    AppBrandStickyBannerLogic.b.d(this);
    Object localObject = new d.a(this);
    ((d.a)localObject).aoO(2131755440);
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(2131231013);
    TextView localTextView = new TextView(this);
    localTextView.setText(2131755495);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.argb(Math.round(137.70001F), 0, 0, 0));
    localTextView.setLineSpacing(0.0F, 1.2F);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-1, -2));
    ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 16);
    ((d.a)localObject).hs(localLinearLayout);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48610);
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48610);
      }
    });
    ((d.a)localObject).aoW(2131757647);
    ((d.a)localObject).d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48611);
        o.a(o.a.nJV, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48611);
      }
    });
    ((d.a)localObject).aoV(2131755494);
    ((d.a)localObject).a(false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(48612);
        paramAnonymousDialogInterface = AppBrandGuideUI.this;
        Object localObject = new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        o.a(o.a.nJW, "");
        AppBrandGuideUI.this.finish();
        AppMethodBeat.o(48612);
      }
    });
    ((d.a)localObject).Dk(false);
    ((d.a)localObject).Dl(true);
    localObject = ((d.a)localObject).hbn();
    ((Dialog)localObject).setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(48613);
        if (4 == paramAnonymousInt)
        {
          if (1 == paramAnonymousKeyEvent.getAction())
          {
            o.a(o.a.nJX, "");
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
    o.a(o.a.nJU, paramBundle.nTF);
    paramBundle.nTE = false;
    paramBundle.nTF = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI
 * JD-Core Version:    0.7.0.1
 */