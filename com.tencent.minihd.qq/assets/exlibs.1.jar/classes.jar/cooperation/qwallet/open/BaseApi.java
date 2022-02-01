package cooperation.qwallet.open;

import android.os.Bundle;

public abstract class BaseApi
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putString("_mqqpay_baseapi_appid", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_baseapi_apptype", this.c);
    paramBundle.putString("_mqqpay_baseapi_sdkversion", this.b);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.d);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.jdField_a_of_type_Int);
  }
  
  public abstract boolean a();
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_appid");
    this.c = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.b = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.d = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.jdField_a_of_type_Int = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.BaseApi
 * JD-Core Version:    0.7.0.1
 */