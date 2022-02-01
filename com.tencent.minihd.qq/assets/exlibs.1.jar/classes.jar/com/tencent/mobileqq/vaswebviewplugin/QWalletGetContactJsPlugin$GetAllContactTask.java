package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import org.json.JSONObject;

class QWalletGetContactJsPlugin$GetAllContactTask
  extends AsyncTask
{
  QWalletGetContactJsPlugin$GetAllContactTask(QWalletGetContactJsPlugin paramQWalletGetContactJsPlugin) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = QWalletGetContactJsPlugin.access$200(this.this$0);
    if (paramVarArgs != null) {
      return paramVarArgs.toString();
    }
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    QWalletGetContactJsPlugin.access$100(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin.GetAllContactTask
 * JD-Core Version:    0.7.0.1
 */