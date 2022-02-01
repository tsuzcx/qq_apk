package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String dBI;
  public LinkedList<String> ikW;
  public String url;
  
  public e(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
    AppMethodBeat.i(101787);
    this.ikW = new LinkedList();
    AppMethodBeat.o(101787);
  }
  
  protected final boolean aAs()
  {
    AppMethodBeat.i(101788);
    if (this.values == null)
    {
      ae.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101788);
      return false;
    }
    ae.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bu.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bu.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.dBI = bu.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.ikW.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.ikW.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(ikF))
        {
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).insert(0, (String)this.values.get(str));
          } else {
            ((StringBuilder)localObject1).append((String)this.values.get(str));
          }
        }
        else
        {
          if (!str.startsWith(".sysmsg.delchatroommember.link.text")) {
            break label498;
          }
          ((StringBuilder)localObject1).append((String)this.values.get(str));
          this.ikJ.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label498:
    for (;;)
    {
      break;
      this.ikK.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.ikL.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.ikH = ((StringBuilder)localObject1).toString();
      ae.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.dBI, Integer.valueOf(this.ikW.size()) });
      AppMethodBeat.o(101788);
      return true;
      ae.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bu.nullAsNil(this.TYPE) });
      AppMethodBeat.o(101788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.e
 * JD-Core Version:    0.7.0.1
 */