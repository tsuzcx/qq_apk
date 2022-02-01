package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.c;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.q.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ab.a;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class h
  implements f
{
  private static final h.b EVs;
  private ae EVt;
  
  static
  {
    AppMethodBeat.i(116928);
    EVs = new h.b((byte)0);
    AppMethodBeat.o(116928);
  }
  
  public static void addSyncDoCmdCallback(ad paramad)
  {
    AppMethodBeat.i(116921);
    EVs.add(paramad);
    AppMethodBeat.o(116921);
  }
  
  public static void removeSyncDoCmdCallback(ad paramad)
  {
    AppMethodBeat.i(116922);
    EVs.remove(paramad);
    AppMethodBeat.o(116922);
  }
  
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(116924);
    ab localab = ab.a.WA(paramabu.SnG);
    if (localab != null) {
      try
      {
        localab.a(paramabu, paramArrayOfByte, paramBoolean, this.EVt);
        AppMethodBeat.o(116924);
        return;
      }
      catch (IOException paramabu)
      {
        Log.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramabu.getMessage());
        paramabu = new RuntimeException("docmd: parse protobuf error");
        AppMethodBeat.o(116924);
        throw paramabu;
      }
    }
    Log.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramabu.SnG) });
    AppMethodBeat.o(116924);
  }
  
  public final void dC(Object paramObject)
  {
    AppMethodBeat.i(116923);
    c localc = af.eSf();
    if (localc != null) {
      this.EVt = ((ae)localc.get());
    }
    if (this.EVt == null) {
      this.EVt = new a((byte)0);
    }
    if ((paramObject instanceof k))
    {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOC(((k)paramObject).TAG);
      EVs.aU(paramObject);
      AppMethodBeat.o(116923);
      return;
    }
    if ((paramObject instanceof String))
    {
      if (paramObject.equals("NetSceneInit"))
      {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOC((String)paramObject);
        EVs.aU(paramObject);
        AppMethodBeat.o(116923);
      }
    }
    else if ((paramObject instanceof q.c))
    {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOC(paramObject.toString());
      EVs.aU(paramObject);
    }
    AppMethodBeat.o(116923);
  }
  
  public final void dD(Object paramObject)
  {
    AppMethodBeat.i(116925);
    if ((paramObject instanceof k))
    {
      this.EVt.dKq();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOD(((k)paramObject).TAG);
      EVs.aV(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      this.EVt.dKq();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOD((String)paramObject);
      EVs.aV(paramObject);
      AppMethodBeat.o(116925);
      return;
    }
    if ((paramObject instanceof q.c))
    {
      this.EVt.dKq();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOD(paramObject.toString());
      EVs.aV(paramObject);
    }
    AppMethodBeat.o(116925);
  }
  
  public final void dE(Object paramObject)
  {
    AppMethodBeat.i(116926);
    if ((paramObject instanceof k)) {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOD(((k)paramObject).TAG);
    }
    AppMethodBeat.o(116926);
  }
  
  public final void dF(Object paramObject)
  {
    AppMethodBeat.i(116927);
    if ((paramObject instanceof k))
    {
      EVs.aW(paramObject);
      AppMethodBeat.o(116927);
      return;
    }
    if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
    {
      EVs.aW(paramObject);
      AppMethodBeat.o(116927);
      return;
    }
    if ((paramObject instanceof q.c)) {
      EVs.aW(paramObject);
    }
    AppMethodBeat.o(116927);
  }
  
  static final class a
    implements ae
  {
    public final void a(ca paramca, db paramdb) {}
    
    public final void dKq() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.h
 * JD-Core Version:    0.7.0.1
 */