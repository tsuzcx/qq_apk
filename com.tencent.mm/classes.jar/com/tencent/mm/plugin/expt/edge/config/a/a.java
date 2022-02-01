package com.tencent.mm.plugin.expt.edge.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.i;

public final class a
{
  public Map<String, Long> zyZ;
  private Map<String, Long> zzA;
  public Map<String, Long> zzB;
  public Map<String, Long> zzC;
  
  public a()
  {
    AppMethodBeat.i(299776);
    this.zyZ = new HashMap();
    this.zzA = new HashMap();
    this.zzB = new HashMap();
    this.zzC = new HashMap();
    caT();
    AppMethodBeat.o(299776);
  }
  
  private void caT()
  {
    AppMethodBeat.i(299784);
    Object localObject3 = b.dIa();
    if (localObject3 == null)
    {
      AppMethodBeat.o(299784);
      return;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = ((MultiProcessMMKV)localObject3).getString("mmkv_key_script_config_recorder", "");
    int j;
    int i;
    String str;
    if (!i.hm((String)localObject2))
    {
      localObject2 = ((String)localObject2).split(";");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label184;
          }
          str = localObject2[i];
          try
          {
            if (!i.hm(str))
            {
              String[] arrayOfString1 = str.split(",");
              if ((arrayOfString1 != null) && (arrayOfString1.length > 0)) {
                ((Map)localObject1).put(arrayOfString1[0], Long.valueOf(Util.getLong(arrayOfString1[1], 0L)));
              }
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder scriptConfigRecorder throw Exception : " + localException1.getMessage() + ", record : " + str);
            }
          }
          i += 1;
        }
      }
    }
    label184:
    localObject2 = new HashMap();
    localObject3 = ((MultiProcessMMKV)localObject3).getString("mmkv_key_sql_config_recorder", "");
    if (!i.hm((String)localObject3))
    {
      localObject3 = ((String)localObject3).split(";");
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        j = localObject3.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label347;
          }
          str = localObject3[i];
          try
          {
            if (!i.hm(str))
            {
              String[] arrayOfString2 = str.split(",");
              if ((arrayOfString2 != null) && (arrayOfString2.length > 0)) {
                ((Map)localObject2).put(arrayOfString2[0], Long.valueOf(Util.getLong(arrayOfString2[1], 0L)));
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder sqlConfigRecorder throw Exception : " + localException2.getMessage() + ", record : " + str);
            }
          }
          i += 1;
        }
      }
    }
    label347:
    long l = System.currentTimeMillis();
    localObject3 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (l - ((Long)((Map)localObject1).get(str)).longValue() < 129600000L)
      {
        this.zyZ.put(str, Long.valueOf(l));
        this.zzB.put(str, Long.valueOf(l));
        Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorScriptConfigRecord : " + str + ", time : " + l);
      }
    }
    localObject1 = ((Map)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (l - ((Long)((Map)localObject2).get(localObject3)).longValue() < 129600000L)
      {
        this.zzA.put(localObject3, Long.valueOf(l));
        this.zzC.put(localObject3, Long.valueOf(l));
        Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorSqlConfigRecord : " + (String)localObject3 + ", time : " + l);
      }
    }
    dIm();
    AppMethodBeat.o(299784);
  }
  
  public final void dIm()
  {
    AppMethodBeat.i(299790);
    MultiProcessMMKV localMultiProcessMMKV = b.dIa();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299790);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.zzB.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.zzB.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_script_config_recorder", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localIterator = this.zzC.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.zzC.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_sql_config_recorder", localStringBuilder.toString());
    AppMethodBeat.o(299790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.config.a.a
 * JD-Core Version:    0.7.0.1
 */