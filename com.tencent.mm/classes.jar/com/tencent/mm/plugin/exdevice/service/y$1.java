package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.f.a.b.e.a;
import com.tencent.mm.sdk.platformtools.ah;

final class y$1
  extends e.a
{
  y$1(y paramy) {}
  
  public final void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "true";
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onConnected. seesionId=%d, connected=%s, profileType=%d", new Object[] { Long.valueOf(paramLong1), localObject, Long.valueOf(paramLong2) });
      localObject = new y.c((byte)0);
      ((y.c)localObject).hXu = paramLong1;
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i = 2;; i = 4)
    {
      ((y.c)localObject).jyF = i;
      ((y.c)localObject).jyE = 1;
      ((y.c)localObject).jsT = 0;
      ((y.c)localObject).hUQ = paramLong2;
      if (!y.a(this.jzD).sendMessage(y.a(this.jzD).obtainMessage(9, localObject))) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(9) });
      }
      return;
      localObject = "false";
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[] { paramString1, paramString2 });
    y.g localg = new y.g((byte)0);
    localg.jzH = false;
    localg.hXy = paramString1;
    localg.gnO = paramString2;
    localg.goh = paramInt;
    localg.jzI = paramArrayOfByte;
    if (!y.a(this.jzD).sendMessage(y.a(this.jzD).obtainMessage(13, localg))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
    }
  }
  
  public final void awr()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
    y.g localg = new y.g((byte)0);
    localg.jzH = true;
    localg.hXy = null;
    localg.gnO = null;
    localg.goh = 0;
    localg.jzI = null;
    if (!y.a(this.jzD).sendMessage(y.a(this.jzD).obtainMessage(13, localg))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
    }
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    y.f localf = new y.f((byte)0);
    localf.jvT = paramLong;
    localf.mData = paramArrayOfByte;
    if (!y.a(this.jzD).sendMessage(y.a(this.jzD).obtainMessage(12, localf))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(12) });
    }
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "true";
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onSend. sessionId=%d, success=%s", new Object[] { Long.valueOf(paramLong), localObject });
      localObject = new y.h((byte)0);
      ((y.h)localObject).jvT = paramLong;
      if (!paramBoolean) {
        break label124;
      }
      ((y.h)localObject).jtf = 0;
    }
    for (((y.h)localObject).jsT = 0;; ((y.h)localObject).jsT = -1)
    {
      ((y.h)localObject).ghs = "";
      if (!y.a(this.jzD).sendMessage(y.a(this.jzD).obtainMessage(11, localObject))) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(11) });
      }
      return;
      localObject = "false";
      break;
      label124:
      ((y.h)localObject).jtf = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.1
 * JD-Core Version:    0.7.0.1
 */