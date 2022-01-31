package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.HandlerThread;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public final class a
{
  public static final UUID jQJ;
  public static final UUID jQK;
  public HashMap<Long, b> jNO;
  public BluetoothAdapter jNi;
  public a.a jQL;
  public Context jQM;
  public final BroadcastReceiver jQN;
  public ak mHandler;
  public boolean mIsInit;
  private Runnable mRunnable;
  
  static
  {
    AppMethodBeat.i(18482);
    jQJ = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    jQK = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    AppMethodBeat.o(18482);
  }
  
  public a(al paramal)
  {
    AppMethodBeat.i(18478);
    this.mIsInit = false;
    this.jQN = new a.1(this);
    this.jNO = new HashMap();
    this.mHandler = new ak(paramal.oNc.getLooper());
    this.mRunnable = new a.2(this);
    AppMethodBeat.o(18478);
  }
  
  private boolean aWd()
  {
    AppMethodBeat.i(18480);
    if (!this.jNi.isDiscovering())
    {
      AppMethodBeat.o(18480);
      return true;
    }
    if (!this.jNi.cancelDiscovery())
    {
      ab.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      AppMethodBeat.o(18480);
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(18480);
    return true;
  }
  
  public final boolean aWc()
  {
    AppMethodBeat.i(18479);
    Assert.assertTrue(this.mIsInit);
    if (this.jNi == null)
    {
      AppMethodBeat.o(18479);
      return false;
    }
    AppMethodBeat.o(18479);
    return true;
  }
  
  public final boolean fK(boolean paramBoolean)
  {
    AppMethodBeat.i(18481);
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      ab.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (aWc()) {
        break;
      }
      ab.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      AppMethodBeat.o(18481);
      return false;
    }
    if (paramBoolean)
    {
      if ((this.jNi.isDiscovering()) && (!aWd()))
      {
        AppMethodBeat.o(18481);
        return false;
      }
      if (!this.jNi.startDiscovery())
      {
        ab.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        AppMethodBeat.o(18481);
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      AppMethodBeat.o(18481);
      return true;
    }
    paramBoolean = aWd();
    AppMethodBeat.o(18481);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */