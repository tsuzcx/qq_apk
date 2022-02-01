package com.tencent.mm.plugin.game.luggage.e.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
{
  List<doh> Ivw;
  Map<Integer, a> Ivx;
  private String mAppId;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.Ivx = new HashMap();
    fEA();
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
    this.Ivx.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void fEA()
  {
    AppMethodBeat.i(83098);
    this.Ivw = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Xhv;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).hPH.putString("game_hv_menu_appid", this.mAppId);
      ((CommonLogicTask)localObject1).cpB();
      localObject1 = ((CommonLogicTask)localObject1).hPH.getString("game_hv_menu_pbcache");
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new cyr();
        ((cyr)localObject2).parseFrom((byte[])localObject1);
        if (!Util.isNullOrNil(((cyr)localObject2).aaDt))
        {
          this.Ivw = ((cyr)localObject2).aaDt;
          Log.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.Ivw, new Comparator() {});
      int j = ((doh)this.Ivw.get(this.Ivw.size() - 1)).aaVn;
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
      Object localObject2 = this.Ivw.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        doh localdoh = (doh)((Iterator)localObject2).next();
        if ((localdoh.aaVn > 0) && (localdoh.aaVn <= localException.size())) {
          localException.set(localdoh.aaVn - 1, localdoh);
        }
      }
      this.Ivw = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.b
 * JD-Core Version:    0.7.0.1
 */