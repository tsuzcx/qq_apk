package com.tencent.mm.model;

import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

@Deprecated
public abstract interface be
{
  public abstract void clearPluginData(int paramInt);
  
  public abstract HashMap<Integer, h.b> getBaseDBFactories();
  
  public abstract void onAccountPostReset(boolean paramBoolean);
  
  public abstract void onAccountRelease();
  
  public abstract void onSdcardMount(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.be
 * JD-Core Version:    0.7.0.1
 */