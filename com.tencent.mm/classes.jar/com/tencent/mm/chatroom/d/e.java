package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
  extends a<cv>
{
  public e(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(196564);
    ad.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.n(paramLinkedList, ";") });
    cu localcu = new cu();
    localcu.dlX = paramString;
    localcu.CxJ = paramLinkedList;
    paramString = new b.a();
    paramString.gUU = localcu;
    paramString.gUV = new cv();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    this.rr = paramString.atI();
    AppMethodBeat.o(196564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.e
 * JD-Core Version:    0.7.0.1
 */