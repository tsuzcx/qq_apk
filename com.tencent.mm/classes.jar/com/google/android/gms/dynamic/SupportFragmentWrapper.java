package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SupportFragmentWrapper
  extends IFragmentWrapper.Stub
{
  private byte _hellAccFlag_;
  private Fragment zzabq;
  
  private SupportFragmentWrapper(Fragment paramFragment)
  {
    this.zzabq = paramFragment;
  }
  
  public static SupportFragmentWrapper wrap(Fragment paramFragment)
  {
    AppMethodBeat.i(5419);
    if (paramFragment != null)
    {
      paramFragment = new SupportFragmentWrapper(paramFragment);
      AppMethodBeat.o(5419);
      return paramFragment;
    }
    AppMethodBeat.o(5419);
    return null;
  }
  
  public final IObjectWrapper getActivity()
  {
    AppMethodBeat.i(5420);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getActivity());
    AppMethodBeat.o(5420);
    return localIObjectWrapper;
  }
  
  public final Bundle getArguments()
  {
    AppMethodBeat.i(5421);
    Bundle localBundle = this.zzabq.getArguments();
    AppMethodBeat.o(5421);
    return localBundle;
  }
  
  public final int getId()
  {
    AppMethodBeat.i(5422);
    int i = this.zzabq.getId();
    AppMethodBeat.o(5422);
    return i;
  }
  
  public final IFragmentWrapper getParentFragment()
  {
    AppMethodBeat.i(5423);
    SupportFragmentWrapper localSupportFragmentWrapper = wrap(this.zzabq.getParentFragment());
    AppMethodBeat.o(5423);
    return localSupportFragmentWrapper;
  }
  
  public final IObjectWrapper getResources()
  {
    AppMethodBeat.i(5424);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getResources());
    AppMethodBeat.o(5424);
    return localIObjectWrapper;
  }
  
  public final boolean getRetainInstance()
  {
    AppMethodBeat.i(5425);
    boolean bool = this.zzabq.getRetainInstance();
    AppMethodBeat.o(5425);
    return bool;
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(5426);
    String str = this.zzabq.getTag();
    AppMethodBeat.o(5426);
    return str;
  }
  
  public final IFragmentWrapper getTargetFragment()
  {
    AppMethodBeat.i(5427);
    SupportFragmentWrapper localSupportFragmentWrapper = wrap(this.zzabq.getTargetFragment());
    AppMethodBeat.o(5427);
    return localSupportFragmentWrapper;
  }
  
  public final int getTargetRequestCode()
  {
    AppMethodBeat.i(5428);
    int i = this.zzabq.getTargetRequestCode();
    AppMethodBeat.o(5428);
    return i;
  }
  
  public final boolean getUserVisibleHint()
  {
    AppMethodBeat.i(5429);
    boolean bool = this.zzabq.getUserVisibleHint();
    AppMethodBeat.o(5429);
    return bool;
  }
  
  public final IObjectWrapper getView()
  {
    AppMethodBeat.i(5430);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getView());
    AppMethodBeat.o(5430);
    return localIObjectWrapper;
  }
  
  public final boolean isAdded()
  {
    AppMethodBeat.i(5431);
    boolean bool = this.zzabq.isAdded();
    AppMethodBeat.o(5431);
    return bool;
  }
  
  public final boolean isDetached()
  {
    AppMethodBeat.i(5432);
    boolean bool = this.zzabq.isDetached();
    AppMethodBeat.o(5432);
    return bool;
  }
  
  public final boolean isHidden()
  {
    AppMethodBeat.i(5433);
    boolean bool = this.zzabq.isHidden();
    AppMethodBeat.o(5433);
    return bool;
  }
  
  public final boolean isInLayout()
  {
    AppMethodBeat.i(5434);
    boolean bool = this.zzabq.isInLayout();
    AppMethodBeat.o(5434);
    return bool;
  }
  
  public final boolean isRemoving()
  {
    AppMethodBeat.i(5435);
    boolean bool = this.zzabq.isRemoving();
    AppMethodBeat.o(5435);
    return bool;
  }
  
  public final boolean isResumed()
  {
    AppMethodBeat.i(5436);
    boolean bool = this.zzabq.isResumed();
    AppMethodBeat.o(5436);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(5437);
    boolean bool = this.zzabq.isVisible();
    AppMethodBeat.o(5437);
    return bool;
  }
  
  public final void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(5438);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabq.registerForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(5438);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(5439);
    this.zzabq.setHasOptionsMenu(paramBoolean);
    AppMethodBeat.o(5439);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(5440);
    this.zzabq.setMenuVisibility(paramBoolean);
    AppMethodBeat.o(5440);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(5441);
    this.zzabq.setRetainInstance(paramBoolean);
    AppMethodBeat.o(5441);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(5442);
    this.zzabq.setUserVisibleHint(paramBoolean);
    AppMethodBeat.o(5442);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(5443);
    Fragment localFragment = this.zzabq;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localFragment, paramIntent.adn(), "com/google/android/gms/dynamic/SupportFragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localFragment.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localFragment, "com/google/android/gms/dynamic/SupportFragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(5443);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(5444);
    this.zzabq.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(5444);
  }
  
  public final void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(5445);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabq.unregisterForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(5445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.SupportFragmentWrapper
 * JD-Core Version:    0.7.0.1
 */