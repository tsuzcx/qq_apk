package com.tencent.mm.plugin.lite.logic;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final b KaJ;
  
  static
  {
    AppMethodBeat.i(271389);
    KaJ = new b();
    AppMethodBeat.o(271389);
  }
  
  public static b fUg()
  {
    return KaJ;
  }
  
  public static boolean fUh()
  {
    AppMethodBeat.i(271382);
    Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp start");
    d.fUi();
    Object localObject1 = d.fUk();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)((Iterator)localObject1).next();
        if (!localWxaLiteAppInfo.appId.equals("wxalitebaselibrary"))
        {
          Object localObject2 = localWxaLiteAppInfo.appId;
          localObject2 = new u(y.n(at.acHs + "/pkg/" + (String)localObject2, true));
          if (((u)localObject2).jKS())
          {
            localObject2 = ((u)localObject2).jKX();
            if (localObject2 != null)
            {
              int j = localObject2.length;
              int i = 0;
              while (i < j)
              {
                Object localObject3 = localObject2[i];
                Log.i("MicroMsg.LiteApp.LiteAppCleaner", "app path:%s local path:%s", new Object[] { localWxaLiteAppInfo.path, ah.v(localObject3.mUri) });
                if (!ah.v(localObject3.mUri).equalsIgnoreCase(y.n(localWxaLiteAppInfo.path, true)))
                {
                  Log.w("MicroMsg.LiteApp.LiteAppCleaner", "delete old version folder.");
                  y.ew(ah.v(localObject3.mUri), true);
                }
                i += 1;
              }
            }
            else
            {
              Log.d("MicroMsg.LiteApp.LiteAppCleaner", "version is empty");
            }
          }
          else
          {
            Log.w("MicroMsg.LiteApp.LiteAppCleaner", "appId %s 目录不存在", new Object[] { localWxaLiteAppInfo.appId });
          }
        }
      }
    }
    Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp end");
    AppMethodBeat.o(271382);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.b
 * JD-Core Version:    0.7.0.1
 */