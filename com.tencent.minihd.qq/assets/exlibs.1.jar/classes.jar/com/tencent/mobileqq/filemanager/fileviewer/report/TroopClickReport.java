package com.tencent.mobileqq.filemanager.fileviewer.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewReport;
import com.tencent.mobileqq.statistics.ReportController;

public class TroopClickReport
  implements BaseActionBar.IActionBarClickEvent, IFileViewReport
{
  public static final String a = "Grp_files";
  public static final String b = "0";
  public static final String c = "1";
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String d;
  
  public TroopClickReport(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    if (paramBoolean)
    {
      this.d = "1";
      return;
    }
    this.d = "0";
  }
  
  public void a()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_share", 0, 0, this.jdField_a_of_type_Long + "", this.d, "", "");
  }
  
  public void b()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_more", 0, 0, this.jdField_a_of_type_Long + "", this.d, "", "");
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
  
  public void c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_share_fri", 0, 0, this.jdField_a_of_type_Long + "", this.d, "", "");
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_ftf", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void e()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_weiyun", 0, 0, this.jdField_a_of_type_Long + "", this.d, "", "");
  }
  
  public void f()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_pc", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void g()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_qqmusic", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void h()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_qqbrowser", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void i()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_print", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void j()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_mobile", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void k()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_other", 0, 0, this.jdField_a_of_type_Long + "", "", "", "");
  }
  
  public void l()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "in_mid", "Clk_save", 0, 0, this.jdField_a_of_type_Long + "", this.d, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.report.TroopClickReport
 * JD-Core Version:    0.7.0.1
 */