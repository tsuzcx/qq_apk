package com.tencent.mm.plugin.expt.edge.config.b;

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
  public Map<String, Long> zzD;
  
  public a()
  {
    AppMethodBeat.i(299794);
    this.zzD = new HashMap();
    dIn();
    AppMethodBeat.o(299794);
  }
  
  private void dIn()
  {
    AppMethodBeat.i(299804);
    Object localObject = b.dIb();
    if (localObject == null)
    {
      AppMethodBeat.o(299804);
      return;
    }
    localObject = ((MultiProcessMMKV)localObject).getString("mmkv_key_run_record", "");
    String str;
    if (!i.hm((String)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label166;
          }
          str = localObject[i];
          try
          {
            if (!i.hm(str))
            {
              String[] arrayOfString = str.split(",");
              if ((arrayOfString != null) && (arrayOfString.length > 0)) {
                this.zzD.put(arrayOfString[0], Long.valueOf(Util.getLong(arrayOfString[1], 0L)));
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("EdgeComputingRunRecord", "[EdgeComputingConfigRecord] initRecord throw Exception : " + localException.getMessage() + ", rr : " + str);
            }
          }
          i += 1;
        }
      }
    }
    label166:
    AppMethodBeat.o(299804);
  }
  
  public final long aqm(String paramString)
  {
    AppMethodBeat.i(299825);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299825);
      return 0L;
    }
    synchronized (this.zzD)
    {
      paramString = (Long)this.zzD.get(paramString);
      if (paramString != null)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(299825);
        return l;
      }
      AppMethodBeat.o(299825);
      return 0L;
    }
  }
  
  public final void dIo()
  {
    AppMethodBeat.i(299813);
    MultiProcessMMKV localMultiProcessMMKV = b.dIb();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(299813);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.zzD.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.zzD.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_run_record", localStringBuilder.toString());
    AppMethodBeat.o(299813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.config.b.a
 * JD-Core Version:    0.7.0.1
 */