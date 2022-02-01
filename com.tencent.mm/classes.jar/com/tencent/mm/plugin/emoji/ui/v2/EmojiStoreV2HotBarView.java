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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.z;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View iFK;
  private TextView pTE;
  private View pTF;
  private TextView pTG;
  private View pTH;
  private TextView pTI;
  private View.OnClickListener pTJ;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109193);
    this.pTJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.pTJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.pTJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.iFK = ((ViewGroup)z.jV(getContext()).inflate(2131493810, this)).findViewById(2131304239);
    this.pTE = ((TextView)this.iFK.findViewById(2131299376));
    this.pTF = this.iFK.findViewById(2131299364);
    this.pTG = ((TextView)this.iFK.findViewById(2131299391));
    this.pTG.setText(getResources().getText(2131758339) + " ");
    this.pTH = this.iFK.findViewById(2131299024);
    this.pTH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109192);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109192);
      }
    });
    this.pTI = ((TextView)this.iFK.findViewById(2131302799));
    ckb();
    setMoreOnClickListener(this.pTJ);
    updateTitle();
    AppMethodBeat.o(109198);
  }
  
  public final void ckb()
  {
    AppMethodBeat.i(109199);
    boolean bool = ((Boolean)g.ajR().ajA().get(am.a.IKU, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.pTI != null)
    {
      localTextView = this.pTI;
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
    return this.iFK;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109195);
    super.onAttachedToWindow();
    ae.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109195);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109196);
    super.onDetachedFromWindow();
    ae.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109196);
  }
  
  public void setDesignerCatalogViewPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(109203);
    if ((this.pTF != null) && (!paramBoolean))
    {
      int i = com.tencent.mm.cb.a.ax(getContext(), 2131165489);
      int j = com.tencent.mm.cb.a.ax(getContext(), 2131165500);
      int k = com.tencent.mm.cb.a.ax(getContext(), 2131165516);
      this.pTF.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(109203);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(109202);
    if (this.pTH != null) {
      this.pTH.setVisibility(paramInt);
    }
    AppMethodBeat.o(109202);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(109201);
    if (this.pTG != null) {
      this.pTG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(109201);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(109204);
    if (this.iFK != null)
    {
      this.iFK.setVisibility(paramInt);
      AppMethodBeat.o(109204);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(109204);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(109200);
    if (d.chY().pKG)
    {
      this.pTE.setText(2131758264);
      AppMethodBeat.o(109200);
      return;
    }
    this.pTE.setText(2131758263);
    AppMethodBeat.o(109200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */