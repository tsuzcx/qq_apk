package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.t.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.b;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements f
{
  private String aVr;
  private ProgressDialog dnm = null;
  private String dqS;
  private SecurityImage fex = null;
  private com.tencent.mm.platformtools.c fmK;
  private int foT;
  private int foZ;
  private String fog;
  private EditText fqV;
  private boolean fqq = false;
  private EditText frO;
  private Button frP;
  private String frQ;
  private String frR;
  private int frS;
  private String frT;
  private String frU;
  private TextView frV;
  private View frW;
  private boolean frX = false;
  private ImageView frY;
  private int frZ = 3;
  private LinkedList<String> fsa = new LinkedList();
  private ImageView fsb;
  private ProgressBar fsc;
  private String fsd = "";
  private ImageView fse;
  private View fsf;
  private TextView fsg;
  private String fsh = null;
  private boolean fsi = false;
  private com.tencent.mm.ui.base.o fsj;
  private View fsk;
  private boolean fsl = false;
  private String fsm;
  private am fsn = new am(Looper.myLooper(), new RegSetInfoUI.1(this), true);
  private int sceneType = 0;
  
  private void Wc()
  {
    XM();
    if (Yo()) {
      h.a(this, getString(q.j.regsetinfo_reverify), "", new RegSetInfoUI.21(this), new RegSetInfoUI.22(this));
    }
    while (Yp()) {
      return;
    }
    if (this.sceneType == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      h.a(this, getString(q.j.regsetinfo_regqq_remind), "", new RegSetInfoUI.24(this), new RegSetInfoUI.25(this));
      return;
    }
    if (Yr())
    {
      h.a(this, getString(q.j.regsetinfo_regqq_remind), "", new RegSetInfoUI.26(this), new RegSetInfoUI.27(this));
      return;
    }
    com.tencent.mm.plugin.b.a.qj("R200_100");
    Intent localIntent = new Intent(this, MobileInputUI.class);
    localIntent.putExtra("mobile_input_purpose", 2);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  private void Yj()
  {
    int j = Ys();
    g.Dk().a(126, this);
    int i;
    com.tencent.mm.modelsimple.s locals;
    if (Yn()) {
      if ((this.fsa == null) || (this.fsa.size() == 0))
      {
        i = 0;
        locals = new com.tencent.mm.modelsimple.s("", this.frT, this.aVr, this.frS, this.frR, this.frQ, "", "", this.dqS, j, this.fsm, "", "", this.frX, this.fqq);
        ((u.a)locals.edR.Kv()).sqk.tuX = i;
      }
    }
    for (;;)
    {
      locals.ne(this.fog);
      locals.jc(this.foT);
      g.Dk().a(locals, 0);
      getString(q.j.app_tip);
      this.dnm = h.b(this, getString(q.j.regbyqq_reg_waiting), true, new RegSetInfoUI.7(this, locals));
      return;
      if (this.fsa.contains(this.fsm))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      locals = new com.tencent.mm.modelsimple.s("", this.frT, this.aVr, this.frS, this.frR, this.frQ, "", "", this.dqS, j, "", "", "", this.frX, this.fqq);
    }
  }
  
  private boolean Yk()
  {
    return (this.fsb.getVisibility() == 8) || (this.fsi);
  }
  
  private void Yl()
  {
    String str = this.fqV.getText().toString().trim();
    Button localButton = this.frP;
    if (!bk.bl(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  private boolean Ym()
  {
    return (this.frZ & 0x1) > 0;
  }
  
  private boolean Yn()
  {
    return (this.frZ & 0x2) > 0;
  }
  
  private boolean Yo()
  {
    return this.sceneType == 1;
  }
  
  private boolean Yp()
  {
    return this.sceneType == 2;
  }
  
  private boolean Yq()
  {
    return this.sceneType == 4;
  }
  
  private boolean Yr()
  {
    return this.sceneType == 3;
  }
  
  private int Ys()
  {
    int j = 2;
    int i;
    if (Yo()) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (Yp());
      if (Yr()) {
        return 6;
      }
      i = j;
    } while (!Yq());
    return 1;
  }
  
  private String Yt()
  {
    if ((Yo()) || (Yq())) {
      return this.frQ;
    }
    if (Yr()) {
      return this.frR;
    }
    return this.frU;
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new ag(paramInt1, paramInt2, paramString);
    if (this.fmK.a(this, (ag)localObject)) {
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      return true;
    }
    switch (paramInt2)
    {
    default: 
      return false;
    case -10: 
    case -7: 
      h.h(this, q.j.reg_username_exist_tip, q.j.reg_username_exist_title);
      return true;
    case -75: 
      h.h(this, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      localObject = this.mController.uMN;
      g.DN();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
      for (paramString = com.tencent.mm.cb.a.ac(this.mController.uMN, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
      {
        h.a((Context)localObject, paramString, this.mController.uMN.getString(q.j.app_tip), new RegSetInfoUI.19(this), new RegSetInfoUI.20(this));
        return true;
        g.DN();
      }
    }
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      return true;
      h.b(this, getString(q.j.regsetinfo_ticket_notfound), "", true);
    }
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (bk.bl(this.frO.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.fsb;
    if (paramBoolean2)
    {
      i = q.e.signup_error;
      localImageView.setImageResource(i);
      localImageView = this.fsb;
      if (!paramBoolean1) {
        break label95;
      }
    }
    label95:
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
      this.fsi = bool1;
      return;
      i = q.e.signup_choose;
      break;
    }
  }
  
  protected final int getLayoutId()
  {
    return q.g.regbyqq_setinfo;
  }
  
  protected final void initView()
  {
    int j = 0;
    this.fsk = findViewById(q.f.popup_anchor);
    this.fsf = findViewById(q.f.setinfo_avatar_ly);
    this.frY = ((ImageView)findViewById(q.f.setinfo_avatar));
    this.fqV = ((EditText)findViewById(q.f.reg_nick));
    this.fsg = ((TextView)findViewById(q.f.setinfo_tip));
    this.frO = ((EditText)findViewById(q.f.reg_wechatid));
    this.frV = ((TextView)findViewById(q.f.alias_tip));
    this.frW = findViewById(q.f.regsetinfo_wid);
    this.fsb = ((ImageView)findViewById(q.f.wechaid_iv));
    this.fsc = ((ProgressBar)findViewById(q.f.progressBar));
    this.fse = ((ImageView)findViewById(q.f.setinfo_camera));
    this.frP = ((Button)findViewById(q.f.next_btn));
    this.fsb.setVisibility(8);
    this.fsc.setVisibility(8);
    this.fse.setVisibility(8);
    this.fqq = false;
    this.fsi = false;
    Object localObject = this.fsf;
    int i;
    if (Ym())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.frW;
      if (!Yn()) {
        break label479;
      }
      i = 0;
      label231:
      ((View)localObject).setVisibility(i);
      localObject = this.frV;
      if (!Yn()) {
        break label485;
      }
      i = j;
      label250:
      ((TextView)localObject).setVisibility(i);
      if ((!Ym()) || (!Yn())) {
        break label491;
      }
      this.fsg.setText(getString(q.j.regsetinfo_settip4));
    }
    for (;;)
    {
      g.DS().a(new RegSetInfoUI.23(this));
      this.fqV.addTextChangedListener(new RegSetInfoUI.28(this));
      this.frP.setOnClickListener(new RegSetInfoUI.29(this));
      this.frO.setOnFocusChangeListener(new RegSetInfoUI.30(this));
      this.frO.addTextChangedListener(new RegSetInfoUI.31(this));
      setBackBtn(new RegSetInfoUI.32(this));
      this.fqV.setOnEditorActionListener(new RegSetInfoUI.33(this));
      this.fqV.setOnKeyListener(new RegSetInfoUI.2(this));
      this.frO.setOnEditorActionListener(new RegSetInfoUI.3(this));
      this.frO.setOnKeyListener(new RegSetInfoUI.4(this));
      this.frY.setOnClickListener(new RegSetInfoUI.5(this));
      localObject = new b(com.tencent.mm.compatible.util.e.dzK);
      if (!((b)localObject).exists()) {
        ((b)localObject).mkdirs();
      }
      Yl();
      return;
      i = 8;
      break;
      label479:
      i = 8;
      break label231;
      label485:
      i = 8;
      break label250;
      label491:
      if ((Ym()) && (!Yn())) {
        this.fsg.setText(getString(q.j.regsetinfo_settip2));
      } else if ((!Ym()) && (Yn())) {
        this.fsg.setText(getString(q.j.regsetinfo_settip3));
      } else {
        this.fsg.setText(getString(q.j.regsetinfo_settip1));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        Yj();
      }
    }
    do
    {
      return;
      paramIntent = com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramIntent);
    } while (paramIntent == null);
    this.frY.setImageBitmap(paramIntent);
    this.fqq = true;
    this.fse.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getString(q.j.regsetinfo_title);
    if (d.spd) {
      paramBundle = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.frQ = getIntent().getStringExtra("regsetinfo_user");
    this.frR = getIntent().getStringExtra("regsetinfo_bind_email");
    this.dqS = getIntent().getStringExtra("regsetinfo_ticket");
    this.frT = getIntent().getStringExtra("regsetinfo_pwd");
    this.frU = getIntent().getStringExtra("regsetinfo_binduin");
    this.foT = getIntent().getIntExtra("mobile_check_type", 0);
    if (!bk.bl(this.frU)) {
      this.frS = com.tencent.mm.a.o.bS(this.frU);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.frX = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.frZ = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.fog = getIntent().getStringExtra("regsession_id");
    this.foZ = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      g.DN();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.qi("R200_900_phone");
    }
    for (;;)
    {
      this.fsl = false;
      this.fmK = new com.tencent.mm.platformtools.c();
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        g.DN();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.qi("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        g.DN();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.qi("R200_900_email");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    StringBuilder localStringBuilder;
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.fmK != null) {
        this.fmK.close();
      }
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        g.DN();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        g.DN();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.fqV.postDelayed(new RegSetInfoUI.12(this), 500L);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    String str2;
    String str1;
    int i;
    String str3;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    boolean bool1;
    Object localObject3;
    if (paramm.getType() == 126)
    {
      g.Dk().b(126, this);
      if (this.dnm != null)
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.fsh = null;
        str2 = Yt();
        str1 = ((com.tencent.mm.modelsimple.s)paramm).QK();
        i = ((com.tencent.mm.modelsimple.s)paramm).QL();
        str3 = ((com.tencent.mm.modelsimple.s)paramm).QM();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bn.s(str3, "wording");
        if (localMap == null) {
          break label1549;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bk.bl((String)localObject3)) {
          break label528;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1549;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bk.bl((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bk.bl((String)localObject3)) {
          break label1546;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      y.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.bF(true);
      if (this.fqq)
      {
        localObject3 = com.tencent.mm.compatible.util.e.dzK + "temp.avatar";
        str3 = com.tencent.mm.compatible.util.e.dzK + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aA((String)localObject3, str3);
        com.tencent.mm.vfs.e.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.c.c(str3, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ag.m(this, com.tencent.mm.compatible.util.e.dzK + "temp.avatar").a(new RegSetInfoUI.8(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, i), new RegSetInfoUI.9(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, i));
        label435:
        if ((paramInt2 != -6) && (paramInt2 != -311) && (paramInt2 != -310)) {
          break label891;
        }
        if (this.fex != null) {
          break label864;
        }
        this.fex = SecurityImage.a.a(this.mController.uMN, q.j.regbyqq_secimg_title, 0, ((com.tencent.mm.modelsimple.s)paramm).QA(), ((com.tencent.mm.modelsimple.s)paramm).Qz(), "", new RegSetInfoUI.10(this, paramm), null, new RegSetInfoUI.11(this), new RegSetInfoUI.13(this, paramm));
      }
      label528:
      label864:
      label891:
      do
      {
        do
        {
          do
          {
            return;
            int j = bk.ZR((String)localObject3);
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
            this.dqS = ((com.tencent.mm.modelsimple.s)paramm).QI();
            at.dVC.Y("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.qj("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dqS);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            startActivity((Intent)localObject1);
            localObject1 = new StringBuilder();
            g.DN();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.DN();
            com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_900_phone") + ",4");
            finish();
            break label435;
            this.fex.a(0, ((com.tencent.mm.modelsimple.s)paramm).QA(), ((com.tencent.mm.modelsimple.s)paramm).Qz(), "");
            return;
            localObject1 = com.tencent.mm.i.a.eI(paramString);
            if (localObject1 != null)
            {
              ((com.tencent.mm.i.a)localObject1).a(this, null, null);
              return;
            }
          } while (h(paramInt1, paramInt2, paramString));
          if (paramm.getType() == 429)
          {
            g.Dk().b(429, this);
            if (this.dnm != null)
            {
              this.dnm.dismiss();
              this.dnm = null;
            }
            this.fsc.setVisibility(8);
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.fsh = null;
              paramInt1 = ((t.b)((ad)paramm).edR.HF()).fgd.tgY;
              y.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
              if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
              {
                paramm = ((t.b)((ad)paramm).edR.HF()).fgd.hPT;
                paramString = com.tencent.mm.i.a.eI(paramString);
                if (paramString != null) {
                  this.frV.setText(paramString.desc);
                }
                this.fsa.clear();
                if ((paramm != null) && (paramm.size() > 0))
                {
                  if (paramm.size() > 3) {}
                  for (paramInt1 = 3;; paramInt1 = paramm.size())
                  {
                    paramString = new String[paramInt1];
                    paramInt2 = 0;
                    while (paramInt2 < paramInt1)
                    {
                      paramString[paramInt2] = ((bml)paramm.get(paramInt2)).tFO;
                      this.fsa.add(paramString[paramInt2]);
                      paramInt2 += 1;
                    }
                  }
                  if (this.fsl)
                  {
                    if (this.fsj != null)
                    {
                      this.fsj.dismiss();
                      this.fsj = null;
                    }
                    this.fsj = p.a(this, this.fsk, paramString, new RegSetInfoUI.18(this, paramString));
                  }
                }
                n(true, true);
                return;
              }
              if (bk.bl(this.frO.getText().toString().trim()))
              {
                n(false, false);
                return;
              }
              n(true, false);
              this.frV.setText(getString(q.j.regsetinfo_tip));
              if (this.fsj != null)
              {
                this.fsj.dismiss();
                this.fsj = null;
              }
              this.frO.postDelayed(new RegSetInfoUI.14(this), 50L);
              return;
            }
            if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
            {
              if (this.fex == null)
              {
                this.fex = SecurityImage.a.a(this.mController.uMN, q.j.regbyqq_secimg_title, 0, ((ad)paramm).QA(), ((ad)paramm).Qz(), "", new RegSetInfoUI.15(this, paramm), null, new RegSetInfoUI.16(this), new RegSetInfoUI.17(this, paramm));
                return;
              }
              this.fex.a(0, ((ad)paramm).QA(), ((ad)paramm).Qz(), "");
              return;
            }
            n(true, true);
          }
        } while (h(paramInt1, paramInt2, paramString));
        if (paramInt1 == 8)
        {
          this.fsh = getString(q.j.fmt_http_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          Toast.makeText(this, this.fsh, 0).show();
          return;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      Toast.makeText(this, getString(q.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      label1546:
      continue;
      label1549:
      localObject1 = null;
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */