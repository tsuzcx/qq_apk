package com.tencent.mm.msgsubscription.e;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final d.a jBc;
  private String appId;
  private String extInfo;
  private com.tencent.mm.msgsubscription.api.a jAX;
  private ArrayList<String> jzS;
  private String jzp;
  private com.tencent.mm.msgsubscription.d.a jzv;
  
  static
  {
    AppMethodBeat.i(223386);
    jBc = new d.a((byte)0);
    AppMethodBeat.o(223386);
  }
  
  private d(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(223384);
    this.jzp = "";
    this.appId = "";
    this.jzS = new ArrayList();
    this.extInfo = "";
    AppMethodBeat.o(223384);
  }
  
  public d(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString1);
    AppMethodBeat.i(223385);
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
      p.h(paramString1, "<set-?>");
      this.dVu = paramString1;
      this.appId = paramString2;
      this.jzv = parama;
      this.jAX = parama1;
      this.jzp = paramString3;
      this.jzS.addAll((Collection)paramList);
      this.extInfo = paramString4;
      AppMethodBeat.o(223385);
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
    AppMethodBeat.i(223383);
    Object localObject = new b(this);
    int i;
    b.a.a locala;
    if (((CharSequence)this.appId).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      locala = b.a.jzu;
    }
    for (localObject = b.a.a.a("", this.appId, this.jzp, (List)this.jzS, this.extInfo, (b.c)localObject);; localObject = b.a.a.a(this.dVu, "", this.jzp, (List)this.jzS, this.extInfo, (b.c)localObject))
    {
      d((b)localObject);
      AppMethodBeat.o(223383);
      return;
      i = 0;
      break;
      label84:
      locala = b.a.jzu;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask$run$callback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223382);
      p.h(paramString, "errMsg");
      Log.i("MicroMsg.GetSubscribeMsgListForDialogTask", "alvinluo getSubscribeMsgListForDialogTask end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.RTc.aV((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(223382);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(223381);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = d.a(this.jBe.jBd);
          if (locala != null)
          {
            String str = this.jBe.jBd.dVu;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.hyc();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(223381);
            return;
          }
          AppMethodBeat.o(223381);
          return;
        }
        com.tencent.mm.msgsubscription.api.a locala = d.a(this.jBe.jBd);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(223381);
          return;
        }
        AppMethodBeat.o(223381);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.d
 * JD-Core Version:    0.7.0.1
 */