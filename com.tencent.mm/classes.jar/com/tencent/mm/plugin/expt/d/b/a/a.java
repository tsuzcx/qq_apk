package com.tencent.mm.plugin.expt.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.g;

public final class a
{
  public Map<String, Long> sxY;
  private Map<String, Long> sxZ;
  public Map<String, Long> sya;
  public Map<String, Long> syb;
  
  public a()
  {
    AppMethodBeat.i(220313);
    this.sxY = new HashMap();
    this.sxZ = new HashMap();
    this.sya = new HashMap();
    this.syb = new HashMap();
    bqI();
    AppMethodBeat.o(220313);
  }
  
  private void bqI()
  {
    AppMethodBeat.i(220314);
    Object localObject3 = b.cMQ();
    if (localObject3 == null)
    {
      AppMethodBeat.o(220314);
      return;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = ((MultiProcessMMKV)localObject3).getString("mmkv_key_script_config_recorder", "");
    int j;
    int i;
    String str;
    if (!g.eP((String)localObject2))
    {
      localObject2 = ((String)localObject2).split(";");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label183;
          }
          str = localObject2[i];
          try
          {
            if (!g.eP(str))
            {
              String[] arrayOfString1 = str.split(",");
              if ((arrayOfString1 != null) && (arrayOfString1.length > 0)) {
                ((Map)localObject1).put(arrayOfString1[0], Long.valueOf(Long.parseLong(arrayOfString1[1])));
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
    label183:
    localObject2 = new HashMap();
    localObject3 = ((MultiProcessMMKV)localObject3).getString("mmkv_key_sql_config_recorder", "");
    if (!g.eP((String)localObject3))
    {
      localObject3 = ((String)localObject3).split(";");
      if ((localObject3 != null) && (localObject3.length > 0))
      {
        j = localObject3.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label345;
          }
          str = localObject3[i];
          try
          {
            if (!g.eP(str))
            {
              String[] arrayOfString2 = str.split(",");
              if ((arrayOfString2 != null) && (arrayOfString2.length > 0)) {
                ((Map)localObject2).put(arrayOfString2[0], Long.valueOf(Long.parseLong(arrayOfString2[1])));
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
    label345:
    long l = System.currentTimeMillis();
    localObject3 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (l - ((Long)((Map)localObject1).get(str)).longValue() < 129600000L)
      {
        this.sxY.put(str, Long.valueOf(l));
        this.sya.put(str, Long.valueOf(l));
        Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorScriptConfigRecord : " + str + ", time : " + l);
      }
    }
    localObject1 = ((Map)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (l - ((Long)((Map)localObject2).get(localObject3)).longValue() < 129600000L)
      {
        this.sxZ.put(localObject3, Long.valueOf(l));
        this.syb.put(localObject3, Long.valueOf(l));
        Log.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorSqlConfigRecord : " + (String)localObject3 + ", time : " + l);
      }
    }
    cMX();
    AppMethodBeat.o(220314);
  }
  
  public final void cMX()
  {
    AppMethodBeat.i(220315);
    MultiProcessMMKV localMultiProcessMMKV = b.cMQ();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(220315);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.sya.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.sya.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_script_config_recorder", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localIterator = this.syb.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.syb.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_sql_config_recorder", localStringBuilder.toString());
    AppMethodBeat.o(220315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */