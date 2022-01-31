package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class n
  implements at
{
  public HashMap<String, n.a> fWG;
  private c<jy> fWH;
  
  public n()
  {
    AppMethodBeat.i(50757);
    this.fWH = new n.3(this);
    this.fWG = new HashMap();
    a.ymk.c(this.fWH);
    AppMethodBeat.o(50757);
  }
  
  public static n alC()
  {
    AppMethodBeat.i(50758);
    n localn = (n)q.S(n.class);
    AppMethodBeat.o(50758);
    return localn;
  }
  
  public final void a(d paramd, String paramString)
  {
    AppMethodBeat.i(50760);
    if ((paramd == null) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(50760);
      return;
    }
    g.RO().ac(new n.1(this, paramString, paramd));
    AppMethodBeat.o(50760);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50759);
    n.a locala2 = (n.a)this.fWG.get(paramString2);
    n.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new n.a(this);
    }
    locala1.fWT = paramString1;
    locala1.fWU = paramString2;
    locala1.toUser = paramString3;
    locala1.dns = paramString4;
    locala1.fWV = paramString5;
    locala1.fWX = paramInt1;
    locala1.fWW = paramInt2;
    locala1.startTime = bo.aoy();
    this.fWG.put(paramString2, locala1);
    ab.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(50759);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */