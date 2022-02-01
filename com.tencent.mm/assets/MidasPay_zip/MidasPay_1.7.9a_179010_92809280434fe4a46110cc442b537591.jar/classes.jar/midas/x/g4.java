package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class g4
  extends ob
{
  public String g = "delay";
  public String h = "";
  public String i = "";
  
  public g4(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APhfAns", localStringBuilder.toString());
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.a = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
        int j = this.a;
        if (j == 0) {}
        switch (((JSONObject)localObject).getInt("state"))
        {
        case 4: 
          this.g = "succeed";
          break;
        case 3: 
          this.g = "failed";
          break;
        case -1: 
        case 1: 
        case 2: 
        case 5: 
        case 6: 
          this.g = "delay";
          break;
          this.g = "delay";
          break;
          this.g = "delay";
          if (((JSONObject)localObject).has("msg")) {
            this.h = ((JSONObject)localObject).getString("msg").toString();
          }
          if (((JSONObject)localObject).has("err_code")) {
            this.i = ((JSONObject)localObject).getString("err_code").toString();
          }
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return super.d(paramgb);
    }
  }
  
  public String g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.g4
 * JD-Core Version:    0.7.0.1
 */