package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.game.b.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class GameMessageUI
  extends GameCenterActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ah.f
{
  private int djF = 0;
  private int drX;
  private TextView faG;
  private AbsListView.OnScrollListener kXQ = new GameMessageUI.4(this);
  private ListView ldV;
  private n ldW;
  private View ldX;
  private int ldY = 1;
  private boolean ldZ = false;
  private boolean lea = false;
  private String leb = "";
  private DialogInterface.OnClickListener lec;
  private DialogInterface.OnClickListener led;
  
  private void goBack()
  {
    ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().aZu();
    finish();
  }
  
  private void sm(int paramInt)
  {
    if (this.faG == null) {
      this.faG = ((TextView)findViewById(g.e.game_msg_empty_tv));
    }
    this.faG.setVisibility(paramInt);
  }
  
  public final int aZY()
  {
    return 13;
  }
  
  public final int aZZ()
  {
    return 1300;
  }
  
  public final int baa()
  {
    return this.drX;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_message;
  }
  
  protected final void initView()
  {
    setMMTitle(g.i.game_message);
    setBackBtn(new GameMessageUI.1(this));
    addTextOptionMenu(0, getString(g.i.app_clear), new GameMessageUI.2(this));
    this.drX = getIntent().getIntExtra("game_report_from_scene", 0);
    this.ldV = ((ListView)findViewById(g.e.game_msg_lv));
    this.ldV.setOnItemClickListener(this);
    if (this.djF > 20)
    {
      if (!com.tencent.mm.plugin.game.model.f.dt(this)) {
        break label250;
      }
      this.ldX = View.inflate(this, g.f.game_msg_tips, null);
      this.ldX.setOnClickListener(new GameMessageUI.5(this));
      this.ldV.addHeaderView(this.ldX);
      this.ldX.setVisibility(0);
      com.tencent.mm.plugin.game.model.f.du(this);
    }
    for (;;)
    {
      o localo = new o();
      localo.kPQ = true;
      this.ldW = new n(this, localo, this.drX);
      this.ldW.mR(true);
      sm(8);
      this.ldW.uMi = new GameMessageUI.3(this);
      this.ldV.setOnScrollListener(this.kXQ);
      this.ldV.setAdapter(this.ldW);
      com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1300, 0, 1, 0, null, this.drX, 0, null, null, null);
      return;
      label250:
      if (this.ldX != null) {
        this.ldX.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(573, this);
    this.djF = getIntent().getIntExtra("game_unread_msg_count", 0);
    this.leb = getIntent().getStringExtra("game_manage_url");
    initView();
    ((com.tencent.mm.plugin.game.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
    r.aZs();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.ldW != null) {
      this.ldW.bcS();
    }
    com.tencent.mm.kernel.g.Dk().b(573, this);
    com.tencent.mm.plugin.game.model.s locals = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
    String str = "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")";
    y.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[] { Boolean.valueOf(locals.gk("GameRawMessage", str)), str });
    ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().aZu();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (o)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {
      y.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[] { Integer.valueOf(paramInt) });
    }
    do
    {
      do
      {
        do
        {
          return;
          paramAdapterView.aZm();
          if (paramAdapterView.field_msgType != 100) {
            break;
          }
        } while (bk.bl(paramAdapterView.kPC));
        paramView = (o.d)paramAdapterView.kPi.get(paramAdapterView.kPC);
      } while (paramView == null);
      paramInt = com.tencent.mm.plugin.game.model.p.a(this, paramAdapterView, paramView, paramAdapterView.field_appId, 1301);
    } while (paramInt == 0);
    com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.drX, paramAdapterView.kPM, paramAdapterView.field_gameMsgId, paramAdapterView.kPN, null);
    return;
    if (paramAdapterView.kPO == 0)
    {
      switch (paramAdapterView.field_msgType)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        return;
      case 2: 
      case 5: 
        if (com.tencent.mm.pluginsdk.model.app.g.o(this, paramAdapterView.field_appId))
        {
          com.tencent.mm.plugin.game.model.f.ai(this, paramAdapterView.field_appId);
          paramInt = 3;
        }
        break;
      }
      for (;;)
      {
        com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.drX, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.kPN, null);
        return;
        if (bk.bl(paramAdapterView.kOV)) {
          break;
        }
        paramInt = com.tencent.mm.plugin.game.f.c.an(this, paramAdapterView.kOV);
        continue;
        if (bk.bl(paramAdapterView.kPx)) {
          break;
        }
        paramInt = com.tencent.mm.plugin.game.f.c.an(this, paramAdapterView.kPx);
        continue;
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
        paramView.putInt("game_report_from_scene", 1301);
        paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView);
      }
    }
    switch (paramAdapterView.kPO)
    {
    default: 
      y.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + paramAdapterView.kPO);
      return;
    case 1: 
      if (bk.bl(paramAdapterView.field_appId))
      {
        y.e("MicroMsg.GameMessageUI", "appid is null");
        return;
      }
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
      paramView.putInt("game_report_from_scene", 1301);
      paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView);
      com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.drX, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.kPN, null);
      return;
    case 2: 
      if (com.tencent.mm.pluginsdk.model.app.g.o(this, paramAdapterView.field_appId)) {
        com.tencent.mm.plugin.game.model.f.ai(this, paramAdapterView.field_appId);
      }
      for (paramInt = 3;; paramInt = com.tencent.mm.plugin.game.f.c.b(this, paramAdapterView.field_appId, null, paramView))
      {
        com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.drX, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.kPN, null);
        return;
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", paramAdapterView.field_appId);
        paramView.putInt("game_report_from_scene", 1301);
      }
    }
    if (!bk.bl(paramAdapterView.kPP))
    {
      paramInt = com.tencent.mm.plugin.game.f.c.an(this, paramAdapterView.kPP);
      com.tencent.mm.plugin.game.e.b.a(this.mController.uMN, 13, 1301, 4, paramInt, 0, paramAdapterView.field_appId, this.drX, paramAdapterView.field_msgType, paramAdapterView.field_gameMsgId, paramAdapterView.kPN, null);
      return;
    }
    y.e("MicroMsg.GameMessageUI", "jumpurl is null");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.ldW.notifyDataSetChanged();
    if ((this.lea) && (this.ldX != null)) {
      this.ldV.removeHeaderView(this.ldX);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramm.getType()) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 573)
      {
        sm(8);
        this.ldW.a(null, null);
      }
    }
    do
    {
      return;
      if (this.ldW.getCount() > 0)
      {
        y.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        return;
      }
    } while (a.eUS.a(this, paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(g.i.game_get_msg_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI
 * JD-Core Version:    0.7.0.1
 */