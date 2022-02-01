package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e
  extends c<bsp>
{
  private final int gWW;
  private final byte[] gWX;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.gWW = paramInt;
    this.gWX = paramArrayOfByte;
    paramArrayOfByte = new bso();
    bsp localbsp = new bsp();
    paramArrayOfByte.DesignerUin = this.gWW;
    if (this.gWX == null) {}
    for (paramArrayOfByte.ReqBuf = new SKBuiltinBuffer_t();; paramArrayOfByte.ReqBuf = z.aC(this.gWX))
    {
      paramArrayOfByte.Scene = 0;
      d.a locala = new d.a();
      locala.c((a)paramArrayOfByte);
      locala.d((a)localbsp);
      locala.MB("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.sG(720);
      c(locala.aXF());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e
 * JD-Core Version:    0.7.0.1
 */