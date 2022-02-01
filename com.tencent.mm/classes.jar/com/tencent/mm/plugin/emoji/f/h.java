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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private f gzH;
  public int jed;
  private int pFP;
  public byte[] pFQ;
  private int pFR;
  private String pFS;
  private int pFT;
  private final b rr;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    b.a locala = new b.a();
    locala.hNM = new baa();
    locala.hNN = new bab();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.jed = paramInt1;
    this.pFP = paramInt2;
    this.pFR = paramInt3;
    this.pFS = paramString;
    this.pFQ = paramArrayOfByte;
    this.pFT = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final bab chd()
  {
    if (this.rr == null) {
      return null;
    }
    return (bab)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108688);
    this.gzH = paramf;
    baa localbaa = (baa)this.rr.hNK.hNQ;
    if (this.pFQ != null)
    {
      localbaa.Gxi = z.al(this.pFQ);
      if (localbaa.Gxi != null) {
        break label139;
      }
    }
    label139:
    for (paramf = "Buf is NULL";; paramf = localbaa.Gxi.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramf);
      localbaa.DesignerUin = this.pFP;
      localbaa.OpCode = this.jed;
      localbaa.Geg = this.pFR;
      localbaa.Gxj = this.pFS;
      localbaa.Gxk = this.pFT;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localbaa.Gxi = new SKBuiltinBuffer_t();
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
    ad.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.pFQ == null) || (this.pFQ.length <= 0)) && (this.jed != 3)))
    {
      paramArrayOfByte = ((d)g.ad(d.class)).getEmojiStorageMgr().ILt;
      str = this.pFP;
      localObject = chd();
      if ((!bt.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      ad.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (bab)((b)paramq).hNL.hNQ;
      if (paramq.Gxi != null) {
        this.pFQ = z.a(paramq.Gxi);
      }
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.IOn.value);
        localj.field_content = ((bab)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.IOn.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        ad.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      }
      continue;
      label348:
      ad.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */