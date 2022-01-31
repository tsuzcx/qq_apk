package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.ui.a.a;
import com.tencent.mm.plugin.appbrand.ui.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;

public final class n
  extends a
{
  private int gdS = 0;
  private int hjt;
  private String hju;
  
  public n(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void dC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = e.class;
      localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().Z(16908290);
      if ((localObject2 == null) || (!((Class)localObject1).isInstance(localObject2))) {
        break label42;
      }
    }
    label42:
    while ((((MMActivity)getBaseContext()).isFinishing()) || (((MMActivity)getBaseContext()).uMr))
    {
      return;
      localObject1 = c.class;
      break;
    }
    Object localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().bP();
    if (paramBoolean) {}
    for (Object localObject1 = new e((MMActivity)getBaseContext() instanceof AppBrandLauncherUI);; localObject1 = c.ce(getString(y.j.app_brand_entrance), getString(y.j.app_brand_launcher_recents_blank_tip)))
    {
      ((AppBrandLauncherUI.a)localObject1).setScene(this.hjt);
      ((AppBrandLauncherUI.a)localObject1).hda = this.hju;
      ((o)localObject2).b(16908290, (Fragment)localObject1);
      ((o)localObject2).commit();
      return;
    }
  }
  
  public final void onActivityDidResume()
  {
    boolean bool;
    if (((MMActivity)getBaseContext() instanceof AppBrandLauncherUI)) {
      if ((!i.acR()) && (!i.acS()) && (!q.acZ()))
      {
        l.acW();
        if (!l.enabled()) {}
      }
      else
      {
        bool = true;
        dC(bool);
      }
    }
    int i;
    do
    {
      return;
      bool = false;
      break;
      ((MMActivity)getBaseContext()).setMMTitle(y.j.app_brand_launcher_header_section_text_recent);
      i = this.gdS + 1;
      this.gdS = i;
    } while (i != 1);
    dC(true);
  }
  
  public final void v(Intent paramIntent)
  {
    this.hjt = paramIntent.getIntExtra("extra_enter_scene", 1);
    this.hju = paramIntent.getStringExtra("extra_enter_scene_note");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */