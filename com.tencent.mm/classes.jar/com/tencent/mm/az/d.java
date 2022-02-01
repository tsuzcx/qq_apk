package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String dqk;
  public String ikN;
  public LinkedList<String> ikO;
  public int ikQ;
  public LinkedList<String> ikR;
  public LinkedList<String> ikS;
  public String ikT;
  public String ikU;
  public String ikV;
  public String text;
  
  public d(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
    AppMethodBeat.i(101785);
    this.ikO = new LinkedList();
    this.ikR = new LinkedList();
    this.ikS = new LinkedList();
    this.ikT = null;
    this.ikU = null;
    this.ikV = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean aAs()
  {
    int i = 0;
    AppMethodBeat.i(101786);
    if (this.values == null)
    {
      ae.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101786);
      return false;
    }
    ae.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bu.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.ikN = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.ikV = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.ikT = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.ikU = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(ikF)) {
        this.text = bu.nullAsNil((String)this.values.get(ikF));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.dqk = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.ikQ = bu.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dCi.fwi())
      {
        this.ikK.add(Integer.valueOf(this.text.length()));
        this.ikJ.add(this.ikV);
        this.ikH = (this.text + this.ikV);
        this.ikL.add(Integer.valueOf(this.ikH.length()));
        if (i >= this.ikQ) {
          break label763;
        }
        if (i != 0) {
          break label628;
        }
        this.ikO.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.ikR.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.ikS.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
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
        label628:
        this.ikO.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.ikR.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.ikS.add(bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label763:
      AppMethodBeat.o(101786);
      return true;
    }
    ae.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bu.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.d
 * JD-Core Version:    0.7.0.1
 */