package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"NewApi"})
public final class FragmentWrapper
  extends IFragmentWrapper.Stub
{
  private byte _hellAccFlag_;
  private Fragment zzabm;
  
  private FragmentWrapper(Fragment paramFragment)
  {
    this.zzabm = paramFragment;
  }
  
  public static FragmentWrapper wrap(Fragment paramFragment)
  {
    AppMethodBeat.i(5363);
    if (paramFragment != null)
    {
      paramFragment = new FragmentWrapper(paramFragment);
      AppMethodBeat.o(5363);
      return paramFragment;
    }
    AppMethodBeat.o(5363);
    return null;
  }
  
  public final IObjectWrapper getActivity()
  {
    AppMethodBeat.i(5364);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getActivity());
    AppMethodBeat.o(5364);
    return localIObjectWrapper;
  }
  
  public final Bundle getArguments()
  {
    AppMethodBeat.i(5365);
    Bundle localBundle = this.zzabm.getArguments();
    AppMethodBeat.o(5365);
    return localBundle;
  }
  
  public final int getId()
  {
    AppMethodBeat.i(5366);
    int i = this.zzabm.getId();
    AppMethodBeat.o(5366);
    return i;
  }
  
  public final IFragmentWrapper getParentFragment()
  {
    AppMethodBeat.i(5367);
    FragmentWrapper localFragmentWrapper = wrap(this.zzabm.getParentFragment());
    AppMethodBeat.o(5367);
    return localFragmentWrapper;
  }
  
  public final IObjectWrapper getResources()
  {
    AppMethodBeat.i(5368);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getResources());
    AppMethodBeat.o(5368);
    return localIObjectWrapper;
  }
  
  public final boolean getRetainInstance()
  {
    AppMethodBeat.i(5369);
    boolean bool = this.zzabm.getRetainInstance();
    AppMethodBeat.o(5369);
    return bool;
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(5370);
    String str = this.zzabm.getTag();
    AppMethodBeat.o(5370);
    return str;
  }
  
  public final IFragmentWrapper getTargetFragment()
  {
    AppMethodBeat.i(5371);
    FragmentWrapper localFragmentWrapper = wrap(this.zzabm.getTargetFragment());
    AppMethodBeat.o(5371);
    return localFragmentWrapper;
  }
  
  public final int getTargetRequestCode()
  {
    AppMethodBeat.i(5372);
    int i = this.zzabm.getTargetRequestCode();
    AppMethodBeat.o(5372);
    return i;
  }
  
  public final boolean getUserVisibleHint()
  {
    AppMethodBeat.i(5373);
    boolean bool = this.zzabm.getUserVisibleHint();
    AppMethodBeat.o(5373);
    return bool;
  }
  
  public final IObjectWrapper getView()
  {
    AppMethodBeat.i(5374);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getView());
    AppMethodBeat.o(5374);
    return localIObjectWrapper;
  }
  
  public final boolean isAdded()
  {
    AppMethodBeat.i(5375);
    boolean bool = this.zzabm.isAdded();
    AppMethodBeat.o(5375);
    return bool;
  }
  
  public final boolean isDetached()
  {
    AppMethodBeat.i(5376);
    boolean bool = this.zzabm.isDetached();
    AppMethodBeat.o(5376);
    return bool;
  }
  
  public final boolean isHidden()
  {
    AppMethodBeat.i(5377);
    boolean bool = this.zzabm.isHidden();
    AppMethodBeat.o(5377);
    return bool;
  }
  
  public final boolean isInLayout()
  {
    AppMethodBeat.i(5378);
    boolean bool = this.zzabm.isInLayout();
    AppMethodBeat.o(5378);
    return bool;
  }
  
  public final boolean isRemoving()
  {
    AppMethodBeat.i(5379);
    boolean bool = this.zzabm.isRemoving();
    AppMethodBeat.o(5379);
    return bool;
  }
  
  public final boolean isResumed()
  {
    AppMethodBeat.i(5380);
    boolean bool = this.zzabm.isResumed();
    AppMethodBeat.o(5380);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(5381);
    boolean bool = this.zzabm.isVisible();
    AppMethodBeat.o(5381);
    return bool;
  }
  
  public final void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(5382);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabm.registerForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(5382);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(5383);
    this.zzabm.setHasOptionsMenu(paramBoolean);
    AppMethodBeat.o(5383);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(5384);
    this.zzabm.setMenuVisibility(paramBoolean);
    AppMethodBeat.o(5384);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(5385);
    this.zzabm.setRetainInstance(paramBoolean);
    AppMethodBeat.o(5385);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(5386);
    this.zzabm.setUserVisibleHint(paramBoolean);
    AppMethodBeat.o(5386);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(5387);
    Fragment localFragment = this.zzabm;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localFragment, paramIntent.adn(), "com/google/android/gms/dynamic/FragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localFragment.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localFragment, "com/google/android/gms/dynamic/FragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(5387);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(5388);
    this.zzabm.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(5388);
  }
  
  public final void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(5389);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabm.unregisterForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(5389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.FragmentWrapper
 * JD-Core Version:    0.7.0.1
 */