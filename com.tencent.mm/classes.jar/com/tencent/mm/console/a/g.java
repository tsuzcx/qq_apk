package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  implements a
{
  static
  {
    AppMethodBeat.i(16137);
    b.a(new g(), new String[] { "//disablesfs", "//exportsfs", "//sfsstat" });
    AppMethodBeat.o(16137);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16136);
    paramString = paramArrayOfString[0];
    switch (paramString.hashCode())
    {
    default: 
      label48:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(16136);
        return false;
        if (!paramString.equals("//disablesfs")) {
          break label48;
        }
        i = 0;
        continue;
        if (!paramString.equals("//exportsfs")) {
          break label48;
        }
        i = 1;
        continue;
        if (!paramString.equals("//sfsstat")) {
          break label48;
        }
        i = 2;
      }
    }
    paramString = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs");
    try
    {
      if ((paramArrayOfString.length > 0) && (!paramArrayOfString[1].equals("0"))) {
        paramString.createNewFile();
      }
      for (;;)
      {
        paramArrayOfString = new StringBuilder("Use SFS: ");
        if (paramString.exists()) {
          break;
        }
        bool = true;
        Toast.makeText(paramContext, Boolean.toString(bool), 0).show();
        AppMethodBeat.o(16136);
        return true;
        paramString.delete();
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SFSCommand", paramArrayOfString, "Failed to operate flag file.", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(16136);
      return false;
    }
    paramArrayOfString = paramArrayOfString[1];
    FileOp.ua(paramArrayOfString);
    Toast.makeText(paramContext, paramArrayOfString, 0).show();
    AppMethodBeat.o(16136);
    return true;
    long l1 = System.currentTimeMillis();
    paramString = FileOp.ajh();
    paramArrayOfString = new StringBuilder(8192);
    paramString = paramString.entrySet().iterator();
    while (paramString.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramString.next();
      paramArrayOfString.append("===== ").append((String)localEntry.getKey()).append(" =====\n").append(((SFSContext.Statistics)localEntry.getValue()).toString()).append("\n\n");
    }
    long l2 = System.currentTimeMillis();
    paramArrayOfString.append("elapsed: ").append(l2 - l1).append(" ms");
    paramString = new TextView(paramContext);
    paramString.setText(paramArrayOfString);
    paramString.setGravity(8388627);
    paramString.setTextSize(1, 10.0F);
    paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramString.setTextColor(-16744704);
    paramString.setTypeface(Typeface.MONOSPACE);
    paramString.setMovementMethod(new ScrollingMovementMethod());
    int i = paramContext.getResources().getDimensionPixelSize(2131427772);
    paramString.setPadding(i, i, i, i);
    h.a(paramContext, null, paramString, null);
    AppMethodBeat.o(16136);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.g
 * JD-Core Version:    0.7.0.1
 */