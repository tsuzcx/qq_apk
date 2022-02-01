package com.tencent.mm.plugin.biz.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/biz/util/BizPayAlbumLogic;", "", "()V", "TAG", "", "getAlbumInfo", "Lcom/tencent/mm/storage/BizPayAlbum;", "msgContent", "isDataValid", "", "values", "", "onBizPayAlbumNotify", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-biz_release"})
public final class b
{
  public static final b pfn;
  
  static
  {
    AppMethodBeat.i(212455);
    pfn = new b();
    AppMethodBeat.o(212455);
  }
  
  public static x ahh(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(212454);
    x localx = new x();
    Object localObject2 = (CharSequence)paramString;
    if ((localObject2 == null) || (n.aL((CharSequence)localObject2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212454);
      return localx;
    }
    i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
    if (i != -1)
    {
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(212454);
        throw paramString;
      }
      localObject1 = paramString.substring(i);
      p.g(localObject1, "(this as java.lang.String).substring(startIndex)");
      localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
    }
    if (localObject1 == null)
    {
      Log.e("MicroMsg.BizPayAlbumLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
      AppMethodBeat.o(212454);
      return localx;
    }
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.UserName");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.userName = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.NickName");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.nickName = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.plain");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.iAq = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.iAR = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.AppMsg.Title");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.title = paramString;
    localObject1 = (String)((Map)localObject1).get(".sysmsg.BizNotification.AppMsg.WebUrl");
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localx.lDS = paramString;
    AppMethodBeat.o(212454);
    return localx;
  }
  
  public static void g(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(212453);
    if ((paramString == null) || (paramMap == null))
    {
      Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(212453);
      return;
    }
    if (!g.aAc())
    {
      Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify acc not ready");
      AppMethodBeat.o(212453);
      return;
    }
    Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify msgContent=".concat(String.valueOf(paramString)));
    int i;
    if (paramMap == null) {
      i = 0;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(212453);
      return;
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label124;
        }
        i = 0;
        break;
      }
      label124:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.NickName");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label166;
        }
        i = 0;
        break;
      }
      label166:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        i = 0;
        break;
      }
      label208:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.plain");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label250;
        }
        i = 0;
        break;
      }
      label250:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.AppMsg.Title");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label292;
        }
        i = 0;
        break;
      }
      label292:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.AppMsg.WebUrl");
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label334;
        }
        i = 0;
        break;
      }
      label334:
      i = 1;
    }
    Object localObject = new z();
    ((z)localObject).field_msgId = ag.bap().gBo();
    ((z)localObject).field_msgSvrId = 0L;
    ((z)localObject).field_type = 10100;
    ((z)localObject).field_talker = ((String)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName"));
    ((z)localObject).field_talkerId = 0;
    ((z)localObject).field_createTime = bp.aVP();
    ((z)localObject).nc(1);
    ((z)localObject).field_status = 3;
    ((z)localObject).field_content = paramString;
    boolean bool = ag.bap().B((z)localObject);
    Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify result: %b, username: %s, msgid=" + ((z)localObject).field_msgId, new Object[] { Boolean.valueOf(bool), ((z)localObject).field_talker });
    AppMethodBeat.o(212453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.b
 * JD-Core Version:    0.7.0.1
 */