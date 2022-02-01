package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.k.a;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

public class RecentsFolderActivityContext
  extends FolderActivityContextWithLifecycle
{
  private int ruz = 0;
  private int uny;
  private String unz;
  
  public RecentsFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void T(Intent paramIntent)
  {
    AppMethodBeat.i(49229);
    this.uny = paramIntent.getIntExtra("extra_enter_scene", 1);
    this.unz = paramIntent.getStringExtra("extra_enter_scene_note");
    AppMethodBeat.o(49229);
  }
  
  public final void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(49228);
    if (paramBoolean) {}
    for (Object localObject1 = AppBrandLauncherRecentsList.class;; localObject1 = AppBrandLauncherBlankPage.class)
    {
      localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().findFragmentById(16908290);
      if ((localObject2 == null) || (!((Class)localObject1).isInstance(localObject2))) {
        break;
      }
      AppMethodBeat.o(49228);
      return;
    }
    if ((((MMActivity)getBaseContext()).isFinishing()) || (((MMActivity)getBaseContext()).activityHasDestroyed()) || (((MMActivity)getBaseContext()).isStopped()))
    {
      AppMethodBeat.o(49228);
      return;
    }
    Object localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().beginTransaction();
    if (paramBoolean) {}
    for (localObject1 = new AppBrandLauncherRecentsList((MMActivity)getBaseContext() instanceof AppBrandLauncherUI);; localObject1 = AppBrandLauncherBlankPage.fo(getString(ba.i.app_brand_entrance), getString(ba.i.app_brand_launcher_recents_blank_tip)))
    {
      ((AppBrandLauncherUI.Fragment)localObject1).setScene(this.uny);
      ((AppBrandLauncherUI.Fragment)localObject1).uaZ = this.unz;
      ((r)localObject2).b(16908290, (Fragment)localObject1);
      ((r)localObject2).FW();
      AppMethodBeat.o(49228);
      return;
    }
  }
  
  public void onActivityDidResume()
  {
    AppMethodBeat.i(49230);
    if (((MMActivity)getBaseContext() instanceof AppBrandLauncherUI))
    {
      Object localObject;
      if ((!com.tencent.mm.plugin.appbrand.appusage.h.ciG()) && (!com.tencent.mm.plugin.appbrand.appusage.h.ciH()) && (!p.ciP()))
      {
        k.ciN();
        if (!com.tencent.mm.kernel.h.baz()) {
          break label123;
        }
        localObject = com.tencent.mm.model.newabtest.d.bEt().Fd("100328");
        if ((localObject != null) && (((c)localObject).isValid())) {
          break label85;
        }
        i = 0;
        if (i == 0) {
          break label128;
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        kT(bool);
        AppMethodBeat.o(49230);
        return;
        label85:
        localObject = k.a.zt(Util.getInt((String)((c)localObject).iWZ().get("isOpenGameEntry"), 0));
        if ((localObject != null) && (localObject == k.a.qOO))
        {
          i = 1;
          break;
        }
        label123:
        i = 0;
        break;
      }
    }
    ((MMActivity)getBaseContext()).setMMTitle(ba.i.app_brand_launcher_header_section_text_recent);
    int i = this.ruz + 1;
    this.ruz = i;
    if (i == 1) {
      kT(true);
    }
    AppMethodBeat.o(49230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */