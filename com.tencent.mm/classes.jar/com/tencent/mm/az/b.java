package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String dqk;
  public String ikN;
  public LinkedList<String> ikO;
  public String ikP;
  public String text;
  
  public b(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
    AppMethodBeat.i(101782);
    this.ikO = new LinkedList();
    this.text = null;
    this.ikP = null;
    this.dqk = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean aAs()
  {
    AppMethodBeat.i(101783);
    if (this.values == null)
    {
      ae.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101783);
      return false;
    }
    ae.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bu.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.ikN = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(ikF)) {
        this.text = bu.nullAsNil((String)this.values.get(ikF));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.ikP = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.dqk = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.ikH = this.text;
      if (!this.dCi.fwi())
      {
        this.ikJ.add(this.ikP);
        this.ikK.add(Integer.valueOf(this.ikH.length()));
        this.ikH += this.ikP;
        this.ikL.add(Integer.valueOf(this.ikH.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.ikO.add(this.values.get(str));
          }
        }
        this.ikH = (this.ikH + " " + ak.getContext().getString(2131760234));
      }
      AppMethodBeat.o(101783);
      return true;
    }
    ae.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bu.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */