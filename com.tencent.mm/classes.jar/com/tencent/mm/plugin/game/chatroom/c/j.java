package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.KickOutChatroomMemberRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.KickOutChatroomMemberResponse;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public j(String paramString)
  {
    AppMethodBeat.i(212428);
    d.a locala = new d.a();
    locala.lBU = new KickOutChatroomMemberRequest();
    locala.lBV = new KickOutChatroomMemberResponse();
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/kickoutchatroommember";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.jTk = locala.bgN();
    ((KickOutChatroomMemberRequest)d.b.b(this.jTk.lBR)).username = paramString;
    Log.i("GameChatRoom.CgiKickOutChatroomMember", "userName:%s", new Object[] { paramString });
    AppMethodBeat.o(212428);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(212430);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(212430);
    return i;
  }
  
  public final int getType()
  {
    return 4596;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212432);
    Log.i("GameChatRoom.CgiKickOutChatroomMember", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(212432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.j
 * JD-Core Version:    0.7.0.1
 */