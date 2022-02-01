package com.tencent.mobileqq.app;

import EncounterSvc.RespGetEncounterV2;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NeighborComm.RespHeader;
import NeighborSvc.RespGetNeighbors;
import QQService.RespFaceInfo;
import com.tencent.mobileqq.facetoface.NearbyUser;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;
import tencent.im.fanpaizi.FanPaiZi.RespDislike;
import tencent.im.fanpaizi.FanPaiZi.RespGetList;
import tencent.im.fanpaizi.FanPaiZi.RespPrise;

public class LBSObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup) {}
  
  public void a(NearbyUser paramNearbyUser, boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea) {}
  
  public void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, ToServiceMsg paramToServiceMsg) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean1, String paramString, RespGetNeighbors paramRespGetNeighbors, boolean paramBoolean2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, RespFaceInfo paramRespFaceInfo) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, FanPaiZi.RespDislike paramRespDislike) {}
  
  public void a(boolean paramBoolean, FanPaiZi.RespGetList paramRespGetList) {}
  
  public void a(boolean paramBoolean, FanPaiZi.RespPrise paramRespPrise) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 9: 
    case 10: 
    case 11: 
    case 18: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 23: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    case 26: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while (paramObject == null);
                          if (paramBoolean)
                          {
                            paramObject = (Object[])paramObject;
                            a(true, (byte[])paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
                            return;
                          }
                          a(false, (byte[])paramObject, null, null, null);
                          return;
                          if (!paramBoolean) {
                            break;
                          }
                        } while (paramObject == null);
                        paramObject = (Object[])paramObject;
                        a(true, (String)paramObject[0], (RespGetNeighbors)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), 0);
                        return;
                        a(false, null, null, false, -1);
                        return;
                        b(paramBoolean, ((Boolean)paramObject).booleanValue());
                        return;
                      } while (paramObject == null);
                      paramObject = (Object[])paramObject;
                    } while (paramObject.length < 3);
                    if ((paramObject[0] != null) && (paramObject[1] != null))
                    {
                      if (paramObject.length >= 5)
                      {
                        a(paramBoolean, (RespHeader)paramObject[0], (RespGetEncounterV2)paramObject[1], (ToServiceMsg)paramObject[2]);
                        return;
                      }
                      a(paramBoolean, (RespHeader)paramObject[0], (RespGetEncounterV2)paramObject[1], (ToServiceMsg)paramObject[2]);
                      return;
                    }
                    if (paramObject[0] == null)
                    {
                      a(paramBoolean, null, null, (ToServiceMsg)paramObject[2]);
                      return;
                    }
                    a(paramBoolean, (RespHeader)paramObject[0], null, (ToServiceMsg)paramObject[2]);
                    return;
                  } while (paramObject == null);
                  if (paramBoolean)
                  {
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                  }
                  a(false, null, 0);
                  return;
                  paramObject = (Object[])paramObject;
                  paramInt = ((Integer)paramObject[0]).intValue();
                  boolean bool = ((Boolean)paramObject[1]).booleanValue();
                  paramObject = (RspGetNearbyGroup)paramObject[2];
                  if (paramBoolean)
                  {
                    a(paramInt, true, bool, paramObject);
                    return;
                  }
                  a(paramInt, false, bool, paramObject);
                  return;
                  if (paramBoolean)
                  {
                    if (paramObject == null)
                    {
                      a(true, null, false);
                      return;
                    }
                    paramObject = (Object[])paramObject;
                    paramBoolean = ((Boolean)paramObject[0]).booleanValue();
                    a(true, (RspGetAreaList)paramObject[1], paramBoolean);
                    return;
                  }
                  a(false, null, false);
                  return;
                  if (paramBoolean)
                  {
                    if (paramObject == null)
                    {
                      a(true, null);
                      return;
                    }
                    a(true, (RspGetGroupInArea)((Object[])(Object[])paramObject)[0]);
                    return;
                  }
                  a(false, null);
                  return;
                  if ((paramBoolean == true) && (paramObject != null))
                  {
                    paramObject = (Object[])paramObject;
                    a(true, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue());
                    return;
                  }
                  a(false, 0L, false);
                  return;
                  a(paramBoolean, ((Boolean)paramObject).booleanValue());
                  return;
                  paramObject = (Object[])paramObject;
                  if (paramBoolean)
                  {
                    a(true, ((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue());
                    return;
                  }
                  a(false, -1, false);
                  return;
                } while ((!paramBoolean) || (paramObject == null));
                a(true, (byte[])paramObject);
                return;
              } while ((paramBoolean != true) || (paramObject == null));
              paramObject = (Object[])paramObject;
              String.valueOf(paramObject[0]);
              String.valueOf(paramObject[1]);
              String.valueOf(paramObject[2]);
              String.valueOf(paramObject[3]);
              String.valueOf(paramObject[4]);
              String.valueOf(paramObject[5]);
              String.valueOf(paramObject[6]);
              String.valueOf(paramObject[7]);
              ((Integer)paramObject[8]).doubleValue();
              ((Integer)paramObject[9]).doubleValue();
              ((Integer)paramObject[10]).doubleValue();
              paramObject = (String[])paramObject[11];
              return;
              a(paramBoolean, (Object[])paramObject);
              return;
              b(paramBoolean, (Object[])paramObject);
              return;
              c(paramBoolean, (Object[])paramObject);
              return;
              a(paramBoolean, ((Integer)paramObject).intValue());
              return;
              a(paramBoolean, paramObject);
              return;
              if (paramObject != null)
              {
                a(paramBoolean, (FanPaiZi.RespGetList)((Object[])(Object[])paramObject)[0]);
                return;
              }
              a(paramBoolean, null);
              return;
            } while (paramObject == null);
            a(paramBoolean, (FanPaiZi.RespPrise)((Object[])(Object[])paramObject)[0]);
            return;
          } while (paramObject == null);
          a(paramBoolean, (FanPaiZi.RespDislike)((Object[])(Object[])paramObject)[0]);
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
        a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
      a((NearbyUser)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
      return;
    }
    a(paramBoolean, (List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSObserver
 * JD-Core Version:    0.7.0.1
 */