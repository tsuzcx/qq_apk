package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.bx;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aq
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public aq(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(41610);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new bx();
    ((c.a)localObject).otF = new by();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (bx)c.b.b(this.mtC.otB);
    ((bx)localObject).IKo = paramInt1;
    ((bx)localObject).IKp = 15;
    ((bx)localObject).IJD = LocaleUtil.getApplicationLanguage();
    ((bx)localObject).pSo = Util.getSimCountryCode(MMApplicationContext.getContext());
    ((bx)localObject).IKq = paramInt2;
    ((bx)localObject).IJY = paramLinkedList;
    ((bx)localObject).IKr = paramBoolean;
    AppMethodBeat.o(41610);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41611);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41611);
    return i;
  }
  
  public final int getType()
  {
    return 1218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41612);
    Log.i("MicroMsg.NetSceneGetLibGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aq
 * JD-Core Version:    0.7.0.1
 */