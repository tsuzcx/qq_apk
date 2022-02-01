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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private f gCo;
  public int jgW;
  private int pMt;
  public byte[] pMu;
  private int pMv;
  private String pMw;
  private int pMx;
  private final b rr;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    b.a locala = new b.a();
    locala.hQF = new baq();
    locala.hQG = new bar();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.jgW = paramInt1;
    this.pMt = paramInt2;
    this.pMv = paramInt3;
    this.pMw = paramString;
    this.pMu = paramArrayOfByte;
    this.pMx = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final bar cit()
  {
    if (this.rr == null) {
      return null;
    }
    return (bar)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108688);
    this.gCo = paramf;
    baq localbaq = (baq)this.rr.hQD.hQJ;
    if (this.pMu != null)
    {
      localbaq.GQI = z.al(this.pMu);
      if (localbaq.GQI != null) {
        break label139;
      }
    }
    label139:
    for (paramf = "Buf is NULL";; paramf = localbaq.GQI.toString())
    {
      ae.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramf);
      localbaq.DesignerUin = this.pMt;
      localbaq.OpCode = this.jgW;
      localbaq.GwN = this.pMv;
      localbaq.GQJ = this.pMw;
      localbaq.GQK = this.pMx;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localbaq.GQI = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 821;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108687);
    ae.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.pMu == null) || (this.pMu.length <= 0)) && (this.jgW != 3)))
    {
      paramArrayOfByte = ((d)g.ad(d.class)).getEmojiStorageMgr().Jga;
      str = this.pMt;
      localObject = cit();
      if ((!bu.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      ae.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (bar)((b)paramq).hQE.hQJ;
      if (paramq.GQI != null) {
        this.pMu = z.a(paramq.GQI);
      }
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.JiT.value);
        localj.field_content = ((bar)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.JiT.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        ae.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        ae.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      }
      continue;
      label348:
      ae.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */