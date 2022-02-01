package com.tencent.mm.ba;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String dpf;
  public String ihU;
  public LinkedList<String> ihV;
  public int ihX;
  public LinkedList<String> ihY;
  public LinkedList<String> ihZ;
  public String iia;
  public String iib;
  public String iic;
  public String text;
  
  public d(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
    AppMethodBeat.i(101785);
    this.ihV = new LinkedList();
    this.ihY = new LinkedList();
    this.ihZ = new LinkedList();
    this.iia = null;
    this.iib = null;
    this.iic = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean aAc()
  {
    int i = 0;
    AppMethodBeat.i(101786);
    if (this.values == null)
    {
      ad.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101786);
      return false;
    }
    ad.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.ihU = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.iic = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.iia = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.iib = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(ihM)) {
        this.text = bt.nullAsNil((String)this.values.get(ihM));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.dpf = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.ihX = bt.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dBd.fsh())
      {
        this.ihR.add(Integer.valueOf(this.text.length()));
        this.ihQ.add(this.iic);
        this.ihO = (this.text + this.iic);
        this.ihS.add(Integer.valueOf(this.ihO.length()));
        if (i >= this.ihX) {
          break label763;
        }
        if (i != 0) {
          break label628;
        }
        this.ihV.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.ihY.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.ihZ.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
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
        label628:
        this.ihV.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.ihY.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.ihZ.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label763:
      AppMethodBeat.o(101786);
      return true;
    }
    ad.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */