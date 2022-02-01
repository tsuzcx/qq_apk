package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  public boolean HNS;
  private int HNT;
  private int HNU;
  private int mColor;
  private Context mContext;
  private Resources mResources;
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(111506);
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.HNS = true;
    this.HNT = 0;
    this.HNU = 0;
    this.mColor = -1;
    AppMethodBeat.o(111506);
  }
  
  public final a WK(int paramInt)
  {
    AppMethodBeat.i(289561);
    this.mColor = a.w(this.mContext, paramInt);
    AppMethodBeat.o(289561);
    return this;
  }
  
  public final a WL(int paramInt)
  {
    AppMethodBeat.i(289563);
    this.HNU = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(289563);
    return this;
  }
  
  public final a WM(int paramInt)
  {
    AppMethodBeat.i(289564);
    this.HNT = this.mResources.getDimensionPixelSize(paramInt);
    AppMethodBeat.o(289564);
    return this;
  }
  
  public final c fBB()
  {
    AppMethodBeat.i(289566);
    c localc = new c(this.HNT, this.HNU, this.mColor, this.HNS, (byte)0);
    AppMethodBeat.o(289566);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.c.a
 * JD-Core Version:    0.7.0.1
 */