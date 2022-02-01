package a.a.a.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.secprotocol.t.s;
import org.json.JSONObject;

public class f
{
  public Context a;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public JSONObject a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(g.a(0), paramInt1);
      localJSONObject.put(g.a(1), paramInt2);
      localJSONObject.put(g.a(2), paramb.b);
      localJSONObject.put(g.a(3), paramb.d);
      localJSONObject.put(g.a(4), paramb.c);
      localJSONObject.put(g.a(5), paramb.e);
      localJSONObject.put(g.a(6), paramString);
      localJSONObject.put(g.a(7), paramb.f);
      localJSONObject.put(g.a(8), paramb.g);
      localJSONObject.put(g.a(9), Build.VERSION.SDK_INT);
      localJSONObject.put(g.a(10), s.b(paramb.a));
      localJSONObject.put(g.a(11), paramb.h);
      localJSONObject.put(g.a(12), System.currentTimeMillis());
      localJSONObject.put(g.a(13), 1);
      localJSONObject.put(g.a(14), "");
      localJSONObject.put(g.a(15), s.getProcessName(this.a));
      localJSONObject.put(g.a(16), s.c(this.a));
      localJSONObject.put(g.a(17), s.d(this.a));
      localJSONObject.put(g.a(18), s.e(this.a));
      return localJSONObject;
    }
    finally
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     a.a.a.b.f
 * JD-Core Version:    0.7.0.1
 */