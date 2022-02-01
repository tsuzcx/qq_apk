package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  public static i hTT;
  private Map<String, String> hTU;
  
  static
  {
    AppMethodBeat.i(127692);
    hTT = new i();
    AppMethodBeat.o(127692);
  }
  
  public final Map<String, String> cM(Context paramContext)
  {
    AppMethodBeat.i(127691);
    for (;;)
    {
      int i;
      try
      {
        paramContext = bt.Q(paramContext.getAssets().open("config/EmailAddress.xml"));
        boolean bool = bt.isNullOrNil(paramContext);
        if (bool)
        {
          AppMethodBeat.o(127691);
          return null;
        }
        Map localMap = bw.K(paramContext, "config");
        if ((localMap == null) || (localMap.isEmpty()))
        {
          ad.d("MicroMsg.EmailFormater", "values null");
          AppMethodBeat.o(127691);
          return null;
        }
        if (this.hTU == null)
        {
          this.hTU = new HashMap();
          i = 0;
          Object localObject = new StringBuilder(".config.format");
          if (i == 0)
          {
            paramContext = "";
            localObject = paramContext;
            if (localMap.get(localObject) == null) {
              continue;
            }
            paramContext = (String)localObject + ".emaildomain";
            localObject = (String)localObject + ".loginpage";
            paramContext = (String)localMap.get(paramContext);
            localObject = (String)localMap.get(localObject);
            if ((bt.isNullOrNil(paramContext)) || (bt.isNullOrNil((String)localObject))) {
              break label290;
            }
            this.hTU.put(paramContext, localObject);
            break label290;
          }
        }
        else
        {
          paramContext = this.hTU;
          AppMethodBeat.o(127691);
          return paramContext;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.hTU;
        AppMethodBeat.o(127691);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(127691);
        return null;
      }
      label290:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.i
 * JD-Core Version:    0.7.0.1
 */