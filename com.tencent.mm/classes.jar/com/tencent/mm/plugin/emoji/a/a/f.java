package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;

public final class f
{
  public int boE;
  public int mStatus;
  public f.a xHD;
  public cjb xHE;
  public anj xHF;
  public aoi xHG;
  public int xHH;
  public String xHI;
  public boolean xHJ;
  public boolean xHK = true;
  public boolean xHL = false;
  
  public f(anj paramanj)
  {
    this.xHF = paramanj;
    this.xHD = f.a.xHN;
  }
  
  public f(cjb paramcjb)
  {
    this.xHE = paramcjb;
    this.xHD = f.a.xHM;
  }
  
  public final void a(boolean paramBoolean1, bj parambj, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    cjb localcjb = this.xHE;
    if (localcjb == null)
    {
      AppMethodBeat.o(108382);
      return;
    }
    if (paramBoolean2)
    {
      setStatus(7);
      AppMethodBeat.o(108382);
      return;
    }
    paramBoolean2 = e.a(localcjb);
    boolean bool1 = e.b(localcjb);
    boolean bool2 = e.e(localcjb);
    boolean bool3 = TextUtils.isEmpty(localcjb.akkc);
    boolean bool4 = e.gO(localcjb.akke, 128);
    boolean bool5 = e.g(localcjb);
    if ((bool2) && (bool1)) {
      setStatus(8);
    }
    for (;;)
    {
      if ((paramBoolean1) && (parambj != null) && (!Util.isNullOrNil(parambj.adjh)))
      {
        this.xHE.akkc = parambj.adjh;
        this.xHE.akkj = parambj.adjg;
        this.xHE.Zuw = parambj.adjf;
      }
      AppMethodBeat.o(108382);
      return;
      if (bool5)
      {
        setStatus(-2);
      }
      else if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.xHH = 0;
        } else {
          this.xHH = 1;
        }
      }
      else if (bool4)
      {
        setStatus(20);
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.xHH = 0;
      }
      else
      {
        this.xHH = 1;
        if ((paramBoolean1) && (parambj != null)) {}
        switch (parambj.adjd)
        {
        default: 
          if ((parambj.adjb != 7) && (parambj.adjb != 6) && (parambj.adjb != 3)) {
            setStatus(10);
          }
          break;
        case 11: 
          setStatus(11);
          break;
        case 12: 
          setStatus(4);
          continue;
          if (paramBoolean1) {
            setStatus(11);
          } else {
            setStatus(4);
          }
          break;
        }
      }
    }
  }
  
  public final void setStatus(int paramInt)
  {
    if ((paramInt == 7) && (this.mStatus == 6) && (this.xHK)) {
      this.xHJ = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */