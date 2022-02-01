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
  private static final int[][] bHA;
  static final int[][] bHB;
  static final String[] bHy;
  static final int[][] bHz;
  final byte[] bHC;
  
  static
  {
    AppMethodBeat.i(12328);
    bHy = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
    Object localObject = { 590318, 0, 327710, 327709, 656318 };
    int[] arrayOfInt = { 327709, 327708, 656318, 0, 327710 };
    bHz = new int[][] { { 0, 327708, 327710, 327709, 656318 }, localObject, { 262158, 590300, 0, 590301, 932798 }, arrayOfInt, { 327711, 656380, 656382, 656381, 0 } };
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 256 });
    bHA = (int[][])localObject;
    localObject[0][32] = 1;
    int i = 65;
    while (i <= 90)
    {
      bHA[0][i] = (i - 65 + 2);
      i += 1;
    }
    bHA[1][32] = 1;
    i = 97;
    while (i <= 122)
    {
      bHA[1][i] = (i - 97 + 2);
      i += 1;
    }
    bHA[2][32] = 1;
    i = 48;
    while (i <= 57)
    {
      bHA[2][i] = (i - 48 + 2);
      i += 1;
    }
    bHA[2][44] = 12;
    bHA[2][46] = 13;
    i = 0;
    while (i < 28)
    {
      bHA[3][new int[] { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 }[i]] = i;
      i += 1;
    }
    localObject = new int[31];
    Object tmp548_547 = localObject;
    tmp548_547[0] = 0;
    Object tmp552_548 = tmp548_547;
    tmp552_548[1] = 13;
    Object tmp557_552 = tmp552_548;
    tmp557_552[2] = 0;
    Object tmp561_557 = tmp557_552;
    tmp561_557[3] = 0;
    Object tmp565_561 = tmp561_557;
    tmp565_561[4] = 0;
    Object tmp569_565 = tmp565_561;
    tmp569_565[5] = 0;
    Object tmp573_569 = tmp569_565;
    tmp573_569[6] = 33;
    Object tmp579_573 = tmp573_569;
    tmp579_573[7] = 39;
    Object tmp585_579 = tmp579_573;
    tmp585_579[8] = 35;
    Object tmp591_585 = tmp585_579;
    tmp591_585[9] = 36;
    Object tmp597_591 = tmp591_585;
    tmp597_591[10] = 37;
    Object tmp603_597 = tmp597_591;
    tmp603_597[11] = 38;
    Object tmp609_603 = tmp603_597;
    tmp609_603[12] = 39;
    Object tmp615_609 = tmp609_603;
    tmp615_609[13] = 40;
    Object tmp621_615 = tmp615_609;
    tmp621_615[14] = 41;
    Object tmp627_621 = tmp621_615;
    tmp627_621[15] = 42;
    Object tmp633_627 = tmp627_621;
    tmp633_627[16] = 43;
    Object tmp639_633 = tmp633_627;
    tmp639_633[17] = 44;
    Object tmp645_639 = tmp639_633;
    tmp645_639[18] = 45;
    Object tmp651_645 = tmp645_639;
    tmp651_645[19] = 46;
    Object tmp657_651 = tmp651_645;
    tmp657_651[20] = 47;
    Object tmp663_657 = tmp657_651;
    tmp663_657[21] = 58;
    Object tmp669_663 = tmp663_657;
    tmp669_663[22] = 59;
    Object tmp675_669 = tmp669_663;
    tmp675_669[23] = 60;
    Object tmp681_675 = tmp675_669;
    tmp681_675[24] = 61;
    Object tmp687_681 = tmp681_675;
    tmp687_681[25] = 62;
    Object tmp693_687 = tmp687_681;
    tmp693_687[26] = 63;
    Object tmp699_693 = tmp693_687;
    tmp699_693[27] = 91;
    Object tmp705_699 = tmp699_693;
    tmp705_699[28] = 93;
    Object tmp711_705 = tmp705_699;
    tmp711_705[29] = 123;
    Object tmp717_711 = tmp711_705;
    tmp717_711[30] = 125;
    tmp717_711;
    i = 0;
    while (i < 31)
    {
      if (localObject[i] > 0) {
        bHA[4][localObject[i]] = i;
      }
      i += 1;
    }
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 6 });
    bHB = (int[][])localObject;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      Arrays.fill(localObject[i], -1);
      i += 1;
    }
    bHB[0][4] = 0;
    bHB[1][4] = 0;
    bHB[1][0] = 28;
    bHB[3][4] = 0;
    bHB[2][4] = 0;
    bHB[2][0] = 15;
    AppMethodBeat.o(12328);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.bHC = paramArrayOfByte;
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
      f localf2 = localf1.fQ(paramInt1);
      localLinkedList.add(localf2.bB(4, paramInt2));
      if (localf1.mode != 4) {
        localLinkedList.add(localf2.bC(4, paramInt2));
      }
      if ((paramInt2 == 3) || (paramInt2 == 4)) {
        localLinkedList.add(localf2.bB(2, 16 - paramInt2).bB(2, 1));
      }
      if (localf1.bHH > 0) {
        localLinkedList.add(localf1.fP(paramInt1).fP(paramInt1 + 1));
      }
    }
    paramIterable = a(localLinkedList);
    AppMethodBeat.o(12326);
    return paramIterable;
  }
  
  final void a(f paramf, int paramInt, Collection<f> paramCollection)
  {
    AppMethodBeat.i(12325);
    int k = (char)(this.bHC[paramInt] & 0xFF);
    int i;
    Object localObject1;
    int j;
    if (bHA[paramf.mode][k] > 0)
    {
      i = 1;
      localObject1 = null;
      j = 0;
      label42:
      if (j > 4) {
        break label178;
      }
      int m = bHA[j][k];
      if (m <= 0) {
        break label221;
      }
      if (localObject1 != null) {
        break label218;
      }
      localObject1 = paramf.fQ(paramInt);
      label76:
      if ((i == 0) || (j == paramf.mode) || (j == 2)) {
        paramCollection.add(((f)localObject1).bB(j, m));
      }
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (bHB[paramf.mode][j] >= 0) {
          paramCollection.add(((f)localObject1).bC(j, m));
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
      if ((paramf.bHH > 0) || (bHA[paramf.mode][k] == 0)) {
        paramCollection.add(paramf.fP(paramInt));
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