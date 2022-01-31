package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> jyu = new LinkedList();
  
  public static void a(a parama)
  {
    jyu.add(parama);
  }
  
  public static void aSF()
  {
    Iterator localIterator = jyu.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).aSG();
    }
    jyu.clear();
  }
  
  public abstract void aSG();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */