package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> oIJ = new LinkedList();
  
  public static void a(a parama)
  {
    oIJ.add(parama);
  }
  
  public static void ceG()
  {
    Iterator localIterator = oIJ.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ceH();
    }
    oIJ.clear();
  }
  
  public abstract void ceH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */