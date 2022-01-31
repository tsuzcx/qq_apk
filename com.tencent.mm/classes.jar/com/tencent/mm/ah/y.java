package com.tencent.mm.ah;

import com.tencent.mm.sdk.platformtools.bk;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b.a;
import oicq.wlogin_sdk.request.i;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class y
{
  private oicq.wlogin_sdk.request.b eeB = null;
  private long eeC = 0L;
  
  public y()
  {
    try
    {
      long l = bk.UY();
      this.eeB = new oicq.wlogin_sdk.request.b(com.tencent.mm.sdk.platformtools.ae.getContext(), com.tencent.mm.protocal.d.spa);
      util.xsi = 1;
      util.xsj = new a();
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", new Object[] { Long.valueOf(bk.co(l)) });
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WtloginMgr", localException, "Failed initializing WtloginMgr.", new Object[0]);
    }
  }
  
  public final boolean a(long paramLong, byte[] paramArrayOfByte)
  {
    if (paramLong != this.eeC)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.eeC), Long.valueOf(paramLong) });
      return false;
    }
    if (bk.bE(paramArrayOfByte))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
      return false;
    }
    label256:
    for (;;)
    {
      try
      {
        oicq.wlogin_sdk.request.b localb = this.eeB;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
        {
          if (localb.xpV == null)
          {
            break label256;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
            if (i != 0) {
              break;
            }
            return true;
          }
          util.ahk("user:" + localb.xpP._uin + " ResolveSvrData ...");
          i = localb.xpV.Y(paramArrayOfByte, paramArrayOfByte.length);
          if (i == 1) {
            localb.iD(localb.xpP._uin);
          }
          util.ahk("user:" + localb.xpP._uin + " ResolveSvrData ret=" + i);
          continue;
        }
        int i = -1017;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", new Object[] { paramArrayOfByte.getMessage() });
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(paramArrayOfByte) });
        return false;
      }
    }
  }
  
  public final byte[] a(long paramLong, String paramString, boolean paramBoolean)
  {
    boolean bool;
    Object localObject;
    if (com.tencent.mm.platformtools.ae.eSP == 10006)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WtloginMgr", "dkwt isTestWtLogin:%b val:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ) });
      if (com.tencent.mm.platformtools.ae.eSP != 10006) {
        break label85;
      }
      if (com.tencent.mm.platformtools.ae.eSQ != 1) {
        break label74;
      }
      com.tencent.mm.platformtools.ae.eSQ = 0;
      localObject = new byte[0];
    }
    for (;;)
    {
      return localObject;
      bool = false;
      break;
      label74:
      if (com.tencent.mm.platformtools.ae.eSQ == 2) {
        return new byte[0];
      }
      try
      {
        label85:
        this.eeC = paramLong;
        byte[] arrayOfByte;
        if (paramBoolean)
        {
          arrayOfByte = null;
          label98:
          if (bk.bE(arrayOfByte)) {
            break label207;
          }
        }
        label207:
        for (bool = true;; bool = false)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ", new Object[] { Integer.valueOf(8256), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
          localObject = arrayOfByte;
          if (!bk.bE(arrayOfByte)) {
            break;
          }
          return this.eeB.a(paramLong, b.a.xqa, new String(bk.ZM(paramString), "ISO-8859-1"));
          arrayOfByte = this.eeB.a(paramLong, b.a.xqb, "");
          break label98;
        }
        return new byte[0];
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", new Object[] { paramString.getMessage() });
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
  }
  
  public final byte[] bH(long paramLong)
  {
    if (paramLong != this.eeC)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.eeC), Long.valueOf(paramLong) });
      return new byte[0];
    }
    try
    {
      byte[] arrayOfByte = this.eeB.iC(paramLong);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(localException) });
    }
    return new byte[0];
  }
  
  public final byte[] bI(long paramLong)
  {
    if (paramLong != this.eeC)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.eeC), Long.valueOf(paramLong) });
      return new byte[0];
    }
    try
    {
      WloginSigInfo localWloginSigInfo = this.eeB.xpP.iF(paramLong);
      WUserSigInfo localWUserSigInfo;
      if (localWloginSigInfo == null) {
        localWUserSigInfo = null;
      }
      while (localWUserSigInfo == null)
      {
        return new byte[0];
        localWUserSigInfo = new WUserSigInfo();
        localWUserSigInfo.get_clone(localWloginSigInfo);
      }
      arrayOfByte = localException._A2;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(localException) });
      return new byte[0];
    }
    byte[] arrayOfByte;
    return arrayOfByte;
  }
  
  public final void bJ(long paramLong)
  {
    if (paramLong != this.eeC)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.eeC), Long.valueOf(paramLong) });
      return;
    }
    try
    {
      this.eeB.iD(paramLong);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", new Object[] { localException.getMessage() });
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final byte[] f(long paramLong, String paramString)
  {
    if (paramLong != this.eeC)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", new Object[] { Long.valueOf(this.eeC), Long.valueOf(paramLong) });
      return new byte[0];
    }
    if (bk.bl(paramString)) {}
    for (paramString = "****".getBytes();; paramString = paramString.getBytes()) {
      try
      {
        paramString = this.eeB.f(paramLong, paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", new Object[] { paramString.getMessage() });
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WtloginMgr", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
    return new byte[0];
  }
  
  final class a
    extends oicq.wlogin_sdk.tools.b
  {
    public a() {}
    
    public final void OnLog(int paramInt, String paramString1, String paramString2)
    {
      if (paramInt == 1) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
      }
      do
      {
        return;
        if (paramInt == 2)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
          return;
        }
      } while (paramInt != 0);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.WtloginMgr.Core", "[%s]%s", new Object[] { paramString1, paramString2 });
    }
    
    public final void p(int paramInt, String paramString)
    {
      OnLog(paramInt, "", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.y
 * JD-Core Version:    0.7.0.1
 */