package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.nc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends c
{
  List<bsm> jUM;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> jUN;
  private int jUO;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(14032);
    this.jUM = null;
    this.jUN = new SparseArray();
    setReporter(new f.1(this));
    AppMethodBeat.o(14032);
  }
  
  public final void a(nc paramnc, boolean paramBoolean)
  {
    AppMethodBeat.i(14034);
    super.a(paramnc, paramBoolean);
    if (this.jUO == 0) {
      this.jUO = super.getCount();
    }
    AppMethodBeat.o(14034);
  }
  
  public final void aWx()
  {
    AppMethodBeat.i(14036);
    super.aWx();
    AppMethodBeat.o(14036);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(14035);
    int i = super.getCount();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (this.jUM != null)
      {
        Iterator localIterator = this.jUM.iterator();
        if (localIterator.hasNext())
        {
          bsm localbsm = (bsm)localIterator.next();
          if ((localbsm == null) || (localbsm.xFX == null)) {
            break label93;
          }
          i += localbsm.xFX.size();
        }
      }
    }
    label93:
    for (;;)
    {
      break;
      j = i;
      AppMethodBeat.o(14035);
      return j;
    }
  }
  
  public final void i(String paramString, List<nc> paramList)
  {
    AppMethodBeat.i(14033);
    super.i(paramString, paramList);
    this.jUO = super.getCount();
    AppMethodBeat.o(14033);
  }
  
  public final Object[] sa(int paramInt)
  {
    AppMethodBeat.i(14038);
    Object localObject2 = rX(paramInt);
    Object localObject1 = rY(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).jTy;
      if (paramInt < this.jUO)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((nc)localObject1).wBZ;; localObject1 = "")
      {
        AppMethodBeat.o(14038);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.sa(paramInt);
    AppMethodBeat.o(14038);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a sc(int paramInt)
  {
    AppMethodBeat.i(14037);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.sc(paramInt);
      AppMethodBeat.o(14037);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.jUN.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.jUM.size() > 0)
      {
        localObject1 = this.jUM.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (bsm)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((bsm)localObject2).xFV != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        bxz localbxz = (bxz)((bsm)localObject2).xFX.get(0);
        localObject2 = localObject1;
        localObject1 = localbxz;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).sd(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.jUN.put(paramInt, localObject1);
      AppMethodBeat.o(14037);
      return localObject1;
      label168:
      localObject1 = ((bsm)localObject2).xFV.toString();
      break label110;
      label180:
      if (paramInt < ((bsm)localObject2).xFX.size() + i)
      {
        localObject1 = (bxz)((bsm)localObject2).xFX.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((bsm)localObject2).xFX.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f
 * JD-Core Version:    0.7.0.1
 */