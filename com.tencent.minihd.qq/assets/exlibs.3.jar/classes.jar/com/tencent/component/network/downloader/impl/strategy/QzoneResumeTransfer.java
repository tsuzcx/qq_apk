package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.Base64;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class QzoneResumeTransfer
  implements ResumeTransfer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private com.tencent.component.network.downloader.a jdField_a_of_type_ComTencentComponentNetworkDownloaderA;
  private com.tencent.component.network.module.cache.a.b jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public Map a;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com" };
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  
  public QzoneResumeTransfer(Context paramContext, String paramString, com.tencent.component.network.module.cache.a.b paramb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB = paramb;
    this.jdField_b_of_type_Boolean = paramBoolean;
    d();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
      b();
    }
  }
  
  private QzoneResumeTransfer.CacheFileAttribute a(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return null;
    }
    return (QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  private QzoneResumeTransfer.CacheFileAttribute a(HttpResponse paramHttpResponse)
  {
    Object localObject2 = null;
    if (paramHttpResponse == null) {
      return null;
    }
    Object localObject1 = paramHttpResponse.getEntity();
    if (localObject1 != null)
    {
      localObject1 = ((HttpEntity)localObject1).getContentType();
      if (localObject1 == null) {}
    }
    for (localObject1 = ((Header)localObject1).getValue();; localObject1 = null)
    {
      Header localHeader = paramHttpResponse.getFirstHeader("Last-Modified");
      paramHttpResponse = localObject2;
      if (localHeader != null) {
        paramHttpResponse = localHeader.getValue();
      }
      return new QzoneResumeTransfer.CacheFileAttribute((String)localObject1, paramHttpResponse);
    }
  }
  
  private boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    long l;
    do
    {
      return false;
      l = paramFile.lastModified();
      l = System.currentTimeMillis() - l;
    } while ((l < 0L) || (l > 86400000L));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return true;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return false;
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramString2));
    paramString1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (paramString1.hasNext()) {
      if (com.tencent.component.network.downloader.common.a.a((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString2);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(String paramString, HttpResponse paramHttpResponse)
  {
    long l4 = 0L;
    if ((paramHttpResponse == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206)) {
      return true;
    }
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity != null) {}
    for (long l2 = localHttpEntity.getContentLength();; l2 = 0L)
    {
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Range");
      int i;
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        if (!TextUtils.isEmpty(paramHttpResponse)) {
          i = paramHttpResponse.indexOf("/");
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.valueOf(paramHttpResponse.substring(i + 1)).intValue();
          l1 = i;
        }
        catch (Exception paramHttpResponse)
        {
          long l3;
          l1 = 0L;
          continue;
        }
        paramString = c(paramString);
        paramString = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString);
        l3 = l4;
        if (paramString != null)
        {
          l3 = l4;
          if (paramString.exists()) {
            l3 = paramString.length();
          }
        }
        return l2 + l3 == l1;
        long l1 = 0L;
      }
    }
  }
  
  private String b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = (QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  private void b()
  {
    localObject3 = null;
    localObject1 = null;
    Object localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contenttype_" + this.jdField_a_of_type_JavaLangString, null);
    if (localObject4 != null) {}
    try
    {
      localObject4 = com.tencent.component.network.downloader.common.a.a(Base64.a((String)localObject4, 0));
      localObject1 = localObject4;
      localObject3 = localObject4;
      this.jdField_b_of_type_JavaUtilMap.clear();
      localObject1 = localObject4;
      localObject3 = localObject4;
      ((Parcel)localObject4).readMap(this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
      if (localObject4 == null) {
        break label92;
      }
      localObject1 = localObject4;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject3 = localObject1;
        com.tencent.component.network.module.base.b.d("download", "download", localThrowable);
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label140;
      }
      localObject3.recycle();
    }
    localObject1.recycle();
    label92:
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
    }
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA;
    if (localObject == null)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label44;
      }
    }
    for (;;)
    {
      return String.valueOf(paramString.hashCode());
      localObject = ((com.tencent.component.network.downloader.a)localObject).a(paramString);
      break;
      label44:
      paramString = (String)localObject;
    }
  }
  
  private void c()
  {
    localObject3 = null;
    localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localObject3 = localParcel;
      localParcel.writeMap(this.jdField_b_of_type_JavaUtilMap);
      localObject1 = localParcel;
      localObject3 = localParcel;
      String str = new String(Base64.b(localParcel.marshall(), 0));
      localObject1 = localParcel;
      localObject3 = localParcel;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("contenttype_" + this.jdField_a_of_type_JavaLangString, str).commit();
      if (localParcel == null) {
        break label99;
      }
      localObject1 = localParcel;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label99:
        localObject3 = localObject1;
        com.tencent.component.network.module.base.b.c("QzoneResumeTransfer", "saveConfig", localException);
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label129;
      }
      localObject3.recycle();
    }
    localObject1.recycle();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      Pattern localPattern = Pattern.compile(this.jdField_a_of_type_ArrayOfJavaLangString[i], 2);
      this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ArrayOfJavaLangString[i], localPattern);
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(c(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      c();
      return;
    }
  }
  
  public void a(com.tencent.component.network.downloader.a parama)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderA = parama;
  }
  
  public void a(String arg1)
  {
    String str = c(???);
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(str);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(str);
      c();
      return;
    }
  }
  
  public void a(String paramString1, String arg2, HttpResponse paramHttpResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(c(paramString1))) || (!this.jdField_b_of_type_Boolean) || (paramHttpResponse == null));
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder;
    if (com.tencent.component.network.module.base.b.a())
    {
      localStringBuilder = new StringBuilder().append("Downloader Resume Response url:").append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label190;
      }
    }
    label190:
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      com.tencent.component.network.module.base.b.a("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!paramHttpResponse.equals((QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(c(paramString1))))
        {
          this.jdField_b_of_type_JavaUtilMap.put(c(paramString1), paramHttpResponse);
          c();
        }
        return;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB)
      {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(c(paramString));
        if (!this.jdField_b_of_type_Boolean) {}
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilMap.containsKey(c(paramString)))
      {
        this.jdField_b_of_type_JavaUtilMap.remove(c(paramString));
        c();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(HttpGet paramHttpGet, String paramString1, String paramString2)
  {
    if (!a(paramString1, paramString2)) {}
    label177:
    label235:
    for (;;)
    {
      return;
      paramString2 = c(paramString1);
      File localFile = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString2);
      long l;
      if ((localFile != null) && (localFile.exists())) {
        if (a(localFile))
        {
          l = localFile.length();
          paramString2 = b(paramString1);
          if (l > 0L)
          {
            if (this.jdField_b_of_type_Boolean) {
              break label177;
            }
            paramHttpGet.addHeader("Range", "bytes=" + l + "-");
          }
        }
      }
      for (;;)
      {
        if (!com.tencent.component.network.module.base.b.b()) {
          break label235;
        }
        com.tencent.component.network.module.base.b.b("downloader", "Downloader Resume --- begin range:" + l + " Accept:" + paramString2 + " url:" + paramString1);
        return;
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheAB.a(paramString2);
        l = 0L;
        break;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramHttpGet.addHeader("Range", "bytes=" + l + "-");
          paramHttpGet.addHeader("Accept", paramString2);
          paramHttpGet.addHeader("Q-Accept", paramString2);
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return;
    }
    if (!paramBoolean) {}
    String[] arrayOfString;
    for (this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;; this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString)
    {
      d();
      return;
      int i = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      int j = paramArrayOfString.length + i;
      arrayOfString = new String[j];
      i = 0;
      if (i < j)
      {
        if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length) {
          arrayOfString[i] = this.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfString[i] = paramArrayOfString[(i - this.jdField_a_of_type_ArrayOfJavaLangString.length)];
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, HttpResponse paramHttpResponse)
  {
    if ((!this.jdField_b_of_type_Boolean) || (!a(paramString1, paramString2))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || (paramHttpResponse == null)) {
      return false;
    }
    if (!a(paramString1, paramHttpResponse)) {
      return false;
    }
    paramString2 = a(paramString1);
    if (paramString2 == null) {
      return true;
    }
    paramHttpResponse = a(paramHttpResponse);
    StringBuilder localStringBuilder;
    if (com.tencent.component.network.module.base.b.b())
    {
      localStringBuilder = new StringBuilder().append("download content-type check url:").append(paramString1).append(" old:");
      if (paramString2 == null) {
        break label148;
      }
      paramString1 = paramString2.toString();
      localStringBuilder = localStringBuilder.append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label155;
      }
    }
    label148:
    label155:
    for (paramString1 = paramHttpResponse.toString();; paramString1 = "N/A")
    {
      com.tencent.component.network.module.base.b.b("downloader", paramString1);
      if (!paramString2.equals(paramHttpResponse)) {
        break label162;
      }
      return true;
      paramString1 = "N/A";
      break;
    }
    label162:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer
 * JD-Core Version:    0.7.0.1
 */