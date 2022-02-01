package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.a.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.google.firebase.components.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar
  implements e
{
  @Keep
  public final List<com.google.firebase.components.a<?>> getComponents()
  {
    AppMethodBeat.i(4148);
    Object localObject = com.google.firebase.components.a.x(FirebaseInstanceId.class).a(f.z(com.google.firebase.a.class)).a(g.bLi);
    if (((a.a)localObject).zzad == 0) {}
    for (boolean bool = true;; bool = false)
    {
      r.b(bool, "Instantiation type has already been set.");
      ((a.a)localObject).zzad = 1;
      localObject = Arrays.asList(new com.google.firebase.components.a[] { ((a.a)localObject).xR(), com.google.firebase.components.a.x(com.google.firebase.iid.a.a.class).a(f.z(FirebaseInstanceId.class)).a(h.bLi).xR() });
      AppMethodBeat.o(4148);
      return localObject;
    }
  }
  
  static final class a
    implements com.google.firebase.iid.a.a
  {
    private final FirebaseInstanceId bLb;
    
    public a(FirebaseInstanceId paramFirebaseInstanceId)
    {
      this.bLb = paramFirebaseInstanceId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.Registrar
 * JD-Core Version:    0.7.0.1
 */