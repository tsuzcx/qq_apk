package com.tencent.mm.plugin.hp.model;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

final class b$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(261846);
    String str = b.bmz() + "Download/";
    str = str + "new.apk";
    long l = System.currentTimeMillis();
    l = (System.currentTimeMillis() - l) / 1000L;
    Log.i("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "merge apk use :%d retCode：%d", new Object[] { Long.valueOf(l), Integer.valueOf(0) });
    if (this.val$context != null) {
      Toast.makeText(this.val$context, "stayTime = " + l + ", retCode = 0", 1).show();
    }
    Log.i("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "show dialog for install");
    Log.i("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "New Apk md5:%s", new Object[] { y.bub(str) });
    Log.i("MicroMsg.Tinker.HdiffBootsCommand.HdiffApk", "md5 is equal.");
    AppMethodBeat.o(261846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.b.1
 * JD-Core Version:    0.7.0.1
 */