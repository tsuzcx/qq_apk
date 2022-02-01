package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable.Factory;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.MusicInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.VideoInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import kbu;
import kbv;
import kbw;
import kbx;
import kby;
import kbz;
import kcb;
import kcc;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsPublishIphoneTitleBarActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback
{
  public static final int A = 6;
  public static final String A = "defaultCategory";
  protected static final int B = 1001;
  public static final String B = "forbiddenType";
  protected static final int C = 1003;
  public static final String C = "forbiddenMsg";
  protected static final int D = 1004;
  public static final String D = "selectTitle";
  protected static final int E = 1005;
  public static final String E = "selectContent";
  protected static final int F = 1006;
  public static final String F = "selectUrl";
  protected static final int G = 1007;
  public static final String G = "key_photo_delete_action";
  protected static final int H = 1008;
  public static final String H = "key_photo_delete_position";
  public static final int I = 500;
  public static final String I = "key_photo_add_action";
  protected static final int J = 4;
  public static final String J = "key_music_delete_action";
  protected static final int K = 9;
  public static final String K = "key_audio_delete_action";
  protected static final int L = 60000;
  public static final String L = "key_video_delete_action";
  protected static final int M = 209715200;
  public static final String M = "key_audio_play_action";
  protected static final int N = 196;
  public static final String N = "key_video_play_action";
  public static final String O = "key_video_time_overflow";
  public static final String P = "key_video_size_overflow";
  public static final String Q = "key_video_select_apply_click";
  public static final String R = "key_video_select_confirm_ok_click";
  public static final int X = 1;
  public static final int Y = 2;
  public static final int Z = 3;
  public static Editable.Factory a;
  private static final String a = "https://y.qq.com/m/qzonemusic/mqzsearch.html?_wv=3&_bid=203&entry=buluo&uin=%s";
  public static final String g = "needDestination";
  public static final int h = 1;
  public static final String h = "needTitle";
  public static final int i = 2;
  public static final String i = "needLocation";
  public static final int j = 4;
  public static final String j = "needFace";
  public static final int k = 8;
  public static final String k = "contentPlaceholder";
  protected static final int l = 1000;
  public static final String l = "minContentLength";
  protected static final int m = 1001;
  public static final String m = "maxContentLength";
  protected static final int n = 1002;
  public static final String n = "barTitle";
  protected static final int o = 1003;
  public static final String o = "isPreUpload";
  protected static final int p = 1004;
  public static final String p = "maxPhotoCount";
  protected static final int q = 0;
  public static final String q = "photoOrContent";
  protected static final int r = 1;
  public static final String r = "isReply";
  protected static final int s = 2;
  public static final String s = "from";
  protected static final int t = 3;
  public static final String t = "flag";
  public static final int u = 0;
  public static final String u = "recordTimeLimit";
  public static final int v = 1;
  public static final String v = "videoTimeLimit";
  public static final int w = 2;
  public static final String w = "videoSizeLimit";
  public static final int x = 3;
  public static final String x = "requireType";
  public static final int y = 4;
  public static final String y = "optionType";
  public static final int z = 5;
  public static final String z = "cacheKey";
  protected int O = 9;
  protected int P = 0;
  protected int Q = 0;
  protected int R = 0;
  public int S;
  public String S;
  public int T;
  protected String T;
  protected int U;
  protected String U;
  protected int V;
  protected String V;
  protected int W;
  protected String W;
  protected String X = null;
  protected String Y = null;
  protected String Z = null;
  public long a;
  public Uri a;
  public BaseActivity a;
  public AbsPublishIphoneTitleBarActivity.PreUploadTask a;
  public AudioInfo a;
  public MusicInfo a;
  public TroopBarPOI a;
  public VideoInfo a;
  protected ActionSheet a;
  protected kcb a;
  protected String aa = null;
  protected String ab = null;
  public String ac = null;
  public String ad = null;
  public String ae = null;
  public String af = null;
  protected long b;
  public EditText b;
  public QQProgressDialog b;
  public ArrayList b;
  protected QQProgressDialog c;
  protected ArrayList c;
  public boolean d = false;
  protected boolean e = true;
  protected boolean f = true;
  protected boolean g = true;
  protected boolean h = true;
  protected boolean i = true;
  protected boolean j = false;
  protected boolean k = true;
  protected boolean l = false;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new kbx();
  }
  
  public AbsPublishIphoneTitleBarActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_S_of_type_JavaLangString = "https://upload.buluo.qq.com/cgi-bin/bar/upload/image";
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidNetUri = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_T_of_type_JavaLangString = null;
    this.jdField_U_of_type_JavaLangString = null;
    this.jdField_V_of_type_JavaLangString = null;
    this.jdField_W_of_type_JavaLangString = null;
    this.jdField_S_of_type_Int = 0;
    this.jdField_T_of_type_Int = 2147483647;
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_U_of_type_Int = 0;
    this.jdField_V_of_type_Int = 0;
    this.jdField_W_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_AndroidWidgetEditText = null;
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    Object localObject = Build.MODEL;
    if ((localObject != null) && ((((String)localObject).startsWith("SH-")) || (((String)localObject).startsWith("SBM")) || (((String)localObject).startsWith("SHL")))) {}
    try
    {
      localObject = TextView.class.getDeclaredField("mTextSelectHandleRes");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(paramEditText, Integer.valueOf(((Integer)((Field)localObject).get(new TextView(paramContext))).intValue()));
      paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
      paramEditText.setBackgroundResource(2130837553);
      paramEmoticonCallback = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramContext, 196.0F));
      int i1 = (int)DisplayUtils.a(paramContext, 20.0F);
      paramEditText.setPadding(0, i1, 0, i1);
      paramViewGroup.addView(paramEditText, paramEmoticonCallback);
      paramEditText.setVisibility(8);
      return paramEditText;
    }
    catch (Exception paramEditText)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(paramEditText));
        }
      }
    }
  }
  
  public static String a(String paramString, ArrayList paramArrayList, MusicInfo paramMusicInfo, AudioInfo paramAudioInfo, VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    try
    {
      localJSONObject.put("content", localObject);
      label32:
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int i1 = 0;
        while (i1 < paramString.size())
        {
          localObject = (String)paramString.get(i1);
          localObject = (TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(localObject);
          if (localObject != null) {
            paramArrayList.put(((TroopBarPostContentEntity.Pic_list)localObject).getJsonObject());
          }
          i1 += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        label130:
        if (paramAudioInfo != null) {
          paramString = new JSONArray();
        }
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
          if (paramMusicInfo != null) {
            paramString = new JSONArray();
          }
        }
        catch (JSONException paramString)
        {
          try
          {
            paramString.put(new JSONObject(paramMusicInfo.getJsonText()));
            localJSONObject.put("qqmusic_list", paramString);
            if (paramVideoInfo != null) {
              paramString = new JSONArray();
            }
          }
          catch (JSONException paramString)
          {
            try
            {
              do
              {
                for (;;)
                {
                  paramString.put(new JSONObject(paramVideoInfo.getJsonText()));
                  localJSONObject.put("video_list", paramString);
                  return localJSONObject.toString();
                  paramString = paramString;
                  if (QLog.isColorLevel()) {
                    QLog.e("IphoneTitleBarActivity", 2, paramString.getMessage());
                  }
                }
                paramString = paramString;
              } while (!QLog.isColorLevel());
              QLog.e("IphoneTitleBarActivity", 2, paramString.getMessage());
            }
            catch (JSONException paramString)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("IphoneTitleBarActivity", 2, paramString.getMessage());
                }
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        break label130;
      }
    }
    catch (JSONException paramString)
    {
      break label32;
    }
  }
  
  protected int a()
  {
    return 2131363935;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    }
  }
  
  protected void a(int paramInt, Handler paramHandler)
  {
    runOnUiThread(new kbu(this));
    if (((TicketManager)this.app.getManager(2)).getSkey(this.app.a()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      new AbsPublishIphoneTitleBarActivity.AudioUploadTask(this, this, paramHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo).start();
      return;
      new AbsPublishIphoneTitleBarActivity.PicUploadThread(this, paramHandler, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_S_of_type_JavaLangString).start();
      return;
      new kcc(this, this, paramHandler, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo).start();
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  public abstract void a(int paramInt, MediaInfo paramMediaInfo);
  
  abstract void a(int paramInt, String... paramVarArgs);
  
  protected void a(BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    SosoInterface.a(new kby(this, 0, true, 0L, false, false, "AbsPublishIphoneTitleBarActivity", paramBaseActivity, paramCallback));
    a(2, new String[0]);
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    paramString = ActionSheet.a(paramBaseActivity);
    paramString.a(2131368536, 1);
    paramString.a(2131368538, 1);
    paramString.a(new kbv(this, paramBaseActivity, paramString));
    paramString.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramString;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_b_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_b_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) || (paramString1 == null)) {
      return;
    }
    Object localObject1 = paramJSONObject.optString("cid");
    paramString1 = new TroopBarUploadItemEntity(this.af, paramString1, (String)localObject1);
    long l1;
    label120:
    Object localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString1.mTitle = paramString2;
      paramString1.mFrom = 1001;
      paramString1.mTime = System.currentTimeMillis();
      paramString1.mFromFlag = this.ac;
      paramString1.mOpType = this.ae;
      paramString1.mContent = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label262;
      }
      paramString2 = new JSONArray();
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      l1 = 0L;
      if (!((Iterator)localObject1).hasNext()) {
        break label206;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      paramString2.put(localObject2);
      localObject2 = new File((String)localObject2);
      if (!((File)localObject2).exists()) {
        break label200;
      }
    }
    label200:
    for (long l2 = ((File)localObject2).length();; l2 = 0L)
    {
      l1 += l2;
      break label120;
      paramString1.mFrom = 1002;
      paramString1.mTitle = paramString2;
      break;
    }
    label206:
    paramString1.mPicList = paramString2.toString();
    paramString1.mSize = l1;
    paramString1.mPicCount = paramString2.length();
    paramString1.mPicUploadCount = 0;
    paramString1.mItemType = 4;
    for (;;)
    {
      paramString1.mState = 0;
      paramString1.mProgress = 0.0F;
      ThreadManager.a(new kbz(this, paramString1, paramJSONObject));
      return;
      label262:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null)
      {
        paramString1.mAudioPath = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path;
        paramString1.mAudioUrl = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url;
        paramString1.mSize = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.size;
        paramString1.mItemType = 2;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo != null)
      {
        paramString1.mSize = this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.jdField_a_of_type_Long;
        paramString1.mVid = this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.e;
        paramString1.mVideoPath = this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.b;
        paramString1.mItemType = 3;
      }
      else
      {
        paramString1.mItemType = 0;
      }
    }
  }
  
  abstract void a(JSONObject paramJSONObject);
  
  abstract boolean a();
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    if ((this.jdField_W_of_type_Int & paramInt) == paramInt)
    {
      Object localObject1 = localObject2;
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
      while (localObject1 != null)
      {
        QQToast.a(this, (CharSequence)localObject1, 0).b(getTitleBarHeight());
        return true;
        localObject1 = getString(2131364088, new Object[] { this.ab });
        continue;
        localObject1 = getString(2131364085, new Object[] { this.ab });
        continue;
        localObject1 = getString(2131364086, new Object[] { this.ab });
        continue;
        localObject1 = getString(2131364087, new Object[] { this.ab });
      }
    }
    return false;
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      Object localObject2 = null;
      Object localObject1;
      if (((paramInt & 0x1) == 1) && (this.jdField_b_of_type_JavaUtilArrayList.size() == 0)) {
        localObject1 = getString(2131364102, new Object[] { getString(2131364069) });
      }
      while (localObject1 != null)
      {
        QQToast.a(this, (CharSequence)localObject1, 0).b(getTitleBarHeight());
        return false;
        if (((paramInt & 0x2) == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null))
        {
          localObject1 = getString(2131364102, new Object[] { getString(2131364067) });
        }
        else if (((paramInt & 0x4) == 4) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo == null))
        {
          localObject1 = getString(2131364102, new Object[] { getString(2131364068) });
        }
        else
        {
          localObject1 = localObject2;
          if ((paramInt & 0x8) == 8)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) {
              localObject1 = getString(2131364102, new Object[] { getString(2131364070) });
            }
          }
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131364089), 1).b(getTitleBarHeight());
    }
    while (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131365098, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QQToast.a(this, getString(2131364089), 1).b(getTitleBarHeight());
      return false;
    }
    if (paramArrayList.size() > 9)
    {
      QQToast.a(this, getString(2131365098, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    if (paramArrayList != this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    for (;;)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(1005));
      return true;
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    }
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (!FileUtils.b(paramString))
    {
      QQToast.a(this, getString(2131364090), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = new VideoInfo(paramString);
    a(3, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492923));
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void b(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    paramString = ActionSheet.a(paramBaseActivity);
    paramString.a(2131368537, 5);
    paramString.a(2131368538, 5);
    paramString.e(2131365736);
    paramString.a(new kbw(this, paramBaseActivity, paramString));
    paramString.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramString;
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(a());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void c() {}
  
  public void d() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i2 = 60000;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131363871, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.jdField_T_of_type_JavaLangString = paramBundle.optString("barTitle");
        this.jdField_U_of_type_JavaLangString = paramBundle.optString("selectTitle");
        this.jdField_V_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_W_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.P = paramBundle.optInt("minContentLength", this.P);
        this.Q = paramBundle.optInt("maxContentLength", this.Q);
        this.X = paramBundle.optString("contentPlaceholder", this.X);
        this.j = paramBundle.optBoolean("photoOrContent");
        this.f = paramBundle.optBoolean("needDestination", true);
        this.g = paramBundle.optBoolean("needTitle", true);
        this.h = paramBundle.optBoolean("needLocation", true);
        this.i = paramBundle.optBoolean("needFace", true);
        this.k = paramBundle.optBoolean("isReply", true);
        this.e = paramBundle.optBoolean("isPreUpload", true);
        this.Z = paramBundle.optString("from", "");
        this.R = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_S_of_type_Int = i1;
          if (paramBundle.optInt("videoTimeLimit") != 0) {
            break label577;
          }
          i1 = i2;
          this.jdField_T_of_type_Int = i1;
          if (paramBundle.optLong("videoSizeLimit") != 0L) {
            break label591;
          }
          l1 = 209715200L;
          this.jdField_a_of_type_Long = l1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label606;
          }
          bool = true;
          this.l = bool;
          if (!"barindex".equals(this.Z)) {
            break label612;
          }
          i1 = 1;
          this.jdField_U_of_type_Int = paramBundle.optInt("optionType", i1);
          this.aa = paramBundle.optString("cacheKey");
          this.jdField_V_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.O = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_W_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.ab = paramBundle.optString("forbiddenMsg", getString(2131364084));
          a(paramBundle);
          if (this.jdField_V_of_type_Int == 0) {
            a();
          }
          e();
          this.jdField_a_of_type_Kcb = new kcb(this);
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
          registerReceiver(this.jdField_a_of_type_Kcb, paramBundle, "com.tencent.msg.permission.pushnotify2", null);
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this, 1, getString(2131363871, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      int i1 = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label577:
      i1 = paramBundle.optInt("videoTimeLimit") * 1000;
      continue;
      label591:
      long l1 = paramBundle.optLong("videoSizeLimit") * 1024L;
      continue;
      label606:
      boolean bool = false;
      continue;
      label612:
      i1 = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_Kcb);
  }
  
  abstract void e();
  
  protected abstract void f();
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
    }
    overridePendingTransition(0, 2130968584);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public abstract void k();
  
  public void l()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://y.qq.com/m/qzonemusic/mqzsearch.html?_wv=3&_bid=203&entry=buluo&uin=%s", new Object[] { this.app.a() }));
    localIntent.putExtra("finish_animation_up_down", true);
    startActivityForResult(localIntent, 1000);
    overridePendingTransition(2130968586, 0);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_AndroidNetUri = TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AppConstants.aK, 1001);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidNetUri = TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_T_of_type_Int, this.jdField_a_of_type_Long, 1004);
  }
  
  public void o()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhotoListActivity.class);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.O);
    localIntent.getExtras().remove("forward_type");
    localIntent.putExtra("album_enter_directly", true);
    localIntent.putExtra("ALBUM_ID", AlbumUtil.b);
    localIntent.putExtra("ALBUM_NAME", AlbumUtil.c);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    startActivityForResult(localIntent, 1001);
    AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, true);
  }
  
  public void p()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.getExtras().remove("forward_type");
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", MediaFileFilter.MEDIA_FILTER_SHOW_VIDEO.ordinal());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.jdField_a_of_type_Long);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", Long.valueOf(this.jdField_T_of_type_Int));
    localIntent.putExtra("album_enter_directly", true);
    localIntent.putExtra("PhotoConst.IS_FROM_TROOP_BAR", true);
    startActivityForResult(localIntent, 1004);
    AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false, true);
  }
  
  protected void q()
  {
    switch (this.jdField_V_of_type_Int)
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
            do
            {
              do
              {
                return;
              } while ((this.jdField_U_of_type_Int & 0x2) != 2);
              f();
              return;
            } while ((this.jdField_U_of_type_Int & 0x1) != 1);
            m();
            return;
          } while ((this.jdField_U_of_type_Int & 0x4) != 4);
          l();
          return;
        } while ((this.jdField_U_of_type_Int & 0x1) != 1);
        o();
        return;
      } while ((this.jdField_U_of_type_Int & 0x8) != 8);
      p();
      return;
    } while ((this.jdField_U_of_type_Int & 0x8) != 8);
    n();
  }
  
  public void r()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */