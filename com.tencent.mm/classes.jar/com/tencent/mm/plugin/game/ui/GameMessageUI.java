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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r.a;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.al.f
{
  private int fGO;
  private int fPp;
  private TextView iYS;
  private AbsListView.OnScrollListener ulN;
  private ListView urH;
  private n urI;
  private View urJ;
  private int urK;
  private boolean urL;
  private boolean urM;
  private String urN;
  private long urO;
  private DialogInterface.OnClickListener urP;
  private DialogInterface.OnClickListener urQ;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(42302);
    this.urK = 1;
    this.urL = false;
    this.urM = false;
    this.fGO = 0;
    this.urN = "";
    this.ulN = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42300);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!GameMessageUI.b(GameMessageUI.this).bXb()))
        {
          GameMessageUI.b(GameMessageUI.this).dab();
          GameMessageUI.b(GameMessageUI.this).a(null, null);
        }
        AppMethodBeat.o(42300);
      }
    };
    AppMethodBeat.o(42302);
  }
  
  private void Ib(int paramInt)
  {
    AppMethodBeat.i(42306);
    if (this.iYS == null) {
      this.iYS = ((TextView)findViewById(2131300519));
    }
    this.iYS.setVisibility(paramInt);
    AppMethodBeat.o(42306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42308);
    ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZg();
    finish();
    AppMethodBeat.o(42308);
  }
  
  public final int cZQ()
  {
    return 1300;
  }
  
  public final int cZR()
  {
    return this.fPp;
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
            ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().execSQL("GameRawMessage", "delete from GameRawMessage");
            GameMessageUI.b(GameMessageUI.this).Zv();
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
    this.fPp = getIntent().getIntExtra("game_report_from_scene", 0);
    this.urH = ((ListView)findViewById(2131300521));
    this.urH.setOnItemClickListener(this);
    if (this.fGO > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.fs(this)) {
        break label319;
      }
      this.urJ = View.inflate(this, 2131494359, null);
      this.urJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42301);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!bt.isNullOrNil(GameMessageUI.f(GameMessageUI.this)))
          {
            int i = c.aB(GameMessageUI.this.getContext(), GameMessageUI.f(GameMessageUI.this));
            com.tencent.mm.game.report.f.a(GameMessageUI.this.getContext(), 13, 1302, 1, i, GameMessageUI.g(GameMessageUI.this), null);
          }
          GameMessageUI.h(GameMessageUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42301);
        }
      });
      this.urH.addHeaderView(this.urJ);
      this.urJ.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.ft(this);
    }
    for (;;)
    {
      Object localObject = new o();
      ((o)localObject).ucF = true;
      this.urI = new n(this, (o)localObject, this.fPp, this.urO);
      this.urI.xk(true);
      Ib(8);
      this.urI.a(new r.a()
      {
        public final void aSs()
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
      this.urH.setOnScrollListener(this.ulN);
      this.urH.setAdapter(this.urI);
      localObject = this.urH;
      n localn = this.urI;
      ad.i("MicroMsg.GameMessageAdapter", "init position:%d", new Object[] { Integer.valueOf(localn.urg) });
      if (localn.urg > localn.getCount() - 1) {
        localn.urg = (localn.getCount() - 1);
      }
      ((ListView)localObject).setSelection(localn.urg);
      com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, 0, null, this.fPp, 0, null, null, null);
      AppMethodBeat.o(42305);
      return;
      label319:
      if (this.urJ != null) {
        this.urJ.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42303);
    super.onCreate(paramBundle);
    g.aiU().a(573, this);
    this.fGO = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.urN = getIntent().getStringExtra("game_manage_url");
    this.urO = getIntent().getLongExtra("game_msg_ui_from_msgid", 0L);
    ad.i("MicroMsg.GameMessageUI", "init msgId:%d", new Object[] { Long.valueOf(this.urO) });
    initView();
    ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cWG();
    r.cZc();
    AppMethodBeat.o(42303);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42309);
    super.onDestroy();
    if (this.urI != null) {
      this.urI.det();
    }
    g.aiU().b(573, this);
    ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZh();
    ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZg();
    AppMethodBeat.o(42309);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42310);
    Object localObject = new b();
    ((b)localObject).bd(paramAdapterView);
    ((b)localObject).bd(paramView);
    ((b)localObject).mr(paramInt);
    ((b)localObject).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahq());
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      ad.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    paramAdapterView.cYU();
    paramView = com.tencent.mm.game.report.f.a(null, null, paramAdapterView.ucB, null);
    if (paramAdapterView.field_msgType == 100)
    {
      if (!bt.isNullOrNil(paramAdapterView.uck))
      {
        localObject = (o.f)paramAdapterView.ubP.get(paramAdapterView.uck);
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42310);
          return;
        }
        paramInt = p.a(this, paramAdapterView, (o.f)localObject, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fPp, paramAdapterView.ucz, paramAdapterView.field_gameMsgId, paramAdapterView.ucA, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    if (paramAdapterView.ucD == 0)
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42310);
          return;
        } while (bt.isNullOrNil(paramAdapterView.ubC));
        paramInt = c.aB(this, paramAdapterView.ubC);
      }
      for (;;)
      {
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fPp, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.ucA, paramView);
        break;
        if (bt.isNullOrNil(paramAdapterView.ucf)) {
          break;
        }
        paramInt = c.aB(this, paramAdapterView.ucf);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.h.s(this, paramAdapterView.field_appId))
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
    switch (paramAdapterView.ucD)
    {
    default: 
      ad.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.ucD);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
      if (bt.isNullOrNil(paramAdapterView.field_appId))
      {
        ad.e("MicroMsg.GameMessageUI", "appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(42310);
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      paramInt = c.a(this, paramAdapterView.field_appId, null, (Bundle)localObject);
      com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fPp, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.ucA, paramView);
      continue;
      if (com.tencent.mm.pluginsdk.model.app.h.s(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.ai(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = c.a(this, paramAdapterView.field_appId, null, (Bundle)localObject))
      {
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fPp, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.ucA, paramView);
        break;
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
        ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      }
      if (!bt.isNullOrNil(paramAdapterView.ucE))
      {
        paramInt = c.aB(this, paramAdapterView.ucE);
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.fPp, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.ucA, paramView);
      }
      else
      {
        ad.e("MicroMsg.GameMessageUI", "jumpurl is null");
      }
    }
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
    this.urI.notifyDataSetChanged();
    if ((this.urM) && (this.urJ != null)) {
      this.urH.removeHeaderView(this.urJ);
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
        Ib(8);
        this.urI.a(null, null);
        AppMethodBeat.o(42311);
      }
    }
    else
    {
      if (this.urI.getCount() > 0)
      {
        ad.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(42311);
        return;
      }
      if (com.tencent.mm.plugin.game.a.a.iRH.a(this, paramInt1, paramInt2, paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */