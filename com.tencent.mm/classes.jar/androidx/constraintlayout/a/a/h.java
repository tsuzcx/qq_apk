package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h
{
  public boolean bjS;
  public List<f> bjW;
  int bjX;
  int bjY;
  public final int[] bjZ;
  List<f> bka;
  List<f> bkb;
  HashSet<f> bkc;
  HashSet<f> bkd;
  List<f> bke;
  List<f> bkf;
  
  h(List<f> paramList)
  {
    AppMethodBeat.i(193995);
    this.bjX = -1;
    this.bjY = -1;
    this.bjS = false;
    this.bjZ = new int[] { this.bjX, this.bjY };
    this.bka = new ArrayList();
    this.bkb = new ArrayList();
    this.bkc = new HashSet();
    this.bkd = new HashSet();
    this.bke = new ArrayList();
    this.bkf = new ArrayList();
    this.bjW = paramList;
    AppMethodBeat.o(193995);
  }
  
  h(List<f> paramList, byte paramByte)
  {
    AppMethodBeat.i(194012);
    this.bjX = -1;
    this.bjY = -1;
    this.bjS = false;
    this.bjZ = new int[] { this.bjX, this.bjY };
    this.bka = new ArrayList();
    this.bkb = new ArrayList();
    this.bkc = new HashSet();
    this.bkd = new HashSet();
    this.bke = new ArrayList();
    this.bkf = new ArrayList();
    this.bjW = paramList;
    this.bjS = true;
    AppMethodBeat.o(194012);
  }
  
  final void a(ArrayList<f> paramArrayList, f paramf)
  {
    AppMethodBeat.i(194038);
    if (paramf.bjl)
    {
      AppMethodBeat.o(194038);
      return;
    }
    paramArrayList.add(paramf);
    paramf.bjl = true;
    if (paramf.CI())
    {
      AppMethodBeat.o(194038);
      return;
    }
    Object localObject;
    if ((paramf instanceof j))
    {
      localObject = (j)paramf;
      j = ((j)localObject).bht;
      i = 0;
      while (i < j)
      {
        a(paramArrayList, localObject.bko[i]);
        i += 1;
      }
    }
    int j = paramf.biF.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramf.biF[i].bhD;
      if (localObject != null)
      {
        f localf = ((e)localObject).bhB;
        if ((localObject != null) && (localf != paramf.biI)) {
          a(paramArrayList, localf);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(194038);
  }
  
  final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(194023);
    if (paramInt == 0)
    {
      this.bkc.add(paramf);
      AppMethodBeat.o(194023);
      return;
    }
    if (paramInt == 1) {
      this.bkd.add(paramf);
    }
    AppMethodBeat.o(194023);
  }
  
  void d(f paramf)
  {
    AppMethodBeat.i(194062);
    int j;
    e locale;
    label50:
    int i;
    if (paramf.bjj)
    {
      if (paramf.CI())
      {
        AppMethodBeat.o(194062);
        return;
      }
      if (paramf.biy.bhD != null)
      {
        j = 1;
        if (j == 0) {
          break label222;
        }
        locale = paramf.biy.bhD;
        if (locale == null) {
          break label456;
        }
        if (!locale.bhB.bjk) {
          d(locale.bhB);
        }
        if (locale.bhC != e.c.bhV) {
          break label234;
        }
        i = locale.bhB.biL;
        i = locale.bhB.getWidth() + i;
      }
    }
    for (;;)
    {
      label106:
      if (j != 0) {
        i -= paramf.biy.CE();
      }
      for (;;)
      {
        paramf.aq(i - paramf.getWidth(), i);
        if (paramf.biB.bhD == null) {
          break label275;
        }
        locale = paramf.biB.bhD;
        if (!locale.bhB.bjk) {
          d(locale.bhB);
        }
        i = locale.bhB.biM;
        i = locale.bhB.biV + i - paramf.biV;
        paramf.ar(i, paramf.mHeight + i);
        paramf.bjk = true;
        AppMethodBeat.o(194062);
        return;
        j = 0;
        break;
        label222:
        locale = paramf.biw.bhD;
        break label50;
        label234:
        if (locale.bhC != e.c.bhT) {
          break label456;
        }
        i = locale.bhB.biL;
        break label106;
        i += paramf.biw.CE() + paramf.getWidth();
      }
      label275:
      int k;
      if (paramf.biA.bhD != null)
      {
        k = 1;
        if (k == 0) {
          break label401;
        }
        locale = paramf.biA.bhD;
        label302:
        j = i;
        if (locale != null)
        {
          if (!locale.bhB.bjk) {
            d(locale.bhB);
          }
          if (locale.bhC != e.c.bhW) {
            break label413;
          }
          j = locale.bhB.biM + locale.bhB.getHeight();
        }
        label358:
        if (k == 0) {
          break label438;
        }
      }
      label401:
      label413:
      label438:
      for (i = j - paramf.biA.CE();; i = j + (paramf.bix.CE() + paramf.getHeight()))
      {
        paramf.ar(i - paramf.getHeight(), i);
        paramf.bjk = true;
        AppMethodBeat.o(194062);
        return;
        k = 0;
        break;
        locale = paramf.bix.bhD;
        break label302;
        j = i;
        if (locale.bhC != e.c.bhU) {
          break label358;
        }
        j = locale.bhB.biM;
        break label358;
      }
      label456:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.h
 * JD-Core Version:    0.7.0.1
 */