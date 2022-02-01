package com.tencent.mobileqq.app;

import com.tencent.mobileqq.facetoface.Face2FaceGroupProfile;
import com.tencent.mobileqq.facetoface.Face2FaceUserProfile;
import java.util.List;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class NearFieldTroopObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile) {}
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          paramObject = (Object[])paramObject;
          a((nearfield_group.BusiRespHead)paramObject[0], (List)paramObject[1]);
          return;
        }
        a(null, null);
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          a((nearfield_group.BusiRespHead)((Object[])(Object[])paramObject)[0]);
          return;
        }
        a(null);
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          paramObject = (Object[])paramObject;
          a((nearfield_group.BusiRespHead)paramObject[0], (String)paramObject[1]);
          return;
        }
        a(null, "");
        return;
      } while ((!paramBoolean) || (paramObject == null));
      a((Face2FaceGroupProfile)((Object[])(Object[])paramObject)[0]);
      return;
    } while ((!paramBoolean) || (paramObject == null));
    a((Face2FaceUserProfile)((Object[])(Object[])paramObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearFieldTroopObserver
 * JD-Core Version:    0.7.0.1
 */