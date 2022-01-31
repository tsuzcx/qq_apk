package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public class GameOverSeaCenterUI
  extends GameCenterBaseUI
  implements f
{
  private boolean evP;
  private Dialog lFU;
  private View.OnClickListener nAI;
  private GameCenterListView nCf;
  private g nCg;
  private GameInfoViewForeign nCh;
  private GameMessageBubbleView nCi;
  private GameInstalledView nCj;
  private View nCk;
  private TextView nCl;
  private bk noP;
  k nvE;
  private boolean nyw;
  private String nyx;
  
  public GameOverSeaCenterUI()
  {
    AppMethodBeat.i(112135);
    this.nvE = new k();
    this.nyx = "";
    this.evP = true;
    this.nAI = new GameOverSeaCenterUI.4(this);
    AppMethodBeat.o(112135);
  }
  
  public int getLayoutId()
  {
    return 2130969709;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112140);
    setBackBtn(new GameOverSeaCenterUI.1(this));
    setMMTitle(2131300478);
    this.nCf = ((GameCenterListView)findViewById(2131824490));
    this.nCf.setOnItemClickListener(this.nvE);
    this.nvE.setSourceScene(this.nok);
    this.nCg = new g(this);
    this.nCg.setSourceScene(this.nok);
    Object localObject = (LayoutInflater)getContext().getSystemService("layout_inflater");
    View localView = ((LayoutInflater)localObject).inflate(2130969717, this.nCf, false);
    this.nCh = ((GameInfoViewForeign)localView.findViewById(2131824519));
    this.nCf.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2130969706, this.nCf, false);
    this.nCi = ((GameMessageBubbleView)localView.findViewById(2131824462));
    this.nCf.addHeaderView(localView);
    localView = ((LayoutInflater)localObject).inflate(2130969718, this.nCf, false);
    this.nCj = ((GameInstalledView)localView.findViewById(2131824523));
    this.nCf.addHeaderView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2130969711, this.nCf, false);
    this.nCf.addFooterView((View)localObject);
    this.nCk = ((View)localObject).findViewById(2131824493);
    this.nCk.setOnClickListener(this.nAI);
    this.nCl = ((TextView)((View)localObject).findViewById(2131824494));
    this.nCf.setAdapter(this.nCg);
    AppMethodBeat.o(112140);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112136);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
    com.tencent.mm.kernel.g.Rc().a(2855, this);
    initView();
    c.aNS().ac(new GameOverSeaCenterUI.2(this));
    AppMethodBeat.o(112136);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112138);
    ab.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
    super.onDestroy();
    a.a.bHB().clearCache();
    com.tencent.mm.kernel.g.Rc().b(2855, this);
    ((d)com.tencent.mm.kernel.g.E(d.class)).bEP().clearCache();
    AppMethodBeat.o(112138);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(112137);
    super.onResume();
    if (!this.evP)
    {
      if (this.nwa) {
        this.nCi.bHu();
      }
      this.nCh.bHo();
    }
    this.evP = false;
    AppMethodBeat.o(112137);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(112141);
    ab.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.hashCode()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(112141);
        return;
        long l = System.currentTimeMillis();
        paramString = ((ap)paramm).lFp.fsW.fta;
        c.aNS().ac(new GameOverSeaCenterUI.6(this, paramString, l));
      }
    }
    if (!com.tencent.mm.plugin.game.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131300407, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.lFU != null) {
      this.lFU.cancel();
    }
    AppMethodBeat.o(112141);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI
 * JD-Core Version:    0.7.0.1
 */