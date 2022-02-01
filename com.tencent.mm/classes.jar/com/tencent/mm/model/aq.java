package com.tencent.mm.model;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ah;
import java.util.List;

public abstract interface aq
  extends IAutoStorage<ah>, IStorage
{
  public abstract String PJ(String paramString);
  
  public abstract List<String> RA(String paramString);
  
  public abstract boolean RB(String paramString);
  
  public abstract boolean RC(String paramString);
  
  public abstract int RD(String paramString);
  
  public abstract ah Rw(String paramString);
  
  public abstract ah Rx(String paramString);
  
  public abstract String Ry(String paramString);
  
  public abstract String Rz(String paramString);
  
  public abstract void w(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.aq
 * JD-Core Version:    0.7.0.1
 */