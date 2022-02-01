package com.tencent.mm.plugin.biz.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.z;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/biz/util/BizPayAlbumLogic;", "", "()V", "TAG", "", "getAlbumInfo", "Lcom/tencent/mm/storage/BizPayAlbum;", "msgContent", "isDataValid", "", "values", "", "onBizPayAlbumNotify", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-biz_release"})
public final class a
{
  public static final a nOO;
  
  static
  {
    AppMethodBeat.i(207295);
    nOO = new a();
    AppMethodBeat.o(207295);
  }
  
  public static com.tencent.mm.storage.v Wz(String paramString)
  {
    AppMethodBeat.i(207294);
    com.tencent.mm.storage.v localv = new com.tencent.mm.storage.v();
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207294);
      return localv;
    }
    localObject = null;
    i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
    if (i != -1)
    {
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(207294);
        throw paramString;
      }
      localObject = paramString.substring(i);
      p.g(localObject, "(this as java.lang.String).substring(startIndex)");
      localObject = bw.M((String)localObject, "sysmsg");
    }
    if (localObject == null)
    {
      ad.e("MicroMsg.BizPayAlbumLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
      AppMethodBeat.o(207294);
      return localv;
    }
    String str = (String)((Map)localObject).get(".sysmsg.BizNotification.BizAccount.UserName");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.userName = paramString;
    str = (String)((Map)localObject).get(".sysmsg.BizNotification.BizAccount.NickName");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.bVF = paramString;
    str = (String)((Map)localObject).get(".sysmsg.BizNotification.plain");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.hDo = paramString;
    str = (String)((Map)localObject).get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.hDQ = paramString;
    str = (String)((Map)localObject).get(".sysmsg.BizNotification.AppMsg.Title");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.title = paramString;
    localObject = (String)((Map)localObject).get(".sysmsg.BizNotification.AppMsg.WebUrl");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    p.h(paramString, "<set-?>");
    localv.kwk = paramString;
    AppMethodBeat.o(207294);
    return localv;
  }
  
  public static void f(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(207293);
    if ((paramString == null) || (paramMap == null))
    {
      ad.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(207293);
      return;
    }
    if (!g.ajx())
    {
      ad.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify acc not ready");
      AppMethodBeat.o(207293);
      return;
    }
    ad.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify msgContent=".concat(String.valueOf(paramString)));
    int i;
    if (paramMap == null) {
      i = 0;
    }
    while (i == 0)
    {
      ad.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(207293);
      return;
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName");
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
      if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
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
    Object localObject = new w();
    ((w)localObject).field_msgId = ag.aGg().fpK();
    ((w)localObject).field_msgSvrId = 0L;
    ((w)localObject).field_type = 10100;
    ((w)localObject).field_talker = ((String)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName"));
    ((w)localObject).field_talkerId = 0;
    ((w)localObject).field_createTime = bj.aCb();
    ((w)localObject).jY(1);
    ((w)localObject).field_status = 3;
    ((w)localObject).field_content = paramString;
    boolean bool = ag.aGg().o((w)localObject);
    ad.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify result: %b, username: %s, msgid=" + ((w)localObject).field_msgId, new Object[] { Boolean.valueOf(bool), ((w)localObject).field_talker });
    AppMethodBeat.o(207293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.a
 * JD-Core Version:    0.7.0.1
 */