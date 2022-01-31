package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements f
{
  private String czF;
  private boolean gsE = false;
  private ImageView gtl;
  private TextView gtm;
  private TextView gtn;
  private Button gto;
  private Button gtp;
  private l.a gtq;
  private i gtr;
  private String gts = null;
  private String gtt = null;
  private int gtu;
  private int gtv = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void apB()
  {
    AppMethodBeat.i(13444);
    hideVKB();
    if (this.gtu == 2)
    {
      cancel();
      finish();
      AppMethodBeat.o(13444);
      return;
    }
    Oi(1);
    AppMethodBeat.o(13444);
  }
  
  private void du(boolean paramBoolean)
  {
    AppMethodBeat.i(13445);
    Intent localIntent = new Intent(this, BindMContactUI.class);
    if (paramBoolean) {
      localIntent.putExtra("bind_scene", 3);
    }
    for (;;)
    {
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = b.k(this, (String)localObject, getString(2131298871));
        if (localObject != null)
        {
          localIntent.putExtra("country_name", ((b.a)localObject).fHT);
          localIntent.putExtra("couttry_code", ((b.a)localObject).fHS);
        }
      }
      J(this, localIntent);
      AppMethodBeat.o(13445);
      return;
      localIntent.putExtra("bind_scene", 0);
    }
  }
  
  public int getLayoutId()
  {
    return 2130968848;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13442);
    this.gtu = getIntent().getIntExtra("bind_scene", 0);
    this.gsE = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.gtv = getIntent().getIntExtra("key_upload_scene", 0);
    this.gtq = l.aqq();
    ab.d("MicroMsg.BindMContactIntroUI", "state " + this.gtq);
    this.czF = ((String)com.tencent.mm.kernel.g.RL().Ru().get(6, null));
    if ((this.czF == null) || (this.czF.equals(""))) {
      this.czF = ((String)com.tencent.mm.kernel.g.RL().Ru().get(4097, null));
    }
    this.gtl = ((ImageView)findViewById(2131821802));
    this.gtm = ((TextView)findViewById(2131821803));
    this.gtn = ((TextView)findViewById(2131821804));
    this.gto = ((Button)findViewById(2131821805));
    this.gtp = ((Button)findViewById(2131821806));
    this.gto.setOnClickListener(new BindMContactIntroUI.1(this));
    this.gtp.setOnClickListener(new BindMContactIntroUI.12(this));
    if (getIntent().getBooleanExtra("skip", false))
    {
      addTextOptionMenu(0, getString(2131296980), new BindMContactIntroUI.21(this));
      if ((this.gtq == l.a.gxC) || (this.gtq == l.a.gxB))
      {
        String str = com.tencent.mm.m.g.Nq().getValue("ShowUnbindPhone");
        int i = 2;
        if (!bo.isNullOrNil(str)) {
          i = bo.apV(str);
        }
        if (i != 0) {
          addIconOptionMenu(1, 2130839668, new BindMContactIntroUI.23(this, i));
        }
      }
      switch (BindMContactIntroUI.20.gty[this.gtq.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13442);
      return;
      setBackBtn(new BindMContactIntroUI.22(this));
      break;
      showOptionMenu(1, false);
      this.gtl.setImageResource(2131231662);
      this.gtn.setVisibility(0);
      this.gtp.setVisibility(8);
      this.gtm.setText(2131297580);
      this.gtn.setText(2131297579);
      this.gto.setText(2131297554);
      AppMethodBeat.o(13442);
      return;
      showOptionMenu(1, false);
      this.gtl.setImageResource(2131231662);
      this.gtn.setVisibility(0);
      this.gtp.setVisibility(0);
      this.gtm.setText(String.format(getString(2131297618), new Object[] { this.czF }));
      this.gtn.setText(2131297608);
      this.gto.setText(2131297612);
      this.gtp.setText(2131297565);
      AppMethodBeat.o(13442);
      return;
      showOptionMenu(1, true);
      this.gtl.setImageResource(2131231661);
      this.gtn.setVisibility(0);
      this.gtp.setVisibility(0);
      this.gtm.setText(String.format(getString(2131297618), new Object[] { this.czF }));
      this.gtn.setText(2131297561);
      this.gto.setText(2131297609);
      this.gtp.setText(2131297563);
      AppMethodBeat.o(13442);
      return;
      showOptionMenu(1, true);
      this.gtl.setImageResource(2131231661);
      this.gtn.setVisibility(0);
      this.gtp.setVisibility(0);
      this.gtm.setText(String.format(getString(2131297618), new Object[] { this.czF }));
      this.gtn.setText(2131297561);
      this.gto.setText(2131297578);
      this.gtp.setText(2131297563);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13447);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13447);
      return;
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.czF);
        paramIntent = new y(y.gxY);
        com.tencent.mm.kernel.g.Rc().a(paramIntent, 0);
        getString(2131297087);
        this.tipDialog = h.b(this, getString(2131296987), true, new BindMContactIntroUI.19(this));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13438);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Rc().a(132, this);
    com.tencent.mm.kernel.g.Rc().a(255, this);
    com.tencent.mm.kernel.g.Rc().a(254, this);
    setMMTitle(2131297597);
    AppMethodBeat.o(13438);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13439);
    com.tencent.mm.kernel.g.Rc().b(132, this);
    com.tencent.mm.kernel.g.Rc().b(255, this);
    com.tencent.mm.kernel.g.Rc().b(254, this);
    if (this.gtr != null) {
      this.gtr.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(13439);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13443);
    if (paramInt == 4)
    {
      apB();
      AppMethodBeat.o(13443);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13443);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13440);
    super.onResume();
    initView();
    AppMethodBeat.o(13440);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13446);
    ab.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramm.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramm.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (((x)paramm).Ac() == 3)
      {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
        if (!bo.isNullOrNil(this.gtt))
        {
          h.a(this, this.gtt, "", getString(2131296977), new BindMContactIntroUI.26(this));
          AppMethodBeat.o(13446);
          return;
        }
        J(this, new Intent(this, BindMContactStatusUI.class));
      }
      AppMethodBeat.o(13446);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(13446);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131297570, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131297567, 0).show();
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
      }
    }
    if (paramm.getType() == 254)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gtt = ((y)paramm).aqC().wLC;
        this.gts = ((y)paramm).aqB();
        if (!bo.isNullOrNil(this.gtt))
        {
          paramString = new x(this.czF, 3, "", 0, "");
          com.tencent.mm.kernel.g.Rc().a(paramString, 0);
          paramm = getContext();
          getString(2131297087);
          this.tipDialog = h.b(paramm, getString(2131297607), true, new BindMContactIntroUI.27(this, paramString));
          AppMethodBeat.o(13446);
          return;
        }
        paramString = new t(2);
        com.tencent.mm.kernel.g.Rc().a(paramString, 0);
        AppMethodBeat.o(13446);
        return;
      }
      if (paramInt2 == -3)
      {
        ab.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13423);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131303496));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            d.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(13423);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    else if (paramm.getType() == 255)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 != 0) {
        break label998;
      }
      paramString = new x(this.czF, 3, "", 0, "");
      com.tencent.mm.kernel.g.Rc().a(paramString, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.tipDialog = h.b(localAppCompatActivity, getString(2131297607), true, new BindMContactIntroUI.10(this, paramString));
    }
    for (;;)
    {
      if (paramm.getType() == 132)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (((x)paramm).Ac() == 3)
        {
          if (paramInt2 == -82)
          {
            h.a(this, 2131303172, 2131297087, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(13446);
            return;
            if (paramInt2 == -81)
            {
              h.a(this, 2131303171, 2131297087, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -82)
            {
              h.a(this, 2131303172, 2131297087, new BindMContactIntroUI.5(this));
              break;
            }
            if (paramInt2 == -83)
            {
              h.a(this, 2131303169, 2131297087, new BindMContactIntroUI.6(this));
              break;
            }
            if (paramInt2 == -84)
            {
              h.a(this, 2131303170, 2131297087, new BindMContactIntroUI.7(this));
              break;
            }
            if (paramInt2 == -85)
            {
              h.a(this, 2131303166, 2131297087, new BindMContactIntroUI.8(this));
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            h.a(this, 2131303174, 2131297087, new BindMContactIntroUI.9(this));
            break;
            label998:
            ab.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            h.a(getContext(), getString(2131303498), null, getString(2131303499), getString(2131303497), true, new BindMContactIntroUI.11(this), new BindMContactIntroUI.13(this));
            continue;
          }
          if (paramInt2 == -83)
          {
            h.a(this, 2131303169, 2131297087, new BindMContactIntroUI.15(this));
            AppMethodBeat.o(13446);
            return;
          }
          if (paramInt2 == -84)
          {
            h.a(this, 2131303170, 2131297087, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(13446);
            return;
          }
          if (paramInt2 == -85)
          {
            h.a(this, 2131303166, 2131297087, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(13446);
            return;
          }
          Toast.makeText(this, getString(2131297603, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        }
      }
    }
    AppMethodBeat.o(13446);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */