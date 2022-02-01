package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.aps;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/kernel/service/IService;", "modifyUserAvatar", "", "avatarPath", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "", "modifyUserNickname", "nickname", "modifyUserPrivate", "private", "modifyUserSex", "sex", "modifyUserSignature", "signature", "finder-sdk_release"})
public abstract interface n
  extends a
{
  public abstract void a(int paramInt, s<aps> params);
  
  public abstract void a(String paramString, s<aps> params);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, s<aps> params);
  
  public abstract void b(int paramInt, s<aps> params);
  
  public abstract void b(String paramString, s<aps> params);
  
  public abstract void c(String paramString, s<aps> params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.n
 * JD-Core Version:    0.7.0.1
 */