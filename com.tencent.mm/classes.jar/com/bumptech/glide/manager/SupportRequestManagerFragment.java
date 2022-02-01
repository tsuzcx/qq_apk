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
  j aAr;
  final a aJU;
  final m aJV;
  private final Set<SupportRequestManagerFragment> aJW;
  private SupportRequestManagerFragment aKk;
  Fragment aKl;
  
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
    this.aJV = new SupportRequestManagerFragment.a(this);
    this.aJW = new HashSet();
    this.aJU = parama;
    AppMethodBeat.o(77582);
  }
  
  private void pm()
  {
    AppMethodBeat.i(77583);
    if (this.aKk != null)
    {
      this.aKk.aJW.remove(this);
      this.aKk = null;
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
      pm();
      this.aKk = c.ac(paramContext).azF.a(paramContext.getSupportFragmentManager(), l.l(paramContext));
      if (!equals(this.aKk)) {
        this.aKk.aJW.add(this);
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
    this.aJU.onDestroy();
    pm();
    AppMethodBeat.o(77588);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(77585);
    super.onDetach();
    this.aKl = null;
    pm();
    AppMethodBeat.o(77585);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(77586);
    super.onStart();
    this.aJU.onStart();
    AppMethodBeat.o(77586);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(77587);
    super.onStop();
    this.aJU.onStop();
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
      localObject = this.aKl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.manager.SupportRequestManagerFragment
 * JD-Core Version:    0.7.0.1
 */