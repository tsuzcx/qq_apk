package midas.x;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;
import java.io.PrintWriter;
import java.io.StringWriter;

public class fx
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  public static void a()
  {
    if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof fx)) {
      Thread.setDefaultUncaughtExceptionHandler(new fx());
    }
  }
  
  private boolean a(Throwable paramThrowable)
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
  
  private String b(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    paramThrowable = localStringWriter.toString();
    localPrintWriter.close();
    return paramThrowable;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!a(paramThrowable))
    {
      this.a.uncaughtException(paramThread, paramThrowable);
      return;
    }
    String str = b(paramThrowable);
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = str.replace(System.lineSeparator(), "|");
    } else {
      localObject = str.replace(System.getProperty("line.separator"), "|");
    }
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = em.b().n().a.saveType;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msg=");
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append("&stacktrace=");
    localStringBuilder.append((String)localObject);
    localAPDataReportManager.a("sdk.cgi.crash", i, null, null, localStringBuilder.toString());
    APLog.e("PAY CRASH", "#++++++++++++++PAY CRASH CAUGHT+++++++++++++");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH DEVICE:      ");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH OS VERSION:  ");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append(" API: ");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH MODEL:       ");
    ((StringBuilder)localObject).append(Build.MODEL);
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH CPU:         ");
    ((StringBuilder)localObject).append(Build.CPU_ABI);
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH APP OFFERID: ");
    ((StringBuilder)localObject).append(em.b().f());
    APLog.e("PAY CRASH", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("# CRASH APP OPENID:  ");
    ((StringBuilder)localObject).append(em.b().e());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fx
 * JD-Core Version:    0.7.0.1
 */