package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ad;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.game.protobuf.bp;
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
  public final d jTk;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    Log.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new d.a();
    ((d.a)localObject).lBU = new bo();
    ((d.a)localObject).lBV = new bp();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (bo)d.b.b(this.jTk.lBR);
    ((bo)localObject).CPt = paramString;
    ((bo)localObject).CPO = paramLinkedList;
    paramLinkedList = e.gz(MMApplicationContext.getContext());
    paramString = paramLinkedList;
    if (Util.isNullOrNil(paramLinkedList)) {
      paramString = Util.getSimCountryCode(MMApplicationContext.getContext());
    }
    if (!Util.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bo)localObject).mVH = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bo)localObject).CPP = new ad();
        if (paramo1 != null)
        {
          ((bo)localObject).CPP.COg = paramo1.CJh.CKl;
          ((bo)localObject).CPP.lVG = paramo1.field_appId;
          ((bo)localObject).CPP.CML = paramo1.CJX;
          ((bo)localObject).CPP.COi = paramo1.CJW;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bo)localObject).CPP;
          paramLinkedList.COh |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bo)localObject).CPP;
          paramLinkedList.COh |= 0x2;
        }
        ((bo)localObject).CPQ = ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyH();
        ((bo)localObject).CPR = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bo)localObject).CPu = i;
          Log.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bo)localObject).mVH)) && (!"CN".equalsIgnoreCase(((bo)localObject).mVH))) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(860L, 7L, 1L, false);
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41602);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */