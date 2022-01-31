package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class i$5
  implements Runnable
{
  public i$5(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(74124);
    Context localContext = this.val$context;
    String str1 = this.bZZ;
    Object localObject = this.mxU;
    String str2 = this.fEQ;
    int i = this.hXH;
    String str3 = this.mxV;
    localObject = new b((String)localObject);
    if (((b)localObject).exists())
    {
      b localb = new b(str2);
      ab.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { j.p(((b)localObject).dQJ()), j.p(localb.dQJ()) });
      g.bPJ().a(localContext, str1, j.p(((b)localObject).dQJ()), str2, 1, i, str3);
    }
    al.d(this.bZt);
    AppMethodBeat.o(74124);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74125);
    String str = super.toString() + "|sendFavVideo";
    AppMethodBeat.o(74125);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.5
 * JD-Core Version:    0.7.0.1
 */