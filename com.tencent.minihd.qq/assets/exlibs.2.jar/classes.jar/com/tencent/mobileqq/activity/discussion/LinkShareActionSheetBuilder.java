package com.tencent.mobileqq.activity.discussion;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import gkp;

public class LinkShareActionSheetBuilder
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "LinkShareDialogBuilder";
  public static final int b = 3;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public LinkShareActionSheetBuilder(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ActionSheet a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2130904504, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837525));
    localGridView.setAdapter(new gkp(this, null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localActionSheet.a(localGridView);
    localActionSheet.e(2131365736);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */