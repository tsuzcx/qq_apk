package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgt;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e
  extends com.tencent.mm.ak.a<bgt>
{
  private final int gmg;
  private final byte[] gmh;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.gmg = paramInt;
    this.gmh = paramArrayOfByte;
    paramArrayOfByte = new bgs();
    bgt localbgt = new bgt();
    paramArrayOfByte.DesignerUin = this.gmg;
    if (this.gmh == null) {}
    for (paramArrayOfByte.ReqBuf = new SKBuiltinBuffer_t();; paramArrayOfByte.ReqBuf = z.al(this.gmh))
    {
      paramArrayOfByte.Scene = 0;
      b.a locala = new b.a();
      locala.c((com.tencent.mm.bw.a)paramArrayOfByte);
      locala.d((com.tencent.mm.bw.a)localbgt);
      locala.DN("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.oS(720);
      c(locala.aDS());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */