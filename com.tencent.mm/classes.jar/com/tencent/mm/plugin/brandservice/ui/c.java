package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int fTH;
  protected int mScene;
  protected boolean nXA;
  protected boolean nXB;
  int nXC;
  protected long[] nXD;
  protected b nXE;
  protected String nXu;
  protected int nXv;
  private List<a> nXy;
  private boolean nXz;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.nXy = new ArrayList();
    G(true, true);
    this.nXz = true;
    b(new long[] { 1L });
    AppMethodBeat.o(5624);
  }
  
  private static int a(a parama)
  {
    int j = 1;
    if (parama == null) {
      return 0;
    }
    int k = parama.count;
    int i;
    if (parama.nXG)
    {
      i = 1;
      if (!parama.nXH) {
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
  
  private a a(qr paramqr)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.nXI = new LinkedList();
    locala.nXI.add(paramqr);
    locala.dle = paramqr.FMq;
    locala.count = paramqr.ugO.size();
    locala.continueFlag = paramqr.FMr;
    locala.fSq = new LinkedList();
    locala.fSq.addAll(paramqr.ugO);
    locala.nXF = paramqr.FMs;
    locala.nXG = this.nXB;
    locala.nXH = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.nXA) && (parama.continueFlag != 0);
  }
  
  private void bNR()
  {
    boolean bool = true;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(5632);
        HashMap localHashMap = new HashMap();
        i = 0;
        a locala;
        if (i < this.nXy.size())
        {
          locala = (a)this.nXy.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.dle), locala);
          }
        }
        else
        {
          this.nXy.clear();
          this.fTH = 0;
          i = 0;
          int j;
          if (i < this.nXD.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.nXD[i]));
            if (locala == null) {
              break label281;
            }
            this.nXy.add(locala);
            j = this.fTH;
            this.fTH = (a(locala) + j);
            break label281;
          }
          if (this.nXy.size() > 0)
          {
            locala = (a)this.nXy.get(this.nXy.size() - 1);
            if (locala.nXH == this.nXz)
            {
              j = this.fTH;
              if (!locala.nXH) {
                continue;
              }
              i = -1;
              this.fTH = (i + j);
              if (this.nXz) {
                continue;
              }
              locala.nXH = bool;
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(5632);
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
      label281:
      i += 1;
    }
  }
  
  private int tl(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.nXy.size())
    {
      if (((a)this.nXy.get(i)).dle == paramLong)
      {
        AppMethodBeat.o(5629);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(5629);
    return -1;
  }
  
  public final void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nXB = paramBoolean1;
    this.nXA = paramBoolean2;
  }
  
  public void a(qr paramqr, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.nXz) && (paramqr == null)) || (paramqr.ugO == null))
    {
      ad.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.nXC = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = tk(paramqr.FMq);
    if (locala == null) {
      if (paramBoolean)
      {
        paramqr = a(paramqr);
        this.nXy.add(paramqr);
        bNR();
      }
    }
    for (;;)
    {
      aq.f(this.JtU);
      AppMethodBeat.o(5627);
      return;
      ad.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramqr.FMq) });
      AppMethodBeat.o(5627);
      return;
      if (locala.fSq == null) {
        locala.fSq = new LinkedList();
      }
      locala.fSq.addAll(paramqr.ugO);
      if (locala.nXI == null) {
        locala.nXI = new LinkedList();
      }
      locala.nXI.add(paramqr);
      locala.count += paramqr.ugO.size();
      this.fTH += paramqr.ugO.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.nXD = paramVarArgs;
    }
  }
  
  public void bNS()
  {
    AppMethodBeat.i(5633);
    l(null, null);
    this.nXC = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.fTH;
  }
  
  public void l(String paramString, List<qr> paramList)
  {
    AppMethodBeat.i(5625);
    this.nXy.clear();
    this.JtT.clear();
    aq.f(this.JtU);
    this.fTH = 0;
    this.nXu = paramString;
    if (paramList != null)
    {
      this.nXC = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (qr)paramList.get(i);
        if ((paramString != null) && (paramString.ugO != null) && (paramString.ugO.size() > 0))
        {
          paramString = a(paramString);
          this.fTH += a(paramString);
          this.nXy.add(paramString);
          ad.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.dle), Integer.valueOf(paramString.count), Integer.valueOf(this.fTH) });
        }
        i += 1;
      }
      bNR();
    }
    aq.f(this.JtU);
    AppMethodBeat.o(5625);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public final void setAddContactScene(int paramInt)
  {
    this.nXv = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.nXE = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  final a tk(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = tl(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.nXy.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  protected final a zi(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.nXy.size())
      {
        a locala = (a)this.nXy.get(i);
        j += a(locala);
        if (paramInt < j)
        {
          AppMethodBeat.o(5630);
          return locala;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(5630);
    return null;
  }
  
  protected final qr zj(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.nXy.size())
      {
        a locala = (a)this.nXy.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.nXG)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.nXI.size()) {
              break label156;
            }
            qr localqr = (qr)locala.nXI.get(i);
            j += localqr.ugO.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localqr;
              i = 0;
              break;
            }
            i += 1;
          }
        }
        i += 1;
      }
    }
    label156:
    AppMethodBeat.o(5631);
    return null;
  }
  
  public final com.tencent.mm.ui.base.sortview.a zk(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.nXy.size())
    {
      Object localObject2 = (a)this.nXy.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).nXG) && (paramInt == j - m)) {
        if (((a)localObject2).nXI.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((qr)localObject1).Title);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (qr)((a)localObject2).nXI.get(0);
        continue;
        if ((((a)localObject2).nXH) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).dle, ((a)localObject2).count, this.nXu);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).nXH) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (qy)((a)localObject2).fSq.get(i);
          long l = ((a)localObject2).dle;
          localObject2 = this.nXE;
          if (localObject1 == null)
          {
            ad.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            AppMethodBeat.o(5634);
            return null;
          }
          if (l == 1L)
          {
            ad.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            if ((localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a))
            {
              com.tencent.mm.plugin.brandservice.ui.base.a locala = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
              locala.zp(i);
              locala.setPosition(paramInt);
              locala.setReporter((b)localObject2);
            }
            AppMethodBeat.o(5634);
            return localObject1;
            if (l == 4L) {
              localObject1 = new h(localObject1);
            } else if (l == 1073741824L) {
              localObject1 = new h(localObject1);
            } else {
              localObject1 = new h(localObject1);
            }
          }
        }
      }
      i += 1;
    }
    Object localObject1 = new h(null);
    AppMethodBeat.o(5634);
    return localObject1;
  }
  
  public Object[] zl(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = zi(paramInt);
    Object localObject1 = zj(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((qr)localObject1).FMt; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).nXF;
      paramInt = this.nXv;
      AppMethodBeat.o(5635);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(5635);
    return null;
  }
  
  protected static final class a
  {
    public int continueFlag;
    public int count;
    public long dle;
    public List<qy> fSq;
    public List<String> nXF;
    public boolean nXG;
    public boolean nXH;
    public List<qr> nXI;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */