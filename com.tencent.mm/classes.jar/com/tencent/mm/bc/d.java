package com.tencent.mm.bc;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String fAo;
  public String lWn;
  public LinkedList<String> lWo;
  public int lWq;
  public LinkedList<String> lWr;
  public LinkedList<String> lWs;
  public String lWt;
  public String lWu;
  public String lWv;
  public String text;
  
  public d(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
    AppMethodBeat.i(101785);
    this.lWo = new LinkedList();
    this.lWr = new LinkedList();
    this.lWs = new LinkedList();
    this.lWt = null;
    this.lWu = null;
    this.lWv = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean bcz()
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
      this.lWn = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.lWv = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.lWt = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.lWu = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(lWe)) {
        this.text = Util.nullAsNil((String)this.values.get(lWe));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.fAo = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.lWq = Util.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.fNz.hAc())
      {
        this.lWk.add(Integer.valueOf(this.text.length()));
        this.lWj.add(this.lWv);
        this.lWg = (this.text + this.lWv);
        this.lWl.add(Integer.valueOf(this.lWg.length()));
        if (i >= this.lWq) {
          break label765;
        }
        if (i != 0) {
          break label630;
        }
        this.lWo.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.lWr.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.lWs.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.lWj.clear();
        this.lWk.clear();
        this.lWl.clear();
        this.lWg = (this.text + " ");
        this.lWk.add(Integer.valueOf(this.lWg.length()));
        this.lWj.add(MMApplicationContext.getContext().getString(b.a.has_approve_info));
        this.lWg += MMApplicationContext.getContext().getString(b.a.has_approve_info);
        this.lWl.add(Integer.valueOf(this.lWg.length()));
        break;
        label630:
        this.lWo.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.lWr.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.lWs.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.d
 * JD-Core Version:    0.7.0.1
 */