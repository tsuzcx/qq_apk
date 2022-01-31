package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class i$5
  implements Runnable
{
  public i$5(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Runnable paramRunnable) {}
  
  public final void run()
  {
    Context localContext = this.val$context;
    String str1 = this.bxX;
    Object localObject = this.kdk;
    String str2 = this.eot;
    int i = this.gAv;
    String str3 = this.kdl;
    localObject = new b((String)localObject);
    if (((b)localObject).exists())
    {
      b localb = new b(str2);
      y.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { j.n(((b)localObject).cLr()), j.n(localb.cLr()) });
      g.bhI().a(localContext, str1, j.n(((b)localObject).cLr()), str2, 1, i, str3);
    }
    ai.d(this.bxs);
  }
  
  public final String toString()
  {
    return super.toString() + "|sendFavVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.5
 * JD-Core Version:    0.7.0.1
 */