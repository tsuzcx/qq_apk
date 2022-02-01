package com.tencent.mm.plugin.hp.net;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b
{
  a DMV;
  SimpleHttpLogic.Request DMW;
  SimpleHttpLogic.TaskCallback DMX;
  a DMY;
  
  public b(dhg paramdhg)
  {
    AppMethodBeat.i(195019);
    this.DMV = new a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(195010);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(195010);
      }
    };
    this.DMX = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(195755);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new dhh();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.TOs;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((dhk)localObject);
              b.this.DMY.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(195755);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.TOu) });
            b.this.DMY.a(-5, null);
            AppMethodBeat.o(195755);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            b.this.DMY.a(-2, null);
            AppMethodBeat.o(195755);
            return;
          }
        }
        b.this.DMY.a(-1, null);
        AppMethodBeat.o(195755);
      }
    };
    this.DMY = this.DMV;
    dhg localdhg = paramdhg;
    if (paramdhg == null)
    {
      paramdhg = a.aSy();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "baseTinkerId = ".concat(String.valueOf(paramdhg)));
      localdhg = new dhg();
      localdhg.TOo = paramdhg;
      localdhg.GIL = a.aSz();
      localdhg.TOp = e.eIb();
      localdhg.TOr = 1;
    }
    try
    {
      this.DMW = new SimpleHttpLogic.Request();
      this.DMW.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.DMW.host = MMApplicationContext.getResources().getString(com.tencent.mm.plugin.boots.b.a.host_short_weixin_qq_com);
      paramdhg = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localdhg.toByteArray(), paramdhg))));
      this.DMW.body = paramdhg.value;
      paramdhg = new StringBuilder();
      if (localdhg != null)
      {
        paramdhg.append("baseId  :").append(localdhg.TOo).append("\n");
        paramdhg.append("patchId :").append(localdhg.GIL).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "prconfig %s", new Object[] { paramdhg.toString() });
      AppMethodBeat.o(195019);
      return;
    }
    catch (IOException paramdhg)
    {
      for (;;)
      {
        this.DMW = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", paramdhg, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(195026);
    this.DMY = parama;
    if (this.DMW == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "doScene failed. request is null.");
      this.DMY.a(-3, null);
      AppMethodBeat.o(195026);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheck", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.DMW, this.DMX, parama);
    AppMethodBeat.o(195026);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.hp.d.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.b
 * JD-Core Version:    0.7.0.1
 */