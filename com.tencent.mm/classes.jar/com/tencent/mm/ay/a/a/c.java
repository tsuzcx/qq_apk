package com.tencent.mm.ay.a.a;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.a;
import com.tencent.mm.ay.a.c.i;
import com.tencent.mm.ay.a.c.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
{
  public Bitmap.Config aFT = null;
  public final float alpha;
  public final String fullPath;
  public final MMHandler handler;
  public final int kOf;
  public final int kOg;
  private final Drawable kOi;
  public final boolean kOl;
  public final boolean kPz;
  public final boolean lRB;
  public final boolean lRC;
  public final boolean lRD;
  public final boolean lRE;
  public final String lRF;
  public final int lRG;
  public final boolean lRH;
  public final int lRI;
  public final boolean lRJ;
  public final boolean lRK;
  public final int lRL;
  public final boolean lRM;
  public final boolean lRN;
  public final boolean lRO;
  public final int lRP;
  private final int lRQ;
  private final Drawable lRR;
  public final int lRS;
  private final Drawable lRT;
  public final String lRU;
  public final SFSContext lRV;
  public final float lRW;
  public final boolean lRX;
  public final boolean lRY;
  public final boolean lRZ;
  public final com.tencent.mm.ay.a.c.c lRs;
  public final q lSa;
  public final a lSb;
  public final i lSc;
  public final Object[] lSd;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.lRB = parama.lRB;
    this.lRD = parama.lRD;
    this.lRC = parama.lRC;
    this.lRE = parama.lRE;
    this.fullPath = parama.fullPath;
    this.prefixPath = parama.prefixPath;
    this.lRF = parama.lRF;
    this.lRG = parama.lRG;
    this.kOf = parama.kOf;
    this.kOg = parama.kOg;
    this.aFT = parama.aFT;
    this.lRH = parama.lRH;
    this.md5 = parama.md5;
    this.lRI = parama.lRI;
    this.alpha = parama.alpha;
    this.lRJ = parama.lRJ;
    this.lRK = parama.lRK;
    this.lRL = parama.lRL;
    this.thumbPath = parama.thumbPath;
    this.lRM = parama.lRM;
    this.lRN = parama.lRN;
    this.lRO = parama.lRO;
    this.lRP = parama.lRP;
    this.kOi = parama.kOi;
    this.lRQ = parama.lRQ;
    this.lRR = parama.lRR;
    this.lRS = parama.lRS;
    this.lRT = parama.lRT;
    this.kOl = parama.kOl;
    this.kPz = parama.kPz;
    this.lRW = parama.lRW;
    this.lRX = parama.lRX;
    this.lRY = parama.lRY;
    this.lRZ = parama.lRZ;
    this.lRV = parama.lRV;
    this.handler = parama.handler;
    this.lSd = parama.lSd;
    this.lRs = parama.lRs;
    this.lSa = parama.lSa;
    this.lSb = parama.lSb;
    this.lSc = parama.lSc;
    this.lRU = parama.lRU;
  }
  
  public static c bmw()
  {
    AppMethodBeat.i(130402);
    c localc = new a().bmL();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final int bmA()
  {
    return this.kOf;
  }
  
  public final int bmB()
  {
    return this.kOg;
  }
  
  public final boolean bmC()
  {
    return this.kPz;
  }
  
  public final float bmD()
  {
    return this.lRW;
  }
  
  public final String bmE()
  {
    return this.lRU;
  }
  
  public final boolean bmx()
  {
    return (this.lRP > 0) || (this.kOi != null);
  }
  
  public final boolean bmy()
  {
    return (this.lRS > 0) || (this.lRT != null);
  }
  
  public final String bmz()
  {
    return this.fullPath;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.lRP != 0)
    {
      paramResources = paramResources.getDrawable(this.lRP);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.kOi;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable h(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.lRS != 0)
    {
      paramResources = paramResources.getDrawable(this.lRS);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.lRT;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    Bitmap.Config aFT = null;
    float alpha = 0.0F;
    public String fullPath = "";
    MMHandler handler = null;
    public int kOf = 0;
    public int kOg = 0;
    public Drawable kOi = null;
    public boolean kOl = true;
    public boolean kPz = false;
    public boolean lRB = true;
    public boolean lRC = false;
    public boolean lRD = false;
    public boolean lRE = true;
    String lRF = "";
    public int lRG = 5;
    public boolean lRH = false;
    int lRI = 0;
    boolean lRJ = false;
    public boolean lRK;
    public int lRL;
    boolean lRM;
    boolean lRN = false;
    public boolean lRO = false;
    public int lRP = 0;
    int lRQ = 0;
    Drawable lRR = null;
    public int lRS = 0;
    public Drawable lRT = null;
    public String lRU = null;
    public SFSContext lRV = null;
    public float lRW = 0.0F;
    public boolean lRX = false;
    boolean lRY = true;
    boolean lRZ = false;
    public com.tencent.mm.ay.a.c.c lRs = null;
    q lSa = null;
    public a lSb = null;
    public i lSc = null;
    public Object[] lSd = null;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a C(Drawable paramDrawable)
    {
      this.kOi = paramDrawable;
      return this;
    }
    
    public final a Wq(String paramString)
    {
      this.fullPath = paramString;
      return this;
    }
    
    public final a Wr(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a Ws(String paramString)
    {
      this.lRU = paramString;
      return this;
    }
    
    public final a a(Bitmap.Config paramConfig)
    {
      this.aFT = paramConfig;
      return this;
    }
    
    public final a a(a parama)
    {
      this.lSb = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.ay.a.c.c paramc)
    {
      this.lRs = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.lRV = paramSFSContext;
      return this;
    }
    
    public final a aw(float paramFloat)
    {
      this.lRW = paramFloat;
      return this;
    }
    
    public final a bmF()
    {
      this.lRD = true;
      return this;
    }
    
    public final a bmG()
    {
      this.lRC = true;
      return this;
    }
    
    public final a bmH()
    {
      this.lRG = 1;
      return this;
    }
    
    public final a bmI()
    {
      this.kOl = true;
      return this;
    }
    
    public final a bmJ()
    {
      this.kPz = true;
      return this;
    }
    
    public final a bmK()
    {
      this.lRX = true;
      return this;
    }
    
    public final c bmL()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a dO(int paramInt1, int paramInt2)
    {
      this.kOf = paramInt1;
      this.kOg = paramInt2;
      return this;
    }
    
    public final a gs(boolean paramBoolean)
    {
      this.lRB = paramBoolean;
      return this;
    }
    
    public final a h(Object... paramVarArgs)
    {
      this.lSd = paramVarArgs;
      return this;
    }
    
    public final a ww(int paramInt)
    {
      this.kOf = paramInt;
      return this;
    }
    
    public final a wx(int paramInt)
    {
      this.kOg = paramInt;
      return this;
    }
    
    public final a wy(int paramInt)
    {
      this.lRP = paramInt;
      return this;
    }
    
    public final a wz(int paramInt)
    {
      this.lRS = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ay.a.a.c
 * JD-Core Version:    0.7.0.1
 */