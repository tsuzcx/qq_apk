package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class aw
  extends ContextWrapper
{
  private static final Object awH = new Object();
  private static ArrayList<WeakReference<aw>> awI;
  private final Resources mResources;
  private final Resources.Theme mTheme;
  
  private aw(Context paramContext)
  {
    super(paramContext);
    if (be.mQ())
    {
      this.mResources = new be(this, paramContext.getResources());
      this.mTheme = this.mResources.newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    }
    this.mResources = new ay(this, paramContext.getResources());
    this.mTheme = null;
  }
  
  public static Context ac(Context paramContext)
  {
    int j = 0;
    int i = j;
    if (!(paramContext instanceof aw))
    {
      i = j;
      if (!(paramContext.getResources() instanceof ay))
      {
        if (!(paramContext.getResources() instanceof be)) {
          break label94;
        }
        i = j;
      }
    }
    Object localObject1 = paramContext;
    if (i != 0) {}
    for (;;)
    {
      synchronized (awH)
      {
        if (awI == null)
        {
          awI = new ArrayList();
          localObject1 = new aw(paramContext);
          awI.add(new WeakReference(localObject1));
          return localObject1;
          label94:
          if (Build.VERSION.SDK_INT >= 21)
          {
            i = j;
            if (!be.mQ()) {
              break;
            }
          }
          i = 1;
          break;
        }
        i = awI.size() - 1;
        if (i >= 0)
        {
          localObject1 = (WeakReference)awI.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {
            awI.remove(i);
          }
        }
        else
        {
          i = awI.size() - 1;
          if (i < 0) {
            continue;
          }
          localObject1 = (WeakReference)awI.get(i);
          if (localObject1 == null) {
            break label227;
          }
          localObject1 = (aw)((WeakReference)localObject1).get();
          if ((localObject1 == null) || (((aw)localObject1).getBaseContext() != paramContext)) {
            break label232;
          }
          return localObject1;
        }
      }
      i -= 1;
      continue;
      label227:
      localObject1 = null;
      continue;
      label232:
      i -= 1;
    }
  }
  
  public final AssetManager getAssets()
  {
    return this.mResources.getAssets();
  }
  
  public final Resources getResources()
  {
    return this.mResources;
  }
  
  public final Resources.Theme getTheme()
  {
    if (this.mTheme == null) {
      return super.getTheme();
    }
    return this.mTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    if (this.mTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.mTheme.applyStyle(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.aw
 * JD-Core Version:    0.7.0.1
 */