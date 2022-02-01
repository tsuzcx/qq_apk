package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eqe;
import eqf;
import eqg;
import eqh;
import eqi;
import eqk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileLabelEditorActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 7;
  public static final String a = "ProfileLabelEditorActivity";
  public float a;
  public Context a;
  public GridView a;
  public LinearLayout a;
  public TextView a;
  private CardObserver a;
  public Card a;
  public ProfileLabelPanel.LabelStatusManager a;
  public ProfileLabelPanel a;
  public eqk a;
  public List a;
  public boolean a;
  public List b = new ArrayList();
  public List c = new ArrayList();
  
  public ProfileLabelEditorActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new eqe(this);
  }
  
  private String a(String paramString)
  {
    paramString = this.jdField_a_of_type_AndroidContentContext.getAssets().open(paramString);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new byte[4096];
    for (;;)
    {
      int i = paramString.read((byte[])localObject, 0, 4096);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write((byte[])localObject, 0, i);
    }
    localObject = new String(localByteArrayOutputStream.toByteArray(), "utf-8");
    paramString.close();
    localByteArrayOutputStream.close();
    return localObject;
  }
  
  private List a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)this.app.getManager(49)).a(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqDataCard.getLabelList();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_Eqk = new eqk(this, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Eqk);
        a(this.jdField_a_of_type_JavaUtilList.size());
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(String paramString)
  {
    if (paramString != null)
    {
      paramString = new JSONArray(paramString);
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramString.optJSONObject(i);
        ProfileLabelTypeInfo localProfileLabelTypeInfo = new ProfileLabelTypeInfo();
        localProfileLabelTypeInfo.typeId = ((JSONObject)localObject).optString("id");
        localProfileLabelTypeInfo.typeName = ((JSONObject)localObject).optString("name");
        localProfileLabelTypeInfo.typeInfo = ((JSONObject)localObject).optString("classinfo");
        localObject = ((JSONObject)localObject).optJSONArray("taglist");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          ProfileLabelInfo localProfileLabelInfo = new ProfileLabelInfo();
          localProfileLabelInfo.labelId = Long.valueOf(localJSONObject.optLong("id"));
          localProfileLabelInfo.labelName = localJSONObject.optString("name");
          localProfileLabelInfo.typeId = localProfileLabelTypeInfo.typeId;
          localProfileLabelTypeInfo.labels.add(localProfileLabelInfo);
          j += 1;
        }
        this.b.add(localProfileLabelTypeInfo);
        i += 1;
      }
    }
  }
  
  private void a(List paramList)
  {
    this.c.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramList.next();
      this.c.add(localProfileLabelInfo.labelId);
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    Iterator localIterator1 = paramList2.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ProfileLabelTypeInfo)localIterator1.next()).labels.iterator();
      while (localIterator2.hasNext())
      {
        ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)localIterator2.next();
        localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_NORMAL;
        if (a(localProfileLabelInfo.labelId, paramList1)) {
          localProfileLabelInfo.labelStatus = ProfileLabelInfo.STATUS_CHECKED;
        }
      }
    }
    c(paramList2);
  }
  
  private void b()
  {
    if (a())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        b(2131367495);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileLabelEditorActivity", 2, "saveEdit save labes num = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_Boolean = true;
      ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    finish();
  }
  
  private void b(List paramList)
  {
    Object localObject = new File(BaseApplicationImpl.a().getFilesDir(), "labelList");
    if ((localObject == null) || (!((File)localObject).exists())) {
      d();
    }
    for (;;)
    {
      return;
      localObject = new ByteArrayInputStream(FileUtils.a((File)localObject));
      try
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject);
        this.b = ((List)localObjectInputStream.readObject());
        localObjectInputStream.close();
        ((ByteArrayInputStream)localObject).close();
        if (!b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileLabelEditorActivity", 2, "get available label list fail ");
          }
          d();
        }
        if (!b()) {
          continue;
        }
        a(paramList, this.b);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  private boolean b()
  {
    return (this.b != null) && (this.b.size() > 0);
  }
  
  private void c()
  {
    b(a(this.app.a()));
  }
  
  private void c(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel = new ProfileLabelPanel(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager, paramList, new eqg(this));
    paramList = new LinearLayout.LayoutParams(-1, (int)(204.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel, paramList);
  }
  
  private void d()
  {
    try
    {
      a(a("qvip_default_tags.json"));
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ProfileLabelInfo a(Long paramLong, List paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      localObject1 = paramList;
      if (localIterator.hasNext())
      {
        localObject1 = (ProfileLabelInfo)localIterator.next();
        if (!((ProfileLabelInfo)localObject1).labelId.equals(paramLong)) {
          break label61;
        }
        paramList = (List)localObject1;
      }
    }
    label61:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public void a()
  {
    setContentView(2130903415);
    getWindow().setBackgroundDrawable(null);
    setTitle(getString(2131367494));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296742));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297558));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297559));
    setRightButton(2131367088, new eqf(this));
    enableRightHighlight(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 7) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131367492) + " (" + paramInt + "/" + 7 + ")");
  }
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, List paramList)
  {
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (((ProfileLabelInfo)paramList.get(i)).labelId.equals(paramProfileLabelInfo.labelId)) {
          paramList.remove(i);
        }
        i += 1;
      }
    }
  }
  
  boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.c != null) && (this.jdField_a_of_type_JavaUtilList.size() == this.c.size()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)localIterator.next()).labelId);
      }
      if ((localArrayList.containsAll(this.c)) && (this.c.containsAll(localArrayList))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(Long paramLong, List paramList)
  {
    return a(paramLong, paramList) != null;
  }
  
  public boolean a(List paramList)
  {
    return paramList.size() >= 7;
  }
  
  public void b(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramInt, 1).b(getResources().getDimensionPixelSize(2131492923));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = new ProfileLabelPanel.LabelStatusManager();
    a();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = null;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (a())
    {
      DialogUtil.a(this, 230).setMessage(getString(2131367503)).setPositiveButton(2131365732, new eqi(this)).setNegativeButton(2131365733, new eqh(this)).show();
      return true;
    }
    finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity
 * JD-Core Version:    0.7.0.1
 */