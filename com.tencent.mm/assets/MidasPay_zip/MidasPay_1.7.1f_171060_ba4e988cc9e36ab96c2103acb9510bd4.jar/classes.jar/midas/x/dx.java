package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;

public class dx
  extends jw
{
  private int a = -1;
  
  public dx(kl paramkl)
  {
    super(paramkl);
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected boolean a(jo paramjo)
  {
    if (paramjo == null) {
      return super.a(paramjo);
    }
    String str = paramjo.b;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Result = ");
    localStringBuilder2.append(str);
    APLog.d("QRCodePay-PayResultAns", localStringBuilder2.toString());
    if ((!TextUtils.isEmpty(str)) && (str.length() > 2))
    {
      str = str.substring(1, str.length() - 1);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Result after format = ");
      localStringBuilder2.append(str);
      APLog.d("QRCodePay-PayResultAns", localStringBuilder2.toString());
      try
      {
        this.a = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Result final = ");
      localStringBuilder1.append(this.a);
      APLog.d("QRCodePay-PayResultAns", localStringBuilder1.toString());
      return super.a(paramjo);
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Result format error = ");
    localStringBuilder2.append(localStringBuilder1);
    APLog.e("QRCodePay-PayResultAns", localStringBuilder2.toString());
    this.i = -1;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("系统繁忙,请稍后再试\n");
    localStringBuilder1.append(bq.a(20004));
    this.j = localStringBuilder1.toString();
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dx
 * JD-Core Version:    0.7.0.1
 */