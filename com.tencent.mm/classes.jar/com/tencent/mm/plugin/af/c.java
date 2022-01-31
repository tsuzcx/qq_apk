package com.tencent.mm.plugin.af;

import android.util.SparseArray;

public enum c
{
  public final SparseArray<b> odV = new SparseArray();
  
  private c() {}
  
  public final boolean a(b paramb)
  {
    this.odV.put(paramb.getType(), paramb);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.af.c
 * JD-Core Version:    0.7.0.1
 */