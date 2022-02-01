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
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d
  extends a
{
  public static float qOE = Resources.getSystem().getDisplayMetrics().density;
  public static int qOF = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int qOG = (int)(40.0F * qOE + 0.5F);
  public ImageView dKU;
  public LinearLayout kmg;
  public LinearLayout qOA;
  public LinearLayout qOB;
  public LinearLayout qOC;
  public LinearLayout qOD;
  public View.OnClickListener qOH = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      b localb = new b();
      localb.bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      d.this.qNG.qRL.cCK().cCA();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181651);
    }
  };
  public WXRTEditText qOq;
  public WXRTEditText qOr;
  public LinearLayout qOs;
  public TextView qOt;
  public TextView qOu;
  public ImageView qOv;
  public View qOw;
  public LinearLayout qOx;
  public LinearLayout qOy;
  public LinearLayout qOz;
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.dKU = ((ImageView)paramView.findViewById(2131299829));
    this.qOw = paramView.findViewById(2131309734);
    this.qOs = ((LinearLayout)paramView.findViewById(2131305504));
    this.kmg = ((LinearLayout)paramView.findViewById(2131305530));
    this.qOt = ((TextView)paramView.findViewById(2131305505));
    this.qOu = ((TextView)paramView.findViewById(2131305502));
    this.qOv = ((ImageView)paramView.findViewById(2131305503));
    this.qOt.setTextSize(16.0F);
    this.qOu.setTextSize(12.0F);
    this.qOx = ((LinearLayout)paramView.findViewById(2131305528));
    this.qOx.setVisibility(8);
    this.qOz = ((LinearLayout)paramView.findViewById(2131305523));
    this.qOz.setVisibility(8);
    this.qOA = ((LinearLayout)paramView.findViewById(2131305501));
    this.qOA.setVisibility(8);
    this.qOB = ((LinearLayout)paramView.findViewById(2131305733));
    this.qOB.setBackgroundColor(1347529272);
    this.qOB.setVisibility(8);
    this.qOB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        e.cDT().cDY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181648);
      }
    });
    this.qOC = ((LinearLayout)paramView.findViewById(2131305741));
    this.qOC.setBackgroundColor(1347529272);
    this.qOC.setVisibility(4);
    this.qOD = ((LinearLayout)paramView.findViewById(2131305736));
    this.qOD.setBackgroundColor(1347529272);
    this.qOD.setVisibility(4);
    this.qOy = ((LinearLayout)paramView.findViewById(2131299850));
    paramj = (RelativeLayout.LayoutParams)this.qOy.getLayoutParams();
    paramj.width = (qOF - qOG);
    paramj.height = -2;
    this.qOy.setLayoutParams(paramj);
    this.qOr = ((WXRTEditText)paramView.findViewById(2131297817));
    this.qOq = ((WXRTEditText)paramView.findViewById(2131297819));
    ((LinearLayout)paramView.findViewById(2131297818)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qOr.cDF();
        d.this.qOr.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297820)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qOq.cDF();
        d.this.qOq.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181650);
      }
    });
    this.qOr.setEditTextType(2);
    this.qOq.setEditTextType(1);
    this.qOq.qRh = this;
    this.qOr.qRh = this;
    if (!this.qNG.qRR)
    {
      this.qOr.setKeyListener(null);
      this.qOr.setEnabled(false);
      this.qOr.setFocusable(false);
      this.qOq.setKeyListener(null);
      this.qOq.setEnabled(false);
      this.qOq.setFocusable(false);
    }
    this.qNG.q(this.qOq);
    this.qNG.q(this.qOr);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lQ());
    this.qOq.setPosInDataList(paramInt1);
    this.qOr.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.cDT().a(this.qOB, this.qOC, this.qOD, paramInt1);
    }
    parama.qPD = this.qOq;
    parama.qPE = this.qOr;
    parama.qPF = null;
    if (parama.qPA) {
      if (parama.qPG) {
        this.qOq.requestFocus();
      }
    }
    for (;;)
    {
      if (this.qOs.getVisibility() == 0)
      {
        if (!parama.qPH) {
          break;
        }
        this.qOs.setBackgroundResource(2131232062);
      }
      return;
      this.qOr.requestFocus();
      continue;
      if (this.qOq.hasFocus()) {
        this.qOq.clearFocus();
      }
      if (this.qOr.hasFocus()) {
        this.qOr.clearFocus();
      }
    }
    this.qOs.setBackgroundResource(2131232061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */