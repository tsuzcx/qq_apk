package com.tencent.mm.ax;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;
import java.util.Map;

public final class d
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
  public String text;
  
  public d(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
    AppMethodBeat.i(101785);
    this.oPq = new LinkedList();
    this.oPt = new LinkedList();
    this.oPu = new LinkedList();
    this.oPv = null;
    this.oPw = null;
    this.oPx = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean bAo()
  {
    int i = 0;
    AppMethodBeat.i(101786);
    if (this.values == null)
    {
      Log.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101786);
      return false;
    }
    Log.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!Util.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.oPp = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.oPx = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.oPv = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.oPw = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(oPh)) {
        this.text = Util.nullAsNil((String)this.values.get(oPh));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.hFb = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.oPs = Util.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.hTm.jcg())
      {
        this.oPm.add(Integer.valueOf(this.text.length()));
        this.oPl.add(this.oPx);
        this.oPj = (this.text + this.oPx);
        this.oPn.add(Integer.valueOf(this.oPj.length()));
        if (i >= this.oPs) {
          break label765;
        }
        if (i != 0) {
          break label630;
        }
        this.oPq.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.oPt.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.oPu.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
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
        this.oPl.add(MMApplicationContext.getContext().getString(b.a.has_approve_info));
        this.oPj += MMApplicationContext.getContext().getString(b.a.has_approve_info);
        this.oPn.add(Integer.valueOf(this.oPj.length()));
        break;
        label630:
        this.oPq.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.oPt.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.oPu.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label765:
      AppMethodBeat.o(101786);
      return true;
    }
    Log.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.d
 * JD-Core Version:    0.7.0.1
 */