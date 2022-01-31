package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public u kBd;
  public String kwY;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    this.kEo = false;
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.i();
    paramHashSet.bVk = this.bVk;
    paramHashSet.kwY = this.kwY;
    paramHashSet.kxf = this;
    paramHashSet.handler = paramah;
    paramHashSet.kwX = 3;
    return ((n)g.t(n.class)).search(3, paramHashSet);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK;
    if (parama.kxL) {
      i -= 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.a.a.l locall = null;
      Object localObject = locall;
      if (i < parama.kxO.size())
      {
        localObject = locall;
        if (i >= 0)
        {
          locall = (com.tencent.mm.plugin.fts.a.a.l)parama.kxO.get(i);
          if (!locall.kwg.equals("create_talker_message​")) {
            break label129;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxT = false;
          ((com.tencent.mm.plugin.fts.ui.a.i)localObject).kwY = this.kwY;
          this.kEo = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kxW = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).kwi = parama.kwi;
        }
        return localObject;
        label129:
        if (locall.kwg.equals("no_result​"))
        {
          localObject = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).fYx = locall;
          ((d)localObject).kwi = parama.kwi;
          ((d)localObject).kBd = this.kBd;
          ((d)localObject).cU(locall.type, locall.kwf);
        }
      }
    }
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    paramHashSet = paramj.kxh;
    Object localObject;
    if (bA(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.l)paramHashSet.get(0);
        if (((com.tencent.mm.plugin.fts.a.a.l)localObject).kwg.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.kxL = false;
          locala.kxO = new ArrayList();
          locala.kxO.add(localObject);
          locala.kwi = paramj.kwi;
          locala.businessType = -2;
          this.kzW.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).kwi = paramj.kwi;
      if (paramHashSet.size() != 0) {
        break label203;
      }
      ((e.a)localObject).kxL = false;
      paramj = new com.tencent.mm.plugin.fts.a.a.l();
      paramj.kwg = "no_result​";
      ((e.a)localObject).kxO = new ArrayList();
      ((e.a)localObject).kxO.add(paramj);
    }
    for (;;)
    {
      this.kzW.add(localObject);
      return;
      label203:
      ((e.a)localObject).kxO = paramHashSet;
    }
  }
  
  protected final com.tencent.mm.plugin.fts.ui.a.k b(int paramInt, e.a parama)
  {
    e locale = new e(paramInt);
    locale.talker = this.kwY;
    locale.count = parama.kxO.size();
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */