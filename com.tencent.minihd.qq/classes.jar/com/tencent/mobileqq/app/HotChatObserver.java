package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, Common.WifiPOIInfo paramWifiPOIInfo, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramObject = (Object[])paramObject;
        if (paramBoolean)
        {
          a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (Boolean)paramObject[1], (Common.WifiPOIInfo)paramObject[2], (List)paramObject[3]);
          return;
        }
        a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), null, null, null);
        return;
        if (paramBoolean) {}
        for (paramInt = i;; paramInt = -1)
        {
          a(paramInt);
          return;
        }
        if (paramObject == null)
        {
          a(null, null, paramBoolean, null, null, null);
          return;
        }
        paramObject = (Object[])paramObject;
        if (paramBoolean)
        {
          a((String)paramObject[2], (String)paramObject[1], paramBoolean, (String)paramObject[0], (String)paramObject[3], (Boolean)paramObject[4]);
          return;
        }
        a("", (String)paramObject[0], paramBoolean, (String)paramObject[1], (String)paramObject[2], null);
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], paramBoolean, (String)paramObject[1]);
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    a(paramBoolean, (HotChatInfo)paramObject[0], (Common.WifiPOIInfo)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatObserver
 * JD-Core Version:    0.7.0.1
 */