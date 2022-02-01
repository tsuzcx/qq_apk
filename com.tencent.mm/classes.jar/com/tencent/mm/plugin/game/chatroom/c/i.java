package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ExportExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private boolean Cux;
  private long Cuy;
  private long Cuz;
  private com.tencent.mm.an.i callback;
  public final com.tencent.mm.an.d jTk;
  
  public i(String paramString, Lbs paramLbs, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(211981);
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).lBU = new JoinChatroomRequest();
    ((com.tencent.mm.an.d.a)localObject).lBV = new JoinChatroomResponse();
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/joinchatroom";
    ((com.tencent.mm.an.d.a)localObject).funcId = getType();
    ((com.tencent.mm.an.d.a)localObject).lBW = 0;
    ((com.tencent.mm.an.d.a)localObject).respCmdId = 0;
    this.Cux = paramBoolean;
    this.Cuy = paramLong1;
    this.Cuz = paramLong2;
    this.jTk = ((com.tencent.mm.an.d.a)localObject).bgN();
    localObject = (JoinChatroomRequest)d.b.b(this.jTk.lBR);
    ((JoinChatroomRequest)localObject).chatroom_name = paramString;
    if (paramLbs != null) {
      ((JoinChatroomRequest)localObject).lbs_info = paramLbs;
    }
    paramString = new ExportExternInfo();
    paramString.sourceid = paramLong2;
    paramString.ssid = paramLong1;
    ((JoinChatroomRequest)localObject).extern_info = paramString;
    AppMethodBeat.o(211981);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(211982);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(211982);
    return i;
  }
  
  public final int getType()
  {
    return 4897;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211983);
    Log.i("GameChatRoom.CgiJoinChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.Cux))
    {
      params = com.tencent.mm.game.report.d.jTj;
      com.tencent.mm.game.report.d.a.b(1L, 14L, 0L, this.Cuy, this.Cuz);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.i
 * JD-Core Version:    0.7.0.1
 */