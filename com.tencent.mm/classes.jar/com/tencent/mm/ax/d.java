package com.tencent.mm.ax;

import android.content.Context;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String bJY;
  public String evE;
  public LinkedList<String> evF = new LinkedList();
  public int evH;
  public LinkedList<String> evI = new LinkedList();
  public LinkedList<String> evJ = new LinkedList();
  public String evK = null;
  public String evL = null;
  public String evM = null;
  public String text = null;
  
  public d(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  protected final boolean Ib()
  {
    int i = 0;
    if (this.values == null)
    {
      y.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      return false;
    }
    y.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bk.pm(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bk.bl(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.evE = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.evM = bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.evK = bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.evL = bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(evw)) {
        this.text = bk.pm((String)this.values.get(evw));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.bJY = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.evH = bk.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.bWO.cvF())
      {
        this.evB.add(Integer.valueOf(this.text.length()));
        this.evA.add(this.evM);
        this.evy = (this.text + this.evM);
        this.evC.add(Integer.valueOf(this.evy.length()));
        if (i >= this.evH) {
          break label755;
        }
        if (i != 0) {
          break label620;
        }
        this.evF.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.evI.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.evJ.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.evA.clear();
        this.evB.clear();
        this.evC.clear();
        this.evy = (this.text + " ");
        this.evB.add(Integer.valueOf(this.evy.length()));
        this.evA.add(ae.getContext().getString(b.a.has_approve_info));
        this.evy += ae.getContext().getString(b.a.has_approve_info);
        this.evC.add(Integer.valueOf(this.evy.length()));
        break;
        label620:
        this.evF.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.evI.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.evJ.add(bk.pm((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label755:
      return true;
    }
    y.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bk.pm(this.TYPE) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ax.d
 * JD-Core Version:    0.7.0.1
 */