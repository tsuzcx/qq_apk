package com.tencent.mm.plugin.cast.banner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.wj;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.cast.b.d;
import com.tencent.mm.plugin.cast.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/banner/ScreenCastBanner;", "Lcom/tencent/mm/pluginsdk/ui/banner/BaseBanner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "banner", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "setContext", "screenCastEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ScreenCastEvent;", "destroy", "", "getLayoutId", "", "getOrder", "initialize", "setVisibility", "visibility", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  public static final a.a wMq;
  private Context context;
  private View vdX;
  private IListener<wj> wMr;
  
  static
  {
    AppMethodBeat.i(274188);
    wMq = new a.a((byte)0);
    AppMethodBeat.o(274188);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(274174);
    this.context = paramContext;
    if (this.view != null)
    {
      this.vdX = this.view.findViewById(b.d.wLS);
      this.view.setOnClickListener(a..ExternalSyntheticLambda0.INSTANCE);
    }
    setVisibility(8);
    this.wMr = ((IListener)new ScreenCastBanner.initialize.2(this, f.hfK));
    paramContext = this.wMr;
    if (paramContext != null) {
      paramContext.alive();
    }
    AppMethodBeat.o(274174);
  }
  
  private static final void eQ(View paramView)
  {
    AppMethodBeat.i(274181);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/banner/ScreenCastBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = new Intent();
    c.b(MMApplicationContext.getContext(), "cast", ".ui.ScreenCastActivity", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/cast/banner/ScreenCastBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274181);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(274213);
    IListener localIListener = this.wMr;
    if (localIListener != null) {
      localIListener.dead();
    }
    AppMethodBeat.o(274213);
  }
  
  public final int getLayoutId()
  {
    return b.e.wLZ;
  }
  
  public final int getOrder()
  {
    return 5;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(274204);
    super.setVisibility(paramInt);
    this.view.findViewById(b.d.wLS).setVisibility(paramInt);
    AppMethodBeat.o(274204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.banner.a
 * JD-Core Version:    0.7.0.1
 */