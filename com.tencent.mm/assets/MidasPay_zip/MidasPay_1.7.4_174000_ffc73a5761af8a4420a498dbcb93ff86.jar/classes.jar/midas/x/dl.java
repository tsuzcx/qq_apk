package midas.x;

import com.tencent.midas.comm.APLog;

public class dl
  extends lh
{
  public dl(lw paramlw)
  {
    super(paramlw);
  }
  
  protected boolean a(kz paramkz)
  {
    String str = paramkz.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSuccess() responseBody = ");
    localStringBuilder.append(str);
    APLog.d("APPayNotifyAns", localStringBuilder.toString());
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dl
 * JD-Core Version:    0.7.0.1
 */