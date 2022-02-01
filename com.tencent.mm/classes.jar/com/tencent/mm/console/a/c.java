package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.DatabaseErrorHandler;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20174);
    b.a(new c(), new String[] { "//fts" });
    AppMethodBeat.o(20174);
  }
  
  private static void D(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20173);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(2131099746));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165498);
    localTextView.setPadding(i, i, i, i);
    h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(20173);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20172);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(20172);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20172);
      return true;
    }
    paramString = paramArrayOfString[1];
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20172);
      return true;
      if (!paramString.equals("msbiz")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("deletedb")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("copydb")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("corrupt")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("setcorrupttime")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("addchatroomcontact")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("clearconfig")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("info")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("insert")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("clearunread")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("inserttest")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("dismisskey")) {
        break;
      }
      i = 11;
      break;
      paramString = am.fYi();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.oTA.iterator();
      while (paramString.hasNext())
      {
        localObject = (crg)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { com.tencent.mm.model.aa.getDisplayName(((crg)localObject).Username), Double.valueOf(((crg)localObject).Mww), f.formatTime("yyyy-MM-dd HH:mm", ((crg)localObject).Mwx / 1000L) }));
        paramArrayOfString.append("\n");
      }
      D(paramContext, paramArrayOfString.toString());
      continue;
      bg.aVF();
      paramContext = new o(com.tencent.mm.model.c.azM(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.axQ(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      bg.aVF();
      paramContext = new o(com.tencent.mm.model.c.azM(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new o("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      s.nw(com.tencent.mm.vfs.aa.z(paramContext.her()), com.tencent.mm.vfs.aa.z(paramArrayOfString.her()));
      continue;
      try
      {
        ((PluginFTS)g.ah(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      g.aAi();
      g.aAh().azQ().set(ar.a.Odk, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.kXb = 65523;
      ((n)g.ah(n.class)).search(10000, paramContext);
      continue;
      paramContext = ar.a.Obp;
      paramArrayOfString = ar.a.Obq;
      paramString = ar.a.Obr;
      Object localObject = ar.a.Obs;
      ar.a locala1 = ar.a.Obt;
      ar.a locala2 = ar.a.Obu;
      ar.a locala3 = ar.a.Obv;
      ar.a locala4 = ar.a.Obw;
      ar.a locala5 = ar.a.Obx;
      ar.a locala6 = ar.a.Oby;
      ar.a locala7 = ar.a.Obz;
      ar.a locala8 = ar.a.ObA;
      ar.a locala9 = ar.a.ObB;
      ar.a locala10 = ar.a.ObC;
      ar.a locala11 = ar.a.ObD;
      ar.a locala12 = ar.a.ObE;
      ar.a locala13 = ar.a.ObF;
      ar.a locala14 = ar.a.ObG;
      ar.a locala15 = ar.a.ObH;
      ar.a locala16 = ar.a.ObI;
      ar.a locala17 = ar.a.ObJ;
      ar.a locala18 = ar.a.ObK;
      ar.a locala19 = ar.a.ObL;
      ar.a locala20 = ar.a.ObM;
      ar.a locala21 = ar.a.ObN;
      ar.a locala22 = ar.a.ObO;
      i = 0;
      while (i < 26)
      {
        ar.a locala23 = new ar.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new o(com.tencent.mm.plugin.fts.a.c.wUX, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        D(paramContext, s.boY(com.tencent.mm.vfs.aa.z(paramArrayOfString.her())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.kXb = 65521;
      paramContext.wWW = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.wWW = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1207:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.ah(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.kXb = 65524;
        ((n)g.ah(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.kXb = 65525;
        ((n)g.ah(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        g.aAi();
        g.aAh().azQ().set(ar.a.Odm, paramContext);
        paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramArrayOfString = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.axQ(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      catch (Exception paramString)
      {
        break label1207;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */