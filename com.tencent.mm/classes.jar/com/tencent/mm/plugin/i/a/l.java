package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apn;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedComment", "", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "modifyFeedPrivacy", "ifPrivate", "finder-sdk_release"})
public abstract interface l
  extends a
{
  public abstract void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<apn> params);
  
  public abstract void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, s<apn> params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.l
 * JD-Core Version:    0.7.0.1
 */