package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends i<a>
{
  public static final String[] dUb = { i.a(a.dUa, "BizAppMsgContext") };
  public static final String[] dUc = new String[0];
  
  public d(e parame)
  {
    super(parame, a.dUa, "BizAppMsgContext", dUc);
  }
  
  public final a xU(String paramString)
  {
    a locala = new a();
    locala.field_appMsgContextId = paramString.hashCode();
    if (!b(locala, new String[] { "appMsgContextId" }))
    {
      y.e("MicroMsg.Preload.BizAppMsgContextStorage", "url:%s, bizAppMsgContext is null", new Object[] { paramString });
      return null;
    }
    y.v("MicroMsg.Preload.BizAppMsgContextStorage", "[get]bizAppMsgContext:%s", new Object[] { locala });
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.d
 * JD-Core Version:    0.7.0.1
 */