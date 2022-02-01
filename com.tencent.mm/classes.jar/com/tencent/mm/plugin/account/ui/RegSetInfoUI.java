package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.u.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements i
{
  private ProgressDialog iXX;
  private String jaS;
  private SecurityImage mUP;
  private ms ncO;
  private com.tencent.mm.platformtools.b ndW;
  private int nfZ;
  private String nfm;
  private String ngY;
  private int ngf;
  private int ngh;
  private boolean nhv;
  private String nickName;
  private EditText nin;
  private EditText nja;
  private Button njb;
  private String njc;
  private String njd;
  private int nje;
  private String njf;
  private String njg;
  private TextView njh;
  private View nji;
  private boolean njj;
  private ImageView njk;
  private int njl;
  private LinkedList<String> njm;
  private ImageView njn;
  private ProgressBar njo;
  private String njp;
  private ImageView njq;
  private View njr;
  private TextView njs;
  private String njt;
  private boolean nju;
  private r njv;
  private View njw;
  private boolean njx;
  private String njy;
  private MTimerHandler njz;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(128701);
    this.iXX = null;
    this.sceneType = 0;
    this.mUP = null;
    this.njj = false;
    this.nhv = false;
    this.njl = 3;
    this.njm = new LinkedList();
    this.njp = "";
    this.njt = null;
    this.nju = false;
    this.njx = false;
    this.ncO = new ms();
    this.njz = new MTimerHandler(Looper.myLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(128668);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (Util.isNullOrNil(str))
        {
          localObject1 = str;
          if (!Util.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label203;
            }
          }
        }
        label203:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!Util.isNullOrNil((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              com.tencent.mm.kernel.h.aGY().a(429, RegSetInfoUI.this);
              localObject1 = new ag(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
              RegSetInfoUI.h(RegSetInfoUI.this).setVisibility(0);
            }
            AppMethodBeat.o(128668);
            return false;
          }
        }
      }
    }, true);
    AppMethodBeat.o(128701);
  }
  
  private boolean bAa()
  {
    return this.sceneType == 1;
  }
  
  private boolean bAb()
  {
    return this.sceneType == 2;
  }
  
  private boolean bAc()
  {
    return this.sceneType == 0;
  }
  
  private boolean bAd()
  {
    return this.sceneType == 4;
  }
  
  private boolean bAe()
  {
    return this.sceneType == 3;
  }
  
  private int bAf()
  {
    AppMethodBeat.i(128711);
    if (bAa())
    {
      AppMethodBeat.o(128711);
      return 4;
    }
    if (bAb())
    {
      AppMethodBeat.o(128711);
      return 2;
    }
    if (bAe())
    {
      AppMethodBeat.o(128711);
      return 6;
    }
    if (bAd())
    {
      AppMethodBeat.o(128711);
      return 1;
    }
    AppMethodBeat.o(128711);
    return 2;
  }
  
  private String bAg()
  {
    AppMethodBeat.i(128712);
    if ((bAa()) || (bAd()))
    {
      str = this.njc;
      AppMethodBeat.o(128712);
      return str;
    }
    if (bAe())
    {
      str = this.njd;
      AppMethodBeat.o(128712);
      return str;
    }
    String str = this.njg;
    AppMethodBeat.o(128712);
    return str;
  }
  
  private void bxv()
  {
    AppMethodBeat.i(128716);
    hideVKB();
    if (bAa())
    {
      com.tencent.mm.ui.base.h.a(this, getString(r.j.regsetinfo_reverify), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128688);
          if (RegSetInfoUI.I(RegSetInfoUI.this) == 2)
          {
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, MobileInputUI.class);
            paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 2);
          }
          for (;;)
          {
            paramAnonymousDialogInterface.addFlags(67108864);
            RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.b(localRegSetInfoUI, paramAnonymousDialogInterface.aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localRegSetInfoUI.startActivity((Intent)paramAnonymousDialogInterface.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localRegSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128688);
            return;
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128716);
      return;
    }
    if (!bAb())
    {
      if (bAc())
      {
        com.tencent.mm.ui.base.h.a(this, getString(r.j.regsetinfo_regqq_remind), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128692);
            com.tencent.mm.plugin.b.a.bkD("R400_100_signup");
            Object localObject = new Intent(RegSetInfoUI.this, LoginUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128692);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128716);
        return;
      }
      if (bAe())
      {
        com.tencent.mm.ui.base.h.a(this, getString(r.j.regsetinfo_regqq_remind), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128693);
            com.tencent.mm.plugin.b.a.bkD("R500_100");
            Object localObject = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousDialogInterface = RegSetInfoUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128693);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128716);
        return;
      }
      com.tencent.mm.plugin.b.a.bkD("R200_100");
      Object localObject = new Intent(this, MobileInputUI.class);
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
    }
    AppMethodBeat.o(128716);
  }
  
  private void bzV()
  {
    AppMethodBeat.i(128706);
    int j = bAf();
    com.tencent.mm.kernel.h.aGY().a(126, this);
    int i;
    v localv;
    if (bzZ()) {
      if ((this.njm == null) || (this.njm.size() == 0))
      {
        i = 0;
        localv = new v("", this.njf, this.nickName, this.nje, this.njd, this.njc, "", "", this.jaS, j, this.njy, "", "", this.njj, this.nhv);
        ((x.a)localv.lCW.getReqObj()).RBY.TKb = i;
      }
    }
    for (;;)
    {
      localv.WZ(this.nfm);
      localv.Xa(this.ngY);
      localv.wL(this.nfZ);
      com.tencent.mm.kernel.h.aGY().a(localv, 0);
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.regbyqq_reg_waiting), true, new RegSetInfoUI.7(this, localv));
      AppMethodBeat.o(128706);
      return;
      if (this.njm.contains(this.njy))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localv = new v("", this.njf, this.nickName, this.nje, this.njd, this.njc, "", "", this.jaS, j, "", "", "", this.njj, this.nhv);
    }
  }
  
  private boolean bzW()
  {
    AppMethodBeat.i(128708);
    if ((this.njn.getVisibility() == 8) || (this.nju))
    {
      AppMethodBeat.o(128708);
      return true;
    }
    AppMethodBeat.o(128708);
    return false;
  }
  
  private void bzX()
  {
    AppMethodBeat.i(128709);
    String str = this.nin.getText().toString().trim();
    Button localButton = this.njb;
    if (!Util.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(128709);
      return;
    }
  }
  
  private boolean bzY()
  {
    return (this.njl & 0x1) > 0;
  }
  
  private boolean bzZ()
  {
    return (this.njl & 0x2) > 0;
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128714);
    Object localObject = new ad(paramInt1, paramInt2, paramString);
    if (this.ndW.a(this, (ad)localObject))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128714);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128714);
      return false;
    case -10: 
    case -7: 
      com.tencent.mm.ui.base.h.p(this, r.j.reg_username_exist_tip, r.j.reg_username_exist_title);
      AppMethodBeat.o(128714);
      return true;
    case -75: 
      com.tencent.mm.ui.base.h.p(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128714);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aGF();
      localObject = getContext();
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (paramString = com.tencent.mm.ci.a.ba(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a((Context)localObject, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128714);
        return true;
        com.tencent.mm.kernel.h.aHE();
      }
    }
    paramString = com.tencent.mm.h.a.Kb(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(128714);
      return true;
      com.tencent.mm.ui.base.h.c(this, getString(r.j.regsetinfo_ticket_notfound), "", true);
    }
  }
  
  private void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(128707);
    if (Util.isNullOrNil(this.nja.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.njn;
    if (paramBoolean2)
    {
      i = r.e.signup_error;
      localImageView.setImageResource(i);
      localImageView = this.njn;
      if (!paramBoolean1) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      boolean bool1 = bool2;
      if (paramBoolean1)
      {
        bool1 = bool2;
        if (paramBoolean2) {
          bool1 = true;
        }
      }
      this.nju = bool1;
      AppMethodBeat.o(128707);
      return;
      i = r.e.signup_choose;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return r.g.regbyqq_setinfo;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(128705);
    this.njw = findViewById(r.f.popup_anchor);
    this.njr = findViewById(r.f.setinfo_avatar_ly);
    this.njk = ((ImageView)findViewById(r.f.setinfo_avatar));
    this.nin = ((EditText)findViewById(r.f.reg_nick));
    this.njs = ((TextView)findViewById(r.f.setinfo_tip));
    this.nja = ((EditText)findViewById(r.f.reg_wechatid));
    this.njh = ((TextView)findViewById(r.f.alias_tip));
    this.nji = findViewById(r.f.regsetinfo_wid);
    this.njn = ((ImageView)findViewById(r.f.wechaid_iv));
    this.njo = ((ProgressBar)findViewById(r.f.progressBar));
    this.njq = ((ImageView)findViewById(r.f.setinfo_camera));
    this.njb = ((Button)findViewById(r.f.next_btn));
    this.njn.setVisibility(8);
    this.njo.setVisibility(8);
    this.njq.setVisibility(8);
    this.nhv = false;
    this.nju = false;
    Object localObject = this.njr;
    int i;
    if (bzY())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.nji;
      if (!bzZ()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.njh;
      if (!bzZ()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!bzY()) || (!bzZ())) {
        break label503;
      }
      this.njs.setText(getString(r.j.regsetinfo_settip4));
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new RegSetInfoUI.23(this));
      this.nin.addTextChangedListener(new RegSetInfoUI.28(this));
      this.njb.setOnClickListener(new RegSetInfoUI.29(this));
      this.nja.setOnFocusChangeListener(new RegSetInfoUI.30(this));
      this.nja.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128698);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).stopped()) {
            RegSetInfoUI.m(RegSetInfoUI.this).stopTimer();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (Util.isNullOrNil(paramAnonymousEditable))
          {
            RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(r.j.regsetinfo_tip));
            RegSetInfoUI.s(RegSetInfoUI.this);
            if (RegSetInfoUI.t(RegSetInfoUI.this) != null)
            {
              RegSetInfoUI.t(RegSetInfoUI.this).dismiss();
              RegSetInfoUI.u(RegSetInfoUI.this);
            }
            RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(128697);
                RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                AppMethodBeat.o(128697);
              }
            }, 50L);
          }
          if ((!Util.isNullOrNil(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.v(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.s(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).startTimer(500L);
          }
          RegSetInfoUI.a(RegSetInfoUI.this, paramAnonymousEditable);
          AppMethodBeat.o(128698);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setBackBtn(new RegSetInfoUI.32(this));
      this.nin.setOnEditorActionListener(new RegSetInfoUI.33(this));
      this.nin.setOnKeyListener(new RegSetInfoUI.2(this));
      this.nja.setOnEditorActionListener(new RegSetInfoUI.3(this));
      this.nja.setOnKeyListener(new RegSetInfoUI.4(this));
      this.njk.setOnClickListener(new RegSetInfoUI.5(this));
      localObject = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aST());
      if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
        ((com.tencent.mm.vfs.q)localObject).ifK();
      }
      bzX();
      AppMethodBeat.o(128705);
      return;
      i = 8;
      break;
      label491:
      i = 8;
      break label237;
      label497:
      i = 8;
      break label256;
      label503:
      if ((bzY()) && (!bzZ())) {
        this.njs.setText(getString(r.j.regsetinfo_settip2));
      } else if ((!bzY()) && (bzZ())) {
        this.njs.setText(getString(r.j.regsetinfo_settip3));
      } else {
        this.njs.setText(getString(r.j.regsetinfo_settip1));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128710);
    Log.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        bzV();
      }
      AppMethodBeat.o(128710);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.sdk.a.mIH.b(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.njk.setImageBitmap(paramIntent);
      this.nhv = true;
      this.njq.setVisibility(0);
    }
    AppMethodBeat.o(128710);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128702);
    super.onCreate(paramBundle);
    paramBundle = getString(r.j.regsetinfo_title);
    if ((d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.njc = getIntent().getStringExtra("regsetinfo_user");
    this.njd = getIntent().getStringExtra("regsetinfo_bind_email");
    this.jaS = getIntent().getStringExtra("regsetinfo_ticket");
    this.njf = getIntent().getStringExtra("regsetinfo_pwd");
    this.njg = getIntent().getStringExtra("regsetinfo_binduin");
    this.nfZ = getIntent().getIntExtra("mobile_check_type", 0);
    if (!Util.isNullOrNil(this.njg)) {
      this.nje = p.fT(this.njg);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.njj = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.njl = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.nfm = getIntent().getStringExtra("regsession_id");
    this.ngY = getIntent().getStringExtra("reg_3d_app_ticket");
    this.ngh = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.ngf = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.bgi("R200_900_phone");
    }
    for (;;)
    {
      this.njx = false;
      this.ndW = new com.tencent.mm.platformtools.b();
      AppMethodBeat.o(128702);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.bgi("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.bgi("R200_900_email");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128704);
    super.onDestroy();
    StringBuilder localStringBuilder;
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.ndW != null) {
        this.ndW.close();
      }
      AppMethodBeat.o(128704);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R4_QQ,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_email,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128715);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bxv();
      AppMethodBeat.o(128715);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128715);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128703);
    super.onResume();
    this.nin.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128679);
        RegSetInfoUI.i(RegSetInfoUI.this).requestFocus();
        RegSetInfoUI.b(RegSetInfoUI.this).clearFocus();
        AppMethodBeat.o(128679);
      }
    }, 500L);
    AppMethodBeat.o(128703);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128713);
    Log.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    final String str2;
    final String str1;
    final int i;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramq.getType() == 126)
    {
      com.tencent.mm.kernel.h.aGY().b(126, this);
      if (this.iXX != null)
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ncO.gVr = this.ngh;
        this.ncO.gef = 6L;
        this.ncO.bpa();
        this.njt = null;
        str2 = bAg();
        str1 = ((v)paramq).boN();
        i = ((v)paramq).boO();
        str3 = ((v)paramq).boP();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label1730;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label571;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1730;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label1727;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      Log.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.b.aGG();
      com.tencent.mm.kernel.b.eQ(true);
      if (this.nhv)
      {
        localObject3 = com.tencent.mm.loader.j.b.aST() + "temp.avatar";
        str3 = com.tencent.mm.loader.j.b.aST() + "temp.avatar.hd";
        u.oo((String)localObject3, str3);
        u.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail(str3, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new o(this, com.tencent.mm.loader.j.b.aST() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128674);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", str2);
            u.deleteFile(com.tencent.mm.loader.j.b.aST() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128674);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.ngE);
                ((Intent)localObject1).putExtra("alert_message", this.ngF);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128674);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128675);
            RegSetInfoUI.b(RegSetInfoUI.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegSetInfoUI.this);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, (Intent)localObject1, (Intent)localObject2);
                RegSetInfoUI.this.finish();
                AppMethodBeat.o(128675);
                return;
                localObject1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.ngE);
                ((Intent)localObject1).putExtra("alert_message", this.ngF);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegSetInfoUI.this);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = RegSetInfoUI.this;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$17", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            AppMethodBeat.o(128675);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.mUP == null)
          {
            this.mUP = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, 0, ((v)paramq).boC(), ((v)paramq).boB(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128677);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  com.tencent.mm.ui.base.h.p(RegSetInfoUI.this, r.j.verify_account_null_tip, r.j.regbymobile_reg_setpwd_alert_title);
                  AppMethodBeat.o(128677);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aGY().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new v("", RegSetInfoUI.y(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((v)paramq).boB(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode(), RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                paramAnonymousDialogInterface.WZ(RegSetInfoUI.E(RegSetInfoUI.this));
                paramAnonymousDialogInterface.Xa(RegSetInfoUI.F(RegSetInfoUI.this));
                paramAnonymousDialogInterface.wL(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(r.j.app_tip);
                RegSetInfoUI.a((RegSetInfoUI)localObject, com.tencent.mm.ui.base.h.a(localRegSetInfoUI, RegSetInfoUI.this.getString(r.j.regbyqq_reg_waiting), true, new RegSetInfoUI.10.1(this, paramAnonymousDialogInterface)));
                AppMethodBeat.o(128677);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128678);
                RegSetInfoUI.H(RegSetInfoUI.this);
                AppMethodBeat.o(128678);
              }
            }, new SecurityImage.b()
            {
              public final void bxQ()
              {
                AppMethodBeat.i(128680);
                RegSetInfoUI.this.hideVKB();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aGY().a(126, RegSetInfoUI.this);
                localObject = new v("", RegSetInfoUI.y(RegSetInfoUI.this), str, RegSetInfoUI.z(RegSetInfoUI.this), RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((v)paramq).boB(), "", RegSetInfoUI.D(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ((v)localObject).WZ(RegSetInfoUI.E(RegSetInfoUI.this));
                ((v)localObject).Xa(RegSetInfoUI.F(RegSetInfoUI.this));
                ((v)localObject).wL(RegSetInfoUI.G(RegSetInfoUI.this));
                com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
                AppMethodBeat.o(128680);
              }
            });
            AppMethodBeat.o(128713);
            return;
            label571:
            int j = Util.safeParseInt((String)localObject3);
            if (j == 0)
            {
              bool1 = false;
              break;
            }
            if (j != 1) {
              break;
            }
            bool1 = true;
            break;
            this.jaS = ((v)paramq).boL();
            bg.ltv.aS("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.jaS);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
                ((Intent)localObject2).addFlags(67108864);
                ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
                MMWizardActivity.b(this, (Intent)localObject1, (Intent)localObject2);
                finish();
                break;
                localObject3 = new Intent(this, FindMContactAlertUI.class);
                ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
                ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
              }
            }
            localObject1 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.mUP.b(0, ((v)paramq).boC(), ((v)paramq).boB(), "");
          AppMethodBeat.o(128713);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.Kb(paramString);
      if (localObject1 != null)
      {
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(128713);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramq.getType() == 429)
      {
        com.tencent.mm.kernel.h.aGY().b(429, this);
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        this.njo.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.njt = null;
          paramInt1 = ((u.b)((ag)paramq).lCW.getRespObj()).mWu.Tlo;
          Log.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramq = ((u.b)((ag)paramq).lCW.getRespObj()).mWu.rVy;
            paramString = com.tencent.mm.h.a.Kb(paramString);
            if (paramString != null) {
              this.njh.setText(paramString.desc);
            }
            this.njm.clear();
            if ((paramq != null) && (paramq.size() > 0))
            {
              if (paramq.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramq.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((eaf)paramq.get(paramInt2)).Ufy;
                  this.njm.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.njx)
              {
                if (this.njv != null)
                {
                  this.njv.dismiss();
                  this.njv = null;
                }
                this.njv = q.a(this, this.njw, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(128687);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymousAdapterView);
                    localb.bn(paramAnonymousView);
                    localb.sg(paramAnonymousInt);
                    localb.Fs(paramAnonymousLong);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
                    if (RegSetInfoUI.t(RegSetInfoUI.this) != null)
                    {
                      RegSetInfoUI.t(RegSetInfoUI.this).dismiss();
                      RegSetInfoUI.u(RegSetInfoUI.this);
                    }
                    RegSetInfoUI.a(RegSetInfoUI.this).setText(paramString[paramAnonymousInt]);
                    RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(128686);
                        RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                        RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                        AppMethodBeat.o(128686);
                      }
                    }, 50L);
                    RegSetInfoUI.r(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(r.j.regsetinfo_tip));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$25", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(128687);
                  }
                });
              }
            }
            u(true, true);
            AppMethodBeat.o(128713);
            return;
          }
          if (Util.isNullOrNil(this.nja.getText().toString().trim()))
          {
            u(false, false);
            AppMethodBeat.o(128713);
            return;
          }
          u(true, false);
          this.njh.setText(getString(r.j.regsetinfo_tip));
          if (this.njv != null)
          {
            this.njv.dismiss();
            this.njv = null;
          }
          this.nja.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128681);
              RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
              RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
              AppMethodBeat.o(128681);
            }
          }, 50L);
          AppMethodBeat.o(128713);
          return;
        }
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.mUP == null)
          {
            this.mUP = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, 0, ((ag)paramq).boC(), ((ag)paramq).boB(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128683);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  com.tencent.mm.ui.base.h.p(RegSetInfoUI.this, r.j.verify_account_null_tip, r.j.regbymobile_reg_setpwd_alert_title);
                  AppMethodBeat.o(128683);
                  return;
                }
                RegSetInfoUI.this.hideVKB();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aGY().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new ag((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((ag)paramq).boB(), RegSetInfoUI.C(RegSetInfoUI.this).getSecImgCode());
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(r.j.app_tip);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, RegSetInfoUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(128682);
                    com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                    com.tencent.mm.kernel.h.aGY().b(429, RegSetInfoUI.this);
                    AppMethodBeat.o(128682);
                  }
                }));
                AppMethodBeat.o(128683);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128684);
                RegSetInfoUI.H(RegSetInfoUI.this);
                AppMethodBeat.o(128684);
              }
            }, new SecurityImage.b()
            {
              public final void bxQ()
              {
                AppMethodBeat.i(128685);
                RegSetInfoUI.this.hideVKB();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                com.tencent.mm.kernel.h.aGY().a(429, RegSetInfoUI.this);
                localObject = new ag((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((ag)paramq).boB(), "");
                com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
                AppMethodBeat.o(128685);
              }
            });
            AppMethodBeat.o(128713);
            return;
          }
          this.mUP.b(0, ((ag)paramq).boC(), ((ag)paramq).boB(), "");
          AppMethodBeat.o(128713);
          return;
        }
        u(true, true);
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128713);
        return;
      }
      if (paramInt1 == 8)
      {
        this.njt = getString(r.j.fmt_http_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.njt, 0).show();
        AppMethodBeat.o(128713);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(r.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128713);
      return;
      label1727:
      continue;
      label1730:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */