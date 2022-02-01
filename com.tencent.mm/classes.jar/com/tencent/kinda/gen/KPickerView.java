package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KPickerView
  extends KView
{
  public abstract ArrayList<Integer> getCurrentSelectedRows();
  
  public abstract void setCallbackImpl(VoidListCallback paramVoidListCallback);
  
  public abstract void setNormalData(ArrayList<ArrayList<String>> paramArrayList);
  
  public abstract void setSelectedRows(ArrayList<Integer> paramArrayList);
  
  public abstract void setSyncData(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KPickerView
 * JD-Core Version:    0.7.0.1
 */