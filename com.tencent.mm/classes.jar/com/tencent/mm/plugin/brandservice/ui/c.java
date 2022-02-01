package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int cUX;
  protected int mScene;
  protected String sxa;
  protected int sxb;
  private List<a> sxe;
  private boolean sxf;
  protected boolean sxg;
  protected boolean sxh;
  int sxi;
  protected long[] sxj;
  protected b sxk;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.sxe = new ArrayList();
    J(true, true);
    this.sxf = true;
    b(new long[] { 1L });
    AppMethodBeat.o(5624);
  }
  
  private int HS(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.sxe.size())
    {
      if (((a)this.sxe.get(i)).fwf == paramLong)
      {
        AppMethodBeat.o(5629);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(5629);
    return -1;
  }
  
  private static int a(a parama)
  {
    int j = 1;
    if (parama == null) {
      return 0;
    }
    int k = parama.count;
    int i;
    if (parama.sxm)
    {
      i = 1;
      if (!parama.sxn) {
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
  
  private a a(rn paramrn)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.sxo = new LinkedList();
    locala.sxo.add(paramrn);
    locala.fwf = paramrn.Sap;
    locala.count = paramrn.COK.size();
    locala.continueFlag = paramrn.Saq;
    locala.jjG = new LinkedList();
    locala.jjG.addAll(paramrn.COK);
    locala.sxl = paramrn.Sar;
    locala.sxm = this.sxh;
    locala.sxn = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.sxg) && (parama.continueFlag != 0);
  }
  
  private void czy()
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
        if (i < this.sxe.size())
        {
          locala = (a)this.sxe.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.fwf), locala);
          }
        }
        else
        {
          this.sxe.clear();
          this.cUX = 0;
          i = 0;
          int j;
          if (i < this.sxj.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.sxj[i]));
            if (locala == null) {
              break label281;
            }
            this.sxe.add(locala);
            j = this.cUX;
            this.cUX = (a(locala) + j);
            break label281;
          }
          if (this.sxe.size() > 0)
          {
            locala = (a)this.sxe.get(this.sxe.size() - 1);
            if (locala.sxn == this.sxf)
            {
              j = this.cUX;
              if (!locala.sxn) {
                continue;
              }
              i = -1;
              this.cUX = (i + j);
              if (this.sxf) {
                continue;
              }
              locala.sxn = bool;
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
  
  protected final a GC(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.sxe.size())
      {
        a locala = (a)this.sxe.get(i);
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
  
  protected final rn GD(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.sxe.size())
      {
        a locala = (a)this.sxe.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.sxm)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.sxo.size()) {
              break label156;
            }
            rn localrn = (rn)locala.sxo.get(i);
            j += localrn.COK.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localrn;
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
  
  public final com.tencent.mm.ui.base.sortview.a GE(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.sxe.size())
    {
      Object localObject2 = (a)this.sxe.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).sxm) && (paramInt == j - m)) {
        if (((a)localObject2).sxo.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((rn)localObject1).fwr);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (rn)((a)localObject2).sxo.get(0);
        continue;
        if ((((a)localObject2).sxn) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).fwf, ((a)localObject2).count, this.sxa);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).sxn) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (ru)((a)localObject2).jjG.get(i);
          long l = ((a)localObject2).fwf;
          localObject2 = this.sxk;
          if (localObject1 == null)
          {
            Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            AppMethodBeat.o(5634);
            return null;
          }
          if (l == 1L)
          {
            Log.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            if ((localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a))
            {
              com.tencent.mm.plugin.brandservice.ui.base.a locala = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
              locala.GJ(i);
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
  
  public Object[] GF(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = GC(paramInt);
    Object localObject1 = GD(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((rn)localObject1).Sas; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).sxl;
      paramInt = this.sxb;
      AppMethodBeat.o(5635);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(5635);
    return null;
  }
  
  final a HR(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = HS(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.sxe.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  public final void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.sxh = paramBoolean1;
    this.sxg = paramBoolean2;
  }
  
  public void a(rn paramrn, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.sxf) && (paramrn == null)) || (paramrn.COK == null))
    {
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.sxi = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = HR(paramrn.Sap);
    if (locala == null) {
      if (paramBoolean)
      {
        paramrn = a(paramrn);
        this.sxe.add(paramrn);
        czy();
      }
    }
    for (;;)
    {
      bfU();
      AppMethodBeat.o(5627);
      return;
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramrn.Sap) });
      AppMethodBeat.o(5627);
      return;
      if (locala.jjG == null) {
        locala.jjG = new LinkedList();
      }
      locala.jjG.addAll(paramrn.COK);
      if (locala.sxo == null) {
        locala.sxo = new LinkedList();
      }
      locala.sxo.add(paramrn);
      locala.count += paramrn.COK.size();
      this.cUX += paramrn.COK.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.sxj = paramVarArgs;
    }
  }
  
  public void czz()
  {
    AppMethodBeat.i(5633);
    m(null, null);
    this.sxi = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.cUX;
  }
  
  public void m(String paramString, List<rn> paramList)
  {
    AppMethodBeat.i(5625);
    this.sxe.clear();
    super.clearData();
    this.cUX = 0;
    this.sxa = paramString;
    if (paramList != null)
    {
      this.sxi = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (rn)paramList.get(i);
        if ((paramString != null) && (paramString.COK != null) && (paramString.COK.size() > 0))
        {
          paramString = a(paramString);
          this.cUX += a(paramString);
          this.sxe.add(paramString);
          Log.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.fwf), Integer.valueOf(paramString.count), Integer.valueOf(this.cUX) });
        }
        i += 1;
      }
      czy();
    }
    bfU();
    AppMethodBeat.o(5625);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public final void setAddContactScene(int paramInt)
  {
    this.sxb = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.sxk = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  protected static final class a
  {
    public int continueFlag;
    public int count;
    public long fwf;
    public List<ru> jjG;
    public List<String> sxl;
    public boolean sxm;
    public boolean sxn;
    public List<rn> sxo;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */