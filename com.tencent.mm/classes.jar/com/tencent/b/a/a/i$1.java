package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i$1
  implements Runnable
{
  public i$1(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(87652);
    try
    {
      new StringBuilder("receive data:").append(this.cPt);
      s.JS();
      int k = 100;
      int j = 3;
      int m = j;
      int i = k;
      Object localObject1;
      Object localObject2;
      long l;
      if (s.ep(this.cPt))
      {
        localObject1 = new JSONObject(this.cPt);
        if (!((JSONObject)localObject1).isNull("mid"))
        {
          localObject2 = ((JSONObject)localObject1).optString("mid");
          if ((s.eq((String)localObject2)) && (!s.eq(this.cPs.JM())))
          {
            i.a(this.cPs).cPl = ((String)localObject2);
            i.a(this.cPs).cPk = s.bb(i.JO());
            i.a(this.cPs).bZM = s.ba(i.JO());
            if (((JSONObject)localObject1).isNull("ts")) {
              break label353;
            }
            l = ((JSONObject)localObject1).optLong("ts");
            if (l <= 0L) {}
          }
        }
      }
      label353:
      for (i.a(this.cPs).cPm = l;; i.a(this.cPs).cPm = System.currentTimeMillis())
      {
        new StringBuilder("new mid midEntity:").append(i.a(this.cPs).toString());
        s.JS();
        r.aY(i.JO()).b(i.a(this.cPs));
        i = k;
        if (!((JSONObject)localObject1).isNull(a.cOU)) {
          i = ((JSONObject)localObject1).getInt(a.cOU);
        }
        if (!((JSONObject)localObject1).isNull(a.cOV)) {
          j = ((JSONObject)localObject1).getInt(a.cOV);
        }
        j.cPu = ((JSONObject)localObject1).optInt("disable", 0);
        j.cPv = ((JSONObject)localObject1).optInt("limit", 0);
        m = j;
        localObject1 = r.aY(i.JO());
        localObject2 = ((r)localObject1).JR();
        if (i > 0) {
          ((a)localObject2).cOQ = i;
        }
        if (m > 0) {
          ((a)localObject2).cOR = m;
        }
        ((a)localObject2).cOO = System.currentTimeMillis();
        ((a)localObject2).cOP = 0;
        ((r)localObject1).b((a)localObject2);
        AppMethodBeat.o(87652);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      s.JU();
      AppMethodBeat.o(87652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.i.1
 * JD-Core Version:    0.7.0.1
 */