package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public static j eRu = new j();
  private Map<String, String> eRv;
  
  public final Map<String, String> bK(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = bk.E(paramContext.getAssets().open("config/EmailAddress.xml"));
        if (bk.bl(paramContext)) {
          return null;
        }
        Map localMap = bn.s(paramContext, "config");
        if ((localMap == null) || (localMap.isEmpty()))
        {
          y.d("MicroMsg.EmailFormater", "values null");
          return null;
        }
        if (this.eRv == null)
        {
          this.eRv = new HashMap();
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
            if ((bk.bl(paramContext)) || (bk.bl((String)localObject))) {
              break label250;
            }
            this.eRv.put(paramContext, localObject);
            break label250;
          }
        }
        else
        {
          return this.eRv;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.eRv;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
        return null;
      }
      label250:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.j
 * JD-Core Version:    0.7.0.1
 */