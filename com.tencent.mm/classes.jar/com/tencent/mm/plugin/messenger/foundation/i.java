package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.cp.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.io.IOException;

public final class i
  implements f
{
  private static final b KQT;
  private ae KQU;
  
  static
  {
    AppMethodBeat.i(116928);
    KQT = new b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(ad paramad)
  {
    AppMethodBeat.i(116921);
    KQT.add(paramad);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(ad paramad)
  {
    AppMethodBeat.i(116922);
    KQT.remove(paramad);
    AppMethodBeat.o(116922);
  }
  
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    ab localab = ab.a.aaC(paramadw.Zmc);
    if (localab != null) {
      try
      {
        localab.a(paramadw, paramArrayOfByte, paramBoolean, this.KQU);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramadw)
      {
        Log.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramadw.getMessage());
        paramadw = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramadw;
      }
    }
    Log.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramadw.Zmc) });
    AppMethodBeat.o(116924);
  }
  
  public final void fT(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = af.gba();
    if (localc != null) {
      this.KQU = ((ae)localc.get());
    }
    if (this.KQU == null) {
      this.KQU = new a();
    }
    if ((paramObject instanceof p))
    {
      ((n)h.ax(n.class)).gaZ().aLB(((p)paramObject).TAG);
      KQT.cq(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((n)h.ax(n.class)).gaZ().aLB((String)paramObject);
        KQT.cq(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof e))
    {
      ((n)h.ax(n.class)).gaZ().aLB(paramObject.toString());
      KQT.cq(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void fU(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof p))
    {
      this.KQU.dir();
      ((n)h.ax(n.class)).gaZ().aLC(((p)paramObject).TAG);
      KQT.cr(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.KQU.dir();
      ((n)h.ax(n.class)).gaZ().aLC((String)paramObject);
      KQT.cr(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof e))
    {
      this.KQU.dir();
      ((n)h.ax(n.class)).gaZ().aLC(paramObject.toString());
      KQT.cr(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void fV(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof p)) {
      ((n)h.ax(n.class)).gaZ().aLC(((p)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void fW(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof p))
    {
      KQT.cs(paramObject);
      AppMethodBeat.o(116927);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      KQT.cs(paramObject);
      AppMethodBeat.o(116927);
      return;
    }
    if ((paramObject instanceof e)) {
      KQT.cs(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  public static final class a
    implements ae
  {
    public final void a(cc paramcc, dl paramdl) {}
    
    public final void dir() {}
  }
  
  static final class b
    extends a<ad>
    implements ad
  {
    public final void cq(final Object paramObject)
    {
      AppMethodBeat.i(116918);
      a(new a.a() {});
      AppMethodBeat.o(116918);
    }
    
    public final void cr(final Object paramObject)
    {
      AppMethodBeat.i(116919);
      a(new a.a() {});
      AppMethodBeat.o(116919);
    }
    
    public final void cs(final Object paramObject)
    {
      AppMethodBeat.i(116920);
      a(new a.a() {});
      AppMethodBeat.o(116920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.i
 * JD-Core Version:    0.7.0.1
 */