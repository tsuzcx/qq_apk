package com.tencent.mm.plugin.game.luggage.c.a;

import android.os.Bundle;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  List<awk> kNn;
  Map<Integer, a> kNo;
  private String mAppId;
  
  public b(String paramString)
  {
    this.mAppId = paramString;
    this.kNo = new HashMap();
    aYN();
    a(new h());
    a(new f());
    a(new j());
    a(new g());
    a(new i());
    a(new d());
    a(new e());
  }
  
  private void a(a parama)
  {
    this.kNo.put(Integer.valueOf(parama.id), parama);
  }
  
  private void aYN()
  {
    this.kNn = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.rwG;
    try
    {
      Object localObject1 = new CommonLogicTask();
      ((CommonLogicTask)localObject1).type = 9;
      ((CommonLogicTask)localObject1).kke.putString("game_hv_menu_appid", this.mAppId);
      LuggageMainProcessService.b((MainProcessTask)localObject1);
      localObject1 = ((CommonLogicTask)localObject1).kke.getString("game_hv_menu_pbcache");
      if (!bk.bl((String)localObject1))
      {
        localObject1 = ((String)localObject1).getBytes("ISO-8859-1");
        localObject2 = new aol();
        ((aol)localObject2).aH((byte[])localObject1);
        if (!bk.dk(((aol)localObject2).tkc))
        {
          this.kNn = ((aol)localObject2).tkc;
          y.i("MicroMsg.H5GameMenuHelp", "use net menu data");
        }
      }
      Collections.sort(this.kNn, new b.1(this));
      int j = ((awk)this.kNn.get(this.kNn.size() - 1)).tta;
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
        y.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", new Object[] { localException.getMessage() });
      }
      Object localObject2 = this.kNn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        awk localawk = (awk)((Iterator)localObject2).next();
        if ((localawk.tta > 0) && (localawk.tta <= localException.size())) {
          localException.set(localawk.tta - 1, localawk);
        }
      }
      this.kNn = localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.b
 * JD-Core Version:    0.7.0.1
 */