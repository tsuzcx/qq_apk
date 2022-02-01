package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.a.uc.a;
import com.tencent.mm.g.b.a.fc;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.a.1;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class ad
{
  private static ad viu;
  String kvy;
  private IListener<uc> lEE;
  private IListener<fp> qZd;
  boolean vij;
  boolean vik;
  boolean vil;
  HashSet<String> vim;
  HashSet<String> vin;
  HashSet<String> vio;
  boolean vip;
  String viq;
  String vir;
  String vis;
  String vit;
  
  private ad()
  {
    AppMethodBeat.i(241804);
    this.vij = false;
    this.vik = false;
    this.vil = false;
    this.vim = null;
    this.vin = null;
    this.vio = null;
    this.vip = false;
    this.lEE = new IListener() {};
    this.qZd = new IListener() {};
    this.vit = "";
    this.kvy = "";
    this.vim = new HashSet();
    this.vin = new HashSet();
    this.vio = new HashSet();
    AppMethodBeat.o(241804);
  }
  
  private static HashSet<String> a(b.a parama, PBool paramPBool, PString paramPString)
  {
    AppMethodBeat.i(241811);
    String str = ((b)g.af(b.class)).a(parama, "");
    Log.i("MicroMsg.MMSessionReporter", "reset control key[%s] [%s]", new Object[] { parama.name(), str });
    paramPString.value = str;
    if (Util.isNullOrNil(str))
    {
      paramPBool.value = false;
      AppMethodBeat.o(241811);
      return null;
    }
    if ("-1".equalsIgnoreCase(str))
    {
      paramPBool.value = true;
      AppMethodBeat.o(241811);
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
    AppMethodBeat.o(241811);
    return parama;
  }
  
  public static ad doP()
  {
    AppMethodBeat.i(241803);
    if (viu == null) {
      viu = new ad();
    }
    ad localad = viu;
    AppMethodBeat.o(241803);
    return localad;
  }
  
  private void doR()
  {
    AppMethodBeat.i(241808);
    this.vij = false;
    this.vim.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(b.a.smM, localPBool, localPString);
    this.vij = localPBool.value;
    this.viq = localPString.value;
    if (localHashSet != null) {
      this.vim.addAll(localHashSet);
    }
    AppMethodBeat.o(241808);
  }
  
  private void doS()
  {
    AppMethodBeat.i(241809);
    this.vik = false;
    this.vin.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(b.a.smN, localPBool, localPString);
    this.vik = localPBool.value;
    this.vir = localPString.value;
    if (localHashSet != null) {
      this.vin.addAll(localHashSet);
    }
    AppMethodBeat.o(241809);
  }
  
  private void doT()
  {
    AppMethodBeat.i(241810);
    this.vil = false;
    this.vio.clear();
    PBool localPBool = new PBool();
    PString localPString = new PString();
    HashSet localHashSet = a(b.a.smP, localPBool, localPString);
    this.vil = localPBool.value;
    this.vis = localPString.value;
    if (localHashSet != null) {
      this.vio.addAll(localHashSet);
    }
    AppMethodBeat.o(241810);
  }
  
  public final void LW()
  {
    AppMethodBeat.i(241805);
    if (MMApplicationContext.isMainProcess())
    {
      doQ();
      EventCenter.instance.add(this.lEE);
      EventCenter.instance.add(this.qZd);
    }
    AppMethodBeat.o(241805);
  }
  
  final void doQ()
  {
    AppMethodBeat.i(241807);
    doR();
    doS();
    doT();
    this.vip = ((b)g.af(b.class)).a(b.a.smO, false);
    AppMethodBeat.o(241807);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(241806);
    if (MMApplicationContext.isMainProcess())
    {
      EventCenter.instance.removeListener(this.lEE);
      EventCenter.instance.removeListener(this.qZd);
    }
    AppMethodBeat.o(241806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ad
 * JD-Core Version:    0.7.0.1
 */