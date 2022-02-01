package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class d
  extends c<ayh>
{
  private final int fMB;
  private final byte[] fMC;
  
  public d(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.fMB = paramInt;
    this.fMC = paramArrayOfByte;
    paramArrayOfByte = new ayg();
    ayh localayh = new ayh();
    paramArrayOfByte.DesignerUin = this.fMB;
    if (this.fMC == null) {}
    for (paramArrayOfByte.ReqBuf = new SKBuiltinBuffer_t();; paramArrayOfByte.ReqBuf = z.am(this.fMC))
    {
      paramArrayOfByte.Scene = 0;
      b.a locala = new b.a();
      locala.c((a)paramArrayOfByte);
      locala.d((a)localayh);
      locala.wg("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.nB(720);
      c(locala.atI());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */