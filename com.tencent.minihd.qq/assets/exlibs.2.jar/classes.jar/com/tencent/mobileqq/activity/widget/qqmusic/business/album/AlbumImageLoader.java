package com.tencent.mobileqq.activity.widget.qqmusic.business.album;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.data.AlbumInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.AlbumRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.AlbumUtil;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.music.SongInfo;
import hcn;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

public class AlbumImageLoader
{
  private static AlbumImageLoader jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader;
  private static final String jdField_a_of_type_JavaLangString = "AlbumImageLoader";
  private final Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  
  public static AlbumImageLoader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader == null) {
      jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader = new AlbumImageLoader();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader;
  }
  
  private void a(AlbumInfo paramAlbumInfo, AlbumImageLoader.LoadAlbumOptions paramLoadAlbumOptions)
  {
    if (paramAlbumInfo == null)
    {
      MLog.d("AlbumImageLoader", "back album info is empty!!");
      return;
    }
    if (!TextUtils.isEmpty(paramAlbumInfo.a()))
    {
      paramLoadAlbumOptions.jdField_a_of_type_JavaLangString = paramAlbumInfo.a();
      this.jdField_a_of_type_JavaUtilHashtable.put(b(paramLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo), paramLoadAlbumOptions.jdField_a_of_type_JavaLangString);
      c(paramLoadAlbumOptions);
      return;
    }
    if (!TextUtils.isEmpty(paramAlbumInfo.c()))
    {
      paramLoadAlbumOptions.jdField_a_of_type_JavaLangString = paramAlbumInfo.c();
      this.jdField_a_of_type_JavaUtilHashtable.put(b(paramLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo), paramLoadAlbumOptions.jdField_a_of_type_JavaLangString);
      c(paramLoadAlbumOptions);
      return;
    }
    paramLoadAlbumOptions.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramLoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    MLog.d("AlbumImageLoader", "back album url is empty!!");
  }
  
  private String b(SongInfo paramSongInfo)
  {
    return AlbumUtil.a(paramSongInfo);
  }
  
  private void b(AlbumImageLoader.LoadAlbumOptions paramLoadAlbumOptions)
  {
    Network.a(new AlbumRequest(paramLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo), new hcn(this, paramLoadAlbumOptions));
  }
  
  private void c(AlbumImageLoader.LoadAlbumOptions paramLoadAlbumOptions)
  {
    try
    {
      MusicPreferences.a().d(paramLoadAlbumOptions.jdField_a_of_type_JavaLangString);
      Object localObject = new URL(paramLoadAlbumOptions.jdField_a_of_type_JavaLangString);
      localObject = URLDrawable.getDrawable(new URL("album", ((URL)localObject).getAuthority(), ((URL)localObject).getFile()), paramLoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramLoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (localObject != null) {
        paramLoadAlbumOptions.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      return;
    }
    catch (MalformedURLException paramLoadAlbumOptions)
    {
      MLog.a("AlbumImageLoader", paramLoadAlbumOptions);
    }
  }
  
  public String a(SongInfo paramSongInfo)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashtable.get(b(paramSongInfo));
  }
  
  public void a(AlbumImageLoader.LoadAlbumOptions paramLoadAlbumOptions)
  {
    if (paramLoadAlbumOptions == null) {
      return;
    }
    if ((paramLoadAlbumOptions.jdField_a_of_type_AndroidWidgetImageView == null) || (paramLoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (paramLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo == null))
    {
      MLog.d("AlbumImageLoader", "LoadAlbumOptions is lost some info!!!");
      return;
    }
    String str = b(paramLoadAlbumOptions.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
    str = (String)this.jdField_a_of_type_JavaUtilHashtable.get(str);
    if (TextUtils.isEmpty(str))
    {
      b(paramLoadAlbumOptions);
      return;
    }
    paramLoadAlbumOptions.jdField_a_of_type_JavaLangString = str;
    c(paramLoadAlbumOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader
 * JD-Core Version:    0.7.0.1
 */