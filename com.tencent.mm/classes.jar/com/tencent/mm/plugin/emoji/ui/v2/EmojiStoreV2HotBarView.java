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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.y;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View hIZ;
  private TextView oFZ;
  private View oGa;
  private TextView oGb;
  private View oGc;
  private TextView oGd;
  private View.OnClickListener oGe;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109193);
    this.oGe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.oGe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.oGe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109191);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109191);
      }
    };
    init();
    AppMethodBeat.o(109197);
  }
  
  private void init()
  {
    AppMethodBeat.i(109198);
    this.hIZ = ((ViewGroup)y.js(getContext()).inflate(2131493810, this)).findViewById(2131304239);
    this.oFZ = ((TextView)this.hIZ.findViewById(2131299376));
    this.oGa = this.hIZ.findViewById(2131299364);
    this.oGb = ((TextView)this.hIZ.findViewById(2131299391));
    this.oGb.setText(getResources().getText(2131758339) + " ");
    this.oGc = this.hIZ.findViewById(2131299024);
    this.oGc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109192);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
        paramAnonymousView = EmojiStoreV2HotBarView.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2HotBarView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109192);
      }
    });
    this.oGd = ((TextView)this.hIZ.findViewById(2131302799));
    bWV();
    setMoreOnClickListener(this.oGe);
    updateTitle();
    AppMethodBeat.o(109198);
  }
  
  public final void bWV()
  {
    AppMethodBeat.i(109199);
    boolean bool = ((Boolean)g.afB().afk().get(ae.a.Fgr, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.oGd != null)
    {
      localTextView = this.oGd;
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
    return this.hIZ;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(109195);
    super.onAttachedToWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109195);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(109196);
    super.onDetachedFromWindow();
    ad.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(109196);
  }
  
  public void setDesignerCatalogViewPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(109203);
    if ((this.oGa != null) && (!paramBoolean))
    {
      int i = com.tencent.mm.cd.a.ao(getContext(), 2131165489);
      int j = com.tencent.mm.cd.a.ao(getContext(), 2131165500);
      int k = com.tencent.mm.cd.a.ao(getContext(), 2131165516);
      this.oGa.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(109203);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(109202);
    if (this.oGc != null) {
      this.oGc.setVisibility(paramInt);
    }
    AppMethodBeat.o(109202);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(109201);
    if (this.oGb != null) {
      this.oGb.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(109201);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(109204);
    if (this.hIZ != null)
    {
      this.hIZ.setVisibility(paramInt);
      AppMethodBeat.o(109204);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(109204);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(109200);
    if (d.bUR().owS)
    {
      this.oFZ.setText(2131758264);
      AppMethodBeat.o(109200);
      return;
    }
    this.oFZ.setText(2131758263);
    AppMethodBeat.o(109200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */