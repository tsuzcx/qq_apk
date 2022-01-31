package com.tencent.mm.plugin.game.luggage.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private String mAppId;
  List<bcz> njS;
  Map<Integer, a> njT;
  
  public b(String paramString)
  {
    AppMethodBeat.i(135891);
    this.mAppId = paramString;
    this.njT = new HashMap();
    bFq();
    a(new h());
    a(new f());
    a(new j());
    a(new g());
    a(new i());
    a(new d());
    a(new e());
    AppMethodBeat.o(135891);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(135892);
    this.njT.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(135892);
  }
  
  private void bFq()
  {
    AppMethodBeat.i(135893);
    this.njS = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.vnz;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).mEJ.putString("game_hv_menu_appid", this.mAppId);
      AppBrandMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).mEJ.getString("game_hv_menu_pbcache");
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new aud();
        ((aud)localObject2).parseFrom((byte[])localObject1);
        if (!bo.es(((aud)localObject2).xiT))
        {
          this.njS = ((aud)localObject2).xiT;
          ab.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.njS, new b.1(this));
      int j = ((bcz)this.njS.get(this.njS.size() - 1)).xta;
      localObject1 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(null);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.njS.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bcz localbcz = (bcz)((Iterator)localObject2).next();
        if ((localbcz.xta > 0) && (localbcz.xta <= localException.size())) {
          localException.set(localbcz.xta - 1, localbcz);
        }
      }
      this.njS = localException;
      AppMethodBeat.o(135893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.b
 * JD-Core Version:    0.7.0.1
 */