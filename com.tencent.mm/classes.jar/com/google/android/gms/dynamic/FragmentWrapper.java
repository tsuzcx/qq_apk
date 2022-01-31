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
  private Fragment zzabm;
  
  private FragmentWrapper(Fragment paramFragment)
  {
    this.zzabm = paramFragment;
  }
  
  public static FragmentWrapper wrap(Fragment paramFragment)
  {
    AppMethodBeat.i(90342);
    if (paramFragment != null)
    {
      paramFragment = new FragmentWrapper(paramFragment);
      AppMethodBeat.o(90342);
      return paramFragment;
    }
    AppMethodBeat.o(90342);
    return null;
  }
  
  public final IObjectWrapper getActivity()
  {
    AppMethodBeat.i(90343);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getActivity());
    AppMethodBeat.o(90343);
    return localIObjectWrapper;
  }
  
  public final Bundle getArguments()
  {
    AppMethodBeat.i(90344);
    Bundle localBundle = this.zzabm.getArguments();
    AppMethodBeat.o(90344);
    return localBundle;
  }
  
  public final int getId()
  {
    AppMethodBeat.i(90345);
    int i = this.zzabm.getId();
    AppMethodBeat.o(90345);
    return i;
  }
  
  public final IFragmentWrapper getParentFragment()
  {
    AppMethodBeat.i(90346);
    FragmentWrapper localFragmentWrapper = wrap(this.zzabm.getParentFragment());
    AppMethodBeat.o(90346);
    return localFragmentWrapper;
  }
  
  public final IObjectWrapper getResources()
  {
    AppMethodBeat.i(90347);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getResources());
    AppMethodBeat.o(90347);
    return localIObjectWrapper;
  }
  
  public final boolean getRetainInstance()
  {
    AppMethodBeat.i(90348);
    boolean bool = this.zzabm.getRetainInstance();
    AppMethodBeat.o(90348);
    return bool;
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(90349);
    String str = this.zzabm.getTag();
    AppMethodBeat.o(90349);
    return str;
  }
  
  public final IFragmentWrapper getTargetFragment()
  {
    AppMethodBeat.i(90350);
    FragmentWrapper localFragmentWrapper = wrap(this.zzabm.getTargetFragment());
    AppMethodBeat.o(90350);
    return localFragmentWrapper;
  }
  
  public final int getTargetRequestCode()
  {
    AppMethodBeat.i(90351);
    int i = this.zzabm.getTargetRequestCode();
    AppMethodBeat.o(90351);
    return i;
  }
  
  public final boolean getUserVisibleHint()
  {
    AppMethodBeat.i(90352);
    boolean bool = this.zzabm.getUserVisibleHint();
    AppMethodBeat.o(90352);
    return bool;
  }
  
  public final IObjectWrapper getView()
  {
    AppMethodBeat.i(90353);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabm.getView());
    AppMethodBeat.o(90353);
    return localIObjectWrapper;
  }
  
  public final boolean isAdded()
  {
    AppMethodBeat.i(90354);
    boolean bool = this.zzabm.isAdded();
    AppMethodBeat.o(90354);
    return bool;
  }
  
  public final boolean isDetached()
  {
    AppMethodBeat.i(90355);
    boolean bool = this.zzabm.isDetached();
    AppMethodBeat.o(90355);
    return bool;
  }
  
  public final boolean isHidden()
  {
    AppMethodBeat.i(90356);
    boolean bool = this.zzabm.isHidden();
    AppMethodBeat.o(90356);
    return bool;
  }
  
  public final boolean isInLayout()
  {
    AppMethodBeat.i(90357);
    boolean bool = this.zzabm.isInLayout();
    AppMethodBeat.o(90357);
    return bool;
  }
  
  public final boolean isRemoving()
  {
    AppMethodBeat.i(90358);
    boolean bool = this.zzabm.isRemoving();
    AppMethodBeat.o(90358);
    return bool;
  }
  
  public final boolean isResumed()
  {
    AppMethodBeat.i(90359);
    boolean bool = this.zzabm.isResumed();
    AppMethodBeat.o(90359);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(90360);
    boolean bool = this.zzabm.isVisible();
    AppMethodBeat.o(90360);
    return bool;
  }
  
  public final void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90361);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabm.registerForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(90361);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(90362);
    this.zzabm.setHasOptionsMenu(paramBoolean);
    AppMethodBeat.o(90362);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(90363);
    this.zzabm.setMenuVisibility(paramBoolean);
    AppMethodBeat.o(90363);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(90364);
    this.zzabm.setRetainInstance(paramBoolean);
    AppMethodBeat.o(90364);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(90365);
    this.zzabm.setUserVisibleHint(paramBoolean);
    AppMethodBeat.o(90365);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(90366);
    this.zzabm.startActivity(paramIntent);
    AppMethodBeat.o(90366);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(90367);
    this.zzabm.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(90367);
  }
  
  public final void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90368);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabm.unregisterForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(90368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.dynamic.FragmentWrapper
 * JD-Core Version:    0.7.0.1
 */