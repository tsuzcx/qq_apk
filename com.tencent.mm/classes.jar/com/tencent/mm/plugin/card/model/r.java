package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private int inr = 0;
  
  public r(LinkedList<String> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new ge();
    locala.ecI = new gf();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
    locala.ecG = 560;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((ge)this.dmK.ecE.ecN).sAo = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((gf)this.dmK.ecF.ecN).sAp;
      if (paramq != null) {
        break label111;
      }
      paramInt1 = 0;
      y.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, resp list count = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramq != null) && (paramq.size() != 0)) {
        break label120;
      }
      y.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label111:
      paramInt1 = paramq.size();
      break;
      label120:
      this.inr = 0;
      paramq = paramq.iterator();
      label240:
      while (paramq.hasNext())
      {
        paramArrayOfByte = (String)paramq.next();
        boolean bool;
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          y.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
          bool = false;
        }
        for (;;)
        {
          if (bool) {
            break label240;
          }
          this.inr += 1;
          break;
          CardInfo localCardInfo = new CardInfo();
          localCardInfo.field_card_id = paramArrayOfByte;
          bool = am.aAs().a(localCardInfo, new String[0]);
          y.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
      y.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[] { Integer.valueOf(this.inr) });
    }
  }
  
  public final int getType()
  {
    return 560;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.r
 * JD-Core Version:    0.7.0.1
 */