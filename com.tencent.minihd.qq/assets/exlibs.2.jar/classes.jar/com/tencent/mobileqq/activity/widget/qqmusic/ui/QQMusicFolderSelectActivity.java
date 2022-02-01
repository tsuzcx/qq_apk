package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager.LoadFolderListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ExpandableListView.OnChildClickListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import hdm;
import hdn;
import hdq;
import hdt;
import hdu;
import java.util.ArrayList;

public class QQMusicFolderSelectActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private FolderListManager.LoadFolderListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener = new hdt(this);
  private FolderListAdapter jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiFolderListAdapter;
  private ExpandableListView.OnChildClickListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener = new hdu(this);
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ArrayList b;
  
  private QQAppInterface a()
  {
    try
    {
      QQAppInterface localQQAppInterface = BaseActivity.sTopActivity.app;
      return localQQAppInterface;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    setTitleBackground(1);
    ((TextView)findViewById(2131297348)).setText(2131365004);
    findViewById(2131297358).setVisibility(8);
    c();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 2;
    }
    for (;;)
    {
      ReportController.b(a(), "CliOper", "", "", "0X8006283", "0X8006283", paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {
      return false;
    }
    this.jdField_a_of_type_Long = l;
    return true;
  }
  
  private void b()
  {
    findViewById(2131297357).setOnClickListener(new hdm(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131300165));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiFolderListAdapter = new FolderListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiFolderListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, this.b);
    Object localObject = LayoutInflater.from(this);
    View localView = ((LayoutInflater)localObject).inflate(2130903948, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    localView.findViewById(2131300169).setOnClickListener(new hdn(this));
    localView.findViewById(2131300171).setOnClickListener(new hdq(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(localView);
    localObject = ((LayoutInflater)localObject).inflate(2130903947, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.b((View)localObject);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiFolderListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnChildClickListener(this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnChildClickListener);
  }
  
  private void d()
  {
    FolderListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener);
    FolderListManager.a().a(this);
  }
  
  private void e()
  {
    ReportController.b(a(), "CliOper", "", "", "0X8006283", "0X8006283", 1, 0, "", "", "", "");
  }
  
  private void f()
  {
    ReportController.b(a(), "CliOper", "", "", "0X8006283", "0X8006283", 0, 0, "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2130903946);
    a();
    b();
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity
 * JD-Core Version:    0.7.0.1
 */