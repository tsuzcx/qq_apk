package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lb;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
{
  public static void a(String paramString1, final String paramString2, final String paramString3, final DialogInterface.OnClickListener paramOnClickListener1, final String paramString4, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(117443);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
      AppMethodBeat.o(117443);
      return;
    }
    Log.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117442);
        lb locallb = new lb();
        b localb = new b();
        localb.title = this.cWz;
        localb.msg = paramString2;
        localb.RDg = new LinkedList();
        a locala = new a();
        locala.RDe = paramString3;
        localb.RDg.add(locala);
        locala = new a();
        locala.RDe = paramString4;
        localb.RDg.add(locala);
        locallb.fIK.type = 1;
        locallb.fIK.fIL = localb;
        locallb.fIK.fIM = paramOnClickListener1;
        locallb.fIK.fIN = paramOnClickListener2;
        EventCenter.instance.publish(locallb);
        AppMethodBeat.o(117442);
      }
    });
    AppMethodBeat.o(117443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.i
 * JD-Core Version:    0.7.0.1
 */