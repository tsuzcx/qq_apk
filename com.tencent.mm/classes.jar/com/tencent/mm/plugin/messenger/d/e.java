package com.tencent.mm.plugin.messenger.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public abstract class e
{
  private e.c vWO = new e.c()
  {
    public final void a(Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
    {
      AppMethodBeat.i(218170);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(218170);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(218171);
      if (paramAnonymousMap == null)
      {
        ae.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(218171);
        return;
      }
      ae.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(218171);
    }
  };
  
  public e()
  {
    ((com.tencent.mm.plugin.messenger.a.e)g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a(dpf(), this.vWO);
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
      if (!bu.isNullOrNil((String)paramMap.get(str)))
      {
        if (bu.lX((String)paramMap.get(str + ".$type"), paramString)) {
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
  
  protected abstract String dpf();
  
  public final void release()
  {
    ((com.tencent.mm.plugin.messenger.a.e)g.ab(com.tencent.mm.plugin.messenger.a.e.class)).b(dpf(), this.vWO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.e
 * JD-Core Version:    0.7.0.1
 */