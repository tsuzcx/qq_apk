package com.tencent.mm.openim.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String dqk;
  public LinkedList<String> iKL;
  public LinkedList<String> iKM;
  public String iKN;
  public String iKO;
  public String ikN;
  public LinkedList<String> ikO;
  public int ikQ;
  public LinkedList<String> ikR;
  public LinkedList<String> ikS;
  public String ikT;
  public String ikU;
  public String ikV;
  public String text;
  
  public b(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
    AppMethodBeat.i(151262);
    this.ikO = new LinkedList();
    this.ikR = new LinkedList();
    this.iKL = new LinkedList();
    this.iKM = new LinkedList();
    this.ikS = new LinkedList();
    this.ikT = null;
    this.iKN = null;
    this.iKO = null;
    this.ikU = null;
    this.ikV = null;
    this.text = null;
    AppMethodBeat.o(151262);
  }
  
  public final boolean aAs()
  {
    int i = 0;
    AppMethodBeat.i(151263);
    if (this.values == null)
    {
      ae.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151263);
      return false;
    }
    ae.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bu.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")))
    {
      this.ikN = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.ikV = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.ikT = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.iKN = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.iKO = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.ikU = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(ikF)) {
        this.text = bu.nullAsNil((String)this.values.get(ikF));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.dqk = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.ikQ = bu.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dCi.fwi())
      {
        this.ikK.add(Integer.valueOf(this.text.length()));
        this.ikJ.add(this.ikV);
        this.ikH = (this.text + this.ikV);
        this.ikL.add(Integer.valueOf(this.ikH.length()));
        if (i >= this.ikQ) {
          break label1079;
        }
        if (i != 0) {
          break label856;
        }
        this.ikO.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.ikR.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.iKL.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.iKM.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.ikS.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.ikJ.clear();
        this.ikK.clear();
        this.ikL.clear();
        this.ikH = (this.text + " ");
        this.ikK.add(Integer.valueOf(this.ikH.length()));
        this.ikJ.add(ak.getContext().getString(2131760229));
        this.ikH += ak.getContext().getString(2131760229);
        this.ikL.add(Integer.valueOf(this.ikH.length()));
        break;
        label856:
        this.ikO.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.ikR.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.iKM.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.iKL.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.ikS.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1079:
      AppMethodBeat.o(151263);
      return true;
    }
    ae.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bu.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.b
 * JD-Core Version:    0.7.0.1
 */