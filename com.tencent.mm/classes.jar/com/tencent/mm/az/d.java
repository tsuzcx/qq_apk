package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;
import java.util.Map;

public final class d
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
  public String text;
  
  public d(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
    AppMethodBeat.i(101785);
    this.hOH = new LinkedList();
    this.hOK = new LinkedList();
    this.hOL = new LinkedList();
    this.hOM = null;
    this.hON = null;
    this.hOO = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean axn()
  {
    int i = 0;
    AppMethodBeat.i(101786);
    if (this.values == null)
    {
      ac.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101786);
      return false;
    }
    ac.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.hOG = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.hOO = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.hOM = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.hON = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(hOy)) {
        this.text = bs.nullAsNil((String)this.values.get(hOy));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.ddJ = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.hOJ = bs.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dpq.fce())
      {
        this.hOD.add(Integer.valueOf(this.text.length()));
        this.hOC.add(this.hOO);
        this.hOA = (this.text + this.hOO);
        this.hOE.add(Integer.valueOf(this.hOA.length()));
        if (i >= this.hOJ) {
          break label763;
        }
        if (i != 0) {
          break label628;
        }
        this.hOH.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.hOK.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.hOL.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
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
        label628:
        this.hOH.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.hOK.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.hOL.add(bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label763:
      AppMethodBeat.o(101786);
      return true;
    }
    ac.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.d
 * JD-Core Version:    0.7.0.1
 */