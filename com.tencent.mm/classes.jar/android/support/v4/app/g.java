package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class g
{
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    return Fragment.instantiate(paramContext, paramString, paramBundle);
  }
  
  public abstract View onFindViewById(int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.g
 * JD-Core Version:    0.7.0.1
 */