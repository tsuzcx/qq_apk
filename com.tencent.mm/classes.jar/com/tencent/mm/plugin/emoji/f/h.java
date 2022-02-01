package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g gfX;
  public int iKU;
  private int pcf;
  public byte[] pcg;
  private int pch;
  private String pci;
  private int pcj;
  private final b rr;
  
  public h(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    b.a locala = new b.a();
    locala.hvt = new awc();
    locala.hvu = new awd();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.iKU = paramInt1;
    this.pcf = paramInt2;
    this.pch = paramInt3;
    this.pci = paramString;
    this.pcg = paramArrayOfByte;
    this.pcj = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final awd ccz()
  {
    if (this.rr == null) {
      return null;
    }
    return (awd)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(108688);
    this.gfX = paramg;
    awc localawc = (awc)this.rr.hvr.hvw;
    if (this.pcg != null)
    {
      localawc.EOe = z.al(this.pcg);
      if (localawc.EOe != null) {
        break label139;
      }
    }
    label139:
    for (paramg = "Buf is NULL";; paramg = localawc.EOe.toString())
    {
      ac.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramg);
      localawc.DesignerUin = this.pcf;
      localawc.OpCode = this.iKU;
      localawc.EwD = this.pch;
      localawc.EOf = this.pci;
      localawc.EOg = this.pcj;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localawc.EOe = new SKBuiltinBuffer_t();
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
    ac.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.pcg == null) || (this.pcg.length <= 0)) && (this.iKU != 3)))
    {
      paramArrayOfByte = ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiStorageMgr().GYf;
      str = this.pcf;
      localObject = ccz();
      if ((!bs.isNullOrNil(str)) && (localObject != null)) {
        break label200;
      }
      ac.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (awd)((b)paramq).hvs.hvw;
      if (paramq.EOe != null) {
        this.pcg = z.a(paramq.EOe);
      }
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label200:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.HaX.value);
        localj.field_content = ((awd)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.HaX.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label348;
        }
        ac.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        ac.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      }
      continue;
      label348:
      ac.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */