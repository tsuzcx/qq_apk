package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class d
{
  private static int jtB = 0;
  HashMap<Long, Integer> jtA;
  j jtC = null;
  private Object jtD = new Object();
  public com.tencent.mm.plugin.exdevice.service.c jtw;
  private w jtx;
  HashMap<Long, am> jty;
  HashMap<Long, am> jtz;
  
  public d()
  {
    u.aMn().jts = new d.1(this);
    if (this.jtx == null) {
      this.jtx = new d.10(this);
    }
    this.jty = new HashMap();
    this.jtz = new HashMap();
    this.jtA = new HashMap();
  }
  
  public static int aLt()
  {
    return jtB;
  }
  
  /* Error */
  private boolean c(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 81	com/tencent/mm/model/au:Dk	()Lcom/tencent/mm/ah/p;
    //   5: invokevirtual 86	com/tencent/mm/ah/p:KG	()I
    //   8: istore 5
    //   10: iload 5
    //   12: iconst_4
    //   13: if_icmpeq +25 -> 38
    //   16: iload 5
    //   18: bipush 6
    //   20: if_icmpeq +18 -> 38
    //   23: ldc 88
    //   25: ldc 90
    //   27: invokestatic 96	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: iconst_0
    //   31: istore 8
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 8
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 61	com/tencent/mm/plugin/exdevice/model/d:jtz	Ljava/util/HashMap;
    //   42: lload_2
    //   43: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: invokevirtual 106	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   49: ifeq +31 -> 80
    //   52: ldc 88
    //   54: ldc 108
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: lload_2
    //   67: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: invokestatic 112	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: iconst_0
    //   75: istore 8
    //   77: goto -44 -> 33
    //   80: new 114	com/tencent/mm/sdk/platformtools/am
    //   83: dup
    //   84: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   87: new 122	com/tencent/mm/plugin/exdevice/model/d$8
    //   90: dup
    //   91: aload_0
    //   92: lload_2
    //   93: aload_1
    //   94: iload 4
    //   96: invokespecial 125	com/tencent/mm/plugin/exdevice/model/d$8:<init>	(Lcom/tencent/mm/plugin/exdevice/model/d;JLjava/lang/String;I)V
    //   99: iconst_0
    //   100: invokespecial 128	com/tencent/mm/sdk/platformtools/am:<init>	(Landroid/os/Looper;Lcom/tencent/mm/sdk/platformtools/am$a;Z)V
    //   103: astore 9
    //   105: invokestatic 134	com/tencent/mm/plugin/exdevice/j/b:aMX	()J
    //   108: lstore 6
    //   110: ldc 88
    //   112: ldc 136
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: lload 6
    //   122: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: aastore
    //   126: invokestatic 112	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 9
    //   131: lload 6
    //   133: lload 6
    //   135: invokevirtual 140	com/tencent/mm/sdk/platformtools/am:S	(JJ)V
    //   138: aload_0
    //   139: getfield 61	com/tencent/mm/plugin/exdevice/model/d:jtz	Ljava/util/HashMap;
    //   142: lload_2
    //   143: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   146: aload 9
    //   148: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: invokestatic 38	com/tencent/mm/plugin/exdevice/service/u:aMn	()Lcom/tencent/mm/plugin/exdevice/model/c;
    //   155: getfield 148	com/tencent/mm/plugin/exdevice/model/c:jtr	Lcom/tencent/mm/plugin/exdevice/service/m;
    //   158: ifnull +48 -> 206
    //   161: ldc 88
    //   163: ldc 150
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: lload_2
    //   176: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   179: aastore
    //   180: invokestatic 112	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: invokestatic 38	com/tencent/mm/plugin/exdevice/service/u:aMn	()Lcom/tencent/mm/plugin/exdevice/model/c;
    //   186: getfield 148	com/tencent/mm/plugin/exdevice/model/c:jtr	Lcom/tencent/mm/plugin/exdevice/service/m;
    //   189: lload_2
    //   190: iload 4
    //   192: aload_0
    //   193: getfield 51	com/tencent/mm/plugin/exdevice/model/d:jtx	Lcom/tencent/mm/plugin/exdevice/service/w;
    //   196: invokeinterface 155 5 0
    //   201: istore 8
    //   203: goto -170 -> 33
    //   206: ldc 88
    //   208: ldc 157
    //   210: invokestatic 96	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: iconst_0
    //   214: istore 8
    //   216: goto -183 -> 33
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	d
    //   0	224	1	paramString	String
    //   0	224	2	paramLong	long
    //   0	224	4	paramInt	int
    //   8	13	5	i	int
    //   108	26	6	l	long
    //   31	184	8	bool	boolean
    //   103	44	9	localam	am
    // Exception table:
    //   from	to	target	type
    //   2	10	219	finally
    //   23	30	219	finally
    //   38	74	219	finally
    //   80	203	219	finally
    //   206	213	219	finally
  }
  
  public static void dH(long paramLong)
  {
    if (u.aMn().jtr != null) {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.aMn().jtr.dZ(paramLong)) });
    }
  }
  
  public static boolean fA(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (u.aMn().jtr != null)
    {
      long[] arrayOfLong = u.aMn().jtr.aMa();
      boolean bool1;
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        y.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        bool1 = false;
      }
      int j;
      int i;
      do
      {
        return bool1;
        j = arrayOfLong.length;
        i = 0;
        bool1 = bool2;
      } while (i >= j);
      long l = arrayOfLong[i];
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
      b localb = ad.aLL().ed(l);
      if (localb == null) {
        y.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
        {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        else
        {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
          u.aMn().jtr.dZ(l);
        }
      }
    }
    y.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
    return false;
  }
  
  public final void a(int paramInt, j paramj)
  {
    y.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null) {
      y.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
    }
    do
    {
      return;
      this.jtC = paramj;
      if (this.jtw == null)
      {
        this.jtw = new com.tencent.mm.plugin.exdevice.service.c();
        this.jtw.jyW = new d.12(this, paramInt, paramInt);
        this.jtw.da(ae.getContext());
        return;
      }
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
      if (u.aMn().jtr == null)
      {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        return;
      }
    } while (u.aMn().jtr.b(paramInt, this.jtC));
    y.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      this.jtA.put(paramLong, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  public final void a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    a.C("shut_down_device", paramLong);
    if (this.jtw == null)
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.jtw = new com.tencent.mm.plugin.exdevice.service.c();
      this.jtw.jyW = new d.6(this, paramInt, paramString, paramLong, paramBoolean);
      this.jtw.da(ae.getContext());
      return;
    }
    if ((this.jtw != null) && (!this.jtw.jyX))
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.jtw.jyW = new d.7(this, paramInt, paramString, paramLong, paramBoolean);
      this.jtw.da(ae.getContext());
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
  }
  
  public final void aLu()
  {
    if ((this.jtw != null) && (this.jtw.jyX)) {}
    try
    {
      ae.getContext().unbindService(this.jtw);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void b(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt, false);
  }
  
  public final void b(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {
      paramBoolean = c(paramString, paramLong, paramInt);
    }
    for (;;)
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
      if (au.Dk().KG() != 4)
      {
        y.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
        paramBoolean = false;
      }
      else
      {
        am localam;
        if (this.jty.containsKey(Long.valueOf(paramLong)))
        {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
          localam = (am)this.jty.get(Long.valueOf(paramLong));
          localam.stopTimer();
          localam.S(30000L, 30000L);
        }
        for (;;)
        {
          if (u.aMn().jtr != null) {
            break label274;
          }
          y.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
          paramBoolean = false;
          break;
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
          localam = new am(Looper.getMainLooper(), new d.9(this, paramLong, paramString, paramInt), false);
          localam.S(30000L, 30000L);
          this.jty.put(Long.valueOf(paramLong), localam);
        }
        label274:
        paramString = u.aMm().dT(paramLong);
        if (paramString == null)
        {
          y.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
          paramBoolean = false;
        }
        else
        {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.bKp) });
          if ((paramString.bKp != 2) && (paramString.bKp != 1)) {
            u.aMn().jtr.a(paramLong, paramInt, this.jtx);
          }
          paramBoolean = true;
        }
      }
    }
  }
  
  public final void qo(int paramInt)
  {
    try
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      jtB = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */