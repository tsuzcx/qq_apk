package com.dataline.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cm;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.open.pcpush.OpenFileUtil;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrinterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String a;
  public ViewGroup a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  public ScrollerRunnable a;
  public XListView a;
  private LinearLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterActivity";
  }
  
  public PrinterActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = null;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 56) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getParcelableArrayListExtra("sFilesSelected");
        localObject = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject).setClass(this, PrinterOptionActivity.class);
        ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramIntent);
        ((Intent)localObject).putExtra(AlbumConstants.i, paramInt1);
        startActivityForResult((Intent)localObject, 102);
      }
    }
    while ((paramInt1 != 102) || (paramInt2 != -1)) {
      return;
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    String str = paramIntent.getStringExtra("sPrintParam");
    Iterator localIterator = ((ArrayList)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!new File(((FileInfo)localIterator.next()).d()).exists());
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        LiteActivity.a(this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a((ArrayList)localObject, "printer", str.getBytes(), Long.valueOf(this.app.a()).longValue());
      switch (paramIntent.getIntExtra(AlbumConstants.i, 0))
      {
      default: 
        label220:
        if (localObject != null) {
          paramIntent = ((ArrayList)localObject).iterator();
        }
        break;
      }
      while (paramIntent.hasNext())
      {
        localObject = (FileInfo)paramIntent.next();
        if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".txt" }))
        {
          ReportController.b(this.app, "CliOper", "", "", "0X800401A", "0X800401A", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.app, "CliOper", "", "", "0X800405C", "0X800405C", 0, 0, "", "", "", "");
          break label220;
          ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
          break label220;
          ReportController.b(this.app, "CliOper", "", "", "0X800405B", "0X800405B", 0, 0, "", "", "", "");
          break label220;
          break;
        }
        if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".doc", ".docx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401B", "0X800401B", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".ppt", ".pptx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401C", "0X800401C", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".xls", ".xlsx" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401D", "0X800401D", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".jpg", ".png", ".jpeg", ".bmp" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401E", "0X800401E", 0, 0, "", "", "", "");
        } else if (OpenFileUtil.a(((FileInfo)localObject).e().toLowerCase(), new String[] { ".pdf" })) {
          ReportController.b(this.app, "CliOper", "", "", "0X800401F", "0X800401F", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "CliOper", "", "", "0X8004020", "0X8004020", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903239);
    setTitle(2131362097);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)findViewById(2131297434));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296424, "n/a");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297435));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.b = ((LinearLayout)findViewById(2131297437));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a = new PrinterSessionAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297394));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a);
    paramBundle = LayoutInflater.from(this).inflate(2130903177, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130840064));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new cm(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a = null;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a.notifyDataSetChanged();
    LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView);
    LiteActivity.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    Object localObject1 = getIntent();
    int i = ((Intent)localObject1).getIntExtra(AlbumConstants.i, -1);
    if ((55 == i) || (i == 57))
    {
      ((Intent)localObject1).removeExtra(AlbumConstants.i);
      Object localObject2 = ((Intent)localObject1).getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          ((ArrayList)localObject1).add(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException) {}
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = new Intent(this, PrinterOptionActivity.class);
        ((Intent)localObject2).putExtra(AlbumConstants.i, i);
        ((Intent)localObject2).putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
        startActivityForResult((Intent)localObject2, 102);
      }
    }
    else
    {
      return;
    }
    LiteActivity.a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297435)
    {
      paramView = new Intent(getApplicationContext(), FMLocalFileActivity.class);
      paramView.putExtra("category", 6);
      paramView.putExtra("busiType", 5);
      paramView.putExtra("selectMode", true);
      paramView.putExtra("targetUin", AppConstants.Z);
      paramView.putExtra("peerType", 6001);
      paramView.putExtra("STRING_Show_Music_Category", false);
      paramView.putExtra("STRING_Show_Video_Category", false);
      paramView.putExtra("STRING_Show_Apk_Category", false);
      paramView.putExtra("STRING_Show_Pic_Category", false);
      paramView.putExtra("STRING_SingleSelect", true);
      paramView.putExtra(AlbumConstants.i, 56);
      paramView.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a());
      startActivityForResult(paramView, 56);
      AlbumUtil.a(this, false, true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
    }
    while (i != 2131297437) {
      return;
    }
    paramView = new Intent(this, PhotoListActivity.class);
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
    paramView.putExtra("busiType", 5);
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    paramView.putExtra(AlbumConstants.i, 57);
    paramView.putExtra("uin", AppConstants.Z);
    paramView.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramView.getExtras().remove("forward_type");
    paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramView.putExtra("STRING_Show_Within_Suffixs", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a());
    startActivity(paramView);
    AlbumUtil.a(this, false, true);
    ReportController.b(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterActivity
 * JD-Core Version:    0.7.0.1
 */