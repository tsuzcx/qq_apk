package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.json.JSONObject;
import org.libpag.PAGFile;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class e$m
  extends k
  implements m<aq, d<? super ah>, Object>
{
  Object L$0;
  Object Uf;
  Object VC;
  int label;
  
  e$m(int paramInt, e parame, String paramString, kotlin.g.a.a<ah> parama, b.j paramj, d<? super m> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360870);
    paramObject = (d)new m(this.CQr, this.CQm, this.CQs, this.CQt, this.CQu, paramd);
    AppMethodBeat.o(360870);
    return paramObject;
  }
  
  public final Object invokeSuspend(final Object paramObject)
  {
    AppMethodBeat.i(360865);
    Object localObject2 = kotlin.d.a.a.aiwj;
    final ah.a locala;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360865);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject1 = new ah.f();
      locala = new ah.a();
      paramObject = new ah.d();
      f localf = (f)bg.kCi();
      m localm = (m)new k(this.CQu, (ah.f)localObject1)
      {
        int label;
        
        public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
        {
          AppMethodBeat.i(360845);
          paramAnonymousObject = (d)new 1(this.CQu, this.CQv, paramObject, locala, paramAnonymousd);
          AppMethodBeat.o(360845);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(360840);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(360840);
            throw paramAnonymousObject;
          }
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = bl.GlV;
          paramAnonymousObject = bl.b(this.CQu);
          this.CQv.aqH = paramAnonymousObject.bsC;
          try
          {
            paramAnonymousObject = new JSONObject((String)paramAnonymousObject.bsD);
            paramObject.aixb = paramAnonymousObject.getInt("t");
            Log.i("OlympicCertificateLayou", s.X("onPagViewPlay endTime: ", Integer.valueOf(paramObject.aixb)));
            label124:
            locala.aiwY = y.ZC((String)this.CQv.aqH);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(360840);
            return paramAnonymousObject;
          }
          finally
          {
            break label124;
          }
        }
      };
      d locald = (d)this;
      this.L$0 = localObject1;
      this.Uf = locala;
      this.VC = paramObject;
      this.label = 1;
      if (l.a(localf, localm, locald) == localObject2)
      {
        AppMethodBeat.o(360865);
        return localObject2;
      }
      break;
    case 1: 
      localObject2 = (ah.d)this.VC;
      locala = (ah.a)this.Uf;
      localObject1 = (ah.f)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject2;
    }
    if (locala.aiwY) {}
    for (Object localObject1 = PAGFile.Load(y.n((String)((ah.f)localObject1).aqH, false));; localObject1 = PAGFile.Load(this.CQm.mJe.getContext().getAssets(), this.CQs))
    {
      e.a(this.CQm, (PAGFile)localObject1, paramObject.aixb, this.CQt);
      paramObject = ah.aiuX;
      AppMethodBeat.o(360865);
      return paramObject;
      paramObject.aixb = this.CQr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.e.m
 * JD-Core Version:    0.7.0.1
 */