package midas.x;

import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;

public class bv
{
  public static bv a()
  {
    return a.a();
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("grayTest() enableGrayTest = ");
    localStringBuilder.append(paramBoolean);
    APLog.d("MidasPushTest", localStringBuilder.toString());
    if (!paramBoolean)
    {
      bu.a().a("key_test_message");
      if (bu.a().b() <= 0) {
        bu.a().e();
      }
    }
    else
    {
      bu.a().a("key_test_message", new bu.a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          APDataReportManager.getInstance().insertData("sdk.cloudgame.test.close", 0, em.b().n().e.l, null, null);
        }
        
        public void a(br paramAnonymousbr)
        {
          if (paramAnonymousbr.a() == 4)
          {
            Object localObject = APDataReportManager.getInstance();
            String str = em.b().n().e.l;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymousbr.c);
            ((APDataReportManager)localObject).insertData("sdk.cloudgame.test.msg", 0, str, null, localStringBuilder.toString());
            paramAnonymousbr = paramAnonymousbr.d();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("responseData() data.nextGrayText() = ");
            ((StringBuilder)localObject).append(paramAnonymousbr);
            APLog.d("MidasPushTest", ((StringBuilder)localObject).toString());
            if (paramAnonymousbr != null) {
              bu.a().a(paramAnonymousbr);
            }
          }
        }
        
        public void a(jn paramAnonymousjn)
        {
          APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
          String str = em.b().n().e.l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("err=");
          localStringBuilder.append(paramAnonymousjn);
          localAPDataReportManager.insertData("sdk.cloudgame.test.error", 0, str, null, localStringBuilder.toString());
        }
        
        public void b(int paramAnonymousInt, String paramAnonymousString)
        {
          APDataReportManager.getInstance().insertData("sdk.cloudgame.test.open", 0, em.b().n().e.l, null, null);
        }
      });
      APDataReportManager.getInstance().insertData("sdk.cloudgame.test.connect", 0, em.b().n().e.l, null, null);
      bu.a().a("cloudDevice", null);
    }
  }
  
  public void b()
  {
    bu.a().a("key_test_message");
    if (bu.a().b() <= 0) {
      bu.a().e();
    }
  }
  
  static class a
  {
    private static bv a = new bv(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bv
 * JD-Core Version:    0.7.0.1
 */