package com.tencent.mm.az;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String dHx;
  public String jfM;
  public LinkedList<String> jfN;
  public String jfO;
  public String text;
  
  public b(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
    AppMethodBeat.i(101782);
    this.jfN = new LinkedList();
    this.text = null;
    this.jfO = null;
    this.dHx = null;
    AppMethodBeat.o(101782);
  }
  
  protected final boolean aTA()
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
      this.jfM = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(jfE)) {
        this.text = Util.nullAsNil((String)this.values.get(jfE));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.jfO = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.dHx = Util.nullAsNil((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.jfG = this.text;
      if (!this.dTX.gDO())
      {
        this.jfI.add(this.jfO);
        this.jfJ.add(Integer.valueOf(this.jfG.length()));
        this.jfG += this.jfO;
        this.jfK.add(Integer.valueOf(this.jfG.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.jfN.add(this.values.get(str));
          }
        }
        this.jfG = (this.jfG + " " + MMApplicationContext.getContext().getString(2131761620));
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
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */