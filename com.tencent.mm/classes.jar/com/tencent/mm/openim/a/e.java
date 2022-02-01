package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent;", "", "()V", "headImageUrl", "", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "nickName", "getNickName", "setNickName", "openImAppId", "getOpenImAppId", "setOpenImAppId", "openImDesc", "getOpenImDesc", "setOpenImDesc", "openImDescIcon", "getOpenImDescIcon", "setOpenImDescIcon", "sex", "", "getSex", "()I", "setSex", "(I)V", "smallHeadImageUrl", "getSmallHeadImageUrl", "setSmallHeadImageUrl", "ticket", "getTicket", "setTicket", "username", "getUsername", "setUsername", "getDisplayName", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a prN;
  public String hFb = "";
  public String nickName = "";
  String nnS = "";
  String prO = "";
  String prP = "";
  public String prQ = "";
  public String prR = "";
  int sex;
  public String username = "";
  
  static
  {
    AppMethodBeat.i(236021);
    prN = new a((byte)0);
    AppMethodBeat.o(236021);
  }
  
  public final String getDisplayName()
  {
    AppMethodBeat.i(236029);
    if (((CharSequence)this.nickName).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      str = this.nickName;
      AppMethodBeat.o(236029);
      return str;
    }
    String str = this.username;
    AppMethodBeat.o(236029);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent$Companion;", "", "()V", "TAG", "", "beforeParse", "content", "getShareCardMsgContent", "", "toSendUsername", "callback", "Lkotlin/Function1;", "", "parse", "Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static e RK(String paramString)
    {
      AppMethodBeat.i(236024);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(236024);
        return null;
      }
      e locale = new e();
      int k;
      int j;
      if (paramString == null)
      {
        paramString = "";
        paramString = (CharSequence)paramString;
        i = paramString.length() - 1;
        k = 0;
        j = 0;
      }
      for (;;)
      {
        label78:
        if (j > i) {
          break label157;
        }
        int m;
        if (k == 0)
        {
          m = j;
          label90:
          if (s.compare(paramString.charAt(m), 32) > 0) {
            break label132;
          }
          m = 1;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label78;
              break;
              m = i;
              break label90;
              label132:
              m = 0;
              continue;
            }
            j += 1;
            break label78;
          }
        }
        if (m == 0) {
          break label157;
        }
        i -= 1;
      }
      label157:
      localObject = paramString.subSequence(j, i + 1).toString();
      paramString = (String)localObject;
      if (!n.U((String)localObject, "<", false))
      {
        i = n.a((CharSequence)localObject, ":", 0, false, 6);
        paramString = (String)localObject;
        if (i != -1)
        {
          if (localObject == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(236024);
            throw paramString;
          }
          paramString = ((String)localObject).substring(i + 1);
          s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        }
      }
      Map localMap = XmlParser.parseXml(paramString, "msg", null);
      if (localMap == null)
      {
        Log.e("MicroMsg.OpenIMKefuContactCardContent", "alvinluo kefuCard parse xml invalid");
        AppMethodBeat.o(236024);
        return null;
      }
      try
      {
        localObject = (String)localMap.get(".msg.$username");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.username = paramString;
        localObject = (String)localMap.get(".msg.$nickname");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.nickName = paramString;
        localObject = (String)localMap.get(".msg.$sex");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        locale.sex = Util.getInt(paramString, 0);
        localObject = (String)localMap.get(".msg.$bigheadimgurl");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.nnS = paramString;
        localObject = (String)localMap.get(".msg.$smallheadimgurl");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.prO = paramString;
        localObject = (String)localMap.get(".msg.$openimappid");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.prP = paramString;
        localObject = (String)localMap.get(".msg.$openimdesc");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.prR = paramString;
        localObject = (String)localMap.get(".msg.$openimdescicon");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.prQ = paramString;
        localObject = (String)localMap.get(".msg.$ticket");
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        s.u(paramString, "<set-?>");
        locale.hFb = paramString;
        Log.i("MicroMsg.OpenIMKefuContactCardContent", "alvinluo kefuCard parse user: " + locale.username + ", headImageUrl: " + locale.nnS + ", " + locale.prO + ", ticket: " + locale.hFb);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.OpenIMKefuContactCardContent", (Throwable)paramString, "alvinluo kefuCard parse exception", new Object[0]);
        }
      }
      AppMethodBeat.o(236024);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.a.e
 * JD-Core Version:    0.7.0.1
 */