package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class lh
{
  private List<String> a;
  private List<String> b;
  private final int c;
  
  public lh()
  {
    AppMethodBeat.i(222625);
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.c = 300;
    AppMethodBeat.o(222625);
  }
  
  private void a()
  {
    try
    {
      AppMethodBeat.i(222642);
      this.a.clear();
      this.b.clear();
      AppMethodBeat.o(222642);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void a(List<String> paramList)
  {
    AppMethodBeat.i(222635);
    if (paramList == null)
    {
      AppMethodBeat.o(222635);
      return;
    }
    if (paramList.size() <= 300)
    {
      AppMethodBeat.o(222635);
      return;
    }
    paramList.remove(0);
    AppMethodBeat.o(222635);
  }
  
  public final boolean a(String paramString)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222651);
        if ((paramString == null) || (paramString.trim().length() == 0))
        {
          AppMethodBeat.o(222651);
          return bool;
        }
        if (this.b.contains(paramString))
        {
          AppMethodBeat.o(222651);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(222651);
    }
  }
  
  public final void b(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(222661);
        if ((paramString == null) || (paramString.trim().length() == 0))
        {
          AppMethodBeat.o(222661);
          return;
        }
        if (this.b.contains(paramString))
        {
          this.b.remove(paramString);
          this.b.add(paramString);
          AppMethodBeat.o(222661);
          continue;
        }
        if (!this.a.contains(paramString)) {
          break label127;
        }
      }
      finally {}
      a(this.b);
      this.b.add(paramString);
      this.a.remove(paramString);
      AppMethodBeat.o(222661);
      continue;
      label127:
      a(this.a);
      this.a.add(paramString);
      AppMethodBeat.o(222661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lh
 * JD-Core Version:    0.7.0.1
 */