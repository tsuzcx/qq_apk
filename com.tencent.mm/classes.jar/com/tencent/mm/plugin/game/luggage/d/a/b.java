package com.tencent.mm.plugin.game.luggage.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  List<byv> tUu;
  Map<Integer, a> tUv;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.tUv = new HashMap();
    cXj();
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
    this.tUv.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void cXj()
  {
    AppMethodBeat.i(83098);
    this.tUu = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Ekd;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).dxT.putString("game_hv_menu_appid", this.mAppId);
      AppBrandMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).dxT.getString("game_hv_menu_pbcache");
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new bne();
        ((bne)localObject2).parseFrom((byte[])localObject1);
        if (!bt.hj(((bne)localObject2).GHd))
        {
          this.tUu = ((bne)localObject2).GHd;
          ad.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.tUu, new Comparator() {});
      int j = ((byv)this.tUu.get(this.tUu.size() - 1)).GTZ;
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
        ad.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.tUu.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        byv localbyv = (byv)((Iterator)localObject2).next();
        if ((localbyv.GTZ > 0) && (localbyv.GTZ <= localException.size())) {
          localException.set(localbyv.GTZ - 1, localbyv);
        }
      }
      this.tUu = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */