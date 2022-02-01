package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public abstract interface LoaderManager$LoaderCallbacks
{
  public abstract Loader onCreateLoader(int paramInt, Bundle paramBundle);
  
  public abstract void onLoadFinished(Loader paramLoader, Object paramObject);
  
  public abstract void onLoaderReset(Loader paramLoader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManager.LoaderCallbacks
 * JD-Core Version:    0.7.0.1
 */