package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View jBN;
  private TextView rkD;
  private View rkE;
  private TextView rkF;
  private View rkG;
  private TextView rkH;
  private View.OnClickListener rkI;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109193);
    this.rkI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109191);
      }
    };
    init();
    AppMethodBeat.o(109193);
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109194);
    this.rkI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109191);
      }
    };
    init();
    AppMethodBeat.o(109194);
  }
  
  @TargetApi(11)
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109197);
    this.rkI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109191);
      }
    };
    init();
    AppMethodBeat.o(109197);
  }
  
  private void init()
  {
    AppMethodBeat.i(109198);
    this.jBN = ((ViewGroup)aa.jQ(getContext()).inflate(2131493964, this)).findViewById(2131307157);
    this.rkD = ((TextView)this.jBN.findViewById(2131299989));
    this.rkE = this.jBN.findViewById(2131299977);
    this.rkF = ((TextView)this.jBN.findViewById(2131300004));
    this.rkF.setText(getResources().getText(2131758633) + " ");
    this.rkG = this.jBN.findViewById(2131299527);
    this.rkG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109192);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109192);
      }
    });
    this.rkH = ((TextView)this.jBN.findViewById(2131305369));
    cIc();
    setMoreOnClickListener(this.rkI);
    updateTitle();
    AppMethodBeat.o(109198);
  }
  
  public final void cIc()
  {
    AppMethodBeat.i(109199);
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NSS, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.rkH != null)
    {
      localTextView = this.rkH;
      if (!bool) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(109199);
      return;
    }
  }
  
  public View getRootView()
  {
    return this.jBN;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109195);
    super.onAttachedToWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109195);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109196);
    super.onDetachedFromWindow();
    Log.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109196);
  }
  
  public void setDesignerCatalogViewPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(109203);
    if ((this.rkE != null) && (!paramBoolean))
    {
      int i = com.tencent.mm.cb.a.aG(getContext(), 2131165507);
      int j = com.tencent.mm.cb.a.aG(getContext(), 2131165518);
      int k = com.tencent.mm.cb.a.aG(getContext(), 2131165534);
      this.rkE.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(109203);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(109202);
    if (this.rkG != null) {
      this.rkG.setVisibility(paramInt);
    }
    AppMethodBeat.o(109202);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(109201);
    if (this.rkF != null) {
      this.rkF.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(109201);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(109204);
    if (this.jBN != null)
    {
      this.jBN.setVisibility(paramInt);
      AppMethodBeat.o(109204);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(109204);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(109200);
    if (com.tencent.mm.plugin.emoji.model.e.cFX().rbm)
    {
      this.rkD.setText(2131758552);
      AppMethodBeat.o(109200);
      return;
    }
    this.rkD.setText(2131758551);
    AppMethodBeat.o(109200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */