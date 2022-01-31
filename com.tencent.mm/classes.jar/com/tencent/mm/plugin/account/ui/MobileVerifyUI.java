package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
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
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText.c;
import java.util.Timer;

public class MobileVerifyUI
  extends MMActivity
{
  String aVr;
  protected String bSe;
  protected ProgressDialog dnm = null;
  int eAa;
  String fcX;
  protected EditText fcd;
  protected TextView fce;
  SecurityImage fex = null;
  private ContentResolver fiK;
  private String fiU;
  private String[] fiZ;
  private c fmK;
  protected boolean fnK = false;
  private int foE;
  String foR;
  int foZ;
  protected String fog;
  protected MMFormInputView fpB;
  protected TextView fpC;
  protected TextView fpD;
  protected TextView fpE;
  protected Button fpF;
  protected ScrollView fpG;
  private MobileVerifyUI.c fpH;
  private long fpI = 0L;
  private boolean fpJ = false;
  private boolean fpK = false;
  Boolean fpL;
  private int fpM = 30;
  protected boolean fpN = false;
  protected boolean fpO = false;
  protected int fpP = -1;
  private MobileVerifyUI.b fpQ;
  String fpR;
  private Timer mTimer;
  
  private void XW()
  {
    if (!this.fpJ)
    {
      this.mTimer = new Timer();
      this.fpJ = true;
      this.fpI = this.fpM;
      MobileVerifyUI.1 local1 = new MobileVerifyUI.1(this);
      this.mTimer.schedule(local1, 1000L, 1000L);
    }
  }
  
  private void XX()
  {
    XM();
    if (this.fcd.getText().toString().trim().equals(""))
    {
      h.h(this, q.j.bind_mcontact_verifynull, q.j.app_tip);
      return;
    }
    this.fpQ.a(MobileVerifyUI.a.fpZ);
  }
  
  private void XY()
  {
    this.fpK = false;
    this.fpC.setEnabled(false);
    this.fpD.setVisibility(0);
    this.fpD.setText(getResources().getQuantityString(q.h.mobileverify_send_code_tip, this.fpM, new Object[] { Integer.valueOf(this.fpM) }));
    this.fpC.setVisibility(8);
    XW();
    this.fpQ.a(MobileVerifyUI.a.fqa);
    h.bC(this, getString(q.j.mobile_code_sended));
  }
  
  /* Error */
  private void Xt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 219
    //   5: invokestatic 225	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   8: astore 8
    //   10: aload_0
    //   11: aload_0
    //   12: invokevirtual 229	com/tencent/mm/plugin/account/ui/MobileVerifyUI:getContentResolver	()Landroid/content/ContentResolver;
    //   15: putfield 231	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiK	Landroid/content/ContentResolver;
    //   18: ldc 233
    //   20: astore 6
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 235	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiZ	[Ljava/lang/String;
    //   29: arraylength
    //   30: if_icmpge +96 -> 126
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 235	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiZ	[Ljava/lang/String;
    //   38: arraylength
    //   39: iconst_1
    //   40: isub
    //   41: if_icmpne +46 -> 87
    //   44: new 237	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   51: aload 6
    //   53: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 244
    //   58: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 235	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiZ	[Ljava/lang/String;
    //   65: iload_1
    //   66: aaload
    //   67: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 246
    //   72: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 6
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: goto -60 -> 24
    //   87: new 237	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   94: aload 6
    //   96: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 249
    //   101: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 235	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiZ	[Ljava/lang/String;
    //   108: iload_1
    //   109: aaload
    //   110: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 251
    //   115: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: astore 6
    //   123: goto -43 -> 80
    //   126: new 237	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   133: aload 6
    //   135: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 253
    //   140: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   146: ldc2_w 260
    //   149: lsub
    //   150: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc_w 266
    //   156: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore 6
    //   164: ldc_w 268
    //   167: new 237	java/lang/StringBuilder
    //   170: dup
    //   171: ldc_w 270
    //   174: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload 6
    //   179: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 279	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 6
    //   190: ifnull +13 -> 203
    //   193: aload 6
    //   195: ldc 130
    //   197: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq +4 -> 204
    //   203: return
    //   204: aload_0
    //   205: getfield 231	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiK	Landroid/content/ContentResolver;
    //   208: aload 8
    //   210: iconst_3
    //   211: anewarray 125	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 281
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: ldc_w 283
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: ldc_w 285
    //   231: aastore
    //   232: aload 6
    //   234: aconst_null
    //   235: aconst_null
    //   236: invokevirtual 291	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   239: astore 6
    //   241: aload 6
    //   243: ifnonnull +26 -> 269
    //   246: aload 6
    //   248: ifnull -45 -> 203
    //   251: aload 6
    //   253: invokeinterface 297 1 0
    //   258: ifne -55 -> 203
    //   261: aload 6
    //   263: invokeinterface 300 1 0
    //   268: return
    //   269: iconst_m1
    //   270: istore_1
    //   271: lconst_0
    //   272: lstore_2
    //   273: aload 6
    //   275: invokeinterface 303 1 0
    //   280: ifeq +34 -> 314
    //   283: aload 6
    //   285: iconst_2
    //   286: invokeinterface 307 2 0
    //   291: lstore 4
    //   293: lload 4
    //   295: lload_2
    //   296: lcmp
    //   297: ifle +275 -> 572
    //   300: aload 6
    //   302: invokeinterface 311 1 0
    //   307: istore_1
    //   308: lload 4
    //   310: lstore_2
    //   311: goto +261 -> 572
    //   314: aload_0
    //   315: aconst_null
    //   316: putfield 313	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiU	Ljava/lang/String;
    //   319: iload_1
    //   320: iflt +145 -> 465
    //   323: aload 6
    //   325: iload_1
    //   326: invokeinterface 317 2 0
    //   331: pop
    //   332: aload 6
    //   334: aload 6
    //   336: ldc_w 281
    //   339: invokeinterface 321 2 0
    //   344: invokeinterface 322 2 0
    //   349: astore 8
    //   351: ldc_w 324
    //   354: invokestatic 330	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   357: aload 8
    //   359: invokevirtual 334	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   362: astore 8
    //   364: aload 8
    //   366: invokevirtual 339	java/util/regex/Matcher:find	()Z
    //   369: ifeq +10 -> 379
    //   372: aload 8
    //   374: invokevirtual 342	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   377: astore 7
    //   379: aload_0
    //   380: aload 7
    //   382: putfield 313	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiU	Ljava/lang/String;
    //   385: aload_0
    //   386: getfield 75	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fpK	Z
    //   389: ifne +76 -> 465
    //   392: aload_0
    //   393: iconst_1
    //   394: putfield 75	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fpK	Z
    //   397: aload_0
    //   398: getfield 111	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fcd	Landroid/widget/EditText;
    //   401: aload_0
    //   402: getfield 313	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fiU	Ljava/lang/String;
    //   405: invokevirtual 343	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   408: aload_0
    //   409: invokevirtual 109	com/tencent/mm/plugin/account/ui/MobileVerifyUI:XM	()V
    //   412: aload_0
    //   413: getfield 111	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fcd	Landroid/widget/EditText;
    //   416: invokevirtual 117	android/widget/EditText:getText	()Landroid/text/Editable;
    //   419: invokevirtual 123	java/lang/Object:toString	()Ljava/lang/String;
    //   422: invokevirtual 128	java/lang/String:trim	()Ljava/lang/String;
    //   425: ldc 130
    //   427: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifne +35 -> 465
    //   433: aload_0
    //   434: getfield 69	com/tencent/mm/plugin/account/ui/MobileVerifyUI:dnm	Landroid/app/ProgressDialog;
    //   437: ifnull +15 -> 452
    //   440: aload_0
    //   441: getfield 69	com/tencent/mm/plugin/account/ui/MobileVerifyUI:dnm	Landroid/app/ProgressDialog;
    //   444: invokevirtual 348	android/app/ProgressDialog:dismiss	()V
    //   447: aload_0
    //   448: aconst_null
    //   449: putfield 69	com/tencent/mm/plugin/account/ui/MobileVerifyUI:dnm	Landroid/app/ProgressDialog;
    //   452: aload_0
    //   453: getfield 150	com/tencent/mm/plugin/account/ui/MobileVerifyUI:fpQ	Lcom/tencent/mm/plugin/account/ui/MobileVerifyUI$b;
    //   456: getstatic 351	com/tencent/mm/plugin/account/ui/MobileVerifyUI$a:fqb	Lcom/tencent/mm/plugin/account/ui/MobileVerifyUI$a;
    //   459: invokeinterface 158 2 0
    //   464: pop
    //   465: aload 6
    //   467: ifnull -264 -> 203
    //   470: aload 6
    //   472: invokeinterface 297 1 0
    //   477: ifne -274 -> 203
    //   480: aload 6
    //   482: invokeinterface 300 1 0
    //   487: return
    //   488: astore 7
    //   490: aconst_null
    //   491: astore 6
    //   493: ldc_w 268
    //   496: aload 7
    //   498: invokevirtual 352	java/lang/Exception:toString	()Ljava/lang/String;
    //   501: invokestatic 355	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 6
    //   506: ifnull -303 -> 203
    //   509: aload 6
    //   511: invokeinterface 297 1 0
    //   516: ifne -313 -> 203
    //   519: aload 6
    //   521: invokeinterface 300 1 0
    //   526: return
    //   527: astore 7
    //   529: aconst_null
    //   530: astore 6
    //   532: aload 6
    //   534: ifnull +20 -> 554
    //   537: aload 6
    //   539: invokeinterface 297 1 0
    //   544: ifne +10 -> 554
    //   547: aload 6
    //   549: invokeinterface 300 1 0
    //   554: aload 7
    //   556: athrow
    //   557: astore 7
    //   559: goto -27 -> 532
    //   562: astore 7
    //   564: goto -32 -> 532
    //   567: astore 7
    //   569: goto -76 -> 493
    //   572: goto -299 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	MobileVerifyUI
    //   23	303	1	i	int
    //   272	39	2	l1	long
    //   291	18	4	l2	long
    //   20	528	6	localObject1	Object
    //   1	380	7	str	String
    //   488	9	7	localException1	java.lang.Exception
    //   527	28	7	localObject2	Object
    //   557	1	7	localObject3	Object
    //   562	1	7	localObject4	Object
    //   567	1	7	localException2	java.lang.Exception
    //   8	365	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   204	241	488	java/lang/Exception
    //   204	241	527	finally
    //   273	293	557	finally
    //   300	308	557	finally
    //   314	319	557	finally
    //   323	364	557	finally
    //   364	379	557	finally
    //   379	452	557	finally
    //   452	465	557	finally
    //   493	504	562	finally
    //   273	293	567	java/lang/Exception
    //   300	308	567	java/lang/Exception
    //   314	319	567	java/lang/Exception
    //   323	364	567	java/lang/Exception
    //   364	379	567	java/lang/Exception
    //   379	452	567	java/lang/Exception
    //   452	465	567	java/lang/Exception
  }
  
  private void goBack()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    if (!this.fpQ.a(MobileVerifyUI.a.fpY)) {
      finish();
    }
  }
  
  protected final void cA(boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(q.j.settings_modify_password_tip));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
  }
  
  protected final int getLayoutId()
  {
    return q.g.mobile_verify_ui;
  }
  
  protected final boolean h(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = com.tencent.mm.i.a.eI(paramString);
    if (localObject != null)
    {
      ((com.tencent.mm.i.a)localObject).a(this, null, null);
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
      return true;
      if (g.Dk().KG() == 5)
      {
        h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
        return true;
      }
      z.bT(this);
      return true;
      Toast.makeText(this, q.j.bind_mcontact_err_freq_limit, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, q.j.bind_mcontact_err_binded, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, q.j.bind_mcontact_err_format, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, q.j.bind_mcontact_err_unbinded_notbinded, 0).show();
      i = 1;
      continue;
      h.a(this, getString(q.j.bind_mcontact_verify_error), "", new MobileVerifyUI.12(this));
      i = 1;
      continue;
      h.a(this, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip, new MobileVerifyUI.2(this));
      i = 1;
      continue;
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      g.DN();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
      for (localObject = com.tencent.mm.cb.a.ac(this.mController.uMN, q.j.main_err_another_place);; localObject = com.tencent.mm.kernel.a.CM())
      {
        h.a(localAppCompatActivity, (String)localObject, this.mController.uMN.getString(q.j.app_tip), new MobileVerifyUI.3(this), new MobileVerifyUI.4(this));
        i = 1;
        break;
        g.DN();
      }
    }
    paramString = new ag(paramInt1, paramInt2, paramString);
    return this.fmK.a(this, paramString);
  }
  
  protected final void initView()
  {
    y.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.bSe);
    this.fpB = ((MMFormInputView)findViewById(q.f.bind_mcontact_verify_num));
    this.fpB.setImeOption(5);
    this.fpB.setInputType(3);
    this.fcd = this.fpB.getContentEditText();
    this.fpC = ((TextView)findViewById(q.f.mobileverify_resend_bt));
    this.fpD = ((TextView)findViewById(q.f.mobileverify_counting_tv));
    this.fce = ((TextView)findViewById(q.f.bind_mcontact_verify_hint));
    this.fce.setText(this.bSe);
    this.bSe = ar.Zt(this.bSe);
    this.fpC.setText(getString(q.j.mobileverify_resend));
    this.fpE = ((TextView)findViewById(q.f.bind_mcontact_verify_tip));
    this.fpF = ((Button)findViewById(q.f.next_btn));
    this.fpG = ((ScrollView)findViewById(q.f.scroll));
    this.fiZ = getResources().getStringArray(q.b.sms_content);
    Object localObject = getString(q.j.regbymobile_reg_input_verify_tip);
    this.fpE.setText(Html.fromHtml((String)localObject));
    localObject = new MobileVerifyUI.5(this);
    this.fpD.setVisibility(0);
    this.fpD.setText(getResources().getQuantityString(q.h.mobileverify_send_code_tip, this.fpM, new Object[] { Integer.valueOf(this.fpM) }));
    XW();
    this.fpK = false;
    this.fcd.setFilters(new InputFilter[] { localObject });
    this.fcd.addTextChangedListener(new MMEditText.c(this.fcd, null, 12));
    this.fpF.setOnClickListener(new MobileVerifyUI.6(this));
    this.fpF.setEnabled(false);
    this.fcd.setTextSize(15.0F);
    this.fcd.addTextChangedListener(new MobileVerifyUI.7(this));
    this.fpC.setOnClickListener(new MobileVerifyUI.8(this));
    this.fpC.setEnabled(false);
    setBackBtn(new MobileVerifyUI.9(this));
    this.fcd.setOnEditorActionListener(new MobileVerifyUI.10(this));
    this.fcd.setOnKeyListener(new MobileVerifyUI.11(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.foZ = getIntent().getIntExtra("key_reg_style", 1);
    this.foE = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.fpR = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.foR = getIntent().getStringExtra("kintent_password");
    this.aVr = getIntent().getStringExtra("kintent_nickname");
    this.fpL = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.fnK = getIntent().getBooleanExtra("from_deep_link", false);
    this.fog = getIntent().getStringExtra("regsession_id");
    switch (this.foE)
    {
    default: 
      y.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.foE) });
      finish();
      return;
    case 2: 
      this.fpQ = new o();
      if ((this.foR != null) && (this.foR.length() >= 8))
      {
        this.eAa = 1;
        paramBundle = getString(q.j.bind_mcontact_title_verify);
        if (d.spd) {
          paramBundle = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
        }
        setMMTitle(paramBundle);
        this.fpM = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.fpN = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.fpO = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.bSe = getIntent().getExtras().getString("bindmcontact_mobile");
        this.fcX = com.tencent.mm.plugin.b.a.YA();
        initView();
        this.fpQ.a(this);
        if (this.fpR == null) {
          break label431;
        }
        this.fcd.setText(this.fpR);
        XX();
      }
      break;
    }
    for (;;)
    {
      this.fmK = new c();
      return;
      this.eAa = 4;
      break;
      this.fpQ = new m(this.foE);
      break;
      this.fpQ = new n();
      break;
      label431:
      if (this.foE == 5)
      {
        this.fpQ.a(MobileVerifyUI.a.fqa);
      }
      else
      {
        this.fpH = new MobileVerifyUI.c(this, this);
        getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.fpH);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.fpH != null)
    {
      getContentResolver().unregisterContentObserver(this.fpH);
      this.fpH = null;
    }
    if (this.fmK != null) {
      this.fmK.close();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onKeyboardStateChanged()
  {
    if (this.mController.uNh == 1)
    {
      this.fpG.scrollTo(0, this.fpG.getChildAt(0).getMeasuredHeight() - this.fpG.getMeasuredHeight());
      return;
    }
    this.fpG.scrollTo(0, 0);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      y.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        XY();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.fpQ.stop();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        y.w("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      y.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (paramArrayOfInt[0] != 0);
    Xt();
  }
  
  public void onResume()
  {
    super.onResume();
    this.fpQ.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */