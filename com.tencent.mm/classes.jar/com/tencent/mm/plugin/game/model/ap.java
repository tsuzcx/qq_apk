package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ac;
import com.tencent.mm.plugin.game.protobuf.bt;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    Log.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bt();
    ((bt)localObject).xLl = paramString;
    ((bt)localObject).xLF = paramLinkedList;
    paramLinkedList = e.gf(MMApplicationContext.getContext());
    paramString = paramLinkedList;
    if (Util.isNullOrNil(paramLinkedList)) {
      paramString = Util.getSimCountryCode(MMApplicationContext.getContext());
    }
    if (!Util.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bt)localObject).keh = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bt)localObject).xLG = new ac();
        if (paramo1 != null)
        {
          ((bt)localObject).xLG.xJZ = paramo1.xFg.xGi;
          ((bt)localObject).xLG.jfi = paramo1.field_appId;
          ((bt)localObject).xLG.xIG = paramo1.xFW;
          ((bt)localObject).xLG.xKb = paramo1.xFV;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bt)localObject).xLG;
          paramLinkedList.xKa |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bt)localObject).xLG;
          paramLinkedList.xKa |= 0x2;
        }
        ((bt)localObject).xLH = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().dVz();
        ((bt)localObject).xLI = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bt)localObject).xLm = i;
          Log.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bt)localObject).keh)) && ("CN".equalsIgnoreCase(((bt)localObject).keh))) {
            h.CyF.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new d.a();
          paramString.iLN = ((a)localObject);
          paramString.iLO = new bu();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.iLP = 0;
          paramString.respCmdId = 0;
          this.hhm = paramString.aXF();
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(41608);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */