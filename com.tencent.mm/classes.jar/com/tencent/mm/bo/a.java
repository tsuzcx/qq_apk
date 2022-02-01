package com.tencent.mm.bo;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends q
  implements m
{
  private static AtomicBoolean mtM;
  private i jQg;
  private d rr;
  
  static
  {
    AppMethodBeat.i(280625);
    mtM = new AtomicBoolean(false);
    AppMethodBeat.o(280625);
  }
  
  public a()
  {
    AppMethodBeat.i(280621);
    this.rr = null;
    d.a locala = new d.a();
    locala.funcId = 6238;
    locala.uri = "/cgi-bin/micromsg-bin/getnetworkinfo";
    locala.lBW = 0;
    locala.respCmdId = 0;
    locala.newExtFlag = 0;
    locala.transferHeader = null;
    locala.lBU = new byt();
    locala.lBV = new byu();
    locala.transferHeader = null;
    this.rr = locala.bgN();
    AppMethodBeat.o(280621);
  }
  
  public static boolean bsQ()
  {
    AppMethodBeat.i(280618);
    boolean bool = mtM.get();
    AppMethodBeat.o(280618);
    return bool;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(280623);
    this.jQg = parami;
    localbyt = (byt)d.b.b(this.rr.lBR);
    for (;;)
    {
      try
      {
        arrayOfString = h.aHF().kcd.lCD.Uf("newdns");
        if ((arrayOfString != null) && (arrayOfString.length == 3)) {
          continue;
        }
        localbyt.ThP = "";
        localbyt.ThQ = "";
        localbyt.ThR = "";
      }
      catch (Exception parami)
      {
        String[] arrayOfString;
        int i;
        Log.e("MicroMsg.MMNetIdRequest", parami.getLocalizedMessage());
        localbyt.ThP = "";
        localbyt.ThQ = "";
        localbyt.ThR = "";
        continue;
        parami = arrayOfString[0];
        continue;
        parami = arrayOfString[2];
        continue;
        parami = arrayOfString[1];
        continue;
      }
      mtM.set(true);
      Log.i("MicroMsg.MMNetIdRequest", "net id from newdns " + localbyt.ThP + " client ip " + localbyt.ThR);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(280623);
      return i;
      if (!TextUtils.isEmpty(arrayOfString[0])) {
        continue;
      }
      parami = "";
      localbyt.ThP = parami;
      if (!TextUtils.isEmpty(arrayOfString[1])) {
        continue;
      }
      parami = "";
      localbyt.ThQ = parami;
      if (!TextUtils.isEmpty(arrayOfString[2])) {
        continue;
      }
      parami = "";
      localbyt.ThR = parami;
    }
  }
  
  public final int getType()
  {
    return 6238;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(280624);
    Log.i("MicroMsg.MMNetIdRequest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3 + " error msg " + paramString);
    mtM.set(false);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      params = (byu)d.c.b(((d)params).lBS);
    }
    try
    {
      paramArrayOfByte = h.aHF().kcd.lCD;
      if ((paramArrayOfByte != null) && (params != null))
      {
        Log.d("MicroMsg.MMNetIdRequest", "receive netinfo id " + params.ThP + " clinet ip " + params.ThR + " isp " + params.ThS);
        paramArrayOfByte.setNetIdAndIsp(params.ThP, String.valueOf(params.ThS), params.ThR);
      }
    }
    catch (Exception params)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMNetIdRequest", params.getLocalizedMessage());
      }
    }
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(280624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bo.a
 * JD-Core Version:    0.7.0.1
 */