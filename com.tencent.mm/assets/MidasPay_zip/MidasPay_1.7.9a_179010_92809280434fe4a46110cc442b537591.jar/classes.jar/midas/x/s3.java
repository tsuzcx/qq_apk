package midas.x;

import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class s3
  extends ob
{
  public String g = "";
  public ArrayList<Long> h = new ArrayList();
  public String i = s3.class.getSimpleName();
  
  public s3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = this.i;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onFinishAns content=");
    ((StringBuilder)localObject2).append(paramgb.b.toString());
    APLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new String(paramgb.b);
    try
    {
      localObject1 = new JSONObject((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnAns=");
      localStringBuilder.append((String)localObject2);
      APLog.d("APQueryReceipt", localStringBuilder.toString());
      int k = ((JSONObject)localObject1).getInt("ret");
      if (((JSONObject)localObject1).has("requery_freq"))
      {
        localObject2 = ((JSONObject)localObject1).getString("requery_freq").split(",");
        this.h.clear();
        this.h.add(Long.valueOf(0L));
        int j = 0;
        while (j < localObject2.length)
        {
          this.h.add(Long.valueOf(i.b(localObject2[j])));
          j += 1;
        }
      }
      if (k == 0)
      {
        this.g = ((JSONObject)localObject1).getString("receipt_info");
      }
      else
      {
        localObject2 = ((JSONObject)localObject1).getString("err_code").toString();
        this.b = ((JSONObject)localObject1).getString("msg");
        if (!((String)localObject2).equals(""))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append(" (");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(")");
          this.b = ((StringBuilder)localObject1).toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public ArrayList<Long> g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s3
 * JD-Core Version:    0.7.0.1
 */