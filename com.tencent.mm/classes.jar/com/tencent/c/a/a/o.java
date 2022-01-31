package com.tencent.c.a.a;

import android.content.Context;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends q
{
  public o(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(125739);
    try
    {
      new StringBuilder("write CheckEntity to Settings.System:").append(parama.toString());
      s.zU();
      p.aM(this.context).A(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), parama.toString());
      return;
    }
    finally
    {
      AppMethodBeat.o(125739);
    }
  }
  
  protected final String read()
  {
    AppMethodBeat.i(125736);
    try
    {
      s.zU();
      String str = Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
      return str;
    }
    finally
    {
      AppMethodBeat.o(125736);
    }
  }
  
  protected final void write(String paramString)
  {
    AppMethodBeat.i(125737);
    try
    {
      s.zU();
      p.aM(this.context).A(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(125737);
    }
  }
  
  protected final boolean zL()
  {
    AppMethodBeat.i(125735);
    boolean bool = s.q(this.context, "android.permission.WRITE_SETTINGS");
    AppMethodBeat.o(125735);
    return bool;
  }
  
  protected final a zM()
  {
    AppMethodBeat.i(125738);
    try
    {
      a locala = new a(Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
      new StringBuilder("read readCheckEntity from Settings.System:").append(locala.toString());
      s.zU();
      return locala;
    }
    finally
    {
      AppMethodBeat.o(125738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.o
 * JD-Core Version:    0.7.0.1
 */