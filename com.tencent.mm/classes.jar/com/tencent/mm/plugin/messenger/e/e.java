package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public abstract class e
{
  private e.d EWu = new e.d()
  {
    public final void a(Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
    {
      AppMethodBeat.i(213543);
      e.this.b(paramAnonymousMap, paramAnonymousa);
      AppMethodBeat.o(213543);
    }
    
    public final void b(String paramAnonymousString, Map<String, String> paramAnonymousMap, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(213546);
      if (paramAnonymousMap == null)
      {
        Log.w("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "hy: non map!!");
        AppMethodBeat.o(213546);
        return;
      }
      Log.i("MicroMsg.SysMsgTemp.SysMsgTemplateReceivedHandlerBase", "onClickLink linkType:%s", new Object[] { paramAnonymousString });
      e.this.c(paramAnonymousString, paramAnonymousMap, paramAnonymousBundle);
      AppMethodBeat.o(213546);
    }
  };
  
  public e()
  {
    ((com.tencent.mm.plugin.messenger.a.e)h.ae(com.tencent.mm.plugin.messenger.a.e.class)).a(eSA(), this.EWu);
  }
  
  protected static String n(Map<String, String> paramMap, String paramString)
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
  
  protected abstract void b(Map<String, String> paramMap, h.a parama);
  
  protected abstract void c(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  protected abstract String eSA();
  
  public final void release()
  {
    ((com.tencent.mm.plugin.messenger.a.e)h.ae(com.tencent.mm.plugin.messenger.a.e.class)).b(eSA(), this.EWu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.e
 * JD-Core Version:    0.7.0.1
 */