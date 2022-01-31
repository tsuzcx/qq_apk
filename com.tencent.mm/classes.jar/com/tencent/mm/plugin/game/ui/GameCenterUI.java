package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.j;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.o.c;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.HashMap;

@j
@com.tencent.mm.ui.base.a(19)
public class GameCenterUI
  extends MMBaseActivity
{
  private void Fb(String paramString)
  {
    getIntent().putExtra("rawUrl", paramString);
    boolean bool;
    int i;
    o localo;
    if (((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jIa, false))
    {
      Q(7, true);
      localIntent = getIntent();
      if ((this == null) || (bk.bl(paramString)) || (localIntent == null)) {}
      for (;;)
      {
        h.nFQ.a(848L, 3L, 1L, false);
        h.nFQ.a(848L, 9L, 1L, false);
        f.aZe();
        return;
        bool = localIntent.getBooleanExtra("from_find_more_friend", false);
        i = localIntent.getIntExtra("game_report_from_scene", 0);
        ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
        localo = r.aZp();
        m.a(paramString, localo);
        if (bool)
        {
          m.b(this, localIntent, "game_center_entrance", true, localo, i);
          ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
          r.aZo();
        }
        else
        {
          m.b(this, localIntent, "game_center_entrance", false, localo, i);
        }
      }
    }
    Q(7, false);
    Intent localIntent = getIntent();
    if ((this == null) || (bk.bl(paramString)) || (localIntent == null)) {}
    for (;;)
    {
      h.nFQ.a(848L, 3L, 1L, false);
      break;
      bool = localIntent.getBooleanExtra("from_find_more_friend", false);
      i = localIntent.getIntExtra("game_report_from_scene", 0);
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      localo = r.aZp();
      m.a(paramString, localo);
      if (bool)
      {
        m.a(this, localIntent, "game_center_entrance", true, localo, i);
        ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
        r.aZo();
      }
      else
      {
        m.a(this, localIntent, "game_center_entrance", false, localo, i);
      }
    }
  }
  
  private void Q(int paramInt, boolean paramBoolean)
  {
    o localo;
    HashMap localHashMap;
    if (getIntent().getBooleanExtra("from_find_more_friend", false))
    {
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      localo = r.aZn();
      localHashMap = new HashMap();
      if (paramBoolean) {
        localHashMap.put("luggage", "1");
      }
      if (localo == null)
      {
        localHashMap.put("function_type", "resource");
        localHashMap.put("function_value", "0");
        com.tencent.mm.plugin.game.e.b.a(this, 9, 901, 1, paramInt, 0, com.tencent.mm.plugin.game.e.a.B(localHashMap));
      }
    }
    else
    {
      return;
    }
    localo.aZm();
    int i = localo.field_msgType;
    if (localo.field_msgType == 100) {
      i = localo.kPM;
    }
    localHashMap.put("function_type", "resource");
    localHashMap.put("function_value", String.valueOf(localo.kPf.kPU));
    com.tencent.mm.plugin.game.e.b.a(this, 9, 901, 1, paramInt, 0, localo.field_appId, 0, i, localo.field_gameMsgId, localo.kPN, com.tencent.mm.plugin.game.e.a.B(localHashMap));
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
    r.aZo();
    h.nFQ.a(858L, 3L, 1L, false);
  }
  
  private void gB(boolean paramBoolean)
  {
    Object localObject;
    if (e.cqq())
    {
      y.i("MicroMsg.GameCenterUI", "GP version");
      localObject = new Intent(this, GameRouteUI.class);
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        ((Intent)localObject).putExtras(localBundle);
      }
      startActivity((Intent)localObject);
      if (!paramBoolean) {
        break label124;
      }
      overridePendingTransition(g.a.in_no_slide, g.a.in_no_slide);
    }
    for (;;)
    {
      Q(6, false);
      h.nFQ.a(848L, 4L, 1L, false);
      return;
      localObject = com.tencent.mm.plugin.game.model.b.sd(getIntent().getIntExtra("game_report_from_scene", 0));
      if ((((b.a)localObject).bcw != 2) || (bk.bl(((b.a)localObject).url))) {
        break;
      }
      Fb(((b.a)localObject).url);
      return;
      label124:
      overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
    y.d("MicroMsg.GameCenterUI", "onCreate");
    if (getIntent().getBooleanExtra("game_check_float", false))
    {
      int i = getIntent().getIntExtra("game_sourceScene", 0);
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      paramBundle = r.aZp();
      if (paramBundle != null)
      {
        paramBundle.aZm();
        if (!bk.bl(paramBundle.kPu.url)) {
          c.a(getBaseContext(), paramBundle, "game_center_h5_floatlayer");
        }
      }
      m.a(paramBundle, i, 1);
      finish();
      return;
    }
    boolean bool = getIntent().getBooleanExtra("switch_country_no_anim", false);
    paramBundle = com.tencent.mm.plugin.game.commlib.a.aYl();
    if (paramBundle != null) {}
    switch (paramBundle.kTh)
    {
    default: 
      gB(bool);
    case 0: 
    case 1: 
      for (;;)
      {
        finish();
        return;
        gB(bool);
        continue;
        if (!bk.bl(paramBundle.kRP)) {
          Fb(paramBundle.kRP);
        } else {
          gB(bool);
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
        overridePendingTransition(g.a.in_no_slide, g.a.in_no_slide);
      }
      for (;;)
      {
        Q(6, false);
        h.nFQ.a(848L, 5L, 1L, false);
        break;
        overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
      }
    }
    paramBundle = new Intent(this, GameDownloadGuidanceUI.class);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      paramBundle.putExtras(localBundle);
    }
    startActivity(paramBundle);
    if (bool) {
      overridePendingTransition(g.a.in_no_slide, g.a.in_no_slide);
    }
    for (;;)
    {
      Q(6, false);
      h.nFQ.a(848L, 6L, 1L, false);
      break;
      overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI
 * JD-Core Version:    0.7.0.1
 */