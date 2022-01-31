package com.tencent.mm.ay;

import android.os.HandlerThread;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import java.util.LinkedList;
import java.util.List;

final class m$a
  extends am
{
  public m$a(m paramm, List<i.b> paramList, LinkedList<Integer> paramLinkedList, LinkedList<bck> paramLinkedList1)
  {
    super(g.DS().mnU.getLooper(), new m.a.1(paramm, paramLinkedList, paramLinkedList1, localLinkedList, paramList), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ay.m.a
 * JD-Core Version:    0.7.0.1
 */