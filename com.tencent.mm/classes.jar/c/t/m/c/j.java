package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  implements Runnable
{
  private Context a;
  private List<a> b;
  private boolean c;
  private List<a> d;
  private c e;
  private boolean f;
  
  public j(Context paramContext, List<a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(136367);
    this.b = null;
    this.c = false;
    this.d = null;
    this.e = null;
    this.f = false;
    this.a = paramContext;
    this.f = paramBoolean;
    this.b = new ArrayList();
    this.b.addAll(paramList);
    this.e = new c(this.a);
    AppMethodBeat.o(136367);
  }
  
  private boolean a()
  {
    AppMethodBeat.i(136370);
    Object localObject = b();
    if (localObject == null)
    {
      AppMethodBeat.o(136370);
      return false;
    }
    localObject = ((String)localObject).getBytes();
    if (localObject != null)
    {
      new HashMap();
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        if (i >= 3) {
          break;
        }
        byte[] arrayOfByte = p.a("https://cc.map.qq.com?desc_c", (byte[])localObject);
        if (arrayOfByte != null)
        {
          localObject = new String(arrayOfByte);
          e.a(this.a).a("DRG", "response suc,try:".concat(String.valueOf(j)));
          boolean bool = a((String)localObject);
          AppMethodBeat.o(136370);
          return bool;
        }
        q.a(10000L);
      }
    }
    AppMethodBeat.o(136370);
    return false;
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(136368);
    paramString = q.c(m.b(paramString, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
    if (paramString == null)
    {
      AppMethodBeat.o(136368);
      return true;
    }
    this.d = q.b(paramString);
    Object localObject = q.b(this.a, "__bad_dex_info__", "preference_default");
    boolean bool1 = false;
    localObject = q.b((String)localObject);
    if (!((List)localObject).isEmpty()) {
      bool1 = l.a((List)localObject, this.d);
    }
    boolean bool2 = a(this.b, this.d);
    e.a(this.a).a("DRG", "need and samebad:" + bool2 + "," + bool1);
    if ((!bool2) && (!bool1))
    {
      e.a(this.a).a("DRG", "to download:".concat(String.valueOf(paramString)));
      this.e.a(this.d);
    }
    AppMethodBeat.o(136368);
    return bool2;
  }
  
  private boolean a(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(136369);
    paramList1 = paramList1.iterator();
    boolean bool = true;
    if (paramList1.hasNext())
    {
      a locala1 = (a)paramList1.next();
      Iterator localIterator = paramList2.iterator();
      a locala2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        locala2 = (a)localIterator.next();
        if (!locala2.c.contains(".dex")) {
          locala2.c += ".dex";
        }
      } while ((!locala1.c.equals(locala2.c)) || (locala1.d != locala2.d) || (!locala1.e.equals(locala2.e)));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = false;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(136369);
        return bool;
      }
    }
  }
  
  private String b()
  {
    AppMethodBeat.i(136371);
    JSONObject localJSONObject1 = new JSONObject();
    String str2 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
    try
    {
      localJSONObject1.put("appkey", q.d(this.a));
      localJSONObject1.put("appversion", q.a(this.a));
      localJSONObject1.put("imei", q.e(this.a));
      localJSONObject1.put("coverSDKver", i.a);
      localJSONObject1.put("model", q.b() + "_" + q.a());
      localJSONObject1.put("APILevel", q.c());
      JSONArray localJSONArray = new JSONArray();
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala != null)
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("compId", locala.a);
            localJSONObject2.put("compVer", locala.b);
            localJSONObject2.put("size", locala.d);
            localJSONObject2.put("md5", q.a(new File(str2, locala.c)));
            localJSONArray.put(localJSONObject2);
          }
        }
      }
      localException.put("compList", localJSONArray);
    }
    catch (Exception localException)
    {
      e.a(this.a).a("DRG", "reqDerror:" + localException.toString());
      AppMethodBeat.o(136371);
      return null;
    }
    String str1 = localException.toString();
    e.a(this.a).a("DRG", "req:".concat(String.valueOf(str1)));
    str1 = m.a(str1, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
    AppMethodBeat.o(136371);
    return str1;
  }
  
  private boolean c()
  {
    AppMethodBeat.i(136373);
    long l = q.b(this.a, "__last_check_update_time__", Long.valueOf(0L)).longValue();
    if (System.currentTimeMillis() - l > 3600000L)
    {
      AppMethodBeat.o(136373);
      return true;
    }
    AppMethodBeat.o(136373);
    return false;
  }
  
  public void run()
  {
    AppMethodBeat.i(136372);
    if (!this.f) {}
    try
    {
      Thread.sleep(2000L);
      label19:
      boolean bool = c();
      e.a(this.a).a("DRG", "t:" + bool + ",i:" + this.f);
      a();
      q.a(this.a, "__last_check_update_time__", Long.valueOf(System.currentTimeMillis()));
      e.a(this.a).c();
      AppMethodBeat.o(136372);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.j
 * JD-Core Version:    0.7.0.1
 */