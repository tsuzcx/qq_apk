package com.tencent.mm.ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class o
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private i fsE;
  private d fsF;
  private c fsG;
  private g fsH;
  private ap fsI;
  
  static
  {
    AppMethodBeat.i(77967);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new o.1());
    baseDBFactories.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new o.2());
    AppMethodBeat.o(77967);
  }
  
  public o()
  {
    AppMethodBeat.i(77957);
    this.fsI = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new o.3(this), false);
    AppMethodBeat.o(77957);
  }
  
  public static d acQ()
  {
    AppMethodBeat.i(77959);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (adf().fsF == null) {
      adf().fsF = new d();
    }
    d locald = adf().fsF;
    AppMethodBeat.o(77959);
    return locald;
  }
  
  public static o adf()
  {
    AppMethodBeat.i(77956);
    o localo = (o)q.S(o.class);
    AppMethodBeat.o(77956);
    return localo;
  }
  
  public static i adg()
  {
    AppMethodBeat.i(77958);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (adf().fsE == null) {
      adf().fsE = new i(com.tencent.mm.kernel.g.RL().eHS);
    }
    i locali = adf().fsE;
    AppMethodBeat.o(77958);
    return locali;
  }
  
  public static g adh()
  {
    AppMethodBeat.i(77960);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (adf().fsH == null) {
      adf().fsH = new g(com.tencent.mm.kernel.g.RL().eHS);
    }
    g localg = adf().fsH;
    AppMethodBeat.o(77960);
    return localg;
  }
  
  public static c adi()
  {
    AppMethodBeat.i(77961);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (adf().fsG == null) {
      adf().fsG = new c();
    }
    c localc = adf().fsG;
    AppMethodBeat.o(77961);
    return localc;
  }
  
  public static boolean adj()
  {
    AppMethodBeat.i(77965);
    if (bo.a((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(59, null), false))
    {
      AppMethodBeat.o(77965);
      return true;
    }
    acQ();
    if (d.qZ(r.Zn()))
    {
      AppMethodBeat.o(77965);
      return true;
    }
    String str = r.Zn();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(77965);
      return false;
    }
    Bitmap localBitmap = d.b.rg(com.tencent.mm.plugin.i.c.YK() + "user_" + com.tencent.mm.a.g.w(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      AppMethodBeat.o(77965);
      return false;
    }
    boolean bool = acQ().f(str, localBitmap);
    AppMethodBeat.o(77965);
    return bool;
  }
  
  static Context getContext()
  {
    AppMethodBeat.i(77964);
    Context localContext = ah.getContext();
    AppMethodBeat.o(77964);
    return localContext;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(77963);
    if (paramBoolean)
    {
      ab.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      com.tencent.mm.kernel.g.RL().Ru().set(90113, Boolean.TRUE);
    }
    try
    {
      String str = r.Zn();
      d locald = acQ();
      d.F(str, false);
      d.F(str, true);
      locald.e(str, null);
      this.fsI.ag(10000L, 10000L);
      b.a(new com.tencent.mm.plugin.avatar.a(), new String[] { "//avatar" });
      AppMethodBeat.o(77963);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(77962);
    this.fsI.stopTimer();
    if (adf().fsF != null) {
      d.reset();
    }
    Object localObject = adf().fsG;
    if (localObject != null) {
      com.tencent.mm.kernel.g.Rc().b(123, (com.tencent.mm.ai.f)localObject);
    }
    localObject = adf().fsE;
    if (localObject != null) {
      ((i)localObject).fso.clear();
    }
    b.N(new String[] { "//avatar" });
    AppMethodBeat.o(77962);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.o
 * JD-Core Version:    0.7.0.1
 */