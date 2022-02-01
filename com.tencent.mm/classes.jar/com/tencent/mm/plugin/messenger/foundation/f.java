package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.co.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.x.a;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final b zpT;
  private aa zpU;
  
  static
  {
    AppMethodBeat.i(116928);
    zpT = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(z paramz)
  {
    AppMethodBeat.i(116921);
    zpT.add(paramz);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(z paramz)
  {
    AppMethodBeat.i(116922);
    zpT.remove(paramz);
    AppMethodBeat.o(116922);
  }
  
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    x localx = x.a.Qn(paramabn.Lms);
    if (localx != null) {
      try
      {
        localx.a(paramabn, paramArrayOfByte, paramBoolean, this.zpU);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramabn)
      {
        Log.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramabn.getMessage());
        paramabn = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramabn;
      }
    }
    Log.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramabn.Lms) });
    AppMethodBeat.o(116924);
  }
  
  public final void dA(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof k))
    {
      this.zpU.dkt();
      ((l)g.af(l.class)).eiy().aEt(((k)paramObject).TAG);
      zpT.aR(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.zpU.dkt();
      ((l)g.af(l.class)).eiy().aEt((String)paramObject);
      zpT.aR(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof q.c))
    {
      this.zpU.dkt();
      ((l)g.af(l.class)).eiy().aEt(paramObject.toString());
      zpT.aR(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void dB(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof k)) {
      ((l)g.af(l.class)).eiy().aEt(((k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void dC(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof q.c)) {
      zpT.aS(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  public final void dz(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = ab.eiz();
    if (localc != null) {
      this.zpU = ((aa)localc.get());
    }
    if (this.zpU == null) {
      this.zpU = new a((byte)0);
    }
    if ((paramObject instanceof k))
    {
      ((l)g.af(l.class)).eiy().aEs(((k)paramObject).TAG);
      zpT.aQ(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((l)g.af(l.class)).eiy().aEs((String)paramObject);
        zpT.aQ(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof q.c))
    {
      ((l)g.af(l.class)).eiy().aEs(paramObject.toString());
      zpT.aQ(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  static final class a
    implements aa
  {
    public final void a(ca paramca, de paramde) {}
    
    public final void dkt() {}
  }
  
  static final class b
    extends a<z>
    implements z
  {
    public final void aQ(final Object paramObject)
    {
      AppMethodBeat.i(116918);
      a(new a.a() {});
      AppMethodBeat.o(116918);
    }
    
    public final void aR(final Object paramObject)
    {
      AppMethodBeat.i(116919);
      a(new a.a() {});
      AppMethodBeat.o(116919);
    }
    
    public final void aS(final Object paramObject)
    {
      AppMethodBeat.i(116920);
      a(new a.a() {});
      AppMethodBeat.o(116920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f
 * JD-Core Version:    0.7.0.1
 */