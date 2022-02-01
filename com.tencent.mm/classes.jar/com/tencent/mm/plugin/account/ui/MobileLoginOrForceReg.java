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
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String dKk;
  private String dpf;
  private String dzn;
  protected ProgressDialog fMu;
  private ImageView fOf;
  private TextView fOg;
  private ap handler;
  private int imo;
  private TextView jai;
  private SecurityImage jct;
  private c jjI;
  private gk jjW;
  private f jkr;
  private g jkx;
  private com.tencent.mm.platformtools.b jlc;
  private Button jmU;
  private Button jmV;
  private LinearLayout jmW;
  private LinearLayout jmX;
  private int jmY;
  private String jmZ;
  private String jmq;
  private String jna;
  private int jnb;
  private String jnc;
  private boolean jnd;
  private boolean jne;
  private String jnf;
  private String jng;
  private int jnh;
  private String jnj;
  private int jnk;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(128395);
    this.fMu = null;
    this.jkx = null;
    this.jnd = true;
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
    this.jct = null;
    this.jjW = new gk();
    this.jjI = new MobileLoginOrForceReg.12(this);
    this.jkr = null;
    AppMethodBeat.o(128395);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128401);
    com.tencent.mm.plugin.b.a.Ma("R200_100");
    if (this.jnh == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.b.a.Kc(this.jnc);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_600") + ",2");
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
    this.jmU = ((Button)findViewById(2131298783));
    this.jmV = ((Button)findViewById(2131300217));
    this.jmW = ((LinearLayout)findViewById(2131300679));
    this.jmX = ((LinearLayout)findViewById(2131302869));
    this.fOf = ((ImageView)findViewById(2131297008));
    this.fOg = ((TextView)findViewById(2131302867));
    this.jai = ((TextView)findViewById(2131297250));
    new ba();
    Object localObject;
    if (this.dzn.startsWith("+"))
    {
      localObject = ba.aob(this.dzn);
      if (!bt.isNullOrNil((String)localObject))
      {
        String str = this.dzn.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + ba.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.jai.setText((CharSequence)localObject);
      if ((!bt.isNullOrNil(this.nickname)) || (!bt.isNullOrNil(this.jna))) {
        break;
      }
      this.jmX.setVisibility(0);
      this.jmW.setVisibility(8);
      this.jmU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128388);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              MobileLoginOrForceReg.this.fMu = paramAnonymous2ProgressDialog;
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).b(MobileLoginOrForceReg.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128388);
        }
      });
      this.jmV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128389);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (bt.isNullOrNil(MobileLoginOrForceReg.g(MobileLoginOrForceReg.this)))
          {
            localObject = new Intent();
            com.tencent.mm.plugin.b.a.Ma("R200_900_phone");
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      localObject = this.dzn;
      continue;
      localObject = "+86 " + ba.formatNumber("86", this.dzn);
    }
    this.jmX.setVisibility(8);
    this.jmW.setVisibility(0);
    if (bt.isNullOrNil(this.nickname)) {
      this.fOg.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.fbx().LL();
      if (localObject != null) {
        this.fOf.setImageBitmap((Bitmap)localObject);
      }
      if (bt.isNullOrNil(this.jna)) {
        break;
      }
      localObject = this.jna;
      com.tencent.mm.kernel.g.ajF().ay(new MobileLoginOrForceReg.13(this, (String)localObject));
      break;
      this.fOg.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128396);
    super.onCreate(paramBundle);
    this.jnc = com.tencent.mm.plugin.b.a.Mp();
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    com.tencent.mm.kernel.g.aiU().a(126, this);
    com.tencent.mm.kernel.g.aiU().a(255, this);
    this.jnh = getIntent().getIntExtra("key_reg_style", 1);
    this.dpf = getIntent().getStringExtra("ticket");
    this.dzn = getIntent().getStringExtra("moble");
    this.jmY = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.jmZ = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.jna = getIntent().getStringExtra("avatar_url");
    this.jmq = getIntent().getStringExtra("regsession_id");
    this.jnj = getIntent().getStringExtra("reg_3d_app_ticket");
    this.jnk = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.jnb = getIntent().getIntExtra("mobile_check_type", 0);
    this.jne = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.jnf = getIntent().getStringExtra("kintent_nickname");
    this.jng = getIntent().getStringExtra("kintent_password");
    if ((this.jng != null) && (this.jng.length() >= 8)) {}
    for (this.imo = 1;; this.imo = 4)
    {
      initView();
      this.jlc = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128396);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128400);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    com.tencent.mm.kernel.g.aiU().b(126, this);
    com.tencent.mm.kernel.g.aiU().b(255, this);
    if (this.jlc != null) {
      this.jlc.close();
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
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    AppMethodBeat.o(128399);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128398);
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.Kc("R200_600");
    AppMethodBeat.o(128398);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128403);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (this.jkr == null) {
      this.jkr = new f();
    }
    boolean bool;
    if (paramn.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.jnd;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131763302));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(128403);
      return;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jkx != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.jkr.account = this.username;
        this.jkr.jlE = this.jng;
        this.jkr.jcw = ((s)paramn).aKL();
        this.jkr.jcv = ((s)paramn).aKM();
        this.jkr.jcx = ((s)paramn).aKN();
        this.jkr.jlF = ((s)paramn).getSecCodeType();
        if (this.jct == null)
        {
          this.jct = SecurityImage.a.a(this, this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128392);
              ad.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jcw + " img len" + MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
              paramAnonymousDialogInterface = new s(MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).account, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jlE, MobileLoginOrForceReg.q(MobileLoginOrForceReg.this).jlF, MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgSid(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(2131755906);
              h.b(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128391);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
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
          }, this.jkr);
          AppMethodBeat.o(128403);
          return;
        }
        this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
        AppMethodBeat.o(128403);
        return;
      }
      this.dKk = ((s)paramn).aKK();
      this.jkx.a(this, paramInt1, paramInt2, paramString, paramn);
      if ((paramn instanceof s)) {
        this.jnd = ((s)paramn).aKU();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new t(1);
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        getString(2131755906);
        this.fMu = h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128394);
            com.tencent.mm.kernel.g.aiU().a(paramString);
            AppMethodBeat.o(128394);
          }
        });
        if (!bt.isNullOrNil(this.jnj)) {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFQ, Integer.valueOf(this.jnk));
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
        paramString = Boolean.valueOf(this.jne);
        localObject1 = this.jng;
        localObject2 = this.jnf;
        if (this.jct == null)
        {
          this.jct = SecurityImage.a.a(this, 0, ((u)paramn).aKM(), ((u)paramn).aKL(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128379);
              paramAnonymousDialogInterface = new u("", this.jnm, this.jnn, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aKL(), MobileLoginOrForceReg.r(MobileLoginOrForceReg.this).getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.Gn(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.Go(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              paramAnonymousDialogInterface.pT(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              AppCompatActivity localAppCompatActivity = MobileLoginOrForceReg.this.getContext();
              MobileLoginOrForceReg.this.getString(2131755906);
              localMobileLoginOrForceReg.fMu = h.b(localAppCompatActivity, MobileLoginOrForceReg.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128378);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
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
            public final void aSv()
            {
              AppMethodBeat.i(128381);
              MobileLoginOrForceReg.this.hideVKB();
              u localu = new u("", this.jnm, this.jnn, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.t(MobileLoginOrForceReg.this), "", ((u)paramn).aKL(), "", true, paramString.booleanValue());
              localu.Gn(MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
              localu.Go(MobileLoginOrForceReg.j(MobileLoginOrForceReg.this));
              localu.pT(MobileLoginOrForceReg.m(MobileLoginOrForceReg.this));
              com.tencent.mm.kernel.g.aiU().a(localu, 0);
              AppMethodBeat.o(128381);
            }
          });
          AppMethodBeat.o(128403);
          return;
        }
        this.jct.b(0, ((u)paramn).aKM(), ((u)paramn).aKL(), "");
        AppMethodBeat.o(128403);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.dzn;
        bool = this.jne;
        this.jjW.enS = this.jnk;
        this.jjW.dPl = 6L;
        this.jjW.aLk();
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dB(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label908;
        }
        localObject2 = com.tencent.mm.loader.j.b.asc() + "temp.avatar";
        String str = com.tencent.mm.loader.j.b.asc() + "temp.avatar.hd";
        i.mA((String)localObject2, str);
        i.deleteFile((String)localObject2);
        com.tencent.mm.sdk.platformtools.g.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.ak.n(this, com.tencent.mm.loader.j.b.asc() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128382);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aKV());
            az.hFS.aM("login_user_name", this.jnr);
            i.deleteFile(com.tencent.mm.loader.j.b.asc() + "temp.avatar");
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajA();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.ajA();
            com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128382);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128383);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((u)paramn).aKV());
            az.hFS.aM("login_user_name", this.jnr);
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(MobileLoginOrForceReg.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = MobileLoginOrForceReg.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileLoginOrForceReg)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajA();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
            com.tencent.mm.kernel.g.ajA();
            com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            AppMethodBeat.o(128383);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.uz(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128403);
        return;
        label908:
        this.dpf = ((u)paramn).aKV();
        az.hFS.aM("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileLoginOrForceReg", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.Ma("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_600") + ",4");
      }
    }
    Object localObject1 = new ae(paramInt1, paramInt2, paramString);
    int i;
    if (this.jlc.a(this, (ae)localObject1)) {
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
        if (!bt.isNullOrNil(this.dKk)) {
          y.n(getContext(), paramString, this.dKk);
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
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.ajA();
        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
        for (localObject1 = com.tencent.mm.cc.a.az(getContext(), 2131761063);; localObject1 = com.tencent.mm.kernel.a.ais())
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
          com.tencent.mm.kernel.g.ajA();
        }
      }
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.uz(paramString);
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