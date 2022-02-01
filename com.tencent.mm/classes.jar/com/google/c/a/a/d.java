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
    Object localObject = { 327711, 656380, 656382, 656381, 0 };
    bRN = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, localObject };
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
    Object tmp546_545 = localObject;
    tmp546_545[0] = 0;
    Object tmp550_546 = tmp546_545;
    tmp550_546[1] = 13;
    Object tmp555_550 = tmp550_546;
    tmp555_550[2] = 0;
    Object tmp559_555 = tmp555_550;
    tmp559_555[3] = 0;
    Object tmp563_559 = tmp559_555;
    tmp563_559[4] = 0;
    Object tmp567_563 = tmp563_559;
    tmp567_563[5] = 0;
    Object tmp571_567 = tmp567_563;
    tmp571_567[6] = 33;
    Object tmp577_571 = tmp571_567;
    tmp577_571[7] = 39;
    Object tmp583_577 = tmp577_571;
    tmp583_577[8] = 35;
    Object tmp589_583 = tmp583_577;
    tmp589_583[9] = 36;
    Object tmp595_589 = tmp589_583;
    tmp595_589[10] = 37;
    Object tmp601_595 = tmp595_589;
    tmp601_595[11] = 38;
    Object tmp607_601 = tmp601_595;
    tmp607_601[12] = 39;
    Object tmp613_607 = tmp607_601;
    tmp613_607[13] = 40;
    Object tmp619_613 = tmp613_607;
    tmp619_613[14] = 41;
    Object tmp625_619 = tmp619_613;
    tmp625_619[15] = 42;
    Object tmp631_625 = tmp625_619;
    tmp631_625[16] = 43;
    Object tmp637_631 = tmp631_625;
    tmp637_631[17] = 44;
    Object tmp643_637 = tmp637_631;
    tmp643_637[18] = 45;
    Object tmp649_643 = tmp643_637;
    tmp649_643[19] = 46;
    Object tmp655_649 = tmp649_643;
    tmp655_649[20] = 47;
    Object tmp661_655 = tmp655_649;
    tmp661_655[21] = 58;
    Object tmp667_661 = tmp661_655;
    tmp667_661[22] = 59;
    Object tmp673_667 = tmp667_661;
    tmp673_667[23] = 60;
    Object tmp679_673 = tmp673_667;
    tmp679_673[24] = 61;
    Object tmp685_679 = tmp679_673;
    tmp685_679[25] = 62;
    Object tmp691_685 = tmp685_679;
    tmp691_685[26] = 63;
    Object tmp697_691 = tmp691_685;
    tmp697_691[27] = 91;
    Object tmp703_697 = tmp697_691;
    tmp703_697[28] = 93;
    Object tmp709_703 = tmp703_697;
    tmp709_703[29] = 123;
    Object tmp715_709 = tmp709_703;
    tmp715_709[30] = 125;
    tmp715_709;
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