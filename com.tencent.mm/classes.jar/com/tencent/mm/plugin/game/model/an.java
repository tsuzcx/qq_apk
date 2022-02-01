package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ac;
import com.tencent.mm.plugin.game.protobuf.bn;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    Log.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new d.a();
    ((d.a)localObject).iLN = new bn();
    ((d.a)localObject).iLO = new bo();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bn)this.hhm.iLK.iLR;
    ((bn)localObject).xLl = paramString;
    ((bn)localObject).xLF = paramLinkedList;
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
      ((bn)localObject).keh = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bn)localObject).xLG = new ac();
        if (paramo1 != null)
        {
          ((bn)localObject).xLG.xJZ = paramo1.xFg.xGi;
          ((bn)localObject).xLG.jfi = paramo1.field_appId;
          ((bn)localObject).xLG.xIG = paramo1.xFW;
          ((bn)localObject).xLG.xKb = paramo1.xFV;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bn)localObject).xLG;
          paramLinkedList.xKa |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bn)localObject).xLG;
          paramLinkedList.xKa |= 0x2;
        }
        ((bn)localObject).xLH = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().dVz();
        ((bn)localObject).xLI = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bn)localObject).xLm = i;
          Log.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bn)localObject).keh)) && (!"CN".equalsIgnoreCase(((bn)localObject).keh))) {
            h.CyF.idkeyStat(860L, 7L, 1L, false);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(41602);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */