package com.tencent.mm.openim.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends a
{
  public String hFb;
  public String oPp;
  public LinkedList<String> oPq;
  public int oPs;
  public LinkedList<String> oPt;
  public LinkedList<String> oPu;
  public String oPv;
  public String oPw;
  public String oPx;
  public LinkedList<String> ptm;
  public LinkedList<String> ptn;
  public String pto;
  public String ptp;
  public String text;
  
  public b(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
    AppMethodBeat.i(151262);
    this.oPq = new LinkedList();
    this.oPt = new LinkedList();
    this.ptm = new LinkedList();
    this.ptn = new LinkedList();
    this.oPu = new LinkedList();
    this.oPv = null;
    this.pto = null;
    this.ptp = null;
    this.oPw = null;
    this.oPx = null;
    this.text = null;
    AppMethodBeat.o(151262);
  }
  
  public final boolean bAo()
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
      this.oPp = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text")) {
        this.oPx = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username")) {
        this.oPv = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid")) {
        this.pto = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".appid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid")) {
        this.ptp = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.inviter" + ".descid"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason")) {
        this.oPw = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.invitationreason"));
      }
      if (this.values.containsKey(oPh)) {
        this.text = Util.nullAsNil((String)this.values.get(oPh));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket")) {
        this.hFb = ((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize")) {
        this.oPs = Util.getInt((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.hTm.jcg())
      {
        this.oPm.add(Integer.valueOf(this.text.length()));
        this.oPl.add(this.oPx);
        this.oPj = (this.text + this.oPx);
        this.oPn.add(Integer.valueOf(this.oPj.length()));
        if (i >= this.oPs) {
          break label1081;
        }
        if (i != 0) {
          break label858;
        }
        this.oPq.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.username")));
        this.oPt.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.nickname")));
        this.ptm.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.descid")));
        this.ptn.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.appid")));
        this.oPu.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.oPl.clear();
        this.oPm.clear();
        this.oPn.clear();
        this.oPj = (this.text + " ");
        this.oPm.add(Integer.valueOf(this.oPj.length()));
        this.oPl.add(MMApplicationContext.getContext().getString(c.h.has_approve_info));
        this.oPj += MMApplicationContext.getContext().getString(c.h.has_approve_info);
        this.oPn.add(Integer.valueOf(this.oPj.length()));
        break;
        label858:
        this.oPq.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".username")));
        this.oPt.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".nickname")));
        this.ptn.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".appid")));
        this.ptm.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".descid")));
        this.oPu.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label1081:
      AppMethodBeat.o(151263);
      return true;
    }
    Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.a.b
 * JD-Core Version:    0.7.0.1
 */