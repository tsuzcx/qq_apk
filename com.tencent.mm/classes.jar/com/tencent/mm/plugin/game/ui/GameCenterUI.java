package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.a;
import com.tencent.mm.plugin.game.model.n.d;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.HashMap;

@i
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void Qt(String paramString)
  {
    AppMethodBeat.i(111783);
    getIntent().putExtra("rawUrl", paramString);
    if (((b)com.tencent.mm.kernel.g.E(b.class)).b(a.a.lRy)) {
      Qu(paramString);
    }
    for (;;)
    {
      e.bGd();
      AppMethodBeat.o(111783);
      return;
      Y(7, false);
      l.a(this, paramString, getIntent());
      h.qsU.idkeyStat(848L, 3L, 1L, false);
    }
  }
  
  private void Qu(String paramString)
  {
    AppMethodBeat.i(111784);
    Y(7, true);
    l.b(this, paramString, getIntent());
    h.qsU.idkeyStat(848L, 3L, 1L, false);
    h.qsU.idkeyStat(848L, 9L, 1L, false);
    AppMethodBeat.o(111784);
  }
  
  private void Y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111786);
    if (getIntent().getBooleanExtra("from_find_more_friend", false))
    {
      ((d)com.tencent.mm.kernel.g.E(d.class)).bER();
      n localn = q.bGn();
      HashMap localHashMap = new HashMap();
      if (paramBoolean) {
        localHashMap.put("luggage", "1");
      }
      if (localn == null)
      {
        localHashMap.put("function_type", "resource");
        localHashMap.put("function_value", "0");
        com.tencent.mm.game.report.c.a(this, 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.h(localHashMap));
        AppMethodBeat.o(111786);
        return;
      }
      localn.bGm();
      int i = localn.field_msgType;
      if (localn.field_msgType == 100) {
        i = localn.nnL;
      }
      localHashMap.put("function_type", "resource");
      localHashMap.put("function_value", String.valueOf(localn.nnb.nnV));
      com.tencent.mm.game.report.c.a(this, 9, 901, 1, paramInt, 0, localn.field_appId, 0, i, localn.field_gameMsgId, localn.nnM, com.tencent.mm.plugin.game.e.a.h(localHashMap));
      ((d)com.tencent.mm.kernel.g.E(d.class)).bER();
      q.bGo();
      h.qsU.idkeyStat(858L, 3L, 1L, false);
    }
    AppMethodBeat.o(111786);
  }
  
  private void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(111782);
    if (com.tencent.mm.sdk.platformtools.g.dsn())
    {
      ab.i("MicroMsg.GameCenterUI", "GP version");
      h.qsU.idkeyStat(848L, 13L, 1L, false);
    }
    String str;
    do
    {
      il(paramBoolean);
      AppMethodBeat.o(111782);
      return;
      str = com.tencent.mm.plugin.game.f.c.bHD();
    } while (bo.isNullOrNil(str));
    Qt(str);
    AppMethodBeat.o(111782);
  }
  
  private void il(boolean paramBoolean)
  {
    AppMethodBeat.i(111785);
    Intent localIntent = new Intent(this, GameRouteUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    startActivity(localIntent);
    if (paramBoolean) {
      overridePendingTransition(2131034195, 2131034195);
    }
    for (;;)
    {
      Y(6, false);
      h.qsU.idkeyStat(848L, 4L, 1L, false);
      AppMethodBeat.o(111785);
      return;
      overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111781);
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    ab.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      int i = getIntent().getIntExtra("game_sourceScene", 0);
      ((d)com.tencent.mm.kernel.g.E(d.class)).bER();
      paramBundle = q.bGp();
      if (paramBundle != null)
      {
        paramBundle.bGm();
        if (!bo.isNullOrNil(paramBundle.nnq.url)) {
          com.tencent.mm.plugin.game.f.c.a(getBaseContext(), paramBundle, "game_center_h5_floatlayer");
        }
      }
      l.a(paramBundle, i, 1);
      finish();
      AppMethodBeat.o(111781);
      return;
    }
    boolean bool = getIntent().getBooleanExtra("switch_country_no_anim", false);
    paramBundle = com.tencent.mm.plugin.game.commlib.a.bFa();
    if (paramBundle != null) {}
    switch (paramBundle.nrh)
    {
    default: 
      ik(bool);
    case 0: 
    case 1: 
      for (;;)
      {
        finish();
        AppMethodBeat.o(111781);
        return;
        ik(bool);
        continue;
        if (!bo.isNullOrNil(paramBundle.npR)) {
          Qt(paramBundle.npR);
        } else {
          ik(bool);
        }
      }
    case 2: 
      paramBundle = new Intent(this, GameOverSeaCenterUI.class);
      localBundle = getIntent().getExtras();
      if (localBundle != null) {
        paramBundle.putExtras(localBundle);
      }
      startActivity(paramBundle);
      if (bool) {
        overridePendingTransition(2131034195, 2131034195);
      }
      for (;;)
      {
        Y(6, false);
        h.qsU.idkeyStat(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
      }
    }
    paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      paramBundle.putExtras(localBundle);
    }
    startActivity(paramBundle);
    if (bool) {
      overridePendingTransition(2131034195, 2131034195);
    }
    for (;;)
    {
      Y(6, false);
      h.qsU.idkeyStat(848L, 6L, 1L, false);
      break;
      overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */