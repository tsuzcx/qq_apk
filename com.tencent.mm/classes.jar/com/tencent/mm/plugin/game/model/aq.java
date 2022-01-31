package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class aq
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL;
  public final b jvQ;
  
  public aq(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    y.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      y.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bi();
    ((bi)localObject).kUa = paramString;
    ((bi)localObject).kUD = paramLinkedList;
    paramLinkedList = f.dw(ae.getContext());
    paramString = paramLinkedList;
    if (bk.bl(paramLinkedList)) {
      paramString = bk.fS(ae.getContext());
    }
    if (!bk.bl(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bi)localObject).ffq = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bi)localObject).kUE = new com.tencent.mm.plugin.game.d.s();
        if (paramo1 != null)
        {
          ((bi)localObject).kUE.kSU = paramo1.kPf.kPU;
          ((bi)localObject).kUE.euK = paramo1.field_appId;
          ((bi)localObject).kUE.kRU = paramo1.kPN;
          if (paramo1.field_msgType == 100) {
            ((bi)localObject).kUE.kSW = paramo1.kPM;
          }
        }
        else
        {
          label223:
          if (paramo2 != null)
          {
            paramLinkedList = ((bi)localObject).kUE;
            paramLinkedList.kSV |= 0x1;
          }
          if (paramo3 != null)
          {
            paramLinkedList = ((bi)localObject).kUE;
            paramLinkedList.kSV |= 0x2;
          }
          ((bi)localObject).kUF = ((c)g.r(c.class)).aYf().aZv();
          ((bi)localObject).kUG = paramBoolean;
          if (!com.tencent.mm.sdk.platformtools.e.cqq()) {
            break label456;
          }
        }
        label456:
        for (int i = 1;; i = 0)
        {
          ((bi)localObject).kUb = i;
          y.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!bk.bl(((bi)localObject).ffq)) && ("CN".equalsIgnoreCase(((bi)localObject).ffq))) {
            h.nFQ.a(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.ecH = ((a)localObject);
          paramString.ecI = new bj();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.ecG = 2855;
          paramString.ecJ = 0;
          paramString.ecK = 0;
          this.jvQ = paramString.Kt();
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label462;
          }
          paramo1 = paramo3;
          break;
          ((bi)localObject).kUE.kSW = paramo1.field_msgType;
          break label223;
        }
        label462:
        paramo1 = null;
      }
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2855;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aq
 * JD-Core Version:    0.7.0.1
 */