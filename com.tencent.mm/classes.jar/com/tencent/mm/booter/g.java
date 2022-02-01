package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lg;
import com.tencent.mm.autogen.a.ri;
import com.tencent.mm.autogen.a.zd;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class g
{
  public static int Cm(String paramString)
  {
    AppMethodBeat.i(131934);
    paramString = y.bi(paramString + "/syncResp.ini", 0, -1);
    if (Util.isNullOrNil(paramString))
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
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(131930);
    Log.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      hf(2L);
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
      hf(7L);
      continue;
      if ((Util.isNullOrNil(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        Log.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        int i = o.t(paramArrayOfByte1, 0);
        paramInt1 = o.t(paramArrayOfByte1, 4);
        Log.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + i + " bufLen:" + paramInt1 + " dump:" + Util.dumpHexBuf(paramArrayOfByte1, 0, 8));
        if (paramInt1 != paramArrayOfByte1.length - 8)
        {
          Log.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
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
              paramArrayOfByte2 = new lg();
              paramArrayOfByte2.hMY.hMZ = paramArrayOfByte1.value;
              boolean bool2 = paramArrayOfByte2.publish();
              Log.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if ((localPInt3.value == 13) && (ag.bRx() != null) && (ag.bRx().poh != null))
            {
              paramArrayOfByte2 = ag.bRx().poh.sA(3);
              localPByteArray1.value = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte2, localPByteArray1.value);
              if (paramArrayOfByte2 == null)
              {
                paramInt1 = -1;
                label459:
                paramArrayOfByte2 = localPByteArray1.value;
                if (localPByteArray1.value != null) {
                  break label622;
                }
                paramInt2 = -1;
                label475:
                Log.i("MicroMsg.NotifySyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]", new Object[] { Integer.valueOf(paramInt1), paramArrayOfByte2, Integer.valueOf(paramInt2) });
              }
            }
            else
            {
              if (bool1) {
                break label632;
              }
              Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            Log.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new lg();
            paramArrayOfByte2.hMY.hMZ = paramArrayOfByte1.value;
            bool1 = paramArrayOfByte2.publish();
            Log.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
            paramArrayOfByte1.value = 0;
            break;
            paramInt1 = paramArrayOfByte2.length;
            break label459;
            label622:
            paramInt2 = localPByteArray1.value.length;
            break label475;
            label632:
            localb.setHeadExtFlags(localPInt2.value);
            if (localPInt1.value == -13)
            {
              localb.setRetCode(localPInt1.value);
              Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt1 = localb.fromProtoBuf(localPByteArray1.value);
            Log.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.setRetCode(paramInt1);
            localb.setBufferSize(arrayOfByte.length);
            paramArrayOfByte2 = Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = com.tencent.mm.platformtools.w.a(localb.YyA.ZdD);
            if ((Util.isNullOrNil(arrayOfByte)) || (!ad.p(paramArrayOfByte2, arrayOfByte)))
            {
              Log.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new com.tencent.mm.modelmulti.g(localb, i, paramLong).doScene(ag.bRx(), new g.1());
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = o.t(paramArrayOfByte1, 0))
          {
            hf(paramLong);
            break;
          }
          paramArrayOfByte2 = new aa.b();
          try
          {
            paramArrayOfByte2.fromProtoBuf(paramArrayOfByte1);
            hf(paramArrayOfByte2.YyK);
          }
          catch (Exception paramArrayOfByte1)
          {
            Log.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    AppMethodBeat.i(131932);
    String str = qf(paramInt);
    int j = Cm(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (y.ZC((String)localObject3))
      {
        Object localObject2 = y.bi((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (Util.isNullOrNil((byte[])localObject2))
        {
          Log.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = y.bi((String)localObject3, 0, -1);
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest((q.eD(true) + paramInt).getBytes());
        localObject3 = l.d((byte[])localObject1, ((String)localObject2).getBytes());
        Log.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), ai((byte[])localObject1), ai((byte[])localObject3), ai(((String)localObject2).getBytes()) });
        if (!Util.isNullOrNil((byte[])localObject3))
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
  
  public static String ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131936);
    if (Util.isNullOrNil(paramArrayOfByte))
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
  
  public static void dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131933);
    String str = qf(paramInt2);
    paramInt2 = Cm(str);
    y.deleteFile(str + "/syncResp.bin" + paramInt1);
    Log.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      y.deleteFile(str + "/syncResp.ini");
      Log.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
    AppMethodBeat.o(131933);
  }
  
  private static void hf(long paramLong)
  {
    AppMethodBeat.i(131931);
    Log.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(paramLong)));
    if ((0x100 & paramLong) != 0L)
    {
      zd localzd = new zd();
      localzd.icq.sourceType = 4;
      localzd.publish();
    }
    if ((0x200000 & paramLong) != 0L) {
      new ri().publish();
    }
    if ((0xFEFFFFFF & paramLong & 0xFFFFFFDF & 0xFFFFFEFF & 0xFFDFFFFF & 0x2) != 0L) {
      new com.tencent.mm.modelmulti.g().doScene(ag.bRx(), new g.2());
    }
    AppMethodBeat.o(131931);
  }
  
  public static String qf(int paramInt)
  {
    AppMethodBeat.i(131935);
    String str = f.sB(paramInt) + "pushSyncResp";
    y.bDX(str);
    AppMethodBeat.o(131935);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.g
 * JD-Core Version:    0.7.0.1
 */