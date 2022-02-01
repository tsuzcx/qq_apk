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
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  
  private static void K(Context paramContext, String paramString)
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
    k.a(paramContext, null, localTextView, null);
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
      paramString = an.iqf();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.vgO.iterator();
      while (paramString.hasNext())
      {
        localObject = (dre)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { aa.getDisplayName(((dre)localObject).Username), Double.valueOf(((dre)localObject).aaXd), com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm", ((dre)localObject).aaXe / 1000L) }));
        paramArrayOfString.append("\n");
      }
      K(paramContext, paramArrayOfString.toString());
      continue;
      bh.bCz();
      paramContext = new u(com.tencent.mm.model.c.baj(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.jKS()) {
        paramContext.diJ();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aYi(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      bh.bCz();
      paramContext = new u(com.tencent.mm.model.c.baj(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new u("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.jKS()) {
        paramArrayOfString.diJ();
      }
      y.O(ah.v(paramContext.jKT()), ah.v(paramArrayOfString.jKT()), false);
      continue;
      try
      {
        ((PluginFTS)h.az(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      h.baF();
      h.baE().ban().set(at.a.acSY, Integer.valueOf(5));
      continue;
      paramContext = new l();
      paramContext.query = paramArrayOfString[2];
      paramContext.qRb = 65523;
      ((n)h.az(n.class)).search(10000, paramContext);
      continue;
      paramContext = at.a.acQU;
      paramArrayOfString = at.a.acQV;
      paramString = at.a.acQW;
      Object localObject = at.a.acQX;
      at.a locala1 = at.a.acQY;
      at.a locala2 = at.a.acQZ;
      at.a locala3 = at.a.acRa;
      at.a locala4 = at.a.acRb;
      at.a locala5 = at.a.acRc;
      at.a locala6 = at.a.acRd;
      at.a locala7 = at.a.acRe;
      at.a locala8 = at.a.acRf;
      at.a locala9 = at.a.acRg;
      at.a locala10 = at.a.acRh;
      at.a locala11 = at.a.acRi;
      at.a locala12 = at.a.acRj;
      at.a locala13 = at.a.acRk;
      at.a locala14 = at.a.acRl;
      at.a locala15 = at.a.acRm;
      at.a locala16 = at.a.acRn;
      at.a locala17 = at.a.acRo;
      at.a locala18 = at.a.acRp;
      at.a locala19 = at.a.acRq;
      at.a locala20 = at.a.acRr;
      at.a locala21 = at.a.acRs;
      at.a locala22 = at.a.acRt;
      i = 0;
      while (i < 26)
      {
        at.a locala23 = new at.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        bh.bCz();
        com.tencent.mm.model.c.ban().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new u(com.tencent.mm.plugin.fts.a.c.Hrx, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.jKS()) {
        continue;
      }
      try
      {
        K(paramContext, y.bEn(ah.v(paramArrayOfString.jKT())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new l();
      paramContext.qRb = 65521;
      paramContext.Htz = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.Htz = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1208:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)h.az(n.class)).search(10000, paramContext);
        continue;
        paramContext = new l();
        paramContext.qRb = 65524;
        ((n)h.az(n.class)).search(10000, paramContext);
        continue;
        paramContext = new l();
        paramContext.qRb = 65525;
        ((n)h.az(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        h.baF();
        h.baE().ban().set(at.a.acTa, paramContext);
        paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramArrayOfString = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aYi(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      catch (Exception paramString)
      {
        break label1208;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */