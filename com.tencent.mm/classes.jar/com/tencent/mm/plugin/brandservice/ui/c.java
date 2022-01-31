package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int ejZ;
  protected String jTm;
  protected int jTn;
  private List<c.a> jTq;
  private boolean jTr;
  protected boolean jTs;
  protected boolean jTt;
  int jTu;
  protected long[] jTv;
  protected c.b jTw;
  protected int mScene;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(13886);
    this.jTq = new ArrayList();
    v(true, true);
    this.jTr = true;
    c(new long[] { 1L });
    AppMethodBeat.o(13886);
  }
  
  private static int a(c.a parama)
  {
    int j = 1;
    if (parama == null) {
      return 0;
    }
    int k = parama.count;
    int i;
    if (parama.jTz)
    {
      i = 1;
      if (!parama.jTA) {
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
  
  private c.a a(nc paramnc)
  {
    AppMethodBeat.i(13888);
    c.a locala = new c.a();
    locala.jTB = new LinkedList();
    locala.jTB.add(paramnc);
    locala.cnw = paramnc.wBW;
    locala.count = paramnc.nrw.size();
    locala.jTx = paramnc.wBX;
    locala.eiJ = new LinkedList();
    locala.eiJ.addAll(paramnc.nrw);
    locala.jTy = paramnc.wBY;
    locala.jTz = this.jTt;
    locala.jTA = b(locala);
    AppMethodBeat.o(13888);
    return locala;
  }
  
  private void aWw()
  {
    boolean bool = true;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(13894);
        HashMap localHashMap = new HashMap();
        i = 0;
        c.a locala;
        if (i < this.jTq.size())
        {
          locala = (c.a)this.jTq.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.cnw), locala);
          }
        }
        else
        {
          this.jTq.clear();
          this.ejZ = 0;
          i = 0;
          int j;
          if (i < this.jTv.length)
          {
            locala = (c.a)localHashMap.get(Long.valueOf(this.jTv[i]));
            if (locala == null) {
              break label281;
            }
            this.jTq.add(locala);
            j = this.ejZ;
            this.ejZ = (a(locala) + j);
            break label281;
          }
          if (this.jTq.size() > 0)
          {
            locala = (c.a)this.jTq.get(this.jTq.size() - 1);
            if (locala.jTA == this.jTr)
            {
              j = this.ejZ;
              if (!locala.jTA) {
                continue;
              }
              i = -1;
              this.ejZ = (i + j);
              if (this.jTr) {
                continue;
              }
              locala.jTA = bool;
            }
          }
          localHashMap.clear();
          AppMethodBeat.o(13894);
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
  
  private boolean b(c.a parama)
  {
    return (this.jTs) && (parama.jTx != 0);
  }
  
  private int hQ(long paramLong)
  {
    AppMethodBeat.i(13891);
    int i = 0;
    while (i < this.jTq.size())
    {
      if (((c.a)this.jTq.get(i)).cnw == paramLong)
      {
        AppMethodBeat.o(13891);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(13891);
    return -1;
  }
  
  public void a(nc paramnc, boolean paramBoolean)
  {
    AppMethodBeat.i(13889);
    if (((this.jTr) && (paramnc == null)) || (paramnc.nrw == null))
    {
      ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(13889);
      return;
    }
    if (isEmpty()) {
      this.jTu = ((int)(System.currentTimeMillis() / 1000L));
    }
    c.a locala = hP(paramnc.wBW);
    if (locala == null) {
      if (paramBoolean)
      {
        paramnc = a(paramnc);
        this.jTq.add(paramnc);
        aWw();
      }
    }
    for (;;)
    {
      al.d(this.zsx);
      AppMethodBeat.o(13889);
      return;
      ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramnc.wBW) });
      AppMethodBeat.o(13889);
      return;
      if (locala.eiJ == null) {
        locala.eiJ = new LinkedList();
      }
      locala.eiJ.addAll(paramnc.nrw);
      if (locala.jTB == null) {
        locala.jTB = new LinkedList();
      }
      locala.jTB.add(paramnc);
      locala.count += paramnc.nrw.size();
      this.ejZ += paramnc.nrw.size();
    }
  }
  
  public void aWx()
  {
    AppMethodBeat.i(13895);
    i(null, null);
    this.jTu = 0;
    AppMethodBeat.o(13895);
  }
  
  public final void c(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.jTv = paramVarArgs;
    }
  }
  
  public int getCount()
  {
    return this.ejZ;
  }
  
  final c.a hP(long paramLong)
  {
    AppMethodBeat.i(13890);
    int i = hQ(paramLong);
    if (i >= 0)
    {
      c.a locala = (c.a)this.jTq.get(i);
      AppMethodBeat.o(13890);
      return locala;
    }
    AppMethodBeat.o(13890);
    return null;
  }
  
  public void i(String paramString, List<nc> paramList)
  {
    AppMethodBeat.i(13887);
    this.jTq.clear();
    this.zsw.clear();
    al.d(this.zsx);
    this.ejZ = 0;
    this.jTm = paramString;
    if (paramList != null)
    {
      this.jTu = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (nc)paramList.get(i);
        if ((paramString != null) && (paramString.nrw != null) && (paramString.nrw.size() > 0))
        {
          paramString = a(paramString);
          this.ejZ += a(paramString);
          this.jTq.add(paramString);
          ab.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.cnw), Integer.valueOf(paramString.count), Integer.valueOf(this.ejZ) });
        }
        i += 1;
      }
      aWw();
    }
    al.d(this.zsx);
    AppMethodBeat.o(13887);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  protected final c.a rX(int paramInt)
  {
    AppMethodBeat.i(13892);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.jTq.size())
      {
        c.a locala = (c.a)this.jTq.get(i);
        j += a(locala);
        if (paramInt < j)
        {
          AppMethodBeat.o(13892);
          return locala;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(13892);
    return null;
  }
  
  protected final nc rY(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(13893);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.jTq.size())
      {
        c.a locala = (c.a)this.jTq.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.jTz)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.jTB.size()) {
              break label156;
            }
            nc localnc = (nc)locala.jTB.get(i);
            j += localnc.nrw.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(13893);
              return localnc;
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
    AppMethodBeat.o(13893);
    return null;
  }
  
  public final com.tencent.mm.ui.base.sortview.a rZ(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(13896);
    int i = 0;
    int j = 0;
    while (i < this.jTq.size())
    {
      Object localObject2 = (c.a)this.jTq.get(i);
      int m = a((c.a)localObject2);
      j += m;
      if ((((c.a)localObject2).jTz) && (paramInt == j - m)) {
        if (((c.a)localObject2).jTB.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((nc)localObject1).Title);
        AppMethodBeat.o(13896);
        return localObject1;
        localObject1 = (nc)((c.a)localObject2).jTB.get(0);
        continue;
        if ((((c.a)localObject2).jTA) && (paramInt == j - 1))
        {
          localObject1 = new e(((c.a)localObject2).cnw, ((c.a)localObject2).count, this.jTm);
          AppMethodBeat.o(13896);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((c.a)localObject2).count;
          i = k;
          if (((c.a)localObject2).jTA) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (ni)((c.a)localObject2).eiJ.get(i);
          long l = ((c.a)localObject2).cnw;
          localObject2 = this.jTw;
          if (localObject1 == null)
          {
            ab.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            AppMethodBeat.o(13896);
            return null;
          }
          if (l == 1L)
          {
            ab.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            if ((localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a))
            {
              com.tencent.mm.plugin.brandservice.ui.base.a locala = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
              locala.sd(i);
              locala.setPosition(paramInt);
              locala.setReporter((c.b)localObject2);
            }
            AppMethodBeat.o(13896);
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
    Object localObject1 = new g(null);
    AppMethodBeat.o(13896);
    return localObject1;
  }
  
  public Object[] sa(int paramInt)
  {
    AppMethodBeat.i(13897);
    Object localObject2 = rX(paramInt);
    Object localObject1 = rY(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((nc)localObject1).wBZ; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((c.a)localObject2).jTy;
      paramInt = this.jTn;
      AppMethodBeat.o(13897);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(13897);
    return null;
  }
  
  public final void setAddContactScene(int paramInt)
  {
    this.jTn = paramInt;
  }
  
  public final void setReporter(c.b paramb)
  {
    this.jTw = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jTt = paramBoolean1;
    this.jTs = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */