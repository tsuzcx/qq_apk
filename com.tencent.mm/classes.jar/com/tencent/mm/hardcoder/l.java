package com.tencent.mm.hardcoder;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  implements k.a
{
  public static Context context;
  public static int dFs = -1;
  public static int dFt = -1;
  protected final Map<Integer, a> dFq = new TreeMap();
  protected int dFr = 0;
  
  public l(Context paramContext)
  {
    context = paramContext;
  }
  
  private void update()
  {
    this.dFr = this.dFq.size();
  }
  
  public final void BP()
  {
    this.dFq.clear();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        Object localObject1 = Build.MODEL;
        if (localObject1 == null) {
          return;
        }
        c.i("HardCoder.PowerConsumption", String.format("[oneliang] device model:%s", new Object[] { localObject1 }));
        localObject1 = ((String)localObject1).toUpperCase();
        localObject2 = context.getAssets().open("hardcoder/power.json");
        localObject3 = new StringBuilder();
        k.a((InputStream)localObject2, new k.a()
        {
          public final boolean fz(String paramAnonymousString)
          {
            this.dFu.append(paramAnonymousString);
            return true;
          }
        });
        localObject2 = new JSONObject(((StringBuilder)localObject3).toString());
        if (!((JSONObject)localObject2).has((String)localObject1)) {
          break label312;
        }
        localObject1 = ((JSONObject)localObject2).getJSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).keys();
        int i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label500;
        }
        ((Iterator)localObject2).next();
        i += 1;
        continue;
        if ((j >= i) || (!((JSONObject)localObject1).has("cluster" + j))) {
          break label312;
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("cluster" + j);
        int k = 0;
        if (k < ((JSONArray)localObject2).length())
        {
          fz(((JSONArray)localObject2).getString(k));
          k += 1;
          continue;
        }
        update();
        switch (j)
        {
        case 0: 
          dFs = this.dFr - 1;
        }
      }
      catch (Exception localException)
      {
        c.e("HardCoder.PowerConsumption", "initialize exception:" + localException.getMessage());
        return;
      }
      dFt = this.dFr - 1;
      break label505;
      label312:
      c.i("HardCoder.PowerConsumption", String.format("[oneliang] cluster0:%s,cluster1:%s", new Object[] { Integer.valueOf(dFs), Integer.valueOf(dFt) }));
      Iterator localIterator = this.dFq.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        c.i("HardCoder.PowerConsumption", "config cpu:" + ((Map.Entry)localObject2).getKey());
        localObject2 = ((a)((Map.Entry)localObject2).getValue()).dFw.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          c.i("HardCoder.PowerConsumption", ((Map.Entry)localObject3).getKey() + "," + ((Map.Entry)localObject3).getValue());
        }
      }
      return;
      label500:
      int j = 0;
      continue;
      label505:
      j += 1;
    }
  }
  
  public final void BQ()
  {
    this.dFq.clear();
    k.a("/sdcard/power.csv", this);
    update();
    k.a("/sdcard/power1.csv", this);
    Iterator localIterator = this.dFq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      c.i("HardCoder.PowerConsumption", "cpu:" + ((Map.Entry)localObject).getKey());
      localObject = ((a)((Map.Entry)localObject).getValue()).dFw.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        c.i("HardCoder.PowerConsumption", localEntry.getKey() + "," + localEntry.getValue());
      }
    }
  }
  
  public final boolean fz(String paramString)
  {
    String[] arrayOfString = paramString.trim().split(",");
    if (arrayOfString.length > 0)
    {
      long l = Long.parseLong(arrayOfString[0]);
      int i = 1;
      if (i < arrayOfString.length)
      {
        Integer localInteger = Integer.valueOf(this.dFr + i - 1);
        if (this.dFq.containsKey(localInteger)) {
          paramString = (a)this.dFq.get(localInteger);
        }
        for (;;)
        {
          paramString.dFw.put(Long.valueOf(l), Integer.valueOf(Integer.parseInt(arrayOfString[i], 0)));
          i += 1;
          break;
          paramString = new a();
          this.dFq.put(localInteger, paramString);
        }
      }
    }
    return true;
  }
  
  public static final class a
  {
    public final Map<Long, Integer> dFw = new TreeMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.l
 * JD-Core Version:    0.7.0.1
 */