package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.a;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

public class RecentsFolderActivityContext
  extends FolderActivityContextWithLifecycle
{
  private int ksm = 0;
  private int mQH;
  private String mQI;
  
  public RecentsFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void T(Intent paramIntent)
  {
    AppMethodBeat.i(49229);
    this.mQH = paramIntent.getIntExtra("extra_enter_scene", 1);
    this.mQI = paramIntent.getStringExtra("extra_enter_scene_note");
    AppMethodBeat.o(49229);
  }
  
  public final void hF(boolean paramBoolean)
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
    for (localObject1 = new AppBrandLauncherRecentsList((MMActivity)getBaseContext() instanceof AppBrandLauncherUI);; localObject1 = AppBrandLauncherBlankPage.er(getString(2131755401), getString(2131755499)))
    {
      ((AppBrandLauncherUI.Fragment)localObject1).setScene(this.mQH);
      ((AppBrandLauncherUI.Fragment)localObject1).mGW = this.mQI;
      ((k)localObject2).b(16908290, (Fragment)localObject1);
      ((k)localObject2).commit();
      AppMethodBeat.o(49228);
      return;
    }
  }
  
  public void onActivityDidResume()
  {
    AppMethodBeat.i(49230);
    if (((MMActivity)getBaseContext() instanceof AppBrandLauncherUI))
    {
      if ((!i.bcy()) && (!i.bcz()) && (!q.bcH()))
      {
        l.bcF();
        if (!com.tencent.mm.kernel.g.ajM()) {
          break label114;
        }
        Object localObject = com.tencent.mm.model.c.d.aDI().xi("100328");
        if (!((c)localObject).isValid()) {
          break label114;
        }
        localObject = l.a.sa(bu.getInt((String)((c)localObject).fsy().get("isOpenGameEntry"), 0));
        if ((localObject == null) || (localObject != l.a.jRZ)) {
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
        hF(bool);
        AppMethodBeat.o(49230);
        return;
        i = 0;
        break;
      }
    }
    ((MMActivity)getBaseContext()).setMMTitle(2131755498);
    int i = this.ksm + 1;
    this.ksm = i;
    if (i == 1) {
      hF(true);
    }
    AppMethodBeat.o(49230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */