package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ExportExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private boolean Ijp;
  private long Ijq;
  private long Ijr;
  private h callback;
  public final c mtC;
  
  public m(String paramString, Lbs paramLbs, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(275827);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new JoinChatroomRequest();
    ((c.a)localObject).otF = new JoinChatroomResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/joinchatroom";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.Ijp = paramBoolean;
    this.Ijq = paramLong1;
    this.Ijr = paramLong2;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (JoinChatroomRequest)c.b.b(this.mtC.otB);
    ((JoinChatroomRequest)localObject).chatroom_name = paramString;
    if (paramLbs != null) {
      ((JoinChatroomRequest)localObject).lbs_info = paramLbs;
    }
    paramString = new ExportExternInfo();
    paramString.sourceid = paramLong2;
    paramString.ssid = paramLong1;
    ((JoinChatroomRequest)localObject).extern_info = paramString;
    AppMethodBeat.o(275827);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275840);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275840);
    return i;
  }
  
  public final int getType()
  {
    return 4897;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275851);
    Log.i("GameChatRoom.CgiJoinChatRoom", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.Ijp)) {
      d.mty.b(1L, 14L, 0L, this.Ijq, this.Ijr);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.m
 * JD-Core Version:    0.7.0.1
 */