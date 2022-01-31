package com.tencent.mm.openim.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String crs;
  public String fLr;
  public LinkedList<String> fLs;
  public int fLu;
  public LinkedList<String> fLv;
  public LinkedList<String> fLw;
  public String fLx;
  public String fLy;
  public String fLz;
  public LinkedList<String> ggd;
  public LinkedList<String> gge;
  public String ggf;
  public String ggg;
  public String text;
  
  public b(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
    AppMethodBeat.i(78918);
    this.fLs = new LinkedList();
    this.fLv = new LinkedList();
    this.ggd = new LinkedList();
    this.gge = new LinkedList();
    this.fLw = new LinkedList();
    this.fLx = null;
    this.ggf = null;
    this.ggg = null;
    this.fLy = null;
    this.fLz = null;
    this.text = null;
    AppMethodBeat.o(78918);
  }
  
  public final boolean Zh()
  {
    int i = 0;
    AppMethodBeat.i(78919);
    if (this.values == null)
    {
      ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(78919);
      return false;
    }
    ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bo.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplication")))
    {
      this.fLr = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.fLz = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.fLx = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.ggf = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.ggg = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.fLy = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(fLj)) {
        this.text = bo.nullAsNil((String)this.values.get(fLj));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.crs = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.fLu = bo.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.cEE.dyn())
      {
        this.fLo.add(Integer.valueOf(this.text.length()));
        this.fLn.add(this.fLz);
        this.fLl = (this.text + this.fLz);
        this.fLp.add(Integer.valueOf(this.fLl.length()));
        if (i >= this.fLu) {
          break label1079;
        }
        if (i != 0) {
          break label856;
        }
        this.fLs.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.fLv.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.ggd.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.gge.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.fLw.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.fLn.clear();
        this.fLo.clear();
        this.fLp.clear();
        this.fLl = (this.text + " ");
        this.fLo.add(Integer.valueOf(this.fLl.length()));
        this.fLn.add(ah.getContext().getString(2131300634));
        this.fLl += ah.getContext().getString(2131300634);
        this.fLp.add(Integer.valueOf(this.fLl.length()));
        break;
        label856:
        this.fLs.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.fLv.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.gge.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.ggd.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.fLw.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1079:
      AppMethodBeat.o(78919);
      return true;
    }
    ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bo.nullAsNil(this.TYPE) });
    AppMethodBeat.o(78919);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.b
 * JD-Core Version:    0.7.0.1
 */