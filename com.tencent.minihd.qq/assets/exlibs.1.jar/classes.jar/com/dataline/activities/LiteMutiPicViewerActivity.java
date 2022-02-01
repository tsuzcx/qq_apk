package com.dataline.activities;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bw;
import bx;
import by;
import cf;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiteMutiPicViewerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, WaitTextView.RefreshListener
{
  private static final int jdField_a_of_type_Int = 3;
  public static final String a = "dataline_group_id";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private cf jdField_a_of_type_Cf;
  private WaitTextView jdField_a_of_type_ComDatalineUtilWidgetWaitTextView;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new by(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  private int f;
  
  private int a(Activity paramActivity)
  {
    return paramActivity.getWindowManager().getDefaultDisplay().getWidth();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131297432));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299392));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299393));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299478));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427934));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297422));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299479));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = new WaitTextView(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setRefreshListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setGravity(17);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextColor(getResources().getColor(2131427975));
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setPadding(0, 0, 0, AIOUtils.a(50.0F, getResources()));
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(a(this), -2);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(3);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.e * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.d * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.f, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.f, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_Cf = new cf(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Cf);
    c();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isCanReciveOrResend()) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362422);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Cf.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131362421);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        d();
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalProcess() * 100.0F));
    String str = "(" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getCompletedCount() + "/" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() + ")";
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {}
    for (int i = 2131362423;; i = 2131362424)
    {
      str = getString(i) + str;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void e()
  {
    setTitle(2131362134);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private void f()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.f = getResources().getDimensionPixelSize(2131493054);
    this.d = getResources().getDimensionPixelSize(2131493052);
    this.e = getResources().getDimensionPixelSize(2131493053);
    this.jdField_b_of_type_Int = ((localDisplay.getWidth() - this.f * 2 - this.d * 2) / 3);
    this.c = this.jdField_b_of_type_Int;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setText(String.format(getString(2131362144), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) }));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut()) && (this.jdField_a_of_type_Cf != null)) {
      this.jdField_a_of_type_Cf.notifyDataSetChanged();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903746);
    int i = getIntent().getIntExtra("dataline_group_id", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a(i);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    f();
    b();
    e();
    g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.app.a() != null) {
      this.app.a().e();
    }
  }
  
  public void onClick(View paramView)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299393: 
      if (NetworkUtil.e(this))
      {
        if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFileTotalSize() > 5242880L))
        {
          paramView = new bw(this, localDataLineHandler);
          localObject1 = new bx(this);
          if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal())
          {
            DialogUtil.a(this, 230, getString(2131362055), getString(2131362465), 2131365736, 2131362063, paramView, (DialogInterface.OnClickListener)localObject1).show();
            return;
          }
          DialogUtil.a(this, 230, getString(2131362058), getString(2131362466), 2131365736, 2131362063, paramView, (DialogInterface.OnClickListener)localObject1).show();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
          DataLineReportUtil.p(this.app);
        }
        localObject1 = null;
        paramView = null;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
        while (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          DLFileInfo localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
          if (localDLFileInfo.a == 1)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localDataLineMsgRecord);
            localObject1 = localObject2;
          }
          else
          {
            if (localDLFileInfo.a != 4)
            {
              localObject2 = paramView;
              if (localDLFileInfo.a != 2) {}
            }
            else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
            {
              if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                break label397;
              }
              DataLineReportUtil.d(this.app);
            }
            for (;;)
            {
              localObject2 = paramView;
              if (paramView == null) {
                localObject2 = new ArrayList();
              }
              ((List)localObject2).add(Long.valueOf(localDataLineMsgRecord.sessionid));
              localDataLineMsgRecord.fileMsgStatus = 0L;
              this.app.a().a().c(localDataLineMsgRecord.msgId);
              paramView = (View)localObject2;
              break;
              label397:
              DataLineReportUtil.e(this.app);
            }
          }
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          localDataLineHandler.a((ArrayList)localObject1, true);
        }
        if ((paramView != null) && (paramView.size() > 0)) {
          localDataLineHandler.a(paramView);
        }
        c();
        return;
      }
      FMToastUtil.a(2131367136);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
      DataLineReportUtil.o(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        DataLineReportUtil.m(this.app);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label595;
      }
      localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, false);
    }
    for (;;)
    {
      c();
      return;
      DataLineReportUtil.k(this.app);
      break;
      label595:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (paramView.hasNext())
      {
        localObject1 = (DataLineMsgRecord)paramView.next();
        localObject2 = DatalineFilesAdapter.a((DataLineMsgRecord)localObject1);
        if ((((DLFileInfo)localObject2).a == 0) || (((DLFileInfo)localObject2).a == 3)) {
          localDataLineHandler.a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */