package com.tencent.mm.plugin.game.chatroom.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hk;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class ChatRoomBaseUI
  extends MMActivity
{
  private long ImA = 0L;
  private long Imz = 0L;
  private long mStartTime = 0L;
  
  public abstract long fCZ();
  
  public abstract long fDa();
  
  public abstract long getSourceId();
  
  public abstract long getSsid();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.mStartTime != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mStartTime;
      Log.i("MicroMsg.ChatRoomBaseUI", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[] { getClass().getSimpleName(), Long.valueOf(l1 - l2), Long.valueOf(this.Imz) });
      if (fDa() != -1L)
      {
        Object localObject = d.mty;
        l1 = fDa();
        l2 = fCZ();
        long l3 = getSsid();
        long l4 = getSourceId();
        long l5 = this.Imz / 1000L;
        localObject = d.a.a(l1, l2, 0L, 29L, 0L, l3, l4);
        d.a locala = d.mty;
        ((hk)localObject).rt(d.aXC());
        ((hk)localObject).iuR = l5;
        ((hk)localObject).bMH();
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.Imz += System.currentTimeMillis() - this.ImA;
  }
  
  public void onResume()
  {
    if (this.mStartTime == 0L) {
      this.mStartTime = System.currentTimeMillis();
    }
    this.ImA = System.currentTimeMillis();
    super.onResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.ChatRoomBaseUI
 * JD-Core Version:    0.7.0.1
 */