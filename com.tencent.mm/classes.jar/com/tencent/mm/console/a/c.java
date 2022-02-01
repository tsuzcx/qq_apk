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
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
    localTextView.setTextColor(ao.aD(paramContext, 2130968584));
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
      paramString = af.eib();
      paramArrayOfString = new StringBuilder();
      paramString = paramString.mAL.iterator();
      while (paramString.hasNext())
      {
        localObject = (bsd)paramString.next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { v.sh(((bsd)localObject).Username), Double.valueOf(((bsd)localObject).DPA), com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm", ((bsd)localObject).DPB / 1000L) }));
        paramArrayOfString.append("\n");
      }
      E(paramContext, paramArrayOfString.toString());
      continue;
      az.arV();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.aff(), "FTS5IndexMicroMsg_encrypt.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      Process.killProcess(Process.myPid());
      continue;
      az.arV();
      paramContext = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.aff(), "FTS5IndexMicroMsg_encrypt.db");
      paramArrayOfString = new com.tencent.mm.vfs.e("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      i.lC(q.B(paramContext.fhU()), q.B(paramArrayOfString.fhU()));
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
      g.afC();
      g.afB().afk().set(ae.a.Fqi, Integer.valueOf(5));
      continue;
      paramContext = new j();
      paramContext.query = paramArrayOfString[2];
      paramContext.iWB = 65523;
      ((n)g.ad(n.class)).search(10000, paramContext);
      continue;
      paramContext = ae.a.Fow;
      paramArrayOfString = ae.a.Fox;
      paramString = ae.a.Foy;
      Object localObject = ae.a.Foz;
      ae.a locala1 = ae.a.FoA;
      ae.a locala2 = ae.a.FoB;
      ae.a locala3 = ae.a.FoC;
      ae.a locala4 = ae.a.FoD;
      ae.a locala5 = ae.a.FoE;
      ae.a locala6 = ae.a.FoF;
      ae.a locala7 = ae.a.FoG;
      ae.a locala8 = ae.a.FoH;
      ae.a locala9 = ae.a.FoI;
      ae.a locala10 = ae.a.FoJ;
      ae.a locala11 = ae.a.FoK;
      ae.a locala12 = ae.a.FoL;
      ae.a locala13 = ae.a.FoM;
      ae.a locala14 = ae.a.FoN;
      ae.a locala15 = ae.a.FoO;
      ae.a locala16 = ae.a.FoP;
      ae.a locala17 = ae.a.FoQ;
      ae.a locala18 = ae.a.FoR;
      ae.a locala19 = ae.a.FoS;
      ae.a locala20 = ae.a.FoT;
      ae.a locala21 = ae.a.FoU;
      ae.a locala22 = ae.a.FoV;
      i = 0;
      while (i < 26)
      {
        ae.a locala23 = new ae.a[] { paramContext, paramArrayOfString, paramString, localObject, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        az.arV();
        com.tencent.mm.model.c.afk().set(locala23, "");
        i += 1;
      }
      paramArrayOfString = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fts.a.c.rnM, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        E(paramContext, i.aMP(q.B(paramArrayOfString.fhU())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new j();
      paramContext.iWB = 65521;
      paramContext.rpL = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.rpL = Integer.valueOf(paramArrayOfString[2]).intValue();
        label1129:
        if (paramArrayOfString.length > 3) {
          paramContext.talker = paramArrayOfString[3];
        }
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.iWB = 65524;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = new j();
        paramContext.iWB = 65525;
        ((n)g.ad(n.class)).search(10000, paramContext);
        continue;
        paramContext = "test_key_" + System.currentTimeMillis();
        g.afC();
        g.afB().afk().set(ae.a.Fqk, paramContext);
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