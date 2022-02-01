package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pm;
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
  private int fwK;
  protected int mScene;
  protected String mTE;
  protected int mTF;
  private List<a> mTI;
  private boolean mTJ;
  protected boolean mTK;
  protected boolean mTL;
  int mTM;
  protected long[] mTN;
  protected b mTO;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.mTI = new ArrayList();
    E(true, true);
    this.mTJ = true;
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
    if (parama.mTQ)
    {
      i = 1;
      if (!parama.mTR) {
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
  
  private a a(pf parampf)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.mTS = new LinkedList();
    locala.mTS.add(parampf);
    locala.dcn = parampf.CNp;
    locala.count = parampf.saZ.size();
    locala.continueFlag = parampf.CNq;
    locala.fvw = new LinkedList();
    locala.fvw.addAll(parampf.saZ);
    locala.mTP = parampf.CNr;
    locala.mTQ = this.mTL;
    locala.mTR = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.mTK) && (parama.continueFlag != 0);
  }
  
  private void bCv()
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
        if (i < this.mTI.size())
        {
          locala = (a)this.mTI.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.dcn), locala);
          }
        }
        else
        {
          this.mTI.clear();
          this.fwK = 0;
          i = 0;
          int j;
          if (i < this.mTN.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.mTN[i]));
            if (locala == null) {
              break label281;
            }
            this.mTI.add(locala);
            j = this.fwK;
            this.fwK = (a(locala) + j);
            break label281;
          }
          if (this.mTI.size() > 0)
          {
            locala = (a)this.mTI.get(this.mTI.size() - 1);
            if (locala.mTR == this.mTJ)
            {
              j = this.fwK;
              if (!locala.mTR) {
                continue;
              }
              i = -1;
              this.fwK = (i + j);
              if (this.mTJ) {
                continue;
              }
              locala.mTR = bool;
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
  
  private int nB(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.mTI.size())
    {
      if (((a)this.mTI.get(i)).dcn == paramLong)
      {
        AppMethodBeat.o(5629);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(5629);
    return -1;
  }
  
  public final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mTL = paramBoolean1;
    this.mTK = paramBoolean2;
  }
  
  public void a(pf parampf, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.mTJ) && (parampf == null)) || (parampf.saZ == null))
    {
      ad.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.mTM = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = nA(parampf.CNp);
    if (locala == null) {
      if (paramBoolean)
      {
        parampf = a(parampf);
        this.mTI.add(parampf);
        bCv();
      }
    }
    for (;;)
    {
      aq.f(this.Ggn);
      AppMethodBeat.o(5627);
      return;
      ad.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(parampf.CNp) });
      AppMethodBeat.o(5627);
      return;
      if (locala.fvw == null) {
        locala.fvw = new LinkedList();
      }
      locala.fvw.addAll(parampf.saZ);
      if (locala.mTS == null) {
        locala.mTS = new LinkedList();
      }
      locala.mTS.add(parampf);
      locala.count += parampf.saZ.size();
      this.fwK += parampf.saZ.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.mTN = paramVarArgs;
    }
  }
  
  public void bCw()
  {
    AppMethodBeat.i(5633);
    m(null, null);
    this.mTM = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.fwK;
  }
  
  public void m(String paramString, List<pf> paramList)
  {
    AppMethodBeat.i(5625);
    this.mTI.clear();
    this.Ggm.clear();
    aq.f(this.Ggn);
    this.fwK = 0;
    this.mTE = paramString;
    if (paramList != null)
    {
      this.mTM = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (pf)paramList.get(i);
        if ((paramString != null) && (paramString.saZ != null) && (paramString.saZ.size() > 0))
        {
          paramString = a(paramString);
          this.fwK += a(paramString);
          this.mTI.add(paramString);
          ad.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.dcn), Integer.valueOf(paramString.count), Integer.valueOf(this.fwK) });
        }
        i += 1;
      }
      bCv();
    }
    aq.f(this.Ggn);
    AppMethodBeat.o(5625);
  }
  
  final a nA(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = nB(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.mTI.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public final void setAddContactScene(int paramInt)
  {
    this.mTF = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.mTO = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  protected final a xG(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.mTI.size())
      {
        a locala = (a)this.mTI.get(i);
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
  
  protected final pf xH(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.mTI.size())
      {
        a locala = (a)this.mTI.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.mTQ)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.mTS.size()) {
              break label156;
            }
            pf localpf = (pf)locala.mTS.get(i);
            j += localpf.saZ.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localpf;
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
  
  public final com.tencent.mm.ui.base.sortview.a xI(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.mTI.size())
    {
      Object localObject2 = (a)this.mTI.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).mTQ) && (paramInt == j - m)) {
        if (((a)localObject2).mTS.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((pf)localObject1).Title);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (pf)((a)localObject2).mTS.get(0);
        continue;
        if ((((a)localObject2).mTR) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).dcn, ((a)localObject2).count, this.mTE);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).mTR) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (pm)((a)localObject2).fvw.get(i);
          long l = ((a)localObject2).dcn;
          localObject2 = this.mTO;
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
              locala.xO(i);
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
  
  public Object[] xJ(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = xG(paramInt);
    Object localObject1 = xH(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((pf)localObject1).CNs; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).mTP;
      paramInt = this.mTF;
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
    public long dcn;
    public List<pm> fvw;
    public List<String> mTP;
    public boolean mTQ;
    public boolean mTR;
    public List<pf> mTS;
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