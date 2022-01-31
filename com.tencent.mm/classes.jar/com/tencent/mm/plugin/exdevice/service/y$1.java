package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class y$1
  extends e.a
{
  y$1(y paramy) {}
  
  public final void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(19649);
    Object localObject;
    if (paramBoolean)
    {
      localObject = "true";
      ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onConnected. seesionId=%d, connected=%s, profileType=%d", new Object[] { Long.valueOf(paramLong1), localObject, Long.valueOf(paramLong2) });
      localObject = new y.c((byte)0);
      ((y.c)localObject).jRn = paramLong1;
      if (!paramBoolean) {
        break label154;
      }
    }
    label154:
    for (int i = 2;; i = 4)
    {
      ((y.c)localObject).lIe = i;
      ((y.c)localObject).lId = 1;
      ((y.c)localObject).lCs = 0;
      ((y.c)localObject).jOK = paramLong2;
      if (!y.a(this.lJc).sendMessage(y.a(this.lJc).obtainMessage(9, localObject))) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(9) });
      }
      AppMethodBeat.o(19649);
      return;
      localObject = "false";
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19652);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[] { paramString1, paramString2 });
    y.g localg = new y.g((byte)0);
    localg.lJg = false;
    localg.jRr = paramString1;
    localg.mDeviceName = paramString2;
    localg.hIe = paramInt;
    localg.lJh = paramArrayOfByte;
    if (!y.a(this.lJc).sendMessage(y.a(this.lJc).obtainMessage(13, localg))) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
    }
    AppMethodBeat.o(19652);
  }
  
  public final void aVU()
  {
    AppMethodBeat.i(19653);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
    y.g localg = new y.g((byte)0);
    localg.lJg = true;
    localg.jRr = null;
    localg.mDeviceName = null;
    localg.hIe = 0;
    localg.lJh = null;
    if (!y.a(this.lJc).sendMessage(y.a(this.lJc).obtainMessage(13, localg))) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
    }
    AppMethodBeat.o(19653);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19650);
    y.f localf = new y.f((byte)0);
    localf.lFs = paramLong;
    localf.mData = paramArrayOfByte;
    if (!y.a(this.lJc).sendMessage(y.a(this.lJc).obtainMessage(12, localf))) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(12) });
    }
    AppMethodBeat.o(19650);
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(19651);
    Object localObject;
    if (paramBoolean)
    {
      localObject = "true";
      ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onSend. sessionId=%d, success=%s", new Object[] { Long.valueOf(paramLong), localObject });
      localObject = new y.h((byte)0);
      ((y.h)localObject).lFs = paramLong;
      if (!paramBoolean) {
        break label136;
      }
      ((y.h)localObject).lCE = 0;
    }
    for (((y.h)localObject).lCs = 0;; ((y.h)localObject).lCs = -1)
    {
      ((y.h)localObject).hyJ = "";
      if (!y.a(this.lJc).sendMessage(y.a(this.lJc).obtainMessage(11, localObject))) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(11) });
      }
      AppMethodBeat.o(19651);
      return;
      localObject = "false";
      break;
      label136:
      ((y.h)localObject).lCE = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.1
 * JD-Core Version:    0.7.0.1
 */