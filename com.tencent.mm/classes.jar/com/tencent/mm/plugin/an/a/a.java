package com.tencent.mm.plugin.an.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.List;

public final class a
{
  private static final a PEW;
  
  static
  {
    AppMethodBeat.i(151586);
    PEW = new a()
    {
      public final int gYh()
      {
        return -1;
      }
      
      public final boolean gYi()
      {
        return false;
      }
      
      public final void jJ(Context paramAnonymousContext) {}
    };
    AppMethodBeat.o(151586);
  }
  
  public static a gYg()
  {
    AppMethodBeat.i(151585);
    b localb = new b();
    AppMethodBeat.o(151585);
    return localb;
  }
  
  public static abstract class a
  {
    public abstract int gYh();
    
    public abstract boolean gYi();
    
    public abstract void jJ(Context paramContext);
  }
  
  static abstract class b
  {
    public final boolean gYj()
    {
      List localList = MMApplicationContext.getContext().getPackageManager().queryIntentActivities(gYk(), 0);
      if ((localList == null) || (localList.isEmpty())) {}
      for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
        return true;
      }
      return false;
    }
    
    protected abstract Intent gYk();
    
    public final void jK(Context paramContext)
    {
      Object localObject = gYk();
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.an.a.a
 * JD-Core Version:    0.7.0.1
 */