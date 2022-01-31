package com.tencent.mm.cg.a;

import android.database.Cursor;
import android.util.SparseArray;
import java.util.HashMap;

public abstract interface d<T>
  extends Cursor
{
  public abstract boolean NL(int paramInt);
  
  public abstract a NM(int paramInt);
  
  public abstract void NN(int paramInt);
  
  public abstract void a(f.a parama);
  
  public abstract boolean a(Object paramObject, a parama);
  
  public abstract boolean cD(Object paramObject);
  
  public abstract a cE(Object paramObject);
  
  public abstract SparseArray<T>[] dzK();
  
  public abstract HashMap<Object, T> dzL();
  
  public abstract boolean dzM();
  
  public abstract void pV(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a.d
 * JD-Core Version:    0.7.0.1
 */