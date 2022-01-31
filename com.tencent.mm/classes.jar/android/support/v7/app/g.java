package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.f.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

class g
  extends AppCompatDelegateImplV9
{
  private int OZ = -100;
  private boolean Pa;
  boolean Pb = true;
  private b Pc;
  
  g(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
  }
  
  private void el()
  {
    if (this.Pc == null)
    {
      Context localContext = this.mContext;
      if (n.QC == null)
      {
        localContext = localContext.getApplicationContext();
        n.QC = new n(localContext, (LocationManager)localContext.getSystemService("location"));
      }
      this.Pc = new b(n.QC);
    }
  }
  
  private boolean em()
  {
    PackageManager localPackageManager;
    if ((this.Pa) && ((this.mContext instanceof Activity))) {
      localPackageManager = this.mContext.getPackageManager();
    }
    try
    {
      int i = localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges;
      return (i & 0x200) == 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
    return true;
  }
  
  final View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  int aU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      el();
      b localb = this.Pc;
      localb.Pf = localb.Pe.eu();
      if (localb.Pf) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public final boolean eh()
  {
    int i;
    int j;
    Object localObject;
    Configuration localConfiguration;
    label55:
    label80:
    boolean bool;
    if (this.OZ != -100)
    {
      i = this.OZ;
      j = aU(i);
      if (j == -1) {
        break label324;
      }
      localObject = this.mContext.getResources();
      localConfiguration = ((Resources)localObject).getConfiguration();
      int k = localConfiguration.uiMode;
      if (j != 2) {
        break label211;
      }
      j = 32;
      if ((k & 0x30) == j) {
        break label318;
      }
      if (!em()) {
        break label217;
      }
      ((Activity)this.mContext).recreate();
      bool = true;
    }
    for (;;)
    {
      if (i == 0)
      {
        el();
        localObject = this.Pc;
        ((b)localObject).cleanup();
        if (((b)localObject).Pg == null) {
          ((b)localObject).Pg = new g.b.1((b)localObject);
        }
        if (((b)localObject).Ph == null)
        {
          ((b)localObject).Ph = new IntentFilter();
          ((b)localObject).Ph.addAction("android.intent.action.TIME_SET");
          ((b)localObject).Ph.addAction("android.intent.action.TIMEZONE_CHANGED");
          ((b)localObject).Ph.addAction("android.intent.action.TIME_TICK");
        }
        ((b)localObject).Pd.mContext.registerReceiver(((b)localObject).Pg, ((b)localObject).Ph);
      }
      this.Pa = true;
      return bool;
      i = d.OF;
      break;
      label211:
      j = 16;
      break label55;
      label217:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
      localConfiguration.uiMode = (j | localConfiguration.uiMode & 0xFFFFFFCF);
      ((Resources)localObject).updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT >= 26) {
        break label80;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        k.c((Resources)localObject);
        break label80;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        k.b((Resources)localObject);
        break label80;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label80;
      }
      k.a((Resources)localObject);
      break label80;
      label318:
      bool = false;
      continue;
      label324:
      bool = false;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.OZ == -100)) {
      this.OZ = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.Pc != null) {
      this.Pc.cleanup();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.OZ != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.OZ);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    eh();
  }
  
  public final void onStop()
  {
    super.onStop();
    if (this.Pc != null) {
      this.Pc.cleanup();
    }
  }
  
  class a
    extends e.b
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(g.this.mContext, paramCallback);
      b localb = g.this.startSupportActionMode(paramCallback);
      if (localb != null) {
        return paramCallback.b(localb);
      }
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (g.this.Pb) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
  
  final class b
  {
    n Pe;
    boolean Pf;
    BroadcastReceiver Pg;
    IntentFilter Ph;
    
    b(n paramn)
    {
      this.Pe = paramn;
      this.Pf = paramn.eu();
    }
    
    final void cleanup()
    {
      if (this.Pg != null)
      {
        g.this.mContext.unregisterReceiver(this.Pg);
        this.Pg = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */