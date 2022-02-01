package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.tf;
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
  private int eQx;
  protected int mScene;
  protected String vCH;
  protected int vCI;
  private List<a> vCL;
  private boolean vCM;
  protected boolean vCN;
  protected boolean vCO;
  int vCP;
  protected long[] vCQ;
  protected b vCR;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.vCL = new ArrayList();
    N(true, true);
    this.vCM = true;
    d(new long[] { 1L });
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
    if (parama.vCT)
    {
      i = 1;
      if (!parama.vCU) {
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
  
  private a a(sy paramsy)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.vCV = new LinkedList();
    locala.vCV.add(paramsy);
    locala.beV = paramsy.YYo;
    locala.count = paramsy.IIU.size();
    locala.continueFlag = paramsy.YYp;
    locala.lMl = new LinkedList();
    locala.lMl.addAll(paramsy.IIU);
    locala.vCS = paramsy.YYq;
    locala.vCT = this.vCO;
    locala.vCU = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.vCN) && (parama.continueFlag != 0);
  }
  
  private void dcq()
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
        if (i < this.vCL.size())
        {
          locala = (a)this.vCL.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.beV), locala);
          }
        }
        else
        {
          this.vCL.clear();
          this.eQx = 0;
          i = 0;
          int j;
          if (i < this.vCQ.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.vCQ[i]));
            if (locala == null) {
              break label281;
            }
            this.vCL.add(locala);
            j = this.eQx;
            this.eQx = (a(locala) + j);
            break label281;
          }
          if (this.vCL.size() > 0)
          {
            locala = (a)this.vCL.get(this.vCL.size() - 1);
            if (locala.vCU == this.vCM)
            {
              j = this.eQx;
              if (!locala.vCU) {
                continue;
              }
              i = -1;
              this.eQx = (i + j);
              if (this.vCM) {
                continue;
              }
              locala.vCU = bool;
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
  
  private int kj(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.vCL.size())
    {
      if (((a)this.vCL.get(i)).beV == paramLong)
      {
        AppMethodBeat.o(5629);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(5629);
    return -1;
  }
  
  protected final a Hb(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.vCL.size())
      {
        a locala = (a)this.vCL.get(i);
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
  
  protected final sy Hc(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.vCL.size())
      {
        a locala = (a)this.vCL.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.vCT)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.vCV.size()) {
              break label156;
            }
            sy localsy = (sy)locala.vCV.get(i);
            j += localsy.IIU.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localsy;
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
  
  public final com.tencent.mm.ui.base.sortview.a Hd(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.vCL.size())
    {
      Object localObject2 = (a)this.vCL.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).vCT) && (paramInt == j - m)) {
        if (((a)localObject2).vCV.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new e(((sy)localObject1).hAP);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (sy)((a)localObject2).vCV.get(0);
        continue;
        if ((((a)localObject2).vCU) && (paramInt == j - 1))
        {
          localObject1 = new g(((a)localObject2).beV, ((a)localObject2).count, this.vCH);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).vCU) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (tf)((a)localObject2).lMl.get(i);
          long l = ((a)localObject2).beV;
          localObject2 = this.vCR;
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
              locala.Hi(i);
              locala.setPosition(paramInt);
              locala.setReporter((b)localObject2);
            }
            AppMethodBeat.o(5634);
            return localObject1;
            if (l == 4L) {
              localObject1 = new i(localObject1);
            } else if (l == 1073741824L) {
              localObject1 = new i(localObject1);
            } else {
              localObject1 = new i(localObject1);
            }
          }
        }
      }
      i += 1;
    }
    Object localObject1 = new i(null);
    AppMethodBeat.o(5634);
    return localObject1;
  }
  
  public Object[] He(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = Hb(paramInt);
    Object localObject1 = Hc(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((sy)localObject1).YYr; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).vCS;
      paramInt = this.vCI;
      AppMethodBeat.o(5635);
      return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
    }
    AppMethodBeat.o(5635);
    return null;
  }
  
  public final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.vCO = paramBoolean1;
    this.vCN = paramBoolean2;
  }
  
  public void a(sy paramsy, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.vCM) && (paramsy == null)) || (paramsy.IIU == null))
    {
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.vCP = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = ki(paramsy.YYo);
    if (locala == null) {
      if (paramBoolean)
      {
        paramsy = a(paramsy);
        this.vCL.add(paramsy);
        dcq();
      }
    }
    for (;;)
    {
      bDL();
      AppMethodBeat.o(5627);
      return;
      Log.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramsy.YYo) });
      AppMethodBeat.o(5627);
      return;
      if (locala.lMl == null) {
        locala.lMl = new LinkedList();
      }
      locala.lMl.addAll(paramsy.IIU);
      if (locala.vCV == null) {
        locala.vCV = new LinkedList();
      }
      locala.vCV.add(paramsy);
      locala.count += paramsy.IIU.size();
      this.eQx += paramsy.IIU.size();
    }
  }
  
  public final void d(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.vCQ = paramVarArgs;
    }
  }
  
  public void dcr()
  {
    AppMethodBeat.i(5633);
    r(null, null);
    this.vCP = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.eQx;
  }
  
  final a ki(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = kj(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.vCL.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void r(String paramString, List<sy> paramList)
  {
    AppMethodBeat.i(5625);
    this.vCL.clear();
    super.clearData();
    this.eQx = 0;
    this.vCH = paramString;
    if (paramList != null)
    {
      this.vCP = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (sy)paramList.get(i);
        if ((paramString != null) && (paramString.IIU != null) && (paramString.IIU.size() > 0))
        {
          paramString = a(paramString);
          this.eQx += a(paramString);
          this.vCL.add(paramString);
          Log.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.beV), Integer.valueOf(paramString.count), Integer.valueOf(this.eQx) });
        }
        i += 1;
      }
      dcq();
    }
    bDL();
    AppMethodBeat.o(5625);
  }
  
  public final void setAddContactScene(int paramInt)
  {
    this.vCI = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.vCR = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  protected static final class a
  {
    public long beV;
    public int continueFlag;
    public int count;
    public List<tf> lMl;
    public List<String> vCS;
    public boolean vCT;
    public boolean vCU;
    public List<sy> vCV;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */