package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcelable;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.appcache.o;

public abstract interface ICommLibReader
  extends Parcelable, b, o, Comparable<ICommLibReader>
{
  public abstract String DI(String paramString);
  
  public static final class a
    extends RuntimeException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader
 * JD-Core Version:    0.7.0.1
 */