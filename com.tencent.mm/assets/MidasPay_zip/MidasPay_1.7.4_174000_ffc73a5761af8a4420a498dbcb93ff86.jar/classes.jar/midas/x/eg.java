package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;

public class eg
  extends lh
{
  private int a = -1;
  
  public eg(lw paramlw)
  {
    super(paramlw);
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    if (paramkz == null) {
      return super.a(paramkz);
    }
    String str = paramkz.b;
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
      return super.a(paramkz);
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Result format error = ");
    localStringBuilder2.append(localStringBuilder1);
    APLog.e("QRCodePay-PayResultAns", localStringBuilder2.toString());
    this.j = -1;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("系统繁忙,请稍后再试\n");
    localStringBuilder1.append(bw.a(20004));
    this.k = localStringBuilder1.toString();
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.eg
 * JD-Core Version:    0.7.0.1
 */