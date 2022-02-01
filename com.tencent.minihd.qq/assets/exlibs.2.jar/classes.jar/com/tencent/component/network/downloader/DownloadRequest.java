package com.tencent.component.network.downloader;

import com.tencent.component.network.downloader.common.a;
import com.tencent.component.network.utils.AssertUtil;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DownloadRequest
{
  public long a;
  private final Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener;
  public Downloader.DownloadMode a;
  public OutputStream a;
  private final String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private boolean b = false;
  
  public DownloadRequest(String paramString, String[] paramArrayOfString, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = Downloader.DownloadMode.FastMode;
    boolean bool1 = bool2;
    if (a.a(paramString))
    {
      bool1 = bool2;
      if (paramArrayOfString != null) {
        bool1 = true;
      }
    }
    AssertUtil.a(bool1);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    this.b = paramBoolean;
  }
  
  private static int a(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public Downloader.DownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    return null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof DownloadRequest))) {
        return false;
      }
      paramObject = (DownloadRequest)paramObject;
    } while ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramObject.jdField_a_of_type_JavaLangString)) && (a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener, paramObject.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_JavaLangString.hashCode() + 527) * 31 + a(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadRequest
 * JD-Core Version:    0.7.0.1
 */