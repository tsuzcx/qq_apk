package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ReportMsgReadRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.ReportMsgReadResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private final d jTk;
  
  public m(String paramString, List<Long> paramList)
  {
    AppMethodBeat.i(211604);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ReportMsgReadRequest();
    ((d.a)localObject).lBV = new ReportMsgReadResponse();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/reportmsgread";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (ReportMsgReadRequest)d.b.b(this.jTk.lBR);
    ((ReportMsgReadRequest)localObject).chatroom_name = paramString;
    if (!Util.isNullOrNil(paramList))
    {
      ((ReportMsgReadRequest)localObject).read_seq_list.addAll(paramList);
      Log.i("GameChatRoom.CgiReportMsgRead", "report at list:%s", new Object[] { paramList.toString() });
    }
    AppMethodBeat.o(211604);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(211606);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(211606);
    return i;
  }
  
  public final int getType()
  {
    return 4524;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211608);
    Log.i("GameChatRoom.CgiReportMsgRead", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.m
 * JD-Core Version:    0.7.0.1
 */