package com.tencent.b.a.a;

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
  
  protected final boolean Is()
  {
    return true;
  }
  
  protected final a It()
  {
    AppMethodBeat.i(87631);
    try
    {
      a locala = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
      new StringBuilder("read CheckEntity from sharedPreferences:").append(locala.toString());
      s.IB();
      return locala;
    }
    finally
    {
      AppMethodBeat.o(87631);
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(87632);
    try
    {
      new StringBuilder("write CheckEntity to sharedPreferences:").append(parama.toString());
      s.IB();
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), parama.toString());
      localEditor.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(87632);
    }
  }
  
  protected final String read()
  {
    AppMethodBeat.i(87629);
    try
    {
      s.IB();
      String str = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
      return str;
    }
    finally
    {
      AppMethodBeat.o(87629);
    }
  }
  
  protected final void write(String paramString)
  {
    AppMethodBeat.i(87630);
    try
    {
      s.IB();
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      AppMethodBeat.o(87630);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */