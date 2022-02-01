package com.tencent.mobileqq.activity.widget.qqmusic.business.folder;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.FavSongRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.FolderSongListRequest;
import com.tencent.mobileqq.music.SongInfo;
import hcw;
import hcx;
import hcy;

public class MyFavSongManager
  extends FolderSongManager
{
  private static MyFavSongManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderMyFavSongManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "liwei";
  protected OnResultListener b = new hcx(this);
  protected OnResultListener c = new hcy(this);
  
  public static MyFavSongManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderMyFavSongManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderMyFavSongManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderMyFavSongManager = new MyFavSongManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderMyFavSongManager;
    }
  }
  
  public void a(Context paramContext)
  {
    if (a())
    {
      new Thread(new hcw(this)).start();
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new FolderInfo();
    paramContext.b(0L);
    paramContext.c(QQMusicHelper.a());
    paramContext.a(201L);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo = paramContext;
    Network.a(new FolderSongListRequest(paramContext), this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
  }
  
  public void a(SongInfo paramSongInfo, boolean paramBoolean)
  {
    Network.a(new FavSongRequest(paramSongInfo, 201L, paramBoolean), this.c);
  }
  
  public void c(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new FolderInfo();
    paramContext.b(0L);
    paramContext.c(QQMusicHelper.a());
    paramContext.a(201L);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo = paramContext;
    Network.a(new FolderSongListRequest(paramContext), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager
 * JD-Core Version:    0.7.0.1
 */