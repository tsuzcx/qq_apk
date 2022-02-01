package com.tencent.mm.plugin.expt.d.b.b;

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
  public Map<String, Long> syc;
  
  public a()
  {
    AppMethodBeat.i(220316);
    this.syc = new HashMap();
    cMY();
    AppMethodBeat.o(220316);
  }
  
  private void cMY()
  {
    AppMethodBeat.i(220317);
    Object localObject = b.cMR();
    if (localObject == null)
    {
      AppMethodBeat.o(220317);
      return;
    }
    localObject = ((MultiProcessMMKV)localObject).getString("mmkv_key_run_record", "");
    String str;
    if (!g.eP((String)localObject))
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
            if (!g.eP(str))
            {
              String[] arrayOfString = str.split(",");
              if ((arrayOfString != null) && (arrayOfString.length > 0)) {
                this.syc.put(arrayOfString[0], Long.valueOf(Long.parseLong(arrayOfString[1])));
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
    AppMethodBeat.o(220317);
  }
  
  public final long aon(String paramString)
  {
    AppMethodBeat.i(220319);
    if (g.eP(paramString))
    {
      AppMethodBeat.o(220319);
      return 0L;
    }
    synchronized (this.syc)
    {
      paramString = (Long)this.syc.get(paramString);
      if (paramString != null)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(220319);
        return l;
      }
      AppMethodBeat.o(220319);
      return 0L;
    }
  }
  
  public final void cMZ()
  {
    AppMethodBeat.i(220318);
    MultiProcessMMKV localMultiProcessMMKV = b.cMR();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(220318);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.syc.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.syc.get(str)).append(";");
    }
    localMultiProcessMMKV.putString("mmkv_key_run_record", localStringBuilder.toString());
    AppMethodBeat.o(220318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.b.a
 * JD-Core Version:    0.7.0.1
 */