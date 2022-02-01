import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;

public class hks
  extends ServerConfigObserver
{
  public hks(LebaHelper paramLebaHelper) {}
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((paramInt & 0x40) == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "receive get leba config");
    }
    Object localObject1;
    EntityTransaction localEntityTransaction;
    int i1;
    int k;
    int i2;
    int i;
    int i3;
    label135:
    int n;
    int m;
    int j;
    if ((paramBoolean) && (paramGetResourceRespV2 != null))
    {
      this.a.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "Leba get config from server=" + paramGetResourceRespV2);
      }
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localEntityTransaction = ((EntityManager)localObject1).a();
      i1 = 0;
      k = 0;
      i2 = 0;
      i = 0;
      i3 = 0;
      paramInt = 0;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().widthPixels >= 480)
      {
        paramBoolean = true;
        n = i3;
        m = i2;
        j = i1;
      }
    }
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        n = i3;
        m = i2;
        j = i1;
        localObject2 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        n = paramInt;
        m = i;
        j = k;
        if (((Iterator)localObject2).hasNext())
        {
          n = paramInt;
          m = i;
          j = k;
          localObject3 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          n = paramInt;
          m = i;
          j = k;
          if (((GetResourceRespInfoV2)localObject3).iPluginType != 64) {
            continue;
          }
          n = paramInt;
          m = i;
          j = k;
          if (((GetResourceRespInfoV2)localObject3).sResSubType != 0)
          {
            n = paramInt;
            m = i;
            j = k;
            if (((GetResourceRespInfoV2)localObject3).sResSubType != 2) {
              break label1150;
            }
          }
          n = paramInt;
          m = i;
          j = k;
          localObject3 = ConfigManager.a((EntityManager)localObject1, paramBoolean, (GetResourceRespInfoV2)localObject3);
          k = 1;
          i1 = 1;
          i = 1;
          i2 = 1;
          n = paramInt;
          m = i2;
          j = i1;
          if (((ResourcePluginInfo)localObject3).cDefaultState != 0) {
            break label1147;
          }
          n = paramInt;
          m = i2;
          j = i1;
          long l = ((ResourcePluginInfo)localObject3).uiResId;
          if (l > 0L) {
            break label1147;
          }
          paramInt = 1;
        }
      }
      catch (Exception paramGetResourceRespV2)
      {
        Object localObject2;
        Object localObject3;
        i = m;
        paramInt = n;
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "An exception was thrown. " + paramGetResourceRespV2.toString());
        }
        paramGetResourceRespV2.printStackTrace();
        localEntityTransaction.c();
        localEntityTransaction.b();
        ((EntityManager)localObject1).a();
        continue;
      }
      finally
      {
        localEntityTransaction.c();
        localEntityTransaction.b();
        ((EntityManager)localObject1).a();
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "v2.vecAddedResInfo item=" + localObject3);
        }
        i = 1;
        j = 1;
        k = j;
      }
      catch (Exception paramGetResourceRespV2)
      {
        j = k;
        continue;
        j = k;
        continue;
      }
      paramBoolean = false;
      break label135;
      n = paramInt;
      m = i;
      j = k;
      localObject2 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
      n = paramInt;
      m = i;
      j = k;
      if (((Iterator)localObject2).hasNext())
      {
        n = paramInt;
        m = i;
        j = k;
        localObject3 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
        n = paramInt;
        m = i;
        j = k;
        if (((GetResourceRespInfoV2)localObject3).iPluginType != 64) {
          continue;
        }
        n = paramInt;
        m = i;
        j = k;
        if (((GetResourceRespInfoV2)localObject3).sResSubType != 0)
        {
          n = paramInt;
          m = i;
          j = k;
          if (((GetResourceRespInfoV2)localObject3).sResSubType != 2) {}
        }
        else
        {
          n = paramInt;
          m = i;
          j = k;
          localObject3 = ((GetResourceRespInfoV2)localObject3).strPkgName;
          n = paramInt;
          m = i;
          j = k;
          ResourcePluginInfo.remove((EntityManager)localObject1, (String)localObject3);
          k = 1;
          j = k;
        }
      }
      else
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("LebaHelper", 2, "v2.vecDeletedResInfo item=" + (String)localObject3);
            j = k;
          }
          k = j;
        }
        catch (Exception paramGetResourceRespV2)
        {
          j = 1;
          continue;
          j = k;
          continue;
        }
        n = paramInt;
        m = i;
        j = k;
        paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
        n = paramInt;
        m = i;
        j = k;
        if (paramGetResourceRespV2.hasNext())
        {
          n = paramInt;
          m = i;
          j = k;
          localObject2 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
          n = paramInt;
          m = i;
          j = k;
          if (((GetResourceRespInfoV2)localObject2).iPluginType != 64) {
            continue;
          }
          n = paramInt;
          m = i;
          j = k;
          if (((GetResourceRespInfoV2)localObject2).sResSubType != 0)
          {
            n = paramInt;
            m = i;
            j = k;
            if (((GetResourceRespInfoV2)localObject2).sResSubType != 2) {}
          }
          else
          {
            n = paramInt;
            m = i;
            j = k;
            localObject2 = ConfigManager.a((EntityManager)localObject1, paramBoolean, (GetResourceRespInfoV2)localObject2);
            k = 1;
            j = k;
            if (QLog.isColorLevel())
            {
              QLog.d("LebaHelper", 2, "v2.vecUpdatedResInfo item=" + localObject2);
              j = k;
            }
            k = j;
          }
        }
        else
        {
          localEntityTransaction.c();
          localEntityTransaction.b();
          ((EntityManager)localObject1).a();
          j = k;
          LebaHelper.a(this.a);
          LebaHelper.b(this.a);
          if (j != 0)
          {
            paramGetResourceRespV2 = new ArrayList(this.a.c).iterator();
            if (paramGetResourceRespV2.hasNext())
            {
              localObject1 = (ResourcePluginListener)paramGetResourceRespV2.next();
              if (i != 0)
              {
                ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)3, 1);
                if (paramInt == 0) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("LebaHelper", 2, "inform STATE_NEW_OPEN_PLUGIN");
                }
                ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)4, 1);
                continue;
              }
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)2, 1);
              continue;
            }
            break;
          }
          paramInt = 0;
          while (paramInt < this.a.c.size())
          {
            ResourcePluginListener.a((ResourcePluginListener)this.a.c.get(paramInt), (byte)1, 1);
            paramInt += 1;
          }
          break;
          this.a.jdField_a_of_type_Boolean = true;
          paramInt = 0;
          while (paramInt < this.a.c.size())
          {
            ResourcePluginListener.a((ResourcePluginListener)this.a.c.get(paramInt), (byte)-1, 1);
            paramInt += 1;
          }
          break;
        }
      }
      label1147:
      continue;
      label1150:
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hks
 * JD-Core Version:    0.7.0.1
 */