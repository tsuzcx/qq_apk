package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  public static g pAs;
  private Map<String, String> pAt;
  
  static
  {
    AppMethodBeat.i(127692);
    pAs = new g();
    AppMethodBeat.o(127692);
  }
  
  public final Map<String, String> ef(Context paramContext)
  {
    AppMethodBeat.i(127691);
    for (;;)
    {
      int i;
      try
      {
        paramContext = Util.streamToString(paramContext.getAssets().open("config/EmailAddress.xml"));
        boolean bool = Util.isNullOrNil(paramContext);
        if (bool)
        {
          AppMethodBeat.o(127691);
          return null;
        }
        Map localMap = XmlParser.parseXml(paramContext, "config", null);
        if ((localMap == null) || (localMap.isEmpty()))
        {
          Log.d("MicroMsg.EmailFormater", "values null");
          AppMethodBeat.o(127691);
          return null;
        }
        if (this.pAt == null)
        {
          this.pAt = new HashMap();
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
            if ((Util.isNullOrNil(paramContext)) || (Util.isNullOrNil((String)localObject))) {
              break label291;
            }
            this.pAt.put(paramContext, localObject);
            break label291;
          }
        }
        else
        {
          paramContext = this.pAt;
          AppMethodBeat.o(127691);
          return paramContext;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.pAt;
        AppMethodBeat.o(127691);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
        AppMethodBeat.o(127691);
        return null;
      }
      label291:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.g
 * JD-Core Version:    0.7.0.1
 */