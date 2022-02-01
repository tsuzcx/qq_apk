package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e
  extends com.tencent.mm.al.a<bgd>
{
  private final int gjN;
  private final byte[] gjO;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.gjN = paramInt;
    this.gjO = paramArrayOfByte;
    paramArrayOfByte = new bgc();
    bgd localbgd = new bgd();
    paramArrayOfByte.DesignerUin = this.gjN;
    if (this.gjO == null) {}
    for (paramArrayOfByte.ReqBuf = new SKBuiltinBuffer_t();; paramArrayOfByte.ReqBuf = z.al(this.gjO))
    {
      paramArrayOfByte.Scene = 0;
      b.a locala = new b.a();
      locala.c((com.tencent.mm.bx.a)paramArrayOfByte);
      locala.d((com.tencent.mm.bx.a)localbgd);
      locala.Dl("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.oP(720);
      c(locala.aDC());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */