package com.tencent.mm.plugin.lite.b;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static final c yEA;
  
  static
  {
    AppMethodBeat.i(198855);
    yEA = new c();
    AppMethodBeat.o(198855);
  }
  
  public static c ecA()
  {
    return yEA;
  }
  
  public static boolean ecB()
  {
    AppMethodBeat.i(198854);
    Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp start");
    f.ecC();
    Object localObject1 = f.ecD();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        WxaLiteAppInfo localWxaLiteAppInfo = (WxaLiteAppInfo)((Iterator)localObject1).next();
        Object localObject2 = localWxaLiteAppInfo.appId;
        localObject2 = new o(s.k(ar.NSg + "/pkg/" + (String)localObject2, true));
        if (((o)localObject2).exists())
        {
          localObject2 = ((o)localObject2).het();
          if (localObject2 != null)
          {
            int j = localObject2.length;
            int i = 0;
            while (i < j)
            {
              Object localObject3 = localObject2[i];
              Log.i("MicroMsg.LiteApp.LiteAppCleaner", "app path:%s local path:", new Object[] { localWxaLiteAppInfo.path, aa.z(localObject3.mUri) });
              if (!aa.z(localObject3.mUri).equalsIgnoreCase(s.k(localWxaLiteAppInfo.path, true)))
              {
                Log.w("MicroMsg.LiteApp.LiteAppCleaner", "delete old version folder.");
                s.dy(aa.z(localObject3.mUri), true);
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
    AppMethodBeat.o(198854);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.c
 * JD-Core Version:    0.7.0.1
 */