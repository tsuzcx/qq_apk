package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vfs.s;

public final class a
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j sPc;
  private static o sPd;
  private static i sPe;
  private static m sPf;
  private static c sPg;
  private static k sPh;
  private b jSi = null;
  
  static
  {
    AppMethodBeat.i(103581);
    sPc = new j();
    sPd = new o();
    sPe = new i();
    sPf = new m();
    sPg = new c();
    sPh = new k();
    AppMethodBeat.o(103581);
  }
  
  private static void gB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103575);
    com.tencent.mm.plugin.expansions.a.cMq();
    String str1 = s.bhK(paramString1);
    String str2 = s.bhK("assets:///".concat(String.valueOf(paramString2)));
    Log.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
    Log.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
    if ((str1 == null) || (str1.equals(str2)))
    {
      Log.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
      AppMethodBeat.o(103575);
      return;
    }
    s.deleteFile(paramString1);
    Log.i("MicroMsg.TaskInitFace", paramString1 + " md5 is wrong");
    p.j(MMApplicationContext.getContext(), paramString2, paramString1);
    AppMethodBeat.o(103575);
  }
  
  private static void safeAddListener(IListener paramIListener)
  {
    AppMethodBeat.i(103574);
    if (paramIListener == null)
    {
      Log.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
      AppMethodBeat.o(103574);
      return;
    }
    if (EventCenter.instance.hadListened(paramIListener))
    {
      Log.w("MicroMsg.TaskInitFace", "hy: already has listener");
      AppMethodBeat.o(103574);
      return;
    }
    EventCenter.instance.addListener(paramIListener);
    AppMethodBeat.o(103574);
  }
  
  private static void x(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103576);
    com.tencent.mm.plugin.expansions.a.cMq();
    p.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(103576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.a
 * JD-Core Version:    0.7.0.1
 */