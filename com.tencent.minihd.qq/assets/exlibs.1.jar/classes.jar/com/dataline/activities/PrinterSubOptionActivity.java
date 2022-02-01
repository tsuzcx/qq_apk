package com.dataline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import co;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public PrinterSubOptionActivity.PrinterItemAdapter a;
  public DataLineHandler a;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new co(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  public List a;
  public boolean a;
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903242);
    setTitle(2131362193);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter = new PrinterSubOptionActivity.PrinterItemAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297451));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296424, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    setLeftViewName(2131366374);
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296424, "n/a");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131362206);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler);
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */