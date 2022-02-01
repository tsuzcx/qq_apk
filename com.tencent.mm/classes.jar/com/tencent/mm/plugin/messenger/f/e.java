package com.tencent.mm.plugin.messenger.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public abstract class e
{
  private e.d KSe = new e.d()
  {
    public final void a(Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
    {
      AppMethodBeat.i(288585);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(288585);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(288594);
      if (paramAnonymousMap == null)
      {
        Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(288594);
        return;
      }
      Log.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(288594);
    }
  };
  
  public e()
  {
    ((com.tencent.mm.plugin.messenger.a.e)h.ax(com.tencent.mm.plugin.messenger.a.e.class)).a(gbu(), this.KSe);
  }
  
  protected static String p(Map<String, String> paramMap, String paramString)
  {
    int i = 0;
    String str = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
    if (i != 0) {
      str = str + i;
    }
    for (;;)
    {
      if (!Util.isNullOrNil((String)paramMap.get(str)))
      {
        if (Util.isEqual((String)paramMap.get(str + ".$type"), paramString)) {
          return str;
        }
        i += 1;
        break;
      }
      return null;
    }
  }
  
  protected abstract void b(Map<String, String> paramMap, g.a parama);
  
  protected abstract void c(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  protected abstract String gbu();
  
  public final void release()
  {
    ((com.tencent.mm.plugin.messenger.a.e)h.ax(com.tencent.mm.plugin.messenger.a.e.class)).b(gbu(), this.KSe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.f.e
 * JD-Core Version:    0.7.0.1
 */