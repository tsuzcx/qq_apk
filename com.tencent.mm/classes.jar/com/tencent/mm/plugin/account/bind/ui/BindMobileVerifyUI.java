package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.au.b;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements f
{
  private String czF;
  private int fromScene;
  private EditText gtO;
  private Button gtQ;
  private BindWordingContent gub;
  private int guc;
  private boolean gud;
  private boolean gue;
  private TextView gut;
  private TextView guu;
  private Integer guv;
  private Timer mTimer;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public BindMobileVerifyUI()
  {
    AppMethodBeat.i(13535);
    this.tipDialog = null;
    this.guv = Integer.valueOf(15);
    AppMethodBeat.o(13535);
  }
  
  private void apE()
  {
    AppMethodBeat.i(13541);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    AppMethodBeat.o(13541);
  }
  
  public int getLayoutId()
  {
    return 2130968850;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13540);
    this.czF = ((String)g.RL().Ru().get(4097, null));
    this.gtO = ((EditText)findViewById(2131821810));
    this.gut = ((TextView)findViewById(2131821809));
    this.guu = ((TextView)findViewById(2131821813));
    Object localObject = (Button)findViewById(2131821811);
    if ((this.czF == null) || (this.czF.equals(""))) {
      this.czF = ((String)g.RL().Ru().get(6, null));
    }
    if ((this.czF != null) && (this.czF.length() > 0))
    {
      this.gut.setVisibility(0);
      this.gut.setText(this.czF);
    }
    BindMobileVerifyUI.1 local1 = new BindMobileVerifyUI.1(this);
    this.gtO.setFilters(new InputFilter[] { local1 });
    this.gtQ = ((Button)findViewById(2131821774));
    ((Button)localObject).setVisibility(8);
    this.guu.setText(getResources().getQuantityString(2131361811, this.guv.intValue(), new Object[] { this.guv }));
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      localObject = new BindMobileVerifyUI.5(this);
      if (this.mTimer != null) {
        this.mTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      }
    }
    addTextOptionMenu(0, getString(2131297013), new BindMobileVerifyUI.2(this));
    setBackBtn(new BindMobileVerifyUI.3(this));
    localObject = this.gtQ;
    if (b.tK(this.czF)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.gtQ.setOnClickListener(new BindMobileVerifyUI.4(this));
      AppMethodBeat.o(13540);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13536);
    super.onCreate(paramBundle);
    g.Rc().a(132, this);
    setMMTitle(2131297598);
    this.gub = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.guc = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.gud = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.gue = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    initView();
    AppMethodBeat.o(13536);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13537);
    g.Rc().b(132, this);
    super.onDestroy();
    AppMethodBeat.o(13537);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13542);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Oi(1);
      AppMethodBeat.o(13542);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13542);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    boolean bool2 = true;
    AppMethodBeat.i(13543);
    ab.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((x)paramm).Ac() != 2)
    {
      AppMethodBeat.o(13543);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((x)paramm).Ac() == 2) {}
      switch (this.fromScene)
      {
      default: 
        if ((this.fromScene == 0) || (this.fromScene == 3)) {
          ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
        }
        paramString = new Intent(this, BindMobileStatusUI.class);
        paramString.putExtra("kstyle_bind_wording", this.gub);
        paramString.putExtra("kstyle_bind_recommend_show", this.guc);
        paramString.putExtra("Kfind_friend_by_mobile_flag", this.gud);
        paramString.putExtra("Krecom_friends_by_mobile_flag", this.gue);
        paramString.putExtra("bind_scene", this.fromScene);
        J(this, paramString);
        AppMethodBeat.o(13543);
        return;
      case 1: 
        if (!r.Zv())
        {
          paramString = new ug();
          paramString.cKJ.cKK = true;
          paramString.cKJ.cKL = true;
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
        }
        Oi(1);
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.gmO.e(this, paramString);
        AppMethodBeat.o(13543);
        return;
      }
      boolean bool1;
      if (!this.gud)
      {
        bool1 = true;
        if (this.gue) {
          break label370;
        }
      }
      for (;;)
      {
        BindMobileStatusUI.c(this, bool1, bool2);
        exit(-1);
        AppMethodBeat.o(13543);
        return;
        bool1 = false;
        break;
        label370:
        bool2 = false;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(13543);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -34: 
        Toast.makeText(this, 2131297570, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131297567, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131297569, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131297568, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131297572, 0).show();
        i = 1;
        break;
      case -32: 
        h.a(this, 2131297616, 2131297621, null);
        i = 1;
        break;
      case -33: 
        h.a(this, 2131297615, 2131297621, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(13543);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(13538);
    apE();
    super.onStop();
    AppMethodBeat.o(13538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */