package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelViewBinder$DefaultEmoticonAdapter
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private static final int e = 63;
  private static final int f = 30;
  private static final int g = 48;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public EmoticonPanelViewBinder$DefaultEmoticonAdapter(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    float f1 = paramEmoticonPanelViewBinder.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.i = ((int)(30.0F * f1));
    this.h = ((int)(63.0F * f1));
    this.j = ((int)(f1 * 48.0F));
    this.k = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)paramRelativeLayout.findViewById(2131296370);
    localImageView.setVisibility(0);
    localImageView.setTag(Boolean.valueOf(false));
    Object localObject1 = a(paramInt);
    paramRelativeLayout.setTag(localObject1);
    paramViewGroup = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    float f1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    label164:
    Object localObject2;
    Object localObject3;
    if (localObject1 != null) {
      if ((((EmoticonInfo)localObject1).c == 1) || (((EmoticonInfo)localObject1).c == 2) || (((EmoticonInfo)localObject1).c == 7))
      {
        paramViewGroup.width = this.i;
        paramViewGroup.height = this.i;
        if (((EmoticonInfo)localObject1).c == -1) {
          break label654;
        }
        paramViewGroup = ((EmoticonInfo)localObject1).a(this.a.jdField_a_of_type_AndroidContentContext, f1);
        ((URLImageView)localImageView).setURLDrawableDownListener(this.a.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        if (paramViewGroup == null) {
          break label645;
        }
        localImageView.setImageDrawable(paramViewGroup);
        if ((this.k == 2006) || (this.k == 2008))
        {
          paramViewGroup = (TextView)paramRelativeLayout.findViewById(2131296372);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo)) || ((((EmoticonInfo)localObject1).c != 6) && (((EmoticonInfo)localObject1).c != 9))) {
            break label1001;
          }
          localObject2 = (PicEmoticonInfo)localObject1;
          localObject3 = ((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
          if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
            break label992;
          }
          paramViewGroup.setVisibility(0);
          paramInt = ((String)localObject3).length();
          if (paramInt <= 5) {
            break label983;
          }
          int m = ((String)localObject3).indexOf("Q脸表情-");
          if ((((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) || (m < 0)) {
            break label950;
          }
          m += 5;
          if (m > paramInt - 1) {
            break label940;
          }
          paramViewGroup.setText(((String)localObject3).substring(m));
        }
        label324:
        if ((this.k == 2006) || (this.k == 2009))
        {
          paramViewGroup = (ImageView)paramRelativeLayout.findViewById(2131296371);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo))) {
            break label1018;
          }
          if (!((PicEmoticonInfo)localObject1).a()) {
            break label1010;
          }
          paramViewGroup.setVisibility(0);
          paramViewGroup.setImageResource(2130841963);
        }
        label389:
        if (this.k == 2008)
        {
          localObject3 = (ImageView)paramRelativeLayout.findViewById(2131296373);
          paramViewGroup = (ImageView)paramRelativeLayout.findViewById(2131296371);
          paramRelativeLayout = (ProgressBar)paramRelativeLayout.findViewById(2131296375);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo))) {
            break label1197;
          }
          localObject2 = (PicEmoticonInfo)localObject1;
          if (((EmoticonInfo)localObject1).c == 9)
          {
            ((ImageView)localObject3).setVisibility(8);
            paramViewGroup.setVisibility(8);
            if (!((PicEmoticonInfo)localObject2).jdField_a_of_type_Boolean) {
              break label1026;
            }
            ((ImageView)localObject3).setImageResource(2130840716);
            ((ImageView)localObject3).setVisibility(0);
            if (!((PicEmoticonInfo)localObject2).b) {
              break label1190;
            }
            paramRelativeLayout.setVisibility(0);
          }
        }
      }
    }
    label645:
    label654:
    label940:
    label950:
    label983:
    label992:
    label1001:
    label1010:
    label1018:
    while ((localObject3 == null) || (paramViewGroup == null) || (paramRelativeLayout == null))
    {
      do
      {
        return;
        if ((this.k != 2009) && ((((EmoticonInfo)localObject1).c == 6) || (((EmoticonInfo)localObject1).c == 9)))
        {
          paramViewGroup.width = this.j;
          paramViewGroup.height = this.j;
          break;
        }
        if ((!"setting".equals(((EmoticonInfo)localObject1).a)) && (!"add".equals(((EmoticonInfo)localObject1).a)) && (!"push".equals(((EmoticonInfo)localObject1).a)) && ((this.k != 2009) || ((((EmoticonInfo)localObject1).c != 6) && (((EmoticonInfo)localObject1).c != 9)))) {
          break;
        }
        paramViewGroup.width = this.h;
        paramViewGroup.height = this.h;
        break;
        localImageView.setVisibility(4);
        break label164;
        if ("delete".equals(((EmoticonInfo)localObject1).a))
        {
          localImageView.setImageResource(2130838230);
          break label164;
        }
        if ("setting".equals(((EmoticonInfo)localObject1).a))
        {
          localImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840736));
          break label164;
        }
        if ("add".equals(((EmoticonInfo)localObject1).a))
        {
          localImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840735));
          break label164;
        }
        if ("push".equals(((EmoticonInfo)localObject1).a))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelViewBinder", 2, "show push_btn drawable.");
          }
          paramViewGroup = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
          localObject2 = ((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).app.a();
          boolean bool = paramViewGroup.getBoolean("magic_promotion_is_new_content_" + (String)localObject2, false);
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840720);
          if (bool)
          {
            paramViewGroup = paramViewGroup.getString("magic_promotion_gifUrl", "");
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
          }
          for (;;)
          {
            localImageView.setImageDrawable(URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject2));
            break;
            paramViewGroup = paramViewGroup.getString("magic_promotion_imgUrl", "");
          }
        }
        localImageView.setImageDrawable(null);
        break label164;
        localImageView.setImageDrawable(null);
        localImageView.setVisibility(4);
        break label164;
        paramViewGroup.setText("");
        break label324;
        paramViewGroup.setText(((String)localObject3).substring(0, 4) + "...");
        break label324;
        paramViewGroup.setText((CharSequence)localObject3);
        break label324;
        paramViewGroup.setVisibility(8);
        break label324;
        paramViewGroup.setVisibility(8);
        break label324;
        paramViewGroup.setVisibility(4);
        break label389;
        paramViewGroup.setVisibility(4);
        break label389;
        localObject3 = ((EmoticonManager)((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).app.getManager(13)).a(((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      } while ((localObject3 == null) || (3 != ((EmoticonPackage)localObject3).jobType) || ((((EmoticonPackage)localObject3).valid) && (2 == ((EmoticonPackage)localObject3).status)) || (((PicEmoticonInfo)localObject2).b));
      localObject1 = ((EmoticonInfo)localObject1).a(this.a.jdField_a_of_type_AndroidContentContext, f1);
      if (((Drawable)localObject1).getIntrinsicWidth() > 0)
      {
        localObject1 = ImageUtil.a((Drawable)localObject1);
        if ((localObject1 != null) && (((Bitmap)localObject1).getWidth() > 0)) {
          localImageView.setImageBitmap(ImageUtil.a((Bitmap)localObject1));
        }
      }
      for (;;)
      {
        if (!((EmoticonPackage)localObject3).valid) {
          paramViewGroup.setImageResource(2130840737);
        }
        paramViewGroup.setVisibility(0);
        break;
        localImageView.setTag(Boolean.valueOf(true));
      }
      paramRelativeLayout.setVisibility(8);
      return;
    }
    label1026:
    label1190:
    label1197:
    ((ImageView)localObject3).setVisibility(8);
    paramViewGroup.setVisibility(8);
    paramRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder.DefaultEmoticonAdapter
 * JD-Core Version:    0.7.0.1
 */