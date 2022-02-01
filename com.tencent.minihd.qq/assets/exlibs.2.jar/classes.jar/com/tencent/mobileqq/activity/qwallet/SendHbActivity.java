package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import gtp;
import gtq;
import gtr;
import gts;
import gtt;
import gtu;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class SendHbActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  public SendHbActivity()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new gtp(this);
  }
  
  private double a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (paramInt < 0) {
      return 0.0D;
    }
    return new BigDecimal(Double.toString(paramDouble1)).divide(new BigDecimal(Double.toString(paramDouble2)), paramInt, 4).doubleValue();
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private boolean a()
  {
    int k = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((k == 0) || (str.startsWith(".")) || (str.endsWith("."))) {
      this.j = "";
    }
    for (;;)
    {
      return false;
      if (TextUtils.isEmpty(str))
      {
        this.j = "";
        return false;
      }
      if (str.indexOf('.') == 0)
      {
        this.j = "";
        return false;
      }
      if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
      {
        str = getString(2131364615);
        if (str != null) {
          a(str);
        }
        this.j = "";
        return false;
      }
      try
      {
        if (Double.valueOf(str).doubleValue() <= 0.0D)
        {
          this.j = "";
          return false;
        }
        if (("2".equals(this.h)) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8)) {}
        for (str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(); Double.valueOf(str).doubleValue() >= 0.01D; str = this.j)
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())) {
            break label261;
          }
          break label261;
          this.j = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
        }
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {}
    for (;;)
    {
      return true;
      String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      try
      {
        if (Integer.parseInt(str) < 1)
        {
          str = getString(2131364607);
          if (str != null) {
            a(str);
          }
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  private void c()
  {
    this.h = "2";
    this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130839359);
    this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
    this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-5758432);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364535);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.j);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364540);
  }
  
  private void c(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.jdField_a_of_type_Int);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.g);
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
  
  private void d()
  {
    this.h = "1";
    this.jdField_c_of_type_AndroidWidgetButton.setBackgroundResource(2130839358);
    this.jdField_c_of_type_AndroidWidgetButton.setTextColor(-5758432);
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839361);
    this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364537);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {}
    for (;;)
    {
      try
      {
        double d1 = Double.valueOf(str2).doubleValue();
        double d2 = Double.valueOf(str1).doubleValue();
        str2 = new DecimalFormat("#.##").format(a(d1, d2, 2));
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str2);
        this.j = a(str2, str1);
        e();
        return;
      }
      catch (Exception localException)
      {
        this.j = "";
        continue;
      }
      this.j = "";
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      return;
    }
    if (!TextUtils.isEmpty(this.j))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("总金额 " + this.j + "元", TextView.BufferType.SPANNABLE);
      Spannable localSpannable = (Spannable)this.jdField_b_of_type_AndroidWidgetTextView.getText();
      localSpannable.setSpan(new ForegroundColorSpan(-8355712), 0, 3, 33);
      localSpannable.setSpan(new ForegroundColorSpan(-3135193), 3, localSpannable.length() - 1, 33);
      localSpannable.setSpan(new ForegroundColorSpan(-8355712), localSpannable.length() - 1, localSpannable.length(), 33);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if ((!"2".equals(this.h)) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
          continue;
        }
        localJSONObject.put("total_amount", a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
        localObject = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localJSONObject.put("total_num", "1");
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        Object localObject;
        localJSONException.printStackTrace();
        return;
        localJSONException.put("total_num", localObject);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localJSONObject.put("name", this.e);
      localJSONObject.put("bus_type", this.h);
      localJSONObject.put("wishing", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      localJSONObject.put("recv_uin", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("recv_type", this.jdField_c_of_type_JavaLangString);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("userId", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("viewTag", "sendHb");
      ((JSONObject)localObject).put("comeForm", 2);
      ((JSONObject)localObject).put("appInfo", this.g);
      ((JSONObject)localObject).put("extra_data", localJSONObject.toString());
      PayBridgeActivity.a(this, ((JSONObject)localObject).toString(), 5, "0", "");
      return;
      localJSONObject.put("total_amount", a(this.j));
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return 131;
    }
    if ("1".equals(this.jdField_c_of_type_JavaLangString)) {
      return 133;
    }
    return 132;
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int k = paramContext.getResources().getDimensionPixelSize(2131492923);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return k - (int)(f1 * 5.0F);
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
    setContentView(2130903673);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ((TextView)findViewById(2131297348)).setText(2131364530);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131299262));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131299263));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299264));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297476));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299201));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299267));
    this.jdField_c_of_type_AndroidWidgetEditText.setOnEditorActionListener(new gtq(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299268));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299266));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299265));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299200));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299269);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131299270));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((Button)findViewById(2131299272)).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299274));
    ((ImageView)findViewById(2131298050)).setBackgroundDrawable(this.app.c(this.jdField_a_of_type_JavaLangString));
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131299261);
    if ("1".equals(this.h)) {
      d();
    }
    while ("1".equals(this.jdField_c_of_type_JavaLangString))
    {
      d();
      localLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      new Handler().postDelayed(new gtr(this), 150L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131364536);
      return;
      if ("2".equals(this.h)) {
        c();
      } else {
        this.h = "2";
      }
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetEditText.setHint("本群共" + this.jdField_b_of_type_JavaLangString + "人");
    }
    this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
    new Handler().postDelayed(new gts(this), 150L);
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
      localIntent.putExtra("callbackSn", this.f);
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
  
  protected void a(String paramString)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sp_data", paramString);
      paramString = new JSONObject();
      paramString.put("userId", this.jdField_a_of_type_JavaLangString);
      paramString.put("viewTag", "sendHbCallback");
      paramString.put("comeForm", 2);
      paramString.put("appInfo", this.g);
      paramString.put("extra_data", localJSONObject.toString());
      PayBridgeActivity.a(this, paramString.toString(), 5, "0", "");
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
    if (!TextUtils.isEmpty(this.g)) {
      paramString5.append(this.g.replace("|", ","));
    }
    paramString5.append("|");
    StatisticCollector.a(BaseApplication.getContext()).d(this.app, paramString5.toString());
  }
  
  protected void b()
  {
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    f();
  }
  
  public void b(String paramString)
  {
    DialogUtil.a(this, 230, null, paramString, new gtt(this), new gtu(this)).show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    this.jdField_a_of_type_AndroidContentContext = this;
    try
    {
      this.jdField_a_of_type_JavaLangString = this.app.a();
      this.e = this.app.c();
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(getIntent().getBooleanExtra("is_H5", false));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 1);
      this.f = getIntent().getStringExtra("callbackSn");
      this.g = getIntent().getStringExtra("app_info");
      paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
      this.jdField_d_of_type_JavaLangString = paramBundle.optString("recv_uin");
      this.jdField_b_of_type_JavaLangString = paramBundle.optString("people_num");
      this.jdField_c_of_type_JavaLangString = paramBundle.optString("recv_type");
      this.h = paramBundle.optString("bus_type");
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
    a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.show", "", "", 2, "");
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: iconst_0
    //   5: putfield 44	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_Boolean	Z
    //   8: aload_3
    //   9: ifnull +143 -> 152
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne +138 -> 152
    //   17: aload_3
    //   18: ldc_w 525
    //   21: invokevirtual 640	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +132 -> 158
    //   29: aload_3
    //   30: invokevirtual 160	java/lang/String:length	()I
    //   33: ifle +125 -> 158
    //   36: new 246	org/json/JSONObject
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 643	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +561 -> 609
    //   51: aload 4
    //   53: ldc_w 676
    //   56: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_3
    //   60: aload 4
    //   62: ldc_w 507
    //   65: iconst_m1
    //   66: invokevirtual 679	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   69: istore_2
    //   70: aload 4
    //   72: ldc_w 681
    //   75: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +89 -> 171
    //   85: aload 4
    //   87: invokevirtual 160	java/lang/String:length	()I
    //   90: ifle +81 -> 171
    //   93: new 246	org/json/JSONObject
    //   96: dup
    //   97: aload 4
    //   99: invokespecial 643	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: aload 5
    //   109: astore_3
    //   110: aload_0
    //   111: getfield 551	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   114: invokevirtual 684	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   117: iload_2
    //   118: ifne +451 -> 569
    //   121: aload_3
    //   122: ifnull +447 -> 569
    //   125: iload_1
    //   126: lookupswitch	default:+26->152, 5:+57->183, 9:+142->268
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 277	java/lang/Exception:printStackTrace	()V
    //   158: aconst_null
    //   159: astore 4
    //   161: goto -115 -> 46
    //   164: astore 4
    //   166: aload 4
    //   168: invokevirtual 277	java/lang/Exception:printStackTrace	()V
    //   171: aconst_null
    //   172: astore 5
    //   174: aload_3
    //   175: astore 4
    //   177: aload 5
    //   179: astore_3
    //   180: goto -70 -> 110
    //   183: aload_0
    //   184: getfield 544	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Boolean	Z
    //   187: ifeq +69 -> 256
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 544	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_c_of_type_Boolean	Z
    //   195: aload_3
    //   196: ldc_w 686
    //   199: invokevirtual 688	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   202: iconst_1
    //   203: if_icmpne +45 -> 248
    //   206: aload_0
    //   207: getfield 71	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   210: iconst_0
    //   211: invokevirtual 691	android/view/View:setVisibility	(I)V
    //   214: aload_0
    //   215: aload_3
    //   216: ldc_w 693
    //   219: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   222: putfield 695	com/tencent/mobileqq/activity/qwallet/SendHbActivity:i	Ljava/lang/String;
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 80	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: aload_0
    //   231: invokevirtual 668	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   234: ldc_w 697
    //   237: ldc 153
    //   239: ldc 153
    //   241: iconst_2
    //   242: ldc 153
    //   244: invokevirtual 672	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   247: return
    //   248: aload_0
    //   249: ldc_w 699
    //   252: invokevirtual 168	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   255: return
    //   256: aload_0
    //   257: aload_3
    //   258: ldc_w 701
    //   261: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: invokespecial 703	com/tencent/mobileqq/activity/qwallet/SendHbActivity:c	(Ljava/lang/String;)V
    //   267: return
    //   268: aload_3
    //   269: ldc_w 705
    //   272: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 4
    //   277: aload 4
    //   279: ifnull -127 -> 152
    //   282: aload_0
    //   283: getfield 342	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   286: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +268 -> 557
    //   292: new 707	java/lang/StringBuffer
    //   295: dup
    //   296: aload 4
    //   298: invokestatic 712	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokespecial 713	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   304: astore 4
    //   306: aload_3
    //   307: ldc_w 556
    //   310: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 5
    //   315: aload 5
    //   317: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifne +20 -> 340
    //   323: aload 4
    //   325: ldc_w 715
    //   328: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   331: pop
    //   332: aload 4
    //   334: aload 5
    //   336: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: aload_3
    //   341: ldc_w 720
    //   344: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 5
    //   349: aload 5
    //   351: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +20 -> 374
    //   357: aload 4
    //   359: ldc_w 722
    //   362: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   365: pop
    //   366: aload 4
    //   368: aload 5
    //   370: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   373: pop
    //   374: aload_3
    //   375: ldc_w 724
    //   378: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 5
    //   383: aload 5
    //   385: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifne +20 -> 408
    //   391: aload 4
    //   393: ldc_w 726
    //   396: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   399: pop
    //   400: aload 4
    //   402: aload 5
    //   404: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   407: pop
    //   408: aload_3
    //   409: ldc_w 728
    //   412: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: astore_3
    //   416: aload_3
    //   417: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   420: ifne +19 -> 439
    //   423: aload 4
    //   425: ldc_w 730
    //   428: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   431: pop
    //   432: aload 4
    //   434: aload_3
    //   435: invokevirtual 718	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   438: pop
    //   439: new 246	org/json/JSONObject
    //   442: dup
    //   443: invokespecial 247	org/json/JSONObject:<init>	()V
    //   446: astore_3
    //   447: new 246	org/json/JSONObject
    //   450: dup
    //   451: invokespecial 247	org/json/JSONObject:<init>	()V
    //   454: astore 5
    //   456: aload 5
    //   458: ldc_w 705
    //   461: aload 4
    //   463: invokevirtual 731	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   466: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload_3
    //   471: ldc_w 507
    //   474: iconst_0
    //   475: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload_3
    //   480: ldc_w 676
    //   483: ldc_w 733
    //   486: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: aload_3
    //   491: ldc_w 681
    //   494: aload 5
    //   496: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   499: pop
    //   500: new 509	android/content/Intent
    //   503: dup
    //   504: invokespecial 510	android/content/Intent:<init>	()V
    //   507: astore 4
    //   509: aload 4
    //   511: ldc_w 512
    //   514: aload_0
    //   515: getfield 514	com/tencent/mobileqq/activity/qwallet/SendHbActivity:f	Ljava/lang/String;
    //   518: invokevirtual 518	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   521: pop
    //   522: aload 4
    //   524: ldc_w 520
    //   527: iconst_5
    //   528: invokevirtual 523	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   531: pop
    //   532: aload 4
    //   534: ldc_w 525
    //   537: aload_3
    //   538: invokevirtual 270	org/json/JSONObject:toString	()Ljava/lang/String;
    //   541: invokevirtual 518	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   544: pop
    //   545: aload_0
    //   546: iconst_m1
    //   547: aload 4
    //   549: invokevirtual 529	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   552: aload_0
    //   553: invokevirtual 736	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   556: return
    //   557: aload_0
    //   558: aload_3
    //   559: ldc_w 556
    //   562: invokevirtual 646	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   565: invokevirtual 738	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;)V
    //   568: return
    //   569: iload_2
    //   570: ifle -418 -> 152
    //   573: aload_0
    //   574: ldc_w 739
    //   577: invokevirtual 165	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   580: astore_3
    //   581: aload 4
    //   583: ifnull +10 -> 593
    //   586: aload_0
    //   587: aload 4
    //   589: invokevirtual 168	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   592: return
    //   593: aload_0
    //   594: aload_3
    //   595: invokevirtual 168	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   598: return
    //   599: astore 4
    //   601: goto -101 -> 500
    //   604: astore 5
    //   606: goto -489 -> 117
    //   609: aconst_null
    //   610: astore_3
    //   611: aload 5
    //   613: astore 4
    //   615: goto -505 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	SendHbActivity
    //   0	618	1	paramInt1	int
    //   0	618	2	paramInt2	int
    //   0	618	3	paramIntent	Intent
    //   44	116	4	localObject1	Object
    //   164	3	4	localException1	Exception
    //   175	413	4	localObject2	Object
    //   599	1	4	localException2	Exception
    //   613	1	4	localException3	Exception
    //   1	494	5	localObject3	Object
    //   604	8	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   36	46	153	java/lang/Exception
    //   93	104	164	java/lang/Exception
    //   447	500	599	java/lang/Exception
    //   110	117	604	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k == 2131297357) {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.keyback", "", "", 2, "");
        a(-1, null);
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_c_of_type_AndroidWidgetEditText.getWindowToken(), 0);
        finish();
      }
    }
    label180:
    label226:
    do
    {
      do
      {
        do
        {
          return;
          a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.back", "", "", 2, "");
          break;
          if (k == 2131299268)
          {
            a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.go", "", "", 2, "");
            b();
            return;
          }
          if (k != 2131299263) {
            break label180;
          }
        } while ("1".equals(this.h));
        d();
        a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.identical", "", "", 2, "");
        return;
        if (k != 2131299262) {
          break label226;
        }
      } while ("2".equals(this.h));
      c();
      a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrap.random", "", "", 2, "");
      return;
      if (k == 2131299272)
      {
        paramView = new Intent(this, ForwardRecentActivity.class);
        paramView.putExtra("hb_id", this.i);
        paramView.putExtra("send_uin", this.jdField_a_of_type_JavaLangString);
        paramView.putExtra("hb_type", "1");
        paramView.putExtra("forward_text", "发红包啦!");
        paramView.putExtra("forward_type", 17);
        paramView.putExtra("display_like_dialog", true);
        startActivity(paramView);
        a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrapped.send", "", "", 2, "");
        return;
      }
    } while (k != 2131299270);
    b("确定关闭吗？");
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrapped.keyback", "", "", 2, "");
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, a(), "hongbao.wrapped.close", "", "", 2, "");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.performClick();
        return true;
      }
      this.jdField_d_of_type_AndroidWidgetButton.performClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void setTitleBackground(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */