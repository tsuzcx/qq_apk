package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String doP;
  public LinkedList<String> hOP;
  public String url;
  
  public e(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
    AppMethodBeat.i(101787);
    this.hOP = new LinkedList();
    AppMethodBeat.o(101787);
  }
  
  protected final boolean axn()
  {
    AppMethodBeat.i(101788);
    if (this.values == null)
    {
      ac.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101788);
      return false;
    }
    ac.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bs.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.doP = bs.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.hOP.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.hOP.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(hOy))
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
          this.hOC.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label498:
    for (;;)
    {
      break;
      this.hOD.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.hOE.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.hOA = ((StringBuilder)localObject1).toString();
      ac.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.doP, Integer.valueOf(this.hOP.size()) });
      AppMethodBeat.o(101788);
      return true;
      ac.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
      AppMethodBeat.o(101788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.e
 * JD-Core Version:    0.7.0.1
 */