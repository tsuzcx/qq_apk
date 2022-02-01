package com.tencent.mm.plugin.expt.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.g;

public final class a
{
  public Map<String, Long> qPV;
  private Map<String, Long> qPW;
  public Map<String, Long> qPX;
  private Map<String, Long> qPY;
  
  public a()
  {
    AppMethodBeat.i(210244);
    this.qPV = new HashMap();
    this.qPW = new HashMap();
    this.qPX = new HashMap();
    this.qPY = new HashMap();
    aVm();
    AppMethodBeat.o(210244);
  }
  
  private static ax Lv()
  {
    AppMethodBeat.i(210247);
    Object localObject = new StringBuilder("mmkv_name_edge_computing_breaker_");
    d.crP();
    localObject = ax.aQz(d.getUin());
    AppMethodBeat.o(210247);
    return localObject;
  }
  
  private void aVm()
  {
    AppMethodBeat.i(210245);
    Object localObject3 = Lv();
    if (localObject3 == null)
    {
      AppMethodBeat.o(210245);
      return;
    }
    Object localObject1 = new HashMap();
    Object localObject2 = ((ax)localObject3).getString("mmkv_key_script_config_recorder", "");
    int j;
    int i;
    String str;
    if (!g.ea((String)localObject2))
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
            if (!g.ea(str))
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
              ad.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder scriptConfigRecorder throw Exception : " + localException1.getMessage() + ", record : " + str);
            }
          }
          i += 1;
        }
      }
    }
    label183:
    localObject2 = new HashMap();
    localObject3 = ((ax)localObject3).getString("mmkv_key_sql_config_recorder", "");
    if (!g.ea((String)localObject3))
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
            if (!g.ea(str))
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
              ad.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder sqlConfigRecorder throw Exception : " + localException2.getMessage() + ", record : " + str);
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
        this.qPV.put(str, Long.valueOf(l));
        this.qPX.put(str, Long.valueOf(l));
        ad.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorScriptConfigRecord : " + str + ", time : " + l);
      }
    }
    localObject1 = ((Map)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (l - ((Long)((Map)localObject2).get(localObject3)).longValue() < 129600000L)
      {
        this.qPW.put(localObject3, Long.valueOf(l));
        this.qPY.put(localObject3, Long.valueOf(l));
        ad.e("EdgeComputingConfigBreaker", "[EdgeComputingConfigBreaker] initRecorder errorSqlConfigRecord : " + (String)localObject3 + ", time : " + l);
      }
    }
    cnn();
    AppMethodBeat.o(210245);
  }
  
  public final void cnn()
  {
    AppMethodBeat.i(210246);
    ax localax = Lv();
    if (localax == null)
    {
      AppMethodBeat.o(210246);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.qPX.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.qPX.get(str)).append(";");
    }
    localax.putString("mmkv_key_script_config_recorder", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localIterator = this.qPY.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.qPY.get(str)).append(";");
    }
    localax.putString("mmkv_key_sql_config_recorder", localStringBuilder.toString());
    AppMethodBeat.o(210246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */