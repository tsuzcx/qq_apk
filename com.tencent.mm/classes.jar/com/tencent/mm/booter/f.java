package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.hj;
import com.tencent.mm.h.a.ln;
import com.tencent.mm.h.a.qt;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;

public final class f
{
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    y.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      bn(2L);
      return true;
    }
    if (paramInt1 != 2) {
      return false;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return true;
      bn(7L);
      continue;
      if ((bk.bE(paramArrayOfByte1)) || (paramArrayOfByte1.length <= 8))
      {
        y.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
      }
      else
      {
        paramInt1 = n.q(paramArrayOfByte1, 0);
        paramInt2 = n.q(paramArrayOfByte1, 4);
        y.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + paramInt1 + " bufLen:" + paramInt2 + " dump:" + bk.U(paramArrayOfByte1, 8));
        if (paramInt2 != paramArrayOfByte1.length - 8)
        {
          y.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + paramArrayOfByte1.length);
        }
        else
        {
          byte[] arrayOfByte = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte1, 8, arrayOfByte, 0, paramInt2);
          s.b localb = new s.b();
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
              paramArrayOfByte2 = new hj();
              paramArrayOfByte2.bPm.bPn = paramArrayOfByte1.value;
              boolean bool2 = a.udP.m(paramArrayOfByte2);
              y.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool2) });
              paramArrayOfByte1.value = 0;
            }
            if (!bool1) {
              y.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
            }
          }
          catch (Exception paramArrayOfByte2)
          {
            y.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte2 });
            y.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte2, "", new Object[0]);
          }
          while (paramArrayOfByte1.value != 0)
          {
            paramArrayOfByte2 = new hj();
            paramArrayOfByte2.bPm.bPn = paramArrayOfByte1.value;
            bool1 = a.udP.m(paramArrayOfByte2);
            y.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(paramArrayOfByte1.value), Boolean.valueOf(bool1) });
            paramArrayOfByte1.value = 0;
            break;
            localb.spO = localPInt2.value;
            if (localPInt1.value == -13)
            {
              localb.spN = localPInt1.value;
              y.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
              break;
            }
            paramInt2 = localb.A(localPByteArray1.value);
            y.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
            localb.spN = paramInt2;
            localb.bufferSize = arrayOfByte.length;
            paramArrayOfByte2 = bk.ZM(ae.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
            arrayOfByte = com.tencent.mm.platformtools.aa.a(localb.sqj.sIi);
            if ((bk.bE(arrayOfByte)) || (!z.h(paramArrayOfByte2, arrayOfByte)))
            {
              y.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
              break;
            }
            new com.tencent.mm.modelmulti.b(localb, paramInt1, paramLong).a(com.tencent.mm.network.aa.Uu(), new f.1());
          }
          if (paramArrayOfByte1 == null) {}
          for (paramLong = 7L;; paramLong = n.q(paramArrayOfByte1, 0))
          {
            bn(paramLong);
            break;
          }
          paramArrayOfByte2 = new w.b();
          try
          {
            paramArrayOfByte2.A(paramArrayOfByte1);
            bn(paramArrayOfByte2.sqp);
          }
          catch (Exception paramArrayOfByte1)
          {
            y.printErrStackTrace("MicroMsg.NotifySyncMgr", paramArrayOfByte1, "", new Object[0]);
          }
        }
      }
    }
  }
  
  public static byte[] a(PInt paramPInt, int paramInt)
  {
    String str = fR(paramInt);
    int j = ep(str);
    int i = 1;
    while (i <= j)
    {
      Object localObject3 = str + "/syncResp.bin" + i;
      if (e.bK((String)localObject3))
      {
        Object localObject2 = e.d((String)localObject3, 0, -1);
        Object localObject1 = localObject2;
        if (bk.bE((byte[])localObject2))
        {
          y.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
          localObject1 = e.d((String)localObject3, 0, -1);
        }
        localObject2 = g.o((q.zf() + paramInt).getBytes());
        localObject3 = k.a((byte[])localObject1, ((String)localObject2).getBytes());
        y.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), x((byte[])localObject1), x((byte[])localObject3), x(((String)localObject2).getBytes()) });
        if (!bk.bE((byte[])localObject3))
        {
          paramPInt.value = i;
          return localObject3;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static void aV(int paramInt1, int paramInt2)
  {
    String str = fR(paramInt2);
    paramInt2 = ep(str);
    e.deleteFile(str + "/syncResp.bin" + paramInt1);
    y.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      e.deleteFile(str + "/syncResp.ini");
      y.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
    }
  }
  
  private static void bn(long paramLong)
  {
    y.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + paramLong);
    Object localObject;
    if ((0x100 & paramLong) != 0L)
    {
      localObject = new qt();
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0x200000 & paramLong) != 0L)
    {
      localObject = new ln();
      a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    }
    if ((0xFFFFFEFF & paramLong & 0xFFDFFFFF & 0x2) != 0L) {
      new com.tencent.mm.modelmulti.b().a(com.tencent.mm.network.aa.Uu(), new f.2());
    }
  }
  
  public static int ep(String paramString)
  {
    paramString = e.d(paramString + "/syncResp.ini", 0, -1);
    if (bk.bE(paramString)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(new String(paramString));
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public static String fR(int paramInt)
  {
    String str = g.o(("mm" + paramInt).getBytes());
    str = ac.dOP + str + "/pushSyncResp";
    e.bN(str);
    return str;
  }
  
  public static String x(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      return "buf is nullOrNil";
    }
    if (paramArrayOfByte.length == 1) {
      return "buf.len is 1: " + Integer.toHexString(paramArrayOfByte[0]);
    }
    return "buf last two[len:" + paramArrayOfByte.length + "]: %s, %s" + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) + ", " + Integer.toHexString(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.f
 * JD-Core Version:    0.7.0.1
 */