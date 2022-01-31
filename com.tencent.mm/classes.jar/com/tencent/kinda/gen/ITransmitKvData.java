package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract class ITransmitKvData
{
  public static native ITransmitKvData create();
  
  public abstract byte[] getBinary(String paramString);
  
  public abstract boolean getBool(String paramString);
  
  public abstract ArrayList<Boolean> getBoolList(String paramString);
  
  public abstract int getInt(String paramString);
  
  public abstract ArrayList<Integer> getIntList(String paramString);
  
  public abstract KJSEvent getJSEvent(String paramString);
  
  public abstract long getLong(String paramString);
  
  public abstract ArrayList<Long> getLongList(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract ArrayList<String> getStringList(String paramString);
  
  public abstract void putBinary(String paramString, byte[] paramArrayOfByte);
  
  public abstract void putBool(String paramString, boolean paramBoolean);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putJSEvent(String paramString, KJSEvent paramKJSEvent);
  
  public abstract void putListBool(String paramString, ArrayList<Boolean> paramArrayList);
  
  public abstract void putListInt(String paramString, ArrayList<Integer> paramArrayList);
  
  public abstract void putListLong(String paramString, ArrayList<Long> paramArrayList);
  
  public abstract void putListString(String paramString, ArrayList<String> paramArrayList);
  
  public abstract void putLong(String paramString, long paramLong);
  
  public abstract void putString(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.ITransmitKvData
 * JD-Core Version:    0.7.0.1
 */