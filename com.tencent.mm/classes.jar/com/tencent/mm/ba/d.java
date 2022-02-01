package com.tencent.mm.ba;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String dgo;
  public String hod;
  public LinkedList<String> hoe;
  public int hog;
  public LinkedList<String> hoh;
  public LinkedList<String> hoi;
  public String hoj;
  public String hok;
  public String hol;
  public String text;
  
  public d(Map<String, String> paramMap, bl parambl)
  {
    super(paramMap, parambl);
    AppMethodBeat.i(101785);
    this.hoe = new LinkedList();
    this.hoh = new LinkedList();
    this.hoi = new LinkedList();
    this.hoj = null;
    this.hok = null;
    this.hol = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean aqx()
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
      this.hod = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.hol = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.hoj = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.hok = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(hnV)) {
        this.text = bt.nullAsNil((String)this.values.get(hnV));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.dgo = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.hog = bt.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.drF.eMz())
      {
        this.hoa.add(Integer.valueOf(this.text.length()));
        this.hnZ.add(this.hol);
        this.hnX = (this.text + this.hol);
        this.hob.add(Integer.valueOf(this.hnX.length()));
        if (i >= this.hog) {
          break label763;
        }
        if (i != 0) {
          break label628;
        }
        this.hoe.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.hoh.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.hoi.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.hnZ.clear();
        this.hoa.clear();
        this.hob.clear();
        this.hnX = (this.text + " ");
        this.hoa.add(Integer.valueOf(this.hnX.length()));
        this.hnZ.add(aj.getContext().getString(2131760229));
        this.hnX += aj.getContext().getString(2131760229);
        this.hob.add(Integer.valueOf(this.hnX.length()));
        break;
        label628:
        this.hoe.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.hoh.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.hoi.add(bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.d
 * JD-Core Version:    0.7.0.1
 */