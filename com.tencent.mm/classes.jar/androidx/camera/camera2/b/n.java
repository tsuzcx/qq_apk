package androidx.camera.camera2.b;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Size;
import androidx.camera.core.impl.a.k;
import androidx.camera.core.impl.bg;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.q;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n
  implements q
{
  private final Map<String, al> BQ;
  private final c BR;
  
  private n(Context paramContext, c paramc, Object paramObject, Set<String> paramSet)
  {
    AppMethodBeat.i(197907);
    this.BQ = new HashMap();
    f.checkNotNull(paramc);
    this.BR = paramc;
    if ((paramObject instanceof androidx.camera.camera2.b.a.n)) {}
    for (paramc = (androidx.camera.camera2.b.a.n)paramObject;; paramc = androidx.camera.camera2.b.a.n.a(paramContext, k.kO()))
    {
      a(paramContext, paramc, paramSet);
      AppMethodBeat.o(197907);
      return;
    }
  }
  
  public n(Context paramContext, Object paramObject, Set<String> paramSet)
  {
    this(paramContext, new c()
    {
      public final boolean x(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(197742);
        boolean bool = CamcorderProfile.hasProfile(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(197742);
        return bool;
      }
      
      public final CamcorderProfile y(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(197747);
        CamcorderProfile localCamcorderProfile = CamcorderProfile.get(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(197747);
        return localCamcorderProfile;
      }
    }, paramObject, paramSet);
    AppMethodBeat.i(197903);
    AppMethodBeat.o(197903);
  }
  
  private void a(Context paramContext, androidx.camera.camera2.b.a.n paramn, Set<String> paramSet)
  {
    AppMethodBeat.i(197914);
    f.checkNotNull(paramContext);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      this.BQ.put(str, new al(paramContext, str, paramn, this.BR));
    }
    AppMethodBeat.o(197914);
  }
  
  public final bg a(String paramString, int paramInt, Size paramSize)
  {
    AppMethodBeat.i(197921);
    paramString = (al)this.BQ.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.a(paramInt, paramSize);; paramString = null)
    {
      AppMethodBeat.o(197921);
      return paramString;
    }
  }
  
  public final Map<bk<?>, Size> a(String paramString, List<bg> paramList, List<bk<?>> paramList1)
  {
    AppMethodBeat.i(197929);
    if (!paramList1.isEmpty()) {}
    al localal;
    for (boolean bool = true;; bool = false)
    {
      f.checkArgument(bool, "No new use cases to be bound.");
      localal = (al)this.BQ.get(paramString);
      if (localal != null) {
        break;
      }
      paramString = new IllegalArgumentException("No such camera id in supported combination list: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(197929);
      throw paramString;
    }
    paramString = localal.b(paramList, paramList1);
    AppMethodBeat.o(197929);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.n
 * JD-Core Version:    0.7.0.1
 */