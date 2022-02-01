package com.tencent.mobileqq.activity.widget.qqmusic.business.folder;

import android.content.Context;
import com.tencent.mobileqq.activity.widget.qqmusic.business.manager.BaseLoadFolderListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.FolderListRequest;
import hcq;
import java.util.ArrayList;

public class FolderListManager
  extends BaseLoadFolderListManager
{
  private static FolderListManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "liwei";
  private Context jdField_a_of_type_AndroidContentContext;
  private FolderListManager.LoadFolderListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener;
  private OnResultListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hcq(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList b = new ArrayList();
  
  public static FolderListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager = new FolderListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager;
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener.a();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    Network.a(new FolderListRequest(1, 1, 0), this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
  }
  
  public void a(Context paramContext, OnResultListener paramOnResultListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Network.a(new FolderListRequest(1, 1, 0), paramOnResultListener);
  }
  
  public void a(FolderListManager.LoadFolderListener paramLoadFolderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessFolderFolderListManager$LoadFolderListener = paramLoadFolderListener;
  }
  
  public ArrayList b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager
 * JD-Core Version:    0.7.0.1
 */