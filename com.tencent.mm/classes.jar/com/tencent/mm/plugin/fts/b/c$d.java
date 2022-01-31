package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi.b;

final class c$d
{
  String content;
  long cpO;
  long createTime;
  int mVb;
  int mVc;
  String mVd;
  String mVe;
  int msgType;
  String talker;
  
  private c$d(c paramc) {}
  
  public final boolean bCn()
  {
    return (this.msgType & 0xFFFF) == 49;
  }
  
  public final boolean bCo()
  {
    return this.msgType == 1;
  }
  
  public final boolean bCp()
  {
    return this.msgType == 48;
  }
  
  public final void bCq()
  {
    AppMethodBeat.i(136753);
    if (bCo())
    {
      this.mVb = 41;
      if (t.lA(this.talker)) {
        this.mVd = bf.pv(this.content);
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.mVd)) {
        this.mVd = d.OZ(this.mVd);
      }
      if (this.mVc != 1) {
        break;
      }
      this.mVe = r.Zn();
      AppMethodBeat.o(136753);
      return;
      this.mVd = this.content;
      continue;
      Object localObject;
      if (bCn())
      {
        localObject = j.b.mY(this.content);
        if (localObject != null) {
          switch (((j.b)localObject).type)
          {
          default: 
            break;
          case 3: 
          case 4: 
          case 5: 
          case 8: 
          case 10: 
          case 13: 
          case 15: 
          case 16: 
          case 20: 
          case 25: 
            this.mVd = bo.bf(((j.b)localObject).getTitle(), "");
            this.mVb = 43;
            break;
          case 6: 
            this.mVd = bo.bf(((j.b)localObject).getTitle(), "");
            this.mVb = 42;
            break;
          case 19: 
            this.mVd = bo.bf(((j.b)localObject).getDescription(), "");
            if (this.mVd != null) {
              this.mVd = this.mVd.replace(":", "​");
            }
            this.mVb = 44;
            break;
          case 24: 
            this.mVd = bo.bf(((j.b)localObject).getDescription(), "");
            if (this.mVd != null) {
              this.mVd = this.mVd.replace(":", "​");
            }
            this.mVb = 49;
            break;
          case 33: 
            this.mVd = bo.bf(((j.b)localObject).getTitle(), "");
            this.mVb = 48;
            break;
          case 2000: 
            this.mVd = (bo.bf(((j.b)localObject).title, "") + "​" + bo.bf(((j.b)localObject).description, ""));
            this.mVb = 45;
            break;
          case 2001: 
            if ("1001".equals(((j.b)localObject).fig))
            {
              this.mVb = 47;
              if (this.mVc == 1)
              {
                this.mVd = (bo.bf(((j.b)localObject).fie, "") + "​" + bo.bf(((j.b)localObject).fib, ""));
                continue;
              }
              this.mVd = (bo.bf(((j.b)localObject).fie, "") + "​" + bo.bf(((j.b)localObject).fia, ""));
              continue;
            }
            if (!"1002".equals(((j.b)localObject).fig)) {
              continue;
            }
            this.mVb = 46;
            if (this.mVc == 1)
            {
              this.mVd = (bo.bf(((j.b)localObject).fie, "") + "​" + bo.bf(((j.b)localObject).fib, ""));
              continue;
            }
            this.mVd = (bo.bf(((j.b)localObject).fie, "") + "​" + bo.bf(((j.b)localObject).fia, ""));
            break;
          }
        }
      }
      else if (bCp())
      {
        this.mVb = 50;
        if (t.lA(this.talker)) {}
        for (localObject = bf.pv(this.content);; localObject = this.content)
        {
          localObject = ((j)g.E(j.class)).bPQ().Tz((String)localObject);
          if (!((bi.b)localObject).dyv()) {
            break label799;
          }
          this.mVd = (((bi.b)localObject).eSM + "​" + ((bi.b)localObject).label);
          break;
        }
        label799:
        this.mVd = ((bi.b)localObject).label;
      }
    }
    if (t.lA(this.talker))
    {
      this.mVe = bo.bf(bf.pu(this.content), this.talker);
      AppMethodBeat.o(136753);
      return;
    }
    this.mVe = this.talker;
    AppMethodBeat.o(136753);
  }
  
  public final boolean isAvailable()
  {
    AppMethodBeat.i(136754);
    if (!bo.isNullOrNil(this.mVd))
    {
      AppMethodBeat.o(136754);
      return true;
    }
    AppMethodBeat.o(136754);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.d
 * JD-Core Version:    0.7.0.1
 */