package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.amj;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyUserInfo;", "Lcom/tencent/mm/kernel/service/IService;", "modifyUserAvatar", "", "avatarPath", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "modifyUserDistrict", "country", "province", "city", "unshowSwitch", "", "modifyUserNickname", "nickname", "modifyUserSex", "sex", "modifyUserSignature", "signature", "finder-sdk_release"})
public abstract interface i
  extends a
{
  public abstract void a(int paramInt, k<amj> paramk);
  
  public abstract void a(String paramString, k<amj> paramk);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, k<amj> paramk);
  
  public abstract void b(String paramString, k<amj> paramk);
  
  public abstract void c(String paramString, k<amj> paramk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.i
 * JD-Core Version:    0.7.0.1
 */