package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ck
  extends lh
{
  private boolean a = false;
  private ArrayList<mi> b;
  
  public ck(lw paramlw)
  {
    super(paramlw);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = paramkz.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("APGetIPListAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (Integer.parseInt(((JSONObject)localObject1).getString("ret").toString()) == 0)
      {
        this.a = true;
        this.b = new ArrayList();
        int i;
        Object localObject3;
        if (((JSONObject)localObject1).has("info"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONArray("info");
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            Object localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            localObject3 = ((JSONObject)localObject4).getString("ip");
            localObject4 = ((JSONObject)localObject4).optString("cat");
            localObject3 = new mi((String)localObject3);
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              ((mi)localObject3).e = Integer.valueOf(0);
            } else if (((String)localObject4).contains("qdiao_best")) {
              ((mi)localObject3).e = Integer.valueOf(1);
            } else if (((String)localObject4).contains("qdiao_better")) {
              ((mi)localObject3).e = Integer.valueOf(2);
            } else {
              ((mi)localObject3).e = Integer.valueOf(3);
            }
            this.b.add(localObject3);
            i += 1;
          }
        }
        if (((JSONObject)localObject1).has("info_ipv6"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("info_ipv6");
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            localObject2 = ((JSONObject)localObject3).getString("ip");
            localObject3 = ((JSONObject)localObject3).optString("cat");
            localObject2 = new mi((String)localObject2);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              ((mi)localObject2).e = Integer.valueOf(0);
            } else if (((String)localObject3).contains("qdiao_best")) {
              ((mi)localObject2).e = Integer.valueOf(1);
            } else if (((String)localObject3).contains("qdiao_better")) {
              ((mi)localObject2).e = Integer.valueOf(2);
            } else {
              ((mi)localObject2).e = Integer.valueOf(3);
            }
            this.b.add(localObject2);
            i += 1;
          }
        }
      }
      else
      {
        this.k = ((JSONObject)localObject1).optString("msg");
        localObject1 = ((JSONObject)localObject1).optString("err_code");
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          this.k = ((StringBuilder)localObject2).toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject2).append(bw.a(20003));
      this.k = ((StringBuilder)localObject2).toString();
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
  }
  
  public ArrayList<mi> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ck
 * JD-Core Version:    0.7.0.1
 */