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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.j.a;
import java.io.IOException;

public final class h
  extends n
  implements k
{
  private com.tencent.mm.al.g gbr;
  public int ikN;
  private int oyF;
  public byte[] oyG;
  private int oyH;
  private String oyI;
  private int oyJ;
  private final b rr;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    b.a locala = new b.a();
    locala.gUU = new asy();
    locala.gUV = new asz();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.ikN = paramInt1;
    this.oyF = paramInt2;
    this.oyH = paramInt3;
    this.oyI = paramString;
    this.oyG = paramArrayOfByte;
    this.oyJ = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final asz bVm()
  {
    if (this.rr == null) {
      return null;
    }
    return (asz)this.rr.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108688);
    this.gbr = paramg;
    asy localasy = (asy)this.rr.gUS.gUX;
    if (this.oyG != null)
    {
      localasy.Dta = z.am(this.oyG);
      if (localasy.Dta != null) {
        break label139;
      }
    }
    label139:
    for (paramg = "Buf is NULL";; paramg = localasy.Dta.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramg);
      localasy.DesignerUin = this.oyF;
      localasy.OpCode = this.ikN;
      localasy.Ddx = this.oyH;
      localasy.Dtb = this.oyI;
      localasy.Dtc = this.oyJ;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localasy.Dta = new SKBuiltinBuffer_t();
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
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.oyG == null) || (this.oyG.length <= 0)) && (this.ikN != 3)))
    {
      paramArrayOfByte = ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiStorageMgr().Fze;
      str = this.oyF;
      localObject = bVm();
      if ((!bt.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      ad.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (asz)((b)paramq).gUT.gUX;
      if (paramq.Dta != null) {
        this.oyG = z.a(paramq.Dta);
      }
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        i locali = new i();
        locali.field_designerIDAndType = (str + j.a.FBU.value);
        locali.field_content = ((asz)localObject).toByteArray();
        localObject = locali.convertTo();
        new StringBuilder().append(str).append(j.a.FBU.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        ad.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      }
      continue;
      label348:
      ad.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */