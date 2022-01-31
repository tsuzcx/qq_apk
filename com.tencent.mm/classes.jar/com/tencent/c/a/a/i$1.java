package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i$1
  implements Runnable
{
  public i$1(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(125770);
    try
    {
      new StringBuilder("receive data:").append(this.bUM);
      s.zU();
      int k = 100;
      int j = 3;
      int m = j;
      int i = k;
      Object localObject1;
      Object localObject2;
      long l;
      if (s.cI(this.bUM))
      {
        localObject1 = new JSONObject(this.bUM);
        if (!((JSONObject)localObject1).isNull("mid"))
        {
          localObject2 = ((JSONObject)localObject1).optString("mid");
          if ((s.cJ((String)localObject2)) && (!s.cJ(this.bUL.zO())))
          {
            i.a(this.bUL).bUE = ((String)localObject2);
            i.a(this.bUL).bUD = s.aP(i.zQ());
            i.a(this.bUL).bpw = s.getImei(i.zQ());
            if (((JSONObject)localObject1).isNull("ts")) {
              break label353;
            }
            l = ((JSONObject)localObject1).optLong("ts");
            if (l <= 0L) {}
          }
        }
      }
      label353:
      for (i.a(this.bUL).bUF = l;; i.a(this.bUL).bUF = System.currentTimeMillis())
      {
        new StringBuilder("new mid midEntity:").append(i.a(this.bUL).toString());
        s.zU();
        r.aN(i.zQ()).b(i.a(this.bUL));
        i = k;
        if (!((JSONObject)localObject1).isNull(a.bUo)) {
          i = ((JSONObject)localObject1).getInt(a.bUo);
        }
        if (!((JSONObject)localObject1).isNull(a.bUp)) {
          j = ((JSONObject)localObject1).getInt(a.bUp);
        }
        j.bUN = ((JSONObject)localObject1).optInt("disable", 0);
        j.bUO = ((JSONObject)localObject1).optInt("limit", 0);
        m = j;
        localObject1 = r.aN(i.zQ());
        localObject2 = ((r)localObject1).zT();
        if (i > 0) {
          ((a)localObject2).bUk = i;
        }
        if (m > 0) {
          ((a)localObject2).bUl = m;
        }
        ((a)localObject2).bUi = System.currentTimeMillis();
        ((a)localObject2).bUj = 0;
        ((r)localObject1).b((a)localObject2);
        AppMethodBeat.o(125770);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      s.zW();
      AppMethodBeat.o(125770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.c.a.a.i.1
 * JD-Core Version:    0.7.0.1
 */