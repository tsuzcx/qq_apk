package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.a;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.au.i;
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
  private int oqF = 0;
  private int rfx;
  private String rfy;
  
  public RecentsFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void Q(Intent paramIntent)
  {
    AppMethodBeat.i(49229);
    this.rfx = paramIntent.getIntExtra("extra_enter_scene", 1);
    this.rfy = paramIntent.getStringExtra("extra_enter_scene_note");
    AppMethodBeat.o(49229);
  }
  
  public final void jE(boolean paramBoolean)
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
    for (localObject1 = new AppBrandLauncherRecentsList((MMActivity)getBaseContext() instanceof AppBrandLauncherUI);; localObject1 = AppBrandLauncherBlankPage.eX(getString(au.i.app_brand_entrance), getString(au.i.app_brand_launcher_recents_blank_tip)))
    {
      ((AppBrandLauncherUI.Fragment)localObject1).setScene(this.rfx);
      ((AppBrandLauncherUI.Fragment)localObject1).qVt = this.rfy;
      ((androidx.fragment.app.i)localObject2).b(16908290, (Fragment)localObject1);
      ((androidx.fragment.app.i)localObject2).in();
      AppMethodBeat.o(49228);
      return;
    }
  }
  
  public void onActivityDidResume()
  {
    AppMethodBeat.i(49230);
    if (((MMActivity)getBaseContext() instanceof AppBrandLauncherUI))
    {
      if ((!com.tencent.mm.plugin.appbrand.appusage.i.bJc()) && (!com.tencent.mm.plugin.appbrand.appusage.i.bJd()) && (!q.bJl()))
      {
        l.bJj();
        if (!h.aHB()) {
          break label114;
        }
        Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100328");
        if (!((c)localObject).isValid()) {
          break label114;
        }
        localObject = l.a.zg(Util.getInt((String)((c)localObject).hvz().get("isOpenGameEntry"), 0));
        if ((localObject == null) || (localObject != l.a.nOW)) {
          break label114;
        }
        i = 1;
        if (i == 0) {
          break label119;
        }
      }
      label114:
      label119:
      for (boolean bool = true;; bool = false)
      {
        jE(bool);
        AppMethodBeat.o(49230);
        return;
        i = 0;
        break;
      }
    }
    ((MMActivity)getBaseContext()).setMMTitle(au.i.app_brand_launcher_header_section_text_recent);
    int i = this.oqF + 1;
    this.oqF = i;
    if (i == 1) {
      jE(true);
    }
    AppMethodBeat.o(49230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */