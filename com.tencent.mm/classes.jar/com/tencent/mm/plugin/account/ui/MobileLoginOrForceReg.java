package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;

public class MobileLoginOrForceReg
  extends MMActivity
  implements i
{
  private String fAo;
  private String fLC;
  private String fXu;
  private MMHandler handler;
  protected ProgressDialog iXX;
  private ImageView iZG;
  private TextView iZH;
  private TextView mSz;
  private SecurityImage mUP;
  private int mam;
  private IListener ncA;
  private ms ncO;
  private com.tencent.mm.platformtools.b ndW;
  private g ndj;
  private h ndp;
  private Button nfS;
  private Button nfT;
  private LinearLayout nfU;
  private LinearLayout nfV;
  private int nfW;
  private String nfX;
  private String nfY;
  private int nfZ;
  private String nfm;
  private String nga;
  private boolean ngb;
  private boolean ngc;
  private String ngd;
  private String nge;
  private int ngf;
  private String ngg;
  private int ngh;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.iXX = null;
    this.ndp = null;
    this.ngb = true;
    this.handler = new MobileLoginOrForceReg.1(this);
    this.mUP = null;
    this.ncO = new ms();
    this.ncA = new MobileLoginOrForceReg.12(this);
    this.ndj = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.bkD("R200_100");
    if (this.ngf == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.bgi(this.nga);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_600") + ",2");
      finish();
      AppMethodBeat.o(128401);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_login_or_force_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128397);
    this.nfS = ((Button)findViewById(r.f.continue_login));
    this.nfT = ((Button)findViewById(r.f.force_reg));
    this.nfU = ((LinearLayout)findViewById(r.f.has_avatar));
    this.nfV = ((LinearLayout)findViewById(r.f.no_avatar));
    this.iZG = ((ImageView)findViewById(r.f.avatar_iv));
    this.iZH = ((TextView)findViewById(r.f.nickname_tv));
    this.mSz = ((TextView)findViewById(r.f.bind_mcontact_verify_hint));
    Object localObject = new PhoneFormater();
    if (this.fLC.startsWith("+"))
    {
      String str1 = PhoneFormater.extractCountryCode(this.fLC);
      if (!Util.isNullOrNil(str1))
      {
        String str2 = this.fLC.substring(str1.length() + 1);
        localObject = "+" + str1 + " " + ((PhoneFormater)localObject).formatNumber(str1, str2);
      }
    }
    for (;;)
    {
      this.mSz.setText((CharSequence)localObject);
      if ((!Util.isNullOrNil(this.nickname)) || (!Util.isNullOrNil(this.nfY))) {
        break;
      }
      this.nfV.setVisibility(0);
      this.nfU.setVisibility(8);
      this.nfS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.iXX = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).c(MobileLoginOrForceReg.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128388);
        }
      });
      this.nfT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (Util.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            localObject = new Intent();
            com.tencent.mm.plugin.b.a.bkD("R200_900_phone");
            ((Intent)localObject).putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_user", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_pwd", MobileLoginOrForceReg.d(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_ismobile", 4);
            ((Intent)localObject).putExtra("regsetinfo_isForce", true);
            ((Intent)localObject).putExtra("regsession_id", MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("reg_3d_app_ticket", MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("reg_3d_app_type", MobileLoginOrForceReg.k(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.l(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("mobile_check_type", MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
            ((Intent)localObject).putExtra("key_reg_style", MobileLoginOrForceReg.n(MobileLoginOrForceReg.this));
            ((Intent)localObject).setClass(MobileLoginOrForceReg.this, RegSetInfoUI.class);
            paramAnonymousView = MobileLoginOrForceReg.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128389);
            return;
            MobileLoginOrForceReg.o(MobileLoginOrForceReg.this);
          }
        }
      });
      setMMTitle(r.j.mobile_input_already_bind_title_welcome_back);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128390);
          MobileLoginOrForceReg.p(MobileLoginOrForceReg.this);
          AppMethodBeat.o(128390);
          return false;
        }
      });
      AppMethodBeat.o(128397);
      return;
      localObject = this.fLC;
      continue;
      localObject = "+86 " + ((PhoneFormater)localObject).formatNumber("86", this.fLC);
    }
    this.nfV.setVisibility(8);
    this.nfU.setVisibility(0);
    if (Util.isNullOrNil(this.nickname)) {
      this.iZH.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.hjf().aaC();
      if (localObject != null) {
        this.iZG.setImageBitmap((Bitmap)localObject);
      }
      if (Util.isNullOrNil(this.nfY)) {
        break;
      }
      localObject = this.nfY;
      com.tencent.mm.kernel.h.aHJ().postToWorker(new MobileLoginOrForceReg.13(this, (String)localObject));
      break;
      this.iZH.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.nga = com.tencent.mm.plugin.b.a.bAt();
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    com.tencent.mm.kernel.h.aGY().a(126, this);
    com.tencent.mm.kernel.h.aGY().a(255, this);
    this.ngf = getIntent().getIntExtra("key_reg_style", 1);
    this.fAo = getIntent().getStringExtra("ticket");
    this.fLC = getIntent().getStringExtra("moble");
    this.nfW = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.nfX = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.nfY = getIntent().getStringExtra("avatar_url");
    this.nfm = getIntent().getStringExtra("regsession_id");
    this.ngg = getIntent().getStringExtra("reg_3d_app_ticket");
    this.ngh = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.nfZ = getIntent().getIntExtra("mobile_check_type", 0);
    this.ngc = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.ngd = getIntent().getStringExtra("kintent_nickname");
    this.nge = getIntent().getStringExtra("kintent_password");
    if ((this.nge != null) && (this.nge.length() >= 8)) {}
    for (this.mam = 1;; this.mam = 4)
    {
      initView();
      this.ndW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(126, this);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    if (this.ndW != null) {
      this.ndW.close();
    }
    super.onDestroy();
    AppMethodBeat.o(128400);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128402);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(128402);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128402);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128399);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.bgi("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(128403);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (this.ndj == null) {
      this.ndj = new g();
    }
    boolean bool;
    if (paramq.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.ngb;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.ndp != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.ndj.account = this.username;
        this.ndj.neA = this.nge;
        this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
        this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
        this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
        this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
        if (this.mUP == null)
        {
          this.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              Log.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).mUS + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).mUR.length + " " + com.tencent.mm.compatible.util.f.avD());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).neA, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).neB, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(r.j.app_tip);
              com.tencent.mm.ui.base.h.a(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128391);
                }
              });
              AppMethodBeat.o(128392);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128393);
              MobileLoginOrForceReg.s(MobileLoginOrForceReg.this);
              AppMethodBeat.o(128393);
            }
          }, this.ndj);
          AppMethodBeat.o(128403);
          return;
        }
        this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
        AppMethodBeat.o(128403);
        return;
      }
      this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
      this.ndp.a(this, paramInt1, paramInt2, paramString, paramq);
      if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
        this.ngb = ((com.tencent.mm.modelsimple.t)paramq).boK();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new com.tencent.mm.modelsimple.u(1);
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        getString(r.j.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.h.aGY().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!Util.isNullOrNil(this.ngg)) {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxm, Integer.valueOf(this.ngh));
        }
      }
      AppMethodBeat.o(128403);
      return;
    }
    Object localObject2;
    if (paramq.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.ngc);
        localObject1 = this.nge;
        localObject2 = this.ngd;
        if (this.mUP == null)
        {
          this.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, ((v)paramq).boC(), ((v)paramq).boB(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new v("", this.ngj, this.ngk, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramq).boB(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.WZ(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.Xa(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.wL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(r.j.app_tip);
              localMobileLoginOrForceReg.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, MobileLoginOrForceReg.this.getString(r.j.regbyqq_reg_waiting), true, new MobileLoginOrForceReg.2.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(128379);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128380);
              MobileLoginOrForceReg.s(MobileLoginOrForceReg.this);
              AppMethodBeat.o(128380);
            }
          }, new SecurityImage.b()
          {
            public final void bxQ()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              v localv = new v("", this.ngj, this.ngk, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((v)paramq).boB(), "", true, paramString.booleanValue());
              localv.WZ(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localv.Xa(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localv.wL(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.h.aGY().a(localv, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.mUP.b(0, ((v)paramq).boC(), ((v)paramq).boB(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.fLC;
        bool = this.ngc;
        this.ncO.gVr = this.ngh;
        this.ncO.gef = 6L;
        this.ncO.bpa();
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.kernel.b.eQ(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label915;
        }
        localObject2 = com.tencent.mm.loader.j.b.aST() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.aST() + "temp.avatar.hd";
        com.tencent.mm.vfs.u.oo((String)localObject2, str);
        com.tencent.mm.vfs.u.deleteFile((String)localObject2);
        BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2, true);
        new o(this, com.tencent.mm.loader.j.b.aST() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", this.ngo);
            com.tencent.mm.vfs.u.deleteFile(com.tencent.mm.loader.j.b.aST() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", this.ngo);
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.Kb(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label915:
        this.fAo = ((v)paramq).boL();
        bg.ltv.aS("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.bkD("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_600") + ",4");
      }
    }
    Object localObject1 = new ad(paramInt1, paramInt2, paramString);
    int i;
    if (this.ndW.a(this, (ad)localObject1)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128403);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -2023: 
      case -100: 
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.kernel.b.aGF();
        localObject2 = getContext();
        com.tencent.mm.kernel.h.aHE();
        if (!TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      case -34: 
      case -43: 
      case -41: 
      case -36: 
      case -32: 
      case -33: 
      case -75: 
        for (localObject1 = com.tencent.mm.ci.a.ba(getContext(), r.j.main_err_another_place);; localObject1 = com.tencent.mm.kernel.b.aGs())
        {
          com.tencent.mm.ui.base.h.a((Context)localObject2, (String)localObject1, getContext().getString(r.j.app_tip), new MobileLoginOrForceReg.9(this), new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_freq_limit, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_binded, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_format, 0).show();
          i = 1;
          break;
          Toast.makeText(this, r.j.bind_mcontact_err_unbinded_notbinded, 0).show();
          i = 1;
          break;
          com.tencent.mm.ui.base.h.d(this, getString(r.j.bind_mcontact_verify_error), "", new MobileLoginOrForceReg.7(this));
          i = 1;
          break;
          com.tencent.mm.ui.base.h.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new MobileLoginOrForceReg.8(this));
          i = 1;
          break;
          com.tencent.mm.ui.base.h.p(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
          i = 1;
          break;
          com.tencent.mm.kernel.h.aHE();
        }
      case -140: 
        if (!Util.isNullOrNil(this.fXu)) {
          y.p(getContext(), paramString, this.fXu);
        }
        i = 1;
      }
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(128403);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */