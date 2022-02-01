package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class g
  extends a
{
  public g(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  protected final boolean aTA()
  {
    AppMethodBeat.i(194530);
    if (this.values == null)
    {
      Log.e("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(194530);
      return false;
    }
    Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if (this.values.containsKey(".sysmsg.SysMsgContent")) {
      this.jfG = Util.nullAsNil((String)this.values.get(".sysmsg.SysMsgContent"));
    }
    Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "appText = " + this.jfG);
    AppMethodBeat.o(194530);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.g
 * JD-Core Version:    0.7.0.1
 */