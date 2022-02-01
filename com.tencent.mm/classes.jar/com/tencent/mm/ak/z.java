package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class z
{
  private oicq.wlogin_sdk.request.b hxh;
  private long hxi;
  
  public z()
  {
    AppMethodBeat.i(132504);
    this.hxi = 0L;
    this.hxh = null;
    try
    {
      long l = bs.eWj();
      this.hxh = new oicq.wlogin_sdk.request.b(ai.getContext(), com.tencent.mm.protocal.d.DIc);
      util.LXM = 1;
      util.LXN = new a();
      ac.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(bs.Ap(l)) });
      AppMethodBeat.o(132504);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
      AppMethodBeat.o(132504);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132506);
    if (paramLong != this.hxi)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hxi), Long.valueOf(paramLong) });
      AppMethodBeat.o(132506);
      return false;
    }
    if (bs.cv(paramArrayOfByte))
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      AppMethodBeat.o(132506);
      return false;
    }
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.hxh;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
          break label288;
        }
        if (localb.LVy == null)
        {
          break label288;
          ac.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
          if (i == 0)
          {
            AppMethodBeat.o(132506);
            return true;
          }
        }
        else
        {
          util.aXk("user:" + localb.LVs._uin + " ResolveSvrData ...");
          i = localb.LVy.ac(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.CE(localb.LVs._uin);
          }
          util.aXk("user:" + localb.LVs._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        AppMethodBeat.o(132506);
      }
      catch (Exception paramArrayOfByte)
      {
        ac.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(paramArrayOfByte) });
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
    if (ab.ivG == 10006) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ab.ivH) });
      if (ab.ivG != 10006) {
        break label96;
      }
      if (ab.ivH != 1) {
        break;
      }
      ab.ivH = 0;
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    if (ab.ivH == 2)
    {
      AppMethodBeat.o(132505);
      return new byte[0];
    }
    for (;;)
    {
      try
      {
        label96:
        this.hxi = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          if (bs.cv(arrayOfByte)) {
            break label279;
          }
          bool = true;
          ac.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          paramBoolean = bs.cv(arrayOfByte);
          if (!paramBoolean)
          {
            AppMethodBeat.o(132505);
            return arrayOfByte;
          }
        }
        else
        {
          arrayOfByte = this.hxh.a(paramLong, b.a.LVE, "");
          continue;
        }
        paramString = this.hxh.a(paramLong, b.a.LVD, new String(bs.aLu(paramString), "ISO-8859-1"));
        AppMethodBeat.o(132505);
        return paramString;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(paramString) });
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
    if (paramLong != this.hxi)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hxi), Long.valueOf(paramLong) });
      AppMethodBeat.o(132508);
      return new byte[0];
    }
    if (bs.isNullOrNil(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.hxh.f(paramLong, paramString);
        AppMethodBeat.o(132508);
        return paramString;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(paramString) });
        AppMethodBeat.o(132508);
      }
    }
    return new byte[0];
  }
  
  public final byte[] pQ(long paramLong)
  {
    AppMethodBeat.i(132507);
    if (paramLong != this.hxi)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hxi), Long.valueOf(paramLong) });
      AppMethodBeat.o(132507);
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.hxh.CD(paramLong);
      AppMethodBeat.o(132507);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132507);
    }
    return new byte[0];
  }
  
  public final byte[] pR(long paramLong)
  {
    AppMethodBeat.i(132509);
    if (paramLong != this.hxi)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hxi), Long.valueOf(paramLong) });
      AppMethodBeat.o(132509);
      return new byte[0];
    }
    for (;;)
    {
      WloginSigInfo localWloginSigInfo;
      try
      {
        localWloginSigInfo = this.hxh.LVs.CG(paramLong);
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
        ac.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
        ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(localException) });
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
  
  public final void pS(long paramLong)
  {
    AppMethodBeat.i(132510);
    if (paramLong != this.hxi)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.hxi), Long.valueOf(paramLong) });
      AppMethodBeat.o(132510);
      return;
    }
    try
    {
      this.hxh.CE(paramLong);
      AppMethodBeat.o(132510);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      ac.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bs.m(localException) });
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
        ac.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 2)
      {
        ac.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(132503);
        return;
      }
      if (paramInt == 0) {
        ac.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      AppMethodBeat.o(132503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.z
 * JD-Core Version:    0.7.0.1
 */