package midas.x;

import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class dp
  extends lh
{
  public String a = "";
  public ArrayList<Long> b = new ArrayList();
  private String c = dp.class.getSimpleName();
  
  public dp(lw paramlw)
  {
    super(paramlw);
  }
  
  public ArrayList<Long> a()
  {
    return this.b;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onFinishAns content=");
    ((StringBuilder)localObject2).append(paramkz.b.toString());
    APLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new String(paramkz.b);
    try
    {
      localObject1 = new JSONObject((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnAns=");
      localStringBuilder.append((String)localObject2);
      APLog.d("APQueryReceipt", localStringBuilder.toString());
      int j = ((JSONObject)localObject1).getInt("ret");
      if (((JSONObject)localObject1).has("requery_freq"))
      {
        localObject2 = ((JSONObject)localObject1).getString("requery_freq").split(",");
        this.b.clear();
        this.b.add(Long.valueOf(0L));
        int i = 0;
        while (i < localObject2.length)
        {
          this.b.add(Long.valueOf(i.a(localObject2[i])));
          i += 1;
        }
      }
      if (j == 0)
      {
        this.a = ((JSONObject)localObject1).getString("receipt_info");
      }
      else
      {
        localObject2 = ((JSONObject)localObject1).getString("err_code").toString();
        this.k = ((JSONObject)localObject1).getString("msg");
        if (!((String)localObject2).equals(""))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.k);
          ((StringBuilder)localObject1).append(" (");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(")");
          this.k = ((StringBuilder)localObject1).toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dp
 * JD-Core Version:    0.7.0.1
 */