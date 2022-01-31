package com.tencent.mm.modelstat;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class c$a
{
  Map<String, Boolean> eCi = new HashMap();
  long eCj;
  long eCk;
  List<c.c> eCs = new ArrayList();
  
  static a nr(String paramString)
  {
    a locala = new a();
    Map localMap;
    try
    {
      localMap = bn.s(paramString, "eventSampleConf");
      if (localMap == null)
      {
        y.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[] { paramString });
        throw new a("reportConfigMap is null");
      }
    }
    catch (Exception paramString)
    {
      throw new a(paramString);
    }
    locala.eCj = bk.getLong((String)localMap.get(".eventSampleConf.nextUpdateInterval"), 0L);
    if ((locala.eCj <= 0L) || (locala.eCj > 432000L)) {
      locala.eCj = 432000L;
    }
    locala.eCk = bk.getLong((String)localMap.get(".eventSampleConf.samplePeriod"), 0L);
    int i = 0;
    c.c localc = new c.c((byte)0);
    Object localObject1 = new StringBuilder(".eventSampleConf.events.event");
    label161:
    ArrayList localArrayList;
    int j;
    Object localObject2;
    if (i > 0)
    {
      paramString = Integer.valueOf(i);
      localObject1 = paramString + ".";
      localc.id = bk.getInt((String)localMap.get((String)localObject1 + "id"), 0);
      if (localc.id > 0)
      {
        localc.eCv = bk.getLong((String)localMap.get((String)localObject1 + "expireTime"), 0L);
        localc.name = ((String)localMap.get((String)localObject1 + "name"));
        localc.eCw = bk.getFloat((String)localMap.get((String)localObject1 + "rate"), 0.0F);
        localc.dCy = bk.getInt((String)localMap.get((String)localObject1 + "logId"), 0);
        localc.eCx = ((String)localMap.get((String)localObject1 + "pages.$type"));
        localArrayList = new ArrayList();
        j = 0;
        for (;;)
        {
          localObject2 = new StringBuilder().append((String)localObject1).append("pages.page");
          if (j <= 0) {
            break label795;
          }
          paramString = Integer.valueOf(j);
          label450:
          paramString = paramString + ".";
          localObject2 = (String)localMap.get(paramString + "$id");
          if (localObject2 == null) {
            break;
          }
          boolean bool = ((String)localMap.get(paramString + "$action")).equals("true");
          localArrayList.add(new Pair(localObject2, Boolean.valueOf(bool)));
          locala.eCi.put(localObject2, Boolean.valueOf(bool));
          j += 1;
        }
        localc.eCy = localArrayList;
        localArrayList = new ArrayList();
        j = 0;
        label597:
        localObject2 = new StringBuilder().append((String)localObject1).append("specialPVPages.pageItem");
        if (j <= 0) {
          break label801;
        }
      }
    }
    label795:
    label801:
    for (paramString = Integer.valueOf(j);; paramString = "")
    {
      paramString = paramString + ".";
      localObject2 = (String)localMap.get(paramString + "$prePage");
      if (localObject2 != null)
      {
        localArrayList.add(new Pair(localObject2, (String)localMap.get(paramString + "$page")));
        j += 1;
        break label597;
      }
      localc.eCz = localArrayList;
      locala.eCs.add(localc);
      y.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[] { localc });
      i += 1;
      break;
      y.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[] { locala });
      return locala;
      paramString = "";
      break label161;
      paramString = "";
      break label450;
    }
  }
  
  public final String toString()
  {
    return "Config{nextUpdateInterval=" + this.eCj + ", samplePeriod=" + this.eCk + ", eventList=" + this.eCs + '}';
  }
  
  static final class a
    extends Exception
  {
    a(String paramString)
    {
      super();
    }
    
    a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.a
 * JD-Core Version:    0.7.0.1
 */