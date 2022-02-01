package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class hv
  extends hu
{
  protected boolean i;
  protected List<hu> j;
  
  public hv(boolean paramBoolean)
  {
    AppMethodBeat.i(226226);
    this.i = true;
    this.j = null;
    this.i = paramBoolean;
    if (this.j == null) {
      this.j = new ArrayList();
    }
    AppMethodBeat.o(226226);
  }
  
  protected final void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226247);
    if (this.j == null)
    {
      AppMethodBeat.o(226247);
      return;
    }
    int m = this.j.size();
    if (m == 0)
    {
      AppMethodBeat.o(226247);
      return;
    }
    int k = 0;
    if (k < m)
    {
      hu localhu = (hu)this.j.get(k);
      if (localhu != null)
      {
        if (!this.i) {
          break label89;
        }
        localhu.a(paramFloat, paramInterpolator);
      }
      for (;;)
      {
        k += 1;
        break;
        label89:
        localhu.a(paramFloat, localhu.f);
      }
    }
    AppMethodBeat.o(226247);
  }
  
  public final void a(long paramLong)
  {
    AppMethodBeat.i(226243);
    super.a(paramLong);
    if (this.j == null)
    {
      AppMethodBeat.o(226243);
      return;
    }
    int m = this.j.size();
    if (m == 0)
    {
      AppMethodBeat.o(226243);
      return;
    }
    int k = 0;
    while (k < m)
    {
      hu localhu = (hu)this.j.get(k);
      if (localhu != null) {
        localhu.a(paramLong);
      }
      k += 1;
    }
    AppMethodBeat.o(226243);
  }
  
  public final void a(hu.b paramb)
  {
    AppMethodBeat.i(226255);
    super.a(paramb);
    if (this.j == null)
    {
      AppMethodBeat.o(226255);
      return;
    }
    int m = this.j.size();
    if (m == 0)
    {
      AppMethodBeat.o(226255);
      return;
    }
    int k = 0;
    while (k < m)
    {
      hu localhu = (hu)this.j.get(k);
      if (localhu != null) {
        localhu.a(paramb);
      }
      k += 1;
    }
    AppMethodBeat.o(226255);
  }
  
  public final void a(hu paramhu)
  {
    AppMethodBeat.i(226231);
    if (paramhu == null)
    {
      AppMethodBeat.o(226231);
      return;
    }
    this.j.add(paramhu);
    AppMethodBeat.o(226231);
  }
  
  public final boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(226251);
    boolean bool = super.a(paramGeoPoint1, paramGeoPoint2);
    if (!bool)
    {
      AppMethodBeat.o(226251);
      return false;
    }
    if (this.j == null)
    {
      AppMethodBeat.o(226251);
      return false;
    }
    int m = this.j.size();
    if (m == 0)
    {
      AppMethodBeat.o(226251);
      return false;
    }
    int k = 0;
    if (k < m)
    {
      hu localhu = (hu)this.j.get(k);
      if (localhu == null) {
        break label129;
      }
      if ((bool) && (localhu.a(paramGeoPoint1, paramGeoPoint2))) {
        bool = true;
      }
    }
    label129:
    for (;;)
    {
      k += 1;
      break;
      bool = false;
      continue;
      AppMethodBeat.o(226251);
      return bool;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(226237);
    if (this.j == null)
    {
      AppMethodBeat.o(226237);
      return;
    }
    this.j.clear();
    AppMethodBeat.o(226237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hv
 * JD-Core Version:    0.7.0.1
 */