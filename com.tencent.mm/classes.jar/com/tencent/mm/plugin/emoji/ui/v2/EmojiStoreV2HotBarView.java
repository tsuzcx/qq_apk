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
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.w;

public class EmojiStoreV2HotBarView
  extends LinearLayout
{
  private View iCk;
  private View lpK;
  private TextView lpL;
  private View lpM;
  private TextView lpN;
  private View.OnClickListener lpO;
  
  public EmojiStoreV2HotBarView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(53629);
    this.lpO = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(53629);
  }
  
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53630);
    this.lpO = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(53630);
  }
  
  @TargetApi(11)
  public EmojiStoreV2HotBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53633);
    this.lpO = new EmojiStoreV2HotBarView.1(this);
    init();
    AppMethodBeat.o(53633);
  }
  
  private void init()
  {
    AppMethodBeat.i(53634);
    this.iCk = ((ViewGroup)w.hM(getContext()).inflate(2130969398, this)).findViewById(2131821003);
    this.lpK = this.iCk.findViewById(2131823675);
    this.lpL = ((TextView)this.iCk.findViewById(2131823677));
    this.lpL.setText(getResources().getText(2131299213) + " ");
    this.lpM = this.iCk.findViewById(2131823666);
    this.lpM.setOnClickListener(new EmojiStoreV2HotBarView.2(this));
    this.lpN = ((TextView)this.iCk.findViewById(2131823665));
    bnj();
    setMoreOnClickListener(this.lpO);
    AppMethodBeat.o(53634);
  }
  
  public final void bnj()
  {
    AppMethodBeat.i(53635);
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yxX, Boolean.FALSE)).booleanValue();
    TextView localTextView;
    if (this.lpN != null)
    {
      localTextView = this.lpN;
      if (!bool) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(53635);
      return;
    }
  }
  
  public View getRootView()
  {
    return this.iCk;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(53631);
    super.onAttachedToWindow();
    ab.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(53631);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(53632);
    super.onDetachedFromWindow();
    ab.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    AppMethodBeat.o(53632);
  }
  
  public void setDesignerCatalogViewPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(53638);
    if ((this.lpK != null) && (!paramBoolean))
    {
      int i = a.ao(getContext(), 2131427781);
      int j = a.ao(getContext(), 2131427792);
      int k = a.ao(getContext(), 2131427808);
      this.lpK.setPadding(k, i, k, j);
    }
    AppMethodBeat.o(53638);
  }
  
  public void setDesignerEmojiViewVisibility(int paramInt)
  {
    AppMethodBeat.i(53637);
    if (this.lpM != null) {
      this.lpM.setVisibility(paramInt);
    }
    AppMethodBeat.o(53637);
  }
  
  public void setMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(53636);
    if (this.lpL != null) {
      this.lpL.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(53636);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(53639);
    if (this.iCk != null)
    {
      this.iCk.setVisibility(paramInt);
      AppMethodBeat.o(53639);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(53639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2HotBarView
 * JD-Core Version:    0.7.0.1
 */