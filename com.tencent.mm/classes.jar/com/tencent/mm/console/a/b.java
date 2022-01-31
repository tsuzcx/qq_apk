package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements a
{
  static
  {
    com.tencent.mm.pluginsdk.cmd.b.a(new b(), new String[] { "//fts" });
  }
  
  public static void init() {}
  
  private static void z(Context paramContext, String paramString)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16711936);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
      return true;
    }
    Object localObject1 = paramArrayOfString[1];
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return true;
      if (!((String)localObject1).equals("msbiz")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("deletedb")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("copydb")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("corrupt")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject1).equals("addchatroomcontact")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject1).equals("clearconfig")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject1).equals("info")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject1).equals("insert")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject1).equals("clearunread")) {
        break;
      }
      i = 8;
      break;
      localObject1 = ai.bZE();
      paramArrayOfString = new StringBuilder();
      localObject1 = ((ayl)localObject1).hPT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ayk)((Iterator)localObject1).next();
        paramArrayOfString.append(String.format("%s | %.2f | %s", new Object[] { r.gV(((ayk)localObject2).sxM), Double.valueOf(((ayk)localObject2).tuu), com.tencent.mm.pluginsdk.f.h.g("yyyy-MM-dd HH:mm", ((ayk)localObject2).tuv / 1000L) }));
        paramArrayOfString.append("\n");
      }
      z(paramContext, paramArrayOfString.toString());
      continue;
      au.Hx();
      paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.FT(), "FTS5IndexMicroMsg.db");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      Process.killProcess(Process.myPid());
      continue;
      au.Hx();
      paramContext = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.FT(), "FTS5IndexMicroMsg.db");
      paramArrayOfString = new com.tencent.mm.vfs.b("/sdcard/IndexMicroMsg.db");
      if (paramArrayOfString.exists()) {
        paramArrayOfString.delete();
      }
      e.r(j.n(paramContext.cLr()), j.n(paramArrayOfString.cLr()));
      continue;
      paramContext = new i();
      paramContext.kwX = 65522;
      ((n)g.t(n.class)).search(10000, paramContext);
      continue;
      paramContext = new i();
      paramContext.bVk = paramArrayOfString[2];
      paramContext.kwX = 65523;
      ((n)g.t(n.class)).search(10000, paramContext);
      continue;
      paramContext = ac.a.uvF;
      paramArrayOfString = ac.a.uvG;
      localObject1 = ac.a.uvH;
      Object localObject2 = ac.a.uvI;
      ac.a locala1 = ac.a.uvJ;
      ac.a locala2 = ac.a.uvK;
      ac.a locala3 = ac.a.uvL;
      ac.a locala4 = ac.a.uvM;
      ac.a locala5 = ac.a.uvN;
      ac.a locala6 = ac.a.uvO;
      ac.a locala7 = ac.a.uvP;
      ac.a locala8 = ac.a.uvQ;
      ac.a locala9 = ac.a.uvR;
      ac.a locala10 = ac.a.uvS;
      ac.a locala11 = ac.a.uvT;
      ac.a locala12 = ac.a.uvU;
      ac.a locala13 = ac.a.uvV;
      ac.a locala14 = ac.a.uvW;
      ac.a locala15 = ac.a.uvX;
      ac.a locala16 = ac.a.uvY;
      ac.a locala17 = ac.a.uvZ;
      ac.a locala18 = ac.a.uwa;
      ac.a locala19 = ac.a.uwb;
      ac.a locala20 = ac.a.uwc;
      ac.a locala21 = ac.a.uwd;
      ac.a locala22 = ac.a.uwe;
      i = 0;
      while (i < 26)
      {
        ac.a locala23 = new ac.a[] { paramContext, paramArrayOfString, localObject1, localObject2, locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15, locala16, locala17, locala18, locala19, locala20, locala21, locala22 }[i];
        au.Hx();
        com.tencent.mm.model.c.Dz().c(locala23, "");
        i += 1;
      }
      paramArrayOfString = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.kvi, "FTS5IndexMicroMsgInfo.txt");
      if (!paramArrayOfString.exists()) {
        continue;
      }
      try
      {
        z(paramContext, e.bP(j.n(paramArrayOfString.cLr())));
      }
      catch (IOException paramContext) {}
      continue;
      paramContext = new i();
      paramContext.kwX = 65521;
      paramContext.kxc = 100;
      if (paramArrayOfString.length > 2) {}
      try
      {
        paramContext.kxc = Integer.valueOf(paramArrayOfString[2]).intValue();
        label999:
        ((n)g.t(n.class)).search(10000, paramContext);
        continue;
        paramContext = new i();
        paramContext.kwX = 65524;
        ((n)g.t(n.class)).search(10000, paramContext);
      }
      catch (Exception paramArrayOfString)
      {
        break label999;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.b
 * JD-Core Version:    0.7.0.1
 */