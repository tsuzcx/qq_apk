package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDIYActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ScrollLayout.OnScreenChangeListener
{
  static final String TAG = "ThemeDIYActivity";
  static final int THEMESTATUS_FAIL = -1;
  static final int THEMESTATUS_NOT_SET = 0;
  static final int THEMESTATUS_SETED = 2;
  static final int THEMESTATUS_SETTING = 1;
  static boolean isBacked;
  static int themeStatus = 0;
  final String PAGE_URL = "https://imgcache.qq.com/qqshow/admindata/comdata/viptheme_DIY_theme/";
  final int STATUS_NO_SET = 0;
  final int STATUS_SETED = 2;
  final int STATUS_UNDO_SET = 1;
  final int TOTAL_LOADING = 2;
  Button btn_themeDiy_reUpload;
  Button btn_themeDiy_undo;
  Button btn_themeDiy_upload;
  int currentIndex;
  ThemeDIYActivity.DataLoading dataLoad;
  String diyScreenshotDir;
  LRULinkedHashMap downLoadMap = null;
  boolean isBTest = false;
  boolean isClickTopButtonOpenVip;
  boolean isReUpLoad = false;
  boolean isSetted = false;
  boolean isShowPay = false;
  boolean isVip;
  public AdapterView.OnItemClickListener itemClickListener = new ThemeDIYActivity.1(this);
  ArrayList loadArr;
  int loadingInt = 0;
  String local_FilesDir;
  Context mContext;
  DownloaderFactory mDownloadFactory = null;
  DownloaderInterface mDownloadInterface = null;
  UniPayHandler.UniPayUpdateListener mObserver = new ThemeDIYActivity.5(this);
  ScrollLayout mScrollLayout;
  PageIndicator pageIndicator;
  DownloadListener picDownloadListener = new ThemeDIYActivity.6(this);
  String reportType;
  int[] setStatus = { 0, 0, 0, 0, 0 };
  final ThemeDIYData[] showData = { new ThemeDIYData("设置页", "drawer_l.png", "drawer_bg_l.jpg", "drawer_s.png", "drawer_bg_s.jpg", "theme_bg_setting_path", 2131427547, null, 0, "自定义-设置页背景"), new ThemeDIYData("通讯页", "chats_l.png", null, "chats_s.png", null, "theme_bg_message_path", 2131427546, "theme_bg_message_path_png", 50, "自定义-通讯页背景"), new ThemeDIYData("聊天背景页", "AIO_l.png", "chat_background.png", "AIO_s.png", "chat_background.png", "theme_bg_aio_path", 2131427548, null, 0, "自定义-聊天页背景") };
  RelativeLayout theme_tryon_layout;
  UniPayHandler uniHandler;
  
  public static Bitmap getLoacalBitmap(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeStream(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "getLoacalBitmap1:" + paramString.getMessage());
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDIYActivity", 2, "getLoacalBitmap2:" + paramString.getMessage());
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDIYActivity", 2, "getLoacalBitmap3:" + paramString.getMessage());
        }
      }
    }
  }
  
  void changeBtnStatus(String paramString)
  {
    if ((paramString != null) && (!"null".equals(paramString)) && (!"none".equals(paramString))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.btn_themeDiy_upload.setVisibility(8);
      this.btn_themeDiy_undo.setVisibility(0);
      this.btn_themeDiy_reUpload.setVisibility(0);
      return;
    }
    this.btn_themeDiy_upload.setVisibility(0);
    this.btn_themeDiy_undo.setVisibility(8);
    this.btn_themeDiy_reUpload.setVisibility(8);
  }
  
  void destroyDownloader()
  {
    if (this.mDownloadFactory != null)
    {
      this.mDownloadFactory.onDestroy();
      this.mDownloadFactory = null;
    }
    if (this.mDownloadInterface != null)
    {
      this.mDownloadInterface.a();
      this.mDownloadInterface = null;
    }
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_4
    //   2: if_icmpne +256 -> 258
    //   5: aload_3
    //   6: ifnull +252 -> 258
    //   9: ldc_w 271
    //   12: aload_3
    //   13: ldc_w 273
    //   16: invokevirtual 279	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +236 -> 258
    //   25: aload_3
    //   26: ldc_w 281
    //   29: invokevirtual 279	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_3
    //   33: iconst_m1
    //   34: istore_2
    //   35: iconst_m1
    //   36: istore 5
    //   38: new 283	org/json/JSONObject
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_3
    //   47: iload 5
    //   49: istore_1
    //   50: aload_3
    //   51: ldc_w 286
    //   54: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 295	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: istore 4
    //   62: iload 5
    //   64: istore_1
    //   65: iload 4
    //   67: istore_2
    //   68: aload_3
    //   69: ldc_w 297
    //   72: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 295	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore 5
    //   80: iload 5
    //   82: istore_1
    //   83: iload 4
    //   85: istore_2
    //   86: aload_3
    //   87: ldc_w 299
    //   90: invokevirtual 289	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 295	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore 6
    //   98: iload 6
    //   100: istore_1
    //   101: iload 4
    //   103: istore_2
    //   104: iload_1
    //   105: istore 4
    //   107: aload_3
    //   108: ifnull +150 -> 258
    //   111: iload_2
    //   112: ifne +146 -> 258
    //   115: iload 5
    //   117: ifne +141 -> 258
    //   120: iload 4
    //   122: ifne +136 -> 258
    //   125: aload_0
    //   126: getfield 301	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isClickTopButtonOpenVip	Z
    //   129: ifeq +151 -> 280
    //   132: aload_0
    //   133: getfield 305	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: ldc_w 307
    //   139: ldc_w 309
    //   142: aload_0
    //   143: getfield 305	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   149: ldc_w 315
    //   152: ldc_w 317
    //   155: iconst_0
    //   156: iconst_1
    //   157: ldc_w 309
    //   160: ldc_w 309
    //   163: aload_0
    //   164: getfield 319	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:reportType	Ljava/lang/String;
    //   167: ldc_w 309
    //   170: invokestatic 325	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield 327	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   178: aload_0
    //   179: getfield 329	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:theme_tryon_layout	Landroid/widget/RelativeLayout;
    //   182: bipush 8
    //   184: invokevirtual 332	android/widget/RelativeLayout:setVisibility	(I)V
    //   187: aload_0
    //   188: getfield 150	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isSetted	Z
    //   191: ifeq +50 -> 241
    //   194: getstatic 78	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeStatus	I
    //   197: iconst_2
    //   198: if_icmpge +43 -> 241
    //   201: iconst_1
    //   202: putstatic 78	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeStatus	I
    //   205: new 334	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask
    //   208: dup
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 336	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   214: aload_0
    //   215: getfield 305	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   218: invokespecial 339	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:<init>	(Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity;Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   221: iconst_2
    //   222: anewarray 341	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc_w 343
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: ldc_w 345
    //   236: aastore
    //   237: invokevirtual 349	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   240: pop
    //   241: aload_0
    //   242: getfield 351	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   245: ifnull +13 -> 258
    //   248: aload_0
    //   249: getfield 351	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   252: ldc_w 309
    //   255: invokevirtual 355	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   258: return
    //   259: astore 7
    //   261: aconst_null
    //   262: astore_3
    //   263: iload 5
    //   265: istore_1
    //   266: aload 7
    //   268: invokevirtual 358	org/json/JSONException:printStackTrace	()V
    //   271: iconst_m1
    //   272: istore 4
    //   274: iload_1
    //   275: istore 5
    //   277: goto -170 -> 107
    //   280: aload_0
    //   281: getfield 305	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   284: ldc_w 307
    //   287: ldc_w 309
    //   290: aload_0
    //   291: getfield 305	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   297: ldc_w 315
    //   300: ldc_w 360
    //   303: iconst_0
    //   304: iconst_1
    //   305: ldc_w 309
    //   308: ldc_w 309
    //   311: aload_0
    //   312: getfield 319	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:reportType	Ljava/lang/String;
    //   315: ldc_w 309
    //   318: invokestatic 325	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   321: goto -148 -> 173
    //   324: astore 7
    //   326: goto -60 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	ThemeDIYActivity
    //   0	329	1	paramInt1	int
    //   0	329	2	paramInt2	int
    //   0	329	3	paramIntent	Intent
    //   60	213	4	i	int
    //   36	240	5	j	int
    //   96	3	6	k	int
    //   259	8	7	localJSONException1	JSONException
    //   324	1	7	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   38	47	259	org/json/JSONException
    //   50	62	324	org/json/JSONException
    //   68	80	324	org/json/JSONException
    //   86	98	324	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mContext = this;
    isBacked = false;
    this.app.a();
    this.isBTest = true;
    boolean bool;
    if (this.isBTest)
    {
      paramBundle = "B";
      this.reportType = paramBundle;
      setContentView(2130904470);
      setTitle(2131366732);
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Enter_diy", 0, 1, "", "", this.reportType, "");
      this.local_FilesDir = (AppConstants.aG + this.app.getAccount() + "/" + "custom_background/");
      this.diyScreenshotDir = (AppConstants.aG + "data/diy_screenshot/");
      if (((SVIPHandler)this.app.a(12)).f() < 1) {
        break label296;
      }
      bool = true;
      label189:
      this.isVip = bool;
      bool = ThemeBackground.getThemeBackgroundEnable();
      if (!bool) {
        break label302;
      }
    }
    int j;
    label296:
    label302:
    for (int i = 2;; i = 0)
    {
      themeStatus = i;
      if ((this.isVip) && (bool)) {
        break label307;
      }
      i = 0;
      j = this.showData.length;
      while (i < j)
      {
        ThemeBackground.clear(this.mContext, this.showData[i].orgSpKey, this.app.a());
        ThemeBackground.clear(this.mContext, this.showData[i].dealSpkey, this.app.a());
        i += 1;
      }
      paramBundle = "A";
      break;
      bool = false;
      break label189;
    }
    label307:
    this.theme_tryon_layout = ((RelativeLayout)findViewById(2131302290));
    this.btn_themeDiy_upload = ((Button)findViewById(2131302294));
    this.btn_themeDiy_undo = ((Button)findViewById(2131302295));
    this.btn_themeDiy_reUpload = ((Button)findViewById(2131302296));
    this.btn_themeDiy_upload.setOnClickListener(this);
    this.btn_themeDiy_undo.setOnClickListener(this);
    this.btn_themeDiy_reUpload.setOnClickListener(this);
    this.mScrollLayout = ((ScrollLayout)findViewById(2131302298));
    this.mScrollLayout.setOnScreenChangeListener(this);
    int k = this.mContext.getResources().getDisplayMetrics().heightPixels;
    int m = this.mContext.getResources().getDisplayMetrics().widthPixels;
    LayoutInflater localLayoutInflater;
    label563:
    ThemeDIYActivity.ViewHolder localViewHolder;
    Object localObject1;
    label676:
    label696:
    Object localObject2;
    String str;
    if (Math.min(k, m) > 480)
    {
      i = 1;
      if (i == 0) {
        ((TextView)findViewById(2131302291)).setText(2131366738);
      }
      j = 25;
      if (this.isBTest)
      {
        ((RelativeLayout)findViewById(2131302289)).setVisibility(8);
        j = -5;
      }
      k = (int)(Math.max(k, m) - DisplayUtils.a(this.mContext, j + 51 + 51 + 50 + 40)) / 6 * 5;
      m = k * 322 / 572;
      localLayoutInflater = LayoutInflater.from(this.mContext);
      j = 0;
      if (j >= this.showData.length) {
        break label1341;
      }
      localViewHolder = new ThemeDIYActivity.ViewHolder();
      localViewHolder.id = j;
      localObject1 = localLayoutInflater.inflate(2130904471, null);
      localViewHolder.scaleView = ((View)localObject1).findViewById(2131302299);
      localViewHolder.mRLayout = ((RelativeLayout)((View)localObject1).findViewById(2131302300));
      paramBundle = (RelativeLayout.LayoutParams)localViewHolder.mRLayout.getLayoutParams();
      paramBundle.width = m;
      paramBundle.height = k;
      if (j != this.showData.length - 1) {
        break label1123;
      }
      if (i == 0) {
        break label1096;
      }
      paramBundle = this.showData[j].bgBig;
      paramBundle = getAssetsDrawable(0, paramBundle);
      if (paramBundle == null) {
        break label1109;
      }
      localViewHolder.mRLayout.setBackgroundDrawable(paramBundle);
      localViewHolder.mImg = ((ImageView)((View)localObject1).findViewById(2131302303));
      localObject2 = localViewHolder.mImg;
      str = this.diyScreenshotDir;
      if (i == 0) {
        break label1217;
      }
      paramBundle = this.showData[j].imgBig;
      label739:
      ((ImageView)localObject2).setBackgroundDrawable(getLocalDrawable(str, paramBundle, localViewHolder.mImg, localViewHolder, true));
      ((ImageView)((View)localObject1).findViewById(2131302302)).setBackgroundColor(getResources().getColor(this.showData[j].orgMarkColor));
      localViewHolder.mImageDiy = ((ImageView)((View)localObject1).findViewById(2131302301));
      paramBundle = new ThemeBackground();
      localViewHolder.mImageDiy.setTag(paramBundle);
      if (bool)
      {
        if (j != this.showData.length - 1) {
          break label1288;
        }
        paramBundle.path = ((ChatBackgroundManager)this.app.getManager(61)).b(null);
        if (!"null".equals(paramBundle.path))
        {
          if (paramBundle.path.indexOf(this.local_FilesDir) < 0) {
            break label1230;
          }
          paramBundle.img = getLocalDrawable(this.local_FilesDir, paramBundle.path.substring(paramBundle.path.lastIndexOf("/") + 1), localViewHolder.mImageDiy, localViewHolder, false);
        }
        label923:
        if (paramBundle.img != null) {
          localViewHolder.mImageDiy.setBackgroundDrawable(paramBundle.img);
        }
      }
      ((View)localObject1).setTag(localViewHolder);
      if (j <= 0) {
        break label1316;
      }
      this.mScrollLayout.changeAlpha((View)localObject1, true, 800);
    }
    for (;;)
    {
      this.mScrollLayout.addView((View)localObject1);
      if (localViewHolder.dTask != null)
      {
        paramBundle = new ProgressBar(this.mContext);
        paramBundle.setIndeterminateDrawable(getResources().getDrawable(2130838130));
        int n = AIOUtils.a(16.0F, this.mContext.getResources());
        localObject1 = new RelativeLayout.LayoutParams(n, n);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = n;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = n;
        ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        localViewHolder.mRLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
        paramBundle.setVisibility(0);
        downloadPic(localViewHolder.dTask);
      }
      j += 1;
      break label563;
      i = 0;
      break;
      label1096:
      paramBundle = this.showData[j].bgSmall;
      break label676;
      label1109:
      localViewHolder.mRLayout.setBackgroundResource(2130841761);
      break label696;
      label1123:
      if (i != 0)
      {
        paramBundle = this.showData[j].bgBig;
        label1137:
        if (paramBundle == null) {
          break label1202;
        }
        localObject2 = localViewHolder.mRLayout;
        str = this.diyScreenshotDir;
        if (i == 0) {
          break label1204;
        }
      }
      label1202:
      label1204:
      for (paramBundle = this.showData[j].bgBig;; paramBundle = this.showData[j].bgSmall)
      {
        ((RelativeLayout)localObject2).setBackgroundDrawable(getLocalDrawable(str, paramBundle, localViewHolder.mRLayout, localViewHolder, true));
        break;
        paramBundle = this.showData[j].bgSmall;
        break label1137;
        break;
      }
      label1217:
      paramBundle = this.showData[j].imgSmall;
      break label739;
      label1230:
      paramBundle.img = getLocalDrawable(paramBundle.path.substring(0, paramBundle.path.lastIndexOf("/") + 1), paramBundle.path.substring(paramBundle.path.lastIndexOf("/") + 1), localViewHolder.mImageDiy, localViewHolder, false);
      break label923;
      label1288:
      ThemeBackground.getThemeBackground(this.mContext, this.showData[j].orgSpKey, this.app.a(), paramBundle);
      break label923;
      label1316:
      this.mScrollLayout.changeAlpha((View)localObject1, false, 800);
      changeBtnStatus(paramBundle.path);
    }
    label1341:
    this.pageIndicator = ((PageIndicator)findViewById(2131298831));
    this.pageIndicator.bindScrollViewGroup(this.mScrollLayout);
    this.dataLoad = new ThemeDIYActivity.DataLoading(this);
    this.dataLoad.bindScrollViewGroup(this.mScrollLayout);
    this.uniHandler = ((UniPayHandler)this.app.a(46));
    this.uniHandler.a(this.mObserver);
    this.uniHandler.a("");
    if (ThemeBackground.getThemeDIYRunTime(this.mContext, this.app.a()) <= 0)
    {
      paramBundle = localLayoutInflater.inflate(2130904472, null);
      paramBundle.setId(2130904472);
      paramBundle.setOnClickListener(this);
      addContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      ThemeBackground.setThemeDIYRunTime(this.mContext, this.app.a());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.uniHandler != null) {
      this.uniHandler.b(this.mObserver);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    View localView = this.mScrollLayout.getChildAt(this.currentIndex);
    if (localView == null) {}
    ThemeDIYActivity.ViewHolder localViewHolder;
    do
    {
      return;
      localViewHolder = (ThemeDIYActivity.ViewHolder)localView.getTag();
    } while (localViewHolder == null);
    this.isSetted = true;
    String str;
    ThemeBackground localThemeBackground;
    if (paramIntent == null)
    {
      str = "null";
      ThemeBackground.setThemeBackgroundPic(this.mContext, this.showData[this.currentIndex].orgSpKey, this.app.a(), str);
      localThemeBackground = (ThemeBackground)localViewHolder.mImageDiy.getTag();
      if (!ThemeBackground.getThemeBackground(this.mContext, this.showData[this.currentIndex].orgSpKey, this.app.a(), localThemeBackground)) {
        break label496;
      }
      if ("null".equals(localThemeBackground.path)) {
        break label484;
      }
      localViewHolder.mImageDiy.setBackgroundDrawable(localThemeBackground.img);
      label140:
      if (!this.isVip) {
        break label614;
      }
      if (paramIntent == null) {
        break label566;
      }
      if (!this.isReUpLoad) {
        break label518;
      }
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_again_success", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      label203:
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Set_success", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      this.theme_tryon_layout.setVisibility(8);
      if (themeStatus <= 0)
      {
        themeStatus = 1;
        new ThemeDIYActivity.SwitchThemeTask(this, this.mContext, this.app).execute(new Object[] { "999", "540" });
      }
      QQToast.a(this, 2131367510, 2600).b(this.mContext.getResources().getDimensionPixelSize(2131492923));
      if (this.currentIndex == this.showData.length - 1) {
        ChatBackground.b(this.mContext, this.app.getAccount(), null, str);
      }
    }
    label518:
    label657:
    for (;;)
    {
      this.isReUpLoad = false;
      changeBtnStatus(localThemeBackground.path);
      this.mScrollLayout.changeAlphaImmediately(localView, localViewHolder.alpha - 0.01F, 10);
      if ((str == null) || (str == "null") || (this.showData[this.currentIndex].dealInt == 0)) {
        break label659;
      }
      ThemeBackground.setThemeBackgroundPic(this.mContext, this.showData[this.currentIndex].dealSpkey, this.app.a(), str);
      new ThemeDIYActivity.DoBrightnessTask(this, str, this.showData[this.currentIndex]).execute(new Object[0]);
      return;
      str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      break;
      label484:
      localViewHolder.mImageDiy.setBackgroundDrawable(null);
      break label140;
      label496:
      if (localThemeBackground.path != "null") {
        break label140;
      }
      localViewHolder.mImageDiy.setBackgroundDrawable(null);
      break label140;
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_success", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      break label203;
      label566:
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_default_success", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      break label203;
      label614:
      if (paramIntent != null) {
        this.setStatus[this.currentIndex] = 2;
      }
      for (;;)
      {
        if (this.isBTest) {
          break label657;
        }
        this.theme_tryon_layout.setVisibility(0);
        break;
        this.setStatus[this.currentIndex] = 1;
      }
    }
    label659:
    ThemeBackground.clear(this.mContext, this.showData[this.currentIndex].dealSpkey, this.app.a());
  }
  
  void downloadPic(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    this.loadingInt += 1;
    if (this.loadingInt >= 2)
    {
      if (this.loadArr == null) {
        this.loadArr = new ArrayList();
      }
      this.loadArr.add(paramDownloadTask);
    }
    if (this.mDownloadFactory == null)
    {
      this.mDownloadFactory = new DownloaderFactory(this.app);
      this.mDownloadInterface = this.mDownloadFactory.a(1);
    }
    this.mDownloadInterface.a(paramDownloadTask, this.picDownloadListener, null);
  }
  
  Drawable getAssetsDrawable(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      localObject = getResources().getAssets();
      try
      {
        localObject = ((AssetManager)localObject).open("themediy/skin_" + paramString);
        paramString = BitmapFactory.decodeStream((InputStream)localObject);
        paramString = new BitmapDrawable(getResources(), paramString);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        do
        {
          try
          {
            ((InputStream)localObject).close();
            return paramString;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject = paramString;
            }
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              localObject = paramString;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;)
            {
              localObject = paramString;
            }
          }
          localOutOfMemoryError1 = localOutOfMemoryError1;
          localObject = null;
          paramString = (String)localObject;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localOutOfMemoryError1.getMessage());
        return localObject;
      }
      catch (IOException localIOException1)
      {
        do
        {
          localObject = null;
          paramString = (String)localObject;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localIOException1.getMessage());
        return localObject;
      }
      catch (Exception localException1)
      {
        do
        {
          localObject = null;
          paramString = (String)localObject;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localException1.getMessage());
        return localObject;
      }
    }
  }
  
  Drawable getLocalDrawable(String paramString1, String paramString2, View paramView, ThemeDIYActivity.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    Object localObject;
    if (new File(paramString1, paramString2).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject = BitmapManager.a(paramString1 + paramString2, (BitmapFactory.Options)localObject);
      if (localObject != null) {
        return new ChatBackgroundDrawable(this.mContext.getResources(), (Bitmap)localObject);
      }
    }
    if (paramBoolean)
    {
      localObject = "https://imgcache.qq.com/qqshow/admindata/comdata/viptheme_DIY_theme/" + paramString2;
      paramString1 = new File(paramString1, paramString2);
      if (paramViewHolder.dTask == null)
      {
        paramViewHolder.dTask = new DownloadTask(new ArrayList(), new HashMap(), String.valueOf(paramViewHolder.id));
        paramViewHolder.waitMap = new HashMap();
      }
      paramViewHolder.dTask.jdField_a_of_type_JavaUtilList.add(localObject);
      paramViewHolder.dTask.jdField_a_of_type_JavaUtilMap.put(localObject, paramString1);
      paramViewHolder.waitMap.put(paramString2, paramView);
    }
    return null;
  }
  
  void gotoOpenQQVip(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.a());
      localJSONObject.put("openMonth", paramInt);
      localJSONObject.put("aid", "mvip.gexinghua.android.theme_diy");
      localJSONObject.put("offerId", "1450000515");
      localJSONObject.put("serviceName", paramString1);
      localJSONObject.put("serviceCode", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 4, "ThemeDIYBgVIP");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    boolean bool2 = false;
    if ((!this.isVip) && (!this.isShowPay))
    {
      i = 0;
      if (i >= this.setStatus.length) {
        break label190;
      }
      if (this.setStatus[i] != 2) {}
    }
    label190:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      label126:
      do
      {
        do
        {
          try
          {
            this.isShowPay = true;
            DialogUtil.a(this.mContext, 230, getResources().getString(2131365995), "自定义主题为QQ会员专享特权，保存自定义主题需开通QQ会员", 2131365736, 2131366727, new ThemeDIYActivity.2(this), new ThemeDIYActivity.3(this)).show();
            bool1 = true;
            return bool1;
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label126;
            }
            QLog.e("ThemeDIYActivity", 2, localException.getMessage());
          }
          i += 1;
          break;
          super.onBackEvent();
          bool1 = bool2;
        } while (!ThemeBackground.getThemeBackgroundEnable());
        boolean bool1 = bool2;
      } while (!this.isSetted);
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      this.mContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
      isBacked = true;
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2130904472: 
      do
      {
        return;
        localObject = (ViewGroup)paramView.getParent();
      } while (localObject == null);
      ((ViewGroup)localObject).removeView(paramView);
      return;
    case 2131302296: 
      this.isReUpLoad = true;
    case 2131302294: 
      if (this.isReUpLoad) {
        ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_again", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      }
      for (;;)
      {
        paramView = getIntent();
        localObject = this.local_FilesDir + System.currentTimeMillis() + ".jpg";
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        int m = localRect.width();
        int k = localRect.height();
        int j = m;
        int i = k;
        if (this.currentIndex < this.showData.length - 1)
        {
          j = m / 4 * 3;
          i = k / 4 * 3;
        }
        PhotoUtils.a(paramView, this, ThemeDIYActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, j, i, (String)localObject);
        return;
        ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
      }
    }
    ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_default", 0, 1, String.valueOf(this.currentIndex), "", this.reportType, "");
    doOnNewIntent(null);
  }
  
  public void onPostThemeChanged()
  {
    if (this.mScrollLayout != null) {
      this.mScrollLayout.setToScreen(this.currentIndex, 50);
    }
  }
  
  public void onScreenChange(int paramInt)
  {
    ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Skim_page", 0, 1, String.valueOf(paramInt), "", this.reportType, "");
    Object localObject = this.mScrollLayout.getChildAt(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ThemeDIYActivity.ViewHolder)((View)localObject).getTag();
    } while (localObject == null);
    this.currentIndex = paramInt;
    this.btn_themeDiy_upload.setText(this.showData[paramInt].defaultButtonText);
    this.pageIndicator.generatePageControl(paramInt);
    changeBtnStatus(((ThemeBackground)((ThemeDIYActivity.ViewHolder)localObject).mImageDiy.getTag()).path);
  }
  
  void showFrameTips(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(this.mContext, 230, getResources().getString(2131365995), "自定义主题为QQ会员专享特权，保存主题需开通QQ会员", 2131365736, 2131366727, new ThemeDIYActivity.7(this), new ThemeDIYActivity.8(this)).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ThemeDIYActivity", 2, paramContext.getMessage());
    }
  }
  
  void showTitleBtn()
  {
    Button localButton1 = (Button)super.findViewById(2131297807);
    Button localButton2 = (Button)super.findViewById(2131302292);
    String str4 = this.app.a();
    Object localObject = getSharedPreferences("uniPaySp_" + str4, 0);
    String str5 = ((SharedPreferences)localObject).getString("sUin", "");
    int i = ((SharedPreferences)localObject).getInt("isShowOpen", 0);
    int j = ((SharedPreferences)localObject).getInt("iUinpPayType", 0);
    String str2 = "LTMCLUB";
    String str3 = "QQ会员";
    int k = Integer.valueOf(((SharedPreferences)localObject).getString("open_month", "3")).intValue();
    localObject = str3;
    String str1 = str2;
    if (str5 != null)
    {
      localObject = str3;
      str1 = str2;
      if (str4 != null)
      {
        localObject = str3;
        str1 = str2;
        if (str5.equals(str4))
        {
          if (i != 1) {
            break label470;
          }
          localButton1.setVisibility(0);
          switch (j)
          {
          default: 
            this.isVip = true;
            localButton1.setVisibility(8);
            this.theme_tryon_layout.setVisibility(8);
            return;
          case 1: 
            localButton1.setText(2131369067);
            str1 = str2;
            localObject = str3;
          }
        }
      }
    }
    for (;;)
    {
      localObject = new ThemeDIYActivity.4(this, k, (String)localObject, str1);
      localButton1.setOnClickListener((View.OnClickListener)localObject);
      localButton2.setOnClickListener((View.OnClickListener)localObject);
      return;
      localButton1.setText(2131367660);
      localObject = str3;
      str1 = str2;
      continue;
      localButton1.setText(2131369068);
      str1 = "CJCLUBT";
      localObject = "超级会员";
      continue;
      localButton1.setText(2131367661);
      str1 = "CJCLUBT";
      localObject = "超级会员";
      continue;
      localButton1.setText(2131367663);
      str1 = "CJCLUBT";
      localObject = "超级会员";
      continue;
      localButton1.setText(2131367666);
      str1 = "CJCLUBT";
      localObject = "超级会员";
      continue;
      localButton1.setText(2131367664);
      str1 = "CJCLUBT";
      localObject = "超级会员";
      continue;
      localButton1.setText(2131367662);
      str1 = "LTMCLUB";
      localObject = "QQ会员";
      continue;
      localButton1.setText(2131367665);
      str1 = "LTMCLUB";
      localObject = "QQ会员";
    }
    label470:
    this.isVip = true;
    localButton1.setVisibility(8);
    this.theme_tryon_layout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity
 * JD-Core Version:    0.7.0.1
 */