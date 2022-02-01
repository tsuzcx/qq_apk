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
  private SupportRequestManagerFragment aMI;
  Fragment aMJ;
  final a aMs;
  final m aMt;
  private final Set<SupportRequestManagerFragment> aMu;
  
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
    this.aMt = new a();
    this.aMu = new HashSet();
    this.aMs = parama;
    AppMethodBeat.o(77582);
  }
  
  private void a(SupportRequestManagerFragment paramSupportRequestManagerFragment)
  {
    AppMethodBeat.i(204486);
    this.aMu.remove(paramSupportRequestManagerFragment);
    AppMethodBeat.o(204486);
  }
  
  private void pT()
  {
    AppMethodBeat.i(77583);
    if (this.aMI != null)
    {
      this.aMI.a(this);
      this.aMI = null;
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
      pT();
      this.aMI = c.af(paramContext).aCp.a(paramContext.getSupportFragmentManager(), l.l(paramContext));
      if (!equals(this.aMI)) {
        this.aMI.aMu.add(this);
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
    this.aMs.onDestroy();
    pT();
    AppMethodBeat.o(77588);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(77585);
    super.onDetach();
    this.aMJ = null;
    pT();
    AppMethodBeat.o(77585);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(77586);
    super.onStart();
    this.aMs.onStart();
    AppMethodBeat.o(77586);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(77587);
    super.onStop();
    this.aMs.onStop();
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
      localObject = this.aMJ;
    }
  }
  
  final class a
    implements m
  {
    a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(77580);
      String str = super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
      AppMethodBeat.o(77580);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.SupportRequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */