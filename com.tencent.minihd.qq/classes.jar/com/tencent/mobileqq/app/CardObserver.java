package com.tencent.mobileqq.app;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import java.util.ArrayList;

public class CardObserver
  implements BusinessObserver
{
  public void onAddPortrait(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject) {}
  
  protected void onCardInBlackList(boolean paramBoolean, String paramString) {}
  
  public void onCardLabelUpdate(boolean paramBoolean, Object paramObject) {}
  
  protected void onCoverUpdate(boolean paramBoolean, Card paramCard) {}
  
  public void onDeletePortrait(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  public void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  public void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard) {}
  
  public void onGetPCActiveState(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void onGotFriendInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onGotGroupInfo(boolean paramBoolean, String paramString, Card paramCard) {}
  
  public void onGotPagedAlbumKeys(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte) {}
  
  public void onGreetingRecv(boolean paramBoolean, String paramString) {}
  
  protected void onGreetingSent(boolean paramBoolean, String paramString) {}
  
  public void onImpeach(boolean paramBoolean, String paramString) {}
  
  public void onImportQzonePhotos(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onLabelLikeSet(boolean paramBoolean, Card paramCard, long paramLong) {}
  
  protected void onNearByProfileSymbolGet(boolean paramBoolean, int paramInt) {}
  
  public void onNearbyCardDownload(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  protected void onNewVotePush(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onPortraitVerifyCode(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onQueryImportQzonePhotoesStatus(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onReqAlbum(boolean paramBoolean1, Card paramCard, boolean paramBoolean2) {}
  
  protected void onReqApplyUploadVoice(boolean paramBoolean, String paramString) {}
  
  public void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSetAllowSeeLoginDays(boolean paramBoolean) {}
  
  public void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject) {}
  
  public void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard) {}
  
  public void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void onSetPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSingleStatus(boolean paramBoolean, Card paramCard) {}
  
  public void onTagsUpdate(boolean paramBoolean, Card paramCard) {}
  
  protected void onTransferVoice(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    label1485:
    int i;
    int j;
    int k;
    switch (paramInt)
    {
    case 4: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 30: 
    default: 
    case 1: 
    case 52: 
    case 53: 
    case 35: 
    case 2: 
    case 3: 
    case 5: 
    case 32: 
    case 6: 
    case 42: 
    case 7: 
    case 8: 
    case 10: 
    case 11: 
    case 9: 
    case 12: 
    case 22: 
    case 29: 
    case 16: 
    case 17: 
    case 20: 
    case 43: 
    case 21: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 41: 
    case 27: 
    case 28: 
    case 31: 
    case 34: 
    case 33: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 54: 
    case 55: 
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
                            do
                            {
                              return;
                              onCardDownload(paramBoolean, paramObject);
                              return;
                              onCardLabelUpdate(paramBoolean, paramObject);
                              return;
                              if (!paramBoolean) {
                                break;
                              }
                            } while (!(paramObject instanceof Object[]));
                            paramObject = (Object[])paramObject;
                            onLabelLikeSet(paramBoolean, (Card)paramObject[0], ((Long)paramObject[1]).longValue());
                            return;
                          } while (!(paramObject instanceof Card));
                          onLabelLikeSet(paramBoolean, (Card)paramObject, -1L);
                          return;
                        } while (!(paramObject instanceof Object[]));
                        paramObject = (Object[])paramObject;
                        onVoiceManager(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Card)paramObject[2]);
                        return;
                        onCardInBlackList(paramBoolean, ((Bundle)paramObject).getString("uin"));
                        return;
                        if (paramBoolean)
                        {
                          onUpdateCard(paramBoolean, (Card)paramObject);
                          return;
                        }
                        onUpdateCard(paramBoolean, null);
                        return;
                        onVoteResult(paramBoolean, ((Bundle)paramObject).getString("targetUin"));
                        return;
                      } while (!(paramObject instanceof Bundle));
                      paramObject = (Bundle)paramObject;
                      onReqFavoriteResult(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"));
                      return;
                      String str;
                      if (paramBoolean)
                      {
                        localObject2 = (Object[])paramObject;
                        paramObject = (Card)localObject2[0];
                        localObject1 = (Bundle)localObject2[1];
                        localObject2 = (ArrayList)localObject2[2];
                        str = ((Bundle)localObject1).getString("uin");
                        l1 = ((Bundle)localObject1).getLong("nextMid");
                        onVoterList(true, str, (ArrayList)localObject2, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), paramObject);
                        return;
                      }
                      onVoterList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
                      return;
                      if (paramBoolean)
                      {
                        localObject2 = (Object[])paramObject;
                        paramObject = (Card)localObject2[0];
                        localObject1 = (Bundle)localObject2[1];
                        localObject2 = (ArrayList)localObject2[2];
                        str = ((Bundle)localObject1).getString("uin");
                        l1 = ((Bundle)localObject1).getLong("nextMid");
                        onFavoritorsList(true, str, (ArrayList)localObject2, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), paramObject);
                        return;
                      }
                      onFavoritorsList(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
                      return;
                      localObject1 = (Object[])paramObject;
                      paramObject = (Bundle)localObject1[0];
                      localObject1 = (ArrayList)localObject1[1];
                      localObject2 = paramObject.getString("uin");
                      l1 = paramObject.getLong("startMid", 0L);
                      l2 = paramObject.getLong("nextMid");
                      paramObject = paramObject.getByteArray("strCookie");
                      if (paramBoolean)
                      {
                        onVisitorList(true, (String)localObject2, (ArrayList)localObject1, l1, l2, paramObject);
                        return;
                      }
                      onVisitorList(false, (String)localObject2, (ArrayList)localObject1, l1, -1L, null);
                      return;
                      onUpdateAvatar(paramBoolean, ((Bundle)paramObject).getString("uin"));
                      return;
                      if (paramBoolean)
                      {
                        paramObject = (Object[])paramObject;
                        onReqAlbum(true, (Card)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                        return;
                      }
                      onReqAlbum(false, (Card)paramObject, false);
                      return;
                      if (paramBoolean)
                      {
                        paramObject = (Object[])paramObject;
                        localObject1 = (Card)paramObject[0];
                        onAddPortrait(paramBoolean, null, ((Bundle)paramObject[1]).getInt("retCode", -1), (Card)localObject1);
                        return;
                      }
                      paramInt = -1;
                      if ((paramObject instanceof Bundle)) {
                        paramInt = ((Bundle)paramObject).getInt("retCode", -1);
                      }
                      onAddPortrait(paramBoolean, null, paramInt, null);
                      return;
                    } while (!paramBoolean);
                    onUpdateSelfIntroduction(paramBoolean, (Card)paramObject);
                    return;
                    if (paramBoolean)
                    {
                      localObject1 = (Object[])paramObject;
                      paramObject = (Bundle)localObject1[0];
                      localObject1 = (Card)localObject1[1];
                      paramObject.getString("uin");
                      onDeletePortrait(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
                      return;
                    }
                    localObject1 = (Object[])paramObject;
                    paramObject = (Bundle)localObject1[0];
                    localObject1 = (Card)localObject1[1];
                    paramObject.getString("uin");
                    onDeletePortrait(paramBoolean, (Card)localObject1, paramObject.getInt("result", -1), paramObject.getByteArray("fileKey"));
                    return;
                    onGreetingSent(paramBoolean, ((Bundle)paramObject).getString("uin"));
                    return;
                    onGreetingRecv(paramBoolean, ((Bundle)paramObject).getString("uin"));
                    return;
                  } while (!paramBoolean);
                  paramObject = (Card)paramObject;
                  onGotFriendInfo(paramBoolean, paramObject.uin, paramObject);
                  return;
                } while (!paramBoolean);
                paramObject = (Card)paramObject;
                onGotGroupInfo(paramBoolean, paramObject.uin, paramObject);
                return;
              } while (!paramBoolean);
              paramObject = (Card)paramObject;
              onGetDetailInfo(paramBoolean, paramObject.uin, paramObject);
              return;
            } while (!paramBoolean);
            paramObject = (Card)paramObject;
            onGetLocationDescription(true, paramObject.uin, paramObject);
            return;
            paramObject = (Bundle)paramObject;
            onPortraitVerifyCode(paramBoolean, paramObject.getString("uin"), paramObject.getString("filekey"));
            return;
            onImpeach(paramBoolean, ((Bundle)paramObject).getString("uin"));
            return;
            if (paramBoolean)
            {
              onSingleStatus(paramBoolean, (Card)paramObject);
              return;
            }
            onSingleStatus(paramBoolean, null);
            return;
            if (paramBoolean)
            {
              onTagsUpdate(paramBoolean, (Card)paramObject);
              return;
            }
            onTagsUpdate(paramBoolean, null);
            return;
            paramObject = (Card)paramObject;
            if (paramBoolean)
            {
              onCoverUpdate(paramBoolean, paramObject);
              return;
            }
            onCoverUpdate(paramBoolean, paramObject);
            return;
            onSetCardTemplateReturn(paramBoolean, paramObject);
            return;
            paramObject = (Bundle)paramObject;
            localObject1 = paramObject.getString("lUin");
            l1 = paramObject.getLong("nextMid");
            Object localObject2 = paramObject.getByteArray("strCookie");
            onGotPagedAlbumKeys(paramBoolean, (String)localObject1, paramObject.getStringArrayList("hexFaceInfo"), l1, (byte[])localObject2);
            return;
          } while (!paramBoolean);
          Object localObject1 = (Object[])paramObject;
          paramObject = (Card)localObject1[0];
          localObject1 = (Bundle)localObject1[1];
          ((Bundle)localObject1).getString("uin");
          paramInt = ((Bundle)localObject1).getInt("newVoteCount");
          onNewVotePush(paramBoolean, ((Bundle)localObject1).getString("voteeUin"), paramInt, paramObject);
          return;
          paramObject = (Object[])paramObject;
          onSetDetailInfo(paramBoolean, ((Integer)paramObject[0]).intValue(), (Card)paramObject[1]);
          return;
          paramObject = (Bundle)paramObject;
          onSetCardSwitch(paramBoolean, paramObject.getString("uin"), paramObject.getBoolean("modify_switch_for_near_people"), paramObject.getBoolean("target_switch"));
          return;
          paramObject = (Bundle)paramObject;
          localObject1 = paramObject.getString("uin");
          long l1 = paramObject.getLong("uCloseNeighborVote", 0L);
          long l2 = paramObject.getLong("uColseTimeEntityManager", 0L);
          boolean bool1;
          if (l1 == 0L)
          {
            bool1 = true;
            if (l2 != 0L) {
              break label1485;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            onGetCardSwitch(paramBoolean, (String)localObject1, bool1, bool2);
            return;
            bool1 = false;
            break;
          }
          onReqApplyUploadVoice(paramBoolean, ((Bundle)paramObject).getString("pttcenter_selfuin"));
          return;
          paramObject = (Bundle)paramObject;
          localObject1 = paramObject.getString("pttcenter_selfuin");
          paramInt = paramObject.getInt("pttcenter_voice_optype");
          onTransferVoice(paramBoolean, (String)localObject1, paramObject.getString("pttcenter_filekey"), paramInt);
          return;
          onGetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
          return;
          onSetPhoneNumSearchable(paramBoolean, ((Boolean)paramObject).booleanValue());
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
        onGetQZoneCover(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
        return;
        onGetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      onSetPCActiveState(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
      return;
    case 44: 
      onGetAllowSeeLoginDays(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 45: 
      onSetAllowSeeLoginDays(paramBoolean);
      return;
    case 46: 
      onUpdateNearbyPeoplePhotoList(paramBoolean);
      return;
    case 47: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 2))
      {
        onUploadQzonePhoto(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
      }
      onUploadQzonePhoto(false, 0, "");
      return;
    case 48: 
      paramObject = (Object[])paramObject;
      paramInt = -1;
      i = -1;
      j = -1;
      k = -1;
      if ((paramObject != null) && (paramObject.length == 5))
      {
        if ((paramObject[1] instanceof Integer)) {
          paramInt = ((Integer)paramObject[1]).intValue();
        }
        if ((paramObject[2] instanceof Integer)) {
          i = ((Integer)paramObject[2]).intValue();
        }
        if ((paramObject[3] instanceof Integer)) {
          j = ((Integer)paramObject[3]).intValue();
        }
        if ((paramObject[4] instanceof Integer)) {
          k = ((Integer)paramObject[4]).intValue();
        }
        onImportQzonePhotos(paramBoolean, (ArrayList)paramObject[0], paramInt, i, j, k);
        return;
      }
      onImportQzonePhotos(false, null, -1, -1, -1, -1);
      return;
    case 49: 
      onUpdateNearbyProfile(paramBoolean, (NearbyPeopleCard)paramObject);
      return;
    case 50: 
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        i = -1;
        j = -1;
        k = -1;
        if ((paramObject == null) || (paramObject.length != 5)) {
          break label2085;
        }
        if (!(paramObject[1] instanceof Integer)) {
          break label2080;
        }
        paramInt = ((Integer)paramObject[1]).intValue();
        if ((paramObject[2] instanceof Integer)) {
          i = ((Integer)paramObject[2]).intValue();
        }
        if ((paramObject[3] instanceof Integer)) {
          j = ((Integer)paramObject[3]).intValue();
        }
        if (!(paramObject[4] instanceof Integer)) {
          break label2077;
        }
        k = ((Integer)paramObject[4]).intValue();
      }
      break;
    }
    for (;;)
    {
      onQueryImportQzonePhotoesStatus(paramBoolean, (ArrayList)paramObject[0], paramInt, i, j, k);
      return;
      onQueryImportQzonePhotoesStatus(false, null, -1, -1, -1, -1);
      return;
      onNearbyCardDownload(paramBoolean, (NearbyPeopleCard)paramObject);
      return;
      onNearByProfileSymbolGet(paramBoolean, ((Integer)paramObject).intValue());
      return;
      onGetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
      onSetAllowActivateFriend(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
      onUpdateSetCallTabVisible(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
      label2077:
      continue;
      label2080:
      paramInt = -1;
      break;
      label2085:
      j = -1;
      i = -1;
      paramInt = -1;
    }
  }
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateCard(boolean paramBoolean, Card paramCard) {}
  
  public void onUpdateNearbyPeoplePhotoList(boolean paramBoolean) {}
  
  public void onUpdateNearbyProfile(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  protected void onUpdateSelfIntroduction(boolean paramBoolean, Card paramCard) {}
  
  protected void onUpdateSetCallTabVisible(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUploadQzonePhoto(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void onVisitorList(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte) {}
  
  protected void onVoiceManager(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void onVoteResult(boolean paramBoolean, String paramString) {}
  
  public void onVoterList(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void simpleUpdate(boolean paramBoolean, String paramString, Card paramCard) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardObserver
 * JD-Core Version:    0.7.0.1
 */