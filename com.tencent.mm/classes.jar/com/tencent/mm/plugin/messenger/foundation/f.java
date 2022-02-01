package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.cm.c;
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
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final b vVO;
  private aa vVP;
  
  static
  {
    AppMethodBeat.i(116928);
    vVO = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(z paramz)
  {
    AppMethodBeat.i(116921);
    vVO.bu(paramz);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(z paramz)
  {
    AppMethodBeat.i(116922);
    vVO.remove(paramz);
    AppMethodBeat.o(116922);
  }
  
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    x localx = x.a.Kl(paramzx.Gru);
    if (localx != null) {
      try
      {
        localx.a(paramzx, paramArrayOfByte, paramBoolean, this.vVP);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramzx)
      {
        ae.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramzx.getMessage());
        paramzx = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramzx;
      }
    }
    ae.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramzx.Gru) });
    AppMethodBeat.o(116924);
  }
  
  public final void ds(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = ab.doK();
    if (localc != null) {
      this.vVP = ((aa)localc.get());
    }
    if (this.vVP == null) {
      this.vVP = new a((byte)0);
    }
    if ((paramObject instanceof k))
    {
      ((l)g.ab(l.class)).doJ().aqX(((k)paramObject).TAG);
      vVO.aI(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((l)g.ab(l.class)).doJ().aqX((String)paramObject);
        vVO.aI(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof q.c))
    {
      ((l)g.ab(l.class)).doJ().aqX(paramObject.toString());
      vVO.aI(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void dt(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof k))
    {
      this.vVP.cEs();
      ((l)g.ab(l.class)).doJ().aqY(((k)paramObject).TAG);
      vVO.aJ(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.vVP.cEs();
      ((l)g.ab(l.class)).doJ().aqY((String)paramObject);
      vVO.aJ(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof q.c))
    {
      this.vVP.cEs();
      ((l)g.ab(l.class)).doJ().aqY(paramObject.toString());
      vVO.aJ(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void du(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof k)) {
      ((l)g.ab(l.class)).doJ().aqY(((k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void dv(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof q.c)) {
      vVO.aK(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  static final class a
    implements aa
  {
    public final void a(bv parambv, cv paramcv) {}
    
    public final void cEs() {}
  }
  
  static final class b
    extends a<z>
    implements z
  {
    public final void aI(final Object paramObject)
    {
      AppMethodBeat.i(116918);
      a(new a.a() {});
      AppMethodBeat.o(116918);
    }
    
    public final void aJ(final Object paramObject)
    {
      AppMethodBeat.i(116919);
      a(new a.a() {});
      AppMethodBeat.o(116919);
    }
    
    public final void aK(final Object paramObject)
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