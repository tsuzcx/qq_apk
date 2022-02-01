package com.tencent.mm.openim.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String dHx;
  public LinkedList<String> jHr;
  public LinkedList<String> jHs;
  public String jHt;
  public String jHu;
  public String jfM;
  public LinkedList<String> jfN;
  public int jfP;
  public LinkedList<String> jfQ;
  public LinkedList<String> jfR;
  public String jfS;
  public String jfT;
  public String jfU;
  public String text;
  
  public b(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
    AppMethodBeat.i(151262);
    this.jfN = new LinkedList();
    this.jfQ = new LinkedList();
    this.jHr = new LinkedList();
    this.jHs = new LinkedList();
    this.jfR = new LinkedList();
    this.jfS = null;
    this.jHt = null;
    this.jHu = null;
    this.jfT = null;
    this.jfU = null;
    this.text = null;
    AppMethodBeat.o(151262);
  }
  
  public final boolean aTA()
  {
    int i = 0;
    AppMethodBeat.i(151263);
    if (this.values == null)
    {
      Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151263);
      return false;
    }
    Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!Util.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")))
    {
      this.jfM = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.jfU = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.jfS = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.jHt = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.jHu = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.jfT = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(jfE)) {
        this.text = Util.nullAsNil((String)this.values.get(jfE));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.dHx = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.jfP = Util.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dTX.gDO())
      {
        this.jfJ.add(Integer.valueOf(this.text.length()));
        this.jfI.add(this.jfU);
        this.jfG = (this.text + this.jfU);
        this.jfK.add(Integer.valueOf(this.jfG.length()));
        if (i >= this.jfP) {
          break label1079;
        }
        if (i != 0) {
          break label856;
        }
        this.jfN.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.jfQ.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.jHr.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.jHs.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.jfR.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.jfI.clear();
        this.jfJ.clear();
        this.jfK.clear();
        this.jfG = (this.text + " ");
        this.jfJ.add(Integer.valueOf(this.jfG.length()));
        this.jfI.add(MMApplicationContext.getContext().getString(2131761615));
        this.jfG += MMApplicationContext.getContext().getString(2131761615);
        this.jfK.add(Integer.valueOf(this.jfG.length()));
        break;
        label856:
        this.jfN.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.jfQ.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.jHs.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.jHr.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.jfR.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1079:
      AppMethodBeat.o(151263);
      return true;
    }
    Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.b
 * JD-Core Version:    0.7.0.1
 */