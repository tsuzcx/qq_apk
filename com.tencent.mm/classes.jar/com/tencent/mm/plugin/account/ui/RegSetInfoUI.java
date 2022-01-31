package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.t.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.vfs.b;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements f
{
  private String blZ;
  private ProgressDialog eeN;
  private String eiu;
  private bj gDn;
  private c gEe;
  private String gFA;
  private int gGn;
  private int gGt;
  private int gGv;
  private boolean gHQ;
  private String gHo;
  private EditText gIy;
  private ImageView gJA;
  private int gJB;
  private LinkedList<String> gJC;
  private ImageView gJD;
  private ProgressBar gJE;
  private String gJF;
  private ImageView gJG;
  private View gJH;
  private TextView gJI;
  private String gJJ;
  private boolean gJK;
  private o gJL;
  private View gJM;
  private boolean gJN;
  private String gJO;
  private ap gJP;
  private EditText gJq;
  private Button gJr;
  private String gJs;
  private String gJt;
  private int gJu;
  private String gJv;
  private String gJw;
  private TextView gJx;
  private View gJy;
  private boolean gJz;
  private SecurityImage gwg;
  private int sceneType;
  
  public RegSetInfoUI()
  {
    AppMethodBeat.i(125540);
    this.eeN = null;
    this.sceneType = 0;
    this.gwg = null;
    this.gJz = false;
    this.gHQ = false;
    this.gJB = 3;
    this.gJC = new LinkedList();
    this.gJF = "";
    this.gJJ = null;
    this.gJK = false;
    this.gJN = false;
    this.gDn = new bj();
    this.gJP = new ap(Looper.myLooper(), new RegSetInfoUI.1(this), true);
    AppMethodBeat.o(125540);
  }
  
  private void apB()
  {
    AppMethodBeat.i(125555);
    hideVKB();
    if (arX())
    {
      h.a(this, getString(2131302494), "", new RegSetInfoUI.21(this), new RegSetInfoUI.22(this));
      AppMethodBeat.o(125555);
      return;
    }
    if (!arY())
    {
      if (arZ())
      {
        h.a(this, getString(2131302493), "", new RegSetInfoUI.24(this), new RegSetInfoUI.25(this));
        AppMethodBeat.o(125555);
        return;
      }
      if (asb())
      {
        h.a(this, getString(2131302493), "", new RegSetInfoUI.26(this), new RegSetInfoUI.27(this));
        AppMethodBeat.o(125555);
        return;
      }
      com.tencent.mm.plugin.b.a.xD("R200_100");
      Intent localIntent = new Intent(this, MobileInputUI.class);
      localIntent.putExtra("mobile_input_purpose", 2);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
    }
    AppMethodBeat.o(125555);
  }
  
  private void arS()
  {
    AppMethodBeat.i(125545);
    int j = asc();
    g.Rc().a(126, this);
    int i;
    u localu;
    if (arW()) {
      if ((this.gJC == null) || (this.gJC.size() == 0))
      {
        i = 0;
        localu = new u("", this.gJv, this.blZ, this.gJu, this.gJt, this.gJs, "", "", this.eiu, j, this.gJO, "", "", this.gJz, this.gHQ);
        ((v.a)localu.ftU.getReqObj()).wiO.xvg = i;
      }
    }
    for (;;)
    {
      localu.uq(this.gFA);
      localu.ur(this.gHo);
      localu.lU(this.gGn);
      g.Rc().a(localu, 0);
      getString(2131297087);
      this.eeN = h.b(this, getString(2131302482), true, new RegSetInfoUI.7(this, localu));
      AppMethodBeat.o(125545);
      return;
      if (this.gJC.contains(this.gJO))
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      localu = new u("", this.gJv, this.blZ, this.gJu, this.gJt, this.gJs, "", "", this.eiu, j, "", "", "", this.gJz, this.gHQ);
    }
  }
  
  private boolean arT()
  {
    AppMethodBeat.i(125547);
    if ((this.gJD.getVisibility() == 8) || (this.gJK))
    {
      AppMethodBeat.o(125547);
      return true;
    }
    AppMethodBeat.o(125547);
    return false;
  }
  
  private void arU()
  {
    AppMethodBeat.i(125548);
    String str = this.gIy.getText().toString().trim();
    Button localButton = this.gJr;
    if (!bo.isNullOrNil(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      AppMethodBeat.o(125548);
      return;
    }
  }
  
  private boolean arV()
  {
    return (this.gJB & 0x1) > 0;
  }
  
  private boolean arW()
  {
    return (this.gJB & 0x2) > 0;
  }
  
  private boolean arX()
  {
    return this.sceneType == 1;
  }
  
  private boolean arY()
  {
    return this.sceneType == 2;
  }
  
  private boolean arZ()
  {
    return this.sceneType == 0;
  }
  
  private boolean asa()
  {
    return this.sceneType == 4;
  }
  
  private boolean asb()
  {
    return this.sceneType == 3;
  }
  
  private int asc()
  {
    AppMethodBeat.i(125550);
    if (arX())
    {
      AppMethodBeat.o(125550);
      return 4;
    }
    if (arY())
    {
      AppMethodBeat.o(125550);
      return 2;
    }
    if (asb())
    {
      AppMethodBeat.o(125550);
      return 6;
    }
    if (asa())
    {
      AppMethodBeat.o(125550);
      return 1;
    }
    AppMethodBeat.o(125550);
    return 2;
  }
  
  private String asd()
  {
    AppMethodBeat.i(125551);
    if ((arX()) || (asa()))
    {
      str = this.gJs;
      AppMethodBeat.o(125551);
      return str;
    }
    if (asb())
    {
      str = this.gJt;
      AppMethodBeat.o(125551);
      return str;
    }
    String str = this.gJw;
    AppMethodBeat.o(125551);
    return str;
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125553);
    Object localObject = new ag(paramInt1, paramInt2, paramString);
    if (this.gEe.a(this, (ag)localObject))
    {
      AppMethodBeat.o(125553);
      return true;
    }
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125553);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(125553);
      return false;
    case -10: 
    case -7: 
      h.h(this, 2131302377, 2131302378);
      AppMethodBeat.o(125553);
      return true;
    case -75: 
      h.h(this, 2131296532, 2131302378);
      AppMethodBeat.o(125553);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      localObject = getContext();
      g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (paramString = com.tencent.mm.cb.a.aq(getContext(), 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
      {
        h.a((Context)localObject, paramString, getContext().getString(2131297087), new RegSetInfoUI.19(this), new RegSetInfoUI.20(this));
        AppMethodBeat.o(125553);
        return true;
        g.RJ();
      }
    }
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      AppMethodBeat.o(125553);
      return true;
      h.b(this, getString(2131302500), "", true);
    }
  }
  
  private void o(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(125546);
    if (bo.isNullOrNil(this.gJq.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.gJD;
    if (paramBoolean2)
    {
      i = 2130840351;
      localImageView.setImageResource(i);
      localImageView = this.gJD;
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
      this.gJK = bool1;
      AppMethodBeat.o(125546);
      return;
      i = 2130840348;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970561;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(125544);
    this.gJM = findViewById(2131827172);
    this.gJH = findViewById(2131827141);
    this.gJA = ((ImageView)findViewById(2131827142));
    this.gIy = ((EditText)findViewById(2131827171));
    this.gJI = ((TextView)findViewById(2131827170));
    this.gJq = ((EditText)findViewById(2131827174));
    this.gJx = ((TextView)findViewById(2131827176));
    this.gJy = findViewById(2131827173);
    this.gJD = ((ImageView)findViewById(2131827175));
    this.gJE = ((ProgressBar)findViewById(2131827109));
    this.gJG = ((ImageView)findViewById(2131827143));
    this.gJr = ((Button)findViewById(2131822914));
    this.gJD.setVisibility(8);
    this.gJE.setVisibility(8);
    this.gJG.setVisibility(8);
    this.gHQ = false;
    this.gJK = false;
    Object localObject = this.gJH;
    int i;
    if (arV())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.gJy;
      if (!arW()) {
        break label491;
      }
      i = 0;
      label237:
      ((View)localObject).setVisibility(i);
      localObject = this.gJx;
      if (!arW()) {
        break label497;
      }
      i = j;
      label256:
      ((TextView)localObject).setVisibility(i);
      if ((!arV()) || (!arW())) {
        break label503;
      }
      this.gJI.setText(getString(2131302499));
    }
    for (;;)
    {
      g.RO().a(new RegSetInfoUI.23(this));
      this.gIy.addTextChangedListener(new RegSetInfoUI.28(this));
      this.gJr.setOnClickListener(new RegSetInfoUI.29(this));
      this.gJq.setOnFocusChangeListener(new RegSetInfoUI.30(this));
      this.gJq.addTextChangedListener(new RegSetInfoUI.31(this));
      setBackBtn(new RegSetInfoUI.32(this));
      this.gIy.setOnEditorActionListener(new RegSetInfoUI.33(this));
      this.gIy.setOnKeyListener(new RegSetInfoUI.2(this));
      this.gJq.setOnEditorActionListener(new RegSetInfoUI.3(this));
      this.gJq.setOnKeyListener(new RegSetInfoUI.4(this));
      this.gJA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125511);
          RegSetInfoUI.x(RegSetInfoUI.this);
          AppMethodBeat.o(125511);
        }
      });
      localObject = new b(com.tencent.mm.compatible.util.e.esy);
      if (!((b)localObject).exists()) {
        ((b)localObject).mkdirs();
      }
      arU();
      AppMethodBeat.o(125544);
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
      if ((arV()) && (!arW())) {
        this.gJI.setText(getString(2131302497));
      } else if ((!arV()) && (arW())) {
        this.gJI.setText(getString(2131302498));
      } else {
        this.gJI.setText(getString(2131302496));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125549);
    ab.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramIntent != null) && (paramInt1 == 300))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
        arS();
      }
      AppMethodBeat.o(125549);
      return;
    }
    paramIntent = com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.gJA.setImageBitmap(paramIntent);
      this.gHQ = true;
      this.gJG.setVisibility(0);
    }
    AppMethodBeat.o(125549);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125541);
    super.onCreate(paramBundle);
    paramBundle = getString(2131302502);
    if (com.tencent.mm.protocal.d.whK) {
      paramBundle = getString(2131297005) + getString(2131296529);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.gJs = getIntent().getStringExtra("regsetinfo_user");
    this.gJt = getIntent().getStringExtra("regsetinfo_bind_email");
    this.eiu = getIntent().getStringExtra("regsetinfo_ticket");
    this.gJv = getIntent().getStringExtra("regsetinfo_pwd");
    this.gJw = getIntent().getStringExtra("regsetinfo_binduin");
    this.gGn = getIntent().getIntExtra("mobile_check_type", 0);
    if (!bo.isNullOrNil(this.gJw)) {
      this.gJu = com.tencent.mm.a.p.cU(this.gJw);
    }
    this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.gJz = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.gJB = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    this.gFA = getIntent().getStringExtra("regsession_id");
    this.gHo = getIntent().getStringExtra("reg_3d_app_ticket");
    this.gGv = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.gGt = getIntent().getIntExtra("key_reg_style", 1);
    initView();
    if (this.sceneType == 1)
    {
      paramBundle = new StringBuilder();
      g.RJ();
      paramBundle = paramBundle.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_900_phone") + ",1");
      com.tencent.mm.plugin.b.a.xC("R200_900_phone");
    }
    for (;;)
    {
      this.gJN = false;
      this.gEe = new c();
      AppMethodBeat.o(125541);
      return;
      if (this.sceneType == 2)
      {
        paramBundle = new StringBuilder();
        g.RJ();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R4_QQ") + ",1");
        com.tencent.mm.plugin.b.a.xC("R4_QQ");
      }
      else if (this.sceneType == 3)
      {
        paramBundle = new StringBuilder();
        g.RJ();
        paramBundle = paramBundle.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_900_email") + ",1");
        com.tencent.mm.plugin.b.a.xC("R200_900_email");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125543);
    super.onDestroy();
    StringBuilder localStringBuilder;
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_phone,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.gEe != null) {
        this.gEe.close();
      }
      AppMethodBeat.o(125543);
      return;
      if (this.sceneType == 2)
      {
        localStringBuilder = new StringBuilder();
        g.RJ();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R4_QQ,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R4_QQ") + ",2");
      }
      else if (this.sceneType == 3)
      {
        localStringBuilder = new StringBuilder();
        g.RJ();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_email,");
        g.RJ();
        com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125554);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(125554);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125554);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125542);
    super.onResume();
    this.gIy.postDelayed(new RegSetInfoUI.12(this), 500L);
    AppMethodBeat.o(125542);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125552);
    ab.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
      g.Rc().b(126, this);
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gDn.cXw = this.gGv;
        this.gDn.cRH = 6L;
        this.gDn.ake();
        this.gJJ = null;
        str2 = asd();
        str1 = ((u)paramm).ajS();
        i = ((u)paramm).ajT();
        str3 = ((u)paramm).ajU();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = br.F(str3, "wording");
        if (localMap == null) {
          break label1647;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bo.isNullOrNil((String)localObject3)) {
          break label564;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1647;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bo.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bo.isNullOrNil((String)localObject3)) {
          break label1644;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ab.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.cv(true);
      if (this.gHQ)
      {
        localObject3 = com.tencent.mm.compatible.util.e.esy + "temp.avatar";
        str3 = com.tencent.mm.compatible.util.e.esy + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aT((String)localObject3, str3);
        com.tencent.mm.vfs.e.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.d.c(str3, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ah.m(this, com.tencent.mm.compatible.util.e.esy + "temp.avatar").a(new RegSetInfoUI.8(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, i), new RegSetInfoUI.9(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, i));
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.gwg == null)
          {
            this.gwg = SecurityImage.a.a(getContext(), 0, ((u)paramm).ajH(), ((u)paramm).ajG(), "", new RegSetInfoUI.10(this, paramm), null, new RegSetInfoUI.11(this), new RegSetInfoUI.13(this, paramm));
            AppMethodBeat.o(125552);
            return;
            label564:
            int j = bo.apV((String)localObject3);
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
            this.eiu = ((u)paramm).ajQ();
            av.flM.ao("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.xD("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.eiu);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
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
            localObject1 = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            startActivity((Intent)localObject1);
            localObject1 = new StringBuilder();
            g.RJ();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.RJ();
            com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.gwg.b(0, ((u)paramm).ajH(), ((u)paramm).ajG(), "");
          AppMethodBeat.o(125552);
          return;
        }
      }
      localObject1 = com.tencent.mm.h.a.kO(paramString);
      if (localObject1 != null)
      {
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(125552);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125552);
        return;
      }
      if (paramm.getType() == 429)
      {
        g.Rc().b(429, this);
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        this.gJE.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.gJJ = null;
          paramInt1 = ((t.b)((ad)paramm).ftU.getRespObj()).gxL.xfM;
          ab.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramm = ((t.b)((ad)paramm).ftU.getRespObj()).gxL.jJv;
            paramString = com.tencent.mm.h.a.kO(paramString);
            if (paramString != null) {
              this.gJx.setText(paramString.desc);
            }
            this.gJC.clear();
            if ((paramm != null) && (paramm.size() > 0))
            {
              if (paramm.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramm.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((bwc)paramm.get(paramInt2)).xJE;
                  this.gJC.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.gJN)
              {
                if (this.gJL != null)
                {
                  this.gJL.dismiss();
                  this.gJL = null;
                }
                this.gJL = p.a(this, this.gJM, paramString, new RegSetInfoUI.18(this, paramString));
              }
            }
            o(true, true);
            AppMethodBeat.o(125552);
            return;
          }
          if (bo.isNullOrNil(this.gJq.getText().toString().trim()))
          {
            o(false, false);
            AppMethodBeat.o(125552);
            return;
          }
          o(true, false);
          this.gJx.setText(getString(2131302501));
          if (this.gJL != null)
          {
            this.gJL.dismiss();
            this.gJL = null;
          }
          this.gJq.postDelayed(new RegSetInfoUI.14(this), 50L);
          AppMethodBeat.o(125552);
          return;
        }
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          if (this.gwg == null)
          {
            this.gwg = SecurityImage.a.a(getContext(), 0, ((ad)paramm).ajH(), ((ad)paramm).ajG(), "", new RegSetInfoUI.15(this, paramm), null, new DialogInterface.OnDismissListener()new RegSetInfoUI.17
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(125523);
                RegSetInfoUI.H(RegSetInfoUI.this);
                AppMethodBeat.o(125523);
              }
            }, new RegSetInfoUI.17(this, paramm));
            AppMethodBeat.o(125552);
            return;
          }
          this.gwg.b(0, ((ad)paramm).ajH(), ((ad)paramm).ajG(), "");
          AppMethodBeat.o(125552);
          return;
        }
        o(true, true);
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125552);
        return;
      }
      if (paramInt1 == 8)
      {
        this.gJJ = getString(2131300043, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.gJJ, 0).show();
        AppMethodBeat.o(125552);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(2131300088, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(125552);
      return;
      label1644:
      continue;
      label1647:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI
 * JD-Core Version:    0.7.0.1
 */