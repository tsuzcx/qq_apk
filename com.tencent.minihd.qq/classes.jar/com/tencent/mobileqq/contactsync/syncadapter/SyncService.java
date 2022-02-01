package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService
  extends Service
{
  private static SyncAdapter jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.SyncService";
  
  public IBinder onBind(Intent paramIntent)
  {
    return jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter == null) {
        jdField_a_of_type_ComTencentMobileqqContactsyncSyncadapterSyncAdapter = new SyncAdapter(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncService
 * JD-Core Version:    0.7.0.1
 */