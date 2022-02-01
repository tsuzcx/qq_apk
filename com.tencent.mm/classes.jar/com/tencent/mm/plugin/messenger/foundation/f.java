package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.co.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final b typ;
  private x tyq;
  
  static
  {
    AppMethodBeat.i(116928);
    typ = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(w paramw)
  {
    AppMethodBeat.i(116921);
    typ.bv(paramw);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(w paramw)
  {
    AppMethodBeat.i(116922);
    typ.remove(paramw);
    AppMethodBeat.o(116922);
  }
  
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    u localu = u.a.Gt(paramxd.CYY);
    if (localu != null) {
      try
      {
        localu.a(paramxd, paramArrayOfByte, paramBoolean, this.tyq);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramxd)
      {
        ad.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramxd.getMessage());
        paramxd = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramxd;
      }
    }
    ad.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramxd.CYY) });
    AppMethodBeat.o(116924);
  }
  
  public final void dn(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = y.cOK();
    if (localc != null) {
      this.tyq = ((x)localc.get());
    }
    if (this.tyq == null) {
      this.tyq = new a((byte)0);
    }
    if ((paramObject instanceof com.tencent.mm.modelmulti.k))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agl(((com.tencent.mm.modelmulti.k)paramObject).TAG);
      typ.aJ(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agl((String)paramObject);
        typ.aJ(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof p.c))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agl(paramObject.toString());
      typ.aJ(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof com.tencent.mm.modelmulti.k))
    {
      this.tyq.cOJ();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agm(((com.tencent.mm.modelmulti.k)paramObject).TAG);
      typ.aK(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.tyq.cOJ();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agm((String)paramObject);
      typ.aK(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof p.c))
    {
      this.tyq.cOJ();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agm(paramObject.toString());
      typ.aK(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof com.tencent.mm.modelmulti.k)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agm(((com.tencent.mm.modelmulti.k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void dq(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof p.c)) {
      typ.aL(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  static final class a
    implements x
  {
    public final void a(bl parambl, cs paramcs) {}
    
    public final void cOJ() {}
  }
  
  static final class b
    extends a<w>
    implements w
  {
    public final void aJ(final Object paramObject)
    {
      AppMethodBeat.i(116918);
      a(new a.a() {});
      AppMethodBeat.o(116918);
    }
    
    public final void aK(final Object paramObject)
    {
      AppMethodBeat.i(116919);
      a(new a.a() {});
      AppMethodBeat.o(116919);
    }
    
    public final void aL(final Object paramObject)
    {
      AppMethodBeat.i(116920);
      a(new a.a() {});
      AppMethodBeat.o(116920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f
 * JD-Core Version:    0.7.0.1
 */