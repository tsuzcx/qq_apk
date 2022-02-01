package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  public static i iPU;
  private Map<String, String> iPV;
  
  static
  {
    AppMethodBeat.i(127692);
    iPU = new i();
    AppMethodBeat.o(127692);
  }
  
  public final Map<String, String> cV(Context paramContext)
  {
    AppMethodBeat.i(127691);
    for (;;)
    {
      int i;
      try
      {
        paramContext = bu.S(paramContext.getAssets().open("config/EmailAddress.xml"));
        boolean bool = bu.isNullOrNil(paramContext);
        if (bool)
        {
          AppMethodBeat.o(127691);
          return null;
        }
        Map localMap = bx.M(paramContext, "config");
        if ((localMap == null) || (localMap.isEmpty()))
        {
          ae.d("MicroMsg.EmailFormater", "values null");
          AppMethodBeat.o(127691);
          return null;
        }
        if (this.iPV == null)
        {
          this.iPV = new HashMap();
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
            if ((bu.isNullOrNil(paramContext)) || (bu.isNullOrNil((String)localObject))) {
              break label290;
            }
            this.iPV.put(paramContext, localObject);
            break label290;
          }
        }
        else
        {
          paramContext = this.iPV;
          AppMethodBeat.o(127691);
          return paramContext;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.iPV;
        AppMethodBeat.o(127691);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
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