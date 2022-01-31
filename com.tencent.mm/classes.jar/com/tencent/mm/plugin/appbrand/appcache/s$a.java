package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.regex.Pattern;

final class s$a
  implements z.a
{
  private final a gUE;
  private final int gUF;
  private final boolean gUG;
  private a gUH;
  private ArrayList<IDKey> gUI;
  private long gUJ;
  private long gUK;
  private long gUL;
  private kv_14609 gUM;
  
  private s$a(a parama)
  {
    AppMethodBeat.i(129372);
    this.gUJ = 0L;
    this.gUK = 0L;
    this.gUL = 0L;
    this.gUE = parama;
    int i;
    if (s.yq(parama.appId))
    {
      i = 776;
      this.gUF = i;
      parama = parama.appId.split(Pattern.quote("$"));
      if (parama != null) {
        break label92;
      }
      i = -1;
      label67:
      if (i != 2) {
        break label98;
      }
    }
    label92:
    label98:
    for (boolean bool = true;; bool = false)
    {
      this.gUG = bool;
      AppMethodBeat.o(129372);
      return;
      i = 368;
      break;
      i = parama.length;
      break label67;
    }
  }
  
  private void avA()
  {
    AppMethodBeat.i(129375);
    try
    {
      com.tencent.mm.plugin.report.e.qrI.b(this.gUI, false);
      this.gUI.clear();
      AppMethodBeat.o(129375);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(129375);
    }
  }
  
  private void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129374);
    if (this.gUI == null) {
      this.gUI = new ArrayList();
    }
    this.gUI.add(new IDKey(paramInt1, paramInt2, 1));
    AppMethodBeat.o(129374);
  }
  
  private void nm(int paramInt)
  {
    AppMethodBeat.i(129373);
    cS(this.gUF, paramInt);
    AppMethodBeat.o(129373);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(129379);
    long l = SystemClock.elapsedRealtime() - this.gUJ;
    int j;
    if ((paramm != null) && (paramm.status == 2))
    {
      j = 1;
      if (this.gUH != null) {}
      switch (s.1.gUD[this.gUH.ordinal()])
      {
      default: 
        if ((j == 0) && (!"@LibraryAppId".equals(this.gUE.appId)) && (999 != this.gUE.cvs))
        {
          if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
          {
            i = 23;
            label139:
            com.tencent.mm.plugin.appbrand.report.e.U(this.gUE.appId, i, this.gUE.cvs + 1);
          }
        }
        else {
          if (paramm == null) {
            break label434;
          }
        }
        break;
      }
    }
    try
    {
      if (paramm.status != 2) {
        break label434;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label173:
        label434:
        ab.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.gUE.appId });
        continue;
        if (paramm.httpStatusCode == 410)
        {
          this.gUM.py(1);
        }
        else if (paramm.httpStatusCode == 404)
        {
          this.gUM.py(2);
        }
        else
        {
          this.gUM.py(3);
          continue;
          this.gUM.py(0);
          continue;
          if ((this.gUE instanceof al))
          {
            this.gUM.iHT = com.tencent.mm.a.e.cM(this.gUE.getFilePath());
          }
          else
          {
            this.gUM.iHS = com.tencent.mm.a.e.cM(this.gUE.getFilePath());
            continue;
            String str2 = "";
            continue;
            i = 2;
          }
        }
      }
    }
    if (a.gUP != this.gUH)
    {
      if (a.gUR == this.gUH) {
        break label605;
      }
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.report.e.a(str1, this.gUH.value, i, l, this.gUG);
        avA();
        if (this.gUM != null)
        {
          if (j != 0) {
            break label555;
          }
          this.gUM.aLr();
          if (!(this.gUE instanceof al)) {
            break label544;
          }
          if (paramm != null) {
            break label491;
          }
          this.gUM.py(3);
          if ((this.gUE instanceof bd)) {
            this.gUM.iHX = l;
          }
          this.gUM.IE();
          if ((!(this.gUE instanceof bd)) && (!(this.gUE instanceof al))) {
            this.gUM.iHW = l;
          }
        }
        AppMethodBeat.o(129379);
        return;
        j = 0;
        break;
        if (j != 0) {}
        for (i = 2;; i = 3)
        {
          nm(i);
          break;
        }
        if (j != 0) {}
        for (i = 11;; i = 12)
        {
          nm(i);
          break;
        }
        if (j != 0) {}
        for (i = 21;; i = 22)
        {
          nm(i);
          break;
        }
        if (j != 0) {}
        for (i = 36;; i = 37)
        {
          nm(i);
          break;
        }
        if (j != 0) {}
        for (i = 47;; i = 48)
        {
          nm(i);
          break;
        }
        i = 19;
        break label139;
        if ((paramm == null) || (paramm.status != 4)) {
          break label612;
        }
        i = 3;
        break label173;
        String str1 = this.gUE.appId;
      }
    }
  }
  
  public final void avh()
  {
    int j = 0;
    AppMethodBeat.i(129376);
    Object localObject;
    label89:
    int i;
    if ((this.gUE instanceof al)) {
      if ("@LibraryAppId".equals(this.gUE.appId))
      {
        localObject = a.gUR;
        this.gUH = ((a)localObject);
        this.gUM = new kv_14609(this.gUE.appId, ((al)this.gUE).gVy, ((al)this.gUE).gVz);
        this.gUM.iHU = bo.aoy();
        switch (s.1.gUD[this.gUH.ordinal()])
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      nm(i);
      this.gUJ = SystemClock.elapsedRealtime();
      AppMethodBeat.o(129376);
      return;
      localObject = a.gUQ;
      break;
      if ("@LibraryAppId".equals(this.gUE.appId))
      {
        this.gUH = a.gUP;
        break label89;
      }
      if (j.a.nk(this.gUE.cvs))
      {
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = h.bl(this.gUE.appId, 1);
        if (localWxaPkgWrappingInfo != null)
        {
          localObject = a.gUO;
          label223:
          this.gUH = ((a)localObject);
          localObject = this.gUE.appId;
          if (localWxaPkgWrappingInfo != null) {
            break label283;
          }
        }
        label283:
        for (i = 0;; i = localWxaPkgWrappingInfo.gXf)
        {
          this.gUM = new kv_14609((String)localObject, i, this.gUE.version);
          this.gUM.iHU = bo.aoy();
          break;
          localObject = a.gUN;
          break label223;
        }
      }
      this.gUH = a.gUN;
      break label89;
      i = 1;
      continue;
      i = 10;
      continue;
      i = 20;
      continue;
      i = 35;
      continue;
      i = 46;
    }
  }
  
  public final void avi()
  {
    AppMethodBeat.i(129377);
    nm(32);
    AppMethodBeat.o(129377);
  }
  
  public final void avj()
  {
    AppMethodBeat.i(129378);
    switch (s.1.gUD[this.gUH.ordinal()])
    {
    }
    for (int i = 31;; i = 30)
    {
      nm(i);
      AppMethodBeat.o(129378);
      return;
    }
  }
  
  public final void avk()
  {
    AppMethodBeat.i(129380);
    this.gUL = SystemClock.elapsedRealtime();
    cS(697, 1);
    AppMethodBeat.o(129380);
  }
  
  public final void avl()
  {
    AppMethodBeat.i(129382);
    if ((a.gUP != this.gUH) && (a.gUR != this.gUH)) {
      com.tencent.mm.plugin.appbrand.report.e.U(this.gUE.appId, 20, this.gUE.cvs + 1);
    }
    AppMethodBeat.o(129382);
  }
  
  public final void avm()
  {
    AppMethodBeat.i(129383);
    this.gUK = SystemClock.elapsedRealtime();
    switch (s.1.gUD[this.gUH.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(129383);
      return;
      nm(5);
      AppMethodBeat.o(129383);
      return;
      nm(14);
      AppMethodBeat.o(129383);
      return;
      nm(24);
      AppMethodBeat.o(129383);
      return;
      nm(41);
      AppMethodBeat.o(129383);
      return;
      nm(49);
    }
  }
  
  public final void avn()
  {
    AppMethodBeat.i(129385);
    nm(56);
    AppMethodBeat.o(129385);
  }
  
  public final void dG(boolean paramBoolean)
  {
    AppMethodBeat.i(129384);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.gUK;
    int i;
    String str;
    switch (s.1.gUD[this.gUH.ordinal()])
    {
    default: 
      i = 0;
      nm(i);
      avA();
      if ((a.gUP == this.gUH) || (a.gUR == this.gUH))
      {
        str = "";
        label99:
        int j = this.gUH.value;
        if (!paramBoolean) {
          break label316;
        }
        i = 1;
        label113:
        com.tencent.mm.plugin.appbrand.report.e.a(str, j + 1, i, l1 - l2, this.gUG);
        if (!paramBoolean) {
          com.tencent.mm.plugin.appbrand.report.e.U(this.gUE.appId, 22, this.gUE.cvs + 1);
        }
        if (this.gUM != null)
        {
          this.gUM.aLr();
          if ((this.gUH != a.gUQ) && (this.gUH != a.gUR)) {
            break label333;
          }
          if (!paramBoolean) {
            break label321;
          }
          this.gUM.iHQ = true;
          this.gUM.iHR = true;
        }
      }
      break;
    }
    for (;;)
    {
      this.gUM.IE();
      AppMethodBeat.o(129384);
      return;
      if (paramBoolean)
      {
        i = 6;
        break;
      }
      i = 7;
      break;
      if (paramBoolean)
      {
        i = 15;
        break;
      }
      i = 16;
      break;
      if (paramBoolean)
      {
        i = 25;
        break;
      }
      i = 26;
      break;
      if (paramBoolean)
      {
        i = 42;
        break;
      }
      i = 43;
      break;
      if (paramBoolean)
      {
        i = 50;
        break;
      }
      i = 51;
      break;
      str = this.gUE.appId;
      break label99;
      label316:
      i = 2;
      break label113;
      label321:
      this.gUM.py(6);
      continue;
      label333:
      this.gUM.iHQ = paramBoolean;
    }
  }
  
  public final void dH(boolean paramBoolean)
  {
    AppMethodBeat.i(129386);
    if (!paramBoolean) {
      nm(57);
    }
    for (;;)
    {
      if (this.gUM != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.gUJ;
        this.gUM.iHX = (l1 - l2);
      }
      AppMethodBeat.o(129386);
      return;
      if ((this.gUM != null) && ((this.gUE instanceof bd))) {
        this.gUM.iHS = com.tencent.mm.a.e.cM(((bd)this.gUE).awk());
      }
    }
  }
  
  public final void nl(int paramInt)
  {
    AppMethodBeat.i(129381);
    SystemClock.elapsedRealtime();
    if (paramInt == 0)
    {
      cS(697, 2);
      avA();
      if (this.gUM == null) {
        break label136;
      }
      if (paramInt == 0) {
        break label116;
      }
      if (paramInt != -4) {
        break label105;
      }
      this.gUM.py(4);
    }
    for (;;)
    {
      this.gUM.aLr();
      this.gUM.IE();
      AppMethodBeat.o(129381);
      return;
      if (paramInt < 0)
      {
        cS(697, -paramInt);
        break;
      }
      if (paramInt != 1) {
        break;
      }
      cS(697, 10);
      break;
      label105:
      this.gUM.py(5);
    }
    label116:
    this.gUM.iHS = com.tencent.mm.a.e.cM(((al)this.gUE).avJ());
    label136:
    AppMethodBeat.o(129381);
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(129371);
      gUN = new a("DOWNLOAD", 0, 1);
      gUO = new a("UPDATE", 1, 4);
      gUP = new a("LIB_UPDATE", 2, 7);
      gUQ = new a("INCREMENTAL_UPDATE", 3, 10);
      gUR = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
      gUS = new a[] { gUN, gUO, gUP, gUQ, gUR };
      AppMethodBeat.o(129371);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s.a
 * JD-Core Version:    0.7.0.1
 */