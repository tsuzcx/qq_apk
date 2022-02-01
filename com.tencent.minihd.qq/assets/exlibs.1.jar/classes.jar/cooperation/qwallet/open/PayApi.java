package cooperation.qwallet.open;

import android.os.Bundle;
import android.text.TextUtils;

public class PayApi
  extends BaseApi
{
  public long a;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.e);
    paramBundle.putString("_mqqpay_payapi_callbackscheme", this.f);
    paramBundle.putString("_mqqpay_payapi_pubacc", this.g);
    paramBundle.putString("_mqqpay_payapi_pubacchint", this.h);
    paramBundle.putString("_mqqpay_payapi_tokenid", this.i);
    paramBundle.putString("_mqqpay_payapi_nonce", this.j);
    paramBundle.putLong("_mqqpay_payapi_timeStamp", this.jdField_a_of_type_Long);
    paramBundle.putString("_mqqpay_payapi_bargainorId", this.k);
    paramBundle.putString("_mqqpay_payapi_sigType", this.l);
    paramBundle.putString("_mqqpay_payapi_sig", this.m);
    paramBundle.putString("_mqqpay_payapi_packageName", this.n);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    while ((TextUtils.isEmpty(this.c)) || (this.c.compareTo("native") != 0) || (TextUtils.isEmpty(this.n)) || (TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.k)) || (TextUtils.isEmpty(this.j)) || (TextUtils.isEmpty(this.m)) || (TextUtils.isEmpty(this.l)) || (this.jdField_a_of_type_Long <= 0L) || (TextUtils.isEmpty(this.e))) {
      return false;
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.e = paramBundle.getString("_mqqpay_payapi_serialnumber");
    this.f = paramBundle.getString("_mqqpay_payapi_callbackscheme");
    this.g = paramBundle.getString("_mqqpay_payapi_pubacc");
    this.h = paramBundle.getString("_mqqpay_payapi_pubacchint");
    this.i = paramBundle.getString("_mqqpay_payapi_tokenid");
    this.j = paramBundle.getString("_mqqpay_payapi_nonce");
    this.jdField_a_of_type_Long = paramBundle.getLong("_mqqpay_payapi_timeStamp");
    this.k = paramBundle.getString("_mqqpay_payapi_bargainorId");
    this.l = paramBundle.getString("_mqqpay_payapi_sigType");
    this.m = paramBundle.getString("_mqqpay_payapi_sig");
    this.n = paramBundle.getString("_mqqpay_payapi_packageName");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.PayApi
 * JD-Core Version:    0.7.0.1
 */