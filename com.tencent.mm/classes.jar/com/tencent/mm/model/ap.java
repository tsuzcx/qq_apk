package com.tencent.mm.model;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.ah;
import java.util.List;

public abstract interface ap
  extends IAutoStorage<ah>, IStorage
{
  public abstract ah Kd(String paramString);
  
  public abstract ah Ke(String paramString);
  
  public abstract String Kf(String paramString);
  
  public abstract String Kg(String paramString);
  
  public abstract List<String> Kh(String paramString);
  
  public abstract boolean Ki(String paramString);
  
  public abstract boolean Kj(String paramString);
  
  public abstract int Kk(String paramString);
  
  public abstract String getDisplayName(String paramString);
  
  public abstract void z(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ap
 * JD-Core Version:    0.7.0.1
 */