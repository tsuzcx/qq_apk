package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class ac
{
  public static a lDJ;
  private oicq.wlogin_sdk.request.b lDH;
  private long lDI;
  
  public ac()
  {
    AppMethodBeat.i(132504);
    this.lDI = 0L;
    this.lDH = null;
    try
    {
      long l = Util.nowMilliSecond();
      byte[] arrayOfByte = util.mW(MMApplicationContext.getContext());
      if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
        util.b(MMApplicationContext.getContext(), q.auM().getBytes());
      }
      this.lDH = new oicq.wlogin_sdk.request.b(MMApplicationContext.getContext(), com.tencent.mm.protocal.d.RAD);
      util.jBo = 1;
      util.abHF = new b();
      Log.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(132504);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
      AppMethodBeat.o(132504);
    }
  }
  
  public final byte[] Gq(long paramLong)
  {
    AppMethodBeat.i(132507);
    if (paramLong != this.lDI)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.lDI), Long.valueOf(paramLong) });
      AppMethodBeat.o(132507);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.lDH.XH(paramLong);
      AppMethodBeat.o(132507);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132507);
    }
    return new byte[0];
  }
  
  public final byte[] Gr(long paramLong)
  {
    AppMethodBeat.i(132509);
    if (paramLong != this.lDI)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.lDI), Long.valueOf(paramLong) });
      AppMethodBeat.o(132509);
      return new byte[0];
    }
    for (;;)
    {
      WloginSigInfo localWloginSigInfo;
      try
      {
        localWloginSigInfo = this.lDH.abFl.XK(paramLong);
        if (localWloginSigInfo == null)
        {
          Object localObject1 = null;
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(132509);
          return new byte[0];
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
        Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(132509);
        return new byte[0];
      }
      localObject2 = new WUserSigInfo();
      ((WUserSigInfo)localObject2).get_clone(localWloginSigInfo);
    }
    Object localObject2 = ((WUserSigInfo)localObject2)._A2;
    AppMethodBeat.o(132509);
    return localObject2;
  }
  
  public final void Gs(long paramLong)
  {
    AppMethodBeat.i(132510);
    if (paramLong != this.lDI)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.lDI), Long.valueOf(paramLong) });
      AppMethodBeat.o(132510);
      return;
    }
    try
    {
      this.lDH.XI(paramLong);
      AppMethodBeat.o(132510);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132510);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132506);
    if (paramLong != this.lDI)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.lDI), Long.valueOf(paramLong) });
      AppMethodBeat.o(132506);
      return false;
    }
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      AppMethodBeat.o(132506);
      return false;
    }
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.lDH;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break label288;
        }
        if (localb.abFr == null)
        {
          break label288;
          Log.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
          if (i == 0)
          {
            AppMethodBeat.o(132506);
            return true;
          }
        }
        else
        {
          util.bIb("user:" + localb.abFl._uin + " ResolveSvrData ...");
          i = localb.abFr.ak(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.XI(localb.abFl._uin);
          }
          util.bIb("user:" + localb.abFl._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        AppMethodBeat.o(132506);
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
        AppMethodBeat.o(132506);
        return false;
      }
      return false;
      label288:
      int i = -1017;
    }
  }
  
  public final byte[] a(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132505);
    if (com.tencent.mm.platformtools.ac.mFM == 10006) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(com.tencent.mm.platformtools.ac.mFN) });
      if (com.tencent.mm.platformtools.ac.mFM != 10006) {
        break label96;
      }
      if (com.tencent.mm.platformtools.ac.mFN != 1) {
        break;
      }
      com.tencent.mm.platformtools.ac.mFN = 0;
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    if (com.tencent.mm.platformtools.ac.mFN == 2)
    {
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    label96:
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        if ((h.aHB()) && (lDJ != null) && (lDJ.biO()) && (!h.aHG().aHp().getBoolean(ar.a.VDS, true)))
        {
          AppMethodBeat.o(132505);
          return new byte[0];
        }
        this.lDI = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          if (Util.isNullOrNil(arrayOfByte)) {
            break label336;
          }
          bool = true;
          Log.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          paramBoolean = Util.isNullOrNil(arrayOfByte);
          if (!paramBoolean)
          {
            AppMethodBeat.o(132505);
            return arrayOfByte;
          }
        }
        else
        {
          arrayOfByte = this.lDH.a(paramLong, b.a.abFx, "");
          continue;
        }
        paramString = this.lDH.a(paramLong, b.a.abFw, new String(Util.decodeHexString(paramString), "ISO-8859-1"));
        AppMethodBeat.o(132505);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(132505);
        return new byte[0];
      }
      label336:
      bool = false;
    }
  }
  
  public final byte[] f(long paramLong, String paramString)
  {
    AppMethodBeat.i(132508);
    if (paramLong != this.lDI)
    {
      Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.lDI), Long.valueOf(paramLong) });
      AppMethodBeat.o(132508);
      return new byte[0];
    }
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.lDH.f(paramLong, paramString);
        AppMethodBeat.o(132508);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        Log.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(132508);
      }
    }
    return new byte[0];
  }
  
  public static abstract interface a
  {
    public abstract boolean biO();
  }
  
  final class b
    extends oicq.wlogin_sdk.tools.b
  {
    public b() {}
    
    public final void L(int paramInt, String paramString)
    {
      AppMethodBeat.i(132502);
      OnLog(paramInt, "", paramString);
      AppMethodBeat.o(132502);
    }
    
    public final void OnLog(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(132503);
      if (paramInt == 1)
      {
        Log.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 2)
      {
        Log.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 0) {
        Log.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      AppMethodBeat.o(132503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.ac
 * JD-Core Version:    0.7.0.1
 */