package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FragmentWrapper
{
  private android.app.Fragment nativeFragment;
  private androidx.fragment.app.Fragment supportFragment;
  
  public FragmentWrapper(android.app.Fragment paramFragment)
  {
    AppMethodBeat.i(7672);
    Validate.notNull(paramFragment, "fragment");
    this.nativeFragment = paramFragment;
    AppMethodBeat.o(7672);
  }
  
  public FragmentWrapper(androidx.fragment.app.Fragment paramFragment)
  {
    AppMethodBeat.i(222899);
    Validate.notNull(paramFragment, "fragment");
    this.supportFragment = paramFragment;
    AppMethodBeat.o(222899);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(7674);
    if (this.supportFragment != null)
    {
      localObject = this.supportFragment.getActivity();
      AppMethodBeat.o(7674);
      return localObject;
    }
    Object localObject = this.nativeFragment.getActivity();
    AppMethodBeat.o(7674);
    return localObject;
  }
  
  public android.app.Fragment getNativeFragment()
  {
    return this.nativeFragment;
  }
  
  public androidx.fragment.app.Fragment getSupportFragment()
  {
    return this.supportFragment;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(7673);
    if (this.supportFragment != null)
    {
      this.supportFragment.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(7673);
      return;
    }
    this.nativeFragment.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(7673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.FragmentWrapper
 * JD-Core Version:    0.7.0.1
 */