package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.qphone.base.util.QLog;
import iqn;
import iqo;
import iqp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileRecentMediaFileTabView
  extends QfileBaseRecentFileTabView
{
  private IClickListener_Ver51 a;
  
  public QfileRecentMediaFileTabView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = null;
    d();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentMediaFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = null;
    d();
    setEditbarButton(false, true, true, true, true);
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = FileUtil.a(paramString).toLowerCase();
      } while ((paramString == null) || (paramString.length() == 0));
      if (".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4a|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|".indexOf(paramString) >= 0) {
        return "视频";
      }
    } while (".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|".indexOf(paramString) < 0);
    return "音乐";
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().L();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a().Q();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = new iqn(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51);
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileRecentFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.jdField_a_of_type_AndroidViewView$OnClickListener, this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
  }
  
  protected void a()
  {
    a(new iqo(this));
  }
  
  protected void b(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity)) {
      if ((this.b == null) || (this.b.trim().length() == 0) || (this.b.equals(paramFileManagerEntity.peerUin))) {}
    }
    String str;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      str = a(paramFileManagerEntity.fileName);
    } while (str == null);
    a(new iqp(this, str, paramFileManagerEntity));
  }
  
  protected boolean b(FileManagerEntity paramFileManagerEntity)
  {
    super.b(paramFileManagerEntity);
    Object localObject = a(paramFileManagerEntity.fileName);
    if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      localObject = ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      i();
      return true;
    }
  }
  
  public void f(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(false, true, true, true, true);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView
 * JD-Core Version:    0.7.0.1
 */