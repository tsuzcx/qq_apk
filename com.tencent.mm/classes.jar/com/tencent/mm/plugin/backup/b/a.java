package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> nsq = new LinkedList();
  
  public static void a(a parama)
  {
    nsq.add(parama);
  }
  
  public static void bGR()
  {
    Iterator localIterator = nsq.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bGS();
    }
    nsq.clear();
  }
  
  public abstract void bGS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */