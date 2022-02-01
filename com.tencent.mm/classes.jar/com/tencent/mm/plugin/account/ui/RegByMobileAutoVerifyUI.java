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
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements com.tencent.mm.ak.g, a.a
{
  private String countryCode;
  private String ddJ;
  private String dnz;
  private String guM;
  private int iTZ;
  private String iTi;
  private String iVo;
  private String iVp;
  private String iVq;
  private String iVr;
  private String iVs;
  private boolean iVt;
  private int iVu;
  private ProgressDialog iVv;
  private SecurityImage iVw;
  private ir iVx;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(193230);
    this.iVu = 2;
    this.iVx = new ir();
    AppMethodBeat.o(193230);
  }
  
  private void aRd()
  {
    AppMethodBeat.i(193234);
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.iVq, this.guM, this);
    this.iVv = h.b(this, getString(2131756503), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193224);
        ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(193224);
      }
    });
    AppMethodBeat.o(193234);
  }
  
  public int getLayoutId()
  {
    return 2131495236;
  }
  
  public void initView()
  {
    AppMethodBeat.i(193232);
    final Button localButton = (Button)findViewById(2131302852);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193221);
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2)
        {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
          AppMethodBeat.o(193221);
          return;
        }
        RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        AppMethodBeat.o(193221);
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(2131303933);
    localCheckBoxLicenseView.setTermTip(getString(2131762325));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193222);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dHr = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aHZ();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(193222);
      }
    });
    ((TextView)findViewById(2131303934)).setText(getString(2131762322, new Object[] { this.iVo }));
    ((TextView)findViewById(2131303941)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193223);
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dHr = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aHZ();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        AppMethodBeat.o(193223);
      }
    });
    AppMethodBeat.o(193232);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193233);
    this.iVx.dHr = 4;
    this.iVx.aHZ();
    super.onBackPressed();
    AppMethodBeat.o(193233);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193231);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dnz = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.iVo = (this.countryCode + this.dnz);
    this.iVp = getIntent().getStringExtra("Key_Seq");
    this.guM = getIntent().getStringExtra("Key_Url");
    this.iTi = getIntent().getStringExtra("Key_reg_sessionId");
    this.iVq = (System.currentTimeMillis() + "_" + this.iVp);
    this.iVr = getIntent().getStringExtra("kintent_nickname");
    this.iVs = getIntent().getStringExtra("kintent_password");
    this.iTZ = getIntent().getIntExtra("key_reg_style", 1);
    this.iVt = getIntent().getBooleanExtra("kintent_hasavatar", false);
    ac.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.dnz, this.iVp, this.guM, this.iVr, Boolean.valueOf(this.iVt) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193212);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(193212);
        return true;
      }
    });
    this.iVx.dPp = System.currentTimeMillis();
    paramBundle = this.iVx;
    paramBundle.elw = paramBundle.t("DeviceID", com.tencent.mm.compatible.deviceinfo.q.Ya(), true);
    paramBundle = this.iVx;
    paramBundle.elv = paramBundle.t("RegisterMobile", this.iVo, true);
    com.tencent.mm.kernel.g.agi().a(126, this);
    com.tencent.mm.kernel.g.agi().a(145, this);
    AppMethodBeat.o(193231);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193236);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.iVq);
    com.tencent.mm.kernel.g.agi().b(126, this);
    com.tencent.mm.kernel.g.agi().b(145, this);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    AppMethodBeat.o(193236);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(193237);
    ac.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.iVv != null)
    {
      this.iVv.dismiss();
      this.iVv = null;
    }
    int i;
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      ac.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.iVu = ((com.tencent.mm.modelfriend.a)paramn).aEu();
          ac.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.iVu) });
          if (this.iVu == 2)
          {
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aEx();
            this.iVp = paramn.iVp;
            this.guM = paramn.url;
            this.iVq = (System.currentTimeMillis() + "_" + this.iVp);
            aRd();
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
          paramn = com.tencent.mm.h.a.rM(paramString);
          if ((paramn == null) || (!paramn.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(193237);
          return;
          if (this.iVu == 1)
          {
            this.iVx.dHr = 3;
            this.iVx.dWe = 2;
            this.iVx.aHZ();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramn).aEw();
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aEv();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.iTi);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.iVo);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramn);
            ((Intent)localObject2).putExtra("kintent_nickname", this.iVr);
            ((Intent)localObject2).putExtra("kintent_password", this.iVs);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.iVt);
            paramn = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramn.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramn.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.iVx.dHr = 3;
            this.iVx.dWe = 2;
            this.iVx.aHZ();
            i = ((com.tencent.mm.modelfriend.a)paramn).aEz();
            int j = ((com.tencent.mm.modelfriend.a)paramn).aEA();
            paramn = new Intent();
            paramn.putExtra("bindmcontact_mobile", this.iVo);
            paramn.putExtra("bindmcontact_shortmobile", this.dnz);
            paramn.putExtra("couttry_code", this.countryCode);
            paramn.putExtra("mobileverify_countdownsec", i);
            paramn.putExtra("mobileverify_countdownstyle", j);
            paramn.putExtra("kintent_hasavatar", this.iVt);
            paramn.putExtra("kintent_nickname", this.iVr);
            paramn.putExtra("kintent_password", this.iVs);
            paramn.putExtra("key_reg_style", this.iTZ);
            paramn.putExtra("regsession_id", this.iTi);
            paramn.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramn);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              h.l(this, 2131762328, 2131762329);
              AppMethodBeat.o(193237);
              return;
            }
            if (paramInt2 == -34)
            {
              h.c(this, getString(2131756462), "", true);
              AppMethodBeat.o(193237);
              return;
              if (i == 15)
              {
                paramn = (com.tencent.mm.modelfriend.a)paramn;
                this.ddJ = paramn.aEr();
                if (paramInt2 == 0)
                {
                  this.iVx.dHr = 3;
                  this.iVx.dWe = 1;
                  this.iVx.aHZ();
                  if (this.iTZ == 1)
                  {
                    com.tencent.mm.kernel.g.agi().a(126, this);
                    paramn = new u("", this.iVs, this.iVr, 0, "", this.iVo, "", "", this.ddJ, 1, "", "", "", true, this.iVt);
                    paramn.Di(this.iTi);
                    paramn.pq(this.iVu);
                    com.tencent.mm.kernel.g.agi().a(paramn, 0);
                    getString(2131755906);
                    this.iVv = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(193228);
                        com.tencent.mm.kernel.g.agi().a(paramn);
                        com.tencent.mm.kernel.g.agi().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(193228);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.ddJ);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.iVo);
                    ((Intent)localObject1).putExtra("regsession_id", this.iTi);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramn.aEy());
                    ((Intent)localObject1).putExtra("key_reg_style", this.iTZ);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramn = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramn.lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.iVx.dHr = 3;
                  this.iVx.dWe = 2;
                  this.iVx.aHZ();
                  localObject1 = com.tencent.mm.h.a.rM(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193229);
                        com.tencent.mm.kernel.g.agi().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.agi().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aEq());
                        AppMethodBeat.o(193229);
                      }
                    }, null);
                  } else {
                    h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193213);
                        com.tencent.mm.kernel.g.agi().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.agi().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aEq());
                        AppMethodBeat.o(193213);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.iVx.dHr = 3;
                  this.iVx.dWe = 2;
                  this.iVx.aHZ();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.ddJ);
                  ((Intent)localObject1).putExtra("moble", this.iVo);
                  ((Intent)localObject1).putExtra("regsession_id", this.iTi);
                  ((Intent)localObject1).putExtra("next_controll", paramn.aEy());
                  ((Intent)localObject1).putExtra("username", paramn.getUsername());
                  ((Intent)localObject1).putExtra("password", paramn.aEq());
                  ((Intent)localObject1).putExtra("nickname", paramn.aEE());
                  ((Intent)localObject1).putExtra("avatar_url", paramn.aED());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.iVu);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.iVt);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.iVr);
                  ((Intent)localObject1).putExtra("kintent_password", this.iVs);
                  ((Intent)localObject1).putExtra("key_reg_style", this.iTZ);
                  paramn = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, paramn.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramn.lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.iVx.dHr = 3;
                    this.iVx.dWe = 2;
                    this.iVx.aHZ();
                    h.a(this, getString(2131762320), "", getString(2131755792), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193214);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(193214);
                      }
                    });
                    AppMethodBeat.o(193237);
                    return;
                  }
                  this.iVx.dHr = 3;
                  this.iVx.dWe = 2;
                  this.iVx.aHZ();
                  Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramn.getType() != 126);
      localObject1 = (u)paramn;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.iVw == null)
        {
          this.iVw = SecurityImage.a.a(this, 0, ((u)localObject1).aHB(), ((u)localObject1).aHA(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(193216);
              paramAnonymousDialogInterface = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.iVA.aHA(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.Di(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.pq(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(2131755906);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, h.b(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(193215);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(193215);
                }
              }));
              AppMethodBeat.o(193216);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(193217);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(193217);
            }
          }, new SecurityImage.b()
          {
            public final void aPj()
            {
              AppMethodBeat.i(193218);
              RegByMobileAutoVerifyUI.this.hideVKB();
              u localu = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.iVA.aHA(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localu.Di(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localu.pq(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.agi().a(localu, 0);
              AppMethodBeat.o(193218);
            }
          });
          AppMethodBeat.o(193237);
          return;
        }
        this.iVw.b(0, ((u)paramn).aHB(), ((u)paramn).aHA(), "");
        AppMethodBeat.o(193237);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.iVo;
    com.tencent.mm.kernel.a.unhold();
    com.tencent.mm.kernel.a.dz(true);
    if (this.iVt)
    {
      paramn = b.apo() + "temp.avatar";
      localObject2 = b.apo() + "temp.avatar.hd";
      i.ma(paramn, (String)localObject2);
      i.deleteFile(paramn);
      f.c((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
      new com.tencent.mm.aj.n(this, b.apo() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(193219);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.iVA.aHK());
          ay.hnA.aL("login_user_name", paramString);
          i.deleteFile(b.apo() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(193219);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193220);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.iVA.aHK());
          ay.hnA.aL("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(193220);
        }
      });
      AppMethodBeat.o(193237);
      return;
    }
    this.ddJ = ((u)localObject1).aHK();
    ay.hnA.aL("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.IL("RE900_100");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    paramString = paramString.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_600") + ",4");
    AppMethodBeat.o(193237);
    return;
    com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(193237);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void x(final Bundle paramBundle)
  {
    AppMethodBeat.i(193235);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193226);
        String str = paramBundle.getString("session", "");
        if ((!bs.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          ac.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!bs.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(193226);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dHr = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dWe = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aHZ();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(2131762320), "", RegByMobileAutoVerifyUI.this.getString(2131755792), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(193225);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(193225);
            }
          });
        }
        AppMethodBeat.o(193226);
      }
    });
    AppMethodBeat.o(193235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */