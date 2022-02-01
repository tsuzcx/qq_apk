package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.liteapp.ui.WxaLiteAppBaseFragment.a;
import com.tencent.liteapp.ui.WxaLiteAppFragment;
import com.tencent.luggage.f.a.a;
import com.tencent.luggage.f.a.b;
import com.tencent.luggage.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppSheetUI;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "luggage-lite-app_release"})
public final class WxaLiteAppSheetUI
  extends AppCompatActivity
{
  public static final a Ehi;
  public static Fragment fragment;
  
  static
  {
    AppMethodBeat.i(234061);
    Ehi = new a((byte)0);
    AppMethodBeat.o(234061);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(234059);
    super.finish();
    overridePendingTransition(a.a.alpha_in, a.a.alpha_out);
    AppMethodBeat.o(234059);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234057);
    super.onCreate(paramBundle);
    setContentView(a.c.lite_app_sheet_ui);
    overridePendingTransition(a.a.alpha_in, a.a.alpha_out);
    paramBundle = getSupportFragmentManager();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.beginTransaction();; paramBundle = null)
    {
      Object localObject1 = findViewById(a.b.fragment_container);
      p.j(localObject1, "findViewById(R.id.fragment_container)");
      localObject1 = (FrameLayout)localObject1;
      Object localObject2 = getIntent().getBundleExtra("bundle");
      if ((localObject2 != null) && (((Bundle)localObject2).containsKey("sheet_height")))
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        WindowManager localWindowManager = getWindowManager();
        p.j(localWindowManager, "windowManager");
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        localObject2 = new FrameLayout.LayoutParams(-1, ((Bundle)localObject2).getInt("sheet_height", localDisplayMetrics.heightPixels / 2));
        ((FrameLayout.LayoutParams)localObject2).gravity = 80;
        ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = new WxaLiteAppBaseFragment.a(WxaLiteAppFragment.class).NH();
      p.j(localObject1, "WxaLiteAppBaseFragment.F…ment::class.java).build()");
      fragment = (Fragment)localObject1;
      if (paramBundle != null)
      {
        int i = a.b.fragment_container;
        localObject1 = fragment;
        if (localObject1 == null) {
          p.bGy("fragment");
        }
        paramBundle.a(i, (Fragment)localObject1);
      }
      if (paramBundle == null) {
        break;
      }
      paramBundle.in();
      AppMethodBeat.o(234057);
      return;
    }
    AppMethodBeat.o(234057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppSheetUI$Companion;", "", "()V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "luggage-lite-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppSheetUI
 * JD-Core Version:    0.7.0.1
 */