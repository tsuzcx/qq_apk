package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI
  extends MMActivity
  implements f
{
  private View ejC;
  private boolean evP;
  private Dialog lFU;
  private boolean mUB;
  private HashMap<Integer, String> nAA;
  private int nAB;
  private View nAC;
  private Button nAD;
  private boolean nAE;
  private int nAF;
  private int nAG;
  private View.OnClickListener nAH;
  private View.OnClickListener nAI;
  private GameDropdownView.a nAJ;
  private GameBannerView nAu;
  private GameLibraryCategoriesView nAv;
  private View nAw;
  private TextView nAx;
  private View nAy;
  private GameDropdownView nAz;
  private int nok;
  private int nor;
  private k nvE;
  private ListView nvL;
  private l nvM;
  private boolean nvN;
  private boolean nvO;
  private m.a nvR;
  private AbsListView.OnScrollListener nvS;
  
  public GameLibraryUI()
  {
    AppMethodBeat.i(112041);
    this.nAB = 0;
    this.mUB = false;
    this.nvN = false;
    this.nor = 0;
    this.nvO = true;
    this.nAE = false;
    this.evP = true;
    this.nok = 0;
    this.nAF = 990;
    this.nAG = 0;
    this.nvE = new k();
    this.nvR = new GameLibraryUI.3(this);
    this.nAH = new GameLibraryUI.5(this);
    this.nAI = new GameLibraryUI.6(this);
    this.nAJ = new GameDropdownView.a()
    {
      public final void xh(int paramAnonymousInt)
      {
        AppMethodBeat.i(112037);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(GameLibraryUI.f(GameLibraryUI.this).keySet());
        if (paramAnonymousInt > localLinkedList.size() - 1)
        {
          AppMethodBeat.o(112037);
          return;
        }
        GameLibraryUI.a(GameLibraryUI.this, ((Integer)localLinkedList.get(paramAnonymousInt)).intValue());
        ab.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(GameLibraryUI.this)) });
        GameLibraryUI.b(GameLibraryUI.this, 0);
        GameLibraryUI.h(GameLibraryUI.this);
        com.tencent.mm.game.report.c.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.g(GameLibraryUI.this) + GameLibraryUI.i(GameLibraryUI.this), 2, GameLibraryUI.e(GameLibraryUI.this), null);
        AppMethodBeat.o(112037);
      }
    };
    this.nvS = new GameLibraryUI.8(this);
    AppMethodBeat.o(112041);
  }
  
  private void bHl()
  {
    AppMethodBeat.i(112049);
    Object localObject = getIntent().getStringExtra("jump_game_center");
    if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equals("jump_game_center")))
    {
      localObject = new Intent(this, GameCenterUI.class);
      ((Intent)localObject).putExtra("jump_find_more_friends", "jump_find_more_friends");
      startActivity((Intent)localObject);
    }
    AppMethodBeat.o(112049);
  }
  
  private void bHq()
  {
    AppMethodBeat.i(112050);
    Object localObject = com.tencent.mm.plugin.game.model.e.bFS();
    int i = this.nor;
    int j = this.nAB;
    if (this.nor == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aq(i, (LinkedList)localObject, j, bool);
      g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      this.nvN = true;
      AppMethodBeat.o(112050);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(112048);
    bHl();
    finish();
    AppMethodBeat.o(112048);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969769;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112047);
    setMMTitle(2131300386);
    setBackBtn(new GameLibraryUI.1(this));
    if (!bo.isNullOrNil(com.tencent.mm.plugin.game.model.e.bGf())) {
      addIconOptionMenu(0, 2131304318, 2131230741, new GameLibraryUI.2(this));
    }
    this.nvL = ((ListView)findViewById(2131824671));
    this.nvL.setOnItemClickListener(this.nvE);
    this.nvE.setSourceScene(this.nok);
    this.nvL.setOnScrollListener(this.nvS);
    this.nvM = new l(this);
    this.nvM.setSourceScene(this.nok);
    this.nvM.a(this.nvR);
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject = localLayoutInflater.inflate(2130969777, this.nvL, false);
    this.nAu = ((GameBannerView)((View)localObject).findViewById(2131824681));
    this.nAu.setSourceScene(this.nok);
    this.nvL.addHeaderView((View)localObject);
    this.nAG += 1;
    this.nAv = ((GameLibraryCategoriesView)localLayoutInflater.inflate(2130969771, this.nvL, false));
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.nAv);
    this.nvL.addHeaderView((View)localObject);
    this.nAG += 1;
    this.nAw = localLayoutInflater.inflate(2130969776, this.nvL, false);
    this.nAw.setOnClickListener(this.nAH);
    this.nAx = ((TextView)this.nAw.findViewById(2131824680));
    this.nAy = localLayoutInflater.inflate(2130969770, this.nvL, false);
    this.nAy.setOnClickListener(null);
    this.nAz = ((GameDropdownView)this.nAy.findViewById(2131824673));
    this.nAz.setAnchorView(this.nAy);
    this.nAz.setOnSelectionChangedListener(this.nAJ);
    this.ejC = localLayoutInflater.inflate(2130969779, this.nvL, false);
    this.ejC.setVisibility(8);
    localObject = new LinearLayout(this);
    ((LinearLayout)localObject).addView(this.ejC);
    this.nvL.addFooterView((View)localObject);
    this.nAC = localLayoutInflater.inflate(2130969775, this.nvL, false);
    this.nAC.setVisibility(8);
    this.nAD = ((Button)this.nAC.findViewById(2131824678));
    this.nAD.setOnClickListener(this.nAI);
    this.nvL.addFooterView(this.nAC);
    this.nvL.setAdapter(this.nvM);
    AppMethodBeat.o(112047);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(112052);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 != 1)
    {
      ab.e("MicroMsg.GameLibraryUI", "error request code");
      AppMethodBeat.o(112052);
      return;
    }
    AppMethodBeat.o(112052);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112042);
    super.onCreate(paramBundle);
    if (!g.RG())
    {
      ab.e("MicroMsg.GameLibraryUI", "account not ready");
      finish();
      AppMethodBeat.o(112042);
      return;
    }
    this.nok = getIntent().getIntExtra("game_report_from_scene", 0);
    g.Rc().a(1218, this);
    initView();
    paramBundle = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bET().PN("pb_library");
    if (paramBundle == null) {
      ab.i("MicroMsg.GameLibraryUI", "No cache found");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        this.lFU = com.tencent.mm.plugin.game.f.c.en(this);
        this.lFU.show();
      }
      bHq();
      com.tencent.mm.game.report.c.a(this, 11, 1100, 0, 1, this.nok, null);
      AppMethodBeat.o(112042);
      return;
      g.RO().ac(new GameLibraryUI.4(this, paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112045);
    ab.i("MicroMsg.GameLibraryUI", "onDestroy");
    super.onDestroy();
    g.Rc().b(1218, this);
    this.nvM.clear();
    if (this.nAu != null) {
      this.nAu.nvk.stopTimer();
    }
    AppMethodBeat.o(112045);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(112046);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(112046);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(112046);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(112044);
    super.onPause();
    if (this.nAu != null)
    {
      GameBannerView localGameBannerView = this.nAu;
      if (localGameBannerView.nvk != null)
      {
        localGameBannerView.nvk.stopTimer();
        ab.i("MicroMsg.GameBannerView", "Auto scroll stopped");
      }
    }
    AppMethodBeat.o(112044);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(112043);
    super.onResume();
    if (!g.RG())
    {
      ab.e("MicroMsg.GameLibraryUI", "account not ready");
      AppMethodBeat.o(112043);
      return;
    }
    this.nvM.refresh();
    if ((!this.evP) && (this.nAu != null))
    {
      GameBannerView localGameBannerView = this.nAu;
      if ((localGameBannerView.nvk != null) && (localGameBannerView.nvk.dtj()) && (localGameBannerView.nvj.size() > 1))
      {
        localGameBannerView.nvk.ag(5000L, 5000L);
        ab.i("MicroMsg.GameBannerView", "Auto scroll restarted");
      }
    }
    if (this.evP) {
      this.evP = false;
    }
    AppMethodBeat.o(112043);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(112051);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(112051);
        return;
        paramString = ((aq)paramm).lFp.fsW.fta;
        g.RO().ac(new GameLibraryUI.9(this, paramString));
      }
    }
    if (!a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      Toast.makeText(this, getString(2131300407, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    if (this.lFU != null) {
      this.lFU.cancel();
    }
    AppMethodBeat.o(112051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI
 * JD-Core Version:    0.7.0.1
 */