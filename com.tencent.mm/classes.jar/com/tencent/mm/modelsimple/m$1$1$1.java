package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class m$1$1$1
  implements Runnable
{
  m$1$1$1(m.1.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(16578);
    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", new Object[] { Boolean.valueOf(ah.dsM()) });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_disaster_content", this.fPd.fPa);
    localIntent.putExtra("key_disaster_url", this.fPd.fPb);
    localIntent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
    ah.getContext().startActivity(localIntent);
    AppMethodBeat.o(16578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.m.1.1.1
 * JD-Core Version:    0.7.0.1
 */