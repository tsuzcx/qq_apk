package com.tencent.c.a.a;

import org.json.JSONObject;

public final class i$1
  implements Runnable
{
  public i$1(i parami, String paramString) {}
  
  public final void run()
  {
    try
    {
      new StringBuilder("receive data:").append(this.btC);
      int k = 100;
      int j = 3;
      int m = j;
      int i = k;
      Object localObject1;
      Object localObject2;
      long l;
      if (s.bF(this.btC))
      {
        localObject1 = new JSONObject(this.btC);
        if (!((JSONObject)localObject1).isNull("mid"))
        {
          localObject2 = ((JSONObject)localObject1).optString("mid");
          if ((s.bG((String)localObject2)) && (!s.bG(this.btB.ry())))
          {
            i.a(this.btB).btu = ((String)localObject2);
            i.a(this.btB).btt = s.ar(i.rA());
            i.a(this.btB).aYO = s.getImei(i.rA());
            if (((JSONObject)localObject1).isNull("ts")) {
              break label337;
            }
            l = ((JSONObject)localObject1).optLong("ts");
            if (l <= 0L) {}
          }
        }
      }
      label337:
      for (i.a(this.btB).btv = l;; i.a(this.btB).btv = System.currentTimeMillis())
      {
        new StringBuilder("new mid midEntity:").append(i.a(this.btB).toString());
        r.ap(i.rA()).b(i.a(this.btB));
        i = k;
        if (!((JSONObject)localObject1).isNull(a.btc)) {
          i = ((JSONObject)localObject1).getInt(a.btc);
        }
        if (!((JSONObject)localObject1).isNull(a.btd)) {
          j = ((JSONObject)localObject1).getInt(a.btd);
        }
        j.btD = ((JSONObject)localObject1).optInt("disable", 0);
        j.btE = ((JSONObject)localObject1).optInt("limit", 0);
        m = j;
        localObject1 = r.ap(i.rA());
        localObject2 = ((r)localObject1).rE();
        if (i > 0) {
          ((a)localObject2).bsY = i;
        }
        if (m > 0) {
          ((a)localObject2).bsZ = m;
        }
        ((a)localObject2).bsW = System.currentTimeMillis();
        ((a)localObject2).bsX = 0;
        ((r)localObject1).b((a)localObject2);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.c.a.a.i.1
 * JD-Core Version:    0.7.0.1
 */