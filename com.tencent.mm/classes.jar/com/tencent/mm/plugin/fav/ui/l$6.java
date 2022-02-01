package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class l$6
  implements Runnable
{
  public l$6(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(106893);
    Context localContext = this.val$context;
    String str1 = this.cWl;
    Object localObject = this.rxV;
    String str2 = this.iaG;
    int i = this.leQ;
    String str3 = this.rxW;
    String str4 = this.rwU;
    localObject = new e((String)localObject);
    if (((e)localObject).exists())
    {
      e locale = new e(str2);
      ad.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { q.B(((e)localObject).fOK()), q.B(locale.fOK()) });
      g.dlD().a(localContext, str1, q.B(((e)localObject).fOK()), str2, 1, i, str3, str4);
    }
    aq.f(this.val$callback);
    AppMethodBeat.o(106893);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(106894);
    String str = super.toString() + "|sendFavVideo";
    AppMethodBeat.o(106894);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.6
 * JD-Core Version:    0.7.0.1
 */