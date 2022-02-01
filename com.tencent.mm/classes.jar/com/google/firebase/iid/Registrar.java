package com.google.firebase.iid;

import com.google.firebase.components.a.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.google.firebase.components.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class Registrar
  implements e
{
  public final List<com.google.firebase.components.a<?>> getComponents()
  {
    AppMethodBeat.i(4148);
    Object localObject = com.google.firebase.components.a.w(FirebaseInstanceId.class).a(f.y(com.google.firebase.a.class)).a(g.dCL);
    if (((a.a)localObject).zzad == 0) {}
    for (boolean bool = true;; bool = false)
    {
      r.b(bool, "Instantiation type has already been set.");
      ((a.a)localObject).zzad = 1;
      localObject = Arrays.asList(new com.google.firebase.components.a[] { ((a.a)localObject).Ye(), com.google.firebase.components.a.w(com.google.firebase.iid.a.a.class).a(f.y(FirebaseInstanceId.class)).a(h.dCL).Ye() });
      AppMethodBeat.o(4148);
      return localObject;
    }
  }
  
  static final class a
    implements com.google.firebase.iid.a.a
  {
    private final FirebaseInstanceId dCE;
    
    public a(FirebaseInstanceId paramFirebaseInstanceId)
    {
      this.dCE = paramFirebaseInstanceId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.Registrar
 * JD-Core Version:    0.7.0.1
 */