package midas.x;

import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class dh
  extends jw
{
  public String a = "";
  public ArrayList<Long> b = new ArrayList();
  private String c = dh.class.getSimpleName();
  
  public dh(kl paramkl)
  {
    super(paramkl);
  }
  
  public ArrayList<Long> a()
  {
    return this.b;
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = this.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onFinishAns content=");
    ((StringBuilder)localObject2).append(paramjo.b.toString());
    APLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new String(paramjo.b);
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
        this.j = ((JSONObject)localObject1).getString("msg");
        if (!((String)localObject2).equals(""))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.j);
          ((StringBuilder)localObject1).append(" (");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(")");
          this.j = ((StringBuilder)localObject1).toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dh
 * JD-Core Version:    0.7.0.1
 */