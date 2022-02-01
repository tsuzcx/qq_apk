package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;

public class TbsReaderPredownload
{
  public static final int READER_SO_SUCCESS = 2;
  public static final int READER_WAIT_IN_QUEUE = 3;
  static final String[] b = { "docx", "pptx", "xlsx", "pdf", "epub", "txt" };
  Handler a = null;
  LinkedList<String> c = new LinkedList();
  boolean d = false;
  ReaderWizard e = null;
  TbsReaderView.ReaderCallback f = null;
  Object g = null;
  Context h = null;
  ReaderPreDownloadCallback i = null;
  String j = "";
  
  public TbsReaderPredownload(ReaderPreDownloadCallback paramReaderPreDownloadCallback)
  {
    this.i = paramReaderPreDownloadCallback;
    paramReaderPreDownloadCallback = b;
    int m = paramReaderPreDownloadCallback.length;
    while (k < m)
    {
      Object localObject = paramReaderPreDownloadCallback[k];
      this.c.add(localObject);
      k += 1;
    }
    a();
  }
  
  private void b()
  {
    b(3);
  }
  
  void a()
  {
    this.a = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          do
          {
            return;
          } while ((TbsReaderPredownload.this.c.isEmpty()) || (TbsReaderPredownload.this.d));
          paramAnonymousMessage = (String)TbsReaderPredownload.this.c.removeFirst();
          TbsReaderPredownload.this.j = paramAnonymousMessage;
        } while (TbsReaderPredownload.this.a(paramAnonymousMessage));
        TbsReaderPredownload.this.a(-1);
      }
    };
  }
  
  void a(int paramInt)
  {
    if (this.i != null)
    {
      boolean bool = this.c.isEmpty();
      this.i.onEvent(this.j, paramInt, bool);
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    Message localMessage = this.a.obtainMessage(paramInt1);
    this.a.sendMessageDelayed(localMessage, paramInt2);
  }
  
  boolean a(String paramString)
  {
    if ((this.g == null) || (this.e == null)) {}
    while (!ReaderWizard.isSupportExt(paramString)) {
      return false;
    }
    return this.e.checkPlugin(this.g, this.h, paramString, true);
  }
  
  void b(int paramInt)
  {
    this.a.removeMessages(paramInt);
  }
  
  boolean c(int paramInt)
  {
    return this.a.hasMessages(paramInt);
  }
  
  public boolean init(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    this.h = paramContext.getApplicationContext();
    bool = TbsReaderView.a(paramContext.getApplicationContext());
    this.f = new TbsReaderView.ReaderCallback()
    {
      public void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        switch (paramAnonymousInteger.intValue())
        {
        }
        int i;
        do
        {
          return;
          i = ((Integer)paramAnonymousObject1).intValue();
        } while (5014 == i);
        if (5013 == i) {
          TbsReaderPredownload.this.a(0);
        }
        for (;;)
        {
          TbsReaderPredownload.this.j = "";
          TbsReaderPredownload.this.a(3, 100);
          return;
          if (i == 0) {
            TbsReaderPredownload.this.a(0);
          } else {
            TbsReaderPredownload.this.a(-1);
          }
        }
      }
    };
    try
    {
      if (this.e == null) {
        this.e = new ReaderWizard(this.f);
      }
      if (this.g == null) {
        this.g = this.e.getTbsReader();
      }
      if (this.g != null) {
        bool = this.e.initTbsReader(this.g, paramContext.getApplicationContext());
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        Log.e("TbsReaderPredownload", "Unexpect null object!");
        bool = false;
      }
    }
    return bool;
  }
  
  public void pause()
  {
    this.d = true;
  }
  
  public void shutdown()
  {
    this.i = null;
    this.d = false;
    this.c.clear();
    b();
    if (this.e != null)
    {
      this.e.destroy(this.g);
      this.g = null;
    }
    this.h = null;
  }
  
  public void start(String paramString)
  {
    this.d = false;
    b(3);
    this.c.add(paramString);
    a(3, 100);
  }
  
  public void startAll()
  {
    this.d = false;
    if (!(c(3) | false)) {
      a(3, 100);
    }
  }
  
  public static abstract interface ReaderPreDownloadCallback
  {
    public static final int NOTIFY_PLUGIN_FAILED = -1;
    public static final int NOTIFY_PLUGIN_SUCCESS = 0;
    
    public abstract void onEvent(String paramString, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload
 * JD-Core Version:    0.7.0.1
 */