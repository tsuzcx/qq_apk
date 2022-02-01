package cooperation.plugin;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.PluginInfoParser;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class PluginUpdater
  extends ServerConfigObserver
{
  public static final String a = "PluginUpdater";
  private static final String b = "plugin_info";
  private Context jdField_a_of_type_AndroidContentContext;
  private PluginUpdater.OnPluginInfoUpdateListener jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public PluginUpdater(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = a(paramContext);
    boolean bool = PluginInfoUtil.a(paramContext);
    File[] arrayOfFile = PluginInfoUtil.a(paramContext);
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isFile())
        {
          PluginInfo localPluginInfo = PluginInfoUtil.a(localFile);
          if (localPluginInfo == null) {
            break label103;
          }
          this.jdField_a_of_type_JavaUtilMap.put(localPluginInfo.mID, localPluginInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          label103:
          localFile.delete();
        }
      }
    }
    if (bool) {
      PluginInfoUtil.a(paramContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init plugin updater :" + this.jdField_a_of_type_JavaUtilMap.size());
    }
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("plugin_info", 0);
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramGetResourceRespV2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onGetPluginConfig GetResourceRespV2: " + paramGetResourceRespV2 + "[add: " + paramGetResourceRespV2.vecAddedResInfo.size() + ", remove: " + paramGetResourceRespV2.vecDeletedResInfo.size() + ", update: " + paramGetResourceRespV2.vecUpdatedResInfo.size() + "]");
      }
      localObject3 = new PluginBaseInfoHelper.PluginInfoParser();
      ((PluginBaseInfoHelper.PluginInfoParser)localObject3).setResultClass(PluginInfo.class);
      localObject1 = new ArrayList();
      localObject2 = new HashMap();
      localHashMap = new HashMap();
      localObject4 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((GetResourceRespInfoV2)((Iterator)localObject4).next()).strPkgName);
      }
      localObject4 = paramGetResourceRespV2.vecAddedResInfo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((GetResourceRespInfoV2)localObject5).strResConf, (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if ((localObject6 != null) && (!BuiltinPluginManager.b(((PluginInfo)localObject6).mID)))
        {
          ((PluginInfo)localObject6).mType = ((GetResourceRespInfoV2)localObject5).sResSubType;
          ((PluginInfo)localObject6).mPackageName = ((GetResourceRespInfoV2)localObject5).strPkgName;
          ((PluginInfo)localObject6).mCurVersion = ((GetResourceRespInfoV2)localObject5).uiNewVer;
          ((PluginInfo)localObject6).mState = 0;
          ((HashMap)localObject2).put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
      localObject4 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((GetResourceRespInfoV2)localObject5).strResConf, (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if ((localObject6 != null) && (!BuiltinPluginManager.b(((PluginInfo)localObject6).mID)))
        {
          ((PluginInfo)localObject6).mType = ((GetResourceRespInfoV2)localObject5).sResSubType;
          ((PluginInfo)localObject6).mPackageName = ((GetResourceRespInfoV2)localObject5).strPkgName;
          ((PluginInfo)localObject6).mCurVersion = ((GetResourceRespInfoV2)localObject5).uiNewVer;
          ((PluginInfo)localObject6).mState = 0;
          localHashMap.put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
    }
    label1154:
    label1157:
    label1162:
    label1164:
    label1167:
    for (;;)
    {
      try
      {
        localObject3 = this.jdField_a_of_type_JavaUtilMap;
        localObject4 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localObject6 = ((Map)localObject3).values().iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1149;
          }
          localObject1 = (PluginInfo)((Iterator)localObject6).next();
          if ((!((PluginInfo)localObject1).mPackageName.equals(localObject5)) || (BuiltinPluginManager.b(((PluginInfo)localObject1).mID))) {
            continue;
          }
          if (localObject1 == null) {
            break label1146;
          }
          if (((HashMap)localObject2).containsKey(((PluginInfo)localObject1).mID))
          {
            localObject5 = (PluginInfo)((HashMap)localObject2).get(((PluginInfo)localObject1).mID);
            ((HashMap)localObject2).remove(((PluginInfo)localObject1).mID);
            localHashMap.put(((PluginInfo)localObject1).mID, localObject5);
            break label1154;
          }
          if ((this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener == null) || (!this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a((PluginInfo)localObject1))) {
            break label1146;
          }
          ((Map)localObject3).remove(((PluginInfo)localObject1).mID);
          if (!QLog.isColorLevel()) {
            break label1157;
          }
          QLog.d("plugin_tag", 2, "remove PluginInfo: " + localObject1);
          break label1157;
        }
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (PluginInfo)((HashMap)localObject2).get((String)((Iterator)localObject1).next());
          localObject5 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject4).mID);
          if ((localObject5 != null) && (((PluginInfo)localObject5).mMD5 != null) && (((PluginInfo)localObject5).mMD5.equals(((PluginInfo)localObject4).mMD5)) && ((((PluginInfo)localObject5).mURL == null) || (((PluginInfo)localObject4).mForceUrl <= 0) || (((PluginInfo)localObject5).mURL.equals(((PluginInfo)localObject4).mURL)))) {
            break label1143;
          }
          ((Map)localObject3).put(((PluginInfo)localObject4).mID, localObject4);
          if (!QLog.isColorLevel()) {
            break label1162;
          }
          QLog.d("plugin_tag", 2, "add PluginInfo: " + localObject4);
          break label1162;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PluginInfo)localHashMap.get((String)((Iterator)localObject1).next());
          localObject4 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject2).mID);
          if ((localObject4 == null) || (((PluginInfo)localObject4).mMD5 == null) || (!((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) || ((((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl > 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL))))
          {
            ((Map)localObject3).put(((PluginInfo)localObject2).mID, localObject2);
            if (!QLog.isColorLevel()) {
              break label1138;
            }
            QLog.d("plugin_tag", 2, "update PluginInfo: " + localObject2);
            i = 1;
            break label1167;
          }
          if ((((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) && (((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl <= 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL)))
          {
            ((PluginInfo)localObject4).mPackageName = ((PluginInfo)localObject2).mPackageName;
            ((PluginInfo)localObject4).mCurVersion = ((PluginInfo)localObject2).mCurVersion;
            ((PluginInfo)localObject4).mURL = ((PluginInfo)localObject2).mURL;
            i = 1;
            break label1167;
          }
        }
        else
        {
          if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener != null) {
            this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(true);
          }
          if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
          {
            localObject1 = new HashMap();
            StatisticCollector.a((Map)localObject1, AppSetting.a);
            StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(String.valueOf(paramGetResourceRespV2.uin), "pluginUpdateEmpty", false, 0L, 0L, (HashMap)localObject1, "");
          }
          if (i != 0) {
            a();
          }
          return;
        }
      }
      finally {}
      break label1167;
      label1138:
      int i = 1;
      break label1167;
      label1143:
      break label1164;
      label1146:
      break label1154;
      label1149:
      localObject1 = null;
      continue;
      for (;;)
      {
        break;
        i = 1;
      }
      i = 1;
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public Map a()
  {
    return new HashMap(this.jdField_a_of_type_JavaUtilMap);
  }
  
  public void a()
  {
    File localFile = a(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = PluginInfoUtil.a(localFile);
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      PluginInfoUtil.a((PluginInfo)((Iterator)localObject).next(), localFile);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "handle getPluginList");
    }
    this.jdField_a_of_type_Boolean = true;
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = ((short)localPluginInfo.mType);
      localGetResourceReqInfoV2.strPkgName = localPluginInfo.mPackageName;
      localGetResourceReqInfoV2.uiCurVer = localPluginInfo.mCurVersion;
      localArrayList.add(localGetResourceReqInfoV2);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "getPluginList Add: " + localPluginInfo.mID);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128");
    }
    paramQQAppInterface = (ServerConfigManager)paramQQAppInterface.getManager(4);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getPluginConfig(128, localReqUserInfo, localArrayList, this);
    }
  }
  
  public void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener)
  {
    this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener = paramOnPluginInfoUpdateListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    if (paramPluginInfo == null) {}
    PluginInfo localPluginInfo;
    do
    {
      return false;
      localPluginInfo = a(paramPluginInfo.mID);
    } while ((localPluginInfo == null) || (paramPluginInfo == null) || (!localPluginInfo.mMD5.equals(paramPluginInfo.mMD5)));
    return true;
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onGetPluginConfig: " + paramBoolean);
    }
    if (paramInt != 128) {
      if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener != null) {
        this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(false);
      }
    }
    do
    {
      return;
      if ((paramBoolean) && (paramGetResourceRespV2 != null)) {
        break;
      }
    } while (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener == null);
    this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(false);
    return;
    a(paramGetResourceRespV2);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */