package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements f
{
  private String blZ;
  private int countDown;
  private String crs;
  private String gCO;
  private bj gDn;
  private String gFA;
  private String gFE;
  private g gFw;
  private int gGt;
  private int gGv;
  private boolean gHQ;
  private String gHo;
  private String gIm;
  private String gIn;
  private ProgressDialog gIo;
  private int gIp;
  private Button gIq;
  private Button gIr;
  private ap gIs;
  private SecurityImage gIt;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(125413);
    this.gIm = "";
    this.gCO = "";
    this.gIn = "";
    this.gFA = "";
    this.countDown = 15;
    this.gDn = new bj();
    AppMethodBeat.o(125413);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(125421);
    h.a(this, getString(2131302429), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(125405);
        RegByMobileSendSmsUI.t(RegByMobileSendSmsUI.this);
        RegByMobileSendSmsUI.this.finish();
        AppMethodBeat.o(125405);
      }
    }, null);
    AppMethodBeat.o(125421);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(125420);
    if (this.gIs != null) {
      this.gIs.stopTimer();
    }
    this.gIr.setText(2131302427);
    this.gIr.setEnabled(true);
    AppMethodBeat.o(125420);
  }
  
  private k xz(String paramString)
  {
    AppMethodBeat.i(125416);
    k localk = new k(paramString);
    ab.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localk.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131427761)), i, paramString.length(), 33);
    localk.setSpan(new ForegroundColorSpan(getResources().getColor(2131690139)), i, paramString.length(), 33);
    AppMethodBeat.o(125416);
    return localk;
  }
  
  public int getLayoutId()
  {
    return 2130970557;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125415);
    super.initView();
    ((TextView)findViewById(2131827150)).setText(getString(2131302433, new Object[] { this.gIm }));
    ((TextView)findViewById(2131827151)).setText(xz(getString(2131302432, new Object[] { this.gCO })));
    ((TextView)findViewById(2131827152)).setText(xz(getString(2131302435, new Object[] { this.gIn })));
    this.gIq = ((Button)findViewById(2131827154));
    this.gIr = ((Button)findViewById(2131827155));
    if (bo.Q(new String[] { this.gIm, this.gIn, this.gCO }))
    {
      this.gIq.setEnabled(false);
      this.gIr.setEnabled(false);
      if (!bo.isNullOrNil(q.getSimCountryIso())) {
        break label248;
      }
      this.gIq.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131302434);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      AppMethodBeat.o(125415);
      return;
      this.gIr.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label248:
      this.gIq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125406);
          paramAnonymousView = new Intent();
          paramAnonymousView.setAction("android.intent.action.SENDTO");
          paramAnonymousView.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(RegByMobileSendSmsUI.this)));
          paramAnonymousView.putExtra("sms_body", RegByMobileSendSmsUI.c(RegByMobileSendSmsUI.this));
          try
          {
            RegByMobileSendSmsUI.this.startActivity(paramAnonymousView);
            RegByMobileSendSmsUI.this.overridePendingTransition(2131034266, 2131034263);
            AppMethodBeat.o(125406);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            ab.e("MicroMsg.RegByMobileSendSmsUI", paramAnonymousView.getMessage());
            AppMethodBeat.o(125406);
          }
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125414);
    super.onCreate(paramBundle);
    this.gGt = getIntent().getIntExtra("key_reg_style", 1);
    this.gIm = bo.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.gIn = bo.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.gCO = bo.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.gFA = bo.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.gHo = bo.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.blZ = bo.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.gFE = bo.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.gHQ = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.gGv = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(125414);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125422);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(125422);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125422);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125417);
    super.onResume();
    com.tencent.mm.kernel.g.Rc().a(145, this);
    AppMethodBeat.o(125417);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125419);
    ab.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.gIo != null) {
      this.gIo.dismiss();
    }
    if ((paramm.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramm).Ac() == 15))
    {
      paramm = (com.tencent.mm.modelfriend.a)paramm;
      this.crs = paramm.agx();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.gGt == 1)
        {
          com.tencent.mm.kernel.g.Rc().a(126, this);
          paramString = new u("", this.gFE, this.blZ, 0, "", this.gIm, "", "", this.crs, 1, "", "", "", true, this.gHQ);
          paramString.uq(this.gFA);
          paramString.ur(this.gHo);
          paramString.lU(1);
          com.tencent.mm.kernel.g.Rc().a(paramString, 0);
          getString(2131297087);
          this.gIo = h.b(this, getString(2131302482), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(125408);
              com.tencent.mm.kernel.g.Rc().a(paramString);
              com.tencent.mm.kernel.g.Rc().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(125408);
            }
          });
          AppMethodBeat.o(125419);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.crs);
        paramString.putExtra("regsetinfo_user", this.gIm);
        paramString.putExtra("regsession_id", this.gFA);
        paramString.putExtra("reg_3d_app_ticket", this.gHo);
        paramString.putExtra("reg_3d_app_type", this.gGv);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramm.agD());
        paramString.putExtra("key_reg_style", this.gGt);
        paramString.setClass(this, RegSetInfoUI.class);
        startActivity(paramString);
        AppMethodBeat.o(125419);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.kO(paramString);
        this.gDn.cXw = this.gGv;
        this.gDn.cRH = 7L;
        this.gDn.ake();
        if (paramString != null)
        {
          paramString.a(this, new RegByMobileSendSmsUI.12(this, paramm), new RegByMobileSendSmsUI.13(this));
          AppMethodBeat.o(125419);
          return;
        }
        h.a(this, getString(2131297552), null, new RegByMobileSendSmsUI.14(this, paramm), new RegByMobileSendSmsUI.15(this));
        AppMethodBeat.o(125419);
        return;
      }
      if (paramInt2 == -212)
      {
        stopTimer();
        paramString = new Intent(this, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", this.crs);
        paramString.putExtra("moble", this.gIm);
        paramString.putExtra("regsession_id", this.gFA);
        paramString.putExtra("reg_3d_app_ticket", this.gHo);
        paramString.putExtra("reg_3d_app_type", this.gGv);
        paramString.putExtra("next_controll", paramm.agD());
        paramString.putExtra("username", paramm.getUsername());
        paramString.putExtra("password", paramm.agw());
        paramString.putExtra("nickname", paramm.agJ());
        paramString.putExtra("avatar_url", paramm.agI());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.gHQ);
        paramString.putExtra("kintent_nickname", this.blZ);
        paramString.putExtra("kintent_password", this.gFE);
        paramString.putExtra("key_reg_style", this.gGt);
        startActivity(paramString);
        AppMethodBeat.o(125419);
        return;
      }
      if ((!bo.isNullOrNil(paramString)) && (this.gIp >= 4))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(125419);
          return;
        }
      }
      AppMethodBeat.o(125419);
      return;
    }
    if (paramm.getType() == 126)
    {
      u localu = (u)paramm;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.gIt == null)
        {
          this.gIt = SecurityImage.a.a(this, 0, localu.ajH(), localu.ajG(), "", new RegByMobileSendSmsUI.16(this, localu), null, new RegByMobileSendSmsUI.2(this), new RegByMobileSendSmsUI.3(this, localu));
          AppMethodBeat.o(125419);
          return;
        }
        this.gIt.b(0, ((u)paramm).ajH(), ((u)paramm).ajG(), "");
        AppMethodBeat.o(125419);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.gIm;
        this.gDn.cXw = this.gGv;
        this.gDn.cRH = 6L;
        this.gDn.ake();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.cv(true);
        if (this.gHQ)
        {
          paramm = com.tencent.mm.compatible.util.e.esy + "temp.avatar";
          String str = com.tencent.mm.compatible.util.e.esy + "temp.avatar.hd";
          com.tencent.mm.vfs.e.aT(paramm, str);
          com.tencent.mm.vfs.e.deleteFile(paramm);
          d.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, paramm);
          new com.tencent.mm.ah.m(this, com.tencent.mm.compatible.util.e.esy + "temp.avatar").a(new RegByMobileSendSmsUI.4(this, localu, paramString), new RegByMobileSendSmsUI.5(this, localu, paramString));
          AppMethodBeat.o(125419);
          return;
        }
        this.crs = localu.ajQ();
        av.flM.ao("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        startActivity(paramString);
        finish();
        com.tencent.mm.plugin.b.a.xD("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.RJ();
        paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_600") + ",4");
        AppMethodBeat.o(125419);
        return;
      }
      paramString = com.tencent.mm.h.a.kO(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(125419);
        return;
      }
    }
    AppMethodBeat.o(125419);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(125418);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.g.Rc().b(145, this);
    AppMethodBeat.o(125418);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */