package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import dxj;
import dxk;
import dxl;
import dxm;
import dxn;
import dxo;
import dxp;
import dxq;
import dxr;
import dxs;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final String jdField_a_of_type_JavaLangString = "EmosmActivity";
  public static final String b = "extra_launch_source";
  public static final int c = 1;
  public static final String c = "extra_launch_mode";
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 2;
  public static final int i = 0;
  public static final int j = 1;
  public int a;
  public Button a;
  public TextView a;
  EmosmObserver jdField_a_of_type_ComTencentMobileqqAppEmosmObserver = new dxj(this);
  public DragSortAdapter a;
  DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new dxr(this);
  DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new dxs(this);
  public DragSortListView a;
  EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  public EmoticonManager a;
  public QQProgressDialog a;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new dxk(this);
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public Runnable a;
  public WeakReference a;
  public ArrayList a;
  public boolean a;
  public int b;
  TextView b;
  public boolean b;
  TextView c;
  public boolean c;
  public int g;
  public int h;
  
  public EmosmActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.setDragHandleId(2131296303);
    paramDragSortListView.setClickRemoveId(2131296304);
    paramDragSortListView.setRemoveEnabled(true);
    paramDragSortListView.setSortEnabled(true);
    paramDragSortListView.setDragInitMode(0);
    paramDragSortListView.setRemoveMode(0);
    paramDragSortListView.setRemoveOrientation(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearSelectStatus();
    }
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.h == 1)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((!localEmoticonPackage.epId.equals("100000")) && (3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.h == 2)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((3 == localEmoticonPackage.jobType) && (!localEmoticonPackage.epId.equals("100000"))) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.jobType == 2))
    {
      EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramEmoticonPackage.kinId);
      if ((localEmoticonPackage != null) && (localEmoticonPackage.kinId != null) && (localEmoticonPackage.kinId.length() > 0))
      {
        localEmoticonPackage.kinId = null;
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmoticonPackage);
      }
      ReportController.b(this.app, "CliOper", "", "", "qface_emoji", "delete_qfpkg", 0, 0, paramEmoticonPackage.kinId, "", "", "");
    }
  }
  
  public void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      if (paramString.listFiles().length == 0) {
        paramString.delete();
      }
    }
    while (!paramString.exists())
    {
      return;
      File[] arrayOfFile = paramString.listFiles();
      int m = arrayOfFile.length;
      int k = 0;
      while (k < m)
      {
        a(arrayOfFile[k].getAbsolutePath());
        k += 1;
      }
      paramString.delete();
      return;
    }
    paramString.delete();
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      EmoticonPackage localEmoticonPackage;
      if (1 == this.h)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b().iterator();
        while (localIterator.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if ((localEmoticonPackage.type == 1) && (!"100000".equals(localEmoticonPackage.epId))) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
        }
      }
      if (2 == this.h)
      {
        localIterator = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b().iterator();
        while (localIterator.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if ((localEmoticonPackage.type != 1) || ("100000".equals(localEmoticonPackage.epId))) {
            localArrayList1.add(localEmoticonPackage.epId);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add(((EmoticonPackage)localIterator.next()).epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add(((EmoticonPackage)localIterator.next()).epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localArrayList1);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(localArrayList2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903305);
    super.setContentBackgroundResource(2130837687);
    super.setTitle(2131368457);
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368459);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new dxl(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297617));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297619));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new dxm(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)super.findViewById(2131297618));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131368597));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131368598));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    EmoticonPackage localEmoticonPackage;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.app.getManager(13));
      this.jdField_a_of_type_JavaLangRunnable = new dxn(this);
      paramBundle = getIntent();
      this.h = paramBundle.getIntExtra("extra_launch_mode", 1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label460;
      }
      if (this.h == 1)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
          if ((!localEmoticonPackage.epId.equals("100000")) && (1 != localEmoticonPackage.type) && (1 != localEmoticonPackage.jobType)) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.h != 2) {
        break label460;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = null;
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, paramBundle.getMessage());
      }
      return false;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
      if ((1 == localEmoticonPackage.type) && (!localEmoticonPackage.epId.equals("100000"))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
      }
    }
    label460:
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter = new DragSortAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new dxo(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new dxp(this);
    localObject = (EmojiManager)this.app.getManager(42);
    ((EmojiManager)localObject).a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new dxq(this);
    ((EmojiManager)localObject).a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.g = paramBundle.getIntExtra("extra_launch_source", 2);
    if ((this.g == 2) || (this.g == 1))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368459);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(42);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("back_from_emojimall", false))) {}
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmosmObserver);
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((EmosmHandler)this.app.a(11)).a(0, 0);
      k += 1;
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    EmojiManager localEmojiManager = (EmojiManager)this.app.getManager(42);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    localEmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearCache();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.removeUpdateListeners();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.removeDownloadListeners();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!NetworkUtil.e(this))
    {
      paramView = new QQToast(this);
      paramView.a(2130838220);
      paramView.c(1500);
      paramView.a("无网络连接，删除失败");
      paramView.b(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131368476));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getSelectedPackages();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = ((List)localObject).size();
    paramView = (EmosmHandler)this.app.a(11);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
      paramView.a(Integer.parseInt(localEmoticonPackage.epId));
      ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
      if (localEmoticonPackage.jobType == 3) {
        ReportController.b(this.app, "CliOper", "", "", "0X80065A8", "0X80065A8", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "CliOper", "", "", "0X8006646", "0X8006646", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */