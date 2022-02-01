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
  j aBl;
  final a aKK;
  final m aKL;
  private final Set<SupportRequestManagerFragment> aKM;
  private SupportRequestManagerFragment aLa;
  Fragment aLb;
  
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
    this.aKL = new SupportRequestManagerFragment.a(this);
    this.aKM = new HashSet();
    this.aKK = parama;
    AppMethodBeat.o(77582);
  }
  
  private void pw()
  {
    AppMethodBeat.i(77583);
    if (this.aLa != null)
    {
      this.aLa.aKM.remove(this);
      this.aLa = null;
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
      pw();
      this.aLa = c.ad(paramContext).aAz.a(paramContext.getSupportFragmentManager(), l.l(paramContext));
      if (!equals(this.aLa)) {
        this.aLa.aKM.add(this);
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
    this.aKK.onDestroy();
    pw();
    AppMethodBeat.o(77588);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(77585);
    super.onDetach();
    this.aLb = null;
    pw();
    AppMethodBeat.o(77585);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(77586);
    super.onStart();
    this.aKK.onStart();
    AppMethodBeat.o(77586);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(77587);
    super.onStop();
    this.aKK.onStop();
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
      localObject = this.aLb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.manager.SupportRequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */