package com.tencent.mm.plugin.game.luggage.e.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cxc;
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
  List<cxc> CBG;
  Map<Integer, a> CBH;
  private String mAppId;
  
  public b(String paramString)
  {
    AppMethodBeat.i(83096);
    this.mAppId = paramString;
    this.CBH = new HashMap();
    ewI();
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
    this.CBH.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(83097);
  }
  
  private void ewI()
  {
    AppMethodBeat.i(83098);
    this.CBG = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.Qph;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).fKb.putString("game_hv_menu_appid", this.mAppId);
      ((CommonLogicTask)localObject1).bPu();
      localObject1 = ((CommonLogicTask)localObject1).fKb.getString("game_hv_menu_pbcache");
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new cio();
        ((cio)localObject2).parseFrom((byte[])localObject1);
        if (!Util.isNullOrNil(((cio)localObject2).Tpr))
        {
          this.CBG = ((cio)localObject2).Tpr;
          Log.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.CBG, new Comparator() {});
      int j = ((cxc)this.CBG.get(this.CBG.size() - 1)).TFG;
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
      Object localObject2 = this.CBG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cxc localcxc = (cxc)((Iterator)localObject2).next();
        if ((localcxc.TFG > 0) && (localcxc.TFG <= localException.size())) {
          localException.set(localcxc.TFG - 1, localcxc);
        }
      }
      this.CBG = localException;
      AppMethodBeat.o(83098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.b
 * JD-Core Version:    0.7.0.1
 */