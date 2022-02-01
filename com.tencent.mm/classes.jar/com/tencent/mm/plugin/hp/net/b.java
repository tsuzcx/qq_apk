package com.tencent.mm.plugin.hp.net;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  a JEj;
  SimpleHttpLogic.Request JEk;
  SimpleHttpLogic.TaskCallback JEl;
  a JEm;
  
  public b(dzp paramdzp)
  {
    AppMethodBeat.i(261833);
    this.JEj = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.b.b paramAnonymousb)
      {
        AppMethodBeat.i(261827);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(261827);
      }
    };
    this.JEl = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(261836);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new dzq();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.abeO;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.b.b((dzt)localObject);
              b.this.JEm.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(261836);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.abeQ) });
            b.this.JEm.a(-5, null);
            AppMethodBeat.o(261836);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.JEm.a(-2, null);
            AppMethodBeat.o(261836);
            return;
          }
        }
        b.this.JEm.a(-1, null);
        AppMethodBeat.o(261836);
      }
    };
    this.JEm = this.JEj;
    dzp localdzp = paramdzp;
    if (paramdzp == null)
    {
      paramdzp = a.bmm();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(paramdzp)));
      localdzp = new dzp();
      localdzp.abeK = paramdzp;
      localdzp.ycW = a.bmn();
      localdzp.abeL = e.fPU();
      localdzp.abeN = 1;
    }
    try
    {
      this.JEk = new SimpleHttpLogic.Request();
      this.JEk.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.JEk.host = MMApplicationContext.getResources().getString(com.tencent.mm.plugin.boots.b.a.host_short_weixin_qq_com);
      paramdzp = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localdzp.toByteArray(), paramdzp))));
      this.JEk.body = paramdzp.value;
      paramdzp = new StringBuilder();
      if (localdzp != null)
      {
        paramdzp.append("baseId  :").append(localdzp.abeK).append("\n");
        paramdzp.append("patchId :").append(localdzp.ycW).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { paramdzp.toString() });
      AppMethodBeat.o(261833);
      return;
    }
    catch (IOException paramdzp)
    {
      for (;;)
      {
        this.JEk = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramdzp, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(261839);
    this.JEm = parama;
    if (this.JEk == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      this.JEm.a(-3, null);
      AppMethodBeat.o(261839);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.JEk, this.JEl, parama);
    AppMethodBeat.o(261839);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.hp.b.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.b
 * JD-Core Version:    0.7.0.1
 */