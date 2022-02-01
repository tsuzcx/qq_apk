package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class k
  extends Fragment
{
  j aAr;
  final a aJU;
  final m aJV;
  private final Set<k> aJW;
  private k aJX;
  Fragment aJY;
  
  public k()
  {
    this(new a());
    AppMethodBeat.i(77554);
    AppMethodBeat.o(77554);
  }
  
  @SuppressLint({"ValidFragment"})
  private k(a parama)
  {
    AppMethodBeat.i(77555);
    this.aJV = new k.a(this);
    this.aJW = new HashSet();
    this.aJU = parama;
    AppMethodBeat.o(77555);
  }
  
  private void pm()
  {
    AppMethodBeat.i(77556);
    if (this.aJX != null)
    {
      this.aJX.aJW.remove(this);
      this.aJX = null;
    }
    AppMethodBeat.o(77556);
  }
  
  public final void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(77557);
    super.onAttach(paramActivity);
    try
    {
      pm();
      this.aJX = c.ac(paramActivity).azF.a(paramActivity.getFragmentManager(), l.l(paramActivity));
      if (!equals(this.aJX)) {
        this.aJX.aJW.add(this);
      }
      AppMethodBeat.o(77557);
      return;
    }
    catch (IllegalStateException paramActivity)
    {
      Log.isLoggable("RMFragment", 5);
      AppMethodBeat.o(77557);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(77561);
    super.onDestroy();
    this.aJU.onDestroy();
    pm();
    AppMethodBeat.o(77561);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(77558);
    super.onDetach();
    pm();
    AppMethodBeat.o(77558);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(77559);
    super.onStart();
    this.aJU.onStart();
    AppMethodBeat.o(77559);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(77560);
    super.onStop();
    this.aJU.onStop();
    AppMethodBeat.o(77560);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77562);
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{parent=");
    Object localObject;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject = getParentFragment();
      if (localObject == null) {
        break label68;
      }
    }
    for (;;)
    {
      localObject = localObject + "}";
      AppMethodBeat.o(77562);
      return localObject;
      localObject = null;
      break;
      label68:
      localObject = this.aJY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.manager.k
 * JD-Core Version:    0.7.0.1
 */