package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.media.AudioManager;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final Set<String> ebp;
  static final Time ebr;
  public boolean ebq;
  
  static
  {
    AppMethodBeat.i(16023);
    HashSet localHashSet = new HashSet();
    ebp = localHashSet;
    localHashSet.add("readerapp");
    ebp.add("blogapp");
    ebp.add("newsapp");
    ebr = new Time();
    AppMethodBeat.o(16023);
  }
  
  public static boolean IT()
  {
    AppMethodBeat.i(16014);
    ebr.setToNow();
    int i = ebr.hour;
    int j = ebr.minute;
    ah.getContext();
    if (!com.tencent.mm.m.a.bX(i, j))
    {
      ab.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
      AppMethodBeat.o(16014);
      return true;
    }
    AppMethodBeat.o(16014);
    return false;
  }
  
  public static boolean IU()
  {
    AppMethodBeat.i(16015);
    boolean bool = f.MB();
    ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(16015);
    return bool;
  }
  
  public static boolean IV()
  {
    boolean bool2 = true;
    AppMethodBeat.i(16018);
    try
    {
      ux localux = new ux();
      localux.cLs.cut = 2;
      com.tencent.mm.sdk.b.a.ymk.l(localux);
      bool1 = localux.cLt.cLu;
      if (!bool1)
      {
        ab.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", new Object[] { Boolean.valueOf(bool2) });
        AppMethodBeat.o(16018);
        return bool1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Notification.Silent.Handle", localException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static boolean IW()
  {
    AppMethodBeat.i(16020);
    boolean bool = f.MD();
    int i = IX();
    if (i == 0) {
      bool = false;
    }
    ab.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(16020);
    return bool;
  }
  
  public static int IX()
  {
    AppMethodBeat.i(16021);
    int i = ((AudioManager)ah.getContext().getSystemService("audio")).getRingerMode();
    AppMethodBeat.o(16021);
    return i;
  }
  
  public static boolean a(String paramString, bi parambi)
  {
    boolean bool2 = true;
    AppMethodBeat.i(16017);
    boolean bool1;
    if ((f.lB(paramString)) && (!f.i(parambi)))
    {
      bool1 = true;
      if (bool1) {
        break label59;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", new Object[] { Boolean.valueOf(bool2) });
      AppMethodBeat.o(16017);
      return bool1;
      bool1 = false;
      break;
      label59:
      bool2 = false;
    }
  }
  
  public static boolean a(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfBoolean[0] &= paramBoolean;
      paramArrayOfBoolean[1] &= paramBoolean;
      return bool;
    }
  }
  
  public static boolean a(boolean[] paramArrayOfBoolean, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfBoolean[0] &= paramBoolean1;
      paramArrayOfBoolean[1] &= paramBoolean2;
      return bool;
    }
  }
  
  public static boolean iq(int paramInt)
  {
    AppMethodBeat.i(16016);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(16016);
      return bool;
    }
  }
  
  public static boolean ir(int paramInt)
  {
    AppMethodBeat.i(16022);
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(16022);
      return bool;
    }
  }
  
  public static boolean kG(String paramString)
  {
    AppMethodBeat.i(16012);
    if (aj.apm("keep_chatting_silent".concat(String.valueOf(paramString))))
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
      AppMethodBeat.o(16012);
      return true;
    }
    ab.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
    AppMethodBeat.o(16012);
    return false;
  }
  
  public static boolean kH(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(16013);
    boolean bool2 = ebp.contains(paramString);
    if (!bool2) {}
    for (;;)
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", new Object[] { Boolean.valueOf(bool1) });
      AppMethodBeat.o(16013);
      return bool2;
      bool1 = false;
    }
  }
  
  public static boolean o(int paramInt, String paramString)
  {
    AppMethodBeat.i(16019);
    boolean bool;
    if (f.iX(paramInt)) {
      if (f.lw(paramString)) {
        bool = f.No();
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(16019);
      return bool;
      if (f.lx(paramString)) {
        bool = f.Np();
      } else {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.e
 * JD-Core Version:    0.7.0.1
 */