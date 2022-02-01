package com.google.a;

import com.google.a.b.e;
import com.google.a.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

final class a
  extends s<java.util.Date>
{
  private final Class<? extends java.util.Date> bMK;
  private final List<DateFormat> bML;
  
  public a(Class<? extends java.util.Date> paramClass, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108116);
    this.bML = new ArrayList();
    this.bMK = A(paramClass);
    this.bML.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      this.bML.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }
    if (e.yK()) {
      this.bML.add(i.bw(paramInt1, paramInt2));
    }
    AppMethodBeat.o(108116);
  }
  
  a(Class<? extends java.util.Date> paramClass, String paramString)
  {
    AppMethodBeat.i(108115);
    this.bML = new ArrayList();
    this.bMK = A(paramClass);
    this.bML.add(new SimpleDateFormat(paramString, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      this.bML.add(new SimpleDateFormat(paramString));
    }
    AppMethodBeat.o(108115);
  }
  
  private static Class<? extends java.util.Date> A(Class<? extends java.util.Date> paramClass)
  {
    AppMethodBeat.i(108117);
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class) && (paramClass != Timestamp.class))
    {
      paramClass = new IllegalArgumentException("Date type must be one of " + java.util.Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + paramClass);
      AppMethodBeat.o(108117);
      throw paramClass;
    }
    AppMethodBeat.o(108117);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108118);
    Object localObject = (DateFormat)this.bML.get(0);
    if ((localObject instanceof SimpleDateFormat))
    {
      localObject = "DefaultDateTypeAdapter(" + ((SimpleDateFormat)localObject).toPattern() + ')';
      AppMethodBeat.o(108118);
      return localObject;
    }
    localObject = "DefaultDateTypeAdapter(" + localObject.getClass().getSimpleName() + ')';
    AppMethodBeat.o(108118);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.a
 * JD-Core Version:    0.7.0.1
 */