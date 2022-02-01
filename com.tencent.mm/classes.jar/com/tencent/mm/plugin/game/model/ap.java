package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ae;
import com.tencent.mm.plugin.game.protobuf.bv;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c mtC;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    Log.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bv();
    ((bv)localObject).IJD = paramString;
    ((bv)localObject).IJY = paramLinkedList;
    paramLinkedList = e.hS(MMApplicationContext.getContext());
    paramString = paramLinkedList;
    if (Util.isNullOrNil(paramLinkedList)) {
      paramString = Util.getSimCountryCode(MMApplicationContext.getContext());
    }
    if (!Util.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bv)localObject).pSo = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bv)localObject).IJZ = new ae();
        if (paramo1 != null)
        {
          ((bv)localObject).IJZ.IIq = paramo1.IDs.IEw;
          ((bv)localObject).IJZ.oOI = paramo1.field_appId;
          ((bv)localObject).IJZ.IGQ = paramo1.mNoticeId;
          ((bv)localObject).IJZ.IIs = paramo1.IEh;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bv)localObject).IJZ;
          paramLinkedList.IIr |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bv)localObject).IJZ;
          paramLinkedList.IIr |= 0x2;
        }
        ((bv)localObject).IKa = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGD();
        ((bv)localObject).IKb = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bv)localObject).IJE = i;
          Log.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bv)localObject).pSo)) && ("CN".equalsIgnoreCase(((bv)localObject).pSo))) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new c.a();
          paramString.otE = ((a)localObject);
          paramString.otF = new bw();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.otG = 0;
          paramString.respCmdId = 0;
          this.mtC = paramString.bEF();
          AppMethodBeat.o(41607);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label449;
          }
          paramo1 = paramo3;
          break;
        }
        label449:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(41608);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41608);
    return i;
  }
  
  public final int getType()
  {
    return 2855;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41609);
    Log.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */