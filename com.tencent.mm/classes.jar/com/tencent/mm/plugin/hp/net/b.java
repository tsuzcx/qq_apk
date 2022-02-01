package com.tencent.mm.plugin.hp.net;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  a ymT;
  SimpleHttpLogic.Request ymU;
  SimpleHttpLogic.TaskCallback ymV;
  a ymW;
  
  public b(cxv paramcxv)
  {
    AppMethodBeat.i(196777);
    this.ymT = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(196775);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(196775);
      }
    };
    this.ymV = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(196776);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new cxw();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.MCM;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((cxz)localObject);
              b.this.ymW.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(196776);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.MCO) });
            b.this.ymW.a(-5, null);
            AppMethodBeat.o(196776);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.ymW.a(-2, null);
            AppMethodBeat.o(196776);
            return;
          }
        }
        b.this.ymW.a(-1, null);
        AppMethodBeat.o(196776);
      }
    };
    this.ymW = this.ymT;
    cxv localcxv = paramcxv;
    if (paramcxv == null)
    {
      paramcxv = a.aKw();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(paramcxv)));
      localcxv = new cxv();
      localcxv.MCI = paramcxv;
      localcxv.APx = a.aKx();
      localcxv.MCJ = e.dZe();
      localcxv.MCL = 1;
    }
    try
    {
      this.ymU = new SimpleHttpLogic.Request();
      this.ymU.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.ymU.host = MMApplicationContext.getResources().getString(2131761739);
      paramcxv = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcxv.toByteArray(), paramcxv))));
      this.ymU.body = paramcxv.value;
      paramcxv = new StringBuilder();
      if (localcxv != null)
      {
        paramcxv.append("baseId  :").append(localcxv.MCI).append("\n");
        paramcxv.append("patchId :").append(localcxv.APx).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { paramcxv.toString() });
      AppMethodBeat.o(196777);
      return;
    }
    catch (IOException paramcxv)
    {
      for (;;)
      {
        this.ymU = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramcxv, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196778);
    this.ymW = parama;
    if (this.ymU == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      this.ymW.a(-3, null);
      AppMethodBeat.o(196778);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.ymU, this.ymV, parama);
    AppMethodBeat.o(196778);
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