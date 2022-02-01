package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class l$6
  implements Runnable
{
  public l$6(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(106893);
    Context localContext = this.val$context;
    String str1 = this.dnJ;
    Object localObject = this.tfM;
    String str2 = this.iYw;
    int i = this.moi;
    String str3 = this.tfN;
    String str4 = this.teL;
    localObject = new o((String)localObject);
    if (((o)localObject).exists())
    {
      o localo = new o(str2);
      Log.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[] { aa.z(((o)localObject).her()), aa.z(localo.her()) });
      g.eir().a(localContext, str1, aa.z(((o)localObject).her()), str2, 1, i, str3, str4);
    }
    MMHandlerThread.postToMainThread(this.val$callback);
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