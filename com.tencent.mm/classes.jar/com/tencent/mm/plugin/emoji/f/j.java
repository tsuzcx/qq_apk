package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.h.a;
import java.io.IOException;

public final class j
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  private String iZQ;
  
  public j(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new aet();
    locala.ecI = new aeu();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.ecG = 239;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZQ = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dIJ = paramf;
    ((aet)this.dmK.ecE.ecN).sRs = this.iZQ;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)com.tencent.mm.kernel.g.t(d.class)).getEmojiStorageMgr().uBh;
      paramArrayOfByte = this.iZQ;
      localObject = aIe();
      if ((!bk.bl(paramArrayOfByte)) && (localObject != null)) {
        break label103;
      }
      y.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      try
      {
        label103:
        com.tencent.mm.storage.emotion.g localg = new com.tencent.mm.storage.emotion.g();
        localg.field_designerIDAndType = (paramArrayOfByte + h.a.uDr.value);
        localg.field_content = ((aeu)localObject).toByteArray();
        localObject = localg.vf();
        new StringBuilder().append(paramArrayOfByte).append(h.a.uDr.value).toString();
        if (paramq.dXw.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label247;
        }
        y.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        y.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bk.j(paramq) });
      }
      continue;
      label247:
      y.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
  
  public final aeu aIe()
  {
    if (this.dmK == null) {
      return null;
    }
    return (aeu)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 239;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.j
 * JD-Core Version:    0.7.0.1
 */