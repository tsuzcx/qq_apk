package com.tencent.mm.modelimage.loader.a;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.a;
import com.tencent.mm.modelimage.loader.b.i;
import com.tencent.mm.modelimage.loader.b.q;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
{
  public final float alpha;
  public Bitmap.Config bitmapConfig = null;
  public final String fullPath;
  public final MMHandler handler;
  public final String md5;
  public final int npU;
  public final int npV;
  private final Drawable npX;
  public final boolean nqa;
  public final boolean nrc;
  public final boolean oKA;
  public final int oKB;
  private final int oKC;
  private final Drawable oKD;
  public final int oKE;
  private final Drawable oKF;
  public final String oKG;
  public final SFSContext oKH;
  public final float oKI;
  public final boolean oKJ;
  public final boolean oKK;
  public final boolean oKL;
  public final q oKM;
  public final a oKN;
  public final i oKO;
  public final Object[] oKP;
  public final com.tencent.mm.modelimage.loader.b.c oKe;
  public final boolean oKn;
  public final boolean oKo;
  public final boolean oKp;
  public final boolean oKq;
  public final String oKr;
  public final int oKs;
  public final boolean oKt;
  public final int oKu;
  public final boolean oKv;
  public final boolean oKw;
  public final int oKx;
  public final boolean oKy;
  public final boolean oKz;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.oKn = parama.oKn;
    this.oKp = parama.oKp;
    this.oKo = parama.oKo;
    this.oKq = parama.oKq;
    this.fullPath = parama.fullPath;
    this.prefixPath = parama.prefixPath;
    this.oKr = parama.oKr;
    this.oKs = parama.oKs;
    this.npU = parama.npU;
    this.npV = parama.npV;
    this.bitmapConfig = parama.bitmapConfig;
    this.oKt = parama.oKt;
    this.md5 = parama.md5;
    this.oKu = parama.oKu;
    this.alpha = parama.alpha;
    this.oKv = parama.oKv;
    this.oKw = parama.oKw;
    this.oKx = parama.oKx;
    this.thumbPath = parama.thumbPath;
    this.oKy = parama.oKy;
    this.oKz = parama.oKz;
    this.oKA = parama.oKA;
    this.oKB = parama.oKB;
    this.npX = parama.npX;
    this.oKC = parama.oKC;
    this.oKD = parama.oKD;
    this.oKE = parama.oKE;
    this.oKF = parama.oKF;
    this.nqa = parama.nqa;
    this.nrc = parama.nrc;
    this.oKI = parama.oKI;
    this.oKJ = parama.oKJ;
    this.oKK = parama.oKK;
    this.oKL = parama.oKL;
    this.oKH = parama.oKH;
    this.handler = parama.handler;
    this.oKP = parama.oKP;
    this.oKe = parama.oKe;
    this.oKM = parama.oKM;
    this.oKN = parama.oKN;
    this.oKO = parama.oKO;
    this.oKG = parama.oKG;
  }
  
  public static c bKp()
  {
    AppMethodBeat.i(130402);
    c localc = new a().bKx();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean bKq()
  {
    return (this.oKB > 0) || (this.npX != null);
  }
  
  public final boolean bKr()
  {
    return (this.oKE > 0) || (this.oKF != null);
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.oKB != 0)
    {
      paramResources = paramResources.getDrawable(this.oKB);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.npX;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable h(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.oKE != 0)
    {
      paramResources = paramResources.getDrawable(this.oKE);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.oKF;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    public Bitmap.Config bitmapConfig = null;
    public String fullPath = "";
    MMHandler handler = null;
    public String md5 = "";
    public int npU = 0;
    public int npV = 0;
    public Drawable npX = null;
    public boolean nqa = true;
    public boolean nrc = false;
    public boolean oKA = false;
    public int oKB = 0;
    int oKC = 0;
    Drawable oKD = null;
    public int oKE = 0;
    public Drawable oKF = null;
    public String oKG = null;
    public SFSContext oKH = null;
    public float oKI = 0.0F;
    public boolean oKJ = false;
    boolean oKK = true;
    boolean oKL = false;
    q oKM = null;
    public a oKN = null;
    public i oKO = null;
    public Object[] oKP = null;
    public com.tencent.mm.modelimage.loader.b.c oKe = null;
    public boolean oKn = true;
    public boolean oKo = false;
    public boolean oKp = false;
    public boolean oKq = true;
    String oKr = "";
    public int oKs = 5;
    public boolean oKt = false;
    int oKu = 0;
    boolean oKv = false;
    public boolean oKw;
    public int oKx;
    boolean oKy;
    boolean oKz = false;
    public String prefixPath = "";
    String thumbPath;
    
    public final a Oq(String paramString)
    {
      this.fullPath = paramString;
      return this;
    }
    
    public final a Or(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a a(a parama)
    {
      this.oKN = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.modelimage.loader.b.c paramc)
    {
      this.oKe = paramc;
      return this;
    }
    
    public final a bKs()
    {
      this.oKn = true;
      return this;
    }
    
    public final a bKt()
    {
      this.oKp = true;
      return this;
    }
    
    public final a bKu()
    {
      this.oKo = true;
      return this;
    }
    
    public final a bKv()
    {
      this.nqa = true;
      return this;
    }
    
    public final a bKw()
    {
      this.nrc = true;
      return this;
    }
    
    public final c bKx()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a bt(float paramFloat)
    {
      this.oKI = paramFloat;
      return this;
    }
    
    public final a eG(int paramInt1, int paramInt2)
    {
      this.npU = paramInt1;
      this.npV = paramInt2;
      return this;
    }
    
    public final a wB(int paramInt)
    {
      this.oKB = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.a.c
 * JD-Core Version:    0.7.0.1
 */