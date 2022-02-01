package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import frj;
import frk;
import java.io.File;
import java.util.ArrayList;

public class SigTlpAnimation
  extends XBubbleAnimation
{
  public static final String a;
  protected Rect a;
  protected View a;
  private RichStatItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder;
  public BubbleInfo.CommonAttrs a;
  private StatusHistoryActivity.ItemViewHolder jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder;
  protected SignatureTemplateInfo.DynamicItem a;
  protected boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected String b;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = SigTlpAnimation.class.getSimpleName();
  }
  
  public SigTlpAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (b())
    {
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      }
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
      localLayoutParams.height = (this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
      localLayoutParams.width = (this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, localLayoutParams, false);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, localLayoutParams.width, localLayoutParams.height);
      bool = a();
    }
    return bool;
  }
  
  public int a(View paramView, boolean paramBoolean)
  {
    View localView = (View)paramView.getParent();
    int j = paramView.getTop();
    if (paramBoolean) {
      for (i = j; !(localView instanceof ChatXListView); i = j + i)
      {
        j = localView.getTop();
        localView = (View)localView.getParent();
      }
    }
    paramView = localView;
    int i = j;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      i = j;
      for (;;)
      {
        j = i;
        if ((localView instanceof MutilayoutSlideDetectListView)) {
          break;
        }
        i += localView.getTop();
        localView = (View)localView.getParent();
      }
    }
    for (;;)
    {
      j = i;
      if ((paramView instanceof MaxHeightRelativelayout)) {
        break;
      }
      i += paramView.getTop();
      paramView = (View)paramView.getParent();
    }
    j = i;
    return j;
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView == null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder == null) {
        e();
      }
    }
    else {
      while ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder == null)) {
        return false;
      }
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(this.jdField_a_of_type_AndroidGraphicsRect.left);
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_AndroidGraphicsRect.top);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.post(new frj(this));
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1;
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.jdField_a_of_type_ArrayOfJavaLangString != null);
    localObject = FileUtils.a(paramString);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject).size()];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString).append(File.separator).append("%d.png");
    paramString = ((StringBuilder)localObject).toString();
    int j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = String.format(paramString, new Object[] { Integer.valueOf(i + 1) });
      i += 1;
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      a(false);
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {}
    String str;
    do
    {
      return false;
      this.jdField_a_of_type_AndroidViewView = null;
      localObject = String.valueOf(paramVarArgs[1]);
      this.jdField_b_of_type_JavaLangString = String.valueOf(paramVarArgs[2]);
      str = (String)paramVarArgs[3];
      this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[4]).booleanValue();
      if (paramVarArgs[5] != null) {
        this.jdField_a_of_type_AndroidViewView = ((View)paramVarArgs[5]);
      }
      this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = ((SignatureTemplateInfo.DynamicItem)paramVarArgs[6]);
      if (((String)localObject).equals(this.jdField_d_of_type_JavaLangString)) {
        break;
      }
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
    } while (!a(SignatureTemplateConfig.a(this.jdField_b_of_type_JavaLangString, str)));
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_c_of_type_Int != 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_c_of_type_Int;
      paramVarArgs.a((String[])localObject, i, false);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
        if (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_b_of_type_Int == 0) {
          break label219;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_b_of_type_Int;
        label181:
        paramVarArgs.k = i;
      }
      this.jdField_b_of_type_AndroidViewView = new frk(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
    }
    for (boolean bool = a(true);; bool = false)
    {
      return bool;
      i = 50;
      break;
      label219:
      i = 3;
      break label181;
    }
  }
  
  public boolean b()
  {
    int i = 0;
    int j = 0;
    Object localObject;
    int m;
    int k;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = null;
      this.jdField_d_of_type_Int = AIOUtils.a(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentWidgetListView.a());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_d_of_type_Int));
      if ((localObject != null) && ((localObject instanceof RichStatItemBuilder.Holder))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = ((RichStatItemBuilder.Holder)localObject);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder == null)
      {
        e();
        return false;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "list view item's tag can not cast to Holder, object:" + localObject);
        }
      }
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break label646;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getLeft() + ((View)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getParent()).getLeft();
      k = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a, true) - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getLeft();
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.getTop();
    }
    for (;;)
    {
      label230:
      m += (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.a * j);
      k += (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_b_of_type_Float * i);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      float f = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_c_of_type_Float;
      j = (int)(j * f);
      f = this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.d;
      ((Rect)localObject).set(m, k, j + m, (int)(i * f) + k);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView top=" + k + ",left=" + m);
      }
      return true;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder = null;
        this.jdField_d_of_type_Int = SignatureManager.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentWidgetListView.a());
        localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_d_of_type_Int));
        if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder))) {
          this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder = ((StatusHistoryActivity.ItemViewHolder)localObject);
        }
      }
      label644:
      for (;;)
      {
        label425:
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder != null)
        {
          if (this.jdField_b_of_type_AndroidViewView == null) {
            break label635;
          }
          m = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getLeft() + ((View)this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getParent()).getLeft();
          k = a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a, false);
          j = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getRight() - this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getLeft();
          i = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getBottom() - this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getTop();
        }
        for (;;)
        {
          break label230;
          if (!QLog.isColorLevel()) {
            break label644;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "list view item's tag can not cast to ItemViewHolder, object:" + localObject);
          break label425;
          break;
          m = ((View)this.jdField_a_of_type_AndroidViewView.getParent()).getLeft();
          k = a(this.jdField_a_of_type_AndroidViewView, false) - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          j = this.jdField_a_of_type_AndroidViewView.getRight() - this.jdField_a_of_type_AndroidViewView.getLeft();
          i = this.jdField_a_of_type_AndroidViewView.getBottom() - this.jdField_a_of_type_AndroidViewView.getTop();
          break label230;
          label635:
          j = 0;
          k = 0;
          m = 0;
        }
      }
      label646:
      i = 0;
      k = 0;
      m = 0;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation
 * JD-Core Version:    0.7.0.1
 */