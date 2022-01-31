package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public static j gjp;
  private Map<String, String> gjq;
  
  static
  {
    AppMethodBeat.i(124534);
    gjp = new j();
    AppMethodBeat.o(124534);
  }
  
  public final Map<String, String> cr(Context paramContext)
  {
    AppMethodBeat.i(124533);
    for (;;)
    {
      int i;
      try
      {
        paramContext = bo.F(paramContext.getAssets().open("config/EmailAddress.xml"));
        boolean bool = bo.isNullOrNil(paramContext);
        if (bool)
        {
          AppMethodBeat.o(124533);
          return null;
        }
        Map localMap = br.F(paramContext, "config");
        if ((localMap == null) || (localMap.isEmpty()))
        {
          ab.d("MicroMsg.EmailFormater", "values null");
          AppMethodBeat.o(124533);
          return null;
        }
        if (this.gjq == null)
        {
          this.gjq = new HashMap();
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
            if ((bo.isNullOrNil(paramContext)) || (bo.isNullOrNil((String)localObject))) {
              break label290;
            }
            this.gjq.put(paramContext, localObject);
            break label290;
          }
        }
        else
        {
          paramContext = this.gjq;
          AppMethodBeat.o(124533);
          return paramContext;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.gjq;
        AppMethodBeat.o(124533);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(124533);
        return null;
      }
      label290:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.j
 * JD-Core Version:    0.7.0.1
 */