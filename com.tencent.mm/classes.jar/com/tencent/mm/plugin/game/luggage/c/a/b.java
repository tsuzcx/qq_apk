package com.tencent.mm.plugin.game.luggage.c.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  List<bug> sXu;
  Map<Integer, a> sXv;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.sXv = new HashMap();
    cOJ();
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
    this.sXv.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void cOJ()
  {
    AppMethodBeat.i(83098);
    this.sXu = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.CGr;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).dmf.putString("game_hv_menu_appid", this.mAppId);
      AppBrandMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).dmf.getString("game_hv_menu_pbcache");
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new biw();
        ((biw)localObject2).parseFrom((byte[])localObject1);
        if (!bs.gY(((biw)localObject2).EXH))
        {
          this.sXu = ((biw)localObject2).EXH;
          ac.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.sXu, new Comparator() {});
      int j = ((bug)this.sXu.get(this.sXu.size() - 1)).Fkr;
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
        ac.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.sXu.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bug localbug = (bug)((Iterator)localObject2).next();
        if ((localbug.Fkr > 0) && (localbug.Fkr <= localException.size())) {
          localException.set(localbug.Fkr - 1, localbug);
        }
      }
      this.sXu = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.b
 * JD-Core Version:    0.7.0.1
 */