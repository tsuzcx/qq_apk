package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.a.te.a;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.report.a.1;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;

public final class v
{
  private static v sCz;
  private c<te> kAl;
  private c<fm> sCA;
  boolean sCn;
  boolean sCo;
  boolean sCp;
  HashSet<String> sCq;
  HashSet<String> sCr;
  HashSet<String> sCs;
  boolean sCt;
  String sCu;
  String sCv;
  String sCw;
  String sCx;
  String sCy;
  
  private v()
  {
    AppMethodBeat.i(201337);
    this.sCn = false;
    this.sCo = false;
    this.sCp = false;
    this.sCq = null;
    this.sCr = null;
    this.sCs = null;
    this.sCt = false;
    this.kAl = new c() {};
    this.sCA = new c() {};
    this.sCy = "";
    this.sCx = "";
    this.sCq = new HashSet();
    this.sCr = new HashSet();
    this.sCs = new HashSet();
    AppMethodBeat.o(201337);
  }
  
  private static HashSet<String> a(com.tencent.mm.plugin.expt.b.b.a parama, PBool paramPBool, PString paramPString)
  {
    AppMethodBeat.i(201344);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(parama, "");
    ae.i("MicroMsg.MMSessionReporter", "reset control key[%s] [%s]", new Object[] { parama.name(), str });
    paramPString.value = str;
    if (bu.isNullOrNil(str))
    {
      paramPBool.value = false;
      AppMethodBeat.o(201344);
      return null;
    }
    if ("-1".equalsIgnoreCase(str))
    {
      paramPBool.value = true;
      AppMethodBeat.o(201344);
      return null;
    }
    parama = new HashSet();
    paramPString = str.split(",");
    if ((paramPString != null) && (paramPString.length > 0))
    {
      int j = paramPString.length;
      int i = 0;
      while (i < j)
      {
        parama.add(paramPString[i]);
        i += 1;
      }
    }
    paramPBool.value = false;
    AppMethodBeat.o(201344);
    return parama;
  }
  
  public static v cGr()
  {
    AppMethodBeat.i(201336);
    if (sCz == null) {
      sCz = new v();
    }
    v localv = sCz;
    AppMethodBeat.o(201336);
    return localv;
  }
  
  private void cGt()
  {
    AppMethodBeat.i(201341);
    this.sCn = false;
    this.sCq.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qPD, localPBool, localPString);
    this.sCn = localPBool.value;
    this.sCu = localPString.value;
    if (localHashSet != null) {
      this.sCq.addAll(localHashSet);
    }
    AppMethodBeat.o(201341);
  }
  
  private void cGu()
  {
    AppMethodBeat.i(201342);
    this.sCo = false;
    this.sCr.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qPE, localPBool, localPString);
    this.sCo = localPBool.value;
    this.sCv = localPString.value;
    if (localHashSet != null) {
      this.sCr.addAll(localHashSet);
    }
    AppMethodBeat.o(201342);
  }
  
  private void cGv()
  {
    AppMethodBeat.i(201343);
    this.sCp = false;
    this.sCs.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qPG, localPBool, localPString);
    this.sCp = localPBool.value;
    this.sCw = localPString.value;
    if (localHashSet != null) {
      this.sCs.addAll(localHashSet);
    }
    AppMethodBeat.o(201343);
  }
  
  public final void CA()
  {
    AppMethodBeat.i(201338);
    if (ak.coh())
    {
      cGs();
      com.tencent.mm.sdk.b.a.IvT.b(this.kAl);
      com.tencent.mm.sdk.b.a.IvT.b(this.sCA);
    }
    AppMethodBeat.o(201338);
  }
  
  final void cGs()
  {
    AppMethodBeat.i(201340);
    cGt();
    cGu();
    cGv();
    this.sCt = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPF, false);
    AppMethodBeat.o(201340);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(201339);
    if (ak.coh())
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.kAl);
      com.tencent.mm.sdk.b.a.IvT.d(this.sCA);
    }
    AppMethodBeat.o(201339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.v
 * JD-Core Version:    0.7.0.1
 */