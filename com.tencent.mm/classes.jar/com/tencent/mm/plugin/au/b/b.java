package com.tencent.mm.plugin.au.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vibrate/manager/VibrationManager;", "", "()V", "TAG", "", "vibrateFilePath", "vibrateRootPath", "checkCurrentDeviceNotAllowToUseFunnyVibrate", "", "checkCurrentPreviewCanVibrate", "vibrateDescInfo", "Lcom/tencent/mm/plugin/ringtoneapi/api/VibrateDescInfo;", "checkCurrentPreviewSupportFunnyVibrate", "checkVoIPSupportFunnyVibrate", "copyVibrate", "", "downloadVibrateFile", "url", "fileName", "getCurrentRingtoneVibrate", "getDefaultPath", "getDefaultVibrate", "plugin-vibrate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b TWR;
  private static final String TWS;
  private static final String TWT;
  
  static
  {
    AppMethodBeat.i(260735);
    TWR = new b();
    String str = s.X(com.tencent.mm.loader.i.b.bmq(), "app_vibrate");
    TWS = str;
    TWT = s.X(str, "/");
    AppMethodBeat.o(260735);
  }
  
  public static final boolean a(a parama)
  {
    AppMethodBeat.i(260717);
    s.u(parama, "vibrateDescInfo");
    if (s.p(parama.fileUrl, "phonering.HE")) {}
    for (parama = new u(String.valueOf(aUr("phonering.HE"))); (hQf()) && (parama.jKS()); parama = new u(TWT + parama.fileName + ".HE"))
    {
      AppMethodBeat.o(260717);
      return true;
    }
    AppMethodBeat.o(260717);
    return false;
  }
  
  private static String aUr(String paramString)
  {
    AppMethodBeat.i(260721);
    s.u(paramString, "fileName");
    if (!new u(s.X(TWT, paramString)).jKS()) {
      hQi();
    }
    paramString = ah.v(new u(s.X(TWT, paramString)).jKT());
    s.s(paramString, "file.absolutePath");
    AppMethodBeat.o(260721);
    return paramString;
  }
  
  public static final boolean hQf()
  {
    AppMethodBeat.i(260686);
    i locali = i.agtt;
    if (i.a(b.a.agsS, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsS, 0) == 1)
      {
        AppMethodBeat.o(260686);
        return true;
      }
      AppMethodBeat.o(260686);
      return false;
    }
    if (hQg())
    {
      AppMethodBeat.o(260686);
      return false;
    }
    boolean bool = ((c)h.ax(c.class)).a(c.a.ySe, true);
    AppMethodBeat.o(260686);
    return bool;
  }
  
  private static boolean hQg()
  {
    AppMethodBeat.i(260696);
    String str = ((c)h.ax(c.class)).a(c.a.ySg, "");
    if (str != null)
    {
      int i;
      if (((CharSequence)str).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label123;
        }
        if (n.bp((CharSequence)str)) {
          break label118;
        }
        i = 1;
        label58:
        if (i == 0) {
          break label123;
        }
        i = 1;
        label64:
        if (i == 0) {
          break label128;
        }
      }
      for (;;)
      {
        if (str != null)
        {
          if (n.a((CharSequence)str, new char[] { n.bx((CharSequence)str) }, 0, 6).contains(d.Yxf))
          {
            AppMethodBeat.o(260696);
            return true;
            i = 0;
            break;
            label118:
            i = 0;
            break label58;
            label123:
            i = 0;
            break label64;
            label128:
            str = null;
            continue;
          }
          AppMethodBeat.o(260696);
          return false;
        }
      }
    }
    AppMethodBeat.o(260696);
    return false;
  }
  
  public static final boolean hQh()
  {
    AppMethodBeat.i(260705);
    i locali = i.agtt;
    if (i.a(b.a.agsS, 0) != 0)
    {
      locali = i.agtt;
      if (i.a(b.a.agsS, 0) == 1)
      {
        AppMethodBeat.o(260705);
        return true;
      }
      AppMethodBeat.o(260705);
      return false;
    }
    if (hQg())
    {
      AppMethodBeat.o(260705);
      return false;
    }
    boolean bool = ((c)h.ax(c.class)).a(c.a.ySf, false);
    AppMethodBeat.o(260705);
    return bool;
  }
  
  private static void hQi()
  {
    AppMethodBeat.i(260732);
    u localu = new u(TWT);
    if (localu.jKV()) {
      localu.diJ();
    }
    if (!localu.jKS()) {
      localu.jKY();
    }
    long l = System.currentTimeMillis();
    y.O("assets:///phonering.HE", s.X(TWT, "phonering.HE"), false);
    Log.d("MicroMsg.VibrationManager", "copyVibrate. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(260732);
  }
  
  public static final String nq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260729);
    s.u(paramString1, "url");
    s.u(paramString2, "fileName");
    if (s.p(paramString1, "phonering.HE"))
    {
      paramString1 = aUr("phonering.HE");
      AppMethodBeat.o(260729);
      return paramString1;
    }
    if (!new u(TWT + paramString2 + ".HE").jKS())
    {
      s.u(paramString1, "url");
      s.u(paramString2, "fileName");
      if (!new u(s.X(TWS, paramString1)).jKS()) {
        hQi();
      }
      g.a locala = new g.a();
      locala.nC(true);
      locala.setAppId(s.X("vibrate_", paramString2));
      locala.amR(paramString1);
      locala.JA(0);
      locala.amV(TWT + paramString2 + ".HE");
      locala.nA(false);
      locala.nB(false);
      locala.amT(s.X(paramString2, ".HE"));
      f.duv().b(locala.xoe);
    }
    paramString1 = ah.v(new u(TWT + paramString2 + ".HE").jKT());
    s.s(paramString1, "file.absolutePath");
    AppMethodBeat.o(260729);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.au.b.b
 * JD-Core Version:    0.7.0.1
 */