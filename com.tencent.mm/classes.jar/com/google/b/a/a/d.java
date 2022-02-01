package com.google.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  static final String[] ccl;
  static final int[][] ccm;
  private static final int[][] ccn;
  static final int[][] cco;
  final byte[] ccp;
  
  static
  {
    AppMethodBeat.i(12328);
    ccl = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
    ccm = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, { 327711, 656380, 656382, 656381, 0 } };
    Object localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 256 });
    ccn = (int[][])localObject;
    localObject[0][32] = 1;
    int i = 65;
    while (i <= 90)
    {
      ccn[0][i] = (i - 65 + 2);
      i += 1;
    }
    ccn[1][32] = 1;
    i = 97;
    while (i <= 122)
    {
      ccn[1][i] = (i - 97 + 2);
      i += 1;
    }
    ccn[2][32] = 1;
    i = 48;
    while (i <= 57)
    {
      ccn[2][i] = (i - 48 + 2);
      i += 1;
    }
    ccn[2][44] = 12;
    ccn[2][46] = 13;
    i = 0;
    while (i < 28)
    {
      ccn[3][new int[] { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 }[i]] = i;
      i += 1;
    }
    localObject = new int[31];
    Object tmp544_543 = localObject;
    tmp544_543[0] = 0;
    Object tmp548_544 = tmp544_543;
    tmp548_544[1] = 13;
    Object tmp553_548 = tmp548_544;
    tmp553_548[2] = 0;
    Object tmp557_553 = tmp553_548;
    tmp557_553[3] = 0;
    Object tmp561_557 = tmp557_553;
    tmp561_557[4] = 0;
    Object tmp565_561 = tmp561_557;
    tmp565_561[5] = 0;
    Object tmp569_565 = tmp565_561;
    tmp569_565[6] = 33;
    Object tmp575_569 = tmp569_565;
    tmp575_569[7] = 39;
    Object tmp581_575 = tmp575_569;
    tmp581_575[8] = 35;
    Object tmp587_581 = tmp581_575;
    tmp587_581[9] = 36;
    Object tmp593_587 = tmp587_581;
    tmp593_587[10] = 37;
    Object tmp599_593 = tmp593_587;
    tmp599_593[11] = 38;
    Object tmp605_599 = tmp599_593;
    tmp605_599[12] = 39;
    Object tmp611_605 = tmp605_599;
    tmp611_605[13] = 40;
    Object tmp617_611 = tmp611_605;
    tmp617_611[14] = 41;
    Object tmp623_617 = tmp617_611;
    tmp623_617[15] = 42;
    Object tmp629_623 = tmp623_617;
    tmp629_623[16] = 43;
    Object tmp635_629 = tmp629_623;
    tmp635_629[17] = 44;
    Object tmp641_635 = tmp635_629;
    tmp641_635[18] = 45;
    Object tmp647_641 = tmp641_635;
    tmp647_641[19] = 46;
    Object tmp653_647 = tmp647_641;
    tmp653_647[20] = 47;
    Object tmp659_653 = tmp653_647;
    tmp659_653[21] = 58;
    Object tmp665_659 = tmp659_653;
    tmp665_659[22] = 59;
    Object tmp671_665 = tmp665_659;
    tmp671_665[23] = 60;
    Object tmp677_671 = tmp671_665;
    tmp677_671[24] = 61;
    Object tmp683_677 = tmp677_671;
    tmp683_677[25] = 62;
    Object tmp689_683 = tmp683_677;
    tmp689_683[26] = 63;
    Object tmp695_689 = tmp689_683;
    tmp695_689[27] = 91;
    Object tmp701_695 = tmp695_689;
    tmp701_695[28] = 93;
    Object tmp707_701 = tmp701_695;
    tmp707_701[29] = 123;
    Object tmp713_707 = tmp707_701;
    tmp713_707[30] = 125;
    tmp713_707;
    i = 0;
    while (i < 31)
    {
      if (localObject[i] > 0) {
        ccn[4][localObject[i]] = i;
      }
      i += 1;
    }
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 6 });
    cco = (int[][])localObject;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      Arrays.fill(localObject[i], -1);
      i += 1;
    }
    cco[0][4] = 0;
    cco[1][4] = 0;
    cco[1][0] = 28;
    cco[3][4] = 0;
    cco[2][4] = 0;
    cco[2][0] = 15;
    AppMethodBeat.o(12328);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.ccp = paramArrayOfByte;
  }
  
  static Collection<f> a(Iterable<f> paramIterable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12326);
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf1 = (f)paramIterable.next();
      f localf2 = localf1.he(paramInt1);
      localLinkedList.add(localf2.bD(4, paramInt2));
      if (localf1.mode != 4) {
        localLinkedList.add(localf2.bE(4, paramInt2));
      }
      if ((paramInt2 == 3) || (paramInt2 == 4)) {
        localLinkedList.add(localf2.bD(2, 16 - paramInt2).bD(2, 1));
      }
      if (localf1.ccu > 0) {
        localLinkedList.add(localf1.hd(paramInt1).hd(paramInt1 + 1));
      }
    }
    paramIterable = b(localLinkedList);
    AppMethodBeat.o(12326);
    return paramIterable;
  }
  
  static Collection<f> b(Iterable<f> paramIterable)
  {
    AppMethodBeat.i(12327);
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    label48:
    label123:
    label126:
    for (;;)
    {
      f localf1;
      Iterator localIterator;
      f localf2;
      if (paramIterable.hasNext())
      {
        localf1 = (f)paramIterable.next();
        localIterator = localLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break label123;
        }
        localf2 = (f)localIterator.next();
        if (!localf2.a(localf1)) {}
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label126;
        }
        localLinkedList.add(localf1);
        break;
        if (!localf1.a(localf2)) {
          break label48;
        }
        localIterator.remove();
        break label48;
        AppMethodBeat.o(12327);
        return localLinkedList;
      }
    }
  }
  
  final void a(f paramf, int paramInt, Collection<f> paramCollection)
  {
    AppMethodBeat.i(12325);
    int k = (char)(this.ccp[paramInt] & 0xFF);
    int i;
    Object localObject1;
    int j;
    if (ccn[paramf.mode][k] > 0)
    {
      i = 1;
      localObject1 = null;
      j = 0;
      label42:
      if (j > 4) {
        break label178;
      }
      int m = ccn[j][k];
      if (m <= 0) {
        break label221;
      }
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = paramf.he(paramInt);
      label76:
      if ((i == 0) || (j == paramf.mode) || (j == 2)) {
        paramCollection.add(((f)localObject1).bD(j, m));
      }
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (cco[paramf.mode][j] >= 0) {
          paramCollection.add(((f)localObject1).bE(j, m));
        }
      }
    }
    label178:
    label218:
    label221:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      j += 1;
      localObject1 = localObject2;
      break label42;
      i = 0;
      break;
      if ((paramf.ccu > 0) || (ccn[paramf.mode][k] == 0)) {
        paramCollection.add(paramf.hd(paramInt));
      }
      AppMethodBeat.o(12325);
      return;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */