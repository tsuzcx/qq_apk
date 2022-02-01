package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Timer;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class PrinterItemMsgRecord
  extends MessageRecord
  implements Cloneable
{
  public static final String sTagleName = "mr_dataline_printer";
  public static final int status_New = 1;
  public static final int status_print_fail = 11;
  public static final int status_print_suc = 10;
  public static final int status_running = 2;
  public static final int status_transfer_fail = 12;
  public String filename;
  @notColumn
  public Timer mTimer_for_Print = null;
  public double progress = 0.0D;
  public int status = 1;
  public long uSessionID = 0L;
  
  public PrinterItemMsgRecord()
  {
    this.versionCode = 0;
  }
  
  public PrinterItemMsgRecord(long paramLong)
  {
    this.versionCode = 0;
    this.msgId = paramLong;
  }
  
  public static String tableName()
  {
    return "mr_dataline_printer";
  }
  
  public PrinterItemMsgRecord clone()
  {
    try
    {
      PrinterItemMsgRecord localPrinterItemMsgRecord = (PrinterItemMsgRecord)super.clone();
      return localPrinterItemMsgRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  protected Class getClassForTable()
  {
    return PrinterItemMsgRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_dataline_printer";
  }
  
  protected void postRead() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrinterItemMsgRecord
 * JD-Core Version:    0.7.0.1
 */