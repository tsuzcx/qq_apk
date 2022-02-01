package com.tencent.mm.openim.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.openim.api.c.a;
import com.tencent.mm.openim.api.c.b;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.api.k.a;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuGetContactService;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MAX_TRY_LIMIT", "", "OPEN_IM_KEFU_GET_CONTACT_THREAD_TAG", "", "TAG", "debugConfirmType", "Ljava/lang/Integer;", "getContactCallbackMap", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getContactCount", "Lcom/tencent/mm/algorithm/LRUMap;", "gettingUsernameSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "opContactRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/openim/api/OpenIMKefuOpContactRequest;", "addContact", "", "request", "addGetContactCallback", "username", "callBack", "checkAddGetContactTask", "checkLimit", "", "task", "Lkotlin/Function0;", "closeContact", "callback", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "doGetContact", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactRequest;", "getContact", "getContactFromLocal", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "getContactFromRemote", "init", "onGetContactEnd", "contact", "resp", "Lcom/tencent/mm/protocal/protobuf/GetOpenIMKefuContactResp;", "errType", "errCode", "errMsg", "onOpContactEnd", "success", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "opContact", "release", "replaceContact", "runTask", "Ljava/lang/Runnable;", "setDebugConfirmType", "confirmType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h
{
  public static final l psh;
  private static Integer psi;
  private static final com.tencent.mm.b.f<String, Integer> psj;
  private static HashSet<String> psk;
  private static HashMap<String, ArrayList<c.a>> psl;
  private static ConcurrentHashMap<String, com.tencent.mm.openim.api.k> psm;
  
  static
  {
    AppMethodBeat.i(236137);
    psh = new l();
    psj = (com.tencent.mm.b.f)new com.tencent.mm.memory.a.c(200);
    psk = new HashSet();
    psl = new HashMap();
    psm = new ConcurrentHashMap();
    AppMethodBeat.o(236137);
  }
  
  public static final c RS(String paramString)
  {
    AppMethodBeat.i(236069);
    paramString = g.RL(paramString);
    AppMethodBeat.o(236069);
    return paramString;
  }
  
  private static final void a(c.a parama, String paramString)
  {
    AppMethodBeat.i(236119);
    if (parama != null) {
      parama.RF(paramString);
    }
    AppMethodBeat.o(236119);
  }
  
  public static final void a(com.tencent.mm.openim.api.i parami, c.a parama)
  {
    AppMethodBeat.i(236064);
    if (parami == null)
    {
      AppMethodBeat.o(236064);
      return;
    }
    Object localObject = parami.prk;
    Log.i("MicroMsg.OpenIMKefuGetContactService", "alvinluo getContact start username: " + localObject + ", needGetFromRemote: " + parami.prm);
    parama = new a(parama);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.a(null);
      AppMethodBeat.o(236064);
      return;
    }
    localObject = g.RL((String)localObject);
    if ((localObject != null) && (((c)localObject).maN != 0L))
    {
      localCharSequence = (CharSequence)((c)localObject).field_nickname;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label174;
      }
      i = 1;
    }
    while (i != 0) {
      if (parami.prm)
      {
        c(parami, (c.a)parama);
        AppMethodBeat.o(236064);
        return;
        label174:
        i = 0;
      }
      else
      {
        parama.a(null);
        AppMethodBeat.o(236064);
        return;
      }
    }
    parami = new j();
    parami.prp = ((com.tencent.mm.openim.api.a)localObject);
    localObject = ah.aiuX;
    parama.a(parami);
    AppMethodBeat.o(236064);
  }
  
  private static final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, c paramc, cou paramcou)
  {
    AppMethodBeat.i(236130);
    kotlin.g.b.s.u(paramString1, "$username");
    psk.remove(paramString1);
    paramString1 = (ArrayList)psl.remove(paramString1);
    com.tencent.threadpool.h.ahAA.bk(new l..ExternalSyntheticLambda3(paramString1, paramInt1, paramInt2, paramString2, paramc, paramcou));
    AppMethodBeat.o(236130);
  }
  
  private static void a(String paramString1, c paramc, cou paramcou, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(236107);
    Log.v("MicroMsg.OpenIMKefuGetContactService", kotlin.g.b.s.X("alvinluo onGetContactEnd username: ", paramString1));
    y(new l..ExternalSyntheticLambda1(paramString1, paramInt1, paramInt2, paramString2, paramc, paramcou));
    AppMethodBeat.o(236107);
  }
  
  private static void a(String paramString, boolean paramBoolean, c.a parama, kotlin.g.a.a<ah> parama1)
  {
    AppMethodBeat.i(236101);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.OpenIMKefuGetContactService", "alvinluo checkAddGetContactTask username invalid");
      if (parama != null) {
        parama.a(null);
      }
      AppMethodBeat.o(236101);
      return;
    }
    y(new l..ExternalSyntheticLambda2(paramString, paramBoolean, parama, parama1));
    AppMethodBeat.o(236101);
  }
  
  private static final void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, c paramc, cou paramcou)
  {
    AppMethodBeat.i(236125);
    if (paramArrayList != null)
    {
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      if (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        j localj = new j();
        localj.errType = paramInt1;
        localj.errCode = paramInt2;
        localj.errMsg = paramString;
        localj.prp = ((com.tencent.mm.openim.api.a)paramc);
        int i;
        if ((BuildInfo.DEBUG) && (psi != null))
        {
          paramArrayList = psi;
          kotlin.g.b.s.checkNotNull(paramArrayList);
          i = paramArrayList.intValue();
          label106:
          localj.prq = i;
          if (paramcou != null) {
            break label165;
          }
          paramArrayList = "";
        }
        for (;;)
        {
          localj.prr = paramArrayList;
          paramArrayList = ah.aiuX;
          locala.a(localj);
          break;
          if (paramcou == null)
          {
            i = 3;
            break label106;
          }
          i = paramcou.xld;
          break label106;
          label165:
          String str = paramcou.aavK;
          paramArrayList = str;
          if (str == null) {
            paramArrayList = "";
          }
        }
      }
    }
    AppMethodBeat.o(236125);
  }
  
  private static void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(236111);
    String str = "";
    Bundle localBundle = new Bundle();
    if ((paramp instanceof com.tencent.mm.openim.model.c))
    {
      str = ((com.tencent.mm.openim.model.c)paramp).username;
      if (!paramBoolean) {
        break label208;
      }
      localBundle.putInt("key_op_contact_result_source", ((com.tencent.mm.openim.model.c)paramp).source);
    }
    label174:
    label201:
    label208:
    for (;;)
    {
      if (paramp == null) {}
      for (paramp = null;; paramp = Integer.valueOf(paramp.getType()))
      {
        Log.i("MicroMsg.OpenIMKefuGetContactService", "alvinluo onOpContactEnd success: %s, type: %s, key: %s", new Object[] { Boolean.valueOf(paramBoolean), paramp, str });
        paramp = (com.tencent.mm.openim.api.k)psm.remove(str);
        if (!paramBoolean) {
          break label174;
        }
        if (paramp == null) {
          break label201;
        }
        paramString = paramp.prt;
        if (paramString == null) {
          break label201;
        }
        paramString.bRY();
        AppMethodBeat.o(236111);
        return;
        if (!(paramp instanceof com.tencent.mm.openim.model.f)) {
          break;
        }
        str = ((com.tencent.mm.openim.model.f)paramp).prk;
        break;
      }
      if (paramp != null)
      {
        paramp = paramp.prt;
        if (paramp != null) {
          paramp.o(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(236111);
      return;
    }
  }
  
  public static final boolean a(c paramc)
  {
    AppMethodBeat.i(236078);
    kotlin.g.b.s.u(paramc, "contact");
    boolean bool = g.a(paramc);
    AppMethodBeat.o(236078);
    return bool;
  }
  
  public static final void b(com.tencent.mm.openim.api.k paramk)
  {
    AppMethodBeat.i(236087);
    kotlin.g.b.s.u(paramk, "request");
    paramk.opType = 1;
    c(paramk);
    AppMethodBeat.o(236087);
  }
  
  public static final void b(String paramString, c.b paramb)
  {
    AppMethodBeat.i(236082);
    Log.i("MicroMsg.OpenIMKefuGetContactService", kotlin.g.b.s.X("alvinluo closeContact username: ", paramString));
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new com.tencent.mm.openim.api.k(str);
    paramString.opType = 2;
    paramString.prt = paramb;
    c(paramString);
    AppMethodBeat.o(236082);
  }
  
  private static final void b(String paramString, boolean paramBoolean, c.a parama, kotlin.g.a.a parama1)
  {
    AppMethodBeat.i(236123);
    kotlin.g.b.s.u(parama1, "$task");
    Object localObject = (Integer)psj.ct(paramString);
    if (localObject == null) {}
    for (int i = 0; (paramBoolean) && (i >= 3); i = ((Integer)localObject).intValue())
    {
      Log.e("MicroMsg.OpenIMKefuGetContactService", "alvinluo checkAddTask getContact exceed limit: %s", new Object[] { paramString });
      if (parama != null) {
        parama.a(null);
      }
      AppMethodBeat.o(236123);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new l..ExternalSyntheticLambda0(parama, paramString));
    if ((ArrayList)psl.get(paramString) == null) {
      ((Map)psl).put(paramString, new ArrayList());
    }
    if (parama != null)
    {
      localObject = (ArrayList)psl.get(paramString);
      if (localObject != null) {
        ((ArrayList)localObject).add(parama);
      }
    }
    if (psk.contains(paramString))
    {
      Log.v("MicroMsg.OpenIMKefuGetContactService", "alvinluo checkAddTask username: " + paramString + " already running");
      AppMethodBeat.o(236123);
      return;
    }
    psj.B(paramString, Integer.valueOf(i + 1));
    parama1.invoke();
    AppMethodBeat.o(236123);
  }
  
  public static final void c(com.tencent.mm.openim.api.i parami, c.a parama)
  {
    AppMethodBeat.i(236074);
    kotlin.g.b.s.u(parami, "request");
    String str = parami.key;
    Log.d("MicroMsg.OpenIMKefuGetContactService", kotlin.g.b.s.X("alvinluo getContactFromRemote checkTryLimit: ", Boolean.valueOf(parami.prl)));
    a(str, parami.prl, parama, (kotlin.g.a.a)new b(parami));
    AppMethodBeat.o(236074);
  }
  
  private static void c(com.tencent.mm.openim.api.k paramk)
  {
    int j = 1;
    AppMethodBeat.i(236094);
    Object localObject = paramk.username;
    if (psm.containsKey(localObject))
    {
      Log.i("MicroMsg.OpenIMKefuGetContactService", kotlin.g.b.s.X("alvinluo opContact is already running key: ", localObject));
      AppMethodBeat.o(236094);
      return;
    }
    Log.i("MicroMsg.OpenIMKefuGetContactService", "alvinluo opContact username: " + (String)localObject + ", opType: " + paramk.opType);
    ((Map)psm).put(localObject, paramk);
    du localdu;
    if (paramk.opType == 1)
    {
      localdu = new du();
      localObject = paramk.hPH;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (localObject.length != 0) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        k.a locala;
        Log.printErrStackTrace("MicroMsg.OpenIMKefuGetContactService", (Throwable)localException, "alvinluo opContact exception", new Object[0]);
        continue;
      }
      if (i != 0) {
        localdu.parseFrom((byte[])localObject);
      }
      paramk = new com.tencent.mm.openim.model.c(paramk.username, localdu);
      com.tencent.mm.kernel.h.aZW().a((p)paramk, 0);
      AppMethodBeat.o(236094);
      return;
      locala = com.tencent.mm.openim.api.k.prs;
      localObject = ((Bundle)localObject).getByteArray(com.tencent.mm.openim.api.k.bSa());
      break;
      int i = 0;
      break label262;
      i = 0;
      continue;
      if (paramk.opType == 2)
      {
        paramk = new com.tencent.mm.openim.model.f(paramk.username);
        com.tencent.mm.kernel.h.aZW().a((p)paramk, 0);
      }
      AppMethodBeat.o(236094);
      return;
      label262:
      if (i == 0) {
        i = j;
      }
    }
  }
  
  public static void xG(int paramInt)
  {
    AppMethodBeat.i(236116);
    Log.d("MicroMsg.OpenIMKefuGetContactService", "alvinluo setDebugConfirmType: %s", new Object[] { Integer.valueOf(paramInt) });
    psi = Integer.valueOf(paramInt);
    AppMethodBeat.o(236116);
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(236113);
    kotlin.g.b.s.u(paramRunnable, "task");
    com.tencent.threadpool.h.ahAA.j(paramRunnable, "getOpenImKefuContact");
    AppMethodBeat.o(236113);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(236143);
    Object localObject2 = new StringBuilder("alvinluo onSceneEnd errType: ").append(paramInt1).append(", errCode: ").append(paramInt2).append(", errMsg: ").append(paramString).append(", type: ");
    if (paramp == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramp.getType()))
    {
      Log.i("MicroMsg.OpenIMKefuGetContactService", localObject1);
      if (!(paramp instanceof com.tencent.mm.openim.model.k)) {
        break label198;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      localObject1 = ((com.tencent.mm.openim.model.k)paramp).psv;
      localObject2 = ((com.tencent.mm.openim.model.k)paramp).psw;
      paramp = ((com.tencent.mm.openim.model.k)paramp).psx.key;
      kotlin.g.b.s.s(paramp, "scene.getRequest().key()");
      a(paramp, (c)localObject1, (cou)localObject2, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(236143);
      return;
    }
    paramp = ((com.tencent.mm.openim.model.k)paramp).psx.key;
    kotlin.g.b.s.s(paramp, "scene.getRequest().key()");
    a(paramp, null, null, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(236143);
    return;
    label198:
    if (((paramp instanceof com.tencent.mm.openim.model.c)) || ((paramp instanceof com.tencent.mm.openim.model.f)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(true, paramInt1, paramInt2, paramString, paramp);
        AppMethodBeat.o(236143);
        return;
      }
      a(false, paramInt1, paramInt2, paramString, paramp);
    }
    AppMethodBeat.o(236143);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKefuGetContactService$getContact$wrapCallback$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c.a
  {
    a(c.a parama) {}
    
    public final void RF(String paramString)
    {
      AppMethodBeat.i(236090);
      c.a locala = this.psn;
      if (locala != null) {
        locala.RF(paramString);
      }
      AppMethodBeat.o(236090);
    }
    
    public final void a(j paramj)
    {
      Object localObject = null;
      AppMethodBeat.i(236086);
      if (paramj == null) {}
      for (;;)
      {
        Log.i("MicroMsg.OpenIMKefuGetContactService", kotlin.g.b.s.X("alvinluo getContact finish! contact: ", localObject));
        localObject = this.psn;
        if (localObject != null) {
          ((c.a)localObject).a(paramj);
        }
        AppMethodBeat.o(236086);
        return;
        com.tencent.mm.openim.api.a locala = paramj.prp;
        if (locala != null) {
          localObject = locala.getUsername();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(com.tencent.mm.openim.api.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.l
 * JD-Core Version:    0.7.0.1
 */