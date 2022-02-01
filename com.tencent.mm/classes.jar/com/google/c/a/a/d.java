package com.google.c.a.a;

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
  static final String[] bRM;
  static final int[][] bRN;
  private static final int[][] bRO;
  static final int[][] bRP;
  final byte[] bRQ;
  
  static
  {
    AppMethodBeat.i(12328);
    bRM = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
    Object localObject = { 0, 327708, 327710, 327709, 656318 };
    int[] arrayOfInt1 = { 262158, 590300, 0, 590301, 932798 };
    int[] arrayOfInt2 = { 327709, 327708, 656318, 0, 327710 };
    int[] arrayOfInt3 = { 327711, 656380, 656382, 656381, 0 };
    bRN = new int[][] { localObject, { 590318, 0, 327710, 327709, 656318 }, arrayOfInt1, arrayOfInt2, arrayOfInt3 };
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 256 });
    bRO = (int[][])localObject;
    localObject[0][32] = 1;
    int i = 65;
    while (i <= 90)
    {
      bRO[0][i] = (i - 65 + 2);
      i += 1;
    }
    bRO[1][32] = 1;
    i = 97;
    while (i <= 122)
    {
      bRO[1][i] = (i - 97 + 2);
      i += 1;
    }
    bRO[2][32] = 1;
    i = 48;
    while (i <= 57)
    {
      bRO[2][i] = (i - 48 + 2);
      i += 1;
    }
    bRO[2][44] = 12;
    bRO[2][46] = 13;
    i = 0;
    while (i < 28)
    {
      bRO[3][new int[] { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 }[i]] = i;
      i += 1;
    }
    localObject = new int[31];
    Object tmp556_555 = localObject;
    tmp556_555[0] = 0;
    Object tmp560_556 = tmp556_555;
    tmp560_556[1] = 13;
    Object tmp565_560 = tmp560_556;
    tmp565_560[2] = 0;
    Object tmp569_565 = tmp565_560;
    tmp569_565[3] = 0;
    Object tmp573_569 = tmp569_565;
    tmp573_569[4] = 0;
    Object tmp577_573 = tmp573_569;
    tmp577_573[5] = 0;
    Object tmp581_577 = tmp577_573;
    tmp581_577[6] = 33;
    Object tmp587_581 = tmp581_577;
    tmp587_581[7] = 39;
    Object tmp593_587 = tmp587_581;
    tmp593_587[8] = 35;
    Object tmp599_593 = tmp593_587;
    tmp599_593[9] = 36;
    Object tmp605_599 = tmp599_593;
    tmp605_599[10] = 37;
    Object tmp611_605 = tmp605_599;
    tmp611_605[11] = 38;
    Object tmp617_611 = tmp611_605;
    tmp617_611[12] = 39;
    Object tmp623_617 = tmp617_611;
    tmp623_617[13] = 40;
    Object tmp629_623 = tmp623_617;
    tmp629_623[14] = 41;
    Object tmp635_629 = tmp629_623;
    tmp635_629[15] = 42;
    Object tmp641_635 = tmp635_629;
    tmp641_635[16] = 43;
    Object tmp647_641 = tmp641_635;
    tmp647_641[17] = 44;
    Object tmp653_647 = tmp647_641;
    tmp653_647[18] = 45;
    Object tmp659_653 = tmp653_647;
    tmp659_653[19] = 46;
    Object tmp665_659 = tmp659_653;
    tmp665_659[20] = 47;
    Object tmp671_665 = tmp665_659;
    tmp671_665[21] = 58;
    Object tmp677_671 = tmp671_665;
    tmp677_671[22] = 59;
    Object tmp683_677 = tmp677_671;
    tmp683_677[23] = 60;
    Object tmp689_683 = tmp683_677;
    tmp689_683[24] = 61;
    Object tmp695_689 = tmp689_683;
    tmp695_689[25] = 62;
    Object tmp701_695 = tmp695_689;
    tmp701_695[26] = 63;
    Object tmp707_701 = tmp701_695;
    tmp707_701[27] = 91;
    Object tmp713_707 = tmp707_701;
    tmp713_707[28] = 93;
    Object tmp719_713 = tmp713_707;
    tmp719_713[29] = 123;
    Object tmp725_719 = tmp719_713;
    tmp725_719[30] = 125;
    tmp725_719;
    i = 0;
    while (i < 31)
    {
      if (localObject[i] > 0) {
        bRO[4][localObject[i]] = i;
      }
      i += 1;
    }
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 6 });
    bRP = (int[][])localObject;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      Arrays.fill(localObject[i], -1);
      i += 1;
    }
    bRP[0][4] = 0;
    bRP[1][4] = 0;
    bRP[1][0] = 28;
    bRP[3][4] = 0;
    bRP[2][4] = 0;
    bRP[2][0] = 15;
    AppMethodBeat.o(12328);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.bRQ = paramArrayOfByte;
  }
  
  static Collection<f> a(Iterable<f> paramIterable)
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
  
  static Collection<f> a(Iterable<f> paramIterable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12326);
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf1 = (f)paramIterable.next();
      f localf2 = localf1.fT(paramInt1);
      localLinkedList.add(localf2.bD(4, paramInt2));
      if (localf1.mode != 4) {
        localLinkedList.add(localf2.bE(4, paramInt2));
      }
      if ((paramInt2 == 3) || (paramInt2 == 4)) {
        localLinkedList.add(localf2.bD(2, 16 - paramInt2).bD(2, 1));
      }
      if (localf1.bRV > 0) {
        localLinkedList.add(localf1.fS(paramInt1).fS(paramInt1 + 1));
      }
    }
    paramIterable = a(localLinkedList);
    AppMethodBeat.o(12326);
    return paramIterable;
  }
  
  final void a(f paramf, int paramInt, Collection<f> paramCollection)
  {
    AppMethodBeat.i(12325);
    int k = (char)(this.bRQ[paramInt] & 0xFF);
    int i;
    Object localObject1;
    int j;
    if (bRO[paramf.mode][k] > 0)
    {
      i = 1;
      localObject1 = null;
      j = 0;
      label42:
      if (j > 4) {
        break label178;
      }
      int m = bRO[j][k];
      if (m <= 0) {
        break label221;
      }
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = paramf.fT(paramInt);
      label76:
      if ((i == 0) || (j == paramf.mode) || (j == 2)) {
        paramCollection.add(((f)localObject1).bD(j, m));
      }
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (bRP[paramf.mode][j] >= 0) {
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
      if ((paramf.bRV > 0) || (bRO[paramf.mode][k] == 0)) {
        paramCollection.add(paramf.fS(paramInt));
      }
      AppMethodBeat.o(12325);
      return;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */