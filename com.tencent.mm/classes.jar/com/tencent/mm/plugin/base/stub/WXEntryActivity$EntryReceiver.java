package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import com.jg.JgClassChecked;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class WXEntryActivity$EntryReceiver
  extends BroadcastReceiver
{
  private static ah handler;
  private String Bo;
  private String appId;
  private String appName;
  private Context context;
  private int hRW;
  private long hSE;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return;
    }
    d.coz();
    if (handler == null)
    {
      HandlerThread localHandlerThread = e.aap("WXEntryReceiver");
      localHandlerThread.start();
      handler = new ah(localHandlerThread.getLooper());
    }
    if (!g.DQ().dKP.dLj)
    {
      g.DQ().a(new WXEntryActivity.EntryReceiver.1(this, paramContext, paramIntent));
      return;
    }
    handler.post(new WXEntryActivity.EntryReceiver.2(this, paramContext, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver
 * JD-Core Version:    0.7.0.1
 */