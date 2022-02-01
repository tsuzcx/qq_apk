package com.tencent.mm.aw.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.a;
import com.tencent.mm.aw.a.c.i;
import com.tencent.mm.aw.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
{
  public final float alpha;
  public final int density;
  public final boolean gjA;
  public final String gjt;
  public final int gjv;
  public final int gjw;
  private final Drawable gjy;
  public final boolean gkG;
  public final ap handler;
  public final com.tencent.mm.aw.a.c.c hjJ;
  public final boolean hjS;
  public final boolean hjT;
  public final boolean hjU;
  public final boolean hjV;
  public final String hjW;
  public final int hjX;
  public final boolean hjY;
  public final boolean hjZ;
  public final boolean hka;
  public final int hkb;
  public final boolean hkc;
  private final boolean hkd;
  public final boolean hke;
  public final int hkf;
  private final int hkg;
  private final Drawable hkh;
  public final int hki;
  private final Drawable hkj;
  public final String hkk;
  public final SFSContext hkl;
  public final float hkm;
  public final boolean hkn;
  public final boolean hko;
  public final boolean hkp;
  public final q hkq;
  public final a hkr;
  public final i hks;
  public final Object[] hkt;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.hjS = parama.hjS;
    this.hjU = parama.hjU;
    this.hjT = parama.hjT;
    this.hjV = parama.hjV;
    this.gjt = parama.gjt;
    this.prefixPath = parama.prefixPath;
    this.hjW = parama.hjW;
    this.hjX = parama.hjX;
    this.gjv = parama.gjv;
    this.gjw = parama.gjw;
    this.hjY = parama.hjY;
    this.md5 = parama.md5;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.hjZ = parama.hjZ;
    this.hka = parama.hka;
    this.hkb = parama.hkb;
    this.thumbPath = parama.thumbPath;
    this.hkc = parama.hkc;
    this.hkd = parama.hkd;
    this.hke = parama.hke;
    this.hkf = parama.hkf;
    this.gjy = parama.gjy;
    this.hkg = parama.hkg;
    this.hkh = parama.hkh;
    this.hki = parama.hki;
    this.hkj = parama.hkj;
    this.gjA = parama.gjA;
    this.gkG = parama.gkG;
    this.hkm = parama.hkm;
    this.hkn = parama.hkn;
    this.hko = parama.hko;
    this.hkp = parama.hkp;
    this.hkl = parama.hkl;
    this.handler = parama.handler;
    this.hkt = parama.hkt;
    this.hjJ = parama.hjJ;
    this.hkq = parama.hkq;
    this.hkr = parama.hkr;
    this.hks = parama.hks;
    this.hkk = parama.hkk;
  }
  
  public static c ayT()
  {
    AppMethodBeat.i(130402);
    c localc = new a().azc();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean ayU()
  {
    return (this.hkf > 0) || (this.gjy != null);
  }
  
  public final boolean ayV()
  {
    return (this.hki > 0) || (this.hkj != null);
  }
  
  public final String ayW()
  {
    return this.gjt;
  }
  
  public final Drawable f(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.hkf != 0)
    {
      paramResources = paramResources.getDrawable(this.hkf);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.gjy;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.hki != 0)
    {
      paramResources = paramResources.getDrawable(this.hki);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.hkj;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    int density = 0;
    public boolean gjA = true;
    public String gjt = "";
    public int gjv = 0;
    public int gjw = 0;
    public Drawable gjy = null;
    public boolean gkG = false;
    ap handler = null;
    public com.tencent.mm.aw.a.c.c hjJ = null;
    public boolean hjS = true;
    public boolean hjT = false;
    public boolean hjU = false;
    public boolean hjV = true;
    String hjW = "";
    public int hjX = 5;
    public boolean hjY = false;
    boolean hjZ = false;
    public boolean hka;
    public int hkb;
    boolean hkc;
    boolean hkd = false;
    boolean hke = false;
    public int hkf = 0;
    int hkg = 0;
    Drawable hkh = null;
    public int hki = 0;
    public Drawable hkj = null;
    public String hkk = null;
    public SFSContext hkl = null;
    public float hkm = 0.0F;
    public boolean hkn = false;
    boolean hko = true;
    boolean hkp = false;
    q hkq = null;
    public a hkr = null;
    public i hks = null;
    public Object[] hkt = null;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a a(a parama)
    {
      this.hkr = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.aw.a.c.c paramc)
    {
      this.hjJ = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.hkl = paramSFSContext;
      return this;
    }
    
    public final a ag(float paramFloat)
    {
      this.hkm = paramFloat;
      return this;
    }
    
    public final a ayX()
    {
      this.hjS = true;
      return this;
    }
    
    public final a ayY()
    {
      this.hjU = true;
      return this;
    }
    
    public final a ayZ()
    {
      this.hjT = true;
      return this;
    }
    
    public final a aza()
    {
      this.gkG = true;
      return this;
    }
    
    public final a azb()
    {
      this.hkn = true;
      return this;
    }
    
    public final c azc()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a de(int paramInt1, int paramInt2)
    {
      this.gjv = paramInt1;
      this.gjw = paramInt2;
      return this;
    }
    
    public final a oo(int paramInt)
    {
      this.gjv = paramInt;
      return this;
    }
    
    public final a op(int paramInt)
    {
      this.gjw = paramInt;
      return this;
    }
    
    public final a oq(int paramInt)
    {
      this.hkf = paramInt;
      return this;
    }
    
    public final a or(int paramInt)
    {
      this.hki = paramInt;
      return this;
    }
    
    public final a yv(String paramString)
    {
      this.gjt = paramString;
      return this;
    }
    
    public final a yw(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a yx(String paramString)
    {
      this.hkk = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a.a.c
 * JD-Core Version:    0.7.0.1
 */