package com.tencent.mm.at.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.at.a.c.o;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  public final float alpha;
  public final String cqq;
  public final int density;
  public final boolean eNK;
  public final boolean eNL;
  public final boolean eNM;
  public final boolean eNN;
  public final String eNO;
  public final String eNP;
  public final String eNQ;
  public final int eNS;
  public final int eNT;
  public final boolean eNU;
  public final boolean eNV;
  private final boolean eNW;
  public final boolean eNX;
  public final int eNY;
  private final Drawable eNZ;
  public final int eOa;
  private final Drawable eOb;
  public final String eOc;
  public final SFSContext eOd;
  public final boolean eOe;
  public final boolean eOf;
  public final boolean eOg;
  public final Object[] eOi;
  public final boolean eOk;
  public final float eOl;
  public final boolean eOm;
  public final b fHk;
  public final int fHt;
  public final boolean fHu;
  public final int fHv;
  public final boolean fHw;
  private final int fHx;
  private final Drawable fHy;
  public final o fHz;
  public final ak handler;
  public final String thumbPath;
  
  private c(c.a parama)
  {
    this.eNK = parama.eNK;
    this.eNM = parama.eNM;
    this.eNL = parama.eNL;
    this.eNN = parama.eNN;
    this.eNO = parama.eNO;
    this.eNP = parama.eNP;
    this.eNQ = parama.eNQ;
    this.fHt = parama.fHt;
    this.eNS = parama.eNS;
    this.eNT = parama.eNT;
    this.eNU = parama.eNU;
    this.cqq = parama.cqq;
    this.density = parama.density;
    this.alpha = parama.alpha;
    this.eNV = parama.eNV;
    this.fHu = parama.fHu;
    this.fHv = parama.fHv;
    this.thumbPath = parama.thumbPath;
    this.fHw = parama.fHw;
    this.eNW = parama.eNW;
    this.eNX = parama.eNX;
    this.eNY = parama.eNY;
    this.eNZ = parama.eNZ;
    this.fHx = parama.fHx;
    this.fHy = parama.fHy;
    this.eOa = parama.eOa;
    this.eOb = parama.eOb;
    this.eOe = parama.eOe;
    this.eOk = parama.eOk;
    this.eOl = parama.eOl;
    this.eOf = parama.eOf;
    this.eOg = parama.eOg;
    this.eOm = parama.eOm;
    this.eOd = parama.eOd;
    this.handler = parama.handler;
    this.eOi = parama.eOi;
    this.fHk = parama.fHk;
    this.fHz = parama.fHz;
    this.eOc = parama.eOc;
  }
  
  public static c ahQ()
  {
    AppMethodBeat.i(116073);
    c localc = new c.a().ahY();
    AppMethodBeat.o(116073);
    return localc;
  }
  
  public final boolean ahR()
  {
    return (this.eNY > 0) || (this.eNZ != null);
  }
  
  public final boolean ahS()
  {
    return (this.eOa > 0) || (this.eOb != null);
  }
  
  public final Drawable f(Resources paramResources)
  {
    AppMethodBeat.i(116075);
    if (this.eOa != 0)
    {
      paramResources = paramResources.getDrawable(this.eOa);
      AppMethodBeat.o(116075);
      return paramResources;
    }
    paramResources = this.eOb;
    AppMethodBeat.o(116075);
    return paramResources;
  }
  
  public final Drawable g(Resources paramResources)
  {
    AppMethodBeat.i(116074);
    if (this.eNY != 0)
    {
      paramResources = paramResources.getDrawable(this.eNY);
      AppMethodBeat.o(116074);
      return paramResources;
    }
    paramResources = this.eNZ;
    AppMethodBeat.o(116074);
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.a.a.c
 * JD-Core Version:    0.7.0.1
 */