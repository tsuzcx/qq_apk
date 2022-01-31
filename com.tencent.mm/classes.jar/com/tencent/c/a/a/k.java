package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

final class k
  extends q
{
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(a parama)
  {
    try
    {
      new StringBuilder("write CheckEntity to sharedPreferences:").append(parama.toString());
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), parama.toString());
      localEditor.commit();
      return;
    }
    finally {}
  }
  
  protected final String read()
  {
    try
    {
      String str = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
      return str;
    }
    finally {}
  }
  
  protected final boolean rv()
  {
    return true;
  }
  
  protected final a rw()
  {
    try
    {
      a locala = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
      new StringBuilder("read CheckEntity from sharedPreferences:").append(locala.toString());
      return locala;
    }
    finally {}
  }
  
  protected final void write(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      localEditor.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      localEditor.commit();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */