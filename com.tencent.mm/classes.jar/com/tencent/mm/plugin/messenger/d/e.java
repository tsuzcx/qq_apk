package com.tencent.mm.plugin.messenger.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public abstract class e
{
  private e.c vKK = new e.c()
  {
    public final void a(Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
    {
      AppMethodBeat.i(211861);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(211861);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(211862);
      if (paramAnonymousMap == null)
      {
        ad.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(211862);
        return;
      }
      ad.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(211862);
    }
  };
  
  public e()
  {
    ((com.tencent.mm.plugin.messenger.a.e)g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a(dmg(), this.vKK);
  }
  
  protected static String m(Map<String, String> paramMap, String paramString)
  {
    int i = 0;
    String str = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
    if (i != 0) {
      str = str + i;
    }
    for (;;)
    {
      if (!bt.isNullOrNil((String)paramMap.get(str)))
      {
        if (bt.lQ((String)paramMap.get(str + ".$type"), paramString)) {
          return str;
        }
        i += 1;
        break;
      }
      return null;
    }
  }
  
  protected abstract void b(Map<String, String> paramMap, e.a parama);
  
  protected abstract void c(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  protected abstract String dmg();
  
  public final void release()
  {
    ((com.tencent.mm.plugin.messenger.a.e)g.ab(com.tencent.mm.plugin.messenger.a.e.class)).b(dmg(), this.vKK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.e
 * JD-Core Version:    0.7.0.1
 */