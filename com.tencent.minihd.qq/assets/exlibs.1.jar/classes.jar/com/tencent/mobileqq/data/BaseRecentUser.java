package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public abstract class BaseRecentUser
  extends Entity
{
  public boolean mIsParsed;
  
  protected abstract void doParse();
  
  public void parse()
  {
    if (!this.mIsParsed) {
      try
      {
        if (!this.mIsParsed)
        {
          doParse();
          this.mIsParsed = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void reParse()
  {
    if (!this.mIsParsed) {
      return;
    }
    this.mIsParsed = false;
    parse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.BaseRecentUser
 * JD-Core Version:    0.7.0.1
 */