package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.ui.MMActivity;

public class RecentsFolderActivityContext
  extends FolderActivityContextWithLifecycle
{
  private int hvP = 0;
  private int iVa;
  private String iVb;
  
  public RecentsFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void N(Intent paramIntent)
  {
    AppMethodBeat.i(133501);
    this.iVa = paramIntent.getIntExtra("extra_enter_scene", 1);
    this.iVb = paramIntent.getStringExtra("extra_enter_scene_note");
    AppMethodBeat.o(133501);
  }
  
  public final void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(133500);
    if (paramBoolean) {}
    for (Object localObject1 = AppBrandLauncherRecentsList.class;; localObject1 = AppBrandLauncherBlankPage.class)
    {
      localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().findFragmentById(16908290);
      if ((localObject2 == null) || (!((Class)localObject1).isInstance(localObject2))) {
        break;
      }
      AppMethodBeat.o(133500);
      return;
    }
    if ((((MMActivity)getBaseContext()).isFinishing()) || (((MMActivity)getBaseContext()).activityHasDestroyed()))
    {
      AppMethodBeat.o(133500);
      return;
    }
    Object localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().beginTransaction();
    if (paramBoolean) {}
    for (localObject1 = new AppBrandLauncherRecentsList((MMActivity)getBaseContext() instanceof AppBrandLauncherUI);; localObject1 = AppBrandLauncherBlankPage.cT(getString(2131296630), getString(2131296718)))
    {
      ((AppBrandLauncherUI.Fragment)localObject1).setScene(this.iVa);
      ((AppBrandLauncherUI.Fragment)localObject1).iMQ = this.iVb;
      ((k)localObject2).b(16908290, (Fragment)localObject1);
      ((k)localObject2).commit();
      AppMethodBeat.o(133500);
      return;
    }
  }
  
  public void onActivityDidResume()
  {
    AppMethodBeat.i(133502);
    if (((MMActivity)getBaseContext() instanceof AppBrandLauncherUI))
    {
      if ((!i.awX()) && (!i.awY()) && (!q.axf()))
      {
        l.axc();
        if (!l.enabled()) {
          break label59;
        }
      }
      label59:
      for (boolean bool = true;; bool = false)
      {
        eP(bool);
        AppMethodBeat.o(133502);
        return;
      }
    }
    ((MMActivity)getBaseContext()).setMMTitle(2131296717);
    int i = this.hvP + 1;
    this.hvP = i;
    if (i == 1) {
      eP(true);
    }
    AppMethodBeat.o(133502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */