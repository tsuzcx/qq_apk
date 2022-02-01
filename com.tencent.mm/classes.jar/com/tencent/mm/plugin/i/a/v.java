package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayy;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/kernel/service/IService;", "modifyFeedComment", "", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "modifyFeedPrivacy", "ifPrivate", "finder-sdk_release"})
public abstract interface v
  extends a
{
  public abstract void a(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ai<ayy> paramai);
  
  public abstract void b(long paramLong, FinderObject paramFinderObject, String paramString, boolean paramBoolean, ai<ayy> paramai);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.v
 * JD-Core Version:    0.7.0.1
 */