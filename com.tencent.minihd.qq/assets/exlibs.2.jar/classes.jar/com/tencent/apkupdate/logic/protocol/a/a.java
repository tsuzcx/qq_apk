package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.c.f;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.apkupdate.logic.protocol.jce.ApkDownUrl;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateRequest;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.apkupdate.logic.protocol.a
{
  private static String a = "CheckAppUpdateHttpRequest";
  private final List b;
  
  public a(List paramList)
  {
    this.b = paramList;
  }
  
  private static ApkUpdateDetail a(AppUpdateInfo paramAppUpdateInfo)
  {
    Object localObject3 = null;
    if (paramAppUpdateInfo != null)
    {
      ApkUpdateDetail localApkUpdateDetail = new ApkUpdateDetail();
      localApkUpdateDetail.packageName = paramAppUpdateInfo.packageName;
      localApkUpdateDetail.versionname = paramAppUpdateInfo.versionName;
      localApkUpdateDetail.versioncode = paramAppUpdateInfo.versionCode;
      Object localObject4 = paramAppUpdateInfo.apkDownUrl;
      Object localObject1;
      Object localObject2;
      int i;
      if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
      {
        localObject1 = ((ArrayList)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ApkDownUrl)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((ApkDownUrl)localObject2).type == 2)) {
              if (((ApkDownUrl)localObject2).urlList != null)
              {
                localObject1 = (String)((ApkDownUrl)localObject2).urlList.get(0);
                i = 1;
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject3;
        if (i == 0)
        {
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            if (((ArrayList)localObject4).size() > 0)
            {
              localObject4 = ((ArrayList)localObject4).iterator();
              do
              {
                localObject1 = localObject3;
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject1 = (ApkDownUrl)((Iterator)localObject4).next();
              } while ((localObject1 == null) || (((ApkDownUrl)localObject1).type != 1));
              if (((ApkDownUrl)localObject1).urlList == null) {
                break label282;
              }
              localObject1 = (String)((ApkDownUrl)localObject1).urlList.get(0);
            }
          }
        }
        label210:
        if (i != 0) {
          localApkUpdateDetail.updatemethod = 4;
        }
        for (localApkUpdateDetail.url = ((String)localObject2);; localApkUpdateDetail.url = ((String)localObject1))
        {
          localApkUpdateDetail.newapksize = ((int)paramAppUpdateInfo.fileSize);
          localApkUpdateDetail.patchsize = ((int)paramAppUpdateInfo.diffFileSize);
          localApkUpdateDetail.fileMd5 = paramAppUpdateInfo.diffApkMd5;
          localApkUpdateDetail.sigMd5 = paramAppUpdateInfo.signatureMd5;
          localApkUpdateDetail.newFeature = paramAppUpdateInfo.newFeature;
          return localApkUpdateDetail;
          localObject1 = "";
          break;
          label282:
          localObject1 = "";
          break label210;
          localApkUpdateDetail.updatemethod = 2;
        }
        localObject2 = null;
        i = 0;
      }
    }
    return null;
  }
  
  protected final void a()
  {
    super.a();
    if (this.b != null)
    {
      GetAppUpdateRequest localGetAppUpdateRequest = new GetAppUpdateRequest();
      localGetAppUpdateRequest.appInfoForUpdateList = ((ArrayList)this.b);
      localGetAppUpdateRequest.flag = 0;
      StringBuffer localStringBuffer = new StringBuffer("CheckAppUpdateHttpRequest:prepareData to server; appInfoForUpdateList= [");
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        AppInfoForUpdate localAppInfoForUpdate = (AppInfoForUpdate)localIterator.next();
        localStringBuffer.append("pkgname=" + localAppInfoForUpdate.packageName + ";versionCode=" + localAppInfoForUpdate.versionCode + ";targetVersionCode=" + localAppInfoForUpdate.targetVersionCode + ";targetGrayVersionCode=" + localAppInfoForUpdate.targetGrayVersionCode + "| \n\r");
      }
      f.a(a, localStringBuffer.toString() + "]");
      a(localGetAppUpdateRequest);
    }
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label179:
    Object localObject4;
    int j;
    label218:
    Object localObject5;
    boolean bool;
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof GetAppUpdateResponse)))
    {
      localObject2 = (GetAppUpdateResponse)paramJceStruct2;
      paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; response=  [");
      paramJceStruct1.append("ret=" + ((GetAppUpdateResponse)localObject2).ret + "| ");
      if (((GetAppUpdateResponse)localObject2).ret != 0) {
        break label1033;
      }
      localObject1 = new ArrayList();
      paramJceStruct2 = new ArrayList();
      localObject2 = ((GetAppUpdateResponse)localObject2).appUpdateInfoGroup;
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        localObject2 = ((Map)localObject2).values();
        if ((localObject2 != null) && (((Collection)localObject2).size() > 0))
        {
          localObject2 = ((Collection)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ArrayList)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
            {
              localObject3 = ((ArrayList)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (AppUpdateInfo)((Iterator)localObject3).next();
                j = ((AppUpdateInfo)localObject4).flag;
                if ((j & 0x1) != 1) {
                  break label524;
                }
                i = 1;
                if (i != 0) {
                  paramJceStruct2.add(localObject4);
                }
                localObject5 = new StringBuilder("pkgname=").append(((AppUpdateInfo)localObject4).packageName).append(";versionCode=").append(((AppUpdateInfo)localObject4).versionCode).append(";uploadFlag=");
                if ((j & 0x1) != 1) {
                  break label529;
                }
                bool = true;
                label277:
                paramJceStruct1.append(bool + "| \n\r");
                localObject4 = a((AppUpdateInfo)localObject4);
                if (localObject4 != null)
                {
                  localObject5 = com.tencent.apkupdate.logic.protocol.b.a().b(((ApkUpdateDetail)localObject4).packageName);
                  if ((com.tencent.apkupdate.c.b.a().b() == null) || (com.tencent.apkupdate.c.b.a(com.tencent.apkupdate.c.b.a().b(), ((ApkUpdateDetail)localObject4).packageName) != ((ApkUpdateDetail)localObject4).versioncode)) {
                    break label1057;
                  }
                }
              }
            }
          }
        }
      }
    }
    label524:
    label529:
    label1057:
    for (int i = 1;; i = 0)
    {
      if ((((String)localObject5).compareToIgnoreCase(((ApkUpdateDetail)localObject4).sigMd5) != 0) || (i != 0)) {
        ((ApkUpdateDetail)localObject4).updatemethod = 1;
      }
      f.a(a, "packageName: " + ((ApkUpdateDetail)localObject4).packageName);
      f.a(a, "updatemethod: " + ((ApkUpdateDetail)localObject4).updatemethod);
      f.a(a, "newapksize: " + ((ApkUpdateDetail)localObject4).newapksize);
      f.a(a, "patchsize: " + ((ApkUpdateDetail)localObject4).patchsize);
      f.a(a, "url: " + ((ApkUpdateDetail)localObject4).url);
      ((ArrayList)localObject1).add(localObject4);
      break label179;
      break;
      i = 0;
      break label218;
      bool = false;
      break label277;
      f.a(a, paramJceStruct1.toString() + "]");
      localObject2 = new ArrayList();
      if (this.b != null)
      {
        localObject3 = this.b.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramJceStruct1 = (AppInfoForUpdate)((Iterator)localObject3).next();
          localObject4 = paramJceStruct1.packageName;
          j = paramJceStruct1.versionCode;
          localObject5 = paramJceStruct1.versionName;
          Iterator localIterator = ((ArrayList)localObject1).iterator();
          String str;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            paramJceStruct1 = (ApkUpdateDetail)localIterator.next();
            str = paramJceStruct1.packageName;
          } while ((localObject4 == null) || (str == null) || (!((String)localObject4).equals(str)));
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          ((ArrayList)localObject2).add(paramJceStruct1);
          break;
        }
        paramJceStruct1 = new ApkUpdateDetail();
        paramJceStruct1.packageName = ((String)localObject4);
        paramJceStruct1.versionname = ((String)localObject5);
        paramJceStruct1.versioncode = j;
        paramJceStruct1.updatemethod = 1;
        ((ArrayList)localObject2).add(paramJceStruct1);
        break;
        paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; returnSuceessList response= [");
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ApkUpdateDetail)((Iterator)localObject1).next();
          paramJceStruct1.append("pkgname=" + ((ApkUpdateDetail)localObject3).packageName + ";versionCode=" + ((ApkUpdateDetail)localObject3).versioncode + "| \n\r");
        }
        f.a(a, paramJceStruct1.toString() + "]");
        paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
        paramJceStruct1.what = 1;
        paramJceStruct1.obj = localObject2;
        paramJceStruct1.sendToTarget();
        paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:NeedUpdateApk from server; needUpdateApkInfos response= [");
        localObject1 = paramJceStruct2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AppUpdateInfo)((Iterator)localObject1).next();
          paramJceStruct1.append("pkgname=" + ((AppUpdateInfo)localObject2).packageName + ";versionCode=" + ((AppUpdateInfo)localObject2).versionCode + ";grayVersionCode=" + ((AppUpdateInfo)localObject2).grayVersionCode + "| \n\r");
        }
        f.a(a, paramJceStruct1.toString() + "]");
        if (paramJceStruct2.size() > 0)
        {
          paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
          paramJceStruct1.what = 7;
          paramJceStruct1.obj = paramJceStruct2;
          paramJceStruct1.sendToTarget();
        }
        return;
        paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
        paramJceStruct1.what = 2;
        paramJceStruct1.sendToTarget();
        return;
        paramJceStruct1 = null;
      }
    }
  }
  
  protected final void b()
  {
    Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.a
 * JD-Core Version:    0.7.0.1
 */