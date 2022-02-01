package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpaysdk.api.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "makeTranslucent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandAuthRealNameProxyEmptyUI
  extends MMActivity
{
  public static final a qSO;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(265307);
    qSO = new a((byte)0);
    AppMethodBeat.o(265307);
  }
  
  private final void cjo()
  {
    AppMethodBeat.i(265306);
    x.e(getWindow());
    x.d(getWindow(), false);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    b.a((Activity)this, null);
    AppMethodBeat.o(265306);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(265309);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(265309);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(265308);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(265308);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265304);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    cjo();
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("key_process_is_end", false) == true))
    {
      finish();
      AppMethodBeat.o(265304);
      return;
    }
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      String str = paramBundle.getStringExtra("action");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.h("startRealNameVerify", paramBundle))
    {
      paramBundle = new Bundle();
      paramBundle.putString("realname_verify_process_jump_activity", ".ui.AppBrandAuthRealNameProxyEmptyUI");
      paramBundle.putString("realname_verify_process_jump_plugin", "appbrand");
      paramBundle.putInt("real_name_verify_mode", 4);
      paramBundle.putInt("entry_scene", 1);
      ((c)h.ae(c.class)).h((Activity)getContext(), paramBundle);
      AppMethodBeat.o(265304);
      return;
    }
    finish();
    AppMethodBeat.o(265304);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265305);
    super.onResume();
    cjo();
    AppMethodBeat.o(265305);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion;", "", "()V", "ACTION_START_REAL_NAME_VERIFY", "", "KEY_ACTION", "startRealNameVerify", "", "context", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthRealNameProxyEmptyUI
 * JD-Core Version:    0.7.0.1
 */