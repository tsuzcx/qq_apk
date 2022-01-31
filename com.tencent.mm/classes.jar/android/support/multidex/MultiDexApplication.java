package android.support.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    a.H(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.multidex.MultiDexApplication
 * JD-Core Version:    0.7.0.1
 */