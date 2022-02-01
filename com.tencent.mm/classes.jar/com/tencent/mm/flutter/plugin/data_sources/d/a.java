package com.tencent.mm.flutter.plugin.data_sources.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.e;
import com.tencent.mm.flutter.plugin.a.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/sns/SnsDataSource;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "username", "", "(Ljava/lang/String;)V", "isSelf", "", "snsDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/flutter/plugin/proto/GetSnsResponse;", "", "timeLimit", "", "getUsername", "()Ljava/lang/String;", "getImageFile", "localId", "snsId", "mediaId", "requestThumb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestSnsInfo", "callback", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "toSnsDataType", "Lcom/tencent/mm/flutter/plugin/data_sources/sns/SnsDataSource$SnsDataType;", "toSnsItem", "Lcom/tencent/mm/flutter/plugin/proto/SnsItem;", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "Companion", "SnsDataType", "SnsMediaType", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a.a mrE;
  public final boolean hHq;
  public long ibE;
  public kotlin.g.a.b<? super e, ah> mrF;
  public final String username;
  
  static
  {
    AppMethodBeat.i(233402);
    mrE = new a.a((byte)0);
    AppMethodBeat.o(233402);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(233382);
    this.username = paramString;
    this.hHq = kotlin.g.b.s.p(this.username, z.bAM());
    AppMethodBeat.o(233382);
  }
  
  private static g a(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(233398);
    if (kotlin.a.p.listOf(new Integer[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(15) }).contains(Integer.valueOf(paramSnsInfo.getTypeFlag())))
    {
      int j = paramSnsInfo.getCreateTime();
      switch (paramSnsInfo.getTypeFlag())
      {
      default: 
        localObject1 = a.b.mrJ;
      }
      TimeLineObject localTimeLineObject;
      for (;;)
      {
        localTimeLineObject = paramSnsInfo.getTimeLine();
        if (localTimeLineObject != null) {
          break;
        }
        AppMethodBeat.o(233398);
        return null;
        localObject1 = a.b.mrG;
        continue;
        localObject1 = a.b.mrH;
        continue;
        localObject1 = a.b.mrI;
      }
      String str = localTimeLineObject.ContentDesc;
      Object localObject2 = localTimeLineObject.ContentObj;
      if (localObject2 == null)
      {
        AppMethodBeat.o(233398);
        return null;
      }
      Object localObject3 = ((agh)localObject2).Zpr;
      if (localObject3 == null)
      {
        AppMethodBeat.o(233398);
        return null;
      }
      localObject2 = new ArrayList();
      int i;
      if (!((Collection)localObject3).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        dmz localdmz;
        com.tencent.mm.flutter.plugin.a.h localh;
        if (localObject1 == a.b.mrH)
        {
          localObject3 = ((LinkedList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localdmz = (dmz)((Iterator)localObject3).next();
            if (localdmz.vhJ == 2)
            {
              localh = new com.tencent.mm.flutter.plugin.a.h();
              localh.mediaId = localdmz.Id;
              localh.mediaType = a.c.mrL.ordinal();
              ((ArrayList)localObject2).add(localh);
            }
          }
          i = 0;
        }
        else if (localObject1 == a.b.mrI)
        {
          localObject3 = ((LinkedList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localdmz = (dmz)((Iterator)localObject3).next();
            if ((localdmz.vhJ == 4) || (localdmz.vhJ == 6))
            {
              localh = new com.tencent.mm.flutter.plugin.a.h();
              localh.mediaId = localdmz.Id;
              localh.mediaType = a.c.mrM.ordinal();
              ((ArrayList)localObject2).add(localh);
            }
          }
        }
      }
      localObject3 = new g();
      ((g)localObject3).msd = (j * 1000L);
      ((g)localObject3).type = ((a.b)localObject1).ordinal();
      ((g)localObject3).desc = str;
      ((g)localObject3).msn = new LinkedList();
      ((g)localObject3).hQX = paramSnsInfo.getSnsId();
      ((g)localObject3).hHB = paramSnsInfo.getLocalid();
      Object localObject1 = localTimeLineObject.Id;
      paramSnsInfo = (SnsInfo)localObject1;
      if (localObject1 == null) {
        paramSnsInfo = "";
      }
      ((g)localObject3).mso = paramSnsInfo;
      paramSnsInfo = (CharSequence)localTimeLineObject.Location.poiName;
      if ((paramSnsInfo == null) || (paramSnsInfo.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label566;
        }
        localObject1 = localTimeLineObject.Location.pSh;
        paramSnsInfo = (SnsInfo)localObject1;
        if (localObject1 != null) {}
      }
      label566:
      for (paramSnsInfo = "";; paramSnsInfo = localTimeLineObject.Location.poiName)
      {
        ((g)localObject3).mse = paramSnsInfo;
        ((g)localObject3).msn.addAll((Collection)localObject2);
        AppMethodBeat.o(233398);
        return localObject3;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(233398);
    return null;
  }
  
  public static Object a(String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, d<? super String> paramd)
  {
    AppMethodBeat.i(233389);
    paramString1 = l.a((f)bg.kCi(), (m)new d(paramString1, paramString2, paramString3, paramBoolean, null), paramd);
    AppMethodBeat.o(233389);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(233406);
    int i;
    if ((paramp != null) && (paramp.getType() == 212)) {
      i = 1;
    }
    while (i != 0)
    {
      com.tencent.mm.kernel.h.baD().mCm.b(212, (com.tencent.mm.am.h)this);
      Log.i("MicroMsg.SnsDataSource", "on snsUserPage sceneEnd, errType:" + paramInt1 + ", errCode:" + paramInt2);
      long l = System.currentTimeMillis();
      paramInt1 = (int)((l - this.ibE) / 1000.0D);
      paramInt2 = (int)(l / 1000L);
      Object localObject1 = al.hgB().a(true, this.username, 0, this.hHq, "", paramInt1, paramInt2);
      paramp = new e();
      paramp.msl = new LinkedList();
      paramString = (Closeable)localObject1;
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          do
          {
            Object localObject3 = new SnsInfo();
            ((SnsInfo)localObject3).convertFrom((Cursor)localObject1);
            localObject3 = a((SnsInfo)localObject3);
            if (localObject3 != null) {
              paramp.msl.add(localObject3);
            }
          } while (((Cursor)localObject1).moveToNext());
          Log.i("MicroMsg.SnsDataSource", kotlin.g.b.s.X("final dataList size:", Integer.valueOf(paramp.msl.size())));
          localObject1 = this.mrF;
          if (localObject1 != null)
          {
            ((kotlin.g.a.b)localObject1).invoke(paramp);
            paramp = ah.aiuX;
          }
        }
        for (;;)
        {
          kotlin.f.b.a(paramString, null);
          AppMethodBeat.o(233406);
          return;
          i = 0;
          break;
          localObject1 = this.mrF;
          if (localObject1 != null)
          {
            ((kotlin.g.a.b)localObject1).invoke(paramp);
            paramp = ah.aiuX;
          }
        }
        AppMethodBeat.o(233406);
      }
      finally
      {
        try
        {
          AppMethodBeat.o(233406);
          throw paramp;
        }
        finally
        {
          kotlin.f.b.a(paramString, paramp);
          AppMethodBeat.o(233406);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super String>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    d(String paramString1, String paramString2, String paramString3, boolean paramBoolean, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233392);
      paramObject = (d)new d(this.mrO, paramString2, paramString3, paramBoolean, paramd);
      AppMethodBeat.o(233392);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(233383);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233383);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.SnsDataSource", "getImageFile(" + this.mrO + ", " + paramString2 + ", " + paramString3 + "), requestThumb:" + paramBoolean);
        paramObject = al.hgB().aZL(this.mrO);
        if (paramObject == null)
        {
          Log.e("MicroMsg.SnsDataSource", kotlin.g.b.s.X("Couldn't find SnsInfo, localId=", this.mrO));
          AppMethodBeat.o(233383);
          return null;
        }
        paramObject = paramObject.getTimeLine();
        if (paramObject == null) {
          paramObject = null;
        }
        while (paramObject == null)
        {
          Log.e("MicroMsg.SnsDataSource", "Couldn't find media, localId=" + this.mrO + ", mediaId=" + paramString3);
          AppMethodBeat.o(233383);
          return null;
          paramObject = paramObject.ContentObj;
          if (paramObject == null)
          {
            paramObject = null;
          }
          else
          {
            paramObject = paramObject.Zpr;
            if (paramObject == null)
            {
              paramObject = null;
            }
            else
            {
              paramObject = (Iterable)paramObject;
              localObject1 = paramString3;
              localObject2 = paramObject.iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramObject = ((Iterator)localObject2).next();
              } while (!kotlin.g.b.s.p(((dmz)paramObject).Id, localObject1));
              for (;;)
              {
                paramObject = (dmz)paramObject;
                break;
                paramObject = null;
              }
            }
          }
        }
        if (paramBoolean) {}
        for (localObject1 = t.d(paramObject);; localObject1 = t.k(paramObject))
        {
          localObject2 = y.n(kotlin.g.b.s.X(as.mg(al.getAccSnsPath(), paramObject.Id), localObject1), false);
          if ((!y.ZC((String)localObject2)) || (!t.S(t.aXw((String)localObject2)))) {
            break;
          }
          Log.i("MicroMsg.SnsDataSource", kotlin.g.b.s.X("photo has already been downloaded: ", localObject2));
          AppMethodBeat.o(233383);
          return localObject2;
        }
        localObject3 = new com.tencent.mm.plugin.sns.data.p(paramObject);
        if (paramBoolean)
        {
          ((com.tencent.mm.plugin.sns.data.p)localObject3).QnY = 1;
          if (paramObject.vhJ != 6) {
            break label630;
          }
          i = 5;
        }
        break;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.sns.data.p)localObject3).hOG = paramObject.Id;
        localObject1 = al.hgw();
        Log.i("MicroMsg.SnsDataSource", "start downloading mediaId=" + paramObject.Id + ", snsId=" + paramString2);
        ((com.tencent.mm.plugin.sns.model.c)localObject1).a(paramObject, i, (com.tencent.mm.plugin.sns.data.p)localObject3, br.adjZ);
        this.L$0 = paramObject;
        this.Uf = localObject2;
        this.VC = localObject1;
        this.label = 1;
        localObject3 = new q(kotlin.d.a.b.au((d)this), 1);
        ((q)localObject3).kBA();
        final kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject3;
        paramObject = new b(paramObject, (String)localObject2, (com.tencent.mm.plugin.sns.model.c)localObject1, localp);
        ((com.tencent.mm.plugin.sns.model.c)localObject1).a((c.b)paramObject);
        localp.bg((kotlin.g.a.b)new a((com.tencent.mm.plugin.sns.model.c)localObject1, paramObject));
        localObject1 = ((q)localObject3).getResult();
        if (localObject1 == kotlin.d.a.a.aiwj) {
          kotlin.g.b.s.u((d)this, "frame");
        }
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(233383);
          return locala;
          ((com.tencent.mm.plugin.sns.data.p)localObject3).QnY = 3;
          i = 2;
          continue;
          ResultKt.throwOnFailure(paramObject);
        }
        else
        {
          AppMethodBeat.o(233383);
          return paramObject;
          label630:
          i = 1;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Throwable, ah>
    {
      a(com.tencent.mm.plugin.sns.model.c paramc, a.d.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/flutter/plugin/data_sources/sns/SnsDataSource$getImageFile$2$1$listener$1", "Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "onImageFinish", "", "mediaId", "", "isOk", "", "onSetbg", "onSightFinish", "onThumbFinish", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements c.b
    {
      b(dmz paramdmz, String paramString, com.tencent.mm.plugin.sns.model.c paramc, kotlinx.coroutines.p<? super String> paramp) {}
      
      public final void EE(String paramString)
      {
        AppMethodBeat.i(233387);
        kotlin.g.b.s.u(paramString, "mediaId");
        Log.i("MicroMsg.SnsDataSource", kotlin.g.b.s.X("onThumbFinish:", paramString));
        if (kotlin.g.b.s.p(paramString, this.mrU.Id))
        {
          Log.i("MicroMsg.SnsDataSource", kotlin.g.b.s.X("onThumbFinish: ", this.eWL));
          this.mrS.b((c.b)this);
          paramString = (d)localp;
          String str = this.eWL;
          Result.Companion localCompanion = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(str));
        }
        AppMethodBeat.o(233387);
      }
      
      public final void aXr() {}
      
      public final void w(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(233393);
        Log.i("MicroMsg.SnsDataSource", "onImageFinish: mediaId=" + paramString + ", isOk=" + paramBoolean);
        if (kotlin.g.b.s.p(paramString, this.mrU.Id))
        {
          this.mrS.b((c.b)this);
          paramString = (d)localp;
          String str = this.eWL;
          Result.Companion localCompanion = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(str));
        }
        AppMethodBeat.o(233393);
      }
      
      public final void x(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(233399);
        Log.i("MicroMsg.SnsDataSource", kotlin.g.b.s.X("onSightFinish: ", paramString));
        AppMethodBeat.o(233399);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.d.a
 * JD-Core Version:    0.7.0.1
 */