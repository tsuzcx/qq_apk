package com.tencent.mobileqq.troop.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.MusicInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.data.VideoInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataCacheEntity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import kbi;
import kbj;
import kbk;
import kbl;
import kbm;
import kbn;
import kbo;
import kbr;
import kbs;
import kbt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsPublishActivity
  extends AbsPublishIphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodLinearLayout.onSizeChangeListenner
{
  protected static final int a = 200;
  protected static final String a = "needCategory";
  private static final int aa = 100;
  protected static final String b = "titlePlaceholder";
  protected static final String c = "minTitleLength";
  protected static final int d = 4;
  protected static final String d = "maxTitleLength";
  protected static final int e = 25;
  protected static final int f = 10;
  protected static final int g = 700;
  protected BroadcastReceiver a;
  protected Drawable a;
  protected Handler a;
  protected View a;
  public EditText a;
  protected FrameLayout a;
  public ImageButton a;
  protected ImageView a;
  public RelativeLayout a;
  protected TextView a;
  public TroopBarPageEntity.TypeListEntity a;
  public SystemEmoticonPanel a;
  public ExtendGridView a;
  public TroopBarImagePreviewAdapter a;
  public PublishItemBar a;
  public PublishItemContainer a;
  protected InputMethodLinearLayout a;
  public QQProgressDialog a;
  protected ScrollView a;
  public ArrayList a;
  public JSONObject a;
  protected boolean a;
  protected int b;
  public View b;
  protected ImageView b;
  protected TextView b;
  protected boolean b;
  protected int c;
  public View c;
  public TextView c;
  public boolean c;
  protected String e;
  protected String f = null;
  
  public AbsPublishActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = null;
    this.jdField_a_of_type_ComTencentWidgetScrollView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kbn(this);
    this.jdField_a_of_type_AndroidOsHandler = new kbo(this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findFocus() == this.jdField_b_of_type_AndroidWidgetEditText) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841082);
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131363925));
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void s()
  {
    if (((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      localActionSheet.a(((TroopBarPageEntity.TypeListEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).name, 1);
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity != null) {
      localActionSheet.a(2131363939, 3);
    }
    localActionSheet.e(2131365736);
    localActionSheet.a(new kbm(this, j, localActionSheet));
    localActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
  }
  
  public Animation a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Resources localResources = getResources();
      paramInt = (int)localResources.getDimension(2131493241);
      int i = (int)localResources.getDimension(2131493242);
      if (this.U == 0) {}
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), paramInt);
        g();
        return;
        paramInt = paramInt + i + localResources.getDrawable(2130839190).getIntrinsicHeight();
      }
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(0);
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public void a(int paramInt, MediaInfo paramMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
    a(paramInt);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((paramMediaInfo instanceof MusicInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = ((MusicInfo)paramMediaInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
    }
    do
    {
      return;
      if ((paramMediaInfo instanceof AudioInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
        return;
      }
    } while (!(paramMediaInfo instanceof VideoInfo));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = ((VideoInfo)paramMediaInfo);
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    Object localObject = "";
    boolean bool;
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      paramInt = 8;
      bool = false;
      label44:
      this.jdField_a_of_type_AndroidViewView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if (!bool) {
        break;
      }
    }
    for (paramVarArgs = getString(2131363922, new Object[] { paramVarArgs });; paramVarArgs = getString(2131363921))
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramVarArgs);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131365218);
      paramInt = 8;
      bool = false;
      break label44;
      String str = getString(2131365217);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      paramVarArgs = str;
      paramInt = 8;
      bool = false;
      break label44;
      paramVarArgs = getString(2131365216);
      paramInt = 8;
      bool = false;
      break label44;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        paramInt = 0;
        bool = true;
        break label44;
      }
      a(0, new String[0]);
      return;
    }
  }
  
  abstract void a(View paramView, int paramInt, long paramLong);
  
  void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("minTitleLength", this.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = paramJSONObject.optInt("maxTitleLength", this.jdField_c_of_type_Int);
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("titlePlaceholder", this.jdField_e_of_type_JavaLangString);
    if ("barindex".equals(this.Z)) {}
    for (paramJSONObject = "0";; paramJSONObject = "1")
    {
      this.ac = paramJSONObject;
      q();
      com.tencent.biz.common.util.ImageUtil.b((String)null, 0);
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("key_photo_delete_action");
      paramJSONObject.addAction("key_music_delete_action");
      paramJSONObject.addAction("key_audio_delete_action");
      paramJSONObject.addAction("key_video_delete_action");
      paramJSONObject.addAction("key_audio_play_action");
      paramJSONObject.addAction("key_video_play_action");
      paramJSONObject.addAction("key_video_select_apply_click");
      paramJSONObject.addAction("key_video_time_overflow");
      paramJSONObject.addAction("key_video_size_overflow");
      paramJSONObject.addAction("key_video_select_confirm_ok_click");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_c_of_type_JavaUtilArrayList == null)
        {
          this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
          break label226;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_c_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_c_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_c_of_type_JavaUtilArrayList.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      label226:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  protected boolean a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.aa);
    }
    if (TextUtils.isEmpty(this.aa)) {
      return false;
    }
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.a.get(this.aa);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.aa + ", data = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.a.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_c_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_c_of_type_JavaUtilArrayList;
    this.f = localPublishDataCacheEntity.jdField_c_of_type_JavaLangString;
    this.Y = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo;
    if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_c_of_type_Int = 25;
      this.jdField_e_of_type_JavaLangString = getString(2131363887, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if ((TextUtils.isEmpty(this.X)) || (this.P <= 0) || (this.Q <= 0))
    {
      this.P = 10;
      this.Q = 700;
      this.X = getString(2131363888, new Object[] { Integer.valueOf(this.P), Integer.valueOf(this.Q) });
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    int i;
    if (paramEditable == null)
    {
      i = 0;
      if ((this.Q <= 0) || (i <= this.Q)) {
        break label100;
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.Q - i));
    }
    for (;;)
    {
      if ((Build.DISPLAY.equals("moonlight-diyroms' ROMS")) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null)) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      }
      return;
      i = paramEditable.length();
      break;
      label100:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      if ((1000 == paramInt1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo == null))
      {
        String str1 = this.ad;
        String str2 = this.ae;
        if (this.af != null) {
          break label70;
        }
        paramIntent = "";
        TroopBarUtils.a(str1, str2, "un_music", paramIntent, this.ac, "", "");
      }
    }
    label70:
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = this.af;
          break;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_AndroidNetUri == null);
        paramIntent = com.tencent.mobileqq.utils.ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
        com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
        }
      } while (!this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = new AbsPublishIphoneTitleBarActivity.PreUploadTask(this, this, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_S_of_type_JavaLangString);
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask);
      return;
    } while (this.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = com.tencent.mobileqq.utils.ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
    com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
    a(paramIntent);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j)) {}
      for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j)
      {
        a(1, new String[] { paramIntent });
        return;
      }
    }
    a(0, new String[0]);
    return;
    paramIntent = (AudioInfo)paramIntent.getSerializableExtra("audio_info");
    a(2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = paramIntent;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (!this.d) {
        i();
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
      }
      if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
        this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsPublishActivity", 4, "unregisterReceiver(mItemDeleteReceiver) exception");
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (localObject == null) {
        break label83;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_e_of_type_Boolean) {
        break label54;
      }
    }
    label54:
    label83:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = new AbsPublishIphoneTitleBarActivity.PreUploadTask(this, this, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_S_of_type_JavaLangString);
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask);
      return;
      localObject = paramIntent.getStringExtra("file_send_path");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = new VideoInfo((String)localObject, paramIntent.getLongExtra("file_send_size", -1L), paramIntent.getLongExtra("file_send_duration", -1L));
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void e()
  {
    setContentView(2130903564);
    if (TextUtils.isEmpty(this.T))
    {
      setTitle(2131363889);
      setLeftViewName(2131365736);
      setRightButton(2131363890, this);
      this.leftView.setContentDescription(getString(2131363913));
      this.rightViewText.setContentDescription(getString(2131363914));
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)findViewById(2131298789));
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131297112));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131298828));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298771));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298813);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298814));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298815));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298816));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298805));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298806));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298808));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298817));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298810);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = ((ExtendGridView)findViewById(2131298811));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298826));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131298809));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131298812);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar = ((PublishItemBar)findViewById(2131298807));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setCallback(this.jdField_a_of_type_AndroidOsHandler);
      if (this.U != 0) {
        break label516;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      label336:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      if (!this.g) {
        break label538;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    }
    for (;;)
    {
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if ((localDisplayMetrics != null) && (localDisplayMetrics.heightPixels <= 800)) {
        this.jdField_b_of_type_AndroidWidgetEditText.setMinLines(3);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new kbs(this) });
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      a(this, this);
      j();
      return;
      setTitle(this.T);
      break;
      label516:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.U);
      break label336;
      label538:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
    }
  }
  
  protected void f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("audio_max_length", this.jdField_S_of_type_Int);
    if (this.af != null)
    {
      localIntent.putExtra("from", "publish");
      localIntent.putExtra("bid", this.af);
      localIntent.putExtra("fromflag", this.ac);
    }
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AudioRecordActivity.class);
    startActivityForResult(localIntent, 1003);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void g()
  {
    Object localObject = a(1.0F, 0.0F);
    Animation localAnimation = a(0.0F, 1.0F);
    ((Animation)localObject).setAnimationListener(new kbi(this, localAnimation));
    localAnimation.setAnimationListener(new kbj(this));
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    }
    for (int i = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();; i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getMeasuredHeight())
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getMeasuredHeight();
      localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getLayoutParams()).bottomMargin + j - i);
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getVisibility() != 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.startAnimation((Animation)localObject);
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void i()
  {
    int j = 0;
    if (this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "publish save key = " + this.aa);
      }
      if (TextUtils.isEmpty(this.aa)) {
        continue;
      }
      TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
      Object localObject1;
      int i;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject1 = new ArrayList();
        i = 0;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject1).add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
        localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_c_of_type_JavaUtilArrayList != null)
        {
          localObject1 = new ArrayList();
          i = 0;
          while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
          {
            ((ArrayList)localObject1).add(new TroopBarPOI((TroopBarPOI)this.jdField_c_of_type_JavaUtilArrayList.get(i)));
            i += 1;
          }
          localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
      localPublishDataCacheEntity.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      localPublishDataCacheEntity.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      localPublishDataCacheEntity.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localPublishDataCacheEntity.jdField_c_of_type_Int = this.P;
      localPublishDataCacheEntity.jdField_d_of_type_Int = this.Q;
      localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.X;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = new ArrayList();
        i = j;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject1).add(new TroopBarPageEntity.TypeListEntity((TroopBarPageEntity.TypeListEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)));
          i += 1;
        }
        localPublishDataCacheEntity.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo != null) {}
      try
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = ((MusicInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo.clone());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) {}
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2)
      {
        try
        {
          localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) {}
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2)
        {
          try
          {
            do
            {
              for (;;)
              {
                localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = ((VideoInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.clone());
                localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity;
                if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
                  break label562;
                }
                localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
                localPublishDataCacheEntity.jdField_c_of_type_JavaLangString = ((String)localObject1);
                localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetEditText.getEditableText().toString();
                TroopBarUtils.a.put(this.aa, localPublishDataCacheEntity);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("TroopBar", 2, "publish save key = " + this.aa + ", data = " + localPublishDataCacheEntity);
                return;
                localCloneNotSupportedException1 = localCloneNotSupportedException1;
                if (QLog.isColorLevel()) {
                  QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException1));
                }
              }
              localCloneNotSupportedException2 = localCloneNotSupportedException2;
            } while (!QLog.isColorLevel());
            QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException2));
          }
          catch (CloneNotSupportedException localCloneNotSupportedException3)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException3));
                continue;
                label562:
                Object localObject2 = null;
              }
            }
          }
        }
      }
    }
  }
  
  public void j()
  {
    label90:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar != null)
    {
      if (this.U == 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      }
    }
    else
    {
      if ((this.U & 0x1) != 1) {
        break label502;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setNumColumns(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setOnItemClickListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter = new TroopBarImagePreviewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter);
      if (!this.i) {
        break label514;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetEditText, this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      label130:
      if (!this.h) {
        break label526;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      label177:
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_c_of_type_Int), new kbt(this) });
      EditText localEditText;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)
      {
        localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
        if (TextUtils.isEmpty(this.f)) {
          break label538;
        }
        str = this.f;
        label259:
        localEditText.setText(str);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.X);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getText().length() <= 0)
      {
        localEditText = this.jdField_b_of_type_AndroidWidgetEditText;
        if (TextUtils.isEmpty(this.Y)) {
          break label543;
        }
        str = this.Y;
        label310:
        localEditText.setText(str);
      }
      if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j)) {
          break label548;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
        label350:
        a(1, new String[] { str });
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label559;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name);
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131363931, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name }));
      }
      label435:
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label571;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_b_of_type_JavaUtilArrayList);
      a(4);
      label463:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo == null) {
        break label579;
      }
      a(1, this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo);
    }
    label502:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(this.U);
      break;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label90;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label130;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label177;
      str = null;
      break label259;
      str = null;
      break label310;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
      break label350;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label435;
      a(0);
      break label463;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)
      {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null);
    label514:
    label526:
    label538:
    label543:
    label548:
    label559:
    label571:
    label579:
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0))
    {
      h();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298813: 
    case 2131298814: 
    case 2131298815: 
    case 2131298816: 
    case 2131297360: 
    case 2131298828: 
      do
      {
        do
        {
          return;
          paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
          paramView.putParcelableArrayListExtra("current_location_list", this.jdField_c_of_type_JavaUtilArrayList);
          paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          startActivityForResult(paramView, 1002);
          return;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
          k();
          return;
        } while (System.currentTimeMillis() - this.jdField_b_of_type_Long < 500L);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kbk(this), 200L);
        return;
      }
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kbl(this), 200L);
      return;
    }
    s();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetEditText)
    {
      if (!paramBoolean) {
        break label47;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kbr(this), 200L);
      }
    }
    return;
    label47:
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((1 != paramMotionEvent.getAction()) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0));
          h();
          return false;
        } while (paramMotionEvent.getAction() != 2);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus())) {
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
        }
      } while (this.jdField_b_of_type_AndroidWidgetEditText == null);
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() != 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity
 * JD-Core Version:    0.7.0.1
 */