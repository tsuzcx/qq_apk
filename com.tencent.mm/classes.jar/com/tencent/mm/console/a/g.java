package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.y;
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
    b.a(new g(), new String[] { "//disablesfs", "//exportsfs", "//sfsstat" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    Object localObject = paramArrayOfString[0];
    switch (((String)localObject).hashCode())
    {
    default: 
      label44:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (!((String)localObject).equals("//disablesfs")) {
          break label44;
        }
        i = 0;
        continue;
        if (!((String)localObject).equals("//exportsfs")) {
          break label44;
        }
        i = 1;
        continue;
        if (!((String)localObject).equals("//sfsstat")) {
          break label44;
        }
        i = 2;
      }
    }
    localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs");
    try
    {
      if ((paramArrayOfString.length > 0) && (!paramArrayOfString[1].equals("0"))) {
        ((File)localObject).createNewFile();
      }
      for (;;)
      {
        paramArrayOfString = new StringBuilder("Use SFS: ");
        if (((File)localObject).exists()) {
          break;
        }
        bool = true;
        Toast.makeText(paramContext, Boolean.toString(bool), 0).show();
        return true;
        ((File)localObject).delete();
      }
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SFSCommand", paramArrayOfString, "Failed to operate flag file.", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
    if (paramArrayOfString.length <= 1) {
      return false;
    }
    paramArrayOfString = paramArrayOfString[1];
    FileOp.mQ(paramArrayOfString);
    Toast.makeText(paramContext, paramArrayOfString, 0).show();
    return true;
    long l1 = System.currentTimeMillis();
    localObject = FileOp.Qb();
    paramArrayOfString = new StringBuilder(8192);
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramArrayOfString.append("===== ").append((String)localEntry.getKey()).append(" =====\n").append(((SFSContext.Statistics)localEntry.getValue()).toString()).append("\n\n");
    }
    long l2 = System.currentTimeMillis();
    paramArrayOfString.append("elapsed: ").append(l2 - l1).append(" ms");
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(paramArrayOfString);
    ((TextView)localObject).setGravity(8388627);
    ((TextView)localObject).setTextSize(1, 10.0F);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ((TextView)localObject).setTextColor(-16744704);
    ((TextView)localObject).setTypeface(Typeface.MONOSPACE);
    ((TextView)localObject).setMovementMethod(new ScrollingMovementMethod());
    int i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
    ((TextView)localObject).setPadding(i, i, i, i);
    h.a(paramContext, null, (View)localObject, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.g
 * JD-Core Version:    0.7.0.1
 */