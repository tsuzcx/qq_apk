package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    LoaderManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void destroyLoader(int paramInt);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract Loader getLoader(int paramInt);
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  public abstract Loader initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks paramLoaderCallbacks);
  
  public abstract Loader restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks paramLoaderCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManager
 * JD-Core Version:    0.7.0.1
 */