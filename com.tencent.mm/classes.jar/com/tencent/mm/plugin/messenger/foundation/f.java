package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.cn.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.w.a;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private static final b vJK;
  private z vJL;
  
  static
  {
    AppMethodBeat.i(116928);
    vJK = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(y paramy)
  {
    AppMethodBeat.i(116921);
    vJK.bu(paramy);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(y paramy)
  {
    AppMethodBeat.i(116922);
    vJK.remove(paramy);
    AppMethodBeat.o(116922);
  }
  
  public final void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    w localw = w.a.JM(paramzu.FYU);
    if (localw != null) {
      try
      {
        localw.a(paramzu, paramArrayOfByte, paramBoolean, this.vJL);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramzu)
      {
        ad.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramzu.getMessage());
        paramzu = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramzu;
      }
    }
    ad.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramzu.FYU) });
    AppMethodBeat.o(116924);
  }
  
  public final void dr(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = aa.dlL();
    if (localc != null) {
      this.vJL = ((z)localc.get());
    }
    if (this.vJL == null) {
      this.vJL = new a((byte)0);
    }
    if ((paramObject instanceof k))
    {
      ((l)g.ab(l.class)).dlK().apS(((k)paramObject).TAG);
      vJK.aI(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((l)g.ab(l.class)).dlK().apS((String)paramObject);
        vJK.aI(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof q.c))
    {
      ((l)g.ab(l.class)).dlK().apS(paramObject.toString());
      vJK.aI(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void ds(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof k))
    {
      this.vJL.cCF();
      ((l)g.ab(l.class)).dlK().apT(((k)paramObject).TAG);
      vJK.aJ(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.vJL.cCF();
      ((l)g.ab(l.class)).dlK().apT((String)paramObject);
      vJK.aJ(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof q.c))
    {
      this.vJL.cCF();
      ((l)g.ab(l.class)).dlK().apT(paramObject.toString());
      vJK.aJ(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void dt(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof k)) {
      ((l)g.ab(l.class)).dlK().apT(((k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void du(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof q.c)) {
      vJK.aK(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  static final class a
    implements z
  {
    public final void a(bu parambu, cv paramcv) {}
    
    public final void cCF() {}
  }
  
  static final class b
    extends a<y>
    implements y
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