package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ab;

final class aa$1
  implements Runnable
{
  aa$1(gk paramgk) {}
  
  public final void run()
  {
    AppMethodBeat.i(154508);
    ab.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
    g.Rc().a(new af(this.flE), 0);
    AppMethodBeat.o(154508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.aa.1
 * JD-Core Version:    0.7.0.1
 */