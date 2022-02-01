package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
  implements Runnable
{
  public Context a;
  public List<a> b;
  public boolean c;
  public List<a> d;
  public c e;
  public boolean f;
  
  public i(Context paramContext, List<a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(186169);
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
    AppMethodBeat.o(186169);
  }
  
  public final String a()
  {
    AppMethodBeat.i(186183);
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject1 = this.a.getFilesDir().getAbsolutePath() + File.separator + r.b;
    try
    {
      localObject2 = r.k(this.a);
      localJSONObject1.put("appkey", localObject2);
      localJSONObject1.put("appversion", r.b(this.a));
      localJSONObject1.put("imei", r.g(this.a));
      localJSONObject1.put("coverSDKver", h.a);
      localObject2 = new StringBuilder().append(r.e());
      localJSONObject1.put("model", "_" + r.f());
      localJSONObject1.put("APILevel", r.b());
      localObject2 = new JSONArray();
      if (this.b != null)
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = (a)localIterator.next();
          if (localObject3 != null)
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("compId", ((a)localObject3).a);
            localJSONObject2.put("compVer", ((a)localObject3).b);
            localJSONObject2.put("size", ((a)localObject3).d);
            localObject3 = r.a(new File((String)localObject1, ((a)localObject3).c));
            localJSONObject2.put("md5", localObject3);
            ((JSONArray)localObject2).put(localJSONObject2);
          }
        }
      }
      localException.put("compList", localObject2);
    }
    catch (Exception localException)
    {
      e.a(this.a).a("DRG", "reqDerror:" + localException.toString());
      AppMethodBeat.o(186183);
      return null;
    }
    String str = localException.toString();
    localObject1 = e.a(this.a);
    Object localObject2 = new StringBuilder();
    ((e)localObject1).a("DRG", "req:" + str);
    str = m.b(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
    AppMethodBeat.o(186183);
    return str;
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(186174);
    paramString = r.d(m.a(paramString, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
    if (paramString == null)
    {
      AppMethodBeat.o(186174);
      return false;
    }
    this.d = r.e(paramString);
    List localList = r.e(r.b(this.a, "__bad_dex_info___sapp", "preference_default_sapp"));
    if (!localList.isEmpty()) {}
    for (boolean bool1 = l.a(localList, this.d);; bool1 = false)
    {
      boolean bool3 = a(this.b, this.d);
      localList = r.e(r.b(this.a, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "preference_default_sapp"));
      if (!localList.isEmpty()) {}
      for (boolean bool2 = l.a(localList, this.d);; bool2 = false)
      {
        e.a(this.a).a("DRG", "need and samebad:" + bool3 + "," + bool1);
        if ((!bool3) && (!bool1) && (!bool2))
        {
          e.a(this.a).a("DRG", "to download:".concat(String.valueOf(paramString)));
          this.e.b(this.d);
          AppMethodBeat.o(186174);
          return true;
        }
        AppMethodBeat.o(186174);
        return false;
      }
    }
  }
  
  public final boolean a(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(186177);
    paramList1 = paramList1.iterator();
    boolean bool = true;
    label178:
    for (;;)
    {
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
        if (i != 0) {
          break label178;
        }
        bool = false;
        break;
        AppMethodBeat.o(186177);
        return bool;
      }
    }
  }
  
  public final boolean b()
  {
    AppMethodBeat.i(186185);
    long l = r.a(this.a, "__last_check_update_time___sapp", Long.valueOf(0L)).longValue();
    if (System.currentTimeMillis() - l > 3600000L)
    {
      AppMethodBeat.o(186185);
      return true;
    }
    AppMethodBeat.o(186185);
    return false;
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(186179);
    Object localObject = a();
    if (localObject == null)
    {
      AppMethodBeat.o(186179);
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
          AppMethodBeat.o(186179);
          return bool;
        }
        r.a(10000L);
      }
    }
    AppMethodBeat.o(186179);
    return false;
  }
  
  public void run()
  {
    AppMethodBeat.i(186171);
    boolean bool = b();
    e.a(this.a).a("DRG", "t:" + bool + ",i:" + this.f);
    c();
    r.b(this.a, "__last_check_update_time___sapp", Long.valueOf(System.currentTimeMillis()));
    e.a(this.a).d();
    AppMethodBeat.o(186171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.i
 * JD-Core Version:    0.7.0.1
 */