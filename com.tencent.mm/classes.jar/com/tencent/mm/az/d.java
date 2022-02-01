package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends a
{
  public String dHx;
  public String jfM;
  public LinkedList<String> jfN;
  public int jfP;
  public LinkedList<String> jfQ;
  public LinkedList<String> jfR;
  public String jfS;
  public String jfT;
  public String jfU;
  public String text;
  
  public d(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
    AppMethodBeat.i(101785);
    this.jfN = new LinkedList();
    this.jfQ = new LinkedList();
    this.jfR = new LinkedList();
    this.jfS = null;
    this.jfT = null;
    this.jfU = null;
    this.text = null;
    AppMethodBeat.o(101785);
  }
  
  protected final boolean aTA()
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
      this.jfM = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.jfU = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.jfS = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.jfT = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(jfE)) {
        this.text = Util.nullAsNil((String)this.values.get(jfE));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.dHx = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.jfP = Util.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.dTX.gDO())
      {
        this.jfJ.add(Integer.valueOf(this.text.length()));
        this.jfI.add(this.jfU);
        this.jfG = (this.text + this.jfU);
        this.jfK.add(Integer.valueOf(this.jfG.length()));
        if (i >= this.jfP) {
          break label763;
        }
        if (i != 0) {
          break label628;
        }
        this.jfN.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.jfQ.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.jfR.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.jfI.clear();
        this.jfJ.clear();
        this.jfK.clear();
        this.jfG = (this.text + " ");
        this.jfJ.add(Integer.valueOf(this.jfG.length()));
        this.jfI.add(MMApplicationContext.getContext().getString(2131761615));
        this.jfG += MMApplicationContext.getContext().getString(2131761615);
        this.jfK.add(Integer.valueOf(this.jfG.length()));
        break;
        label628:
        this.jfN.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.jfQ.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.jfR.add(Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label763:
      AppMethodBeat.o(101786);
      return true;
    }
    Log.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.d
 * JD-Core Version:    0.7.0.1
 */