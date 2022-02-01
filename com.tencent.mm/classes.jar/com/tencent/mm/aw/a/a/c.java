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
  public final ap handler;
  public final String hdP;
  public final int hdR;
  public final int hdS;
  private final Drawable hdU;
  public final boolean hdX;
  public final boolean hfi;
  public final boolean idA;
  private final boolean idB;
  public final boolean idC;
  public final int idD;
  private final int idE;
  private final Drawable idF;
  public final int idG;
  private final Drawable idH;
  public final String idI;
  public final SFSContext idJ;
  public final float idK;
  public final boolean idL;
  public final boolean idM;
  public final boolean idN;
  public final q idO;
  public final a idP;
  public final i idQ;
  public final Object[] idR;
  public final com.tencent.mm.aw.a.c.c idg;
  public final boolean idp;
  public final boolean idq;
  public final boolean idr;
  public final boolean ids;
  public final String idt;
  public final int idu;
  public final boolean idv;
  public final boolean idw;
  public final boolean idy;
  public final int idz;
  public final String md5;
  public final String prefixPath;
  public final String thumbPath;
  
  private c(a parama)
  {
    this.idp = parama.idp;
    this.idr = parama.idr;
    this.idq = parama.idq;
    this.ids = parama.ids;
    this.hdP = parama.hdP;
    this.prefixPath = parama.prefixPath;
    this.idt = parama.idt;
    this.idu = parama.idu;
    this.hdR = parama.hdR;
    this.hdS = parama.hdS;
    this.idv = parama.idv;
    this.md5 = parama.md5;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.idw = parama.idw;
    this.idy = parama.idy;
    this.idz = parama.idz;
    this.thumbPath = parama.thumbPath;
    this.idA = parama.idA;
    this.idB = parama.idB;
    this.idC = parama.idC;
    this.idD = parama.idD;
    this.hdU = parama.hdU;
    this.idE = parama.idE;
    this.idF = parama.idF;
    this.idG = parama.idG;
    this.idH = parama.idH;
    this.hdX = parama.hdX;
    this.hfi = parama.hfi;
    this.idK = parama.idK;
    this.idL = parama.idL;
    this.idM = parama.idM;
    this.idN = parama.idN;
    this.idJ = parama.idJ;
    this.handler = parama.handler;
    this.idR = parama.idR;
    this.idg = parama.idg;
    this.idO = parama.idO;
    this.idP = parama.idP;
    this.idQ = parama.idQ;
    this.idI = parama.idI;
  }
  
  public static c aIT()
  {
    AppMethodBeat.i(130402);
    c localc = new a().aJc();
    AppMethodBeat.o(130402);
    return localc;
  }
  
  public final boolean aIU()
  {
    return (this.idD > 0) || (this.hdU != null);
  }
  
  public final boolean aIV()
  {
    return (this.idG > 0) || (this.idH != null);
  }
  
  public final String aIW()
  {
    return this.hdP;
  }
  
  public final Drawable f(Resources paramResources)
  {
    AppMethodBeat.i(130403);
    if (this.idD != 0)
    {
      paramResources = paramResources.getDrawable(this.idD);
      AppMethodBeat.o(130403);
      return paramResources;
    }
    paramResources = this.hdU;
    AppMethodBeat.o(130403);
    return paramResources;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(130404);
    if (this.idG != 0)
    {
      paramResources = paramResources.getDrawable(this.idG);
      AppMethodBeat.o(130404);
      return paramResources;
    }
    paramResources = this.idH;
    AppMethodBeat.o(130404);
    return paramResources;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    int density = 0;
    ap handler = null;
    public String hdP = "";
    public int hdR = 0;
    public int hdS = 0;
    public Drawable hdU = null;
    public boolean hdX = true;
    public boolean hfi = false;
    boolean idA;
    boolean idB = false;
    boolean idC = false;
    public int idD = 0;
    int idE = 0;
    Drawable idF = null;
    public int idG = 0;
    public Drawable idH = null;
    public String idI = null;
    public SFSContext idJ = null;
    public float idK = 0.0F;
    public boolean idL = false;
    boolean idM = true;
    boolean idN = false;
    q idO = null;
    public a idP = null;
    public i idQ = null;
    public Object[] idR = null;
    public com.tencent.mm.aw.a.c.c idg = null;
    public boolean idp = true;
    public boolean idq = false;
    public boolean idr = false;
    public boolean ids = true;
    String idt = "";
    public int idu = 5;
    public boolean idv = false;
    boolean idw = false;
    public boolean idy;
    public int idz;
    public String md5 = "";
    public String prefixPath = "";
    String thumbPath;
    
    public final a FE(String paramString)
    {
      this.hdP = paramString;
      return this;
    }
    
    public final a FF(String paramString)
    {
      this.prefixPath = paramString;
      return this;
    }
    
    public final a FG(String paramString)
    {
      this.idI = paramString;
      return this;
    }
    
    public final a a(a parama)
    {
      this.idP = parama;
      return this;
    }
    
    public final a a(com.tencent.mm.aw.a.c.c paramc)
    {
      this.idg = paramc;
      return this;
    }
    
    public final a a(SFSContext paramSFSContext)
    {
      this.idJ = paramSFSContext;
      return this;
    }
    
    public final a aIX()
    {
      this.idp = true;
      return this;
    }
    
    public final a aIY()
    {
      this.idr = true;
      return this;
    }
    
    public final a aIZ()
    {
      this.idq = true;
      return this;
    }
    
    public final a aJa()
    {
      this.hfi = true;
      return this;
    }
    
    public final a aJb()
    {
      this.idL = true;
      return this;
    }
    
    public final c aJc()
    {
      AppMethodBeat.i(130401);
      c localc = new c(this, (byte)0);
      AppMethodBeat.o(130401);
      return localc;
    }
    
    public final a an(float paramFloat)
    {
      this.idK = paramFloat;
      return this;
    }
    
    public final a dh(int paramInt1, int paramInt2)
    {
      this.hdR = paramInt1;
      this.hdS = paramInt2;
      return this;
    }
    
    public final a pF(int paramInt)
    {
      this.hdR = paramInt;
      return this;
    }
    
    public final a pG(int paramInt)
    {
      this.hdS = paramInt;
      return this;
    }
    
    public final a pH(int paramInt)
    {
      this.idD = paramInt;
      return this;
    }
    
    public final a pI(int paramInt)
    {
      this.idG = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.a.c
 * JD-Core Version:    0.7.0.1
 */