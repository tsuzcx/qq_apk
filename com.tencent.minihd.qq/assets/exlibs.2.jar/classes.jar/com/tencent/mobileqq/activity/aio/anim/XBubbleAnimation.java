package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import frn;
import fro;
import frp;
import frs;

public class XBubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  public static final String c;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private BaseBubbleBuilder.ViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
  public VipPngPlayAnimationDrawable a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  protected View b;
  public VipPngPlayAnimationDrawable b;
  public BubbleInfo.CommonAttrs b;
  protected int c;
  public BubbleInfo.CommonAttrs c;
  
  static
  {
    jdField_c_of_type_JavaLangString = XBubbleAnimation.class.getSimpleName();
  }
  
  public XBubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      return new int[] { paramInt2, paramInt1 };
    case 0: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 6: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
    {
      paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  protected void a(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.jdField_b_of_type_AndroidViewView.getBottom() > 0) && (this.jdField_b_of_type_AndroidViewView.getTop() < this.jdField_a_of_type_ComTencentWidgetListView.getHeight())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
        if ((!this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.jdField_a_of_type_AndroidViewView.getBottom() > 0))
        {
          paramInt = j;
          if (this.jdField_a_of_type_AndroidViewView.getTop() < this.jdField_a_of_type_ComTencentWidgetListView.getHeight()) {
            break label112;
          }
        }
      }
      for (paramInt = 1;; paramInt = i)
      {
        label112:
        if (paramInt != 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new fro(this));
        }
        return;
      }
    }
  }
  
  protected boolean a()
  {
    boolean bool3 = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = null;
    Object localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    boolean bool1;
    label325:
    boolean bool2;
    label375:
    label382:
    int i;
    int n;
    int k;
    int j;
    int m;
    if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null)) {
        e();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null)) {
        break label1353;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.top = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c.getTop() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c.getLeft() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c.getBottom() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c.getRight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView bubbleRect top=" + this.jdField_a_of_type_AndroidGraphicsRect.top + ",left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + ",bottom=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + ",right=" + this.jdField_a_of_type_AndroidGraphicsRect.right);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
        break label1128;
      }
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1;
      if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null)
      {
        if (!this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString)) {
          break label1140;
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
        if (bool1) {
          break label1134;
        }
        bool2 = true;
        ((VipPngPlayAnimationDrawable)localObject).c = bool2;
      }
      localObject = a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
      i = localObject[1];
      n = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top + i;
      if (bool1) {
        break label1152;
      }
      i = localObject[0];
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left + i;
      k = i;
      if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
        break label1380;
      }
      localObject = a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
      j = localObject[0] - this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
      m = localObject[1] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
      k = i;
      i = m;
    }
    for (;;)
    {
      label552:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView master_x=" + k + ",master_y=" + n + ",mAttrsFirst.mRect.right=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mAttrsFirst.mRect.bottom=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
      }
      if ((k >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) && (k <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) && (n >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom) && (n <= this.jdField_a_of_type_ComTencentWidgetListView.getHeight()))
      {
        k -= this.jdField_b_of_type_AndroidViewView.getLeft();
        m = n - this.jdField_b_of_type_AndroidViewView.getTop();
        if ((k != 0) || (m != 0))
        {
          this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(k);
          this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(m);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView.offsetLeftAndRight " + k + ",mView.offsetTopAndBottom " + m);
          }
        }
      }
      label804:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_a_of_type_AndroidViewView != null) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView x=" + j + ",y=" + i + ",mRect.right=" + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mRect.bottom=" + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
          }
          bool1 = bool3;
          if (j >= -this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right)
          {
            bool1 = bool3;
            if (j <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth())
            {
              bool1 = bool3;
              if (i >= -this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom)
              {
                bool1 = bool3;
                if (i <= this.jdField_a_of_type_ComTencentWidgetListView.getHeight())
                {
                  j -= this.jdField_a_of_type_AndroidViewView.getLeft();
                  i -= this.jdField_a_of_type_AndroidViewView.getTop();
                  if ((j == 0) && (i == 0)) {
                    break label1308;
                  }
                  this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(j);
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView.offsetLeftAndRight " + j + ",mLinkView.offsetTopAndBottom " + i);
                  }
                }
              }
            }
          }
          for (;;)
          {
            bool1 = true;
            return bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e(jdField_c_of_type_JavaLangString, 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
            break;
            label1128:
            bool1 = false;
            break label325;
            label1134:
            bool2 = false;
            break label375;
            label1140:
            this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1;
            break label382;
            m = localObject[0] - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
            k = m;
            if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
              break label1380;
            }
            localObject = a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
            j = localObject[0] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left;
            i = localObject[1] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
            k = m;
            break label552;
            if (!QLog.isColorLevel()) {
              break label804;
            }
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView dx=" + k + ",dy=" + m);
            break label804;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView dx=" + j + ",dy=" + i);
            }
          }
          label1353:
          this.jdField_a_of_type_AndroidOsHandler.post(new frn(this));
          return false;
        }
        return bool1;
      }
      label1152:
      label1308:
      label1380:
      i = 0;
      j = 0;
    }
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    return a();
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    int j = 1;
    int k = ((Integer)paramVarArgs[0]).intValue();
    long l = ((Long)paramVarArgs[1]).longValue();
    if (paramVarArgs.length != 3) {}
    Object localObject;
    do
    {
      return false;
      this.jdField_c_of_type_Int = AIOUtils.a(l, this.jdField_a_of_type_ComTencentWidgetListView.a());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
      if ((localObject == null) || (!(localObject instanceof BaseBubbleBuilder.ViewHolder))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
      if ((l == this.jdField_a_of_type_Long) && (this.jdField_b_of_type_Int == k)) {
        break label494;
      }
      paramVarArgs = (Pair)paramVarArgs[2];
    } while ((paramVarArgs == null) || (paramVarArgs.first == null) || (((BubbleInfo.CommonAttrs)paramVarArgs.first).jdField_a_of_type_ArrayOfJavaLangString == null));
    e();
    this.jdField_a_of_type_Long = l;
    this.jdField_b_of_type_Int = k;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramVarArgs.first);
    this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramVarArgs.second);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
    int i;
    if (k != 0)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean)
      {
        i = 1;
        label217:
        paramVarArgs.k = i;
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView = new frp(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicHeight());
      if ((this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
        if (k != 0)
        {
          paramVarArgs = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
          if (!this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean) {
            break label483;
          }
          i = j;
          label352:
          paramVarArgs.k = i;
        }
        this.jdField_a_of_type_AndroidViewView = new frs(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicWidth(), this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicHeight());
      }
    }
    label483:
    label494:
    for (boolean bool = a();; bool = false)
    {
      return bool;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_c_of_type_JavaLangString, 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break label217;
      i = this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break label352;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {}
    do
    {
      Drawable localDrawable;
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Boolean = paramBoolean;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null);
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.c.getBackground();
      } while (!(localDrawable instanceof VipBubbleDrawable));
      ((VipBubbleDrawable)localDrawable).a(paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_c_of_type_JavaLangString, 2, "background alpha changed:" + String.valueOf(paramBoolean));
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation
 * JD-Core Version:    0.7.0.1
 */