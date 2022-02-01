package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class z
  extends ContextWrapper
{
  private static final Object xt;
  private static ArrayList<WeakReference<z>> xu;
  private final Resources mResources;
  private final Resources.Theme mTheme;
  
  static
  {
    AppMethodBeat.i(199870);
    xt = new Object();
    AppMethodBeat.o(199870);
  }
  
  private z(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199859);
    if (ah.fE())
    {
      this.mResources = new ah(this, paramContext.getResources());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      AppMethodBeat.o(199859);
      return;
    }
    this.mResources = new ab(this, paramContext.getResources());
    this.mTheme = null;
    AppMethodBeat.o(199859);
  }
  
  public static Context L(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(199849);
    int i = j;
    if (!(paramContext instanceof z))
    {
      i = j;
      if (!(paramContext.getResources() instanceof ab))
      {
        if (!(paramContext.getResources() instanceof ah)) {
          break label102;
        }
        i = j;
      }
    }
    if (i != 0) {}
    for (;;)
    {
      synchronized (xt)
      {
        if (xu == null)
        {
          xu = new ArrayList();
          paramContext = new z(paramContext);
          xu.add(new WeakReference(paramContext));
          AppMethodBeat.o(199849);
          return paramContext;
          label102:
          if (Build.VERSION.SDK_INT >= 21)
          {
            i = j;
            if (!ah.fE()) {
              break;
            }
          }
          i = 1;
          break;
        }
        i = xu.size() - 1;
        if (i >= 0)
        {
          localObject1 = (WeakReference)xu.get(i);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
            break label257;
          }
          xu.remove(i);
          break label257;
        }
        i = xu.size() - 1;
        if (i < 0) {
          continue;
        }
        Object localObject1 = (WeakReference)xu.get(i);
        if (localObject1 != null)
        {
          localObject1 = (z)((WeakReference)localObject1).get();
          if ((localObject1 != null) && (((z)localObject1).getBaseContext() == paramContext))
          {
            AppMethodBeat.o(199849);
            return localObject1;
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        i -= 1;
      }
      AppMethodBeat.o(199849);
      return paramContext;
      label257:
      i -= 1;
    }
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(199910);
    AssetManager localAssetManager = this.mResources.getAssets();
    AppMethodBeat.o(199910);
    return localAssetManager;
  }
  
  public final Resources getResources()
  {
    return this.mResources;
  }
  
  public final Resources.Theme getTheme()
  {
    AppMethodBeat.i(199880);
    if (this.mTheme == null)
    {
      localTheme = super.getTheme();
      AppMethodBeat.o(199880);
      return localTheme;
    }
    Resources.Theme localTheme = this.mTheme;
    AppMethodBeat.o(199880);
    return localTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    AppMethodBeat.i(199887);
    if (this.mTheme == null)
    {
      super.setTheme(paramInt);
      AppMethodBeat.o(199887);
      return;
    }
    this.mTheme.applyStyle(paramInt, true);
    AppMethodBeat.o(199887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.z
 * JD-Core Version:    0.7.0.1
 */