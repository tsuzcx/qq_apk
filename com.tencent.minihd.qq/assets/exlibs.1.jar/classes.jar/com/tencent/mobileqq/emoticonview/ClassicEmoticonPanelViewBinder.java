package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import java.util.List;

public class ClassicEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = "ClassicEmoticonPanelViewBinder";
  private static final int b = 7;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  
  public ClassicEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    this(paramContext, paramEmoticonCallback, paramInt, false);
  }
  
  public ClassicEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    return SystemAndEmojiEmoticonInfo.h + SystemAndEmojiEmoticonInfo.i;
  }
  
  protected int a(int paramInt)
  {
    if (((paramInt == this.c) || (paramInt == this.c - 1) || (paramInt == this.c + 1)) && (this.jdField_a_of_type_Boolean)) {
      return 2010;
    }
    return 2007;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130840758);
    paramContext = paramContext.getResources().getDrawable(2130840759);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
      } while (paramInt >= a());
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = SystemAndEmojiEmoticonInfo.a();
      }
      if (i == 2007)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new EmoticonPanelViewBinder.DefaultEmoticonAdapter(this, 2007);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(true);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(false);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
          localObject = new EmoticonInfo();
          ((EmoticonInfo)localObject).a = "delete";
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a((EmoticonInfo)localObject);
        }
        Object localObject = (EmoticonLinearLayout)paramView;
        ((EmoticonLinearLayout)localObject).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
        ((EmoticonLinearLayout)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(3, 7);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
      }
    } while (i != 2010);
    paramView = (ClassicEmoticonPanelView)paramView;
    paramView.b();
    paramView.setData(this.jdField_a_of_type_JavaUtilList, paramInt);
    paramView.setCallback(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */