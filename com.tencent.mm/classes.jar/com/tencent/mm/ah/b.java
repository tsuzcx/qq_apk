package com.tencent.mm.ah;

import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bsi;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
  extends k
{
  public int ccs = 0;
  public int dEk;
  public b ecE = null;
  public c ecF = null;
  public int ecG;
  public String uri;
  
  private b(a parama1, a parama2, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if ((parama1 instanceof blm)) {
        bool1 = true;
      }
    }
    this.ecE = new b(parama1, paramInt1, paramInt2, bool1, paramInt5);
    this.ecF = new c(parama2, paramInt3, paramBoolean);
    this.uri = paramString;
    this.ecG = paramInt1;
    this.dEk = paramInt4;
  }
  
  public final a Kn()
  {
    return this.ecE.ecN;
  }
  
  public final a Ko()
  {
    return this.ecF.ecN;
  }
  
  public final int Kp()
  {
    return this.dEk;
  }
  
  public final int Kq()
  {
    return this.ccs;
  }
  
  public final void a(y paramy)
  {
    this.ecE.spM = paramy;
  }
  
  public final int getType()
  {
    return this.ecG;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public static final class a
  {
    public int dEk = 0;
    public int ecG;
    public a ecH;
    public a ecI;
    public int ecJ = 0;
    public int ecK = 0;
    public boolean ecL = true;
    public int ecM = 0;
    public String uri;
    
    public final void Kr()
    {
      this.ecJ = 209;
    }
    
    public final void Ks()
    {
      this.ecK = 1000000209;
    }
    
    public final b Kt()
    {
      boolean bool5 = true;
      if ((this.ecH == null) || (this.ecI == null) || (bk.bl(this.uri)) || (this.ecG <= 0) || (this.ecJ == -2147483648) || (this.ecK == -2147483648))
      {
        boolean bool1;
        boolean bool2;
        label70:
        boolean bool6;
        boolean bool3;
        label88:
        boolean bool4;
        if (this.ecH == null)
        {
          bool1 = true;
          if (this.ecI != null) {
            break label177;
          }
          bool2 = true;
          bool6 = bk.bl(this.uri);
          if (this.ecG > 0) {
            break label182;
          }
          bool3 = true;
          if (this.ecJ != -2147483648) {
            break label187;
          }
          bool4 = true;
          label100:
          if (this.ecK != -2147483648) {
            break label193;
          }
        }
        for (;;)
        {
          throw new IllegalArgumentException(String.format("%s %s %s %s %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool6), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
          bool1 = false;
          break;
          label177:
          bool2 = false;
          break label70;
          label182:
          bool3 = false;
          break label88;
          label187:
          bool4 = false;
          break label100;
          label193:
          bool5 = false;
        }
      }
      return new b(this.ecH, this.ecI, this.uri, this.ecG, this.ecJ, this.ecK, this.ecL, this.dEk, this.ecM, (byte)0);
    }
    
    public final void a(a parama)
    {
      this.ecH = parama;
    }
    
    public final void b(a parama)
    {
      this.ecI = parama;
    }
    
    public final void ig(int paramInt)
    {
      this.ecG = paramInt;
    }
    
    public final void kr(String paramString)
    {
      this.uri = paramString;
    }
  }
  
  public static final class b
    extends k.d
    implements k.b
  {
    public int cmdId;
    private int ecG;
    public a ecN;
    private boolean ecO;
    
    public b(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.ecN = parama;
      this.ecG = paramInt1;
      this.cmdId = paramInt2;
      this.ecO = paramBoolean;
      this.ecM = paramInt3;
    }
    
    public final byte[] HG()
    {
      if ((this.ecN instanceof blm)) {
        ((blm)this.ecN).tEX = com.tencent.mm.protocal.k.a(this);
      }
      return this.ecN.toByteArray();
    }
    
    public final int HH()
    {
      return this.ecG;
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
  
  public static final class c
    extends k.e
    implements k.c
  {
    public int cmdId;
    public a ecN = null;
    private boolean ecO;
    
    public c(a parama, int paramInt, boolean paramBoolean)
    {
      this.ecN = parama;
      this.cmdId = paramInt;
      this.ecO = paramBoolean;
    }
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.ecN = this.ecN.aH(paramArrayOfByte);
      if (!(this.ecN instanceof bsi))
      {
        com.tencent.mm.protocal.k.a(this, ((bly)this.ecN).tFx);
        return ((bly)this.ecN).tFx.sze;
      }
      return ((bsi)this.ecN).getRet();
    }
    
    public final int getCmdId()
    {
      return this.cmdId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.b
 * JD-Core Version:    0.7.0.1
 */