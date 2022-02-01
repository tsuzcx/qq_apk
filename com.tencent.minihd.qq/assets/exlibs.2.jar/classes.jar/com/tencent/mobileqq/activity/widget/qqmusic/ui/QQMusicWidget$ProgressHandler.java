package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.music.QQPlayerService;
import java.lang.ref.WeakReference;

public class QQMusicWidget$ProgressHandler
  extends Handler
{
  WeakReference a;
  
  QQMusicWidget$ProgressHandler(QQMusicWidget paramQQMusicWidget)
  {
    this.a = new WeakReference(paramQQMusicWidget);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (QQMusicWidget)this.a.get();
    if (paramMessage == null) {}
    while (QQPlayerService.a() != 2) {
      return;
    }
    QQMusicWidget.a(paramMessage).sendEmptyMessageDelayed(0, 800L);
    QQMusicWidget.e(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget.ProgressHandler
 * JD-Core Version:    0.7.0.1
 */