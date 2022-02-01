package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bh;

public final class f
{
  public int IB;
  public int mStatus;
  public a uAZ;
  public akh uBa;
  public ajw uBb;
  public int uBc;
  public String uBd;
  public boolean uBe;
  public boolean uBf = true;
  public boolean uBg = false;
  
  public f(ajw paramajw)
  {
    this.uBb = paramajw;
    this.uAZ = a.uBi;
  }
  
  public f(akh paramakh)
  {
    this.uBa = paramakh;
    this.uAZ = a.uBh;
  }
  
  public final void a(boolean paramBoolean1, bh parambh, boolean paramBoolean2)
  {
    AppMethodBeat.i(108382);
    akh localakh = this.uBa;
    if (localakh == null)
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
    paramBoolean2 = e.a(localakh);
    boolean bool1 = e.b(localakh);
    boolean bool2 = e.e(localakh);
    boolean bool3 = TextUtils.isEmpty(localakh.Tex);
    if ((bool2) && (bool1)) {
      setStatus(8);
    }
    for (;;)
    {
      if ((paramBoolean1) && (parambh != null) && (!Util.isNullOrNil(parambh.VFu)))
      {
        this.uBa.Tex = parambh.VFu;
        this.uBa.VHC = parambh.VFt;
        this.uBa.SuH = parambh.VFs;
      }
      AppMethodBeat.o(108382);
      return;
      if (paramBoolean2)
      {
        setStatus(3);
        if ((bool1) || ((!paramBoolean1) && (bool3))) {
          this.uBc = 0;
        } else {
          this.uBc = 1;
        }
      }
      else if ((bool1) || ((!paramBoolean1) && (bool3)))
      {
        setStatus(3);
        this.uBc = 0;
      }
      else
      {
        this.uBc = 1;
        if ((paramBoolean1) && (parambh != null)) {}
        switch (parambh.VFq)
        {
        default: 
          if ((parambh.VFo != 7) && (parambh.VFo != 6) && (parambh.VFo != 3)) {
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
    if ((paramInt == 7) && (this.mStatus == 6) && (this.uBf)) {
      this.uBe = true;
    }
    this.mStatus = paramInt;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108381);
      uBh = new a("summary", 0);
      uBi = new a("cellset", 1);
      uBj = new a[] { uBh, uBi };
      AppMethodBeat.o(108381);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */