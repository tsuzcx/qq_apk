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
import com.tencent.mm.vfs.u;

public final class b
  implements com.tencent.mm.vending.c.a<Void, Void>
{
  private static j wuX;
  private static o wuY;
  private static i wuZ;
  private static m wva;
  private static c wvb;
  private static k wvc;
  private com.tencent.mm.vending.g.b mJv = null;
  
  static
  {
    AppMethodBeat.i(103581);
    wuX = new j();
    wuY = new o();
    wuZ = new i();
    wva = new m();
    wvb = new c();
    wvc = new k();
    AppMethodBeat.o(103581);
  }
  
  private static void A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103576);
    com.tencent.mm.plugin.expansions.a.dbe();
    p.j(paramContext, paramString1, paramString2);
    AppMethodBeat.o(103576);
  }
  
  private static void gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103575);
    com.tencent.mm.plugin.expansions.a.dbe();
    String str1 = u.buc(paramString1);
    String str2 = u.buc("assets:///".concat(String.valueOf(paramString2)));
    Log.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(str1)));
    Log.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(str2)));
    if ((str1 == null) || (str1.equals(str2)))
    {
      Log.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", new Object[] { paramString1 });
      AppMethodBeat.o(103575);
      return;
    }
    u.deleteFile(paramString1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b
 * JD-Core Version:    0.7.0.1
 */