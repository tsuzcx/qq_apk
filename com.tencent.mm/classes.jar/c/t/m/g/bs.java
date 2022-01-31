package c.t.m.g;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bs
  extends bq
{
  br a = new br("HttpSchedulerHandler");
  
  public final void a()
  {
    m.i().post(new bt(this, null, null));
  }
  
  public final void a(bm parambm)
  {
    try
    {
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      x.e();
      localObject = ((br)localObject).a(x.b());
      if (!cm.a((byte[])localObject))
      {
        localObject = new JSONObject(new String((byte[])localObject));
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("resultMap");
          if (localObject != null)
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray(str);
              if (localJSONArray != null)
              {
                JSONObject localJSONObject3 = new JSONObject();
                int i = 0;
                while (i < localJSONArray.length())
                {
                  JSONObject localJSONObject4 = localJSONArray.getJSONObject(i);
                  localJSONObject3.put(localJSONObject4.optString("unit"), localJSONObject4.optString("schedulecode"));
                  i += 1;
                }
                localJSONObject2.put(str, localJSONObject3);
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put(m.b(), new JSONObject());
          parambm.a.put("directScheduleCodes", localJSONObject1);
          return;
        }
        catch (Exception parambm)
        {
          JSONObject localJSONObject2;
          return;
        }
        localJSONObject2.put(m.b(), new JSONObject());
        parambm.a.put("directScheduleCodes", localJSONObject2);
        return;
        localJSONObject2.put(m.b(), new JSONObject());
        continue;
        JSONObject localJSONObject1 = null;
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("AccessScheduleRsp");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.toString();
        if (!cm.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!cm.a(paramJSONObject))
          {
            String str = x.b();
            this.a.a(str, paramJSONObject);
            m.i().post(new bt(this, str, paramJSONObject));
          }
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public final String c()
  {
    return "accessscheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.bs
 * JD-Core Version:    0.7.0.1
 */