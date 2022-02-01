package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  boolean CbQ;
  private int CbR;
  private int CbS;
  private int mColor;
  private Context mContext;
  private Resources mResources;
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(111506);
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.CbQ = true;
    this.CbR = 0;
    this.CbS = 0;
    this.mColor = -1;
    AppMethodBeat.o(111506);
  }
  
  public final a Tc(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(244476);
    this.mColor = androidx.core.content.a.w(this.mContext, paramInt);
    AppMethodBeat.o(244476);
    return this;
  }
  
  public final a Td(int paramInt)
  {
    AppMethodBeat.i(244477);
    this.CbS = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(244477);
    return this;
  }
  
  public final a Te(int paramInt)
  {
    AppMethodBeat.i(244478);
    this.CbR = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(244478);
    return this;
  }
  
  public final a euF()
  {
    this.CbQ = false;
    return this;
  }
  
  public final c euG()
  {
    AppMethodBeat.i(244479);
    c localc = new c(this.CbR, this.CbS, this.mColor, this.CbQ, (byte)0);
    AppMethodBeat.o(244479);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c.a
 * JD-Core Version:    0.7.0.1
 */