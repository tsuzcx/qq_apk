package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> uVN = new LinkedList();
  
  public static void a(a parama)
  {
    uVN.add(parama);
  }
  
  public static void cUD()
  {
    Iterator localIterator = uVN.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cUE();
    }
    uVN.clear();
  }
  
  public abstract void cUE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */