package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public final b grW;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bk();
    ((bk)localObject).uhu = paramString;
    ((bk)localObject).uie = paramLinkedList;
    paramLinkedList = e.fv(aj.getContext());
    paramString = paramLinkedList;
    if (bt.isNullOrNil(paramLinkedList)) {
      paramString = bt.jg(aj.getContext());
    }
    if (!bt.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bk)localObject).jdl = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bk)localObject).uif = new w();
        if (paramo1 != null)
        {
          ((bk)localObject).uif.ugk = paramo1.ubM.ucM;
          ((bk)localObject).uif.iht = paramo1.field_appId;
          ((bk)localObject).uif.ufd = paramo1.ucA;
          ((bk)localObject).uif.ugm = paramo1.ucz;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bk)localObject).uif;
          paramLinkedList.ugl |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bk)localObject).uif;
          paramLinkedList.ugl |= 0x2;
        }
        ((bk)localObject).uig = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZi();
        ((bk)localObject).uih = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.j.fjZ()) {}
        for (int i = 1;; i = 0)
        {
          ((bk)localObject).uhv = i;
          ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new b.a();
          paramString.hNM = ((a)localObject);
          paramString.hNN = new bl();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.hNO = 0;
          paramString.respCmdId = 0;
          this.grW = paramString.aDC();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(41605);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41605);
    return i;
  }
  
  public final int getType()
  {
    return 2586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41606);
    ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */