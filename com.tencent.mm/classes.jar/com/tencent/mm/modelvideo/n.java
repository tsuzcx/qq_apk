package com.tencent.mm.modelvideo;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.jp;
import com.tencent.mm.j.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class n
  implements ar
{
  public HashMap<String, n.a> eGQ = new HashMap();
  private c<jp> eGR = new n.3(this);
  
  public n()
  {
    a.udP.c(this.eGR);
  }
  
  public static n Sp()
  {
    return (n)p.B(n.class);
  }
  
  public final void a(d paramd, String paramString)
  {
    if ((paramd == null) || (bk.bl(paramString))) {
      return;
    }
    g.DS().O(new n.1(this, paramString, paramd));
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    n.a locala2 = (n.a)this.eGQ.get(paramString2);
    n.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new n.a(this);
    }
    locala1.eHd = paramString1;
    locala1.eHe = paramString2;
    locala1.toUser = paramString3;
    locala1.czr = paramString4;
    locala1.eHf = paramString5;
    locala1.eHh = paramInt1;
    locala1.eHg = paramInt2;
    locala1.startTime = bk.UY();
    this.eGQ.put(paramString2, locala1);
    y.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */