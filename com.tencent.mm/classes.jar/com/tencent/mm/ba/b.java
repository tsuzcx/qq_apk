package com.tencent.mm.ba;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String dgo;
  public String hod;
  public LinkedList<String> hoe;
  public String hof;
  public String text;
  
  public b(Map<String, String> paramMap, bl parambl)
  {
    super(paramMap, parambl);
    AppMethodBeat.i(101782);
    this.hoe = new LinkedList();
    this.text = null;
    this.hof = null;
    this.dgo = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean aqx()
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
      this.hod = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(hnV)) {
        this.text = bt.nullAsNil((String)this.values.get(hnV));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.hof = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.dgo = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.hnX = this.text;
      if (!this.drF.eMz())
      {
        this.hnZ.add(this.hof);
        this.hoa.add(Integer.valueOf(this.hnX.length()));
        this.hnX += this.hof;
        this.hob.add(Integer.valueOf(this.hnX.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.hoe.add(this.values.get(str));
          }
        }
        this.hnX = (this.hnX + " " + aj.getContext().getString(2131760234));
      }
      AppMethodBeat.o(101783);
      return true;
    }
    ad.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.b
 * JD-Core Version:    0.7.0.1
 */