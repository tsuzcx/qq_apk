package com.tencent.b.a.a;

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
  
  protected final boolean TW()
  {
    AppMethodBeat.i(87617);
    boolean bool = s.checkPermission(this.context, "android.permission.WRITE_SETTINGS");
    AppMethodBeat.o(87617);
    return bool;
  }
  
  protected final a TX()
  {
    AppMethodBeat.i(87620);
    try
    {
      a locala = new a(Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
      new StringBuilder("read readCheckEntity from Settings.System:").append(locala.toString());
      s.Uf();
      return locala;
    }
    finally
    {
      AppMethodBeat.o(87620);
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(87621);
    try
    {
      new StringBuilder("write CheckEntity to Settings.System:").append(parama.toString());
      s.Uf();
      p.br(this.context).N(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), parama.toString());
      return;
    }
    finally
    {
      AppMethodBeat.o(87621);
    }
  }
  
  protected final String read()
  {
    AppMethodBeat.i(87618);
    try
    {
      s.Uf();
      String str = Settings.System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
      return str;
    }
    finally
    {
      AppMethodBeat.o(87618);
    }
  }
  
  protected final void write(String paramString)
  {
    AppMethodBeat.i(87619);
    try
    {
      s.Uf();
      p.br(this.context).N(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      return;
    }
    finally
    {
      AppMethodBeat.o(87619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.o
 * JD-Core Version:    0.7.0.1
 */