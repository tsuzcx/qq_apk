package com.tencent.mm.av.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.a;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ao;

public final class c
{
  public final float alpha;
  public final int density;
  public final String gKe;
  public final int gKg;
  public final int gKh;
  private final Drawable gKj;
  public final boolean gKm;
  public final boolean gLt;
  public final int hKA;
  public final boolean hKB;
  public final boolean hKC;
  public final boolean hKD;
  public final int hKE;
  public final boolean hKF;
  private final boolean hKG;
  public final boolean hKH;
  public final int hKI;
  private final int hKJ;
  private final Drawable hKK;
  public final int hKL;
  private final Drawable hKM;
  public final String hKN;
  public final SFSContext hKO;
  public final float hKP;
  public final boolean hKQ;
  public final boolean hKR;
  public final boolean hKS;
  public final q hKT;
  public final a hKU;
  public final i hKV;
  public final Object[] hKW;
  public final com.tencent.mm.av.a.c.c hKm;
  public final boolean hKv;
  public final boolean hKw;
  public final boolean hKx;
  public final boolean hKy;
  public final String hKz;
  public final ao handler;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.hKv = parama.hKv;
    this.hKx = parama.hKx;
    this.hKw = parama.hKw;
    this.hKy = parama.hKy;
    this.gKe = parama.gKe;
    this.prefixPath = parama.prefixPath;
    this.hKz = parama.hKz;
    this.hKA = parama.hKA;
    this.gKg = parama.gKg;
    this.gKh = parama.gKh;
    this.hKB = parama.hKB;
    this.md5 = parama.md5;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.hKC = parama.hKC;
    this.hKD = parama.hKD;
    this.hKE = parama.hKE;
    this.thumbPath = parama.thumbPath;
    this.hKF = parama.hKF;
    this.hKG = parama.hKG;
    this.hKH = parama.hKH;
    this.hKI = parama.hKI;
    this.gKj = parama.gKj;
    this.hKJ = parama.hKJ;
    this.hKK = parama.hKK;
    this.hKL = parama.hKL;
    this.hKM = parama.hKM;
    this.gKm = parama.gKm;
    this.gLt = parama.gLt;
    this.hKP = parama.hKP;
    this.hKQ = parama.hKQ;
    this.hKR = parama.hKR;
    this.hKS = parama.hKS;
    this.hKO = parama.hKO;
    this.handler = parama.handler;
    this.hKW = parama.hKW;
    this.hKm = parama.hKm;
    this.hKT = parama.hKT;
    this.hKU = parama.hKU;
    this.hKV = parama.hKV;
    this.hKN = parama.hKN;
  }
  
  public static c aFK()
  {
    AppMethodBeat.i(130402);
    c localc = new a().aFT();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean aFL()
  {
    return (this.hKI > 0) || (this.gKj != null);
  }
  
  public final boolean aFM()
  {
    return (this.hKL > 0) || (this.hKM != null);
  }
  
  public final String aFN()
  {
    return this.gKe;
  }
  
  public final Drawable f(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.hKI != 0)
    {
      paramResources = paramResources.getDrawable(this.hKI);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.gKj;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.hKL != 0)
    {
      paramResources = paramResources.getDrawable(this.hKL);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.hKM;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    int density = 0;
    public String gKe = "";
    public int gKg = 0;
    public int gKh = 0;
    public Drawable gKj = null;
    public boolean gKm = true;
    public boolean gLt = false;
    public int hKA = 5;
    public boolean hKB = false;
    boolean hKC = false;
    public boolean hKD;
    public int hKE;
    boolean hKF;
    boolean hKG = false;
    boolean hKH = false;
    public int hKI = 0;
    int hKJ = 0;
    Drawable hKK = null;
    public int hKL = 0;
    public Drawable hKM = null;
    public String hKN = null;
    public SFSContext hKO = null;
    public float hKP = 0.0F;
    public boolean hKQ = false;
    boolean hKR = true;
    boolean hKS = false;
    q hKT = null;
    public a hKU = null;
    public i hKV = null;
    public Object[] hKW = null;
    public com.tencent.mm.av.a.c.c hKm = null;
    public boolean hKv = true;
    public boolean hKw = false;
    public boolean hKx = false;
    public boolean hKy = true;
    String hKz = "";
    ao handler = null;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a CA(String paramString)
    {
      this.gKe = paramString;
      return this;
    }
    
    public final a CB(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a CC(String paramString)
    {
      this.hKN = paramString;
      return this;
    }
    
    public final a a(a parama)
    {
      this.hKU = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.av.a.c.c paramc)
    {
      this.hKm = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.hKO = paramSFSContext;
      return this;
    }
    
    public final a aFO()
    {
      this.hKv = true;
      return this;
    }
    
    public final a aFP()
    {
      this.hKx = true;
      return this;
    }
    
    public final a aFQ()
    {
      this.hKw = true;
      return this;
    }
    
    public final a aFR()
    {
      this.gLt = true;
      return this;
    }
    
    public final a aFS()
    {
      this.hKQ = true;
      return this;
    }
    
    public final c aFT()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a ak(float paramFloat)
    {
      this.hKP = paramFloat;
      return this;
    }
    
    public final a de(int paramInt1, int paramInt2)
    {
      this.gKg = paramInt1;
      this.gKh = paramInt2;
      return this;
    }
    
    public final a pc(int paramInt)
    {
      this.gKg = paramInt;
      return this;
    }
    
    public final a pd(int paramInt)
    {
      this.gKh = paramInt;
      return this;
    }
    
    public final a pe(int paramInt)
    {
      this.hKI = paramInt;
      return this;
    }
    
    public final a pf(int paramInt)
    {
      this.hKL = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.a.a.c
 * JD-Core Version:    0.7.0.1
 */