package com.tencent.mm.openim.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String ddJ;
  public String hOG;
  public LinkedList<String> hOH;
  public int hOJ;
  public LinkedList<String> hOK;
  public LinkedList<String> hOL;
  public String hOM;
  public String hON;
  public String hOO;
  public LinkedList<String> iov;
  public LinkedList<String> iow;
  public String iox;
  public String ioy;
  public String text;
  
  public b(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
    AppMethodBeat.i(151262);
    this.hOH = new LinkedList();
    this.hOK = new LinkedList();
    this.iov = new LinkedList();
    this.iow = new LinkedList();
    this.hOL = new LinkedList();
    this.hOM = null;
    this.iox = null;
    this.ioy = null;
    this.hON = null;
    this.hOO = null;
    this.text = null;
    AppMethodBeat.o(151262);
  }
  
  public final boolean axn()
  {
    int i = 0;
    AppMethodBeat.i(151263);
    if (this.values == null)
    {
      ac.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151263);
      return false;
    }
    ac.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")))
    {
      this.hOG = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.hOO = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.hOM = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.iox = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.ioy = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.hON = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(hOy)) {
        this.text = bs.nullAsNil((String)this.values.get(hOy));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.ddJ = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.hOJ = bs.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dpq.fce())
      {
        this.hOD.add(Integer.valueOf(this.text.length()));
        this.hOC.add(this.hOO);
        this.hOA = (this.text + this.hOO);
        this.hOE.add(Integer.valueOf(this.hOA.length()));
        if (i >= this.hOJ) {
          break label1079;
        }
        if (i != 0) {
          break label856;
        }
        this.hOH.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.hOK.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.iov.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.iow.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.hOL.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.hOC.clear();
        this.hOD.clear();
        this.hOE.clear();
        this.hOA = (this.text + " ");
        this.hOD.add(Integer.valueOf(this.hOA.length()));
        this.hOC.add(ai.getContext().getString(2131760229));
        this.hOA += ai.getContext().getString(2131760229);
        this.hOE.add(Integer.valueOf(this.hOA.length()));
        break;
        label856:
        this.hOH.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.hOK.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.iow.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.iov.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.hOL.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1079:
      AppMethodBeat.o(151263);
      return true;
    }
    ac.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.b
 * JD-Core Version:    0.7.0.1
 */