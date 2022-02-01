package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String ddJ;
  public String hOG;
  public LinkedList<String> hOH;
  public String hOI;
  public String text;
  
  public b(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
    AppMethodBeat.i(101782);
    this.hOH = new LinkedList();
    this.text = null;
    this.hOI = null;
    this.ddJ = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean axn()
  {
    AppMethodBeat.i(101783);
    if (this.values == null)
    {
      ac.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(101783);
      return false;
    }
    ac.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.hOG = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(hOy)) {
        this.text = bs.nullAsNil((String)this.values.get(hOy));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.hOI = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.ddJ = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.hOA = this.text;
      if (!this.dpq.fce())
      {
        this.hOC.add(this.hOI);
        this.hOD.add(Integer.valueOf(this.hOA.length()));
        this.hOA += this.hOI;
        this.hOE.add(Integer.valueOf(this.hOA.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.hOH.add(this.values.get(str));
          }
        }
        this.hOA = (this.hOA + " " + ai.getContext().getString(2131760234));
      }
      AppMethodBeat.o(101783);
      return true;
    }
    ac.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
    AppMethodBeat.o(101783);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */