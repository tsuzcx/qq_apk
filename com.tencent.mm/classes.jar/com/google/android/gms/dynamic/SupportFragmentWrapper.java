package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SupportFragmentWrapper
  extends IFragmentWrapper.Stub
{
  private Fragment zzabq;
  
  private SupportFragmentWrapper(Fragment paramFragment)
  {
    this.zzabq = paramFragment;
  }
  
  public static SupportFragmentWrapper wrap(Fragment paramFragment)
  {
    AppMethodBeat.i(90398);
    if (paramFragment != null)
    {
      paramFragment = new SupportFragmentWrapper(paramFragment);
      AppMethodBeat.o(90398);
      return paramFragment;
    }
    AppMethodBeat.o(90398);
    return null;
  }
  
  public final IObjectWrapper getActivity()
  {
    AppMethodBeat.i(90399);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getActivity());
    AppMethodBeat.o(90399);
    return localIObjectWrapper;
  }
  
  public final Bundle getArguments()
  {
    AppMethodBeat.i(90400);
    Bundle localBundle = this.zzabq.getArguments();
    AppMethodBeat.o(90400);
    return localBundle;
  }
  
  public final int getId()
  {
    AppMethodBeat.i(90401);
    int i = this.zzabq.getId();
    AppMethodBeat.o(90401);
    return i;
  }
  
  public final IFragmentWrapper getParentFragment()
  {
    AppMethodBeat.i(90402);
    SupportFragmentWrapper localSupportFragmentWrapper = wrap(this.zzabq.getParentFragment());
    AppMethodBeat.o(90402);
    return localSupportFragmentWrapper;
  }
  
  public final IObjectWrapper getResources()
  {
    AppMethodBeat.i(90403);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getResources());
    AppMethodBeat.o(90403);
    return localIObjectWrapper;
  }
  
  public final boolean getRetainInstance()
  {
    AppMethodBeat.i(90404);
    boolean bool = this.zzabq.getRetainInstance();
    AppMethodBeat.o(90404);
    return bool;
  }
  
  public final String getTag()
  {
    AppMethodBeat.i(90405);
    String str = this.zzabq.getTag();
    AppMethodBeat.o(90405);
    return str;
  }
  
  public final IFragmentWrapper getTargetFragment()
  {
    AppMethodBeat.i(90406);
    SupportFragmentWrapper localSupportFragmentWrapper = wrap(this.zzabq.getTargetFragment());
    AppMethodBeat.o(90406);
    return localSupportFragmentWrapper;
  }
  
  public final int getTargetRequestCode()
  {
    AppMethodBeat.i(90407);
    int i = this.zzabq.getTargetRequestCode();
    AppMethodBeat.o(90407);
    return i;
  }
  
  public final boolean getUserVisibleHint()
  {
    AppMethodBeat.i(90408);
    boolean bool = this.zzabq.getUserVisibleHint();
    AppMethodBeat.o(90408);
    return bool;
  }
  
  public final IObjectWrapper getView()
  {
    AppMethodBeat.i(90409);
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(this.zzabq.getView());
    AppMethodBeat.o(90409);
    return localIObjectWrapper;
  }
  
  public final boolean isAdded()
  {
    AppMethodBeat.i(90410);
    boolean bool = this.zzabq.isAdded();
    AppMethodBeat.o(90410);
    return bool;
  }
  
  public final boolean isDetached()
  {
    AppMethodBeat.i(90411);
    boolean bool = this.zzabq.isDetached();
    AppMethodBeat.o(90411);
    return bool;
  }
  
  public final boolean isHidden()
  {
    AppMethodBeat.i(90412);
    boolean bool = this.zzabq.isHidden();
    AppMethodBeat.o(90412);
    return bool;
  }
  
  public final boolean isInLayout()
  {
    AppMethodBeat.i(90413);
    boolean bool = this.zzabq.isInLayout();
    AppMethodBeat.o(90413);
    return bool;
  }
  
  public final boolean isRemoving()
  {
    AppMethodBeat.i(90414);
    boolean bool = this.zzabq.isRemoving();
    AppMethodBeat.o(90414);
    return bool;
  }
  
  public final boolean isResumed()
  {
    AppMethodBeat.i(90415);
    boolean bool = this.zzabq.isResumed();
    AppMethodBeat.o(90415);
    return bool;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(90416);
    boolean bool = this.zzabq.isVisible();
    AppMethodBeat.o(90416);
    return bool;
  }
  
  public final void registerForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90417);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabq.registerForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(90417);
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(90418);
    this.zzabq.setHasOptionsMenu(paramBoolean);
    AppMethodBeat.o(90418);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(90419);
    this.zzabq.setMenuVisibility(paramBoolean);
    AppMethodBeat.o(90419);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    AppMethodBeat.i(90420);
    this.zzabq.setRetainInstance(paramBoolean);
    AppMethodBeat.o(90420);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(90421);
    this.zzabq.setUserVisibleHint(paramBoolean);
    AppMethodBeat.o(90421);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(90422);
    this.zzabq.startActivity(paramIntent);
    AppMethodBeat.o(90422);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(90423);
    this.zzabq.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(90423);
  }
  
  public final void unregisterForContextMenu(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(90424);
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzabq.unregisterForContextMenu(paramIObjectWrapper);
    AppMethodBeat.o(90424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.dynamic.SupportFragmentWrapper
 * JD-Core Version:    0.7.0.1
 */