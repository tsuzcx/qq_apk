package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import gqm;
import gqn;
import gqo;
import gqp;
import gqq;
import gqr;
import gqt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  public static final String a = "k_name";
  public static final String b = "k_code";
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private gqp jdField_a_of_type_Gqp;
  public gqt a;
  public ArrayList a;
  public LinkedHashMap a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public View b;
  private View c;
  
  public CountryActivity()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void a(View paramView, gqq paramgqq)
  {
    paramView = (gqr)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramgqq.b);
    paramView.b.setText("+" + paramgqq.c);
    paramView.jdField_a_of_type_Gqq = paramgqq;
  }
  
  private static View b(LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903401, null);
    if (paramBoolean) {
      paramLayoutInflater.setPadding(paramLayoutInflater.getPaddingLeft(), paramLayoutInflater.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.a, 40.0F), paramLayoutInflater.getPaddingBottom());
    }
    gqr localgqr = new gqr(null);
    localgqr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131298109));
    localgqr.b = ((TextView)paramLayoutInflater.findViewById(2131298085));
    paramLayoutInflater.setTag(localgqr);
    return paramLayoutInflater;
  }
  
  public void a(View paramView)
  {
    paramView = (gqr)paramView.getTag();
    if (paramView.jdField_a_of_type_Gqq != null)
    {
      if ((this.jdField_a_of_type_Gqt != null) && (this.jdField_a_of_type_Gqt.isShowing())) {
        this.jdField_a_of_type_Gqt.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Gqq.b);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Gqq.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.m();
    localPinnedDividerListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue() + i);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903399);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230798);
    paramBundle = this.jdField_a_of_type_ArrayOfJavaLangString;
    Object localObject1 = getResources().getStringArray(2131230797);
    String[] arrayOfString = getResources().getStringArray(2131230796);
    Object localObject2 = getResources().getStringArray(2131230795);
    paramBundle = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length + arrayOfString.length];
    System.arraycopy(arrayOfString, 0, paramBundle, 0, arrayOfString.length);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangString, 0, paramBundle, arrayOfString.length, this.jdField_a_of_type_ArrayOfJavaLangString.length);
    arrayOfString = new String[localObject1.length + localObject2.length];
    System.arraycopy(localObject2, 0, arrayOfString, 0, localObject2.length);
    System.arraycopy(localObject1, 0, arrayOfString, localObject2.length, localObject1.length);
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = paramBundle[i];
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(0));
      i += 1;
    }
    localObject2 = new ArrayList(paramBundle.length);
    paramBundle = "#";
    j = arrayOfString.length;
    i = 0;
    gqq localgqq;
    if (i < j)
    {
      localgqq = new gqq(arrayOfString[i]);
      localObject1 = localgqq.a;
      if (paramBundle.equals(localObject1)) {
        break label615;
      }
      ((ArrayList)localObject2).add(new gqq((String)localObject1));
      paramBundle = (Bundle)localObject1;
    }
    label610:
    label615:
    for (;;)
    {
      ((ArrayList)localObject2).add(localgqq);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue() + 1));
      i += 1;
      break;
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      if (paramBundle.hasNext())
      {
        localObject1 = (String)paramBundle.next();
        j = ((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).intValue();
        if (j == 0) {
          break label610;
        }
      }
      for (j = j + i + 1;; j = i)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, Integer.valueOf(i));
        i = j;
        break;
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        setTitle("选择国家和地区");
        this.leftView.setText(2131366374);
        this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131297347).getParent());
        this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298108));
        this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130904390, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.c.setPadding(0, 0, 40, 0);
        this.c.findViewById(2131299461).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131299473));
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a(this.c);
        this.jdField_a_of_type_Gqp = new gqp(this, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Gqp);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298099));
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(this.jdField_a_of_type_ArrayOfJavaLangString, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
        ChnToSpell.a(this);
        return true;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Gqt = new gqt(this, this);
      this.jdField_a_of_type_Gqt.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new gqm(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new gqn(this, i));
      this.jdField_a_of_type_Gqt.setOnDismissListener(new gqo(this, i, localTranslateAnimation));
      this.b.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */