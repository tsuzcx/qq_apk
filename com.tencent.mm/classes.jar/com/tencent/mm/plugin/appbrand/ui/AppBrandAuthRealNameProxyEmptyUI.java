package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpaysdk.api.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "makeTranslucent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandAuthRealNameProxyEmptyUI
  extends MMActivity
{
  public static final a tXt;
  
  static
  {
    AppMethodBeat.i(322463);
    tXt = new a((byte)0);
    AppMethodBeat.o(322463);
  }
  
  private final void cKo()
  {
    AppMethodBeat.i(322460);
    ae.g(getWindow());
    ae.c(getWindow(), false);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    b.a((Activity)this, null);
    AppMethodBeat.o(322460);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(322470);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    cKo();
    paramBundle = getIntent();
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getBooleanExtra("key_process_is_end", false) == true) {
        i = 1;
      }
    }
    if (i != 0)
    {
      finish();
      AppMethodBeat.o(322470);
      return;
    }
    paramBundle = getIntent();
    if (paramBundle == null) {
      paramBundle = "";
    }
    while (s.p("startRealNameVerify", paramBundle))
    {
      paramBundle = new Bundle();
      paramBundle.putString("realname_verify_process_jump_activity", ".ui.AppBrandAuthRealNameProxyEmptyUI");
      paramBundle.putString("realname_verify_process_jump_plugin", "appbrand");
      paramBundle.putInt("real_name_verify_mode", 4);
      paramBundle.putInt("entry_scene", 1);
      ((c)h.ax(c.class)).h((Activity)getContext(), paramBundle);
      AppMethodBeat.o(322470);
      return;
      String str = paramBundle.getStringExtra("action");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
    }
    finish();
    AppMethodBeat.o(322470);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(322476);
    super.onResume();
    cKo();
    AppMethodBeat.o(322476);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandAuthRealNameProxyEmptyUI$Companion;", "", "()V", "ACTION_START_REAL_NAME_VERIFY", "", "KEY_ACTION", "startRealNameVerify", "", "context", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthRealNameProxyEmptyUI
 * JD-Core Version:    0.7.0.1
 */