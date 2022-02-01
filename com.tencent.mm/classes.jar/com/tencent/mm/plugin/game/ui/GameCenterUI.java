package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void ahK(String paramString)
  {
    AppMethodBeat.i(41951);
    getIntent().putExtra("rawUrl", paramString);
    if (((b)g.ab(b.class)).a(b.a.pLY, true)) {
      ahL(paramString);
    }
    for (;;)
    {
      e.cQg();
      AppMethodBeat.o(41951);
      return;
      m.a(this, paramString, getIntent());
      h.wUl.idkeyStat(848L, 3L, 1L, false);
    }
  }
  
  private void ahL(String paramString)
  {
    AppMethodBeat.i(41952);
    m.b(this, paramString, getIntent());
    h.wUl.idkeyStat(848L, 3L, 1L, false);
    h.wUl.idkeyStat(848L, 9L, 1L, false);
    AppMethodBeat.o(41952);
  }
  
  private void mQ(boolean paramBoolean)
  {
    AppMethodBeat.i(41950);
    if (com.tencent.mm.sdk.platformtools.i.eUv())
    {
      ac.i("MicroMsg.GameCenterUI", "GP version");
      h.wUl.idkeyStat(848L, 13L, 1L, false);
    }
    String str;
    do
    {
      mR(paramBoolean);
      AppMethodBeat.o(41950);
      return;
      str = c.cRK();
    } while (bs.isNullOrNil(str));
    ahK(str);
    AppMethodBeat.o(41950);
  }
  
  private void mR(boolean paramBoolean)
  {
    AppMethodBeat.i(41953);
    Object localObject = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      ((Intent)localObject).putExtras(localBundle);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBoolean) {
      overridePendingTransition(2130772069, 2130772069);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      h.wUl.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(41953);
      return;
      overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41949);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    ac.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      int i = getIntent().getIntExtra("game_sourceScene", 0);
      ((d)g.ab(d.class)).cOl();
      paramBundle = r.cQu();
      if (paramBundle != null)
      {
        paramBundle.cQp();
        if (!bs.isNullOrNil(paramBundle.tem.url)) {
          c.a(getBaseContext(), paramBundle, "game_center_h5_floatlayer");
        }
      }
      m.a(paramBundle, i, 1);
      finish();
      AppMethodBeat.o(41949);
      return;
    }
    boolean bool = getIntent().getBooleanExtra("switch_country_no_anim", false);
    if (com.tencent.mm.plugin.game.commlib.a.sWd != null)
    {
      localObject = com.tencent.mm.plugin.game.commlib.a.sWd.tjy;
      paramBundle = (Bundle)localObject;
      if (localObject != null)
      {
        ac.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(((am)localObject).tiE), ((am)localObject).thh });
        paramBundle = (Bundle)localObject;
      }
      if (paramBundle == null) {}
    }
    switch (paramBundle.tiE)
    {
    default: 
      mQ(bool);
    case 0: 
    case 1: 
      for (;;)
      {
        finish();
        AppMethodBeat.o(41949);
        return;
        paramBundle = null;
        com.tencent.mm.plugin.game.commlib.a.cOt();
        break;
        mQ(bool);
        continue;
        if (!bs.isNullOrNil(paramBundle.thh)) {
          ahK(paramBundle.thh);
        } else {
          mQ(bool);
        }
      }
    case 2: 
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        paramBundle.putExtras((Bundle)localObject);
      }
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bool) {
        overridePendingTransition(2130772069, 2130772069);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
          m.b(6, false, null);
        }
        h.wUl.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
      }
    }
    paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      paramBundle.putExtras((Bundle)localObject);
    }
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramBundle.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (bool) {
      overridePendingTransition(2130772069, 2130772069);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
        m.b(6, false, null);
      }
      h.wUl.idkeyStat(848L, 6L, 1L, false);
      break;
      overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
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