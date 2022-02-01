package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import java.io.IOException;

public final class b
{
  a uIF;
  SimpleHttpLogic.Request uIG;
  SimpleHttpLogic.TaskCallback uIH;
  a uII;
  
  public b(cgu paramcgu)
  {
    AppMethodBeat.i(218902);
    this.uIF = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(218900);
        ad.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(218900);
      }
    };
    this.uIH = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218901);
        ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            ad.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new cgv();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.Hao;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((cgy)localObject);
              b.this.uII.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(218901);
              return;
            }
            ad.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.Haq) });
            b.this.uII.a(-5, null);
            AppMethodBeat.o(218901);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.uII.a(-2, null);
            AppMethodBeat.o(218901);
            return;
          }
        }
        b.this.uII.a(-1, null);
        AppMethodBeat.o(218901);
      }
    };
    this.uII = this.uIF;
    cgu localcgu = paramcgu;
    if (paramcgu == null)
    {
      paramcgu = a.arH();
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(paramcgu)));
      localcgu = new cgu();
      localcgu.Hak = paramcgu;
      localcgu.wDT = a.arI();
      localcgu.Hal = e.dcs();
      localcgu.Han = 1;
    }
    try
    {
      this.uIG = new SimpleHttpLogic.Request();
      this.uIG.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.uIG.host = "short.weixin.qq.com";
      paramcgu = new PByteArray();
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcgu.toByteArray(), paramcgu))));
      this.uIG.body = paramcgu.value;
      paramcgu = new StringBuilder();
      if (localcgu != null)
      {
        paramcgu.append("baseId  :").append(localcgu.Hak).append("\n");
        paramcgu.append("patchId :").append(localcgu.wDT).append("\n");
      }
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { paramcgu.toString() });
      AppMethodBeat.o(218902);
      return;
    }
    catch (IOException paramcgu)
    {
      for (;;)
      {
        this.uIG = null;
        ad.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramcgu, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(218903);
    this.uII = parama;
    if (this.uIG == null)
    {
      ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      this.uII.a(-3, null);
      AppMethodBeat.o(218903);
      return;
    }
    ad.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    parama = "";
    if (i.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.uIG, this.uIH, parama);
    AppMethodBeat.o(218903);
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