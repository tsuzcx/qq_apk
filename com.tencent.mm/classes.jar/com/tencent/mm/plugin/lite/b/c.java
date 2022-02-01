package com.tencent.mm.plugin.lite.b;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static final c Egp;
  
  static
  {
    AppMethodBeat.i(234275);
    Egp = new c();
    AppMethodBeat.o(234275);
  }
  
  public static c eLF()
  {
    return Egp;
  }
  
  public static boolean eLG()
  {
    AppMethodBeat.i(234272);
    Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp start");
    f.eLH();
    Object localObject1 = f.eLI();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)((Iterator)localObject1).next();
        Object localObject2 = localWxaLiteAppInfo.appId;
        localObject2 = new q(u.n(ar.Vgd + "/pkg/" + (String)localObject2, true));
        if (((q)localObject2).ifE())
        {
          localObject2 = ((q)localObject2).ifJ();
          if (localObject2 != null)
          {
            int j = localObject2.length;
            int i = 0;
            while (i < j)
            {
              Object localObject3 = localObject2[i];
              Log.i("MicroMsg.LiteApp.LiteAppCleaner", "app path:%s local path:", new Object[] { localWxaLiteAppInfo.path, localObject3.getPath() });
              if (!localObject3.getPath().equalsIgnoreCase(u.n(localWxaLiteAppInfo.path, true)))
              {
                Log.w("MicroMsg.LiteApp.LiteAppCleaner", "delete old version folder.");
                u.deleteDir(localObject3.getPath());
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
    Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp end");
    AppMethodBeat.o(234272);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.c
 * JD-Core Version:    0.7.0.1
 */