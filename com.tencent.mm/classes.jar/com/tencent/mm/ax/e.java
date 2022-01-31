package com.tencent.mm.ax;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class e
  extends a
{
  public String bTq;
  public LinkedList<String> evN = new LinkedList();
  public String url;
  
  public e(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  protected final boolean Ib()
  {
    if (this.values == null)
    {
      y.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      return false;
    }
    y.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bk.pm(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bk.bl(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bk.pm((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.bTq = bk.pm((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.evN.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.evN.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(evw))
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
            break label478;
          }
          ((StringBuilder)localObject1).append((String)this.values.get(str));
          this.evA.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label478:
    for (;;)
    {
      break;
      this.evB.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.evC.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.evy = ((StringBuilder)localObject1).toString();
      y.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.bTq, Integer.valueOf(this.evN.size()) });
      return true;
      y.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bk.pm(this.TYPE) });
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ax.e
 * JD-Core Version:    0.7.0.1
 */