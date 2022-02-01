package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import com.tencent.wcdb.DatabaseErrorHandler;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  implements a
{
  static
  {
    AppMethodBeat.i(20174);
    b.a(new c(), new String[] { "//fts" });
    AppMethodBeat.o(20174);
  }
  
  private static void E(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20173);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(ao.aJ(paramContext, 2130968584));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165480);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(20173);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20172);
    if (ac.getLogLevel() > 1)
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
      paramString = ad.exv();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.ncM.iterator();
      while (paramString.hasNext())
      {
        localObject = (bwu)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { v.wk(((bwu)localObject).Username), Double.valueOf(((bwu)localObject).FlR), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm", ((bwu)localObject).FlS / 1000L) }));
        paramArrayOfString.append("\n");
      }
      E(paramContext, paramArrayOfString.toString());
      continue;
      az.ayM();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.agv(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      Process.killProcess(Process.myPid());
      continue;
      az.ayM();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.agv(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new com.tencent.mm.vfs.e("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      i.lZ(q.B(paramContext.fxV()), q.B(paramArrayOfString.fxV()));
      continue;
      try
      {
        ((PluginFTS)g.ad(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        ac.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      g.agS();
      g.agR().agA().set(ah.a.GNY, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.jwR = 65523;
      ((n)g.ad(n.class)).search(10000, paramContext);
      continue;
      paramContext = ah.a.GMl;
      paramArrayOfString = ah.a.GMm;
      paramString = ah.a.GMn;
      Object localObject = ah.a.GMo;
      ah.a locala1 = ah.a.GMp;
      ah.a locala2 = ah.a.GMq;
      ah.a locala3 = ah.a.GMr;
      ah.a locala4 = ah.a.GMs;
      ah.a locala5 = ah.a.GMt;
      ah.a locala6 = ah.a.GMu;
      ah.a locala7 = ah.a.GMv;
      ah.a locala8 = ah.a.GMw;
      ah.a locala9 = ah.a.GMx;
      ah.a locala10 = ah.a.GMy;
      ah.a locala11 = ah.a.GMz;
      ah.a locala12 = ah.a.GMA;
      ah.a locala13 = ah.a.GMB;
      ah.a locala14 = ah.a.GMC;
      ah.a locala15 = ah.a.GMD;
      ah.a locala16 = ah.a.GME;
      ah.a locala17 = ah.a.GMF;
      ah.a locala18 = ah.a.GMG;
      ah.a locala19 = ah.a.GMH;
      ah.a locala20 = ah.a.GMI;
      ah.a locala21 = ah.a.GMJ;
      ah.a locala22 = ah.a.GMK;
      i = 0;
      while (i < 26)
      {
        ah.a locala23 = new ah.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        az.ayM();
        com.tencent.mm.model.c.agA().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fts.a.c.swG, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        E(paramContext, i.aSr(q.B(paramArrayOfString.fxV())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.jwR = 65521;
      paramContext.syF = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.syF = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1129:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jwR = 65524;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.jwR = 65525;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        g.agS();
        g.agR().agA().set(ah.a.GOa, paramContext);
        Process.killProcess(Process.myPid());
      }
      catch (Exception paramString)
      {
        break label1129;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */