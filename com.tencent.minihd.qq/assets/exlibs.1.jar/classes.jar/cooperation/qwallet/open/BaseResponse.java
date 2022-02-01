package cooperation.qwallet.open;

import android.os.Bundle;

public abstract class BaseResponse
{
  protected final int a;
  public String a;
  protected final int b;
  public String b;
  public int c = -9999999;
  public int d;
  
  public BaseResponse()
  {
    this.jdField_a_of_type_Int = -9999999;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_mqqpay_baseresp_retcode", this.c);
    paramBundle.putString("_mqqpay_baseresp_retmsg", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.jdField_b_of_type_JavaLangString);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.d);
  }
  
  public boolean a()
  {
    return this.c == 0;
  }
  
  public void b(Bundle paramBundle)
  {
    this.c = paramBundle.getInt("_mqqpay_baseresp_retcode");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseresp_retmsg");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.d = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.BaseResponse
 * JD-Core Version:    0.7.0.1
 */