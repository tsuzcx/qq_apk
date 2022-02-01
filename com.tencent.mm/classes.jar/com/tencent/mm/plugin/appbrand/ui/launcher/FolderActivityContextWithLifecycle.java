package com.tencent.mm.plugin.appbrand.ui.launcher;

import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.mm.ui.MMActivity;

public abstract class FolderActivityContextWithLifecycle
  extends ContextWrapper
  implements p, a
{
  public FolderActivityContextWithLifecycle(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void T(Intent paramIntent) {}
  
  @z(Ho=j.a.ON_CREATE)
  public final void onActivityDidCreateCall()
  {
    T(((MMActivity)getBaseContext()).getIntent());
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onActivityDidResume() {}
  
  @z(Ho=j.a.ON_DESTROY)
  public void onActivityWillDestroy()
  {
    View localView = ((MMActivity)getBaseContext()).findViewById(16908290);
    if ((localView instanceof ViewGroup)) {
      com.tencent.mm.plugin.appbrand.widget.k.a.q((ViewGroup)localView);
    }
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onActivityWillPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
 * JD-Core Version:    0.7.0.1
 */