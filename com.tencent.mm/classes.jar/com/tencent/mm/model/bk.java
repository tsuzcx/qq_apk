package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.o;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class bk
  extends o
{
  private final x.a ltR;
  private final x.b ltS;
  
  public bk()
  {
    AppMethodBeat.i(132250);
    this.ltR = new x.a();
    this.ltS = new x.b();
    AppMethodBeat.o(132250);
  }
  
  public static int a(s params)
  {
    AppMethodBeat.i(196803);
    Object localObject2 = (x.a)params.getReqObj();
    x.b localb = (x.b)params.getRespObj();
    Log.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", new Object[] { Integer.valueOf(((x.a)localObject2).getFuncId()), Util.getStack() });
    int i;
    if (localb.jWd != 0)
    {
      Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localb.jWd) });
      i = localb.jWd;
      AppMethodBeat.o(196803);
      return i;
    }
    params = localb.RBZ.TKt;
    int j;
    Object localObject1;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if (params != null)
    {
      j = params.RMj;
      localObject1 = params.RLT;
      arrayOfByte1 = z.a(params.RMm);
      arrayOfByte2 = z.a(params.RMn);
      arrayOfByte3 = z.a(params.RLU);
      int k = ((aiq)localObject1).RMR.Ufv;
      int m = ((aiq)localObject1).Stl;
      if (arrayOfByte3 == null)
      {
        i = -1;
        Log.d("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Util.secPrint(Util.dumpHex(arrayOfByte3)), Util.secPrint(Util.dumpHex(arrayOfByte1)), Util.secPrint(Util.dumpHex(arrayOfByte2)) });
        byte[] arrayOfByte4 = z.a(((aiq)localObject1).RMR);
        localObject2 = ((x.a)localObject2).RBl;
        params = null;
        if (Util.isNullOrNil(arrayOfByte4)) {
          break label573;
        }
        k = arrayOfByte4.length;
        params = Util.secPrint(Util.dumpHex(arrayOfByte4));
        if (localObject2 != null) {
          break label560;
        }
        i = -1;
        label286:
        Log.d("MicroMsg.MMReqRespReg2", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(k), params, Integer.valueOf(i), Util.secPrint(Util.dumpHex((byte[])localObject2)) });
        params = new PByteArray();
        k = MMProtocalJni.computerKeyWithAllStr(((aiq)localObject1).Stl, arrayOfByte4, (byte[])localObject2, params, 0);
        params = params.value;
        if (params != null) {
          break label567;
        }
        i = -1;
        label360:
        Log.i("MicroMsg.MMReqRespReg2", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Util.secPrint(Util.dumpHex(params)) });
        label395:
        if (params == null) {
          break label583;
        }
        localObject1 = params;
        label402:
        localb.RBq = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label660;
        }
        Log.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
        if (Util.isNullOrNil(params)) {
          break label632;
        }
        params = MMProtocalJni.aesDecrypt(arrayOfByte3, params);
        if (arrayOfByte3 != null) {
          break label591;
        }
        i = -1;
        label443:
        localObject1 = Util.dumpHex(arrayOfByte3);
        if (params != null) {
          break label598;
        }
        j = -1;
        label456:
        Log.d("MicroMsg.MMReqRespReg2", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), Util.secPrint(Util.dumpHex(params)) });
        if (Util.isNullOrNil(params)) {
          break label604;
        }
        Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", new Object[] { Util.secPrint(Util.dumpHex(params)) });
        localb.b(params, arrayOfByte1, arrayOfByte2);
        localb.jWd = 1;
      }
    }
    for (;;)
    {
      i = localb.jWd;
      AppMethodBeat.o(196803);
      return i;
      i = arrayOfByte3.length;
      break;
      label560:
      i = localObject2.length;
      break label286;
      label567:
      i = params.length;
      break label360;
      label573:
      Log.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
      break label395;
      label583:
      localObject1 = new byte[0];
      break label402;
      label591:
      i = arrayOfByte3.length;
      break label443;
      label598:
      j = params.length;
      break label456;
      label604:
      Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
      localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
      localb.jWd = 2;
      continue;
      label632:
      Log.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
      localb.b(new byte[0], arrayOfByte1, arrayOfByte2);
      localb.jWd = 2;
      continue;
      label660:
      Log.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
      localb.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      localb.jWd = 1;
      continue;
      Log.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
      localb.b(new byte[0], new byte[0], new byte[0]);
      localb.jWd = 2;
    }
  }
  
  public final l.d getReqObjImp()
  {
    return this.ltR;
  }
  
  public final l.e getRespObj()
  {
    return this.ltS;
  }
  
  public final int getType()
  {
    return 126;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/newreg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */