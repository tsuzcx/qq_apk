package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bbz;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e
  extends c<bbz>
{
  private final int fQn;
  private final byte[] fQo;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.fQn = paramInt;
    this.fQo = paramArrayOfByte;
    paramArrayOfByte = new bby();
    bbz localbbz = new bbz();
    paramArrayOfByte.DesignerUin = this.fQn;
    if (this.fQo == null) {}
    for (paramArrayOfByte.ReqBuf = new SKBuiltinBuffer_t();; paramArrayOfByte.ReqBuf = z.al(this.fQo))
    {
      paramArrayOfByte.Scene = 0;
      b.a locala = new b.a();
      locala.c((a)paramArrayOfByte);
      locala.d((a)localbbz);
      locala.Am("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.op(720);
      c(locala.aAz());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */