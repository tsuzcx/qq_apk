package com.tencent.mm.booter;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class MountReceiver$1
  extends ah
{
  MountReceiver$1(MountReceiver paramMountReceiver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool1 = true;
    paramMessage = MountReceiver.a(this.dhH);
    boolean bool2 = au.DK();
    if (MountReceiver.b(this.dhH) == null)
    {
      y.d("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b", new Object[] { paramMessage, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(f.zG()) });
      if (MountReceiver.b(this.dhH) != null) {
        break label78;
      }
    }
    label78:
    while (!f.zG())
    {
      return;
      bool1 = false;
      break;
    }
    s.gN(MountReceiver.b(this.dhH));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver.1
 * JD-Core Version:    0.7.0.1
 */