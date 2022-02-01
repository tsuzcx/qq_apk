package com.tencent.av.app;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class QavChatHandler
{
  private static final QavChatHandler jdField_a_of_type_ComTencentAvAppQavChatHandler = new QavChatHandler();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Handler b;
  
  private QavChatHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("qav_chat_thread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static QavChatHandler a()
  {
    return jdField_a_of_type_ComTencentAvAppQavChatHandler;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Handler b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.app.QavChatHandler
 * JD-Core Version:    0.7.0.1
 */