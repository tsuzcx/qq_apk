package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class b
{
  a syh;
  public SimpleHttpLogic.Request syi;
  public SimpleHttpLogic.TaskCallback syj;
  public a syk;
  
  public b()
  {
    AppMethodBeat.i(187223);
    this.syh = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
      {
        AppMethodBeat.i(187221);
        ad.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(187221);
      }
    };
    this.syj = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(187222);
        ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            ad.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new bxj();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.DTR;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.c.b((bxm)localObject);
              b.this.syk.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(187222);
              return;
            }
            ad.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.DTT) });
            b.this.syk.a(-5, null);
            AppMethodBeat.o(187222);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.syk.a(-2, null);
            AppMethodBeat.o(187222);
            return;
          }
        }
        b.this.syk.a(-1, null);
        AppMethodBeat.o(187222);
      }
    };
    this.syk = this.syh;
    Object localObject = a.ahU();
    ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(localObject)));
    bxi localbxi = new bxi();
    localbxi.DTN = ((String)localObject);
    localbxi.upD = a.ahV();
    localbxi.DTO = d.cGb();
    localbxi.DTQ = 1;
    try
    {
      this.syi = new SimpleHttpLogic.Request();
      this.syi.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.syi.host = "short.weixin.qq.com";
      localObject = new PByteArray();
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localbxi.toByteArray(), (PByteArray)localObject))));
      this.syi.body = ((PByteArray)localObject).value;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baseId  :").append(localbxi.DTN).append("\n");
      ((StringBuilder)localObject).append("patchId :").append(localbxi.upD).append("\n");
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { ((StringBuilder)localObject).toString() });
      AppMethodBeat.o(187223);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.syi = null;
        ad.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", localIOException, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.hp.c.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.b
 * JD-Core Version:    0.7.0.1
 */