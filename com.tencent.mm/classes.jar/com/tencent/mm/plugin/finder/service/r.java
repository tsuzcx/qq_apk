package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.bqe;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/IFinderModifyUserInfo;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedMvReproduce", "", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "modifyProfileCover", "coverUrl", "", "modifyUserAtShowTab", "private", "", "modifyUserAvatar", "avatarPath", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserMpIdentity", "switchToMpIdentity", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r
  extends a
{
  public abstract void a(int paramInt, ck<bqe> paramck);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, ck<bqe> paramck);
  
  public abstract void a(boolean paramBoolean, ck<bqe> paramck);
  
  public abstract void b(int paramInt, ck<bqe> paramck);
  
  public abstract void b(boolean paramBoolean, ck<bqe> paramck);
  
  public abstract void c(int paramInt, ck<bqe> paramck);
  
  public abstract void c(String paramString, ck<bqe> paramck);
  
  public abstract void d(String paramString, ck<bqe> paramck);
  
  public abstract void e(String paramString, ck<bqe> paramck);
  
  public abstract void f(String paramString, ck<bqe> paramck);
  
  public abstract void pL(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.r
 * JD-Core Version:    0.7.0.1
 */