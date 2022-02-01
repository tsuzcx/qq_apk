package com.tencent.mm.plugin.biz.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.x;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/biz/util/BizPayAlbumLogic;", "", "()V", "TAG", "", "getAlbumInfo", "Lcom/tencent/mm/storage/BizPayAlbum;", "msgContent", "isDataValid", "", "values", "", "onBizPayAlbumNotify", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b vto;
  
  static
  {
    AppMethodBeat.i(260665);
    vto = new b();
    AppMethodBeat.o(260665);
  }
  
  public static x aij(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(260661);
    x localx = new x();
    Object localObject2 = (CharSequence)paramString;
    if ((localObject2 == null) || (n.bp((CharSequence)localObject2))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(260661);
      return localx;
    }
    i = n.a((CharSequence)paramString, "<sysmsg", 0, false, 6);
    if (i != -1)
    {
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(260661);
        throw paramString;
      }
      localObject1 = paramString.substring(i);
      s.s(localObject1, "(this as java.lang.String).substring(startIndex)");
      localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
    }
    if (localObject1 == null)
    {
      Log.e("MicroMsg.BizPayAlbumLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
      AppMethodBeat.o(260661);
      return localx;
    }
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.UserName");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.userName = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.NickName");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.nickName = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.plain");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.nUO = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.nVs = paramString;
    localObject2 = (String)((Map)localObject1).get(".sysmsg.BizNotification.AppMsg.Title");
    paramString = (String)localObject2;
    if (localObject2 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.title = paramString;
    localObject1 = (String)((Map)localObject1).get(".sysmsg.BizNotification.AppMsg.WebUrl");
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    s.u(paramString, "<set-?>");
    localx.rDm = paramString;
    AppMethodBeat.o(260661);
    return localx;
  }
  
  public static void i(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(260656);
    if ((paramString == null) || (paramMap == null))
    {
      Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(260656);
      return;
    }
    if (!h.baz())
    {
      Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify acc not ready");
      AppMethodBeat.o(260656);
      return;
    }
    Log.i("MicroMsg.BizPayAlbumLogic", s.X("onBizPayAlbumNotify msgContent=", paramString));
    int i;
    if (paramMap == null) {
      i = 0;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
      AppMethodBeat.o(260656);
      return;
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label121;
        }
        i = 0;
        break;
      }
      label121:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.NickName");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label163;
        }
        i = 0;
        break;
      }
      label163:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.BizAccount.HeadImgUrl");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label205;
        }
        i = 0;
        break;
      }
      label205:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.plain");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label247;
        }
        i = 0;
        break;
      }
      label247:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.AppMsg.Title");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label289;
        }
        i = 0;
        break;
      }
      label289:
      localObject = (CharSequence)paramMap.get(".sysmsg.BizNotification.AppMsg.WebUrl");
      if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label331;
        }
        i = 0;
        break;
      }
      label331:
      i = 1;
    }
    Object localObject = new ab();
    ((ab)localObject).field_msgId = af.bHo().iZc();
    ((ab)localObject).field_msgSvrId = 0L;
    ((ab)localObject).field_type = 10100;
    ((ab)localObject).field_talker = ((String)paramMap.get(".sysmsg.BizNotification.BizAccount.UserName"));
    ((ab)localObject).field_talkerId = 0;
    ((ab)localObject).field_createTime = br.bCJ();
    ((ab)localObject).po(1);
    ((ab)localObject).field_status = 3;
    ((ab)localObject).field_content = paramString;
    boolean bool = af.bHo().E((ab)localObject);
    Log.i("MicroMsg.BizPayAlbumLogic", s.X("onBizPayAlbumNotify result: %b, username: %s, msgid=", Long.valueOf(((ab)localObject).field_msgId)), new Object[] { Boolean.valueOf(bool), ((ab)localObject).field_talker });
    AppMethodBeat.o(260656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.biz.b.b
 * JD-Core Version:    0.7.0.1
 */