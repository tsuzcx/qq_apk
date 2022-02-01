package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.q.a;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.g
{
  private int flm;
  private int fsv;
  private TextView ifA;
  private AbsListView.OnScrollListener sfw;
  private ListView slp;
  private n slq;
  private View slr;
  private int sls;
  private boolean slt;
  private boolean slu;
  private String slv;
  private long slw;
  private DialogInterface.OnClickListener slx;
  private DialogInterface.OnClickListener sly;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(42302);
    this.sls = 1;
    this.slt = false;
    this.slu = false;
    this.flm = 0;
    this.slv = "";
    this.sfw = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42300);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!GameMessageUI.b(GameMessageUI.this).bLj()))
        {
          GameMessageUI.b(GameMessageUI.this).cEm();
          GameMessageUI.b(GameMessageUI.this).a(null, null);
        }
        AppMethodBeat.o(42300);
      }
    };
    AppMethodBeat.o(42302);
  }
  
  private void EM(int paramInt)
  {
    AppMethodBeat.i(42306);
    if (this.ifA == null) {
      this.ifA = ((TextView)findViewById(2131300519));
    }
    this.ifA.setVisibility(paramInt);
    AppMethodBeat.o(42306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42308);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDr();
    finish();
    AppMethodBeat.o(42308);
  }
  
  public final int cEa()
  {
    return 1300;
  }
  
  public final int cEb()
  {
    return this.fsv;
  }
  
  public int getLayoutId()
  {
    return 2131494351;
  }
  
  public final int getScene()
  {
    return 13;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42305);
    setMMTitle(2131759933);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42296);
        GameMessageUI.a(GameMessageUI.this);
        AppMethodBeat.o(42296);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42298);
        GameMessageUI.a(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(42297);
            ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().execSQL("GameRawMessage", "delete from GameRawMessage");
            GameMessageUI.b(GameMessageUI.this).We();
            GameMessageUI.b(GameMessageUI.this).notifyDataSetChanged();
            AppMethodBeat.o(42297);
          }
        });
        GameMessageUI.b(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        com.tencent.mm.ui.base.h.a(GameMessageUI.this.getContext(), 2131759840, 0, GameMessageUI.c(GameMessageUI.this), GameMessageUI.d(GameMessageUI.this));
        AppMethodBeat.o(42298);
        return false;
      }
    });
    this.fsv = getIntent().getIntExtra("game_report_from_scene", 0);
    this.slp = ((ListView)findViewById(2131300521));
    this.slp.setOnItemClickListener(this);
    if (this.flm > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.fb(this)) {
        break label319;
      }
      this.slr = View.inflate(this, 2131494359, null);
      this.slr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42301);
          if (!bt.isNullOrNil(GameMessageUI.f(GameMessageUI.this)))
          {
            int i = c.ax(GameMessageUI.this.getContext(), GameMessageUI.f(GameMessageUI.this));
            com.tencent.mm.game.report.e.a(GameMessageUI.this.getContext(), 13, 1302, 1, i, GameMessageUI.g(GameMessageUI.this), null);
          }
          GameMessageUI.h(GameMessageUI.this);
          AppMethodBeat.o(42301);
        }
      });
      this.slp.addHeaderView(this.slr);
      this.slr.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.fc(this);
    }
    for (;;)
    {
      Object localObject = new o();
      ((o)localObject).rWW = true;
      this.slq = new n(this, (o)localObject, this.fsv, this.slw);
      this.slq.vw(true);
      EM(8);
      this.slq.a(new q.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(42299);
          if (GameMessageUI.b(GameMessageUI.this).getCount() == 0)
          {
            GameMessageUI.e(GameMessageUI.this).setVisibility(8);
            GameMessageUI.a(GameMessageUI.this, 0);
            GameMessageUI.this.enableOptionMenu(false);
            AppMethodBeat.o(42299);
            return;
          }
          GameMessageUI.e(GameMessageUI.this).setVisibility(0);
          GameMessageUI.a(GameMessageUI.this, 8);
          GameMessageUI.this.enableOptionMenu(true);
          AppMethodBeat.o(42299);
        }
      });
      this.slp.setOnScrollListener(this.sfw);
      this.slp.setAdapter(this.slq);
      localObject = this.slp;
      n localn = this.slq;
      ad.i("MicroMsg.GameMessageAdapter", "init position:%d", new Object[] { Integer.valueOf(localn.skQ) });
      if (localn.skQ > localn.getCount() - 1) {
        localn.skQ = (localn.getCount() - 1);
      }
      ((ListView)localObject).setSelection(localn.skQ);
      com.tencent.mm.game.report.e.a(getContext(), 13, 1300, 0, 1, 0, null, this.fsv, 0, null, null, null);
      AppMethodBeat.o(42305);
      return;
      label319:
      if (this.slr != null) {
        this.slr.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42303);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(573, this);
    this.flm = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.slv = getIntent().getStringExtra("game_manage_url");
    this.slw = getIntent().getLongExtra("game_msg_ui_from_msgid", 0L);
    ad.i("MicroMsg.GameMessageUI", "init msgId:%d", new Object[] { Long.valueOf(this.slw) });
    initView();
    ((d)com.tencent.mm.kernel.g.ab(d.class)).cBc();
    r.cDn();
    AppMethodBeat.o(42303);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42309);
    super.onDestroy();
    if (this.slq != null) {
      this.slq.cHX();
    }
    com.tencent.mm.kernel.g.aeS().b(573, this);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDs();
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDr();
    AppMethodBeat.o(42309);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42310);
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      ad.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(42310);
      return;
    }
    paramAdapterView.cDf();
    paramView = com.tencent.mm.game.report.e.a(null, null, paramAdapterView.rWS, null);
    Object localObject;
    if (paramAdapterView.field_msgType == 100)
    {
      if (!bt.isNullOrNil(paramAdapterView.rWC))
      {
        localObject = (o.e)paramAdapterView.rWh.get(paramAdapterView.rWC);
        if (localObject == null)
        {
          AppMethodBeat.o(42310);
          return;
        }
        paramInt = p.a(this, paramAdapterView, (o.e)localObject, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          com.tencent.mm.game.report.e.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fsv, paramAdapterView.rWQ, paramAdapterView.field_gameMsgId, paramAdapterView.rWR, paramView);
        }
      }
      AppMethodBeat.o(42310);
      return;
    }
    if (paramAdapterView.rWU == 0)
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
          AppMethodBeat.o(42310);
          return;
        } while (bt.isNullOrNil(paramAdapterView.rVU));
        paramInt = c.ax(this, paramAdapterView.rVU);
      }
      for (;;)
      {
        com.tencent.mm.game.report.e.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fsv, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.rWR, paramView);
        break;
        if (bt.isNullOrNil(paramAdapterView.rWx)) {
          break;
        }
        paramInt = c.ax(this, paramAdapterView.rWx);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.h.t(this, paramAdapterView.field_appId))
        {
          com.tencent.mm.plugin.game.model.e.ai(this, paramAdapterView.field_appId);
          paramInt = 3;
        }
        else
        {
          localObject = new Bundle();
          ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
          ((Bundle)localObject).putInt("game_report_from_scene", 1301);
          paramInt = c.a(this, paramAdapterView.field_appId, null, (Bundle)localObject);
        }
      }
    }
    switch (paramAdapterView.rWU)
    {
    default: 
      ad.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.rWU);
      AppMethodBeat.o(42310);
      return;
    case 1: 
      if (bt.isNullOrNil(paramAdapterView.field_appId))
      {
        ad.e("MicroMsg.GameMessageUI", "appid is null");
        AppMethodBeat.o(42310);
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      paramInt = c.a(this, paramAdapterView.field_appId, null, (Bundle)localObject);
      com.tencent.mm.game.report.e.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fsv, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.rWR, paramView);
      AppMethodBeat.o(42310);
      return;
    case 2: 
      if (com.tencent.mm.pluginsdk.model.app.h.t(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.ai(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = c.a(this, paramAdapterView.field_appId, null, (Bundle)localObject))
      {
        com.tencent.mm.game.report.e.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fsv, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.rWR, paramView);
        AppMethodBeat.o(42310);
        return;
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
        ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      }
    }
    if (!bt.isNullOrNil(paramAdapterView.rWV))
    {
      paramInt = c.ax(this, paramAdapterView.rWV);
      com.tencent.mm.game.report.e.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fsv, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.rWR, paramView);
      AppMethodBeat.o(42310);
      return;
    }
    ad.e("MicroMsg.GameMessageUI", "jumpurl is null");
    AppMethodBeat.o(42310);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42307);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(42307);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42307);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42304);
    super.onResume();
    this.slq.notifyDataSetChanged();
    if ((this.slu) && (this.slr != null)) {
      this.slp.removeHeaderView(this.slr);
    }
    AppMethodBeat.o(42304);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(42311);
    ad.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramn.getType()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 573)
      {
        EM(8);
        this.slq.a(null, null);
        AppMethodBeat.o(42311);
      }
    }
    else
    {
      if (this.slq.getCount() > 0)
      {
        ad.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(42311);
        return;
      }
      if (a.hYu.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(42311);
        return;
      }
      Toast.makeText(this, getString(2131759886, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(42311);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */