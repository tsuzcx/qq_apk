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
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
    localTextView.setTextColor(paramContext.getResources().getColor(2131099732));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165480);
    localTextView.setPadding(i, i, i, i);
    h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(20173);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20172);
    if (ae.getLogLevel() > 1)
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
      paramString = ah.ePV();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.nIE.iterator();
      while (paramString.hasNext())
      {
        localObject = (cce)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { com.tencent.mm.model.w.zP(((cce)localObject).Username), Double.valueOf(((cce)localObject).Hpb), i.formatTime("yyyy-MM-dd HH:mm", ((cce)localObject).Hpc / 1000L) }));
        paramArrayOfString.append("\n");
      }
      D(paramContext, paramArrayOfString.toString());
      continue;
      bc.aCg();
      paramContext = new k(com.tencent.mm.model.c.ajw(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahE(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      bc.aCg();
      paramContext = new k(com.tencent.mm.model.c.ajw(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new k("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      o.mF(com.tencent.mm.vfs.w.B(paramContext.fTh()), com.tencent.mm.vfs.w.B(paramArrayOfString.fTh()));
      continue;
      try
      {
        ((PluginFTS)g.ad(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      g.ajS();
      g.ajR().ajA().set(am.a.IUS, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.jUf = 65523;
      ((n)g.ad(n.class)).search(10000, paramContext);
      continue;
      paramContext = am.a.ITb;
      paramArrayOfString = am.a.ITc;
      paramString = am.a.ITd;
      Object localObject = am.a.ITe;
      am.a locala1 = am.a.ITf;
      am.a locala2 = am.a.ITg;
      am.a locala3 = am.a.ITh;
      am.a locala4 = am.a.ITi;
      am.a locala5 = am.a.ITj;
      am.a locala6 = am.a.ITk;
      am.a locala7 = am.a.ITl;
      am.a locala8 = am.a.ITm;
      am.a locala9 = am.a.ITn;
      am.a locala10 = am.a.ITo;
      am.a locala11 = am.a.ITp;
      am.a locala12 = am.a.ITq;
      am.a locala13 = am.a.ITr;
      am.a locala14 = am.a.ITs;
      am.a locala15 = am.a.ITt;
      am.a locala16 = am.a.ITu;
      am.a locala17 = am.a.ITv;
      am.a locala18 = am.a.ITw;
      am.a locala19 = am.a.ITx;
      am.a locala20 = am.a.ITy;
      am.a locala21 = am.a.ITz;
      am.a locala22 = am.a.ITA;
      i = 0;
      while (i < 26)
      {
        am.a locala23 = new am.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new k(com.tencent.mm.plugin.fts.a.c.tDY, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        D(paramContext, o.aZT(com.tencent.mm.vfs.w.B(paramArrayOfString.fTh())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.jUf = 65521;
      paramContext.tFX = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.tFX = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1207:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jUf = 65524;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jUf = 65525;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        g.ajS();
        g.ajR().ajA().set(am.a.IUU, paramContext);
        paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramArrayOfString = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahE(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
      catch (Exception paramString)
      {
        break label1207;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */