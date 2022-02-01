package com.tencent.mobileqq.vas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kva;
import kvb;
import kvd;
import kve;
import kvf;
import kvg;
import kvh;
import kvi;
import org.json.JSONException;
import org.json.JSONObject;

public class ColorRingPlayer
  implements View.OnClickListener
{
  public static final String a = "ColorRingPlayer";
  public int a;
  public AudioManager.OnAudioFocusChangeListener a;
  public MediaPlayer a;
  public Handler a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Button a;
  public ImageView a;
  public ProgressBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQBrowserActivity a;
  public Client.onRemoteRespObserver a;
  public PhotoProgressDrawable a;
  public Object a;
  public kvi a;
  public boolean a;
  public ImageView b;
  ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public ImageView c;
  TextView c;
  TextView d;
  
  public ColorRingPlayer(QQBrowserActivity paramQQBrowserActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Kvi = new kvi(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = null;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new kva(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new kvg(this);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    WebIPCOperator.getInstance().registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297533));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131300782));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300777));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131298193));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300779));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299804));
    this.d = ((TextView)paramViewGroup.findViewById(2131300780));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300776));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131300781));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300775));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  String a(int paramInt)
  {
    if (paramInt > 3599) {
      return "";
    }
    int i = paramInt % 60;
    paramInt /= 60;
    if (paramInt >= 10) {}
    for (String str = "" + paramInt;; str = "" + "0" + paramInt)
    {
      str = str + ":";
      if (i < 10) {
        break;
      }
      return str + i;
    }
    return str + "0" + i;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840714));
      }
    }
    synchronized (this.jdField_a_of_type_Kvi)
    {
      this.jdField_a_of_type_Kvi.h = 5;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  void a(long paramLong)
  {
    ??? = new Bundle();
    ((Bundle)???).putLong("id", paramLong);
    ((Bundle)???).putInt("resourceType", 3);
    a(DataFactory.makeIPCRequestPacket("stopDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)???));
    synchronized (this.jdField_a_of_type_Kvi)
    {
      this.jdField_a_of_type_Kvi.h = 2;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840712));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368546));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
  }
  
  /* Error */
  public void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 10
    //   8: iconst_2
    //   9: new 134	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   16: ldc 240
    //   18: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: lload_1
    //   22: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   25: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 42	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   35: astore 4
    //   37: aload 4
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   44: ifnull +15 -> 59
    //   47: aload_0
    //   48: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   59: aload 4
    //   61: monitorexit
    //   62: aload_0
    //   63: new 152	android/media/MediaPlayer
    //   66: dup
    //   67: invokespecial 250	android/media/MediaPlayer:<init>	()V
    //   70: putfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   73: aload_0
    //   74: getfield 40	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_Kvi	Lkvi;
    //   77: astore 4
    //   79: aload 4
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 40	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_Kvi	Lkvi;
    //   86: iconst_4
    //   87: putfield 185	kvi:h	I
    //   90: aload 4
    //   92: monitorexit
    //   93: lload_1
    //   94: lconst_0
    //   95: lcmp
    //   96: ifne +256 -> 352
    //   99: aload_0
    //   100: getfield 64	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   103: invokevirtual 171	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   106: ldc 251
    //   108: invokevirtual 255	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   111: astore 4
    //   113: aload 4
    //   115: ifnonnull +75 -> 190
    //   118: aload_0
    //   119: getfield 42	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   122: astore 4
    //   124: aload 4
    //   126: monitorenter
    //   127: aload_0
    //   128: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   139: aload 4
    //   141: monitorexit
    //   142: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc 10
    //   150: iconst_2
    //   151: ldc_w 257
    //   154: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: return
    //   158: astore 5
    //   160: aload 4
    //   162: monitorexit
    //   163: aload 5
    //   165: athrow
    //   166: astore 5
    //   168: aload 4
    //   170: monitorexit
    //   171: aload 5
    //   173: athrow
    //   174: astore 4
    //   176: aload 4
    //   178: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   181: return
    //   182: astore 5
    //   184: aload 4
    //   186: monitorexit
    //   187: aload 5
    //   189: athrow
    //   190: aload_0
    //   191: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   194: aload 4
    //   196: invokevirtual 266	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   199: aload 4
    //   201: invokevirtual 270	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   204: aload 4
    //   206: invokevirtual 273	android/content/res/AssetFileDescriptor:getLength	()J
    //   209: invokevirtual 277	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   212: aload 4
    //   214: invokevirtual 280	android/content/res/AssetFileDescriptor:close	()V
    //   217: aload_0
    //   218: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   221: invokevirtual 283	android/media/MediaPlayer:prepare	()V
    //   224: aload_0
    //   225: getfield 64	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   228: ldc_w 285
    //   231: invokevirtual 289	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   234: checkcast 291	android/media/AudioManager
    //   237: astore 4
    //   239: aload 4
    //   241: aload_0
    //   242: getfield 55	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   245: iconst_3
    //   246: iconst_1
    //   247: invokevirtual 295	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   250: iconst_1
    //   251: if_icmpne +116 -> 367
    //   254: aload_0
    //   255: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   258: iload_3
    //   259: invokevirtual 298	android/media/MediaPlayer:seekTo	(I)V
    //   262: aload_0
    //   263: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   266: invokevirtual 301	android/media/MediaPlayer:start	()V
    //   269: aload_0
    //   270: invokevirtual 303	com/tencent/mobileqq/vas/ColorRingPlayer:d	()V
    //   273: aload_0
    //   274: getfield 109	com/tencent/mobileqq/vas/ColorRingPlayer:d	Landroid/widget/TextView;
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   282: invokevirtual 306	android/media/MediaPlayer:getDuration	()I
    //   285: sipush 1000
    //   288: idiv
    //   289: invokevirtual 308	com/tencent/mobileqq/vas/ColorRingPlayer:a	(I)Ljava/lang/String;
    //   292: invokevirtual 309	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   295: aload_0
    //   296: getfield 93	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   299: aload_0
    //   300: getfield 64	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   303: invokevirtual 171	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   306: ldc_w 310
    //   309: invokevirtual 178	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   312: invokevirtual 182	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   315: aload_0
    //   316: getfield 93	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   319: iconst_0
    //   320: invokevirtual 222	android/widget/ImageView:setVisibility	(I)V
    //   323: aload_0
    //   324: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   327: new 312	kuz
    //   330: dup
    //   331: aload_0
    //   332: aload 4
    //   334: invokespecial 315	kuz:<init>	(Lcom/tencent/mobileqq/vas/ColorRingPlayer;Landroid/media/AudioManager;)V
    //   337: invokevirtual 319	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   340: aload_0
    //   341: ldc_w 321
    //   344: ldc_w 321
    //   347: iconst_0
    //   348: invokevirtual 324	com/tencent/mobileqq/vas/ColorRingPlayer:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   351: return
    //   352: aload_0
    //   353: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   356: lload_1
    //   357: iconst_3
    //   358: invokestatic 329	com/tencent/mobileqq/vas/ColorRingManager:b	(JI)Ljava/lang/String;
    //   361: invokevirtual 332	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   364: goto -147 -> 217
    //   367: aload_0
    //   368: getfield 42	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   371: astore 4
    //   373: aload 4
    //   375: monitorenter
    //   376: aload_0
    //   377: getfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   380: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   383: aload_0
    //   384: aconst_null
    //   385: putfield 44	com/tencent/mobileqq/vas/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   388: aload 4
    //   390: monitorexit
    //   391: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -237 -> 157
    //   397: ldc 10
    //   399: iconst_2
    //   400: ldc_w 334
    //   403: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: return
    //   407: astore 5
    //   409: aload 4
    //   411: monitorexit
    //   412: aload 5
    //   414: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	ColorRingPlayer
    //   0	415	1	paramLong	long
    //   0	415	3	paramInt	int
    //   174	39	4	localIOException	java.io.IOException
    //   158	6	5	localObject3	Object
    //   166	6	5	localObject4	Object
    //   182	6	5	localObject5	Object
    //   407	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   40	59	158	finally
    //   59	62	158	finally
    //   160	163	158	finally
    //   82	93	166	finally
    //   168	171	166	finally
    //   73	82	174	java/io/IOException
    //   99	113	174	java/io/IOException
    //   118	127	174	java/io/IOException
    //   142	157	174	java/io/IOException
    //   171	174	174	java/io/IOException
    //   187	190	174	java/io/IOException
    //   190	217	174	java/io/IOException
    //   217	351	174	java/io/IOException
    //   352	364	174	java/io/IOException
    //   367	376	174	java/io/IOException
    //   391	406	174	java/io/IOException
    //   412	415	174	java/io/IOException
    //   127	142	182	finally
    //   184	187	182	finally
    //   376	391	407	finally
    //   409	412	407	finally
  }
  
  void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt != 3)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("id", paramLong);
      ((Bundle)localObject).putInt("resourceType", paramInt);
      ((Bundle)localObject).putString("colorType", paramString);
      a(DataFactory.makeIPCRequestPacket("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)localObject));
      return;
    }
    if (NetworkUtil.a(((ConnectivityManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("connectivity")).getActiveNetworkInfo()))
    {
      localObject = new kvd(this, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getActivity(), 2131558902);
      ((QQCustomDialog)localObject).setContentView(2130903216);
      ((QQCustomDialog)localObject).setTitle("温馨提示");
      ((QQCustomDialog)localObject).setMessage(2131366717);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setNegativeButton(2131365736, new kve(this));
      ((QQCustomDialog)localObject).setPositiveButton(2131365737, new kvf(this, paramLong, paramInt, paramString));
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramLong, paramInt, paramString);
  }
  
  void a(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368558);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramString);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(paramString);
      if (paramLong != 0L) {
        break label261;
      }
      a(paramLong, 0);
      if (!a(paramLong, paramString)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368551));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840713));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840711));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368552));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
      if ("comering".equals(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368559);
      }
    }
    if (paramString.equals("colorring")) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368547));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      break;
      if (paramString.equals("comering")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368548));
      }
    }
    label261:
    if (a(paramLong, paramString)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (!new File(ColorRingManager.b(paramLong, 3)).exists())
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840712));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals("colorring"))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368547));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        a(paramLong, 3, paramString);
        label368:
        if (new File(ColorRingManager.b(paramLong, 1)).exists()) {
          break label610;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840710));
        a(paramLong, 1, paramString);
      }
    }
    for (;;)
    {
      if (new File(ColorRingManager.b(paramLong, 2)).exists()) {
        break label631;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      a(paramLong, 2, paramString);
      return;
      if (!paramString.equals("comering")) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368548));
      break;
      a(paramLong, 0);
      if (a(paramLong, paramString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368551));
        break label368;
      }
      if (paramString.equals("colorring")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368547));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        break;
        if (paramString.equals("comering")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368548));
        }
      }
      label610:
      if (ColorRingManager.a(paramLong) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ColorRingManager.a(paramLong));
      }
    }
    label631:
    a(ColorRingManager.a(paramLong));
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String arg5)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Kvi)
      {
        if (this.jdField_a_of_type_Kvi.jdField_a_of_type_Long == paramLong)
        {
          if (paramInt != 0) {
            break label203;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368551));
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          if (!paramString1.equals("colorring")) {
            continue;
          }
          if (paramInt == 0)
          {
            paramInt = i;
            a("0X8004A24", "0X8004A24", paramInt);
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            a(DataFactory.makeIPCRequestPacket("colorRingSetup", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, localBundle));
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return;
        }
        paramInt = 1;
        continue;
        if (!paramString1.equals("comering")) {
          continue;
        }
        if (paramInt == 0)
        {
          paramInt = j;
          a("0X8005003", "0X8005003", paramInt);
        }
      }
      paramInt = 1;
      continue;
      label203:
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "setup failure.");
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_Kvi)
    {
      if ((this.jdField_a_of_type_Kvi.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_Kvi.jdField_a_of_type_JavaLangString.equals(paramString1)))
      {
        if (this.jdField_a_of_type_Kvi.h == 6) {
          a(paramLong, 0);
        }
        return;
      }
      if (this.jdField_a_of_type_Kvi.h == 1) {
        a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long);
      }
      b();
      this.jdField_a_of_type_Kvi.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Kvi.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Kvi.b = paramString2;
      this.jdField_a_of_type_Kvi.h = 0;
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
      a(paramLong, paramString1);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded())
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), "正在初始化服务，请稍候尝试", 0).show();
      return;
    }
    WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(paramBundle);
  }
  
  public void a(String arg1)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840714));
    }
    synchronized (this.jdField_a_of_type_Kvi)
    {
      this.jdField_a_of_type_Kvi.h = 6;
      this.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
    }
  }
  
  void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a().post(new kvh(this, paramString1, paramString2, paramInt));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "initColorRingDetail, detail is null");
      }
      return;
    }
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("singer"));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  boolean a(long paramLong, String paramString)
  {
    Object localObject = (BrowserAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
    EntityManager localEntityManager = ((BrowserAppInterface)localObject).a(null).createEntityManager();
    localObject = (ExtensionInfo)localEntityManager.a(ExtensionInfo.class, ((BrowserAppInterface)localObject).getAccount());
    localEntityManager.a();
    if (localObject == null) {
      return false;
    }
    if (("colorring".equals(paramString)) && (((ExtensionInfo)localObject).colorRingId == paramLong)) {
      return true;
    }
    return ("comering".equals(paramString)) && (((ExtensionInfo)localObject).commingRingId == paramLong);
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      return;
    }
  }
  
  public void b(long paramLong, int paramInt, String arg4)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("id", paramLong);
    ((Bundle)localObject1).putInt("resourceType", paramInt);
    ((Bundle)localObject1).putString("colorType", ???);
    a(DataFactory.makeIPCRequestPacket("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, (Bundle)localObject1));
    synchronized (this.jdField_a_of_type_Kvi)
    {
      this.jdField_a_of_type_Kvi.h = 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ??? = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources(), 2130841318);
        ??? = (String)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label113:
        break label113;
      }
      localObject1 = ???;
      if (??? == null) {
        localObject1 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable((Bitmap)localObject1, (int)(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().density * 12.0F));
      ??? = new Rect();
      ???.set(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131493197), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131493198));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(???);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131368545));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  public void c()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          synchronized (this.jdField_a_of_type_Kvi)
          {
            long l = this.jdField_a_of_type_Kvi.jdField_a_of_type_Long;
            a(l, this.jdField_a_of_type_Int);
            d();
            this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840713));
          }
        }
      }
      synchronized (this.jdField_a_of_type_Kvi)
      {
        this.jdField_a_of_type_Kvi.h = 4;
        return;
        localObject4 = finally;
        throw localObject4;
        localObject2 = finally;
        throw localObject2;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
    }
  }
  
  void d()
  {
    new kvb(this).start();
  }
  
  public void e()
  {
    WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    ??? = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("audio");
    if (??? == null) {
      return;
    }
    ((AudioManager)???).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130840714));
      }
      synchronized (this.jdField_a_of_type_Kvi)
      {
        this.jdField_a_of_type_Kvi.h = 6;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void onClick(View arg1)
  {
    String str4 = (String)???.getTag();
    String str1 = str4;
    if (str4 == null) {
      str1 = "colorring";
    }
    switch (???.getId())
    {
    default: 
      return;
    case 2131300777: 
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Kvi)
        {
          if (this.jdField_a_of_type_Kvi.h == 4)
          {
            a();
            return;
          }
        }
        if (this.jdField_a_of_type_Kvi.h == 5)
        {
          c();
        }
        else if (this.jdField_a_of_type_Kvi.h == 6)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 0);
        }
        else if (this.jdField_a_of_type_Kvi.h == 1)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long);
          this.jdField_a_of_type_Kvi.h = 2;
        }
        else if (this.jdField_a_of_type_Kvi.h == 2)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 3, str2);
        }
        else if (this.jdField_a_of_type_Kvi.h == 0)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 3, str2);
        }
        else if (this.jdField_a_of_type_Kvi.h == 3)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 0);
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Kvi)
      {
        if (this.jdField_a_of_type_Kvi.h == 1)
        {
          a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long);
          return;
        }
      }
      if (this.jdField_a_of_type_Kvi.h == 2)
      {
        a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 3, str3);
      }
      else if (this.jdField_a_of_type_Kvi.h == 0)
      {
        a(this.jdField_a_of_type_Kvi.jdField_a_of_type_Long, 3, str3);
      }
      else if (this.jdField_a_of_type_Kvi.h >= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a().a(this.jdField_a_of_type_Kvi.b, new String[] { "{'result':0,'message':'OK'}" });
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer
 * JD-Core Version:    0.7.0.1
 */