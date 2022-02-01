package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d6
{
  public static ExecutorService a = ;
  
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
  
  public final void a(final SharedPreferences.Editor paramEditor)
  {
    a.execute(new a(paramEditor));
  }
  
  public class a
    implements Runnable
  {
    public a(SharedPreferences.Editor paramEditor) {}
    
    public void run()
    {
      paramEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d6
 * JD-Core Version:    0.7.0.1
 */