package midas.x;

import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;

public class w1
{
  public static w1 b()
  {
    return b.a();
  }
  
  public void a()
  {
    v1.e().a("key_test_message");
    if (v1.e().c() <= 0) {
      v1.e().a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("grayTest() enableGrayTest = ");
    localStringBuilder.append(paramBoolean);
    APLog.d("MidasPushTest", localStringBuilder.toString());
    if (!paramBoolean)
    {
      v1.e().a("key_test_message");
      if (v1.e().c() <= 0) {
        v1.e().a();
      }
    }
    else
    {
      v1.e().a("key_test_message", new a());
      APDataReportManager.getInstance().insertData("sdk.cloudgame.test.connect", 0, p4.p().e().f.k, null, null);
      v1.e().a("cloudDevice", null, p4.p().e().b);
    }
  }
  
  public class a
    implements v1.d
  {
    public a() {}
    
    public void a(int paramInt, String paramString)
    {
      APDataReportManager.getInstance().insertData("sdk.cloudgame.test.close", 0, p4.p().e().f.k, null, null);
    }
    
    public void a(s1 params1)
    {
      if (params1.b() == 4)
      {
        Object localObject = APDataReportManager.getInstance();
        String str = p4.p().e().f.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(params1.c);
        ((APDataReportManager)localObject).insertData("sdk.cloudgame.test.msg", 0, str, null, localStringBuilder.toString());
        params1 = params1.d();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("responseData() data.nextGrayText() = ");
        ((StringBuilder)localObject).append(params1);
        APLog.d("MidasPushTest", ((StringBuilder)localObject).toString());
        if (params1 != null) {
          v1.e().a(params1);
        }
      }
    }
    
    public void a(t9 paramt9)
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      String str = p4.p().e().f.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(paramt9);
      localAPDataReportManager.insertData("sdk.cloudgame.test.error", 0, str, null, localStringBuilder.toString());
    }
    
    public void b(int paramInt, String paramString)
    {
      APDataReportManager.getInstance().insertData("sdk.cloudgame.test.open", 0, p4.p().e().f.k, null, null);
    }
  }
  
  public static class b
  {
    public static w1 a = new w1(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w1
 * JD-Core Version:    0.7.0.1
 */