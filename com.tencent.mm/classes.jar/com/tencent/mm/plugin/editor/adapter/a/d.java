package com.tencent.mm.plugin.editor.adapter.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.d.d;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  extends a
{
  public static float xxf = Resources.getSystem().getDisplayMetrics().density;
  public static int xxg = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int xxh = (int)(40.0F * xxf + 0.5F);
  public ImageView hIz;
  public LinearLayout pZr;
  public WXRTEditText xwR;
  public WXRTEditText xwS;
  public LinearLayout xwT;
  public TextView xwU;
  public TextView xwV;
  public ImageView xwW;
  public View xwX;
  public LinearLayout xwY;
  public LinearLayout xwZ;
  public LinearLayout xxa;
  public LinearLayout xxb;
  public LinearLayout xxc;
  public LinearLayout xxd;
  public LinearLayout xxe;
  public View.OnClickListener xxi = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      b localb = new b();
      localb.cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      d.this.xvq.xAo.dvI().dvy();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181651);
    }
  };
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.hIz = ((ImageView)paramView.findViewById(d.e.fGw));
    this.xwX = paramView.findViewById(d.e.gbs);
    this.xwT = ((LinearLayout)paramView.findViewById(d.e.fRQ));
    this.pZr = ((LinearLayout)paramView.findViewById(d.e.fSm));
    this.xwU = ((TextView)paramView.findViewById(d.e.fRR));
    this.xwV = ((TextView)paramView.findViewById(d.e.fRO));
    this.xwW = ((ImageView)paramView.findViewById(d.e.fRP));
    this.xwU.setTextSize(16.0F);
    this.xwV.setTextSize(12.0F);
    this.xwY = ((LinearLayout)paramView.findViewById(d.e.fSk));
    this.xwY.setVisibility(8);
    this.xxa = ((LinearLayout)paramView.findViewById(d.e.fSf));
    this.xxa.setVisibility(8);
    this.xxb = ((LinearLayout)paramView.findViewById(d.e.fRN));
    this.xxb.setVisibility(8);
    this.xxc = ((LinearLayout)paramView.findViewById(d.e.fSM));
    this.xxc.setBackgroundColor(1347529272);
    this.xxc.setVisibility(8);
    this.xxc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        e.dwQ().dwW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181648);
      }
    });
    this.xxd = ((LinearLayout)paramView.findViewById(d.e.fSP));
    this.xxd.setBackgroundColor(1347529272);
    this.xxd.setVisibility(4);
    this.xxe = ((LinearLayout)paramView.findViewById(d.e.fSN));
    this.xxe.setBackgroundColor(1347529272);
    this.xxe.setVisibility(4);
    this.xwZ = ((LinearLayout)paramView.findViewById(d.e.fGz));
    paramj = (RelativeLayout.LayoutParams)this.xwZ.getLayoutParams();
    paramj.width = (xxg - xxh);
    paramj.height = -2;
    this.xwZ.setLayoutParams(paramj);
    this.xwS = ((WXRTEditText)paramView.findViewById(d.e.fuV));
    this.xwR = ((WXRTEditText)paramView.findViewById(d.e.fuX));
    ((LinearLayout)paramView.findViewById(d.e.fuW)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xwS.dwC();
        d.this.xwS.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(d.e.fuY)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xwR.dwC();
        d.this.xwR.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181650);
      }
    });
    this.xwS.setEditTextType(2);
    this.xwR.setEditTextType(1);
    this.xwR.xzK = this;
    this.xwS.xzK = this;
    if (!this.xvq.xAu)
    {
      this.xwS.setKeyListener(null);
      this.xwS.setEnabled(false);
      this.xwS.setFocusable(false);
      this.xwR.setKeyListener(null);
      this.xwR.setEnabled(false);
      this.xwR.setFocusable(false);
    }
    this.xvq.q(this.xwR);
    this.xvq.q(this.xwS);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + KI());
    this.xwR.setPosInDataList(paramInt1);
    this.xwS.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.dwQ().a(this.xxc, this.xxd, this.xxe, paramInt1);
    }
    parama.xye = this.xwR;
    parama.xyf = this.xwS;
    parama.xyg = null;
    if (parama.xyb) {
      if (parama.xyh) {
        this.xwR.requestFocus();
      }
    }
    for (;;)
    {
      if (this.xwT.getVisibility() == 0)
      {
        if (!parama.xyi) {
          break;
        }
        this.xwT.setBackgroundResource(d.d.xvU);
      }
      return;
      this.xwS.requestFocus();
      continue;
      if (this.xwR.hasFocus()) {
        this.xwR.clearFocus();
      }
      if (this.xwS.hasFocus()) {
        this.xwS.clearFocus();
      }
    }
    this.xwT.setBackgroundResource(d.d.xvT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */