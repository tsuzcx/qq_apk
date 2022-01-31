package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class y
{
  private oicq.wlogin_sdk.request.b fuD;
  private long fuE;
  
  public y()
  {
    AppMethodBeat.i(58320);
    this.fuE = 0L;
    this.fuD = null;
    try
    {
      long l = bo.aoy();
      this.fuD = new oicq.wlogin_sdk.request.b(ah.getContext(), com.tencent.mm.protocal.d.whH);
      util.COv = 1;
      util.COw = new a();
      ab.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(bo.hl(l)) });
      AppMethodBeat.o(58320);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
      AppMethodBeat.o(58320);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58322);
    if (paramLong != this.fuE)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.fuE), Long.valueOf(paramLong) });
      AppMethodBeat.o(58322);
      return false;
    }
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      AppMethodBeat.o(58322);
      return false;
    }
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.fuD;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break label288;
        }
        if (localb.CMi == null)
        {
          break label288;
          ab.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
          if (i == 0)
          {
            AppMethodBeat.o(58322);
            return true;
          }
        }
        else
        {
          util.azC("user:" + localb.CMc._uin + " ResolveSvrData ...");
          i = localb.CMi.Z(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.pB(localb.CMc._uin);
          }
          util.azC("user:" + localb.CMc._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        AppMethodBeat.o(58322);
      }
      catch (Exception paramArrayOfByte)
      {
        ab.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(paramArrayOfByte) });
        AppMethodBeat.o(58322);
        return false;
      }
      return false;
      label288:
      int i = -1017;
    }
  }
  
  public final byte[] a(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(58321);
    if (ae.gkK == 10006) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ae.gkL) });
      if (ae.gkK != 10006) {
        break label96;
      }
      if (ae.gkL != 1) {
        break;
      }
      ae.gkL = 0;
      AppMethodBeat.o(58321);
      return new byte[0];
    }
    if (ae.gkL == 2)
    {
      AppMethodBeat.o(58321);
      return new byte[0];
    }
    for (;;)
    {
      try
      {
        label96:
        this.fuE = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          if (bo.ce(arrayOfByte)) {
            break label279;
          }
          bool = true;
          ab.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          paramBoolean = bo.ce(arrayOfByte);
          if (!paramBoolean)
          {
            AppMethodBeat.o(58321);
            return arrayOfByte;
          }
        }
        else
        {
          arrayOfByte = this.fuD.a(paramLong, b.a.CMo, "");
          continue;
        }
        paramString = this.fuD.a(paramLong, b.a.CMn, new String(bo.apQ(paramString), "ISO-8859-1"));
        AppMethodBeat.o(58321);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(58321);
        return new byte[0];
      }
      label279:
      bool = false;
    }
  }
  
  public final byte[] d(long paramLong, String paramString)
  {
    AppMethodBeat.i(58324);
    if (paramLong != this.fuE)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.fuE), Long.valueOf(paramLong) });
      AppMethodBeat.o(58324);
      return new byte[0];
    }
    if (bo.isNullOrNil(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.fuD.f(paramLong, paramString);
        AppMethodBeat.o(58324);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(58324);
      }
    }
    return new byte[0];
  }
  
  public final byte[] gC(long paramLong)
  {
    AppMethodBeat.i(58323);
    if (paramLong != this.fuE)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.fuE), Long.valueOf(paramLong) });
      AppMethodBeat.o(58323);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.fuD.pA(paramLong);
      AppMethodBeat.o(58323);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58323);
    }
    return new byte[0];
  }
  
  public final byte[] gD(long paramLong)
  {
    AppMethodBeat.i(58325);
    if (paramLong != this.fuE)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.fuE), Long.valueOf(paramLong) });
      AppMethodBeat.o(58325);
      return new byte[0];
    }
    for (;;)
    {
      WloginSigInfo localWloginSigInfo;
      try
      {
        localWloginSigInfo = this.fuD.CMc.pD(paramLong);
        if (localWloginSigInfo == null)
        {
          Object localObject1 = null;
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(58325);
          return new byte[0];
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
        ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(58325);
        return new byte[0];
      }
      localObject2 = new WUserSigInfo();
      ((WUserSigInfo)localObject2).get_clone(localWloginSigInfo);
    }
    Object localObject2 = ((WUserSigInfo)localObject2)._A2;
    AppMethodBeat.o(58325);
    return localObject2;
  }
  
  public final void gE(long paramLong)
  {
    AppMethodBeat.i(58326);
    if (paramLong != this.fuE)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.fuE), Long.valueOf(paramLong) });
      AppMethodBeat.o(58326);
      return;
    }
    try
    {
      this.fuD.pB(paramLong);
      AppMethodBeat.o(58326);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      ab.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58326);
    }
  }
  
  final class a
    extends oicq.wlogin_sdk.tools.b
  {
    public a() {}
    
    public final void OnLog(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(58319);
      if (paramInt == 1)
      {
        ab.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(58319);
        return;
      }
      if (paramInt == 2)
      {
        ab.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(58319);
        return;
      }
      if (paramInt == 0) {
        ab.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      AppMethodBeat.o(58319);
    }
    
    public final void w(int paramInt, String paramString)
    {
      AppMethodBeat.i(58318);
      OnLog(paramInt, "", paramString);
      AppMethodBeat.o(58318);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.y
 * JD-Core Version:    0.7.0.1
 */