package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import hac;
import had;
import hae;
import haf;
import hag;
import hah;
import hai;
import haj;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class QvipSpecialSoundActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "friendUin";
  private static final int jdField_b_of_type_Int = 1;
  private static final long jdField_b_of_type_Long = 90000L;
  private static final String jdField_b_of_type_JavaLangString = "SpecialSoundActivity";
  private static final int jdField_c_of_type_Int = 2;
  private static final String d = "mvip.gongneng.mobileqq.tiexintixing.ringandroid";
  private static final String e = "mvip.gongneng.mobileqq.tiexintixing.listandroid";
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new had(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QvipSpecialSoundActivity.SpecialSoundAdapter jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new hah(this);
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  
  public QvipSpecialSoundActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300994));
    setLeftViewName(2131366374);
    View localView = LayoutInflater.from(this).inflate(2130904144, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131300996));
    this.b = ((TextView)localView.findViewById(2131300997));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131301000));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131300995));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void a(int paramInt)
  {
    haj localhaj = (haj)QvipSpecialSoundManager.b.get(String.valueOf(paramInt));
    if (localhaj != null) {
      if (localhaj.c == 0) {
        b(getString(2131369152));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SpecialSoundActivity", 2, "用户设置的铃音没有包含在铃音配置文件中，有问题（素材管理系统出问题了）");
  }
  
  private void a(Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, paramUri);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
      return;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!NetworkUtil.e(this))
    {
      b(getString(2131367136));
      return;
    }
    startTitleProgress();
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2), 90000L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new ArrayList();
    paramString.add(String.valueOf(paramInt));
    if (paramInt == 1)
    {
      QvipSpecialCareManager.a(localArrayList, 2, paramString, this.app);
      return;
    }
    QvipSpecialCareManager.a(localArrayList, 3, paramString, this.app);
  }
  
  private boolean a()
  {
    return (!this.app.k()) && (!this.app.l()) && (this.app.m()) && ((this.app.a() == null) || (!this.app.a().e()));
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 300L;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.c = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("friendUin");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter = new QvipSpecialSoundActivity.SpecialSoundAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    if (VipUtils.a(this.app))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131369137));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131369136));
  }
  
  private void b(String paramString)
  {
    if (!isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, getTitleBarHeight(), 0, 0);
    }
  }
  
  private void c()
  {
    String str = "key_special_sound_list" + this.app.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      startTitleProgress();
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new hac(this, str));
      return;
    }
    this.jdField_a_of_type_JavaUtilList = ((List)QvipSpecialSoundManager.jdField_a_of_type_JavaUtilHashMap.get(str));
  }
  
  private void c(String paramString)
  {
    DialogUtil.a(this, 230, getString(2131365995), paramString, 2131365736, 2131369145, new haf(this), new hag(this)).show();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter.a(this.jdField_a_of_type_JavaUtilList);
    int i = QvipSpecialCareManager.a(this.c, this.app);
    if (i == 1)
    {
      f();
      return;
    }
    a(i);
  }
  
  private void e()
  {
    a(this.c, 1);
    if (a())
    {
      h();
      a(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165199));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300998).setVisibility(0);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300998).setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  public void a(View paramView)
  {
    long l = System.currentTimeMillis();
    if (!a(this.jdField_a_of_type_Long, l)) {}
    Object localObject;
    label214:
    do
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          this.jdField_a_of_type_Long = l;
          localObject = (hai)paramView.getTag();
          if (localObject != null)
          {
            i = ((hai)localObject).jdField_a_of_type_Int;
            if (VipUtils.a(this.app)) {
              a(this.c, ((hai)localObject).jdField_a_of_type_Int);
            }
            while (a())
            {
              try
              {
                h();
                if (i != 1) {
                  break label214;
                }
                a(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165199));
                return;
              }
              catch (Exception paramView)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SpecialSoundActivity", 2, "onItemClick play music exception:" + paramView.getMessage());
                }
                paramView.printStackTrace();
                return;
              }
              if (!this.jdField_a_of_type_Boolean)
              {
                c(String.format(getString(2131369143), new Object[] { Integer.valueOf(QvipSpecialCareManager.b(this.app)) }));
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
        }
      } while (i <= 1);
      paramView = new File(getFilesDir(), ((hai)localObject).jdField_a_of_type_JavaLangString);
      if (paramView.exists())
      {
        a(paramView.getAbsolutePath());
        return;
      }
      if (!NetworkUtil.e(this))
      {
        b(getString(2131367136));
        return;
      }
      localObject = ((hai)localObject).jdField_a_of_type_JavaLangString;
    } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject));
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Boolean.valueOf(true));
    startTitleProgress();
    this.app.a(new hae(this, (String)localObject, paramView));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (paramString != null))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(new FileInputStream(paramString).getFD());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904143);
    setTitle(2131369134);
    a();
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    h();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.app != null) {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    for (;;)
    {
      return;
      if ((paramInt1 == 4) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("result");
        try
        {
          if ((new JSONObject(paramIntent).getInt("resultCode") == 0) && (this.jdField_a_of_type_AndroidOsHandler != null))
          {
            paramIntent = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301000: 
      VipUtils.b(this, 3, "mvip.gongneng.mobileqq.tiexintixing.listandroid");
      return;
    case 2131300995: 
      e();
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity
 * JD-Core Version:    0.7.0.1
 */