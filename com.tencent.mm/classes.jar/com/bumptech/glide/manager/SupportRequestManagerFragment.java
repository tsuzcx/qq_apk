package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment
  extends Fragment
{
  j aDc;
  final a aMB;
  final m aMC;
  private final Set<SupportRequestManagerFragment> aMD;
  private SupportRequestManagerFragment aMR;
  Fragment aMS;
  
  public SupportRequestManagerFragment()
  {
    this(new a());
    AppMethodBeat.i(77581);
    AppMethodBeat.o(77581);
  }
  
  @SuppressLint({"ValidFragment"})
  private SupportRequestManagerFragment(a parama)
  {
    AppMethodBeat.i(77582);
    this.aMC = new SupportRequestManagerFragment.a(this);
    this.aMD = new HashSet();
    this.aMB = parama;
    AppMethodBeat.o(77582);
  }
  
  private void pO()
  {
    AppMethodBeat.i(77583);
    if (this.aMR != null)
    {
      this.aMR.aMD.remove(this);
      this.aMR = null;
    }
    AppMethodBeat.o(77583);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(77584);
    super.onAttach(paramContext);
    try
    {
      paramContext = getActivity();
      pO();
      this.aMR = c.ad(paramContext).aCq.a(paramContext.getSupportFragmentManager(), l.l(paramContext));
      if (!equals(this.aMR)) {
        this.aMR.aMD.add(this);
      }
      AppMethodBeat.o(77584);
      return;
    }
    catch (IllegalStateException paramContext)
    {
      Log.isLoggable("SupportRMFragment", 5);
      AppMethodBeat.o(77584);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(77588);
    super.onDestroy();
    this.aMB.onDestroy();
    pO();
    AppMethodBeat.o(77588);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(77585);
    super.onDetach();
    this.aMS = null;
    pO();
    AppMethodBeat.o(77585);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(77586);
    super.onStart();
    this.aMB.onStart();
    AppMethodBeat.o(77586);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(77587);
    super.onStop();
    this.aMB.onStop();
    AppMethodBeat.o(77587);
  }
  
  public String toString()
  {
    AppMethodBeat.i(77589);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{parent=");
    Object localObject = getParentFragment();
    if (localObject != null) {}
    for (;;)
    {
      localObject = localObject + "}";
      AppMethodBeat.o(77589);
      return localObject;
      localObject = this.aMS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.manager.SupportRequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */