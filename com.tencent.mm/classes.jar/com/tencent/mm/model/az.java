package com.tencent.mm.model;

import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

@Deprecated
public abstract interface az
{
  public abstract void clearPluginData(int paramInt);
  
  public abstract HashMap<Integer, h.b> getBaseDBFactories();
  
  public abstract void onAccountPostReset(boolean paramBoolean);
  
  public abstract void onAccountRelease();
  
  public abstract void onSdcardMount(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.az
 * JD-Core Version:    0.7.0.1
 */