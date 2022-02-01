package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.nw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements i, a.a
{
  private String countryCode;
  private String dHx;
  private String dSf;
  private String hJl;
  private String knu;
  private int kon;
  private String kpE;
  private String kpF;
  private String kpG;
  private String kpH;
  private boolean kpI;
  private int kpJ;
  private ProgressDialog kpK;
  private SecurityImage kpL;
  private nw kpM;
  private String seq;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(196908);
    this.kpJ = 2;
    this.kpM = new nw();
    AppMethodBeat.o(196908);
  }
  
  private void bpB()
  {
    AppMethodBeat.i(196912);
    ((com.tencent.mm.plugin.mobile.verify.a.a)g.ah(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.kpF, this.hJl, this);
    this.kpK = h.a(this, getString(2131756639), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(196902);
        ((com.tencent.mm.plugin.mobile.verify.a.a)g.ah(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(196902);
      }
    });
    AppMethodBeat.o(196912);
  }
  
  public final void F(final Bundle paramBundle)
  {
    AppMethodBeat.i(196913);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196904);
        String str = paramBundle.getString("session", "");
        if ((!Util.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!Util.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(196904);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).eki = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).eRI = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bfK();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(2131764386), "", RegByMobileAutoVerifyUI.this.getString(2131755873), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(196903);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(196903);
            }
          });
        }
        AppMethodBeat.o(196904);
      }
    });
    AppMethodBeat.o(196913);
  }
  
  public int getLayoutId()
  {
    return 2131496082;
  }
  
  public void initView()
  {
    AppMethodBeat.i(196910);
    final Button localButton = (Button)findViewById(2131305423);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196899);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2) {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196899);
          return;
          RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        }
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(2131306787);
    localCheckBoxLicenseView.setTermTip(getString(2131764391));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196900);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).eki = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bfK();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(196900);
      }
    });
    ((TextView)findViewById(2131306788)).setText(getString(2131764388, new Object[] { this.kpE }));
    ((TextView)findViewById(2131306795)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196901);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).eki = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bfK();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196901);
      }
    });
    AppMethodBeat.o(196910);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(196911);
    this.kpM.eki = 4;
    this.kpM.bfK();
    super.onBackPressed();
    AppMethodBeat.o(196911);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196909);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    this.dSf = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.kpE = (this.countryCode + this.dSf);
    this.seq = getIntent().getStringExtra("Key_Seq");
    this.hJl = getIntent().getStringExtra("Key_Url");
    this.knu = getIntent().getStringExtra("Key_reg_sessionId");
    this.kpF = (System.currentTimeMillis() + "_" + this.seq);
    this.kpG = getIntent().getStringExtra("kintent_nickname");
    this.kpH = getIntent().getStringExtra("kintent_password");
    this.kon = getIntent().getIntExtra("key_reg_style", 1);
    this.kpI = getIntent().getBooleanExtra("kintent_hasavatar", false);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.dSf, this.seq, this.hJl, this.kpG, Boolean.valueOf(this.kpI) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196890);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(196890);
        return true;
      }
    });
    this.kpM.exh = System.currentTimeMillis();
    paramBundle = this.kpM;
    paramBundle.fiG = paramBundle.x("DeviceID", com.tencent.mm.compatible.deviceinfo.q.aoJ(), true);
    paramBundle = this.kpM;
    paramBundle.fiF = paramBundle.x("RegisterMobile", this.kpE, true);
    g.azz().a(126, this);
    g.azz().a(145, this);
    AppMethodBeat.o(196909);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(196914);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)g.ah(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.kpF);
    g.azz().b(126, this);
    g.azz().b(145, this);
    g.azz().b(701, this);
    g.azz().b(252, this);
    AppMethodBeat.o(196914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(196915);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.kpK != null)
    {
      this.kpK.dismiss();
      this.kpK = null;
    }
    int i;
    if (paramq.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      Log.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.kpJ = ((com.tencent.mm.modelfriend.a)paramq).bbJ();
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.kpJ) });
          if (this.kpJ == 2)
          {
            paramq = ((com.tencent.mm.modelfriend.a)paramq).bbM();
            this.seq = paramq.seq;
            this.hJl = paramq.url;
            this.kpF = (System.currentTimeMillis() + "_" + this.seq);
            bpB();
          }
        }
      }
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        for (;;)
        {
          paramq = com.tencent.mm.h.a.Dk(paramString);
          if ((paramq == null) || (!paramq.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(196915);
          return;
          if (this.kpJ == 1)
          {
            this.kpM.eki = 3;
            this.kpM.eRI = 2;
            this.kpM.bfK();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramq).bbL();
            paramq = ((com.tencent.mm.modelfriend.a)paramq).bbK();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.knu);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.kpE);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramq);
            ((Intent)localObject2).putExtra("kintent_nickname", this.kpG);
            ((Intent)localObject2).putExtra("kintent_password", this.kpH);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.kpI);
            paramq = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramq.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramq.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.kpM.eki = 3;
            this.kpM.eRI = 2;
            this.kpM.bfK();
            i = ((com.tencent.mm.modelfriend.a)paramq).bbO();
            int j = ((com.tencent.mm.modelfriend.a)paramq).bbP();
            paramq = new Intent();
            paramq.putExtra("bindmcontact_mobile", this.kpE);
            paramq.putExtra("bindmcontact_shortmobile", this.dSf);
            paramq.putExtra("couttry_code", this.countryCode);
            paramq.putExtra("mobileverify_countdownsec", i);
            paramq.putExtra("mobileverify_countdownstyle", j);
            paramq.putExtra("kintent_hasavatar", this.kpI);
            paramq.putExtra("kintent_nickname", this.kpG);
            paramq.putExtra("kintent_password", this.kpH);
            paramq.putExtra("key_reg_style", this.kon);
            paramq.putExtra("regsession_id", this.knu);
            paramq.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramq);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              h.n(this, 2131764394, 2131764395);
              AppMethodBeat.o(196915);
              return;
            }
            if (paramInt2 == -34)
            {
              h.c(this, getString(2131756598), "", true);
              AppMethodBeat.o(196915);
              return;
              if (i == 15)
              {
                paramq = (com.tencent.mm.modelfriend.a)paramq;
                this.dHx = paramq.bbG();
                if (paramInt2 == 0)
                {
                  this.kpM.eki = 3;
                  this.kpM.eRI = 1;
                  this.kpM.bfK();
                  if (this.kon == 1)
                  {
                    g.azz().a(126, this);
                    paramq = new v("", this.kpH, this.kpG, 0, "", this.kpE, "", "", this.dHx, 1, "", "", "", true, this.kpI);
                    paramq.PB(this.knu);
                    paramq.tL(this.kpJ);
                    g.azz().a(paramq, 0);
                    getString(2131755998);
                    this.kpK = h.a(this, getString(2131764451), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(196906);
                        g.azz().a(paramq);
                        g.azz().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(196906);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dHx);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.kpE);
                    ((Intent)localObject1).putExtra("regsession_id", this.knu);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramq.bbN());
                    ((Intent)localObject1).putExtra("key_reg_style", this.kon);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramq = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, paramq.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramq.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.kpM.eki = 3;
                  this.kpM.eRI = 2;
                  this.kpM.bfK();
                  localObject1 = com.tencent.mm.h.a.Dk(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(196907);
                        g.azz().a(701, RegByMobileAutoVerifyUI.this);
                        g.azz().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramq.getUsername(), paramq.bbF());
                        AppMethodBeat.o(196907);
                      }
                    }, null);
                  } else {
                    h.a(this, getString(2131756580), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(196891);
                        g.azz().a(701, RegByMobileAutoVerifyUI.this);
                        g.azz().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramq.getUsername(), paramq.bbF());
                        AppMethodBeat.o(196891);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.kpM.eki = 3;
                  this.kpM.eRI = 2;
                  this.kpM.bfK();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.dHx);
                  ((Intent)localObject1).putExtra("moble", this.kpE);
                  ((Intent)localObject1).putExtra("regsession_id", this.knu);
                  ((Intent)localObject1).putExtra("next_controll", paramq.bbN());
                  ((Intent)localObject1).putExtra("username", paramq.getUsername());
                  ((Intent)localObject1).putExtra("password", paramq.bbF());
                  ((Intent)localObject1).putExtra("nickname", paramq.bbT());
                  ((Intent)localObject1).putExtra("avatar_url", paramq.bbS());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.kpJ);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.kpI);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.kpG);
                  ((Intent)localObject1).putExtra("kintent_password", this.kpH);
                  ((Intent)localObject1).putExtra("key_reg_style", this.kon);
                  paramq = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, paramq.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramq.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.kpM.eki = 3;
                    this.kpM.eRI = 2;
                    this.kpM.bfK();
                    h.a(this, getString(2131764386), "", getString(2131755873), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(196892);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(196892);
                      }
                    });
                    AppMethodBeat.o(196915);
                    return;
                  }
                  this.kpM.eki = 3;
                  this.kpM.eRI = 2;
                  this.kpM.bfK();
                  Toast.makeText(this, getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramq.getType() != 126);
      localObject1 = (v)paramq;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.kpL == null)
        {
          this.kpL = SecurityImage.a.a(this, 0, ((v)localObject1).bfm(), ((v)localObject1).bfl(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(196894);
              paramAnonymousDialogInterface = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.kpP.bfl(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.PB(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.tL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              g.azz().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(2131755998);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, h.a(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(196893);
                  g.azz().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(196893);
                }
              }));
              AppMethodBeat.o(196894);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(196895);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(196895);
            }
          }, new SecurityImage.b()
          {
            public final void bnH()
            {
              AppMethodBeat.i(196896);
              RegByMobileAutoVerifyUI.this.hideVKB();
              v localv = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.kpP.bfl(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localv.PB(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localv.tL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              g.azz().a(localv, 0);
              AppMethodBeat.o(196896);
            }
          });
          AppMethodBeat.o(196915);
          return;
        }
        this.kpL.b(0, ((v)paramq).bfm(), ((v)paramq).bfl(), "");
        AppMethodBeat.o(196915);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.kpE;
    com.tencent.mm.kernel.a.unhold();
    com.tencent.mm.kernel.a.es(true);
    if (this.kpI)
    {
      paramq = com.tencent.mm.loader.j.b.aKR() + "temp.avatar";
      localObject2 = com.tencent.mm.loader.j.b.aKR() + "temp.avatar.hd";
      s.nx(paramq, (String)localObject2);
      s.deleteFile(paramq);
      BitmapUtil.createThumbNail((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramq, true);
      new n(this, com.tencent.mm.loader.j.b.aKR() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(196897);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.kpP.bfv());
          bf.iDu.aO("login_user_name", paramString);
          s.deleteFile(com.tencent.mm.loader.j.b.aKR() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          g.aAf();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(196897);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196898);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.kpP.bfv());
          bf.iDu.aO("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          g.aAf();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
          g.aAf();
          com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(196898);
        }
      });
      AppMethodBeat.o(196915);
      return;
    }
    this.dHx = ((v)localObject1).bfv();
    bf.iDu.aO("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.bwV("RE900_100");
    paramString = new StringBuilder();
    g.aAf();
    paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_600,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_600") + ",4");
    AppMethodBeat.o(196915);
    return;
    com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(196915);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */