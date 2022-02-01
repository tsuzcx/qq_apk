package com.tencent.mm.ax;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String hFb;
  public String oPp;
  public LinkedList<String> oPq;
  public String oPr;
  public String text;
  
  public b(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
    AppMethodBeat.i(101782);
    this.oPq = new LinkedList();
    this.text = null;
    this.oPr = null;
    this.hFb = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean bAo()
  {
    AppMethodBeat.i(101783);
    if (this.values == null)
    {
      Log.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101783);
      return false;
    }
    Log.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!Util.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.oPp = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(oPh)) {
        this.text = Util.nullAsNil((String)this.values.get(oPh));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.oPr = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.hFb = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.oPj = this.text;
      if (!this.hTm.jcg())
      {
        this.oPl.add(this.oPr);
        this.oPm.add(Integer.valueOf(this.oPj.length()));
        this.oPj += this.oPr;
        this.oPn.add(Integer.valueOf(this.oPj.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.oPq.add((String)this.values.get(str));
          }
        }
        this.oPj = (this.oPj + " " + MMApplicationContext.getContext().getString(b.a.has_send_invite));
      }
      AppMethodBeat.o(101783);
      return true;
    }
    Log.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { Util.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.b
 * JD-Core Version:    0.7.0.1
 */