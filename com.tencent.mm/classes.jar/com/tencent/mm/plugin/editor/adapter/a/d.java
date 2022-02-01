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
  public static float uqI = Resources.getSystem().getDisplayMetrics().density;
  public static int uqJ = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int uqK = (int)(40.0F * uqI + 0.5F);
  public ImageView fDJ;
  public LinearLayout ndX;
  public View uqA;
  public LinearLayout uqB;
  public LinearLayout uqC;
  public LinearLayout uqD;
  public LinearLayout uqE;
  public LinearLayout uqF;
  public LinearLayout uqG;
  public LinearLayout uqH;
  public View.OnClickListener uqL = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      b localb = new b();
      localb.bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      d.this.uoT.utR.cRp().cRf();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181651);
    }
  };
  public WXRTEditText uqu;
  public WXRTEditText uqv;
  public LinearLayout uqw;
  public TextView uqx;
  public TextView uqy;
  public ImageView uqz;
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.fDJ = ((ImageView)paramView.findViewById(d.e.dFr));
    this.uqA = paramView.findViewById(d.e.dYE);
    this.uqw = ((LinearLayout)paramView.findViewById(d.e.dPL));
    this.ndX = ((LinearLayout)paramView.findViewById(d.e.dQh));
    this.uqx = ((TextView)paramView.findViewById(d.e.dPM));
    this.uqy = ((TextView)paramView.findViewById(d.e.dPJ));
    this.uqz = ((ImageView)paramView.findViewById(d.e.dPK));
    this.uqx.setTextSize(16.0F);
    this.uqy.setTextSize(12.0F);
    this.uqB = ((LinearLayout)paramView.findViewById(d.e.dQf));
    this.uqB.setVisibility(8);
    this.uqD = ((LinearLayout)paramView.findViewById(d.e.dQa));
    this.uqD.setVisibility(8);
    this.uqE = ((LinearLayout)paramView.findViewById(d.e.dPI));
    this.uqE.setVisibility(8);
    this.uqF = ((LinearLayout)paramView.findViewById(d.e.dQG));
    this.uqF.setBackgroundColor(1347529272);
    this.uqF.setVisibility(8);
    this.uqF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        e.cSy().cSE();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181648);
      }
    });
    this.uqG = ((LinearLayout)paramView.findViewById(d.e.dQJ));
    this.uqG.setBackgroundColor(1347529272);
    this.uqG.setVisibility(4);
    this.uqH = ((LinearLayout)paramView.findViewById(d.e.dQH));
    this.uqH.setBackgroundColor(1347529272);
    this.uqH.setVisibility(4);
    this.uqC = ((LinearLayout)paramView.findViewById(d.e.dFs));
    paramj = (RelativeLayout.LayoutParams)this.uqC.getLayoutParams();
    paramj.width = (uqJ - uqK);
    paramj.height = -2;
    this.uqC.setLayoutParams(paramj);
    this.uqv = ((WXRTEditText)paramView.findViewById(d.e.duD));
    this.uqu = ((WXRTEditText)paramView.findViewById(d.e.duF));
    ((LinearLayout)paramView.findViewById(d.e.duE)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.uqv.cSk();
        d.this.uqv.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(d.e.duG)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.uqu.cSk();
        d.this.uqu.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181650);
      }
    });
    this.uqv.setEditTextType(2);
    this.uqu.setEditTextType(1);
    this.uqu.utn = this;
    this.uqv.utn = this;
    if (!this.uoT.utX)
    {
      this.uqv.setKeyListener(null);
      this.uqv.setEnabled(false);
      this.uqv.setFocusable(false);
      this.uqu.setKeyListener(null);
      this.uqu.setEnabled(false);
      this.uqu.setFocusable(false);
    }
    this.uoT.q(this.uqu);
    this.uoT.q(this.uqv);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + mc());
    this.uqu.setPosInDataList(paramInt1);
    this.uqv.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.cSy().a(this.uqF, this.uqG, this.uqH, paramInt1);
    }
    parama.urJ = this.uqu;
    parama.urK = this.uqv;
    parama.urL = null;
    if (parama.urG) {
      if (parama.urM) {
        this.uqu.requestFocus();
      }
    }
    for (;;)
    {
      if (this.uqw.getVisibility() == 0)
      {
        if (!parama.urN) {
          break;
        }
        this.uqw.setBackgroundResource(d.d.upx);
      }
      return;
      this.uqv.requestFocus();
      continue;
      if (this.uqu.hasFocus()) {
        this.uqu.clearFocus();
      }
      if (this.uqv.hasFocus()) {
        this.uqv.clearFocus();
      }
    }
    this.uqw.setBackgroundResource(d.d.upw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */