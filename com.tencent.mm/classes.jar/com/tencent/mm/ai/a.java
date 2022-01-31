package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.e;
import junit.framework.Assert;

public class a<_Resp extends bvk>
{
  a.b<_Resp> fsK;
  private com.tencent.mm.cm.f<a.a<_Resp>> fsL;
  public b rr;
  
  public a()
  {
    AppMethodBeat.i(58154);
    this.fsK = new a.b(this);
    AppMethodBeat.o(58154);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, m paramm) {}
  
  public final void a(b paramb)
  {
    this.rr = paramb;
  }
  
  public com.tencent.mm.cm.f<a.a<_Resp>> adl()
  {
    try
    {
      AppMethodBeat.i(58155);
      Assert.assertNotNull("You should set a CommReqResp!", this.rr);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", w.adW());
      if (this.fsL == null) {
        this.fsL = g.c(new a.1(this));
      }
      com.tencent.mm.cm.f localf = this.fsL;
      AppMethodBeat.o(58155);
      return localf;
    }
    finally {}
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(58153);
    if (this.fsK != null) {
      w.a(this.fsK);
    }
    if (this.fsL != null) {
      this.fsL.a(true);
    }
    AppMethodBeat.o(58153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.a
 * JD-Core Version:    0.7.0.1
 */