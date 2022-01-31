package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi.b;

final class c$f
{
  long bIt;
  String content;
  long createTime;
  int kzl;
  int kzm;
  String kzn;
  String kzo;
  int msgType;
  String talker;
  
  private c$f(c paramc) {}
  
  public final boolean aVK()
  {
    return (this.msgType & 0xFFFF) == 49;
  }
  
  public final boolean aVL()
  {
    return this.msgType == 1;
  }
  
  public final boolean aVM()
  {
    return this.msgType == 48;
  }
  
  public final void aVN()
  {
    if (aVL())
    {
      this.kzl = 41;
      if (s.fn(this.talker)) {
        this.kzn = bd.iJ(this.content);
      }
    }
    for (;;)
    {
      if (!bk.bl(this.kzn)) {
        this.kzn = d.DQ(this.kzn);
      }
      if (this.kzm != 1) {
        break;
      }
      this.kzo = q.Gj();
      return;
      this.kzn = this.content;
      continue;
      Object localObject;
      if (aVK())
      {
        localObject = g.a.gp(this.content);
        if (localObject != null) {
          switch (((g.a)localObject).type)
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
            this.kzn = bk.aM(((g.a)localObject).getTitle(), "");
            this.kzl = 43;
            break;
          case 6: 
            this.kzn = bk.aM(((g.a)localObject).getTitle(), "");
            this.kzl = 42;
            break;
          case 19: 
            this.kzn = bk.aM(((g.a)localObject).getDescription(), "");
            if (this.kzn != null) {
              this.kzn = this.kzn.replace(":", "​");
            }
            this.kzl = 44;
            break;
          case 24: 
            this.kzn = bk.aM(((g.a)localObject).getDescription(), "");
            if (this.kzn != null) {
              this.kzn = this.kzn.replace(":", "​");
            }
            this.kzl = 49;
            break;
          case 33: 
            this.kzn = bk.aM(((g.a)localObject).getTitle(), "");
            this.kzl = 48;
            break;
          case 2000: 
            this.kzn = (bk.aM(((g.a)localObject).title, "") + "​" + bk.aM(((g.a)localObject).description, ""));
            this.kzl = 45;
            break;
          case 2001: 
            if ("1001".equals(((g.a)localObject).dSh))
            {
              this.kzl = 47;
              if (this.kzm == 1)
              {
                this.kzn = (bk.aM(((g.a)localObject).dSf, "") + "​" + bk.aM(((g.a)localObject).dSc, ""));
                continue;
              }
              this.kzn = (bk.aM(((g.a)localObject).dSf, "") + "​" + bk.aM(((g.a)localObject).dSb, ""));
              continue;
            }
            if (!"1002".equals(((g.a)localObject).dSh)) {
              continue;
            }
            this.kzl = 46;
            if (this.kzm == 1)
            {
              this.kzn = (bk.aM(((g.a)localObject).dSf, "") + "​" + bk.aM(((g.a)localObject).dSc, ""));
              continue;
            }
            this.kzn = (bk.aM(((g.a)localObject).dSf, "") + "​" + bk.aM(((g.a)localObject).dSb, ""));
            break;
          }
        }
      }
      else if (aVM())
      {
        this.kzl = 50;
        if (s.fn(this.talker)) {}
        for (localObject = bd.iJ(this.content);; localObject = this.content)
        {
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HO((String)localObject);
          if (!((bi.b)localObject).cvN()) {
            break label791;
          }
          this.kzn = (((bi.b)localObject).lFn + "​" + ((bi.b)localObject).label);
          break;
        }
        label791:
        this.kzn = ((bi.b)localObject).label;
      }
    }
    if (s.fn(this.talker))
    {
      this.kzo = bk.aM(bd.iI(this.content), this.talker);
      return;
    }
    this.kzo = this.talker;
  }
  
  public final boolean isAvailable()
  {
    return !bk.bl(this.kzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.f
 * JD-Core Version:    0.7.0.1
 */