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
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String dAl;
  private String dgo;
  private String dpO;
  protected ProgressDialog fpP;
  private ImageView frr;
  private TextView frs;
  private ap handler;
  private int hsv;
  private TextView igQ;
  private SecurityImage ijd;
  private dv iqH;
  private c iqt;
  private com.tencent.mm.platformtools.b irP;
  private f ird;
  private g irj;
  private Button itH;
  private Button itI;
  private LinearLayout itJ;
  private LinearLayout itK;
  private int itL;
  private String itM;
  private String itN;
  private int itO;
  private String itP;
  private boolean itQ;
  private boolean itR;
  private String itS;
  private String itT;
  private int itU;
  private String itV;
  private int itW;
  private String itd;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.fpP = null;
    this.irj = null;
    this.itQ = true;
    this.handler = new ap()
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
    this.ijd = null;
    this.iqH = new dv();
    this.iqt = new MobileLoginOrForceReg.12(this);
    this.ird = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.aUz("R200_100");
    if (this.itU == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.aUy(this.itP);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R200_600") + ",2");
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
    this.itH = ((Button)findViewById(2131298783));
    this.itI = ((Button)findViewById(2131300217));
    this.itJ = ((LinearLayout)findViewById(2131300679));
    this.itK = ((LinearLayout)findViewById(2131302869));
    this.frr = ((ImageView)findViewById(2131297008));
    this.frs = ((TextView)findViewById(2131302867));
    this.igQ = ((TextView)findViewById(2131297250));
    new ba();
    Object localObject;
    if (this.dpO.startsWith("+"))
    {
      localObject = ba.aew(this.dpO);
      if (!bt.isNullOrNil((String)localObject))
      {
        String str = this.dpO.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + ba.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.igQ.setText((CharSequence)localObject);
      if ((!bt.isNullOrNil(this.nickname)) || (!bt.isNullOrNil(this.itN))) {
        break;
      }
      this.itK.setVisibility(0);
      this.itJ.setVisibility(8);
      this.itH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.fpP = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).a(MobileLoginOrForceReg.this);
          AppMethodBeat.o(128388);
        }
      });
      this.itI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          if (bt.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            Object localObject = new Intent();
            com.tencent.mm.plugin.b.a.aUz("R200_900_phone");
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
      localObject = this.dpO;
      continue;
      localObject = "+86 " + ba.formatNumber("86", this.dpO);
    }
    this.itK.setVisibility(8);
    this.itJ.setVisibility(0);
    if (bt.isNullOrNil(this.nickname)) {
      this.frs.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.exg().Ky();
      if (localObject != null) {
        this.frr.setImageBitmap((Bitmap)localObject);
      }
      if (bt.isNullOrNil(this.itN)) {
        break;
      }
      localObject = this.itN;
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128386);
          Object localObject = null;
          try
          {
            Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.decodeStream(com.tencent.mm.network.b.v(this.val$url, 10000, 20000));
            localObject = localBitmap;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
            }
          }
          MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).sendMessage(MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).obtainMessage(0, localObject));
          AppMethodBeat.o(128386);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(128387);
          String str = super.toString() + "|loadBitmap";
          AppMethodBeat.o(128387);
          return str;
        }
      });
      break;
      this.frs.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.itP = com.tencent.mm.plugin.b.a.fQQ();
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    com.tencent.mm.kernel.g.aeS().a(126, this);
    com.tencent.mm.kernel.g.aeS().a(255, this);
    this.itU = getIntent().getIntExtra("key_reg_style", 1);
    this.dgo = getIntent().getStringExtra("ticket");
    this.dpO = getIntent().getStringExtra("moble");
    this.itL = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.itM = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.itN = getIntent().getStringExtra("avatar_url");
    this.itd = getIntent().getStringExtra("regsession_id");
    this.itV = getIntent().getStringExtra("reg_3d_app_ticket");
    this.itW = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.itO = getIntent().getIntExtra("mobile_check_type", 0);
    this.itR = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.itS = getIntent().getStringExtra("kintent_nickname");
    this.itT = getIntent().getStringExtra("kintent_password");
    if ((this.itT != null) && (this.itT.length() >= 8)) {}
    for (this.hsv = 1;; this.hsv = 4)
    {
      initView();
      this.irP = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    com.tencent.mm.kernel.g.aeS().b(126, this);
    com.tencent.mm.kernel.g.aeS().b(255, this);
    if (this.irP != null) {
      this.irP.close();
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
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.aUy("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128403);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (this.ird == null) {
      this.ird = new f();
    }
    boolean bool;
    if (paramn.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.itQ;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131763302));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.irj != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.ird.account = this.username;
        this.ird.isr = this.itT;
        this.ird.ijg = ((s)paramn).aAK();
        this.ird.ijf = ((s)paramn).aAL();
        this.ird.ijh = ((s)paramn).aAM();
        this.ird.iss = ((s)paramn).getSecCodeType();
        if (this.ijd == null)
        {
          this.ijd = SecurityImage.a.a(this, this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).ijg + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
              paramAnonymousDialogInterface = new s(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).isr, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).iss, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(2131755906);
              h.b(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
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
          }, this.ird);
          AppMethodBeat.o(128403);
          return;
        }
        this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
        AppMethodBeat.o(128403);
        return;
      }
      this.dAl = ((s)paramn).aAJ();
      this.irj.a(this, paramInt1, paramInt2, paramString, paramn);
      if ((paramn instanceof s)) {
        this.itQ = ((s)paramn).aAT();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new t(1);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        getString(2131755906);
        this.fpP = h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.g.aeS().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!bt.isNullOrNil(this.itV)) {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fvr, Integer.valueOf(this.itW));
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
        paramString = Boolean.valueOf(this.itR);
        localObject1 = this.itT;
        localObject2 = this.itS;
        if (this.ijd == null)
        {
          this.ijd = SecurityImage.a.a(this, 0, ((u)paramn).aAL(), ((u)paramn).aAK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new u("", this.itY, this.itZ, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aAK(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.zd(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.ze(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.oC(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(2131755906);
              localMobileLoginOrForceReg.fpP = h.b(localAppCompatActivity, MobileLoginOrForceReg.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
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
            public final void aIs()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              u localu = new u("", this.itY, this.itZ, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aAK(), "", true, paramString.booleanValue());
              localu.zd(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localu.ze(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localu.oC(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.aeS().a(localu, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.ijd.b(0, ((u)paramn).aAL(), ((u)paramn).aAK(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.dpO;
        bool = this.itR;
        this.iqH.dVG = this.itW;
        this.iqH.dFd = 6L;
        this.iqH.aBj();
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dz(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label906;
        }
        localObject2 = com.tencent.mm.loader.j.b.aio() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.aio() + "temp.avatar.hd";
        i.lD((String)localObject2, str);
        i.deleteFile((String)localObject2);
        com.tencent.mm.sdk.platformtools.f.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.ak.n(this, com.tencent.mm.loader.j.b.aio() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aAU());
            ay.gNa.aD("login_user_name", this.iud);
            i.deleteFile(com.tencent.mm.loader.j.b.aio() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.afz();
            com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aAU());
            ay.gNa.aD("login_user_name", this.iud);
            Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.afz();
            com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.oG(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label906:
        this.dgo = ((u)paramn).aAU();
        ay.gNa.aD("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.aUz("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R200_600") + ",4");
      }
    }
    Object localObject1 = new com.tencent.mm.platformtools.ad(paramInt1, paramInt2, paramString);
    int i;
    if (this.irP.a(this, (com.tencent.mm.platformtools.ad)localObject1)) {
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
        if (!bt.isNullOrNil(this.dAl)) {
          y.m(getContext(), paramString, this.dAl);
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
        h.j(this, 2131755266, 2131762275);
        i = 1;
        break;
      case -100: 
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.afz();
        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
        for (localObject1 = com.tencent.mm.cd.a.aq(getContext(), 2131761063);; localObject1 = com.tencent.mm.kernel.a.aeq())
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
          com.tencent.mm.kernel.g.afz();
        }
      }
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.oG(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */