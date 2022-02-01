package com.tencent.mobileqq.activity.widget.qqmusic.business.folder;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.business.manager.BaseLoadSongListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.FolderSongListRequest;
import hcr;
import hcs;
import hcu;
import java.util.ArrayList;

public class FolderSongManager
  extends BaseLoadSongListManager
{
  private static final String a = "liwei";
  public Context a;
  public FolderSongManager.LoadFolderSongListener a;
  protected FolderInfo a;
  protected OnResultListener a;
  public ArrayList a;
  private OnResultListener b;
  public ArrayList b;
  
  public FolderSongManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcs(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcu(this);
  }
  
  public FolderSongManager(FolderInfo paramFolderInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcs(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcu(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo = paramFolderInfo;
  }
  
  public FolderSongManager.LoadFolderSongListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener;
  }
  
  public ArrayList a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (a())
    {
      new Thread(new hcr(this)).start();
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Network.a(new FolderSongListRequest(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo), this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
  }
  
  public void a(Context paramContext, OnResultListener paramOnResultListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Network.a(new FolderSongListRequest(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo), paramOnResultListener);
  }
  
  public void a(FolderSongManager.LoadFolderSongListener paramLoadFolderSongListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderSongManager$LoadFolderSongListener = paramLoadFolderSongListener;
  }
  
  public void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Network.a(new FolderSongListRequest(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo), this.jdField_b_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager
 * JD-Core Version:    0.7.0.1
 */