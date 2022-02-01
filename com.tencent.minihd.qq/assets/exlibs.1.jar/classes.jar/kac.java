import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class kac
{
  private static final int jdField_a_of_type_Int = 5;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private int[][] jdField_a_of_type_Array2dOfInt;
  
  public kac(FMTSrvAddrProvider paramFMTSrvAddrProvider) {}
  
  private int a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = 5;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        int k;
        if (paramArrayOfInt[i] < j)
        {
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0) {
        return ((Integer)localArrayList.get(Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt()) % localArrayList.size())).intValue();
      }
    }
    return -1;
  }
  
  public FileStorageServerListInfo a(int paramInt)
  {
    Object localObject2 = null;
    ArrayList localArrayList = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        paramInt = a(a(paramInt));
        localObject1 = localObject2;
        if (paramInt > -1)
        {
          localObject1 = localObject2;
          if (paramInt < localArrayList.size()) {
            localObject1 = (FileStorageServerListInfo)localArrayList.get(paramInt);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
    }
    return localObject1;
  }
  
  public ArrayList a(int paramInt)
  {
    int i3 = 2147483647;
    int i2 = 0;
    ArrayList localArrayList1 = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
    int i;
    int k;
    ArrayList localArrayList2;
    int[] arrayOfInt;
    int j;
    int m;
    int n;
    int i1;
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      i = localArrayList1.size();
      k = i;
      if (i >= 3) {
        k = 3;
      }
      localArrayList2 = new ArrayList(k);
      arrayOfInt = a(paramInt);
      if ((arrayOfInt != null) && (arrayOfInt.length == localArrayList1.size()))
      {
        paramInt = 0;
        i = 2147483647;
        j = 0;
        while (paramInt < arrayOfInt.length)
        {
          m = i;
          if (arrayOfInt[paramInt] < i)
          {
            m = arrayOfInt[paramInt];
            j = paramInt;
          }
          paramInt += 1;
          i = m;
        }
        localArrayList2.add(0, localArrayList1.get(j));
        if (k < 2) {
          break label342;
        }
        paramInt = 0;
        n = 2147483647;
        for (i = 0; paramInt < arrayOfInt.length; i = m)
        {
          i1 = n;
          m = i;
          if (paramInt != j)
          {
            i1 = n;
            m = i;
            if (arrayOfInt[paramInt] < n)
            {
              i1 = arrayOfInt[paramInt];
              m = paramInt;
            }
          }
          paramInt += 1;
          n = i1;
        }
        localArrayList2.add(1, localArrayList1.get(i));
      }
    }
    for (;;)
    {
      if (k >= 3)
      {
        n = 0;
        k = i3;
        paramInt = i2;
        while (paramInt < arrayOfInt.length)
        {
          i1 = n;
          m = k;
          if (paramInt != j)
          {
            i1 = n;
            m = k;
            if (paramInt != i)
            {
              i1 = n;
              m = k;
              if (arrayOfInt[paramInt] < k)
              {
                m = arrayOfInt[paramInt];
                i1 = paramInt;
              }
            }
          }
          paramInt += 1;
          n = i1;
          k = m;
        }
        localArrayList2.add(2, localArrayList1.get(n));
      }
      return localArrayList2;
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "getAddr error,ret=null");
      }
      return null;
      label342:
      i = 0;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      ArrayList localArrayList = FMTSrvAddrProvider.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, paramInt);
      int[] arrayOfInt = a(paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        paramString = new URL(paramString).getHost();
        if ((paramString != null) && (paramString.length() > 0)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt < localArrayList.size())
        {
          String str = ((FileStorageServerListInfo)localArrayList.get(paramInt)).sIP;
          if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
            break label116;
          }
          if (arrayOfInt.length > paramInt) {
            arrayOfInt[paramInt] += 1;
          }
        }
        return;
        label116:
        paramInt += 1;
      }
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    if (paramFileStoragePushFSSvcList != null)
    {
      this.jdField_a_of_type_Array2dOfInt = new int[16][];
      if ((paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[4] = new int[paramFileStoragePushFSSvcList.vUrlEncodeServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vGPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vGPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[2] = new int[paramFileStoragePushFSSvcList.vGPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vPicDownLoadList != null) && (paramFileStoragePushFSSvcList.vPicDownLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[1] = new int[paramFileStoragePushFSSvcList.vPicDownLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vQzoneProxyServiceList != null) && (paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[3] = new int[paramFileStoragePushFSSvcList.vQzoneProxyServiceList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vUpLoadList != null) && (paramFileStoragePushFSSvcList.vUpLoadList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[0] = new int[paramFileStoragePushFSSvcList.vUpLoadList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vVipEmotionList != null) && (paramFileStoragePushFSSvcList.vVipEmotionList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[5] = new int[paramFileStoragePushFSSvcList.vVipEmotionList.size()];
      }
      if ((paramFileStoragePushFSSvcList.vC2CPicDownList != null) && (paramFileStoragePushFSSvcList.vC2CPicDownList.size() > 0)) {
        this.jdField_a_of_type_Array2dOfInt[11] = new int[paramFileStoragePushFSSvcList.vC2CPicDownList.size()];
      }
      int i = 6;
      int j;
      if (i <= 10)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, FMTSrvAddrProvider.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
      i = 12;
      if (i <= 15)
      {
        paramFileStoragePushFSSvcList = FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, FMTSrvAddrProvider.b(this.jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider, i));
        if (paramFileStoragePushFSSvcList != null) {}
        for (j = paramFileStoragePushFSSvcList.size();; j = 0)
        {
          this.jdField_a_of_type_Array2dOfInt[i] = new int[j];
          i += 1;
          break;
        }
      }
    }
  }
  
  int[] a(int paramInt)
  {
    if (this.jdField_a_of_type_Array2dOfInt == null) {
      return null;
    }
    return this.jdField_a_of_type_Array2dOfInt[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kac
 * JD-Core Version:    0.7.0.1
 */