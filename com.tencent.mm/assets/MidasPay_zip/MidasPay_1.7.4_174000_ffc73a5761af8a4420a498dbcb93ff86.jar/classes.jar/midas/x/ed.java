package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ed
  extends lh
{
  private String a = "delay";
  private String b = "";
  private String c = "";
  private int d = -1;
  
  public ed(lw paramlw)
  {
    super(paramlw);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APhfAns", localStringBuilder.toString());
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.j = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
        this.d = this.j;
        int i;
        if (this.j == 0)
        {
          i = ((JSONObject)localObject).getInt("state");
          if (i == -1) {}
        }
        switch (i)
        {
        case 4: 
          this.a = "delay";
          break;
          this.a = "succeed";
          break;
        case 3: 
          this.a = "failed";
          break;
        case 1: 
        case 2: 
        case 5: 
        case 6: 
          this.a = "delay";
          break;
          this.a = "delay";
          if (((JSONObject)localObject).has("msg")) {
            this.b = ((JSONObject)localObject).getString("msg").toString();
          }
          if (((JSONObject)localObject).has("err_code")) {
            this.c = ((JSONObject)localObject).getString("err_code").toString();
          }
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return super.a(paramkz);
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ed
 * JD-Core Version:    0.7.0.1
 */