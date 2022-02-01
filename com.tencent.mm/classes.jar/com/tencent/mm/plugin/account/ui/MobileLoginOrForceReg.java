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
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String ddJ;
  private String dnz;
  private String dxX;
  protected ProgressDialog fts;
  private ImageView fuY;
  private TextView fuZ;
  private int hSX;
  private ao handler;
  private TextView iGZ;
  private SecurityImage iJk;
  private c iQA;
  private fl iQO;
  private com.tencent.mm.platformtools.b iRU;
  private f iRj;
  private g iRp;
  private Button iTM;
  private Button iTN;
  private LinearLayout iTO;
  private LinearLayout iTP;
  private int iTQ;
  private String iTR;
  private String iTS;
  private int iTT;
  private String iTU;
  private boolean iTV;
  private boolean iTW;
  private String iTX;
  private String iTY;
  private int iTZ;
  private String iTi;
  private String iUa;
  private int iUb;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.fts = null;
    this.iRp = null;
    this.iTV = true;
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(128377);
        if (paramAnonymousMessage.obj != null)
        {
          paramAnonymousMessage = (Bitmap)paramAnonymousMessage.obj;
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this).setImageBitmap(paramAnonymousMessage);
        }
        AppMethodBeat.o(128377);
      }
    };
    this.iJk = null;
    this.iQO = new fl();
    this.iQA = new MobileLoginOrForceReg.12(this);
    this.iRj = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.IL("R200_100");
    if (this.iTZ == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.IK(this.iTU);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_600") + ",2");
      finish();
      AppMethodBeat.o(128401);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494924;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128397);
    this.iTM = ((Button)findViewById(2131298783));
    this.iTN = ((Button)findViewById(2131300217));
    this.iTO = ((LinearLayout)findViewById(2131300679));
    this.iTP = ((LinearLayout)findViewById(2131302869));
    this.fuY = ((ImageView)findViewById(2131297008));
    this.fuZ = ((TextView)findViewById(2131302867));
    this.iGZ = ((TextView)findViewById(2131297250));
    new az();
    Object localObject;
    if (this.dnz.startsWith("+"))
    {
      localObject = az.ajo(this.dnz);
      if (!bs.isNullOrNil((String)localObject))
      {
        String str = this.dnz.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + az.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.iGZ.setText((CharSequence)localObject);
      if ((!bs.isNullOrNil(this.nickname)) || (!bs.isNullOrNil(this.iTS))) {
        break;
      }
      this.iTP.setVisibility(0);
      this.iTO.setVisibility(8);
      this.iTM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.fts = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).a(MobileLoginOrForceReg.this);
          AppMethodBeat.o(128388);
        }
      });
      this.iTN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          if (bs.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            Object localObject = new Intent();
            com.tencent.mm.plugin.b.a.IL("R200_900_phone");
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128389);
            return;
          }
          MobileLoginOrForceReg.o(MobileLoginOrForceReg.this);
          AppMethodBeat.o(128389);
        }
      });
      setMMTitle(2131761256);
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
      localObject = this.dnz;
      continue;
      localObject = "+86 " + az.formatNumber("86", this.dnz);
    }
    this.iTP.setVisibility(8);
    this.iTO.setVisibility(0);
    if (bs.isNullOrNil(this.nickname)) {
      this.fuZ.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.eMA().Kj();
      if (localObject != null) {
        this.fuY.setImageBitmap((Bitmap)localObject);
      }
      if (bs.isNullOrNil(this.iTS)) {
        break;
      }
      localObject = this.iTS;
      com.tencent.mm.kernel.g.agU().az(new MobileLoginOrForceReg.13(this, (String)localObject));
      break;
      this.fuZ.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.iTU = com.tencent.mm.plugin.b.a.EL();
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    com.tencent.mm.kernel.g.agi().a(126, this);
    com.tencent.mm.kernel.g.agi().a(255, this);
    this.iTZ = getIntent().getIntExtra("key_reg_style", 1);
    this.ddJ = getIntent().getStringExtra("ticket");
    this.dnz = getIntent().getStringExtra("moble");
    this.iTQ = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.iTR = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.iTS = getIntent().getStringExtra("avatar_url");
    this.iTi = getIntent().getStringExtra("regsession_id");
    this.iUa = getIntent().getStringExtra("reg_3d_app_ticket");
    this.iUb = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.iTT = getIntent().getIntExtra("mobile_check_type", 0);
    this.iTW = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.iTX = getIntent().getStringExtra("kintent_nickname");
    this.iTY = getIntent().getStringExtra("kintent_password");
    if ((this.iTY != null) && (this.iTY.length() >= 8)) {}
    for (this.hSX = 1;; this.hSX = 4)
    {
      initView();
      this.iRU = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(126, this);
    com.tencent.mm.kernel.g.agi().b(255, this);
    if (this.iRU != null) {
      this.iRU.close();
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.IK("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128403);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (this.iRj == null) {
      this.iRj = new f();
    }
    boolean bool;
    if (paramn.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.iTV;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131763302));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.iRp != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.iRj.account = this.username;
        this.iRj.iSw = this.iTY;
        this.iRj.iJn = ((s)paramn).aHA();
        this.iRj.iJm = ((s)paramn).aHB();
        this.iRj.iJo = ((s)paramn).aHC();
        this.iRj.iSx = ((s)paramn).getSecCodeType();
        if (this.iJk == null)
        {
          this.iJk = SecurityImage.a.a(this, this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              ac.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).iJn + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
              paramAnonymousDialogInterface = new s(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).iSw, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).iSx, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(2131755906);
              h.b(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(2131760781), true, new MobileLoginOrForceReg.17.1(this, paramAnonymousDialogInterface));
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
          }, this.iRj);
          AppMethodBeat.o(128403);
          return;
        }
        this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
        AppMethodBeat.o(128403);
        return;
      }
      this.dxX = ((s)paramn).aHz();
      this.iRp.a(this, paramInt1, paramInt2, paramString, paramn);
      if ((paramn instanceof s)) {
        this.iTV = ((s)paramn).aHJ();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new t(1);
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        getString(2131755906);
        this.fts = h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.g.agi().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!bs.isNullOrNil(this.iUa)) {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTl, Integer.valueOf(this.iUb));
        }
      }
      AppMethodBeat.o(128403);
      return;
    }
    Object localObject2;
    if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.iTW);
        localObject1 = this.iTY;
        localObject2 = this.iTX;
        if (this.iJk == null)
        {
          this.iJk = SecurityImage.a.a(this, 0, ((u)paramn).aHB(), ((u)paramn).aHA(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new u("", this.iUd, this.iUe, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aHA(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.Di(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.Dj(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.pq(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(2131755906);
              localMobileLoginOrForceReg.fts = h.b(localAppCompatActivity, MobileLoginOrForceReg.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128378);
                }
              });
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
            public final void aPj()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              u localu = new u("", this.iUd, this.iUe, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aHA(), "", true, paramString.booleanValue());
              localu.Di(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localu.Dj(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localu.pq(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.agi().a(localu, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.iJk.b(0, ((u)paramn).aHB(), ((u)paramn).aHA(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.dnz;
        bool = this.iTW;
        this.iQO.dXB = this.iUb;
        this.iQO.dCQ = 6L;
        this.iQO.aHZ();
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dz(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label908;
        }
        localObject2 = com.tencent.mm.loader.j.b.apo() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.apo() + "temp.avatar.hd";
        i.ma((String)localObject2, str);
        i.deleteFile((String)localObject2);
        com.tencent.mm.sdk.platformtools.f.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.aj.n(this, com.tencent.mm.loader.j.b.apo() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aHK());
            ay.hnA.aL("login_user_name", this.iUi);
            i.deleteFile(com.tencent.mm.loader.j.b.apo() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aHK());
            ay.hnA.aL("login_user_name", this.iUi);
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.rM(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label908:
        this.ddJ = ((u)paramn).aHK();
        ay.hnA.aL("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.IL("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_600") + ",4");
      }
    }
    Object localObject1 = new ad(paramInt1, paramInt2, paramString);
    int i;
    if (this.iRU.a(this, (ad)localObject1)) {
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
      case -140: 
        if (!bs.isNullOrNil(this.dxX)) {
          y.m(getContext(), paramString, this.dxX);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131756462, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756459, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756461, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756464, 0).show();
        i = 1;
        break;
      case -32: 
        h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        i = 1;
        break;
      case -33: 
        h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        i = 1;
        break;
      case -75: 
        h.l(this, 2131755266, 2131762275);
        i = 1;
        break;
      case -100: 
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.agP();
        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
        for (localObject1 = com.tencent.mm.cc.a.aw(getContext(), 2131761063);; localObject1 = com.tencent.mm.kernel.a.afG())
        {
          h.a((Context)localObject2, (String)localObject1, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
          });
          i = 1;
          break;
          com.tencent.mm.kernel.g.agP();
        }
      }
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(128403);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128403);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */