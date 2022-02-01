package com.tencent.mm.plugin.lite.ui;

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.liteapp.ui.WxaLiteAppBaseFragment.a;
import com.tencent.liteapp.ui.WxaLiteAppFragment;
import com.tencent.luggage.f.a.a;
import com.tencent.luggage.f.a.b;
import com.tencent.luggage.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/ui/WxaLiteAppSheetUI;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaLiteAppSheetUI
  extends AppCompatActivity
{
  public static final WxaLiteAppSheetUI.a KbP;
  public static Fragment fragment;
  
  static
  {
    AppMethodBeat.i(271415);
    KbP = new WxaLiteAppSheetUI.a((byte)0);
    AppMethodBeat.o(271415);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(271432);
    super.finish();
    overridePendingTransition(a.a.alpha_in, a.a.alpha_out);
    AppMethodBeat.o(271432);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(271427);
    super.onCreate(paramBundle);
    setContentView(a.c.lite_app_sheet_ui);
    overridePendingTransition(a.a.alpha_in, a.a.alpha_out);
    paramBundle = getSupportFragmentManager();
    int i;
    if (paramBundle == null)
    {
      paramBundle = null;
      Object localObject2 = findViewById(a.b.fragment_container);
      s.s(localObject2, "findViewById(R.id.fragment_container)");
      localObject2 = (FrameLayout)localObject2;
      Object localObject3 = getIntent().getBundleExtra("bundle");
      if ((localObject3 != null) && (((Bundle)localObject3).containsKey("sheet_height")))
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        localObject3 = new FrameLayout.LayoutParams(-1, ((Bundle)localObject3).getInt("sheet_height", localDisplayMetrics.heightPixels / 2));
        ((FrameLayout.LayoutParams)localObject3).gravity = 80;
        ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      localObject2 = new WxaLiteAppBaseFragment.a(WxaLiteAppFragment.class).anS();
      s.s(localObject2, "FragmentBuilder(WxaLiteA…ment::class.java).build()");
      localObject2 = (Fragment)localObject2;
      s.u(localObject2, "<set-?>");
      fragment = (Fragment)localObject2;
      if (paramBundle != null)
      {
        i = a.b.fragment_container;
        localObject2 = fragment;
        if (localObject2 == null) {
          break label244;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      paramBundle.a(i, localObject1);
      if (paramBundle != null) {
        paramBundle.FW();
      }
      AppMethodBeat.o(271427);
      return;
      paramBundle = paramBundle.beginTransaction();
      break;
      label244:
      s.bIx("fragment");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppSheetUI
 * JD-Core Version:    0.7.0.1
 */