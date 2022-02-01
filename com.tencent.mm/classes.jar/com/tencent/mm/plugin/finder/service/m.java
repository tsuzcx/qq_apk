package com.tencent.mm.plugin.finder.service;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bfc;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/IFinderModifyUserInfo;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedMvReproduce", "", "show", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "modifyUserAtShowTab", "private", "", "modifyUserAvatar", "avatarPath", "", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "modifyUserNickname", "nickname", "modifyUserPrivate", "modifyUserSex", "sex", "modifyUserSignature", "signature", "modifyUserWxProfile", "plugin-finder_release"})
public abstract interface m
  extends a
{
  public abstract void a(int paramInt, aj<bfc> paramaj);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, aj<bfc> paramaj);
  
  public abstract void a(boolean paramBoolean, aj<bfc> paramaj);
  
  public abstract void b(int paramInt, aj<bfc> paramaj);
  
  public abstract void c(int paramInt, aj<bfc> paramaj);
  
  public abstract void c(String paramString, aj<bfc> paramaj);
  
  public abstract void d(String paramString, aj<bfc> paramaj);
  
  public abstract void e(String paramString, aj<bfc> paramaj);
  
  public abstract void oj(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.m
 * JD-Core Version:    0.7.0.1
 */