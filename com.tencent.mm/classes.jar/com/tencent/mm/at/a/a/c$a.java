package com.tencent.mm.at.a.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.at.a.c.o;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ak;

public final class c$a
{
  float alpha = 0.0F;
  public String cqq = "";
  int density = 0;
  public boolean eNK = true;
  public boolean eNL = false;
  public boolean eNM = false;
  public boolean eNN = true;
  public String eNO = "";
  public String eNP = "";
  String eNQ = "";
  public int eNS = 0;
  public int eNT = 0;
  public boolean eNU = false;
  public boolean eNV = false;
  boolean eNW = false;
  boolean eNX = false;
  public int eNY = 0;
  public Drawable eNZ = null;
  public int eOa = 0;
  public Drawable eOb = null;
  public String eOc = null;
  public SFSContext eOd = null;
  public boolean eOe = true;
  public boolean eOf = false;
  boolean eOg = true;
  public Object[] eOi = null;
  public boolean eOk = false;
  public float eOl = 0.0F;
  boolean eOm = false;
  public b fHk = null;
  public int fHt = 5;
  public boolean fHu;
  public int fHv;
  boolean fHw;
  int fHx = 0;
  Drawable fHy = null;
  o fHz = null;
  ak handler = null;
  String thumbPath;
  
  public final a a(b paramb)
  {
    this.fHk = paramb;
    return this;
  }
  
  public final a a(SFSContext paramSFSContext)
  {
    this.eOd = paramSFSContext;
    return this;
  }
  
  public final a ahT()
  {
    this.eNK = true;
    return this;
  }
  
  public final a ahU()
  {
    this.eNM = true;
    return this;
  }
  
  public final a ahV()
  {
    this.eNL = true;
    return this;
  }
  
  public final a ahW()
  {
    this.eOk = true;
    return this;
  }
  
  public final a ahX()
  {
    this.eOf = true;
    return this;
  }
  
  public final c ahY()
  {
    AppMethodBeat.i(116072);
    c localc = new c(this, (byte)0);
    AppMethodBeat.o(116072);
    return localc;
  }
  
  public final a cx(int paramInt1, int paramInt2)
  {
    this.eNS = paramInt1;
    this.eNT = paramInt2;
    return this;
  }
  
  public final a lF(int paramInt)
  {
    this.eNS = paramInt;
    return this;
  }
  
  public final a lG(int paramInt)
  {
    this.eNT = paramInt;
    return this;
  }
  
  public final a lH(int paramInt)
  {
    this.eNY = paramInt;
    return this;
  }
  
  public final a lI(int paramInt)
  {
    this.eOa = paramInt;
    return this;
  }
  
  public final a tA(String paramString)
  {
    this.eOc = paramString;
    return this;
  }
  
  public final a ty(String paramString)
  {
    this.eNO = paramString;
    return this;
  }
  
  public final a tz(String paramString)
  {
    this.eNP = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */