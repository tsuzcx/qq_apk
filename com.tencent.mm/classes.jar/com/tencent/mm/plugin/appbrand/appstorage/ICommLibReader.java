package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcelable;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.appcache.p;
import java.io.Closeable;

public abstract interface ICommLibReader
  extends Parcelable, b, p, Closeable, Comparable<ICommLibReader>
{
  public abstract String UX(String paramString);
  
  public abstract String cfF();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader
 * JD-Core Version:    0.7.0.1
 */