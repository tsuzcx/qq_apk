package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.d.a.a;
import com.tencent.mm.plugin.game.d.a.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.ax;
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
  private void wx(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (ChannelUtil.isGPVersion())
    {
      Log.i("MicroMsg.GameCenterUI", "GP version");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 13L, 1L, false);
      wy(paramBoolean);
      AppMethodBeat.o(41950);
      return;
    }
    if (!m.s(this, getIntent())) {
      wy(paramBoolean);
    }
    AppMethodBeat.o(41950);
  }
  
  private void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean)
    {
      int i = h.a.HSF;
      overridePendingTransition(i, i);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
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
      a.a.fHX().IXU.fHY();
      a.a.fHX().IXU.startTimeMs = System.currentTimeMillis();
      a.a.fHX().IXU.IXX = System.currentTimeMillis();
    }
    int i;
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
      paramBundle = r.fGu();
      if (paramBundle != null)
      {
        paramBundle.fGp();
        if (!Util.isNullOrNil(paramBundle.IDI.url)) {
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
    if (com.tencent.mm.plugin.game.commlib.a.IsN != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.IsN.GameIndexSetting;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        Log.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((ax)localObject).IHl), ((ax)localObject).IGI });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle != null) {}
      switch (paramBundle.IHl)
      {
      default: 
        wx(bool);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41949);
      return;
      com.tencent.mm.plugin.game.commlib.a.fDQ();
      break;
      wx(bool);
      continue;
      if (!Util.isNullOrNil(paramBundle.IGI))
      {
        paramBundle = paramBundle.IGI;
        getIntent().putExtra("rawUrl", paramBundle);
        o localo1;
        if (((b)com.tencent.mm.kernel.h.ax(b.class)).a(c.a.yGB, true))
        {
          localObject = getIntent();
          if ((Util.isNullOrNil(paramBundle)) || (localObject == null)) {}
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 3L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 9L, 1L, false);
            com.tencent.mm.plugin.game.model.e.fGf();
            break;
            bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
            i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
            localo1 = r.fGq();
            paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
            ((Intent)localObject).putExtra("rawUrl", paramBundle);
            ((Intent)localObject).putExtra("from_find_more_friend", true);
            if (bool)
            {
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
              o localo2 = r.fGr();
              if (localo2 != null)
              {
                localo2.fGp();
                if (localo2.IEh == 107) {
                  ((Intent)localObject).putExtra("from_download_floagt_ball_shutdown_entrance", true);
                }
              }
              m.a((Intent)localObject, "game_center_entrance", true, localo1, i, paramBundle);
              c.w((Intent)localObject, this);
              m.b(7, true, paramBundle);
              ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg().fGz();
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 3L, 1L, false);
          break;
          bool = ((Intent)localObject).getBooleanExtra("from_find_more_friend", false);
          i = ((Intent)localObject).getIntExtra("game_report_from_scene", 0);
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg();
          localo1 = r.fGq();
          paramBundle = m.a(paramBundle, localo1, (Intent)localObject, true);
          ((Intent)localObject).putExtra("rawUrl", paramBundle);
          if (bool)
          {
            m.a(this, (Intent)localObject, "game_center_entrance", true, localo1, i);
            m.b(7, true, paramBundle);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg().fGz();
          }
          else
          {
            m.a(this, (Intent)localObject, "game_center_entrance", false, localo1, i);
          }
        }
      }
      wx(bool);
      continue;
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool)
      {
        i = h.a.HSF;
        overridePendingTransition(i, i);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
      }
      paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool)
      {
        i = h.a.HSF;
        overridePendingTransition(i, i);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(848L, 6L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
      }
      wy(bool);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */