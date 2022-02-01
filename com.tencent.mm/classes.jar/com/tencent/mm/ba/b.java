package com.tencent.mm.ba;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String dpf;
  public String ihU;
  public LinkedList<String> ihV;
  public String ihW;
  public String text;
  
  public b(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
    AppMethodBeat.i(101782);
    this.ihV = new LinkedList();
    this.text = null;
    this.ihW = null;
    this.dpf = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean aAc()
  {
    AppMethodBeat.i(101783);
    if (this.values == null)
    {
      ad.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101783);
      return false;
    }
    ad.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.ihU = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(ihM)) {
        this.text = bt.nullAsNil((String)this.values.get(ihM));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.ihW = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.dpf = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.ihO = this.text;
      if (!this.dBd.fsh())
      {
        this.ihQ.add(this.ihW);
        this.ihR.add(Integer.valueOf(this.ihO.length()));
        this.ihO += this.ihW;
        this.ihS.add(Integer.valueOf(this.ihO.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.ihV.add(this.values.get(str));
          }
        }
        this.ihO = (this.ihO + " " + aj.getContext().getString(2131760234));
      }
      AppMethodBeat.o(101783);
      return true;
    }
    ad.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */