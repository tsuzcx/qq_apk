package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> mpQ = new LinkedList();
  
  public static void a(a parama)
  {
    mpQ.add(parama);
  }
  
  public static void bvN()
  {
    Iterator localIterator = mpQ.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bvO();
    }
    mpQ.clear();
  }
  
  public abstract void bvO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */