package com.tencent.mm.plugin.messenger.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.a.f.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public abstract class e
{
  private f.c uHF = new f.c()
  {
    public final void a(Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
    {
      AppMethodBeat.i(198611);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(198611);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(198612);
      if (paramAnonymousMap == null)
      {
        ac.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(198612);
        return;
      }
      ac.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(198612);
    }
  };
  
  public e()
  {
    ((f)g.ab(f.class)).a(dcM(), this.uHF);
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
      if (!bs.isNullOrNil((String)paramMap.get(str)))
      {
        if (bs.lr((String)paramMap.get(str + ".$type"), paramString)) {
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
  
  protected abstract String dcM();
  
  public final void release()
  {
    ((f)g.ab(f.class)).b(dcM(), this.uHF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.e
 * JD-Core Version:    0.7.0.1
 */