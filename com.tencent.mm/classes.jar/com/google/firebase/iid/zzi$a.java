package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzi$a
  extends ClassLoader
{
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(4220);
    if ("com.google.android.gms.iid.MessengerCompat".equals(paramString))
    {
      FirebaseInstanceId.wB();
      AppMethodBeat.o(4220);
      return zzi.class;
    }
    paramString = super.loadClass(paramString, paramBoolean);
    AppMethodBeat.o(4220);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.zzi.a
 * JD-Core Version:    0.7.0.1
 */