package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class l$6
  implements Runnable
{
  public l$6(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(106893);
    Context localContext = this.val$context;
    String str1 = this.cXi;
    Object localObject = this.rGg;
    String str2 = this.idz;
    int i = this.liC;
    String str3 = this.rGh;
    String str4 = this.rFg;
    localObject = new k((String)localObject);
    if (((k)localObject).exists())
    {
      k localk = new k(str2);
      ae.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { w.B(((k)localObject).fTh()), w.B(localk.fTh()) });
      g.doC().a(localContext, str1, w.B(((k)localObject).fTh()), str2, 1, i, str3, str4);
    }
    ar.f(this.val$callback);
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