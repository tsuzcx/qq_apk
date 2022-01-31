package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private String cJr;
  private String crs;
  private String czF;
  protected ProgressDialog eeN;
  private ImageView egq;
  private TextView egr;
  private int fPQ;
  private com.tencent.mm.sdk.b.c gCZ;
  private f gDU;
  private bj gDn;
  private com.tencent.mm.platformtools.c gEe;
  private String gFA;
  private g gFw;
  private Button gGg;
  private Button gGh;
  private LinearLayout gGi;
  private LinearLayout gGj;
  private int gGk;
  private String gGl;
  private String gGm;
  private int gGn;
  private String gGo;
  private boolean gGp;
  private boolean gGq;
  private String gGr;
  private String gGs;
  private int gGt;
  private String gGu;
  private int gGv;
  private TextView gtP;
  private SecurityImage gwg;
  private ak handler;
  private String nickname;
  private String username;
  
  public MobileLoginOrForceReg()
  {
    AppMethodBeat.i(125222);
    this.eeN = null;
    this.gFw = null;
    this.gGp = true;
    this.handler = new MobileLoginOrForceReg.1(this);
    this.gwg = null;
    this.gDn = new bj();
    this.gCZ = new MobileLoginOrForceReg.12(this);
    this.gDU = null;
    AppMethodBeat.o(125222);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(125229);
    com.tencent.mm.plugin.b.a.xD("R200_100");
    if (this.gGt == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      startActivity((Intent)localObject);
      com.tencent.mm.plugin.b.a.xC(this.gGo);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_600") + ",2");
      finish();
      AppMethodBeat.o(125229);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970292;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125225);
    this.gGg = ((Button)findViewById(2131826313));
    this.gGh = ((Button)findViewById(2131826314));
    this.gGi = ((LinearLayout)findViewById(2131826312));
    this.gGj = ((LinearLayout)findViewById(2131826311));
    this.egq = ((ImageView)findViewById(2131821210));
    this.egr = ((TextView)findViewById(2131823254));
    this.gtP = ((TextView)findViewById(2131821808));
    new com.tencent.mm.sdk.platformtools.av();
    Object localObject;
    if (this.czF.startsWith("+"))
    {
      localObject = com.tencent.mm.sdk.platformtools.av.RC(this.czF);
      if (!bo.isNullOrNil((String)localObject))
      {
        String str = this.czF.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + com.tencent.mm.sdk.platformtools.av.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.gtP.setText((CharSequence)localObject);
      if ((!bo.isNullOrNil(this.nickname)) || (!bo.isNullOrNil(this.gGm))) {
        break;
      }
      this.gGj.setVisibility(0);
      this.gGi.setVisibility(8);
      this.gGg.setOnClickListener(new MobileLoginOrForceReg.14(this));
      this.gGh.setOnClickListener(new MobileLoginOrForceReg.15(this));
      setMMTitle(2131301584);
      setBackBtn(new MobileLoginOrForceReg.16(this));
      AppMethodBeat.o(125225);
      return;
      localObject = this.czF;
      continue;
      localObject = "+86 " + com.tencent.mm.sdk.platformtools.av.formatNumber("86", this.czF);
    }
    this.gGj.setVisibility(8);
    this.gGi.setVisibility(0);
    if (bo.isNullOrNil(this.nickname)) {
      this.egr.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.dmT().AY();
      if (localObject != null) {
        this.egq.setImageBitmap((Bitmap)localObject);
      }
      if (bo.isNullOrNil(this.gGm)) {
        break;
      }
      localObject = this.gGm;
      com.tencent.mm.kernel.g.RO().ac(new MobileLoginOrForceReg.13(this, (String)localObject));
      break;
      this.egr.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125223);
    super.onCreate(paramBundle);
    this.gGo = com.tencent.mm.plugin.b.a.awy();
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    com.tencent.mm.kernel.g.Rc().a(126, this);
    com.tencent.mm.kernel.g.Rc().a(255, this);
    this.gGt = getIntent().getIntExtra("key_reg_style", 1);
    this.crs = getIntent().getStringExtra("ticket");
    this.czF = getIntent().getStringExtra("moble");
    this.gGk = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.gGl = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.gGm = getIntent().getStringExtra("avatar_url");
    this.gFA = getIntent().getStringExtra("regsession_id");
    this.gGu = getIntent().getStringExtra("reg_3d_app_ticket");
    this.gGv = getIntent().getIntExtra("reg_3d_app_type", 0);
    this.gGn = getIntent().getIntExtra("mobile_check_type", 0);
    this.gGq = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.gGr = getIntent().getStringExtra("kintent_nickname");
    this.gGs = getIntent().getStringExtra("kintent_password");
    if ((this.gGs != null) && (this.gGs.length() >= 8)) {}
    for (this.fPQ = 1;; this.fPQ = 4)
    {
      initView();
      this.gEe = new com.tencent.mm.platformtools.c();
      AppMethodBeat.o(125223);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125228);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    com.tencent.mm.kernel.g.Rc().b(126, this);
    com.tencent.mm.kernel.g.Rc().b(255, this);
    if (this.gEe != null) {
      this.gEe.close();
    }
    super.onDestroy();
    AppMethodBeat.o(125228);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125230);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(125230);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125230);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125227);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    AppMethodBeat.o(125227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125226);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.xC("R200_600");
    AppMethodBeat.o(125226);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125231);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (this.gDU == null) {
      this.gDU = new f();
    }
    boolean bool;
    if (paramm.getType() == 255)
    {
      if ((paramInt2 == -3) && (paramInt1 == 4))
      {
        bool = this.gGp;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(2131303322));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      AppMethodBeat.o(125231);
      return;
    }
    if (((paramm.getType() == 252) || (paramm.getType() == 701)) && (this.gFw != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.gDU.account = this.username;
        this.gDU.gEK = this.gGs;
        this.gDU.gwj = ((s)paramm).ajG();
        this.gDU.gwi = ((s)paramm).ajH();
        this.gDU.gwk = ((s)paramm).ajI();
        this.gDU.gEL = ((s)paramm).getSecCodeType();
        if (this.gwg == null)
        {
          this.gwg = SecurityImage.a.a(this, this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new MobileLoginOrForceReg.17(this), null, new MobileLoginOrForceReg.18(this), this.gDU);
          AppMethodBeat.o(125231);
          return;
        }
        this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
        AppMethodBeat.o(125231);
        return;
      }
      this.cJr = ((s)paramm).ajF();
      this.gFw.a(this, paramInt1, paramInt2, paramString, paramm);
      if ((paramm instanceof s)) {
        this.gGp = ((s)paramm).ajP();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new t(1);
        com.tencent.mm.kernel.g.Rc().a(paramString, 0);
        getString(2131297087);
        this.eeN = h.b(this, getString(2131296987), true, new MobileLoginOrForceReg.19(this, paramString));
        if (!bo.isNullOrNil(this.gGu)) {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLR, Integer.valueOf(this.gGv));
        }
      }
      AppMethodBeat.o(125231);
      return;
    }
    Object localObject2;
    if (paramm.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.gGq);
        localObject1 = this.gGs;
        localObject2 = this.gGr;
        if (this.gwg == null)
        {
          this.gwg = SecurityImage.a.a(this, 0, ((u)paramm).ajH(), ((u)paramm).ajG(), "", new MobileLoginOrForceReg.2(this, (String)localObject1, (String)localObject2, paramm, paramString), null, new MobileLoginOrForceReg.3(this), new MobileLoginOrForceReg.4(this, (String)localObject1, (String)localObject2, paramm, paramString));
          AppMethodBeat.o(125231);
          return;
        }
        this.gwg.b(0, ((u)paramm).ajH(), ((u)paramm).ajG(), "");
        AppMethodBeat.o(125231);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.czF;
        bool = this.gGq;
        this.gDn.cXw = this.gGv;
        this.gDn.cRH = 6L;
        this.gDn.ake();
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.cv(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label904;
        }
        localObject2 = com.tencent.mm.compatible.util.e.esy + "temp.avatar";
        String str = com.tencent.mm.compatible.util.e.esy + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aT((String)localObject2, str);
        com.tencent.mm.vfs.e.deleteFile((String)localObject2);
        d.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.ah.m(this, com.tencent.mm.compatible.util.e.esy + "temp.avatar").a(new MobileLoginOrForceReg.5(this, paramm, (String)localObject1), new MobileLoginOrForceReg.6(this, paramm, (String)localObject1));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.kO(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.h.a)localObject1).a(this, null, null);
        AppMethodBeat.o(125231);
        return;
        label904:
        this.crs = ((u)paramm).ajQ();
        com.tencent.mm.model.av.flM.ao("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        startActivity((Intent)localObject1);
        finish();
        com.tencent.mm.plugin.b.a.xD("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.RJ();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_600") + ",4");
      }
    }
    Object localObject1 = new ag(paramInt1, paramInt2, paramString);
    int i;
    if (this.gEe.a(this, (ag)localObject1)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(125231);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -140: 
        if (!bo.isNullOrNil(this.cJr)) {
          com.tencent.mm.platformtools.z.o(getContext(), paramString, this.cJr);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131297570, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131297567, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131297569, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131297572, 0).show();
        i = 1;
        break;
      case -32: 
        h.a(this, getString(2131297617), "", new MobileLoginOrForceReg.7(this));
        i = 1;
        break;
      case -33: 
        h.a(this, 2131297615, 2131297621, new MobileLoginOrForceReg.8(this));
        i = 1;
        break;
      case -75: 
        h.h(this, 2131296532, 2131302378);
        i = 1;
        break;
      case -100: 
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.kernel.a.hold();
        localObject2 = getContext();
        com.tencent.mm.kernel.g.RJ();
        if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
        for (localObject1 = com.tencent.mm.cb.a.aq(getContext(), 2131301416);; localObject1 = com.tencent.mm.kernel.a.QD())
        {
          h.a((Context)localObject2, (String)localObject1, getContext().getString(2131297087), new MobileLoginOrForceReg.9(this), new MobileLoginOrForceReg.10(this));
          i = 1;
          break;
          com.tencent.mm.kernel.g.RJ();
        }
      }
    }
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString != null) && (paramString.a(getContext(), null, null)))
      {
        AppMethodBeat.o(125231);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(getContext(), getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(125231);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */