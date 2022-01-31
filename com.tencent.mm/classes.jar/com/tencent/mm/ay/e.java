package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String cAV;
  public LinkedList<String> fLA;
  public String url;
  
  public e(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
    AppMethodBeat.i(5558);
    this.fLA = new LinkedList();
    AppMethodBeat.o(5558);
  }
  
  protected final boolean Zh()
  {
    AppMethodBeat.i(5559);
    if (this.values == null)
    {
      ab.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(5559);
      return false;
    }
    ab.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bo.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bo.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.cAV = bo.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.fLA.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.fLA.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(fLj))
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
            break label502;
          }
          ((StringBuilder)localObject1).append((String)this.values.get(str));
          this.fLn.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label502:
    for (;;)
    {
      break;
      this.fLo.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.fLp.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.fLl = ((StringBuilder)localObject1).toString();
      ab.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.cAV, Integer.valueOf(this.fLA.size()) });
      AppMethodBeat.o(5559);
      return true;
      ab.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bo.nullAsNil(this.TYPE) });
      AppMethodBeat.o(5559);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ay.e
 * JD-Core Version:    0.7.0.1
 */