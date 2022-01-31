package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class e$2
  extends f.a
{
  e$2(e parame) {}
  
  public final void a(final long paramLong1, boolean paramBoolean, final long paramLong2)
  {
    String str2 = b.ee(paramLong1);
    if (paramBoolean) {}
    for (String str1 = "true";; str1 = "false")
    {
      y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
      this.hUG.G(new Runnable()
      {
        public final void run()
        {
          f localf = (f)e.2.this.hUG.hTU.get(Long.valueOf(paramLong1));
          if (!paramLong2) {}
          for (int i = 1; (localf != null) || (i != 0); i = 0)
          {
            if (e.2.this.hUG.hUC != null)
            {
              e.2.this.hUG.hUC.a(paramLong1, paramLong2, this.hUI);
              if (i != 0) {
                y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.ee(paramLong1) });
              }
            }
            if (i != 0)
            {
              y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.ee(paramLong1) });
              e.2.this.hUG.hTU.remove(Long.valueOf(paramLong1));
              e.2.this.hUG.hUE.remove(Long.valueOf(paramLong1));
            }
            return;
          }
          y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.ee(paramLong1) });
        }
      });
      y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(this.hUG.hTU.size()) });
      return;
    }
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.ee(paramLong) });
    if (this.hUG.hUC != null)
    {
      this.hUG.hUC.b(paramLong, paramArrayOfByte);
      return;
    }
    y.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    String str2 = b.ee(paramLong);
    if (paramBoolean) {}
    for (String str1 = "true";; str1 = "false")
    {
      y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
      if (this.hUG.hUC != null) {
        this.hUG.hUC.j(paramLong, paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.e.2
 * JD-Core Version:    0.7.0.1
 */