package midas.x;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;
import java.io.PrintWriter;
import java.io.StringWriter;

public class b6
  implements Thread.UncaughtExceptionHandler
{
  public Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  public static void a()
  {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof b6)) {
      Thread.setDefaultUncaughtExceptionHandler(new b6());
    }
  }
  
  public final String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    paramThrowable = localStringWriter.toString();
    localPrintWriter.close();
    return paramThrowable;
  }
  
  public final boolean b(Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    int j = paramThrowable.length;
    int i = 0;
    while (i < j)
    {
      String str = paramThrowable[i].getClassName();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("com.tencent.midas.")) || (str.startsWith("x.")) || (str.startsWith("midas.x.")) || (str.startsWith("com.pay.")))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!b(paramThrowable))
    {
      this.a.uncaughtException(paramThread, paramThrowable);
      return;
    }
    String str = a(paramThrowable);
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = str.replace(System.lineSeparator(), "|");
    } else {
      localObject = str.replace(System.getProperty("line.separator"), "|");
    }
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = p4.p().e().b.saveType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msg=");
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append("&stacktrace=");
    localStringBuilder.append((String)localObject);
    localAPDataReportManager.a("sdk.cgi.crash", i, null, null, localStringBuilder.toString());
    APLog.e("PAY CRASH", "#++++++++++++++PAY CRASH CAUGHT+++++++++++++");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH APP OFFERID: ");
    ((StringBuilder)localObject).append(p4.p().c());
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH APP OPENID:  ");
    ((StringBuilder)localObject).append(p4.p().d());
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH TYPE:        ");
    ((StringBuilder)localObject).append(paramThrowable.getClass().getName());
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH MSG:         ");
    ((StringBuilder)localObject).append(paramThrowable.getMessage());
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH STACK:       ");
    ((StringBuilder)localObject).append(str);
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    APLog.e("PAY CRASH", "#++++++++++++++++++++++++++++++++++++++++++++");
    this.a.uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b6
 * JD-Core Version:    0.7.0.1
 */