package com.tencent.mm.mj_template.maas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/HeicTranscodeHelper;", "", "()V", "MAX_DECODE_SIZE", "", "TAG", "", "tmpBasePath", "transcode", "originPath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nZx;
  private static final String nZy;
  
  static
  {
    AppMethodBeat.i(239804);
    nZx = new b();
    nZy = y.n(com.tencent.mm.vfs.ah.v(af.eC("MaasTemp", false).mUri), true);
    AppMethodBeat.o(239804);
  }
  
  public static Object b(String paramString, d<? super String> paramd)
  {
    AppMethodBeat.i(239794);
    paramString = l.a((f)bg.kCi(), (m)new a(paramString, null), paramd);
    AppMethodBeat.o(239794);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super String>, Object>
  {
    int label;
    
    a(String paramString, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(239695);
      paramObject = (d)new a(this.nZz, paramd);
      AppMethodBeat.o(239695);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239692);
      Object localObject1 = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239692);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.Maas.HeicTranscodeHelper", s.X("transcode file ", this.nZz));
      paramObject = new u(this.nZz);
      Object localObject2 = new StringBuilder().append(b.bxn()).append('/');
      paramObject = paramObject.getName();
      s.s(paramObject, "file.name");
      localObject1 = (String)p.ae(n.b((CharSequence)paramObject, new String[] { "." }), 0);
      paramObject = localObject1;
      if (localObject1 == null) {
        paramObject = String.valueOf(System.currentTimeMillis());
      }
      paramObject = paramObject + "_transcoded.jpg";
      if (new u(paramObject).jKS())
      {
        Log.i("MicroMsg.Maas.HeicTranscodeHelper", this.nZz + " has cache " + paramObject);
        AppMethodBeat.o(239692);
        return paramObject;
      }
      Log.i("MicroMsg.Maas.HeicTranscodeHelper", s.X("start transcode for file ", this.nZz));
      long l = System.currentTimeMillis();
      localObject1 = BitmapUtil.createThumbBitmap(this.nZz, 4096, 4096, true, false);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.Maas.HeicTranscodeHelper", s.X("decode bitmap error ", this.nZz));
        AppMethodBeat.o(239692);
        return null;
      }
      Log.i("MicroMsg.Maas.HeicTranscodeHelper", "decode success, start encode " + this.nZz + ", takes " + (System.currentTimeMillis() - l));
      localObject2 = this.nZz;
      try
      {
        Result.Companion localCompanion = Result.Companion;
        BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.JPEG, paramObject, true);
        Log.i("MicroMsg.Maas.HeicTranscodeHelper", "encode success " + (String)localObject2 + ", takes " + (System.currentTimeMillis() - l));
        paramObject = Result.constructor-impl(paramObject);
        localObject1 = this.nZz;
        localObject2 = Result.exceptionOrNull-impl(paramObject);
        if (localObject2 == null)
        {
          paramObject = (String)paramObject;
          AppMethodBeat.o(239692);
          return paramObject;
        }
      }
      finally
      {
        for (;;)
        {
          localObject1 = Result.Companion;
          paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
          continue;
          Log.printErrStackTrace("MicroMsg.Maas.HeicTranscodeHelper", (Throwable)localObject2, s.X("save bitmap error ", localObject1), new Object[0]);
          paramObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.b
 * JD-Core Version:    0.7.0.1
 */