package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class g
{
  public static String O(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131936);
    if (bs.cv(paramArrayOfByte))
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
    ac.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      oI(2L);
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
      oI(7L);
      continue;
      if ((bs.cv(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        ac.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        int i = o.t(paramArrayOfByte1, 0);
        paramInt1 = o.t(paramArrayOfByte1, 4);
        ac.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + i + " bufLen:" + paramInt1 + " dump:" + bs.Y(paramArrayOfByte1, 8));
        if (paramInt1 != paramArrayOfByte1.length - 8)
        {
          ac.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
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
              paramArrayOfByte2 = new io();
              paramArrayOfByte2.djO.djP = paramArrayOfByte1.value;
              boolean bool2 = com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte2);
              ac.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if ((localPInt3.value == 13) && (com.tencent.mm.network.ad.aMf() != null) && (com.tencent.mm.network.ad.aMf().ilv != null))
            {
              paramArrayOfByte2 = com.tencent.mm.network.ad.aMf().ilv.mp(3);
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
                ac.i("MicroMsg.NotifySyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]", new Object[] { Integer.valueOf(paramInt1), paramArrayOfByte2, Integer.valueOf(paramInt2) });
              }
            }
            else
            {
              if (bool1) {
                break label637;
              }
              ac.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            ac.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            ac.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new io();
            paramArrayOfByte2.djO.djP = paramArrayOfByte1.value;
            bool1 = com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte2);
            ac.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
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
              ac.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt1 = localb.fromProtoBuf(localPByteArray1.value);
            ac.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.setRetCode(paramInt1);
            localb.setBufferSize(arrayOfByte.length);
            paramArrayOfByte2 = bs.aLu(ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = z.a(localb.DJr.Eki);
            if ((bs.cv(arrayOfByte)) || (!com.tencent.mm.protocal.ad.l(paramArrayOfByte2, arrayOfByte)))
            {
              ac.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new com.tencent.mm.modelmulti.b(localb, i, paramLong).doScene(com.tencent.mm.network.ad.aMf(), new g.1());
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = o.t(paramArrayOfByte1, 0))
          {
            oI(paramLong);
            break;
          }
          paramArrayOfByte2 = new aa.b();
          try
          {
            paramArrayOfByte2.fromProtoBuf(paramArrayOfByte1);
            oI(paramArrayOfByte2.DJB);
          }
          catch (Exception paramArrayOfByte1)
          {
            ac.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    AppMethodBeat.i(131932);
    String str = kp(paramInt);
    int j = rt(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (i.eA((String)localObject3))
      {
        Object localObject2 = i.aU((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (bs.cv((byte[])localObject2))
        {
          ac.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = i.aU((String)localObject3, 0, -1);
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest((q.cF(true) + paramInt).getBytes());
        localObject3 = l.d((byte[])localObject1, ((String)localObject2).getBytes());
        ac.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), O((byte[])localObject1), O((byte[])localObject3), O(((String)localObject2).getBytes()) });
        if (!bs.cv((byte[])localObject3))
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
  
  public static void cm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131933);
    String str = kp(paramInt2);
    paramInt2 = rt(str);
    i.deleteFile(str + "/syncResp.bin" + paramInt1);
    ac.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      i.deleteFile(str + "/syncResp.ini");
      ac.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
    AppMethodBeat.o(131933);
  }
  
  public static String kp(int paramInt)
  {
    AppMethodBeat.i(131935);
    String str = e.mq(paramInt) + "pushSyncResp";
    i.aSh(str);
    AppMethodBeat.o(131935);
    return str;
  }
  
  private static void oI(long paramLong)
  {
    AppMethodBeat.i(131931);
    ac.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(paramLong)));
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new uj();
      ((uj)localObject).dxb.sourceType = 4;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new nx();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0xFEFFFFFF & paramLong & 0xFFFFFEFF & 0xFFDFFFFF & 0x2) != 0L) {
      new com.tencent.mm.modelmulti.b().doScene(com.tencent.mm.network.ad.aMf(), new g.2());
    }
    AppMethodBeat.o(131931);
  }
  
  public static int rt(String paramString)
  {
    AppMethodBeat.i(131934);
    paramString = i.aU(paramString + "/syncResp.ini", 0, -1);
    if (bs.cv(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.g
 * JD-Core Version:    0.7.0.1
 */