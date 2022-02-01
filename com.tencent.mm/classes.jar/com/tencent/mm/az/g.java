package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class g
  extends a
{
  public g(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
  }
  
  protected final boolean aAs()
  {
    AppMethodBeat.i(209891);
    if (this.values == null)
    {
      ae.e("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(209891);
      return false;
    }
    ae.i("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if (this.values.containsKey(".sysmsg.SysMsgContent")) {
      this.ikH = bu.nullAsNil((String)this.values.get(".sysmsg.SysMsgContent"));
    }
    ae.i("MicroMsg.FinderChatSystemaNewXmlMsg", "appText = " + this.ikH);
    AppMethodBeat.o(209891);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.g
 * JD-Core Version:    0.7.0.1
 */