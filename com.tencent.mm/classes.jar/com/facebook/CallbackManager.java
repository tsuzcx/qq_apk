package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface CallbackManager
{
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public static class Factory
  {
    public static CallbackManager create()
    {
      AppMethodBeat.i(17008);
      CallbackManagerImpl localCallbackManagerImpl = new CallbackManagerImpl();
      AppMethodBeat.o(17008);
      return localCallbackManagerImpl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.CallbackManager
 * JD-Core Version:    0.7.0.1
 */