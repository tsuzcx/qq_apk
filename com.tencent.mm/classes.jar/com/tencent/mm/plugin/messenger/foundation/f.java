package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.cn.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final b uGN;
  private x uGO;
  
  static
  {
    AppMethodBeat.i(116928);
    uGN = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(w paramw)
  {
    AppMethodBeat.i(116921);
    uGN.bs(paramw);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(w paramw)
  {
    AppMethodBeat.i(116922);
    uGN.remove(paramw);
    AppMethodBeat.o(116922);
  }
  
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    u localu = u.a.Ip(paramxv.ErL);
    if (localu != null) {
      try
      {
        localu.a(paramxv, paramArrayOfByte, paramBoolean, this.uGO);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramxv)
      {
        ac.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramxv.getMessage());
        paramxv = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramxv;
      }
    }
    ac.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramxv.ErL) });
    AppMethodBeat.o(116924);
  }
  
  public final void jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = y.dct();
    if (localc != null) {
      this.uGO = ((x)localc.get());
    }
    if (this.uGO == null) {
      this.uGO = new a((byte)0);
    }
    if ((paramObject instanceof com.tencent.mm.modelmulti.k))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alf(((com.tencent.mm.modelmulti.k)paramObject).TAG);
      uGN.aG(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alf((String)paramObject);
        uGN.aG(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof p.c))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alf(paramObject.toString());
      uGN.aG(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof com.tencent.mm.modelmulti.k))
    {
      this.uGO.dcs();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alg(((com.tencent.mm.modelmulti.k)paramObject).TAG);
      uGN.aH(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.uGO.dcs();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alg((String)paramObject);
      uGN.aH(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof p.c))
    {
      this.uGO.dcs();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alg(paramObject.toString());
      uGN.aH(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void dq(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof com.tencent.mm.modelmulti.k)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alg(((com.tencent.mm.modelmulti.k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void dr(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof p.c)) {
      uGN.aI(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  static final class a
    implements x
  {
    public final void a(bo parambo, cu paramcu) {}
    
    public final void dcs() {}
  }
  
  static final class b
    extends a<w>
    implements w
  {
    public final void aG(final Object paramObject)
    {
      AppMethodBeat.i(116918);
      a(new a.a() {});
      AppMethodBeat.o(116918);
    }
    
    public final void aH(final Object paramObject)
    {
      AppMethodBeat.i(116919);
      a(new a.a() {});
      AppMethodBeat.o(116919);
    }
    
    public final void aI(final Object paramObject)
    {
      AppMethodBeat.i(116920);
      a(new a.a() {});
      AppMethodBeat.o(116920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f
 * JD-Core Version:    0.7.0.1
 */