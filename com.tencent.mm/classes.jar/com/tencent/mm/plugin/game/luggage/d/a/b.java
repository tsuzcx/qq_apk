package com.tencent.mm.plugin.game.luggage.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  List<bzp> ufm;
  Map<Integer, a> ufn;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.ufn = new HashMap();
    cZS();
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
    this.ufn.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void cZS()
  {
    AppMethodBeat.i(83098);
    this.ufm = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.ECh;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).dyY.putString("game_hv_menu_appid", this.mAppId);
      AppBrandMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).dyY.getString("game_hv_menu_pbcache");
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new bnw();
        ((bnw)localObject2).parseFrom((byte[])localObject1);
        if (!bu.ht(((bnw)localObject2).HaF))
        {
          this.ufm = ((bnw)localObject2).HaF;
          ae.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.ufm, new Comparator() {});
      int j = ((bzp)this.ufm.get(this.ufm.size() - 1)).HnA;
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
        ae.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.ufm.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bzp localbzp = (bzp)((Iterator)localObject2).next();
        if ((localbzp.HnA > 0) && (localbzp.HnA <= localException.size())) {
          localException.set(localbzp.HnA - 1, localbzp);
        }
      }
      this.ufm = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */