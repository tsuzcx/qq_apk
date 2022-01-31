package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class i
{
  final int gVy;
  final QualitySession hiI;
  final int hiK;
  final WxaAttributes ilb;
  final i.a ilc;
  
  i(String paramString, int paramInt, i.a parama, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(131813);
    this.hiK = paramInt;
    this.ilb = g.auF().d(paramString, new String[0]);
    this.ilc = parama;
    this.hiI = paramQualitySession;
    if (this.ilb == null)
    {
      ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", " <init> get NULL record by username %s", new Object[] { paramString });
      this.gVy = -1;
      AppMethodBeat.o(131813);
      return;
    }
    if (this.ilb.ayE() == null)
    {
      ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", " <init> get NULL record by username %s", new Object[] { paramString });
      this.gVy = -2;
      AppMethodBeat.o(131813);
      return;
    }
    this.gVy = this.ilb.ayE().bDc;
    AppMethodBeat.o(131813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.i
 * JD-Core Version:    0.7.0.1
 */