package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements h.a, h.b, SensorController.a
{
  private static SensorController iah;
  private com.tencent.mm.f.a.a byN;
  private boolean iak = true;
  private n.d ifj = new MassSendHistoryUI.4(this);
  private View lwG;
  private boolean mbA = false;
  private LinearLayout mbB;
  private ListView mbv;
  private c mbw;
  private Button mbx;
  private Button mby;
  private MMPullDownView mbz;
  
  private boolean GX(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      iah.a(this);
      paramString = h.bhd().GS(paramString);
      au.Hx();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bk.bl(paramString.bgW()))) {
        break;
      }
      com.tencent.mm.ui.base.s.gM(this);
      return false;
    }
    if (this.byN == null) {
      this.byN = new com.tencent.mm.f.a.a(this);
    }
    this.byN.stop(false);
    if (this.byN.k(paramString.bgW(), this.iak))
    {
      au.Hy().f(this.iak, false, false);
      this.byN.bBG = this;
      this.byN.bBF = this;
      return true;
    }
    Toast.makeText(this, getString(R.l.chatting_play_err), 0).show();
    return false;
  }
  
  private void stopPlay()
  {
    iah.crJ();
    this.byN.stop(false);
    this.mbw.GV("");
    releaseWakeLock();
  }
  
  public final void eq(boolean paramBoolean)
  {
    if (this.byN == null) {}
    do
    {
      return;
      if (!this.byN.isPlaying())
      {
        this.byN.aV(true);
        au.Hy().f(true, false, false);
        this.iak = true;
        return;
      }
      this.byN.aV(paramBoolean);
      au.Hy().f(paramBoolean, false, false);
      this.iak = paramBoolean;
    } while (paramBoolean);
    if (GX(this.mbw.mbj))
    {
      this.mbw.GV(this.mbw.mbj);
      return;
    }
    this.mbw.GV("");
  }
  
  protected final int getLayoutId()
  {
    return R.i.mass_send_history;
  }
  
  protected final void initView()
  {
    this.mbA = getIntent().getBooleanExtra("finish_direct", false);
    y.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.mbA);
    this.mbB = ((LinearLayout)findViewById(R.h.mass_send_next_ll));
    this.mbv = ((ListView)findViewById(R.h.mass_send_history_list));
    this.mbv.setTranscriptMode(0);
    this.mbz = ((MMPullDownView)findViewById(R.h.mass_send_history_pull_down_view));
    this.mbz.setOnTopLoadDataListener(new MassSendHistoryUI.5(this));
    this.mbz.setTopViewVisible(true);
    this.mbz.setAtBottomCallBack(new MassSendHistoryUI.6(this));
    this.mbz.setAtTopCallBack(new MassSendHistoryUI.7(this));
    this.mbz.setIsBottomShowAll(true);
    this.mbw = new c(this);
    this.mbw.uMi = new MassSendHistoryUI.8(this);
    this.lwG = findViewById(R.h.mass_send_history_empty_view);
    this.mbv.setAdapter(this.mbw);
    this.mbv.setOnItemClickListener(new MassSendHistoryUI.9(this));
    this.mbv.setOnTouchListener(new MassSendHistoryUI.10(this));
    this.mbx = ((Button)findViewById(R.h.mass_send_next));
    this.mbx.setOnClickListener(new MassSendHistoryUI.11(this));
    this.mby = ((Button)findViewById(R.h.mass_send_next_two));
    this.mby.setOnClickListener(new MassSendHistoryUI.12(this));
    setBackBtn(new MassSendHistoryUI.2(this));
    addIconOptionMenu(0, R.l.app_set, R.k.actionbar_setting_icon, new MassSendHistoryUI.3(this));
    new j(this).a(this.mbv, this, this.ifj);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.mass_send_helper);
    if (iah == null) {
      iah = new SensorController(getApplicationContext());
    }
    initView();
    this.byN = new com.tencent.mm.f.a.a(this);
    this.byN.bBG = this;
    this.byN.bBF = this;
    this.mbw.mbk = new MassSendHistoryUI.1(this);
    if (this.mController != null) {
      this.mController.ap(3, false);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    y.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.mbw.getItem(paramView.position)).bgY().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      au.Hx();
      localObject = com.tencent.mm.model.c.Fw().abl((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((ad)localObject).Bq() + ";");
      }
      i += 1;
    }
    paramContextMenu.setHeaderTitle(localStringBuilder.toString());
    paramContextMenu.add(paramView.position, 1, 0, getString(R.l.chatting_long_click_menu_delete_msg));
  }
  
  protected void onDestroy()
  {
    this.mbw.bcS();
    super.onDestroy();
  }
  
  public final void onError()
  {
    stopPlay();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.mbA) {
        finish();
      }
      for (;;)
      {
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.eUR.q(paramKeyEvent, this);
        finish();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Hy().yx();
    h.bhd().d(this.mbw);
    iah.crJ();
  }
  
  protected void onResume()
  {
    super.onResume();
    h.bhd().c(this.mbw);
    this.mbw.a(null, null);
    this.mbv.setSelection(this.mbw.getCount() - 1);
  }
  
  protected final void releaseWakeLock()
  {
    this.mbv.setKeepScreenOn(false);
  }
  
  public final void ug()
  {
    stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */