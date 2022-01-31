package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.h.a;
import java.io.IOException;

public final class i
  extends m
  implements k
{
  private f eGj;
  private String liH;
  private final b rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(53117);
    b.a locala = new b.a();
    locala.fsX = new ajq();
    locala.fsY = new ajr();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.liH = paramString;
    AppMethodBeat.o(53117);
  }
  
  public final ajr blD()
  {
    if (this.rr == null) {
      return null;
    }
    return (ajr)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53119);
    this.eGj = paramf;
    ((ajq)this.rr.fsV.fta).wQg = this.liH;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53119);
    return i;
  }
  
  public final int getType()
  {
    return 239;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53118);
    ab.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((d)com.tencent.mm.kernel.g.G(d.class)).getEmojiStorageMgr().yNt;
      paramArrayOfByte = this.liH;
      localObject = blD();
      if ((!bo.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      ab.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53118);
      return;
      try
      {
        label113:
        com.tencent.mm.storage.emotion.g localg = new com.tencent.mm.storage.emotion.g();
        localg.field_designerIDAndType = (paramArrayOfByte + h.a.yPY.value);
        localg.field_content = ((ajr)localObject).toByteArray();
        localObject = localg.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(h.a.yPY.value).toString();
        if (paramq.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        ab.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException paramq)
      {
        ab.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bo.l(paramq) });
      }
      continue;
      label257:
      ab.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */