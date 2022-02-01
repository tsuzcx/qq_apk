package midas.x;

import com.tencent.midas.comm.APLog;

public class m3
  extends ob
{
  public m3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    String str = paramgb.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSuccess() responseBody = ");
    localStringBuilder.append(str);
    APLog.d("APPayNotifyAns", localStringBuilder.toString());
    return super.d(paramgb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m3
 * JD-Core Version:    0.7.0.1
 */