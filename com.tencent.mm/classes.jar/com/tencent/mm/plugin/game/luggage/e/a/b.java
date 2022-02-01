package com.tencent.mm.plugin.game.luggage.e.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private String mAppId;
  List<coq> xxx;
  Map<Integer, a> xxy;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.xxy = new HashMap();
    dTz();
    a(new h());
    a(new f());
    a(new j());
    a(new g());
    a(new i());
    a(new d());
    a(new e());
    AppMethodBeat.o(83096);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(83097);
    this.xxy.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void dTz()
  {
    AppMethodBeat.i(83098);
    this.xxx = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.JrL;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).dQL.putString("game_hv_menu_appid", this.mAppId);
      AppBrandMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).dQL.getString("game_hv_menu_pbcache");
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new can();
        ((can)localObject2).parseFrom((byte[])localObject1);
        if (!Util.isNullOrNil(((can)localObject2).MfF))
        {
          this.xxx = ((can)localObject2).MfF;
          Log.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.xxx, new Comparator() {});
      int j = ((coq)this.xxx.get(this.xxx.size() - 1)).MuP;
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
        Log.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.xxx.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        coq localcoq = (coq)((Iterator)localObject2).next();
        if ((localcoq.MuP > 0) && (localcoq.MuP <= localException.size())) {
          localException.set(localcoq.MuP - 1, localcoq);
        }
      }
      this.xxx = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.b
 * JD-Core Version:    0.7.0.1
 */