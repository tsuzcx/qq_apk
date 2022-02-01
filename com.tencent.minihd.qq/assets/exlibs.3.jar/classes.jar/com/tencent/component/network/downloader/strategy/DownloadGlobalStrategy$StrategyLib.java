package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.a.a;
import java.util.ArrayList;
import java.util.List;

public class DownloadGlobalStrategy$StrategyLib
{
  private int jdField_a_of_type_Int;
  private DownloadGlobalStrategy.StrategyInfo jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private DownloadGlobalStrategy.StrategyInfo jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public DownloadGlobalStrategy$StrategyLib(DownloadGlobalStrategy paramDownloadGlobalStrategy)
  {
    b();
    this.jdField_a_of_type_Int = 80;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return;
    }
    if (!NetworkManager.a())
    {
      this.jdField_a_of_type_JavaUtilArrayList = DownloadGlobalStrategy.a();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = DownloadGlobalStrategy.b();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool1 = a.a().a();
    boolean bool2 = a.a().b();
    if (!bool1)
    {
      this.jdField_a_of_type_JavaUtilArrayList = DownloadGlobalStrategy.a();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_JavaUtilArrayList = DownloadGlobalStrategy.b();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = DownloadGlobalStrategy.c();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public DownloadGlobalStrategy.StrategyInfo a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
  }
  
  public DownloadGlobalStrategy.StrategyInfo a(int paramInt)
  {
    int m = -1;
    int k = paramInt;
    if (paramInt < 0) {
      k = 0;
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo == null) {}
    for (DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k % this.jdField_a_of_type_JavaUtilArrayList.size());; localStrategyInfo1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo)
    {
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = localStrategyInfo1;
      if (localStrategyInfo1 == null)
      {
        if (!NetworkManager.a()) {
          break label383;
        }
        localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.b().get(0);
      }
      return localStrategyInfo2;
      if (k > 0) {
        break;
      }
    }
    if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int != DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int != DownloadGlobalStrategy.d.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int != DownloadGlobalStrategy.e.jdField_a_of_type_Int))
    {
      if (k == 1) {
        c();
      }
      paramInt = 0;
      label146:
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label400;
      }
      if (((DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {}
    }
    for (;;)
    {
      if ((k > 0) && (k <= paramInt))
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k - 1);
        break;
        paramInt += 1;
        break label146;
      }
      localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k % this.jdField_a_of_type_JavaUtilArrayList.size());
      break;
      if (k == 1)
      {
        c();
        return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
      }
      paramInt = 0;
      int j;
      for (int i = -1; paramInt < this.jdField_a_of_type_JavaUtilArrayList.size(); i = j)
      {
        j = i;
        if (((DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          j = i;
          if (i < 0) {
            j = paramInt;
          }
          m = paramInt;
        }
        paramInt += 1;
      }
      if ((k > 1) && (k <= m))
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k - 2);
        break;
      }
      if (k > m)
      {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k % this.jdField_a_of_type_JavaUtilArrayList.size());
        break;
        label383:
        return (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.a().get(0);
      }
      localStrategyInfo1 = null;
      break;
      label400:
      paramInt = -1;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo)
  {
    this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = paramStrategyInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramList == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DownloadGlobalStrategy.StrategyInfo b()
  {
    return this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null) {
      return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib
 * JD-Core Version:    0.7.0.1
 */