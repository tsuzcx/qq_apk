package com.tencent.mm.hardcoder;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  implements g.a
{
  public static int eCR = -1;
  public static int eCS = -1;
  public static Context eCT;
  protected final Map<Integer, a> eCP;
  protected int eCQ;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(93965);
    this.eCP = new TreeMap();
    this.eCQ = 0;
    eCT = paramContext;
    AppMethodBeat.o(93965);
  }
  
  private void update()
  {
    AppMethodBeat.i(93968);
    this.eCQ = this.eCP.size();
    c.d("HardCoder.PowerConsumption", "update existCpuSize:" + this.eCQ);
    AppMethodBeat.o(93968);
  }
  
  public final void PF()
  {
    AppMethodBeat.i(93966);
    this.eCP.clear();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        Object localObject1 = Build.MODEL;
        if (localObject1 == null)
        {
          AppMethodBeat.o(93966);
          return;
        }
        c.i("HardCoder.PowerConsumption", String.format("[oneliang] device model:%s", new Object[] { localObject1 }));
        localObject1 = ((String)localObject1).toUpperCase();
        localObject2 = eCT.getAssets().open("hardcoder/power.json");
        localObject3 = new StringBuilder();
        g.a((InputStream)localObject2, new g.a()
        {
          public final boolean lS(String paramAnonymousString)
          {
            AppMethodBeat.i(93963);
            this.eCU.append(paramAnonymousString);
            AppMethodBeat.o(93963);
            return true;
          }
        });
        localObject2 = new JSONObject(((StringBuilder)localObject3).toString());
        if (!((JSONObject)localObject2).has((String)localObject1)) {
          break label313;
        }
        localObject1 = ((JSONObject)localObject2).getJSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).keys();
        int i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label506;
        }
        ((Iterator)localObject2).next();
        i += 1;
        continue;
        if ((j >= i) || (!((JSONObject)localObject1).has("cluster".concat(String.valueOf(j))))) {
          break label313;
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("cluster".concat(String.valueOf(j)));
        int k = 0;
        if (k < ((JSONArray)localObject2).length())
        {
          lS(((JSONArray)localObject2).getString(k));
          k += 1;
          continue;
        }
        update();
        switch (j)
        {
        case 0: 
          eCR = this.eCQ - 1;
        }
      }
      catch (Exception localException)
      {
        c.e("HardCoder.PowerConsumption", "initialize exception:" + localException.getMessage());
        AppMethodBeat.o(93966);
        return;
      }
      eCS = this.eCQ - 1;
      break label511;
      label313:
      c.i("HardCoder.PowerConsumption", String.format("[oneliang] cluster0:%d,cluster1:%d", new Object[] { Integer.valueOf(eCR), Integer.valueOf(eCS) }));
      Iterator localIterator = this.eCP.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        c.i("HardCoder.PowerConsumption", "config cpu:" + ((Map.Entry)localObject2).getKey());
        localObject2 = ((a)((Map.Entry)localObject2).getValue()).eCW.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          c.i("HardCoder.PowerConsumption", ((Map.Entry)localObject3).getKey() + "," + ((Map.Entry)localObject3).getValue());
        }
      }
      AppMethodBeat.o(93966);
      return;
      label506:
      int j = 0;
      continue;
      label511:
      j += 1;
    }
  }
  
  public final void PG()
  {
    AppMethodBeat.i(93967);
    this.eCP.clear();
    g.a("/sdcard/power.csv", this);
    update();
    g.a("/sdcard/power1.csv", this);
    Iterator localIterator = this.eCP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      c.i("HardCoder.PowerConsumption", "cpu:" + ((Map.Entry)localObject).getKey());
      localObject = ((a)((Map.Entry)localObject).getValue()).eCW.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        c.i("HardCoder.PowerConsumption", localEntry.getKey() + "," + localEntry.getValue());
      }
    }
    AppMethodBeat.o(93967);
  }
  
  public final boolean lS(String paramString)
  {
    AppMethodBeat.i(93969);
    String[] arrayOfString = paramString.trim().split(",");
    if (arrayOfString.length > 0)
    {
      long l = Long.parseLong(arrayOfString[0]);
      int i = 1;
      if (i < arrayOfString.length)
      {
        Integer localInteger = Integer.valueOf(this.eCQ + i - 1);
        if (this.eCP.containsKey(localInteger)) {
          paramString = (a)this.eCP.get(localInteger);
        }
        for (;;)
        {
          paramString.eCW.put(Long.valueOf(l), Integer.valueOf(Integer.parseInt(arrayOfString[i], 0)));
          i += 1;
          break;
          paramString = new a();
          this.eCP.put(localInteger, paramString);
        }
      }
    }
    AppMethodBeat.o(93969);
    return true;
  }
  
  public static final class a
  {
    public final Map<Long, Integer> eCW;
    
    public a()
    {
      AppMethodBeat.i(93964);
      this.eCW = new TreeMap();
      AppMethodBeat.o(93964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.h
 * JD-Core Version:    0.7.0.1
 */