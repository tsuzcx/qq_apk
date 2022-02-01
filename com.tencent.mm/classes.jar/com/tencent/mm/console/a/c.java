package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.q;
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
    if (ad.getLogLevel() > 1)
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
      paramString = ah.eMm();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.nDj.iterator();
      while (paramString.hasNext())
      {
        localObject = (cbk)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { v.zf(((cbk)localObject).Username), Double.valueOf(((cbk)localObject).GVA), com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm", ((cbk)localObject).GVB / 1000L) }));
        paramArrayOfString.append("\n");
      }
      D(paramContext, paramArrayOfString.toString());
      continue;
      ba.aBQ();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.ajh(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahp(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      ba.aBQ();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.ajh(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new com.tencent.mm.vfs.e("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      com.tencent.mm.vfs.i.mz(q.B(paramContext.fOK()), q.B(paramArrayOfString.fOK()));
      continue;
      try
      {
        ((PluginFTS)g.ad(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      g.ajD();
      g.ajC().ajl().set(al.a.IAt, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.jQN = 65523;
      ((n)g.ad(n.class)).search(10000, paramContext);
      continue;
      paramContext = al.a.IyD;
      paramArrayOfString = al.a.IyE;
      paramString = al.a.IyF;
      Object localObject = al.a.IyG;
      al.a locala1 = al.a.IyH;
      al.a locala2 = al.a.IyI;
      al.a locala3 = al.a.IyJ;
      al.a locala4 = al.a.IyK;
      al.a locala5 = al.a.IyL;
      al.a locala6 = al.a.IyM;
      al.a locala7 = al.a.IyN;
      al.a locala8 = al.a.IyO;
      al.a locala9 = al.a.IyP;
      al.a locala10 = al.a.IyQ;
      al.a locala11 = al.a.IyR;
      al.a locala12 = al.a.IyS;
      al.a locala13 = al.a.IyT;
      al.a locala14 = al.a.IyU;
      al.a locala15 = al.a.IyV;
      al.a locala16 = al.a.IyW;
      al.a locala17 = al.a.IyX;
      al.a locala18 = al.a.IyY;
      al.a locala19 = al.a.IyZ;
      al.a locala20 = al.a.Iza;
      al.a locala21 = al.a.Izb;
      al.a locala22 = al.a.Izc;
      i = 0;
      while (i < 26)
      {
        al.a locala23 = new al.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fts.a.c.tth, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        D(paramContext, com.tencent.mm.vfs.i.aYq(q.B(paramArrayOfString.fOK())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.jQN = 65521;
      paramContext.tvg = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.tvg = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1207:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jQN = 65524;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jQN = 65525;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        g.ajD();
        g.ajC().ajl().set(al.a.IAv, paramContext);
        paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramArrayOfString = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahp(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramContext.mq(0)).intValue());
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