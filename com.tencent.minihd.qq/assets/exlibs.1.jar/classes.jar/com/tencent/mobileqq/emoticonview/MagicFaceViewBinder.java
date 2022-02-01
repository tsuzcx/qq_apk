package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MagicFaceViewBinder
  extends EmoticonPanelViewBinder
{
  public static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = "MagicFaceViewBinder";
  public static final int b = 4;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
  private MagicPromotionInfo jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicPromotionInfo;
  private List jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public MagicFaceViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 9, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicPromotionInfo = EmoticonUtils.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicPromotionInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicPromotionInfo.a != 0) {
        break label98;
      }
    }
    for (;;)
    {
      this.b = bool;
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceViewBinder", 2, "[hasPushBtn]:" + this.b);
      }
      return;
      label98:
      bool = false;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (EmoticonInfo)localIterator.next();
      if ((localObject instanceof PicEmoticonInfo))
      {
        localObject = (PicEmoticonInfo)localObject;
        float f = localEmojiManager.a(((PicEmoticonInfo)localObject).a.epId);
        if ((f >= 0.0F) && (f != 1.0F)) {}
        for (boolean bool = true;; bool = false)
        {
          ((PicEmoticonInfo)localObject).b = bool;
          break;
        }
      }
    }
  }
  
  public int a()
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j + 1;
    }
    j = i;
    if (this.b) {
      j = i + 1;
    }
    i = k;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = k;
      if (j > 0)
      {
        k = 0 + j / 8;
        i = k;
        if (j % 8 != 0) {
          return k + 1;
        }
      }
    }
    return i;
  }
  
  protected int a(int paramInt)
  {
    return 2008;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130840763);
    paramContext = paramContext.getResources().getDrawable(2130840764);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while ((a(paramInt) != 2008) || (paramInt >= a())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new EmoticonPanelViewBinder.DefaultEmoticonAdapter(this, 2008);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.e(this.b);
      EmoticonInfo localEmoticonInfo;
      if (this.jdField_a_of_type_Boolean)
      {
        localEmoticonInfo = new EmoticonInfo();
        localEmoticonInfo.a = "add";
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(localEmoticonInfo);
      }
      if (this.b)
      {
        localEmoticonInfo = new EmoticonInfo();
        localEmoticonInfo.a = "push";
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(localEmoticonInfo);
      }
    }
    paramView = (EmoticonLinearLayout)paramView;
    paramView.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(2, 4);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(paramInt);
    e();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null) {
      return;
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void d()
  {
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicFaceViewBinder
 * JD-Core Version:    0.7.0.1
 */