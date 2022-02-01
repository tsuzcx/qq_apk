import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;

@TargetApi(11)
public class jjw
  implements View.OnDragListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public jjw(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    CustomImgView localCustomImgView = new CustomImgView(NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel));
    localCustomImgView.setBackground(NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getResources().getDrawable(2130840157));
    Object localObject = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject).setMargins((int)paramFloat1 - this.jdField_b_of_type_Int / 2, (int)paramFloat2 - this.jdField_b_of_type_Int / 2, 0, 0);
    NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getTag();
    Drawable localDrawable = NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).a();
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, localCustomImgView, localPicInfo, localDrawable);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).addView(localCustomImgView, (ViewGroup.LayoutParams)localObject);
    localObject = new ScaleAnimation(1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1, (paramFloat1 - this.jdField_b_of_type_Int / 2) * this.jdField_a_of_type_Int / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / this.jdField_a_of_type_Int, 1, (paramFloat2 - this.jdField_b_of_type_Int / 2) * this.jdField_a_of_type_Int / (this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / this.jdField_a_of_type_Int);
    ((ScaleAnimation)localObject).setDuration(200L);
    long l2 = this.jdField_a_of_type_Long + 500L - System.currentTimeMillis();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    ((ScaleAnimation)localObject).setStartOffset(l1);
    ((ScaleAnimation)localObject).setAnimationListener(new jkc(this, localPicInfo, localDrawable, localCustomImgView));
    localCustomImgView.startAnimation((Animation)localObject);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt)
  {
    View localView = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getChildAt(paramInt);
    int[] arrayOfInt1 = new int[2];
    localView.getLocationInWindow(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getLocationInWindow(arrayOfInt2);
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject1 = new ScaleAnimation(1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1.0F, this.jdField_a_of_type_Int / this.jdField_b_of_type_Int, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject1).setDuration(200L);
    Object localObject2 = new TranslateAnimation(0.0F, (arrayOfInt1[0] + this.jdField_b_of_type_Int / 2 - arrayOfInt2[0] - this.jdField_a_of_type_Int / 2) * -1, 0.0F, (arrayOfInt1[1] + this.jdField_b_of_type_Int / 2 - arrayOfInt2[1] - this.jdField_a_of_type_Int / 2) * -1);
    ((TranslateAnimation)localObject2).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setStartOffset(300L);
    localObject1 = new CustomImgView(NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel));
    localObject2 = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(arrayOfInt1[0] - arrayOfInt2[0], arrayOfInt1[1] - arrayOfInt2[1], 0, 0);
    ((CustomImgView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, (CustomImgView)localObject1, (NearbyPeopleProfileActivity.PicInfo)localView.getTag(), null);
    localAnimationSet.setAnimationListener(new jjy(this, localView, (CustomImgView)localObject1));
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).addView((View)localObject1);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).removeView(localView);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).a.remove(localView.getTag());
    ((CustomImgView)localObject1).startAnimation(localAnimationSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject1 = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getChildAt(paramInt);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationInWindow((int[])localObject2);
    int[] arrayOfInt = new int[2];
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getLocationInWindow(arrayOfInt);
    localObject1 = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, this.jdField_b_of_type_Int / this.jdField_a_of_type_Int, 1.0F, this.jdField_b_of_type_Int / this.jdField_a_of_type_Int, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localObject2 = new TranslateAnimation(0.0F, localObject2[0] + this.jdField_b_of_type_Int / 2 - arrayOfInt[0] - this.jdField_a_of_type_Int / 2, 0.0F, localObject2[1] + this.jdField_b_of_type_Int / 2 - arrayOfInt[1] - this.jdField_a_of_type_Int / 2);
    ((TranslateAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setStartOffset(300L);
    localObject2 = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel, (NearbyPeopleProfileActivity.PicInfo)NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).getTag());
    ((CustomImgView)localObject2).setVisibility(4);
    ((AnimationSet)localObject1).setAnimationListener(new jka(this, (NearbyPeopleProfileActivity.PicInfo)paramView.getTag(), (CustomImgView)localObject2));
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).startAnimation((Animation)localObject1);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).removeView(paramView);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).addView((View)localObject2, paramInt);
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
  }
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    case 1: 
    default: 
    case 5: 
    case 2: 
    case 6: 
    case 3: 
      do
      {
        do
        {
          do
          {
            int i;
            int j;
            CustomImgView localCustomImgView;
            do
            {
              do
              {
                do
                {
                  return true;
                  paramDragEvent = NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
                  i = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).indexOfChild(paramView);
                  j = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).indexOfChild(paramDragEvent);
                  if ((i == -1) && (j != -1) && (!this.jdField_a_of_type_Boolean))
                  {
                    a(paramDragEvent, j);
                    this.jdField_a_of_type_Boolean = true;
                    this.jdField_a_of_type_Long = System.currentTimeMillis();
                    return true;
                  }
                } while ((i == -1) || (j != -1));
                try
                {
                  a(i);
                  NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).addView(paramDragEvent, i);
                  NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
                  return true;
                }
                catch (Exception paramView) {}
              } while (!QLog.isColorLevel());
              QLog.d("Q.nearby_people_card.", 2, "small pic getting big exception" + paramView.getMessage());
              return true;
              localCustomImgView = NearbyProfileEditPanel.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
              i = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).indexOfChild(paramView);
              j = NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).indexOfChild(localCustomImgView);
            } while ((i == -1) || (j == -1) || (((i <= j) || (paramDragEvent.getX() <= this.jdField_b_of_type_Int / 2)) && ((i >= j) || (paramDragEvent.getX() >= this.jdField_b_of_type_Int / 2))));
            try
            {
              NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).removeView(localCustomImgView);
              NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).addView(localCustomImgView, i);
              NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel);
              return true;
            }
            catch (Exception paramView) {}
          } while (!QLog.isColorLevel());
          QLog.d("Q.nearby_people_card.", 2, "drag between small pics exception" + paramView.getMessage());
          return true;
        } while (paramView != NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel));
        this.jdField_a_of_type_Boolean = false;
        return true;
      } while (paramView != NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel));
      a(paramDragEvent.getX(), paramDragEvent.getY());
      return true;
    }
    NearbyProfileEditPanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel).post(new jjx(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjw
 * JD-Core Version:    0.7.0.1
 */