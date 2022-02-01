package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class i
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g gfX;
  private String pck;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(108689);
    b.a locala = new b.a();
    locala.hvt = new awe();
    locala.hvu = new awf();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pck = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final awf ccA()
  {
    if (this.rr == null) {
      return null;
    }
    return (awf)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(108691);
    this.gfX = paramg;
    ((awe)this.rr.hvr.hvw).Ewv = this.pck;
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
    ac.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiStorageMgr().GYf;
      paramArrayOfByte = this.pck;
      localObject = ccA();
      if ((!bs.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      ac.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        j localj = new j();
        localj.field_designerIDAndType = (paramArrayOfByte + k.a.HaV.value);
        localj.field_content = ((awf)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(k.a.HaV.value).toString();
        if (paramq.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        ac.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        ac.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bs.m(paramq) });
      }
      continue;
      label257:
      ac.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */