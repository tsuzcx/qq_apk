package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import java.io.IOException;

public final class b
{
  a uUs;
  SimpleHttpLogic.Request uUt;
  SimpleHttpLogic.TaskCallback uUu;
  a uUv;
  
  public b(cho paramcho)
  {
    AppMethodBeat.i(196769);
    this.uUs = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(196767);
        ae.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(196767);
      }
    };
    this.uUu = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(196768);
        ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            ae.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new chp();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.HtO;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((chs)localObject);
              b.this.uUv.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(196768);
              return;
            }
            ae.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.HtQ) });
            b.this.uUv.a(-5, null);
            AppMethodBeat.o(196768);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.uUv.a(-2, null);
            AppMethodBeat.o(196768);
            return;
          }
        }
        b.this.uUv.a(-1, null);
        AppMethodBeat.o(196768);
      }
    };
    this.uUv = this.uUs;
    cho localcho = paramcho;
    if (paramcho == null)
    {
      paramcho = a.arW();
      ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(paramcho)));
      localcho = new cho();
      localcho.HtK = paramcho;
      localcho.wTE = a.arX();
      localcho.HtL = e.dfk();
      localcho.HtN = 1;
    }
    try
    {
      this.uUt = new SimpleHttpLogic.Request();
      this.uUt.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.uUt.host = "short.weixin.qq.com";
      paramcho = new PByteArray();
      ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcho.toByteArray(), paramcho))));
      this.uUt.body = paramcho.value;
      paramcho = new StringBuilder();
      if (localcho != null)
      {
        paramcho.append("baseId  :").append(localcho.HtK).append("\n");
        paramcho.append("patchId :").append(localcho.wTE).append("\n");
      }
      ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { paramcho.toString() });
      AppMethodBeat.o(196769);
      return;
    }
    catch (IOException paramcho)
    {
      for (;;)
      {
        this.uUt = null;
        ae.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramcho, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196770);
    this.uUv = parama;
    if (this.uUt == null)
    {
      ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      this.uUv.a(-3, null);
      AppMethodBeat.o(196770);
      return;
    }
    ae.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    parama = "";
    if (j.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.uUt, this.uUu, parama);
    AppMethodBeat.o(196770);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.hp.d.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.b
 * JD-Core Version:    0.7.0.1
 */