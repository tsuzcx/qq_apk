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
  private String ahZt;
  
  public static List<File> bGA(String paramString)
  {
    AppMethodBeat.i(212110);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(212110);
      return null;
    }
    paramString = bGB(paramString);
    if ((paramString == null) || (paramString.length <= 0))
    {
      AppMethodBeat.o(212110);
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
    AppMethodBeat.o(212110);
    return localArrayList;
  }
  
  public static File[] bGB(String paramString)
  {
    AppMethodBeat.i(212117);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(212117);
      return null;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs()))
    {
      AppMethodBeat.o(212117);
      return null;
    }
    paramString = paramString.listFiles();
    AppMethodBeat.o(212117);
    return paramString;
  }
  
  public static File j(File paramFile, String paramString)
  {
    AppMethodBeat.i(212095);
    if (paramFile == null)
    {
      AppMethodBeat.o(212095);
      return null;
    }
    paramFile = new File(paramFile.getAbsolutePath() + File.separator + paramString);
    if ((!paramFile.exists()) && (!paramFile.mkdirs()))
    {
      AppMethodBeat.o(212095);
      return null;
    }
    AppMethodBeat.o(212095);
    return paramFile;
  }
  
  public static boolean qL(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(212106);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(212106);
      return false;
    }
    paramString1 = bGB(paramString1);
    if ((paramString1 == null) || (paramString1.length <= 0))
    {
      AppMethodBeat.o(212106);
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
        AppMethodBeat.o(212106);
        return bool1;
      }
      i += 1;
    }
  }
  
  public final File oJ(Context paramContext)
  {
    AppMethodBeat.i(212131);
    if (paramContext == null)
    {
      AppMethodBeat.o(212131);
      return null;
    }
    if (TextUtils.isEmpty(this.ahZt)) {
      this.ahZt = d.W(d.ahVX);
    }
    if (TextUtils.isEmpty(this.ahZt))
    {
      AppMethodBeat.o(212131);
      return null;
    }
    i.d("Persistence", "dir : " + this.ahZt);
    paramContext = paramContext.getDir(this.ahZt, 0);
    AppMethodBeat.o(212131);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.d.a
 * JD-Core Version:    0.7.0.1
 */