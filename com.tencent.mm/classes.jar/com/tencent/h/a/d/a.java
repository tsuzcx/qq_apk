package com.tencent.h.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.g.c.d;
import com.tencent.g.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a
{
  private String ZUU;
  
  public static List<File> bEb(String paramString)
  {
    AppMethodBeat.i(207746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207746);
      return null;
    }
    paramString = bEc(paramString);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(207746);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((TextUtils.isEmpty(null)) || (localObject.getName().startsWith(null))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(207746);
    return localArrayList;
  }
  
  public static File[] bEc(String paramString)
  {
    AppMethodBeat.i(207747);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(207747);
      return null;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs()))
    {
      AppMethodBeat.o(207747);
      return null;
    }
    paramString = paramString.listFiles();
    AppMethodBeat.o(207747);
    return paramString;
  }
  
  public static File j(File paramFile, String paramString)
  {
    AppMethodBeat.i(207743);
    if (paramFile == null)
    {
      AppMethodBeat.o(207743);
      return null;
    }
    paramFile = new File(paramFile.getAbsolutePath() + File.separator + paramString);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      AppMethodBeat.o(207743);
      return null;
    }
    AppMethodBeat.o(207743);
    return paramFile;
  }
  
  public static boolean oN(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(207744);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(207744);
      return false;
    }
    paramString1 = bEc(paramString1);
    if ((paramString1 == null) || (paramString1.length <= 0))
    {
      AppMethodBeat.o(207744);
      return false;
    }
    int j = paramString1.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString1[i].getName().startsWith(paramString2)) {
          bool1 = true;
        }
      }
      else
      {
        AppMethodBeat.o(207744);
        return bool1;
      }
      i += 1;
    }
  }
  
  public final File mt(Context paramContext)
  {
    AppMethodBeat.i(207742);
    if (paramContext == null)
    {
      AppMethodBeat.o(207742);
      return null;
    }
    if (TextUtils.isEmpty(this.ZUU)) {
      this.ZUU = d.U(d.ZRA);
    }
    if (TextUtils.isEmpty(this.ZUU))
    {
      AppMethodBeat.o(207742);
      return null;
    }
    i.d("Persistence", "dir : " + this.ZUU);
    paramContext = paramContext.getDir(this.ZUU, 0);
    AppMethodBeat.o(207742);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.d.a
 * JD-Core Version:    0.7.0.1
 */