package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.q;

public final class l$6
  implements Runnable
{
  public l$6(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(106893);
    Context localContext = this.val$context;
    String str1 = this.cKY;
    Object localObject = this.qNW;
    String str2 = this.hHS;
    int i = this.kIx;
    String str3 = this.qNX;
    String str4 = this.qMS;
    localObject = new com.tencent.mm.vfs.e((String)localObject);
    if (((com.tencent.mm.vfs.e)localObject).exists())
    {
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str2);
      ac.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { q.B(((com.tencent.mm.vfs.e)localObject).fxV()), q.B(locale.fxV()) });
      j.dck().a(localContext, str1, q.B(((com.tencent.mm.vfs.e)localObject).fxV()), str2, 1, i, str3, str4);
    }
    ap.f(this.val$callback);
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