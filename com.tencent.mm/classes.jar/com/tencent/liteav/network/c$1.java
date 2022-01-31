package com.tencent.liteav.network;

import java.util.ArrayList;
import org.json.JSONObject;

class c$1
  extends Thread
{
  c$1(c paramc, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  public void run()
  {
    if (this.c.a == null) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject3 = localArrayList1;
      Object localObject2;
      if (i < 5) {
        localObject2 = localArrayList1;
      }
      try
      {
        localObject3 = c.a(this.c, this.a, this.b);
        try
        {
          localObject2 = new JSONObject((String)localObject3);
          if (!((JSONObject)localObject2).has("use")) {
            break label103;
          }
          int j = ((JSONObject)localObject2).getInt("use");
          if (j != 0) {
            break label103;
          }
          localObject3 = localArrayList1;
        }
        catch (Exception localException2)
        {
          do
          {
            localArrayList2 = localArrayList1;
            localArrayList1 = c.a(this.c, (String)localObject3);
            if (localArrayList1 == null) {
              break;
            }
            localObject3 = localArrayList1;
            localArrayList2 = localArrayList1;
          } while (localArrayList1.size() > 0);
          localArrayList2 = localArrayList1;
          sleep(1000L, 0);
        }
        this.c.a.onFetchDone(0, (ArrayList)localObject3);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          label103:
          ArrayList localArrayList2;
          Object localObject1 = localArrayList2;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.network.c.1
 * JD-Core Version:    0.7.0.1
 */