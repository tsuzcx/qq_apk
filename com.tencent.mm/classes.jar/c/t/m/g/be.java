package c.t.m.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class be
  implements Runnable
{
  be(bd parambd) {}
  
  public final void run()
  {
    Object localObject1 = x.b();
    bd localbd = this.a;
    Object localObject2 = this.a.a.a((String)localObject1);
    try
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!cm.a((byte[])localObject2)))
      {
        localObject2 = new JSONObject(new String((byte[])localObject2));
        localObject1 = new u((String)localObject1);
        ((JSONObject)localObject2).getString("ipInfo");
        localObject2 = ((JSONObject)localObject2).optJSONObject("resultMap");
        if (localObject2 != null)
        {
          Iterator localIterator = ((JSONObject)localObject2).keys();
          while (localIterator.hasNext())
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray((String)localIterator.next());
            if (localJSONArray != null) {
              bd.a((u)localObject1, localJSONArray);
            }
          }
        }
        localbd.b = ((u)localObject1);
        p.c();
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.be
 * JD-Core Version:    0.7.0.1
 */