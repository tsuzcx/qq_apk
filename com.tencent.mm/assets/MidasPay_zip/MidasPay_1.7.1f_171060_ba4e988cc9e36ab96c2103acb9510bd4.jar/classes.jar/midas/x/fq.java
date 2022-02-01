package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fq
{
  private static ExecutorService a = ;
  
  private void a(final SharedPreferences.Editor paramEditor)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        paramEditor.commit();
      }
    });
  }
  
  public String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return "";
    }
    return paramContext.getSharedPreferences(paramString1, 4).getString(paramString2, "");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 4).edit();
    paramContext.putString(paramString2, paramString3);
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fq
 * JD-Core Version:    0.7.0.1
 */