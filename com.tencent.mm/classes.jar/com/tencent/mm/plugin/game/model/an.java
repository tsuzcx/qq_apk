package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ae;
import com.tencent.mm.plugin.game.protobuf.bp;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c mtC;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    Log.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new c.a();
    ((c.a)localObject).otE = new bp();
    ((c.a)localObject).otF = new bq();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (bp)c.b.b(this.mtC.otB);
    ((bp)localObject).IJD = paramString;
    ((bp)localObject).IJY = paramLinkedList;
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
      ((bp)localObject).pSo = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bp)localObject).IJZ = new ae();
        if (paramo1 != null)
        {
          ((bp)localObject).IJZ.IIq = paramo1.IDs.IEw;
          ((bp)localObject).IJZ.oOI = paramo1.field_appId;
          ((bp)localObject).IJZ.IGQ = paramo1.mNoticeId;
          ((bp)localObject).IJZ.IIs = paramo1.IEh;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bp)localObject).IJZ;
          paramLinkedList.IIr |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bp)localObject).IJZ;
          paramLinkedList.IIr |= 0x2;
        }
        ((bp)localObject).IKa = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGD();
        ((bp)localObject).IKb = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bp)localObject).IJE = i;
          Log.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bp)localObject).pSo)) && (!"CN".equalsIgnoreCase(((bp)localObject).pSo))) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(860L, 7L, 1L, false);
          }
          AppMethodBeat.o(41601);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label468;
          }
          paramo1 = paramo3;
          break;
        }
        label468:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(41602);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41602);
    return i;
  }
  
  public final int getType()
  {
    return 2994;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41603);
    Log.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */