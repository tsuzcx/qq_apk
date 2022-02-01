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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, i
{
  private AbsListView.OnScrollListener CTt;
  private ListView CZj;
  private n CZk;
  private View CZl;
  private int CZm;
  private boolean CZn;
  private boolean CZo;
  private String CZp;
  private long CZq;
  private DialogInterface.OnClickListener CZr;
  private DialogInterface.OnClickListener CZs;
  private int iSp;
  private int jaR;
  private TextView mRh;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(42302);
    this.CZm = 1;
    this.CZn = false;
    this.CZo = false;
    this.iSp = 0;
    this.CZp = "";
    this.CTt = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42300);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!GameMessageUI.b(GameMessageUI.this).cJI()))
        {
          GameMessageUI.b(GameMessageUI.this).ezz();
          GameMessageUI.b(GameMessageUI.this).onNotifyChange(null, null);
        }
        AppMethodBeat.o(42300);
      }
    };
    AppMethodBeat.o(42302);
  }
  
  private void TU(int paramInt)
  {
    AppMethodBeat.i(42306);
    if (this.mRh == null) {
      this.mRh = ((TextView)findViewById(g.e.Cka));
    }
    this.mRh.setVisibility(paramInt);
    AppMethodBeat.o(42306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42308);
    ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyF();
    finish();
    AppMethodBeat.o(42308);
  }
  
  public final int ezq()
  {
    return 1300;
  }
  
  public final int ezr()
  {
    return this.jaR;
  }
  
  public int getLayoutId()
  {
    return g.f.CnM;
  }
  
  public final int getScene()
  {
    return 13;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42305);
    setMMTitle(g.i.CnM);
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
    addTextOptionMenu(0, getString(g.i.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42298);
        GameMessageUI.a(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(42297);
            ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyI();
            GameMessageUI.b(GameMessageUI.this).ats();
            GameMessageUI.b(GameMessageUI.this).notifyDataSetChanged();
            AppMethodBeat.o(42297);
          }
        });
        GameMessageUI.b(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        com.tencent.mm.ui.base.h.a(GameMessageUI.this.getContext(), g.i.CoA, 0, GameMessageUI.c(GameMessageUI.this), GameMessageUI.d(GameMessageUI.this));
        AppMethodBeat.o(42298);
        return false;
      }
    });
    this.jaR = getIntent().getIntExtra("game_report_from_scene", 0);
    this.CZj = ((ListView)findViewById(g.e.Ckb));
    this.CZj.setOnItemClickListener(this);
    if (this.iSp > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.gw(this)) {
        break label325;
      }
      this.CZl = View.inflate(this, g.f.CnS, null);
      this.CZl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42301);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!Util.isNullOrNil(GameMessageUI.f(GameMessageUI.this)))
          {
            int i = c.aY(GameMessageUI.this.getContext(), GameMessageUI.f(GameMessageUI.this));
            g.a(GameMessageUI.this.getContext(), 13, 1302, 1, i, GameMessageUI.g(GameMessageUI.this), null);
          }
          GameMessageUI.h(GameMessageUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42301);
        }
      });
      this.CZj.addHeaderView(this.CZl);
      this.CZl.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.gx(this);
    }
    for (;;)
    {
      Object localObject = new o();
      ((o)localObject).CKc = true;
      this.CZk = new n(this, (o)localObject, this.jaR, this.CZq);
      this.CZk.Fx(true);
      TU(8);
      this.CZk.a(new v.a()
      {
        public final void bxN()
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
      this.CZj.setOnScrollListener(this.CTt);
      this.CZj.setAdapter(this.CZk);
      localObject = this.CZj;
      n localn = this.CZk;
      Log.i("MicroMsg.GameMessageAdapter", "init position:%d", new Object[] { Integer.valueOf(localn.CYK) });
      if (localn.CYK > localn.getCount() - 1) {
        localn.CYK = (localn.getCount() - 1);
      }
      ((ListView)localObject).setSelection(localn.CYK);
      g.a(getContext(), 13, 1300, 0, 1, 0, null, this.jaR, 0, null, null, null);
      AppMethodBeat.o(42305);
      return;
      label325:
      if (this.CZl != null) {
        this.CZl.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42303);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(573, this);
    this.iSp = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.CZp = getIntent().getStringExtra("game_manage_url");
    this.CZq = getIntent().getLongExtra("game_msg_ui_from_msgid", 0L);
    Log.i("MicroMsg.GameMessageUI", "init msgId:%d", new Object[] { Long.valueOf(this.CZq) });
    initView();
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.e.class)).evn().eyB();
    AppMethodBeat.o(42303);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42309);
    super.onDestroy();
    if (this.CZk != null) {
      this.CZk.eKd();
    }
    com.tencent.mm.kernel.h.aGY().b(573, this);
    ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyG();
    ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyF();
    AppMethodBeat.o(42309);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42310);
    Object localObject = new b();
    ((b)localObject).bn(paramAdapterView);
    ((b)localObject).bn(paramView);
    ((b)localObject).sg(paramInt);
    ((b)localObject).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      Log.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    paramAdapterView.eyt();
    paramView = g.a(null, null, paramAdapterView.CJY, null);
    if (paramAdapterView.field_msgType == 100)
    {
      if (!Util.isNullOrNil(paramAdapterView.CJF))
      {
        localObject = (o.h)paramAdapterView.CJk.get(paramAdapterView.CJF);
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42310);
          return;
        }
        paramInt = p.a(this, paramAdapterView, (o.h)localObject, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.jaR, paramAdapterView.CJW, paramAdapterView.field_gameMsgId, paramAdapterView.CJX, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    if (paramAdapterView.CKa == 0)
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
        } while (Util.isNullOrNil(paramAdapterView.CIX));
        paramInt = c.aY(this, paramAdapterView.CIX);
      }
      for (;;)
      {
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.jaR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.CJX, paramView);
        break;
        if (Util.isNullOrNil(paramAdapterView.CJA)) {
          break;
        }
        paramInt = c.aY(this, paramAdapterView.CJA);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.h.u(this, paramAdapterView.field_appId))
        {
          com.tencent.mm.plugin.game.model.e.at(this, paramAdapterView.field_appId);
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
    switch (paramAdapterView.CKa)
    {
    default: 
      Log.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.CKa);
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
      g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.jaR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.CJX, paramView);
      continue;
      if (com.tencent.mm.pluginsdk.model.app.h.u(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.at(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = c.b(this, paramAdapterView.field_appId, null, (Bundle)localObject))
      {
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.jaR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.CJX, paramView);
        break;
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
        ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      }
      if (!Util.isNullOrNil(paramAdapterView.CKb))
      {
        paramInt = c.aY(this, paramAdapterView.CKb);
        g.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.jaR, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.CJX, paramView);
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
    this.CZk.notifyDataSetChanged();
    if ((this.CZo) && (this.CZl != null)) {
      this.CZj.removeHeaderView(this.CZl);
    }
    AppMethodBeat.o(42304);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(42311);
    Log.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 573)
      {
        TU(8);
        this.CZk.onNotifyChange(null, null);
        AppMethodBeat.o(42311);
      }
    }
    else
    {
      if (this.CZk.getCount() > 0)
      {
        Log.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(42311);
        return;
      }
      if (com.tencent.mm.plugin.game.a.a.mIH.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(42311);
        return;
      }
      Toast.makeText(this, getString(g.i.CoS, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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