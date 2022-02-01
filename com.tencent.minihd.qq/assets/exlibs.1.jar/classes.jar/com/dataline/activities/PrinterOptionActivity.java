package com.dataline.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new cn(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  static void a(FormSimpleItem paramFormSimpleItem, float paramFloat, Context paramContext)
  {
    paramFormSimpleItem.setBgType(0);
    paramFormSimpleItem.a().setTextColor(-16777216);
    paramFormSimpleItem.b().setTextColor(-16777216);
    if (paramFloat != 0.0F)
    {
      paramFormSimpleItem.a().setTextSize(paramFloat);
      paramFormSimpleItem.b().setTextSize(paramFloat);
    }
    paramFormSimpleItem.setBackgroundDrawable(paramContext.getResources().getDrawable(2130837732));
  }
  
  private void a(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean a()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(9);
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362204);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
    }
    for (;;)
    {
      return false;
      if (localRegisterProxySvcPackHandler.a() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362201);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362203);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
      }
      else if (!a(false))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362200);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
      else
      {
        if (b()) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131362202);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = "";
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
      return false;
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList.size() > 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((String)((Iterator)localObject).next()).equals(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = null;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h == null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = ((String)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = getString(2131362200);
      }
      for (paramBoolean = false;; paramBoolean = true)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
        return paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = null;
        break;
      }
    }
  }
  
  private boolean b()
  {
    int j;
    int i;
    boolean bool;
    int k;
    label174:
    int m;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a() == null) {
        break label308;
      }
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      j = 1;
      i = 1;
      bool = false;
      if (!localIterator1.hasNext()) {
        break label299;
      }
      String str = ((FileInfo)localIterator1.next()).e().toLowerCase();
      Iterator localIterator2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.b.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator2.next();
          if (str.endsWith("." + localSupportFileInfo.str_file_suffix.get())) {
            if (localSupportFileInfo.uint32_copies.get() == 1)
            {
              k = 1;
              if (localSupportFileInfo.uint32_duplex.get() != 1) {
                break label253;
              }
              m = 1;
              label189:
              m &= j;
              j = i & k;
              bool = true;
              i = m;
              label205:
              if (bool) {
                break label259;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (i != 0)
      {
        this.c.setVisibility(8);
        return bool;
        k = 0;
        break label174;
        label253:
        m = 0;
        break label189;
        label259:
        k = j;
        j = i;
        i = k;
        break;
        i = 0;
        j = 0;
        bool = false;
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return bool;
      k = i;
      i = j;
      j = k;
      break label205;
      label299:
      k = i;
      i = j;
      j = k;
      continue;
      label308:
      i = 1;
      j = 1;
      bool = false;
    }
  }
  
  void a()
  {
    boolean bool = true;
    Object localObject = getString(2131362187) + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Int > 1) {}
    for (;;)
    {
      ((View)localObject).setEnabled(bool);
      return;
      bool = false;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 103) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h = paramIntent.getStringExtra("sPrinterName");
      a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("sFilesSelected");
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903241);
    setTitle(2131362192);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297442));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296424, "n/a");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297443));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 19.0F, this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297418));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297409));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297444));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297445);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297446);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131297450));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297447));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)findViewById(2131297449));
    a(true);
    b();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem) {
      a(true);
    }
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break;
        }
      } while (!a());
      paramView = new Intent();
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("printCopies", this.jdField_a_of_type_Int);
          if (!this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.isChecked()) {
            continue;
          }
          localJSONObject.put("duplexMode", 2);
          localJSONObject.put("printerName", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.h);
          paramView.putExtra("sPrintParam", localJSONObject.toString());
          paramView.putParcelableArrayListExtra("sFilesSelected", this.jdField_a_of_type_JavaUtilArrayList);
          paramView.putExtra(AlbumConstants.i, getIntent().getIntExtra(AlbumConstants.i, 0));
        }
        catch (JSONException localJSONException)
        {
          JSONObject localJSONObject;
          continue;
        }
        setResult(-1, paramView);
        finish();
        ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
        return;
        localJSONObject.put("duplexMode", 1);
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_Int = Math.max(1, this.jdField_a_of_type_Int);
        a();
        return;
      }
    } while (paramView != this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Int += 1;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity
 * JD-Core Version:    0.7.0.1
 */