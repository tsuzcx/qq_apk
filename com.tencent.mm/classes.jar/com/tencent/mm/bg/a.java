package com.tencent.mm.bg;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends p
  implements m
{
  private static AtomicBoolean pnf;
  private com.tencent.mm.am.h mAY;
  private com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(230963);
    pnf = new AtomicBoolean(false);
    AppMethodBeat.o(230963);
  }
  
  public a()
  {
    AppMethodBeat.i(230962);
    this.rr = null;
    c.a locala = new c.a();
    locala.funcId = 6238;
    locala.uri = "/cgi-bin/micromsg-bin/getnetworkinfo";
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.newExtFlag = 0;
    locala.transferHeader = null;
    locala.otE = new cnw();
    locala.otF = new cnx();
    locala.transferHeader = null;
    this.rr = locala.bEF();
    AppMethodBeat.o(230962);
  }
  
  public static boolean bQz()
  {
    AppMethodBeat.i(230958);
    boolean bool = pnf.get();
    AppMethodBeat.o(230958);
    return bool;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(230966);
    this.mAY = paramh;
    localcnw = (cnw)c.b.b(this.rr.otB);
    for (;;)
    {
      try
      {
        arrayOfString = com.tencent.mm.kernel.h.baD().mCm.oun.Me("newdns");
        if ((arrayOfString != null) && (arrayOfString.length == 3)) {
          continue;
        }
        localcnw.aavf = "";
        localcnw.aavg = "";
        localcnw.aavh = "";
      }
      catch (Exception paramh)
      {
        String[] arrayOfString;
        int i;
        Log.e("MicroMsg.MMNetIdRequest", paramh.getLocalizedMessage());
        localcnw.aavf = "";
        localcnw.aavg = "";
        localcnw.aavh = "";
        continue;
        paramh = arrayOfString[0];
        continue;
        paramh = arrayOfString[2];
        continue;
        paramh = arrayOfString[1];
        continue;
      }
      pnf.set(true);
      Log.i("MicroMsg.MMNetIdRequest", "net id from newdns " + localcnw.aavf + " client ip " + localcnw.aavh);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(230966);
      return i;
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        continue;
      }
      paramh = "";
      localcnw.aavf = paramh;
      if (!TextUtils.isEmpty(arrayOfString[1])) {
        continue;
      }
      paramh = "";
      localcnw.aavg = paramh;
      if (!TextUtils.isEmpty(arrayOfString[2])) {
        continue;
      }
      paramh = "";
      localcnw.aavh = paramh;
    }
  }
  
  public final int getType()
  {
    return 6238;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230969);
    Log.i("MicroMsg.MMNetIdRequest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3 + " error msg " + paramString);
    pnf.set(false);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      params = (cnx)c.c.b(((com.tencent.mm.am.c)params).otC);
    }
    try
    {
      paramArrayOfByte = com.tencent.mm.kernel.h.baD().mCm.oun;
      if ((paramArrayOfByte != null) && (params != null))
      {
        Log.d("MicroMsg.MMNetIdRequest", "receive netinfo id " + params.aavf + " clinet ip " + params.aavh + " isp " + params.aavi);
        paramArrayOfByte.setNetIdAndIsp(params.aavf, String.valueOf(params.aavi), params.aavh);
      }
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMNetIdRequest", params.getLocalizedMessage());
      }
    }
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(230969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bg.a
 * JD-Core Version:    0.7.0.1
 */