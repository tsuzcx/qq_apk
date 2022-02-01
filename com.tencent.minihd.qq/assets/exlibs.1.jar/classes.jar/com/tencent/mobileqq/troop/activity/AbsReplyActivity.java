package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.PlusPanel.PluginData;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import kcd;
import kce;
import kch;
import kci;
import kcj;
import kck;
import kcl;
import kcm;
import kcn;
import kco;
import kcp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsReplyActivity
  extends AbsPublishIphoneTitleBarActivity
  implements View.OnClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  protected static final int a = 3;
  private static int[] jdField_a_of_type_ArrayOfInt = { 2131362067, 2130838012, 2131364061 };
  private static final int aa = 0;
  private static final int ab = 1;
  private static final int ac = 2;
  private static final int ad = 3;
  private static final int ae = 4;
  private static final int af = 5;
  private static final int ag = 6;
  private static final int ah = 7;
  private static final int ai = 8;
  protected static final int b = 700;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131366475, 2130838002, 2131364062 };
  private static final int jdField_c_of_type_Int = 0;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131364067, 2130839201, 2131364063 };
  private static final int jdField_d_of_type_Int = 2;
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131364070, 2130838019, 2131364065 };
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  protected BroadcastReceiver a;
  protected Drawable a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new kch(this);
  protected View a;
  public Button a;
  protected FrameLayout a;
  protected GridView a;
  public ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  private PlusPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter = null;
  public CommonListenPanel a;
  public CommonRecordSoundPanel a;
  protected SystemEmoticonPanel a;
  public PublishItemContainer a;
  protected InputMethodRelativeLayout a;
  protected CharSequence a;
  public boolean a;
  private final int[][] jdField_a_of_type_Array2dOfInt = new int[5][];
  Handler jdField_b_of_type_AndroidOsHandler = new kco(this);
  public ImageButton b;
  private AudioInfo jdField_b_of_type_ComTencentMobileqqTroopDataAudioInfo;
  Handler jdField_c_of_type_AndroidOsHandler = new kcp(this);
  
  public AbsReplyActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = null;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kcm(this);
    this.jdField_a_of_type_AndroidOsHandler = new kcn(this);
  }
  
  private void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getResources();
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    if ((this.U & 0x1) == 1)
    {
      this.jdField_a_of_type_Array2dOfInt[0] = jdField_a_of_type_ArrayOfInt;
      this.jdField_a_of_type_Array2dOfInt[1] = jdField_b_of_type_ArrayOfInt;
    }
    for (int j = 2;; j = 0)
    {
      int i = j;
      if ((this.U & 0x2) == 2)
      {
        this.jdField_a_of_type_Array2dOfInt[j] = jdField_c_of_type_ArrayOfInt;
        i = j + 1;
      }
      j = i;
      if ((this.U & 0x8) == 8)
      {
        this.jdField_a_of_type_Array2dOfInt[i] = jdField_d_of_type_ArrayOfInt;
        j = i + 1;
      }
      if (((this.U & 0x4) != 4) || (j > 0))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        i = 0;
        if (i < this.jdField_a_of_type_Array2dOfInt.length)
        {
          int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i];
          if (arrayOfInt == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfInt.length == jdField_a_of_type_ArrayOfInt.length)
            {
              PlusPanel.PluginData localPluginData = new PlusPanel.PluginData();
              localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(arrayOfInt[1]);
              localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
              localPluginData.jdField_a_of_type_JavaLangString = paramContext.getString(arrayOfInt[0]);
              localPluginData.jdField_b_of_type_JavaLangString = paramContext.getString(arrayOfInt[2]);
              localPluginData.jdField_a_of_type_Boolean = false;
              localArrayList.add(localPluginData);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation1.setDuration(0L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.4F, 1.0F);
    localAlphaAnimation2.setDuration(0L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    findViewById(2131298772).setEnabled(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation2);
      this.jdField_b_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation2);
      findViewById(2131298772).setBackgroundColor(0);
      findViewById(2131298772).setBackgroundResource(2130842237);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    this.jdField_b_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation1);
    findViewById(2131298772).setBackgroundColor(1291845632);
    this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation1);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837553);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    case 2: 
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    case 3: 
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.g();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
  }
  
  protected int a()
  {
    return 2131363941;
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131364076);
    Object localObject = new kce(this, paramInt);
    localQQCustomDialog.setNegativeButton(getString(2131364079), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      str = getString(2131364066, new Object[] { getString(2131364067) });
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setPositiveButton(getString(2131364081), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.show();
      return;
      str = getString(2131364066, new Object[] { getString(2131364068) });
      localQQCustomDialog.setPositiveButton(getString(2131364080), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364066, new Object[] { getString(2131364069) });
      localQQCustomDialog.setPositiveButton(getString(2131364082), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364066, new Object[] { getString(2131364069) });
      localQQCustomDialog.setPositiveButton(getString(2131364082), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131363940, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).a(bool);
        break;
        bool = false;
      }
      str = getString(2131364071);
      localQQCustomDialog.setPositiveButton(getString(2131364078), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364072);
      localQQCustomDialog.setPositiveButton(getString(2131364077), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364066, new Object[] { getString(2131364070) });
      localQQCustomDialog.setPositiveButton(getString(2131364083), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131364073);
      localQQCustomDialog.setPositiveButton(getString(2131364077), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void a(int paramInt, MediaInfo paramMediaInfo)
  {
    if (paramMediaInfo == null) {
      return;
    }
    if ((paramMediaInfo instanceof MusicInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = ((MusicInfo)paramMediaInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
      c(0);
      InputMethodUtil.a(this.jdField_b_of_type_AndroidWidgetEditText);
      return;
      if ((paramMediaInfo instanceof AudioInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
      }
      else if ((paramMediaInfo instanceof VideoInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = ((VideoInfo)paramMediaInfo);
      }
    }
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    Object localObject = "";
    boolean bool;
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      bool = false;
      label41:
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      if (!bool) {
        break;
      }
    }
    for (paramVarArgs = getString(2131363922, new Object[] { paramVarArgs });; paramVarArgs = getString(2131363921))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131365218);
      bool = false;
      break label41;
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
      bool = false;
      break label41;
      paramVarArgs = getString(2131365216);
      bool = false;
      break label41;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        bool = true;
        break label41;
      }
      a(0, new String[0]);
      return;
    }
  }
  
  protected void a(View paramView, String paramString, int paramInt)
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
      ((RelativeLayout.LayoutParams)localObject1).width = 100;
      ((RelativeLayout.LayoutParams)localObject1).height = 100;
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      localObject1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = Utils.a(this, 2.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = Utils.a(this, 2.0F);
      localObject2 = new File(paramString);
    }
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      label261:
      try
      {
        if (!((File)localObject2).exists()) {
          break label261;
        }
        localObject2 = URLDrawable.getDrawable(((File)localObject2).toURL(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        label149:
        break label149;
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
      paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramView.rightMargin = Utils.a(this, 2.0F);
      paramView.width = (Utils.a(this, 10.0F) + 100);
      paramView.height = (Utils.a(this, 17.0F) + 100);
      return;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130841071);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131365464);
    com.tencent.biz.common.util.ImageUtil.b((String)null, 0);
    if ("barindex".equals(this.Z)) {}
    for (paramJSONObject = "0";; paramJSONObject = "1")
    {
      this.ac = paramJSONObject;
      if (this.V != 0) {
        q();
      }
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("key_photo_delete_action");
      paramJSONObject.addAction("key_music_delete_action");
      paramJSONObject.addAction("key_audio_delete_action");
      paramJSONObject.addAction("key_photo_add_action");
      paramJSONObject.addAction("key_video_delete_action");
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
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      c(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841082);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131363925));
      this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837573);
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "repky restore key = " + this.aa);
    }
    if (TextUtils.isEmpty(this.aa)) {
      return false;
    }
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.b.get(this.aa);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.aa + ", replyData = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.b.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_c_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.P = localPublishDataCacheEntity.c;
    this.Q = localPublishDataCacheEntity.jdField_d_of_type_Int;
    this.X = localPublishDataCacheEntity.jdField_b_of_type_JavaLangString;
    this.Y = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo;
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841082);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131363925));
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837573);
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        return;
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
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = new AbsPublishIphoneTitleBarActivity.PreUploadTask(this, this, this.jdField_b_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask);
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
      return;
    } while (this.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = com.tencent.mobileqq.utils.ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
    com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
    a(paramIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (!this.jdField_d_of_type_Boolean) {
      g();
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.f();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (localObject == null) {
        break label74;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = new AbsPublishIphoneTitleBarActivity.PreUploadTask(this, this, this.jdField_b_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask);
    }
    label74:
    do
    {
      return;
      localObject = paramIntent.getStringExtra("file_send_path");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = new VideoInfo((String)localObject, paramIntent.getLongExtra("file_send_size", 0L), paramIntent.getIntExtra("file_send_duration", 0));
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.e();
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
  
  protected void e()
  {
    int j = 0;
    setContentView(2130903574);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131298789));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131298828));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131297033));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298814));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298806));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298135));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131298850));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298851);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298771));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    findViewById(2131298772).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131298848));
    this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter = new PlusPanelAdapter();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter);
    a(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298769));
    Object localObject = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)((LayoutInflater)localObject).inflate(2130903502, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.S);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel = ((CommonListenPanel)((LayoutInflater)localObject).inflate(2130903501, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.a(this.app, this, this.jdField_c_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((TextUtils.isEmpty(this.X)) || (this.P <= 0) || (this.Q <= 0))
    {
      this.P = 3;
      this.Q = 700;
      this.X = getString(2131363888, new Object[] { Integer.valueOf(this.P), Integer.valueOf(this.Q) });
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.X);
    label567:
    label580:
    int i;
    if (this.jdField_b_of_type_AndroidWidgetEditText.getText().length() <= 0)
    {
      EditText localEditText = this.jdField_b_of_type_AndroidWidgetEditText;
      if (!TextUtils.isEmpty(this.Y))
      {
        localObject = this.Y;
        localEditText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label664;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j)) {
        break label653;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.k;
      a(1, new String[] { localObject });
      a(this, this);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.h) {
        break label676;
      }
      i = 0;
      label600:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!this.i) {
        break label682;
      }
      i = j;
      label619:
      ((ImageButton)localObject).setVisibility(i);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label687;
      }
      a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_b_of_type_JavaUtilArrayList);
    }
    label653:
    label664:
    label676:
    label682:
    label687:
    do
    {
      return;
      localObject = null;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.j;
      break label567;
      a(0, new String[0]);
      break label580;
      i = 8;
      break label600;
      i = 4;
      break label619;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo != null)
      {
        a(1, this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)
      {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null);
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcd(this), 200L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kci(this), 500L);
  }
  
  protected void g()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.aa);
    }
    if (TextUtils.isEmpty(this.aa)) {}
    for (;;)
    {
      return;
      TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
      ArrayList localArrayList;
      int i;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          localArrayList.add(this.jdField_b_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
        localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_c_of_type_JavaUtilArrayList != null)
        {
          localArrayList = new ArrayList();
          i = j;
          while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.jdField_c_of_type_JavaUtilArrayList.get(i)));
            i += 1;
          }
          localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        }
      }
      localPublishDataCacheEntity.c = this.P;
      localPublishDataCacheEntity.jdField_d_of_type_Int = this.Q;
      localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.X;
      localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetEditText.getEditableText().toString();
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
                TroopBarUtils.b.put(this.aa, localPublishDataCacheEntity);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("TroopBar", 2, "reply save key = " + this.aa + ", data = " + localPublishDataCacheEntity);
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
              if (QLog.isColorLevel()) {
                QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException3));
              }
            }
          }
        }
      }
    }
  }
  
  protected void init(Intent paramIntent) {}
  
  public void m()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 9)
    {
      a(4);
      return;
    }
    super.m();
  }
  
  public void o()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 9)
    {
      a(4);
      return;
    }
    super.o();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298772: 
    case 2131298814: 
    case 2131298828: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.w("IphoneTitleBarActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
        finish();
        return;
        paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        paramView.putParcelableArrayListExtra("current_location_list", this.jdField_c_of_type_JavaUtilArrayList);
        paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        startActivityForResult(paramView, 1002);
        return;
      } while (System.currentTimeMillis() - this.jdField_b_of_type_Long < 500L);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_b_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841082);
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131363925));
        this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837573);
        this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131363927));
        return;
      }
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcj(this), 200L);
      return;
    case 2131298135: 
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
      k();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)
    {
      c(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kck(this), 200L);
      return;
    }
    InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcl(this), 200L);
    TroopBarUtils.a(this.ad, this.ae, "Clk_add", this.af, this.ac, "", "");
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsReplyActivity
 * JD-Core Version:    0.7.0.1
 */