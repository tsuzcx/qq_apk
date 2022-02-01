package com.tencent.mm.plugin.messenger.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.a.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public abstract class e
{
  private f.c tzi = new f.c()
  {
    public final void a(Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
    {
      AppMethodBeat.i(196727);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(196727);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(196728);
      if (paramAnonymousMap == null)
      {
        ad.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(196728);
        return;
      }
      ad.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(196728);
    }
  };
  
  public e()
  {
    ((f)g.ab(f.class)).a(cPd(), this.tzi);
  }
  
  protected static String l(Map<String, String> paramMap, String paramString)
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
        if (bt.kU((String)paramMap.get(str + ".$type"), paramString)) {
          return str;
        }
        i += 1;
        break;
      }
      return null;
    }
  }
  
  protected abstract void b(Map<String, String> paramMap, f.a parama);
  
  protected abstract void c(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  protected abstract String cPd();
  
  public final void release()
  {
    ((f)g.ab(f.class)).b(cPd(), this.tzi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.e
 * JD-Core Version:    0.7.0.1
 */