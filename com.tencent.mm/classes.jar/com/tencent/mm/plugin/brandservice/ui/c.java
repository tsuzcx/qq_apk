package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.base.sortview.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  extends b
{
  private int fVN;
  protected int mScene;
  protected String odd;
  protected int ode;
  private List<a> odh;
  private boolean odi;
  protected boolean odj;
  protected boolean odk;
  int odl;
  protected long[] odm;
  protected b odn;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5624);
    this.odh = new ArrayList();
    G(true, true);
    this.odi = true;
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
    if (parama.odp)
    {
      i = 1;
      if (!parama.odq) {
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
  
  private a a(qt paramqt)
  {
    AppMethodBeat.i(5626);
    a locala = new a();
    locala.odr = new LinkedList();
    locala.odr.add(paramqt);
    locala.dmg = paramqt.GeP;
    locala.count = paramqt.usl.size();
    locala.continueFlag = paramqt.GeQ;
    locala.fUw = new LinkedList();
    locala.fUw.addAll(paramqt.usl);
    locala.odo = paramqt.GeR;
    locala.odp = this.odk;
    locala.odq = b(locala);
    AppMethodBeat.o(5626);
    return locala;
  }
  
  private boolean b(a parama)
  {
    return (this.odj) && (parama.continueFlag != 0);
  }
  
  private void bOO()
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
        if (i < this.odh.size())
        {
          locala = (a)this.odh.get(i);
          if (locala != null) {
            localHashMap.put(Long.valueOf(locala.dmg), locala);
          }
        }
        else
        {
          this.odh.clear();
          this.fVN = 0;
          i = 0;
          int j;
          if (i < this.odm.length)
          {
            locala = (a)localHashMap.get(Long.valueOf(this.odm[i]));
            if (locala == null) {
              break label281;
            }
            this.odh.add(locala);
            j = this.fVN;
            this.fVN = (a(locala) + j);
            break label281;
          }
          if (this.odh.size() > 0)
          {
            locala = (a)this.odh.get(this.odh.size() - 1);
            if (locala.odq == this.odi)
            {
              j = this.fVN;
              if (!locala.odq) {
                continue;
              }
              i = -1;
              this.fVN = (i + j);
              if (this.odi) {
                continue;
              }
              locala.odq = bool;
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
  
  private int tz(long paramLong)
  {
    AppMethodBeat.i(5629);
    int i = 0;
    while (i < this.odh.size())
    {
      if (((a)this.odh.get(i)).dmg == paramLong)
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
    this.odk = paramBoolean1;
    this.odj = paramBoolean2;
  }
  
  public void a(qt paramqt, boolean paramBoolean)
  {
    AppMethodBeat.i(5627);
    if (((this.odi) && (paramqt == null)) || (paramqt.usl == null))
    {
      ae.e("MicroMsg.BrandService.BizSearchResultAdapter", "The content or content.ItemList is null or the mode do not support to append data.");
      AppMethodBeat.o(5627);
      return;
    }
    if (isEmpty()) {
      this.odl = ((int)(System.currentTimeMillis() / 1000L));
    }
    a locala = ty(paramqt.GeP);
    if (locala == null) {
      if (paramBoolean)
      {
        paramqt = a(paramqt);
        this.odh.add(paramqt);
        bOO();
      }
    }
    for (;;)
    {
      ar.f(this.JOJ);
      AppMethodBeat.o(5627);
      return;
      ae.e("MicroMsg.BrandService.BizSearchResultAdapter", "The type(%d) do not exist.", new Object[] { Long.valueOf(paramqt.GeP) });
      AppMethodBeat.o(5627);
      return;
      if (locala.fUw == null) {
        locala.fUw = new LinkedList();
      }
      locala.fUw.addAll(paramqt.usl);
      if (locala.odr == null) {
        locala.odr = new LinkedList();
      }
      locala.odr.add(paramqt);
      locala.count += paramqt.usl.size();
      this.fVN += paramqt.usl.size();
    }
  }
  
  public final void b(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      this.odm = paramVarArgs;
    }
  }
  
  public void bOP()
  {
    AppMethodBeat.i(5633);
    l(null, null);
    this.odl = 0;
    AppMethodBeat.o(5633);
  }
  
  public int getCount()
  {
    return this.fVN;
  }
  
  public void l(String paramString, List<qt> paramList)
  {
    AppMethodBeat.i(5625);
    this.odh.clear();
    this.JOI.clear();
    ar.f(this.JOJ);
    this.fVN = 0;
    this.odd = paramString;
    if (paramList != null)
    {
      this.odl = ((int)(System.currentTimeMillis() / 1000L));
      int i = 0;
      while (i < paramList.size())
      {
        paramString = (qt)paramList.get(i);
        if ((paramString != null) && (paramString.usl != null) && (paramString.usl.size() > 0))
        {
          paramString = a(paramString);
          this.fVN += a(paramString);
          this.odh.add(paramString);
          ae.i("MicroMsg.BrandService.BizSearchResultAdapter", "type(%d) , count(%d) , offset(%d)", new Object[] { Long.valueOf(paramString.dmg), Integer.valueOf(paramString.count), Integer.valueOf(this.fVN) });
        }
        i += 1;
      }
      bOO();
    }
    ar.f(this.JOJ);
    AppMethodBeat.o(5625);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public final void setAddContactScene(int paramInt)
  {
    this.ode = paramInt;
  }
  
  public final void setReporter(b paramb)
  {
    this.odn = paramb;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  final a ty(long paramLong)
  {
    AppMethodBeat.i(5628);
    int i = tz(paramLong);
    if (i >= 0)
    {
      a locala = (a)this.odh.get(i);
      AppMethodBeat.o(5628);
      return locala;
    }
    AppMethodBeat.o(5628);
    return null;
  }
  
  protected final a zr(int paramInt)
  {
    AppMethodBeat.i(5630);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.odh.size())
      {
        a locala = (a)this.odh.get(i);
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
  
  protected final qt zs(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5631);
    if (paramInt >= 0)
    {
      int i = 0;
      int j = 0;
      while (i < this.odh.size())
      {
        a locala = (a)this.odh.get(i);
        int m = a(locala);
        j += m;
        if (paramInt < j)
        {
          if (locala.odp)
          {
            i = 1;
            j = i + (j - m);
            i = k;
          }
          for (;;)
          {
            if (i >= locala.odr.size()) {
              break label156;
            }
            qt localqt = (qt)locala.odr.get(i);
            j += localqt.usl.size();
            if (paramInt < j)
            {
              AppMethodBeat.o(5631);
              return localqt;
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
  
  public final com.tencent.mm.ui.base.sortview.a zt(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(5634);
    int i = 0;
    int j = 0;
    while (i < this.odh.size())
    {
      Object localObject2 = (a)this.odh.get(i);
      int m = a((a)localObject2);
      j += m;
      if ((((a)localObject2).odp) && (paramInt == j - m)) {
        if (((a)localObject2).odr.size() == 0) {
          localObject1 = null;
        }
      }
      while (localObject1 != null)
      {
        localObject1 = new d(((qt)localObject1).Title);
        AppMethodBeat.o(5634);
        return localObject1;
        localObject1 = (qt)((a)localObject2).odr.get(0);
        continue;
        if ((((a)localObject2).odq) && (paramInt == j - 1))
        {
          localObject1 = new f(((a)localObject2).dmg, ((a)localObject2).count, this.odd);
          AppMethodBeat.o(5634);
          return localObject1;
        }
        if (paramInt < j)
        {
          m = ((a)localObject2).count;
          i = k;
          if (((a)localObject2).odq) {
            i = 1;
          }
          i += paramInt - j + m;
          localObject1 = (ra)((a)localObject2).fUw.get(i);
          long l = ((a)localObject2).dmg;
          localObject2 = this.odn;
          if (localObject1 == null)
          {
            ae.e("MicroMsg.BrandService.BizSearchResultAdapter", "data is null.");
            AppMethodBeat.o(5634);
            return null;
          }
          if (l == 1L)
          {
            ae.v("MicroMsg.BrandService.BizSearchResultAdapter", "Create a BizContactDataItem.");
            localObject1 = new a(localObject1);
          }
          for (;;)
          {
            if ((localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.base.a))
            {
              com.tencent.mm.plugin.brandservice.ui.base.a locala = (com.tencent.mm.plugin.brandservice.ui.base.a)localObject1;
              locala.zy(i);
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
  
  public Object[] zu(int paramInt)
  {
    AppMethodBeat.i(5635);
    Object localObject2 = zr(paramInt);
    Object localObject1 = zs(paramInt);
    if (localObject1 != null) {}
    for (localObject1 = ((qt)localObject1).GeS; localObject2 != null; localObject1 = "")
    {
      localObject2 = ((a)localObject2).odo;
      paramInt = this.ode;
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
    public long dmg;
    public List<ra> fUw;
    public List<String> odo;
    public boolean odp;
    public boolean odq;
    public List<qt> odr;
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc, com.tencent.mm.ui.base.sortview.a parama, int paramInt1, String paramString, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c
 * JD-Core Version:    0.7.0.1
 */