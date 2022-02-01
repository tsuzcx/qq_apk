package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.protobuf.ad;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.protobuf.bt;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bs();
    ((bs)localObject).CPt = paramString;
    ((bs)localObject).CPO = paramLinkedList;
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
      ((bs)localObject).mVH = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bs)localObject).CPP = new ad();
        if (paramo1 != null)
        {
          ((bs)localObject).CPP.COg = paramo1.CJh.CKl;
          ((bs)localObject).CPP.lVG = paramo1.field_appId;
          ((bs)localObject).CPP.CML = paramo1.CJX;
          ((bs)localObject).CPP.COi = paramo1.CJW;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bs)localObject).CPP;
          paramLinkedList.COh |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bs)localObject).CPP;
          paramLinkedList.COh |= 0x2;
        }
        ((bs)localObject).CPQ = ((f)h.ae(f.class)).evo().eyH();
        ((bs)localObject).CPR = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((bs)localObject).CPu = i;
          Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new d.a();
          paramString.lBU = ((a)localObject);
          paramString.lBV = new bt();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.lBW = 0;
          paramString.respCmdId = 0;
          this.jTk = paramString.bgN();
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41605);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */