package com.tencent.mm.ay;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;
import java.util.Map;

public final class d
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
  public String text;
  
  public d(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
    AppMethodBeat.i(5556);
    this.fLs = new LinkedList();
    this.fLv = new LinkedList();
    this.fLw = new LinkedList();
    this.fLx = null;
    this.fLy = null;
    this.fLz = null;
    this.text = null;
    AppMethodBeat.o(5556);
  }
  
  protected final boolean Zh()
  {
    int i = 0;
    AppMethodBeat.i(5557);
    if (this.values == null)
    {
      ab.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(5557);
      return false;
    }
    ab.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bo.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.fLr = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.fLz = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.fLx = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.fLy = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(fLj)) {
        this.text = bo.nullAsNil((String)this.values.get(fLj));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.crs = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.fLu = bo.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.cEE.dyn())
      {
        this.fLo.add(Integer.valueOf(this.text.length()));
        this.fLn.add(this.fLz);
        this.fLl = (this.text + this.fLz);
        this.fLp.add(Integer.valueOf(this.fLl.length()));
        if (i >= this.fLu) {
          break label765;
        }
        if (i != 0) {
          break label630;
        }
        this.fLs.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.fLv.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.fLw.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
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
        label630:
        this.fLs.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.fLv.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.fLw.add(bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label765:
      AppMethodBeat.o(5557);
      return true;
    }
    ab.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bo.nullAsNil(this.TYPE) });
    AppMethodBeat.o(5557);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ay.d
 * JD-Core Version:    0.7.0.1
 */