package com.tencent.mm.plugin.api;

import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bkk;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/api/INetSceneFinderUserPage;", "", "checkIsOnlyFetchUserInfo", "", "friendFollowCount", "", "getCurrentLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getNextLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "reqUserName", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract FinderContact caK();
  
  public abstract boolean caL();
  
  public abstract String caM();
  
  public abstract int caN();
  
  public abstract bkk caO();
  
  public abstract FinderObject caP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.api.a
 * JD-Core Version:    0.7.0.1
 */