package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@i
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void no(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (k.fnT())
    {
      ae.i("MicroMsg.GameCenterUI", "GP version");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 13L, 1L, false);
      np(paramBoolean);
      AppMethodBeat.o(41950);
      return;
    }
    if (!m.d(this, getIntent())) {
      np(paramBoolean);
    }
    AppMethodBeat.o(41950);
  }
  
  private void np(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean) {
      overridePendingTransition(2130772069, 2130772069);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41949);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    ae.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    int i;
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
      paramBundle = r.dbJ();
      if (paramBundle != null)
      {
        paramBundle.dbE();
        if (!bu.isNullOrNil(paramBundle.une.url)) {
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
    if (com.tencent.mm.plugin.game.commlib.a.udz != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.udz.usW;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        ae.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((au)localObject).uqI), ((au)localObject).uqf });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle != null) {}
      switch (paramBundle.uqI)
      {
      default: 
        no(bool);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41949);
      return;
      com.tencent.mm.plugin.game.commlib.a.cZs();
      break;
      no(bool);
      continue;
      if (!bu.isNullOrNil(paramBundle.uqf))
      {
        paramBundle = paramBundle.uqf;
        getIntent().putExtra("rawUrl", paramBundle);
        o localo1;
        if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qws, true))
        {
          localObject = getIntent();
          if ((bu.isNullOrNil(paramBundle)) || (localObject == null)) {}
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 3L, 1L, false);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 9L, 1L, false);
            com.tencent.mm.plugin.game.model.e.dbv();
            break;
            bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
            i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
            localo1 = r.dbF();
            paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
            ((Intent)localObject).putExtra("rawUrl", paramBundle);
            ((Intent)localObject).putExtra("from_find_more_friend", true);
            if (bool)
            {
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
              o localo2 = r.dbG();
              if (localo2 != null)
              {
                localo2.dbE();
                if (localo2.unD == 107) {
                  ((Intent)localObject).putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
              }
              m.a((Intent)localObject, "game_center_entrance", true, localo1, i, paramBundle);
              c.y((Intent)localObject, this);
              m.b(7, true, paramBundle);
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
              r.dbO();
            }
            else
            {
              m.a((Intent)localObject, "game_center_entrance", false, localo1, i, paramBundle);
              c.y((Intent)localObject, this);
            }
          }
        }
        localObject = getIntent();
        if ((bu.isNullOrNil(paramBundle)) || (localObject == null)) {}
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 3L, 1L, false);
          break;
          bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
          i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
          localo1 = r.dbF();
          paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
          ((Intent)localObject).putExtra("rawUrl", paramBundle);
          if (bool)
          {
            m.a(this, (Intent)localObject, "game_center_entrance", true, localo1, i);
            m.b(7, true, paramBundle);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
            r.dbO();
          }
          else
          {
            m.a(this, (Intent)localObject, "game_center_entrance", false, localo1, i);
          }
        }
      }
      no(bool);
      continue;
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772069, 2130772069);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
      }
      paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772069, 2130772069);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(848L, 6L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
      }
      np(bool);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */