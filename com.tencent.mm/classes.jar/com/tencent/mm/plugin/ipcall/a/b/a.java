package com.tencent.mm.plugin.ipcall.a.b;

import android.media.AudioManager;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public boolean bSr = false;
  public b iEF = null;
  public final Object lqj = new Object();
  public int lqk = 0;
  public boolean lql = false;
  
  public static boolean ys()
  {
    return au.Hy().dui.isSpeakerphoneOn();
  }
  
  public final void gV(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(this.lql), Boolean.valueOf(paramBoolean) });
    au.Hy().bn(paramBoolean);
    com.tencent.mm.plugin.ipcall.a.c.a locala = i.bch();
    if (paramBoolean) {}
    for (int i = locala.lqG.um(401);; i = locala.lqG.um(402))
    {
      if (i < 0) {
        y.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      if (paramBoolean != this.lql)
      {
        this.lql = paramBoolean;
        if ((this.iEF != null) && (this.iEF.pNn)) {
          this.iEF.jQ(paramBoolean);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a
 * JD-Core Version:    0.7.0.1
 */