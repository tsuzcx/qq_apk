package com.tencent.mm.openim.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String dpf;
  public LinkedList<String> iHS;
  public LinkedList<String> iHT;
  public String iHU;
  public String iHV;
  public String ihU;
  public LinkedList<String> ihV;
  public int ihX;
  public LinkedList<String> ihY;
  public LinkedList<String> ihZ;
  public String iia;
  public String iib;
  public String iic;
  public String text;
  
  public b(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
    AppMethodBeat.i(151262);
    this.ihV = new LinkedList();
    this.ihY = new LinkedList();
    this.iHS = new LinkedList();
    this.iHT = new LinkedList();
    this.ihZ = new LinkedList();
    this.iia = null;
    this.iHU = null;
    this.iHV = null;
    this.iib = null;
    this.iic = null;
    this.text = null;
    AppMethodBeat.o(151262);
  }
  
  public final boolean aAc()
  {
    int i = 0;
    AppMethodBeat.i(151263);
    if (this.values == null)
    {
      ad.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151263);
      return false;
    }
    ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")))
    {
      this.ihU = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.iic = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.iia = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.iHU = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.iHV = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.iib = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(ihM)) {
        this.text = bt.nullAsNil((String)this.values.get(ihM));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.dpf = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.ihX = bt.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dBd.fsh())
      {
        this.ihR.add(Integer.valueOf(this.text.length()));
        this.ihQ.add(this.iic);
        this.ihO = (this.text + this.iic);
        this.ihS.add(Integer.valueOf(this.ihO.length()));
        if (i >= this.ihX) {
          break label1079;
        }
        if (i != 0) {
          break label856;
        }
        this.ihV.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.ihY.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.iHS.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.iHT.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.ihZ.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.ihQ.clear();
        this.ihR.clear();
        this.ihS.clear();
        this.ihO = (this.text + " ");
        this.ihR.add(Integer.valueOf(this.ihO.length()));
        this.ihQ.add(aj.getContext().getString(2131760229));
        this.ihO += aj.getContext().getString(2131760229);
        this.ihS.add(Integer.valueOf(this.ihO.length()));
        break;
        label856:
        this.ihV.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.ihY.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.iHT.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.iHS.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.ihZ.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1079:
      AppMethodBeat.o(151263);
      return true;
    }
    ad.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.b
 * JD-Core Version:    0.7.0.1
 */