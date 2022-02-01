package com.tencent.mobileqq.activity.widget.qqmusic.utils.storage;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.Util4File;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

public class QFile
{
  private static final int jdField_a_of_type_Int = 3;
  public static final String a = "/";
  private static final String jdField_b_of_type_JavaLangString = "QFile";
  private static final int c = 2;
  private File jdField_a_of_type_JavaIoFile;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  public QFile(QFile paramQFile, String paramString)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramQFile.a(), paramString);
    this.jdField_b_of_type_Boolean = MusicUtil.a(this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public QFile(File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_b_of_type_Boolean = MusicUtil.a(this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public QFile(File paramFile, String paramString)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramFile, paramString);
    this.jdField_b_of_type_Boolean = MusicUtil.a(this.jdField_a_of_type_JavaIoFile.getPath());
  }
  
  public QFile(String paramString)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
    this.jdField_b_of_type_Boolean = MusicUtil.a(paramString);
  }
  
  public QFile(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramString1, paramString2);
    this.jdField_b_of_type_Boolean = MusicUtil.a(paramString1);
  }
  
  public QFile(URI paramURI)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramURI);
  }
  
  private QFile[] a(File[] paramArrayOfFile)
  {
    QFile[] arrayOfQFile = null;
    if (paramArrayOfFile != null)
    {
      arrayOfQFile = new QFile[paramArrayOfFile.length];
      int i = 0;
      while (i < paramArrayOfFile.length)
      {
        arrayOfQFile[i] = new QFile(paramArrayOfFile[i]);
        i += 1;
      }
    }
    return arrayOfQFile;
  }
  
  private boolean k()
  {
    return false;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_JavaIoFile.length();
  }
  
  public QFile a()
  {
    return new QFile(this.jdField_a_of_type_JavaIoFile.getParentFile());
  }
  
  public File a()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaIoFile.getName();
  }
  
  public boolean a()
  {
    return a(false);
  }
  
  public boolean a(QFile paramQFile)
  {
    boolean bool = false;
    if (paramQFile != null)
    {
      paramQFile.a().b(false);
      bool = this.jdField_a_of_type_JavaIoFile.renameTo(paramQFile.a());
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return b(paramBoolean);
  }
  
  public QFile[] a()
  {
    return a(this.jdField_a_of_type_JavaIoFile.listFiles());
  }
  
  public QFile[] a(FileFilter paramFileFilter)
  {
    return a(this.jdField_a_of_type_JavaIoFile.listFiles(paramFileFilter));
  }
  
  public QFile[] a(FilenameFilter paramFilenameFilter)
  {
    return a(this.jdField_a_of_type_JavaIoFile.listFiles(paramFilenameFilter));
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_JavaIoFile.list();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_JavaIoFile.lastModified();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaIoFile.isDirectory()) {
      return Util4File.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
  }
  
  public boolean b()
  {
    return b(true);
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool2 = true;
    int i = 0;
    while (i < 2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoFile.exists()) {
          return true;
        }
        this.jdField_a_of_type_JavaIoFile.mkdirs();
        boolean bool3 = this.jdField_a_of_type_JavaIoFile.exists();
        bool1 = bool2;
        if (bool3) {
          return bool1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          MLog.a("QFile", localException);
        }
      }
      i += 1;
    }
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int < 3))
    {
      this.jdField_b_of_type_Int += 1;
      File localFile = this.jdField_a_of_type_JavaIoFile;
      if (k())
      {
        this.jdField_a_of_type_Boolean = true;
        bool1 = bool2;
        if (b(false)) {
          return bool1;
        }
        this.jdField_a_of_type_JavaIoFile = localFile;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_JavaIoFile.isDirectory()) {
      return Util4File.a(this.jdField_a_of_type_JavaIoFile.getPath());
    }
    return this.jdField_a_of_type_JavaIoFile.getPath();
  }
  
  public boolean c()
  {
    return c(true);
  }
  
  public boolean c(boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1;
    if (this.jdField_a_of_type_JavaIoFile.isDirectory()) {
      bool1 = b(paramBoolean);
    }
    label127:
    File localFile;
    do
    {
      return bool1;
      int i = 0;
      if (i < 2)
      {
        if (this.jdField_a_of_type_JavaIoFile.exists()) {}
        for (;;)
        {
          try
          {
            bool1 = this.jdField_a_of_type_JavaIoFile.delete();
            if (!bool1) {
              break label127;
            }
          }
          catch (Exception localException1)
          {
            try
            {
              bool2 = this.jdField_a_of_type_JavaIoFile.createNewFile();
              bool1 = bool3;
              if (bool2) {
                break;
              }
              i += 1;
            }
            catch (IOException localIOException)
            {
              MLog.a("QFile", localIOException);
            }
            localException1 = localException1;
            MLog.a("QFile", localException1);
            bool1 = false;
            continue;
          }
          try
          {
            this.jdField_a_of_type_JavaIoFile.getParentFile().mkdirs();
            bool1 = true;
          }
          catch (Exception localException2)
          {
            MLog.a("QFile", localException2);
            bool1 = true;
          }
          continue;
          boolean bool2 = false;
        }
      }
      if ((this.jdField_b_of_type_Boolean) || (!paramBoolean) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int >= 3)) {
        break;
      }
      this.jdField_b_of_type_Int += 1;
      localFile = this.jdField_a_of_type_JavaIoFile;
      if (!k()) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      bool1 = bool3;
    } while (c(false));
    this.jdField_a_of_type_JavaIoFile = localFile;
    return false;
  }
  
  public String d()
  {
    return Util4File.a(this.jdField_a_of_type_JavaIoFile.getParent());
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaIoFile.exists();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaIoFile.delete();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_JavaIoFile.isDirectory();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaIoFile.isFile();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaIoFile.canRead();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaIoFile.isHidden();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_JavaIoFile.canWrite();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaIoFile.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.storage.QFile
 * JD-Core Version:    0.7.0.1
 */