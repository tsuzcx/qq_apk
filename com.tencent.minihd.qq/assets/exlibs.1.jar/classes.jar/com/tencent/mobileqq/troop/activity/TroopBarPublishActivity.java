package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kgd;
import kge;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishActivity
  extends AbsPublishActivity
{
  protected static final int aa = 2000;
  public static final String ah = TroopBarPublishActivity.class.getName();
  Animation.AnimationListener a;
  public TroopBarMyBar a;
  public final int ab;
  public int ac;
  public int ad;
  public int ae;
  protected String ai;
  protected View e;
  protected TextView f = null;
  protected boolean m = false;
  public boolean n = false;
  
  public TroopBarPublishActivity()
  {
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
    this.jdField_ab_of_type_Int = 4;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new kge(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_b_of_type_JavaUtilArrayList.size()))
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() == 1)
      {
        a(0);
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
        if (this.jdField_b_of_type_JavaUtilArrayList.size() < paramInt2) {
          bool = true;
        }
        ((TroopBarImagePreviewAdapter)localObject).a(bool, true);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
    else {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label131;
      }
    }
    label131:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "del_photo", (String)localObject, "", "", "");
      return;
      if (this.n) {
        break;
      }
      this.jdField_ad_of_type_Int = paramInt1;
      this.jdField_ae_of_type_Int = paramInt2;
      c(paramInt1);
      break;
    }
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(paramInt))
    {
      a(this, TroopBarPublishActivity.class.getName());
      return;
    }
    AlbumUtil.a();
    paramView = new Intent(this, ImagePreviewActivity.class);
    paramView.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", TroopBarPublishActivity.class.getName());
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_b_of_type_JavaUtilArrayList);
    paramView.putExtra("selected_photo_index", paramInt);
    paramView.putExtra("back_btn_text", getString(2131363889));
    paramView.addFlags(603979776);
    startActivity(paramView);
    AlbumUtil.a(this, true, true);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
    for (paramView = "0";; paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "choose_photo", paramView, "", "", "");
      return;
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      l = Long.parseLong(paramJSONObject.optString("bid"));
      this.ai = paramJSONObject.optString("extparam");
      if (l > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = new TroopBarMyBar(l, paramJSONObject.optString("barName"));
        this.aa = (this.app.a() + "-" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x);
        this.af = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
      }
      this.jdField_ad_of_type_JavaLangString = "Grp_tribe";
      this.jdField_ae_of_type_JavaLangString = "pub_page";
      b(paramJSONObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, localNumberFormatException.getMessage());
        }
        long l = 0L;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    super.a(paramJSONObject, paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.optInt("retcode", -1) == -1) {
          break;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.m))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.af = null;
        }
      }
      if (this.jdField_c_of_type_Boolean) {
        r();
      }
    } while (!this.m);
    this.m = false;
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.f = paramJSONObject.optInt("flag");
    }
    this.j = paramJSONObject.optBoolean("photoOrContent");
    this.Z = paramJSONObject.optString("from");
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory", true);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("minTitleLength", this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = paramJSONObject.optInt("maxTitleLength", this.jdField_c_of_type_Int);
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_e_of_type_JavaLangString);
    this.P = paramJSONObject.optInt("minContentLength", this.P);
    this.Q = paramJSONObject.optInt("maxContentLength", this.Q);
    this.X = paramJSONObject.optString("contentPlaceholder", this.X);
    this.h = paramJSONObject.optBoolean("needLocation", true);
    this.i = paramJSONObject.optBoolean("needFace", true);
    paramBundle = paramJSONObject.optJSONArray("categorys");
    if (paramBundle == null) {
      paramBundle = paramJSONObject.optJSONArray("typelist");
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          JSONObject localJSONObject = paramBundle.optJSONObject(paramInt);
          if (localJSONObject != null) {
            localArrayList.add(new TroopBarPageEntity.TypeListEntity(localJSONObject));
          }
          paramInt += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      for (;;)
      {
        try
        {
          paramBundle = paramJSONObject.getJSONObject("publish_condition");
          if (paramBundle.optInt("requireType", 0) == 0) {
            continue;
          }
          bool = true;
          this.l = bool;
          if (!this.jdField_c_of_type_Boolean) {
            continue;
          }
          if (!this.m) {
            continue;
          }
          this.U |= paramBundle.optInt("optionType");
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.f == 1)) {
            this.U |= 0x1;
          }
          if (paramBundle.optInt("recordTimeLimit") != 0) {
            continue;
          }
          paramInt = 60000;
          this.S = paramInt;
          if (paramBundle.optInt("videoTimeLimit") != 0) {
            continue;
          }
          paramInt = 60000;
          this.T = paramInt;
          if (paramBundle.optLong("videoSizeLimit") != 0L) {
            continue;
          }
          l = 209715200L;
          this.jdField_a_of_type_Long = l;
          this.W = paramBundle.optInt("forbiddenType", 0);
          this.jdField_ab_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131364084));
        }
        catch (JSONException paramBundle)
        {
          boolean bool;
          long l;
          continue;
          paramInt = 0;
          continue;
        }
        a();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kgd(this), 200L);
        c(paramJSONObject);
        break;
        bool = false;
        continue;
        this.U = paramBundle.optInt("optionType");
        continue;
        if (!"barindex".equals(this.Z)) {
          continue;
        }
        paramInt = 1;
        this.U = paramBundle.optInt("optionType", paramInt);
        continue;
        paramInt = paramBundle.optInt("recordTimeLimit") * 1000;
        continue;
        paramInt = paramBundle.optInt("videoTimeLimit") * 1000;
        continue;
        l = paramBundle.optLong("videoSizeLimit");
        l = l * 1024L * 1024L;
      }
    }
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("share_from_app");
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("share_info");
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    TroopBarShareUtils.a(this.app, "share_ask", paramJSONObject.optString("bid"));
    this.h = true;
    this.i = true;
    this.jdField_a_of_type_Boolean = false;
    this.Z = "";
    this.jdField_b_of_type_Int = 4;
    this.jdField_c_of_type_Int = 25;
    this.jdField_e_of_type_JavaLangString = getString(2131363887, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
    this.P = 10;
    this.Q = 700;
    this.X = getString(2131363888, new Object[] { Integer.valueOf(this.P), Integer.valueOf(this.Q) });
    this.U |= 0x1;
  }
  
  public void c(int paramInt)
  {
    boolean bool = false;
    if (paramInt == 8)
    {
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() < this.jdField_ae_of_type_Int) {
        bool = true;
      }
      ((TroopBarImagePreviewAdapter)localObject1).a(bool, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
    }
    label126:
    do
    {
      return;
      this.jdField_ac_of_type_Int = 0;
      this.n = true;
      localObject1 = a(1.0F, 0.0F);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
      if (localObject2 != null) {
        ((View)localObject2).startAnimation((Animation)localObject1);
      }
      paramInt += 1;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        int j;
        int i;
        if (paramInt % 4 == 0)
        {
          j = 3;
          i = -1;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
          localObject2 = b(j, i);
          ((Animation)localObject2).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          if (localObject1 != null) {
            break label174;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          i = 0;
          j = -1;
          break label126;
          ((View)localObject1).startAnimation((Animation)localObject2);
          this.jdField_ac_of_type_Int += 1;
        }
      }
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
    } while ((paramInt != 4) && (paramInt != 8));
    label174:
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a());
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject1);
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.m) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.v = paramJSONObject.optString("barName");
      this.f.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.v);
      paramJSONObject = getString(2131363929, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.v });
      this.jdField_e_of_type_AndroidViewView.setContentDescription(paramJSONObject);
      this.f.setContentDescription(paramJSONObject);
    }
  }
  
  protected void d(int paramInt)
  {
    if (paramInt == 1) {
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      a(0);
      return;
      if (paramInt == 4) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
      } else if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      case 1002: 
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j))
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
            a(1, new String[] { paramIntent });
            label96:
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
              break label146;
            }
          }
        }
        label146:
        for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
        {
          TroopBarUtils.a("pub_page", "choose_place", paramIntent, "2", "", "");
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
          break;
          a(0, new String[0]);
          break label96;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)paramIntent.getParcelableExtra("key_selected_item"));
      paramInt1 = paramIntent.getIntExtra("key_drop_media_data", -1);
      this.af = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
      {
        this.aa = (this.app.a() + "-" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x);
        this.f.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.v);
        paramIntent = getString(2131363929, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.v });
        this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
        this.f.setContentDescription(paramIntent);
        paramIntent = new Bundle();
        paramIntent.putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x);
        TroopBarUtils.b(this, paramIntent, "https://xiaoqu.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
        if (this.jdField_c_of_type_Boolean)
        {
          this.l = false;
          this.U = 0;
        }
      }
      while (paramInt1 > 0)
      {
        d(paramInt1);
        return;
        this.f.setText(null);
        paramIntent = getString(2131363928);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(paramIntent);
        this.f.setContentDescription(paramIntent);
      }
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_e_of_type_AndroidViewView = ((ViewStub)findViewById(2131298804)).inflate();
    this.f = ((TextView)findViewById(2131298820));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (!"barindex".equals(this.Z))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x);
        this.m = true;
        TroopBarUtils.b(this, (Bundle)localObject, "https://xiaoqu.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.jdField_c_of_type_Boolean) {
        b(2131363692);
      }
      u();
      StringBuffer localStringBuffer = new StringBuffer();
      if ((this.U & 0x1) == 1) {
        localStringBuffer.append("0");
      }
      if ((this.U & 0x2) == 2) {
        localStringBuffer.append("1");
      }
      if ((this.U & 0x4) == 4) {
        localStringBuffer.append("2");
      }
      if ((this.U & 0x8) == 8) {
        localStringBuffer.append("3");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label282;
      }
      localObject = "0";
      label226:
      TroopBarUtils.a("pub_page", "exp", (String)localObject, this.jdField_ac_of_type_JavaLangString, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label293;
      }
    }
    label282:
    label293:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "choose_place", (String)localObject, "0", "", "");
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
      break label226;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.d) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      TroopBarShareUtils.a(this, this.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id"));
    }
    String str1;
    if (!this.d)
    {
      if (((this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText.length() <= 0)) && ((this.jdField_b_of_type_AndroidWidgetEditText == null) || (this.jdField_b_of_type_AndroidWidgetEditText.length() <= 0)) && ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0))) {
        break label125;
      }
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label132;
      }
    }
    label132:
    for (String str2 = "0";; str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "un", str2, str1, "", "");
      return;
      label125:
      str1 = "1";
      break;
    }
  }
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 655	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   4: invokestatic 664	com/tencent/util/InputMethodUtil:b	(Landroid/view/View;)V
    //   7: aload_0
    //   8: getfield 667	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask	Lcom/tencent/mobileqq/troop/activity/AbsPublishIphoneTitleBarActivity$PreUploadTask;
    //   11: ifnull +16 -> 27
    //   14: aload_0
    //   15: getfield 667	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask	Lcom/tencent/mobileqq/troop/activity/AbsPublishIphoneTitleBarActivity$PreUploadTask;
    //   18: iconst_1
    //   19: putfield 670	com/tencent/mobileqq/troop/activity/AbsPublishIphoneTitleBarActivity$PreUploadTask:jdField_a_of_type_Boolean	Z
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 667	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask	Lcom/tencent/mobileqq/troop/activity/AbsPublishIphoneTitleBarActivity$PreUploadTask;
    //   27: aload_0
    //   28: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   31: ifnonnull +61 -> 92
    //   34: aload_0
    //   35: ldc_w 671
    //   38: iconst_1
    //   39: invokestatic 676	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   42: aload_0
    //   43: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   46: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   49: pop
    //   50: aload_0
    //   51: invokevirtual 685	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:t	()V
    //   54: aload_0
    //   55: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   58: ifnonnull +23 -> 81
    //   61: ldc 92
    //   63: astore_2
    //   64: ldc 94
    //   66: ldc_w 687
    //   69: aload_2
    //   70: ldc_w 689
    //   73: ldc 98
    //   75: ldc 98
    //   77: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   80: return
    //   81: aload_0
    //   82: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   85: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   88: astore_2
    //   89: goto -25 -> 64
    //   92: aload_0
    //   93: getfield 650	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   96: invokestatic 692	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Landroid/widget/EditText;)Ljava/lang/String;
    //   99: astore_2
    //   100: aload_2
    //   101: invokestatic 564	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +1124 -> 1228
    //   107: aload_2
    //   108: invokevirtual 695	java/lang/String:trim	()Ljava/lang/String;
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 696	java/lang/String:length	()I
    //   116: istore_1
    //   117: iload_1
    //   118: ifne +56 -> 174
    //   121: aload_0
    //   122: ldc_w 697
    //   125: iconst_0
    //   126: invokestatic 676	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   129: aload_0
    //   130: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   133: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   136: pop
    //   137: aload_0
    //   138: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   141: ifnonnull +22 -> 163
    //   144: ldc 92
    //   146: astore_2
    //   147: ldc 94
    //   149: ldc_w 687
    //   152: aload_2
    //   153: ldc 92
    //   155: ldc 98
    //   157: ldc 98
    //   159: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: return
    //   163: aload_0
    //   164: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   167: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   170: astore_2
    //   171: goto -24 -> 147
    //   174: iload_1
    //   175: aload_0
    //   176: getfield 294	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_Int	I
    //   179: if_icmpge +74 -> 253
    //   182: aload_0
    //   183: aload_0
    //   184: ldc_w 698
    //   187: iconst_1
    //   188: anewarray 465	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: getfield 294	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_Int	I
    //   197: invokestatic 471	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: invokevirtual 474	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   204: iconst_0
    //   205: invokestatic 701	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   208: aload_0
    //   209: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   212: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   215: pop
    //   216: aload_0
    //   217: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   220: ifnonnull +22 -> 242
    //   223: ldc 92
    //   225: astore_2
    //   226: ldc 94
    //   228: ldc_w 687
    //   231: aload_2
    //   232: ldc 92
    //   234: ldc 98
    //   236: ldc 98
    //   238: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   241: return
    //   242: aload_0
    //   243: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   246: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   249: astore_2
    //   250: goto -24 -> 226
    //   253: iload_1
    //   254: aload_0
    //   255: getfield 298	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_c_of_type_Int	I
    //   258: if_icmple +75 -> 333
    //   261: aload_0
    //   262: aload_0
    //   263: ldc_w 702
    //   266: iconst_1
    //   267: anewarray 465	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: getfield 298	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_c_of_type_Int	I
    //   276: invokestatic 471	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: aastore
    //   280: invokevirtual 474	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   283: iconst_0
    //   284: invokestatic 701	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   287: aload_0
    //   288: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   291: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   294: pop
    //   295: aload_0
    //   296: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   299: ifnonnull +23 -> 322
    //   302: ldc 92
    //   304: astore_2
    //   305: ldc 94
    //   307: ldc_w 687
    //   310: aload_2
    //   311: ldc_w 630
    //   314: ldc 98
    //   316: ldc 98
    //   318: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   321: return
    //   322: aload_0
    //   323: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   326: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   329: astore_2
    //   330: goto -25 -> 305
    //   333: aload_0
    //   334: getfield 655	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   337: invokestatic 692	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Landroid/widget/EditText;)Ljava/lang/String;
    //   340: astore_3
    //   341: aload_3
    //   342: invokestatic 564	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifne +878 -> 1223
    //   348: aload_3
    //   349: invokevirtual 695	java/lang/String:trim	()Ljava/lang/String;
    //   352: astore_3
    //   353: aload_3
    //   354: invokevirtual 696	java/lang/String:length	()I
    //   357: istore_1
    //   358: aload_0
    //   359: getfield 279	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:j	Z
    //   362: ifeq +13 -> 375
    //   365: aload_0
    //   366: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   369: invokevirtual 704	java/util/ArrayList:isEmpty	()Z
    //   372: ifeq +221 -> 593
    //   375: iload_1
    //   376: ifne +57 -> 433
    //   379: aload_0
    //   380: ldc_w 705
    //   383: iconst_0
    //   384: invokestatic 676	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   387: aload_0
    //   388: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   391: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   394: pop
    //   395: aload_0
    //   396: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   399: ifnonnull +23 -> 422
    //   402: ldc 92
    //   404: astore_2
    //   405: ldc 94
    //   407: ldc_w 687
    //   410: aload_2
    //   411: ldc_w 574
    //   414: ldc 98
    //   416: ldc 98
    //   418: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   421: return
    //   422: aload_0
    //   423: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   426: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   429: astore_2
    //   430: goto -25 -> 405
    //   433: iload_1
    //   434: aload_0
    //   435: getfield 310	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:P	I
    //   438: if_icmpge +75 -> 513
    //   441: aload_0
    //   442: aload_0
    //   443: ldc_w 706
    //   446: iconst_1
    //   447: anewarray 465	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: aload_0
    //   453: getfield 310	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:P	I
    //   456: invokestatic 471	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: invokevirtual 474	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   463: iconst_0
    //   464: invokestatic 701	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   467: aload_0
    //   468: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   471: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   474: pop
    //   475: aload_0
    //   476: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   479: ifnonnull +23 -> 502
    //   482: ldc 92
    //   484: astore_2
    //   485: ldc 94
    //   487: ldc_w 687
    //   490: aload_2
    //   491: ldc_w 574
    //   494: ldc 98
    //   496: ldc 98
    //   498: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   501: return
    //   502: aload_0
    //   503: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   506: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   509: astore_2
    //   510: goto -25 -> 485
    //   513: iload_1
    //   514: aload_0
    //   515: getfield 315	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:Q	I
    //   518: if_icmple +75 -> 593
    //   521: aload_0
    //   522: aload_0
    //   523: ldc_w 707
    //   526: iconst_1
    //   527: anewarray 465	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload_0
    //   533: getfield 315	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:Q	I
    //   536: invokestatic 471	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: invokevirtual 474	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   543: iconst_0
    //   544: invokestatic 701	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   547: aload_0
    //   548: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   551: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   554: pop
    //   555: aload_0
    //   556: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   559: ifnonnull +23 -> 582
    //   562: ldc 92
    //   564: astore_2
    //   565: ldc 94
    //   567: ldc_w 687
    //   570: aload_2
    //   571: ldc_w 709
    //   574: ldc 98
    //   576: ldc 98
    //   578: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   581: return
    //   582: aload_0
    //   583: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   586: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   589: astore_2
    //   590: goto -25 -> 565
    //   593: aload_0
    //   594: aload_0
    //   595: getfield 372	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:U	I
    //   598: aload_0
    //   599: getfield 369	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:l	Z
    //   602: invokevirtual 712	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:a	(IZ)Z
    //   605: ifeq -525 -> 80
    //   608: aload_0
    //   609: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   612: getfield 270	com/tencent/mobileqq/troop/data/TroopBarMyBar:f	I
    //   615: iconst_1
    //   616: if_icmpne +74 -> 690
    //   619: aload_0
    //   620: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   623: ifnull +13 -> 636
    //   626: aload_0
    //   627: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   630: invokevirtual 704	java/util/ArrayList:isEmpty	()Z
    //   633: ifeq +57 -> 690
    //   636: aload_0
    //   637: ldc_w 713
    //   640: iconst_0
    //   641: invokestatic 676	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   644: aload_0
    //   645: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   648: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   651: pop
    //   652: aload_0
    //   653: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   656: ifnonnull +23 -> 679
    //   659: ldc 92
    //   661: astore_2
    //   662: ldc 94
    //   664: ldc_w 687
    //   667: aload_2
    //   668: ldc_w 715
    //   671: ldc 98
    //   673: ldc 98
    //   675: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   678: return
    //   679: aload_0
    //   680: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   683: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   686: astore_2
    //   687: goto -25 -> 662
    //   690: aload_0
    //   691: invokestatic 720	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   694: ifne +57 -> 751
    //   697: aload_0
    //   698: ldc_w 721
    //   701: iconst_0
    //   702: invokestatic 676	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   705: aload_0
    //   706: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   709: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   712: pop
    //   713: aload_0
    //   714: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   717: ifnonnull +23 -> 740
    //   720: ldc 92
    //   722: astore_2
    //   723: ldc 94
    //   725: ldc_w 687
    //   728: aload_2
    //   729: ldc_w 723
    //   732: ldc 98
    //   734: ldc 98
    //   736: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   739: return
    //   740: aload_0
    //   741: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   744: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   747: astore_2
    //   748: goto -25 -> 723
    //   751: aload_0
    //   752: iconst_1
    //   753: invokevirtual 725	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:b	(Z)V
    //   756: aload_0
    //   757: getfield 61	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:rightViewText	Landroid/widget/TextView;
    //   760: iconst_0
    //   761: invokevirtual 728	android/widget/TextView:setEnabled	(Z)V
    //   764: aload_0
    //   765: getfield 532	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer	Lcom/tencent/mobileqq/troop/widget/PublishItemContainer;
    //   768: iconst_0
    //   769: invokevirtual 731	com/tencent/mobileqq/troop/widget/PublishItemContainer:setItemEnable	(Z)V
    //   772: aload_0
    //   773: getfield 482	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView	Lcom/tencent/mobileqq/troop/activity/ExtendGridView;
    //   776: iconst_0
    //   777: invokevirtual 732	com/tencent/mobileqq/troop/activity/ExtendGridView:setEnabled	(Z)V
    //   780: iconst_0
    //   781: istore_1
    //   782: iload_1
    //   783: aload_0
    //   784: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   787: invokevirtual 72	java/util/ArrayList:size	()I
    //   790: if_icmpge +84 -> 874
    //   793: aload_0
    //   794: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   797: iload_1
    //   798: invokevirtual 735	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   801: checkcast 427	java/lang/String
    //   804: astore 4
    //   806: getstatic 738	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	Ljava/util/Hashtable;
    //   809: aload 4
    //   811: invokevirtual 743	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: checkcast 745	com/tencent/mobileqq/data/TroopBarPostContentEntity$Pic_list
    //   817: ifnonnull +50 -> 867
    //   820: aload_0
    //   821: iconst_1
    //   822: aload_0
    //   823: getfield 410	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   826: invokevirtual 748	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:a	(ILandroid/os/Handler;)V
    //   829: aload_0
    //   830: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   833: ifnonnull +23 -> 856
    //   836: ldc 92
    //   838: astore_2
    //   839: ldc 94
    //   841: ldc_w 687
    //   844: aload_2
    //   845: ldc_w 750
    //   848: ldc 98
    //   850: ldc 98
    //   852: invokestatic 103	com/tencent/mobileqq/troop/utils/TroopBarUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   855: return
    //   856: aload_0
    //   857: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   860: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   863: astore_2
    //   864: goto -25 -> 839
    //   867: iload_1
    //   868: iconst_1
    //   869: iadd
    //   870: istore_1
    //   871: goto -89 -> 782
    //   874: aload_0
    //   875: getfield 541	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo	Lcom/tencent/mobileqq/troop/data/AudioInfo;
    //   878: ifnull +23 -> 901
    //   881: aload_0
    //   882: getfield 541	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo	Lcom/tencent/mobileqq/troop/data/AudioInfo;
    //   885: getfield 755	com/tencent/mobileqq/troop/data/AudioInfo:url	Ljava/lang/String;
    //   888: ifnonnull +13 -> 901
    //   891: aload_0
    //   892: iconst_2
    //   893: aload_0
    //   894: getfield 410	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   897: invokevirtual 748	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:a	(ILandroid/os/Handler;)V
    //   900: return
    //   901: aload_0
    //   902: getfield 758	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo	Lcom/tencent/mobileqq/troop/data/VideoInfo;
    //   905: ifnull +23 -> 928
    //   908: aload_0
    //   909: getfield 758	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo	Lcom/tencent/mobileqq/troop/data/VideoInfo;
    //   912: getfield 761	com/tencent/mobileqq/troop/data/VideoInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   915: ifnonnull +13 -> 928
    //   918: aload_0
    //   919: iconst_3
    //   920: aload_0
    //   921: getfield 410	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   924: invokevirtual 748	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:a	(ILandroid/os/Handler;)V
    //   927: return
    //   928: aload_3
    //   929: aload_0
    //   930: getfield 66	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   933: aload_0
    //   934: getfield 538	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo	Lcom/tencent/mobileqq/troop/data/MusicInfo;
    //   937: aload_0
    //   938: getfield 541	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo	Lcom/tencent/mobileqq/troop/data/AudioInfo;
    //   941: aload_0
    //   942: getfield 758	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo	Lcom/tencent/mobileqq/troop/data/VideoInfo;
    //   945: invokestatic 764	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:a	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/troop/data/MusicInfo;Lcom/tencent/mobileqq/troop/data/AudioInfo;Lcom/tencent/mobileqq/troop/data/VideoInfo;)Ljava/lang/String;
    //   948: astore 4
    //   950: new 180	org/json/JSONObject
    //   953: dup
    //   954: invokespecial 765	org/json/JSONObject:<init>	()V
    //   957: astore_3
    //   958: aload_0
    //   959: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   962: ifnonnull +215 -> 1177
    //   965: iconst_0
    //   966: istore_1
    //   967: aload_3
    //   968: ldc 178
    //   970: iload_1
    //   971: invokevirtual 769	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   974: pop
    //   975: aload_3
    //   976: ldc_w 771
    //   979: aload 4
    //   981: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   984: pop
    //   985: aload_3
    //   986: ldc_w 776
    //   989: aload_2
    //   990: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   993: pop
    //   994: aload_0
    //   995: getfield 556	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   998: ifnull +54 -> 1052
    //   1001: aload_3
    //   1002: ldc_w 778
    //   1005: aload_0
    //   1006: getfield 556	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   1009: getfield 780	com/tencent/mobileqq/troop/data/TroopBarPOI:h	Ljava/lang/String;
    //   1012: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1015: pop
    //   1016: aload_3
    //   1017: ldc_w 782
    //   1020: aload_0
    //   1021: getfield 556	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   1024: getfield 783	com/tencent/mobileqq/troop/data/TroopBarPOI:jdField_b_of_type_Int	I
    //   1027: invokestatic 785	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1030: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1033: pop
    //   1034: aload_3
    //   1035: ldc_w 787
    //   1038: aload_0
    //   1039: getfield 556	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   1042: getfield 789	com/tencent/mobileqq/troop/data/TroopBarPOI:a	I
    //   1045: invokestatic 785	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1048: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1051: pop
    //   1052: aload_0
    //   1053: getfield 792	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity	Lcom/tencent/mobileqq/data/TroopBarPageEntity$TypeListEntity;
    //   1056: ifnull +135 -> 1191
    //   1059: aload_0
    //   1060: getfield 792	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity	Lcom/tencent/mobileqq/data/TroopBarPageEntity$TypeListEntity;
    //   1063: getfield 795	com/tencent/mobileqq/data/TroopBarPageEntity$TypeListEntity:type	I
    //   1066: istore_1
    //   1067: aload_3
    //   1068: ldc_w 796
    //   1071: iload_1
    //   1072: invokevirtual 769	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1075: pop
    //   1076: aload_3
    //   1077: ldc 192
    //   1079: aload_0
    //   1080: getfield 194	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:ai	Ljava/lang/String;
    //   1083: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1086: pop
    //   1087: new 798	mqq/app/NewIntent
    //   1090: dup
    //   1091: aload_0
    //   1092: invokespecial 802	com/tencent/mobileqq/troop/activity/AbsPublishActivity:getApplicationContext	()Landroid/content/Context;
    //   1095: ldc_w 804
    //   1098: invokespecial 805	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1101: astore_2
    //   1102: aload_2
    //   1103: ldc_w 807
    //   1106: ldc_w 809
    //   1109: invokevirtual 810	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1112: pop
    //   1113: new 812	com/tencent/mobileqq/WebSsoBody$WebSsoRequestBody
    //   1116: dup
    //   1117: invokespecial 813	com/tencent/mobileqq/WebSsoBody$WebSsoRequestBody:<init>	()V
    //   1120: astore 4
    //   1122: aload 4
    //   1124: getfield 816	com/tencent/mobileqq/WebSsoBody$WebSsoRequestBody:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1127: iconst_0
    //   1128: invokevirtual 821	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1131: aload 4
    //   1133: getfield 825	com/tencent/mobileqq/WebSsoBody$WebSsoRequestBody:data	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1136: aload_3
    //   1137: invokevirtual 826	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1140: invokevirtual 831	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1143: aload_2
    //   1144: ldc_w 832
    //   1147: aload 4
    //   1149: invokevirtual 836	com/tencent/mobileqq/WebSsoBody$WebSsoRequestBody:toByteArray	()[B
    //   1152: invokevirtual 839	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1155: pop
    //   1156: aload_2
    //   1157: new 841	kgf
    //   1160: dup
    //   1161: aload_0
    //   1162: invokespecial 842	kgf:<init>	(Lcom/tencent/mobileqq/troop/activity/TroopBarPublishActivity;)V
    //   1165: invokevirtual 846	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   1168: aload_0
    //   1169: getfield 206	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1172: aload_2
    //   1173: invokevirtual 850	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   1176: return
    //   1177: aload_0
    //   1178: getfield 44	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   1181: getfield 115	com/tencent/mobileqq/troop/data/TroopBarMyBar:x	Ljava/lang/String;
    //   1184: invokestatic 853	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1187: istore_1
    //   1188: goto -221 -> 967
    //   1191: iconst_0
    //   1192: istore_1
    //   1193: goto -126 -> 1067
    //   1196: astore_2
    //   1197: aload_0
    //   1198: iconst_1
    //   1199: ldc_w 854
    //   1202: iconst_0
    //   1203: invokestatic 857	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   1206: aload_0
    //   1207: invokevirtual 679	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:getTitleBarHeight	()I
    //   1210: invokevirtual 682	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1213: pop
    //   1214: aload_2
    //   1215: invokevirtual 860	java/lang/Exception:printStackTrace	()V
    //   1218: return
    //   1219: astore_2
    //   1220: goto -1213 -> 7
    //   1223: iconst_0
    //   1224: istore_1
    //   1225: goto -867 -> 358
    //   1228: iconst_0
    //   1229: istore_1
    //   1230: goto -1113 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1233	0	this	TroopBarPublishActivity
    //   116	1114	1	i	int
    //   63	1110	2	localObject1	Object
    //   1196	19	2	localException1	java.lang.Exception
    //   1219	1	2	localException2	java.lang.Exception
    //   340	797	3	localObject2	Object
    //   804	344	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   958	965	1196	java/lang/Exception
    //   967	1052	1196	java/lang/Exception
    //   1052	1067	1196	java/lang/Exception
    //   1067	1087	1196	java/lang/Exception
    //   1177	1188	1196	java/lang/Exception
    //   0	7	1219	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131298817: 
    default: 
      return;
    case 2131298818: 
      s();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      paramView = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label100;
      }
    }
    label100:
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("pub_page", "Clk_place", paramView, str, "", "");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
      break;
    }
  }
  
  protected void s()
  {
    t();
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {
        break label50;
      }
    }
    label50:
    for (String str2 = "0";; str2 = "1")
    {
      TroopBarUtils.a("pub_page", "choose_tribe", str1, str2, "", "");
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
      break;
    }
  }
  
  protected void t()
  {
    Intent localIntent = new Intent(this, TroopBarPublishBarSelectActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      localIntent.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    }
    int i = -1;
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i > 0) {
        localIntent.putExtra("key_media_data", i);
      }
      startActivityForResult(localIntent, 2000);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo != null) {
        i = 4;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        i = 2;
      }
    }
  }
  
  protected void u()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      Object localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_title");
      Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_content");
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_img_list");
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_c_of_type_Int) });
      }
      if (this.jdField_b_of_type_AndroidWidgetEditText != null)
      {
        localObject3 = this.jdField_b_of_type_AndroidWidgetEditText;
        if (localObject2 != null) {
          break label209;
        }
      }
      label209:
      for (Object localObject1 = "";; localObject1 = localObject2)
      {
        ((EditText)localObject3).setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.X);
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject1 = str.split(";");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          return;
        }
        localObject2 = new ArrayList();
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = new AbsPublishIphoneTitleBarActivity.PreUploadTask(this, this, this.jdField_b_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */