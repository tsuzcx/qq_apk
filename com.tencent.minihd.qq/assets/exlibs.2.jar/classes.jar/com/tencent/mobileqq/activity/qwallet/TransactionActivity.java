package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import gtv;
import gtw;
import gtx;
import org.json.JSONException;
import org.json.JSONObject;

public class TransactionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  protected TextWatcher a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public TransactionActivity()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new gtv(this);
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString((Double.valueOf(paramString).doubleValue() * 100.0D));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.jdField_a_of_type_Int);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.i);
      PayBridgeActivity.a(this, localJSONObject.toString(), 9, "0", "");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if ((paramString.indexOf('.') != 0) && ((paramString.indexOf('.') <= 0) || (paramString.indexOf('.') >= paramString.length() - 3))) {
        try
        {
          double d1 = Double.valueOf(paramString).doubleValue();
          if (d1 > 0.0D) {
            return true;
          }
        }
        catch (Exception paramString) {}
      }
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("PayeeUin", this.e);
      localJSONObject1.put("PayeeNick", this.d);
      localJSONObject1.put("Amout", a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
      localJSONObject1.put("Memo", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      localJSONObject1.put("ComeFrom", this.jdField_a_of_type_Int);
      localJSONObject1.put("HistransSign", this.c);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("userId", this.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("viewTag", "transferInfor");
      localJSONObject2.put("comeForm", 2);
      localJSONObject2.put("appInfo", this.i);
      localJSONObject2.put("extra_data", localJSONObject1.toString());
      PayBridgeActivity.a(this, localJSONObject2.toString(), 5, "0", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int j = paramContext.getResources().getDimensionPixelSize(2131492923);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return j - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public String a()
  {
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("Asia/Shanghai");
    return localTime.format("%Y%m%d%H%M%S");
  }
  
  protected void a()
  {
    setContentView(2130903675);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    TextView localTextView = (TextView)findViewById(2131297348);
    if (localTextView != null) {
      localTextView.setText(2131364524);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299201));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    new Handler().postDelayed(new gtw(this), 100L);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299267));
    this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new gtx(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299279));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299276));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.app.b(this.e));
    ((TextView)findViewById(2131299277)).setText(this.d);
    ((TextView)findViewById(2131299278)).setText(this.e);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label29:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.h);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    paramString5.append(6);
    paramString5.append("|");
    paramString5.append(a());
    paramString5.append("|");
    if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      paramString5.append(paramString3);
      paramString5.append(".");
      paramString5.append(paramString4);
    }
    paramString5.append("|");
    paramString5.append(paramInt2);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.i)) {
      paramString5.append(this.i.replace("|", ","));
    }
    paramString5.append("|");
    StatisticCollector.a(BaseApplication.getContext()).d(this.app, paramString5.toString());
  }
  
  protected void b()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    this.jdField_a_of_type_AndroidContentContext = this;
    try
    {
      this.jdField_a_of_type_JavaLangString = this.app.a();
      this.jdField_b_of_type_JavaLangString = this.app.c();
      this.f = this.app.d();
      this.g = "2";
      this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 1);
      this.h = getIntent().getStringExtra("callbackSn");
      this.i = getIntent().getStringExtra("app_info");
      paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
      this.e = paramBundle.optString("targetUin");
      this.d = paramBundle.optString("targetNickname");
      this.c = paramBundle.optString("sign");
      this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)getIntent().getParcelableExtra("receiver"));
      a();
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.show", "", "", 2, "");
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: iconst_0
    //   5: putfield 40	com/tencent/mobileqq/activity/qwallet/TransactionActivity:jdField_b_of_type_Boolean	Z
    //   8: aload_3
    //   9: ifnull +143 -> 152
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne +138 -> 152
    //   17: aload_3
    //   18: ldc_w 332
    //   21: invokevirtual 438	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +132 -> 158
    //   29: aload_3
    //   30: invokevirtual 140	java/lang/String:length	()I
    //   33: ifle +125 -> 158
    //   36: new 87	org/json/JSONObject
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 442	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +466 -> 514
    //   51: aload 4
    //   53: ldc_w 477
    //   56: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_3
    //   60: aload 4
    //   62: ldc_w 314
    //   65: iconst_m1
    //   66: invokevirtual 480	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   69: istore_2
    //   70: aload 4
    //   72: ldc_w 482
    //   75: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +89 -> 171
    //   85: aload 4
    //   87: invokevirtual 140	java/lang/String:length	()I
    //   90: ifle +81 -> 171
    //   93: new 87	org/json/JSONObject
    //   96: dup
    //   97: aload 4
    //   99: invokespecial 442	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: aload 5
    //   109: astore_3
    //   110: aload_0
    //   111: getfield 400	com/tencent/mobileqq/activity/qwallet/TransactionActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   114: invokevirtual 485	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   117: iload_2
    //   118: ifne +356 -> 474
    //   121: aload_3
    //   122: ifnull +352 -> 474
    //   125: iload_1
    //   126: lookupswitch	default:+26->152, 5:+57->183, 9:+69->195
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   158: aconst_null
    //   159: astore 4
    //   161: goto -115 -> 46
    //   164: astore 4
    //   166: aload 4
    //   168: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   171: aconst_null
    //   172: astore 5
    //   174: aload_3
    //   175: astore 4
    //   177: aload 5
    //   179: astore_3
    //   180: goto -70 -> 110
    //   183: aload_0
    //   184: aload_3
    //   185: ldc_w 487
    //   188: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokespecial 489	com/tencent/mobileqq/activity/qwallet/TransactionActivity:a	(Ljava/lang/String;)V
    //   194: return
    //   195: aload_3
    //   196: ldc_w 491
    //   199: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 4
    //   204: aload 4
    //   206: ifnull -54 -> 152
    //   209: new 493	java/lang/StringBuffer
    //   212: dup
    //   213: aload 4
    //   215: invokestatic 498	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokespecial 499	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   221: astore 4
    //   223: aload_3
    //   224: ldc_w 501
    //   227: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 5
    //   232: aload 5
    //   234: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne +20 -> 257
    //   240: aload 4
    //   242: ldc_w 503
    //   245: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   248: pop
    //   249: aload 4
    //   251: aload 5
    //   253: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   256: pop
    //   257: aload_3
    //   258: ldc_w 508
    //   261: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: astore 5
    //   266: aload 5
    //   268: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifne +20 -> 291
    //   274: aload 4
    //   276: ldc_w 510
    //   279: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   282: pop
    //   283: aload 4
    //   285: aload 5
    //   287: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   290: pop
    //   291: aload_3
    //   292: ldc_w 512
    //   295: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 5
    //   300: aload 5
    //   302: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +20 -> 325
    //   308: aload 4
    //   310: ldc_w 514
    //   313: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   316: pop
    //   317: aload 4
    //   319: aload 5
    //   321: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   324: pop
    //   325: aload_3
    //   326: ldc_w 516
    //   329: invokevirtual 447	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore_3
    //   333: aload_3
    //   334: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +19 -> 356
    //   340: aload 4
    //   342: ldc_w 518
    //   345: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   348: pop
    //   349: aload 4
    //   351: aload_3
    //   352: invokevirtual 506	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   355: pop
    //   356: new 87	org/json/JSONObject
    //   359: dup
    //   360: invokespecial 88	org/json/JSONObject:<init>	()V
    //   363: astore_3
    //   364: new 87	org/json/JSONObject
    //   367: dup
    //   368: invokespecial 88	org/json/JSONObject:<init>	()V
    //   371: astore 5
    //   373: aload 5
    //   375: ldc_w 491
    //   378: aload 4
    //   380: invokevirtual 519	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   383: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload_3
    //   388: ldc_w 314
    //   391: iconst_0
    //   392: invokevirtual 101	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload_3
    //   397: ldc_w 477
    //   400: ldc_w 521
    //   403: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload_3
    //   408: ldc_w 482
    //   411: aload 5
    //   413: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   416: pop
    //   417: new 316	android/content/Intent
    //   420: dup
    //   421: invokespecial 317	android/content/Intent:<init>	()V
    //   424: astore 4
    //   426: aload 4
    //   428: ldc_w 319
    //   431: aload_0
    //   432: getfield 321	com/tencent/mobileqq/activity/qwallet/TransactionActivity:h	Ljava/lang/String;
    //   435: invokevirtual 325	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   438: pop
    //   439: aload 4
    //   441: ldc_w 327
    //   444: iconst_5
    //   445: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   448: pop
    //   449: aload 4
    //   451: ldc_w 332
    //   454: aload_3
    //   455: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   458: invokevirtual 325	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   461: pop
    //   462: aload_0
    //   463: iconst_m1
    //   464: aload 4
    //   466: invokevirtual 336	com/tencent/mobileqq/activity/qwallet/TransactionActivity:setResult	(ILandroid/content/Intent;)V
    //   469: aload_0
    //   470: invokevirtual 524	com/tencent/mobileqq/activity/qwallet/TransactionActivity:finish	()V
    //   473: return
    //   474: iload_2
    //   475: ifle -323 -> 152
    //   478: aload_0
    //   479: ldc_w 525
    //   482: invokevirtual 529	com/tencent/mobileqq/activity/qwallet/TransactionActivity:getString	(I)Ljava/lang/String;
    //   485: astore_3
    //   486: aload 4
    //   488: ifnull +10 -> 498
    //   491: aload_0
    //   492: aload 4
    //   494: invokevirtual 531	com/tencent/mobileqq/activity/qwallet/TransactionActivity:a	(Ljava/lang/CharSequence;)V
    //   497: return
    //   498: aload_0
    //   499: aload_3
    //   500: invokevirtual 531	com/tencent/mobileqq/activity/qwallet/TransactionActivity:a	(Ljava/lang/CharSequence;)V
    //   503: return
    //   504: astore 4
    //   506: goto -89 -> 417
    //   509: astore 5
    //   511: goto -394 -> 117
    //   514: aconst_null
    //   515: astore_3
    //   516: aload 5
    //   518: astore 4
    //   520: goto -410 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	TransactionActivity
    //   0	523	1	paramInt1	int
    //   0	523	2	paramInt2	int
    //   0	523	3	paramIntent	Intent
    //   44	116	4	localObject1	Object
    //   164	3	4	localException1	Exception
    //   175	318	4	localObject2	Object
    //   504	1	4	localException2	Exception
    //   518	1	4	localException3	Exception
    //   1	411	5	localObject3	Object
    //   509	8	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   36	46	153	java/lang/Exception
    //   93	104	164	java/lang/Exception
    //   364	417	504	java/lang/Exception
    //   110	117	509	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131297357) {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amout.keyback", "", "", 2, "");
        a(-1, null);
        hideSoftPanel();
        finish();
      }
    }
    while (j != 2131299279) {
      for (;;)
      {
        return;
        a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.back", "", "", 2, "");
      }
    }
    a(this.jdField_a_of_type_JavaLangString, 128, "transfer.amount.go", "", "", 2, "");
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.performClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TransactionActivity
 * JD-Core Version:    0.7.0.1
 */