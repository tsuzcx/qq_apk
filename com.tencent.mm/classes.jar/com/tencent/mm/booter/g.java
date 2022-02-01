package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
{
  public static String N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131936);
    if (bu.cF(paramArrayOfByte))
    {
      AppMethodBeat.o(131936);
      return "buf is nullOrNil";
    }
    if (paramArrayOfByte.length == 1)
    {
      paramArrayOfByte = "buf.len is 1: " + Integer.toHexString(paramArrayOfByte[0]);
      AppMethodBeat.o(131936);
      return paramArrayOfByte;
    }
    paramArrayOfByte = "buf last two[len:" + paramArrayOfByte.length + "]: %s, %s" + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) + ", " + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF);
    AppMethodBeat.o(131936);
    return paramArrayOfByte;
  }
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(131930);
    ae.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      qV(2L);
      AppMethodBeat.o(131930);
      return true;
    }
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(131930);
      return false;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131930);
      return true;
      qV(7L);
      continue;
      if ((bu.cF(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        ae.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        int i = com.tencent.mm.b.o.t(paramArrayOfByte1, 0);
        paramInt1 = com.tencent.mm.b.o.t(paramArrayOfByte1, 4);
        ae.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + i + " bufLen:" + paramInt1 + " dump:" + bu.ad(paramArrayOfByte1, 8));
        if (paramInt1 != paramArrayOfByte1.length - 8)
        {
          ae.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
        }
        else
        {
          byte[] arrayOfByte = new byte[paramInt1];
          System.arraycopy(paramArrayOfByte1, 8, arrayOfByte, 0, paramInt1);
          v.b localb = new v.b();
          PByteArray localPByteArray2 = new PByteArray();
          PByteArray localPByteArray1 = new PByteArray();
          PInt localPInt1 = new PInt();
          PInt localPInt3 = new PInt();
          paramArrayOfByte1 = new PInt(0);
          PInt localPInt2 = new PInt(255);
          boolean bool1;
          try
          {
            bool1 = MMProtocalJni.unpack(localPByteArray1, arrayOfByte, paramArrayOfByte2, localPByteArray2, localPInt1, localPInt3, paramArrayOfByte1, localPInt2);
            if (paramArrayOfByte1.value != 0)
            {
              paramArrayOfByte2 = new ix();
              paramArrayOfByte2.dwG.dwH = paramArrayOfByte1.value;
              boolean bool2 = com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte2);
              ae.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if ((localPInt3.value == 13) && (com.tencent.mm.network.ad.aPK() != null) && (com.tencent.mm.network.ad.aPK().iHF != null))
            {
              paramArrayOfByte2 = com.tencent.mm.network.ad.aPK().iHF.mR(3);
              localPByteArray1.value = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte2, localPByteArray1.value);
              if (paramArrayOfByte2 == null)
              {
                paramInt1 = -1;
                label461:
                paramArrayOfByte2 = localPByteArray1.value;
                if (localPByteArray1.value != null) {
                  break label627;
                }
                paramInt2 = -1;
                label477:
                ae.i("MicroMsg.NotifySyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]", new Object[] { Integer.valueOf(paramInt1), paramArrayOfByte2, Integer.valueOf(paramInt2) });
              }
            }
            else
            {
              if (bool1) {
                break label637;
              }
              ae.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            ae.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            ae.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new ix();
            paramArrayOfByte2.dwG.dwH = paramArrayOfByte1.value;
            bool1 = com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte2);
            ae.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
            paramArrayOfByte1.value = 0;
            break;
            paramInt1 = paramArrayOfByte2.length;
            break label461;
            label627:
            paramInt2 = localPByteArray1.value.length;
            break label477;
            label637:
            localb.setHeadExtFlags(localPInt2.value);
            if (localPInt1.value == -13)
            {
              localb.setRetCode(localPInt1.value);
              ae.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt1 = localb.fromProtoBuf(localPByteArray1.value);
            ae.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.setRetCode(paramInt1);
            localb.setBufferSize(arrayOfByte.length);
            paramArrayOfByte2 = bu.aSx(ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = z.a(localb.FGW.GjQ);
            if ((bu.cF(arrayOfByte)) || (!com.tencent.mm.protocal.ad.m(paramArrayOfByte2, arrayOfByte)))
            {
              ae.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new com.tencent.mm.modelmulti.b(localb, i, paramLong).doScene(com.tencent.mm.network.ad.aPK(), new g.1());
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = com.tencent.mm.b.o.t(paramArrayOfByte1, 0))
          {
            qV(paramLong);
            break;
          }
          paramArrayOfByte2 = new aa.b();
          try
          {
            paramArrayOfByte2.fromProtoBuf(paramArrayOfByte1);
            qV(paramArrayOfByte2.FHg);
          }
          catch (Exception paramArrayOfByte1)
          {
            ae.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    AppMethodBeat.i(131932);
    String str = kO(paramInt);
    int j = uA(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (com.tencent.mm.vfs.o.fB((String)localObject3))
      {
        Object localObject2 = com.tencent.mm.vfs.o.bb((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (bu.cF((byte[])localObject2))
        {
          ae.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = com.tencent.mm.vfs.o.bb((String)localObject3, 0, -1);
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest((q.cH(true) + paramInt).getBytes());
        localObject3 = l.d((byte[])localObject1, ((String)localObject2).getBytes());
        ae.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), N((byte[])localObject1), N((byte[])localObject3), N(((String)localObject2).getBytes()) });
        if (!bu.cF((byte[])localObject3))
        {
          paramPInt.value = i;
          AppMethodBeat.o(131932);
          return localObject3;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(131932);
    return null;
  }
  
  public static void co(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131933);
    String str = kO(paramInt2);
    paramInt2 = uA(str);
    com.tencent.mm.vfs.o.deleteFile(str + "/syncResp.bin" + paramInt1);
    ae.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      com.tencent.mm.vfs.o.deleteFile(str + "/syncResp.ini");
      ae.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
    AppMethodBeat.o(131933);
  }
  
  public static String kO(int paramInt)
  {
    AppMethodBeat.i(131935);
    String str = e.mS(paramInt) + "pushSyncResp";
    com.tencent.mm.vfs.o.aZI(str);
    AppMethodBeat.o(131935);
    return str;
  }
  
  private static void qV(long paramLong)
  {
    AppMethodBeat.i(131931);
    ae.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(paramLong)));
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new vg();
      ((vg)localObject).dKB.sourceType = 4;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new og();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x2) != 0L) {
      new com.tencent.mm.modelmulti.b().doScene(com.tencent.mm.network.ad.aPK(), new g.2());
    }
    AppMethodBeat.o(131931);
  }
  
  public static int uA(String paramString)
  {
    AppMethodBeat.i(131934);
    paramString = com.tencent.mm.vfs.o.bb(paramString + "/syncResp.ini", 0, -1);
    if (bu.cF(paramString))
    {
      AppMethodBeat.o(131934);
      return 0;
    }
    try
    {
      int i = Integer.parseInt(new String(paramString));
      AppMethodBeat.o(131934);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(131934);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.g
 * JD-Core Version:    0.7.0.1
 */