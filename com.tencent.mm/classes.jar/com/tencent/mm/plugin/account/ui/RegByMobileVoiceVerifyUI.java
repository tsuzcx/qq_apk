package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class RegByMobileVoiceVerifyUI
  extends MMActivity
  implements f
{
  private String czF;
  private TextView euY;
  private String gDD;
  private String gIR;
  private com.tencent.mm.modelfriend.a gIT;
  private x gIU;
  private int gIV = 0;
  private String guI;
  
  public int getLayoutId()
  {
    return 2130968852;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125470);
    setMMTitle(2131297631);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125461);
        RegByMobileVoiceVerifyUI.this.hideVKB();
        RegByMobileVoiceVerifyUI.this.finish();
        AppMethodBeat.o(125461);
        return true;
      }
    });
    this.euY = ((TextView)findViewById(2131821815));
    Button localButton = (Button)findViewById(2131821816);
    this.gDD = RegByMobileVoiceVerifySelectUI.xA(this.czF);
    this.euY.setText(this.gDD);
    this.gIR = b.tL(this.czF);
    findViewById(2131821814).setOnClickListener(new RegByMobileVoiceVerifyUI.2(this));
    localButton.setOnClickListener(new RegByMobileVoiceVerifyUI.3(this));
    AppMethodBeat.o(125470);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125471);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10000)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(125471);
        return;
      }
      this.gDD = paramIntent.getStringExtra("voice_verify_language");
      this.gIR = paramIntent.getStringExtra("voice_verify_code");
      this.euY.setText(this.gDD);
    }
    AppMethodBeat.o(125471);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125466);
    super.onCreate(paramBundle);
    this.czF = getIntent().getExtras().getString("bindmcontact_mobile");
    this.gIV = getIntent().getExtras().getInt("voice_verify_type");
    if ((this.gIV == 0) || (this.gIV == 2) || (this.gIV == 3)) {
      g.Rc().a(145, this);
    }
    for (;;)
    {
      this.guI = com.tencent.mm.plugin.b.a.awy();
      initView();
      AppMethodBeat.o(125466);
      return;
      if ((this.gIV == 4) || (this.gIV == 1)) {
        g.Rc().a(132, this);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125468);
    super.onDestroy();
    g.Rc().b(132, this);
    g.Rc().b(145, this);
    if ((this.gIV == 0) || (this.gIV == 2) || (this.gIV == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_500,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_500") + ",2");
    }
    AppMethodBeat.o(125468);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125469);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.b.a.xD(this.guI);
      hideVKB();
      finish();
      AppMethodBeat.o(125469);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125469);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125467);
    super.onResume();
    if ((this.gIV == 0) || (this.gIV == 2) || (this.gIV == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_500,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_500") + ",1");
      com.tencent.mm.plugin.b.a.xC("R200_500");
    }
    AppMethodBeat.o(125467);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(125472);
    ab.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(125472);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI
 * JD-Core Version:    0.7.0.1
 */