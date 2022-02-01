package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String dre;
  public LinkedList<String> hom;
  public String url;
  
  public e(Map<String, String> paramMap, bl parambl)
  {
    super(paramMap, parambl);
    AppMethodBeat.i(101787);
    this.hom = new LinkedList();
    AppMethodBeat.o(101787);
  }
  
  protected final boolean aqx()
  {
    AppMethodBeat.i(101788);
    if (this.values == null)
    {
      ad.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101788);
      return false;
    }
    ad.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bt.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.dre = bt.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.hom.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.hom.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(hnV))
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
          this.hnZ.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label498:
    for (;;)
    {
      break;
      this.hoa.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.hob.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.hnX = ((StringBuilder)localObject1).toString();
      ad.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.dre, Integer.valueOf(this.hom.size()) });
      AppMethodBeat.o(101788);
      return true;
      ad.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
      AppMethodBeat.o(101788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.e
 * JD-Core Version:    0.7.0.1
 */