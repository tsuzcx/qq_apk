package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
  extends q
{
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(125750);
    try
    {
      new StringBuilder("write CheckEntity to sharedPreferences:").append(parama.toString());
      s.zU();
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), parama.toString());
      localEditor.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(125750);
    }
  }
  
  protected final String read()
  {
    AppMethodBeat.i(125747);
    try
    {
      s.zU();
      String str = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
      return str;
    }
    finally
    {
      AppMethodBeat.o(125747);
    }
  }
  
  protected final void write(String paramString)
  {
    AppMethodBeat.i(125748);
    try
    {
      s.zU();
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(125748);
    }
  }
  
  protected final boolean zL()
  {
    return true;
  }
  
  protected final a zM()
  {
    AppMethodBeat.i(125749);
    try
    {
      a locala = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
      new StringBuilder("read CheckEntity from sharedPreferences:").append(locala.toString());
      s.zU();
      return locala;
    }
    finally
    {
      AppMethodBeat.o(125749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */