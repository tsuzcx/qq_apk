package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class g
  extends a
{
  public g(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
  }
  
  protected final boolean aAc()
  {
    AppMethodBeat.i(219251);
    if (this.values == null)
    {
      ad.e("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(219251);
      return false;
    }
    ad.i("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if (this.values.containsKey(".sysmsg.SysMsgContent")) {
      this.ihO = bt.nullAsNil((String)this.values.get(".sysmsg.SysMsgContent"));
    }
    ad.i("MicroMsg.FinderChatSystemaNewXmlMsg", "appText = " + this.ihO);
    AppMethodBeat.o(219251);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.g
 * JD-Core Version:    0.7.0.1
 */