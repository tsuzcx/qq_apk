package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzi$a
  extends ClassLoader
{
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108784);
    if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
    {
      FirebaseInstanceId.rP();
      AppMethodBeat.o(108784);
      return zzi.class;
    }
    paramString = super.loadClass(paramString, paramBoolean);
    AppMethodBeat.o(108784);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.firebase.iid.zzi.a
 * JD-Core Version:    0.7.0.1
 */