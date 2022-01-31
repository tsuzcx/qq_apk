package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class GameDownloadGuidanceUI
  extends GameCenterBaseUI
  implements f
{
  private Dialog lFU;
  private LinearLayout mDJ;
  private bi noB;
  private TextView nyt;
  private TextView nyu;
  private TextView nyv;
  private boolean nyw;
  private String nyx = "";
  
  public final void a(com.tencent.mm.plugin.game.model.ab paramab, int paramInt)
  {
    AppMethodBeat.i(111890);
    if (isFinishing())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
      AppMethodBeat.o(111890);
      return;
    }
    if ((paramab == null) || (paramab.bGK() == null))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
      AppMethodBeat.o(111890);
      return;
    }
    if ((paramab != null) && (paramab.bGL() != null))
    {
      this.nyx = paramab.bGL().npR;
      if (bo.isNullOrNil(this.nyx)) {
        break label243;
      }
      if (!this.nyw)
      {
        addIconOptionMenu(0, 2131230758, new GameDownloadGuidanceUI.4(this));
        this.nyw = true;
      }
      label108:
      this.mDJ.setVisibility(0);
      paramab = paramab.bGK();
      if (bo.isNullOrNil(paramab.nqH)) {
        break label264;
      }
      this.nyt.setText(paramab.nqH);
      this.nyt.setVisibility(0);
      label150:
      if (bo.isNullOrNil(paramab.nqI)) {
        break label276;
      }
      this.nyu.setText(paramab.nqI);
      this.nyu.setVisibility(0);
      label179:
      if (bo.isNullOrNil(paramab.nqJ)) {
        break label288;
      }
      this.nyv.setText(paramab.nqJ);
      this.nyv.setVisibility(0);
    }
    for (;;)
    {
      if (paramInt == 2) {
        c.aNS().ac(new GameDownloadGuidanceUI.3(this));
      }
      AppMethodBeat.o(111890);
      return;
      this.nyx = "";
      break;
      label243:
      if (!this.nyw) {
        break label108;
      }
      removeOptionMenu(0);
      this.nyw = false;
      break label108;
      label264:
      this.nyt.setVisibility(8);
      break label150;
      label276:
      this.nyu.setVisibility(8);
      break label179;
      label288:
      this.nyv.setVisibility(8);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969760;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111889);
    setBackBtn(new GameDownloadGuidanceUI.1(this));
    setMMTitle(2131300478);
    this.mDJ = ((LinearLayout)findViewById(2131821084));
    this.nyt = ((TextView)findViewById(2131824647));
    this.nyu = ((TextView)findViewById(2131824648));
    this.nyv = ((TextView)findViewById(2131824649));
    AppMethodBeat.o(111889);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111887);
    super.onCreate(paramBundle);
    g.Rc().a(2586, this);
    initView();
    c.aNS().ac(new GameDownloadGuidanceUI.2(this));
    AppMethodBeat.o(111887);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111888);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
    super.onDestroy();
    a.a.bHB().clearCache();
    g.Rc().b(2586, this);
    ((d)g.E(d.class)).bEP().clearCache();
    AppMethodBeat.o(111888);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(111891);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(111891);
        return;
        long l = System.currentTimeMillis();
        paramString = ((ao)paramm).lFp.fsW.fta;
        c.aNS().ac(new GameDownloadGuidanceUI.5(this, paramString, l));
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131300407, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.lFU != null) {
      this.lFU.cancel();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI
 * JD-Core Version:    0.7.0.1
 */