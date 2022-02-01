package com.tencent.mm.plugin.appbrand.ui.launcher;

import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.mm.ui.MMActivity;

public abstract class FolderActivityContextWithLifecycle
  extends ContextWrapper
  implements k, a
{
  public FolderActivityContextWithLifecycle(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void Q(Intent paramIntent) {}
  
  protected final MMActivity getActivity()
  {
    return (MMActivity)getBaseContext();
  }
  
  @t(jl=h.a.ON_CREATE)
  public final void onActivityDidCreateCall()
  {
    Q(((MMActivity)getBaseContext()).getIntent());
  }
  
  @t(jl=h.a.ON_RESUME)
  public void onActivityDidResume() {}
  
  @t(jl=h.a.ON_DESTROY)
  public void onActivityWillDestroy()
  {
    View localView = ((MMActivity)getBaseContext()).findViewById(16908290);
    if ((localView instanceof ViewGroup)) {
      com.tencent.mm.plugin.appbrand.widget.j.a.n((ViewGroup)localView);
    }
  }
  
  @t(jl=h.a.ON_PAUSE)
  public void onActivityWillPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
 * JD-Core Version:    0.7.0.1
 */