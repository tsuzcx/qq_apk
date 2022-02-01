package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.av;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (ChannelUtil.isGPVersion())
    {
      Log.i("MicroMsg.GameCenterUI", "GP version");
      h.CyF.idkeyStat(848L, 13L, 1L, false);
      pV(paramBoolean);
      AppMethodBeat.o(41950);
      return;
    }
    if (!m.i(this, getIntent())) {
      pV(paramBoolean);
    }
    AppMethodBeat.o(41950);
  }
  
  private void pV(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean) {
      overridePendingTransition(2130772082, 2130772082);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      h.CyF.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41949);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    Log.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    int i;
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
      paramBundle = r.dVq();
      if (paramBundle != null)
      {
        paramBundle.dVl();
        if (!Util.isNullOrNil(paramBundle.xFw.url)) {
          c.a(getBaseContext(), paramBundle, "game_center_h5_floatlayer");
        }
      }
      m.a(paramBundle, i, 1);
      finish();
      AppMethodBeat.o(41949);
      return;
    }
    boolean bool = getIntent().getBooleanExtra("switch_country_no_anim", false);
    paramBundle = null;
    Object localObject;
    if (com.tencent.mm.plugin.game.commlib.a.xvl != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        Log.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((av)localObject).xJa), ((av)localObject).xIy });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle != null) {}
      switch (paramBundle.xJa)
      {
      default: 
        pU(bool);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41949);
      return;
      com.tencent.mm.plugin.game.commlib.a.dSS();
      break;
      pU(bool);
      continue;
      if (!Util.isNullOrNil(paramBundle.xIy))
      {
        paramBundle = paramBundle.xIy;
        getIntent().putExtra("rawUrl", paramBundle);
        o localo1;
        if (((b)g.af(b.class)).a(b.a.rOd, true))
        {
          localObject = getIntent();
          if ((Util.isNullOrNil(paramBundle)) || (localObject == null)) {}
          for (;;)
          {
            h.CyF.idkeyStat(848L, 3L, 1L, false);
            h.CyF.idkeyStat(848L, 9L, 1L, false);
            com.tencent.mm.plugin.game.model.e.dVc();
            break;
            bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
            i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
            ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
            localo1 = r.dVm();
            paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
            ((Intent)localObject).putExtra("rawUrl", paramBundle);
            ((Intent)localObject).putExtra("from_find_more_friend", true);
            if (bool)
            {
              ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
              o localo2 = r.dVn();
              if (localo2 != null)
              {
                localo2.dVl();
                if (localo2.xFV == 107) {
                  ((Intent)localObject).putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
              }
              m.a((Intent)localObject, "game_center_entrance", true, localo1, i, paramBundle);
              c.x((Intent)localObject, this);
              m.b(7, true, paramBundle);
              ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
              r.dVv();
            }
            else
            {
              m.a((Intent)localObject, "game_center_entrance", false, localo1, i, paramBundle);
              c.x((Intent)localObject, this);
            }
          }
        }
        localObject = getIntent();
        if ((Util.isNullOrNil(paramBundle)) || (localObject == null)) {}
        for (;;)
        {
          h.CyF.idkeyStat(848L, 3L, 1L, false);
          break;
          bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
          i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
          ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
          localo1 = r.dVm();
          paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
          ((Intent)localObject).putExtra("rawUrl", paramBundle);
          if (bool)
          {
            m.a(this, (Intent)localObject, "game_center_entrance", true, localo1, i);
            m.b(7, true, paramBundle);
            ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
            r.dVv();
          }
          else
          {
            m.a(this, (Intent)localObject, "game_center_entrance", false, localo1, i);
          }
        }
      }
      pU(bool);
      continue;
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772082, 2130772082);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        h.CyF.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
      }
      paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772082, 2130772082);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        h.CyF.idkeyStat(848L, 6L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
      }
      pV(bool);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */