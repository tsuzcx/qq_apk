package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.td.a;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.report.a.1;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;

public final class u
{
  private static u ssp;
  private c<td> kwW;
  boolean ssd;
  boolean sse;
  boolean ssf;
  HashSet<String> ssg;
  HashSet<String> ssh;
  HashSet<String> ssi;
  boolean ssj;
  String ssk;
  String ssl;
  String ssm;
  String ssn;
  String sso;
  private c<fl> ssq;
  
  private u()
  {
    AppMethodBeat.i(200916);
    this.ssd = false;
    this.sse = false;
    this.ssf = false;
    this.ssg = null;
    this.ssh = null;
    this.ssi = null;
    this.ssj = false;
    this.kwW = new c() {};
    this.ssq = new c() {};
    this.sso = "";
    this.ssn = "";
    this.ssg = new HashSet();
    this.ssh = new HashSet();
    this.ssi = new HashSet();
    AppMethodBeat.o(200916);
  }
  
  private static HashSet<String> a(com.tencent.mm.plugin.expt.b.b.a parama, PBool paramPBool, PString paramPString)
  {
    AppMethodBeat.i(200923);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(parama, "");
    ad.i("MicroMsg.MMSessionReporter", "reset control key[%s] [%s]", new Object[] { parama.name(), str });
    paramPString.value = str;
    if (bt.isNullOrNil(str))
    {
      paramPBool.value = false;
      AppMethodBeat.o(200923);
      return null;
    }
    if ("-1".equalsIgnoreCase(str))
    {
      paramPBool.value = true;
      AppMethodBeat.o(200923);
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
    AppMethodBeat.o(200923);
    return parama;
  }
  
  public static u cEv()
  {
    AppMethodBeat.i(200915);
    if (ssp == null) {
      ssp = new u();
    }
    u localu = ssp;
    AppMethodBeat.o(200915);
    return localu;
  }
  
  private void cEx()
  {
    AppMethodBeat.i(200920);
    this.ssd = false;
    this.ssg.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qHX, localPBool, localPString);
    this.ssd = localPBool.value;
    this.ssk = localPString.value;
    if (localHashSet != null) {
      this.ssg.addAll(localHashSet);
    }
    AppMethodBeat.o(200920);
  }
  
  private void cEy()
  {
    AppMethodBeat.i(200921);
    this.sse = false;
    this.ssh.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qHY, localPBool, localPString);
    this.sse = localPBool.value;
    this.ssl = localPString.value;
    if (localHashSet != null) {
      this.ssh.addAll(localHashSet);
    }
    AppMethodBeat.o(200921);
  }
  
  private void cEz()
  {
    AppMethodBeat.i(200922);
    this.ssf = false;
    this.ssi.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(com.tencent.mm.plugin.expt.b.b.a.qIa, localPBool, localPString);
    this.ssf = localPBool.value;
    this.ssm = localPString.value;
    if (localHashSet != null) {
      this.ssi.addAll(localHashSet);
    }
    AppMethodBeat.o(200922);
  }
  
  public final void Cx()
  {
    AppMethodBeat.i(200917);
    if (aj.cmR())
    {
      cEw();
      com.tencent.mm.sdk.b.a.IbL.b(this.kwW);
      com.tencent.mm.sdk.b.a.IbL.b(this.ssq);
    }
    AppMethodBeat.o(200917);
  }
  
  final void cEw()
  {
    AppMethodBeat.i(200919);
    cEx();
    cEy();
    cEz();
    this.ssj = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHZ, false);
    AppMethodBeat.o(200919);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(200918);
    if (aj.cmR())
    {
      com.tencent.mm.sdk.b.a.IbL.d(this.kwW);
      com.tencent.mm.sdk.b.a.IbL.d(this.ssq);
    }
    AppMethodBeat.o(200918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.u
 * JD-Core Version:    0.7.0.1
 */