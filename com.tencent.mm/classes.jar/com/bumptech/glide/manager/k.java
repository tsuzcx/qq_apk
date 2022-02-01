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
  j aBl;
  final a aKK;
  final m aKL;
  private final Set<k> aKM;
  private k aKN;
  Fragment aKO;
  
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
    this.aKL = new k.a(this);
    this.aKM = new HashSet();
    this.aKK = parama;
    AppMethodBeat.o(77555);
  }
  
  private void pw()
  {
    AppMethodBeat.i(77556);
    if (this.aKN != null)
    {
      this.aKN.aKM.remove(this);
      this.aKN = null;
    }
    AppMethodBeat.o(77556);
  }
  
  public final void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(77557);
    super.onAttach(paramActivity);
    try
    {
      pw();
      this.aKN = c.ad(paramActivity).aAz.a(paramActivity.getFragmentManager(), l.l(paramActivity));
      if (!equals(this.aKN)) {
        this.aKN.aKM.add(this);
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
    this.aKK.onDestroy();
    pw();
    AppMethodBeat.o(77561);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(77558);
    super.onDetach();
    pw();
    AppMethodBeat.o(77558);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(77559);
    super.onStart();
    this.aKK.onStart();
    AppMethodBeat.o(77559);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(77560);
    super.onStop();
    this.aKK.onStop();
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
      localObject = this.aKO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.manager.k
 * JD-Core Version:    0.7.0.1
 */