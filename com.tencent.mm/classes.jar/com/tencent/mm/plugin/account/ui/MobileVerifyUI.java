package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;

public class MobileVerifyUI
  extends MMActivity
{
  String blZ;
  protected String czF;
  protected ProgressDialog eeN = null;
  int fPQ;
  private c gEe;
  protected String gFA;
  private int gFY;
  protected boolean gFc = false;
  protected MMFormInputView gGX;
  protected TextView gGY;
  protected TextView gGZ;
  String gGl;
  int gGt;
  protected int gGv;
  protected TextView gHa;
  protected Button gHb;
  protected ScrollView gHc;
  private long gHd = 0L;
  private boolean gHe = false;
  private String[] gHf;
  private boolean gHg = false;
  Boolean gHh;
  private int gHi = 30;
  protected boolean gHj = false;
  protected boolean gHk = false;
  protected int gHl = -1;
  private MobileVerifyUI.b gHm;
  String gHn;
  protected String gHo;
  protected EditText gtO;
  protected TextView gtP;
  String guI;
  SecurityImage gwg = null;
  private Timer mTimer;
  
  private void arF()
  {
    AppMethodBeat.i(125286);
    if (!this.gHe)
    {
      this.mTimer = new Timer();
      this.gHe = true;
      this.gHd = this.gHi;
      MobileVerifyUI.1 local1 = new MobileVerifyUI.1(this);
      this.mTimer.schedule(local1, 1000L, 1000L);
    }
    AppMethodBeat.o(125286);
  }
  
  private void arG()
  {
    AppMethodBeat.i(125289);
    hideVKB();
    if (this.gtO.getText().toString().trim().equals(""))
    {
      h.h(this, 2131297622, 2131297087);
      AppMethodBeat.o(125289);
      return;
    }
    this.gHm.a(MobileVerifyUI.a.gHw);
    AppMethodBeat.o(125289);
  }
  
  private void arH()
  {
    AppMethodBeat.i(125290);
    this.gHg = false;
    this.gGY.setEnabled(false);
    this.gGZ.setVisibility(0);
    this.gGZ.setText(getResources().getQuantityString(2131361811, this.gHi, new Object[] { Integer.valueOf(this.gHi) }));
    this.gGY.setVisibility(8);
    arF();
    this.gHm.a(MobileVerifyUI.a.gHx);
    h.bO(this, getString(2131301576));
    AppMethodBeat.o(125290);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(125292);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    if (!this.gHm.a(MobileVerifyUI.a.gHv))
    {
      finish();
      AppMethodBeat.o(125292);
      return;
    }
    AppMethodBeat.o(125292);
  }
  
  protected final void dC(boolean paramBoolean)
  {
    AppMethodBeat.i(125295);
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(2131303322));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(125295);
  }
  
  public int getLayoutId()
  {
    return 2130970293;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125288);
    ab.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.czF);
    this.gGX = ((MMFormInputView)findViewById(2131821810));
    this.gGX.setImeOption(5);
    this.gGX.setInputType(3);
    this.gtO = this.gGX.getContentEditText();
    this.gGY = ((TextView)findViewById(2131826316));
    this.gGZ = ((TextView)findViewById(2131826317));
    this.gtP = ((TextView)findViewById(2131821808));
    this.gtP.setText(this.czF);
    this.czF = av.apy(this.czF);
    this.gGY.setText(getString(2131301601));
    this.gHa = ((TextView)findViewById(2131826315));
    this.gHb = ((Button)findViewById(2131822914));
    this.gHc = ((ScrollView)findViewById(2131820743));
    this.gHf = getResources().getStringArray(2131755059);
    Object localObject = getString(2131302424);
    this.gHa.setText(Html.fromHtml((String)localObject));
    localObject = new MobileVerifyUI.5(this);
    this.gGZ.setVisibility(0);
    this.gGZ.setText(getResources().getQuantityString(2131361811, this.gHi, new Object[] { Integer.valueOf(this.gHi) }));
    arF();
    this.gHg = false;
    this.gtO.setFilters(new InputFilter[] { localObject });
    this.gtO.addTextChangedListener(new MMEditText.c(this.gtO, null, 12));
    this.gHb.setOnClickListener(new MobileVerifyUI.6(this));
    this.gHb.setEnabled(false);
    this.gtO.setTextSize(15.0F);
    this.gtO.addTextChangedListener(new MobileVerifyUI.7(this));
    this.gGY.setOnClickListener(new MobileVerifyUI.8(this));
    this.gGY.setEnabled(false);
    setBackBtn(new MobileVerifyUI.9(this));
    this.gtO.setOnEditorActionListener(new MobileVerifyUI.10(this));
    this.gtO.setOnKeyListener(new MobileVerifyUI.11(this));
    AppMethodBeat.o(125288);
  }
  
  protected final boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125294);
    Object localObject = com.tencent.mm.h.a.kO(paramString);
    if (localObject != null)
    {
      ((com.tencent.mm.h.a)localObject).a(this, null, null);
      AppMethodBeat.o(125294);
      return true;
    }
    if (paramInt1 == 4) {}
    int i;
    switch (paramInt2)
    {
    default: 
      switch (paramInt2)
      {
      default: 
        i = 0;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(125294);
      return true;
      if (g.Rc().adt() == 5)
      {
        h.h(this, 2131301790, 2131301789);
        AppMethodBeat.o(125294);
        return true;
      }
      z.cA(this);
      AppMethodBeat.o(125294);
      return true;
      Toast.makeText(this, 2131297570, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131297567, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131297569, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131297572, 0).show();
      i = 1;
      continue;
      h.a(this, getString(2131297617), "", new MobileVerifyUI.12(this));
      i = 1;
      continue;
      h.a(this, 2131297615, 2131297621, new MobileVerifyUI.2(this));
      i = 1;
      continue;
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (localObject = com.tencent.mm.cb.a.aq(getContext(), 2131301416);; localObject = com.tencent.mm.kernel.a.QD())
      {
        h.a(localAppCompatActivity, (String)localObject, getContext().getString(2131297087), new MobileVerifyUI.3(this), new MobileVerifyUI.4(this));
        i = 1;
        break;
        g.RJ();
      }
    }
    paramString = new ag(paramInt1, paramInt2, paramString);
    if (this.gEe.a(this, paramString))
    {
      AppMethodBeat.o(125294);
      return true;
    }
    AppMethodBeat.o(125294);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125282);
    super.onCreate(paramBundle);
    this.gGt = getIntent().getIntExtra("key_reg_style", 1);
    this.gFY = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.gHn = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.gGl = getIntent().getStringExtra("kintent_password");
    this.blZ = getIntent().getStringExtra("kintent_nickname");
    this.gHh = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.gFc = getIntent().getBooleanExtra("from_deep_link", false);
    this.gFA = getIntent().getStringExtra("regsession_id");
    this.gHo = getIntent().getStringExtra("reg_3d_app_ticket");
    this.gGv = getIntent().getIntExtra("reg_3d_app_type", 0);
    switch (this.gFY)
    {
    default: 
      ab.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.gFY) });
      finish();
      AppMethodBeat.o(125282);
      return;
    case 2: 
      this.gHm = new o();
      if ((this.gGl != null) && (this.gGl.length() >= 8))
      {
        this.fPQ = 1;
        paramBundle = getString(2131297598);
        if (d.whK) {
          paramBundle = getString(2131297005) + getString(2131296529);
        }
        setMMTitle(paramBundle);
        this.gHi = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.gHj = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.gHk = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.czF = getIntent().getExtras().getString("bindmcontact_mobile");
        this.guI = com.tencent.mm.plugin.b.a.awy();
        initView();
        this.gHm.a(this);
        if (this.gHn == null) {
          break label475;
        }
        this.gtO.setText(this.gHn);
        arG();
      }
      break;
    }
    for (;;)
    {
      this.gEe = new c();
      AppMethodBeat.o(125282);
      return;
      this.fPQ = 4;
      break;
      this.gHm = new m(this.gFY);
      break;
      this.gHm = new n();
      break;
      label475:
      if (this.gFY == 5) {
        this.gHm.a(MobileVerifyUI.a.gHx);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125283);
    if (this.gEe != null) {
      this.gEe.close();
    }
    super.onDestroy();
    AppMethodBeat.o(125283);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125291);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(125291);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125291);
    return bool;
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(125287);
    if (keyboardState() == 1)
    {
      this.gHc.scrollTo(0, this.gHc.getChildAt(0).getMeasuredHeight() - this.gHc.getMeasuredHeight());
      AppMethodBeat.o(125287);
      return;
    }
    this.gHc.scrollTo(0, 0);
    AppMethodBeat.o(125287);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125293);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      ab.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        arH();
      }
    }
    AppMethodBeat.o(125293);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125285);
    super.onPause();
    this.gHm.stop();
    AppMethodBeat.o(125285);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125284);
    super.onResume();
    this.gHm.start();
    AppMethodBeat.o(125284);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */