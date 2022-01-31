package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL;
  public final b jvQ;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    y.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      y.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).ecH = new bc();
    ((b.a)localObject).ecI = new bd();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).ecG = 2994;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (bc)this.jvQ.ecE.ecN;
    ((bc)localObject).kUa = paramString;
    ((bc)localObject).kUD = paramLinkedList;
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
      ((bc)localObject).ffq = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bc)localObject).kUE = new com.tencent.mm.plugin.game.d.s();
        if (paramo1 != null)
        {
          ((bc)localObject).kUE.kSU = paramo1.kPf.kPU;
          ((bc)localObject).kUE.euK = paramo1.field_appId;
          ((bc)localObject).kUE.kRU = paramo1.kPN;
          if (paramo1.field_msgType == 100) {
            ((bc)localObject).kUE.kSW = paramo1.kPM;
          }
        }
        else
        {
          label298:
          if (paramo2 != null)
          {
            paramLinkedList = ((bc)localObject).kUE;
            paramLinkedList.kSV |= 0x1;
          }
          if (paramo3 != null)
          {
            paramLinkedList = ((bc)localObject).kUE;
            paramLinkedList.kSV |= 0x2;
          }
          ((bc)localObject).kUF = ((c)g.r(c.class)).aYf().aZv();
          ((bc)localObject).kUG = paramBoolean;
          if (!com.tencent.mm.sdk.platformtools.e.cqq()) {
            break label475;
          }
        }
        label475:
        for (int i = 1;; i = 0)
        {
          ((bc)localObject).kUb = i;
          y.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bk.bl(((bc)localObject).ffq)) && (!"CN".equalsIgnoreCase(((bc)localObject).ffq))) {
            h.nFQ.a(860L, 7L, 1L, false);
          }
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label481;
          }
          paramo1 = paramo3;
          break;
          ((bc)localObject).kUE.kSW = paramo1.field_msgType;
          break label298;
        }
        label481:
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
    y.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2994;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */