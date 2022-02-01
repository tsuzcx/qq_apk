package com.tencent.mm.plugin.appbrand.ui.privacy;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/AppBrandPrivacyPageContainerUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandPrivacyPageContainerUI
  extends MMActivity
{
  public static final a uiG;
  
  static
  {
    AppMethodBeat.i(322733);
    uiG = new a((byte)0);
    AppMethodBeat.o(322733);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(322749);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = d.U(paramBundle))
    {
      paramBundle = (AppBrandPrivacyPageContainerUI)this;
      Log.w("MicroMsg.AppBrandPrivacyPageContainerUI", "onCreate, fragment is null");
      paramBundle.finish();
      AppMethodBeat.o(322749);
      return;
    }
    r localr = getSupportFragmentManager().beginTransaction();
    Intent localIntent = getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      paramBundle.setArguments((Bundle)localObject);
      localObject = ah.aiuX;
      localr.a(16908290, (Fragment)paramBundle).FW();
      AppMethodBeat.o(322749);
      return;
      localObject = localIntent.getExtras();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/AppBrandPrivacyPageContainerUI$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.AppBrandPrivacyPageContainerUI
 * JD-Core Version:    0.7.0.1
 */