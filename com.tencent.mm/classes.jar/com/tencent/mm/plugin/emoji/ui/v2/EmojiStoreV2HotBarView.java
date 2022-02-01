package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
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
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View mrI;
  private TextView uNQ;
  private View uNR;
  private TextView uNS;
  private View uNT;
  private TextView uNU;
  private View.OnClickListener uNV;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(109193);
    this.uNV = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109193);
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109194);
    this.uNV = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109194);
  }
  
  @TargetApi(11)
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109197);
    this.uNV = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(109197);
  }
  
  private void init()
  {
    AppMethodBeat.i(109198);
    this.mrI = ((ViewGroup)ad.kS(getContext()).inflate(i.f.emoji_store_v2_hot_bar_view, this)).findViewById(i.e.root);
    this.uNQ = ((TextView)this.mrI.findViewById(i.e.emoji_hot));
    this.uNR = this.mrI.findViewById(i.e.emoji_designer_catalog);
    this.uNS = ((TextView)this.mrI.findViewById(i.e.emoji_more));
    this.uNS.setText(getResources().getText(i.h.emoji_store_new_suggest) + " ");
    this.uNT = this.mrI.findViewById(i.e.designer_product);
    this.uNT.setOnClickListener(new EmojiStoreV2HotBarView.2(this));
    this.uNU = ((TextView)this.mrI.findViewById(i.e.new_tips));
    cWJ();
    setMoreOnClickListener(this.uNV);
    updateTitle();
    AppMethodBeat.o(109198);
  }
  
  public final void cWJ()
  {
    AppMethodBeat.i(109199);
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.VgQ, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.uNU != null)
    {
      localTextView = this.uNU;
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
    return this.mrI;
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
    if ((this.uNR != null) && (!paramBoolean))
    {
      int i = a.aY(getContext(), i.c.ListPadding);
      int j = a.aY(getContext(), i.c.MiddlePadding);
      int k = a.aY(getContext(), i.c.NormalPadding);
      this.uNR.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(109203);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(109202);
    if (this.uNT != null) {
      this.uNT.setVisibility(paramInt);
    }
    AppMethodBeat.o(109202);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(109201);
    if (this.uNS != null) {
      this.uNS.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(109201);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(109204);
    if (this.mrI != null)
    {
      this.mrI.setVisibility(paramInt);
      AppMethodBeat.o(109204);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(109204);
  }
  
  public final void updateTitle()
  {
    AppMethodBeat.i(109200);
    if (j.cUG().uEq)
    {
      this.uNQ.setText(i.h.emoji_hot_title_paid);
      AppMethodBeat.o(109200);
      return;
    }
    this.uNQ.setText(i.h.emoji_hot_title);
    AppMethodBeat.o(109200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */