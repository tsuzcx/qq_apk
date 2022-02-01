package com.tencent.kinda.framework.widget.base;

abstract interface FragmentLifecycle
{
  public abstract void onFragmentOnCreate();
  
  public abstract void onFragmentOnDestroy();
  
  public abstract void onFragmentOnPause();
  
  public abstract void onFragmentOnResume();
  
  public abstract void onFragmentOnStart();
  
  public abstract void onFragmentOnStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.FragmentLifecycle
 * JD-Core Version:    0.7.0.1
 */