package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.ui.p.e;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "context", "Landroid/content/Context;", "proxy", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputProxy;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputProxy;)V", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "Lkotlin/Lazy;", "loadingIv", "Landroid/widget/ProgressBar;", "getLoadingIv", "()Landroid/widget/ProgressBar;", "loadingIv$delegate", "getProxy", "()Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputProxy;", "sayTv", "Landroid/widget/TextView;", "getSayTv", "()Landroid/widget/TextView;", "sayTv$delegate", "voiceHelper", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputHelper;", "getVoiceHelper", "()Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputHelper;", "voiceHelper$delegate", "voicePanel", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl;", "getVoicePanel", "()Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl;", "voicePanel$delegate", "getEmptyViewHeight", "", "inflateContentView", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.ui.f.a
{
  private final j FSd;
  final j HCP;
  final j HCQ;
  final j HCR;
  private final j HCS;
  final d Hzw;
  
  public a(final Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(265873);
    this.Hzw = paramd;
    this.HCP = k.cm((kotlin.g.a.a)new f(this, paramContext));
    this.HCQ = k.cm((kotlin.g.a.a)new d(this));
    this.HCR = k.cm((kotlin.g.a.a)new b(this));
    this.HCS = k.cm((kotlin.g.a.a)new e(paramContext, this));
    this.FSd = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(265873);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(265888);
    s.u(parama, "this$0");
    parama.fzi().release();
    AppMethodBeat.o(265888);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(265885);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265885);
  }
  
  private c fzi()
  {
    AppMethodBeat.i(265879);
    c localc = (c)this.HCS.getValue();
    AppMethodBeat.o(265879);
    return localc;
  }
  
  public final View bZy()
  {
    AppMethodBeat.i(265903);
    View localView = LayoutInflater.from(getContext()).inflate(p.e.fts_voice_input_dialog, null);
    s.s(localView, "from(context).inflate(R.…voice_input_dialog, null)");
    AppMethodBeat.o(265903);
    return localView;
  }
  
  public final int fcr()
  {
    AppMethodBeat.i(265905);
    int i = com.tencent.mm.cd.a.mt(getContext());
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 320);
    AppMethodBeat.o(265905);
    return i - j;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265901);
    super.onCreate(paramBundle);
    fzi().HDg = ((c.a)new c(this));
    paramBundle = (View)this.FSd.getValue();
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    }
    setOnDismissListener(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(265901);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<View>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ProgressBar;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ProgressBar>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputDialog$onCreate$1", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputHelper$StateListener;", "onDetectBegin", "", "onDetectError", "speakShort", "", "netError", "lastContent", "", "onDetectFinish", "voiceId", "content", "onDetectTextChange", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c.a
  {
    c(a parama) {}
    
    public final void aEH(String paramString)
    {
      AppMethodBeat.i(265924);
      this.HCT.Hzw.aEH(paramString);
      AppMethodBeat.o(265924);
    }
    
    public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      AppMethodBeat.i(265912);
      this.HCT.Hzw.c(paramBoolean1, paramBoolean2, paramString);
      AppMethodBeat.o(265912);
    }
    
    public final void fyx()
    {
      AppMethodBeat.i(265920);
      this.HCT.Hzw.fyx();
      AppMethodBeat.o(265920);
    }
    
    public final void iE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(265916);
      this.HCT.Hzw.iE(paramString1, paramString2);
      this.HCT.dismiss();
      AppMethodBeat.o(265916);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<c>
  {
    e(Context paramContext, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<FTSVoiceInputLayoutImpl>
  {
    f(a parama, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */