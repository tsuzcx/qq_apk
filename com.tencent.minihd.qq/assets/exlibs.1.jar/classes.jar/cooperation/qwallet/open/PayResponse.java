package cooperation.qwallet.open;

import android.os.Bundle;
import android.text.TextUtils;

public class PayResponse
  extends BaseResponse
{
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payresp_paychanneltype", this.jdField_c_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_payresp_transactionid", this.d);
    paramBundle.putString("_mqqpay_payresp_paytime", this.e);
    paramBundle.putString("_mqqpay_payresp_totalfee", this.f);
    paramBundle.putString("_mqqpay_payresp_callbackurl", this.g);
    paramBundle.putString("_mqqpay_payresp_spdata", this.h);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.i);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("_mqqpay_payresp_paychanneltype");
    this.d = paramBundle.getString("_mqqpay_payresp_transactionid");
    this.e = paramBundle.getString("_mqqpay_payresp_paytime");
    this.f = paramBundle.getString("_mqqpay_payresp_totalfee");
    this.g = paramBundle.getString("_mqqpay_payresp_callbackurl");
    this.h = paramBundle.getString("_mqqpay_payresp_spdata");
    this.i = paramBundle.getString("_mqqpay_payapi_serialnumber");
  }
  
  public boolean b()
  {
    if (this.jdField_c_of_type_Int == -9999999) {}
    while ((a()) && (!c()) && ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))) {
      return false;
    }
    return true;
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    while (this.jdField_c_of_type_JavaLangString.compareTo("1") != 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.PayResponse
 * JD-Core Version:    0.7.0.1
 */