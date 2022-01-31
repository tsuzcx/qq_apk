package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class k$1$1$1
  implements Runnable
{
  k$1$1$1(k.1.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", new Object[] { Boolean.valueOf(ae.cqO()) });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_disaster_content", this.ezo.ezl);
    localIntent.putExtra("key_disaster_url", this.ezo.ezm);
    localIntent.setClass(ae.getContext(), DisasterUI.class).addFlags(268435456);
    ae.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.k.1.1.1
 * JD-Core Version:    0.7.0.1
 */