package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void nk(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (j.fjZ())
    {
      ad.i("MicroMsg.GameCenterUI", "GP version");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 13L, 1L, false);
      nl(paramBoolean);
      AppMethodBeat.o(41950);
      return;
    }
    if (!m.d(this, getIntent())) {
      nl(paramBoolean);
    }
    AppMethodBeat.o(41950);
  }
  
  private void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean) {
      overridePendingTransition(2130772069, 2130772069);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41949);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    ad.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    int i;
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
      paramBundle = r.cYZ();
      if (paramBundle != null)
      {
        paramBundle.cYU();
        if (!bt.isNullOrNil(paramBundle.ucc.url)) {
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
    if (com.tencent.mm.plugin.game.commlib.a.tSI != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.tSI.uhy;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        ad.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((ao)localObject).ugz), ((ao)localObject).ueY });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle != null) {}
      switch (paramBundle.ugz)
      {
      default: 
        nk(bool);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41949);
      return;
      com.tencent.mm.plugin.game.commlib.a.cWO();
      break;
      nk(bool);
      continue;
      if (!bt.isNullOrNil(paramBundle.ueY))
      {
        paramBundle = paramBundle.ueY;
        getIntent().putExtra("rawUrl", paramBundle);
        o localo1;
        if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qpL, true))
        {
          localObject = getIntent();
          if ((bt.isNullOrNil(paramBundle)) || (localObject == null)) {}
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 3L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 9L, 1L, false);
            com.tencent.mm.plugin.game.model.e.cYL();
            break;
            bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
            i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
            localo1 = r.cYV();
            paramBundle = m.a(paramBundle, localo1, true);
            ((Intent)localObject).putExtra("rawUrl", paramBundle);
            ((Intent)localObject).putExtra("from_find_more_friend", true);
            if (bool)
            {
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
              o localo2 = r.cYW();
              if (localo2 != null)
              {
                localo2.cYU();
                if (localo2.ucz == 107) {
                  ((Intent)localObject).putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
              }
              m.a((Intent)localObject, "game_center_entrance", true, localo1, i, paramBundle);
              c.y((Intent)localObject, this);
              m.b(7, true, paramBundle);
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
              r.cZe();
            }
            else
            {
              m.a((Intent)localObject, "game_center_entrance", false, localo1, i, paramBundle);
              c.y((Intent)localObject, this);
            }
          }
        }
        localObject = getIntent();
        if ((bt.isNullOrNil(paramBundle)) || (localObject == null)) {}
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 3L, 1L, false);
          break;
          bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
          i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
          localo1 = r.cYV();
          paramBundle = m.a(paramBundle, localo1, true);
          ((Intent)localObject).putExtra("rawUrl", paramBundle);
          if (bool)
          {
            m.a(this, (Intent)localObject, "game_center_entrance", true, localo1, i);
            m.b(7, true, paramBundle);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
            r.cZe();
          }
          else
          {
            m.a(this, (Intent)localObject, "game_center_entrance", false, localo1, i);
          }
        }
      }
      nk(bool);
      continue;
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772069, 2130772069);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
      }
      paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772069, 2130772069);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(848L, 6L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
      }
      nl(bool);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */