package com.tencent.mobileqq.activity.widget.qqmusic.business.radio;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.business.manager.BaseLoadSongListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.RadioListRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.postcontent.NetPageXmlBody;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.SonginfoUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import hcz;
import hda;
import java.util.ArrayList;

public class GuessYouLikeManager
  extends BaseLoadSongListManager
{
  private static GuessYouLikeManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessRadioGuessYouLikeManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "liwei";
  private static final int e = 50;
  private Context jdField_a_of_type_AndroidContentContext;
  private OnResultListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcz(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private OnResultListener b = new hda(this);
  
  public static GuessYouLikeManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessRadioGuessYouLikeManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessRadioGuessYouLikeManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessRadioGuessYouLikeManager = new GuessYouLikeManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessRadioGuessYouLikeManager;
    }
  }
  
  private void b(Context paramContext, OnResultListener paramOnResultListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    RadioListRequest localRadioListRequest = new RadioListRequest();
    localRadioListRequest.b(QQMusicCGIConfig.d());
    NetPageXmlBody localNetPageXmlBody = new NetPageXmlBody("703");
    localNetPageXmlBody.c("99");
    localNetPageXmlBody.d("2");
    localNetPageXmlBody.e("1");
    localRadioListRequest.a(localNetPageXmlBody.a(paramContext, null));
    Network.a(localRadioListRequest, paramOnResultListener);
  }
  
  public void a(Context paramContext)
  {
    b(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
  }
  
  public void a(Context paramContext, OnResultListener paramOnResultListener)
  {
    b(paramContext, paramOnResultListener);
  }
  
  public boolean a(Context paramContext)
  {
    int i = QQPlayerService.c();
    int j = QQPlayerService.f();
    if (j + 1 >= 50)
    {
      a(paramContext);
      return true;
    }
    if (j + 2 >= i) {
      b(paramContext, this.b);
    }
    return false;
  }
  
  public boolean a(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if ((QQPlayerService.c() == 1) || (paramSongInfo == null)) {
      return false;
    }
    int i = QQPlayerService.f();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= i)) {
      return false;
    }
    if (((com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b() != paramSongInfo.a) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(i);
    paramSongInfo = SonginfoUtil.a(this.jdField_a_of_type_JavaUtilArrayList, 1);
    if (i >= paramSongInfo.length) {
      QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(6, ""), paramSongInfo);
    }
    for (;;)
    {
      return true;
      QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(6, ""), paramSongInfo, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager
 * JD-Core Version:    0.7.0.1
 */