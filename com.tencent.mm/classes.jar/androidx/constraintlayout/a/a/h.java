package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h
{
  public boolean DK;
  public List<f> DO;
  int DP;
  int DQ;
  public final int[] DR;
  List<f> DS;
  List<f> DT;
  HashSet<f> DU;
  HashSet<f> DV;
  List<f> DW;
  List<f> DX;
  
  h(List<f> paramList)
  {
    AppMethodBeat.i(229507);
    this.DP = -1;
    this.DQ = -1;
    this.DK = false;
    this.DR = new int[] { this.DP, this.DQ };
    this.DS = new ArrayList();
    this.DT = new ArrayList();
    this.DU = new HashSet();
    this.DV = new HashSet();
    this.DW = new ArrayList();
    this.DX = new ArrayList();
    this.DO = paramList;
    AppMethodBeat.o(229507);
  }
  
  h(List<f> paramList, byte paramByte)
  {
    AppMethodBeat.i(229509);
    this.DP = -1;
    this.DQ = -1;
    this.DK = false;
    this.DR = new int[] { this.DP, this.DQ };
    this.DS = new ArrayList();
    this.DT = new ArrayList();
    this.DU = new HashSet();
    this.DV = new HashSet();
    this.DW = new ArrayList();
    this.DX = new ArrayList();
    this.DO = paramList;
    this.DK = true;
    AppMethodBeat.o(229509);
  }
  
  final void a(ArrayList<f> paramArrayList, f paramf)
  {
    AppMethodBeat.i(229513);
    if (paramf.Dd)
    {
      AppMethodBeat.o(229513);
      return;
    }
    paramArrayList.add(paramf);
    paramf.Dd = true;
    if (paramf.fz())
    {
      AppMethodBeat.o(229513);
      return;
    }
    Object localObject;
    if ((paramf instanceof j))
    {
      localObject = (j)paramf;
      j = ((j)localObject).Bl;
      i = 0;
      while (i < j)
      {
        a(paramArrayList, localObject.Eg[i]);
        i += 1;
      }
    }
    int j = paramf.Cx.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramf.Cx[i].Bv;
      if (localObject != null)
      {
        f localf = ((e)localObject).Bt;
        if ((localObject != null) && (localf != paramf.CA)) {
          a(paramArrayList, localf);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(229513);
  }
  
  final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(229511);
    if (paramInt == 0)
    {
      this.DU.add(paramf);
      AppMethodBeat.o(229511);
      return;
    }
    if (paramInt == 1) {
      this.DV.add(paramf);
    }
    AppMethodBeat.o(229511);
  }
  
  void d(f paramf)
  {
    AppMethodBeat.i(229519);
    int j;
    e locale;
    label50:
    int i;
    if (paramf.Db)
    {
      if (paramf.fz())
      {
        AppMethodBeat.o(229519);
        return;
      }
      if (paramf.Cr.Bv != null)
      {
        j = 1;
        if (j == 0) {
          break label222;
        }
        locale = paramf.Cr.Bv;
        if (locale == null) {
          break label456;
        }
        if (!locale.Bt.Dc) {
          d(locale.Bt);
        }
        if (locale.Bu != e.c.BO) {
          break label234;
        }
        i = locale.Bt.CD;
        i = locale.Bt.getWidth() + i;
      }
    }
    for (;;)
    {
      label106:
      if (j != 0) {
        i -= paramf.Cr.fv();
      }
      for (;;)
      {
        paramf.w(i - paramf.getWidth(), i);
        if (paramf.Ct.Bv == null) {
          break label275;
        }
        locale = paramf.Ct.Bv;
        if (!locale.Bt.Dc) {
          d(locale.Bt);
        }
        i = locale.Bt.CE;
        i = locale.Bt.CN + i - paramf.CN;
        paramf.x(i, paramf.mHeight + i);
        paramf.Dc = true;
        AppMethodBeat.o(229519);
        return;
        j = 0;
        break;
        label222:
        locale = paramf.Cp.Bv;
        break label50;
        label234:
        if (locale.Bu != e.c.BM) {
          break label456;
        }
        i = locale.Bt.CD;
        break label106;
        i += paramf.Cp.fv() + paramf.getWidth();
      }
      label275:
      int k;
      if (paramf.Cs.Bv != null)
      {
        k = 1;
        if (k == 0) {
          break label401;
        }
        locale = paramf.Cs.Bv;
        label302:
        j = i;
        if (locale != null)
        {
          if (!locale.Bt.Dc) {
            d(locale.Bt);
          }
          if (locale.Bu != e.c.BP) {
            break label413;
          }
          j = locale.Bt.CE + locale.Bt.getHeight();
        }
        label358:
        if (k == 0) {
          break label438;
        }
      }
      label401:
      label413:
      label438:
      for (i = j - paramf.Cs.fv();; i = j + (paramf.Cq.fv() + paramf.getHeight()))
      {
        paramf.x(i - paramf.getHeight(), i);
        paramf.Dc = true;
        AppMethodBeat.o(229519);
        return;
        k = 0;
        break;
        locale = paramf.Cq.Bv;
        break label302;
        j = i;
        if (locale.Bu != e.c.BN) {
          break label358;
        }
        j = locale.Bt.CE;
        break label358;
      }
      label456:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.h
 * JD-Core Version:    0.7.0.1
 */