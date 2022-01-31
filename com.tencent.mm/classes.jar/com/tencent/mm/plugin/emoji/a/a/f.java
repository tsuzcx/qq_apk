package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ar;

public final class f
{
  public f.a iVT;
  public vn iVU;
  public ve iVV;
  public int iVW;
  public String iVX;
  public boolean iVY;
  public boolean iVZ = true;
  public boolean iWa = false;
  public int mStatus;
  public int xL;
  
  public f(ve paramve)
  {
    this.iVV = paramve;
    this.iVT = f.a.iWc;
  }
  
  public f(vn paramvn)
  {
    this.iVU = paramvn;
    this.iVT = f.a.iWb;
  }
  
  public final void a(boolean paramBoolean1, ar paramar, boolean paramBoolean2)
  {
    vn localvn = this.iVU;
    if (localvn == null) {}
    label291:
    for (;;)
    {
      return;
      if (paramBoolean2)
      {
        setStatus(7);
        return;
      }
      boolean bool1 = e.a(localvn);
      boolean bool2 = e.b(localvn);
      boolean bool3;
      if (localvn == null)
      {
        paramBoolean2 = false;
        bool3 = TextUtils.isEmpty(localvn.sSf);
        if ((!paramBoolean2) || (!bool2)) {
          break label113;
        }
        setStatus(8);
      }
      for (;;)
      {
        if ((!paramBoolean1) || (paramar == null) || (bk.bl(paramar.uAQ))) {
          break label291;
        }
        this.iVU.sSf = paramar.uAQ;
        return;
        paramBoolean2 = e.cC(localvn.sSh, 8);
        break;
        label113:
        if (bool1)
        {
          setStatus(3);
          if ((bool2) || ((!paramBoolean1) && (bool3))) {
            this.iVW = 0;
          } else {
            this.iVW = 1;
          }
        }
        else if ((bool2) || ((!paramBoolean1) && (bool3)))
        {
          setStatus(3);
          this.iVW = 0;
        }
        else
        {
          this.iVW = 1;
          if ((paramBoolean1) && (paramar != null)) {}
          switch (paramar.uAO)
          {
          default: 
            if ((paramar.uAM != 7) && (paramar.uAM != 6) && (paramar.uAM != 3)) {
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
  }
  
  public final void setStatus(int paramInt)
  {
    if ((paramInt == 7) && (this.mStatus == 6) && (this.iVZ)) {
      this.iVY = true;
    }
    this.mStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.f
 * JD-Core Version:    0.7.0.1
 */