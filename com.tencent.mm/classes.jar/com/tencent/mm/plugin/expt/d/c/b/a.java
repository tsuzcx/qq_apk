package com.tencent.mm.plugin.expt.d.c.b;

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
  public Map<String, Long> wdU;
  
  public a()
  {
    AppMethodBeat.i(255113);
    this.wdU = new HashMap();
    dbN();
    AppMethodBeat.o(255113);
  }
  
  private void dbN()
  {
    AppMethodBeat.i(255114);
    Object localObject = b.dbE();
    if (localObject == null)
    {
      AppMethodBeat.o(255114);
      return;
    }
    localObject = ((MultiProcessMMKV)localObject).getString("mmkv_key_run_record", "");
    String str;
    if (!g.fK((String)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label165;
          }
          str = localObject[i];
          try
          {
            if (!g.fK(str))
            {
              String[] arrayOfString = str.split(",");
              if ((arrayOfString != null) && (arrayOfString.length > 0)) {
                this.wdU.put(arrayOfString[0], Long.valueOf(Long.parseLong(arrayOfString[1])));
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
    label165:
    AppMethodBeat.o(255114);
  }
  
  public final long awm(String paramString)
  {
    AppMethodBeat.i(255118);
    if (g.fK(paramString))
    {
      AppMethodBeat.o(255118);
      return 0L;
    }
    synchronized (this.wdU)
    {
      paramString = (Long)this.wdU.get(paramString);
      if (paramString != null)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(255118);
        return l;
      }
      AppMethodBeat.o(255118);
      return 0L;
    }
  }
  
  public final void dbO()
  {
    AppMethodBeat.i(255115);
    MultiProcessMMKV localMultiProcessMMKV = b.dbE();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(255115);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.wdU.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.wdU.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_run_record", localStringBuilder.toString());
    AppMethodBeat.o(255115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */