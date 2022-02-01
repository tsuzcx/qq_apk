package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.a.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@k
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (ChannelUtil.isGPVersion())
    {
      Log.i("MicroMsg.GameCenterUI", "GP version");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 13L, 1L, false);
      ss(paramBoolean);
      AppMethodBeat.o(41950);
      return;
    }
    if (!m.l(this, getIntent())) {
      ss(paramBoolean);
    }
    AppMethodBeat.o(41950);
  }
  
  private void ss(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean)
    {
      int i = g.a.Cgw;
      overridePendingTransition(i, i);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41949);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    Log.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    if (getIntent().getIntExtra("game_report_from_scene", 0) == 901)
    {
      a.a.ezW().DdD.ezX();
      a.a.ezW().DdD.startTimeMs = System.currentTimeMillis();
      a.a.ezW().DdD.DdG = System.currentTimeMillis();
    }
    int i;
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
      paramBundle = r.eyy();
      if (paramBundle != null)
      {
        paramBundle.eyt();
        if (!Util.isNullOrNil(paramBundle.CJx.url)) {
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
    if (com.tencent.mm.plugin.game.commlib.a.Czb != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.Czb.GameIndexSetting;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        Log.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((aw)localObject).CNg), ((aw)localObject).CMD });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle != null) {}
      switch (paramBundle.CNg)
      {
      default: 
        sr(bool);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41949);
      return;
      com.tencent.mm.plugin.game.commlib.a.ewa();
      break;
      sr(bool);
      continue;
      if (!Util.isNullOrNil(paramBundle.CMD))
      {
        paramBundle = paramBundle.CMD;
        getIntent().putExtra("rawUrl", paramBundle);
        o localo1;
        if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vtX, true))
        {
          localObject = getIntent();
          if ((Util.isNullOrNil(paramBundle)) || (localObject == null)) {}
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 3L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 9L, 1L, false);
            com.tencent.mm.plugin.game.model.e.eyj();
            break;
            bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
            i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
            localo1 = r.eyu();
            paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
            ((Intent)localObject).putExtra("rawUrl", paramBundle);
            ((Intent)localObject).putExtra("from_find_more_friend", true);
            if (bool)
            {
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
              o localo2 = r.eyv();
              if (localo2 != null)
              {
                localo2.eyt();
                if (localo2.CJW == 107) {
                  ((Intent)localObject).putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
              }
              m.a((Intent)localObject, "game_center_entrance", true, localo1, i, paramBundle);
              c.w((Intent)localObject, this);
              m.b(7, true, paramBundle);
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn().eyD();
            }
            else
            {
              m.a((Intent)localObject, "game_center_entrance", false, localo1, i, paramBundle);
              c.w((Intent)localObject, this);
            }
          }
        }
        localObject = getIntent();
        if ((Util.isNullOrNil(paramBundle)) || (localObject == null)) {}
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 3L, 1L, false);
          break;
          bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
          i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn();
          localo1 = r.eyu();
          paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
          ((Intent)localObject).putExtra("rawUrl", paramBundle);
          if (bool)
          {
            m.a(this, (Intent)localObject, "game_center_entrance", true, localo1, i);
            m.b(7, true, paramBundle);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn().eyD();
          }
          else
          {
            m.a(this, (Intent)localObject, "game_center_entrance", false, localo1, i);
          }
        }
      }
      sr(bool);
      continue;
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool)
      {
        i = g.a.Cgw;
        overridePendingTransition(i, i);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
      }
      paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool)
      {
        i = g.a.Cgw;
        overridePendingTransition(i, i);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(848L, 6L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
      }
      ss(bool);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */