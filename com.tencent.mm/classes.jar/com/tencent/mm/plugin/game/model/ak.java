package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class ak
  extends m
  implements k
{
  public static final String kRe = com.tencent.mm.loader.a.b.bkH + "Game/TabNav/";
  private f dmL;
  final com.tencent.mm.ah.b jvQ;
  
  public ak()
  {
    b.a locala = new b.a();
    locala.ecH = new be();
    locala.ecI = new bf();
    locala.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
    locala.ecG = 2641;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.jvQ = locala.Kt();
  }
  
  public static void a(ak.a parama)
  {
    y.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data");
    com.tencent.mm.kernel.g.Dk().a(2641, new ak.1(parama));
    parama = new ak();
    com.tencent.mm.kernel.g.Dk().a(parama, 0);
  }
  
  private static void a(List<String> paramList, ak.b paramb)
  {
    String str;
    for (;;)
    {
      if (bk.dk(paramList))
      {
        if (paramb != null) {
          paramb.onComplete();
        }
        return;
      }
      str = (String)paramList.remove(0);
      if (!bk.bl(str)) {
        break;
      }
      y.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
    }
    Object localObject = kRe + com.tencent.mm.a.g.o(str.getBytes());
    c.a locala = new c.a();
    locala.erf = true;
    locala.erh = ((String)localObject);
    localObject = locala.OV();
    o.ON().a(str, (c)localObject, new ak.3(str, paramList, paramb));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((bf)((com.tencent.mm.ah.b)paramq).ecF.ecN == null)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2641;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak
 * JD-Core Version:    0.7.0.1
 */