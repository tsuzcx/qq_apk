package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int dsr;
  protected int fzn;
  private List<c.a> icB = new ArrayList();
  private boolean icC;
  protected boolean icD;
  protected boolean icE;
  int icF;
  protected long[] icG;
  protected c.b icH;
  protected String icx;
  protected int icy;
  
  public c(Context paramContext)
  {
    super(paramContext);
    u(true, true);
    this.icC = true;
    e(new long[] { 1L });
  }
  
  private static int a(c.a parama)
  {
    int j = 1;
    if (parama == null) {
      return 0;
    }
    int k = parama.count;
    int i;
    if (parama.icK)
    {
      i = 1;
      if (!parama.icL) {
        break label40;
      }
    }
    for (;;)
    {
      return i + k + j;
      i = 0;
      break;
      label40:
      j = 0;
    }
  }
  
  private c.a a(kq paramkq)
  {
    c.a locala = new c.a();
    locala.icM = new LinkedList();
    locala.icM.add(paramkq);
    locala.bGn = paramkq.sFC;
    locala.count = paramkq.kTw.size();
    locala.icI = paramkq.sFD;
    locala.drc = new LinkedList();
    locala.drc.addAll(paramkq.kTw);
    locala.icJ = paramkq.sFE;
    locala.icK = this.icE;
    if ((this.icD) && (locala.icI != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.icL = bool;
      return locala;
    }
  }
  
  private void axy()
  {
    boolean bool = true;
    for (;;)
    {
      int i;
      try
      {
        HashMap localHashMap = new HashMap();
        i = 0;
        c.a locala;
        if (i < this.icB.size())
        {
          locala = (c.a)this.icB.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.bGn), locala);
          }
        }
        else
        {
          this.icB.clear();
          this.dsr = 0;
          i = 0;
          int j;
          if (i < this.icG.length)
          {
            locala = (c.a)localHashMap.get(Long.valueOf(this.icG[i]));
            if (locala == null) {
              break label269;
            }
            this.icB.add(locala);
            j = this.dsr;
            this.dsr = (a(locala) + j);
            break label269;
          }
          if (this.icB.size() > 0)
          {
            locala = (c.a)this.icB.get(this.icB.size() - 1);
            if (locala.icL == this.icC)
            {
              j = this.dsr;
              if (!locala.icL) {
                continue;
              }
              i = -1;
              this.dsr = (i + j);
              if (this.icC) {
                continue;
              }
              locala.icL = bool;
            }
          }
          localHashMap.clear();
          return;
          i = 1;
          continue;
          bool = false;
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label269:
      i += 1;
    }
  }
  
  public void a(kq paramkq, boolean paramBoolean)
  {
    if (((this.icC) && (paramkq == null)) || (paramkq.kTw == null))
    {
      y.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      return;
    }
    if (isEmpty()) {
      this.icF = ((int)(System.currentTimeMillis() / 1000L));
    }
    c.a locala = cN(paramkq.sFC);
    if (locala == null) {
      if (paramBoolean)
      {
        paramkq = a(paramkq);
        this.icB.add(paramkq);
        axy();
      }
    }
    for (;;)
    {
      ai.d(this.vdX);
      return;
      y.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramkq.sFC) });
      return;
      if (locala.drc == null) {
        locala.drc = new LinkedList();
      }
      locala.drc.addAll(paramkq.kTw);
      if (locala.icM == null) {
        locala.icM = new LinkedList();
      }
      locala.icM.add(paramkq);
      locala.count += paramkq.kTw.size();
      this.dsr += paramkq.kTw.size();
    }
  }
  
  public void axz()
  {
    h(null, null);
    this.icF = 0;
  }
  
  final c.a cN(long paramLong)
  {
    int i = 0;
    if (i < this.icB.size()) {
      if (((c.a)this.icB.get(i)).bGn != paramLong) {}
    }
    for (;;)
    {
      if (i < 0) {
        break label66;
      }
      return (c.a)this.icB.get(i);
      i += 1;
      break;
      i = -1;
    }
    label66:
    return null;
  }
  
  public final void e(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.icG = paramVarArgs;
    }
  }
  
  public int getCount()
  {
    return this.dsr;
  }
  
  public void h(String paramString, List<kq> paramList)
  {
    this.icB.clear();
    this.vdW.clear();
    ai.d(this.vdX);
    this.dsr = 0;
    this.icx = paramString;
    if (paramList != null)
    {
      this.icF = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (kq)paramList.get(i);
        if ((paramString != null) && (paramString.kTw != null) && (paramString.kTw.size() > 0))
        {
          paramString = a(paramString);
          this.dsr += a(paramString);
          this.icB.add(paramString);
          y.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.bGn), Integer.valueOf(paramString.count), Integer.valueOf(this.dsr) });
        }
        i += 1;
      }
      axy();
    }
    ai.d(this.vdX);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  protected final c.a or(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.icB.size())
      {
        c.a locala = (c.a)this.icB.get(i);
        j += a(locala);
        if (paramInt < j) {
          return locala;
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected final kq os(int paramInt)
  {
    int k = 0;
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.icB.size())
      {
        c.a locala = (c.a)this.icB.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.icK)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.icM.size()) {
              break label144;
            }
            kq localkq = (kq)locala.icM.get(i);
            j += localkq.kTw.size();
            if (paramInt < j)
            {
              return localkq;
              i = 0;
              break;
            }
            i += 1;
          }
        }
        i += 1;
      }
    }
    label144:
    return null;
  }
  
  protected final com.tencent.mm.ui.base.sortview.a ot(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < this.icB.size())
    {
      Object localObject2 = (c.a)this.icB.get(i);
      int m = a((c.a)localObject2);
      j += m;
      Object localObject1;
      if ((((c.a)localObject2).icK) && (paramInt == j - m)) {
        if (((c.a)localObject2).icM.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject2 = new d(((kq)localObject1).bGw);
        return localObject2;
        localObject1 = (kq)((c.a)localObject2).icM.get(0);
        continue;
        if ((((c.a)localObject2).icL) && (paramInt == j - 1)) {
          return new e(((c.a)localObject2).bGn, ((c.a)localObject2).count, this.icx);
        }
        if (paramInt < j)
        {
          m = ((c.a)localObject2).count;
          i = k;
          if (((c.a)localObject2).icL) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (kw)((c.a)localObject2).drc.get(i);
          long l = ((c.a)localObject2).bGn;
          c.b localb = this.icH;
          if (localObject1 == null)
          {
            y.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            return null;
          }
          if (l == 1L)
          {
            y.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (!(localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a)) {
              break;
            }
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
            ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject2).ox(i);
            ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject2).setPosition(paramInt);
            ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject2).setReporter(localb);
            return localObject1;
            if (l == 4L) {
              localObject1 = new g(localObject1);
            } else if (l == 1073741824L) {
              localObject1 = new g(localObject1);
            } else {
              localObject1 = new g(localObject1);
            }
          }
        }
      }
      i += 1;
    }
    return new g(null);
  }
  
  protected Object[] ou(int paramInt)
  {
    c.a locala = or(paramInt);
    Object localObject = os(paramInt);
    if (localObject != null) {}
    for (localObject = ((kq)localObject).sFF; locala != null; localObject = "") {
      return new Object[] { this, locala.icJ, Integer.valueOf(this.icy), localObject };
    }
    return null;
  }
  
  public final void setAddContactScene(int paramInt)
  {
    this.icy = paramInt;
  }
  
  public final void setReporter(c.b paramb)
  {
    this.icH = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.fzn = paramInt;
  }
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.icE = paramBoolean1;
    this.icD = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */