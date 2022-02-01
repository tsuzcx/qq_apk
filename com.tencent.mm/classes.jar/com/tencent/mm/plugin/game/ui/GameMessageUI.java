package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.x.a;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.am.h
{
  private AbsListView.OnScrollListener INJ;
  private n ITA;
  private View ITB;
  private int ITC;
  private boolean ITD;
  private boolean ITE;
  private String ITF;
  private long ITG;
  private DialogInterface.OnClickListener ITH;
  private DialogInterface.OnClickListener ITI;
  private ListView ITz;
  private int lCR;
  private int lum;
  private TextView pNO;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(42302);
    this.ITC = 1;
    this.ITD = false;
    this.ITE = false;
    this.lum = 0;
    this.ITF = "";
    this.INJ = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42300);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!GameMessageUI.b(GameMessageUI.this).dmY()))
        {
          GameMessageUI.b(GameMessageUI.this).fHx();
          GameMessageUI.b(GameMessageUI.this).onNotifyChange(null, null);
        }
        AppMethodBeat.o(42300);
      }
    };
    AppMethodBeat.o(42302);
  }
  
  private void XO(int paramInt)
  {
    AppMethodBeat.i(42306);
    if (this.pNO == null) {
      this.pNO = ((TextView)findViewById(h.e.HWi));
    }
    this.pNO.setVisibility(paramInt);
    AppMethodBeat.o(42306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42308);
    ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGB();
    finish();
    AppMethodBeat.o(42308);
  }
  
  public final int fHm()
  {
    return 1300;
  }
  
  public final int fHn()
  {
    return this.lCR;
  }
  
  public final String fHo()
  {
    return null;
  }
  
  public final String fHp()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return h.f.HZU;
  }
  
  public final int getScene()
  {
    return 13;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42305);
    setMMTitle(h.i.HZU);
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
    addTextOptionMenu(0, getString(h.i.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42298);
        GameMessageUI.a(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(42297);
            ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGE();
            GameMessageUI.b(GameMessageUI.this).aNz();
            GameMessageUI.b(GameMessageUI.this).notifyDataSetChanged();
            AppMethodBeat.o(42297);
          }
        });
        GameMessageUI.b(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        k.a(GameMessageUI.this.getContext(), h.i.IaI, 0, GameMessageUI.c(GameMessageUI.this), GameMessageUI.d(GameMessageUI.this));
        AppMethodBeat.o(42298);
        return false;
      }
    });
    this.lCR = getIntent().getIntExtra("game_report_from_scene", 0);
    this.ITz = ((ListView)findViewById(h.e.HWj));
    this.ITz.setOnItemClickListener(this);
    if (this.lum > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.hP(this)) {
        break label325;
      }
      this.ITB = View.inflate(this, h.f.Iaa, null);
      this.ITB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42301);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!Util.isNullOrNil(GameMessageUI.f(GameMessageUI.this)))
          {
            int i = c.ba(GameMessageUI.this.getContext(), GameMessageUI.f(GameMessageUI.this));
            g.a(GameMessageUI.this.getContext(), 13, 1302, 1, i, GameMessageUI.g(GameMessageUI.this), null);
          }
          GameMessageUI.h(GameMessageUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42301);
        }
      });
      this.ITz.addHeaderView(this.ITB);
      this.ITB.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.hQ(this);
    }
    for (;;)
    {
      Object localObject = new o();
      ((o)localObject).IEm = true;
      this.ITA = new n(this, (o)localObject, this.lCR, this.ITG);
      this.ITA.Lh(true);
      XO(8);
      this.ITA.a(new x.a()
      {
        public final void bWC()
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
      this.ITz.setOnScrollListener(this.INJ);
      this.ITz.setAdapter(this.ITA);
      localObject = this.ITz;
      n localn = this.ITA;
      Log.i("MicroMsg.GameMessageAdapter", "init position:%d", new Object[] { Integer.valueOf(localn.ITa) });
      if (localn.ITa > localn.getCount() - 1) {
        localn.ITa = (localn.getCount() - 1);
      }
      ((ListView)localObject).setSelection(localn.ITa);
      g.a(getContext(), 13, 1300, 0, 1, 0, null, this.lCR, 0, null, null, null);
      AppMethodBeat.o(42305);
      return;
      label325:
      if (this.ITB != null) {
        this.ITB.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42303);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(573, this);
    this.lum = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.ITF = getIntent().getStringExtra("game_manage_url");
    this.ITG = getIntent().getLongExtra("game_msg_ui_from_msgid", 0L);
    Log.i("MicroMsg.GameMessageUI", "init msgId:%d", new Object[] { Long.valueOf(this.ITG) });
    initView();
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.e.class)).fCg().fGx();
    AppMethodBeat.o(42303);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42309);
    super.onDestroy();
    if (this.ITA != null) {
      this.ITA.fSd();
    }
    com.tencent.mm.kernel.h.aZW().b(573, this);
    ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGC();
    ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGB();
    AppMethodBeat.o(42309);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42310);
    Object localObject = new b();
    ((b)localObject).cH(paramAdapterView);
    ((b)localObject).cH(paramView);
    ((b)localObject).sc(paramInt);
    ((b)localObject).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      Log.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    paramAdapterView.fGp();
    paramView = g.a(null, null, paramAdapterView.IEi, null);
    if (paramAdapterView.field_msgType == 100)
    {
      if (!Util.isNullOrNil(paramAdapterView.IDQ))
      {
        localObject = (o.h)paramAdapterView.IDv.get(paramAdapterView.IDQ);
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42310);
          return;
        }
        paramInt = com.tencent.mm.plugin.game.model.p.a(this, paramAdapterView, (o.h)localObject, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.lCR, paramAdapterView.IEh, paramAdapterView.field_gameMsgId, paramAdapterView.mNoticeId, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    if (paramAdapterView.IEk == 0)
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
        } while (Util.isNullOrNil(paramAdapterView.IDi));
        paramInt = c.ba(this, paramAdapterView.IDi);
      }
      for (;;)
      {
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.lCR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.mNoticeId, paramView);
        break;
        if (Util.isNullOrNil(paramAdapterView.IDL)) {
          break;
        }
        paramInt = c.ba(this, paramAdapterView.IDL);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.h.y(this, paramAdapterView.field_appId))
        {
          com.tencent.mm.plugin.game.model.e.au(this, paramAdapterView.field_appId);
          paramInt = 3;
        }
        else
        {
          localObject = new Bundle();
          ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
          ((Bundle)localObject).putInt("game_report_from_scene", 1301);
          paramInt = c.b(this, paramAdapterView.field_appId, null, (Bundle)localObject);
        }
      }
    }
    switch (paramAdapterView.IEk)
    {
    default: 
      Log.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.IEk);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
      if (Util.isNullOrNil(paramAdapterView.field_appId))
      {
        Log.e("MicroMsg.GameMessageUI", "appid is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(42310);
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
      ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      paramInt = c.b(this, paramAdapterView.field_appId, null, (Bundle)localObject);
      g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.lCR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.mNoticeId, paramView);
      continue;
      if (com.tencent.mm.pluginsdk.model.app.h.y(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.au(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = c.b(this, paramAdapterView.field_appId, null, (Bundle)localObject))
      {
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.lCR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.mNoticeId, paramView);
        break;
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
        ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      }
      if (!Util.isNullOrNil(paramAdapterView.IEl))
      {
        paramInt = c.ba(this, paramAdapterView.IEl);
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.lCR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.mNoticeId, paramView);
      }
      else
      {
        Log.e("MicroMsg.GameMessageUI", "jumpurl is null");
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
    this.ITA.notifyDataSetChanged();
    if ((this.ITE) && (this.ITB != null)) {
      this.ITz.removeHeaderView(this.ITB);
    }
    AppMethodBeat.o(42304);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(42311);
    Log.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.getType()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 573)
      {
        XO(8);
        this.ITA.onNotifyChange(null, null);
        AppMethodBeat.o(42311);
      }
    }
    else
    {
      if (this.ITA.getCount() > 0)
      {
        Log.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(42311);
        return;
      }
      if (com.tencent.mm.plugin.game.a.a.pFo.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(42311);
        return;
      }
      Toast.makeText(this, getString(h.i.Iba, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(42311);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */