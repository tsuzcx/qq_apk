package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> nxL = new LinkedList();
  
  public static void a(a parama)
  {
    nxL.add(parama);
  }
  
  public static void bHP()
  {
    Iterator localIterator = nxL.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bHQ();
    }
    nxL.clear();
  }
  
  public abstract void bHQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */