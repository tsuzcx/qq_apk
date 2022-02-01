package com.tencent.mm.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;

final class GPAppInlineFence
  extends Handler
{
  private final ApplicationLike mAppLike;
  
  private GPAppInlineFence(ApplicationLike paramApplicationLike)
  {
    this.mAppLike = paramApplicationLike;
  }
  
  private static void dummyThrowExceptionMethod()
  {
    AppMethodBeat.i(239284);
    if ((System.currentTimeMillis() & 0x7FFFFFFF) < 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException();
      AppMethodBeat.o(239284);
      throw localRuntimeException;
    }
    AppMethodBeat.o(239284);
  }
  
  private void handleMessageImpl(Message paramMessage)
  {
    AppMethodBeat.i(239281);
    switch (paramMessage.what)
    {
    default: 
      paramMessage = new IllegalStateException("Should not be here.");
      AppMethodBeat.o(239281);
      throw paramMessage;
    case 1: 
      this.mAppLike.onBaseContextAttached((Context)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 2: 
      this.mAppLike.onCreate();
      AppMethodBeat.o(239281);
      return;
    case 3: 
      this.mAppLike.onConfigurationChanged((Configuration)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 4: 
      this.mAppLike.onTrimMemory(((Integer)paramMessage.obj).intValue());
      AppMethodBeat.o(239281);
      return;
    case 5: 
      this.mAppLike.onLowMemory();
      AppMethodBeat.o(239281);
      return;
    case 6: 
      this.mAppLike.onTerminate();
      AppMethodBeat.o(239281);
      return;
    case 7: 
      paramMessage.obj = this.mAppLike.getClassLoader((ClassLoader)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 8: 
      paramMessage.obj = this.mAppLike.getBaseContext((Context)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 9: 
      paramMessage.obj = this.mAppLike.getAssets((AssetManager)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 10: 
      paramMessage.obj = this.mAppLike.getResources((Resources)paramMessage.obj);
      AppMethodBeat.o(239281);
      return;
    case 11: 
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      paramMessage.obj = this.mAppLike.getSystemService((String)arrayOfObject[0], arrayOfObject[1]);
      AppMethodBeat.o(239281);
      return;
    }
    paramMessage.obj = Integer.valueOf(this.mAppLike.mzNightModeUseOf());
    AppMethodBeat.o(239281);
  }
  
  private void handleMessage_$noinline$(Message paramMessage)
  {
    AppMethodBeat.i(239277);
    try
    {
      dummyThrowExceptionMethod();
      return;
    }
    finally
    {
      handleMessageImpl(paramMessage);
      AppMethodBeat.o(239277);
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(239286);
    handleMessage_$noinline$(paramMessage);
    AppMethodBeat.o(239286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.GPAppInlineFence
 * JD-Core Version:    0.7.0.1
 */