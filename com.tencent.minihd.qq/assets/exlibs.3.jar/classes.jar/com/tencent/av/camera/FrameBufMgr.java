package com.tencent.av.camera;

public class FrameBufMgr
{
  private static final int FRAME_BUF_CNT = 4;
  public static final int STATE_CAPTURING = 1;
  public static final int STATE_NO_USE = 0;
  public static final int STATE_PREOCESSING = 3;
  public static final int STATE_TO_PREOCESS = 2;
  public static final String TAG = "FrameBufMgr";
  private static volatile FrameBufMgr sFrameBufMgr;
  private FrameBuf[] mFrameBufList = new FrameBuf[4];
  private Object mFrameBufLocker = new Object();
  
  public static FrameBufMgr getInstance()
  {
    if (sFrameBufMgr == null) {}
    try
    {
      if (sFrameBufMgr == null) {
        sFrameBufMgr = new FrameBufMgr();
      }
      return sFrameBufMgr;
    }
    finally {}
  }
  
  public void clear()
  {
    Object localObject1 = this.mFrameBufLocker;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mFrameBufList.length)
        {
          if (this.mFrameBufList[i] != null)
          {
            this.mFrameBufList[i].buf = null;
            this.mFrameBufList[i].state = 0;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public byte[] getFrameBuf(int paramInt)
  {
    if ((this.mFrameBufList[paramInt] == null) || (this.mFrameBufList[paramInt].buf == null)) {
      return null;
    }
    return this.mFrameBufList[paramInt].buf;
  }
  
  public byte[] getFrameBufByState(int paramInt)
  {
    Object localObject1 = this.mFrameBufLocker;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mFrameBufList.length)
        {
          if (this.mFrameBufList[i].state == paramInt)
          {
            byte[] arrayOfByte = this.mFrameBufList[i].buf;
            return arrayOfByte;
          }
        }
        else {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int getFrameBufCnt()
  {
    return this.mFrameBufList.length;
  }
  
  public boolean init(int paramInt)
  {
    Object localObject1 = this.mFrameBufLocker;
    int i = 0;
    try
    {
      while (i < this.mFrameBufList.length)
      {
        if (this.mFrameBufList[i] == null) {
          this.mFrameBufList[i] = new FrameBuf();
        }
        if ((this.mFrameBufList[i].buf == null) || (this.mFrameBufList[i].buf.length != paramInt)) {
          this.mFrameBufList[i].buf = new byte[paramInt];
        }
        this.mFrameBufList[i].state = 0;
        i += 1;
      }
      return true;
    }
    finally {}
  }
  
  public void setFrameBufState(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      synchronized (this.mFrameBufLocker)
      {
        if (i < this.mFrameBufList.length)
        {
          if (this.mFrameBufList[i].state == paramInt1)
          {
            this.mFrameBufList[i].state = paramInt2;
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            break;
          }
          return;
        }
      }
      i += 1;
    }
  }
  
  public void setFrameBufState(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.mFrameBufLocker;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mFrameBufList.length)
        {
          if (this.mFrameBufList[i].buf == paramArrayOfByte) {
            this.mFrameBufList[i].state = paramInt;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public class FrameBuf
  {
    public byte[] buf = null;
    public int state = 0;
    
    public FrameBuf() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.camera.FrameBufMgr
 * JD-Core Version:    0.7.0.1
 */