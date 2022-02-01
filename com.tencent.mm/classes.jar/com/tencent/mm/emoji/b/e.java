package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.eae;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e
  extends c<caj>
{
  private final int jHU;
  private final byte[] jHV;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.jHU = paramInt;
    this.jHV = paramArrayOfByte;
    paramArrayOfByte = new cai();
    caj localcaj = new caj();
    paramArrayOfByte.TdG = this.jHU;
    if (this.jHV == null) {}
    for (paramArrayOfByte.RJA = new eae();; paramArrayOfByte.RJA = z.aN(this.jHV))
    {
      paramArrayOfByte.CPw = 0;
      d.a locala = new d.a();
      locala.c((a)paramArrayOfByte);
      locala.d((a)localcaj);
      locala.TW("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
      locala.vD(720);
      c(locala.bgN());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e
 * JD-Core Version:    0.7.0.1
 */