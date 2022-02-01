package com.tencent.mm.av.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.a;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
{
  public final float alpha;
  public final int density;
  public final aq handler;
  public final String hgD;
  public final int hgF;
  public final int hgG;
  private final Drawable hgI;
  public final boolean hgL;
  public final boolean hhW;
  public final com.tencent.mm.av.a.c.c ifZ;
  public final String igA;
  public final SFSContext igB;
  public final float igC;
  public final boolean igD;
  public final boolean igE;
  public final boolean igF;
  public final q igG;
  public final a igH;
  public final i igI;
  public final Object[] igJ;
  public final boolean igi;
  public final boolean igj;
  public final boolean igk;
  public final boolean igl;
  public final String igm;
  public final int ign;
  public final boolean igo;
  public final boolean igp;
  public final boolean igq;
  public final int igr;
  public final boolean igs;
  private final boolean igt;
  public final boolean igu;
  public final int igv;
  private final int igw;
  private final Drawable igx;
  public final int igy;
  private final Drawable igz;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.igi = parama.igi;
    this.igk = parama.igk;
    this.igj = parama.igj;
    this.igl = parama.igl;
    this.hgD = parama.hgD;
    this.prefixPath = parama.prefixPath;
    this.igm = parama.igm;
    this.ign = parama.ign;
    this.hgF = parama.hgF;
    this.hgG = parama.hgG;
    this.igo = parama.igo;
    this.md5 = parama.md5;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.igp = parama.igp;
    this.igq = parama.igq;
    this.igr = parama.igr;
    this.thumbPath = parama.thumbPath;
    this.igs = parama.igs;
    this.igt = parama.igt;
    this.igu = parama.igu;
    this.igv = parama.igv;
    this.hgI = parama.hgI;
    this.igw = parama.igw;
    this.igx = parama.igx;
    this.igy = parama.igy;
    this.igz = parama.igz;
    this.hgL = parama.hgL;
    this.hhW = parama.hhW;
    this.igC = parama.igC;
    this.igD = parama.igD;
    this.igE = parama.igE;
    this.igF = parama.igF;
    this.igB = parama.igB;
    this.handler = parama.handler;
    this.igJ = parama.igJ;
    this.ifZ = parama.ifZ;
    this.igG = parama.igG;
    this.igH = parama.igH;
    this.igI = parama.igI;
    this.igA = parama.igA;
  }
  
  public static c aJl()
  {
    AppMethodBeat.i(130402);
    c localc = new a().aJu();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean aJm()
  {
    return (this.igv > 0) || (this.hgI != null);
  }
  
  public final boolean aJn()
  {
    return (this.igy > 0) || (this.igz != null);
  }
  
  public final String aJo()
  {
    return this.hgD;
  }
  
  public final Drawable f(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.igv != 0)
    {
      paramResources = paramResources.getDrawable(this.igv);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.hgI;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.igy != 0)
    {
      paramResources = paramResources.getDrawable(this.igy);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.igz;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    int density = 0;
    aq handler = null;
    public String hgD = "";
    public int hgF = 0;
    public int hgG = 0;
    public Drawable hgI = null;
    public boolean hgL = true;
    public boolean hhW = false;
    public com.tencent.mm.av.a.c.c ifZ = null;
    public String igA = null;
    public SFSContext igB = null;
    public float igC = 0.0F;
    public boolean igD = false;
    boolean igE = true;
    boolean igF = false;
    q igG = null;
    public a igH = null;
    public i igI = null;
    public Object[] igJ = null;
    public boolean igi = true;
    public boolean igj = false;
    public boolean igk = false;
    public boolean igl = true;
    String igm = "";
    public int ign = 5;
    public boolean igo = false;
    boolean igp = false;
    public boolean igq;
    public int igr;
    boolean igs;
    boolean igt = false;
    boolean igu = false;
    public int igv = 0;
    int igw = 0;
    Drawable igx = null;
    public int igy = 0;
    public Drawable igz = null;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a Gg(String paramString)
    {
      this.hgD = paramString;
      return this;
    }
    
    public final a Gh(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a Gi(String paramString)
    {
      this.igA = paramString;
      return this;
    }
    
    public final a a(a parama)
    {
      this.igH = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.av.a.c.c paramc)
    {
      this.ifZ = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.igB = paramSFSContext;
      return this;
    }
    
    public final a aJp()
    {
      this.igi = true;
      return this;
    }
    
    public final a aJq()
    {
      this.igk = true;
      return this;
    }
    
    public final a aJr()
    {
      this.igj = true;
      return this;
    }
    
    public final a aJs()
    {
      this.hhW = true;
      return this;
    }
    
    public final a aJt()
    {
      this.igD = true;
      return this;
    }
    
    public final c aJu()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a an(float paramFloat)
    {
      this.igC = paramFloat;
      return this;
    }
    
    public final a dh(int paramInt1, int paramInt2)
    {
      this.hgF = paramInt1;
      this.hgG = paramInt2;
      return this;
    }
    
    public final a pI(int paramInt)
    {
      this.hgF = paramInt;
      return this;
    }
    
    public final a pJ(int paramInt)
    {
      this.hgG = paramInt;
      return this;
    }
    
    public final a pK(int paramInt)
    {
      this.igv = paramInt;
      return this;
    }
    
    public final a pL(int paramInt)
    {
      this.igy = paramInt;
      return this;
    }
    
    public final a x(Drawable paramDrawable)
    {
      this.hgI = paramDrawable;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.a.c
 * JD-Core Version:    0.7.0.1
 */