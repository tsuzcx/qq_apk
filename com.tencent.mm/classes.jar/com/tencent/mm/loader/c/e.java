package com.tencent.mm.loader.c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.e.c.a;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
{
  public static boolean DEBUG = true;
  public static final e.b eNJ = e.b.eOn;
  private final float alpha;
  private final String cqq;
  private final int density;
  private final boolean eNK;
  private final boolean eNL;
  private final boolean eNM;
  private final boolean eNN;
  private final String eNO;
  private final String eNP;
  private final String eNQ;
  private final e.b eNR;
  private final int eNS;
  private final int eNT;
  private final boolean eNU;
  private final boolean eNV;
  private final boolean eNW;
  private final boolean eNX;
  private final int eNY;
  private final Drawable eNZ;
  private final int eOa;
  private final Drawable eOb;
  private final String eOc;
  private final SFSContext eOd;
  private final boolean eOe;
  private final boolean eOf;
  private final boolean eOg;
  private final b eOh;
  private final Object[] eOi;
  private final ak handler;
  
  private e(a parama)
  {
    this.eNK = parama.eNK;
    this.eNM = parama.eNM;
    this.eNL = parama.eNL;
    this.eNN = parama.eNN;
    this.eNO = parama.eNO;
    this.eNP = parama.eNP;
    this.eNQ = parama.eNQ;
    this.eNR = parama.eNR;
    this.eNS = parama.eNS;
    this.eNT = parama.eNT;
    this.eNU = parama.eNU;
    this.cqq = parama.cqq;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.eNV = parama.eNV;
    this.eNW = parama.eNW;
    this.eNX = parama.eNX;
    this.eNY = parama.eNY;
    this.eNZ = parama.eNZ;
    this.eOa = parama.eOa;
    this.eOb = parama.eOb;
    this.eOe = parama.eOe;
    this.eOf = parama.eOf;
    this.eOg = parama.eOg;
    this.eOd = parama.eOd;
    this.handler = parama.handler;
    this.eOi = parama.eOi;
    this.eOh = parama.eOh;
    this.eOc = parama.eOc;
  }
  
  public static e To()
  {
    return new a().TI();
  }
  
  public final boolean TA()
  {
    return this.eNU;
  }
  
  public final String TB()
  {
    return this.cqq;
  }
  
  public final SFSContext TC()
  {
    return this.eOd;
  }
  
  public final Object[] TD()
  {
    if (this.eOi == null) {
      return new Object[0];
    }
    return this.eOi;
  }
  
  public final boolean TE()
  {
    return this.eNX;
  }
  
  public final boolean Tp()
  {
    return this.eNK;
  }
  
  public final boolean Tq()
  {
    return this.eNM;
  }
  
  public final boolean Tr()
  {
    return this.eNL;
  }
  
  public final String Ts()
  {
    return this.eNO;
  }
  
  public final String Tt()
  {
    return this.eNP;
  }
  
  public final String Tu()
  {
    return this.eNQ;
  }
  
  public final e.b Tv()
  {
    return this.eNR;
  }
  
  public final int Tw()
  {
    return this.eNS;
  }
  
  public final int Tx()
  {
    return this.eNT;
  }
  
  public final boolean Ty()
  {
    return this.eNV;
  }
  
  public final int Tz()
  {
    return this.eOa;
  }
  
  public final Drawable f(Resources paramResources)
  {
    if (this.eOa != 0) {
      return paramResources.getDrawable(this.eOa);
    }
    return this.eOb;
  }
  
  public final float getAlpha()
  {
    return this.alpha;
  }
  
  public static final class a
  {
    float alpha = 0.0F;
    String cqq = "";
    int density = 0;
    boolean eNK = true;
    boolean eNL = false;
    boolean eNM = false;
    boolean eNN = true;
    String eNO = "";
    String eNP = "";
    String eNQ = "";
    e.b eNR = e.eNJ;
    int eNS = 0;
    int eNT = 0;
    boolean eNU = false;
    boolean eNV = false;
    boolean eNW = false;
    boolean eNX = false;
    int eNY = 0;
    Drawable eNZ = null;
    int eOa = 0;
    Drawable eOb = null;
    String eOc = null;
    SFSContext eOd = null;
    boolean eOe = true;
    boolean eOf = false;
    boolean eOg = true;
    b eOh = null;
    Object[] eOi = null;
    private a eOj = null;
    private boolean eOk = false;
    private float eOl = 0.0F;
    private boolean eOm = false;
    ak handler = null;
    
    public final a TF()
    {
      this.eNK = true;
      return this;
    }
    
    public final a TG()
    {
      this.eNM = true;
      return this;
    }
    
    public final a TH()
    {
      this.eOa = 2130838904;
      return this;
    }
    
    public final e TI()
    {
      return new e(this, (byte)0);
    }
    
    public final a jV(int paramInt)
    {
      this.eNS = paramInt;
      return this;
    }
    
    public final a jW(int paramInt)
    {
      this.eNT = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */