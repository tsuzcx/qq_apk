package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import com.tencent.wcdb.DatabaseErrorHandler;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements a
{
  static
  {
    AppMethodBeat.i(16127);
    com.tencent.mm.pluginsdk.cmd.b.a(new b(), new String[] { "//fts" });
    AppMethodBeat.o(16127);
  }
  
  private static void E(Context paramContext, String paramString)
  {
    AppMethodBeat.i(16126);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16711936);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131427772);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(16126);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16125);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16125);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16125);
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
      AppMethodBeat.o(16125);
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
      paramString = ai.cZA();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.jJv.iterator();
      while (paramString.hasNext())
      {
        localObject = (bfh)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { s.nE(((bfh)localObject).Username), Double.valueOf(((bfh)localObject).xuw), com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm", ((bfh)localObject).xux / 1000L) }));
        paramArrayOfString.append("\n");
      }
      E(paramContext, paramArrayOfString.toString());
      continue;
      aw.aaz();
      paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Rp(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      Process.killProcess(Process.myPid());
      continue;
      aw.aaz();
      paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Rp(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new com.tencent.mm.vfs.b("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      com.tencent.mm.vfs.e.C(j.p(paramContext.dQJ()), j.p(paramArrayOfString.dQJ()));
      continue;
      try
      {
        ((PluginFTS)g.G(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.CommandTestFTS", paramContext, "corrupt command", new Object[0]);
      }
      continue;
      g.RM();
      g.RL().Ru().set(ac.a.yHr, Integer.valueOf(3));
      continue;
      paramContext = new i();
      paramContext.query = paramArrayOfString[2];
      paramContext.hdl = 65523;
      ((n)g.G(n.class)).search(10000, paramContext);
      continue;
      paramContext = ac.a.yFN;
      paramArrayOfString = ac.a.yFO;
      paramString = ac.a.yFP;
      Object localObject = ac.a.yFQ;
      ac.a locala1 = ac.a.yFR;
      ac.a locala2 = ac.a.yFS;
      ac.a locala3 = ac.a.yFT;
      ac.a locala4 = ac.a.yFU;
      ac.a locala5 = ac.a.yFV;
      ac.a locala6 = ac.a.yFW;
      ac.a locala7 = ac.a.yFX;
      ac.a locala8 = ac.a.yFY;
      ac.a locala9 = ac.a.yFZ;
      ac.a locala10 = ac.a.yGa;
      ac.a locala11 = ac.a.yGb;
      ac.a locala12 = ac.a.yGc;
      ac.a locala13 = ac.a.yGd;
      ac.a locala14 = ac.a.yGe;
      ac.a locala15 = ac.a.yGf;
      ac.a locala16 = ac.a.yGg;
      ac.a locala17 = ac.a.yGh;
      ac.a locala18 = ac.a.yGi;
      ac.a locala19 = ac.a.yGj;
      ac.a locala20 = ac.a.yGk;
      ac.a locala21 = ac.a.yGl;
      ac.a locala22 = ac.a.yGm;
      i = 0;
      while (i < 26)
      {
        ac.a locala23 = new ac.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mQV, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        E(paramContext, com.tencent.mm.vfs.e.cS(j.p(paramArrayOfString.dQJ())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new i();
      paramContext.hdl = 65521;
      paramContext.mSR = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.mSR = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1101:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.G(n.class)).search(10000, paramContext);
        continue;
        paramContext = new i();
        paramContext.hdl = 65524;
        ((n)g.G(n.class)).search(10000, paramContext);
        continue;
        paramContext = new i();
        paramContext.hdl = 65525;
        ((n)g.G(n.class)).search(10000, paramContext);
      }
      catch (Exception paramString)
      {
        break label1101;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.b
 * JD-Core Version:    0.7.0.1
 */