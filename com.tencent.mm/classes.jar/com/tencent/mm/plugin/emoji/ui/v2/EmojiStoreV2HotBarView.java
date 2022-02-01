package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View plc;
  private TextView xWA;
  private View xWB;
  private TextView xWC;
  private View xWD;
  private TextView xWE;
  private View.OnClickListener xWF;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109193);
    this.xWF = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109193);
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109194);
    this.xWF = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109194);
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109197);
    this.xWF = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109197);
  }
  
  private void init()
  {
    AppMethodBeat.i(109198);
    this.plc = ((ViewGroup)af.mU(getContext()).inflate(h.f.emoji_store_v2_hot_bar_view, this)).findViewById(h.e.root);
    this.xWA = ((TextView)this.plc.findViewById(h.e.emoji_hot));
    this.xWB = this.plc.findViewById(h.e.emoji_designer_catalog);
    this.xWC = ((TextView)this.plc.findViewById(h.e.emoji_more));
    this.xWC.setText(getResources().getText(h.h.emoji_store_new_suggest) + " ");
    this.xWD = this.plc.findViewById(h.e.designer_product);
    this.xWD.setOnClickListener(new EmojiStoreV2HotBarView.2(this));
    this.xWE = ((TextView)this.plc.findViewById(h.e.new_tips));
    dCp();
    setMoreOnClickListener(this.xWF);
    aMl();
    AppMethodBeat.o(109198);
  }
  
  public final void aMl()
  {
    AppMethodBeat.i(109200);
    if (j.dzN().xMH)
    {
      this.xWA.setText(h.h.emoji_hot_title_paid);
      AppMethodBeat.o(109200);
      return;
    }
    this.xWA.setText(h.h.emoji_hot_title);
    AppMethodBeat.o(109200);
  }
  
  public final void dCp()
  {
    AppMethodBeat.i(109199);
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acIh, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.xWE != null)
    {
      localTextView = this.xWE;
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
    return this.plc;
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
    if ((this.xWB != null) && (!paramBoolean))
    {
      int i = a.br(getContext(), h.c.ListPadding);
      int j = a.br(getContext(), h.c.MiddlePadding);
      int k = a.br(getContext(), h.c.NormalPadding);
      this.xWB.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(109203);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(109202);
    if (this.xWD != null) {
      this.xWD.setVisibility(paramInt);
    }
    AppMethodBeat.o(109202);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(109201);
    if (this.xWC != null) {
      this.xWC.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(109201);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(109204);
    if (this.plc != null)
    {
      this.plc.setVisibility(paramInt);
      AppMethodBeat.o(109204);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(109204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */