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
import com.tencent.mm.plugin.game.protobuf.bt;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c mtC;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bt();
    ((bt)localObject).IJD = paramString;
    ((bt)localObject).IJY = paramLinkedList;
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
      ((bt)localObject).pSo = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bt)localObject).IJZ = new ae();
        if (paramo1 != null)
        {
          ((bt)localObject).IJZ.IIq = paramo1.IDs.IEw;
          ((bt)localObject).IJZ.oOI = paramo1.field_appId;
          ((bt)localObject).IJZ.IGQ = paramo1.mNoticeId;
          ((bt)localObject).IJZ.IIs = paramo1.IEh;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bt)localObject).IJZ;
          paramLinkedList.IIr |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bt)localObject).IJZ;
          paramLinkedList.IIr |= 0x2;
        }
        ((bt)localObject).IKa = ((f)com.tencent.mm.kernel.h.ax(f.class)).fCh().fGD();
        ((bt)localObject).IKb = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bt)localObject).IJE = i;
          Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new c.a();
          paramString.otE = ((a)localObject);
          paramString.otF = new bu();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.otG = 0;
          paramString.respCmdId = 0;
          this.mtC = paramString.bEF();
          AppMethodBeat.o(41604);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label411;
          }
          paramo1 = paramo3;
          break;
        }
        label411:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(41605);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41605);
    return i;
  }
  
  public final int getType()
  {
    return 2586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41606);
    Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */