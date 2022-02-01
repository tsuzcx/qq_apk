package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class i
  extends n
  implements com.tencent.mm.network.k
{
  private f gzH;
  private String pFU;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(108689);
    b.a locala = new b.a();
    locala.hNM = new bac();
    locala.hNN = new bad();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFU = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final bad che()
  {
    if (this.rr == null) {
      return null;
    }
    return (bad)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108691);
    this.gzH = paramf;
    ((bac)this.rr.hNK.hNQ).GdY = this.pFU;
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
      paramq = ((d)g.ad(d.class)).getEmojiStorageMgr().ILt;
      paramArrayOfByte = this.pFU;
      localObject = che();
      if ((!bt.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      ad.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        j localj = new j();
        localj.field_designerIDAndType = (paramArrayOfByte + k.a.IOl.value);
        localj.field_content = ((bad)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(k.a.IOl.value).toString();
        if (paramq.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        ad.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        ad.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bt.n(paramq) });
      }
      continue;
      label257:
      ad.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */