package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader;
import com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader.LoadAlbumOptions;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager.LoadFolderSongListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.SingleSongRadioBehaviorReport;
import com.tencent.mobileqq.activity.widget.qqmusic.business.share.ShareHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import hdx;
import hdy;
import hdz;
import hea;
import hed;
import hee;
import hef;
import heg;
import hel;
import hem;
import hen;
import heo;
import hep;
import heq;
import her;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QQMusicWidget
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = 500;
  private static final String jdField_a_of_type_JavaLangString = "QQMusicWidget";
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int jdField_e_of_type_Int = 3;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FolderSongManager.LoadFolderSongListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener = new hef(this);
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiCircleProgressView;
  private ProgressWheel jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel;
  private QQMusicWidget.ProgressHandler jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget$ProgressHandler;
  private QQPlayerService.QQPlayerCallback jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback = new hea(this);
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  
  public QQMusicWidget(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQMusicWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public QQMusicWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private QQAppInterface a()
  {
    try
    {
      QQAppInterface localQQAppInterface = BaseActivity.sTopActivity.app;
      return localQQAppInterface;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.h = paramInt;
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      b(false);
      continue;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget$ProgressHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiCircleProgressView.setProgress(0);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget$ProgressHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget$ProgressHandler.sendEmptyMessageDelayed(0, 500L);
      continue;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      b(true);
    }
  }
  
  private void a(Context paramContext)
  {
    addView(LayoutInflater.from(paramContext).inflate(2130903950, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget$ProgressHandler = new QQMusicWidget.ProgressHandler(this);
  }
  
  private void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return;
    }
    String str1 = paramSongInfo.jdField_b_of_type_JavaLangString;
    String str2 = paramSongInfo.g;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + " - " + str2);
    if (this.f != paramSongInfo.jdField_b_of_type_Int)
    {
      this.f = paramSongInfo.jdField_b_of_type_Int;
      if (this.f != 1) {
        break label107;
      }
      this.i = 0;
    }
    for (;;)
    {
      k();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(MusicPreferences.a().e());
      a(a(paramSongInfo.jdField_a_of_type_Long));
      return;
      switch (QQMusicHelper.a())
      {
      default: 
        this.i = 1;
        QQPlayerService.a(103);
        break;
      case 101: 
        this.i = 3;
        QQPlayerService.a(101);
        break;
      case 105: 
        label107:
        this.i = 2;
        QQPlayerService.a(105);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setBackgroundResource(2130840630);
      return;
    }
    this.d.setBackgroundResource(2130840631);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = l;
    return true;
  }
  
  private boolean a(long paramLong)
  {
    return MyFavSongManager.a().a().contains(Long.valueOf(paramLong));
  }
  
  private void b(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return;
    }
    AlbumImageLoader.LoadAlbumOptions localLoadAlbumOptions = new AlbumImageLoader.LoadAlbumOptions();
    localLoadAlbumOptions.jdField_a_of_type_AndroidWidgetImageView = this.e;
    localLoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840654);
    localLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    AlbumImageLoader.a().a(localLoadAlbumOptions);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel.setVisibility(8);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hdx(this);
      getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.activity.ForwardRecentActivity.ACTION_LIST_ITEM_ON_CLICK"));
    }
  }
  
  private void c(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      return;
    }
    Intent localIntent = new Intent(getContext(), MusicGeneQQBrowserActivity.class);
    long l = QQMusicHelper.a();
    paramSongInfo = ShareHelper.a(paramSongInfo.jdField_a_of_type_Long);
    localIntent.putExtra("uin", String.valueOf(l));
    localIntent.putExtra("url", paramSongInfo);
    localIntent.putExtra("BUNDLE_KEY_FROM_PLAY_BAR", true);
    QQPlayerService.a(localIntent);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void d(SongInfo paramSongInfo)
  {
    if ((paramSongInfo == null) || (paramSongInfo.c != 1)) {
      return;
    }
    boolean bool = a(paramSongInfo.jdField_a_of_type_Long);
    ArrayList localArrayList = MyFavSongManager.a().a();
    if (bool)
    {
      DialogUtil.a(getContext(), 230, getContext().getResources().getString(2131365007), getContext().getResources().getString(2131365008), getContext().getResources().getString(2131365009), getContext().getResources().getString(2131365010), new hed(this, paramSongInfo, localArrayList), new hee(this)).show();
      ReportController.b(a(), "CliOper", "", "", "0X8006288", "0X8006288", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      MyFavSongManager.a().a(true);
      return;
      MyFavSongManager.a().a(paramSongInfo, true);
      localArrayList.add(Long.valueOf(paramSongInfo.jdField_a_of_type_Long));
      a(true);
      ReportController.b(a(), "CliOper", "", "", "0X8006288", "0X8006288", 0, 0, "", "", "", "");
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300179));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300180));
    this.c = ((ImageView)findViewById(2131300188));
    this.d = ((ImageView)findViewById(2131300190));
    this.e = ((ImageView)findViewById(2131300177));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300184));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiCircleProgressView = ((CircleProgressView)findViewById(2131300178));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiProgressWheel = ((ProgressWheel)findViewById(2131300181));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300175));
  }
  
  private void f()
  {
    QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback);
    MyFavSongManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new heg(this));
    findViewById(2131300183).setOnClickListener(new hel(this));
    findViewById(2131300182).setOnClickListener(new hem(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new hen(this));
    findViewById(2131300189).setOnClickListener(new heo(this));
    findViewById(2131300187).setOnClickListener(new hep(this));
    findViewById(2131300185).setOnClickListener(new heq(this));
    findViewById(2131300173).setOnClickListener(new her(this));
    this.e.setOnClickListener(new hdy(this));
    findViewById(2131300186).setOnClickListener(new hdz(this));
  }
  
  private void g()
  {
    Object localObject2 = MusicPreferences.a().d();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getResources().getDrawable(2130840654);
    }
    try
    {
      localObject2 = new URL((String)localObject2);
      localObject1 = URLDrawable.getDrawable(new URL("album", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), (Drawable)localObject1, (Drawable)localObject1);
      if (localObject1 != null) {
        this.e.setImageDrawable((Drawable)localObject1);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localMalformedURLException);
        continue;
        switch (MusicPreferences.a().c())
        {
        case 102: 
        case 104: 
        default: 
          break;
        case 101: 
          this.i = 3;
          break;
        case 103: 
          this.i = 1;
          break;
        case 105: 
          this.i = 2;
        }
      }
    }
    Object localObject1 = MusicPreferences.a().e();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131365000));
      this.f = MusicPreferences.a().a();
      if (this.f != 1) {
        break label148;
      }
      this.i = 0;
      k();
    }
  }
  
  private void h()
  {
    if (MusicPreferences.a().a() == 1)
    {
      this.f = 1;
      GuessYouLikeManager.a().a(getContext());
      localObject = getResources().getString(2131365000);
      MusicPreferences.a().e((String)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    this.f = 0;
    Object localObject = new FolderInfo();
    ((FolderInfo)localObject).a(MusicPreferences.a().a());
    ((FolderInfo)localObject).b(MusicPreferences.a().b());
    ((FolderInfo)localObject).c(MusicPreferences.a().c());
    new FolderSongManager((FolderInfo)localObject).b(getContext());
  }
  
  private void i()
  {
    this.g = QQPlayerService.f();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = QQPlayerService.a();
    MusicPreferences.a().b(this.g);
  }
  
  private void j()
  {
    QQPlayerService.QQPlayerCallback localQQPlayerCallback = QQPlayerService.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback != localQQPlayerCallback) {
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
    {
      h();
      return;
    }
    if (this.g < this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length) {}
    for (int j = this.g;; j = 0)
    {
      QQPlayerService.a(QQMusicHelper.a());
      QQPlayerService.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback.getToken(), this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo, j);
      return;
    }
  }
  
  private void k()
  {
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.c.setImageResource(2130840625);
      return;
    case 1: 
      this.c.setImageResource(2130840622);
      return;
    case 2: 
      this.c.setImageResource(2130840649);
      return;
    }
    this.c.setImageResource(2130840652);
  }
  
  private void l()
  {
    if (QQPlayerService.a() == 2)
    {
      int j = QQPlayerService.d();
      int k = QQPlayerService.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiCircleProgressView.setProgress(k, j);
    }
  }
  
  private void m()
  {
    SongInfo localSongInfo = QQPlayerService.a();
    if (localSongInfo == null) {}
    while (localSongInfo.jdField_b_of_type_Int != 1) {
      return;
    }
    GuessYouLikeManager.a().a(localSongInfo);
    SingleSongRadioBehaviorReport.a(localSongInfo, "", QQPlayerService.e() / 1000, "", null, 15, 9);
  }
  
  public void a()
  {
    String str1 = QQPlayerService.a();
    String str2 = QQPlayerService.a(6, "");
    MLog.b("liwei", "onResume : " + str1);
    if ((str1 != null) && (str1.equals(str2)))
    {
      if (QQPlayerService.a() != this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback) {
        QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback);
      }
      return;
    }
    a(0);
  }
  
  public void b()
  {
    QQPlayerService.c(getContext());
    this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = null;
    this.g = 0;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131365000));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131364999));
    Drawable localDrawable = getResources().getDrawable(2130840654);
    this.e.setImageDrawable(localDrawable);
    MusicPreferences.a().a(1);
    MusicPreferences.a().d("");
    MusicPreferences.a().e("");
    MusicPreferences.a().c(103);
    QQMusicHelper.a(103);
    this.i = 0;
    k();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e();
    f();
    g();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget
 * JD-Core Version:    0.7.0.1
 */