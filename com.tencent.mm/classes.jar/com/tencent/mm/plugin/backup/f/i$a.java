package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.gx;
import java.util.LinkedList;

public final class i$a
{
  int cth;
  String filePath;
  gx jDB;
  LinkedList<u> jDC;
  boolean jDD = true;
  String jDE;
  boolean jDF;
  u jDy;
  
  public i$a(String paramString1, gx paramgx, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    this.filePath = paramString1;
    this.jDB = paramgx;
    this.jDC = paramLinkedList;
    this.cth = paramInt;
    this.jDD = paramBoolean1;
    this.jDE = paramString2;
    this.jDF = paramBoolean2;
    this.jDy = null;
  }
  
  public i$a(String paramString, gx paramgx, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
  {
    this.filePath = paramString;
    this.jDB = paramgx;
    this.jDC = paramLinkedList;
    this.cth = paramInt;
    this.jDD = paramBoolean1;
    this.jDF = paramBoolean2;
    this.jDy = paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i.a
 * JD-Core Version:    0.7.0.1
 */