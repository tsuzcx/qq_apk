package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  
  private static void F(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20173);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(R.e.FG_0));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
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
      paramString = am.gQT();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.rVy.iterator();
      while (paramString.hasNext())
      {
        localObject = (czx)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { aa.PJ(((czx)localObject).Username), Double.valueOf(((czx)localObject).THu), com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm", ((czx)localObject).THv / 1000L) }));
        paramArrayOfString.append("\n");
      }
      F(paramContext, paramArrayOfString.toString());
      continue;
      bh.beI();
      paramContext = new q(com.tencent.mm.model.c.aHl(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.ifE()) {
        paramContext.cFq();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aFh(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      bh.beI();
      paramContext = new q(com.tencent.mm.model.c.aHl(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new q("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.ifE()) {
        paramArrayOfString.cFq();
      }
      u.on(paramContext.bOF(), paramArrayOfString.bOF());
      continue;
      try
      {
        ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vru, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.nRn = 65523;
      ((n)com.tencent.mm.kernel.h.ag(n.class)).search(10000, paramContext);
      continue;
      paramContext = ar.a.Vps;
      paramArrayOfString = ar.a.Vpt;
      paramString = ar.a.Vpu;
      Object localObject = ar.a.Vpv;
      ar.a locala1 = ar.a.Vpw;
      ar.a locala2 = ar.a.Vpx;
      ar.a locala3 = ar.a.Vpy;
      ar.a locala4 = ar.a.Vpz;
      ar.a locala5 = ar.a.VpA;
      ar.a locala6 = ar.a.VpB;
      ar.a locala7 = ar.a.VpC;
      ar.a locala8 = ar.a.VpD;
      ar.a locala9 = ar.a.VpE;
      ar.a locala10 = ar.a.VpF;
      ar.a locala11 = ar.a.VpG;
      ar.a locala12 = ar.a.VpH;
      ar.a locala13 = ar.a.VpI;
      ar.a locala14 = ar.a.VpJ;
      ar.a locala15 = ar.a.VpK;
      ar.a locala16 = ar.a.VpL;
      ar.a locala17 = ar.a.VpM;
      ar.a locala18 = ar.a.VpN;
      ar.a locala19 = ar.a.VpO;
      ar.a locala20 = ar.a.VpP;
      ar.a locala21 = ar.a.VpQ;
      ar.a locala22 = ar.a.VpR;
      i = 0;
      while (i < 26)
      {
        ar.a locala23 = new ar.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        bh.beI();
        com.tencent.mm.model.c.aHp().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new q(com.tencent.mm.plugin.fts.a.c.BGT, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.ifE()) {
        continue;
      }
      try
      {
        F(paramContext, u.bBS(paramArrayOfString.bOF()));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.nRn = 65521;
      paramContext.BIR = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.BIR = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1198:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)com.tencent.mm.kernel.h.ag(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.nRn = 65524;
        ((n)com.tencent.mm.kernel.h.ag(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.nRn = 65525;
        ((n)com.tencent.mm.kernel.h.ag(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrw, paramContext);
        paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramArrayOfString = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aFh(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      catch (Exception paramString)
      {
        break label1198;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */