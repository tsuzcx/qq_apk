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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s.a;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, i
{
  private int gog;
  private int gwE;
  private TextView jZO;
  private AbsListView.OnScrollListener xPk;
  private ListView xUY;
  private n xUZ;
  private View xVa;
  private int xVb;
  private boolean xVc;
  private boolean xVd;
  private String xVe;
  private long xVf;
  private DialogInterface.OnClickListener xVg;
  private DialogInterface.OnClickListener xVh;
  
  public GameMessageUI()
  {
    AppMethodBeat.i(42302);
    this.xVb = 1;
    this.xVc = false;
    this.xVd = false;
    this.gog = 0;
    this.xVe = "";
    this.xPk = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(42300);
        if ((paramAnonymousInt == 0) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!GameMessageUI.b(GameMessageUI.this).cwg()))
        {
          GameMessageUI.b(GameMessageUI.this).dWt();
          GameMessageUI.b(GameMessageUI.this).onNotifyChange(null, null);
        }
        AppMethodBeat.o(42300);
      }
    };
    AppMethodBeat.o(42302);
  }
  
  private void OA(int paramInt)
  {
    AppMethodBeat.i(42306);
    if (this.jZO == null) {
      this.jZO = ((TextView)findViewById(2131302046));
    }
    this.jZO.setVisibility(paramInt);
    AppMethodBeat.o(42306);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42308);
    ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVx();
    finish();
    AppMethodBeat.o(42308);
  }
  
  public final int dWi()
  {
    return 1300;
  }
  
  public final int dWj()
  {
    return this.gwE;
  }
  
  public int getLayoutId()
  {
    return 2131494916;
  }
  
  public final int getScene()
  {
    return 13;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42305);
    setMMTitle(2131761282);
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
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42298);
        GameMessageUI.a(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(42297);
            ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVA();
            GameMessageUI.b(GameMessageUI.this).anq();
            GameMessageUI.b(GameMessageUI.this).notifyDataSetChanged();
            AppMethodBeat.o(42297);
          }
        });
        GameMessageUI.b(GameMessageUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        com.tencent.mm.ui.base.h.a(GameMessageUI.this.getContext(), 2131761174, 0, GameMessageUI.c(GameMessageUI.this), GameMessageUI.d(GameMessageUI.this));
        AppMethodBeat.o(42298);
        return false;
      }
    });
    this.gwE = getIntent().getIntExtra("game_report_from_scene", 0);
    this.xUY = ((ListView)findViewById(2131302048));
    this.xUY.setOnItemClickListener(this);
    if (this.gog > 20)
    {
      if (!com.tencent.mm.plugin.game.model.e.gc(this)) {
        break label319;
      }
      this.xVa = View.inflate(this, 2131494925, null);
      this.xVa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(42301);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!Util.isNullOrNil(GameMessageUI.f(GameMessageUI.this)))
          {
            int i = c.aQ(GameMessageUI.this.getContext(), GameMessageUI.f(GameMessageUI.this));
            com.tencent.mm.game.report.f.a(GameMessageUI.this.getContext(), 13, 1302, 1, i, GameMessageUI.g(GameMessageUI.this), null);
          }
          GameMessageUI.h(GameMessageUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(42301);
        }
      });
      this.xUY.addHeaderView(this.xVa);
      this.xVa.setVisibility(0);
      com.tencent.mm.plugin.game.model.e.gd(this);
    }
    for (;;)
    {
      Object localObject = new o();
      ((o)localObject).xGb = true;
      this.xUZ = new n(this, (o)localObject, this.gwE, this.xVf);
      this.xUZ.Bh(true);
      OA(8);
      this.xUZ.a(new s.a()
      {
        public final void bnE()
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
      this.xUY.setOnScrollListener(this.xPk);
      this.xUY.setAdapter(this.xUZ);
      localObject = this.xUY;
      n localn = this.xUZ;
      Log.i("MicroMsg.GameMessageAdapter", "init position:%d", new Object[] { Integer.valueOf(localn.xUz) });
      if (localn.xUz > localn.getCount() - 1) {
        localn.xUz = (localn.getCount() - 1);
      }
      ((ListView)localObject).setSelection(localn.xUz);
      com.tencent.mm.game.report.f.a(getContext(), 13, 1300, 0, 1, 0, null, this.gwE, 0, null, null, null);
      AppMethodBeat.o(42305);
      return;
      label319:
      if (this.xVa != null) {
        this.xVa.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42303);
    super.onCreate(paramBundle);
    g.azz().a(573, this);
    this.gog = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.xVe = getIntent().getStringExtra("game_manage_url");
    this.xVf = getIntent().getLongExtra("game_msg_ui_from_msgid", 0L);
    Log.i("MicroMsg.GameMessageUI", "init msgId:%d", new Object[] { Long.valueOf(this.xVf) });
    initView();
    ((com.tencent.mm.plugin.game.api.e)g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
    r.dVt();
    AppMethodBeat.o(42303);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42309);
    super.onDestroy();
    if (this.xUZ != null) {
      this.xUZ.ebf();
    }
    g.azz().b(573, this);
    ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVy();
    ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVx();
    AppMethodBeat.o(42309);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42310);
    Object localObject = new b();
    ((b)localObject).bm(paramAdapterView);
    ((b)localObject).bm(paramView);
    ((b)localObject).pH(paramInt);
    ((b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      Log.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    paramAdapterView.dVl();
    paramView = com.tencent.mm.game.report.f.a(null, null, paramAdapterView.xFX, null);
    if (paramAdapterView.field_msgType == 100)
    {
      if (!Util.isNullOrNil(paramAdapterView.xFE))
      {
        localObject = (o.g)paramAdapterView.xFj.get(paramAdapterView.xFE);
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(42310);
          return;
        }
        paramInt = p.a(this, paramAdapterView, (o.g)localObject, paramAdapterView.field_appId, 1301);
        if (paramInt != 0) {
          com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.gwE, paramAdapterView.xFV, paramAdapterView.field_gameMsgId, paramAdapterView.xFW, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMessageUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(42310);
      return;
    }
    if (paramAdapterView.xFZ == 0)
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
        } while (Util.isNullOrNil(paramAdapterView.xEW));
        paramInt = c.aQ(this, paramAdapterView.xEW);
      }
      for (;;)
      {
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.gwE, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.xFW, paramView);
        break;
        if (Util.isNullOrNil(paramAdapterView.xFz)) {
          break;
        }
        paramInt = c.aQ(this, paramAdapterView.xFz);
        continue;
        if (com.tencent.mm.pluginsdk.model.app.h.s(this, paramAdapterView.field_appId))
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
    switch (paramAdapterView.xFZ)
    {
    default: 
      Log.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.xFZ);
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
      com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.gwE, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.xFW, paramView);
      continue;
      if (com.tencent.mm.pluginsdk.model.app.h.s(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.e.at(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = c.b(this, paramAdapterView.field_appId, null, (Bundle)localObject))
      {
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.gwE, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.xFW, paramView);
        break;
        localObject = new Bundle();
        ((Bundle)localObject).putCharSequence("game_app_id", paramAdapterView.field_appId);
        ((Bundle)localObject).putInt("game_report_from_scene", 1301);
      }
      if (!Util.isNullOrNil(paramAdapterView.xGa))
      {
        paramInt = c.aQ(this, paramAdapterView.xGa);
        com.tencent.mm.game.report.f.a(getContext(), 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.gwE, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.xFW, paramView);
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
    this.xUZ.notifyDataSetChanged();
    if ((this.xVd) && (this.xVa != null)) {
      this.xUY.removeHeaderView(this.xVa);
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
        OA(8);
        this.xUZ.onNotifyChange(null, null);
        AppMethodBeat.o(42311);
      }
    }
    else
    {
      if (this.xUZ.getCount() > 0)
      {
        Log.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        AppMethodBeat.o(42311);
        return;
      }
      if (com.tencent.mm.plugin.game.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(42311);
        return;
      }
      Toast.makeText(this, getString(2131761223, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(42311);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */