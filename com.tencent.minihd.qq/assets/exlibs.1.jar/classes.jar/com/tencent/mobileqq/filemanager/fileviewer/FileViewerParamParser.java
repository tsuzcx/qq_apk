package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileViewerParamParser
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "FileViewerParamParser";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private IFileViewerAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private String b;
  private int e = 0;
  private int f = 0;
  
  public FileViewerParamParser(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList1, FileManagerEntity paramFileManagerEntity, ArrayList paramArrayList2)
  {
    if (paramArrayList1 == null) {}
    while (paramArrayList2 == null) {
      return -1;
    }
    paramArrayList1 = paramArrayList1.iterator();
    int j = -1;
    int i = 0;
    while (paramArrayList1.hasNext())
    {
      long l = Long.parseLong((String)paramArrayList1.next());
      FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(l, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        int k = localFileManagerEntity.cloudType;
        if (FileUtil.b(localFileManagerEntity.strFilePath)) {
          k = 3;
        }
        if (localFileManagerEntity.nSessionId == paramFileManagerEntity.nSessionId) {
          j = i;
        }
        for (;;)
        {
          paramArrayList2.add(FileViewerAdapterBase.a(paramQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
          if (!b(localFileManagerEntity.nFileType, k)) {
            break;
          }
        }
      }
    }
    return j;
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((this.b == null) || (this.b.trim().length() == 0) || (this.b.equals(localFileManagerEntity.peerUin)))
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.cloudType))
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    while (paramInt2 == 0) {
      return false;
    }
    return true;
  }
  
  private boolean a(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool = true;
    paramForwardFileInfo = FMDataCache.a();
    if ((paramForwardFileInfo == null) || (paramForwardFileInfo.size() == 0)) {
      bool = false;
    }
    do
    {
      return bool;
      int k = paramIntent.getIntExtra("clicked_file_hashcode", 0);
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramIntent = paramForwardFileInfo.iterator();
      int i = 0;
      int j = 0;
      if (paramIntent.hasNext())
      {
        paramForwardFileInfo = (FileInfo)paramIntent.next();
        if ((i == 0) && (paramForwardFileInfo.hashCode() == k))
        {
          this.e = j;
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(paramForwardFileInfo));
        }
      }
    } while (this.jdField_a_of_type_Boolean);
    FMDataCache.a();
    return true;
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((this.b == null) || (this.b.trim().length() == 0) || (this.b.equals(localFileManagerEntity.peerUin)))
      {
        int j = localFileManagerEntity.cloudType;
        if (FileUtil.b(localFileManagerEntity.strFilePath)) {
          j = 3;
        }
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (b(localFileManagerEntity.nFileType, j))
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    if (1 != paramInt1) {}
    while ((1 == paramInt2) || (paramInt2 == 0) || (2 == paramInt2) || (-1 == paramInt2) || (4 == paramInt2)) {
      return false;
    }
    return true;
  }
  
  private boolean b(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("local_weiyun_list");
    if ((paramIntent == null) || (paramIntent.size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramIntent.next();
      if ((localWeiYunFileInfo.a != null) && (localWeiYunFileInfo.a.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId))) {
        this.e = i;
      }
      while (FileManagerUtil.a(localWeiYunFileInfo.b) == 0)
      {
        i += 1;
        this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localWeiYunFileInfo));
        break;
      }
    }
    return true;
  }
  
  private boolean b(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    paramForwardFileInfo = FMDataCache.a();
    if ((paramForwardFileInfo == null) || (paramForwardFileInfo.size() == 0)) {
      return false;
    }
    int j = paramIntent.getIntExtra("clicked_file_hashcode", 0);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramForwardFileInfo.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      paramForwardFileInfo = (FileInfo)paramIntent.next();
      if (paramForwardFileInfo.hashCode() == j) {
        this.e = i;
      }
      while (FileManagerUtil.a(paramForwardFileInfo.e()) == 1)
      {
        i += 1;
        this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(paramForwardFileInfo));
        break;
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      FMDataCache.a();
    }
    return true;
  }
  
  private boolean c()
  {
    Object localObject3 = FMDataCache.c();
    Object localObject2 = FMDataCache.b();
    Object localObject1 = FMDataCache.e();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).b() == 0) {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a((FileInfo)localObject3));
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (FileManagerUtil.a(((WeiYunFileInfo)localObject2).b) == 0) {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (WeiYunFileInfo)localObject2));
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  private boolean c(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_Uinseq_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.cloudType))
        {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean c(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool;
    switch (paramForwardFileInfo.b())
    {
    case 10005: 
    case 10007: 
    case 10008: 
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("FileViewerParamParser", 4, "parseAudioGallery: type[" + paramForwardFileInfo.b() + "] is not implemented");
      }
      bool = false;
      label101:
      this.f = 2;
      if (!bool) {
        QLog.e("FileViewerParamParser", 1, "parseAudioGallery type[" + paramForwardFileInfo.b() + "] return false");
      }
      break;
    }
    while (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      return bool;
      bool = b(paramIntent, paramForwardFileInfo);
      break label101;
      bool = b();
      break label101;
      bool = d(paramIntent);
      break label101;
      bool = e(paramIntent);
      break label101;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("FileViewerParamParser", 4, "parseAudioGallery: not support OfflineFile type");
      bool = false;
      break label101;
      bool = g(paramIntent);
      break label101;
    }
    QLog.e("FileViewerParamParser", 1, "parseAudioGallery type[" + paramForwardFileInfo.b() + "] list is empty");
    return false;
  }
  
  private boolean d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_Uinseq_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        int j = localFileManagerEntity.cloudType;
        if (FileUtil.b(localFileManagerEntity.strFilePath)) {
          j = 3;
        }
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (b(localFileManagerEntity.nFileType, j))
        {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean d(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool;
    switch (paramForwardFileInfo.b())
    {
    case 10005: 
    case 10008: 
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("FileViewerParamParser", 4, "parseImageGallery: type[" + paramForwardFileInfo.b() + "] is not implemented");
      }
      bool = false;
      label102:
      this.f = 1;
      if (!bool) {
        QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.b() + "] return false");
      }
      break;
    }
    while (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      return bool;
      bool = a(paramIntent, paramForwardFileInfo);
      break label102;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("FileViewerParamParser", 4, "parseImageGallery: not support OfflineFile type");
      bool = false;
      break label102;
      bool = b(paramIntent);
      break label102;
      bool = a();
      break label102;
      bool = c(paramIntent);
      break label102;
      bool = f(paramIntent);
      break label102;
      bool = c();
      break label102;
    }
    QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.b() + "] list is empty");
    return false;
  }
  
  private boolean e(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_SessionId_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0L, "", 0, l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (b(localFileManagerEntity.nFileType, localFileManagerEntity.cloudType))
        {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean f(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_SessionId_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0L, "", 0, l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.e = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.cloudType))
        {
          this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean g(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    this.e = 0;
    this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    return true;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public IFileViewerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(Intent paramIntent)
  {
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    long l = localForwardFileInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("FileViewerParamParser", 1, "FileViewerParamParsernot found, bug. sessionid:" + String.valueOf(l));
      return false;
    }
    FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    boolean bool1 = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType);
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType;
    if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath)) {
      i = 3;
    }
    boolean bool2 = b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType, i);
    if (bool1) {
      return d(paramIntent, localForwardFileInfo);
    }
    if (bool2) {
      return c(paramIntent, localForwardFileInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = FileViewerAdapterBase.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.f = 3;
    return true;
  }
  
  public int b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser
 * JD-Core Version:    0.7.0.1
 */