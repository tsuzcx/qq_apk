package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import ekw;

public class MusicSharePlayActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  private Handler jdField_a_of_type_AndroidOsHandler = new ekw(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQPlayerService a;
  private TextView b;
  
  public MusicSharePlayActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService = null;
  }
  
  private void b()
  {
    SongInfo localSongInfo = QQPlayerService.a();
    if (localSongInfo != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSongInfo.b);
      this.b.setText(localSongInfo.c);
      if (TextUtils.isEmpty(localSongInfo.d)) {
        break label106;
      }
    }
    label106:
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject = getResources().getDrawable(2130841995);
        localObject = URLDrawable.getDrawable(localSongInfo.d, (Drawable)localObject, (Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("IphoneTitleBarActivity", 2, "song.coverUrl: " + localSongInfo.d, localThrowable);
        return;
      }
    }
    QLog.e("IphoneTitleBarActivity", 2, "song.coverUrl is empty ");
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298011));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298012));
    this.b = ((TextView)findViewById(2131298013));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298014));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131298014)
    {
      QQPlayerService.c(getApplicationContext());
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903382);
    setTitle(2131368745);
    setLeftViewName(2131365114);
    a();
    this.app.a(MusicSharePlayActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.a(MusicSharePlayActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MusicSharePlayActivity
 * JD-Core Version:    0.7.0.1
 */