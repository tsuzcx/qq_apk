package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.storage.emotion.EmojiInfo;
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
  EmojiInfo hNs;
  
  public i$a(String paramString1, fo paramfo, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
  {
    this.filePath = paramString1;
    this.hJY = paramfo;
    this.hJZ = paramLinkedList;
    this.bLN = paramInt;
    this.hKa = false;
    this.hKb = paramString2;
    this.hKc = false;
    this.hJV = null;
  }
  
  public i$a(String paramString, fo paramfo, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
  {
    this.filePath = paramString;
    this.hJY = paramfo;
    this.hJZ = paramLinkedList;
    this.bLN = paramInt;
    this.hKa = false;
    this.hKc = paramBoolean;
    this.hJV = paramu;
  }
  
  public i$a(String paramString, fo paramfo, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
  {
    this.filePath = paramString;
    this.hJY = paramfo;
    this.hJZ = paramLinkedList;
    this.bLN = 5;
    this.hKa = false;
    this.hKc = false;
    this.hJV = null;
    this.hNs = paramEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i.a
 * JD-Core Version:    0.7.0.1
 */