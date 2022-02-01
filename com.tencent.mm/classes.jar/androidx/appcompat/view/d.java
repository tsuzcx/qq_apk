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
  public int kI;
  private Configuration kJ;
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
    this.kI = paramInt;
  }
  
  private void cw()
  {
    AppMethodBeat.i(200701);
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
      this.mTheme.applyStyle(this.kI, true);
      AppMethodBeat.o(200701);
      return;
    }
  }
  
  protected final void attachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(200712);
    super.attachBaseContext(paramContext);
    AppMethodBeat.o(200712);
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(200766);
    AssetManager localAssetManager = getResources().getAssets();
    AppMethodBeat.o(200766);
    return localAssetManager;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(200725);
    if (this.mResources == null)
    {
      if (this.kJ != null) {
        break label39;
      }
      this.mResources = super.getResources();
    }
    for (;;)
    {
      Resources localResources = this.mResources;
      AppMethodBeat.o(200725);
      return localResources;
      label39:
      if (Build.VERSION.SDK_INT >= 17) {
        this.mResources = createConfigurationContext(this.kJ).getResources();
      }
    }
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(200757);
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      paramString = this.mInflater;
      AppMethodBeat.o(200757);
      return paramString;
    }
    paramString = getBaseContext().getSystemService(paramString);
    AppMethodBeat.o(200757);
    return paramString;
  }
  
  public final Resources.Theme getTheme()
  {
    AppMethodBeat.i(200746);
    if (this.mTheme != null)
    {
      localTheme = this.mTheme;
      AppMethodBeat.o(200746);
      return localTheme;
    }
    if (this.kI == 0) {
      this.kI = a.i.Theme_AppCompat_Light;
    }
    cw();
    Resources.Theme localTheme = this.mTheme;
    AppMethodBeat.o(200746);
    return localTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    AppMethodBeat.i(200734);
    if (this.kI != paramInt)
    {
      this.kI = paramInt;
      cw();
    }
    AppMethodBeat.o(200734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.view.d
 * JD-Core Version:    0.7.0.1
 */