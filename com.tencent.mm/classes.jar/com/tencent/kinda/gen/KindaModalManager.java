package com.tencent.kinda.gen;

public abstract interface KindaModalManager
{
  public abstract void addModalView(IUIModal paramIUIModal);
  
  public abstract void removeAllModalViews();
  
  public abstract void removeModalViewImpl(IUIModal paramIUIModal, VoidCallback paramVoidCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KindaModalManager
 * JD-Core Version:    0.7.0.1
 */