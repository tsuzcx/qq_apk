package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import junit.framework.Assert;

public class MassSendHistoryUI
  extends MMActivity
  implements h.a, h.b, SensorController.a
{
  private static SensorController mub;
  private com.tencent.mm.audio.a.a caP;
  private n.d jWw;
  private boolean mtV;
  private View nTT;
  private ListView oBW;
  private c oBX;
  private Button oBY;
  private Button oBZ;
  private MMPullDownView oCa;
  private boolean oCb;
  private LinearLayout oCc;
  
  public MassSendHistoryUI()
  {
    AppMethodBeat.i(22806);
    this.mtV = true;
    this.oCb = false;
    this.jWw = new MassSendHistoryUI.4(this);
    AppMethodBeat.o(22806);
  }
  
  private boolean SI(String paramString)
  {
    AppMethodBeat.i(22816);
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      mub.a(this);
      paramString = h.bPc().SC(paramString);
      aw.aaz();
      if ((com.tencent.mm.model.c.isSDCardAvailable()) || (bo.isNullOrNil(paramString.bOU()))) {
        break;
      }
      t.ii(this);
      AppMethodBeat.o(22816);
      return false;
    }
    if (this.caP == null) {
      this.caP = new com.tencent.mm.audio.a.a(this);
    }
    this.caP.stop(false);
    if (this.caP.n(paramString.bOU(), this.mtV))
    {
      aw.aaA().d(this.mtV, false, false);
      this.caP.civ = this;
      this.caP.ciu = this;
      AppMethodBeat.o(22816);
      return true;
    }
    Toast.makeText(this, getString(2131298283), 0).show();
    AppMethodBeat.o(22816);
    return false;
  }
  
  private void stopPlay()
  {
    AppMethodBeat.i(22817);
    mub.dtJ();
    this.caP.stop(false);
    this.oBX.SG("");
    releaseWakeLock();
    AppMethodBeat.o(22817);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(22818);
    stopPlay();
    AppMethodBeat.o(22818);
  }
  
  public int getLayoutId()
  {
    return 2130970120;
  }
  
  public final void hv(boolean paramBoolean)
  {
    AppMethodBeat.i(22815);
    if (this.caP == null)
    {
      AppMethodBeat.o(22815);
      return;
    }
    if (!this.caP.isPlaying())
    {
      this.caP.bx(true);
      aw.aaA().d(true, false, false);
      this.mtV = true;
      AppMethodBeat.o(22815);
      return;
    }
    this.caP.bx(paramBoolean);
    aw.aaA().d(paramBoolean, false, false);
    this.mtV = paramBoolean;
    if (!paramBoolean)
    {
      if (SI(this.oBX.oBL))
      {
        this.oBX.SG(this.oBX.oBL);
        AppMethodBeat.o(22815);
        return;
      }
      this.oBX.SG("");
    }
    AppMethodBeat.o(22815);
  }
  
  public void initView()
  {
    AppMethodBeat.i(22811);
    this.oCb = getIntent().getBooleanExtra("finish_direct", false);
    ab.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.oCb);
    this.oCc = ((LinearLayout)findViewById(2131826092));
    this.oBW = ((ListView)findViewById(2131826089));
    this.oBW.setTranscriptMode(0);
    this.oCa = ((MMPullDownView)findViewById(2131826088));
    this.oCa.setOnTopLoadDataListener(new MassSendHistoryUI.5(this));
    this.oCa.setTopViewVisible(true);
    this.oCa.setAtBottomCallBack(new MassSendHistoryUI.6(this));
    this.oCa.setAtTopCallBack(new MassSendHistoryUI.7(this));
    this.oCa.setIsBottomShowAll(true);
    this.oBX = new c(this);
    this.oBX.a(new MassSendHistoryUI.8(this));
    this.nTT = findViewById(2131826090);
    this.oBW.setAdapter(this.oBX);
    this.oBW.setOnItemClickListener(new MassSendHistoryUI.9(this));
    this.oBW.setOnTouchListener(new MassSendHistoryUI.10(this));
    this.oBY = ((Button)findViewById(2131826093));
    this.oBY.setOnClickListener(new MassSendHistoryUI.11(this));
    this.oBZ = ((Button)findViewById(2131826091));
    this.oBZ.setOnClickListener(new MassSendHistoryUI.12(this));
    setBackBtn(new MassSendHistoryUI.2(this));
    addIconOptionMenu(0, 2131297072, 2131230758, new MassSendHistoryUI.3(this));
    new l(this).a(this.oBW, this, this.jWw);
    AppMethodBeat.o(22811);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22807);
    super.onCreate(paramBundle);
    setMMTitle(2131301529);
    if (mub == null) {
      mub = new SensorController(getApplicationContext());
    }
    initView();
    this.caP = new com.tencent.mm.audio.a.a(this);
    this.caP.civ = this;
    this.caP.ciu = this;
    this.oBX.oBM = new MassSendHistoryUI.1(this);
    if (this.mController != null) {
      this.mController.aF(3, false);
    }
    AppMethodBeat.o(22807);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(22813);
    ab.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.masssend.a.a)this.oBX.getItem(paramView.position)).bOW().split(";");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramContextMenuInfo.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContextMenuInfo[i];
      aw.aaz();
      localObject = com.tencent.mm.model.c.YA().arw((String)localObject);
      if (localObject != null) {
        localStringBuilder.append(((ad)localObject).Of() + ";");
      }
      i += 1;
    }
    paramContextMenu.setHeaderTitle(localStringBuilder.toString());
    paramContextMenu.add(paramView.position, 1, 0, getString(2131298232));
    AppMethodBeat.o(22813);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22810);
    this.oBX.bKb();
    super.onDestroy();
    AppMethodBeat.o(22810);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(22819);
    stopPlay();
    AppMethodBeat.o(22819);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22812);
    if (paramInt == 4)
    {
      if (this.oCb) {
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(22812);
        return true;
        paramKeyEvent = new Intent();
        paramKeyEvent.addFlags(67108864);
        com.tencent.mm.plugin.masssend.a.gmO.p(paramKeyEvent, this);
        finish();
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22812);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22809);
    super.onPause();
    aw.aaA().KS();
    h.bPc().remove(this.oBX);
    mub.dtJ();
    AppMethodBeat.o(22809);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22808);
    super.onResume();
    h.bPc().add(this.oBX);
    this.oBX.a(null, null);
    this.oBW.setSelection(this.oBX.getCount() - 1);
    AppMethodBeat.o(22808);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void releaseWakeLock()
  {
    AppMethodBeat.i(22814);
    this.oBW.setKeepScreenOn(false);
    AppMethodBeat.o(22814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI
 * JD-Core Version:    0.7.0.1
 */