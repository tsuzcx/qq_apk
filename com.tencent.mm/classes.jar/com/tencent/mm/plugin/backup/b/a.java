package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> rKz = new LinkedList();
  
  public static void a(a parama)
  {
    rKz.add(parama);
  }
  
  public static void crT()
  {
    Iterator localIterator = rKz.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).crU();
    }
    rKz.clear();
  }
  
  public abstract void crU();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */