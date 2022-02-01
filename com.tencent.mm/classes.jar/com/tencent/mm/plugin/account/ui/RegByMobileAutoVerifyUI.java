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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements f, a.a
{
  private String countryCode;
  private String dAs;
  private String dqk;
  private String gRf;
  private String jpk;
  private int jqb;
  private String jrq;
  private String jrr;
  private String jrs;
  private String jrt;
  private String jru;
  private boolean jrv;
  private int jrw;
  private ProgressDialog jrx;
  private SecurityImage jry;
  private jy jrz;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(188423);
    this.jrw = 2;
    this.jrz = new jy();
    AppMethodBeat.o(188423);
  }
  
  private void aUO()
  {
    AppMethodBeat.i(188427);
    ((com.tencent.mm.plugin.mobile.verify.a.a)g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.jrs, this.gRf, this);
    this.jrx = com.tencent.mm.ui.base.h.b(this, getString(2131756503), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(188417);
        ((com.tencent.mm.plugin.mobile.verify.a.a)g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(188417);
      }
    });
    AppMethodBeat.o(188427);
  }
  
  public int getLayoutId()
  {
    return 2131495236;
  }
  
  public void initView()
  {
    AppMethodBeat.i(188425);
    final Button localButton = (Button)findViewById(2131302852);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188414);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2) {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(188414);
          return;
          RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        }
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(2131303933);
    localCheckBoxLicenseView.setTermTip(getString(2131762325));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(188415);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dRj = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLH();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(188415);
      }
    });
    ((TextView)findViewById(2131303934)).setText(getString(2131762322, new Object[] { this.jrq }));
    ((TextView)findViewById(2131303941)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188416);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dRj = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLH();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188416);
      }
    });
    AppMethodBeat.o(188425);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(188426);
    this.jrz.dRj = 4;
    this.jrz.aLH();
    super.onBackPressed();
    AppMethodBeat.o(188426);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188424);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dAs = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.jrq = (this.countryCode + this.dAs);
    this.jrr = getIntent().getStringExtra("Key_Seq");
    this.gRf = getIntent().getStringExtra("Key_Url");
    this.jpk = getIntent().getStringExtra("Key_reg_sessionId");
    this.jrs = (System.currentTimeMillis() + "_" + this.jrr);
    this.jrt = getIntent().getStringExtra("kintent_nickname");
    this.jru = getIntent().getStringExtra("kintent_password");
    this.jqb = getIntent().getIntExtra("key_reg_style", 1);
    this.jrv = getIntent().getBooleanExtra("kintent_hasavatar", false);
    ae.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.dAs, this.jrr, this.gRf, this.jrt, Boolean.valueOf(this.jrv) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188405);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(188405);
        return true;
      }
    });
    this.jrz.ege = System.currentTimeMillis();
    paramBundle = this.jrz;
    paramBundle.eEh = paramBundle.t("DeviceID", com.tencent.mm.compatible.deviceinfo.q.aaK(), true);
    paramBundle = this.jrz;
    paramBundle.eEg = paramBundle.t("RegisterMobile", this.jrq, true);
    g.ajj().a(126, this);
    g.ajj().a(145, this);
    AppMethodBeat.o(188424);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188429);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.jrs);
    g.ajj().b(126, this);
    g.ajj().b(145, this);
    g.ajj().b(701, this);
    g.ajj().b(252, this);
    AppMethodBeat.o(188429);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(188430);
    ae.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jrx != null)
    {
      this.jrx.dismiss();
      this.jrx = null;
    }
    int i;
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      ae.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.jrw = ((com.tencent.mm.modelfriend.a)paramn).aHQ();
          ae.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.jrw) });
          if (this.jrw == 2)
          {
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aHT();
            this.jrr = paramn.jrr;
            this.gRf = paramn.url;
            this.jrs = (System.currentTimeMillis() + "_" + this.jrr);
            aUO();
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
          paramn = com.tencent.mm.h.a.uU(paramString);
          if ((paramn == null) || (!paramn.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(188430);
          return;
          if (this.jrw == 1)
          {
            this.jrz.dRj = 3;
            this.jrz.eoc = 2;
            this.jrz.aLH();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramn).aHS();
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aHR();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.jpk);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.jrq);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramn);
            ((Intent)localObject2).putExtra("kintent_nickname", this.jrt);
            ((Intent)localObject2).putExtra("kintent_password", this.jru);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.jrv);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramn.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.jrz.dRj = 3;
            this.jrz.eoc = 2;
            this.jrz.aLH();
            i = ((com.tencent.mm.modelfriend.a)paramn).aHV();
            int j = ((com.tencent.mm.modelfriend.a)paramn).aHW();
            paramn = new Intent();
            paramn.putExtra("bindmcontact_mobile", this.jrq);
            paramn.putExtra("bindmcontact_shortmobile", this.dAs);
            paramn.putExtra("couttry_code", this.countryCode);
            paramn.putExtra("mobileverify_countdownsec", i);
            paramn.putExtra("mobileverify_countdownstyle", j);
            paramn.putExtra("kintent_hasavatar", this.jrv);
            paramn.putExtra("kintent_nickname", this.jrt);
            paramn.putExtra("kintent_password", this.jru);
            paramn.putExtra("key_reg_style", this.jqb);
            paramn.putExtra("regsession_id", this.jpk);
            paramn.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramn);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              com.tencent.mm.ui.base.h.l(this, 2131762328, 2131762329);
              AppMethodBeat.o(188430);
              return;
            }
            if (paramInt2 == -34)
            {
              com.tencent.mm.ui.base.h.c(this, getString(2131756462), "", true);
              AppMethodBeat.o(188430);
              return;
              if (i == 15)
              {
                paramn = (com.tencent.mm.modelfriend.a)paramn;
                this.dqk = paramn.aHN();
                if (paramInt2 == 0)
                {
                  this.jrz.dRj = 3;
                  this.jrz.eoc = 1;
                  this.jrz.aLH();
                  if (this.jqb == 1)
                  {
                    g.ajj().a(126, this);
                    paramn = new v("", this.jru, this.jrt, 0, "", this.jrq, "", "", this.dqk, 1, "", "", "", true, this.jrv);
                    paramn.GP(this.jpk);
                    paramn.pW(this.jrw);
                    g.ajj().a(paramn, 0);
                    getString(2131755906);
                    this.jrx = com.tencent.mm.ui.base.h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(188421);
                        g.ajj().a(paramn);
                        g.ajj().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(188421);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dqk);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.jrq);
                    ((Intent)localObject1).putExtra("regsession_id", this.jpk);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramn.aHU());
                    ((Intent)localObject1).putExtra("key_reg_style", this.jqb);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramn.mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.jrz.dRj = 3;
                  this.jrz.eoc = 2;
                  this.jrz.aLH();
                  localObject1 = com.tencent.mm.h.a.uU(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(188422);
                        g.ajj().a(701, RegByMobileAutoVerifyUI.this);
                        g.ajj().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aHM());
                        AppMethodBeat.o(188422);
                      }
                    }, null);
                  } else {
                    com.tencent.mm.ui.base.h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(188406);
                        g.ajj().a(701, RegByMobileAutoVerifyUI.this);
                        g.ajj().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aHM());
                        AppMethodBeat.o(188406);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.jrz.dRj = 3;
                  this.jrz.eoc = 2;
                  this.jrz.aLH();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.dqk);
                  ((Intent)localObject1).putExtra("moble", this.jrq);
                  ((Intent)localObject1).putExtra("regsession_id", this.jpk);
                  ((Intent)localObject1).putExtra("next_controll", paramn.aHU());
                  ((Intent)localObject1).putExtra("username", paramn.getUsername());
                  ((Intent)localObject1).putExtra("password", paramn.aHM());
                  ((Intent)localObject1).putExtra("nickname", paramn.aIa());
                  ((Intent)localObject1).putExtra("avatar_url", paramn.aHZ());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.jrw);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.jrv);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.jrt);
                  ((Intent)localObject1).putExtra("kintent_password", this.jru);
                  ((Intent)localObject1).putExtra("key_reg_style", this.jqb);
                  paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramn.mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.jrz.dRj = 3;
                    this.jrz.eoc = 2;
                    this.jrz.aLH();
                    com.tencent.mm.ui.base.h.a(this, getString(2131762320), "", getString(2131755792), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(188407);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(188407);
                      }
                    });
                    AppMethodBeat.o(188430);
                    return;
                  }
                  this.jrz.dRj = 3;
                  this.jrz.eoc = 2;
                  this.jrz.aLH();
                  Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramn.getType() != 126);
      localObject1 = (v)paramn;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.jry == null)
        {
          this.jry = SecurityImage.a.a(this, 0, ((v)localObject1).aLj(), ((v)localObject1).aLi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(188409);
              paramAnonymousDialogInterface = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.jrC.aLi(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.GP(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.pW(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              g.ajj().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(2131755906);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(188408);
                  g.ajj().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(188408);
                }
              }));
              AppMethodBeat.o(188409);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(188410);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(188410);
            }
          }, new SecurityImage.b()
          {
            public final void aSU()
            {
              AppMethodBeat.i(188411);
              RegByMobileAutoVerifyUI.this.hideVKB();
              v localv = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.jrC.aLi(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localv.GP(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localv.pW(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              g.ajj().a(localv, 0);
              AppMethodBeat.o(188411);
            }
          });
          AppMethodBeat.o(188430);
          return;
        }
        this.jry.b(0, ((v)paramn).aLj(), ((v)paramn).aLi(), "");
        AppMethodBeat.o(188430);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.jrq;
    com.tencent.mm.kernel.a.unhold();
    com.tencent.mm.kernel.a.dC(true);
    if (this.jrv)
    {
      paramn = com.tencent.mm.loader.j.b.asr() + "temp.avatar";
      localObject2 = com.tencent.mm.loader.j.b.asr() + "temp.avatar.hd";
      o.mG(paramn, (String)localObject2);
      o.deleteFile(paramn);
      com.tencent.mm.sdk.platformtools.h.c((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
      new com.tencent.mm.aj.n(this, com.tencent.mm.loader.j.b.asr() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(188412);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.jrC.aLs());
          bb.hIK.aM("login_user_name", paramString);
          o.deleteFile(com.tencent.mm.loader.j.b.asr() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          g.ajP();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
          g.ajP();
          com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(188412);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188413);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.jrC.aLs());
          bb.hIK.aM("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          g.ajP();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
          g.ajP();
          com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(188413);
        }
      });
      AppMethodBeat.o(188430);
      return;
    }
    this.dqk = ((v)localObject1).aLs();
    bb.hIK.aM("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.KB("RE900_100");
    paramString = new StringBuilder();
    g.ajP();
    paramString = paramString.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
    g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_600") + ",4");
    AppMethodBeat.o(188430);
    return;
    com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(188430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(final Bundle paramBundle)
  {
    AppMethodBeat.i(188428);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188419);
        String str = paramBundle.getString("session", "");
        if ((!bu.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          ae.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!bu.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(188419);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dRj = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).eoc = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLH();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          com.tencent.mm.ui.base.h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(2131762320), "", RegByMobileAutoVerifyUI.this.getString(2131755792), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(188418);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(188418);
            }
          });
        }
        AppMethodBeat.o(188419);
      }
    });
    AppMethodBeat.o(188428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */