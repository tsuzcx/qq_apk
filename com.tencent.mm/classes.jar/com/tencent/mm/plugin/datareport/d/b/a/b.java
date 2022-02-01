package com.tencent.mm.plugin.datareport.d.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.c.a;

public final class b
{
  public static void a(Object paramObject, com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    AppMethodBeat.i(262857);
    if (paramObject == null)
    {
      AppMethodBeat.o(262857);
      return;
    }
    if (!(paramObject instanceof View))
    {
      AppMethodBeat.o(262857);
      return;
    }
    try
    {
      ((View)paramObject).setTag(c.a.xgm, paramb);
      return;
    }
    finally
    {
      AppMethodBeat.o(262857);
    }
  }
  
  public static com.tencent.mm.plugin.datareport.d.a.b eU(Object paramObject)
  {
    AppMethodBeat.i(262864);
    if (paramObject == null)
    {
      AppMethodBeat.o(262864);
      return null;
    }
    if (!(paramObject instanceof View))
    {
      AppMethodBeat.o(262864);
      return null;
    }
    try
    {
      paramObject = ((View)paramObject).getTag(c.a.xgm);
      if ((paramObject instanceof com.tencent.mm.plugin.datareport.d.a.b))
      {
        paramObject = (com.tencent.mm.plugin.datareport.d.a.b)paramObject;
        return paramObject;
      }
    }
    finally
    {
      AppMethodBeat.o(262864);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */