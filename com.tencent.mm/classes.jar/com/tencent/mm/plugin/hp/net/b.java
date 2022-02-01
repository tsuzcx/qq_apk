package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class b
{
  a tFW;
  public SimpleHttpLogic.Request tFX;
  public SimpleHttpLogic.TaskCallback tFY;
  public a tFZ;
  
  public b()
  {
    AppMethodBeat.i(189690);
    this.tFW = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.c.b paramAnonymousb)
      {
        AppMethodBeat.i(189688);
        ac.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(189688);
      }
    };
    this.tFY = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(189689);
        ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            ac.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new cce();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.FqE;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.c.b((cch)localObject);
              b.this.tFZ.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(189689);
              return;
            }
            ac.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.FqG) });
            b.this.tFZ.a(-5, null);
            AppMethodBeat.o(189689);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.tFZ.a(-2, null);
            AppMethodBeat.o(189689);
            return;
          }
        }
        b.this.tFZ.a(-1, null);
        AppMethodBeat.o(189689);
      }
    };
    this.tFZ = this.tFW;
    Object localObject = a.aoU();
    ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(localObject)));
    ccd localccd = new ccd();
    localccd.FqA = ((String)localObject);
    localccd.vyz = a.aoV();
    localccd.FqB = e.cTl();
    localccd.FqD = 1;
    try
    {
      this.tFX = new SimpleHttpLogic.Request();
      this.tFX.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.tFX.host = "short.weixin.qq.com";
      localObject = new PByteArray();
      ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localccd.toByteArray(), (PByteArray)localObject))));
      this.tFX.body = ((PByteArray)localObject).value;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baseId  :").append(localccd.FqA).append("\n");
      ((StringBuilder)localObject).append("patchId :").append(localccd.vyz).append("\n");
      ac.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { ((StringBuilder)localObject).toString() });
      AppMethodBeat.o(189690);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.tFX = null;
        ac.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", localIOException, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.hp.c.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.b
 * JD-Core Version:    0.7.0.1
 */