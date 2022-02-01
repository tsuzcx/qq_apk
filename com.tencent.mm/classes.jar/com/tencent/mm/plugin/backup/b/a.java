package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
{
  private static String TAG = "MicroMsg.BackupBaseModel";
  private static LinkedList<a> mRR = new LinkedList();
  
  public static void a(a parama)
  {
    mRR.add(parama);
  }
  
  public static void bCJ()
  {
    Iterator localIterator = mRR.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).bCK();
    }
    mRR.clear();
  }
  
  public abstract void bCK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.a
 * JD-Core Version:    0.7.0.1
 */