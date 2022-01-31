package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, f
{
  private int eaZ;
  private int ejF;
  private TextView gsy;
  private ListView nBQ;
  private n nBR;
  private View nBS;
  private int nBT;
  private boolean nBU;
  private boolean nBV;
  private String nBW;
  private DialogInterface.OnClickListener nBX;
  private DialogInterface.OnClickListener nBY;
  private AbsListView.OnScrollListener nvS;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(112105);
    this.nBT = 1;
    this.nBU = false;
    this.nBV = false;
    this.eaZ = 0;
    this.nBW = "";
    this.nvS = new GameMessageUI.4(this);
    AppMethodBeat.o(112105);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(112111);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGw();
    finish();
    AppMethodBeat.o(112111);
  }
  
  private void xm(int paramInt)
  {
    AppMethodBeat.i(112109);
    if (this.gsy == null) {
      this.gsy = ((TextView)findViewById(2131824699));
    }
    this.gsy.setVisibility(paramInt);
    AppMethodBeat.o(112109);
  }
  
  public final int bHg()
  {
    return 1300;
  }
  
  public final int bHh()
  {
    return this.ejF;
  }
  
  public int getLayoutId()
  {
    return 2130969792;
  }
  
  public final int getScene()
  {
    return 13;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112115);
    setMMTitle(2131300420);
    setBackBtn(new GameMessageUI.1(this));
    addTextOptionMenu(0, getString(2131296891), new GameMessageUI.2(this));
    this.ejF = getIntent().getIntExtra("game_report_from_scene", 0);
    this.nBQ = ((ListView)findViewById(2131824698));
    this.nBQ.setOnItemClickListener(this);
    if (this.eaZ > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.eg(this)) {
        break label253;
      }
      this.nBS = View.inflate(this, 2130969796, null);
      this.nBS.setOnClickListener(new GameMessageUI.5(this));
      this.nBQ.addHeaderView(this.nBS);
      this.nBS.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.eh(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.game.model.n localn = new com.tencent.mm.plugin.game.model.n();
      localn.nnP = true;
      this.nBR = new n(this, localn, this.ejF);
      this.nBR.qp(true);
      xm(8);
      this.nBR.a(new GameMessageUI.3(this));
      this.nBQ.setOnScrollListener(this.nvS);
      this.nBQ.setAdapter(this.nBR);
      com.tencent.mm.game.report.c.a(getContext(), 13, 1300, 0, 1, 0, null, this.ejF, 0, null, null, null);
      AppMethodBeat.o(112115);
      return;
      label253:
      if (this.nBS != null) {
        this.nBS.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112106);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(573, this);
    this.eaZ = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.nBW = getIntent().getStringExtra("game_manage_url");
    initView();
    ((d)com.tencent.mm.kernel.g.E(d.class)).bER();
    q.bGs();
    AppMethodBeat.o(112106);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112112);
    super.onDestroy();
    if (this.nBR != null) {
      this.nBR.bKb();
    }
    com.tencent.mm.kernel.g.Rc().b(573, this);
    r localr = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES();
    String str = "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")";
    ab.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[] { Boolean.valueOf(localr.execSQL("GameRawMessage", str)), str });
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGw();
    AppMethodBeat.o(112112);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112113);
    paramAdapterView = (com.tencent.mm.plugin.game.model.n)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(112113);
      return;
    }
    paramAdapterView.bGm();
    if (paramAdapterView.field_msgType == 100)
    {
      if (!bo.isNullOrNil(paramAdapterView.nny))
      {
        paramView = (n.e)paramAdapterView.nne.get(paramAdapterView.nny);
        if (paramView == null)
        {
          AppMethodBeat.o(112113);
          return;
        }
        paramInt = o.a(this, paramAdapterView, paramView, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          com.tencent.mm.game.report.c.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.ejF, paramAdapterView.nnL, paramAdapterView.field_gameMsgId, paramAdapterView.nnM, null);
        }
      }
      AppMethodBeat.o(112113);
      return;
    }
    if (paramAdapterView.nnN == 0)
    {
      switch (paramAdapterView.field_msgType)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      case 9: 
      default: 
      case 10: 
      case 11: 
        do
        {
          AppMethodBeat.o(112113);
          return;
        } while (bo.isNullOrNil(paramAdapterView.nmR));
        paramInt = com.tencent.mm.plugin.game.f.c.ax(this, paramAdapterView.nmR);
      }
      for (;;)
      {
        com.tencent.mm.game.report.c.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.ejF, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.nnM, null);
        break;
        if (bo.isNullOrNil(paramAdapterView.nnt)) {
          break;
        }
        paramInt = com.tencent.mm.plugin.game.f.c.ax(this, paramAdapterView.nnt);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.g.u(this, paramAdapterView.field_appId))
        {
          com.tencent.mm.plugin.game.model.e.aj(this, paramAdapterView.field_appId);
          paramInt = 3;
        }
        else
        {
          paramView = new Bundle();
          paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
          paramView.putInt("game_report_from_scene", 1301);
          paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView);
        }
      }
    }
    switch (paramAdapterView.nnN)
    {
    default: 
      ab.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.nnN);
      AppMethodBeat.o(112113);
      return;
    case 1: 
      if (bo.isNullOrNil(paramAdapterView.field_appId))
      {
        ab.e("MicroMsg.GameMessageUI", "appid is null");
        AppMethodBeat.o(112113);
        return;
      }
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
      paramView.putInt("game_report_from_scene", 1301);
      paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView);
      com.tencent.mm.game.report.c.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.ejF, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.nnM, null);
      AppMethodBeat.o(112113);
      return;
    case 2: 
      if (com.tencent.mm.pluginsdk.model.app.g.u(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.aj(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView))
      {
        com.tencent.mm.game.report.c.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.ejF, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.nnM, null);
        AppMethodBeat.o(112113);
        return;
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
        paramView.putInt("game_report_from_scene", 1301);
      }
    }
    if (!bo.isNullOrNil(paramAdapterView.nnO))
    {
      paramInt = com.tencent.mm.plugin.game.f.c.ax(this, paramAdapterView.nnO);
      com.tencent.mm.game.report.c.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.ejF, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.nnM, null);
      AppMethodBeat.o(112113);
      return;
    }
    ab.e("MicroMsg.GameMessageUI", "jumpurl is null");
    AppMethodBeat.o(112113);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(112110);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(112110);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(112110);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(112107);
    super.onResume();
    this.nBR.notifyDataSetChanged();
    if ((this.nBV) && (this.nBS != null)) {
      this.nBQ.removeHeaderView(this.nBS);
    }
    AppMethodBeat.o(112107);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(112114);
    ab.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 573)
      {
        xm(8);
        this.nBR.a(null, null);
        AppMethodBeat.o(112114);
      }
    }
    else
    {
      if (this.nBR.getCount() > 0)
      {
        ab.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(112114);
        return;
      }
      if (a.gmP.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(112114);
        return;
      }
      Toast.makeText(this, getString(2131300379, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(112114);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */