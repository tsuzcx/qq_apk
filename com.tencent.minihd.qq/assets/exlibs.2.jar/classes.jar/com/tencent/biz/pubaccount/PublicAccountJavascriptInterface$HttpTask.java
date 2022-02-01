package com.tencent.biz.pubaccount;

import android.os.AsyncTask;
import com.tencent.biz.common.util.Util;

public class PublicAccountJavascriptInterface$HttpTask
  extends AsyncTask
{
  String jdField_a_of_type_JavaLangString;
  
  public PublicAccountJavascriptInterface$HttpTask(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected String a(String... paramVarArgs)
  {
    if (super.isCancelled()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a(paramVarArgs[0], paramVarArgs[1]);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "{\"r\" : \"-100\"}";
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs("clientCallback", new String[] { Util.b(str), Util.b(this.jdField_a_of_type_JavaLangString) });
  }
  
  protected void a(Integer... paramVarArgs) {}
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.HttpTask
 * JD-Core Version:    0.7.0.1
 */