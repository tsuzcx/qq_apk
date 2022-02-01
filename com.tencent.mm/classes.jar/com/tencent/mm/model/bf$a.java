package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.sdk.platformtools.bt;

public final class bf$a
  extends l.d
  implements l.b
{
  public dkb gNC;
  
  public bf$a()
  {
    AppMethodBeat.i(20369);
    this.gNC = new dkb();
    AppMethodBeat.o(20369);
  }
  
  public final int getCmdId()
  {
    return 0;
  }
  
  public final int getFuncId()
  {
    return 617;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(20370);
    setRsaInfo(ac.eBY());
    this.gNC.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    this.gNC.setBaseRequest(l.a(this));
    byte[] arrayOfByte = this.gNC.toByteArray();
    AppMethodBeat.o(20370);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bf.a
 * JD-Core Version:    0.7.0.1
 */