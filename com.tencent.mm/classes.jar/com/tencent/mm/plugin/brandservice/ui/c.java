package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int fAr;
  protected int mScene;
  protected String nvW;
  protected int nvX;
  private List<a> nwa;
  private boolean nwb;
  protected boolean nwc;
  protected boolean nwd;
  int nwe;
  protected long[] nwf;
  protected b nwg;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.nwa = new ArrayList();
    F(true, true);
    this.nwb = true;
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
    if (parama.nwi)
    {
      i = 1;
      if (!parama.nwj) {
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
  
  private a a(pm parampm)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.nwk = new LinkedList();
    locala.nwk.add(parampm);
    locala.cZM = parampm.EfR;
    locala.count = parampm.tiT.size();
    locala.continueFlag = parampm.EfS;
    locala.fzd = new LinkedList();
    locala.fzd.addAll(parampm.tiT);
    locala.nwh = parampm.EfT;
    locala.nwi = this.nwd;
    locala.nwj = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.nwc) && (parama.continueFlag != 0);
  }
  
  private void bJy()
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
        if (i < this.nwa.size())
        {
          locala = (a)this.nwa.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.cZM), locala);
          }
        }
        else
        {
          this.nwa.clear();
          this.fAr = 0;
          i = 0;
          int j;
          if (i < this.nwf.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.nwf[i]));
            if (locala == null) {
              break label281;
            }
            this.nwa.add(locala);
            j = this.fAr;
            this.fAr = (a(locala) + j);
            break label281;
          }
          if (this.nwa.size() > 0)
          {
            locala = (a)this.nwa.get(this.nwa.size() - 1);
            if (locala.nwj == this.nwb)
            {
              j = this.fAr;
              if (!locala.nwj) {
                continue;
              }
              i = -1;
              this.fAr = (i + j);
              if (this.nwb) {
                continue;
              }
              locala.nwj = bool;
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
  
  private int rn(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.nwa.size())
    {
      if (((a)this.nwa.get(i)).cZM == paramLong)
      {
        AppMethodBeat.o(5629);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(5629);
    return -1;
  }
  
  public final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nwd = paramBoolean1;
    this.nwc = paramBoolean2;
  }
  
  public void a(pm parampm, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.nwb) && (parampm == null)) || (parampm.tiT == null))
    {
      ac.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.nwe = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = rm(parampm.EfR);
    if (locala == null) {
      if (paramBoolean)
      {
        parampm = a(parampm);
        this.nwa.add(parampm);
        bJy();
      }
    }
    for (;;)
    {
      ap.f(this.HGd);
      AppMethodBeat.o(5627);
      return;
      ac.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(parampm.EfR) });
      AppMethodBeat.o(5627);
      return;
      if (locala.fzd == null) {
        locala.fzd = new LinkedList();
      }
      locala.fzd.addAll(parampm.tiT);
      if (locala.nwk == null) {
        locala.nwk = new LinkedList();
      }
      locala.nwk.add(parampm);
      locala.count += parampm.tiT.size();
      this.fAr += parampm.tiT.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.nwf = paramVarArgs;
    }
  }
  
  public void bJz()
  {
    AppMethodBeat.i(5633);
    k(null, null);
    this.nwe = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.fAr;
  }
  
  public void k(String paramString, List<pm> paramList)
  {
    AppMethodBeat.i(5625);
    this.nwa.clear();
    this.HGc.clear();
    ap.f(this.HGd);
    this.fAr = 0;
    this.nvW = paramString;
    if (paramList != null)
    {
      this.nwe = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (pm)paramList.get(i);
        if ((paramString != null) && (paramString.tiT != null) && (paramString.tiT.size() > 0))
        {
          paramString = a(paramString);
          this.fAr += a(paramString);
          this.nwa.add(paramString);
          ac.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.cZM), Integer.valueOf(paramString.count), Integer.valueOf(this.fAr) });
        }
        i += 1;
      }
      bJy();
    }
    ap.f(this.HGd);
    AppMethodBeat.o(5625);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  final a rm(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = rn(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.nwa.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  public final void setAddContactScene(int paramInt)
  {
    this.nvX = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.nwg = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  public final com.tencent.mm.ui.base.sortview.a yA(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.nwa.size())
    {
      Object localObject2 = (a)this.nwa.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).nwi) && (paramInt == j - m)) {
        if (((a)localObject2).nwk.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((pm)localObject1).Title);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (pm)((a)localObject2).nwk.get(0);
        continue;
        if ((((a)localObject2).nwj) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).cZM, ((a)localObject2).count, this.nvW);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).nwj) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (pt)((a)localObject2).fzd.get(i);
          long l = ((a)localObject2).cZM;
          localObject2 = this.nwg;
          if (localObject1 == null)
          {
            ac.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            AppMethodBeat.o(5634);
            return null;
          }
          if (l == 1L)
          {
            ac.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            if ((localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a))
            {
              com.tencent.mm.plugin.brandservice.ui.base.a locala = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
              locala.yF(i);
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
  
  public Object[] yB(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = yy(paramInt);
    Object localObject1 = yz(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((pm)localObject1).EfU; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).nwh;
      paramInt = this.nvX;
      AppMethodBeat.o(5635);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(5635);
    return null;
  }
  
  protected final a yy(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.nwa.size())
      {
        a locala = (a)this.nwa.get(i);
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
  
  protected final pm yz(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.nwa.size())
      {
        a locala = (a)this.nwa.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.nwi)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.nwk.size()) {
              break label156;
            }
            pm localpm = (pm)locala.nwk.get(i);
            j += localpm.tiT.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localpm;
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
  
  protected static final class a
  {
    public long cZM;
    public int continueFlag;
    public int count;
    public List<pt> fzd;
    public List<String> nwh;
    public boolean nwi;
    public boolean nwj;
    public List<pm> nwk;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */