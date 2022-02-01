package com.tencent.mm.av.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.a;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
{
  public final float alpha;
  public final int density;
  public final String fullPath;
  public final int hZA;
  private final Drawable hZC;
  public final boolean hZF;
  public final int hZz;
  public final MMHandler handler;
  public final boolean iaT;
  public final com.tencent.mm.av.a.c.c jaU;
  public final boolean jbA;
  public final q jbB;
  public final a jbC;
  public final i jbD;
  public final Object[] jbE;
  public final boolean jbd;
  public final boolean jbe;
  public final boolean jbf;
  public final boolean jbg;
  public final String jbh;
  public final int jbi;
  public final boolean jbj;
  public final boolean jbk;
  public final boolean jbl;
  public final int jbm;
  public final boolean jbn;
  private final boolean jbo;
  public final boolean jbp;
  public final int jbq;
  private final int jbr;
  private final Drawable jbs;
  public final int jbt;
  private final Drawable jbu;
  public final String jbv;
  public final SFSContext jbw;
  public final float jbx;
  public final boolean jby;
  public final boolean jbz;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.jbd = parama.jbd;
    this.jbf = parama.jbf;
    this.jbe = parama.jbe;
    this.jbg = parama.jbg;
    this.fullPath = parama.fullPath;
    this.prefixPath = parama.prefixPath;
    this.jbh = parama.jbh;
    this.jbi = parama.jbi;
    this.hZz = parama.hZz;
    this.hZA = parama.hZA;
    this.jbj = parama.jbj;
    this.md5 = parama.md5;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.jbk = parama.jbk;
    this.jbl = parama.jbl;
    this.jbm = parama.jbm;
    this.thumbPath = parama.thumbPath;
    this.jbn = parama.jbn;
    this.jbo = parama.jbo;
    this.jbp = parama.jbp;
    this.jbq = parama.jbq;
    this.hZC = parama.hZC;
    this.jbr = parama.jbr;
    this.jbs = parama.jbs;
    this.jbt = parama.jbt;
    this.jbu = parama.jbu;
    this.hZF = parama.hZF;
    this.iaT = parama.iaT;
    this.jbx = parama.jbx;
    this.jby = parama.jby;
    this.jbz = parama.jbz;
    this.jbA = parama.jbA;
    this.jbw = parama.jbw;
    this.handler = parama.handler;
    this.jbE = parama.jbE;
    this.jaU = parama.jaU;
    this.jbB = parama.jbB;
    this.jbC = parama.jbC;
    this.jbD = parama.jbD;
    this.jbv = parama.jbv;
  }
  
  public static c bdf()
  {
    AppMethodBeat.i(130402);
    c localc = new a().bdv();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean bdg()
  {
    return (this.jbq > 0) || (this.hZC != null);
  }
  
  public final boolean bdh()
  {
    return (this.jbt > 0) || (this.jbu != null);
  }
  
  public final String bdi()
  {
    return this.fullPath;
  }
  
  public final int bdj()
  {
    return this.hZz;
  }
  
  public final int bdk()
  {
    return this.hZA;
  }
  
  public final boolean bdl()
  {
    return this.iaT;
  }
  
  public final float bdm()
  {
    return this.jbx;
  }
  
  public final String bdn()
  {
    return this.jbv;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.jbq != 0)
    {
      paramResources = paramResources.getDrawable(this.jbq);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.hZC;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable h(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.jbt != 0)
    {
      paramResources = paramResources.getDrawable(this.jbt);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.jbu;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    int density = 0;
    public String fullPath = "";
    public int hZA = 0;
    public Drawable hZC = null;
    public boolean hZF = true;
    public int hZz = 0;
    MMHandler handler = null;
    public boolean iaT = false;
    public com.tencent.mm.av.a.c.c jaU = null;
    boolean jbA = false;
    q jbB = null;
    public a jbC = null;
    public i jbD = null;
    public Object[] jbE = null;
    public boolean jbd = true;
    public boolean jbe = false;
    public boolean jbf = false;
    public boolean jbg = true;
    String jbh = "";
    public int jbi = 5;
    public boolean jbj = false;
    boolean jbk = false;
    public boolean jbl;
    public int jbm;
    boolean jbn;
    boolean jbo = false;
    boolean jbp = false;
    public int jbq = 0;
    int jbr = 0;
    Drawable jbs = null;
    public int jbt = 0;
    public Drawable jbu = null;
    public String jbv = null;
    public SFSContext jbw = null;
    public float jbx = 0.0F;
    public boolean jby = false;
    boolean jbz = true;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a OS(String paramString)
    {
      this.fullPath = paramString;
      return this;
    }
    
    public final a OT(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a OU(String paramString)
    {
      this.jbv = paramString;
      return this;
    }
    
    public final a a(a parama)
    {
      this.jbC = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.av.a.c.c paramc)
    {
      this.jaU = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.jbw = paramSFSContext;
      return this;
    }
    
    public final a aw(float paramFloat)
    {
      this.jbx = paramFloat;
      return this;
    }
    
    public final a bdo()
    {
      this.jbd = true;
      return this;
    }
    
    public final a bdp()
    {
      this.jbf = true;
      return this;
    }
    
    public final a bdq()
    {
      this.jbe = true;
      return this;
    }
    
    public final a bdr()
    {
      this.jbi = 1;
      return this;
    }
    
    public final a bds()
    {
      this.hZF = true;
      return this;
    }
    
    public final a bdt()
    {
      this.iaT = true;
      return this;
    }
    
    public final a bdu()
    {
      this.jby = true;
      return this;
    }
    
    public final c bdv()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a dr(int paramInt1, int paramInt2)
    {
      this.hZz = paramInt1;
      this.hZA = paramInt2;
      return this;
    }
    
    public final a h(Object... paramVarArgs)
    {
      this.jbE = paramVarArgs;
      return this;
    }
    
    public final a tw(int paramInt)
    {
      this.hZz = paramInt;
      return this;
    }
    
    public final a tx(int paramInt)
    {
      this.hZA = paramInt;
      return this;
    }
    
    public final a ty(int paramInt)
    {
      this.jbq = paramInt;
      return this;
    }
    
    public final a tz(int paramInt)
    {
      this.jbt = paramInt;
      return this;
    }
    
    public final a x(Drawable paramDrawable)
    {
      this.hZC = paramDrawable;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.a.c
 * JD-Core Version:    0.7.0.1
 */