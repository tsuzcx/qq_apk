package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.List;

public class SystemEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final int jdField_a_of_type_Int = 3;
  private static final int b = 7;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  
  public SystemEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 1, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public int a()
  {
    return SystemAndEmojiEmoticonInfo.h;
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public Drawable a(Context paramContext)
  {
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2007) || (paramInt >= a())) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = SystemEmoticonInfo.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new EmoticonPanelViewBinder.DefaultEmoticonAdapter(this, 2007);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
      EmoticonInfo localEmoticonInfo = new EmoticonInfo();
      localEmoticonInfo.a = "delete";
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(localEmoticonInfo);
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(3, 7);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */