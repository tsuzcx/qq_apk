package com.tencent.mobileqq.troopinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ZipUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GroupCatalogTool
{
  protected static final long a = 86400000L;
  private static GroupCatalogTool jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "group_catalog.xml";
  public static final String b = "group_catalog";
  public static final String c = "group_catalog_temp";
  public static final String d = "layer.zip";
  protected static final String e = "https://pub.idqqimg.com/qqweb/m/qun/configs/category/layer.zip";
  protected static final String f = "LAST_GET_CLASS_CHOICE_URL_TIME";
  protected static final String g = "https://pub.idqqimg.com/pc/misc/files/20141124/a14566eeb23140778a2eb64c992cfdfe.zip";
  protected static final String h = "GroupCatalogTool";
  private GroupCatalogBean jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
  private File jdField_a_of_type_JavaIoFile = new File(a(paramContext) + "group_catalog.xml");
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private GroupCatalogTool(Context paramContext) {}
  
  private GroupCatalogBean a(GroupCatalogBean paramGroupCatalogBean, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    if (paramGroupCatalogBean.b.equals(paramString)) {}
    do
    {
      for (Object localObject1 = paramGroupCatalogBean; !localIterator.hasNext(); localObject1 = localObject2)
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localIterator;
          } while (paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList == null);
          localObject1 = localIterator;
        } while (paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.isEmpty());
        localIterator = paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      paramGroupCatalogBean = a((GroupCatalogBean)localIterator.next(), paramString);
      localObject1 = paramGroupCatalogBean;
    } while (paramGroupCatalogBean == null);
    return paramGroupCatalogBean;
  }
  
  private GroupCatalogBean a(String paramString)
  {
    Object localObject1 = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        GroupCatalogBean localGroupCatalogBean = a((GroupCatalogBean)localIterator.next(), paramString);
        localObject1 = localGroupCatalogBean;
        if (localGroupCatalogBean != null) {
          localObject1 = localGroupCatalogBean;
        }
      }
      return localObject1;
    }
  }
  
  public static GroupCatalogTool a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool == null) {
        jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool = new GroupCatalogTool(paramContext);
      }
      return jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool;
    }
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog" + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  private ArrayList a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = null;
    GroupCatalogBean localGroupCatalogBean = null;
    Iterator localIterator;
    if (paramArrayList != null)
    {
      localIterator = paramArrayList.iterator();
      paramArrayList = localGroupCatalogBean;
    }
    for (;;)
    {
      localArrayList = paramArrayList;
      if (localIterator.hasNext())
      {
        localGroupCatalogBean = (GroupCatalogBean)localIterator.next();
        if ((localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList == null) || (localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label100;
        }
        if (!localGroupCatalogBean.b.equals(paramString)) {
          break label81;
        }
        localArrayList = localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList;
      }
      label81:
      label100:
      do
      {
        return localArrayList;
        localArrayList = a(localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList, paramString);
        paramArrayList = localArrayList;
        if (localArrayList == null) {
          break;
        }
        return localArrayList;
        localArrayList = paramArrayList;
      } while (localGroupCatalogBean.jdField_a_of_type_Int == 4);
    }
  }
  
  private String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog_temp" + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  private GroupCatalogBean c(Context paramContext, String paramString)
  {
    if (!a()) {
      a(paramContext, a(paramContext));
    }
    paramContext = new GroupCatalogXmlHandler(paramString);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream(this.jdField_a_of_type_JavaIoFile), "gb2312")), paramContext);
      this.jdField_a_of_type_JavaUtilArrayList = paramContext.a();
      paramContext = paramContext.a();
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (SAXException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (ParserConfigurationException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  protected long a(Context paramContext)
  {
    return paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).getLong("GroupCatalogTool", 0L);
  }
  
  public GroupCatalogBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
  }
  
  public GroupCatalogBean a(Context paramContext, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramContext = a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramContext;
      return paramContext;
    }
    paramContext = c(paramContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramContext;
    return paramContext;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
      return paramString;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = null;
      return;
    }
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).edit();
    paramContext.putLong("GroupCatalogTool", paramLong);
    paramContext.commit();
  }
  
  public void a(Context paramContext, String paramString)
  {
    ZipUtil.a(paramContext, "layer.zip", paramString);
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramGroupCatalogBean;
  }
  
  public void a(HttpCgiAsyncTask.Callback paramCallback, Context paramContext)
  {
    long l = a(paramContext);
    boolean bool = this.jdField_a_of_type_JavaIoFile.exists();
    if ((System.currentTimeMillis() - l > 86400000L) || (!bool))
    {
      paramContext = new Bundle();
      paramContext.putString("needhttpcache", "need");
      paramContext.putString("LastModifyUseString", "need");
      paramContext.putString("downloadfile", "need");
      new HttpCgiAsyncTask("https://pub.idqqimg.com/qqweb/m/qun/configs/category/layer.zip", "GET", paramCallback).a(paramContext);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaIoFile.length() > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Context paramContext)
  {
    return FileUtils.a(b(paramContext) + "group_catalog.xml", a(paramContext) + "group_catalog.xml");
  }
  
  public boolean a(Context paramContext, InputStream paramInputStream)
  {
    return FileUtils.a(b(paramContext), new StringBuffer("layer.zip"), paramInputStream);
  }
  
  public GroupCatalogBean b(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      ZipUtils.a(new File(b(paramContext) + "layer.zip"), b(paramContext));
      paramString = new GroupCatalogXmlHandler(paramString);
      return null;
    }
    catch (ZipException paramString)
    {
      do
      {
        try
        {
          SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream(new File(b(paramContext) + "group_catalog.xml")), "gb2312")), paramString);
          this.jdField_a_of_type_JavaUtilArrayList = paramString.a();
          paramContext = paramString.a();
          return paramContext;
        }
        catch (FileNotFoundException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        catch (SAXException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        catch (ParserConfigurationException paramContext)
        {
          paramContext.printStackTrace();
        }
        paramString = paramString;
        paramContext = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("GroupCatalogTool", 2, paramString.getMessage());
      return null;
    }
    catch (IOException paramString)
    {
      do
      {
        paramContext = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("GroupCatalogTool", 2, paramString.getMessage());
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopinfo.GroupCatalogTool
 * JD-Core Version:    0.7.0.1
 */