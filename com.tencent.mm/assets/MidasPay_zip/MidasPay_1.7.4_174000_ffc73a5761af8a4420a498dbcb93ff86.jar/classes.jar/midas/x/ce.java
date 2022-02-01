package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONObject;

public class ce
  extends lh
{
  public ce(lw paramlw)
  {
    super(paramlw);
  }
  
  protected boolean a(kz paramkz)
  {
    try
    {
      Object localObject2 = new String(paramkz.b);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultData=");
      ((StringBuilder)localObject1).append((String)localObject2);
      APLog.i("APDataReportAns", ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("{"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith("}"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("}");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      this.j = new JSONObject((String)localObject2).getInt("ret");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultCode=");
      ((StringBuilder)localObject1).append(this.j);
      APLog.d("APDataReportAns", ((StringBuilder)localObject1).toString());
      APLog.d("APDataReportAns", "report ok");
    }
    catch (Exception localException)
    {
      APLog.e("APDataReportAns progressJson", localException.toString());
      this.j = -1;
    }
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ce
 * JD-Core Version:    0.7.0.1
 */