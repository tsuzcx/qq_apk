package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String dTx;
  public LinkedList<String> jfV;
  public String url;
  
  public e(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
    AppMethodBeat.i(101787);
    this.jfV = new LinkedList();
    AppMethodBeat.o(101787);
  }
  
  protected final boolean aTA()
  {
    AppMethodBeat.i(101788);
    if (this.values == null)
    {
      Log.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101788);
      return false;
    }
    Log.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!Util.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = Util.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.dTx = Util.nullAsNil((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.jfV.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.jfV.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(jfE))
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
          this.jfI.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label498:
    for (;;)
    {
      break;
      this.jfJ.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.jfK.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.jfG = ((StringBuilder)localObject1).toString();
      Log.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.dTx, Integer.valueOf(this.jfV.size()) });
      AppMethodBeat.o(101788);
      return true;
      Log.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
      AppMethodBeat.o(101788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.e
 * JD-Core Version:    0.7.0.1
 */