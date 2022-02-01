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
import com.tencent.mm.plugin.game.protobuf.br;
import com.tencent.mm.plugin.game.protobuf.bs;
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
  public final d hhm;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new br();
    ((br)localObject).xLl = paramString;
    ((br)localObject).xLF = paramLinkedList;
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
      ((br)localObject).keh = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((br)localObject).xLG = new ac();
        if (paramo1 != null)
        {
          ((br)localObject).xLG.xJZ = paramo1.xFg.xGi;
          ((br)localObject).xLG.jfi = paramo1.field_appId;
          ((br)localObject).xLG.xIG = paramo1.xFW;
          ((br)localObject).xLG.xKb = paramo1.xFV;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((br)localObject).xLG;
          paramLinkedList.xKa |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((br)localObject).xLG;
          paramLinkedList.xKa |= 0x2;
        }
        ((br)localObject).xLH = ((f)com.tencent.mm.kernel.g.af(f.class)).dSK().dVz();
        ((br)localObject).xLI = paramBoolean;
        if (ChannelUtil.isGPVersion()) {}
        for (int i = 1;; i = 0)
        {
          ((br)localObject).xLm = i;
          Log.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new d.a();
          paramString.iLN = ((a)localObject);
          paramString.iLO = new bs();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.iLP = 0;
          paramString.respCmdId = 0;
          this.hhm = paramString.aXF();
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(41605);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */