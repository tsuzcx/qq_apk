package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ad;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.game.protobuf.bv;
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
  public final d jTk;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    Log.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bu();
    ((bu)localObject).CPt = paramString;
    ((bu)localObject).CPO = paramLinkedList;
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
      ((bu)localObject).mVH = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bu)localObject).CPP = new ad();
        if (paramo1 != null)
        {
          ((bu)localObject).CPP.COg = paramo1.CJh.CKl;
          ((bu)localObject).CPP.lVG = paramo1.field_appId;
          ((bu)localObject).CPP.CML = paramo1.CJX;
          ((bu)localObject).CPP.COi = paramo1.CJW;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bu)localObject).CPP;
          paramLinkedList.COh |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bu)localObject).CPP;
          paramLinkedList.COh |= 0x2;
        }
        ((bu)localObject).CPQ = ((f)com.tencent.mm.kernel.h.ae(f.class)).evo().eyH();
        ((bu)localObject).CPR = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bu)localObject).CPu = i;
          Log.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!Util.isNullOrNil(((bu)localObject).mVH)) && ("CN".equalsIgnoreCase(((bu)localObject).mVH))) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new d.a();
          paramString.lBU = ((a)localObject);
          paramString.lBV = new bv();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.lBW = 0;
          paramString.respCmdId = 0;
          this.jTk = paramString.bgN();
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41608);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */