package com.tencent.mm.plugin.expt.d.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.b.g;

public final class a
{
  public Map<String, Long> qXS;
  
  public a()
  {
    AppMethodBeat.i(195894);
    this.qXS = new HashMap();
    coM();
    AppMethodBeat.o(195894);
  }
  
  private void coM()
  {
    AppMethodBeat.i(195895);
    Object localObject = b.coF();
    if (localObject == null)
    {
      AppMethodBeat.o(195895);
      return;
    }
    localObject = ((ay)localObject).getString("mmkv_key_run_record", "");
    String str;
    if (!g.ef((String)localObject))
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
            if (!g.ef(str))
            {
              String[] arrayOfString = str.split(",");
              if ((arrayOfString != null) && (arrayOfString.length > 0)) {
                this.qXS.put(arrayOfString[0], Long.valueOf(Long.parseLong(arrayOfString[1])));
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.e("EdgeComputingRunRecord", "[EdgeComputingConfigRecord] initRecord throw Exception : " + localException.getMessage() + ", rr : " + str);
            }
          }
          i += 1;
        }
      }
    }
    label165:
    AppMethodBeat.o(195895);
  }
  
  public final long aed(String paramString)
  {
    AppMethodBeat.i(195897);
    if (g.ef(paramString))
    {
      AppMethodBeat.o(195897);
      return 0L;
    }
    synchronized (this.qXS)
    {
      paramString = (Long)this.qXS.get(paramString);
      if (paramString != null)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(195897);
        return l;
      }
      AppMethodBeat.o(195897);
      return 0L;
    }
  }
  
  public final void coN()
  {
    AppMethodBeat.i(195896);
    ay localay = b.coF();
    if (localay == null)
    {
      AppMethodBeat.o(195896);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.qXS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str).append(",").append(this.qXS.get(str)).append(";");
    }
    localay.putString("mmkv_key_run_record", localStringBuilder.toString());
    AppMethodBeat.o(195896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b.b.a
 * JD-Core Version:    0.7.0.1
 */