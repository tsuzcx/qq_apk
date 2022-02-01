package com.tencent.mm.plugin.eggspring.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class SpringLuckyEggActivity$k
  extends k
  implements kotlin.g.a.m<aq, d<? super ah>, Object>
{
  int label;
  
  SpringLuckyEggActivity$k(SpringLuckyEggActivity paramSpringLuckyEggActivity, String paramString, com.tencent.mm.modelpackage.m paramm, d<? super k> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(266608);
    paramObject = (d)new k(this.xER, this.xES, this.xET, paramd);
    AppMethodBeat.o(266608);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(266599);
    Object localObject3 = a.aiwj;
    Object localObject4;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(266599);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (f)bg.kCi();
      localObject2 = (kotlin.g.a.m)new a(this.xES, this.xET, null);
      localObject4 = (d)this;
      this.label = 1;
      localObject2 = l.a(paramObject, (kotlin.g.a.m)localObject2, (d)localObject4);
      paramObject = localObject2;
      if (localObject2 == localObject3)
      {
        AppMethodBeat.o(266599);
        return localObject3;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    localObject3 = (Bitmap)paramObject;
    Object localObject2 = SpringLuckyEggActivity.a(this.xER);
    paramObject = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewBinding");
      paramObject = null;
    }
    paramObject.xFa.setImageBitmap((Bitmap)localObject3);
    if ((localObject3 != null) && (((Bitmap)localObject3).getWidth() > 0) && (((Bitmap)localObject3).getHeight() > 0))
    {
      localObject2 = SpringLuckyEggActivity.a(this.xER);
      paramObject = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewBinding");
        paramObject = null;
      }
      localObject4 = paramObject.xFa.getLayoutParams();
      paramObject = this.xER;
      float f = ((Bitmap)localObject3).getWidth() / ((Bitmap)localObject3).getHeight();
      localObject2 = SpringLuckyEggActivity.a(paramObject);
      paramObject = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewBinding");
        paramObject = null;
      }
      ((ViewGroup.LayoutParams)localObject4).height = ((int)(paramObject.xFa.getWidth() / f));
      paramObject = SpringLuckyEggActivity.a(this.xER);
      if (paramObject != null) {
        break label318;
      }
      s.bIx("viewBinding");
      paramObject = localObject1;
    }
    label318:
    for (;;)
    {
      paramObject.xFa.requestLayout();
      paramObject = ah.aiuX;
      AppMethodBeat.o(266599);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements kotlin.g.a.m<aq, d<? super Bitmap>, Object>
  {
    int label;
    
    a(String paramString, com.tencent.mm.modelpackage.m paramm, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(266629);
      paramObject = (d)new a(this.xES, this.xET, paramd);
      AppMethodBeat.o(266629);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266623);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266623);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (!y.ZC(this.xES + '/' + this.xET.oQJ))
      {
        AppMethodBeat.o(266623);
        return null;
      }
      paramObject = BitmapUtil.decodeFile(this.xES + '/' + this.xET.oQJ, null);
      AppMethodBeat.o(266623);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.k
 * JD-Core Version:    0.7.0.1
 */