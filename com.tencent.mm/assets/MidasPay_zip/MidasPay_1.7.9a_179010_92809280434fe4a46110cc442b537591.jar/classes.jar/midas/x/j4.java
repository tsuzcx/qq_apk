package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;

public class j4
  extends ob
{
  public int g = -1;
  
  public j4(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    if (paramgb == null) {
      return super.d(paramgb);
    }
    String str = paramgb.b;
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
        this.g = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Result final = ");
      localStringBuilder1.append(this.g);
      APLog.d("QRCodePay-PayResultAns", localStringBuilder1.toString());
      return super.d(paramgb);
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Result format error = ");
    localStringBuilder2.append(localStringBuilder1);
    APLog.e("QRCodePay-PayResultAns", localStringBuilder2.toString());
    this.a = -1;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("系统繁忙,请稍后再试\n");
    localStringBuilder1.append(x1.a(20004));
    this.b = localStringBuilder1.toString();
    return super.d(paramgb);
  }
  
  public int g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j4
 * JD-Core Version:    0.7.0.1
 */