package com.facebook;

import com.facebook.internal.CallbackManagerImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CallbackManager$Factory
{
  public static CallbackManager create()
  {
    AppMethodBeat.i(71572);
    CallbackManagerImpl localCallbackManagerImpl = new CallbackManagerImpl();
    AppMethodBeat.o(71572);
    return localCallbackManagerImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.CallbackManager.Factory
 * JD-Core Version:    0.7.0.1
 */