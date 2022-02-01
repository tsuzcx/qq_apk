package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class PhotoBoard$PhotoBoardHandler
  extends Handler
{
  private final WeakReference a;
  
  public PhotoBoard$PhotoBoardHandler(PhotoBoard paramPhotoBoard)
  {
    this.a = new WeakReference(paramPhotoBoard);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PhotoBoard localPhotoBoard = (PhotoBoard)this.a.get();
    if (localPhotoBoard != null)
    {
      obtainMessage();
      localPhotoBoard.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoBoard.PhotoBoardHandler
 * JD-Core Version:    0.7.0.1
 */