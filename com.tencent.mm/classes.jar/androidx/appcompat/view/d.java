package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import androidx.appcompat.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends ContextWrapper
{
  public int jM;
  private Configuration jN;
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
    this.jM = paramInt;
  }
  
  private void bD()
  {
    AppMethodBeat.i(238907);
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
      this.mTheme.applyStyle(this.jM, true);
      AppMethodBeat.o(238907);
      return;
    }
  }
  
  protected final void attachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(238902);
    super.attachBaseContext(paramContext);
    AppMethodBeat.o(238902);
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(238908);
    AssetManager localAssetManager = getResources().getAssets();
    AppMethodBeat.o(238908);
    return localAssetManager;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(238903);
    if (this.mResources == null)
    {
      if (this.jN != null) {
        break label39;
      }
      this.mResources = super.getResources();
    }
    for (;;)
    {
      Resources localResources = this.mResources;
      AppMethodBeat.o(238903);
      return localResources;
      label39:
      if (Build.VERSION.SDK_INT >= 17) {
        this.mResources = createConfigurationContext(this.jN).getResources();
      }
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(238906);
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      paramString = this.mInflater;
      AppMethodBeat.o(238906);
      return paramString;
    }
    paramString = getBaseContext().getSystemService(paramString);
    AppMethodBeat.o(238906);
    return paramString;
  }
  
  public final Resources.Theme getTheme()
  {
    AppMethodBeat.i(238905);
    if (this.mTheme != null)
    {
      localTheme = this.mTheme;
      AppMethodBeat.o(238905);
      return localTheme;
    }
    if (this.jM == 0) {
      this.jM = a.i.Theme_AppCompat_Light;
    }
    bD();
    Resources.Theme localTheme = this.mTheme;
    AppMethodBeat.o(238905);
    return localTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    AppMethodBeat.i(238904);
    if (this.jM != paramInt)
    {
      this.jM = paramInt;
      bD();
    }
    AppMethodBeat.o(238904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.appcompat.view.d
 * JD-Core Version:    0.7.0.1
 */