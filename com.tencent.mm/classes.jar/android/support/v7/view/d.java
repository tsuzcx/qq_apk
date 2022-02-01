package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class d
  extends ContextWrapper
{
  public int aaG;
  private Configuration aaH;
  private LayoutInflater mInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  
  public d()
  {
    super(null);
  }
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.aaG = paramInt;
  }
  
  public d(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.mTheme = paramTheme;
  }
  
  private void gX()
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
      this.mTheme.applyStyle(this.aaG, true);
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
      if (this.aaH != null) {
        break label27;
      }
      this.mResources = super.getResources();
    }
    for (;;)
    {
      return this.mResources;
      label27:
      if (Build.VERSION.SDK_INT >= 17) {
        this.mResources = createConfigurationContext(this.aaH).getResources();
      }
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public final Resources.Theme getTheme()
  {
    if (this.mTheme != null) {
      return this.mTheme;
    }
    if (this.aaG == 0) {
      this.aaG = 2131821426;
    }
    gX();
    return this.mTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.aaG != paramInt)
    {
      this.aaG = paramInt;
      gX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.d
 * JD-Core Version:    0.7.0.1
 */