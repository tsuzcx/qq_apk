package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jbr;

public class QfileEditBottomBar
  extends RelativeLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray a;
  Button jdField_a_of_type_AndroidWidgetButton;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  final String jdField_a_of_type_JavaLangString = "QfileEditBottomBar";
  Button b;
  Button c;
  Button d;
  Button e;
  
  public QfileEditBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileEditBottomBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903748, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299488));
    this.b = ((Button)findViewById(2131299489));
    this.c = ((Button)findViewById(2131299491));
    this.d = ((Button)findViewById(2131299490));
    this.e = ((Button)findViewById(2131299492));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void c()
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, ForwardRecentActivity.class);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = FMDataCache.b();
    Object localObject2 = FMDataCache.c();
    Object localObject1 = FMDataCache.e();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FileInfo)((Iterator)localObject3).next();
        FileManagerEntity localFileManagerEntity = FileManagerUtil.a((FileInfo)localObject4);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10000);
        localForwardFileInfo.d(localFileManagerEntity.cloudType);
        localForwardFileInfo.b(localFileManagerEntity.nSessionId);
        localForwardFileInfo.d(localFileManagerEntity.fileName);
        localForwardFileInfo.c(localFileManagerEntity.uniseq);
        localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
        localForwardFileInfo.d(localFileManagerEntity.fileSize);
        localForwardFileInfo.a(localFileManagerEntity.strFilePath);
        localForwardFileInfo.b(localFileManagerEntity.Uuid);
        localArrayList2.add(Uri.parse(((FileInfo)localObject4).d()));
        localArrayList1.add(localForwardFileInfo);
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
        localObject4 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject4).b(10001);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).cloudType);
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).nSessionId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileName);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).uniseq);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject3).WeiYunFileId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject3).fileSize);
        ((ForwardFileInfo)localObject4).a(((FileManagerEntity)localObject3).strFilePath);
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject3).Uuid);
        if ((((FileManagerEntity)localObject3).cloudType == 3) && (((FileManagerEntity)localObject3).strFilePath != null) && (((FileManagerEntity)localObject3).strFilePath.length() > 0)) {
          localArrayList2.add(Uri.parse(((FileManagerEntity)localObject3).strFilePath));
        }
        for (;;)
        {
          localArrayList1.add(localObject4);
          break;
          localArrayList2.add(Uri.parse(""));
        }
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localIntent.putExtra("k_dataline", false);
      localObject2 = ((List)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeiYunFileInfo)((Iterator)localObject2).next();
        localObject1 = FileManagerUtil.a((WeiYunFileInfo)localObject3);
        localObject4 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject4).b(10003);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject1).cloudType);
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject4).c(((FileManagerEntity)localObject1).WeiYunFileId);
        ((ForwardFileInfo)localObject4).d(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject4).a(((FileManagerEntity)localObject1).strFilePath);
        ((ForwardFileInfo)localObject4).b(((FileManagerEntity)localObject1).Uuid);
        localArrayList1.add(localObject4);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((WeiYunFileInfo)localObject3).jdField_a_of_type_JavaLangString);
        if (localObject1 != null) {
          break label889;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((WeiYunFileInfo)localObject3).jdField_a_of_type_JavaLangString);
      }
    }
    label889:
    for (;;)
    {
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).strFilePath != null) && (((FileManagerEntity)localObject1).strFilePath.length() > 0))
      {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject1).strFilePath));
        break;
      }
      localArrayList2.add(Uri.parse(""));
      break;
      localBundle.putInt("forward_type", 0);
      localBundle.putParcelableArrayList("fileinfo_array", localArrayList1);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtra("sendMultiple", true);
      localBundle.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("foward_editbar", true);
      localIntent.putExtra("forward_type", 0);
      localObject1 = "转发文件";
      if (localArrayList1.size() == 1) {
        localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
      }
      for (;;)
      {
        localIntent.putExtra("forward_text", (String)localObject1);
        localIntent.putExtra("display_like_dialog", true);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.startActivityForResult(localIntent, 103);
        return;
        if (localArrayList1.size() > 1) {
          localObject1 = "已选择" + FileManagerUtil.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "等" + localArrayList1.size() + "个文件。";
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (FMDataCache.a() > 0L) {}
    int i;
    int j;
    int n;
    FileManagerEntity localFileManagerEntity;
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject).setEnabled(bool);
      localObject = FMDataCache.c().iterator();
      i = 0;
      j = 0;
      n = 0;
      if (((Iterator)localObject).hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((localFileManagerEntity.cloudType != 3) && (localFileManagerEntity.cloudType != 5)) {
          break label296;
        }
        if (j == 0) {
          break;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QfileEditBottomBar", 4, "changeSelectCount nLocal[" + n + "] WeiYun [" + FileManagerUtil.a(localFileManagerEntity) + "]");
        }
      }
      label136:
      if (FMDataCache.a() != n) {
        break label382;
      }
      i = 1;
      label148:
      if (FMDataCache.a() != j) {
        break label387;
      }
      j = 1;
      label159:
      localObject = this.b;
      if (i != 0) {
        break label392;
      }
      bool = true;
      label172:
      ((Button)localObject).setEnabled(bool);
      localObject = this.c;
      if (j != 0) {
        break label398;
      }
      bool = true;
      label192:
      ((Button)localObject).setEnabled(bool);
      if (FMDataCache.a() <= 0L) {
        break label404;
      }
      this.e.setTextColor(getResources().getColor(2131428000));
      this.e.setEnabled(true);
      this.d.setEnabled(true);
      return;
    }
    int m = n + 1;
    int k = j;
    label255:
    if ((localFileManagerEntity.cloudType == 3) && (localFileManagerEntity.strFilePath != null) && (localFileManagerEntity.strFilePath.length() > 0)) {
      i += 1;
    }
    for (;;)
    {
      j = k;
      n = m;
      break;
      label296:
      k = j;
      m = n;
      if (localFileManagerEntity.cloudType != 2) {
        break label255;
      }
      if (n != 0)
      {
        if (!QLog.isDevelopLevel()) {
          break label136;
        }
        QLog.d("QfileEditBottomBar", 4, "changeSelectCount nWeiYun [" + j + "], Local[" + FileManagerUtil.a(localFileManagerEntity) + "]");
        break label136;
      }
      k = j + 1;
      m = n;
      break label255;
      label382:
      i = 0;
      break label148;
      label387:
      j = 0;
      break label159;
      label392:
      bool = false;
      break label172;
      label398:
      bool = false;
      break label192;
      label404:
      this.e.setTextColor(-5855578);
      this.e.setEnabled(false);
      this.d.setEnabled(false);
      return;
    }
  }
  
  void a(View paramView)
  {
    Object localObject = new ArrayList();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      ((List)localObject).add(Integer.valueOf(2131362524));
      ((List)localObject).add(Integer.valueOf(2131362527));
    }
    for (;;)
    {
      paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null);
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localInteger);
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(localInteger.intValue()), 3);
        i += 1;
      }
      ((List)localObject).add(Integer.valueOf(2131362525));
      continue;
      ((List)localObject).add(Integer.valueOf(2131362526));
    }
    paramView.a(new jbr(this, paramView));
    paramView.e(2131365736);
    paramView.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
        } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.b();
        return;
        if (QLog.isColorLevel()) {
          QLog.i("QfileEditBottomBar", 2, "downLoadAllSelectFiles,weiyun[" + FMDataCache.e().size() + "], offline[" + FMDataCache.d().size() + "], recent[" + FMDataCache.c().size() + "], localfile[" + FMDataCache.b().size() + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.c();
        }
        FMDataCache.b();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.d();
        }
        FMDataCache.b();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      } while (paramView.size() <= 0);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.get(0);
      if (paramView.size() > 1)
      {
        FMToastUtil.b(FileManagerUtil.d(localFileManagerEntity.fileName) + "等" + paramView.size() + "个文件" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362432));
        return;
      }
      FMToastUtil.b(FileManagerUtil.d(localFileManagerEntity.fileName) + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362432));
      return;
      c();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.e();
      }
      FMDataCache.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b();
      return;
      a(paramView);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51.f();
  }
  
  public void setActivity(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    int j = 0;
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramBoolean1)
    {
      i = 0;
      localButton.setVisibility(i);
      localButton = this.b;
      if (!paramBoolean2) {
        break label114;
      }
      i = 0;
      label36:
      localButton.setVisibility(i);
      localButton = this.c;
      if (!paramBoolean3) {
        break label121;
      }
      i = 0;
      label56:
      localButton.setVisibility(i);
      localButton = this.d;
      if (!paramBoolean4) {
        break label128;
      }
      i = 0;
      label77:
      localButton.setVisibility(i);
      localButton = this.e;
      if (!paramBoolean5) {
        break label135;
      }
    }
    label128:
    label135:
    for (int i = j;; i = 8)
    {
      localButton.setVisibility(i);
      return;
      i = 8;
      break;
      label114:
      i = 8;
      break label36;
      label121:
      i = 8;
      break label56;
      i = 8;
      break label77;
    }
  }
  
  public void setTabType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar
 * JD-Core Version:    0.7.0.1
 */