package com.tencent.mobileqq.vipav;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.MediaPlayerHelper;
import com.tencent.mobileqq.utils.VipUtils;
import java.lang.ref.WeakReference;
import kwd;
import kwe;
import kwf;
import kwg;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipFunCallPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoView jdField_a_of_type_AndroidWidgetVideoView;
  private MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = MediaPlayerHelper.a();
  protected VipFunCallObserver a;
  public Runnable a;
  public String a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  public int b;
  TextView b;
  public Runnable b;
  
  public VipFunCallPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRunnable = new kwd(this);
    this.jdField_b_of_type_JavaLangRunnable = new kwe(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new kwg(this);
  }
  
  protected String a(int paramInt)
  {
    String str = "mvip.gongneng.android.quweilaidian_mb";
    if (paramInt == 3) {
      str = "mvip.gongneng.android.quweilaidian_jg";
    }
    do
    {
      return str;
      if (paramInt == 4) {
        return "mvip.gongneng.android.quweilaidian_xk";
      }
    } while (paramInt != 6);
    return "mvip.gongneng.android.quweilaidian_dq";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(this, Uri.parse("android.resource://" + getPackageName() + "/" + 2131165195));
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      VipOpenVipDialog.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "温馨提示", "你选择的来电动画为会员专享，开通即可使用此来电动画", "取消", "立即开通", paramInt1, 3, a(paramInt2), null, null);
      return;
    }
    if (paramInt1 == 2)
    {
      VipOpenVipDialog.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "温馨提示", "你选择的来电动画为超级会员专享，开通即可使用此来电动画", "取消", "立即开通", paramInt1, 3, a(paramInt2), null, null);
      return;
    }
    VipOpenVipDialog.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "温馨提示", "设置失败，网速不给力哦，请重试 ^_^", "取消", "确定");
  }
  
  protected String b(int paramInt)
  {
    int j;
    label124:
    do
    {
      try
      {
        JSONArray localJSONArray = VipFunCallManager.a().getJSONArray("items");
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject != null) && (localJSONObject.getInt("id") == paramInt))
          {
            j = localJSONObject.getInt("vip_type");
            long l1 = localJSONObject.getLong("trialstartday");
            long l2 = localJSONObject.getLong("trialendday");
            long l3 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
            if ((l1 > l3) || (l3 > l2)) {
              break label124;
            }
            return "限免期间免费设置";
            if (j == 2) {
              return "SVIP免费设置";
            }
          }
          i += 1;
        }
        return "设置来电动画";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (j == 0) {
        return "免费设置";
      }
    } while (j != 1);
    return "VIP免费设置";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904512);
    super.setLeftViewName(2131369904);
    super.setTitle("预览");
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.hasExtra("key_fun_call_id")) && (paramBundle.hasExtra("key_to_uin")))
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("key_to_uin");
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_fun_call_id", 0);
    }
    if (this.jdField_a_of_type_Int <= 0) {
      finish();
    }
    this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)findViewById(2131302397));
    if (this.jdField_a_of_type_AndroidWidgetVideoView != null)
    {
      this.jdField_b_of_type_Int = VipFunCallManager.a();
      paramBundle = VipFunCallManager.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (paramBundle == null) {
        return false;
      }
      if (this.jdField_b_of_type_Int == VipFunCallManager.jdField_a_of_type_Int)
      {
        if (VipFunCallManager.a(this, this.jdField_a_of_type_AndroidWidgetVideoView, paramBundle, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_Int, true)) {
          a();
        }
        this.jdField_a_of_type_AndroidWidgetVideoView.setOnTouchListener(new kwf(this));
      }
    }
    else
    {
      paramBundle = (RelativeLayout)findViewById(2131302396);
      BitmapDrawable localBitmapDrawable = VipFunCallManager.a(VipFunCallManager.a(this.jdField_a_of_type_Int, VipFunCallManager.d));
      if ((localBitmapDrawable != null) && (paramBundle != null)) {
        paramBundle.setBackgroundDrawable(localBitmapDrawable);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302399));
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        if (VipFunCallManager.b() != this.jdField_a_of_type_Int) {
          break label422;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText("已设置");
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      label266:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302398));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298458));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.app.b(this.jdField_a_of_type_JavaLangString));
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298459));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        paramBundle = (FriendManager)this.app.getManager(8);
        if (paramBundle == null) {
          break label448;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver, true);
      return true;
      if (this.jdField_b_of_type_Int != VipFunCallManager.jdField_b_of_type_Int) {
        break;
      }
      paramBundle = VipFunCallManager.a(paramBundle);
      if (paramBundle == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetVideoView.setBackgroundDrawable(paramBundle);
      a();
      break;
      label422:
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setText(b(this.jdField_a_of_type_Int));
      break label266;
      label448:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_AndroidWidgetVideoView != null) && (this.jdField_a_of_type_AndroidWidgetVideoView.isPlaying()) && (this.jdField_b_of_type_Int == VipFunCallManager.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetVideoView.pause();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.c();
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_AndroidWidgetVideoView != null) && (!this.jdField_a_of_type_AndroidWidgetVideoView.isPlaying()) && (this.jdField_b_of_type_Int == VipFunCallManager.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetVideoView.resume();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.d())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    int j = ((SVIPHandler)this.app.a(12)).f();
    int i = j;
    if (j == 3) {
      i = 2;
    }
    try
    {
      paramView = VipFunCallManager.a().getJSONArray("items");
      j = 0;
      while (j < paramView.length())
      {
        JSONObject localJSONObject = paramView.getJSONObject(j);
        if ((localJSONObject != null) && (localJSONObject.getInt("id") == this.jdField_a_of_type_Int))
        {
          int k = localJSONObject.getInt("vip_type");
          VipUtils.a(this.app, "QQVIPFUNCALL", "0X8004D8D", "0X8004D8D", i, k, new String[] { String.valueOf(this.jdField_a_of_type_Int) });
        }
        j += 1;
      }
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      if (this.jdField_a_of_type_Int > 0)
      {
        paramView = (VipFunCallManager)this.app.getManager(79);
        if (paramView != null)
        {
          i = paramView.a(this.jdField_a_of_type_Int);
          if (i == VipFunCallManager.e)
          {
            a(1, this.jdField_a_of_type_Int);
            return;
          }
          if (i == VipFunCallManager.f)
          {
            a(2, this.jdField_a_of_type_Int);
            return;
          }
        }
      }
      ((VipSetFunCallHandler)this.app.a(48)).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = new Rect();
      getWindow().findViewById(16908290).getDrawingRect((Rect)localObject);
      int i = ((Rect)localObject).width();
      int m = ((Rect)localObject).height() - ProfileCardUtil.c(this, 102);
      if (this.jdField_a_of_type_AndroidWidgetVideoView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetVideoView.getLayoutParams();
        int j = (int)(i * 0.75F);
        int k = (int)(i * 0.75F * 1.5F);
        i = k;
        if (k > m)
        {
          i = m - 50;
          j = (int)(m / 1.5F);
        }
        k = (m - i) / 2;
        ((RelativeLayout.LayoutParams)localObject).width = j;
        ((RelativeLayout.LayoutParams)localObject).height = i;
        ((RelativeLayout.LayoutParams)localObject).topMargin = k;
        this.jdField_a_of_type_AndroidWidgetVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 20);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 30);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ProfileCardUtil.c(this, 20);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */