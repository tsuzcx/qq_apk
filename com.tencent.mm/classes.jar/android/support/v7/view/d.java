package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.a.a.i;
import android.view.LayoutInflater;

public final class d
  extends ContextWrapper
{
  private LayoutInflater Lu;
  public int ST;
  private Configuration SU;
  private Resources mResources;
  private Resources.Theme mTheme;
  
  public d()
  {
    super(null);
  }
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.ST = paramInt;
  }
  
  private void eO()
  {
    if (this.mTheme == null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mTheme = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          this.mTheme.setTo(localTheme);
        }
      }
      this.mTheme.applyStyle(this.ST, true);
      return;
    }
  }
  
  protected final void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public final AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public final Resources getResources()
  {
    if (this.mResources == null)
    {
      if (this.SU != null) {
        break label27;
      }
      this.mResources = super.getResources();
    }
    for (;;)
    {
      return this.mResources;
      label27:
      if (Build.VERSION.SDK_INT >= 17) {
        this.mResources = createConfigurationContext(this.SU).getResources();
      }
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.Lu == null) {
        this.Lu = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.Lu;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    if (this.mTheme != null) {
      return this.mTheme;
    }
    if (this.ST == 0) {
      this.ST = a.i.Theme_AppCompat_Light;
    }
    eO();
    return this.mTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.ST != paramInt)
    {
      this.ST = paramInt;
      eO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.d
 * JD-Core Version:    0.7.0.1
 */