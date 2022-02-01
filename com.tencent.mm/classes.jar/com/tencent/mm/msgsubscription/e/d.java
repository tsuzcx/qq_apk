package com.tencent.mm.msgsubscription.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getType", "", "run", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a pko;
  private String appId;
  private String extInfo;
  private String piK;
  private com.tencent.mm.msgsubscription.d.a piQ;
  private ArrayList<String> pjo;
  private com.tencent.mm.msgsubscription.api.a pkl;
  
  static
  {
    AppMethodBeat.i(236409);
    pko = new d.a((byte)0);
    AppMethodBeat.o(236409);
  }
  
  private d(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(236389);
    this.piK = "";
    this.appId = "";
    this.pjo = new ArrayList();
    this.extInfo = "";
    AppMethodBeat.o(236389);
  }
  
  public d(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString1);
    AppMethodBeat.i(236395);
    int i;
    if (((CharSequence)paramString1).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label126;
      }
    }
    for (;;)
    {
      s.u(paramString1, "<set-?>");
      this.hUQ = paramString1;
      this.appId = paramString2;
      this.piQ = parama;
      this.pkl = parama1;
      this.piK = paramString3;
      this.pjo.addAll((Collection)paramList);
      this.extInfo = paramString4;
      AppMethodBeat.o(236395);
      return;
      i = 0;
      break;
      label126:
      if (((CharSequence)paramString2).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label157;
        }
        paramString1 = paramString2;
        break;
      }
      label157:
      paramString1 = "";
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(236418);
    Object localObject = new b(this);
    int i;
    b.a.a locala;
    if (((CharSequence)this.appId).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      locala = b.a.piO;
    }
    for (localObject = b.a.a.a("", this.appId, this.piK, (List)this.pjo, this.extInfo, (b.c)localObject);; localObject = b.a.a.a(this.hUQ, "", this.piK, (List)this.pjo, this.extInfo, (b.c)localObject))
    {
      d((b)localObject);
      AppMethodBeat.o(236418);
      return;
      i = 0;
      break;
      label84:
      locala = b.a.piO;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask$run$callback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.c
  {
    b(d paramd) {}
    
    private static final void a(int paramInt1, int paramInt2, d paramd, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString)
    {
      AppMethodBeat.i(236456);
      s.u(paramd, "this$0");
      s.u(paramString, "$errMsg");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = d.a(paramd);
        if (paramString != null)
        {
          paramd = paramd.hUQ;
          s.checkNotNull(paramSubscribeMsgRequestResult);
          paramString.a(paramd, paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236456);
        }
      }
      else
      {
        paramd = d.a(paramd);
        if (paramd != null) {
          paramd.j(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(236456);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236474);
      s.u(paramString, "errMsg");
      Log.i("MicroMsg.GetSubscribeMsgListForDialogTask", "alvinluo getSubscribeMsgListForDialogTask end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.ahAA.bk(new d.b..ExternalSyntheticLambda0(paramInt1, paramInt2, this.pkp, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(236474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.d
 * JD-Core Version:    0.7.0.1
 */