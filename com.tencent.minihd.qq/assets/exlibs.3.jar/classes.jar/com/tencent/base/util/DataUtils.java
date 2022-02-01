package com.tencent.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

public class DataUtils
{
  public static boolean closeDataObject(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        if ((paramObject instanceof InputStream))
        {
          ((InputStream)paramObject).close();
        }
        else if ((paramObject instanceof OutputStream))
        {
          ((OutputStream)paramObject).close();
        }
        else if ((paramObject instanceof Reader))
        {
          ((Reader)paramObject).close();
        }
        else if ((paramObject instanceof Writer))
        {
          ((Writer)paramObject).close();
        }
        else
        {
          if (!(paramObject instanceof RandomAccessFile)) {
            continue;
          }
          ((RandomAccessFile)paramObject).close();
        }
        return true;
      }
      catch (IOException paramObject) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.base.util.DataUtils
 * JD-Core Version:    0.7.0.1
 */