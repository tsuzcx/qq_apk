package com.tencent.i.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.h.c.d;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a
{
  private String Str;
  
  public static List<File> brc(String paramString)
  {
    AppMethodBeat.i(214823);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(214823);
      return null;
    }
    paramString = brd(paramString);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(214823);
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
    AppMethodBeat.o(214823);
    return localArrayList;
  }
  
  public static File[] brd(String paramString)
  {
    AppMethodBeat.i(214824);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(214824);
      return null;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs()))
    {
      AppMethodBeat.o(214824);
      return null;
    }
    paramString = paramString.listFiles();
    AppMethodBeat.o(214824);
    return paramString;
  }
  
  public static File i(File paramFile, String paramString)
  {
    AppMethodBeat.i(214821);
    if (paramFile == null)
    {
      AppMethodBeat.o(214821);
      return null;
    }
    paramFile = new File(paramFile.getAbsolutePath() + File.separator + paramString);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      AppMethodBeat.o(214821);
      return null;
    }
    AppMethodBeat.o(214821);
    return paramFile;
  }
  
  public static boolean nR(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(214822);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(214822);
      return false;
    }
    paramString1 = brd(paramString1);
    if ((paramString1 == null) || (paramString1.length <= 0))
    {
      AppMethodBeat.o(214822);
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
        AppMethodBeat.o(214822);
        return bool1;
      }
      i += 1;
    }
  }
  
  public final File lv(Context paramContext)
  {
    AppMethodBeat.i(214820);
    if (paramContext == null)
    {
      AppMethodBeat.o(214820);
      return null;
    }
    if (TextUtils.isEmpty(this.Str)) {
      this.Str = d.V(d.SpV);
    }
    if (TextUtils.isEmpty(this.Str))
    {
      AppMethodBeat.o(214820);
      return null;
    }
    h.d("Persistence", "dir : " + this.Str);
    paramContext = paramContext.getDir(this.Str, 0);
    AppMethodBeat.o(214820);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.d.a
 * JD-Core Version:    0.7.0.1
 */