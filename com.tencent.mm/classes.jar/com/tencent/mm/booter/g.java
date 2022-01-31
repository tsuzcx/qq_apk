package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.l;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class g
{
  public static String I(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57815);
    if (bo.ce(paramArrayOfByte))
    {
      AppMethodBeat.o(57815);
      return "buf is nullOrNil";
    }
    if (paramArrayOfByte.length == 1)
    {
      paramArrayOfByte = "buf.len is 1: " + Integer.toHexString(paramArrayOfByte[0]);
      AppMethodBeat.o(57815);
      return paramArrayOfByte;
    }
    paramArrayOfByte = "buf last two[len:" + paramArrayOfByte.length + "]: %s, %s" + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) + ", " + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF);
    AppMethodBeat.o(57815);
    return paramArrayOfByte;
  }
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(57809);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      fX(2L);
      AppMethodBeat.o(57809);
      return true;
    }
    if (paramInt1 != 2)
    {
      AppMethodBeat.o(57809);
      return false;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(57809);
      return true;
      fX(7L);
      continue;
      if ((bo.ce(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        int i = o.r(paramArrayOfByte1, 0);
        paramInt1 = o.r(paramArrayOfByte1, 4);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + i + " bufLen:" + paramInt1 + " dump:" + bo.V(paramArrayOfByte1, 8));
        if (paramInt1 != paramArrayOfByte1.length - 8)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
        }
        else
        {
          byte[] arrayOfByte = new byte[paramInt1];
          System.arraycopy(paramArrayOfByte1, 8, arrayOfByte, 0, paramInt1);
          t.b localb = new t.b();
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
              paramArrayOfByte2 = new hn();
              paramArrayOfByte2.cwF.cwG = paramArrayOfByte1.value;
              boolean bool2 = com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte2);
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if ((localPInt3.value == 13) && (com.tencent.mm.network.ab.anF() != null) && (com.tencent.mm.network.ab.anF().gdz != null))
            {
              paramArrayOfByte2 = com.tencent.mm.network.ab.anF().gdz.jN(3);
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
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]", new Object[] { Integer.valueOf(paramInt1), paramArrayOfByte2, Integer.valueOf(paramInt2) });
              }
            }
            else
            {
              if (bool1) {
                break label637;
              }
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new hn();
            paramArrayOfByte2.cwF.cwG = paramArrayOfByte1.value;
            bool1 = com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte2);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
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
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt1 = localb.fromProtoBuf(localPByteArray1.value);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.setRetCode(paramInt1);
            localb.setBufferSize(arrayOfByte.length);
            paramArrayOfByte2 = bo.apQ(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mp()).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = aa.a(localb.wiN.wFR);
            if ((bo.ce(arrayOfByte)) || (!com.tencent.mm.protocal.ab.k(paramArrayOfByte2, arrayOfByte)))
            {
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new com.tencent.mm.modelmulti.b(localb, i, paramLong).doScene(com.tencent.mm.network.ab.anF(), new g.1());
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = o.r(paramArrayOfByte1, 0))
          {
            fX(paramLong);
            break;
          }
          paramArrayOfByte2 = new y.b();
          try
          {
            paramArrayOfByte2.fromProtoBuf(paramArrayOfByte1);
            fX(paramArrayOfByte2.wiX);
          }
          catch (Exception paramArrayOfByte1)
          {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    AppMethodBeat.i(57811);
    String str = ig(paramInt);
    int j = kw(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (e.cN((String)localObject3))
      {
        Object localObject2 = e.j((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (bo.ce((byte[])localObject2))
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = e.j((String)localObject3, 0, -1);
        }
        localObject2 = com.tencent.mm.a.g.w((q.bP(true) + paramInt).getBytes());
        localObject3 = l.c((byte[])localObject1, ((String)localObject2).getBytes());
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), I((byte[])localObject1), I((byte[])localObject3), I(((String)localObject2).getBytes()) });
        if (!bo.ce((byte[])localObject3))
        {
          paramPInt.value = i;
          AppMethodBeat.o(57811);
          return localObject3;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(57811);
    return null;
  }
  
  public static void bT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57812);
    String str = ig(paramInt2);
    paramInt2 = kw(str);
    e.deleteFile(str + "/syncResp.bin" + paramInt1);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      e.deleteFile(str + "/syncResp.ini");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
    AppMethodBeat.o(57812);
  }
  
  private static void fX(long paramLong)
  {
    AppMethodBeat.i(57810);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(paramLong)));
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new sf();
      ((sf)localObject).cIz.cpG = 4;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new mc();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0xFFFFFEFF & paramLong & 0xFFDFFFFF & 0x2) != 0L) {
      new com.tencent.mm.modelmulti.b().doScene(com.tencent.mm.network.ab.anF(), new g.2());
    }
    AppMethodBeat.o(57810);
  }
  
  public static String ig(int paramInt)
  {
    AppMethodBeat.i(57814);
    String str = com.tencent.mm.a.g.w("mm".concat(String.valueOf(paramInt)).getBytes());
    str = ac.eQv + str + "/pushSyncResp";
    e.cQ(str);
    AppMethodBeat.o(57814);
    return str;
  }
  
  public static int kw(String paramString)
  {
    AppMethodBeat.i(57813);
    paramString = e.j(paramString + "/syncResp.ini", 0, -1);
    if (bo.ce(paramString))
    {
      AppMethodBeat.o(57813);
      return 0;
    }
    try
    {
      int i = Integer.parseInt(new String(paramString));
      AppMethodBeat.o(57813);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(57813);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.g
 * JD-Core Version:    0.7.0.1
 */