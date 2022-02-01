package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.gol;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<cps>
{
  private final int mhB;
  private final byte[] mhC;
  
  public e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183955);
    this.mhB = paramInt;
    this.mhC = paramArrayOfByte;
    paramArrayOfByte = new cpr();
    cps localcps = new cps();
    paramArrayOfByte.ZtX = this.mhB;
    if (this.mhC == null) {}
    for (paramArrayOfByte.YGU = new gol();; paramArrayOfByte.YGU = w.aN(this.mhC))
    {
      paramArrayOfByte.IJG = 0;
      c.a locala = new c.a();
      locala.otE = ((a)paramArrayOfByte);
      locala.otF = ((a)localcps);
      locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
      locala.funcId = 720;
      c(locala.bEF());
      AppMethodBeat.o(183955);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.e
 * JD-Core Version:    0.7.0.1
 */