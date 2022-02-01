package com.tencent.mobileqq.filemanager.fileviewer.report;

import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewReport;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

public class FileClickReport
  implements BaseActionBar.IActionBarClickEvent, IFileViewReport
{
  private boolean a;
  
  public FileClickReport(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBE");
      return;
    }
    FileManagerReporter.a("0X8004BD4");
  }
  
  public void b()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC2");
      return;
    }
    FileManagerReporter.a("0X8004BD8");
  }
  
  public void b(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (str != null) {
        FileManagerReporter.a(str);
      }
      return;
      if (this.a)
      {
        str = "0X8004BB5";
      }
      else
      {
        str = "0X8004BCA";
        continue;
        if (this.a) {
          str = "0X8004BB4";
        } else {
          str = "0X8004BC9";
        }
      }
    }
  }
  
  public void c()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBF");
      return;
    }
    FileManagerReporter.a("0X8004BD5");
  }
  
  public void d()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC0");
      return;
    }
    FileManagerReporter.a("0X8004BD6");
  }
  
  public void e()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC6");
      return;
    }
    FileManagerReporter.a("0X8004BDC");
  }
  
  public void f()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC3");
      return;
    }
    FileManagerReporter.a("0X8004BD9");
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC5");
      return;
    }
    FileManagerReporter.a("0X8004BDB");
  }
  
  public void j()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC4");
      return;
    }
    FileManagerReporter.a("0X8004BDA");
  }
  
  public void k()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BBD");
      return;
    }
    FileManagerReporter.a("0X8004BD3");
  }
  
  public void l()
  {
    if (this.a)
    {
      FileManagerReporter.a("0X8004BC1");
      return;
    }
    FileManagerReporter.a("0X8004BD7");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.report.FileClickReport
 * JD-Core Version:    0.7.0.1
 */