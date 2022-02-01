package com.tencent.mm.plugin.hp.model;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mf;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class h
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
        mf localmf = new mf();
        b localb = new b();
        localb.title = h.this;
        localb.msg = paramString2;
        localb.YzI = new LinkedList();
        a locala = new a();
        locala.YzG = paramString3;
        localb.YzI.add(locala);
        locala = new a();
        locala.YzG = paramString4;
        localb.YzI.add(locala);
        localmf.hOl.type = 1;
        localmf.hOl.hOm = localb;
        localmf.hOl.hOn = paramOnClickListener1;
        localmf.hOl.hOo = paramOnClickListener2;
        localmf.publish();
        AppMethodBeat.o(117442);
      }
    });
    AppMethodBeat.o(117443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.h
 * JD-Core Version:    0.7.0.1
 */