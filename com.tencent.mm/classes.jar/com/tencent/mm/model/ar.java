package com.tencent.mm.model;

import com.tencent.mm.sdk.storage.IAutoStorage;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.storage.aj;
import java.util.List;

public abstract interface ar
  extends IAutoStorage<aj>, IStorage
{
  public abstract void A(String paramString, long paramLong);
  
  public abstract boolean JA(String paramString);
  
  public abstract int JB(String paramString);
  
  public abstract aj Ju(String paramString);
  
  public abstract aj Jv(String paramString);
  
  public abstract String Jw(String paramString);
  
  public abstract String Jx(String paramString);
  
  public abstract List<String> Jy(String paramString);
  
  public abstract boolean Jz(String paramString);
  
  public abstract String getDisplayName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ar
 * JD-Core Version:    0.7.0.1
 */