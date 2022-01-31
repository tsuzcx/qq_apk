package com.tencent.mm.ay;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String crs;
  public String fLr;
  public LinkedList<String> fLs;
  public String fLt;
  public String text;
  
  public b(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
    AppMethodBeat.i(5553);
    this.fLs = new LinkedList();
    this.text = null;
    this.fLt = null;
    this.crs = null;
    AppMethodBeat.o(5553);
  }
  
  protected final boolean Zh()
  {
    AppMethodBeat.i(5554);
    if (this.values == null)
    {
      ab.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(5554);
      return false;
    }
    ab.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bo.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.fLr = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(fLj)) {
        this.text = bo.nullAsNil((String)this.values.get(fLj));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.fLt = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.crs = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.fLl = this.text;
      if (!this.cEE.dyn())
      {
        this.fLn.add(this.fLt);
        this.fLo.add(Integer.valueOf(this.fLl.length()));
        this.fLl += this.fLt;
        this.fLp.add(Integer.valueOf(this.fLl.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.fLs.add(this.values.get(str));
          }
        }
        this.fLl = (this.fLl + " " + ah.getContext().getString(2131300638));
      }
      AppMethodBeat.o(5554);
      return true;
    }
    ab.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bo.nullAsNil(this.TYPE) });
    AppMethodBeat.o(5554);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ay.b
 * JD-Core Version:    0.7.0.1
 */