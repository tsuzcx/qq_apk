import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.DataObserver;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ifs
  implements EmoticonLinearLayout.DataObserver
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ifs(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    long l = System.currentTimeMillis();
    int m = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b();
    int n = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c();
    int j = 0;
    int i = 0;
    int k;
    if (j < n)
    {
      k = 0;
      label41:
      if (k < m) {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size() > i) {}
      }
    }
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(i, localRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout);
      i += 1;
      k += 1;
      break label41;
      j += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.b == paramInt2) && (this.jdField_a_of_type_Boolean == true)) {}
    long l;
    label278:
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.removeAllViews();
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.c, 0, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.c, 0);
        localLayoutParams1.weight = 1.0F;
        localLinearLayout.setOrientation(0);
        int i = 0;
        if (i < this.b)
        {
          System.currentTimeMillis();
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -1);
          Object localObject1 = null;
          if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size()) {
            localObject1 = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(paramInt1);
          }
          Object localObject2;
          if (localObject1 == null)
          {
            localObject1 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject2 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((URLImageView)localObject2).setId(2131296370);
            switch (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EmoticonLinearLayout", 2, "Should not reach here, check your code!!!");
              }
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.add(localObject1);
            }
          }
          for (;;)
          {
            localLinearLayout.addView((View)localObject1, localLayoutParams2);
            if (i != this.b - 1)
            {
              localObject1 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
              localLinearLayout.addView(new View(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext), (ViewGroup.LayoutParams)localObject1);
            }
            paramInt1 += 1;
            i += 1;
            break;
            Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setAdjustViewBounds(false);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            break label278;
            localObject3 = new TextView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((TextView)localObject3).setVisibility(8);
            ((TextView)localObject3).setId(2131296372);
            ((TextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.b);
            ((TextView)localObject3).setTextSize(12.0F);
            Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(12);
            ((RelativeLayout.LayoutParams)localObject4).addRule(14);
            ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject3 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject4 = new RelativeLayout.LayoutParams(-2, -1);
            ((RelativeLayout.LayoutParams)localObject4).addRule(2, 2131296372);
            ((RelativeLayout.LayoutParams)localObject4).addRule(14);
            ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
            ((URLImageView)localObject2).setVisibility(8);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setAdjustViewBounds(false);
            ((RelativeLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setVisibility(8);
            ((ImageView)localObject2).setId(2131296371);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131296370);
            ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296370);
            ((RelativeLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
            break label278;
            localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject3).setId(2131296374);
            float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getContext().getResources().getDisplayMetrics().density;
            localObject4 = new RelativeLayout.LayoutParams((int)(63.0F * f), (int)(f * 63.0F));
            ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
            ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
            ((ImageView)localObject3).setAdjustViewBounds(false);
            ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject3 = new TextView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((TextView)localObject3).setVisibility(8);
            ((TextView)localObject3).setId(2131296372);
            ((TextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.b);
            ((TextView)localObject3).setTextSize(12.0F);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(12);
            ((RelativeLayout.LayoutParams)localObject4).addRule(14);
            ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject3 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject4 = new RelativeLayout.LayoutParams(-2, -1);
            ((RelativeLayout.LayoutParams)localObject4).addRule(2, 2131296372);
            ((RelativeLayout.LayoutParams)localObject4).addRule(14);
            ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localObject4 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject4).addRule(13, -1);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setAdjustViewBounds(false);
            ((RelativeLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setVisibility(8);
            ((ImageView)localObject2).setId(2131296371);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131296372);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131296374);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setId(2131296373);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131296374);
            ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131296374);
            localObject4 = new ProgressBar(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ProgressBar)localObject4).setVisibility(8);
            ((ProgressBar)localObject4).setId(2131296375);
            ((ProgressBar)localObject4).setIndeterminateDrawable(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838130));
            int j = AIOUtils.a(16.0F, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext.getResources());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
            localLayoutParams.addRule(13, 2131296374);
            ((RelativeLayout)localObject1).addView((View)localObject4, localLayoutParams);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            break label278;
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setAdjustViewBounds(false);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setId(2131296371);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131296370);
            ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131296370);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setId(2131296373);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131296374);
            ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131296374);
            ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            break label278;
            localObject2 = (ViewGroup)((RelativeLayout)localObject1).getParent();
            if (localObject2 != null) {
              ((ViewGroup)localObject2).removeAllViews();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.addView(localLinearLayout, localLayoutParams1);
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifs
 * JD-Core Version:    0.7.0.1
 */