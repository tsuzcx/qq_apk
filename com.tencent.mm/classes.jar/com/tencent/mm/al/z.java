package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class z
{
  private long hPA;
  private oicq.wlogin_sdk.request.b hPz;
  
  public z()
  {
    AppMethodBeat.i(132504);
    this.hPA = 0L;
    this.hPz = null;
    try
    {
      long l = bt.flT();
      this.hPz = new oicq.wlogin_sdk.request.b(aj.getContext(), com.tencent.mm.protocal.d.Fnj);
      util.NSl = 1;
      util.NSm = new a();
      ad.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(bt.Df(l)) });
      AppMethodBeat.o(132504);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
      AppMethodBeat.o(132504);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132506);
    if (paramLong != this.hPA)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hPA), Long.valueOf(paramLong) });
      AppMethodBeat.o(132506);
      return false;
    }
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      AppMethodBeat.o(132506);
      return false;
    }
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.hPz;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break label288;
        }
        if (localb.NPX == null)
        {
          break label288;
          ad.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
          if (i == 0)
          {
            AppMethodBeat.o(132506);
            return true;
          }
        }
        else
        {
          util.bdE("user:" + localb.NPR._uin + " ResolveSvrData ...");
          i = localb.NPX.ad(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.FK(localb.NPR._uin);
          }
          util.bdE("user:" + localb.NPR._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        AppMethodBeat.o(132506);
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(paramArrayOfByte) });
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
    if (ac.iON == 10006) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ac.iOO) });
      if (ac.iON != 10006) {
        break label96;
      }
      if (ac.iOO != 1) {
        break;
      }
      ac.iOO = 0;
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    if (ac.iOO == 2)
    {
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    for (;;)
    {
      try
      {
        label96:
        this.hPA = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          if (bt.cC(arrayOfByte)) {
            break label279;
          }
          bool = true;
          ad.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          paramBoolean = bt.cC(arrayOfByte);
          if (!paramBoolean)
          {
            AppMethodBeat.o(132505);
            return arrayOfByte;
          }
        }
        else
        {
          arrayOfByte = this.hPz.a(paramLong, b.a.NQd, "");
          continue;
        }
        paramString = this.hPz.a(paramLong, b.a.NQc, new String(bt.aRa(paramString), "ISO-8859-1"));
        AppMethodBeat.o(132505);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(paramString) });
        AppMethodBeat.o(132505);
        return new byte[0];
      }
      label279:
      bool = false;
    }
  }
  
  public final byte[] e(long paramLong, String paramString)
  {
    AppMethodBeat.i(132508);
    if (paramLong != this.hPA)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hPA), Long.valueOf(paramLong) });
      AppMethodBeat.o(132508);
      return new byte[0];
    }
    if (bt.isNullOrNil(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.hPz.g(paramLong, paramString);
        AppMethodBeat.o(132508);
        return paramString;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(paramString) });
        AppMethodBeat.o(132508);
      }
    }
    return new byte[0];
  }
  
  public final byte[] rP(long paramLong)
  {
    AppMethodBeat.i(132507);
    if (paramLong != this.hPA)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hPA), Long.valueOf(paramLong) });
      AppMethodBeat.o(132507);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.hPz.FJ(paramLong);
      AppMethodBeat.o(132507);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132507);
    }
    return new byte[0];
  }
  
  public final byte[] rQ(long paramLong)
  {
    AppMethodBeat.i(132509);
    if (paramLong != this.hPA)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hPA), Long.valueOf(paramLong) });
      AppMethodBeat.o(132509);
      return new byte[0];
    }
    for (;;)
    {
      WloginSigInfo localWloginSigInfo;
      try
      {
        localWloginSigInfo = this.hPz.NPR.FM(paramLong);
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
        ad.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
        ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(localException) });
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
  
  public final void rR(long paramLong)
  {
    AppMethodBeat.i(132510);
    if (paramLong != this.hPA)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hPA), Long.valueOf(paramLong) });
      AppMethodBeat.o(132510);
      return;
    }
    try
    {
      this.hPz.FK(paramLong);
      AppMethodBeat.o(132510);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      ad.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132510);
    }
  }
  
  final class a
    extends oicq.wlogin_sdk.tools.b
  {
    public a() {}
    
    public final void G(int paramInt, String paramString)
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
        ad.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 2)
      {
        ad.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 0) {
        ad.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      AppMethodBeat.o(132503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.z
 * JD-Core Version:    0.7.0.1
 */