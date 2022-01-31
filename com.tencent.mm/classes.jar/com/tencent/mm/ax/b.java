package com.tencent.mm.ax;

import android.content.Context;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String bJY = null;
  public String evE;
  public LinkedList<String> evF = new LinkedList();
  public String evG = null;
  public String text = null;
  
  public b(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  protected final boolean Ib()
  {
    if (this.values == null)
    {
      y.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      return false;
    }
    y.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bk.pm(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bk.bl(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.evE = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(evw)) {
        this.text = bk.pm((String)this.values.get(evw));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.evG = bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.bJY = bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.evy = this.text;
      if (!this.bWO.cvF())
      {
        this.evA.add(this.evG);
        this.evB.add(Integer.valueOf(this.evy.length()));
        this.evy += this.evG;
        this.evC.add(Integer.valueOf(this.evy.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.evF.add(this.values.get(str));
          }
        }
        this.evy = (this.evy + " " + ae.getContext().getString(b.a.has_send_invite));
      }
      return true;
    }
    y.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bk.pm(this.TYPE) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ax.b
 * JD-Core Version:    0.7.0.1
 */