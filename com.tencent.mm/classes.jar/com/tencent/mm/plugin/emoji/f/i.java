package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class i
  extends n
  implements com.tencent.mm.network.k
{
  private f gCo;
  private String pMy;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(108689);
    b.a locala = new b.a();
    locala.hQF = new bas();
    locala.hQG = new bat();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pMy = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final bat ciu()
  {
    if (this.rr == null) {
      return null;
    }
    return (bat)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108691);
    this.gCo = paramf;
    ((bas)this.rr.hQD.hQJ).GwF = this.pMy;
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
    ae.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)g.ad(d.class)).getEmojiStorageMgr().Jga;
      paramArrayOfByte = this.pMy;
      localObject = ciu();
      if ((!bu.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      ae.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        j localj = new j();
        localj.field_designerIDAndType = (paramArrayOfByte + k.a.JiR.value);
        localj.field_content = ((bat)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(k.a.JiR.value).toString();
        if (paramq.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        ae.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        ae.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bu.o(paramq) });
      }
      continue;
      label257:
      ae.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */