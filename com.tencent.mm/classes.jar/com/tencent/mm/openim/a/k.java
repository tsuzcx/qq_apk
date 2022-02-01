package com.tencent.mm.openim.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuConversationLogic;", "", "()V", "TAG", "", "THREAD_LOOP_TAG", "checkKefuConversationExistByUsername", "", "username", "deleteAllOpenImKefuConversation", "", "doFillParentConversationInfo", "talker", "lastOfMsg", "Lcom/tencent/mm/storage/MsgInfo;", "parentConv", "Lcom/tencent/mm/storage/Conversation;", "fillParentConversationInfo", "cvs", "getLastOpenImKefuConversation", "isKefuConversationExist", "url", "parseMsgContentTitle", "type", "", "msgContent", "updateOpenImKfServiceConversation", "childCvs", "isValidMsg", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k psg;
  
  static
  {
    AppMethodBeat.i(236118);
    psg = new k();
    AppMethodBeat.o(236118);
  }
  
  public static final void RE(String paramString)
  {
    AppMethodBeat.i(236061);
    s.u(paramString, "username");
    Object localObject = bSe();
    if (localObject == null)
    {
      AppMethodBeat.o(236061);
      return;
    }
    if (!paramString.equals(((bd)localObject).field_username))
    {
      Log.i("MicroMsg.OpenIMKefuConversationLogic", "alvinluo updateOpenImKfServiceConversation %s not the last conversation and ignore", new Object[] { paramString });
      AppMethodBeat.o(236061);
      return;
    }
    bb localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("opencustomerservicemsg");
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(((bd)localObject).field_username);
    if ((localObject != null) && (az((cc)localObject) == true)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (localbb != null))
      {
        Log.i("MicroMsg.OpenIMKefuConversationLogic", "alvinluo updateOpenImKfServiceConversation username: %s, lastMsg talker: %s", new Object[] { paramString, ((fi)localObject).field_talker });
        paramString = localbb.field_username;
        s.s(paramString, "parentConv.username");
        s.s(localObject, "lastMsg");
        a(paramString, (cc)localObject, localbb);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(localbb, "opencustomerservicemsg");
      }
      AppMethodBeat.o(236061);
      return;
    }
  }
  
  public static final boolean RQ(String paramString)
  {
    AppMethodBeat.i(236103);
    Object localObject = g.RN(paramString);
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((c)localObject).field_username;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label70;
      }
    }
    label70:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.OpenIMKefuConversationLogic", "isKefuConversationExist contact invalid url: %s", new Object[] { paramString });
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(236103);
      return false;
    }
    localObject = ((c)localObject).field_username;
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    boolean bool = RR(paramString);
    AppMethodBeat.o(236103);
    return bool;
  }
  
  public static final boolean RR(String paramString)
  {
    AppMethodBeat.i(236109);
    s.u(paramString, "username");
    bb localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(paramString);
    if (localbb != null)
    {
      CharSequence localCharSequence = (CharSequence)localbb.field_username;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label95;
      }
    }
    label95:
    for (int i = 1; (i != 0) || (!localbb.field_username.equals(paramString)); i = 0)
    {
      Log.e("MicroMsg.OpenIMKefuConversationLogic", "isKefuConversationExist conv invalid username: %s", new Object[] { paramString });
      AppMethodBeat.o(236109);
      return false;
    }
    AppMethodBeat.o(236109);
    return true;
  }
  
  private static String Z(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(236096);
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = localObject2;
      if (paramInt == 49)
      {
        paramString = XmlParser.parseXml(paramString, "msg", null);
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject1 = (String)paramString.get(".msg.appmsg.title");
          Log.d("MicroMsg.OpenIMKefuConversationLogic", "parseConversationMsgContentTitle title:%s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(236096);
    return localObject1;
  }
  
  private static void a(bb parambb1, bb parambb2)
  {
    AppMethodBeat.i(236085);
    bb localbb = bSe();
    cc localcc = null;
    if (localbb != null)
    {
      Log.e("MicroMsg.OpenIMKefuConversationLogic", "fillParentConversationInfo the lastest openim kefu conversation username is %s", new Object[] { localbb.field_username });
      localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(localbb.field_username);
      parambb1 = localbb.field_parentRef;
      s.s(parambb1, "lastConv.parentRef");
    }
    for (;;)
    {
      if ((localcc != null) && (az(localcc) == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label155;
        }
        a(parambb1, localcc, parambb2);
        AppMethodBeat.o(236085);
        return;
        if (parambb1 == null) {
          break label172;
        }
        Log.e("MicroMsg.OpenIMKefuConversationLogic", "fillParentConversationInfo the lastest openim kefu conversation is null");
        localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(parambb1.field_username);
        parambb1 = parambb1.field_parentRef;
        s.s(parambb1, "cvs.parentRef");
        break;
      }
      label155:
      Log.e("MicroMsg.OpenIMKefuConversationLogic", "the last of msg is invalid");
      parambb2.jaJ();
      AppMethodBeat.o(236085);
      return;
      label172:
      parambb1 = "";
    }
  }
  
  private static void a(String paramString, cc paramcc, bb parambb)
  {
    AppMethodBeat.i(236091);
    if (parambb == null)
    {
      AppMethodBeat.o(236091);
      return;
    }
    parambb.bG(paramcc);
    parambb.BE(String.valueOf(paramcc.getType()));
    parambb.setContent(paramcc.field_talker + ':' + paramcc.field_content);
    Log.v("MicroMsg.OpenIMKefuConversationLogic", "alvinluo doFillParentConversationInfo msg.content: %s", new Object[] { paramcc.field_content });
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().aDH();
    PString localPString1;
    PInt localPInt;
    String str2;
    int i;
    String str1;
    if (localObject != null)
    {
      PString localPString2 = new PString();
      localPString1 = new PString();
      localPInt = new PInt();
      str2 = paramcc.field_talker;
      paramcc.BS(paramString);
      paramcc.setContent(parambb.field_content);
      ((by.b)localObject).a(paramcc, localPString2, localPString1, localPInt, true);
      localObject = (CharSequence)localPString1.value;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label368;
      }
      i = 1;
      if (i != 0) {
        localPString1.value = str2;
      }
      i = paramcc.getType();
      localObject = paramcc.field_content;
      s.s(localObject, "lastOfMsg.content");
      str1 = Z(i, (String)localObject);
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      str1 = Util.nullAsNil(localPString2.value);
      if (((CharSequence)localObject).length() != 0) {
        break label373;
      }
      i = 1;
      label272:
      if (i == 0) {
        break label378;
      }
    }
    label368:
    label373:
    label378:
    for (localObject = "";; localObject = s.X(" ", localObject))
    {
      parambb.BF(s.X(str1, localObject));
      parambb.BG(localPString1.value);
      parambb.pJ(localPInt.value);
      Log.i("MicroMsg.OpenIMKefuConversationLogic", "alvinluo doFillParentConversationInfo talker: %s, msgType: %s, digest: %s, digestUser: %s, parenConv: %s, lastOfMsgTalker: %s", new Object[] { paramString, Integer.valueOf(paramcc.getType()), parambb.field_digest, parambb.field_digestUser, parambb.field_username, str2 });
      AppMethodBeat.o(236091);
      return;
      i = 0;
      break;
      i = 0;
      break label272;
    }
  }
  
  private static boolean az(cc paramcc)
  {
    return (paramcc != null) && (paramcc.field_msgId > 0L);
  }
  
  public static final void bSd()
  {
    AppMethodBeat.i(236073);
    com.tencent.threadpool.h.ahAA.j(k..ExternalSyntheticLambda0.INSTANCE, "kefu_conversation_logic_thread");
    AppMethodBeat.o(236073);
  }
  
  private static bb bSe()
  {
    AppMethodBeat.i(236077);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(6, null, "opencustomerservicemsg");
    bb localbb;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localbb = new bb();
        localbb.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236077);
      return localbb;
      localbb = null;
      break;
      localbb = null;
    }
  }
  
  private static final void bSf()
  {
    AppMethodBeat.i(236115);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(6, null, "opencustomerservicemsg");
    if (localObject == null)
    {
      AppMethodBeat.o(236115);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    bb localbb;
    if (((Cursor)localObject).moveToFirst())
    {
      localbb = new bb();
      localbb.convertFrom((Cursor)localObject);
      CharSequence localCharSequence = (CharSequence)localbb.field_username;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label201;
      }
    }
    label201:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localLinkedList.add(localbb.field_username);
      }
      if ((((Cursor)localObject).moveToNext()) && (!((Cursor)localObject).isAfterLast())) {
        break;
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.OpenIMKefuConversationLogic", "alvinluo deleteAllOpenImKefuConversation conversation list size: %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      localObject = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject).hasNext()) {
        br.a((String)((Iterator)localObject).next(), (br.a)new a());
      }
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().cv(localLinkedList);
    AppMethodBeat.o(236115);
  }
  
  public static final void d(bb parambb)
  {
    AppMethodBeat.i(236068);
    bb localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("opencustomerservicemsg");
    if (localbb == null)
    {
      Log.i("MicroMsg.OpenIMKefuConversationLogic", "create openim kefu service conversation");
      localbb = new bb("opencustomerservicemsg");
      localbb.jaJ();
      a(parambb, localbb);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().h(localbb);
      AppMethodBeat.o(236068);
      return;
    }
    Log.i("MicroMsg.OpenIMKefuConversationLogic", "openim kefu service conversation has created");
    localbb.BH(null);
    a(parambb, localbb);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(localbb, "opencustomerservicemsg");
    AppMethodBeat.o(236068);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKefuConversationLogic$deleteAllOpenImKefuConversation$1$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements br.a
  {
    public final boolean aMJ()
    {
      return false;
    }
    
    public final void aMK() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.k
 * JD-Core Version:    0.7.0.1
 */