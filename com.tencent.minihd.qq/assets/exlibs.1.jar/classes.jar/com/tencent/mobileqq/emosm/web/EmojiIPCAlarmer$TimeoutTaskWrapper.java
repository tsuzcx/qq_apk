package com.tencent.mobileqq.emosm.web;

class EmojiIPCAlarmer$TimeoutTaskWrapper
  implements Runnable
{
  private int requestSeq;
  
  public EmojiIPCAlarmer$TimeoutTaskWrapper(EmojiIPCAlarmer paramEmojiIPCAlarmer, int paramInt)
  {
    this.requestSeq = paramInt;
  }
  
  public void run()
  {
    if (this.this$0.timeoutObserver != null) {}
    try
    {
      this.this$0.timeoutObserver.onTimeOut(this.requestSeq);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutTaskWrapper
 * JD-Core Version:    0.7.0.1
 */