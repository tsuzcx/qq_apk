package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class g
  extends a
{
  public g(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
  }
  
  protected final boolean bAo()
  {
    AppMethodBeat.i(231187);
    if (this.values == null)
    {
      Log.e("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(231187);
      return false;
    }
    Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if (this.values.containsKey(".sysmsg.SysMsgContent")) {
      this.oPj = Util.nullAsNil((String)this.values.get(".sysmsg.SysMsgContent"));
    }
    Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "appText = " + this.oPj);
    AppMethodBeat.o(231187);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.g
 * JD-Core Version:    0.7.0.1
 */