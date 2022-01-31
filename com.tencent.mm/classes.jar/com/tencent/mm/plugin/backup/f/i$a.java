package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.fo;
import java.util.LinkedList;

public final class i$a
{
  int bLN;
  String filePath;
  u hJV;
  fo hJY;
  LinkedList<u> hJZ;
  boolean hKa = true;
  String hKb;
  boolean hKc;
  
  public i$a(String paramString1, fo paramfo, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    this.filePath = paramString1;
    this.hJY = paramfo;
    this.hJZ = paramLinkedList;
    this.bLN = paramInt;
    this.hKa = paramBoolean1;
    this.hKb = paramString2;
    this.hKc = paramBoolean2;
    this.hJV = null;
  }
  
  public i$a(String paramString, fo paramfo, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
  {
    this.filePath = paramString;
    this.hJY = paramfo;
    this.hJZ = paramLinkedList;
    this.bLN = paramInt;
    this.hKa = paramBoolean1;
    this.hKc = paramBoolean2;
    this.hJV = paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i.a
 * JD-Core Version:    0.7.0.1
 */