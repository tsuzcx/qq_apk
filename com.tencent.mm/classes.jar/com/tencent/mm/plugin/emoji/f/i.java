package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.j.a;
import java.io.IOException;

public final class i
  extends n
  implements k
{
  private com.tencent.mm.al.g gbr;
  private String oyK;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(108689);
    b.a locala = new b.a();
    locala.gUU = new ata();
    locala.gUV = new atb();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyK = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final atb bVn()
  {
    if (this.rr == null) {
      return null;
    }
    return (atb)this.rr.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108691);
    this.gbr = paramg;
    ((ata)this.rr.gUS.gUX).Ddp = this.oyK;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108691);
    return i;
  }
  
  public final int getType()
  {
    return 239;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108690);
    ad.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiStorageMgr().Fze;
      paramArrayOfByte = this.oyK;
      localObject = bVn();
      if ((!bt.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      ad.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        com.tencent.mm.storage.emotion.i locali = new com.tencent.mm.storage.emotion.i();
        locali.field_designerIDAndType = (paramArrayOfByte + j.a.FBS.value);
        locali.field_content = ((atb)localObject).toByteArray();
        localObject = locali.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(j.a.FBS.value).toString();
        if (paramq.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        ad.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        ad.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bt.m(paramq) });
      }
      continue;
      label257:
      ad.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */