package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.bv;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aq
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public aq(int paramInt1, LinkedList<String> paramLinkedList, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(41610);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bv();
    ((d.a)localObject).iLO = new bw();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bv)this.hhm.iLK.iLR;
    ((bv)localObject).xLV = paramInt1;
    ((bv)localObject).xLW = 15;
    ((bv)localObject).xLl = LocaleUtil.getApplicationLanguage();
    ((bv)localObject).keh = Util.getSimCountryCode(MMApplicationContext.getContext());
    ((bv)localObject).xLX = paramInt2;
    ((bv)localObject).xLF = paramLinkedList;
    ((bv)localObject).xLY = paramBoolean;
    AppMethodBeat.o(41610);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41611);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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