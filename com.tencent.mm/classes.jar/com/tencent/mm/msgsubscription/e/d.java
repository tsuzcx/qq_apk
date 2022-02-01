package com.tencent.mm.msgsubscription.e;

import com.tencent.e.h;
import com.tencent.e.i;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask;", "Lcom/tencent/mm/msgsubscription/task/BaseSubscribeMsgTask;", "username", "", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", "bizUsername", "(Ljava/lang/String;)V", "mCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getType", "", "run", "", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final d.a mqL;
  private String appId;
  private String extInfo;
  private String moV;
  private com.tencent.mm.msgsubscription.d.a mpb;
  private ArrayList<String> mpy;
  private com.tencent.mm.msgsubscription.api.a mqF;
  
  static
  {
    AppMethodBeat.i(208280);
    mqL = new d.a((byte)0);
    AppMethodBeat.o(208280);
  }
  
  private d(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(208272);
    this.moV = "";
    this.appId = "";
    this.mpy = new ArrayList();
    this.extInfo = "";
    AppMethodBeat.o(208272);
  }
  
  public d(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, com.tencent.mm.msgsubscription.d.a parama, com.tencent.mm.msgsubscription.api.a parama1)
  {
    this(paramString1);
    AppMethodBeat.i(208277);
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
      p.k(paramString1, "<set-?>");
      this.fOX = paramString1;
      this.appId = paramString2;
      this.mpb = parama;
      this.mqF = parama1;
      this.moV = paramString3;
      this.mpy.addAll((Collection)paramList);
      this.extInfo = paramString4;
      AppMethodBeat.o(208277);
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
    AppMethodBeat.i(208268);
    Object localObject = new b(this);
    int i;
    b.a.a locala;
    if (((CharSequence)this.appId).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      locala = b.a.mpa;
    }
    for (localObject = b.a.a.a("", this.appId, this.moV, (List)this.mpy, this.extInfo, (b.c)localObject);; localObject = b.a.a.a(this.fOX, "", this.moV, (List)this.mpy, this.extInfo, (b.c)localObject))
    {
      d((b)localObject);
      AppMethodBeat.o(208268);
      return;
      i = 0;
      break;
      label84:
      locala = b.a.mpa;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/task/GetSubscribeListForDialogTask$run$callback$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
  public static final class b
    implements b.c
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(219353);
      p.k(paramString, "errMsg");
      Log.i("MicroMsg.GetSubscribeMsgListForDialogTask", "alvinluo getSubscribeMsgListForDialogTask end errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.ZvG.bc((Runnable)new a(this, paramInt1, paramInt2, paramSubscribeMsgRequestResult, paramString));
      AppMethodBeat.o(219353);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb, int paramInt1, int paramInt2, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, String paramString) {}
      
      public final void run()
      {
        AppMethodBeat.i(197794);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          locala = d.a(this.mqN.mqM);
          if (locala != null)
          {
            String str = this.mqN.mqM.fOX;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            if (localSubscribeMsgRequestResult == null) {
              p.iCn();
            }
            locala.a(str, localSubscribeMsgRequestResult);
            AppMethodBeat.o(197794);
            return;
          }
          AppMethodBeat.o(197794);
          return;
        }
        com.tencent.mm.msgsubscription.api.a locala = d.a(this.mqN.mqM);
        if (locala != null)
        {
          locala.i(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(197794);
          return;
        }
        AppMethodBeat.o(197794);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.e.d
 * JD-Core Version:    0.7.0.1
 */