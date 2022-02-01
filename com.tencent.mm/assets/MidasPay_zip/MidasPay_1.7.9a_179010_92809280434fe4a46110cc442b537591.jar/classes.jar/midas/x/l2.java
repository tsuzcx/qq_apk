package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l2
  extends ob
{
  public boolean g = false;
  public ArrayList<zc> h;
  
  public l2(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = paramgb.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("APGetIPListAns", ((StringBuilder)localObject2).toString());
    label526:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (Integer.parseInt(((JSONObject)localObject1).getString("ret").toString()) == 0)
        {
          this.g = true;
          this.h = new ArrayList();
          boolean bool = ((JSONObject)localObject1).has("info");
          int i;
          Object localObject3;
          if (bool)
          {
            localObject2 = ((JSONObject)localObject1).getJSONArray("info");
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              Object localObject4 = ((JSONArray)localObject2).getJSONObject(i);
              localObject3 = ((JSONObject)localObject4).getString("ip");
              localObject4 = ((JSONObject)localObject4).optString("cat");
              localObject3 = new zc((String)localObject3);
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                ((zc)localObject3).e = Integer.valueOf(0);
              } else if (((String)localObject4).contains("qdiao_best")) {
                ((zc)localObject3).e = Integer.valueOf(1);
              } else if (((String)localObject4).contains("qdiao_better")) {
                ((zc)localObject3).e = Integer.valueOf(2);
              } else {
                ((zc)localObject3).e = Integer.valueOf(3);
              }
              this.h.add(localObject3);
              i += 1;
              continue;
            }
          }
          if (((JSONObject)localObject1).has("info_ipv6"))
          {
            localObject1 = ((JSONObject)localObject1).getJSONArray("info_ipv6");
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject3 = ((JSONArray)localObject1).getJSONObject(i);
              localObject2 = ((JSONObject)localObject3).getString("ip");
              localObject3 = ((JSONObject)localObject3).optString("cat");
              localObject2 = new zc((String)localObject2);
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                ((zc)localObject2).e = Integer.valueOf(0);
                break label526;
              }
              if (((String)localObject3).contains("qdiao_best"))
              {
                ((zc)localObject2).e = Integer.valueOf(1);
                break label526;
              }
              if (((String)localObject3).contains("qdiao_better"))
              {
                ((zc)localObject2).e = Integer.valueOf(2);
                break label526;
              }
              ((zc)localObject2).e = Integer.valueOf(3);
              this.h.add(localObject2);
              i += 1;
              continue;
            }
          }
        }
        else
        {
          this.b = ((JSONObject)localObject1).optString("msg");
          localObject1 = ((JSONObject)localObject1).optString("err_code");
          if (!((String)localObject1).equals(""))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(")");
            this.b = ((StringBuilder)localObject2).toString();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
        ((StringBuilder)localObject2).append(x1.a(20003));
        this.b = ((StringBuilder)localObject2).toString();
        localJSONException.printStackTrace();
      }
      return super.d(paramgb);
    }
  }
  
  public ArrayList<zc> g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l2
 * JD-Core Version:    0.7.0.1
 */