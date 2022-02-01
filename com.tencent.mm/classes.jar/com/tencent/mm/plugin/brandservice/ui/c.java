package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int cSs;
  protected int mScene;
  protected String poa;
  protected int pob;
  private List<a> poe;
  private boolean pof;
  protected boolean pog;
  protected boolean poh;
  int poi;
  protected long[] poj;
  protected b pok;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.poe = new ArrayList();
    F(true, true);
    this.pof = true;
    b(new long[] { 1L });
    AppMethodBeat.o(5624);
  }
  
  private int BF(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.poe.size())
    {
      if (((a)this.poe.get(i)).dDw == paramLong)
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
    if (parama.pom)
    {
      i = 1;
      if (!parama.pon) {
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
  
  private a a(ru paramru)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.poo = new LinkedList();
    locala.poo.add(paramru);
    locala.dDw = paramru.KZg;
    locala.count = paramru.xKD.size();
    locala.continueFlag = paramru.KZh;
    locala.gzD = new LinkedList();
    locala.gzD.addAll(paramru.xKD);
    locala.pol = paramru.KZi;
    locala.pom = this.poh;
    locala.pon = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.pog) && (parama.continueFlag != 0);
  }
  
  private void clU()
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
        if (i < this.poe.size())
        {
          locala = (a)this.poe.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.dDw), locala);
          }
        }
        else
        {
          this.poe.clear();
          this.cSs = 0;
          i = 0;
          int j;
          if (i < this.poj.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.poj[i]));
            if (locala == null) {
              break label281;
            }
            this.poe.add(locala);
            j = this.cSs;
            this.cSs = (a(locala) + j);
            break label281;
          }
          if (this.poe.size() > 0)
          {
            locala = (a)this.poe.get(this.poe.size() - 1);
            if (locala.pon == this.pof)
            {
              j = this.cSs;
              if (!locala.pon) {
                continue;
              }
              i = -1;
              this.cSs = (i + j);
              if (this.pof) {
                continue;
              }
              locala.pon = bool;
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
  
  final a BE(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = BF(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.poe.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  protected final a CW(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.poe.size())
      {
        a locala = (a)this.poe.get(i);
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
  
  protected final ru CX(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.poe.size())
      {
        a locala = (a)this.poe.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.pom)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.poo.size()) {
              break label156;
            }
            ru localru = (ru)locala.poo.get(i);
            j += localru.xKD.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localru;
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
  
  public final com.tencent.mm.ui.base.sortview.a CY(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.poe.size())
    {
      Object localObject2 = (a)this.poe.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).pom) && (paramInt == j - m)) {
        if (((a)localObject2).poo.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((ru)localObject1).Title);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (ru)((a)localObject2).poo.get(0);
        continue;
        if ((((a)localObject2).pon) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).dDw, ((a)localObject2).count, this.poa);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).pon) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (sb)((a)localObject2).gzD.get(i);
          long l = ((a)localObject2).dDw;
          localObject2 = this.pok;
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
              locala.Dd(i);
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
  
  public Object[] CZ(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = CW(paramInt);
    Object localObject1 = CX(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((ru)localObject1).KZj; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).pol;
      paramInt = this.pob;
      AppMethodBeat.o(5635);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(5635);
    return null;
  }
  
  public final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.poh = paramBoolean1;
    this.pog = paramBoolean2;
  }
  
  public void a(ru paramru, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.pof) && (paramru == null)) || (paramru.xKD == null))
    {
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.poi = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = BE(paramru.KZg);
    if (locala == null) {
      if (paramBoolean)
      {
        paramru = a(paramru);
        this.poe.add(paramru);
        clU();
      }
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(this.OZP);
      AppMethodBeat.o(5627);
      return;
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramru.KZg) });
      AppMethodBeat.o(5627);
      return;
      if (locala.gzD == null) {
        locala.gzD = new LinkedList();
      }
      locala.gzD.addAll(paramru.xKD);
      if (locala.poo == null) {
        locala.poo = new LinkedList();
      }
      locala.poo.add(paramru);
      locala.count += paramru.xKD.size();
      this.cSs += paramru.xKD.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.poj = paramVarArgs;
    }
  }
  
  public void clV()
  {
    AppMethodBeat.i(5633);
    m(null, null);
    this.poi = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.cSs;
  }
  
  public void m(String paramString, List<ru> paramList)
  {
    AppMethodBeat.i(5625);
    this.poe.clear();
    this.OZO.clear();
    MMHandlerThread.postToMainThread(this.OZP);
    this.cSs = 0;
    this.poa = paramString;
    if (paramList != null)
    {
      this.poi = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (ru)paramList.get(i);
        if ((paramString != null) && (paramString.xKD != null) && (paramString.xKD.size() > 0))
        {
          paramString = a(paramString);
          this.cSs += a(paramString);
          this.poe.add(paramString);
          Log.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.dDw), Integer.valueOf(paramString.count), Integer.valueOf(this.cSs) });
        }
        i += 1;
      }
      clU();
    }
    MMHandlerThread.postToMainThread(this.OZP);
    AppMethodBeat.o(5625);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public final void setAddContactScene(int paramInt)
  {
    this.pob = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.pok = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  protected static final class a
  {
    public int continueFlag;
    public int count;
    public long dDw;
    public List<sb> gzD;
    public List<String> pol;
    public boolean pom;
    public boolean pon;
    public List<ru> poo;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */