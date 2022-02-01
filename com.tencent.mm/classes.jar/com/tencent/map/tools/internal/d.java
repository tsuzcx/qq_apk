package com.tencent.map.tools.internal;

public abstract interface d
{
  public abstract Object callSheetMth(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject);
  
  public abstract Object callSheetMth(Object paramObject, String paramString, Object... paramVarArgs);
  
  public abstract Object callSheetStaMth(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject);
  
  public abstract Class findSheet(String paramString);
  
  public abstract <T> Class<? extends T> findSheet(String paramString, Class<T> paramClass);
  
  public abstract ClassLoader getSheetLoader();
  
  public abstract int loadSheetGroups();
  
  public abstract <T> T newSheetIns(Class<T> paramClass, Object... paramVarArgs);
  
  public abstract Object newSheetIns(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.d
 * JD-Core Version:    0.7.0.1
 */