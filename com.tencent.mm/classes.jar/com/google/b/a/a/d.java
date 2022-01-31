package com.google.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  static final String[] bhW;
  static final int[][] bhX;
  private static final int[][] bhY;
  static final int[][] bhZ;
  final byte[] bia;
  
  static
  {
    AppMethodBeat.i(57263);
    bhW = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
    bhX = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, { 327711, 656380, 656382, 656381, 0 } };
    Object localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 5, 256 });
    bhY = (int[][])localObject;
    localObject[0][32] = 1;
    int i = 65;
    while (i <= 90)
    {
      bhY[0][i] = (i - 65 + 2);
      i += 1;
    }
    bhY[1][32] = 1;
    i = 97;
    while (i <= 122)
    {
      bhY[1][i] = (i - 97 + 2);
      i += 1;
    }
    bhY[2][32] = 1;
    i = 48;
    while (i <= 57)
    {
      bhY[2][i] = (i - 48 + 2);
      i += 1;
    }
    bhY[2][44] = 12;
    bhY[2][46] = 13;
    i = 0;
    while (i < 28)
    {
      bhY[3][new int[] { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 }[i]] = i;
      i += 1;
    }
    localObject = new int[31];
    Object tmp543_542 = localObject;
    tmp543_542[0] = 0;
    Object tmp547_543 = tmp543_542;
    tmp547_543[1] = 13;
    Object tmp552_547 = tmp547_543;
    tmp552_547[2] = 0;
    Object tmp556_552 = tmp552_547;
    tmp556_552[3] = 0;
    Object tmp560_556 = tmp556_552;
    tmp560_556[4] = 0;
    Object tmp564_560 = tmp560_556;
    tmp564_560[5] = 0;
    Object tmp568_564 = tmp564_560;
    tmp568_564[6] = 33;
    Object tmp574_568 = tmp568_564;
    tmp574_568[7] = 39;
    Object tmp580_574 = tmp574_568;
    tmp580_574[8] = 35;
    Object tmp586_580 = tmp580_574;
    tmp586_580[9] = 36;
    Object tmp592_586 = tmp586_580;
    tmp592_586[10] = 37;
    Object tmp598_592 = tmp592_586;
    tmp598_592[11] = 38;
    Object tmp604_598 = tmp598_592;
    tmp604_598[12] = 39;
    Object tmp610_604 = tmp604_598;
    tmp610_604[13] = 40;
    Object tmp616_610 = tmp610_604;
    tmp616_610[14] = 41;
    Object tmp622_616 = tmp616_610;
    tmp622_616[15] = 42;
    Object tmp628_622 = tmp622_616;
    tmp628_622[16] = 43;
    Object tmp634_628 = tmp628_622;
    tmp634_628[17] = 44;
    Object tmp640_634 = tmp634_628;
    tmp640_634[18] = 45;
    Object tmp646_640 = tmp640_634;
    tmp646_640[19] = 46;
    Object tmp652_646 = tmp646_640;
    tmp652_646[20] = 47;
    Object tmp658_652 = tmp652_646;
    tmp658_652[21] = 58;
    Object tmp664_658 = tmp658_652;
    tmp664_658[22] = 59;
    Object tmp670_664 = tmp664_658;
    tmp670_664[23] = 60;
    Object tmp676_670 = tmp670_664;
    tmp676_670[24] = 61;
    Object tmp682_676 = tmp676_670;
    tmp682_676[25] = 62;
    Object tmp688_682 = tmp682_676;
    tmp688_682[26] = 63;
    Object tmp694_688 = tmp688_682;
    tmp694_688[27] = 91;
    Object tmp700_694 = tmp694_688;
    tmp700_694[28] = 93;
    Object tmp706_700 = tmp700_694;
    tmp706_700[29] = 123;
    Object tmp712_706 = tmp706_700;
    tmp712_706[30] = 125;
    tmp712_706;
    i = 0;
    while (i < 31)
    {
      if (localObject[i] > 0) {
        bhY[4][localObject[i]] = i;
      }
      i += 1;
    }
    localObject = (int[][])Array.newInstance(Integer.TYPE, new int[] { 6, 6 });
    bhZ = (int[][])localObject;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      Arrays.fill(localObject[i], -1);
      i += 1;
    }
    bhZ[0][4] = 0;
    bhZ[1][4] = 0;
    bhZ[1][0] = 28;
    bhZ[3][4] = 0;
    bhZ[2][4] = 0;
    bhZ[2][0] = 15;
    AppMethodBeat.o(57263);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this.bia = paramArrayOfByte;
  }
  
  static Collection<f> a(Iterable<f> paramIterable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57261);
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      f localf1 = (f)paramIterable.next();
      f localf2 = localf1.fc(paramInt1);
      localLinkedList.add(localf2.bp(4, paramInt2));
      if (localf1.mode != 4) {
        localLinkedList.add(localf2.bq(4, paramInt2));
      }
      if ((paramInt2 == 3) || (paramInt2 == 4)) {
        localLinkedList.add(localf2.bp(2, 16 - paramInt2).bp(2, 1));
      }
      if (localf1.bif > 0) {
        localLinkedList.add(localf1.fb(paramInt1).fb(paramInt1 + 1));
      }
    }
    paramIterable = c(localLinkedList);
    AppMethodBeat.o(57261);
    return paramIterable;
  }
  
  static Collection<f> c(Iterable<f> paramIterable)
  {
    AppMethodBeat.i(57262);
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    label47:
    label121:
    label124:
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
          break label121;
        }
        localf2 = (f)localIterator.next();
        if (!localf2.a(localf1)) {}
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label124;
        }
        localLinkedList.add(localf1);
        break;
        if (!localf1.a(localf2)) {
          break label47;
        }
        localIterator.remove();
        break label47;
        AppMethodBeat.o(57262);
        return localLinkedList;
      }
    }
  }
  
  final void a(f paramf, int paramInt, Collection<f> paramCollection)
  {
    AppMethodBeat.i(57260);
    int k = (char)(this.bia[paramInt] & 0xFF);
    int i;
    Object localObject1;
    int j;
    if (bhY[paramf.mode][k] > 0)
    {
      i = 1;
      localObject1 = null;
      j = 0;
      label41:
      if (j > 4) {
        break label177;
      }
      int m = bhY[j][k];
      if (m <= 0) {
        break label219;
      }
      if (localObject1 != null) {
        break label216;
      }
      localObject1 = paramf.fc(paramInt);
      label75:
      if ((i == 0) || (j == paramf.mode) || (j == 2)) {
        paramCollection.add(((f)localObject1).bp(j, m));
      }
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = localObject1;
        if (bhZ[paramf.mode][j] >= 0) {
          paramCollection.add(((f)localObject1).bq(j, m));
        }
      }
    }
    label177:
    label216:
    label219:
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      j += 1;
      localObject1 = localObject2;
      break label41;
      i = 0;
      break;
      if ((paramf.bif > 0) || (bhY[paramf.mode][k] == 0)) {
        paramCollection.add(paramf.fb(paramInt));
      }
      AppMethodBeat.o(57260);
      return;
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */