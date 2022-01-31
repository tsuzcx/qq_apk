package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i$a
{
  int cth;
  EmojiInfo evH;
  String filePath;
  gx jDB;
  LinkedList<u> jDC;
  boolean jDD = true;
  String jDE;
  boolean jDF;
  u jDy;
  
  public i$a(String paramString1, gx paramgx, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
  {
    this.filePath = paramString1;
    this.jDB = paramgx;
    this.jDC = paramLinkedList;
    this.cth = paramInt;
    this.jDD = false;
    this.jDE = paramString2;
    this.jDF = false;
    this.jDy = null;
  }
  
  public i$a(String paramString, gx paramgx, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
  {
    this.filePath = paramString;
    this.jDB = paramgx;
    this.jDC = paramLinkedList;
    this.cth = paramInt;
    this.jDD = false;
    this.jDF = paramBoolean;
    this.jDy = paramu;
  }
  
  public i$a(String paramString, gx paramgx, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
  {
    this.filePath = paramString;
    this.jDB = paramgx;
    this.jDC = paramLinkedList;
    this.cth = 5;
    this.jDD = false;
    this.jDF = false;
    this.jDy = null;
    this.evH = paramEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i.a
 * JD-Core Version:    0.7.0.1
 */