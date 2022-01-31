package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> hFb = new LinkedList();
  
  public static void a(a parama)
  {
    hFb.add(parama);
  }
  
  public static void ath()
  {
    Iterator localIterator = hFb.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ati();
    }
    hFb.clear();
  }
  
  public abstract void ati();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */