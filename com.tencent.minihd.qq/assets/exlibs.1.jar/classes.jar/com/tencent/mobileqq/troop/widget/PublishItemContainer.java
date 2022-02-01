package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.troop.activity.ImagePreviewActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.VideoInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import koc;
import kod;

public class PublishItemContainer
  extends HorizontalScrollView
  implements View.OnClickListener, VoicePlayer.VoicePlayerListener
{
  private static final int b = 9;
  private int jdField_a_of_type_Int = 0;
  protected Activity a;
  protected Drawable a;
  protected View a;
  protected LinearLayout a;
  private MediaInfo jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  protected CharSequence a;
  protected ArrayList a;
  private boolean jdField_a_of_type_Boolean = false;
  protected LinearLayout b;
  private int c = 9;
  
  public PublishItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130841071);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131365464);
    this.b = new LinearLayout(paramContext);
    addView(this.b);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    this.b.setOrientation(0);
    this.b.setGravity(16);
    this.b.setLayoutParams(paramAttributeSet);
    this.b.setPadding(0, 0, 0, (int)DisplayUtils.a(paramContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.b.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130903572, null);
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.b.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(paramInt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    c();
  }
  
  protected void a(View paramView)
  {
    Object localObject = paramView.findViewById(2131298842);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131298840);
    localURLImageView.setImageResource(2130841317);
    ((View)localObject).setVisibility(8);
    localURLImageView.setAdjustViewBounds(false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(getContext(), 50.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(getContext(), 50.0F));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localURLImageView.setOnClickListener(this);
    localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = Utils.a(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = Utils.a(getContext(), 2.0F);
    localObject = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), 60.0F), (int)DisplayUtils.a(getContext(), 67.0F));
    ((LinearLayout.LayoutParams)localObject).rightMargin = Utils.a(getContext(), 2.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = Utils.a(getContext(), 4.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void a(View paramView, String paramString)
  {
    View localView;
    URLImageView localURLImageView;
    Object localObject2;
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      localView = paramView.findViewById(2131298842);
      localURLImageView = (URLImageView)paramView.findViewById(2131298840);
      localURLImageView.setAdjustViewBounds(false);
      localObject1 = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)DisplayUtils.a(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)DisplayUtils.a(getContext(), 50.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localObject1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = Utils.a(getContext(), 2.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = Utils.a(getContext(), 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        if (!((File)localObject2).exists()) {
          break label291;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label159:
        label291:
        break label159;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      ((Drawable)localObject2).setBounds(0, 0, 100, 100);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      localView.setTag(paramString);
      localView.setOnClickListener(this);
      localURLImageView.setTag(paramString);
      localURLImageView.setOnClickListener(this);
      paramString = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramString.rightMargin = Utils.a(getContext(), 2.0F);
      paramString.topMargin = Utils.a(getContext(), 5.0F);
      paramString.width = ((int)DisplayUtils.a(getContext(), 60.0F));
      paramString.height = ((int)DisplayUtils.a(getContext(), 67.0F));
      paramView.setLayoutParams(paramString);
      return;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.b.setVisibility(0);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean a(int paramInt, MediaInfo paramMediaInfo)
  {
    if (this.jdField_a_of_type_Int == 4) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (paramMediaInfo == null) {}
    for (View localView = null; localView == null; localView = paramMediaInfo.getView(getContext(), this)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = paramMediaInfo;
    this.jdField_a_of_type_Int = paramInt;
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        View localView = LayoutInflater.from(getContext()).inflate(2130903572, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        a(localView, paramString);
        this.jdField_a_of_type_Int = 4;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == this.c) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        setVisibility(0);
        postDelayed(new koc(this), 200L);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    Object localObject = new ArrayList(paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayList != null)
    {
      int j;
      int k;
      if ((paramArrayList.size() == this.c) || (paramArrayList.size() == 0))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        k = ((ArrayList)localObject).size();
        if (j <= k) {
          break label161;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(k, j - k);
      }
      for (;;)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i), (String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break;
        label161:
        if (j < k)
        {
          paramArrayList = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
          i = 0;
          while (i < k - j)
          {
            localObject = paramArrayList.inflate(2130903572, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            i += 1;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_Int = 4;
        setVisibility(0);
        postDelayed(new kod(this), 200L);
      }
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    setVisibility(8);
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Int != 2) || (!(this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo instanceof AudioInfo))) {}
    AudioInfo localAudioInfo;
    do
    {
      return;
      localAudioInfo = (AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
      localAudioInfo.mAudioIcon.setImageResource(2130839186);
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(localAudioInfo.path, new Handler());
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
    ((AnimationDrawable)localAudioInfo.mAudioIcon.getDrawable()).start();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo instanceof AudioInfo)) {}
    }
    else
    {
      return;
    }
    AudioInfo localAudioInfo = (AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
    ((AnimationDrawable)localAudioInfo.mAudioIcon.getDrawable()).stop();
    localAudioInfo.mAudioIcon.setImageResource(2130841728);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        c();
        paramView = new Intent("key_audio_delete_action");
        BaseApplication.getContext().sendBroadcast(paramView);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = null;
        return;
        paramView = new Intent("key_video_delete_action");
        BaseApplication.getContext().sendBroadcast(paramView);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = null;
        return;
        paramView = new Intent("key_music_delete_action");
        BaseApplication.getContext().sendBroadcast(paramView);
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = null;
        return;
        paramView = (String)paramView.getTag();
        int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(i);
        paramView = new Intent("key_photo_delete_action");
        paramView.putExtra("key_photo_delete_position", i);
        BaseApplication.getContext().sendBroadcast(paramView);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
        {
          setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_Int = 0;
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        if (paramView.getTag() != null)
        {
          paramView = (String)paramView.getTag();
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView);
          AlbumUtil.a();
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, ImagePreviewActivity.class);
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
          paramView.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
          paramView.putExtra("selected_photo_index", i);
          paramView.putExtra("back_btn_text", this.jdField_a_of_type_AndroidAppActivity.getString(2131364103));
          paramView.addFlags(603979776);
          getContext().startActivity(paramView);
          AlbumUtil.a(this.jdField_a_of_type_AndroidAppActivity, false, true);
          return;
        }
        paramView = new Intent("key_photo_add_action");
        BaseApplication.getContext().sendBroadcast(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
          break;
        }
        b();
      } while (this.jdField_a_of_type_Boolean);
      paramView = new Intent("key_audio_play_action");
      BaseApplication.getContext().sendBroadcast(paramView);
      this.jdField_a_of_type_Boolean = true;
      return;
      c();
      return;
      paramView = (VideoInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
    } while (paramView == null);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ShortVideoPreviewActivity.class);
    localIntent.putExtra("file_send_path", paramView.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("file_send_size", paramView.a);
    localIntent.putExtra("file_send_duration", paramView.jdField_b_of_type_Long);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.IS_FROM_TROOP_BAR", true);
    localIntent.putExtra("preview_only", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    paramView = new Intent("key_video_play_action");
    BaseApplication.getContext().sendBroadcast(paramView);
  }
  
  public void setCurType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    View localView2;
    View localView1;
    if (this.jdField_a_of_type_Int == 2)
    {
      localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      localView1 = localView2.findViewById(2131298823);
      localView2 = localView2.findViewById(2131298825);
      if ((localView1 != null) && (localView2 != null))
      {
        localView1.setEnabled(paramBoolean);
        localView2.setEnabled(paramBoolean);
      }
    }
    for (;;)
    {
      setEnabled(paramBoolean);
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        localView1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131298839);
        if (localView1 != null) {
          localView1.setEnabled(paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
        localView1 = localView2.findViewById(2131298843);
        localView2 = localView2.findViewById(2131298847);
        if ((localView2 != null) && (localView1 != null))
        {
          localView1.setEnabled(paramBoolean);
          localView2.setEnabled(paramBoolean);
        }
      }
    }
  }
  
  public void setMaxPicNum(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemContainer
 * JD-Core Version:    0.7.0.1
 */